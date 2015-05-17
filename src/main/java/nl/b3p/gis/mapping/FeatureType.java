/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.gis.mapping;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * A feature type of the GML
 * 
 * @version $Revision$ $Date$
 */
public class FeatureType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _newName
     */
    private java.lang.String _newName;

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * The attribute of a featuretype
     */
    private java.util.ArrayList _attributeList;

    /**
     * A refference to a ohter feature
     */
    private java.util.ArrayList _referenceList;


      //----------------/
     //- Constructors -/
    //----------------/

    public FeatureType() 
     {
        super();
        _attributeList = new java.util.ArrayList();
        _referenceList = new java.util.ArrayList();
    } //-- nl.b3p.gis.mapping.FeatureType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addAttribute
     * 
     * 
     * 
     * @param vAttribute
     */
    public void addAttribute(nl.b3p.gis.mapping.Attribute vAttribute)
        throws java.lang.IndexOutOfBoundsException
    {
        _attributeList.add(vAttribute);
    } //-- void addAttribute(nl.b3p.gis.mapping.Attribute) 

    /**
     * Method addAttribute
     * 
     * 
     * 
     * @param index
     * @param vAttribute
     */
    public void addAttribute(int index, nl.b3p.gis.mapping.Attribute vAttribute)
        throws java.lang.IndexOutOfBoundsException
    {
        _attributeList.add(index, vAttribute);
    } //-- void addAttribute(int, nl.b3p.gis.mapping.Attribute) 

    /**
     * Method addReference
     * 
     * 
     * 
     * @param vReference
     */
    public void addReference(nl.b3p.gis.mapping.Reference vReference)
        throws java.lang.IndexOutOfBoundsException
    {
        _referenceList.add(vReference);
    } //-- void addReference(nl.b3p.gis.mapping.Reference) 

    /**
     * Method addReference
     * 
     * 
     * 
     * @param index
     * @param vReference
     */
    public void addReference(int index, nl.b3p.gis.mapping.Reference vReference)
        throws java.lang.IndexOutOfBoundsException
    {
        _referenceList.add(index, vReference);
    } //-- void addReference(int, nl.b3p.gis.mapping.Reference) 

    /**
     * Method clearAttribute
     * 
     */
    public void clearAttribute()
    {
        _attributeList.clear();
    } //-- void clearAttribute() 

    /**
     * Method clearReference
     * 
     */
    public void clearReference()
    {
        _referenceList.clear();
    } //-- void clearReference() 

    /**
     * Method enumerateAttribute
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateAttribute()
    {
        return Collections.enumeration(_attributeList);
    } //-- java.util.Enumeration enumerateAttribute() 

    /**
     * Method enumerateReference
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateReference()
    {
        return Collections.enumeration(_referenceList);
    } //-- java.util.Enumeration enumerateReference() 

    /**
     * Method getAttribute
     * 
     * 
     * 
     * @param index
     * @return Attribute
     */
    public nl.b3p.gis.mapping.Attribute getAttribute(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _attributeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.gis.mapping.Attribute) _attributeList.get(index);
    } //-- nl.b3p.gis.mapping.Attribute getAttribute(int) 

    /**
     * Method getAttribute
     * 
     * 
     * 
     * @return Attribute
     */
    public nl.b3p.gis.mapping.Attribute[] getAttribute()
    {
        int size = _attributeList.size();
        nl.b3p.gis.mapping.Attribute[] mArray = new nl.b3p.gis.mapping.Attribute[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.gis.mapping.Attribute) _attributeList.get(index);
        }
        return mArray;
    } //-- nl.b3p.gis.mapping.Attribute[] getAttribute() 

    /**
     * Method getAttributeCount
     * 
     * 
     * 
     * @return int
     */
    public int getAttributeCount()
    {
        return _attributeList.size();
    } //-- int getAttributeCount() 

    /**
     * Returns the value of field 'name'.
     * 
     * @return String
     * @return the value of field 'name'.
     */
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Returns the value of field 'newName'.
     * 
     * @return String
     * @return the value of field 'newName'.
     */
    public java.lang.String getNewName()
    {
        return this._newName;
    } //-- java.lang.String getNewName() 

    /**
     * Method getReference
     * 
     * 
     * 
     * @param index
     * @return Reference
     */
    public nl.b3p.gis.mapping.Reference getReference(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _referenceList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.gis.mapping.Reference) _referenceList.get(index);
    } //-- nl.b3p.gis.mapping.Reference getReference(int) 

    /**
     * Method getReference
     * 
     * 
     * 
     * @return Reference
     */
    public nl.b3p.gis.mapping.Reference[] getReference()
    {
        int size = _referenceList.size();
        nl.b3p.gis.mapping.Reference[] mArray = new nl.b3p.gis.mapping.Reference[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.gis.mapping.Reference) _referenceList.get(index);
        }
        return mArray;
    } //-- nl.b3p.gis.mapping.Reference[] getReference() 

    /**
     * Method getReferenceCount
     * 
     * 
     * 
     * @return int
     */
    public int getReferenceCount()
    {
        return _referenceList.size();
    } //-- int getReferenceCount() 

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
     * Method removeAttribute
     * 
     * 
     * 
     * @param vAttribute
     * @return boolean
     */
    public boolean removeAttribute(nl.b3p.gis.mapping.Attribute vAttribute)
    {
        boolean removed = _attributeList.remove(vAttribute);
        return removed;
    } //-- boolean removeAttribute(nl.b3p.gis.mapping.Attribute) 

    /**
     * Method removeReference
     * 
     * 
     * 
     * @param vReference
     * @return boolean
     */
    public boolean removeReference(nl.b3p.gis.mapping.Reference vReference)
    {
        boolean removed = _referenceList.remove(vReference);
        return removed;
    } //-- boolean removeReference(nl.b3p.gis.mapping.Reference) 

    /**
     * Method setAttribute
     * 
     * 
     * 
     * @param index
     * @param vAttribute
     */
    public void setAttribute(int index, nl.b3p.gis.mapping.Attribute vAttribute)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _attributeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _attributeList.set(index, vAttribute);
    } //-- void setAttribute(int, nl.b3p.gis.mapping.Attribute) 

    /**
     * Method setAttribute
     * 
     * 
     * 
     * @param attributeArray
     */
    public void setAttribute(nl.b3p.gis.mapping.Attribute[] attributeArray)
    {
        //-- copy array
        _attributeList.clear();
        for (int i = 0; i < attributeArray.length; i++) {
            _attributeList.add(attributeArray[i]);
        }
    } //-- void setAttribute(nl.b3p.gis.mapping.Attribute) 

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Sets the value of field 'newName'.
     * 
     * @param newName the value of field 'newName'.
     */
    public void setNewName(java.lang.String newName)
    {
        this._newName = newName;
    } //-- void setNewName(java.lang.String) 

    /**
     * Method setReference
     * 
     * 
     * 
     * @param index
     * @param vReference
     */
    public void setReference(int index, nl.b3p.gis.mapping.Reference vReference)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _referenceList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _referenceList.set(index, vReference);
    } //-- void setReference(int, nl.b3p.gis.mapping.Reference) 

    /**
     * Method setReference
     * 
     * 
     * 
     * @param referenceArray
     */
    public void setReference(nl.b3p.gis.mapping.Reference[] referenceArray)
    {
        //-- copy array
        _referenceList.clear();
        for (int i = 0; i < referenceArray.length; i++) {
            _referenceList.add(referenceArray[i]);
        }
    } //-- void setReference(nl.b3p.gis.mapping.Reference) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return FeatureType
     */
    public static nl.b3p.gis.mapping.FeatureType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.gis.mapping.FeatureType) Unmarshaller.unmarshal(nl.b3p.gis.mapping.FeatureType.class, reader);
    } //-- nl.b3p.gis.mapping.FeatureType unmarshal(java.io.Reader) 

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
