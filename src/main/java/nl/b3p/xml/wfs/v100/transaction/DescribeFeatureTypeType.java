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
 * The DescribeFeatureType operation allows a client application
 *  to request that a Web Feature Service describe one or more
 *  feature types. A Web Feature Service must be able to generate
 *  feature descriptions as valid GML2 application schemas.
 * 
 *  The schemas generated by the DescribeFeatureType operation can
 *  be used by a client application to validate the output.
 * 
 *  Feature instances within the WFS interface must be specified
 *  using GML2. The schema of feature instances specified within
 *  the WFS interface must validate against the feature schemas 
 *  generated by the DescribeFeatureType request.
 *  
 * 
 * @version $Revision$ $Date$
 */
public class DescribeFeatureTypeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _version
     */
    private java.lang.String _version = "1.0.0";

    /**
     * Field _service
     */
    private java.lang.String _service = "WFS";

    /**
     * The outputFormat attribute is used to specify what schema
     *  description language should be used to describe features.
     *  The default value of XMLSCHEMA means that the Web Feature
     *  Service must generate a GML2 application schema that can
     *  be used to validate the GML2 output of a GetFeature request
     *  or feature instances specified in Transaction operations.
     *  
     */
    private java.lang.String _outputFormat = "XMLSCHEMA";

    /**
     * The TypeName element is used to enumerate the feature types
     *  to be described. If no TypeName elements are specified
     *  then all features should be described.
     *  
     */
    private java.util.ArrayList _typeNameList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DescribeFeatureTypeType() 
     {
        super();
        setVersion("1.0.0");
        setService("WFS");
        setOutputFormat("XMLSCHEMA");
        _typeNameList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v100.transaction.DescribeFeatureTypeType()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Method clearTypeName
     * 
     */
    public void clearTypeName()
    {
        _typeNameList.clear();
    } //-- void clearTypeName() 

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
     * Returns the value of field 'outputFormat'. The field
     * 'outputFormat' has the following description: The
     * outputFormat attribute is used to specify what schema
     *  description language should be used to describe features.
     *  The default value of XMLSCHEMA means that the Web Feature
     *  Service must generate a GML2 application schema that can
     *  be used to validate the GML2 output of a GetFeature request
     *  or feature instances specified in Transaction operations.
     *  
     * 
     * @return String
     * @return the value of field 'outputFormat'.
     */
    public java.lang.String getOutputFormat()
    {
        return this._outputFormat;
    } //-- java.lang.String getOutputFormat() 

    /**
     * Returns the value of field 'service'.
     * 
     * @return String
     * @return the value of field 'service'.
     */
    public java.lang.String getService()
    {
        return this._service;
    } //-- java.lang.String getService() 

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
     * Returns the value of field 'version'.
     * 
     * @return String
     * @return the value of field 'version'.
     */
    public java.lang.String getVersion()
    {
        return this._version;
    } //-- java.lang.String getVersion() 

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
     * Sets the value of field 'outputFormat'. The field
     * 'outputFormat' has the following description: The
     * outputFormat attribute is used to specify what schema
     *  description language should be used to describe features.
     *  The default value of XMLSCHEMA means that the Web Feature
     *  Service must generate a GML2 application schema that can
     *  be used to validate the GML2 output of a GetFeature request
     *  or feature instances specified in Transaction operations.
     *  
     * 
     * @param outputFormat the value of field 'outputFormat'.
     */
    public void setOutputFormat(java.lang.String outputFormat)
    {
        this._outputFormat = outputFormat;
    } //-- void setOutputFormat(java.lang.String) 

    /**
     * Sets the value of field 'service'.
     * 
     * @param service the value of field 'service'.
     */
    public void setService(java.lang.String service)
    {
        this._service = service;
    } //-- void setService(java.lang.String) 

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
     * Sets the value of field 'version'.
     * 
     * @param version the value of field 'version'.
     */
    public void setVersion(java.lang.String version)
    {
        this._version = version;
    } //-- void setVersion(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return DescribeFeatureTypeType
     */
    public static nl.b3p.xml.wfs.v100.transaction.DescribeFeatureTypeType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.transaction.DescribeFeatureTypeType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.transaction.DescribeFeatureTypeType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.transaction.DescribeFeatureTypeType unmarshal(java.io.Reader) 

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
