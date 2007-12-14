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
 * XML encoded GetCapabilities operation request. This operation
 * allows clients to retrieve service metadata about a specific
 * service instance. In this XML encoding, no "request" parameter
 * is included, since the element name specifies the specific
 * operation. This base type shall be extended by each specific OWS
 * to include the additional required "service" attribute, with the
 * correct value for that OWS. 
 * 
 * @version $Revision$ $Date$
 */
public class GetCapabilitiesType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * When omitted or not supported by server, server shall return
     * latest complete service metadata document. 
     */
    private java.lang.String _updateSequence;

    /**
     * When omitted, server shall return latest supported version. 
     */
    private nl.b3p.xml.ows.v100.AcceptVersions _acceptVersions;

    /**
     * When omitted or not supported by server, server shall return
     * complete service metadata (Capabilities) document. 
     */
    private nl.b3p.xml.ows.v100.Sections _sections;

    /**
     * When omitted or not supported by server, server shall return
     * service metadata document using the MIME type "text/xml". 
     */
    private nl.b3p.xml.ows.v100.AcceptFormats _acceptFormats;


      //----------------/
     //- Constructors -/
    //----------------/

    public GetCapabilitiesType() 
     {
        super();
    } //-- nl.b3p.xml.ows.v100.GetCapabilitiesType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'acceptFormats'. The field
     * 'acceptFormats' has the following description: When omitted
     * or not supported by server, server shall return service
     * metadata document using the MIME type "text/xml". 
     * 
     * @return AcceptFormats
     * @return the value of field 'acceptFormats'.
     */
    public nl.b3p.xml.ows.v100.AcceptFormats getAcceptFormats()
    {
        return this._acceptFormats;
    } //-- nl.b3p.xml.ows.v100.AcceptFormats getAcceptFormats() 

    /**
     * Returns the value of field 'acceptVersions'. The field
     * 'acceptVersions' has the following description: When
     * omitted, server shall return latest supported version. 
     * 
     * @return AcceptVersions
     * @return the value of field 'acceptVersions'.
     */
    public nl.b3p.xml.ows.v100.AcceptVersions getAcceptVersions()
    {
        return this._acceptVersions;
    } //-- nl.b3p.xml.ows.v100.AcceptVersions getAcceptVersions() 

    /**
     * Returns the value of field 'sections'. The field 'sections'
     * has the following description: When omitted or not supported
     * by server, server shall return complete service metadata
     * (Capabilities) document. 
     * 
     * @return Sections
     * @return the value of field 'sections'.
     */
    public nl.b3p.xml.ows.v100.Sections getSections()
    {
        return this._sections;
    } //-- nl.b3p.xml.ows.v100.Sections getSections() 

    /**
     * Returns the value of field 'updateSequence'. The field
     * 'updateSequence' has the following description: When omitted
     * or not supported by server, server shall return latest
     * complete service metadata document. 
     * 
     * @return String
     * @return the value of field 'updateSequence'.
     */
    public java.lang.String getUpdateSequence()
    {
        return this._updateSequence;
    } //-- java.lang.String getUpdateSequence() 

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
     * Sets the value of field 'acceptFormats'. The field
     * 'acceptFormats' has the following description: When omitted
     * or not supported by server, server shall return service
     * metadata document using the MIME type "text/xml". 
     * 
     * @param acceptFormats the value of field 'acceptFormats'.
     */
    public void setAcceptFormats(nl.b3p.xml.ows.v100.AcceptFormats acceptFormats)
    {
        this._acceptFormats = acceptFormats;
    } //-- void setAcceptFormats(nl.b3p.xml.ows.v100.AcceptFormats) 

    /**
     * Sets the value of field 'acceptVersions'. The field
     * 'acceptVersions' has the following description: When
     * omitted, server shall return latest supported version. 
     * 
     * @param acceptVersions the value of field 'acceptVersions'.
     */
    public void setAcceptVersions(nl.b3p.xml.ows.v100.AcceptVersions acceptVersions)
    {
        this._acceptVersions = acceptVersions;
    } //-- void setAcceptVersions(nl.b3p.xml.ows.v100.AcceptVersions) 

    /**
     * Sets the value of field 'sections'. The field 'sections' has
     * the following description: When omitted or not supported by
     * server, server shall return complete service metadata
     * (Capabilities) document. 
     * 
     * @param sections the value of field 'sections'.
     */
    public void setSections(nl.b3p.xml.ows.v100.Sections sections)
    {
        this._sections = sections;
    } //-- void setSections(nl.b3p.xml.ows.v100.Sections) 

    /**
     * Sets the value of field 'updateSequence'. The field
     * 'updateSequence' has the following description: When omitted
     * or not supported by server, server shall return latest
     * complete service metadata document. 
     * 
     * @param updateSequence the value of field 'updateSequence'.
     */
    public void setUpdateSequence(java.lang.String updateSequence)
    {
        this._updateSequence = updateSequence;
    } //-- void setUpdateSequence(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return GetCapabilitiesType
     */
    public static nl.b3p.xml.ows.v100.GetCapabilitiesType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.GetCapabilitiesType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.GetCapabilitiesType.class, reader);
    } //-- nl.b3p.xml.ows.v100.GetCapabilitiesType unmarshal(java.io.Reader) 

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
