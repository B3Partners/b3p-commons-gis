/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v100.capabilities;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class Function_NamesType.
 * 
 * @version $Revision$ $Date$
 */
public class Function_NamesType implements java.io.Serializable {


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

    public Function_NamesType() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.ogc.v100.capabilities.Function_NamesType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addFunction_NamesTypeItem
     * 
     * 
     * 
     * @param vFunction_NamesTypeItem
     */
    public void addFunction_NamesTypeItem(nl.b3p.xml.ogc.v100.capabilities.Function_NamesTypeItem vFunction_NamesTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vFunction_NamesTypeItem);
    } //-- void addFunction_NamesTypeItem(nl.b3p.xml.ogc.v100.capabilities.Function_NamesTypeItem) 

    /**
     * Method addFunction_NamesTypeItem
     * 
     * 
     * 
     * @param index
     * @param vFunction_NamesTypeItem
     */
    public void addFunction_NamesTypeItem(int index, nl.b3p.xml.ogc.v100.capabilities.Function_NamesTypeItem vFunction_NamesTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vFunction_NamesTypeItem);
    } //-- void addFunction_NamesTypeItem(int, nl.b3p.xml.ogc.v100.capabilities.Function_NamesTypeItem) 

    /**
     * Method clearFunction_NamesTypeItem
     * 
     */
    public void clearFunction_NamesTypeItem()
    {
        _items.clear();
    } //-- void clearFunction_NamesTypeItem() 

    /**
     * Method enumerateFunction_NamesTypeItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateFunction_NamesTypeItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateFunction_NamesTypeItem() 

    /**
     * Method getFunction_NamesTypeItem
     * 
     * 
     * 
     * @param index
     * @return Function_NamesTypeItem
     */
    public nl.b3p.xml.ogc.v100.capabilities.Function_NamesTypeItem getFunction_NamesTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ogc.v100.capabilities.Function_NamesTypeItem) _items.get(index);
    } //-- nl.b3p.xml.ogc.v100.capabilities.Function_NamesTypeItem getFunction_NamesTypeItem(int) 

    /**
     * Method getFunction_NamesTypeItem
     * 
     * 
     * 
     * @return Function_NamesTypeItem
     */
    public nl.b3p.xml.ogc.v100.capabilities.Function_NamesTypeItem[] getFunction_NamesTypeItem()
    {
        int size = _items.size();
        nl.b3p.xml.ogc.v100.capabilities.Function_NamesTypeItem[] mArray = new nl.b3p.xml.ogc.v100.capabilities.Function_NamesTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ogc.v100.capabilities.Function_NamesTypeItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ogc.v100.capabilities.Function_NamesTypeItem[] getFunction_NamesTypeItem() 

    /**
     * Method getFunction_NamesTypeItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getFunction_NamesTypeItemCount()
    {
        return _items.size();
    } //-- int getFunction_NamesTypeItemCount() 

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
     * Method removeFunction_NamesTypeItem
     * 
     * 
     * 
     * @param vFunction_NamesTypeItem
     * @return boolean
     */
    public boolean removeFunction_NamesTypeItem(nl.b3p.xml.ogc.v100.capabilities.Function_NamesTypeItem vFunction_NamesTypeItem)
    {
        boolean removed = _items.remove(vFunction_NamesTypeItem);
        return removed;
    } //-- boolean removeFunction_NamesTypeItem(nl.b3p.xml.ogc.v100.capabilities.Function_NamesTypeItem) 

    /**
     * Method setFunction_NamesTypeItem
     * 
     * 
     * 
     * @param index
     * @param vFunction_NamesTypeItem
     */
    public void setFunction_NamesTypeItem(int index, nl.b3p.xml.ogc.v100.capabilities.Function_NamesTypeItem vFunction_NamesTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vFunction_NamesTypeItem);
    } //-- void setFunction_NamesTypeItem(int, nl.b3p.xml.ogc.v100.capabilities.Function_NamesTypeItem) 

    /**
     * Method setFunction_NamesTypeItem
     * 
     * 
     * 
     * @param function_NamesTypeItemArray
     */
    public void setFunction_NamesTypeItem(nl.b3p.xml.ogc.v100.capabilities.Function_NamesTypeItem[] function_NamesTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < function_NamesTypeItemArray.length; i++) {
            _items.add(function_NamesTypeItemArray[i]);
        }
    } //-- void setFunction_NamesTypeItem(nl.b3p.xml.ogc.v100.capabilities.Function_NamesTypeItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Function_NamesType
     */
    public static nl.b3p.xml.ogc.v100.capabilities.Function_NamesType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v100.capabilities.Function_NamesType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.capabilities.Function_NamesType.class, reader);
    } //-- nl.b3p.xml.ogc.v100.capabilities.Function_NamesType unmarshal(java.io.Reader) 

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
