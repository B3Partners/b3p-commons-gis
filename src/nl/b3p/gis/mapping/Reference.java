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
 * A refference to a ohter feature
 * 
 * @version $Revision$ $Date$
 */
public class Reference implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _reference_feature_name
     */
    private java.lang.Object _reference_feature_name;

    /**
     * Field _reference_feature_attribute
     */
    private java.lang.Object _reference_feature_attribute;


      //----------------/
     //- Constructors -/
    //----------------/

    public Reference() 
     {
        super();
    } //-- nl.b3p.gis.mapping.Reference()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'reference_feature_attribute'.
     * 
     * @return Object
     * @return the value of field 'reference_feature_attribute'.
     */
    public java.lang.Object getReference_feature_attribute()
    {
        return this._reference_feature_attribute;
    } //-- java.lang.Object getReference_feature_attribute() 

    /**
     * Returns the value of field 'reference_feature_name'.
     * 
     * @return Object
     * @return the value of field 'reference_feature_name'.
     */
    public java.lang.Object getReference_feature_name()
    {
        return this._reference_feature_name;
    } //-- java.lang.Object getReference_feature_name() 

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
     * Sets the value of field 'reference_feature_attribute'.
     * 
     * @param reference_feature_attribute the value of field
     * 'reference_feature_attribute'.
     */
    public void setReference_feature_attribute(java.lang.Object reference_feature_attribute)
    {
        this._reference_feature_attribute = reference_feature_attribute;
    } //-- void setReference_feature_attribute(java.lang.Object) 

    /**
     * Sets the value of field 'reference_feature_name'.
     * 
     * @param reference_feature_name the value of field
     * 'reference_feature_name'.
     */
    public void setReference_feature_name(java.lang.Object reference_feature_name)
    {
        this._reference_feature_name = reference_feature_name;
    } //-- void setReference_feature_name(java.lang.Object) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Reference
     */
    public static nl.b3p.gis.mapping.Reference unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.gis.mapping.Reference) Unmarshaller.unmarshal(nl.b3p.gis.mapping.Reference.class, reader);
    } //-- nl.b3p.gis.mapping.Reference unmarshal(java.io.Reader) 

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
