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

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * The attribute of a featuretype
 * 
 * @version $Revision$ $Date$
 */
public class Attribute implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _newName
     */
    private java.lang.String _newName;

    /**
     * Field _type
     */
    private nl.b3p.gis.mapping.types.AttributeTypeType _type;

    /**
     * Field _primairyKeyPart
     */
    private boolean _primairyKeyPart = false;

    /**
     * keeps track of state for field: _primairyKeyPart
     */
    private boolean _has_primairyKeyPart;


      //----------------/
     //- Constructors -/
    //----------------/

    public Attribute() 
     {
        super();
    } //-- nl.b3p.gis.mapping.Attribute()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deletePrimairyKeyPart
     * 
     */
    public void deletePrimairyKeyPart()
    {
        this._has_primairyKeyPart= false;
    } //-- void deletePrimairyKeyPart() 

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
     * Returns the value of field 'primairyKeyPart'.
     * 
     * @return boolean
     * @return the value of field 'primairyKeyPart'.
     */
    public boolean getPrimairyKeyPart()
    {
        return this._primairyKeyPart;
    } //-- boolean getPrimairyKeyPart() 

    /**
     * Returns the value of field 'type'.
     * 
     * @return AttributeTypeType
     * @return the value of field 'type'.
     */
    public nl.b3p.gis.mapping.types.AttributeTypeType getType()
    {
        return this._type;
    } //-- nl.b3p.gis.mapping.types.AttributeTypeType getType() 

    /**
     * Method hasPrimairyKeyPart
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasPrimairyKeyPart()
    {
        return this._has_primairyKeyPart;
    } //-- boolean hasPrimairyKeyPart() 

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
     * Sets the value of field 'primairyKeyPart'.
     * 
     * @param primairyKeyPart the value of field 'primairyKeyPart'.
     */
    public void setPrimairyKeyPart(boolean primairyKeyPart)
    {
        this._primairyKeyPart = primairyKeyPart;
        this._has_primairyKeyPart = true;
    } //-- void setPrimairyKeyPart(boolean) 

    /**
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(nl.b3p.gis.mapping.types.AttributeTypeType type)
    {
        this._type = type;
    } //-- void setType(nl.b3p.gis.mapping.types.AttributeTypeType) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Attribute
     */
    public static nl.b3p.gis.mapping.Attribute unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.gis.mapping.Attribute) Unmarshaller.unmarshal(nl.b3p.gis.mapping.Attribute.class, reader);
    } //-- nl.b3p.gis.mapping.Attribute unmarshal(java.io.Reader) 

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
