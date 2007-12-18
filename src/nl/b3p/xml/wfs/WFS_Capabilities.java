/*
 * WFS_Capabilities.java
 *
 * Created on 14 december 2007, 16:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package nl.b3p.xml.wfs;

/**
 *
 * @author Roy
 */
public interface WFS_Capabilities {
    //TODO Object veranderen in interface die nog gemaakt moet worden.
    public FeatureTypeList getFeatureTypeList();
    
    public Filter_Capabilities getFilter_Capabilities();
    
    public java.lang.String getVersion();
    
    public boolean isValid();
    
    //public void setFeatureTypeList(nl.b3p.xml.wfs.FeatureTypeList featureTypeList);
    
    //public void setFilter_Capabilities(nl.b3p.xml.wfs.Filter_Capabilities filter_Capabilities);
    
        
    
}
