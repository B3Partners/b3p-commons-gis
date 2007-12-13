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
 * Class GetCapabilitiesType.
 * 
 * @version $Revision$ $Date$
 */
public class GetCapabilitiesType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _DCPType_GetCapabilitiesTypeList
     */
    private java.util.ArrayList _DCPType_GetCapabilitiesTypeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public GetCapabilitiesType() 
     {
        super();
        _DCPType_GetCapabilitiesTypeList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v100.capabilities.GetCapabilitiesType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addDCPType_GetCapabilitiesType
     * 
     * 
     * 
     * @param vDCPType_GetCapabilitiesType
     */
    public void addDCPType_GetCapabilitiesType(nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType vDCPType_GetCapabilitiesType)
        throws java.lang.IndexOutOfBoundsException
    {
        _DCPType_GetCapabilitiesTypeList.add(vDCPType_GetCapabilitiesType);
    } //-- void addDCPType_GetCapabilitiesType(nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType) 

    /**
     * Method addDCPType_GetCapabilitiesType
     * 
     * 
     * 
     * @param index
     * @param vDCPType_GetCapabilitiesType
     */
    public void addDCPType_GetCapabilitiesType(int index, nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType vDCPType_GetCapabilitiesType)
        throws java.lang.IndexOutOfBoundsException
    {
        _DCPType_GetCapabilitiesTypeList.add(index, vDCPType_GetCapabilitiesType);
    } //-- void addDCPType_GetCapabilitiesType(int, nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType) 

    /**
     * Method clearDCPType_GetCapabilitiesType
     * 
     */
    public void clearDCPType_GetCapabilitiesType()
    {
        _DCPType_GetCapabilitiesTypeList.clear();
    } //-- void clearDCPType_GetCapabilitiesType() 

    /**
     * Method enumerateDCPType_GetCapabilitiesType
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateDCPType_GetCapabilitiesType()
    {
        return Collections.enumeration(_DCPType_GetCapabilitiesTypeList);
    } //-- java.util.Enumeration enumerateDCPType_GetCapabilitiesType() 

    /**
     * Method getDCPType_GetCapabilitiesType
     * 
     * 
     * 
     * @param index
     * @return DCPType_GetCapabilitiesType
     */
    public nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType getDCPType_GetCapabilitiesType(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _DCPType_GetCapabilitiesTypeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType) _DCPType_GetCapabilitiesTypeList.get(index);
    } //-- nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType getDCPType_GetCapabilitiesType(int) 

    /**
     * Method getDCPType_GetCapabilitiesType
     * 
     * 
     * 
     * @return DCPType_GetCapabilitiesType
     */
    public nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType[] getDCPType_GetCapabilitiesType()
    {
        int size = _DCPType_GetCapabilitiesTypeList.size();
        nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType[] mArray = new nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType) _DCPType_GetCapabilitiesTypeList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType[] getDCPType_GetCapabilitiesType() 

    /**
     * Method getDCPType_GetCapabilitiesTypeCount
     * 
     * 
     * 
     * @return int
     */
    public int getDCPType_GetCapabilitiesTypeCount()
    {
        return _DCPType_GetCapabilitiesTypeList.size();
    } //-- int getDCPType_GetCapabilitiesTypeCount() 

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
     * Method removeDCPType_GetCapabilitiesType
     * 
     * 
     * 
     * @param vDCPType_GetCapabilitiesType
     * @return boolean
     */
    public boolean removeDCPType_GetCapabilitiesType(nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType vDCPType_GetCapabilitiesType)
    {
        boolean removed = _DCPType_GetCapabilitiesTypeList.remove(vDCPType_GetCapabilitiesType);
        return removed;
    } //-- boolean removeDCPType_GetCapabilitiesType(nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType) 

    /**
     * Method setDCPType_GetCapabilitiesType
     * 
     * 
     * 
     * @param index
     * @param vDCPType_GetCapabilitiesType
     */
    public void setDCPType_GetCapabilitiesType(int index, nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType vDCPType_GetCapabilitiesType)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _DCPType_GetCapabilitiesTypeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _DCPType_GetCapabilitiesTypeList.set(index, vDCPType_GetCapabilitiesType);
    } //-- void setDCPType_GetCapabilitiesType(int, nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType) 

    /**
     * Method setDCPType_GetCapabilitiesType
     * 
     * 
     * 
     * @param DCPType_GetCapabilitiesTypeArray
     */
    public void setDCPType_GetCapabilitiesType(nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType[] DCPType_GetCapabilitiesTypeArray)
    {
        //-- copy array
        _DCPType_GetCapabilitiesTypeList.clear();
        for (int i = 0; i < DCPType_GetCapabilitiesTypeArray.length; i++) {
            _DCPType_GetCapabilitiesTypeList.add(DCPType_GetCapabilitiesTypeArray[i]);
        }
    } //-- void setDCPType_GetCapabilitiesType(nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return GetCapabilitiesType
     */
    public static nl.b3p.xml.wfs.v100.capabilities.GetCapabilitiesType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.capabilities.GetCapabilitiesType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.capabilities.GetCapabilitiesType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.capabilities.GetCapabilitiesType unmarshal(java.io.Reader) 

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
