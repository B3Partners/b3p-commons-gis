/*
 * FeatureSchemaFactory.java
 *
 * Created on 13 november 2007, 10:08
 *
 * Autor: Roy Braam
 */

package nl.b3p.gis;

import com.vividsolutions.jump.coordsys.CoordinateSystem;
import com.vividsolutions.jump.feature.AttributeType;
import com.vividsolutions.jump.feature.FeatureSchema;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.transaction.NotSupportedException;
import nl.b3p.ogc.utils.SqlMetaDataUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Roy Braam
 */
public class FeatureSchemaFactory {
    private static final Log log = LogFactory.getLog(FeatureSchemaFactory.class);
    /** Creates a new instance of FeatureSchemaFactory */
    public FeatureSchemaFactory() {
    }
    /**Creates a FeatureSchema from a table.
     * @param url The url to the database
     * @param user The user to connect to the database
     * @param password The password needed to connect to the database
     * @param driver The driver used to connect to the database
     * @param table The name of the table in the given database. From this table a FeatureSchema is created
     * @return a FeatureSchema
     */
    static public FeatureSchema createFeatureSchemaFromDbTable(String url,String user,String password, java.sql.Driver driver, String table, String[] dontAddColumns) throws SQLException, NotSupportedException, Exception{
        DriverManager.registerDriver(driver);
        return createFeatureSchemaFromDbTable(DriverManager.getConnection(url,user,password),table,dontAddColumns);
    }
    /**Creates a FeatureSchema from a table.
     * @param conn The connection to the database.
     * @param table The name of the table in the given database. From this table a FeatureSchema is created
     * @return a FeatureSchema
     */
    static public FeatureSchema createFeatureSchemaFromDbTable(Connection conn,String table, String[] dontAddColumns) throws SQLException, NotSupportedException, Exception{
        FeatureSchema fs = new FeatureSchema();
        List tableNames=SqlMetaDataUtils.getTableAndViewNames(conn);
        DatabaseMetaData dbmd = conn.getMetaData();     
        if (tableNames.contains(table)){
            ResultSet rs = dbmd.getColumns(null, null, table, null);
            for (int i=0; rs.next(); i++){
                String columnName= rs.getString("COLUMN_NAME");
                boolean add=true;
                if (dontAddColumns!=null){
                    for (int d=0; d < dontAddColumns.length && add; d++){
                        if (dontAddColumns[d].equalsIgnoreCase(columnName)){
                            add=false;
                        }
                    }
                }
                if (add){
                    int dataType= rs.getInt("DATA_TYPE");
                    AttributeType at=SqlMetaDataUtils.getAttributeTypeFromSqlType(dataType);
                    if (at.equals(AttributeType.OBJECT))
                        //probably a Geom object, otherwise unknown type so don't at the attribute.
                        if (dbmd.getDatabaseProductName().equalsIgnoreCase(SqlMetaDataUtils.PRODUCT_POSTGRES)){
                            //the geom columns in postgis are stored in the "geometry_columns" table
                            PreparedStatement statement = null;                        
                            statement=conn.prepareStatement("SELECT * FROM geometry_columns g WHERE g.f_table_name = '"+table+"';");
                            ResultSet rsgeom=statement.executeQuery();
                            //if there is a geometry_columns record then this is a geometry
                            if (rsgeom.next()){
                                int epsgCode= rsgeom.getInt("srid");
                                CoordinateSystem cs= new CoordinateSystem("EPSG:"+epsgCode,epsgCode,null);
                                fs.setCoordinateSystem(cs);
                                fs.addAttribute(columnName,AttributeType.GEOMETRY);
                            }
                            statement.close();
                        }
                        else{
                           log.info("create geometry feature not supported for "+dbmd.getDatabaseProductName());
                        }
                    else{
                        fs.addAttribute(columnName,at);                    
                    }
                }
            }
             //set the coordinateSystem without the projection. Don't need it (yet)
            
        }else{
            throw new Exception ("Table "+table +" not found");
        }
        return fs;
    }
    /*public static void main(String [] args) throws Exception{
        String url="jdbc:postgresql://localhost:5432/pnb_wis";
        String user="postgres";
        String password="***REMOVED***";
        FeatureSchema fs=createFeatureSchemaFromDbTable(url,user,password,new org.postgresql.Driver(),"tankstations_centroid");
        FileReader fr = new FileReader("c:\\public_tankstations_centroid.csv");
        CsvInputStream cis = new CsvInputStream(fr);
        String[] columns= cis.readRecord();
        FeatureDataset fc = new FeatureDataset(fs);
        Object[] attributes=null;
        attributes=cis.readRecord();
        while(attributes!=null){
            Feature f=FeatureFactory.createPointFeature(attributes,columns,5,6,fs);
            fc.add(f);
            attributes=cis.readRecord();
        }        
        B3pOgcSqlWriter bow = new B3pOgcSqlWriter(url,user,password,new org.postgresql.Driver());
        bow.write(fc,"nieuwe_tankstations","the_geom","28992",2,true,true);
    }*/
}
