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
