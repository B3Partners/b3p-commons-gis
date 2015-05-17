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
 * FeatureFactory.java
 *
 * Created on 13 november 2007, 9:54
 *
 * Autor: Roy Braam
 */
package nl.b3p.gis;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;
import com.vividsolutions.jump.feature.BasicFeature;
import com.vividsolutions.jump.feature.FeatureSchema;

/**
 *
 * @author Roy Braam
 */
public class FeatureFactory {

    /** Creates a new instance of FeatureFactory */
    public FeatureFactory() {
    }

    /** Creates a point feature from a array of objects. The Objects on index xIndex and yIndex are used to create a point.
     * @param attributes The attributes of the Feature.
     * @param columnames The columnames corresponding the attribute names in the FeatureSchema. It gives the order of adding attributes to the Feature.
     * If columnames is null the attributes are added in that order. Not recommended
     *example: the columname at index 0 is used to look up the index (n) of the attribute where attributename equals the columnname at index 0 then that index (n) is used to at the attribute to the feature.
     * So in this example the attribute at index 0 is added to the feature at index n.
     * @param xIndex The index in the object array that is used as x coord for creating the point
     * @param yIndex The index in the object array that is used as y coord for creating the point
     * @param fs The feature schema that is needed to create a feature
     * @param xyAsAttribute If true the x and y coords are also stored as attribute.
     * @param useMultiPoint If true create a MultiPoint for the coordinates
     */
    public static BasicFeature createPointFeature(Object[] attributes, String[] columnames, int xIndex, int yIndex, FeatureSchema fs, boolean xyAsAttribute, boolean useMultiPoint) {
        if (xIndex >= attributes.length || yIndex >= attributes.length) {
            throw new ArrayIndexOutOfBoundsException("xIndex and/or yIndex is greater then the attributes length");
        }
        Double x = getDoubleFromObject(attributes[xIndex]);
        Double y = getDoubleFromObject(attributes[yIndex]);
        if (!xyAsAttribute) {
            Object[] newAttributes = new Object[attributes.length - 2];
            for (int i = 0, addedAttributes = 0; i < attributes.length; i++) {
                if (!(xIndex == i || yIndex == i)) {
                    newAttributes[addedAttributes] = attributes[i];
                    addedAttributes++;
                }
            }
            attributes = newAttributes;
        }
        if (x != null && y != null) {
            return createPointFeature(attributes, columnames, x.doubleValue(), y.doubleValue(), fs, useMultiPoint);
        } else {
            return createFeature(attributes, columnames, fs);
        }
    }

    /** Creates a point feature from a array of objects. The x and y are used for creating the point.
     * @param attributes The attributes of the Feature.
     * @param columnames The columnames corresponding the attribute names in the FeatureSchema. It gives the order of adding attributes to the Feature.
     * If columnames is null the attributes are added in that order. Not recommended
     *example: the columname at index 0 is used to look up the index (n) of the attribute where attributename equals the columnname at index 0 then that index (n) is used to at the attribute to the feature.
     * So in this example the attribute at index 0 is added to the feature at index n.
     * @param x the x coord used for creating the point
     * @param y the y coord used for creating the point
     * @param fs The feature schema that is needed to create a feature
     * @param useMultiPoint If true create a MultiPoint for the coordinates
     */
    public static BasicFeature createPointFeature(Object[] attributes, String[] columnames, double x, double y, FeatureSchema fs, boolean useMultiPoint) {
        BasicFeature f = createFeature(attributes, columnames, fs);
        if (fs.getGeometryIndex() >= 0) {
            PrecisionModel precisionModel = new PrecisionModel(PrecisionModel.FLOATING);
            int schemaSRID = fs.getCoordinateSystem().getEPSGCode();
            GeometryFactory gf = new GeometryFactory(precisionModel, schemaSRID);
            Coordinate c = new Coordinate(x, y);
            if (useMultiPoint) {
                Coordinate[] ca = new Coordinate[]{c};
                MultiPoint p = gf.createMultiPoint(ca);
                f.setGeometry(p);
            } else {
                Point p = gf.createPoint(c);
                f.setGeometry(p);
            }
        }
        return f;
    }

    /** Creates a feature
     *
     */
    public static BasicFeature createFeature(Object[] attributes, String[] columnames, FeatureSchema fs) {
        BasicFeature f = new BasicFeature(fs);
        if (columnames == null) {
            f.setAttributes(attributes);
        } else {
            for (int i = 0; i < columnames.length; i++) {
                for (int j = 0; j < fs.getAttributeCount(); j++) {
                    String fsatt = fs.getAttributeName(j);
                    if (fsatt == null) {
                        continue;
                    }
                    if (fsatt.equalsIgnoreCase(columnames[i])) {
                        f.setAttribute(j, attributes[i]);
                        break;
                    }
                }
            }
        }
        return f;
    }

    private static Double getDoubleFromObject(Object object) {
        Double x = null;
        if (object != null) {
            if (object instanceof Double) {
                x = (Double) object;
            } else if (object instanceof String) {
                x = new Double((String) object);
            }
        }
        return x;
    }
}
