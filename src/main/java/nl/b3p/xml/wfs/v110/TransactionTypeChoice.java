/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v110;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class TransactionTypeChoice.
 * 
 * @version $Revision$ $Date$
 */
public class TransactionTypeChoice implements java.io.Serializable {


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

    public TransactionTypeChoice() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v110.TransactionTypeChoice()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addTransactionTypeChoiceItem
     * 
     * 
     * 
     * @param vTransactionTypeChoiceItem
     */
    public void addTransactionTypeChoiceItem(nl.b3p.xml.wfs.v110.TransactionTypeChoiceItem vTransactionTypeChoiceItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vTransactionTypeChoiceItem);
    } //-- void addTransactionTypeChoiceItem(nl.b3p.xml.wfs.v110.TransactionTypeChoiceItem) 

    /**
     * Method addTransactionTypeChoiceItem
     * 
     * 
     * 
     * @param index
     * @param vTransactionTypeChoiceItem
     */
    public void addTransactionTypeChoiceItem(int index, nl.b3p.xml.wfs.v110.TransactionTypeChoiceItem vTransactionTypeChoiceItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vTransactionTypeChoiceItem);
    } //-- void addTransactionTypeChoiceItem(int, nl.b3p.xml.wfs.v110.TransactionTypeChoiceItem) 

    /**
     * Method clearTransactionTypeChoiceItem
     * 
     */
    public void clearTransactionTypeChoiceItem()
    {
        _items.clear();
    } //-- void clearTransactionTypeChoiceItem() 

    /**
     * Method enumerateTransactionTypeChoiceItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateTransactionTypeChoiceItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateTransactionTypeChoiceItem() 

    /**
     * Method getTransactionTypeChoiceItem
     * 
     * 
     * 
     * @param index
     * @return TransactionTypeChoiceItem
     */
    public nl.b3p.xml.wfs.v110.TransactionTypeChoiceItem getTransactionTypeChoiceItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v110.TransactionTypeChoiceItem) _items.get(index);
    } //-- nl.b3p.xml.wfs.v110.TransactionTypeChoiceItem getTransactionTypeChoiceItem(int) 

    /**
     * Method getTransactionTypeChoiceItem
     * 
     * 
     * 
     * @return TransactionTypeChoiceItem
     */
    public nl.b3p.xml.wfs.v110.TransactionTypeChoiceItem[] getTransactionTypeChoiceItem()
    {
        int size = _items.size();
        nl.b3p.xml.wfs.v110.TransactionTypeChoiceItem[] mArray = new nl.b3p.xml.wfs.v110.TransactionTypeChoiceItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v110.TransactionTypeChoiceItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v110.TransactionTypeChoiceItem[] getTransactionTypeChoiceItem() 

    /**
     * Method getTransactionTypeChoiceItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getTransactionTypeChoiceItemCount()
    {
        return _items.size();
    } //-- int getTransactionTypeChoiceItemCount() 

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
     * Method removeTransactionTypeChoiceItem
     * 
     * 
     * 
     * @param vTransactionTypeChoiceItem
     * @return boolean
     */
    public boolean removeTransactionTypeChoiceItem(nl.b3p.xml.wfs.v110.TransactionTypeChoiceItem vTransactionTypeChoiceItem)
    {
        boolean removed = _items.remove(vTransactionTypeChoiceItem);
        return removed;
    } //-- boolean removeTransactionTypeChoiceItem(nl.b3p.xml.wfs.v110.TransactionTypeChoiceItem) 

    /**
     * Method setTransactionTypeChoiceItem
     * 
     * 
     * 
     * @param index
     * @param vTransactionTypeChoiceItem
     */
    public void setTransactionTypeChoiceItem(int index, nl.b3p.xml.wfs.v110.TransactionTypeChoiceItem vTransactionTypeChoiceItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vTransactionTypeChoiceItem);
    } //-- void setTransactionTypeChoiceItem(int, nl.b3p.xml.wfs.v110.TransactionTypeChoiceItem) 

    /**
     * Method setTransactionTypeChoiceItem
     * 
     * 
     * 
     * @param transactionTypeChoiceItemArray
     */
    public void setTransactionTypeChoiceItem(nl.b3p.xml.wfs.v110.TransactionTypeChoiceItem[] transactionTypeChoiceItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < transactionTypeChoiceItemArray.length; i++) {
            _items.add(transactionTypeChoiceItemArray[i]);
        }
    } //-- void setTransactionTypeChoiceItem(nl.b3p.xml.wfs.v110.TransactionTypeChoiceItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return TransactionTypeChoice
     */
    public static nl.b3p.xml.wfs.v110.TransactionTypeChoice unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.TransactionTypeChoice) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.TransactionTypeChoice.class, reader);
    } //-- nl.b3p.xml.wfs.v110.TransactionTypeChoice unmarshal(java.io.Reader) 

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
