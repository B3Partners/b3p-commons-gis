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
 * B3pShapeWriter.java
 *
 * Created on 17 oktober 2007, 11:56
 *
 * Autor: Roy
 */
package nl.b3p.gis.writers;

import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jump.feature.Feature;
import com.vividsolutions.jump.feature.FeatureCollection;
import com.vividsolutions.jump.feature.FeatureDataset;
import com.vividsolutions.jump.io.DriverProperties;
import com.vividsolutions.jump.io.IllegalParametersException;
import com.vividsolutions.jump.io.ShapefileWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Roy
 */
public class B3pShapeWriter {

    private static final Log log = LogFactory.getLog(B3pShapeWriter.class);
    private String folder;

    /** Creates a new instance of B3pShapeWriter */
    public B3pShapeWriter() {
    }

    /** Create a new ShapeWriter.
     *  @param folder the full path of the folder thats going to contain the shape files..
     */
    public B3pShapeWriter(String folder) {
        this.setFolder(folder);
    }

    /**
     * writes the featurecollection to shapefiles. Use this function if the features in the featurecollection CAN be different types.
     *@fcAll The feature collection (can have different types)
     *@filename The filename to use bij writing the shape file.
     *
     *@return a list of file's of type java.io.File
     */
    public List writeToShape(FeatureCollection fcAll, String filename) throws IllegalParametersException, Exception {
        FeatureDataset allPoint = new FeatureDataset(fcAll.getFeatureSchema());
        FeatureDataset allPoly = new FeatureDataset(fcAll.getFeatureSchema());
        FeatureDataset allLine = new FeatureDataset(fcAll.getFeatureSchema());
        /*FeatureDataset allMPoint = new FeatureDataset(fcAll.getFeatureSchema());
        FeatureDataset allMPoly = new FeatureDataset(fcAll.getFeatureSchema());
        FeatureDataset allMLine = new FeatureDataset(fcAll.getFeatureSchema());*/
        Iterator it = fcAll.iterator();
        while (it.hasNext()) {
            Feature f = (Feature) it.next();
            if (f.getGeometry() instanceof Point) {
                allPoint.add(f);
            } else if (f.getGeometry() instanceof Polygon) {
                allPoly.add(f);
            } else if (f.getGeometry() instanceof LineString) {
                allLine.add(f);
            } else if (f.getGeometry() instanceof MultiPoint) {
                allPoint.add(f);
            } else if (f.getGeometry() instanceof MultiPolygon) {
                allPoly.add(f);
            } else if (f.getGeometry() instanceof MultiLineString) {
                allLine.add(f);
            } else {
                log.error("Geometry type not found: " + f.getGeometry().getClass().toString());
            }
        }
        ArrayList files = new ArrayList();
        if (allPoint.size() > 0) {
            files.addAll(writeShape(allPoint, filename + "_p.shp"));
        }
        if (allPoly.size() > 0) {
            files.addAll(writeShape(allPoly, filename + "_v.shp"));
        }
        if (allLine.size() > 0) {
            files.addAll(writeShape(allLine, filename + "_l.shp"));
        }
        /*if (allMPoint.size()>0){
        files.addAll(writeShape(allMPoint,filename+"_mp.shp"));
        }
        if (allMPoly.size()>0){
        files.addAll(writeShape(allMPoly,filename+"_mv.shp"));
        }
        if(allMLine.size()>0){
        files.addAll(writeShape(allMLine,filename+"_ml.shp"));
        } */
        return files;
    }

    /**
     * Writes a FeatureCollection to shape using the folder and the given name
     *@fc The feature collection (CAN'T have different types) 
     */
    public List writeShape(FeatureCollection fc, String shpName) throws IllegalParametersException, Exception {
        ArrayList files = new ArrayList();
        if (!shpName.endsWith(".shp")) {
            shpName += ".shp";
        }
        String name = shpName.replace(".shp", "");
        String dbfName = name + ".dbf";
        String shxName = name + ".shx";
        DriverProperties dpo = new DriverProperties(getFolder() + shpName);
        ShapefileWriter sw = new ShapefileWriter();
        sw.write(fc, dpo);
        File shpFile = new File(getFolder() + shpName);
        File dbfFile = new File(getFolder() + dbfName);
        File shxFile = new File(getFolder() + shxName);
        if (shpFile.exists()) {
            files.add(shpFile);
        }
        if (dbfFile.exists()) {
            files.add(dbfFile);
        }
        if (shxFile.exists()) {
            files.add(shxFile);
        }
        return files;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }
}
