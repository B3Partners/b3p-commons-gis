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
 * Class ResultFormatType.
 * 
 * @version $Revision$ $Date$
 */
public class ResultFormatType implements java.io.Serializable {


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

    public ResultFormatType() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v100.capabilities.ResultFormatType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addResultFormatTypeItem
     * 
     * 
     * 
     * @param vResultFormatTypeItem
     */
    public void addResultFormatTypeItem(nl.b3p.xml.wfs.v100.capabilities.ResultFormatTypeItem vResultFormatTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vResultFormatTypeItem);
    } //-- void addResultFormatTypeItem(nl.b3p.xml.wfs.v100.capabilities.ResultFormatTypeItem) 

    /**
     * Method addResultFormatTypeItem
     * 
     * 
     * 
     * @param index
     * @param vResultFormatTypeItem
     */
    public void addResultFormatTypeItem(int index, nl.b3p.xml.wfs.v100.capabilities.ResultFormatTypeItem vResultFormatTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vResultFormatTypeItem);
    } //-- void addResultFormatTypeItem(int, nl.b3p.xml.wfs.v100.capabilities.ResultFormatTypeItem) 

    /**
     * Method clearResultFormatTypeItem
     * 
     */
    public void clearResultFormatTypeItem()
    {
        _items.clear();
    } //-- void clearResultFormatTypeItem() 

    /**
     * Method enumerateResultFormatTypeItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateResultFormatTypeItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateResultFormatTypeItem() 

    /**
     * Method getResultFormatTypeItem
     * 
     * 
     * 
     * @param index
     * @return ResultFormatTypeItem
     */
    public nl.b3p.xml.wfs.v100.capabilities.ResultFormatTypeItem getResultFormatTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v100.capabilities.ResultFormatTypeItem) _items.get(index);
    } //-- nl.b3p.xml.wfs.v100.capabilities.ResultFormatTypeItem getResultFormatTypeItem(int) 

    /**
     * Method getResultFormatTypeItem
     * 
     * 
     * 
     * @return ResultFormatTypeItem
     */
    public nl.b3p.xml.wfs.v100.capabilities.ResultFormatTypeItem[] getResultFormatTypeItem()
    {
        int size = _items.size();
        nl.b3p.xml.wfs.v100.capabilities.ResultFormatTypeItem[] mArray = new nl.b3p.xml.wfs.v100.capabilities.ResultFormatTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v100.capabilities.ResultFormatTypeItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v100.capabilities.ResultFormatTypeItem[] getResultFormatTypeItem() 

    /**
     * Method getResultFormatTypeItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getResultFormatTypeItemCount()
    {
        return _items.size();
    } //-- int getResultFormatTypeItemCount() 

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
     * Method removeResultFormatTypeItem
     * 
     * 
     * 
     * @param vResultFormatTypeItem
     * @return boolean
     */
    public boolean removeResultFormatTypeItem(nl.b3p.xml.wfs.v100.capabilities.ResultFormatTypeItem vResultFormatTypeItem)
    {
        boolean removed = _items.remove(vResultFormatTypeItem);
        return removed;
    } //-- boolean removeResultFormatTypeItem(nl.b3p.xml.wfs.v100.capabilities.ResultFormatTypeItem) 

    /**
     * Method setResultFormatTypeItem
     * 
     * 
     * 
     * @param index
     * @param vResultFormatTypeItem
     */
    public void setResultFormatTypeItem(int index, nl.b3p.xml.wfs.v100.capabilities.ResultFormatTypeItem vResultFormatTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vResultFormatTypeItem);
    } //-- void setResultFormatTypeItem(int, nl.b3p.xml.wfs.v100.capabilities.ResultFormatTypeItem) 

    /**
     * Method setResultFormatTypeItem
     * 
     * 
     * 
     * @param resultFormatTypeItemArray
     */
    public void setResultFormatTypeItem(nl.b3p.xml.wfs.v100.capabilities.ResultFormatTypeItem[] resultFormatTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < resultFormatTypeItemArray.length; i++) {
            _items.add(resultFormatTypeItemArray[i]);
        }
    } //-- void setResultFormatTypeItem(nl.b3p.xml.wfs.v100.capabilities.ResultFormatTypeItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return ResultFormatType
     */
    public static nl.b3p.xml.wfs.v100.capabilities.ResultFormatType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.capabilities.ResultFormatType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.capabilities.ResultFormatType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.capabilities.ResultFormatType unmarshal(java.io.Reader) 

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
