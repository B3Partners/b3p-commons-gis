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

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * The Query element is of type QueryType.
 *  
 * 
 * @version $Revision$ $Date$
 */
public class QueryType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The handle attribute allows a client application
     *  to assign a client-generated identifier for the 
     *  Query. The handle is included to facilitate error
     *  reporting. If one Query in a GetFeature request
     *  causes an exception, a WFS may report the handle
     *  to indicate which query element failed. If the a
     *  handle is not present, the WFS may use other means
     *  to localize the error (e.g. line numbers).
     *  
     */
    private java.lang.String _handle;

    /**
     * The typeName attribute is a list of one or more
     *  feature type names that indicate which types 
     *  of feature instances should be included in the
     *  reponse set. Specifying more than one typename
     *  indicates that a join operation is being performed.
     *  All the names in the typeName list must be valid
     *  types that belong to this query's feature content
     *  as defined by the GML Application Schema.
     *  
     */
    private java.lang.String _typeName;

    /**
     * For systems that implement versioning, the featureVersion
     *  attribute is used to specify which version of a particular
     *  feature instance is to be retrieved. A value of ALL means
     *  that all versions should be retrieved. An integer value
     *  'i', means that the ith version should be retrieve if it
     *  exists or the most recent version otherwise.
     *  
     */
    private java.lang.String _featureVersion;

    /**
     * This attribute is used to specify a specific WFS-supported
     * SRS
     *  that should be used for returned feature geometries. The
     * value
     *  may be the WFS StorageSRS value, DefaultRetrievalSRS value,
     * or
     *  one of AdditionalSRS values. If no srsName value is
     * supplied,
     *  then the features will be returned using either the
     *  DefaultRetrievalSRS, if specified, and StorageSRS
     * otherwise.
     *  For feature types with no spatial properties, this
     * attribute
     *  must not be specified or ignored if it is specified.
     *  
     */
    private java.lang.String _srsName;

    /**
     * Filter
     */
    private java.lang.Object _filter;


      //----------------/
     //- Constructors -/
    //----------------/

    public QueryType() 
     {
        super();
    } //-- nl.b3p.ogc.wfs.v110.QueryType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'featureVersion'. The field
     * 'featureVersion' has the following description: For systems
     * that implement versioning, the featureVersion
     *  attribute is used to specify which version of a particular
     *  feature instance is to be retrieved. A value of ALL means
     *  that all versions should be retrieved. An integer value
     *  'i', means that the ith version should be retrieve if it
     *  exists or the most recent version otherwise.
     *  
     * 
     * @return String
     * @return the value of field 'featureVersion'.
     */
    public java.lang.String getFeatureVersion()
    {
        return this._featureVersion;
    } //-- java.lang.String getFeatureVersion() 

    /**
     * Returns the value of field 'filter'. The field 'filter' has
     * the following description: Filter
     * 
     * @return Object
     * @return the value of field 'filter'.
     */
    public java.lang.Object getFilter()
    {
        return this._filter;
    } //-- java.lang.Object getFilter() 

    /**
     * Returns the value of field 'handle'. The field 'handle' has
     * the following description: The handle attribute allows a
     * client application
     *  to assign a client-generated identifier for the 
     *  Query. The handle is included to facilitate error
     *  reporting. If one Query in a GetFeature request
     *  causes an exception, a WFS may report the handle
     *  to indicate which query element failed. If the a
     *  handle is not present, the WFS may use other means
     *  to localize the error (e.g. line numbers).
     *  
     * 
     * @return String
     * @return the value of field 'handle'.
     */
    public java.lang.String getHandle()
    {
        return this._handle;
    } //-- java.lang.String getHandle() 

    /**
     * Returns the value of field 'srsName'. The field 'srsName'
     * has the following description: This attribute is used to
     * specify a specific WFS-supported SRS
     *  that should be used for returned feature geometries. The
     * value
     *  may be the WFS StorageSRS value, DefaultRetrievalSRS value,
     * or
     *  one of AdditionalSRS values. If no srsName value is
     * supplied,
     *  then the features will be returned using either the
     *  DefaultRetrievalSRS, if specified, and StorageSRS
     * otherwise.
     *  For feature types with no spatial properties, this
     * attribute
     *  must not be specified or ignored if it is specified.
     *  
     * 
     * @return String
     * @return the value of field 'srsName'.
     */
    public java.lang.String getSrsName()
    {
        return this._srsName;
    } //-- java.lang.String getSrsName() 

    /**
     * Returns the value of field 'typeName'. The field 'typeName'
     * has the following description: The typeName attribute is a
     * list of one or more
     *  feature type names that indicate which types 
     *  of feature instances should be included in the
     *  reponse set. Specifying more than one typename
     *  indicates that a join operation is being performed.
     *  All the names in the typeName list must be valid
     *  types that belong to this query's feature content
     *  as defined by the GML Application Schema.
     *  
     * 
     * @return String
     * @return the value of field 'typeName'.
     */
    public java.lang.String getTypeName()
    {
        return this._typeName;
    } //-- java.lang.String getTypeName() 

    /**
     * Method isValid
     * 
     * 
     * 
     * @return boolean
     */
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * Method marshal
     * 
     * 
     * 
     * @param out
     */
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * Method marshal
     * 
     * 
     * 
     * @param handler
     */
    public void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Sets the value of field 'featureVersion'. The field
     * 'featureVersion' has the following description: For systems
     * that implement versioning, the featureVersion
     *  attribute is used to specify which version of a particular
     *  feature instance is to be retrieved. A value of ALL means
     *  that all versions should be retrieved. An integer value
     *  'i', means that the ith version should be retrieve if it
     *  exists or the most recent version otherwise.
     *  
     * 
     * @param featureVersion the value of field 'featureVersion'.
     */
    public void setFeatureVersion(java.lang.String featureVersion)
    {
        this._featureVersion = featureVersion;
    } //-- void setFeatureVersion(java.lang.String) 

    /**
     * Sets the value of field 'filter'. The field 'filter' has the
     * following description: Filter
     * 
     * @param filter the value of field 'filter'.
     */
    public void setFilter(java.lang.Object filter)
    {
        this._filter = filter;
    } //-- void setFilter(java.lang.Object) 

    /**
     * Sets the value of field 'handle'. The field 'handle' has the
     * following description: The handle attribute allows a client
     * application
     *  to assign a client-generated identifier for the 
     *  Query. The handle is included to facilitate error
     *  reporting. If one Query in a GetFeature request
     *  causes an exception, a WFS may report the handle
     *  to indicate which query element failed. If the a
     *  handle is not present, the WFS may use other means
     *  to localize the error (e.g. line numbers).
     *  
     * 
     * @param handle the value of field 'handle'.
     */
    public void setHandle(java.lang.String handle)
    {
        this._handle = handle;
    } //-- void setHandle(java.lang.String) 

    /**
     * Sets the value of field 'srsName'. The field 'srsName' has
     * the following description: This attribute is used to specify
     * a specific WFS-supported SRS
     *  that should be used for returned feature geometries. The
     * value
     *  may be the WFS StorageSRS value, DefaultRetrievalSRS value,
     * or
     *  one of AdditionalSRS values. If no srsName value is
     * supplied,
     *  then the features will be returned using either the
     *  DefaultRetrievalSRS, if specified, and StorageSRS
     * otherwise.
     *  For feature types with no spatial properties, this
     * attribute
     *  must not be specified or ignored if it is specified.
     *  
     * 
     * @param srsName the value of field 'srsName'.
     */
    public void setSrsName(java.lang.String srsName)
    {
        this._srsName = srsName;
    } //-- void setSrsName(java.lang.String) 

    /**
     * Sets the value of field 'typeName'. The field 'typeName' has
     * the following description: The typeName attribute is a list
     * of one or more
     *  feature type names that indicate which types 
     *  of feature instances should be included in the
     *  reponse set. Specifying more than one typename
     *  indicates that a join operation is being performed.
     *  All the names in the typeName list must be valid
     *  types that belong to this query's feature content
     *  as defined by the GML Application Schema.
     *  
     * 
     * @param typeName the value of field 'typeName'.
     */
    public void setTypeName(java.lang.String typeName)
    {
        this._typeName = typeName;
    } //-- void setTypeName(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return QueryType
     */
    public static nl.b3p.ogc.wfs.v110.QueryType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.ogc.wfs.v110.QueryType) Unmarshaller.unmarshal(nl.b3p.ogc.wfs.v110.QueryType.class, reader);
    } //-- nl.b3p.ogc.wfs.v110.QueryType unmarshal(java.io.Reader) 

    /**
     * Method validate
     * 
     */
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
