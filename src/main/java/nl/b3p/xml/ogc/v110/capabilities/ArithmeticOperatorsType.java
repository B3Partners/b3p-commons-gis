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
 * Class ArithmeticOperatorsType.
 * 
 * @version $Revision$ $Date$
 */
public class ArithmeticOperatorsType implements java.io.Serializable {


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

    public ArithmeticOperatorsType() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addArithmeticOperatorsTypeItem
     * 
     * 
     * 
     * @param vArithmeticOperatorsTypeItem
     */
    public void addArithmeticOperatorsTypeItem(nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsTypeItem vArithmeticOperatorsTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vArithmeticOperatorsTypeItem);
    } //-- void addArithmeticOperatorsTypeItem(nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsTypeItem) 

    /**
     * Method addArithmeticOperatorsTypeItem
     * 
     * 
     * 
     * @param index
     * @param vArithmeticOperatorsTypeItem
     */
    public void addArithmeticOperatorsTypeItem(int index, nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsTypeItem vArithmeticOperatorsTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vArithmeticOperatorsTypeItem);
    } //-- void addArithmeticOperatorsTypeItem(int, nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsTypeItem) 

    /**
     * Method clearArithmeticOperatorsTypeItem
     * 
     */
    public void clearArithmeticOperatorsTypeItem()
    {
        _items.clear();
    } //-- void clearArithmeticOperatorsTypeItem() 

    /**
     * Method enumerateArithmeticOperatorsTypeItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateArithmeticOperatorsTypeItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateArithmeticOperatorsTypeItem() 

    /**
     * Method getArithmeticOperatorsTypeItem
     * 
     * 
     * 
     * @param index
     * @return ArithmeticOperatorsTypeItem
     */
    public nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsTypeItem getArithmeticOperatorsTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsTypeItem) _items.get(index);
    } //-- nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsTypeItem getArithmeticOperatorsTypeItem(int) 

    /**
     * Method getArithmeticOperatorsTypeItem
     * 
     * 
     * 
     * @return ArithmeticOperatorsTypeItem
     */
    public nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsTypeItem[] getArithmeticOperatorsTypeItem()
    {
        int size = _items.size();
        nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsTypeItem[] mArray = new nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsTypeItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsTypeItem[] getArithmeticOperatorsTypeItem() 

    /**
     * Method getArithmeticOperatorsTypeItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getArithmeticOperatorsTypeItemCount()
    {
        return _items.size();
    } //-- int getArithmeticOperatorsTypeItemCount() 

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
     * Method removeArithmeticOperatorsTypeItem
     * 
     * 
     * 
     * @param vArithmeticOperatorsTypeItem
     * @return boolean
     */
    public boolean removeArithmeticOperatorsTypeItem(nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsTypeItem vArithmeticOperatorsTypeItem)
    {
        boolean removed = _items.remove(vArithmeticOperatorsTypeItem);
        return removed;
    } //-- boolean removeArithmeticOperatorsTypeItem(nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsTypeItem) 

    /**
     * Method setArithmeticOperatorsTypeItem
     * 
     * 
     * 
     * @param index
     * @param vArithmeticOperatorsTypeItem
     */
    public void setArithmeticOperatorsTypeItem(int index, nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsTypeItem vArithmeticOperatorsTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vArithmeticOperatorsTypeItem);
    } //-- void setArithmeticOperatorsTypeItem(int, nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsTypeItem) 

    /**
     * Method setArithmeticOperatorsTypeItem
     * 
     * 
     * 
     * @param arithmeticOperatorsTypeItemArray
     */
    public void setArithmeticOperatorsTypeItem(nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsTypeItem[] arithmeticOperatorsTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < arithmeticOperatorsTypeItemArray.length; i++) {
            _items.add(arithmeticOperatorsTypeItemArray[i]);
        }
    } //-- void setArithmeticOperatorsTypeItem(nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsTypeItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return ArithmeticOperatorsType
     */
    public static nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsType.class, reader);
    } //-- nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsType unmarshal(java.io.Reader) 

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
