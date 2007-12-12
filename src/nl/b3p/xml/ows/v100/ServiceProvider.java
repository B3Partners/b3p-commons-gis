/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Metadata about the organization that provides this specific
 * service instance or server. 
 * 
 * @version $Revision$ $Date$
 */
public class ServiceProvider implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * A unique identifier for the service provider organization. 
     */
    private java.lang.String _providerName;

    /**
     * Reference to the most relevant web site of the service
     * provider. 
     */
    private nl.b3p.xml.ows.v100.ProviderSite _providerSite;

    /**
     * Information for contacting the service provider. The
     * OnlineResource element within this ServiceContact element
     * should not be used to reference a web site of the service
     * provider. 
     */
    private nl.b3p.xml.ows.v100.ServiceContact _serviceContact;


      //----------------/
     //- Constructors -/
    //----------------/

    public ServiceProvider() 
     {
        super();
    } //-- nl.b3p.xml.ows.v100.ServiceProvider()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'providerName'. The field
     * 'providerName' has the following description: A unique
     * identifier for the service provider organization. 
     * 
     * @return String
     * @return the value of field 'providerName'.
     */
    public java.lang.String getProviderName()
    {
        return this._providerName;
    } //-- java.lang.String getProviderName() 

    /**
     * Returns the value of field 'providerSite'. The field
     * 'providerSite' has the following description: Reference to
     * the most relevant web site of the service provider. 
     * 
     * @return ProviderSite
     * @return the value of field 'providerSite'.
     */
    public nl.b3p.xml.ows.v100.ProviderSite getProviderSite()
    {
        return this._providerSite;
    } //-- nl.b3p.xml.ows.v100.ProviderSite getProviderSite() 

    /**
     * Returns the value of field 'serviceContact'. The field
     * 'serviceContact' has the following description: Information
     * for contacting the service provider. The OnlineResource
     * element within this ServiceContact element should not be
     * used to reference a web site of the service provider. 
     * 
     * @return ServiceContact
     * @return the value of field 'serviceContact'.
     */
    public nl.b3p.xml.ows.v100.ServiceContact getServiceContact()
    {
        return this._serviceContact;
    } //-- nl.b3p.xml.ows.v100.ServiceContact getServiceContact() 

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
     * Sets the value of field 'providerName'. The field
     * 'providerName' has the following description: A unique
     * identifier for the service provider organization. 
     * 
     * @param providerName the value of field 'providerName'.
     */
    public void setProviderName(java.lang.String providerName)
    {
        this._providerName = providerName;
    } //-- void setProviderName(java.lang.String) 

    /**
     * Sets the value of field 'providerSite'. The field
     * 'providerSite' has the following description: Reference to
     * the most relevant web site of the service provider. 
     * 
     * @param providerSite the value of field 'providerSite'.
     */
    public void setProviderSite(nl.b3p.xml.ows.v100.ProviderSite providerSite)
    {
        this._providerSite = providerSite;
    } //-- void setProviderSite(nl.b3p.xml.ows.v100.ProviderSite) 

    /**
     * Sets the value of field 'serviceContact'. The field
     * 'serviceContact' has the following description: Information
     * for contacting the service provider. The OnlineResource
     * element within this ServiceContact element should not be
     * used to reference a web site of the service provider. 
     * 
     * @param serviceContact the value of field 'serviceContact'.
     */
    public void setServiceContact(nl.b3p.xml.ows.v100.ServiceContact serviceContact)
    {
        this._serviceContact = serviceContact;
    } //-- void setServiceContact(nl.b3p.xml.ows.v100.ServiceContact) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return ServiceProvider
     */
    public static nl.b3p.xml.ows.v100.ServiceProvider unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.ServiceProvider) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.ServiceProvider.class, reader);
    } //-- nl.b3p.xml.ows.v100.ServiceProvider unmarshal(java.io.Reader) 

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
