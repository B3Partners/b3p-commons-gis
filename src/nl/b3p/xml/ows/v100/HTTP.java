/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Connect point URLs for the HTTP Distributed Computing Platform
 * (DCP). Normally, only one Get and/or one Post is included in
 * this element. More than one Get and/or Post is allowed to
 * support including alternative URLs for uses such as load
 * balancing or backup. 
 * 
 * @version $Revision$ $Date$
 */
public class HTTP implements java.io.Serializable {


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

    public HTTP() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.HTTP()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addHTTPItem
     * 
     * 
     * 
     * @param vHTTPItem
     */
    public void addHTTPItem(nl.b3p.xml.ows.v100.HTTPItem vHTTPItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vHTTPItem);
    } //-- void addHTTPItem(nl.b3p.xml.ows.v100.HTTPItem) 

    /**
     * Method addHTTPItem
     * 
     * 
     * 
     * @param index
     * @param vHTTPItem
     */
    public void addHTTPItem(int index, nl.b3p.xml.ows.v100.HTTPItem vHTTPItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vHTTPItem);
    } //-- void addHTTPItem(int, nl.b3p.xml.ows.v100.HTTPItem) 

    /**
     * Method clearHTTPItem
     * 
     */
    public void clearHTTPItem()
    {
        _items.clear();
    } //-- void clearHTTPItem() 

    /**
     * Method enumerateHTTPItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateHTTPItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateHTTPItem() 

    /**
     * Method getHTTPItem
     * 
     * 
     * 
     * @param index
     * @return HTTPItem
     */
    public nl.b3p.xml.ows.v100.HTTPItem getHTTPItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.HTTPItem) _items.get(index);
    } //-- nl.b3p.xml.ows.v100.HTTPItem getHTTPItem(int) 

    /**
     * Method getHTTPItem
     * 
     * 
     * 
     * @return HTTPItem
     */
    public nl.b3p.xml.ows.v100.HTTPItem[] getHTTPItem()
    {
        int size = _items.size();
        nl.b3p.xml.ows.v100.HTTPItem[] mArray = new nl.b3p.xml.ows.v100.HTTPItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.HTTPItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.HTTPItem[] getHTTPItem() 

    /**
     * Method getHTTPItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getHTTPItemCount()
    {
        return _items.size();
    } //-- int getHTTPItemCount() 

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
     * Method removeHTTPItem
     * 
     * 
     * 
     * @param vHTTPItem
     * @return boolean
     */
    public boolean removeHTTPItem(nl.b3p.xml.ows.v100.HTTPItem vHTTPItem)
    {
        boolean removed = _items.remove(vHTTPItem);
        return removed;
    } //-- boolean removeHTTPItem(nl.b3p.xml.ows.v100.HTTPItem) 

    /**
     * Method setHTTPItem
     * 
     * 
     * 
     * @param index
     * @param vHTTPItem
     */
    public void setHTTPItem(int index, nl.b3p.xml.ows.v100.HTTPItem vHTTPItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vHTTPItem);
    } //-- void setHTTPItem(int, nl.b3p.xml.ows.v100.HTTPItem) 

    /**
     * Method setHTTPItem
     * 
     * 
     * 
     * @param HTTPItemArray
     */
    public void setHTTPItem(nl.b3p.xml.ows.v100.HTTPItem[] HTTPItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < HTTPItemArray.length; i++) {
            _items.add(HTTPItemArray[i]);
        }
    } //-- void setHTTPItem(nl.b3p.xml.ows.v100.HTTPItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return HTTP
     */
    public static nl.b3p.xml.ows.v100.HTTP unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.HTTP) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.HTTP.class, reader);
    } //-- nl.b3p.xml.ows.v100.HTTP unmarshal(java.io.Reader) 

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
