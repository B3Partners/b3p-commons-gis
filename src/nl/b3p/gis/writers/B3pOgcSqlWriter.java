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
    /** Creates a new instance of B3pOgcSqlWriter */
    public B3pOgcSqlWriter(Connection conn){
        setConnection(conn);        
    }
    public B3pOgcSqlWriter(String url,String user,String password, java.sql.Driver driver) throws SQLException{
        DriverManager.registerDriver(driver);
        setConnection(DriverManager.getConnection(url,user,password));
    }    
    public void write(FeatureCollection fc, String tablename, String geomColumn, String srid, int dimension, boolean createTable, boolean attributeNamesToLowerCase)throws SQLException, Exception{
        //check if al features are of the same geom type
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
        if(!sameGeomType)
            throw new Exception("Not all features got the same Geometry Type");
        //check if the table already exists
        DatabaseMetaData dbmd = connection.getMetaData();
        List tableNames=OgcSqlUtils.getTableAndViewNames(connection);        
        FeatureSchema fs= fc.getFeatureSchema();         
        boolean wrongTable=false;
        if (tableNames!=null){
            //if exists check the column's
            if (tableNames.contains(tablename)){
                for (int i=0; i < fs.getAttributeCount() && !wrongTable; i++){
                    if (i!=fs.getGeometryIndex() || geomColumn==null){
                        boolean columFound=false;
                        String attributeName=fs.getAttributeName(i);
                        if (attributeNamesToLowerCase){
                            attributeName=attributeName.toLowerCase();
                        }
                        AttributeType attributeType= fs.getAttributeType(i);
                        ResultSet rs = dbmd.getColumns(null, null, tablename, attributeName);
                        if (rs.next()){
                            int type=rs.getInt("DATA_TYPE");
                            if(isCompatibleType(attributeType,type)){
                                columFound=true;
                            }
                        }
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
                if (wrongTable){
                    throw new Exception("Table already exists but has wrong columns.");
                }
            }else{
                //create table
                if (createTable){
                    if (dbmd.getDatabaseProductName().equalsIgnoreCase(PRODUCT_POSTGRES)){                    
                        StringBuffer sb= new StringBuffer();
                        sb.append("CREATE TABLE ");
                        sb.append(tablename);
                        sb.append("(");
                        boolean firstColumn=true;
                        boolean geomColumnFound=false;
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
                        if(geomColumnFound){
                            String s=dbmd.getURL();
                            sbg=new StringBuffer();
                            sbg.append("select addGeometryColumn(\'");
                            String url=dbmd.getURL();
                            String db=url.split("/")[url.split("/").length-1];                        
                            sbg.append(db);
                            sbg.append("\', \'");
                            sbg.append(tablename);
                            sbg.append("\', \'");
                            sbg.append(geomColumn);
                            sbg.append("\', ");
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
                            sbg.append(aGeom.getGeometryType().toUpperCase());
                            sbg.append("\', ");
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
                        PreparedStatement statement = null;
                        try{
                            statement=connection.prepareStatement(sb.toString()+";"+sbg.toString());
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
                    throw new Exception("Table doesn't exists");
                }
            }
            StringBuffer insertPart = new StringBuffer();
            insertPart.append("INSERT INTO ");
            insertPart.append(tablename);
            insertPart.append(" (");
           
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
            while (it.hasNext()){
                Feature f= (Feature)it.next();         
                
                StringBuffer q = new StringBuffer();
                q.append(insertPart.toString());
                q.append("(");
                for (int i=0; i < fs.getAttributeCount(); i++){
                    Object o=f.getAttribute(fs.getAttributeName(i));
                    if (i!=0)
                        q.append(", ");
                    if (o==null){
                        q.append("\'\'");
                    }else{
                        if (fs.getAttributeType(i)== AttributeType.GEOMETRY){
                            q.append("GeomFromText(\'");
                            q.append(f.getGeometry().toText());
                            //Todo: Srid opzoeken
                            q.append("\', 28992");                
                            q.append(")");
                        }else{                            
                            q.append("\'");
                            q.append(o);
                            q.append("\'");                        
                        }
                    }
                }
                q.append(")");
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
    
     public static void main(String [] args) throws IOException, ParseException, Exception{
         String w1url="http://w1.b3p.nl/cgi-bin/mapserv.exe?SRSNAME=EPSG:28992&TYPENAME=tankstations_centroid&BBOX=70000,300000,305000,425000&VERSION=1.0.0&SERVICE=WFS&map=e:/mapserver/pnb_wis/pnb_wis2.map&REQUEST=GetFeature";
         String royurl="http://b3p-roy/cgi-bin/mapserv.exe?map=C:/mapserver/map/pnb_wis/geoplaza.map&SERVICE=WFS&REQUEST=GetFeature&VERSION=1.0.0&TYPENAME=waterschapsgrenzen&BBOX=70000,300000,305000,425000&SRSNAME=EPSG:28992";         
         String url="jdbc:postgresql://localhost:5432/pnb_wis";
         String user="postgres";
         String password="***REMOVED***";
         B3pGMLReader reader = new B3pGMLReader();
         HashMap features=reader.readWFSUrl(new OGCRequest(royurl));
         Set featureTypes=features.keySet();
         Iterator it=featureTypes.iterator();
         DriverManager.registerDriver(new org.postgresql.Driver());
         Connection conn= DriverManager.getConnection(url,user,password);
         
         while(it.hasNext()){
             String featureType= (String)it.next();
             FeatureCollection fc= (FeatureCollection) features.get(featureType);
             B3pOgcSqlWriter bosw = new B3pOgcSqlWriter(url,user,password,new org.postgresql.Driver());
             bosw.write(fc,featureType,"the_geom","28992",2,true,true);
         }
         
     }
}
