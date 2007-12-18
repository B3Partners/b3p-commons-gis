/*
 * FeatureType.java
 *
 * Created on 17 december 2007, 12:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package nl.b3p.xml.wfs;

/**
 *
 * @author Roy
 */
public interface FeatureType {
    public void clearMetadataURL();
    public java.lang.String getAbstract();
    public nl.b3p.xml.wfs.MetadataURL getMetadataURL(int index);
    public nl.b3p.xml.wfs.MetadataURL[] getMetadataURL();
    public int getMetadataURLCount();
    public java.lang.String getName();
    public java.lang.String getTitle();
    public nl.b3p.xml.wfs.Operations_FeatureTypeType getOperations_FeatureTypeType();
    public boolean isValid();
    
    //setters:
    public void setName(java.lang.String name);
    public void setTitle(java.lang.String title);
    
}
