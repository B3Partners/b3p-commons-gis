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
 * Class BinaryLogicOpType.
 * 
 * @version $Revision$ $Date$
 */
public class BinaryLogicOpType extends nl.b3p.xml.ogc.v100.LogicOpsType 
implements java.io.Serializable
{


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

    public BinaryLogicOpType() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.ogc.v100.BinaryLogicOpType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addBinaryLogicOpTypeItem
     * 
     * 
     * 
     * @param vBinaryLogicOpTypeItem
     */
    public void addBinaryLogicOpTypeItem(nl.b3p.xml.ogc.v100.BinaryLogicOpTypeItem vBinaryLogicOpTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vBinaryLogicOpTypeItem);
    } //-- void addBinaryLogicOpTypeItem(nl.b3p.xml.ogc.v100.BinaryLogicOpTypeItem) 

    /**
     * Method addBinaryLogicOpTypeItem
     * 
     * 
     * 
     * @param index
     * @param vBinaryLogicOpTypeItem
     */
    public void addBinaryLogicOpTypeItem(int index, nl.b3p.xml.ogc.v100.BinaryLogicOpTypeItem vBinaryLogicOpTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vBinaryLogicOpTypeItem);
    } //-- void addBinaryLogicOpTypeItem(int, nl.b3p.xml.ogc.v100.BinaryLogicOpTypeItem) 

    /**
     * Method clearBinaryLogicOpTypeItem
     * 
     */
    public void clearBinaryLogicOpTypeItem()
    {
        _items.clear();
    } //-- void clearBinaryLogicOpTypeItem() 

    /**
     * Method enumerateBinaryLogicOpTypeItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateBinaryLogicOpTypeItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateBinaryLogicOpTypeItem() 

    /**
     * Method getBinaryLogicOpTypeItem
     * 
     * 
     * 
     * @param index
     * @return BinaryLogicOpTypeItem
     */
    public nl.b3p.xml.ogc.v100.BinaryLogicOpTypeItem getBinaryLogicOpTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ogc.v100.BinaryLogicOpTypeItem) _items.get(index);
    } //-- nl.b3p.xml.ogc.v100.BinaryLogicOpTypeItem getBinaryLogicOpTypeItem(int) 

    /**
     * Method getBinaryLogicOpTypeItem
     * 
     * 
     * 
     * @return BinaryLogicOpTypeItem
     */
    public nl.b3p.xml.ogc.v100.BinaryLogicOpTypeItem[] getBinaryLogicOpTypeItem()
    {
        int size = _items.size();
        nl.b3p.xml.ogc.v100.BinaryLogicOpTypeItem[] mArray = new nl.b3p.xml.ogc.v100.BinaryLogicOpTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ogc.v100.BinaryLogicOpTypeItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ogc.v100.BinaryLogicOpTypeItem[] getBinaryLogicOpTypeItem() 

    /**
     * Method getBinaryLogicOpTypeItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getBinaryLogicOpTypeItemCount()
    {
        return _items.size();
    } //-- int getBinaryLogicOpTypeItemCount() 

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
     * Method removeBinaryLogicOpTypeItem
     * 
     * 
     * 
     * @param vBinaryLogicOpTypeItem
     * @return boolean
     */
    public boolean removeBinaryLogicOpTypeItem(nl.b3p.xml.ogc.v100.BinaryLogicOpTypeItem vBinaryLogicOpTypeItem)
    {
        boolean removed = _items.remove(vBinaryLogicOpTypeItem);
        return removed;
    } //-- boolean removeBinaryLogicOpTypeItem(nl.b3p.xml.ogc.v100.BinaryLogicOpTypeItem) 

    /**
     * Method setBinaryLogicOpTypeItem
     * 
     * 
     * 
     * @param index
     * @param vBinaryLogicOpTypeItem
     */
    public void setBinaryLogicOpTypeItem(int index, nl.b3p.xml.ogc.v100.BinaryLogicOpTypeItem vBinaryLogicOpTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vBinaryLogicOpTypeItem);
    } //-- void setBinaryLogicOpTypeItem(int, nl.b3p.xml.ogc.v100.BinaryLogicOpTypeItem) 

    /**
     * Method setBinaryLogicOpTypeItem
     * 
     * 
     * 
     * @param binaryLogicOpTypeItemArray
     */
    public void setBinaryLogicOpTypeItem(nl.b3p.xml.ogc.v100.BinaryLogicOpTypeItem[] binaryLogicOpTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < binaryLogicOpTypeItemArray.length; i++) {
            _items.add(binaryLogicOpTypeItemArray[i]);
        }
    } //-- void setBinaryLogicOpTypeItem(nl.b3p.xml.ogc.v100.BinaryLogicOpTypeItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return LogicOpsType
     */
    public static nl.b3p.xml.ogc.v100.LogicOpsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v100.LogicOpsType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.BinaryLogicOpType.class, reader);
    } //-- nl.b3p.xml.ogc.v100.LogicOpsType unmarshal(java.io.Reader) 

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
