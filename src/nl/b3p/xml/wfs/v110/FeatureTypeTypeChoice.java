/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v110;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class FeatureTypeTypeChoice.
 * 
 * @version $Revision$ $Date$
 */
public class FeatureTypeTypeChoice implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _featureTypeTypeChoiceSequence
     */
    private nl.b3p.xml.wfs.v110.FeatureTypeTypeChoiceSequence _featureTypeTypeChoiceSequence;

    /**
     * Field _noSRS
     */
    private nl.b3p.xml.wfs.v110.NoSRS _noSRS;


      //----------------/
     //- Constructors -/
    //----------------/

    public FeatureTypeTypeChoice() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v110.FeatureTypeTypeChoice()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'featureTypeTypeChoiceSequence'.
     * 
     * @return FeatureTypeTypeChoiceSequence
     * @return the value of field 'featureTypeTypeChoiceSequence'.
     */
    public nl.b3p.xml.wfs.v110.FeatureTypeTypeChoiceSequence getFeatureTypeTypeChoiceSequence()
    {
        return this._featureTypeTypeChoiceSequence;
    } //-- nl.b3p.xml.wfs.v110.FeatureTypeTypeChoiceSequence getFeatureTypeTypeChoiceSequence() 

    /**
     * Returns the value of field 'noSRS'.
     * 
     * @return NoSRS
     * @return the value of field 'noSRS'.
     */
    public nl.b3p.xml.wfs.v110.NoSRS getNoSRS()
    {
        return this._noSRS;
    } //-- nl.b3p.xml.wfs.v110.NoSRS getNoSRS() 

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
     * Sets the value of field 'featureTypeTypeChoiceSequence'.
     * 
     * @param featureTypeTypeChoiceSequence the value of field
     * 'featureTypeTypeChoiceSequence'.
     */
    public void setFeatureTypeTypeChoiceSequence(nl.b3p.xml.wfs.v110.FeatureTypeTypeChoiceSequence featureTypeTypeChoiceSequence)
    {
        this._featureTypeTypeChoiceSequence = featureTypeTypeChoiceSequence;
    } //-- void setFeatureTypeTypeChoiceSequence(nl.b3p.xml.wfs.v110.FeatureTypeTypeChoiceSequence) 

    /**
     * Sets the value of field 'noSRS'.
     * 
     * @param noSRS the value of field 'noSRS'.
     */
    public void setNoSRS(nl.b3p.xml.wfs.v110.NoSRS noSRS)
    {
        this._noSRS = noSRS;
    } //-- void setNoSRS(nl.b3p.xml.wfs.v110.NoSRS) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return FeatureTypeTypeChoice
     */
    public static nl.b3p.xml.wfs.v110.FeatureTypeTypeChoice unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.FeatureTypeTypeChoice) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.FeatureTypeTypeChoice.class, reader);
    } //-- nl.b3p.xml.wfs.v110.FeatureTypeTypeChoice unmarshal(java.io.Reader) 

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
