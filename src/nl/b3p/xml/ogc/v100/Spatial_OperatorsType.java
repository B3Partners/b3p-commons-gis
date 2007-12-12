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
 * Class Spatial_OperatorsType.
 * 
 * @version $Revision$ $Date$
 */
public class Spatial_OperatorsType implements java.io.Serializable {


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

    public Spatial_OperatorsType() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.ogc.v100.Spatial_OperatorsType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addSpatial_OperatorsTypeItem
     * 
     * 
     * 
     * @param vSpatial_OperatorsTypeItem
     */
    public void addSpatial_OperatorsTypeItem(nl.b3p.xml.ogc.v100.Spatial_OperatorsTypeItem vSpatial_OperatorsTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vSpatial_OperatorsTypeItem);
    } //-- void addSpatial_OperatorsTypeItem(nl.b3p.xml.ogc.v100.Spatial_OperatorsTypeItem) 

    /**
     * Method addSpatial_OperatorsTypeItem
     * 
     * 
     * 
     * @param index
     * @param vSpatial_OperatorsTypeItem
     */
    public void addSpatial_OperatorsTypeItem(int index, nl.b3p.xml.ogc.v100.Spatial_OperatorsTypeItem vSpatial_OperatorsTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vSpatial_OperatorsTypeItem);
    } //-- void addSpatial_OperatorsTypeItem(int, nl.b3p.xml.ogc.v100.Spatial_OperatorsTypeItem) 

    /**
     * Method clearSpatial_OperatorsTypeItem
     * 
     */
    public void clearSpatial_OperatorsTypeItem()
    {
        _items.clear();
    } //-- void clearSpatial_OperatorsTypeItem() 

    /**
     * Method enumerateSpatial_OperatorsTypeItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateSpatial_OperatorsTypeItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateSpatial_OperatorsTypeItem() 

    /**
     * Method getSpatial_OperatorsTypeItem
     * 
     * 
     * 
     * @param index
     * @return Spatial_OperatorsTypeItem
     */
    public nl.b3p.xml.ogc.v100.Spatial_OperatorsTypeItem getSpatial_OperatorsTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ogc.v100.Spatial_OperatorsTypeItem) _items.get(index);
    } //-- nl.b3p.xml.ogc.v100.Spatial_OperatorsTypeItem getSpatial_OperatorsTypeItem(int) 

    /**
     * Method getSpatial_OperatorsTypeItem
     * 
     * 
     * 
     * @return Spatial_OperatorsTypeItem
     */
    public nl.b3p.xml.ogc.v100.Spatial_OperatorsTypeItem[] getSpatial_OperatorsTypeItem()
    {
        int size = _items.size();
        nl.b3p.xml.ogc.v100.Spatial_OperatorsTypeItem[] mArray = new nl.b3p.xml.ogc.v100.Spatial_OperatorsTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ogc.v100.Spatial_OperatorsTypeItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ogc.v100.Spatial_OperatorsTypeItem[] getSpatial_OperatorsTypeItem() 

    /**
     * Method getSpatial_OperatorsTypeItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getSpatial_OperatorsTypeItemCount()
    {
        return _items.size();
    } //-- int getSpatial_OperatorsTypeItemCount() 

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
     * Method removeSpatial_OperatorsTypeItem
     * 
     * 
     * 
     * @param vSpatial_OperatorsTypeItem
     * @return boolean
     */
    public boolean removeSpatial_OperatorsTypeItem(nl.b3p.xml.ogc.v100.Spatial_OperatorsTypeItem vSpatial_OperatorsTypeItem)
    {
        boolean removed = _items.remove(vSpatial_OperatorsTypeItem);
        return removed;
    } //-- boolean removeSpatial_OperatorsTypeItem(nl.b3p.xml.ogc.v100.Spatial_OperatorsTypeItem) 

    /**
     * Method setSpatial_OperatorsTypeItem
     * 
     * 
     * 
     * @param index
     * @param vSpatial_OperatorsTypeItem
     */
    public void setSpatial_OperatorsTypeItem(int index, nl.b3p.xml.ogc.v100.Spatial_OperatorsTypeItem vSpatial_OperatorsTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vSpatial_OperatorsTypeItem);
    } //-- void setSpatial_OperatorsTypeItem(int, nl.b3p.xml.ogc.v100.Spatial_OperatorsTypeItem) 

    /**
     * Method setSpatial_OperatorsTypeItem
     * 
     * 
     * 
     * @param spatial_OperatorsTypeItemArray
     */
    public void setSpatial_OperatorsTypeItem(nl.b3p.xml.ogc.v100.Spatial_OperatorsTypeItem[] spatial_OperatorsTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < spatial_OperatorsTypeItemArray.length; i++) {
            _items.add(spatial_OperatorsTypeItemArray[i]);
        }
    } //-- void setSpatial_OperatorsTypeItem(nl.b3p.xml.ogc.v100.Spatial_OperatorsTypeItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Spatial_OperatorsType
     */
    public static nl.b3p.xml.ogc.v100.Spatial_OperatorsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v100.Spatial_OperatorsType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.Spatial_OperatorsType.class, reader);
    } //-- nl.b3p.xml.ogc.v100.Spatial_OperatorsType unmarshal(java.io.Reader) 

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
