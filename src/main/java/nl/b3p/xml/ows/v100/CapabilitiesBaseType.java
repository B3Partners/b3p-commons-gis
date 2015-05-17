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
 * XML encoded GetCapabilities operation response. This document
 * provides clients with service metadata about a specific service
 * instance, usually including metadata about the tightly-coupled
 * data served. If the server does not implement the updateSequence
 * parameter, the server shall always return the complete
 * Capabilities document, without the updateSequence parameter.
 * When the server implements the updateSequence parameter and the
 * GetCapabilities operation request included the updateSequence
 * parameter with the current value, the server shall return this
 * element with only the "version" and "updateSequence" attributes.
 * Otherwise, all optional elements shall be included or not
 * depending on the actual value of the Contents parameter in the
 * GetCapabilities operation request. This base type shall be
 * extended by each specific OWS to include the additional contents
 * needed. 
 * 
 * @version $Revision$ $Date$
 */
public class CapabilitiesBaseType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _version
     */
    private java.lang.String _version;

    /**
     * Field _updateSequence
     */
    private java.lang.String _updateSequence;

    /**
     * General metadata for this specific server. This XML Schema
     * of this section shall be the same for all OWS. 
     */
    private nl.b3p.xml.ows.v100.ServiceIdentification _serviceIdentification;

    /**
     * Metadata about the organization that provides this specific
     * service instance or server. 
     */
    private nl.b3p.xml.ows.v100.ServiceProvider _serviceProvider;

    /**
     * Metadata about the operations and related abilities
     * specified by this service and implemented by this server,
     * including the URLs for operation requests. The basic
     * contents of this section shall be the same for all OWS
     * types, but individual services can add elements and/or
     * change the optionality of optional elements. 
     */
    private nl.b3p.xml.ows.v100.OperationsMetadata _operationsMetadata;


      //----------------/
     //- Constructors -/
    //----------------/

    public CapabilitiesBaseType() 
     {
        super();
    } //-- nl.b3p.xml.ows.v100.CapabilitiesBaseType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'operationsMetadata'. The field
     * 'operationsMetadata' has the following description: Metadata
     * about the operations and related abilities specified by this
     * service and implemented by this server, including the URLs
     * for operation requests. The basic contents of this section
     * shall be the same for all OWS types, but individual services
     * can add elements and/or change the optionality of optional
     * elements. 
     * 
     * @return OperationsMetadata
     * @return the value of field 'operationsMetadata'.
     */
    public nl.b3p.xml.ows.v100.OperationsMetadata getOperationsMetadata()
    {
        return this._operationsMetadata;
    } //-- nl.b3p.xml.ows.v100.OperationsMetadata getOperationsMetadata() 

    /**
     * Returns the value of field 'serviceIdentification'. The
     * field 'serviceIdentification' has the following description:
     * General metadata for this specific server. This XML Schema
     * of this section shall be the same for all OWS. 
     * 
     * @return ServiceIdentification
     * @return the value of field 'serviceIdentification'.
     */
    public nl.b3p.xml.ows.v100.ServiceIdentification getServiceIdentification()
    {
        return this._serviceIdentification;
    } //-- nl.b3p.xml.ows.v100.ServiceIdentification getServiceIdentification() 

    /**
     * Returns the value of field 'serviceProvider'. The field
     * 'serviceProvider' has the following description: Metadata
     * about the organization that provides this specific service
     * instance or server. 
     * 
     * @return ServiceProvider
     * @return the value of field 'serviceProvider'.
     */
    public nl.b3p.xml.ows.v100.ServiceProvider getServiceProvider()
    {
        return this._serviceProvider;
    } //-- nl.b3p.xml.ows.v100.ServiceProvider getServiceProvider() 

    /**
     * Returns the value of field 'updateSequence'.
     * 
     * @return String
     * @return the value of field 'updateSequence'.
     */
    public java.lang.String getUpdateSequence()
    {
        return this._updateSequence;
    } //-- java.lang.String getUpdateSequence() 

    /**
     * Returns the value of field 'version'.
     * 
     * @return String
     * @return the value of field 'version'.
     */
    public java.lang.String getVersion()
    {
        return this._version;
    } //-- java.lang.String getVersion() 

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
     * Sets the value of field 'operationsMetadata'. The field
     * 'operationsMetadata' has the following description: Metadata
     * about the operations and related abilities specified by this
     * service and implemented by this server, including the URLs
     * for operation requests. The basic contents of this section
     * shall be the same for all OWS types, but individual services
     * can add elements and/or change the optionality of optional
     * elements. 
     * 
     * @param operationsMetadata the value of field
     * 'operationsMetadata'.
     */
    public void setOperationsMetadata(nl.b3p.xml.ows.v100.OperationsMetadata operationsMetadata)
    {
        this._operationsMetadata = operationsMetadata;
    } //-- void setOperationsMetadata(nl.b3p.xml.ows.v100.OperationsMetadata) 

    /**
     * Sets the value of field 'serviceIdentification'. The field
     * 'serviceIdentification' has the following description:
     * General metadata for this specific server. This XML Schema
     * of this section shall be the same for all OWS. 
     * 
     * @param serviceIdentification the value of field
     * 'serviceIdentification'.
     */
    public void setServiceIdentification(nl.b3p.xml.ows.v100.ServiceIdentification serviceIdentification)
    {
        this._serviceIdentification = serviceIdentification;
    } //-- void setServiceIdentification(nl.b3p.xml.ows.v100.ServiceIdentification) 

    /**
     * Sets the value of field 'serviceProvider'. The field
     * 'serviceProvider' has the following description: Metadata
     * about the organization that provides this specific service
     * instance or server. 
     * 
     * @param serviceProvider the value of field 'serviceProvider'.
     */
    public void setServiceProvider(nl.b3p.xml.ows.v100.ServiceProvider serviceProvider)
    {
        this._serviceProvider = serviceProvider;
    } //-- void setServiceProvider(nl.b3p.xml.ows.v100.ServiceProvider) 

    /**
     * Sets the value of field 'updateSequence'.
     * 
     * @param updateSequence the value of field 'updateSequence'.
     */
    public void setUpdateSequence(java.lang.String updateSequence)
    {
        this._updateSequence = updateSequence;
    } //-- void setUpdateSequence(java.lang.String) 

    /**
     * Sets the value of field 'version'.
     * 
     * @param version the value of field 'version'.
     */
    public void setVersion(java.lang.String version)
    {
        this._version = version;
    } //-- void setVersion(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return CapabilitiesBaseType
     */
    public static nl.b3p.xml.ows.v100.CapabilitiesBaseType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.CapabilitiesBaseType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.CapabilitiesBaseType.class, reader);
    } //-- nl.b3p.xml.ows.v100.CapabilitiesBaseType unmarshal(java.io.Reader) 

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
