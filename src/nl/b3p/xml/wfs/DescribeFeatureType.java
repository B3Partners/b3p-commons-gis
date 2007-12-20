/*
 * DescribeFeatureType.java
 *
 * Created on 20 december 2007, 10:46
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package nl.b3p.xml.wfs;

/**
 *
 * @author Roy
 */
public interface DescribeFeatureType {
     public void addTypeName(java.lang.String vTypeName);
     public void addTypeName(int index, java.lang.String vTypeName);
     public void clearTypeName();
     public java.util.Enumeration enumerateTypeName();
     public java.lang.String getService();
     public java.lang.String getOutputFormat();
     public java.lang.String getTypeName(int index);
     public java.lang.String[] getTypeName();
     public int getTypeNameCount();
     public java.lang.String getVersion();
     public boolean isValid();
     
     public boolean removeTypeName(java.lang.String vTypeName);
     public void setService(java.lang.String service);
     public void setOutputFormat(java.lang.String outputFormat);
     public void setTypeName(int index, java.lang.String vTypeName);
     public void setTypeName(java.lang.String[] typeNameArray);
     public void setVersion(java.lang.String version);
     
}
