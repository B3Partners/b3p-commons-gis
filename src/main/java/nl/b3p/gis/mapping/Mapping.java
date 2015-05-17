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
 * Root of mapping file
 * 
 * @version $Revision$ $Date$
 */
public class Mapping implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _description
     */
    private java.lang.String _description;

    /**
     * A feature type of the GML
     */
    private java.util.ArrayList _featureTypeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Mapping() 
     {
        super();
        _featureTypeList = new java.util.ArrayList();
    } //-- nl.b3p.gis.mapping.Mapping()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addFeatureType
     * 
     * 
     * 
     * @param vFeatureType
     */
    public void addFeatureType(nl.b3p.gis.mapping.FeatureType vFeatureType)
        throws java.lang.IndexOutOfBoundsException
    {
        _featureTypeList.add(vFeatureType);
    } //-- void addFeatureType(nl.b3p.gis.mapping.FeatureType) 

    /**
     * Method addFeatureType
     * 
     * 
     * 
     * @param index
     * @param vFeatureType
     */
    public void addFeatureType(int index, nl.b3p.gis.mapping.FeatureType vFeatureType)
        throws java.lang.IndexOutOfBoundsException
    {
        _featureTypeList.add(index, vFeatureType);
    } //-- void addFeatureType(int, nl.b3p.gis.mapping.FeatureType) 

    /**
     * Method clearFeatureType
     * 
     */
    public void clearFeatureType()
    {
        _featureTypeList.clear();
    } //-- void clearFeatureType() 

    /**
     * Method enumerateFeatureType
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateFeatureType()
    {
        return Collections.enumeration(_featureTypeList);
    } //-- java.util.Enumeration enumerateFeatureType() 

    /**
     * Returns the value of field 'description'.
     * 
     * @return String
     * @return the value of field 'description'.
     */
    public java.lang.String getDescription()
    {
        return this._description;
    } //-- java.lang.String getDescription() 

    /**
     * Method getFeatureType
     * 
     * 
     * 
     * @param index
     * @return FeatureType
     */
    public nl.b3p.gis.mapping.FeatureType getFeatureType(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _featureTypeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.gis.mapping.FeatureType) _featureTypeList.get(index);
    } //-- nl.b3p.gis.mapping.FeatureType getFeatureType(int) 

    /**
     * Method getFeatureType
     * 
     * 
     * 
     * @return FeatureType
     */
    public nl.b3p.gis.mapping.FeatureType[] getFeatureType()
    {
        int size = _featureTypeList.size();
        nl.b3p.gis.mapping.FeatureType[] mArray = new nl.b3p.gis.mapping.FeatureType[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.gis.mapping.FeatureType) _featureTypeList.get(index);
        }
        return mArray;
    } //-- nl.b3p.gis.mapping.FeatureType[] getFeatureType() 

    /**
     * Method getFeatureTypeCount
     * 
     * 
     * 
     * @return int
     */
    public int getFeatureTypeCount()
    {
        return _featureTypeList.size();
    } //-- int getFeatureTypeCount() 

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
     * Method removeFeatureType
     * 
     * 
     * 
     * @param vFeatureType
     * @return boolean
     */
    public boolean removeFeatureType(nl.b3p.gis.mapping.FeatureType vFeatureType)
    {
        boolean removed = _featureTypeList.remove(vFeatureType);
        return removed;
    } //-- boolean removeFeatureType(nl.b3p.gis.mapping.FeatureType) 

    /**
     * Sets the value of field 'description'.
     * 
     * @param description the value of field 'description'.
     */
    public void setDescription(java.lang.String description)
    {
        this._description = description;
    } //-- void setDescription(java.lang.String) 

    /**
     * Method setFeatureType
     * 
     * 
     * 
     * @param index
     * @param vFeatureType
     */
    public void setFeatureType(int index, nl.b3p.gis.mapping.FeatureType vFeatureType)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _featureTypeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _featureTypeList.set(index, vFeatureType);
    } //-- void setFeatureType(int, nl.b3p.gis.mapping.FeatureType) 

    /**
     * Method setFeatureType
     * 
     * 
     * 
     * @param featureTypeArray
     */
    public void setFeatureType(nl.b3p.gis.mapping.FeatureType[] featureTypeArray)
    {
        //-- copy array
        _featureTypeList.clear();
        for (int i = 0; i < featureTypeArray.length; i++) {
            _featureTypeList.add(featureTypeArray[i]);
        }
    } //-- void setFeatureType(nl.b3p.gis.mapping.FeatureType) 

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
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Mapping
     */
    public static nl.b3p.gis.mapping.Mapping unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.gis.mapping.Mapping) Unmarshaller.unmarshal(nl.b3p.gis.mapping.Mapping.class, reader);
    } //-- nl.b3p.gis.mapping.Mapping unmarshal(java.io.Reader) 

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
