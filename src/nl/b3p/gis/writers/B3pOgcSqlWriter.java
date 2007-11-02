/*
 * B3pOgcSqlWriter.java
 *
 * Created on 23 oktober 2007, 13:40
 *
 * Autor: Roy Braam
 */

package nl.b3p.gis.writers;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jump.feature.AttributeType;
import com.vividsolutions.jump.feature.Feature;
import com.vividsolutions.jump.feature.FeatureCollection;
import com.vividsolutions.jump.feature.FeatureSchema;
import com.vividsolutions.jump.io.ParseException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import nl.b3p.gis.readers.B3pGMLReader;
import nl.b3p.ogc.utils.OGCRequest;
import nl.b3p.ogc.utils.OgcSqlUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Roy Braam
 */
public class B3pOgcSqlWriter {
    private static final Log log = LogFactory.getLog(B3pOgcSqlWriter.class);
    
    private Connection connection;    
    
    public static final String DEFAULT_GEOM_COLUMN="the_geom";
    public static final String PRODUCT_POSTGRES="PostgreSQL";
    public static final String POSTGRES_GLOBALGEOMETRY="GEOMETRY";
    public static final Set SUPPORTED_DIALECTS=new HashSet();   
    
    /** Creates a new instance of B3pOgcSqlWriter */
    public B3pOgcSqlWriter(Connection conn){
        SUPPORTED_DIALECTS.add(PRODUCT_POSTGRES);
        setConnection(conn);  
    }
    /* Creates a connection and a B3pOgcSqlWriter*/
    public B3pOgcSqlWriter(String url,String user,String password, java.sql.Driver driver) throws SQLException{
        SUPPORTED_DIALECTS.add(PRODUCT_POSTGRES);
        DriverManager.registerDriver(driver);
        setConnection(DriverManager.getConnection(url,user,password));
    }
    /* Write features to the given table.
     * @param fc The collection of features.
     * @param tablename The tablename.
     * @param geomColumn The name of the geometry column. If null the attribute name of type geometry ikn the featureCollection is used.
     * @param srid The srid of the features. If srid is null the srid of the geometry in the featurecollection is used. If that is also 0 or null -1 is used.
     * @param dimension The dimension of the geometry in the feature. If 0 the dimension of the geometry is used. If still 0, 2 is used.
     * @param createTabel If true the function will try to create a table if the given tablename doesn't exists. It only supports PostGres/Postgis for creating geometry columns!
     * @param attributeNamesToLowerCase If true all attribute names will be cast to a lower case (recommended)
     */
    public void write(FeatureCollection fc, String tablename, String geomColumn, String srid, int dimension, boolean createTable, boolean attributeNamesToLowerCase)throws SQLException, Exception{
        //check if al features are of the same geom type and get a geom
        Iterator fcit=fc.iterator();
        Geometry aGeom=null;
        boolean sameGeomType=true;
        while (fcit.hasNext() && sameGeomType){
            Feature f= (Feature)fcit.next();
            if (f.getGeometry()!=null){
                if (aGeom==null){
                    aGeom=f.getGeometry();
                }else{
                    if (!aGeom.getGeometryType().equals(f.getGeometry().getGeometryType())){
                        sameGeomType=false;
                    }
                }
            }
        }
        /*if(!sameGeomType)
            throw new Exception("Not all features got the same Geometry Type");*/
        DatabaseMetaData dbmd = connection.getMetaData();
        List tableNames=OgcSqlUtils.getTableAndViewNames(connection);        
        FeatureSchema fs= fc.getFeatureSchema();         
        boolean wrongTable=false;
        if (tableNames!=null){
            //check if the table already exists
            if (tableNames.contains(tablename)){
                //if exists check the column's
                for (int i=0; i < fs.getAttributeCount() && !wrongTable; i++){
                    if (i!=fs.getGeometryIndex() || geomColumn==null){
                        boolean columFound=false;
                        String attributeName=fs.getAttributeName(i);
                        if (attributeNamesToLowerCase){
                            attributeName=attributeName.toLowerCase();
                        }
                        AttributeType attributeType= fs.getAttributeType(i);
                        //get the column by attribute name.
                        ResultSet rs = dbmd.getColumns(null, null, tablename, attributeName);
                        //if the column exists check the compatibility of the data_type
                        if (rs.next()){
                            int type=rs.getInt("DATA_TYPE");
                            if(isCompatibleType(attributeType,type)){
                                columFound=true;
                            }
                        }
                        //if there is no correct columFound it is a 'wrong' table
                        if (!columFound){
                            wrongTable=true;
                        }
                    }else{
                        ResultSet rs = dbmd.getColumns(null, null, tablename, geomColumn);
                        if (!rs.next()){
                            wrongTable=true;
                        }
                    }
                }
                //if it is a wrong table (not compatible with featurecollection) return a error
                if (wrongTable){
                    throw new Exception("Table already exists but has wrong columns.");
                }
            }else{
                //if the table doesn't exists and 'createTable'==true create the table
                if (createTable){
                    //check if the product is supported
                    if (SUPPORTED_DIALECTS.contains(dbmd.getDatabaseProductName())){                    
                        StringBuffer sb= new StringBuffer();
                        sb.append("CREATE TABLE ");
                        sb.append(tablename);
                        sb.append("(");
                        boolean firstColumn=true;
                        boolean geomColumnFound=false;
                        //create a create table script without the geometry column.
                        for (int i=0; i < fs.getAttributeCount(); i++){
                            AttributeType at=fs.getAttributeType(i);                            
                            if (at.equals(AttributeType.GEOMETRY)){
                                geomColumnFound=true;
                                if (geomColumn==null){
                                    if (attributeNamesToLowerCase){
                                        geomColumn=fs.getAttributeName(i).toLowerCase();
                                    }
                                    else{
                                        geomColumn=fs.getAttributeName(i);
                                    }
                                }
                            }else{                                
                                if (!firstColumn){
                                    sb.append(", ");
                                }
                                firstColumn=false;
                                sb.append("\"");
                                if(attributeNamesToLowerCase)
                                    sb.append(fs.getAttributeName(i).toLowerCase());
                                else
                                    sb.append(fs.getAttributeName(i));
                                sb.append("\" ");
                                if (at.equals(AttributeType.DATE)){
                                    sb.append("date");
                                }else if (at.equals(AttributeType.DOUBLE)){
                                    sb.append("double");
                                }else if (at.equals(AttributeType.INTEGER)){
                                    sb.append("integer");
                                }else{
                                    sb.append("varchar(255)");
                                }
                            }
                        }
                        sb.append(")"); 
                        StringBuffer sbg=null;
                        //if there is a geomColum needed create the create script.
                        if(geomColumnFound){
                            //if it is a postgres/postgis db
                            if (dbmd.getDatabaseProductName().equalsIgnoreCase(PRODUCT_POSTGRES)){
                                // get the database name.
                                String s=dbmd.getURL();
                                String url=dbmd.getURL();
                                String db=url.split("/")[url.split("/").length-1];
                                //create the script for the addGeometryColumn function
                                sbg=new StringBuffer();
                                sbg.append("select addGeometryColumn(\'");                                
                                sbg.append(db);
                                sbg.append("\', \'");
                                sbg.append(tablename);
                                sbg.append("\', \'");
                                sbg.append(geomColumn);
                                sbg.append("\', ");
                                //if the srid is given as param use it. Otherwise try to get the srid out of the geometry or use -1 as srid
                                if (srid!=null){
                                    sbg.append(srid);
                                }else{
                                    if (aGeom.getSRID()>0){
                                        sbg.append(fs.getCoordinateSystem().getEPSGCode());
                                    }else{
                                        sbg.append(-1);
                                    }
                                }
                                sbg.append(", \'");
                                //if not all geometries are of the same type create a global geometry column
                                if (!sameGeomType){
                                    sbg.append(POSTGRES_GLOBALGEOMETRY);
                                }else{
                                    sbg.append(aGeom.getGeometryType().toUpperCase());
                                }                                    
                                sbg.append("\', ");
                                //if the dimension is given use it, otherwise try to get it out of the Geometry of use 2
                                if (dimension>0){
                                    sbg.append(dimension);
                                }else{
                                    if (aGeom.getDimension()>1)
                                        sbg.append(aGeom.getDimension());
                                    else{
                                        sbg.append("2");
                                    }
                                }
                                sbg.append(")");
                            }
                        }
                        //execute the create table script.
                        PreparedStatement statement = null;
                        try{
                            if (sbg.toString()!=null){
                                sb.append(";");
                                sb.append(sbg.toString());
                            }
                            statement=connection.prepareStatement(sb.toString());
                            statement.execute();                        
                        }catch(SQLException se){
                            log.error("Query: "+sb.toString(),se);
                            throw se;
                        }finally{
                            if (statement!=null)
                                statement.close();
                        }
                    }else{
                        throw new Exception("CREATE TABLE not supported for "+dbmd.getDatabaseProductName());
                    }
                }else{
                    throw new Exception("Table does not exists");
                }
            }           
            StringBuffer insertPart = new StringBuffer();
            insertPart.append("INSERT INTO ");
            insertPart.append(tablename);
            insertPart.append(" (");
            //create the global part of the insert script.
            for (int i=0; i < fs.getAttributeCount(); i++){
                if (i!=0)
                    insertPart.append(", ");
                if (i!=fs.getGeometryIndex() || geomColumn==null){
                    if (attributeNamesToLowerCase){
                        insertPart.append(fs.getAttributeName(i).toLowerCase());
                    }else{
                        insertPart.append(fs.getAttributeName(i));
                    }
                }else{
                    insertPart.append(geomColumn);
                }
            }
            insertPart.append(") VALUES ");
            Iterator it= fc.iterator();
            //Create the insert script.
            StringBuffer q = null;
            while (it.hasNext()){
                if (q==null)
                    q=new StringBuffer();
                Feature f= (Feature)it.next();
                q.append(insertPart.toString());
                q.append("(");
                for (int i=0; i < fs.getAttributeCount(); i++){
                    Object o=f.getAttribute(fs.getAttributeName(i));
                    if (i!=0)
                        q.append(", ");                    
                    if (fs.getAttributeType(i).equals(AttributeType.GEOMETRY)){
                        q.append("GeomFromText(\'");
                        q.append(f.getGeometry().toText());
                        //Todo: Srid opzoeken
                        q.append("\', 28992");                
                        q.append(")");
                    }else if (fs.getAttributeType(i).equals(AttributeType.DOUBLE)){                            
                        q.append(o);                            
                    }else if (fs.getAttributeType(i).equals(AttributeType.INTEGER)){
                        q.append(o); 
                    }else if (fs.getAttributeType(i).equals(AttributeType.STRING)){
                        if (o==null)
                            q.append(o);
                        else{
                            String s=(String)o;
                            s=s.replaceAll("'","\'\'");
                            q.append("\'");
                            q.append(s);
                            q.append("\'");
                        }
                    }else if (fs.getAttributeType(i).equals(AttributeType.DATE)){
                         if (o==null)
                            q.append(o);
                        else{
                            q.append("\'");
                            q.append(o);
                            q.append("\'");
                        }
                    }else if (fs.getAttributeType(i).equals(AttributeType.OBJECT)){
                         if (o==null)
                            q.append(o);
                        else{
                            q.append("\'");
                            q.append(o);
                            q.append("\'");
                        }
                    }
                    
                }
                q.append(");");                
            }
            //excecute the insert script if there is data to add.
            if (q!=null){
                PreparedStatement statement=null;
                try{                
                    statement=connection.prepareStatement(q.toString());
                    statement.execute();

                }catch(SQLException se){
                    log.error("Can't execute query: "+q.toString(), se);
                    throw se;
                }finally {
                    if (statement!=null)
                        statement.close();
                }
            }
            
        }
    }    
    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    /**
     * Check if the given attributetype is compatible with the given sql type
     * @param attributeType the attributeType of the feature attribute
     * @param type the sql type of the column.
     * @return true if compatible
     */
    private boolean isCompatibleType(AttributeType attributeType, int type) {
        if (attributeType.equals(AttributeType.DATE)){         
            if (type==java.sql.Types.DATE || type==java.sql.Types.TIME || type==java.sql.Types.TIMESTAMP)
                return true;
        }
        else if (attributeType.equals(AttributeType.DOUBLE)){
            if (type==java.sql.Types.DOUBLE || type==java.sql.Types.DECIMAL || type==java.sql.Types.REAL || type==java.sql.Types.FLOAT)
                return true;
        }
        else if (attributeType.equals(AttributeType.GEOMETRY)){
            return true;
        }else if (attributeType.equals(AttributeType.INTEGER)){
            if (type==java.sql.Types.INTEGER || type==java.sql.Types.BIGINT || type==java.sql.Types.SMALLINT || type==java.sql.Types.TINYINT)
                return true;
        }else if (attributeType.equals(AttributeType.OBJECT)){
            return true;
        }else if (attributeType.equals(AttributeType.STRING)){
            if(type==java.sql.Types.VARCHAR || type==java.sql.Types.CHAR || type==java.sql.Types.BLOB || type==java.sql.Types.CLOB || type==java.sql.Types.LONGVARCHAR )
                return true;
        }
        return false;        
    }
    /*
     public static void main(String [] args) throws IOException, ParseException, Exception{
         String w1url="http://w1.b3p.nl/cgi-bin/mapserv.exe?SRSNAME=EPSG:28992&TYPENAME=tankstations_centroid&BBOX=70000,300000,305000,425000&VERSION=1.0.0&SERVICE=WFS&map=e:/mapserver/pnb_wis/pnb_wis2.map&REQUEST=GetFeature";
         String royurl="http://b3p-roy/cgi-bin/mapserv.exe?map=C:/mapserver/map/pnb_wis/geoplaza.map&SERVICE=WFS&REQUEST=GetFeature&VERSION=1.0.0&TYPENAME=strooiroutes&BBOX=70000,300000,305000,425000&SRSNAME=EPSG:28992";         
         String degree="http://portal.prvlimburg.nl/risicokaart_prof/ogcwebservices?SRSNAME=EPSG:28992&TYPENAME=app:V_RB10_PUNT_PROF,app:V_KWO_PUNT_PROF,app:V_RB10_LIJN_PROF,app:RGS_IRG_KRN_PROF,app:V_RB9_LIJN_PROF,app:V_RB8_POLY_PROF,app:RGS_ISDFE_ZONE_PROF,app:Incident,app:V_RB9_POLY_PROF,app:gg,app:euregio_hulpverlening,app:V_RB10_POLY_PROF,app:RGS_ISG_AFST_PROF,app:RGS_ISB_EADPUNT_PROF,app:V_RB11_POLY_PROF,app:V_RB6_POLY_PROF,app:RGS_ISB_EAD_PROF,app:V_RB4_LIJN_PROF,app:V_RB5_POLY_PROF,app:V_RB8_LIJN_PROF,app:V_RB8_PUNT_PROF,app:RGS_IRG_LOK_PROF,app:RGS_IRG_EAD_PROF,app:V_RB6_LIJN_PROF,app:RGS_IRG_POS_PROF,app:seveso_1,app:V_RB6_PUNT_PROF,app:V_RB7_LIJN_PROF,app:V_RB5_POS_PROF,app:RGS_IRG_CTR_PROF,app:RGS_ISB_CTR_PROF,app:data_brussel,app:RGS_ISB_LOK_PROF,app:RGS_IRG_EADPUNT_PROF&VERSION=1.1.0&SERVICE=WFS&REQUEST=GetFeature";
         String url="jdbc:postgresql://localhost:5432/pnb_wis";
         String user="postgres";
         String password="***REMOVED***";
         B3pGMLReader reader = new B3pGMLReader();
         OGCRequest wfslink=new OGCRequest(degree);
         wfslink.addOrReplaceNameSpace("app","http://www.deegree.org/app");
         HashMap features=reader.readWFSUrl(wfslink);
         if (features!=null){
             Set featureTypes=features.keySet();
             Iterator it=featureTypes.iterator();
             DriverManager.registerDriver(new org.postgresql.Driver());
             Connection conn= DriverManager.getConnection(url,user,password);

             while(it.hasNext()){
                 String featureType= (String)it.next();
                 String tableName=new String(featureType);
                 if (tableName.contains(":")){
                     tableName=featureType.split(":")[1];
                 }
                 FeatureCollection fc= (FeatureCollection) features.get(featureType);                 
                 B3pOgcSqlWriter bosw = new B3pOgcSqlWriter(url,user,password,new org.postgresql.Driver());
                 if (fc!=null)
                     bosw.write(fc,tableName.toLowerCase(),"the_geom","28992",2,true,true);
             }
         }
     }
     */
}
