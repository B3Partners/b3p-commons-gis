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
 * Class TransactionType.
 * 
 * @version $Revision$ $Date$
 */
public class TransactionType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _DCPType_TransactionTypeList
     */
    private java.util.ArrayList _DCPType_TransactionTypeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public TransactionType() 
     {
        super();
        _DCPType_TransactionTypeList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v100.capabilities.TransactionType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addDCPType_TransactionType
     * 
     * 
     * 
     * @param vDCPType_TransactionType
     */
    public void addDCPType_TransactionType(nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType vDCPType_TransactionType)
        throws java.lang.IndexOutOfBoundsException
    {
        _DCPType_TransactionTypeList.add(vDCPType_TransactionType);
    } //-- void addDCPType_TransactionType(nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType) 

    /**
     * Method addDCPType_TransactionType
     * 
     * 
     * 
     * @param index
     * @param vDCPType_TransactionType
     */
    public void addDCPType_TransactionType(int index, nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType vDCPType_TransactionType)
        throws java.lang.IndexOutOfBoundsException
    {
        _DCPType_TransactionTypeList.add(index, vDCPType_TransactionType);
    } //-- void addDCPType_TransactionType(int, nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType) 

    /**
     * Method clearDCPType_TransactionType
     * 
     */
    public void clearDCPType_TransactionType()
    {
        _DCPType_TransactionTypeList.clear();
    } //-- void clearDCPType_TransactionType() 

    /**
     * Method enumerateDCPType_TransactionType
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateDCPType_TransactionType()
    {
        return Collections.enumeration(_DCPType_TransactionTypeList);
    } //-- java.util.Enumeration enumerateDCPType_TransactionType() 

    /**
     * Method getDCPType_TransactionType
     * 
     * 
     * 
     * @param index
     * @return DCPType_TransactionType
     */
    public nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType getDCPType_TransactionType(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _DCPType_TransactionTypeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType) _DCPType_TransactionTypeList.get(index);
    } //-- nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType getDCPType_TransactionType(int) 

    /**
     * Method getDCPType_TransactionType
     * 
     * 
     * 
     * @return DCPType_TransactionType
     */
    public nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType[] getDCPType_TransactionType()
    {
        int size = _DCPType_TransactionTypeList.size();
        nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType[] mArray = new nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType) _DCPType_TransactionTypeList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType[] getDCPType_TransactionType() 

    /**
     * Method getDCPType_TransactionTypeCount
     * 
     * 
     * 
     * @return int
     */
    public int getDCPType_TransactionTypeCount()
    {
        return _DCPType_TransactionTypeList.size();
    } //-- int getDCPType_TransactionTypeCount() 

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
     * Method removeDCPType_TransactionType
     * 
     * 
     * 
     * @param vDCPType_TransactionType
     * @return boolean
     */
    public boolean removeDCPType_TransactionType(nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType vDCPType_TransactionType)
    {
        boolean removed = _DCPType_TransactionTypeList.remove(vDCPType_TransactionType);
        return removed;
    } //-- boolean removeDCPType_TransactionType(nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType) 

    /**
     * Method setDCPType_TransactionType
     * 
     * 
     * 
     * @param index
     * @param vDCPType_TransactionType
     */
    public void setDCPType_TransactionType(int index, nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType vDCPType_TransactionType)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _DCPType_TransactionTypeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _DCPType_TransactionTypeList.set(index, vDCPType_TransactionType);
    } //-- void setDCPType_TransactionType(int, nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType) 

    /**
     * Method setDCPType_TransactionType
     * 
     * 
     * 
     * @param DCPType_TransactionTypeArray
     */
    public void setDCPType_TransactionType(nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType[] DCPType_TransactionTypeArray)
    {
        //-- copy array
        _DCPType_TransactionTypeList.clear();
        for (int i = 0; i < DCPType_TransactionTypeArray.length; i++) {
            _DCPType_TransactionTypeList.add(DCPType_TransactionTypeArray[i]);
        }
    } //-- void setDCPType_TransactionType(nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return TransactionType
     */
    public static nl.b3p.xml.wfs.v100.capabilities.TransactionType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.capabilities.TransactionType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.capabilities.TransactionType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.capabilities.TransactionType unmarshal(java.io.Reader) 

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
