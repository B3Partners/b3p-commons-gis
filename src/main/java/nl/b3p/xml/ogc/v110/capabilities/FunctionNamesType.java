/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v110.capabilities;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class FunctionNamesType.
 * 
 * @version $Revision$ $Date$
 */
public class FunctionNamesType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items
     */
    private java.util.ArrayList _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public FunctionNamesType() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.ogc.v110.capabilities.FunctionNamesType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addFunctionNamesTypeItem
     * 
     * 
     * 
     * @param vFunctionNamesTypeItem
     */
    public void addFunctionNamesTypeItem(nl.b3p.xml.ogc.v110.capabilities.FunctionNamesTypeItem vFunctionNamesTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vFunctionNamesTypeItem);
    } //-- void addFunctionNamesTypeItem(nl.b3p.xml.ogc.v110.capabilities.FunctionNamesTypeItem) 

    /**
     * Method addFunctionNamesTypeItem
     * 
     * 
     * 
     * @param index
     * @param vFunctionNamesTypeItem
     */
    public void addFunctionNamesTypeItem(int index, nl.b3p.xml.ogc.v110.capabilities.FunctionNamesTypeItem vFunctionNamesTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vFunctionNamesTypeItem);
    } //-- void addFunctionNamesTypeItem(int, nl.b3p.xml.ogc.v110.capabilities.FunctionNamesTypeItem) 

    /**
     * Method clearFunctionNamesTypeItem
     * 
     */
    public void clearFunctionNamesTypeItem()
    {
        _items.clear();
    } //-- void clearFunctionNamesTypeItem() 

    /**
     * Method enumerateFunctionNamesTypeItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateFunctionNamesTypeItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateFunctionNamesTypeItem() 

    /**
     * Method getFunctionNamesTypeItem
     * 
     * 
     * 
     * @param index
     * @return FunctionNamesTypeItem
     */
    public nl.b3p.xml.ogc.v110.capabilities.FunctionNamesTypeItem getFunctionNamesTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ogc.v110.capabilities.FunctionNamesTypeItem) _items.get(index);
    } //-- nl.b3p.xml.ogc.v110.capabilities.FunctionNamesTypeItem getFunctionNamesTypeItem(int) 

    /**
     * Method getFunctionNamesTypeItem
     * 
     * 
     * 
     * @return FunctionNamesTypeItem
     */
    public nl.b3p.xml.ogc.v110.capabilities.FunctionNamesTypeItem[] getFunctionNamesTypeItem()
    {
        int size = _items.size();
        nl.b3p.xml.ogc.v110.capabilities.FunctionNamesTypeItem[] mArray = new nl.b3p.xml.ogc.v110.capabilities.FunctionNamesTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ogc.v110.capabilities.FunctionNamesTypeItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ogc.v110.capabilities.FunctionNamesTypeItem[] getFunctionNamesTypeItem() 

    /**
     * Method getFunctionNamesTypeItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getFunctionNamesTypeItemCount()
    {
        return _items.size();
    } //-- int getFunctionNamesTypeItemCount() 

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
     * Method removeFunctionNamesTypeItem
     * 
     * 
     * 
     * @param vFunctionNamesTypeItem
     * @return boolean
     */
    public boolean removeFunctionNamesTypeItem(nl.b3p.xml.ogc.v110.capabilities.FunctionNamesTypeItem vFunctionNamesTypeItem)
    {
        boolean removed = _items.remove(vFunctionNamesTypeItem);
        return removed;
    } //-- boolean removeFunctionNamesTypeItem(nl.b3p.xml.ogc.v110.capabilities.FunctionNamesTypeItem) 

    /**
     * Method setFunctionNamesTypeItem
     * 
     * 
     * 
     * @param index
     * @param vFunctionNamesTypeItem
     */
    public void setFunctionNamesTypeItem(int index, nl.b3p.xml.ogc.v110.capabilities.FunctionNamesTypeItem vFunctionNamesTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vFunctionNamesTypeItem);
    } //-- void setFunctionNamesTypeItem(int, nl.b3p.xml.ogc.v110.capabilities.FunctionNamesTypeItem) 

    /**
     * Method setFunctionNamesTypeItem
     * 
     * 
     * 
     * @param functionNamesTypeItemArray
     */
    public void setFunctionNamesTypeItem(nl.b3p.xml.ogc.v110.capabilities.FunctionNamesTypeItem[] functionNamesTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < functionNamesTypeItemArray.length; i++) {
            _items.add(functionNamesTypeItemArray[i]);
        }
    } //-- void setFunctionNamesTypeItem(nl.b3p.xml.ogc.v110.capabilities.FunctionNamesTypeItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return FunctionNamesType
     */
    public static nl.b3p.xml.ogc.v110.capabilities.FunctionNamesType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v110.capabilities.FunctionNamesType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.capabilities.FunctionNamesType.class, reader);
    } //-- nl.b3p.xml.ogc.v110.capabilities.FunctionNamesType unmarshal(java.io.Reader) 

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
