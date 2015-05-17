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
 * This element may be used in place of an wfs:PropertyName element
 *  in a wfs:Query element in a wfs:GetFeature element to
 * selectively
 *  request the traversal of nested XLinks in the returned element
 * for
 *  the named property. This element may not be used in other
 * requests
 *  -- GetFeatureWithLock, LockFeature, Insert, Update, Delete --
 * in
 *  this version of the WFS specification.
 *  
 * 
 * @version $Revision$ $Date$
 */
public class XlinkPropertyName implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * internal content storage
     */
    private java.lang.String _content = "";

    /**
     * This attribute indicates the depth to which nested property
     *  XLink linking element locator attribute (href) XLinks are
     *  traversed and resolved if possible. A value of "1"
     * indicates
     *  that one linking element locator attribute (href) Xlink
     *  will be traversed and the referenced element returned if
     *  possible, but nested property XLink linking element locator
     *  attribute (href) XLinks in the returned element are not
     *  traversed. A value of "*" indicates that all nested
     * property
     *  XLink linking element locator attribute (href) XLinks will
     * be
     *  traversed and the referenced elements returned if possible.
     *  The range of valid values for this attribute consists of
     *  positive integers plus "*".
     *  
     */
    private java.lang.String _traverseXlinkDepth;

    /**
     * The traverseXlinkExpiry attribute value is specified in
     *  minutes It indicates how long a Web Feature Service should
     *  wait to receive a response to a nested GetGmlObject
     * request. 
     *  
     */
    private int _traverseXlinkExpiry;

    /**
     * keeps track of state for field: _traverseXlinkExpiry
     */
    private boolean _has_traverseXlinkExpiry;


      //----------------/
     //- Constructors -/
    //----------------/

    public XlinkPropertyName() 
     {
        super();
        setContent("");
    } //-- nl.b3p.xml.wfs.v110.XlinkPropertyName()


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
     * Returns the value of field 'content'. The field 'content'
     * has the following description: internal content storage
     * 
     * @return String
     * @return the value of field 'content'.
     */
    public java.lang.String getContent()
    {
        return this._content;
    } //-- java.lang.String getContent() 

    /**
     * Returns the value of field 'traverseXlinkDepth'. The field
     * 'traverseXlinkDepth' has the following description: This
     * attribute indicates the depth to which nested property
     *  XLink linking element locator attribute (href) XLinks are
     *  traversed and resolved if possible. A value of "1"
     * indicates
     *  that one linking element locator attribute (href) Xlink
     *  will be traversed and the referenced element returned if
     *  possible, but nested property XLink linking element locator
     *  attribute (href) XLinks in the returned element are not
     *  traversed. A value of "*" indicates that all nested
     * property
     *  XLink linking element locator attribute (href) XLinks will
     * be
     *  traversed and the referenced elements returned if possible.
     *  The range of valid values for this attribute consists of
     *  positive integers plus "*".
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
     * traverseXlinkExpiry attribute value is specified in
     *  minutes It indicates how long a Web Feature Service should
     *  wait to receive a response to a nested GetGmlObject
     * request. 
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
     * Sets the value of field 'content'. The field 'content' has
     * the following description: internal content storage
     * 
     * @param content the value of field 'content'.
     */
    public void setContent(java.lang.String content)
    {
        this._content = content;
    } //-- void setContent(java.lang.String) 

    /**
     * Sets the value of field 'traverseXlinkDepth'. The field
     * 'traverseXlinkDepth' has the following description: This
     * attribute indicates the depth to which nested property
     *  XLink linking element locator attribute (href) XLinks are
     *  traversed and resolved if possible. A value of "1"
     * indicates
     *  that one linking element locator attribute (href) Xlink
     *  will be traversed and the referenced element returned if
     *  possible, but nested property XLink linking element locator
     *  attribute (href) XLinks in the returned element are not
     *  traversed. A value of "*" indicates that all nested
     * property
     *  XLink linking element locator attribute (href) XLinks will
     * be
     *  traversed and the referenced elements returned if possible.
     *  The range of valid values for this attribute consists of
     *  positive integers plus "*".
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
     * traverseXlinkExpiry attribute value is specified in
     *  minutes It indicates how long a Web Feature Service should
     *  wait to receive a response to a nested GetGmlObject
     * request. 
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
     * @return XlinkPropertyName
     */
    public static nl.b3p.xml.wfs.v110.XlinkPropertyName unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.XlinkPropertyName) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.XlinkPropertyName.class, reader);
    } //-- nl.b3p.xml.wfs.v110.XlinkPropertyName unmarshal(java.io.Reader) 

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
