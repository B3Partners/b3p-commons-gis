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
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import nl.b3p.ogc.utils.SqlMetaDataUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Roy Braam
 */
public class B3pOgcSqlWriter {
    private static final Log log = LogFactory.getLog(B3pOgcSqlWriter.class);
    
    private Connection connection;
    private int batchValue=20;
    public static final String DEFAULT_GEOM_COLUMN="the_geom";
    public static final String POSTGRES_GLOBALGEOMETRY="GEOMETRY";
    public static final List SUPPORTED_DIALECTS= Arrays.asList(new String[] {
        SqlMetaDataUtils.PRODUCT_POSTGRES
    });
    
    /** Creates a new instance of B3pOgcSqlWriter */
    public B3pOgcSqlWriter(Connection conn){
        setConnection(conn);
    }
    /* Creates a connection and a B3pOgcSqlWriter*/
    public B3pOgcSqlWriter(String url,String user,String password, java.sql.Driver driver) throws SQLException{
        DriverManager.registerDriver(driver);
        setConnection(DriverManager.getConnection(url,user,password));
    }
    /**
     * Write features to the given table.
     * @param fc The collection of features.
     * @param tablename The tablename.
     * @param geomColumn The name of the geometry column. If null the attribute name of type geometry ikn the featureCollection is used.
     * @param srid The srid of the features. If srid is null the srid of the geometry in the featurecollection is used. If that is also 0 or null -1 is used.
     * @param dimension The dimension of the geometry in the feature. If 0 the dimension of the geometry is used. If still 0, 2 is used.
     * @param createTabel If true the function will try to create a table if the given tablename doesn't exists. It only supports PostGres/Postgis for creating geometry columns!
     * @param attributeNamesToLowerCase If true all attribute names will be cast to a lower case (recommended)
     */
    public int[] write(FeatureCollection fc, String tablename, String geomColumn, int dimension, boolean createTable, boolean attributeNamesToLowerCase)throws SQLException, Exception{
        return write(fc, tablename, geomColumn, null, dimension, createTable, attributeNamesToLowerCase, null);
    }
    /**
     * Write features to the given table.
     * @param fc The collection of features.
     * @param tablename The tablename.
     * @param geomColumn The name of the geometry column. If null the attribute name of type geometry ikn the featureCollection is used.
     * @param srid The srid of the features. If srid is null the srid of the geometry in the featurecollection is used. If that is also 0 or null -1 is used.
     * @param dimension The dimension of the geometry in the feature. If 0 the dimension of the geometry is used. If still 0, 2 is used.
     * @param createTabel If true the function will try to create a table if the given tablename doesn't exists. It only supports PostGres/Postgis for creating geometry columns!
     * @param attributeNamesToLowerCase If true all attribute names will be cast to a lower case (recommended)
     * @param columns to check on. If all attributes of a feature equals the columns of a record. The database record wil be updated with the feature (not inserted).
     */
    public int[] write(FeatureCollection fc, String tablename, String geomColumn, int dimension, boolean createTable, boolean attributeNamesToLowerCase, String [] columnNamesToCheck)throws SQLException, Exception{
        return write(fc, tablename, geomColumn, null, dimension, createTable, attributeNamesToLowerCase, columnNamesToCheck);
    }
    /**
     * Write features to the given table.
     * @param fc The collection of features.
     * @param tablename The tablename.
     * @param geomColumn The name of the geometry column. If null the attribute name of type geometry ikn the featureCollection is used.
     * @param srid The srid of the features. If srid is null the srid of the geometry in the featurecollection is used. If that is also 0 or null -1 is used.
     * @param dimension The dimension of the geometry in the feature. If 0 the dimension of the geometry is used. If still 0, 2 is used.
     * @param createTabel If true the function will try to create a table if the given tablename doesn't exists. It only supports PostGres/Postgis for creating geometry columns!
     * @param attributeNamesToLowerCase If true all attribute names will be cast to a lower case (recommended)
     * @deprecated use function without SRID.
     */
    @Deprecated public int[] write(FeatureCollection fc, String tablename, String geomColumn, String srid, int dimension, boolean createTable, boolean attributeNamesToLowerCase)throws SQLException, Exception{
        return write(fc, tablename, geomColumn, srid, dimension, createTable, attributeNamesToLowerCase, null);
    }
    /**
     * Write features to the given table.
     * @param fc The collection of features.
     * @param tablename The tablename.
     * @param geomColumn The name of the geometry column. If null the attribute name of type geometry ikn the featureCollection is used.
     * @param srid The srid of the features. If srid is null the srid of the geometry in the featurecollection is used. If that is also 0 or null -1 is used.
     * @param dimension The dimension of the geometry in the feature. If 0 the dimension of the geometry is used. If still 0, 2 is used.
     * @param createTabel If true the function will try to create a table if the given tablename doesn't exists. It only supports PostGres/Postgis for creating geometry columns!
     * @param attributeNamesToLowerCase If true all attribute names will be cast to a lower case (recommended)
     * @param columns to check on. If all attributes of a feature equals the columns of a record. The database record wil be updated with the feature (not inserted).
     * @deprecated use function without SRID.
     */
    @Deprecated public int[] write(FeatureCollection fc, String tablename, String geomColumn, String srid, int dimension, boolean createTable, boolean attributeNamesToLowerCase, String [] columnNamesToCheck)throws SQLException, Exception{
        //check if al features are of the same geom type and get a geom
        int nupdates=0;
        int ninserts=0;
        Iterator fcit=fc.iterator();
        Geometry aGeom=null;
        boolean sameGeomType=true;
        while (fcit.hasNext() && sameGeomType){
            Feature f= (Feature)fcit.next();
            FeatureSchema fs = f.getSchema();
            if (fs.getGeometryIndex() >= 0 && f.getGeometry()!=null){
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
        FeatureSchema fs = fc.getFeatureSchema();
        if (tablename == null) {
            log.error("No table name given.");
            throw new Exception("No table name given.");
        }
        
        List tableNames = SqlMetaDataUtils.getTableAndViewNames(connection);
        if (tableNames == null) {
            log.error("Cannot get database tables.");
            throw new Exception("Cannot get database tables.");
        } else {
            if (tableNames.contains(tablename)) {
                checkcolumns(fs, geomColumn, attributeNamesToLowerCase, dbmd, tablename);
            } else if(createTable) {
                createTable(dbmd, tablename, fs, geomColumn, attributeNamesToLowerCase, srid, aGeom, sameGeomType, dimension);
            } else {
                log.error("Table does not exists.");
                throw new Exception("Table does not exists.");
            }
            
            StringBuffer insertPart = createInsertPart(fs, tablename, geomColumn, attributeNamesToLowerCase);
            StringBuffer updatePart = createUpdatePart(tablename);
            Iterator it = fc.iterator();
            //Create the insert script.
            StringBuffer q = null;
            for (int inserts = 0; it.hasNext(); inserts++){
                if (q == null)
                    q = new StringBuffer();
                Feature f = (Feature)it.next();
                
                boolean update = false;
                
                if (columnNamesToCheck != null) {
                    //ArrayList values = getPrimaryValues(fs, f, columnNamesToCheck);
                    update = checkExinstenceInDB(columnNamesToCheck,f, tablename);
                }
                
                if(update) {
                    nupdates++;
                    q.append(updatePart.toString());
                    q.append(addUpdateValue(fs, f, geomColumn, columnNamesToCheck));
                } else {
                    ninserts++;
                    q.append(insertPart.toString());
                    q.append("(");
                    q.append(addInsertValue(fs, f).toString());
                    q.append(");");
                }
                if(getBatchValue() != 0) {
                    if ((inserts+1)%getBatchValue()==0){
                        executeStatement(q.toString());
                        q=null;
                    }
                }
            }
            if (q != null && q.length() > 0){
                executeStatement(q.toString());
            }
            return new int[]{nupdates,ninserts};
        }
    }
    
    private boolean checkExinstenceInDB(String[] columnNamesToCheck, Feature f, String tablename) throws SQLException, ParseException {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM \"");
        sql.append(tablename);
        sql.append("\" WHERE ");
        for (int i=0; i < columnNamesToCheck.length; i++){
            if (i!=0){
                sql.append(" AND ");
            }
            sql.append("\""+columnNamesToCheck[i]+"\"");
            sql.append(" = ");
            sql.append(getSqlValue(f,f.getSchema(),columnNamesToCheck[i]));
        }
        sql.append(";");
        PreparedStatement statement = connection.prepareStatement(sql.toString());
        ResultSet rs = statement.executeQuery();
        boolean found = rs.next();
        statement.execute();
        statement.close();
        return found;
    }
    
    private void checkcolumns(FeatureSchema fs, String geomColumn, boolean attributeNamesToLowerCase, DatabaseMetaData dbmd, String tablename) throws Exception {
        for (int i = 0; i < fs.getAttributeCount(); i++) {
            if (i != fs.getGeometryIndex() || geomColumn == null){
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
                    int type = rs.getInt("DATA_TYPE");
                    if(isCompatibleType(attributeType,type)) {
                        columFound=true;
                    }
                }
                //if there is no correct columFound it is a 'wrong' table
                if (!columFound){
                    log.error("Table already exists but has wrong columns.");
                    throw new Exception("Table already exists but has wrong columns.");
                }
            }else{
                ResultSet rs = dbmd.getColumns(null, null, tablename, geomColumn);
                if (!rs.next()){
                    log.error("Table already exists but has wrong columns.");
                    throw new Exception("Table already exists but has wrong columns.");
                }
            }
        }
    }
    
    private void executeStatement(String statementToExecute) throws SQLException{
        PreparedStatement statement=null;
        try{
            statement=connection.prepareStatement(statementToExecute);
            statement.execute();
        }catch(SQLException se){
            throw se;
        }finally {
            if (statement!=null)
                statement.close();
        }
    }
    
    private StringBuffer addInsertValue(FeatureSchema fs, Feature f) throws ParseException{
        StringBuffer values = new StringBuffer();
        for (int i=0; i < fs.getAttributeCount(); i++) {
            if (i!=0)
                values.append(", ");
            values.append(getSqlValue(f,fs,i));
        }
        return values;
    }
    private String getSqlValue(Feature f, FeatureSchema fs,String attributeName) throws ParseException{
        return getSqlValue(f,fs.getAttributeIndex(attributeName));
    }
    private String getSqlValue(Feature f,int i) throws ParseException{
        return getSqlValue(f,f.getSchema(),i);
    }
    private String getSqlValue(Feature f,FeatureSchema fs,int i) throws ParseException{
        Object o=f.getAttribute(fs.getAttributeName(i));
        StringBuffer values= new StringBuffer();
        if (fs.getAttributeType(i).equals(AttributeType.GEOMETRY)){
            values.append("GeomFromText(\'");
            values.append(f.getGeometry().toText());
            
            int geomSRID = f.getGeometry().getSRID();
            int schemaSRID = fs.getCoordinateSystem().getEPSGCode();
            if (geomSRID>=0 && schemaSRID>=0 && geomSRID!=schemaSRID)
                throw new ParseException("SRID of geometry differs from EPSG code of feature schema!", i);
            
            if (geomSRID>=0){
                values.append("\', "+geomSRID);
            } else if (schemaSRID>=0){
                values.append("\', "+geomSRID);
            } else {
                values.append("\', 28992");
            }
            values.append(")");
        }else if (fs.getAttributeType(i).equals(AttributeType.DOUBLE)){
            values.append(o);
        }else if (fs.getAttributeType(i).equals(AttributeType.INTEGER)){
            values.append(o);
        }else if (fs.getAttributeType(i).equals(AttributeType.STRING)){
            if (o==null)
                values.append(o);
            else{
                String s=(String)o;
                s=s.replaceAll("'","\'\'");
                values.append("\'");
                values.append(s);
                values.append("\'");
            }
        }else if (fs.getAttributeType(i).equals(AttributeType.DATE)){
            if (o==null)
                values.append(o);
            else if (o instanceof Date){
                Date d = (Date)o;
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTime(d);
                values.append("\'");
                values.append(cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH));
                values.append("\'");
            }else if (o instanceof String){
                values.append("\'");
                values.append(formatDate("dd-MM-yyyy", "yyyy-MM-dd", (String) o));
                values.append("\'");
            }else{
                values.append("\'\'");
            }
        }else if (fs.getAttributeType(i).equals(AttributeType.OBJECT)){
            if (o==null)
                values.append(o);
            else{
                values.append("\'");
                values.append(o);
                values.append("\'");
            }
        }
        return values.toString();
    }
    
    private String addUpdateValue(FeatureSchema fs, Feature f, String geomColumn, String [] columnNamesToCheck) throws ParseException {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < fs.getAttributeCount(); i++) {
            if (i!=0)
                sb.append(", ");
            if (fs.getGeometryIndex()==i){
                sb.append("\""+geomColumn+"\"");
            }else{
                sb.append("\""+fs.getAttributeName(i)+"\"");
            }
            
            sb.append(" = ");
            sb.append(getSqlValue(f,fs,i));
            
        }
        sb.append(" WHERE ");
        for (int i = 0; i < columnNamesToCheck.length; i++) {
            if (i!=0)
                sb.append(" AND ");
            sb.append("\""+columnNamesToCheck[i]+"\"");
            sb.append(" = ");
            sb.append(getSqlValue(f,fs,columnNamesToCheck[i]));
            
        }
        sb.append(";");
        return sb.toString();
    }
    
    private String formatDate(String oldstyle, String newstyle, String parse_date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(oldstyle);
        Date date = null;
        //try {
        date = dateFormat.parse(parse_date);
        //} catch (ParseException e) {}
        dateFormat = new SimpleDateFormat(newstyle);
        return dateFormat.format(date);
    }
    
    private void createTable(DatabaseMetaData dbmd, String tablename, FeatureSchema fs, String geomColumn,
            boolean attributeNamesToLowerCase, String srid, Geometry aGeom, boolean sameGeomType, int dimension) throws SQLException, Exception {
        //check if the product is supported
        if (SUPPORTED_DIALECTS.contains(dbmd.getDatabaseProductName())) {
            StringBuffer sb = new StringBuffer();
            sb.append("CREATE TABLE \"");
            sb.append(tablename);
            sb.append("\"(");
            
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
                        } else{
                            geomColumn=fs.getAttributeName(i);
                        }
                    }
                }else{
                    if (!firstColumn) {
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
                        sb.append("double precision");
                    }else if (at.equals(AttributeType.INTEGER)){
                        sb.append("bigint");
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
                if (dbmd.getDatabaseProductName().equalsIgnoreCase(SqlMetaDataUtils.PRODUCT_POSTGRES)){
                    // get the database name.
                    String s=dbmd.getURL();
                    String url=dbmd.getURL();
                    String db=url.split("/")[url.split("/").length-1];
                    //create the script for the addGeometryColumn function
                    sbg=new StringBuffer();
                    sbg.append("select addGeometryColumn(\'");
                    sbg.append("public");
                    sbg.append("\', \'");
                    sbg.append(tablename);
                    sbg.append("\', \'");
                    sbg.append(geomColumn);
                    sbg.append("\', ");
                    //if the srid is given as param use it. Otherwise try to get the srid out of the geometry or use -1 as srid
                    if (srid!=null){
                        sbg.append(srid);
                    }else if (aGeom!=null){
                        if (aGeom.getSRID()>=0){
                            sbg.append(aGeom.getSRID());
                        }
                    }else{
                        sbg.append(-1);
                    }
                    sbg.append(", \'");
                    //if not all geometries are of the same type create a global geometry column
                    if (!sameGeomType || aGeom==null){
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
            
            if (sbg.toString()!=null){
                sb.append(";");
                sb.append(sbg.toString());
            }
            statement=connection.prepareStatement(sb.toString());
            statement.execute();
            statement.close();
            
        }else{
            log.error("CREATE TABLE not supported for "+dbmd.getDatabaseProductName());
            throw new Exception("CREATE TABLE not supported for "+dbmd.getDatabaseProductName());
        }
    }
    
    private StringBuffer createInsertPart(FeatureSchema fs, String tablename, String geomColumn, boolean attributeNamesToLowerCase) {
        StringBuffer insertPart = new StringBuffer();
        insertPart.append("INSERT INTO \"");
        insertPart.append(tablename);
        insertPart.append("\" (");
        //create the global part of the insert script.
        for (int i=0; i < fs.getAttributeCount(); i++){
            if (i!=0)
                insertPart.append(", ");
            if (i!=fs.getGeometryIndex() || geomColumn==null){
                if (attributeNamesToLowerCase){
                    insertPart.append("\""+fs.getAttributeName(i).toLowerCase()+"\"");
                }else{
                    insertPart.append("\""+fs.getAttributeName(i)+"\"");
                }
            }else{
                insertPart.append("\""+geomColumn+"\"");
            }
        }
        insertPart.append(") VALUES ");
        return insertPart;
    }
    
    private StringBuffer createUpdatePart(String tablename) {
        StringBuffer insertPart = new StringBuffer();
        insertPart.append("UPDATE \"");
        insertPart.append(tablename);
        insertPart.append("\" SET ");
        return insertPart;
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
        } else if (attributeType.equals(AttributeType.DOUBLE)){
            if (type==java.sql.Types.DOUBLE || type==java.sql.Types.DECIMAL || type==java.sql.Types.REAL || type==java.sql.Types.FLOAT)
                return true;
        } else if (attributeType.equals(AttributeType.GEOMETRY)){
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
    
  /*  public static void main(String [] args) throws IOException, ParseException, Exception{
         String w1url="http://w1.b3p.nl/cgi-bin/mapserv.exe?SRSNAME=EPSG:28992&TYPENAME=tankstations_centroid&BBOX=70000,300000,305000,425000&VERSION=1.0.0&SERVICE=WFS&map=e:/mapserver/pnb_wis/pnb_wis2.map&REQUEST=GetFeature";
         String royurl="http://b3p-roy/cgi-bin/mapserv.exe?map=C:/mapserver/map/pnb_wis/geoplaza.map&SERVICE=WFS&REQUEST=GetFeature&VERSION=1.0.0&TYPENAME=strooiroutes&BBOX=70000,300000,305000,425000&SRSNAME=EPSG:28992";
         //,POL2006_P5B_V,POL2006_P5A_V,POL2006_P4_V,POL2006_P3_V,POL2006_P6_V,POL2006_P2_V,POL2006_P1_V,POL2006_Grens_sted_dynam_V,POL2006_P13_Water_V,POL2006_AEF_beek_L,POL2006_SEF_beek_L,POL2006_P7_Transportas_L
         String degree="http://lin017.prvlimburg.nl/cgi-bin/oru/pol2006_1_perspectieven?SRSNAME=EPSG:28992&TYPENAME=POL2006_P9_V,POL2006_P8_V&VERSION=1.0.0&SERVICE=WFS&REQUEST=GetFeature";
         String url="jdbc:postgresql://localhost:5432/gistest";
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
                 bosw.setBatchValue(10);
                 if (fc!=null)
                     bosw.write(fc,tableName.toLowerCase(),"the_geom","28992",2,true,true);
             }
         }
     }*/
    /**Get the connection
     */
    public Connection getConnection() {
        return connection;
    }
    /**Set the Connection
     *@param connection the connection used to access the database
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    /**Get the batch value for committing inserts
     */
    public int getBatchValue() {
        return batchValue;
    }
    /** Set the batch value for committing inserts. Default 2.
     * @param batchValue the new value. Default it is 20
     */
    public void setBatchValue(int batchValue) {
        this.batchValue = batchValue;
    }
    public void close() throws SQLException{
        if (connection!=null)
            connection.close();
    }
}
