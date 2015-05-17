/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100.transaction;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
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
     * Field _handle
     */
    private java.lang.String _handle;

    /**
     * Field _typeName
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
     * The PropertyName element is used to specify one or more
     *  properties of a feature whose values are to be retrieved
     *  by a Web Feature Service. 
     *  
     *  While a Web Feature Service should endeavour to satisfy
     *  the exact request specified, in some instance this may
     *  not be possible. Specifically, a Web Feature Service
     *  must generate a valid GML2 response to a Query operation.
     *  The schema used to generate the output may include 
     *  properties that are mandatory. In order that the output
     *  validates, these mandatory properties must be specified
     *  in the request. If they are not, a Web Feature Service
     *  may add them automatically to the Query before processing
     *  it. Thus a client application should, in general, be
     *  prepared to receive more properties than it requested.
     * 
     *  Of course, using the DescribeFeatureType request, a client
     *  application can determine which properties are mandatory
     *  and request them in the first place.
     *  
     */
    private java.util.ArrayList _propertyNameList;

    /**
     * The Filter element is used to define spatial and/or
     * non-spatial
     *  constraints on query. Spatial constrains use GML2 to
     * specify
     *  the constraining geometry. A full description of the Filter
     *  element can be found in the Filter Encoding Implementation
     *  Specification.
     *  
     */
    private nl.b3p.xml.ogc.v100.Filter _filter;


      //----------------/
     //- Constructors -/
    //----------------/

    public QueryType() 
     {
        super();
        _propertyNameList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v100.transaction.QueryType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addPropertyName
     * 
     * 
     * 
     * @param vPropertyName
     */
    public void addPropertyName(nl.b3p.xml.ogc.v100.PropertyName vPropertyName)
        throws java.lang.IndexOutOfBoundsException
    {
        _propertyNameList.add(vPropertyName);
    } //-- void addPropertyName(nl.b3p.xml.ogc.v100.PropertyName) 

    /**
     * Method addPropertyName
     * 
     * 
     * 
     * @param index
     * @param vPropertyName
     */
    public void addPropertyName(int index, nl.b3p.xml.ogc.v100.PropertyName vPropertyName)
        throws java.lang.IndexOutOfBoundsException
    {
        _propertyNameList.add(index, vPropertyName);
    } //-- void addPropertyName(int, nl.b3p.xml.ogc.v100.PropertyName) 

    /**
     * Method clearPropertyName
     * 
     */
    public void clearPropertyName()
    {
        _propertyNameList.clear();
    } //-- void clearPropertyName() 

    /**
     * Method enumeratePropertyName
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumeratePropertyName()
    {
        return Collections.enumeration(_propertyNameList);
    } //-- java.util.Enumeration enumeratePropertyName() 

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
     * the following description: The Filter element is used to
     * define spatial and/or non-spatial
     *  constraints on query. Spatial constrains use GML2 to
     * specify
     *  the constraining geometry. A full description of the Filter
     *  element can be found in the Filter Encoding Implementation
     *  Specification.
     *  
     * 
     * @return Filter
     * @return the value of field 'filter'.
     */
    public nl.b3p.xml.ogc.v100.Filter getFilter()
    {
        return this._filter;
    } //-- nl.b3p.xml.ogc.v100.Filter getFilter() 

    /**
     * Returns the value of field 'handle'.
     * 
     * @return String
     * @return the value of field 'handle'.
     */
    public java.lang.String getHandle()
    {
        return this._handle;
    } //-- java.lang.String getHandle() 

    /**
     * Method getPropertyName
     * 
     * 
     * 
     * @param index
     * @return PropertyName
     */
    public nl.b3p.xml.ogc.v100.PropertyName getPropertyName(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _propertyNameList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ogc.v100.PropertyName) _propertyNameList.get(index);
    } //-- nl.b3p.xml.ogc.v100.PropertyName getPropertyName(int) 

    /**
     * Method getPropertyName
     * 
     * 
     * 
     * @return PropertyName
     */
    public nl.b3p.xml.ogc.v100.PropertyName[] getPropertyName()
    {
        int size = _propertyNameList.size();
        nl.b3p.xml.ogc.v100.PropertyName[] mArray = new nl.b3p.xml.ogc.v100.PropertyName[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ogc.v100.PropertyName) _propertyNameList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ogc.v100.PropertyName[] getPropertyName() 

    /**
     * Method getPropertyNameCount
     * 
     * 
     * 
     * @return int
     */
    public int getPropertyNameCount()
    {
        return _propertyNameList.size();
    } //-- int getPropertyNameCount() 

    /**
     * Returns the value of field 'typeName'.
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
     * Method removePropertyName
     * 
     * 
     * 
     * @param vPropertyName
     * @return boolean
     */
    public boolean removePropertyName(nl.b3p.xml.ogc.v100.PropertyName vPropertyName)
    {
        boolean removed = _propertyNameList.remove(vPropertyName);
        return removed;
    } //-- boolean removePropertyName(nl.b3p.xml.ogc.v100.PropertyName) 

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
     * following description: The Filter element is used to define
     * spatial and/or non-spatial
     *  constraints on query. Spatial constrains use GML2 to
     * specify
     *  the constraining geometry. A full description of the Filter
     *  element can be found in the Filter Encoding Implementation
     *  Specification.
     *  
     * 
     * @param filter the value of field 'filter'.
     */
    public void setFilter(nl.b3p.xml.ogc.v100.Filter filter)
    {
        this._filter = filter;
    } //-- void setFilter(nl.b3p.xml.ogc.v100.Filter) 

    /**
     * Sets the value of field 'handle'.
     * 
     * @param handle the value of field 'handle'.
     */
    public void setHandle(java.lang.String handle)
    {
        this._handle = handle;
    } //-- void setHandle(java.lang.String) 

    /**
     * Method setPropertyName
     * 
     * 
     * 
     * @param index
     * @param vPropertyName
     */
    public void setPropertyName(int index, nl.b3p.xml.ogc.v100.PropertyName vPropertyName)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _propertyNameList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _propertyNameList.set(index, vPropertyName);
    } //-- void setPropertyName(int, nl.b3p.xml.ogc.v100.PropertyName) 

    /**
     * Method setPropertyName
     * 
     * 
     * 
     * @param propertyNameArray
     */
    public void setPropertyName(nl.b3p.xml.ogc.v100.PropertyName[] propertyNameArray)
    {
        //-- copy array
        _propertyNameList.clear();
        for (int i = 0; i < propertyNameArray.length; i++) {
            _propertyNameList.add(propertyNameArray[i]);
        }
    } //-- void setPropertyName(nl.b3p.xml.ogc.v100.PropertyName) 

    /**
     * Sets the value of field 'typeName'.
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
    public static nl.b3p.xml.wfs.v100.transaction.QueryType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.transaction.QueryType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.transaction.QueryType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.transaction.QueryType unmarshal(java.io.Reader) 

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
