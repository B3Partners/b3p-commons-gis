/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.gml.v311;

/**
 * All complexContent GML elements are directly or indirectly
 * derived from this abstract supertype 
 *  to establish a hierarchy of GML types that may be distinguished
 * from other XML types by their ancestry. 
 *  Elements in this hierarchy may have an ID and are thus
 * referenceable.
 * 
 * @version $Revision$ $Date$
 */
public abstract class AbstractGMLType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _id
     */
    private java.lang.Object _id;

    /**
     * Field _standardObjectProperties
     */
    private nl.b3p.xml.gml.v311.StandardObjectProperties _standardObjectProperties;


      //----------------/
     //- Constructors -/
    //----------------/

    public AbstractGMLType() 
     {
        super();
    } //-- nl.b3p.xml.gml.v311.AbstractGMLType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'id'.
     * 
     * @return Object
     * @return the value of field 'id'.
     */
    public java.lang.Object getId()
    {
        return this._id;
    } //-- java.lang.Object getId() 

    /**
     * Returns the value of field 'standardObjectProperties'.
     * 
     * @return StandardObjectProperties
     * @return the value of field 'standardObjectProperties'.
     */
    public nl.b3p.xml.gml.v311.StandardObjectProperties getStandardObjectProperties()
    {
        return this._standardObjectProperties;
    } //-- nl.b3p.xml.gml.v311.StandardObjectProperties getStandardObjectProperties() 

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
     * Sets the value of field 'id'.
     * 
     * @param id the value of field 'id'.
     */
    public void setId(java.lang.Object id)
    {
        this._id = id;
    } //-- void setId(java.lang.Object) 

    /**
     * Sets the value of field 'standardObjectProperties'.
     * 
     * @param standardObjectProperties the value of field
     * 'standardObjectProperties'.
     */
    public void setStandardObjectProperties(nl.b3p.xml.gml.v311.StandardObjectProperties standardObjectProperties)
    {
        this._standardObjectProperties = standardObjectProperties;
    } //-- void setStandardObjectProperties(nl.b3p.xml.gml.v311.StandardObjectProperties) 

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
