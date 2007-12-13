/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100.capabilities;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class FeatureTypeListType.
 * 
 * @version $Revision$ $Date$
 */
public class FeatureTypeListType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _operations_FeatureTypeListType
     */
    private nl.b3p.xml.wfs.v100.capabilities.Operations_FeatureTypeListType _operations_FeatureTypeListType;

    /**
     * Field _featureTypeList
     */
    private java.util.ArrayList _featureTypeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public FeatureTypeListType() 
     {
        super();
        _featureTypeList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v100.capabilities.FeatureTypeListType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addFeatureType
     * 
     * 
     * 
     * @param vFeatureType
     */
    public void addFeatureType(nl.b3p.xml.wfs.v100.capabilities.FeatureType vFeatureType)
        throws java.lang.IndexOutOfBoundsException
    {
        _featureTypeList.add(vFeatureType);
    } //-- void addFeatureType(nl.b3p.xml.wfs.v100.capabilities.FeatureType) 

    /**
     * Method addFeatureType
     * 
     * 
     * 
     * @param index
     * @param vFeatureType
     */
    public void addFeatureType(int index, nl.b3p.xml.wfs.v100.capabilities.FeatureType vFeatureType)
        throws java.lang.IndexOutOfBoundsException
    {
        _featureTypeList.add(index, vFeatureType);
    } //-- void addFeatureType(int, nl.b3p.xml.wfs.v100.capabilities.FeatureType) 

    /**
     * Method clearFeatureType
     * 
     */
    public void clearFeatureType()
    {
        _featureTypeList.clear();
    } //-- void clearFeatureType() 

    /**
     * Method enumerateFeatureType
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateFeatureType()
    {
        return Collections.enumeration(_featureTypeList);
    } //-- java.util.Enumeration enumerateFeatureType() 

    /**
     * Method getFeatureType
     * 
     * 
     * 
     * @param index
     * @return FeatureType
     */
    public nl.b3p.xml.wfs.v100.capabilities.FeatureType getFeatureType(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _featureTypeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v100.capabilities.FeatureType) _featureTypeList.get(index);
    } //-- nl.b3p.xml.wfs.v100.capabilities.FeatureType getFeatureType(int) 

    /**
     * Method getFeatureType
     * 
     * 
     * 
     * @return FeatureType
     */
    public nl.b3p.xml.wfs.v100.capabilities.FeatureType[] getFeatureType()
    {
        int size = _featureTypeList.size();
        nl.b3p.xml.wfs.v100.capabilities.FeatureType[] mArray = new nl.b3p.xml.wfs.v100.capabilities.FeatureType[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v100.capabilities.FeatureType) _featureTypeList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v100.capabilities.FeatureType[] getFeatureType() 

    /**
     * Method getFeatureTypeCount
     * 
     * 
     * 
     * @return int
     */
    public int getFeatureTypeCount()
    {
        return _featureTypeList.size();
    } //-- int getFeatureTypeCount() 

    /**
     * Returns the value of field 'operations_FeatureTypeListType'.
     * 
     * @return Operations_FeatureTypeListType
     * @return the value of field 'operations_FeatureTypeListType'.
     */
    public nl.b3p.xml.wfs.v100.capabilities.Operations_FeatureTypeListType getOperations_FeatureTypeListType()
    {
        return this._operations_FeatureTypeListType;
    } //-- nl.b3p.xml.wfs.v100.capabilities.Operations_FeatureTypeListType getOperations_FeatureTypeListType() 

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
     * Method removeFeatureType
     * 
     * 
     * 
     * @param vFeatureType
     * @return boolean
     */
    public boolean removeFeatureType(nl.b3p.xml.wfs.v100.capabilities.FeatureType vFeatureType)
    {
        boolean removed = _featureTypeList.remove(vFeatureType);
        return removed;
    } //-- boolean removeFeatureType(nl.b3p.xml.wfs.v100.capabilities.FeatureType) 

    /**
     * Method setFeatureType
     * 
     * 
     * 
     * @param index
     * @param vFeatureType
     */
    public void setFeatureType(int index, nl.b3p.xml.wfs.v100.capabilities.FeatureType vFeatureType)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _featureTypeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _featureTypeList.set(index, vFeatureType);
    } //-- void setFeatureType(int, nl.b3p.xml.wfs.v100.capabilities.FeatureType) 

    /**
     * Method setFeatureType
     * 
     * 
     * 
     * @param featureTypeArray
     */
    public void setFeatureType(nl.b3p.xml.wfs.v100.capabilities.FeatureType[] featureTypeArray)
    {
        //-- copy array
        _featureTypeList.clear();
        for (int i = 0; i < featureTypeArray.length; i++) {
            _featureTypeList.add(featureTypeArray[i]);
        }
    } //-- void setFeatureType(nl.b3p.xml.wfs.v100.capabilities.FeatureType) 

    /**
     * Sets the value of field 'operations_FeatureTypeListType'.
     * 
     * @param operations_FeatureTypeListType the value of field
     * 'operations_FeatureTypeListType'.
     */
    public void setOperations_FeatureTypeListType(nl.b3p.xml.wfs.v100.capabilities.Operations_FeatureTypeListType operations_FeatureTypeListType)
    {
        this._operations_FeatureTypeListType = operations_FeatureTypeListType;
    } //-- void setOperations_FeatureTypeListType(nl.b3p.xml.wfs.v100.capabilities.Operations_FeatureTypeListType) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return FeatureTypeListType
     */
    public static nl.b3p.xml.wfs.v100.capabilities.FeatureTypeListType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.capabilities.FeatureTypeListType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.capabilities.FeatureTypeListType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.capabilities.FeatureTypeListType unmarshal(java.io.Reader) 

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
