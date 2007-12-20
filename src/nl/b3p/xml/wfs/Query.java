/*
 * Query.java
 *
 * Created on 20 december 2007, 11:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package nl.b3p.xml.wfs;

/**
 *
 * @author Roy
 */
public interface Query {
    public java.lang.String getFeatureVersion();
    public java.lang.String getHandle();
    public boolean isValid();
    public void setFeatureVersion(java.lang.String featureVersion);
    public void setHandle(java.lang.String handle);
    public void validate()throws org.exolab.castor.xml.ValidationException;
    
}
