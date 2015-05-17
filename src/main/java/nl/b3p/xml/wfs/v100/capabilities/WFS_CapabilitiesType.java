/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100.capabilities;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class WFS_CapabilitiesType.
 * 
 * @version $Revision$ $Date$
 */
public class WFS_CapabilitiesType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _version
     */
    private java.lang.String _version = "1.0.0";

    /**
     * Field _updateSequence
     */
    private int _updateSequence = 0;

    /**
     * keeps track of state for field: _updateSequence
     */
    private boolean _has_updateSequence;

    /**
     * Field _service
     */
    private nl.b3p.xml.wfs.v100.capabilities.Service _service;

    /**
     * Field _capability
     */
    private nl.b3p.xml.wfs.v100.capabilities.Capability _capability;

    /**
     * Field _featureTypeList
     */
    private nl.b3p.xml.wfs.v100.capabilities.FeatureTypeList _featureTypeList;

    /**
     * Field _filter_Capabilities
     */
    private nl.b3p.xml.ogc.v100.capabilities.Filter_Capabilities _filter_Capabilities;


      //----------------/
     //- Constructors -/
    //----------------/

    public WFS_CapabilitiesType() 
     {
        super();
        setVersion("1.0.0");
    } //-- nl.b3p.xml.wfs.v100.capabilities.WFS_CapabilitiesType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteUpdateSequence
     * 
     */
    public void deleteUpdateSequence()
    {
        this._has_updateSequence= false;
    } //-- void deleteUpdateSequence() 

    /**
     * Returns the value of field 'capability'.
     * 
     * @return Capability
     * @return the value of field 'capability'.
     */
    public nl.b3p.xml.wfs.v100.capabilities.Capability getCapability()
    {
        return this._capability;
    } //-- nl.b3p.xml.wfs.v100.capabilities.Capability getCapability() 

    /**
     * Returns the value of field 'featureTypeList'.
     * 
     * @return FeatureTypeList
     * @return the value of field 'featureTypeList'.
     */
    public nl.b3p.xml.wfs.v100.capabilities.FeatureTypeList getFeatureTypeList()
    {
        return this._featureTypeList;
    } //-- nl.b3p.xml.wfs.v100.capabilities.FeatureTypeList getFeatureTypeList() 

    /**
     * Returns the value of field 'filter_Capabilities'.
     * 
     * @return Filter_Capabilities
     * @return the value of field 'filter_Capabilities'.
     */
    public nl.b3p.xml.ogc.v100.capabilities.Filter_Capabilities getFilter_Capabilities()
    {
        return this._filter_Capabilities;
    } //-- nl.b3p.xml.ogc.v100.Filter_Capabilities getFilter_Capabilities() 

    /**
     * Returns the value of field 'service'.
     * 
     * @return Service
     * @return the value of field 'service'.
     */
    public nl.b3p.xml.wfs.v100.capabilities.Service getService()
    {
        return this._service;
    } //-- nl.b3p.xml.wfs.v100.capabilities.Service getService() 

    /**
     * Returns the value of field 'updateSequence'.
     * 
     * @return int
     * @return the value of field 'updateSequence'.
     */
    public int getUpdateSequence()
    {
        return this._updateSequence;
    } //-- int getUpdateSequence() 

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
     * Method hasUpdateSequence
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasUpdateSequence()
    {
        return this._has_updateSequence;
    } //-- boolean hasUpdateSequence() 

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
     * Sets the value of field 'capability'.
     * 
     * @param capability the value of field 'capability'.
     */
    public void setCapability(nl.b3p.xml.wfs.v100.capabilities.Capability capability)
    {
        this._capability = capability;
    } //-- void setCapability(nl.b3p.xml.wfs.v100.capabilities.Capability) 

    /**
     * Sets the value of field 'featureTypeList'.
     * 
     * @param featureTypeList the value of field 'featureTypeList'.
     */
    public void setFeatureTypeList(nl.b3p.xml.wfs.v100.capabilities.FeatureTypeList featureTypeList)
    {
        this._featureTypeList = featureTypeList;
    } //-- void setFeatureTypeList(nl.b3p.xml.wfs.v100.capabilities.FeatureTypeList) 

    /**
     * Sets the value of field 'filter_Capabilities'.
     * 
     * @param filter_Capabilities the value of field
     * 'filter_Capabilities'.
     */
    public void setFilter_Capabilities(nl.b3p.xml.ogc.v100.capabilities.Filter_Capabilities filter_Capabilities)
    {
        this._filter_Capabilities = filter_Capabilities;
    } //-- void setFilter_Capabilities(nl.b3p.xml.ogc.v100.Filter_Capabilities) 

    /**
     * Sets the value of field 'service'.
     * 
     * @param service the value of field 'service'.
     */
    public void setService(nl.b3p.xml.wfs.v100.capabilities.Service service)
    {
        this._service = service;
    } //-- void setService(nl.b3p.xml.wfs.v100.capabilities.Service) 

    /**
     * Sets the value of field 'updateSequence'.
     * 
     * @param updateSequence the value of field 'updateSequence'.
     */
    public void setUpdateSequence(int updateSequence)
    {
        this._updateSequence = updateSequence;
        this._has_updateSequence = true;
    } //-- void setUpdateSequence(int) 

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
     * @return WFS_CapabilitiesType
     */
    public static nl.b3p.xml.wfs.v100.capabilities.WFS_CapabilitiesType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.capabilities.WFS_CapabilitiesType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.capabilities.WFS_CapabilitiesType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.capabilities.WFS_CapabilitiesType unmarshal(java.io.Reader) 

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
