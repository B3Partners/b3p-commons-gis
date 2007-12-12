/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100;

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
    private nl.b3p.xml.wfs.v100.ResultFormat _resultFormat;

    /**
     * Field _DCPTypeList
     */
    private java.util.ArrayList _DCPTypeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public GetFeatureTypeType() 
     {
        super();
        _DCPTypeList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v100.GetFeatureTypeType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addDCPType
     * 
     * 
     * 
     * @param vDCPType
     */
    public void addDCPType(nl.b3p.xml.wfs.v100.DCPType vDCPType)
        throws java.lang.IndexOutOfBoundsException
    {
        _DCPTypeList.add(vDCPType);
    } //-- void addDCPType(nl.b3p.xml.wfs.v100.DCPType) 

    /**
     * Method addDCPType
     * 
     * 
     * 
     * @param index
     * @param vDCPType
     */
    public void addDCPType(int index, nl.b3p.xml.wfs.v100.DCPType vDCPType)
        throws java.lang.IndexOutOfBoundsException
    {
        _DCPTypeList.add(index, vDCPType);
    } //-- void addDCPType(int, nl.b3p.xml.wfs.v100.DCPType) 

    /**
     * Method clearDCPType
     * 
     */
    public void clearDCPType()
    {
        _DCPTypeList.clear();
    } //-- void clearDCPType() 

    /**
     * Method enumerateDCPType
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateDCPType()
    {
        return Collections.enumeration(_DCPTypeList);
    } //-- java.util.Enumeration enumerateDCPType() 

    /**
     * Method getDCPType
     * 
     * 
     * 
     * @param index
     * @return DCPType
     */
    public nl.b3p.xml.wfs.v100.DCPType getDCPType(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _DCPTypeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v100.DCPType) _DCPTypeList.get(index);
    } //-- nl.b3p.xml.wfs.v100.DCPType getDCPType(int) 

    /**
     * Method getDCPType
     * 
     * 
     * 
     * @return DCPType
     */
    public nl.b3p.xml.wfs.v100.DCPType[] getDCPType()
    {
        int size = _DCPTypeList.size();
        nl.b3p.xml.wfs.v100.DCPType[] mArray = new nl.b3p.xml.wfs.v100.DCPType[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v100.DCPType) _DCPTypeList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v100.DCPType[] getDCPType() 

    /**
     * Method getDCPTypeCount
     * 
     * 
     * 
     * @return int
     */
    public int getDCPTypeCount()
    {
        return _DCPTypeList.size();
    } //-- int getDCPTypeCount() 

    /**
     * Returns the value of field 'resultFormat'.
     * 
     * @return ResultFormat
     * @return the value of field 'resultFormat'.
     */
    public nl.b3p.xml.wfs.v100.ResultFormat getResultFormat()
    {
        return this._resultFormat;
    } //-- nl.b3p.xml.wfs.v100.ResultFormat getResultFormat() 

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
     * Method removeDCPType
     * 
     * 
     * 
     * @param vDCPType
     * @return boolean
     */
    public boolean removeDCPType(nl.b3p.xml.wfs.v100.DCPType vDCPType)
    {
        boolean removed = _DCPTypeList.remove(vDCPType);
        return removed;
    } //-- boolean removeDCPType(nl.b3p.xml.wfs.v100.DCPType) 

    /**
     * Method setDCPType
     * 
     * 
     * 
     * @param index
     * @param vDCPType
     */
    public void setDCPType(int index, nl.b3p.xml.wfs.v100.DCPType vDCPType)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _DCPTypeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _DCPTypeList.set(index, vDCPType);
    } //-- void setDCPType(int, nl.b3p.xml.wfs.v100.DCPType) 

    /**
     * Method setDCPType
     * 
     * 
     * 
     * @param DCPTypeArray
     */
    public void setDCPType(nl.b3p.xml.wfs.v100.DCPType[] DCPTypeArray)
    {
        //-- copy array
        _DCPTypeList.clear();
        for (int i = 0; i < DCPTypeArray.length; i++) {
            _DCPTypeList.add(DCPTypeArray[i]);
        }
    } //-- void setDCPType(nl.b3p.xml.wfs.v100.DCPType) 

    /**
     * Sets the value of field 'resultFormat'.
     * 
     * @param resultFormat the value of field 'resultFormat'.
     */
    public void setResultFormat(nl.b3p.xml.wfs.v100.ResultFormat resultFormat)
    {
        this._resultFormat = resultFormat;
    } //-- void setResultFormat(nl.b3p.xml.wfs.v100.ResultFormat) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return GetFeatureTypeType
     */
    public static nl.b3p.xml.wfs.v100.GetFeatureTypeType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.GetFeatureTypeType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.GetFeatureTypeType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.GetFeatureTypeType unmarshal(java.io.Reader) 

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
