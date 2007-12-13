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
 * Class FeaturesNotLockedType.
 * 
 * @version $Revision$ $Date$
 */
public class FeaturesNotLockedType implements java.io.Serializable {


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

    public FeaturesNotLockedType() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v110.FeaturesNotLockedType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addFeaturesNotLockedTypeItem
     * 
     * 
     * 
     * @param vFeaturesNotLockedTypeItem
     */
    public void addFeaturesNotLockedTypeItem(nl.b3p.xml.wfs.v110.FeaturesNotLockedTypeItem vFeaturesNotLockedTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vFeaturesNotLockedTypeItem);
    } //-- void addFeaturesNotLockedTypeItem(nl.b3p.xml.wfs.v110.FeaturesNotLockedTypeItem) 

    /**
     * Method addFeaturesNotLockedTypeItem
     * 
     * 
     * 
     * @param index
     * @param vFeaturesNotLockedTypeItem
     */
    public void addFeaturesNotLockedTypeItem(int index, nl.b3p.xml.wfs.v110.FeaturesNotLockedTypeItem vFeaturesNotLockedTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vFeaturesNotLockedTypeItem);
    } //-- void addFeaturesNotLockedTypeItem(int, nl.b3p.xml.wfs.v110.FeaturesNotLockedTypeItem) 

    /**
     * Method clearFeaturesNotLockedTypeItem
     * 
     */
    public void clearFeaturesNotLockedTypeItem()
    {
        _items.clear();
    } //-- void clearFeaturesNotLockedTypeItem() 

    /**
     * Method enumerateFeaturesNotLockedTypeItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateFeaturesNotLockedTypeItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateFeaturesNotLockedTypeItem() 

    /**
     * Method getFeaturesNotLockedTypeItem
     * 
     * 
     * 
     * @param index
     * @return FeaturesNotLockedTypeItem
     */
    public nl.b3p.xml.wfs.v110.FeaturesNotLockedTypeItem getFeaturesNotLockedTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v110.FeaturesNotLockedTypeItem) _items.get(index);
    } //-- nl.b3p.xml.wfs.v110.FeaturesNotLockedTypeItem getFeaturesNotLockedTypeItem(int) 

    /**
     * Method getFeaturesNotLockedTypeItem
     * 
     * 
     * 
     * @return FeaturesNotLockedTypeItem
     */
    public nl.b3p.xml.wfs.v110.FeaturesNotLockedTypeItem[] getFeaturesNotLockedTypeItem()
    {
        int size = _items.size();
        nl.b3p.xml.wfs.v110.FeaturesNotLockedTypeItem[] mArray = new nl.b3p.xml.wfs.v110.FeaturesNotLockedTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v110.FeaturesNotLockedTypeItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v110.FeaturesNotLockedTypeItem[] getFeaturesNotLockedTypeItem() 

    /**
     * Method getFeaturesNotLockedTypeItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getFeaturesNotLockedTypeItemCount()
    {
        return _items.size();
    } //-- int getFeaturesNotLockedTypeItemCount() 

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
     * Method removeFeaturesNotLockedTypeItem
     * 
     * 
     * 
     * @param vFeaturesNotLockedTypeItem
     * @return boolean
     */
    public boolean removeFeaturesNotLockedTypeItem(nl.b3p.xml.wfs.v110.FeaturesNotLockedTypeItem vFeaturesNotLockedTypeItem)
    {
        boolean removed = _items.remove(vFeaturesNotLockedTypeItem);
        return removed;
    } //-- boolean removeFeaturesNotLockedTypeItem(nl.b3p.xml.wfs.v110.FeaturesNotLockedTypeItem) 

    /**
     * Method setFeaturesNotLockedTypeItem
     * 
     * 
     * 
     * @param index
     * @param vFeaturesNotLockedTypeItem
     */
    public void setFeaturesNotLockedTypeItem(int index, nl.b3p.xml.wfs.v110.FeaturesNotLockedTypeItem vFeaturesNotLockedTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vFeaturesNotLockedTypeItem);
    } //-- void setFeaturesNotLockedTypeItem(int, nl.b3p.xml.wfs.v110.FeaturesNotLockedTypeItem) 

    /**
     * Method setFeaturesNotLockedTypeItem
     * 
     * 
     * 
     * @param featuresNotLockedTypeItemArray
     */
    public void setFeaturesNotLockedTypeItem(nl.b3p.xml.wfs.v110.FeaturesNotLockedTypeItem[] featuresNotLockedTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < featuresNotLockedTypeItemArray.length; i++) {
            _items.add(featuresNotLockedTypeItemArray[i]);
        }
    } //-- void setFeaturesNotLockedTypeItem(nl.b3p.xml.wfs.v110.FeaturesNotLockedTypeItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return FeaturesNotLockedType
     */
    public static nl.b3p.xml.wfs.v110.FeaturesNotLockedType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.FeaturesNotLockedType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.FeaturesNotLockedType.class, reader);
    } //-- nl.b3p.xml.wfs.v110.FeaturesNotLockedType unmarshal(java.io.Reader) 

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
