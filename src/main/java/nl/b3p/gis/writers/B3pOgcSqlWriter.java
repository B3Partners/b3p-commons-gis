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
    private int batchValue = 20;
    public static final String DEFAULT_GEOM_COLUMN = "the_geom";
    public static final String POSTGRES_GLOBALGEOMETRY = "GEOMETRY";
    public static final List SUPPORTED_DIALECTS = Arrays.asList(new String[]{
                SqlMetaDataUtils.PRODUCT_POSTGRES
            });

    /** Creates a new instance of B3pOgcSqlWriter */
    public B3pOgcSqlWriter(Connection conn) {
        setConnection(conn);
    }
    /* Creates a connection and a B3pOgcSqlWriter*/

    public B3pOgcSqlWriter(String url, String user, String password, java.sql.Driver driver) throws SQLException {
        DriverManager.registerDriver(driver);
        setConnection(DriverManager.getConnection(url, user, password));
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
    public int[] write(FeatureCollection fc, String tablename, String geomColumn, int dimension, boolean createTable, boolean attributeNamesToLowerCase) throws SQLException, Exception {
        return write(fc, tablename, geomColumn, null, dimension, createTable, attributeNamesToLowerCase, null, null);
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
    public int[] write(FeatureCollection fc, String tablename, String geomColumn, int dimension, boolean createTable, boolean attributeNamesToLowerCase, String[] columnNamesToCheck) throws SQLException, Exception {
        return write(fc, tablename, geomColumn, null, dimension, createTable, attributeNamesToLowerCase, columnNamesToCheck, null);
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
     * @param the value to ignore. If a feature has that value don't include it in the update/insert.
     */
    public int[] write(FeatureCollection fc, String tablename, String geomColumn, int dimension, boolean createTable, boolean attributeNamesToLowerCase, String[] columnNamesToCheck, String ignoreValue) throws SQLException, Exception {
        return write(fc, tablename, geomColumn, null, dimension, createTable, attributeNamesToLowerCase, columnNamesToCheck, ignoreValue);
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
    @Deprecated
    public int[] write(FeatureCollection fc, String tablename, String geomColumn, String srid, int dimension, boolean createTable, boolean attributeNamesToLowerCase) throws SQLException, Exception {
        return write(fc, tablename, geomColumn, srid, dimension, createTable, attributeNamesToLowerCase, null, null);
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
     * @param the value to ignore. If a feature has that value don't include it in the update/insert.
     * @deprecated use function without SRID.
     */
    @Deprecated
    public int[] write(FeatureCollection fc, String tablename, String geomColumn, String srid, int dimension, boolean createTable, boolean attributeNamesToLowerCase, String[] columnNamesToCheck, String ignoreValue) throws SQLException, Exception {
    	ignoreValue = "'" + ignoreValue + "'";
        //check if al features are of the same geom type and get a geom
        int nupdates = 0;
        int ninserts = 0;
        Iterator fcit = fc.iterator();
        Geometry aGeom = null;
        boolean sameGeomType = true;
        while (fcit.hasNext() && sameGeomType) {
            Feature f = (Feature) fcit.next();
            FeatureSchema fs = f.getSchema();
            if (fs.getGeometryIndex() >= 0 && f.getGeometry() != null) {
                if (aGeom == null) {
                    aGeom = f.getGeometry();
                } else {
                    if (!aGeom.getGeometryType().equals(f.getGeometry().getGeometryType())) {
                        sameGeomType = false;
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
            } else if (createTable) {
                createTable(dbmd, tablename, fs, geomColumn, attributeNamesToLowerCase, srid, aGeom, sameGeomType, dimension);
            } else {
                log.error("Table does not exists.");
                throw new Exception("Table does not exists.");
            }

            String insertPart = createInsertPart(fs, tablename);
            String updatePart = createUpdatePart(tablename);
            Iterator it = fc.iterator();
            //Create the insert script.
            StringBuffer q = null;
            for (int inserts = 0; it.hasNext(); inserts++) {
                if (q == null) {
                    q = new StringBuffer();
                }
                Feature f = (Feature) it.next();

                boolean update = false;

                if (columnNamesToCheck != null) {
                    //ArrayList values = getPrimaryValues(fs, f, columnNamesToCheck);
                    update = checkExinstenceInDB(columnNamesToCheck, f, tablename);
                }

                if (update) {
                    nupdates++;
                    q.append(updatePart.toString());
                    q.append(addUpdateValue(fs, f, geomColumn, columnNamesToCheck, ignoreValue));
                } else {
                    ninserts++;
                    q.append(insertPart.toString());
                    q.append(addInsertValue(fs, f, geomColumn, attributeNamesToLowerCase, ignoreValue));
                }
                if (getBatchValue() != 0) {
                    if ((inserts + 1) % getBatchValue() == 0) {
                        executeStatement(q.toString());
                        q = null;
                    }
                }
            }
            if (q != null && q.length() > 0) {
                executeStatement(q.toString());
            }
            return new int[]{nupdates, ninserts};
        }
    }

    private boolean checkExinstenceInDB(String[] columnNamesToCheck, Feature f, String tablename) throws SQLException, ParseException {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM \"");
        sql.append(tablename);
        sql.append("\" WHERE ");
        for (int i = 0; i < columnNamesToCheck.length; i++) {
            if (i != 0) {
                sql.append(" AND ");
            }
            sql.append("\"" + columnNamesToCheck[i] + "\"");
            sql.append(" = ");
            sql.append(getSqlValue(f, f.getSchema(), columnNamesToCheck[i], true));
        }
        sql.append(";");
        if (log.isDebugEnabled()) {
        	log.debug("checkExistenceInDB - sql: " + sql);
        }
        PreparedStatement statement = connection.prepareStatement(sql.toString());
        ResultSet rs = statement.executeQuery();
        boolean found = rs.next();
        statement.execute();
        statement.close();
        return found;
    }

    private void checkcolumns(FeatureSchema fs, String geomColumn, boolean attributeNamesToLowerCase, DatabaseMetaData dbmd, String tablename) throws Exception {
        for (int i = 0; i < fs.getAttributeCount(); i++) {
            if (i != fs.getGeometryIndex() || geomColumn == null) {
                boolean columFound = false;
                String attributeName = fs.getAttributeName(i);
                if (attributeNamesToLowerCase) {
                    attributeName = attributeName.toLowerCase();
                }
                AttributeType attributeType = fs.getAttributeType(i);
                //get the column by attribute name.
                ResultSet rs = dbmd.getColumns(null, null, tablename, attributeName);
                //if the column exists check the compatibility of the data_type
                if (rs.next()) {
                    int type = rs.getInt("DATA_TYPE");
                    if (isCompatibleType(attributeType, type)) {
                        columFound = true;
                    }
                }
                //if there is no correct columFound it is a 'wrong' table
                if (!columFound) {
                    log.error("Table already exists but has wrong columns.");
                    throw new Exception("Table already exists but has wrong columns.");
                }
            } else {
                ResultSet rs = dbmd.getColumns(null, null, tablename, geomColumn);
                if (!rs.next()) {
                    log.error("Table already exists but has wrong columns.");
                    throw new Exception("Table already exists but has wrong columns.");
                }
            }
        }
    }

    private void executeStatement(String statementToExecute) throws SQLException {
    	if (log.isDebugEnabled()) {
    		log.debug("executeStatement: " + statementToExecute);
    	}
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(statementToExecute);
            statement.execute();
        } catch (SQLException se) {
            throw se;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    private String addInsertValue(FeatureSchema fs, Feature f, String geomColumn, boolean attributeNamesToLowerCase, String ignoreValue) throws ParseException {
    	StringBuffer columns = new StringBuffer();
        StringBuffer values = new StringBuffer();
        
        columns.append("(");
        boolean first = true;
        for (int i = 0; i < fs.getAttributeCount(); i++) {
        	String value = getSqlValue(f, fs, i, false);
        	if (ignoreValue == null || !ignoreValue.equals(value)) {
	            if (!first) {
	            	columns.append(", ");
	                values.append(", ");
	            }
            	first = false;
	            values.append(value);
	            
	            if (i != fs.getGeometryIndex() || geomColumn == null) {
	                if (attributeNamesToLowerCase) {
	                	columns.append("\"" + fs.getAttributeName(i).toLowerCase() + "\"");
	                } else {
	                	columns.append("\"" + fs.getAttributeName(i) + "\"");
	                }
	            } else {
	            	columns.append("\"" + geomColumn + "\"");
	            }
        	}
        }
        columns.append(") VALUES (");
        columns.append(values.toString());
        columns.append(");");
        
        return columns.toString();
    }

    private String getSqlValue(Feature f, FeatureSchema fs, String attributeName, boolean nullForEmptyNumber) throws ParseException {
        return getSqlValue(f, fs.getAttributeIndex(attributeName), nullForEmptyNumber);
    }

    private String getSqlValue(Feature f, int i, boolean nullForEmptyNumber) throws ParseException {
        return getSqlValue(f, f.getSchema(), i, nullForEmptyNumber);
    }

    private String getSqlValue(Feature f, FeatureSchema fs, int i, boolean nullForEmptyNumber) throws ParseException {
        Object o = f.getAttribute(fs.getAttributeName(i));
        StringBuffer values = new StringBuffer();
        if (fs.getAttributeType(i).equals(AttributeType.GEOMETRY)) {
            values.append("ST_GeomFromText(\'");
            values.append(f.getGeometry().toText());

            int geomSRID = f.getGeometry().getSRID();
            //int schemaSRID = fs.getCoordinateSystem().getEPSGCode();
            /*if (geomSRID>=0 && schemaSRID>=0 && geomSRID!=schemaSRID)
            throw new ParseException("SRID of geometry differs from EPSG code of feature schema!", i);
             */
            if (geomSRID >= 0) {
                values.append("\', " + geomSRID);
            } /*else if (schemaSRID>=0){
            values.append("\', "+geomSRID);
            } */ else {
                values.append("\', 28992");
            }
            values.append(")");
        } else if (fs.getAttributeType(i).equals(AttributeType.DOUBLE) 
        		|| fs.getAttributeType(i).equals(AttributeType.INTEGER)) {
        	if ("".equals(o) || o == null) {
        		if (nullForEmptyNumber) {
        			values.append("null");
        		} else {
        			values.append("''");
        		}
        	} else {
        		// check if value is a number!!!
        		// else we get strange SQL syntax errors
        		try {
        			Double.parseDouble(o.toString());
        		} catch(Exception e) {
        			throw new IllegalArgumentException("The DOUBLE/INTEGER value is not valid: " + o);
        		}
        		values.append(o);
        	}
        } else if (fs.getAttributeType(i).equals(AttributeType.STRING)) {
            if (o == null) {
                values.append(o);
            } else {
                String s = (String) o;
                s = s.replaceAll("'", "\'\'");
                values.append("\'");
                values.append(s);
                values.append("\'");
            }
        } else if (fs.getAttributeType(i).equals(AttributeType.DATE)) {
            if (o == null) {
                values.append(o);
            } else if (o instanceof Date) {
                Date d = (Date) o;
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTime(d);
                values.append("\'");
                values.append(new SimpleDateFormat("yyyy-MM-dd").format(d));
                values.append("\'");
            } else if (o instanceof String) {
                values.append("\'");
                if (!"''".equals(o)) {
                	values.append(formatDate("dd-MM-yyyy", "HH:mm:ss", "yyyy-MM-dd", "HH:mm:ss", (String) o));
                }
                values.append("\'");
            } else {
                values.append("\'\'");
            }
        } else if (fs.getAttributeType(i).equals(AttributeType.OBJECT)) {
            if (o == null) {
                values.append(o);
            } else {
                values.append("\'");
                values.append(o);
                values.append("\'");
            }
        }
        return values.toString();
    }

    private String addUpdateValue(FeatureSchema fs, Feature f, String geomColumn, String[] columnNamesToCheck, String ignoreValue) throws ParseException {
        StringBuffer sb = new StringBuffer();
        boolean first = true;
        for (int i = 0; i < fs.getAttributeCount(); i++) {
        	String value = getSqlValue(f, fs, i, false);
        	if (ignoreValue == null || !ignoreValue.equals(value)) {
	            if (!first) {
	                sb.append(", ");
	            }
            	first = false;
	            if (fs.getGeometryIndex() == i) {
	                sb.append("\"" + geomColumn + "\"");
	            } else {
	                sb.append("\"" + fs.getAttributeName(i) + "\"");
	            }
	
	            sb.append(" = ");
	            sb.append(value);
        	}
        }
        sb.append(" WHERE ");
        for (int i = 0; i < columnNamesToCheck.length; i++) {
            if (i != 0) {
                sb.append(" AND ");
            }
            sb.append("\"" + columnNamesToCheck[i] + "\"");
            sb.append(" = ");
            sb.append(getSqlValue(f, fs, columnNamesToCheck[i], false));

        }
        sb.append(";");
        return sb.toString();
    }

    private String formatDate(String olddate, String oldtime, String newdate, String newtime, String parse_date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(olddate + " " + oldtime);
        Date date = null;
        // first try date + time
        try {
        	date = dateFormat.parse(parse_date);
            dateFormat = new SimpleDateFormat(newdate + " " + newtime);
        } catch (ParseException e) {
        	// second try date
            try {
            	dateFormat.applyPattern(olddate);
            	date = dateFormat.parse(parse_date);
                dateFormat = new SimpleDateFormat(newdate);
            } catch (ParseException e2) {
            	// third try time
	        	dateFormat.applyPattern(oldtime);
	        	date = dateFormat.parse(parse_date);
	            dateFormat = new SimpleDateFormat(newtime);
            }
        }
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

            boolean firstColumn = true;
            boolean geomColumnFound = false;
            //create a create table script without the geometry column.
            for (int i = 0; i < fs.getAttributeCount(); i++) {
                AttributeType at = fs.getAttributeType(i);
                if (at.equals(AttributeType.GEOMETRY)) {
                    geomColumnFound = true;
                    if (geomColumn == null) {
                        if (attributeNamesToLowerCase) {
                            geomColumn = fs.getAttributeName(i).toLowerCase();
                        } else {
                            geomColumn = fs.getAttributeName(i);
                        }
                    }
                } else {
                    if (!firstColumn) {
                        sb.append(", ");
                    }
                    firstColumn = false;
                    sb.append("\"");
                    if (attributeNamesToLowerCase) {
                        sb.append(fs.getAttributeName(i).toLowerCase());
                    } else {
                        sb.append(fs.getAttributeName(i));
                    }
                    sb.append("\" ");
                    if (at.equals(AttributeType.DATE)) {
                        sb.append("date");
                    } else if (at.equals(AttributeType.DOUBLE)) {
                        sb.append("double precision");
                    } else if (at.equals(AttributeType.INTEGER)) {
                        sb.append("bigint");
                    } else {
                        sb.append("varchar(255)");
                    }
                }
            }
            sb.append(")WITH OIDS");
            StringBuffer sbg = null;
            //if there is a geomColum needed create the create script.
            if (geomColumnFound) {
                //if it is a postgres/postgis db
                if (dbmd.getDatabaseProductName().equalsIgnoreCase(SqlMetaDataUtils.PRODUCT_POSTGRES)) {
                    // get the database name.
                    String s = dbmd.getURL();
                    String url = dbmd.getURL();
                    String db = url.split("/")[url.split("/").length - 1];
                    //create the script for the addGeometryColumn function
                    sbg = new StringBuffer();
                    sbg.append("select addGeometryColumn(\'");
                    sbg.append("public");
                    sbg.append("\', \'");
                    sbg.append(tablename);
                    sbg.append("\', \'");
                    sbg.append(geomColumn);
                    sbg.append("\', ");
                    //if the srid is given as param use it. Otherwise try to get the srid out of the geometry or use -1 as srid
                    if (srid != null) {
                        sbg.append(srid);
                    } else if (aGeom != null) {
                        if (aGeom.getSRID() >= 0) {
                            sbg.append(aGeom.getSRID());
                        }
                    } else {
                        sbg.append(-1);
                    }
                    sbg.append(", \'");
                    //if not all geometries are of the same type create a global geometry column
                    if (!sameGeomType || aGeom == null) {
                        sbg.append(POSTGRES_GLOBALGEOMETRY);
                    } else {
                        sbg.append(aGeom.getGeometryType().toUpperCase());
                    }
                    sbg.append("\', ");
                    //if the dimension is given use it, otherwise try to get it out of the Geometry of use 2
                    if (dimension > 0) {
                        sbg.append(dimension);
                    } else {
                        if (aGeom.getDimension() > 1) {
                            sbg.append(aGeom.getDimension());
                        } else {
                            sbg.append("2");
                        }
                    }
                    sbg.append(")");
                }
            }
            //execute the create table script.
            PreparedStatement statement = null;

            if (sbg.toString() != null) {
                sb.append(";");
                sb.append(sbg.toString());
            }
            statement = connection.prepareStatement(sb.toString());
            statement.execute();
            statement.close();

        } else {
            log.error("CREATE TABLE not supported for " + dbmd.getDatabaseProductName());
            throw new Exception("CREATE TABLE not supported for " + dbmd.getDatabaseProductName());
        }
    }

    private String createInsertPart(FeatureSchema fs, String tablename) {
        StringBuffer insertPart = new StringBuffer();
        insertPart.append("INSERT INTO \"");
        insertPart.append(tablename);
        insertPart.append("\"");
        return insertPart.toString();
    }

    private String createUpdatePart(String tablename) {
        StringBuffer insertPart = new StringBuffer();
        insertPart.append("UPDATE \"");
        insertPart.append(tablename);
        insertPart.append("\" SET ");
        return insertPart.toString();
    }

    /**
     * Check if the given attributetype is compatible with the given sql type
     * @param attributeType the attributeType of the feature attribute
     * @param type the sql type of the column.
     * @return true if compatible
     */
    private boolean isCompatibleType(AttributeType attributeType, int type) {
        if (attributeType.equals(AttributeType.DATE)) {
            if (type == java.sql.Types.DATE || type == java.sql.Types.TIME || type == java.sql.Types.TIMESTAMP) {
                return true;
            }
        } else if (attributeType.equals(AttributeType.DOUBLE)) {
            if (type == java.sql.Types.DOUBLE || type == java.sql.Types.DECIMAL || type == java.sql.Types.REAL || type == java.sql.Types.FLOAT) {
                return true;
            }
        } else if (attributeType.equals(AttributeType.GEOMETRY)) {
            return true;
        } else if (attributeType.equals(AttributeType.INTEGER)) {
            if (type == java.sql.Types.INTEGER || type == java.sql.Types.BIGINT || type == java.sql.Types.SMALLINT || type == java.sql.Types.TINYINT) {
                return true;
            }
        } else if (attributeType.equals(AttributeType.OBJECT)) {
            return true;
        } else if (attributeType.equals(AttributeType.STRING)) {
            if (type == java.sql.Types.VARCHAR || type == java.sql.Types.CHAR || type == java.sql.Types.BLOB || type == java.sql.Types.CLOB || type == java.sql.Types.LONGVARCHAR) {
                return true;
            }
        }
        return false;
    }

  
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

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
