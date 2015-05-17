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
 * Request to a WFS to perform the GetCapabilities operation.
 *  This operation allows a client to retrieve a Capabilities
 *  XML document providing metadata for the specific WFS server.
 * 
 *  The GetCapapbilities element is used to request that a Web
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
public class GetCapabilitiesType extends nl.b3p.xml.ows.v100.GetCapabilitiesType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _service
     */
    private java.lang.String _service = "WFS";


      //----------------/
     //- Constructors -/
    //----------------/

    public GetCapabilitiesType() 
     {
        super();
        setService("WFS");
    } //-- nl.b3p.xml.wfs.v110.GetCapabilitiesType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'service'.
     * 
     * @return String
     * @return the value of field 'service'.
     */
    public java.lang.String getService()
    {
        return this._service;
    } //-- java.lang.String getService() 

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
     * Sets the value of field 'service'.
     * 
     * @param service the value of field 'service'.
     */
    public void setService(java.lang.String service)
    {
        this._service = service;
    } //-- void setService(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return GetCapabilitiesType
     */
    public static nl.b3p.xml.wfs.v110.GetCapabilitiesType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.GetCapabilitiesType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.GetCapabilitiesType.class, reader);
    } //-- nl.b3p.xml.wfs.v110.GetCapabilitiesType unmarshal(java.io.Reader) 

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
