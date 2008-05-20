/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.gml.v311;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * This content model group makes it easier to construct types that
 * 
 *  derive from AbstractGMLType and its descendents "by
 * restriction". 
 *  A reference to the group saves having to enumerate the standard
 * object properties.
 * 
 * @version $Revision$ $Date$
 */
public class StandardObjectProperties implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _metaDataPropertyList
     */
    private java.util.ArrayList _metaDataPropertyList;

    /**
     * Field _description
     */
    private java.lang.Object _description;

    /**
     * Multiple names may be provided. These will often be
     * distinguished by being assigned by different authorities, as
     * indicated by the value of the codeSpace attribute. In an
     * instance document there will usually only be one name per
     * authority.
     */
    private java.util.ArrayList _nameList;


      //----------------/
     //- Constructors -/
    //----------------/

    public StandardObjectProperties() 
     {
        super();
        _metaDataPropertyList = new java.util.ArrayList();
        _nameList = new java.util.ArrayList();
    } //-- nl.b3p.xml.gml.v311.StandardObjectProperties()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addMetaDataProperty
     * 
     * 
     * 
     * @param vMetaDataProperty
     */
    public void addMetaDataProperty(java.lang.Object vMetaDataProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        _metaDataPropertyList.add(vMetaDataProperty);
    } //-- void addMetaDataProperty(java.lang.Object) 

    /**
     * Method addMetaDataProperty
     * 
     * 
     * 
     * @param index
     * @param vMetaDataProperty
     */
    public void addMetaDataProperty(int index, java.lang.Object vMetaDataProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        _metaDataPropertyList.add(index, vMetaDataProperty);
    } //-- void addMetaDataProperty(int, java.lang.Object) 

    /**
     * Method addName
     * 
     * 
     * 
     * @param vName
     */
    public void addName(java.lang.Object vName)
        throws java.lang.IndexOutOfBoundsException
    {
        _nameList.add(vName);
    } //-- void addName(java.lang.Object) 

    /**
     * Method addName
     * 
     * 
     * 
     * @param index
     * @param vName
     */
    public void addName(int index, java.lang.Object vName)
        throws java.lang.IndexOutOfBoundsException
    {
        _nameList.add(index, vName);
    } //-- void addName(int, java.lang.Object) 

    /**
     * Method clearMetaDataProperty
     * 
     */
    public void clearMetaDataProperty()
    {
        _metaDataPropertyList.clear();
    } //-- void clearMetaDataProperty() 

    /**
     * Method clearName
     * 
     */
    public void clearName()
    {
        _nameList.clear();
    } //-- void clearName() 

    /**
     * Method enumerateMetaDataProperty
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateMetaDataProperty()
    {
        return Collections.enumeration(_metaDataPropertyList);
    } //-- java.util.Enumeration enumerateMetaDataProperty() 

    /**
     * Method enumerateName
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateName()
    {
        return Collections.enumeration(_nameList);
    } //-- java.util.Enumeration enumerateName() 

    /**
     * Returns the value of field 'description'.
     * 
     * @return Object
     * @return the value of field 'description'.
     */
    public java.lang.Object getDescription()
    {
        return this._description;
    } //-- java.lang.Object getDescription() 

    /**
     * Method getMetaDataProperty
     * 
     * 
     * 
     * @param index
     * @return Object
     */
    public java.lang.Object getMetaDataProperty(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _metaDataPropertyList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (java.lang.Object) _metaDataPropertyList.get(index);
    } //-- java.lang.Object getMetaDataProperty(int) 

    /**
     * Method getMetaDataProperty
     * 
     * 
     * 
     * @return Object
     */
    public java.lang.Object[] getMetaDataProperty()
    {
        int size = _metaDataPropertyList.size();
        java.lang.Object[] mArray = new java.lang.Object[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (java.lang.Object) _metaDataPropertyList.get(index);
        }
        return mArray;
    } //-- java.lang.Object[] getMetaDataProperty() 

    /**
     * Method getMetaDataPropertyCount
     * 
     * 
     * 
     * @return int
     */
    public int getMetaDataPropertyCount()
    {
        return _metaDataPropertyList.size();
    } //-- int getMetaDataPropertyCount() 

    /**
     * Method getName
     * 
     * 
     * 
     * @param index
     * @return Object
     */
    public java.lang.Object getName(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _nameList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (java.lang.Object) _nameList.get(index);
    } //-- java.lang.Object getName(int) 

    /**
     * Method getName
     * 
     * 
     * 
     * @return Object
     */
    public java.lang.Object[] getName()
    {
        int size = _nameList.size();
        java.lang.Object[] mArray = new java.lang.Object[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (java.lang.Object) _nameList.get(index);
        }
        return mArray;
    } //-- java.lang.Object[] getName() 

    /**
     * Method getNameCount
     * 
     * 
     * 
     * @return int
     */
    public int getNameCount()
    {
        return _nameList.size();
    } //-- int getNameCount() 

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
     * Method removeMetaDataProperty
     * 
     * 
     * 
     * @param vMetaDataProperty
     * @return boolean
     */
    public boolean removeMetaDataProperty(java.lang.Object vMetaDataProperty)
    {
        boolean removed = _metaDataPropertyList.remove(vMetaDataProperty);
        return removed;
    } //-- boolean removeMetaDataProperty(java.lang.Object) 

    /**
     * Method removeName
     * 
     * 
     * 
     * @param vName
     * @return boolean
     */
    public boolean removeName(java.lang.Object vName)
    {
        boolean removed = _nameList.remove(vName);
        return removed;
    } //-- boolean removeName(java.lang.Object) 

    /**
     * Sets the value of field 'description'.
     * 
     * @param description the value of field 'description'.
     */
    public void setDescription(java.lang.Object description)
    {
        this._description = description;
    } //-- void setDescription(java.lang.Object) 

    /**
     * Method setMetaDataProperty
     * 
     * 
     * 
     * @param index
     * @param vMetaDataProperty
     */
    public void setMetaDataProperty(int index, java.lang.Object vMetaDataProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _metaDataPropertyList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _metaDataPropertyList.set(index, vMetaDataProperty);
    } //-- void setMetaDataProperty(int, java.lang.Object) 

    /**
     * Method setMetaDataProperty
     * 
     * 
     * 
     * @param metaDataPropertyArray
     */
    public void setMetaDataProperty(java.lang.Object[] metaDataPropertyArray)
    {
        //-- copy array
        _metaDataPropertyList.clear();
        for (int i = 0; i < metaDataPropertyArray.length; i++) {
            _metaDataPropertyList.add(metaDataPropertyArray[i]);
        }
    } //-- void setMetaDataProperty(java.lang.Object) 

    /**
     * Method setName
     * 
     * 
     * 
     * @param index
     * @param vName
     */
    public void setName(int index, java.lang.Object vName)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _nameList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _nameList.set(index, vName);
    } //-- void setName(int, java.lang.Object) 

    /**
     * Method setName
     * 
     * 
     * 
     * @param nameArray
     */
    public void setName(java.lang.Object[] nameArray)
    {
        //-- copy array
        _nameList.clear();
        for (int i = 0; i < nameArray.length; i++) {
            _nameList.add(nameArray[i]);
        }
    } //-- void setName(java.lang.Object) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return StandardObjectProperties
     */
    public static nl.b3p.xml.gml.v311.StandardObjectProperties unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.gml.v311.StandardObjectProperties) Unmarshaller.unmarshal(nl.b3p.xml.gml.v311.StandardObjectProperties.class, reader);
    } //-- nl.b3p.xml.gml.v311.StandardObjectProperties unmarshal(java.io.Reader) 

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
