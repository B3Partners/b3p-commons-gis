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
 * Class QueryTypeChoice.
 * 
 * @version $Revision$ $Date$
 */
public class QueryTypeChoice implements java.io.Serializable {


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

    public QueryTypeChoice() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v110.QueryTypeChoice()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addQueryTypeChoiceItem
     * 
     * 
     * 
     * @param vQueryTypeChoiceItem
     */
    public void addQueryTypeChoiceItem(nl.b3p.xml.wfs.v110.QueryTypeChoiceItem vQueryTypeChoiceItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vQueryTypeChoiceItem);
    } //-- void addQueryTypeChoiceItem(nl.b3p.xml.wfs.v110.QueryTypeChoiceItem) 

    /**
     * Method addQueryTypeChoiceItem
     * 
     * 
     * 
     * @param index
     * @param vQueryTypeChoiceItem
     */
    public void addQueryTypeChoiceItem(int index, nl.b3p.xml.wfs.v110.QueryTypeChoiceItem vQueryTypeChoiceItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vQueryTypeChoiceItem);
    } //-- void addQueryTypeChoiceItem(int, nl.b3p.xml.wfs.v110.QueryTypeChoiceItem) 

    /**
     * Method clearQueryTypeChoiceItem
     * 
     */
    public void clearQueryTypeChoiceItem()
    {
        _items.clear();
    } //-- void clearQueryTypeChoiceItem() 

    /**
     * Method enumerateQueryTypeChoiceItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateQueryTypeChoiceItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateQueryTypeChoiceItem() 

    /**
     * Method getQueryTypeChoiceItem
     * 
     * 
     * 
     * @param index
     * @return QueryTypeChoiceItem
     */
    public nl.b3p.xml.wfs.v110.QueryTypeChoiceItem getQueryTypeChoiceItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v110.QueryTypeChoiceItem) _items.get(index);
    } //-- nl.b3p.xml.wfs.v110.QueryTypeChoiceItem getQueryTypeChoiceItem(int) 

    /**
     * Method getQueryTypeChoiceItem
     * 
     * 
     * 
     * @return QueryTypeChoiceItem
     */
    public nl.b3p.xml.wfs.v110.QueryTypeChoiceItem[] getQueryTypeChoiceItem()
    {
        int size = _items.size();
        nl.b3p.xml.wfs.v110.QueryTypeChoiceItem[] mArray = new nl.b3p.xml.wfs.v110.QueryTypeChoiceItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v110.QueryTypeChoiceItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v110.QueryTypeChoiceItem[] getQueryTypeChoiceItem() 

    /**
     * Method getQueryTypeChoiceItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getQueryTypeChoiceItemCount()
    {
        return _items.size();
    } //-- int getQueryTypeChoiceItemCount() 

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
     * Method removeQueryTypeChoiceItem
     * 
     * 
     * 
     * @param vQueryTypeChoiceItem
     * @return boolean
     */
    public boolean removeQueryTypeChoiceItem(nl.b3p.xml.wfs.v110.QueryTypeChoiceItem vQueryTypeChoiceItem)
    {
        boolean removed = _items.remove(vQueryTypeChoiceItem);
        return removed;
    } //-- boolean removeQueryTypeChoiceItem(nl.b3p.xml.wfs.v110.QueryTypeChoiceItem) 

    /**
     * Method setQueryTypeChoiceItem
     * 
     * 
     * 
     * @param index
     * @param vQueryTypeChoiceItem
     */
    public void setQueryTypeChoiceItem(int index, nl.b3p.xml.wfs.v110.QueryTypeChoiceItem vQueryTypeChoiceItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vQueryTypeChoiceItem);
    } //-- void setQueryTypeChoiceItem(int, nl.b3p.xml.wfs.v110.QueryTypeChoiceItem) 

    /**
     * Method setQueryTypeChoiceItem
     * 
     * 
     * 
     * @param queryTypeChoiceItemArray
     */
    public void setQueryTypeChoiceItem(nl.b3p.xml.wfs.v110.QueryTypeChoiceItem[] queryTypeChoiceItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < queryTypeChoiceItemArray.length; i++) {
            _items.add(queryTypeChoiceItemArray[i]);
        }
    } //-- void setQueryTypeChoiceItem(nl.b3p.xml.wfs.v110.QueryTypeChoiceItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return QueryTypeChoice
     */
    public static nl.b3p.xml.wfs.v110.QueryTypeChoice unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.QueryTypeChoice) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.QueryTypeChoice.class, reader);
    } //-- nl.b3p.xml.wfs.v110.QueryTypeChoice unmarshal(java.io.Reader) 

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
