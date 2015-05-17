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
 * Class Id_CapabilitiesType.
 * 
 * @version $Revision$ $Date$
 */
public class Id_CapabilitiesType implements java.io.Serializable {


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

    public Id_CapabilitiesType() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addId_CapabilitiesTypeItem
     * 
     * 
     * 
     * @param vId_CapabilitiesTypeItem
     */
    public void addId_CapabilitiesTypeItem(nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesTypeItem vId_CapabilitiesTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vId_CapabilitiesTypeItem);
    } //-- void addId_CapabilitiesTypeItem(nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesTypeItem) 

    /**
     * Method addId_CapabilitiesTypeItem
     * 
     * 
     * 
     * @param index
     * @param vId_CapabilitiesTypeItem
     */
    public void addId_CapabilitiesTypeItem(int index, nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesTypeItem vId_CapabilitiesTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vId_CapabilitiesTypeItem);
    } //-- void addId_CapabilitiesTypeItem(int, nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesTypeItem) 

    /**
     * Method clearId_CapabilitiesTypeItem
     * 
     */
    public void clearId_CapabilitiesTypeItem()
    {
        _items.clear();
    } //-- void clearId_CapabilitiesTypeItem() 

    /**
     * Method enumerateId_CapabilitiesTypeItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateId_CapabilitiesTypeItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateId_CapabilitiesTypeItem() 

    /**
     * Method getId_CapabilitiesTypeItem
     * 
     * 
     * 
     * @param index
     * @return Id_CapabilitiesTypeItem
     */
    public nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesTypeItem getId_CapabilitiesTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesTypeItem) _items.get(index);
    } //-- nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesTypeItem getId_CapabilitiesTypeItem(int) 

    /**
     * Method getId_CapabilitiesTypeItem
     * 
     * 
     * 
     * @return Id_CapabilitiesTypeItem
     */
    public nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesTypeItem[] getId_CapabilitiesTypeItem()
    {
        int size = _items.size();
        nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesTypeItem[] mArray = new nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesTypeItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesTypeItem[] getId_CapabilitiesTypeItem() 

    /**
     * Method getId_CapabilitiesTypeItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getId_CapabilitiesTypeItemCount()
    {
        return _items.size();
    } //-- int getId_CapabilitiesTypeItemCount() 

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
     * Method removeId_CapabilitiesTypeItem
     * 
     * 
     * 
     * @param vId_CapabilitiesTypeItem
     * @return boolean
     */
    public boolean removeId_CapabilitiesTypeItem(nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesTypeItem vId_CapabilitiesTypeItem)
    {
        boolean removed = _items.remove(vId_CapabilitiesTypeItem);
        return removed;
    } //-- boolean removeId_CapabilitiesTypeItem(nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesTypeItem) 

    /**
     * Method setId_CapabilitiesTypeItem
     * 
     * 
     * 
     * @param index
     * @param vId_CapabilitiesTypeItem
     */
    public void setId_CapabilitiesTypeItem(int index, nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesTypeItem vId_CapabilitiesTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vId_CapabilitiesTypeItem);
    } //-- void setId_CapabilitiesTypeItem(int, nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesTypeItem) 

    /**
     * Method setId_CapabilitiesTypeItem
     * 
     * 
     * 
     * @param id_CapabilitiesTypeItemArray
     */
    public void setId_CapabilitiesTypeItem(nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesTypeItem[] id_CapabilitiesTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < id_CapabilitiesTypeItemArray.length; i++) {
            _items.add(id_CapabilitiesTypeItemArray[i]);
        }
    } //-- void setId_CapabilitiesTypeItem(nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesTypeItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Id_CapabilitiesType
     */
    public static nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesType.class, reader);
    } //-- nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesType unmarshal(java.io.Reader) 

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
