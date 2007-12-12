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
 * Class HTTPType.
 * 
 * @version $Revision$ $Date$
 */
public class HTTPType implements java.io.Serializable {


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

    public HTTPType() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v100.HTTPType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addHTTPTypeItem
     * 
     * 
     * 
     * @param vHTTPTypeItem
     */
    public void addHTTPTypeItem(nl.b3p.xml.wfs.v100.HTTPTypeItem vHTTPTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vHTTPTypeItem);
    } //-- void addHTTPTypeItem(nl.b3p.xml.wfs.v100.HTTPTypeItem) 

    /**
     * Method addHTTPTypeItem
     * 
     * 
     * 
     * @param index
     * @param vHTTPTypeItem
     */
    public void addHTTPTypeItem(int index, nl.b3p.xml.wfs.v100.HTTPTypeItem vHTTPTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vHTTPTypeItem);
    } //-- void addHTTPTypeItem(int, nl.b3p.xml.wfs.v100.HTTPTypeItem) 

    /**
     * Method clearHTTPTypeItem
     * 
     */
    public void clearHTTPTypeItem()
    {
        _items.clear();
    } //-- void clearHTTPTypeItem() 

    /**
     * Method enumerateHTTPTypeItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateHTTPTypeItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateHTTPTypeItem() 

    /**
     * Method getHTTPTypeItem
     * 
     * 
     * 
     * @param index
     * @return HTTPTypeItem
     */
    public nl.b3p.xml.wfs.v100.HTTPTypeItem getHTTPTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v100.HTTPTypeItem) _items.get(index);
    } //-- nl.b3p.xml.wfs.v100.HTTPTypeItem getHTTPTypeItem(int) 

    /**
     * Method getHTTPTypeItem
     * 
     * 
     * 
     * @return HTTPTypeItem
     */
    public nl.b3p.xml.wfs.v100.HTTPTypeItem[] getHTTPTypeItem()
    {
        int size = _items.size();
        nl.b3p.xml.wfs.v100.HTTPTypeItem[] mArray = new nl.b3p.xml.wfs.v100.HTTPTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v100.HTTPTypeItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v100.HTTPTypeItem[] getHTTPTypeItem() 

    /**
     * Method getHTTPTypeItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getHTTPTypeItemCount()
    {
        return _items.size();
    } //-- int getHTTPTypeItemCount() 

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
     * Method removeHTTPTypeItem
     * 
     * 
     * 
     * @param vHTTPTypeItem
     * @return boolean
     */
    public boolean removeHTTPTypeItem(nl.b3p.xml.wfs.v100.HTTPTypeItem vHTTPTypeItem)
    {
        boolean removed = _items.remove(vHTTPTypeItem);
        return removed;
    } //-- boolean removeHTTPTypeItem(nl.b3p.xml.wfs.v100.HTTPTypeItem) 

    /**
     * Method setHTTPTypeItem
     * 
     * 
     * 
     * @param index
     * @param vHTTPTypeItem
     */
    public void setHTTPTypeItem(int index, nl.b3p.xml.wfs.v100.HTTPTypeItem vHTTPTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vHTTPTypeItem);
    } //-- void setHTTPTypeItem(int, nl.b3p.xml.wfs.v100.HTTPTypeItem) 

    /**
     * Method setHTTPTypeItem
     * 
     * 
     * 
     * @param HTTPTypeItemArray
     */
    public void setHTTPTypeItem(nl.b3p.xml.wfs.v100.HTTPTypeItem[] HTTPTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < HTTPTypeItemArray.length; i++) {
            _items.add(HTTPTypeItemArray[i]);
        }
    } //-- void setHTTPTypeItem(nl.b3p.xml.wfs.v100.HTTPTypeItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return HTTPType
     */
    public static nl.b3p.xml.wfs.v100.HTTPType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.HTTPType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.HTTPType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.HTTPType unmarshal(java.io.Reader) 

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
