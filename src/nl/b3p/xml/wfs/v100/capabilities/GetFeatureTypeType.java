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
 * Class GetFeatureTypeType.
 * 
 * @version $Revision$ $Date$
 */
public class GetFeatureTypeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _resultFormat
     */
    private nl.b3p.xml.wfs.v100.capabilities.ResultFormat _resultFormat;

    /**
     * Field _DCPType_FeatureTypeTypeList
     */
    private java.util.ArrayList _DCPType_FeatureTypeTypeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public GetFeatureTypeType() 
     {
        super();
        _DCPType_FeatureTypeTypeList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v100.capabilities.GetFeatureTypeType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addDCPType_FeatureTypeType
     * 
     * 
     * 
     * @param vDCPType_FeatureTypeType
     */
    public void addDCPType_FeatureTypeType(nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType vDCPType_FeatureTypeType)
        throws java.lang.IndexOutOfBoundsException
    {
        _DCPType_FeatureTypeTypeList.add(vDCPType_FeatureTypeType);
    } //-- void addDCPType_FeatureTypeType(nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType) 

    /**
     * Method addDCPType_FeatureTypeType
     * 
     * 
     * 
     * @param index
     * @param vDCPType_FeatureTypeType
     */
    public void addDCPType_FeatureTypeType(int index, nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType vDCPType_FeatureTypeType)
        throws java.lang.IndexOutOfBoundsException
    {
        _DCPType_FeatureTypeTypeList.add(index, vDCPType_FeatureTypeType);
    } //-- void addDCPType_FeatureTypeType(int, nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType) 

    /**
     * Method clearDCPType_FeatureTypeType
     * 
     */
    public void clearDCPType_FeatureTypeType()
    {
        _DCPType_FeatureTypeTypeList.clear();
    } //-- void clearDCPType_FeatureTypeType() 

    /**
     * Method enumerateDCPType_FeatureTypeType
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateDCPType_FeatureTypeType()
    {
        return Collections.enumeration(_DCPType_FeatureTypeTypeList);
    } //-- java.util.Enumeration enumerateDCPType_FeatureTypeType() 

    /**
     * Method getDCPType_FeatureTypeType
     * 
     * 
     * 
     * @param index
     * @return DCPType_FeatureTypeType
     */
    public nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType getDCPType_FeatureTypeType(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _DCPType_FeatureTypeTypeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType) _DCPType_FeatureTypeTypeList.get(index);
    } //-- nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType getDCPType_FeatureTypeType(int) 

    /**
     * Method getDCPType_FeatureTypeType
     * 
     * 
     * 
     * @return DCPType_FeatureTypeType
     */
    public nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType[] getDCPType_FeatureTypeType()
    {
        int size = _DCPType_FeatureTypeTypeList.size();
        nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType[] mArray = new nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType) _DCPType_FeatureTypeTypeList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType[] getDCPType_FeatureTypeType() 

    /**
     * Method getDCPType_FeatureTypeTypeCount
     * 
     * 
     * 
     * @return int
     */
    public int getDCPType_FeatureTypeTypeCount()
    {
        return _DCPType_FeatureTypeTypeList.size();
    } //-- int getDCPType_FeatureTypeTypeCount() 

    /**
     * Returns the value of field 'resultFormat'.
     * 
     * @return ResultFormat
     * @return the value of field 'resultFormat'.
     */
    public nl.b3p.xml.wfs.v100.capabilities.ResultFormat getResultFormat()
    {
        return this._resultFormat;
    } //-- nl.b3p.xml.wfs.v100.capabilities.ResultFormat getResultFormat() 

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
     * Method removeDCPType_FeatureTypeType
     * 
     * 
     * 
     * @param vDCPType_FeatureTypeType
     * @return boolean
     */
    public boolean removeDCPType_FeatureTypeType(nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType vDCPType_FeatureTypeType)
    {
        boolean removed = _DCPType_FeatureTypeTypeList.remove(vDCPType_FeatureTypeType);
        return removed;
    } //-- boolean removeDCPType_FeatureTypeType(nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType) 

    /**
     * Method setDCPType_FeatureTypeType
     * 
     * 
     * 
     * @param index
     * @param vDCPType_FeatureTypeType
     */
    public void setDCPType_FeatureTypeType(int index, nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType vDCPType_FeatureTypeType)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _DCPType_FeatureTypeTypeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _DCPType_FeatureTypeTypeList.set(index, vDCPType_FeatureTypeType);
    } //-- void setDCPType_FeatureTypeType(int, nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType) 

    /**
     * Method setDCPType_FeatureTypeType
     * 
     * 
     * 
     * @param DCPType_FeatureTypeTypeArray
     */
    public void setDCPType_FeatureTypeType(nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType[] DCPType_FeatureTypeTypeArray)
    {
        //-- copy array
        _DCPType_FeatureTypeTypeList.clear();
        for (int i = 0; i < DCPType_FeatureTypeTypeArray.length; i++) {
            _DCPType_FeatureTypeTypeList.add(DCPType_FeatureTypeTypeArray[i]);
        }
    } //-- void setDCPType_FeatureTypeType(nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType) 

    /**
     * Sets the value of field 'resultFormat'.
     * 
     * @param resultFormat the value of field 'resultFormat'.
     */
    public void setResultFormat(nl.b3p.xml.wfs.v100.capabilities.ResultFormat resultFormat)
    {
        this._resultFormat = resultFormat;
    } //-- void setResultFormat(nl.b3p.xml.wfs.v100.capabilities.ResultFormat) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return GetFeatureTypeType
     */
    public static nl.b3p.xml.wfs.v100.capabilities.GetFeatureTypeType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.capabilities.GetFeatureTypeType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.capabilities.GetFeatureTypeType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.capabilities.GetFeatureTypeType unmarshal(java.io.Reader) 

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
