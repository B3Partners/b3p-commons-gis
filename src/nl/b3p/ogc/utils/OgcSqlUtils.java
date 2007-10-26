/*
 * OgcSqlUtils.java
 *
 * Created on 24 oktober 2007, 14:59
 *
 * Autor: Roy Braam
 */

package nl.b3p.ogc.utils;

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
public class OgcSqlUtils {
    
    /** Creates a new instance of OgcSqlUtils */
    public OgcSqlUtils() {
    }    
    static public List getTableAndViewNames(Connection conn) throws SQLException {
        DatabaseMetaData dbmd = conn.getMetaData();
        String[] types = new String[] {"TABLE", "VIEW"};
        ResultSet rs = dbmd.getTables(null, null, null, types);
        List tables = null;
        while (rs.next()) {
            String tableName = rs.getString("TABLE_NAME");
            if (tables==null)
                tables = new ArrayList();
            tables.add(tableName);
        }
        return tables;
    }
    
    static public List getColumnNames(String tablename, String column, Connection conn) throws SQLException {
        DatabaseMetaData dbmd = conn.getMetaData();
        ResultSet rs = dbmd.getColumns(null, null, tablename, null);
        List columns = null;
        while (rs.next()) {
            String columnName = rs.getString("COLUMN_NAME");
            if (columns==null)
                columns = new ArrayList();
            columns.add(columnName);
        }
        return columns;
    }
}
