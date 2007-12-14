/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100.dataidentification;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Identification of, and means of communication with, person(s)
 * responsible for the resource(s). For OWS use in the
 * ServiceProvider section of a service metadata document, the
 * optional organizationName element was removed, since this type
 * is always used with the ProviderName element which provides that
 * information. The optional individualName element was made
 * mandatory, since either the organizationName or individualName
 * element is mandatory. The mandatory "role" element was changed
 * to optional, since no clear use of this information is known in
 * the ServiceProvider section. 
 * 
 * @version $Revision$ $Date$
 */
public class PointOfContact extends ResponsiblePartyType 
implements java.io.Serializable
{


      //----------------/
     //- Constructors -/
    //----------------/

    public PointOfContact() 
     {
        super();
    } //-- nl.b3p.xml.ows.v100.dataidentification.PointOfContact()


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
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return ResponsiblePartyType
     */
    public static nl.b3p.xml.ows.v100.dataidentification.ResponsiblePartyType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.dataidentification.ResponsiblePartyType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.dataidentification.PointOfContact.class, reader);
    } //-- nl.b3p.xml.ows.v100.dataidentification.ResponsiblePartyType unmarshal(java.io.Reader) 

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
