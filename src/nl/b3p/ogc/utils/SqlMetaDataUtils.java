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
import javax.transaction.NotSupportedException;

/**
 *
 * @author Roy Braam
 */
public class SqlMetaDataUtils {
    public static final String PRODUCT_POSTGRES="PostgreSQL";
    /** Creates a new instance of OgcSqlUtils */
    public SqlMetaDataUtils() {
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
        ResultSet rs = dbmd.getColumns(null, null, tablename, column);
        List columns = null;
        while (rs.next()) {
            String columnName = rs.getString("COLUMN_NAME");
            if (columns==null)
                columns = new ArrayList();
            columns.add(columnName);
        }
        return columns;
    }
    static public AttributeType getAttributeTypeFromSqlType(int sqlType) throws NotSupportedException{
        AttributeType at=null;
        if (sqlType == java.sql.Types.BIGINT || 
                sqlType == java.sql.Types.INTEGER ||
                sqlType == java.sql.Types.SMALLINT ||
                sqlType == java.sql.Types.TINYINT ||  
                sqlType == java.sql.Types.NUMERIC){
            at= AttributeType.INTEGER;
        }
        else if (sqlType == java.sql.Types.DATE || 
                sqlType == java.sql.Types.TIME ||
                sqlType == java.sql.Types.TIMESTAMP){
            at= AttributeType.DATE;
        }
        else if (sqlType == java.sql.Types.DECIMAL || 
                sqlType == java.sql.Types.DOUBLE || 
                sqlType == java.sql.Types.FLOAT || 
                sqlType == java.sql.Types.REAL){
            at= AttributeType.DOUBLE;
        }
        else if (sqlType == java.sql.Types.CHAR ||  
                sqlType == java.sql.Types.BLOB ||  
                sqlType == java.sql.Types.CLOB || 
                sqlType == java.sql.Types.LONGVARCHAR || 
                sqlType == java.sql.Types.VARCHAR){
            at= AttributeType.STRING;
        }
        else if (sqlType== java.sql.Types.OTHER){
            at= AttributeType.OBJECT;
        }
        else{
            //throw new NotSupportedException("SQL type not supported: "+ sqlType);
            //at is null.
        }
        return at;
    }
    
}
