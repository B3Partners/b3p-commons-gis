/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.b3p.ogc.utils.geotools;

import java.util.ArrayList;
import java.util.List;
import org.geotools.feature.AttributeTypeBuilder;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.feature.type.AttributeDescriptor;
import org.opengis.feature.type.GeometryDescriptor;

/**
 * B3partners B.V. http://www.b3partners.nl
 * @author Roy
 * Created on 10-sep-2010, 15:01:00
 */
public class Util {
    /**
     * Function to change the Geometry binding of the featureType
     */
    public static SimpleFeatureType changeGeometryBinding(SimpleFeatureType ft, Class geomBinding) {
        List<AttributeDescriptor> attributeDescriptors = new ArrayList<AttributeDescriptor>(ft.getAttributeDescriptors());
        SimpleFeatureTypeBuilder builder = new SimpleFeatureTypeBuilder();
        builder.init(ft);
        if (ft.getGeometryDescriptor() != null) {
            AttributeDescriptor gd = changeGeometryBinding(ft.getGeometryDescriptor(), geomBinding);
            attributeDescriptors.set(ft.indexOf(ft.getGeometryDescriptor().getName()), gd);
            builder.setDefaultGeometry(ft.getGeometryDescriptor().getName().getLocalPart());
            builder.setAttributes(attributeDescriptors);
        }
        SimpleFeatureType newFt = builder.buildFeatureType();
        return newFt;
    }

    /**
     * Function to change the geometryBinding of a GeometryDescriptor
     */
    public static AttributeDescriptor changeGeometryBinding(GeometryDescriptor gd, Class geomBinding) {
        AttributeTypeBuilder builder = new AttributeTypeBuilder();
        builder.init(gd);
        builder.setBinding(geomBinding);
        builder.setCRS(gd.getCoordinateReferenceSystem());
        return builder.buildDescriptor(gd.getLocalName());
    }

    /**
     * Function to rebuild the feature for shape files.
     * For example. The WFS/GML boundedBy (parsed as a jts.Envelope) can't be written.
     * Add a string to the skipAttributeNames.
     */
    public static SimpleFeature rebuildFeature(SimpleFeature feature, List<String> removeAttributeNames) {
        if (removeAttributeNames==null){
            return feature;
        }
        SimpleFeatureTypeBuilder featureTypeBuilder = new SimpleFeatureTypeBuilder();
        featureTypeBuilder.init(feature.getFeatureType());
        //new lists
        List<AttributeDescriptor> newAttributeDescriptors = new ArrayList<AttributeDescriptor>();
        List<Object> newAttributes = new ArrayList<Object>();
        //old lists
        List<Object> attributes = feature.getAttributes();
        List<AttributeDescriptor> attributeDescriptors = new ArrayList<AttributeDescriptor>(feature.getFeatureType().getAttributeDescriptors());
        //iterate over the old list
        for (int a = 0; a < attributeDescriptors.size(); a++) {
            boolean skip = false;
            for (int s = 0; s < removeAttributeNames.size() && !skip; s++) {
                if (attributeDescriptors.get(a).getLocalName().equalsIgnoreCase(removeAttributeNames.get(s))) {
                    skip = true;
                }
            }
            //if doesn't need to skip, add to new list
            if (!skip) {
                newAttributeDescriptors.add(attributeDescriptors.get(a));
                newAttributes.add(attributes.get(a));
            }
        }
        //create the new feature
        featureTypeBuilder.setAttributes(newAttributeDescriptors);

        SimpleFeatureBuilder simpleFeatureBuilder = new SimpleFeatureBuilder(featureTypeBuilder.buildFeatureType());
        return simpleFeatureBuilder.buildFeature(feature.getID(), newAttributes.toArray(new Object[newAttributes.size()]));
    }
}
