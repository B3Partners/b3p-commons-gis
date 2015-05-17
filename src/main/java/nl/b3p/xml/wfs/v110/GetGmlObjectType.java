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
 * A GetGmlObjectType element contains exactly one GmlObjectId. 
 *  The value of the gml:id attribute on that GmlObjectId is used 
 *  as a unique key to retrieve the complex element with a 
 *  gml:id attribute with the same value. 
 *  
 * 
 * @version $Revision$ $Date$
 */
public class GetGmlObjectType extends nl.b3p.xml.wfs.v110.BaseRequestType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _outputFormat
     */
    private java.lang.String _outputFormat = "GML3";

    /**
     * This attribute indicates the depth to which nested
     *  property XLink linking element locator attribute
     *  (href) XLinks are traversed and resolved if possible.
     *  A value of "1" indicates that one linking element
     *  locator attribute (href) XLink will be traversed
     *  and the referenced element returned if possible, but
     *  nested property XLink linking element locator attribute
     *  (href) XLinks in the returned element are not traversed.
     *  A value of "*" indicates that all nested property XLink
     *  linking element locator attribute (href) XLinks will be
     *  traversed and the referenced elements returned if
     *  possible. The range of valid values for this attribute
     *  consists of positive integers plus "*".
     *  
     */
    private java.lang.String _traverseXlinkDepth;

    /**
     * The traverseXlinkExpiry attribute value is specified
     *  in minutes. It indicates how long a Web Feature Service
     *  should wait to receive a response to a nested GetGmlObject
     *  request. 
     *  
     */
    private int _traverseXlinkExpiry;

    /**
     * keeps track of state for field: _traverseXlinkExpiry
     */
    private boolean _has_traverseXlinkExpiry;

    /**
     * Field _gmlObjectId
     */
    private nl.b3p.xml.ogc.v110.GmlObjectId _gmlObjectId;


      //----------------/
     //- Constructors -/
    //----------------/

    public GetGmlObjectType() 
     {
        super();
        setOutputFormat("GML3");
    } //-- nl.b3p.xml.wfs.v110.GetGmlObjectType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteTraverseXlinkExpiry
     * 
     */
    public void deleteTraverseXlinkExpiry()
    {
        this._has_traverseXlinkExpiry= false;
    } //-- void deleteTraverseXlinkExpiry() 

    /**
     * Returns the value of field 'gmlObjectId'.
     * 
     * @return GmlObjectId
     * @return the value of field 'gmlObjectId'.
     */
    public nl.b3p.xml.ogc.v110.GmlObjectId getGmlObjectId()
    {
        return this._gmlObjectId;
    } //-- nl.b3p.xml.ogc.v110.GmlObjectId getGmlObjectId() 

    /**
     * Returns the value of field 'outputFormat'.
     * 
     * @return String
     * @return the value of field 'outputFormat'.
     */
    public java.lang.String getOutputFormat()
    {
        return this._outputFormat;
    } //-- java.lang.String getOutputFormat() 

    /**
     * Returns the value of field 'traverseXlinkDepth'. The field
     * 'traverseXlinkDepth' has the following description: This
     * attribute indicates the depth to which nested
     *  property XLink linking element locator attribute
     *  (href) XLinks are traversed and resolved if possible.
     *  A value of "1" indicates that one linking element
     *  locator attribute (href) XLink will be traversed
     *  and the referenced element returned if possible, but
     *  nested property XLink linking element locator attribute
     *  (href) XLinks in the returned element are not traversed.
     *  A value of "*" indicates that all nested property XLink
     *  linking element locator attribute (href) XLinks will be
     *  traversed and the referenced elements returned if
     *  possible. The range of valid values for this attribute
     *  consists of positive integers plus "*".
     *  
     * 
     * @return String
     * @return the value of field 'traverseXlinkDepth'.
     */
    public java.lang.String getTraverseXlinkDepth()
    {
        return this._traverseXlinkDepth;
    } //-- java.lang.String getTraverseXlinkDepth() 

    /**
     * Returns the value of field 'traverseXlinkExpiry'. The field
     * 'traverseXlinkExpiry' has the following description: The
     * traverseXlinkExpiry attribute value is specified
     *  in minutes. It indicates how long a Web Feature Service
     *  should wait to receive a response to a nested GetGmlObject
     *  request. 
     *  
     * 
     * @return int
     * @return the value of field 'traverseXlinkExpiry'.
     */
    public int getTraverseXlinkExpiry()
    {
        return this._traverseXlinkExpiry;
    } //-- int getTraverseXlinkExpiry() 

    /**
     * Method hasTraverseXlinkExpiry
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasTraverseXlinkExpiry()
    {
        return this._has_traverseXlinkExpiry;
    } //-- boolean hasTraverseXlinkExpiry() 

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
     * Sets the value of field 'gmlObjectId'.
     * 
     * @param gmlObjectId the value of field 'gmlObjectId'.
     */
    public void setGmlObjectId(nl.b3p.xml.ogc.v110.GmlObjectId gmlObjectId)
    {
        this._gmlObjectId = gmlObjectId;
    } //-- void setGmlObjectId(nl.b3p.xml.ogc.v110.GmlObjectId) 

    /**
     * Sets the value of field 'outputFormat'.
     * 
     * @param outputFormat the value of field 'outputFormat'.
     */
    public void setOutputFormat(java.lang.String outputFormat)
    {
        this._outputFormat = outputFormat;
    } //-- void setOutputFormat(java.lang.String) 

    /**
     * Sets the value of field 'traverseXlinkDepth'. The field
     * 'traverseXlinkDepth' has the following description: This
     * attribute indicates the depth to which nested
     *  property XLink linking element locator attribute
     *  (href) XLinks are traversed and resolved if possible.
     *  A value of "1" indicates that one linking element
     *  locator attribute (href) XLink will be traversed
     *  and the referenced element returned if possible, but
     *  nested property XLink linking element locator attribute
     *  (href) XLinks in the returned element are not traversed.
     *  A value of "*" indicates that all nested property XLink
     *  linking element locator attribute (href) XLinks will be
     *  traversed and the referenced elements returned if
     *  possible. The range of valid values for this attribute
     *  consists of positive integers plus "*".
     *  
     * 
     * @param traverseXlinkDepth the value of field
     * 'traverseXlinkDepth'.
     */
    public void setTraverseXlinkDepth(java.lang.String traverseXlinkDepth)
    {
        this._traverseXlinkDepth = traverseXlinkDepth;
    } //-- void setTraverseXlinkDepth(java.lang.String) 

    /**
     * Sets the value of field 'traverseXlinkExpiry'. The field
     * 'traverseXlinkExpiry' has the following description: The
     * traverseXlinkExpiry attribute value is specified
     *  in minutes. It indicates how long a Web Feature Service
     *  should wait to receive a response to a nested GetGmlObject
     *  request. 
     *  
     * 
     * @param traverseXlinkExpiry the value of field
     * 'traverseXlinkExpiry'.
     */
    public void setTraverseXlinkExpiry(int traverseXlinkExpiry)
    {
        this._traverseXlinkExpiry = traverseXlinkExpiry;
        this._has_traverseXlinkExpiry = true;
    } //-- void setTraverseXlinkExpiry(int) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return BaseRequestType
     */
    public static nl.b3p.xml.wfs.v110.BaseRequestType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.BaseRequestType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.GetGmlObjectType.class, reader);
    } //-- nl.b3p.xml.wfs.v110.BaseRequestType unmarshal(java.io.Reader) 

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
