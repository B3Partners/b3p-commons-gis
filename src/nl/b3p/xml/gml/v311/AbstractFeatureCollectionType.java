/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.gml.v311;

/**
 * Class AbstractFeatureCollectionType.
 * 
 * @version $Revision$ $Date$
 */
public abstract class AbstractFeatureCollectionType extends nl.b3p.xml.gml.v311.AbstractFeatureType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _featureMember
     */
    private java.lang.Object _featureMember;

    /**
     * Field _featureMembers
     */
    private java.lang.Object _featureMembers;


      //----------------/
     //- Constructors -/
    //----------------/

    public AbstractFeatureCollectionType() 
     {
        super();
    } //-- nl.b3p.xml.gml.v311.AbstractFeatureCollectionType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'featureMember'.
     * 
     * @return Object
     * @return the value of field 'featureMember'.
     */
    public java.lang.Object getFeatureMember()
    {
        return this._featureMember;
    } //-- java.lang.Object getFeatureMember() 

    /**
     * Returns the value of field 'featureMembers'.
     * 
     * @return Object
     * @return the value of field 'featureMembers'.
     */
    public java.lang.Object getFeatureMembers()
    {
        return this._featureMembers;
    } //-- java.lang.Object getFeatureMembers() 

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
     * Sets the value of field 'featureMember'.
     * 
     * @param featureMember the value of field 'featureMember'.
     */
    public void setFeatureMember(java.lang.Object featureMember)
    {
        this._featureMember = featureMember;
    } //-- void setFeatureMember(java.lang.Object) 

    /**
     * Sets the value of field 'featureMembers'.
     * 
     * @param featureMembers the value of field 'featureMembers'.
     */
    public void setFeatureMembers(java.lang.Object featureMembers)
    {
        this._featureMembers = featureMembers;
    } //-- void setFeatureMembers(java.lang.Object) 

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
