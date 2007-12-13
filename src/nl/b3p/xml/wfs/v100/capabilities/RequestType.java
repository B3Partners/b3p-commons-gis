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
 * Class RequestType.
 * 
 * @version $Revision$ $Date$
 */
public class RequestType implements java.io.Serializable {


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

    public RequestType() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v100.capabilities.RequestType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addRequestTypeItem
     * 
     * 
     * 
     * @param vRequestTypeItem
     */
    public void addRequestTypeItem(nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem vRequestTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vRequestTypeItem);
    } //-- void addRequestTypeItem(nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem) 

    /**
     * Method addRequestTypeItem
     * 
     * 
     * 
     * @param index
     * @param vRequestTypeItem
     */
    public void addRequestTypeItem(int index, nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem vRequestTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vRequestTypeItem);
    } //-- void addRequestTypeItem(int, nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem) 

    /**
     * Method clearRequestTypeItem
     * 
     */
    public void clearRequestTypeItem()
    {
        _items.clear();
    } //-- void clearRequestTypeItem() 

    /**
     * Method enumerateRequestTypeItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateRequestTypeItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateRequestTypeItem() 

    /**
     * Method getRequestTypeItem
     * 
     * 
     * 
     * @param index
     * @return RequestTypeItem
     */
    public nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem getRequestTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem) _items.get(index);
    } //-- nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem getRequestTypeItem(int) 

    /**
     * Method getRequestTypeItem
     * 
     * 
     * 
     * @return RequestTypeItem
     */
    public nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem[] getRequestTypeItem()
    {
        int size = _items.size();
        nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem[] mArray = new nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem[] getRequestTypeItem() 

    /**
     * Method getRequestTypeItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getRequestTypeItemCount()
    {
        return _items.size();
    } //-- int getRequestTypeItemCount() 

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
     * Method removeRequestTypeItem
     * 
     * 
     * 
     * @param vRequestTypeItem
     * @return boolean
     */
    public boolean removeRequestTypeItem(nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem vRequestTypeItem)
    {
        boolean removed = _items.remove(vRequestTypeItem);
        return removed;
    } //-- boolean removeRequestTypeItem(nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem) 

    /**
     * Method setRequestTypeItem
     * 
     * 
     * 
     * @param index
     * @param vRequestTypeItem
     */
    public void setRequestTypeItem(int index, nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem vRequestTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vRequestTypeItem);
    } //-- void setRequestTypeItem(int, nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem) 

    /**
     * Method setRequestTypeItem
     * 
     * 
     * 
     * @param requestTypeItemArray
     */
    public void setRequestTypeItem(nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem[] requestTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < requestTypeItemArray.length; i++) {
            _items.add(requestTypeItemArray[i]);
        }
    } //-- void setRequestTypeItem(nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return RequestType
     */
    public static nl.b3p.xml.wfs.v100.capabilities.RequestType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.capabilities.RequestType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.capabilities.RequestType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.capabilities.RequestType unmarshal(java.io.Reader) 

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
