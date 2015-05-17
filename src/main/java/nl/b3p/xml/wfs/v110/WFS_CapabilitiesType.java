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
 * XML encoded WFS GetCapabilities operation response. This
 *  document provides clients with service metadata about a
 *  specific service instance, including metadata about the
 *  tightly-coupled data served. If the server does not implement
 *  the updateSequence parameter, the server shall always return
 *  the complete Capabilities document, without the updateSequence
 *  parameter. When the server implements the updateSequence
 *  parameter and the GetCapabilities operation request included
 *  the updateSequence parameter with the current value, the server
 *  shall return this element with only the "version" and
 *  "updateSequence" attributes. Otherwise, all optional elements
 *  shall be included or not depending on the actual value of the
 *  Contents parameter in the GetCapabilities operation request.
 *  
 * 
 * @version $Revision$ $Date$
 */
public class WFS_CapabilitiesType extends nl.b3p.xml.ows.v100.CapabilitiesBaseType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _featureTypeList
     */
    private nl.b3p.xml.wfs.v110.FeatureTypeList _featureTypeList;

    /**
     * List of GML Object types available for GetGmlObject requests
     *  
     */
    private nl.b3p.xml.wfs.v110.ServesGMLObjectTypeList _servesGMLObjectTypeList;

    /**
     * List of GML Object types that WFS is capable of serving,
     * either
     *  directly, or as validly derived types defined in a GML
     * application
     *  schema.
     *  
     */
    private nl.b3p.xml.wfs.v110.SupportsGMLObjectTypeList _supportsGMLObjectTypeList;

    /**
     * Field _filter_Capabilities
     */
    private nl.b3p.xml.ogc.v110.Filter_Capabilities _filter_Capabilities;


      //----------------/
     //- Constructors -/
    //----------------/

    public WFS_CapabilitiesType() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v110.WFS_CapabilitiesType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'featureTypeList'.
     * 
     * @return FeatureTypeList
     * @return the value of field 'featureTypeList'.
     */
    public nl.b3p.xml.wfs.v110.FeatureTypeList getFeatureTypeList()
    {
        return this._featureTypeList;
    } //-- nl.b3p.xml.wfs.v110.FeatureTypeList getFeatureTypeList() 

    /**
     * Returns the value of field 'filter_Capabilities'.
     * 
     * @return Filter_Capabilities
     * @return the value of field 'filter_Capabilities'.
     */
    public nl.b3p.xml.ogc.v110.Filter_Capabilities getFilter_Capabilities()
    {
        return this._filter_Capabilities;
    } //-- nl.b3p.xml.ogc.v110.Filter_Capabilities getFilter_Capabilities() 

    /**
     * Returns the value of field 'servesGMLObjectTypeList'. The
     * field 'servesGMLObjectTypeList' has the following
     * description: List of GML Object types available for
     * GetGmlObject requests
     *  
     * 
     * @return ServesGMLObjectTypeList
     * @return the value of field 'servesGMLObjectTypeList'.
     */
    public nl.b3p.xml.wfs.v110.ServesGMLObjectTypeList getServesGMLObjectTypeList()
    {
        return this._servesGMLObjectTypeList;
    } //-- nl.b3p.xml.wfs.v110.ServesGMLObjectTypeList getServesGMLObjectTypeList() 

    /**
     * Returns the value of field 'supportsGMLObjectTypeList'. The
     * field 'supportsGMLObjectTypeList' has the following
     * description: List of GML Object types that WFS is capable of
     * serving, either
     *  directly, or as validly derived types defined in a GML
     * application
     *  schema.
     *  
     * 
     * @return SupportsGMLObjectTypeList
     * @return the value of field 'supportsGMLObjectTypeList'.
     */
    public nl.b3p.xml.wfs.v110.SupportsGMLObjectTypeList getSupportsGMLObjectTypeList()
    {
        return this._supportsGMLObjectTypeList;
    } //-- nl.b3p.xml.wfs.v110.SupportsGMLObjectTypeList getSupportsGMLObjectTypeList() 

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
     * Sets the value of field 'featureTypeList'.
     * 
     * @param featureTypeList the value of field 'featureTypeList'.
     */
    public void setFeatureTypeList(nl.b3p.xml.wfs.v110.FeatureTypeList featureTypeList)
    {
        this._featureTypeList = featureTypeList;
    } //-- void setFeatureTypeList(nl.b3p.xml.wfs.v110.FeatureTypeList) 

    /**
     * Sets the value of field 'filter_Capabilities'.
     * 
     * @param filter_Capabilities the value of field
     * 'filter_Capabilities'.
     */
    public void setFilter_Capabilities(nl.b3p.xml.ogc.v110.Filter_Capabilities filter_Capabilities)
    {
        this._filter_Capabilities = filter_Capabilities;
    } //-- void setFilter_Capabilities(nl.b3p.xml.ogc.v110.Filter_Capabilities) 

    /**
     * Sets the value of field 'servesGMLObjectTypeList'. The field
     * 'servesGMLObjectTypeList' has the following description:
     * List of GML Object types available for GetGmlObject requests
     *  
     * 
     * @param servesGMLObjectTypeList the value of field
     * 'servesGMLObjectTypeList'.
     */
    public void setServesGMLObjectTypeList(nl.b3p.xml.wfs.v110.ServesGMLObjectTypeList servesGMLObjectTypeList)
    {
        this._servesGMLObjectTypeList = servesGMLObjectTypeList;
    } //-- void setServesGMLObjectTypeList(nl.b3p.xml.wfs.v110.ServesGMLObjectTypeList) 

    /**
     * Sets the value of field 'supportsGMLObjectTypeList'. The
     * field 'supportsGMLObjectTypeList' has the following
     * description: List of GML Object types that WFS is capable of
     * serving, either
     *  directly, or as validly derived types defined in a GML
     * application
     *  schema.
     *  
     * 
     * @param supportsGMLObjectTypeList the value of field
     * 'supportsGMLObjectTypeList'.
     */
    public void setSupportsGMLObjectTypeList(nl.b3p.xml.wfs.v110.SupportsGMLObjectTypeList supportsGMLObjectTypeList)
    {
        this._supportsGMLObjectTypeList = supportsGMLObjectTypeList;
    } //-- void setSupportsGMLObjectTypeList(nl.b3p.xml.wfs.v110.SupportsGMLObjectTypeList) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return WFS_CapabilitiesType
     */
    public static nl.b3p.xml.wfs.v110.WFS_CapabilitiesType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.WFS_CapabilitiesType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.WFS_CapabilitiesType.class, reader);
    } //-- nl.b3p.xml.wfs.v110.WFS_CapabilitiesType unmarshal(java.io.Reader) 

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
