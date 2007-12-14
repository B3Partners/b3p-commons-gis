/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100.subset19115;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Information required to enable contact with the responsible
 * person and/or organization. For OWS use in the service metadata
 * document, the optional hoursOfService and contactInstructions
 * elements were retained, as possibly being useful in the
 * ServiceProvider section. 
 * 
 * @version $Revision$ $Date$
 */
public class ContactType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Telephone numbers at which the organization or individual
     * may be contacted. 
     */
    private nl.b3p.xml.ows.v100.subset19115.Phone _phone;

    /**
     * Physical and email address at which the organization or
     * individual may be contacted. 
     */
    private nl.b3p.xml.ows.v100.subset19115.Address _address;

    /**
     * On-line information that can be used to contact the
     * individual or organization. OWS specifics: The xlink:href
     * attribute in the xlink:simpleLink attribute group shall be
     * used to reference this resource. Whenever practical, the
     * xlink:href attribute with type anyURI should be a URL from
     * which more contact information can be electronically
     * retrieved. The xlink:title attribute with type "string" can
     * be used to name this set of information. The other
     * attributes in the xlink:simpleLink attribute group should
     * not be used. 
     */
    private nl.b3p.xml.ows.v100.subset19115.OnlineResource _onlineResource;

    /**
     * Time period (including time zone) when individuals can
     * contact the organization or individual. 
     */
    private java.lang.String _hoursOfService;

    /**
     * Supplemental instructions on how or when to contact the
     * individual or organization. 
     */
    private java.lang.String _contactInstructions;


      //----------------/
     //- Constructors -/
    //----------------/

    public ContactType() 
     {
        super();
    } //-- nl.b3p.xml.ows.v100.subset19115.ContactType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'address'. The field 'address'
     * has the following description: Physical and email address at
     * which the organization or individual may be contacted. 
     * 
     * @return Address
     * @return the value of field 'address'.
     */
    public nl.b3p.xml.ows.v100.subset19115.Address getAddress()
    {
        return this._address;
    } //-- nl.b3p.xml.ows.v100.subset19115.Address getAddress() 

    /**
     * Returns the value of field 'contactInstructions'. The field
     * 'contactInstructions' has the following description:
     * Supplemental instructions on how or when to contact the
     * individual or organization. 
     * 
     * @return String
     * @return the value of field 'contactInstructions'.
     */
    public java.lang.String getContactInstructions()
    {
        return this._contactInstructions;
    } //-- java.lang.String getContactInstructions() 

    /**
     * Returns the value of field 'hoursOfService'. The field
     * 'hoursOfService' has the following description: Time period
     * (including time zone) when individuals can contact the
     * organization or individual. 
     * 
     * @return String
     * @return the value of field 'hoursOfService'.
     */
    public java.lang.String getHoursOfService()
    {
        return this._hoursOfService;
    } //-- java.lang.String getHoursOfService() 

    /**
     * Returns the value of field 'onlineResource'. The field
     * 'onlineResource' has the following description: On-line
     * information that can be used to contact the individual or
     * organization. OWS specifics: The xlink:href attribute in the
     * xlink:simpleLink attribute group shall be used to reference
     * this resource. Whenever practical, the xlink:href attribute
     * with type anyURI should be a URL from which more contact
     * information can be electronically retrieved. The xlink:title
     * attribute with type "string" can be used to name this set of
     * information. The other attributes in the xlink:simpleLink
     * attribute group should not be used. 
     * 
     * @return OnlineResource
     * @return the value of field 'onlineResource'.
     */
    public nl.b3p.xml.ows.v100.subset19115.OnlineResource getOnlineResource()
    {
        return this._onlineResource;
    } //-- nl.b3p.xml.ows.v100.subset19115.OnlineResource getOnlineResource() 

    /**
     * Returns the value of field 'phone'. The field 'phone' has
     * the following description: Telephone numbers at which the
     * organization or individual may be contacted. 
     * 
     * @return Phone
     * @return the value of field 'phone'.
     */
    public nl.b3p.xml.ows.v100.subset19115.Phone getPhone()
    {
        return this._phone;
    } //-- nl.b3p.xml.ows.v100.subset19115.Phone getPhone() 

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
     * Sets the value of field 'address'. The field 'address' has
     * the following description: Physical and email address at
     * which the organization or individual may be contacted. 
     * 
     * @param address the value of field 'address'.
     */
    public void setAddress(nl.b3p.xml.ows.v100.subset19115.Address address)
    {
        this._address = address;
    } //-- void setAddress(nl.b3p.xml.ows.v100.subset19115.Address) 

    /**
     * Sets the value of field 'contactInstructions'. The field
     * 'contactInstructions' has the following description:
     * Supplemental instructions on how or when to contact the
     * individual or organization. 
     * 
     * @param contactInstructions the value of field
     * 'contactInstructions'.
     */
    public void setContactInstructions(java.lang.String contactInstructions)
    {
        this._contactInstructions = contactInstructions;
    } //-- void setContactInstructions(java.lang.String) 

    /**
     * Sets the value of field 'hoursOfService'. The field
     * 'hoursOfService' has the following description: Time period
     * (including time zone) when individuals can contact the
     * organization or individual. 
     * 
     * @param hoursOfService the value of field 'hoursOfService'.
     */
    public void setHoursOfService(java.lang.String hoursOfService)
    {
        this._hoursOfService = hoursOfService;
    } //-- void setHoursOfService(java.lang.String) 

    /**
     * Sets the value of field 'onlineResource'. The field
     * 'onlineResource' has the following description: On-line
     * information that can be used to contact the individual or
     * organization. OWS specifics: The xlink:href attribute in the
     * xlink:simpleLink attribute group shall be used to reference
     * this resource. Whenever practical, the xlink:href attribute
     * with type anyURI should be a URL from which more contact
     * information can be electronically retrieved. The xlink:title
     * attribute with type "string" can be used to name this set of
     * information. The other attributes in the xlink:simpleLink
     * attribute group should not be used. 
     * 
     * @param onlineResource the value of field 'onlineResource'.
     */
    public void setOnlineResource(nl.b3p.xml.ows.v100.subset19115.OnlineResource onlineResource)
    {
        this._onlineResource = onlineResource;
    } //-- void setOnlineResource(nl.b3p.xml.ows.v100.subset19115.OnlineResource) 

    /**
     * Sets the value of field 'phone'. The field 'phone' has the
     * following description: Telephone numbers at which the
     * organization or individual may be contacted. 
     * 
     * @param phone the value of field 'phone'.
     */
    public void setPhone(nl.b3p.xml.ows.v100.subset19115.Phone phone)
    {
        this._phone = phone;
    } //-- void setPhone(nl.b3p.xml.ows.v100.subset19115.Phone) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return ContactType
     */
    public static nl.b3p.xml.ows.v100.subset19115.ContactType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.subset19115.ContactType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.subset19115.ContactType.class, reader);
    } //-- nl.b3p.xml.ows.v100.subset19115.ContactType unmarshal(java.io.Reader) 

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
