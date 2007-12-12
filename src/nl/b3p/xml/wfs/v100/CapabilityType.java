/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class CapabilityType.
 * 
 * @version $Revision$ $Date$
 */
public class CapabilityType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _request
     */
    private nl.b3p.xml.wfs.v100.Request _request;

    /**
     * Field _vendorSpecificCapabilities
     */
    private java.lang.String _vendorSpecificCapabilities;


      //----------------/
     //- Constructors -/
    //----------------/

    public CapabilityType() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v100.CapabilityType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'request'.
     * 
     * @return Request
     * @return the value of field 'request'.
     */
    public nl.b3p.xml.wfs.v100.Request getRequest()
    {
        return this._request;
    } //-- nl.b3p.xml.wfs.v100.Request getRequest() 

    /**
     * Returns the value of field 'vendorSpecificCapabilities'.
     * 
     * @return String
     * @return the value of field 'vendorSpecificCapabilities'.
     */
    public java.lang.String getVendorSpecificCapabilities()
    {
        return this._vendorSpecificCapabilities;
    } //-- java.lang.String getVendorSpecificCapabilities() 

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
     * Sets the value of field 'request'.
     * 
     * @param request the value of field 'request'.
     */
    public void setRequest(nl.b3p.xml.wfs.v100.Request request)
    {
        this._request = request;
    } //-- void setRequest(nl.b3p.xml.wfs.v100.Request) 

    /**
     * Sets the value of field 'vendorSpecificCapabilities'.
     * 
     * @param vendorSpecificCapabilities the value of field
     * 'vendorSpecificCapabilities'.
     */
    public void setVendorSpecificCapabilities(java.lang.String vendorSpecificCapabilities)
    {
        this._vendorSpecificCapabilities = vendorSpecificCapabilities;
    } //-- void setVendorSpecificCapabilities(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return CapabilityType
     */
    public static nl.b3p.xml.wfs.v100.CapabilityType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.CapabilityType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.CapabilityType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.CapabilityType unmarshal(java.io.Reader) 

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
