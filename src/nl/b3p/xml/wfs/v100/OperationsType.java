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
 * Class OperationsType.
 * 
 * @version $Revision$ $Date$
 */
public class OperationsType implements java.io.Serializable {


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

    public OperationsType() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v100.OperationsType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addOperationsTypeItem
     * 
     * 
     * 
     * @param vOperationsTypeItem
     */
    public void addOperationsTypeItem(nl.b3p.xml.wfs.v100.OperationsTypeItem vOperationsTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vOperationsTypeItem);
    } //-- void addOperationsTypeItem(nl.b3p.xml.wfs.v100.OperationsTypeItem) 

    /**
     * Method addOperationsTypeItem
     * 
     * 
     * 
     * @param index
     * @param vOperationsTypeItem
     */
    public void addOperationsTypeItem(int index, nl.b3p.xml.wfs.v100.OperationsTypeItem vOperationsTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vOperationsTypeItem);
    } //-- void addOperationsTypeItem(int, nl.b3p.xml.wfs.v100.OperationsTypeItem) 

    /**
     * Method clearOperationsTypeItem
     * 
     */
    public void clearOperationsTypeItem()
    {
        _items.clear();
    } //-- void clearOperationsTypeItem() 

    /**
     * Method enumerateOperationsTypeItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateOperationsTypeItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateOperationsTypeItem() 

    /**
     * Method getOperationsTypeItem
     * 
     * 
     * 
     * @param index
     * @return OperationsTypeItem
     */
    public nl.b3p.xml.wfs.v100.OperationsTypeItem getOperationsTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v100.OperationsTypeItem) _items.get(index);
    } //-- nl.b3p.xml.wfs.v100.OperationsTypeItem getOperationsTypeItem(int) 

    /**
     * Method getOperationsTypeItem
     * 
     * 
     * 
     * @return OperationsTypeItem
     */
    public nl.b3p.xml.wfs.v100.OperationsTypeItem[] getOperationsTypeItem()
    {
        int size = _items.size();
        nl.b3p.xml.wfs.v100.OperationsTypeItem[] mArray = new nl.b3p.xml.wfs.v100.OperationsTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v100.OperationsTypeItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v100.OperationsTypeItem[] getOperationsTypeItem() 

    /**
     * Method getOperationsTypeItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getOperationsTypeItemCount()
    {
        return _items.size();
    } //-- int getOperationsTypeItemCount() 

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
     * Method removeOperationsTypeItem
     * 
     * 
     * 
     * @param vOperationsTypeItem
     * @return boolean
     */
    public boolean removeOperationsTypeItem(nl.b3p.xml.wfs.v100.OperationsTypeItem vOperationsTypeItem)
    {
        boolean removed = _items.remove(vOperationsTypeItem);
        return removed;
    } //-- boolean removeOperationsTypeItem(nl.b3p.xml.wfs.v100.OperationsTypeItem) 

    /**
     * Method setOperationsTypeItem
     * 
     * 
     * 
     * @param index
     * @param vOperationsTypeItem
     */
    public void setOperationsTypeItem(int index, nl.b3p.xml.wfs.v100.OperationsTypeItem vOperationsTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vOperationsTypeItem);
    } //-- void setOperationsTypeItem(int, nl.b3p.xml.wfs.v100.OperationsTypeItem) 

    /**
     * Method setOperationsTypeItem
     * 
     * 
     * 
     * @param operationsTypeItemArray
     */
    public void setOperationsTypeItem(nl.b3p.xml.wfs.v100.OperationsTypeItem[] operationsTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < operationsTypeItemArray.length; i++) {
            _items.add(operationsTypeItemArray[i]);
        }
    } //-- void setOperationsTypeItem(nl.b3p.xml.wfs.v100.OperationsTypeItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return OperationsType
     */
    public static nl.b3p.xml.wfs.v100.OperationsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.OperationsType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.OperationsType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.OperationsType unmarshal(java.io.Reader) 

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
