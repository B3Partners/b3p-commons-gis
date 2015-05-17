/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.gml.v311;

/**
 * Class AbstractFeatureType.
 * 
 * @version $Revision$ $Date$
 */
public abstract class AbstractFeatureType extends nl.b3p.xml.gml.v311.AbstractGMLType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _boundedBy
     */
    private java.lang.Object _boundedBy;

    /**
     * Field _location
     */
    private java.lang.Object _location;


      //----------------/
     //- Constructors -/
    //----------------/

    public AbstractFeatureType() 
     {
        super();
    } //-- nl.b3p.xml.gml.v311.AbstractFeatureType()


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
     * Returns the value of field 'location'.
     * 
     * @return Object
     * @return the value of field 'location'.
     */
    public java.lang.Object getLocation()
    {
        return this._location;
    } //-- java.lang.Object getLocation() 

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
     * Sets the value of field 'location'.
     * 
     * @param location the value of field 'location'.
     */
    public void setLocation(java.lang.Object location)
    {
        this._location = location;
    } //-- void setLocation(java.lang.Object) 

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
