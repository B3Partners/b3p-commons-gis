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
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */
package nl.b3p.ogc.wfs.v110;

/**
 * XML encoded WFS operation request base, for all operations
 *  except GetCapabilities.
 *  
 * 
 * @version $Revision$ $Date$
 */
public abstract class BaseRequestType implements java.io.Serializable {
    //--------------------------/
    //- Class/Member Variables -/
    //--------------------------/
    /**
     * The service attribute is included to support service 
     *  endpoints that implement more than one OGC service.
     *  For example, a single CGI that implements WMS, WFS
     *  and WCS services. 
     *  The endpoint can inspect the value of this attribute 
     *  to figure out which service should process the request.
     *  The value WFS indicates that a web feature service should
     *  process the request.
     *  This parameter is somewhat redundant in the XML encoding
     *  since the request namespace can be used to determine
     *  which service should process any give request. For example,
     *  wfs:GetCapabilities and easily be distinguished from
     *  wcs:GetCapabilities using the namespaces.
     *  
     */
    private java.lang.String _service = "WFS";
    /**
     * The version attribute is used to indicate the version of the
     *  WFS specification that a request conforms to. All requests
     * in
     *  this schema conform to V1.1 of the WFS specification.
     *  For WFS implementations that support more than one version
     * of
     *  a WFS sepcification ... if the version attribute is not 
     *  specified then the service should assume that the request
     *  conforms to greatest available specification version.
     *  
     */
    private java.lang.String _version = "1.1.0";
    /**
     * The handle attribute allows a client application
     *  to assign a client-generated request identifier
     *  to a WFS request. The handle is included to
     *  facilitate error reporting. A WFS may report the
     *  handle in an exception report to identify the
     *  offending request or action. If the handle is not
     *  present, then the WFS may employ other means to
     *  localize the error (e.g. line numbers).
     *  
     */
    private java.lang.String _handle;
    //----------------/
    //- Constructors -/
    //----------------/
    public BaseRequestType() {
        super();
        setService("WFS");
        setVersion("1.1.0");
    } //-- nl.b3p.ogc.wfs.v110.BaseRequestType()


    //-----------/
    //- Methods -/
    //-----------/
    /**
     * Returns the value of field 'handle'. The field 'handle' has
     * the following description: The handle attribute allows a
     * client application
     *  to assign a client-generated request identifier
     *  to a WFS request. The handle is included to
     *  facilitate error reporting. A WFS may report the
     *  handle in an exception report to identify the
     *  offending request or action. If the handle is not
     *  present, then the WFS may employ other means to
     *  localize the error (e.g. line numbers).
     *  
     * 
     * @return String
     * @return the value of field 'handle'.
     */
    public java.lang.String getHandle() {
        return this._handle;
    } //-- java.lang.String getHandle() 

    /**
     * Returns the value of field 'service'. The field 'service'
     * has the following description: The service attribute is
     * included to support service 
     *  endpoints that implement more than one OGC service.
     *  For example, a single CGI that implements WMS, WFS
     *  and WCS services. 
     *  The endpoint can inspect the value of this attribute 
     *  to figure out which service should process the request.
     *  The value WFS indicates that a web feature service should
     *  process the request.
     *  This parameter is somewhat redundant in the XML encoding
     *  since the request namespace can be used to determine
     *  which service should process any give request. For example,
     *  wfs:GetCapabilities and easily be distinguished from
     *  wcs:GetCapabilities using the namespaces.
     *  
     * 
     * @return String
     * @return the value of field 'service'.
     */
    public java.lang.String getService() {
        return this._service;
    } //-- java.lang.String getService() 

    /**
     * Returns the value of field 'version'. The field 'version'
     * has the following description: The version attribute is used
     * to indicate the version of the
     *  WFS specification that a request conforms to. All requests
     * in
     *  this schema conform to V1.1 of the WFS specification.
     *  For WFS implementations that support more than one version
     * of
     *  a WFS sepcification ... if the version attribute is not 
     *  specified then the service should assume that the request
     *  conforms to greatest available specification version.
     *  
     * 
     * @return String
     * @return the value of field 'version'.
     */
    public java.lang.String getVersion() {
        return this._version;
    } //-- java.lang.String getVersion() 

    /**
     * Method isValid
     * 
     * 
     * 
     * @return boolean
     */
    public boolean isValid() {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * Sets the value of field 'handle'. The field 'handle' has the
     * following description: The handle attribute allows a client
     * application
     *  to assign a client-generated request identifier
     *  to a WFS request. The handle is included to
     *  facilitate error reporting. A WFS may report the
     *  handle in an exception report to identify the
     *  offending request or action. If the handle is not
     *  present, then the WFS may employ other means to
     *  localize the error (e.g. line numbers).
     *  
     * 
     * @param handle the value of field 'handle'.
     */
    public void setHandle(java.lang.String handle) {
        this._handle = handle;
    } //-- void setHandle(java.lang.String) 

    /**
     * Sets the value of field 'service'. The field 'service' has
     * the following description: The service attribute is included
     * to support service 
     *  endpoints that implement more than one OGC service.
     *  For example, a single CGI that implements WMS, WFS
     *  and WCS services. 
     *  The endpoint can inspect the value of this attribute 
     *  to figure out which service should process the request.
     *  The value WFS indicates that a web feature service should
     *  process the request.
     *  This parameter is somewhat redundant in the XML encoding
     *  since the request namespace can be used to determine
     *  which service should process any give request. For example,
     *  wfs:GetCapabilities and easily be distinguished from
     *  wcs:GetCapabilities using the namespaces.
     *  
     * 
     * @param service the value of field 'service'.
     */
    public void setService(java.lang.String service) {
        this._service = service;
    } //-- void setService(java.lang.String) 

    /**
     * Sets the value of field 'version'. The field 'version' has
     * the following description: The version attribute is used to
     * indicate the version of the
     *  WFS specification that a request conforms to. All requests
     * in
     *  this schema conform to V1.1 of the WFS specification.
     *  For WFS implementations that support more than one version
     * of
     *  a WFS sepcification ... if the version attribute is not 
     *  specified then the service should assume that the request
     *  conforms to greatest available specification version.
     *  
     * 
     * @param version the value of field 'version'.
     */
    public void setVersion(java.lang.String version) {
        this._version = version;
    } //-- void setVersion(java.lang.String) 

    /**
     * Method validate
     * 
     */
    public void validate()
            throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 
}
