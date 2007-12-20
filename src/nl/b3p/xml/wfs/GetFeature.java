/*
 * GetFeature.java
 *
 * Created on 20 december 2007, 11:29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package nl.b3p.xml.wfs;

/**
 *
 * @author Roy
 */
public interface GetFeature {
    public void clearQuery();
    public void deleteMaxFeatures();
    public java.util.Enumeration enumerateQuery();
    public int getMaxFeatures();
    public java.lang.String getService();    
    public java.lang.String getOutputFormat();     
    public int getQueryCount();        
    public java.lang.String getVersion();
    public boolean hasMaxFeatures();
    public boolean isValid();
    
   
    public void setMaxFeatures(int maxFeatures);
    public void setService(java.lang.String service);
    public void setOutputFormat(java.lang.String outputFormat);
    public void setVersion(java.lang.String version);
    public void validate()throws org.exolab.castor.xml.ValidationException;
    
}
