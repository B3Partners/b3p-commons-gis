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
import com.vividsolutions.jump.feature.FeatureDataset;
import com.vividsolutions.jump.io.DriverProperties;
import com.vividsolutions.jump.io.IllegalParametersException;
import com.vividsolutions.jump.io.ShapefileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.geotools.data.DefaultTransaction;
import org.geotools.data.FeatureStore;
import org.geotools.data.Transaction;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.shapefile.ShapefileDataStoreFactory;
import org.geotools.feature.DefaultFeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.feature.type.FeatureType;

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
     * @deprecated
     */
    public List writeToShape(com.vividsolutions.jump.feature.FeatureCollection fcAll, String filename) throws IllegalParametersException, Exception {
        FeatureDataset allPoint = new FeatureDataset(fcAll.getFeatureSchema());
        FeatureDataset allPoly = new FeatureDataset(fcAll.getFeatureSchema());
        FeatureDataset allLine = new FeatureDataset(fcAll.getFeatureSchema());
        /*FeatureDataset allMPoint = new FeatureDataset(fcAll.getFeatureSchema());
        FeatureDataset allMPoly = new FeatureDataset(fcAll.getFeatureSchema());
        FeatureDataset allMLine = new FeatureDataset(fcAll.getFeatureSchema());*/
        Iterator it = fcAll.iterator();
        while (it.hasNext()) {
            com.vividsolutions.jump.feature.Feature f = (com.vividsolutions.jump.feature.Feature) it.next();
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
     * writes the featurecollection to shapefiles. Use this function if the features in the featurecollection CAN be different types.
     *@fcAll The feature collection (can have different types)
     *@filename The filename to use bij writing the shape file.
     *
     *@return a list of file's of type java.io.File
     */
    public List writeToShape(org.geotools.feature.FeatureCollection fcAll, String filename, Boolean spatialIndex) throws IllegalParametersException, Exception {
        DefaultFeatureCollection allPoint = new DefaultFeatureCollection(null,(SimpleFeatureType)fcAll.getSchema());
        DefaultFeatureCollection allPoly = new DefaultFeatureCollection(null,(SimpleFeatureType)fcAll.getSchema());
        DefaultFeatureCollection allLine = new DefaultFeatureCollection(null,(SimpleFeatureType)fcAll.getSchema());
        /*FeatureDataset allMPoint = new FeatureDataset(fcAll.getFeatureSchema());
        FeatureDataset allMPoly = new FeatureDataset(fcAll.getFeatureSchema());
        FeatureDataset allMLine = new FeatureDataset(fcAll.getFeatureSchema());*/
        FeatureIterator it = fcAll.features();
        while (it.hasNext()) {
            SimpleFeature f = (SimpleFeature) it.next();
            if (f.getDefaultGeometry() instanceof Point) {
                allPoint.add((SimpleFeature) f);
            } else if (f.getDefaultGeometry() instanceof Polygon) {
                allPoly.add(f);
            } else if (f.getDefaultGeometry() instanceof LineString) {
                allLine.add(f);
            } else if (f.getDefaultGeometry() instanceof MultiPoint) {
                allPoint.add(f);
            } else if (f.getDefaultGeometry() instanceof MultiPolygon) {
                allPoly.add(f);
            } else if (f.getDefaultGeometry() instanceof MultiLineString) {
                allLine.add(f);
            } else if(f.getDefaultGeometry()==null) {
                log.info("No default geometry set.");
            }else{
                log.error("Geometry type not found: " + f.getDefaultGeometry().getClass().toString());
            }
        }
        ArrayList files = new ArrayList();
        if (allPoint.size() > 0) {
            files.addAll(writeShape(allPoint, filename + "_p.shp",spatialIndex));
        }
        if (allPoly.size() > 0) {
            files.addAll(writeShape(allPoly, filename + "_v.shp",spatialIndex));
        }
        if (allLine.size() > 0) {
            files.addAll(writeShape(allLine, filename + "_l.shp",spatialIndex));
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
     * @param fc The feature collection (CAN'T have different types)
     * @param shpName the name of the shape file.
     */
    public List writeShape(DefaultFeatureCollection fc, String shpName,Boolean spatialIndex) throws IOException {
        ArrayList files = new ArrayList();
        if (!shpName.endsWith(".shp")) {
            shpName += ".shp";
        }
        File newShape=new File(getFolder()+shpName);
        boolean created=newShape.createNewFile();
        ShapefileDataStoreFactory factory = new ShapefileDataStoreFactory();
        Map map = new HashMap();
        map.put(ShapefileDataStoreFactory.URLP.key, newShape.toURI().toURL());
        map.put(ShapefileDataStoreFactory.CREATE_SPATIAL_INDEX.key, spatialIndex);

        ShapefileDataStore ds =(ShapefileDataStore) factory.createNewDataStore(map);
        FeatureType ft= fc.getSchema();
        ds.createSchema((SimpleFeatureType) ft);
        Transaction transaction = new DefaultTransaction("create");

        String typeName = ds.getTypeNames()[0];
        FeatureStore fs=(FeatureStore) ds.getFeatureSource(typeName);
        try{
            fs.addFeatures(fc);
            transaction.commit();
        }catch(Exception ex){
            log.error("Error writing shape file. ",ex);
        }finally{
            transaction.close();
            ds.dispose();
        }
        String name = shpName.replace(".shp", "");
        File shpFile = new File(getFolder() + shpName);
        File dbfFile = new File(getFolder() + name + ".dbf");
        File shxFile = new File(getFolder() + name + ".shx");
        if (shpFile.exists()) {
            files.add(shpFile);
        }
        if (dbfFile.exists()) {
            files.add(dbfFile);
        }
        if (shxFile.exists()) {
            files.add(dbfFile);
        }
        return files;
    }

    /**
     * Writes a FeatureCollection to shape using the folder and the given name
     * @param fc The feature collection (CAN'T have different types)
     * @param shpName the name of the shape file.
     * @deprecated Use the writeShape with a GeoTools FeatureCollection
     */
    public List writeShape(com.vividsolutions.jump.feature.FeatureCollection fc, String shpName) throws IllegalParametersException, Exception {
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
