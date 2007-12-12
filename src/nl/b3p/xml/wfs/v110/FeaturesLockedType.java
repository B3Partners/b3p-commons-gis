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
 * Class FeaturesLockedType.
 * 
 * @version $Revision$ $Date$
 */
public class FeaturesLockedType implements java.io.Serializable {


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

    public FeaturesLockedType() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v110.FeaturesLockedType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addFeaturesLockedTypeItem
     * 
     * 
     * 
     * @param vFeaturesLockedTypeItem
     */
    public void addFeaturesLockedTypeItem(nl.b3p.xml.wfs.v110.FeaturesLockedTypeItem vFeaturesLockedTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vFeaturesLockedTypeItem);
    } //-- void addFeaturesLockedTypeItem(nl.b3p.xml.wfs.v110.FeaturesLockedTypeItem) 

    /**
     * Method addFeaturesLockedTypeItem
     * 
     * 
     * 
     * @param index
     * @param vFeaturesLockedTypeItem
     */
    public void addFeaturesLockedTypeItem(int index, nl.b3p.xml.wfs.v110.FeaturesLockedTypeItem vFeaturesLockedTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vFeaturesLockedTypeItem);
    } //-- void addFeaturesLockedTypeItem(int, nl.b3p.xml.wfs.v110.FeaturesLockedTypeItem) 

    /**
     * Method clearFeaturesLockedTypeItem
     * 
     */
    public void clearFeaturesLockedTypeItem()
    {
        _items.clear();
    } //-- void clearFeaturesLockedTypeItem() 

    /**
     * Method enumerateFeaturesLockedTypeItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateFeaturesLockedTypeItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateFeaturesLockedTypeItem() 

    /**
     * Method getFeaturesLockedTypeItem
     * 
     * 
     * 
     * @param index
     * @return FeaturesLockedTypeItem
     */
    public nl.b3p.xml.wfs.v110.FeaturesLockedTypeItem getFeaturesLockedTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v110.FeaturesLockedTypeItem) _items.get(index);
    } //-- nl.b3p.xml.wfs.v110.FeaturesLockedTypeItem getFeaturesLockedTypeItem(int) 

    /**
     * Method getFeaturesLockedTypeItem
     * 
     * 
     * 
     * @return FeaturesLockedTypeItem
     */
    public nl.b3p.xml.wfs.v110.FeaturesLockedTypeItem[] getFeaturesLockedTypeItem()
    {
        int size = _items.size();
        nl.b3p.xml.wfs.v110.FeaturesLockedTypeItem[] mArray = new nl.b3p.xml.wfs.v110.FeaturesLockedTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v110.FeaturesLockedTypeItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v110.FeaturesLockedTypeItem[] getFeaturesLockedTypeItem() 

    /**
     * Method getFeaturesLockedTypeItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getFeaturesLockedTypeItemCount()
    {
        return _items.size();
    } //-- int getFeaturesLockedTypeItemCount() 

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
     * Method removeFeaturesLockedTypeItem
     * 
     * 
     * 
     * @param vFeaturesLockedTypeItem
     * @return boolean
     */
    public boolean removeFeaturesLockedTypeItem(nl.b3p.xml.wfs.v110.FeaturesLockedTypeItem vFeaturesLockedTypeItem)
    {
        boolean removed = _items.remove(vFeaturesLockedTypeItem);
        return removed;
    } //-- boolean removeFeaturesLockedTypeItem(nl.b3p.xml.wfs.v110.FeaturesLockedTypeItem) 

    /**
     * Method setFeaturesLockedTypeItem
     * 
     * 
     * 
     * @param index
     * @param vFeaturesLockedTypeItem
     */
    public void setFeaturesLockedTypeItem(int index, nl.b3p.xml.wfs.v110.FeaturesLockedTypeItem vFeaturesLockedTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vFeaturesLockedTypeItem);
    } //-- void setFeaturesLockedTypeItem(int, nl.b3p.xml.wfs.v110.FeaturesLockedTypeItem) 

    /**
     * Method setFeaturesLockedTypeItem
     * 
     * 
     * 
     * @param featuresLockedTypeItemArray
     */
    public void setFeaturesLockedTypeItem(nl.b3p.xml.wfs.v110.FeaturesLockedTypeItem[] featuresLockedTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < featuresLockedTypeItemArray.length; i++) {
            _items.add(featuresLockedTypeItemArray[i]);
        }
    } //-- void setFeaturesLockedTypeItem(nl.b3p.xml.wfs.v110.FeaturesLockedTypeItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return FeaturesLockedType
     */
    public static nl.b3p.xml.wfs.v110.FeaturesLockedType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.FeaturesLockedType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.FeaturesLockedType.class, reader);
    } //-- nl.b3p.xml.wfs.v110.FeaturesLockedType unmarshal(java.io.Reader) 

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
