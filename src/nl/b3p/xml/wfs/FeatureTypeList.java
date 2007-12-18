/*
 * FeatureType.java
 *
 * Created on 14 december 2007, 16:31
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package nl.b3p.xml.wfs;

/**
 *
 * @author Roy
 */
public interface FeatureTypeList {
    public int getFeatureTypeCount();
    public java.util.Enumeration enumerateFeatureType();
    public nl.b3p.xml.wfs.FeatureType getFeatureType(int index);
    public nl.b3p.xml.wfs.FeatureType[] getFeatureType();
    public void clearFeatureType();
    
}
