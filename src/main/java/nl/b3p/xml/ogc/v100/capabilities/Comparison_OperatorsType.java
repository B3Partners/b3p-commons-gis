/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v100.capabilities;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class Comparison_OperatorsType.
 * 
 * @version $Revision$ $Date$
 */
public class Comparison_OperatorsType implements java.io.Serializable {


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

    public Comparison_OperatorsType() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addComparison_OperatorsTypeItem
     * 
     * 
     * 
     * @param vComparison_OperatorsTypeItem
     */
    public void addComparison_OperatorsTypeItem(nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem vComparison_OperatorsTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vComparison_OperatorsTypeItem);
    } //-- void addComparison_OperatorsTypeItem(nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem) 

    /**
     * Method addComparison_OperatorsTypeItem
     * 
     * 
     * 
     * @param index
     * @param vComparison_OperatorsTypeItem
     */
    public void addComparison_OperatorsTypeItem(int index, nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem vComparison_OperatorsTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vComparison_OperatorsTypeItem);
    } //-- void addComparison_OperatorsTypeItem(int, nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem) 

    /**
     * Method clearComparison_OperatorsTypeItem
     * 
     */
    public void clearComparison_OperatorsTypeItem()
    {
        _items.clear();
    } //-- void clearComparison_OperatorsTypeItem() 

    /**
     * Method enumerateComparison_OperatorsTypeItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateComparison_OperatorsTypeItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateComparison_OperatorsTypeItem() 

    /**
     * Method getComparison_OperatorsTypeItem
     * 
     * 
     * 
     * @param index
     * @return Comparison_OperatorsTypeItem
     */
    public nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem getComparison_OperatorsTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem) _items.get(index);
    } //-- nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem getComparison_OperatorsTypeItem(int) 

    /**
     * Method getComparison_OperatorsTypeItem
     * 
     * 
     * 
     * @return Comparison_OperatorsTypeItem
     */
    public nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem[] getComparison_OperatorsTypeItem()
    {
        int size = _items.size();
        nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem[] mArray = new nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem[] getComparison_OperatorsTypeItem() 

    /**
     * Method getComparison_OperatorsTypeItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getComparison_OperatorsTypeItemCount()
    {
        return _items.size();
    } //-- int getComparison_OperatorsTypeItemCount() 

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
     * Method removeComparison_OperatorsTypeItem
     * 
     * 
     * 
     * @param vComparison_OperatorsTypeItem
     * @return boolean
     */
    public boolean removeComparison_OperatorsTypeItem(nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem vComparison_OperatorsTypeItem)
    {
        boolean removed = _items.remove(vComparison_OperatorsTypeItem);
        return removed;
    } //-- boolean removeComparison_OperatorsTypeItem(nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem) 

    /**
     * Method setComparison_OperatorsTypeItem
     * 
     * 
     * 
     * @param index
     * @param vComparison_OperatorsTypeItem
     */
    public void setComparison_OperatorsTypeItem(int index, nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem vComparison_OperatorsTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vComparison_OperatorsTypeItem);
    } //-- void setComparison_OperatorsTypeItem(int, nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem) 

    /**
     * Method setComparison_OperatorsTypeItem
     * 
     * 
     * 
     * @param comparison_OperatorsTypeItemArray
     */
    public void setComparison_OperatorsTypeItem(nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem[] comparison_OperatorsTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < comparison_OperatorsTypeItemArray.length; i++) {
            _items.add(comparison_OperatorsTypeItemArray[i]);
        }
    } //-- void setComparison_OperatorsTypeItem(nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Comparison_OperatorsType
     */
    public static nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsType.class, reader);
    } //-- nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsType unmarshal(java.io.Reader) 

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
