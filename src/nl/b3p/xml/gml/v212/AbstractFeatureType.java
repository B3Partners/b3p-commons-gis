/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.gml.v212;

/**
 * An abstract feature provides a set of common properties. A
 * concrete 
 *  feature type must derive from this type and specify additional 
 *  properties in an application schema. A feature may optionally 
 *  possess an identifying attribute ('fid').
 *  
 * 
 * @version $Revision$ $Date$
 */
public abstract class AbstractFeatureType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _fid
     */
    private java.lang.String _fid;

    /**
     * Field _description
     */
    private java.lang.Object _description;

    /**
     * Field _name
     */
    private java.lang.Object _name;

    /**
     * Field _boundedBy
     */
    private java.lang.Object _boundedBy;


      //----------------/
     //- Constructors -/
    //----------------/

    public AbstractFeatureType() 
     {
        super();
    } //-- nl.b3p.xml.gml.v212.AbstractFeatureType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'boundedBy'.
     * 
     * @return Object
     * @return the value of field 'boundedBy'.
     */
    public java.lang.Object getBoundedBy()
    {
        return this._boundedBy;
    } //-- java.lang.Object getBoundedBy() 

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
     * Returns the value of field 'fid'.
     * 
     * @return String
     * @return the value of field 'fid'.
     */
    public java.lang.String getFid()
    {
        return this._fid;
    } //-- java.lang.String getFid() 

    /**
     * Returns the value of field 'name'.
     * 
     * @return Object
     * @return the value of field 'name'.
     */
    public java.lang.Object getName()
    {
        return this._name;
    } //-- java.lang.Object getName() 

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
     * Sets the value of field 'boundedBy'.
     * 
     * @param boundedBy the value of field 'boundedBy'.
     */
    public void setBoundedBy(java.lang.Object boundedBy)
    {
        this._boundedBy = boundedBy;
    } //-- void setBoundedBy(java.lang.Object) 

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
     * Sets the value of field 'fid'.
     * 
     * @param fid the value of field 'fid'.
     */
    public void setFid(java.lang.String fid)
    {
        this._fid = fid;
    } //-- void setFid(java.lang.String) 

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.Object name)
    {
        this._name = name;
    } //-- void setName(java.lang.Object) 

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
