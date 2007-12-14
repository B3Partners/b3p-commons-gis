/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v110;

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
    private java.util.ArrayList _typeNameList;

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
     * Field _queryTypeChoiceList
     */
    private java.util.ArrayList _queryTypeChoiceList;

    /**
     * The Filter element is used to define spatial and/or
     * non-spatial
     *  constraints on query. Spatial constrains use GML3 to
     * specify
     *  the constraining geometry. A full description of the Filter
     *  element can be found in the Filter Encoding Implementation
     *  Specification.
     *  
     */
    private nl.b3p.xml.ogc.v110.Filter _filter;

    /**
     * The SortBy element is used specify property names whose
     *  values should be used to order (upon presentation) the
     *  set of feature instances that satisfy the query.
     *  
     */
    private nl.b3p.xml.ogc.v110.SortBy _sortBy;


      //----------------/
     //- Constructors -/
    //----------------/

    public QueryType() 
     {
        super();
        _typeNameList = new java.util.ArrayList();
        _queryTypeChoiceList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v110.QueryType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addQueryTypeChoice
     * 
     * 
     * 
     * @param vQueryTypeChoice
     */
    public void addQueryTypeChoice(nl.b3p.xml.wfs.v110.QueryTypeChoice vQueryTypeChoice)
        throws java.lang.IndexOutOfBoundsException
    {
        _queryTypeChoiceList.add(vQueryTypeChoice);
    } //-- void addQueryTypeChoice(nl.b3p.xml.wfs.v110.QueryTypeChoice) 

    /**
     * Method addQueryTypeChoice
     * 
     * 
     * 
     * @param index
     * @param vQueryTypeChoice
     */
    public void addQueryTypeChoice(int index, nl.b3p.xml.wfs.v110.QueryTypeChoice vQueryTypeChoice)
        throws java.lang.IndexOutOfBoundsException
    {
        _queryTypeChoiceList.add(index, vQueryTypeChoice);
    } //-- void addQueryTypeChoice(int, nl.b3p.xml.wfs.v110.QueryTypeChoice) 

    /**
     * Method addTypeName
     * 
     * 
     * 
     * @param vTypeName
     */
    public void addTypeName(java.lang.String vTypeName)
        throws java.lang.IndexOutOfBoundsException
    {
        _typeNameList.add(vTypeName);
    } //-- void addTypeName(java.lang.String) 

    /**
     * Method addTypeName
     * 
     * 
     * 
     * @param index
     * @param vTypeName
     */
    public void addTypeName(int index, java.lang.String vTypeName)
        throws java.lang.IndexOutOfBoundsException
    {
        _typeNameList.add(index, vTypeName);
    } //-- void addTypeName(int, java.lang.String) 

    /**
     * Method clearQueryTypeChoice
     * 
     */
    public void clearQueryTypeChoice()
    {
        _queryTypeChoiceList.clear();
    } //-- void clearQueryTypeChoice() 

    /**
     * Method clearTypeName
     * 
     */
    public void clearTypeName()
    {
        _typeNameList.clear();
    } //-- void clearTypeName() 

    /**
     * Method enumerateQueryTypeChoice
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateQueryTypeChoice()
    {
        return Collections.enumeration(_queryTypeChoiceList);
    } //-- java.util.Enumeration enumerateQueryTypeChoice() 

    /**
     * Method enumerateTypeName
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateTypeName()
    {
        return Collections.enumeration(_typeNameList);
    } //-- java.util.Enumeration enumerateTypeName() 

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
     *  constraints on query. Spatial constrains use GML3 to
     * specify
     *  the constraining geometry. A full description of the Filter
     *  element can be found in the Filter Encoding Implementation
     *  Specification.
     *  
     * 
     * @return Filter
     * @return the value of field 'filter'.
     */
    public nl.b3p.xml.ogc.v110.Filter getFilter()
    {
        return this._filter;
    } //-- nl.b3p.xml.ogc.v110.Filter getFilter() 

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
     * Method getQueryTypeChoice
     * 
     * 
     * 
     * @param index
     * @return QueryTypeChoice
     */
    public nl.b3p.xml.wfs.v110.QueryTypeChoice getQueryTypeChoice(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _queryTypeChoiceList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v110.QueryTypeChoice) _queryTypeChoiceList.get(index);
    } //-- nl.b3p.xml.wfs.v110.QueryTypeChoice getQueryTypeChoice(int) 

    /**
     * Method getQueryTypeChoice
     * 
     * 
     * 
     * @return QueryTypeChoice
     */
    public nl.b3p.xml.wfs.v110.QueryTypeChoice[] getQueryTypeChoice()
    {
        int size = _queryTypeChoiceList.size();
        nl.b3p.xml.wfs.v110.QueryTypeChoice[] mArray = new nl.b3p.xml.wfs.v110.QueryTypeChoice[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v110.QueryTypeChoice) _queryTypeChoiceList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v110.QueryTypeChoice[] getQueryTypeChoice() 

    /**
     * Method getQueryTypeChoiceCount
     * 
     * 
     * 
     * @return int
     */
    public int getQueryTypeChoiceCount()
    {
        return _queryTypeChoiceList.size();
    } //-- int getQueryTypeChoiceCount() 

    /**
     * Returns the value of field 'sortBy'. The field 'sortBy' has
     * the following description: The SortBy element is used
     * specify property names whose
     *  values should be used to order (upon presentation) the
     *  set of feature instances that satisfy the query.
     *  
     * 
     * @return SortBy
     * @return the value of field 'sortBy'.
     */
    public nl.b3p.xml.ogc.v110.SortBy getSortBy()
    {
        return this._sortBy;
    } //-- nl.b3p.xml.ogc.v110.SortBy getSortBy() 

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
     * Method getTypeName
     * 
     * 
     * 
     * @param index
     * @return String
     */
    public java.lang.String getTypeName(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _typeNameList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_typeNameList.get(index);
    } //-- java.lang.String getTypeName(int) 

    /**
     * Method getTypeName
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String[] getTypeName()
    {
        int size = _typeNameList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_typeNameList.get(index);
        }
        return mArray;
    } //-- java.lang.String[] getTypeName() 

    /**
     * Method getTypeNameCount
     * 
     * 
     * 
     * @return int
     */
    public int getTypeNameCount()
    {
        return _typeNameList.size();
    } //-- int getTypeNameCount() 

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
     * Method removeQueryTypeChoice
     * 
     * 
     * 
     * @param vQueryTypeChoice
     * @return boolean
     */
    public boolean removeQueryTypeChoice(nl.b3p.xml.wfs.v110.QueryTypeChoice vQueryTypeChoice)
    {
        boolean removed = _queryTypeChoiceList.remove(vQueryTypeChoice);
        return removed;
    } //-- boolean removeQueryTypeChoice(nl.b3p.xml.wfs.v110.QueryTypeChoice) 

    /**
     * Method removeTypeName
     * 
     * 
     * 
     * @param vTypeName
     * @return boolean
     */
    public boolean removeTypeName(java.lang.String vTypeName)
    {
        boolean removed = _typeNameList.remove(vTypeName);
        return removed;
    } //-- boolean removeTypeName(java.lang.String) 

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
     *  constraints on query. Spatial constrains use GML3 to
     * specify
     *  the constraining geometry. A full description of the Filter
     *  element can be found in the Filter Encoding Implementation
     *  Specification.
     *  
     * 
     * @param filter the value of field 'filter'.
     */
    public void setFilter(nl.b3p.xml.ogc.v110.Filter filter)
    {
        this._filter = filter;
    } //-- void setFilter(nl.b3p.xml.ogc.v110.Filter) 

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
     * Method setQueryTypeChoice
     * 
     * 
     * 
     * @param index
     * @param vQueryTypeChoice
     */
    public void setQueryTypeChoice(int index, nl.b3p.xml.wfs.v110.QueryTypeChoice vQueryTypeChoice)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _queryTypeChoiceList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _queryTypeChoiceList.set(index, vQueryTypeChoice);
    } //-- void setQueryTypeChoice(int, nl.b3p.xml.wfs.v110.QueryTypeChoice) 

    /**
     * Method setQueryTypeChoice
     * 
     * 
     * 
     * @param queryTypeChoiceArray
     */
    public void setQueryTypeChoice(nl.b3p.xml.wfs.v110.QueryTypeChoice[] queryTypeChoiceArray)
    {
        //-- copy array
        _queryTypeChoiceList.clear();
        for (int i = 0; i < queryTypeChoiceArray.length; i++) {
            _queryTypeChoiceList.add(queryTypeChoiceArray[i]);
        }
    } //-- void setQueryTypeChoice(nl.b3p.xml.wfs.v110.QueryTypeChoice) 

    /**
     * Sets the value of field 'sortBy'. The field 'sortBy' has the
     * following description: The SortBy element is used specify
     * property names whose
     *  values should be used to order (upon presentation) the
     *  set of feature instances that satisfy the query.
     *  
     * 
     * @param sortBy the value of field 'sortBy'.
     */
    public void setSortBy(nl.b3p.xml.ogc.v110.SortBy sortBy)
    {
        this._sortBy = sortBy;
    } //-- void setSortBy(nl.b3p.xml.ogc.v110.SortBy) 

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
     * Method setTypeName
     * 
     * 
     * 
     * @param index
     * @param vTypeName
     */
    public void setTypeName(int index, java.lang.String vTypeName)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _typeNameList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _typeNameList.set(index, vTypeName);
    } //-- void setTypeName(int, java.lang.String) 

    /**
     * Method setTypeName
     * 
     * 
     * 
     * @param typeNameArray
     */
    public void setTypeName(java.lang.String[] typeNameArray)
    {
        //-- copy array
        _typeNameList.clear();
        for (int i = 0; i < typeNameArray.length; i++) {
            _typeNameList.add(typeNameArray[i]);
        }
    } //-- void setTypeName(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return QueryType
     */
    public static nl.b3p.xml.wfs.v110.QueryType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.QueryType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.QueryType.class, reader);
    } //-- nl.b3p.xml.wfs.v110.QueryType unmarshal(java.io.Reader) 

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
