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
 * OgcSqlUtils.java
 *
 * Created on 24 oktober 2007, 14:59
 *
 * Autor: Roy Braam
 */
package nl.b3p.ogc.utils;

import com.vividsolutions.jump.feature.AttributeType;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roy Braam
 */
public class SqlMetaDataUtils {

    public static final String PRODUCT_POSTGRES = "PostgreSQL";

    /** Creates a new instance of OgcSqlUtils */
    public SqlMetaDataUtils() {
    }

    static public List getTableAndViewNames(Connection conn) throws SQLException {
        DatabaseMetaData dbmd = conn.getMetaData();
        String[] types = new String[]{"TABLE", "VIEW"};
        ResultSet rs = dbmd.getTables(null, null, null, types);
        List tables = null;
        while (rs.next()) {
            String tableName = rs.getString("TABLE_NAME");
            if (tables == null) {
                tables = new ArrayList();
            }
            tables.add(tableName);
        }
        return tables;
    }

    static public List getColumnNames(String tablename, String column, Connection conn) throws SQLException {
        DatabaseMetaData dbmd = conn.getMetaData();
        ResultSet rs = dbmd.getColumns(null, null, tablename, column);
        List columns = null;
        while (rs.next()) {
            String columnName = rs.getString("COLUMN_NAME");
            if (columns == null) {
                columns = new ArrayList();
            }
            columns.add(columnName);
        }
        return columns;
    }

    static public AttributeType getAttributeTypeFromSqlType(int sqlType) {
        AttributeType at = null;
        if (sqlType == java.sql.Types.BIGINT ||
                sqlType == java.sql.Types.INTEGER ||
                sqlType == java.sql.Types.SMALLINT ||
                sqlType == java.sql.Types.TINYINT ||
                sqlType == java.sql.Types.NUMERIC) {
            at = AttributeType.INTEGER;
        } else if (sqlType == java.sql.Types.DATE ||
                sqlType == java.sql.Types.TIME ||
                sqlType == java.sql.Types.TIMESTAMP) {
            at = AttributeType.DATE;
        } else if (sqlType == java.sql.Types.DECIMAL ||
                sqlType == java.sql.Types.DOUBLE ||
                sqlType == java.sql.Types.FLOAT ||
                sqlType == java.sql.Types.REAL) {
            at = AttributeType.DOUBLE;
        } else if (sqlType == java.sql.Types.CHAR ||
                sqlType == java.sql.Types.BLOB ||
                sqlType == java.sql.Types.CLOB ||
                sqlType == java.sql.Types.LONGVARCHAR ||
                sqlType == java.sql.Types.VARCHAR) {
            at = AttributeType.STRING;
        } else if (sqlType == java.sql.Types.OTHER) {
            at = AttributeType.OBJECT;
        } else {
            //throw new NotSupportedException("SQL type not supported: "+ sqlType);
            //at is null.
        }
        return at;
    }
}
