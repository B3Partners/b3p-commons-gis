/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class SchemaDescriptionLanguageType.
 * 
 * @version $Revision$ $Date$
 */
public class SchemaDescriptionLanguageType implements java.io.Serializable {


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

    public SchemaDescriptionLanguageType() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addSchemaDescriptionLanguageTypeItem
     * 
     * 
     * 
     * @param vSchemaDescriptionLanguageTypeItem
     */
    public void addSchemaDescriptionLanguageTypeItem(nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageTypeItem vSchemaDescriptionLanguageTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vSchemaDescriptionLanguageTypeItem);
    } //-- void addSchemaDescriptionLanguageTypeItem(nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageTypeItem) 

    /**
     * Method addSchemaDescriptionLanguageTypeItem
     * 
     * 
     * 
     * @param index
     * @param vSchemaDescriptionLanguageTypeItem
     */
    public void addSchemaDescriptionLanguageTypeItem(int index, nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageTypeItem vSchemaDescriptionLanguageTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vSchemaDescriptionLanguageTypeItem);
    } //-- void addSchemaDescriptionLanguageTypeItem(int, nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageTypeItem) 

    /**
     * Method clearSchemaDescriptionLanguageTypeItem
     * 
     */
    public void clearSchemaDescriptionLanguageTypeItem()
    {
        _items.clear();
    } //-- void clearSchemaDescriptionLanguageTypeItem() 

    /**
     * Method enumerateSchemaDescriptionLanguageTypeItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateSchemaDescriptionLanguageTypeItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateSchemaDescriptionLanguageTypeItem() 

    /**
     * Method getSchemaDescriptionLanguageTypeItem
     * 
     * 
     * 
     * @param index
     * @return SchemaDescriptionLanguageTypeItem
     */
    public nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageTypeItem getSchemaDescriptionLanguageTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageTypeItem) _items.get(index);
    } //-- nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageTypeItem getSchemaDescriptionLanguageTypeItem(int) 

    /**
     * Method getSchemaDescriptionLanguageTypeItem
     * 
     * 
     * 
     * @return SchemaDescriptionLanguageTypeItem
     */
    public nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageTypeItem[] getSchemaDescriptionLanguageTypeItem()
    {
        int size = _items.size();
        nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageTypeItem[] mArray = new nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageTypeItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageTypeItem[] getSchemaDescriptionLanguageTypeItem() 

    /**
     * Method getSchemaDescriptionLanguageTypeItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getSchemaDescriptionLanguageTypeItemCount()
    {
        return _items.size();
    } //-- int getSchemaDescriptionLanguageTypeItemCount() 

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
     * Method removeSchemaDescriptionLanguageTypeItem
     * 
     * 
     * 
     * @param vSchemaDescriptionLanguageTypeItem
     * @return boolean
     */
    public boolean removeSchemaDescriptionLanguageTypeItem(nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageTypeItem vSchemaDescriptionLanguageTypeItem)
    {
        boolean removed = _items.remove(vSchemaDescriptionLanguageTypeItem);
        return removed;
    } //-- boolean removeSchemaDescriptionLanguageTypeItem(nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageTypeItem) 

    /**
     * Method setSchemaDescriptionLanguageTypeItem
     * 
     * 
     * 
     * @param index
     * @param vSchemaDescriptionLanguageTypeItem
     */
    public void setSchemaDescriptionLanguageTypeItem(int index, nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageTypeItem vSchemaDescriptionLanguageTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vSchemaDescriptionLanguageTypeItem);
    } //-- void setSchemaDescriptionLanguageTypeItem(int, nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageTypeItem) 

    /**
     * Method setSchemaDescriptionLanguageTypeItem
     * 
     * 
     * 
     * @param schemaDescriptionLanguageTypeItemArray
     */
    public void setSchemaDescriptionLanguageTypeItem(nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageTypeItem[] schemaDescriptionLanguageTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < schemaDescriptionLanguageTypeItemArray.length; i++) {
            _items.add(schemaDescriptionLanguageTypeItemArray[i]);
        }
    } //-- void setSchemaDescriptionLanguageTypeItem(nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageTypeItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return SchemaDescriptionLanguageType
     */
    public static nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.SchemaDescriptionLanguageType unmarshal(java.io.Reader) 

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
