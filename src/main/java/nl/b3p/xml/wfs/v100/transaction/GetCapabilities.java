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
 * The GetCapapbilities element is used to request that a Web
 * Feature
 *  Service generate an XML document describing the organization
 *  providing the service, the WFS operations that the service
 *  supports, a list of feature types that the service can operate
 *  on and list of filtering capabilities that the service support.
 *  Such an XML document is called a capabilities document.
 *  
 * 
 * @version $Revision$ $Date$
 */
public class GetCapabilities extends GetCapabilitiesType 
implements java.io.Serializable
{


      //----------------/
     //- Constructors -/
    //----------------/

    public GetCapabilities() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v100.transaction.GetCapabilities()


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
     * @return GetCapabilitiesType
     */
    public static nl.b3p.xml.wfs.v100.transaction.GetCapabilitiesType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.transaction.GetCapabilitiesType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.transaction.GetCapabilities.class, reader);
    } //-- nl.b3p.xml.wfs.v100.transaction.GetCapabilitiesType unmarshal(java.io.Reader) 

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
