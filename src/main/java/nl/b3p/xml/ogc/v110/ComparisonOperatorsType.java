/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v110;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class ComparisonOperatorsType.
 * 
 * @version $Revision$ $Date$
 */
public class ComparisonOperatorsType implements java.io.Serializable {


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

    public ComparisonOperatorsType() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.ogc.v110.ComparisonOperatorsType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addComparisonOperatorsTypeItem
     * 
     * 
     * 
     * @param vComparisonOperatorsTypeItem
     */
    public void addComparisonOperatorsTypeItem(nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem vComparisonOperatorsTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vComparisonOperatorsTypeItem);
    } //-- void addComparisonOperatorsTypeItem(nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem) 

    /**
     * Method addComparisonOperatorsTypeItem
     * 
     * 
     * 
     * @param index
     * @param vComparisonOperatorsTypeItem
     */
    public void addComparisonOperatorsTypeItem(int index, nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem vComparisonOperatorsTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vComparisonOperatorsTypeItem);
    } //-- void addComparisonOperatorsTypeItem(int, nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem) 

    /**
     * Method clearComparisonOperatorsTypeItem
     * 
     */
    public void clearComparisonOperatorsTypeItem()
    {
        _items.clear();
    } //-- void clearComparisonOperatorsTypeItem() 

    /**
     * Method enumerateComparisonOperatorsTypeItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateComparisonOperatorsTypeItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateComparisonOperatorsTypeItem() 

    /**
     * Method getComparisonOperatorsTypeItem
     * 
     * 
     * 
     * @param index
     * @return ComparisonOperatorsTypeItem
     */
    public nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem getComparisonOperatorsTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem) _items.get(index);
    } //-- nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem getComparisonOperatorsTypeItem(int) 

    /**
     * Method getComparisonOperatorsTypeItem
     * 
     * 
     * 
     * @return ComparisonOperatorsTypeItem
     */
    public nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem[] getComparisonOperatorsTypeItem()
    {
        int size = _items.size();
        nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem[] mArray = new nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem[] getComparisonOperatorsTypeItem() 

    /**
     * Method getComparisonOperatorsTypeItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getComparisonOperatorsTypeItemCount()
    {
        return _items.size();
    } //-- int getComparisonOperatorsTypeItemCount() 

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
     * Method removeComparisonOperatorsTypeItem
     * 
     * 
     * 
     * @param vComparisonOperatorsTypeItem
     * @return boolean
     */
    public boolean removeComparisonOperatorsTypeItem(nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem vComparisonOperatorsTypeItem)
    {
        boolean removed = _items.remove(vComparisonOperatorsTypeItem);
        return removed;
    } //-- boolean removeComparisonOperatorsTypeItem(nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem) 

    /**
     * Method setComparisonOperatorsTypeItem
     * 
     * 
     * 
     * @param index
     * @param vComparisonOperatorsTypeItem
     */
    public void setComparisonOperatorsTypeItem(int index, nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem vComparisonOperatorsTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vComparisonOperatorsTypeItem);
    } //-- void setComparisonOperatorsTypeItem(int, nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem) 

    /**
     * Method setComparisonOperatorsTypeItem
     * 
     * 
     * 
     * @param comparisonOperatorsTypeItemArray
     */
    public void setComparisonOperatorsTypeItem(nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem[] comparisonOperatorsTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < comparisonOperatorsTypeItemArray.length; i++) {
            _items.add(comparisonOperatorsTypeItemArray[i]);
        }
    } //-- void setComparisonOperatorsTypeItem(nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return ComparisonOperatorsType
     */
    public static nl.b3p.xml.ogc.v110.ComparisonOperatorsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v110.ComparisonOperatorsType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.ComparisonOperatorsType.class, reader);
    } //-- nl.b3p.xml.ogc.v110.ComparisonOperatorsType unmarshal(java.io.Reader) 

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
