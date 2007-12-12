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
 * Class Scalar_CapabilitiesType.
 * 
 * @version $Revision$ $Date$
 */
public class Scalar_CapabilitiesType implements java.io.Serializable {


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

    public Scalar_CapabilitiesType() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.ogc.v100.Scalar_CapabilitiesType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addScalar_CapabilitiesTypeItem
     * 
     * 
     * 
     * @param vScalar_CapabilitiesTypeItem
     */
    public void addScalar_CapabilitiesTypeItem(nl.b3p.xml.ogc.v100.Scalar_CapabilitiesTypeItem vScalar_CapabilitiesTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vScalar_CapabilitiesTypeItem);
    } //-- void addScalar_CapabilitiesTypeItem(nl.b3p.xml.ogc.v100.Scalar_CapabilitiesTypeItem) 

    /**
     * Method addScalar_CapabilitiesTypeItem
     * 
     * 
     * 
     * @param index
     * @param vScalar_CapabilitiesTypeItem
     */
    public void addScalar_CapabilitiesTypeItem(int index, nl.b3p.xml.ogc.v100.Scalar_CapabilitiesTypeItem vScalar_CapabilitiesTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vScalar_CapabilitiesTypeItem);
    } //-- void addScalar_CapabilitiesTypeItem(int, nl.b3p.xml.ogc.v100.Scalar_CapabilitiesTypeItem) 

    /**
     * Method clearScalar_CapabilitiesTypeItem
     * 
     */
    public void clearScalar_CapabilitiesTypeItem()
    {
        _items.clear();
    } //-- void clearScalar_CapabilitiesTypeItem() 

    /**
     * Method enumerateScalar_CapabilitiesTypeItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateScalar_CapabilitiesTypeItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateScalar_CapabilitiesTypeItem() 

    /**
     * Method getScalar_CapabilitiesTypeItem
     * 
     * 
     * 
     * @param index
     * @return Scalar_CapabilitiesTypeItem
     */
    public nl.b3p.xml.ogc.v100.Scalar_CapabilitiesTypeItem getScalar_CapabilitiesTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ogc.v100.Scalar_CapabilitiesTypeItem) _items.get(index);
    } //-- nl.b3p.xml.ogc.v100.Scalar_CapabilitiesTypeItem getScalar_CapabilitiesTypeItem(int) 

    /**
     * Method getScalar_CapabilitiesTypeItem
     * 
     * 
     * 
     * @return Scalar_CapabilitiesTypeItem
     */
    public nl.b3p.xml.ogc.v100.Scalar_CapabilitiesTypeItem[] getScalar_CapabilitiesTypeItem()
    {
        int size = _items.size();
        nl.b3p.xml.ogc.v100.Scalar_CapabilitiesTypeItem[] mArray = new nl.b3p.xml.ogc.v100.Scalar_CapabilitiesTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ogc.v100.Scalar_CapabilitiesTypeItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ogc.v100.Scalar_CapabilitiesTypeItem[] getScalar_CapabilitiesTypeItem() 

    /**
     * Method getScalar_CapabilitiesTypeItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getScalar_CapabilitiesTypeItemCount()
    {
        return _items.size();
    } //-- int getScalar_CapabilitiesTypeItemCount() 

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
     * Method removeScalar_CapabilitiesTypeItem
     * 
     * 
     * 
     * @param vScalar_CapabilitiesTypeItem
     * @return boolean
     */
    public boolean removeScalar_CapabilitiesTypeItem(nl.b3p.xml.ogc.v100.Scalar_CapabilitiesTypeItem vScalar_CapabilitiesTypeItem)
    {
        boolean removed = _items.remove(vScalar_CapabilitiesTypeItem);
        return removed;
    } //-- boolean removeScalar_CapabilitiesTypeItem(nl.b3p.xml.ogc.v100.Scalar_CapabilitiesTypeItem) 

    /**
     * Method setScalar_CapabilitiesTypeItem
     * 
     * 
     * 
     * @param index
     * @param vScalar_CapabilitiesTypeItem
     */
    public void setScalar_CapabilitiesTypeItem(int index, nl.b3p.xml.ogc.v100.Scalar_CapabilitiesTypeItem vScalar_CapabilitiesTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vScalar_CapabilitiesTypeItem);
    } //-- void setScalar_CapabilitiesTypeItem(int, nl.b3p.xml.ogc.v100.Scalar_CapabilitiesTypeItem) 

    /**
     * Method setScalar_CapabilitiesTypeItem
     * 
     * 
     * 
     * @param scalar_CapabilitiesTypeItemArray
     */
    public void setScalar_CapabilitiesTypeItem(nl.b3p.xml.ogc.v100.Scalar_CapabilitiesTypeItem[] scalar_CapabilitiesTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < scalar_CapabilitiesTypeItemArray.length; i++) {
            _items.add(scalar_CapabilitiesTypeItemArray[i]);
        }
    } //-- void setScalar_CapabilitiesTypeItem(nl.b3p.xml.ogc.v100.Scalar_CapabilitiesTypeItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Scalar_CapabilitiesType
     */
    public static nl.b3p.xml.ogc.v100.Scalar_CapabilitiesType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v100.Scalar_CapabilitiesType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.Scalar_CapabilitiesType.class, reader);
    } //-- nl.b3p.xml.ogc.v100.Scalar_CapabilitiesType unmarshal(java.io.Reader) 

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
