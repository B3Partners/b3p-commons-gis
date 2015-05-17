/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100.transaction;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class PropertyType.
 * 
 * @version $Revision$ $Date$
 */
public class PropertyType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The Name element contains the name of a feature property
     *  to be updated.
     *  
     */
    private java.lang.String _name;

    /**
     * The Value element contains the replacement value for the
     *  named property.
     *  
     */
    private java.lang.Object _value;


      //----------------/
     //- Constructors -/
    //----------------/

    public PropertyType() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v100.transaction.PropertyType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'name'. The field 'name' has the
     * following description: The Name element contains the name of
     * a feature property
     *  to be updated.
     *  
     * 
     * @return String
     * @return the value of field 'name'.
     */
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Returns the value of field 'value'. The field 'value' has
     * the following description: The Value element contains the
     * replacement value for the
     *  named property.
     *  
     * 
     * @return Object
     * @return the value of field 'value'.
     */
    public java.lang.Object getValue()
    {
        return this._value;
    } //-- java.lang.Object getValue() 

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
     * Sets the value of field 'name'. The field 'name' has the
     * following description: The Name element contains the name of
     * a feature property
     *  to be updated.
     *  
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Sets the value of field 'value'. The field 'value' has the
     * following description: The Value element contains the
     * replacement value for the
     *  named property.
     *  
     * 
     * @param value the value of field 'value'.
     */
    public void setValue(java.lang.Object value)
    {
        this._value = value;
    } //-- void setValue(java.lang.Object) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return PropertyType
     */
    public static nl.b3p.xml.wfs.v100.transaction.PropertyType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.transaction.PropertyType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.transaction.PropertyType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.transaction.PropertyType unmarshal(java.io.Reader) 

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
