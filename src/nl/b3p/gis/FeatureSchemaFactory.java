/*
 * B3P Commons GIS is a library with commonly used classes for OGC
 * reading and writing. Included are wms, wfs, gml, csv and other
 * general helper classes and extensions.
 *
 * Copyright 2005 - 2008 B3Partners BV
 * 
 * This file is part of B3P Commons GIS.
 * 
 * B3P Commons GIS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * B3P Commons GIS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with B3P Commons GIS.  If not, see <http://www.gnu.org/licenses/>.
 */

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
    static public FeatureSchema createFeatureSchemaFromDbTable(String url, String user, String password, java.sql.Driver driver, String table, String[] dontAddColumns) throws SQLException, NotSupportedException, Exception {
        DriverManager.registerDriver(driver);
        return createFeatureSchemaFromDbTable(DriverManager.getConnection(url, user, password), table, dontAddColumns);
    }

    /**Creates a FeatureSchema from a table.
     * @param conn The connection to the database.
     * @param table The name of the table in the given database. From this table a FeatureSchema is created
     * @return a FeatureSchema
     */
    static public FeatureSchema createFeatureSchemaFromDbTable(Connection conn, String table, String[] dontAddColumns) throws SQLException, NotSupportedException, Exception {
        FeatureSchema fs = new FeatureSchema();
        List tableNames = SqlMetaDataUtils.getTableAndViewNames(conn);
        DatabaseMetaData dbmd = conn.getMetaData();
        if (tableNames.contains(table)) {
            ResultSet rs = dbmd.getColumns(null, null, table, null);
            for (int i = 0; rs.next(); i++) {
                String columnName = rs.getString("COLUMN_NAME");
                boolean add = true;
                if (dontAddColumns != null) {
                    for (int d = 0; d < dontAddColumns.length && add; d++) {
                        if (dontAddColumns[d].equalsIgnoreCase(columnName)) {
                            add = false;
                        }
                    }
                }
                if (add) {
                    int dataType = rs.getInt("DATA_TYPE");
                    AttributeType at = SqlMetaDataUtils.getAttributeTypeFromSqlType(dataType);
                    //probably a Geom object, otherwise unknown type so don't add the attribute.
                    if (at.equals(AttributeType.OBJECT)) {
                        if (dbmd.getDatabaseProductName().equalsIgnoreCase(SqlMetaDataUtils.PRODUCT_POSTGRES)) {
                            //the geom columns in postgis are stored in the "geometry_columns" table
                            PreparedStatement statement = null;
                            statement = conn.prepareStatement("SELECT * FROM geometry_columns g WHERE g.f_table_name = '" + table + "';");
                            ResultSet rsgeom = statement.executeQuery();
                            //if there is a geometry_columns record then this is a geometry
                            if (rsgeom.next()) {
                                int epsgCode = rsgeom.getInt("srid");
                                CoordinateSystem cs = new CoordinateSystem("EPSG:" + epsgCode, epsgCode, null);
                                fs.setCoordinateSystem(cs);

                                String type = rsgeom.getString("type");

                                fs.addAttribute(columnName, AttributeType.GEOMETRY);
                            }
                            statement.close();
                        } else {
                            log.info("create geometry feature not supported for " + dbmd.getDatabaseProductName());
                        }
                    } else {
                        fs.addAttribute(columnName, at);
                    }
                }
            }
        //set the coordinateSystem without the projection. Don't need it (yet)

        } else {
            log.error("Table " + table + " not found");
            throw new Exception("Table " + table + " not found");
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
