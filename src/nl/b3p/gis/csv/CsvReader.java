/*
 */
package nl.b3p.gis.csv;

import com.vividsolutions.jump.feature.Feature;
import com.vividsolutions.jump.feature.FeatureDataset;
import com.vividsolutions.jump.feature.FeatureSchema;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.transaction.NotSupportedException;
import nl.b3p.commons.csv.CsvFormatException;
import nl.b3p.commons.csv.CsvInputStream;
import nl.b3p.gis.FeatureFactory;
import nl.b3p.gis.FeatureSchemaFactory;
import nl.b3p.gis.writers.B3pOgcSqlWriter;

/**
 *
 * @author Chris
 */
public class CsvReader {

    public static final String DEFAULT_ignoredColumnName1 = "id";
    public static final String DEFAULT_geomColumnName = "the_geom";
    public static final String DEFAULT_srs = "28992";
    public static final String DEFAULT_tsColumnName = "TS";
    public static final String DEFAULT_rdxColumnName = "RDX";
    public static final String DEFAULT_rdyColumnName = "RDY";

    // FC
    private String tableName;
    private String[] ignoredColumnNames;
    private String geomColumnName;
    private String srs;
    private String tsColumnName;
    private String timestamp;
    private String spaceName;
    private String spaceValue;
    private String[] uidNames;
    // CSV
    private String rdxColumnName;
    private String rdyColumnName;
    // Locale
    private Locale csvLocale;
    private DecimalFormatSymbols dfs;
    private char csvSeparator;

    // Translation
    private HashMap translatorMap = null;

    public CsvReader(String tableName, String spaceName, String spaceValue, String[] uidNames) {
        this(tableName, spaceName, spaceValue, uidNames, null, ',');
    }

    public CsvReader(String tableName, String spaceName, String spaceValue, String[] uidNames, Locale loc, char csvSeparator) {
        this.setTableName(tableName);
        this.setSpaceName(spaceName);
        this.setSpaceValue(spaceValue);
        this.setUidNames(uidNames);
        this.setCsvLocale(loc);
        this.setCsvSeparator(csvSeparator);
        this.fillDefaults();
    }
    
    protected void fillDefaults() {
        SimpleDateFormat sdf = (SimpleDateFormat) SimpleDateFormat.getDateInstance();
        sdf.applyPattern("yyyy-MM-dd HH:mm:sss");
        this.timestamp = sdf.format(new Date());

        this.ignoredColumnNames = new String[]{DEFAULT_ignoredColumnName1};
        this.geomColumnName = DEFAULT_geomColumnName;
        this.srs = DEFAULT_srs;
        this.tsColumnName = DEFAULT_tsColumnName;
        this.rdxColumnName = DEFAULT_rdxColumnName;
        this.rdyColumnName = DEFAULT_rdyColumnName;
    }

    public void csvOgcSqlETL(Connection conn, CsvInputStream cis) throws SQLException, NotSupportedException, IOException, CsvFormatException, Exception {
        FeatureSchema fs = getFeatureSchema(conn);
        FeatureDataset fc = readFeatureDataset(fs, cis);
        writeFeatureDataset(conn, fc);
    }

    public FeatureSchema getFeatureSchema(Connection conn) throws SQLException, NotSupportedException, Exception {
        return FeatureSchemaFactory.createFeatureSchemaFromDbTable(conn, getTableName(), getIgnoredColumnNames());
    }

    public FeatureDataset readFeatureDataset(FeatureSchema fs, CsvInputStream cis) throws IOException, CsvFormatException {
        cis.setSeparator(getCsvSeparator());
        FeatureDataset fc = new FeatureDataset(fs);

        List columnList = cis.readRecordAsList();
        cis.setCheckColumnCount(true);
        int rdxindex = -1, rdyindex = -1;
        if (columnList != null) {
            rdxindex = columnList.indexOf(getRdxColumnName());
            rdyindex = columnList.indexOf(getRdyColumnName());
        }
        columnList = processColumns(columnList);
        String[] columns = null;
        if (columnList != null) {
            columns = (String[]) columnList.toArray(new String[]{});
        }
        List attributeList = null;
        while ((attributeList = cis.readRecordAsList()) != null) {

            attributeList = processAttributes(attributeList, columnList);
            double rdx = 0.0d, rdy = 0.0d;
            if (rdxindex >= 0) {
                rdx = getDoubleFromString((String) attributeList.get(rdxindex));
            }
            if (rdyindex >= 0) {
                rdy = getDoubleFromString((String) attributeList.get(rdyindex));
            }
            String[] attributes = (String[]) attributeList.toArray(new String[]{});
            Feature f = FeatureFactory.createPointFeature((Object[]) attributes, columns, rdx, rdy, fs);

            fc.add(f);
        }
        return fc;
    }

    public void writeFeatureDataset(Connection conn, FeatureDataset fc) throws SQLException, Exception {
        B3pOgcSqlWriter bow = new B3pOgcSqlWriter(conn);
        bow.setBatchValue(0);
        String[] columnsToCheck = null;
        int len = getUidNames().length;
        if (len == 0 && getSpaceName() != null) {
            columnsToCheck = new String[]{getSpaceName()};
        } else if (getSpaceName() != null) {
            columnsToCheck = new String[len + 1];
            for (int i = 0; i < len; i++) {
                columnsToCheck[i] = getUidNames()[i];
            }
            columnsToCheck[len] = getSpaceName();
        } else {
            columnsToCheck = getUidNames();
        }
        bow.write(fc, getTableName(), getGeomColumnName(), getSrs(), 2, false, true, columnsToCheck);
    }

    protected List translateColumns(List columns) {
        if (columns == null) {
            return null;
        }
        List newColumns = new ArrayList();
        if (getTranslatorMap() != null) {
            for (int i = 0; i < columns.size(); i++) {
                String newColumnName = (String) getTranslatorMap().get(columns.get(i));
                if (newColumnName != null && newColumnName.length() > 0) {
                    newColumns.add(newColumnName);
                } else {
                    newColumns.add(columns.get(i));
                }
            }
        }
        return newColumns;
    }

    protected List processColumns(List columns) {
        if (columns == null) {
            return null;
        }
        List newColumns = translateColumns(columns);
        if (getTsColumnName() != null && getTsColumnName().length() > 0) {
            newColumns.add(getTsColumnName());
        }
        if (getSpaceName() != null && getSpaceName().length() > 0) {
            newColumns.add(getSpaceName());
        }
        return newColumns;
    }

    protected List processAttributes(List attributes, List columns) {
        if (attributes == null) {
            return null;
        }
        if (getTsColumnName() != null && getTsColumnName().length() > 0) {
            attributes.add(getTimestamp()); // TODO juiste format?

        }
        if (getSpaceName() != null && getSpaceName().length() > 0) {
            attributes.add(getSpaceValue());
        }
        return attributes;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String[] getIgnoredColumnNames() {
        return ignoredColumnNames;
    }

    public void setIgnoredColumnNames(String[] ignoredColumnNames) {
        this.ignoredColumnNames = ignoredColumnNames;
    }

    public String getGeomColumnName() {
        return geomColumnName;
    }

    public void setGeomColumnName(String geomColumnName) {
        this.geomColumnName = geomColumnName;
    }

    public String getSrs() {
        return srs;
    }

    public void setSrs(String srs) {
        this.srs = srs;
    }

    public String getTsColumnName() {
        return tsColumnName;
    }

    public void setTsColumnName(String tsColumnName) {
        this.tsColumnName = tsColumnName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getSpaceValue() {
        return spaceValue;
    }

    public void setSpaceValue(String spaceValue) {
        this.spaceValue = spaceValue;
    }

    public String[] getUidNames() {
        return uidNames;
    }

    public void setUidNames(String[] uidNames) {
        this.uidNames = uidNames;
    }

    public String getRdxColumnName() {
        return rdxColumnName;
    }

    public void setRdxColumnName(String rdxColumnName) {
        this.rdxColumnName = rdxColumnName;
    }

    public String getRdyColumnName() {
        return rdyColumnName;
    }

    public void setRdyColumnName(String rdyColumnName) {
        this.rdyColumnName = rdyColumnName;
    }

    public HashMap getTranslatorMap() {
        return translatorMap;
    }

    public void setTranslatorMap(HashMap translatorMap) {
        this.translatorMap = translatorMap;
    }

    public Locale getCsvLocale() {
        return csvLocale;
    }

    public void setCsvLocale(Locale csvLocale) {
        this.csvLocale = csvLocale;
    }

    public DecimalFormatSymbols getDfs() {
        if (csvLocale == null) {
            csvLocale = Locale.getDefault();
        }
        dfs = new DecimalFormatSymbols(this.csvLocale);
        return dfs;
    }

    public char getCsvSeparator() {
        return csvSeparator;
    }

    public void setCsvSeparator(char csvSeparator) {
        this.csvSeparator = csvSeparator;
    }

    private double getDoubleFromString(String d) {
        if (d==null)
            return 0.0d;
        DecimalFormat df = new DecimalFormat("#", getDfs());
        ParsePosition pos = new ParsePosition(0);
        Number n = df.parse(d.trim(), pos);
        if (n == null) {
            return 0.0d;
        }
        return n.doubleValue();
    }
}
