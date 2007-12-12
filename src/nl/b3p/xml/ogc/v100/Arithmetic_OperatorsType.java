/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v100;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class Arithmetic_OperatorsType.
 * 
 * @version $Revision$ $Date$
 */
public class Arithmetic_OperatorsType implements java.io.Serializable {


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

    public Arithmetic_OperatorsType() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.ogc.v100.Arithmetic_OperatorsType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addArithmetic_OperatorsTypeItem
     * 
     * 
     * 
     * @param vArithmetic_OperatorsTypeItem
     */
    public void addArithmetic_OperatorsTypeItem(nl.b3p.xml.ogc.v100.Arithmetic_OperatorsTypeItem vArithmetic_OperatorsTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vArithmetic_OperatorsTypeItem);
    } //-- void addArithmetic_OperatorsTypeItem(nl.b3p.xml.ogc.v100.Arithmetic_OperatorsTypeItem) 

    /**
     * Method addArithmetic_OperatorsTypeItem
     * 
     * 
     * 
     * @param index
     * @param vArithmetic_OperatorsTypeItem
     */
    public void addArithmetic_OperatorsTypeItem(int index, nl.b3p.xml.ogc.v100.Arithmetic_OperatorsTypeItem vArithmetic_OperatorsTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vArithmetic_OperatorsTypeItem);
    } //-- void addArithmetic_OperatorsTypeItem(int, nl.b3p.xml.ogc.v100.Arithmetic_OperatorsTypeItem) 

    /**
     * Method clearArithmetic_OperatorsTypeItem
     * 
     */
    public void clearArithmetic_OperatorsTypeItem()
    {
        _items.clear();
    } //-- void clearArithmetic_OperatorsTypeItem() 

    /**
     * Method enumerateArithmetic_OperatorsTypeItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateArithmetic_OperatorsTypeItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateArithmetic_OperatorsTypeItem() 

    /**
     * Method getArithmetic_OperatorsTypeItem
     * 
     * 
     * 
     * @param index
     * @return Arithmetic_OperatorsTypeItem
     */
    public nl.b3p.xml.ogc.v100.Arithmetic_OperatorsTypeItem getArithmetic_OperatorsTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ogc.v100.Arithmetic_OperatorsTypeItem) _items.get(index);
    } //-- nl.b3p.xml.ogc.v100.Arithmetic_OperatorsTypeItem getArithmetic_OperatorsTypeItem(int) 

    /**
     * Method getArithmetic_OperatorsTypeItem
     * 
     * 
     * 
     * @return Arithmetic_OperatorsTypeItem
     */
    public nl.b3p.xml.ogc.v100.Arithmetic_OperatorsTypeItem[] getArithmetic_OperatorsTypeItem()
    {
        int size = _items.size();
        nl.b3p.xml.ogc.v100.Arithmetic_OperatorsTypeItem[] mArray = new nl.b3p.xml.ogc.v100.Arithmetic_OperatorsTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ogc.v100.Arithmetic_OperatorsTypeItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ogc.v100.Arithmetic_OperatorsTypeItem[] getArithmetic_OperatorsTypeItem() 

    /**
     * Method getArithmetic_OperatorsTypeItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getArithmetic_OperatorsTypeItemCount()
    {
        return _items.size();
    } //-- int getArithmetic_OperatorsTypeItemCount() 

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
     * Method removeArithmetic_OperatorsTypeItem
     * 
     * 
     * 
     * @param vArithmetic_OperatorsTypeItem
     * @return boolean
     */
    public boolean removeArithmetic_OperatorsTypeItem(nl.b3p.xml.ogc.v100.Arithmetic_OperatorsTypeItem vArithmetic_OperatorsTypeItem)
    {
        boolean removed = _items.remove(vArithmetic_OperatorsTypeItem);
        return removed;
    } //-- boolean removeArithmetic_OperatorsTypeItem(nl.b3p.xml.ogc.v100.Arithmetic_OperatorsTypeItem) 

    /**
     * Method setArithmetic_OperatorsTypeItem
     * 
     * 
     * 
     * @param index
     * @param vArithmetic_OperatorsTypeItem
     */
    public void setArithmetic_OperatorsTypeItem(int index, nl.b3p.xml.ogc.v100.Arithmetic_OperatorsTypeItem vArithmetic_OperatorsTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vArithmetic_OperatorsTypeItem);
    } //-- void setArithmetic_OperatorsTypeItem(int, nl.b3p.xml.ogc.v100.Arithmetic_OperatorsTypeItem) 

    /**
     * Method setArithmetic_OperatorsTypeItem
     * 
     * 
     * 
     * @param arithmetic_OperatorsTypeItemArray
     */
    public void setArithmetic_OperatorsTypeItem(nl.b3p.xml.ogc.v100.Arithmetic_OperatorsTypeItem[] arithmetic_OperatorsTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < arithmetic_OperatorsTypeItemArray.length; i++) {
            _items.add(arithmetic_OperatorsTypeItemArray[i]);
        }
    } //-- void setArithmetic_OperatorsTypeItem(nl.b3p.xml.ogc.v100.Arithmetic_OperatorsTypeItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Arithmetic_OperatorsType
     */
    public static nl.b3p.xml.ogc.v100.Arithmetic_OperatorsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v100.Arithmetic_OperatorsType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.Arithmetic_OperatorsType.class, reader);
    } //-- nl.b3p.xml.ogc.v100.Arithmetic_OperatorsType unmarshal(java.io.Reader) 

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
