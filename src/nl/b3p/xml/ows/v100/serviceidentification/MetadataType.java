/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100.serviceidentification;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * This element either references or contains more metadata about
 * the element that includes this element. To reference metadata
 * stored remotely, at least the xlinks:href attribute in
 * xlink:simpleLink shall be included. Either at least one of the
 * attributes in xlink:simpleLink or a substitute for the
 * AbstractMetaData element shall be included, but not both. An
 * Implementation Specification can restrict the contents of this
 * element to always be a reference or always contain metadata.
 * (Informative: This element was adapted from the metaDataProperty
 * element in GML 3.0.) 
 * 
 * @version $Revision$ $Date$
 */
public class MetadataType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Optional reference to the aspect of the element which
     * includes this "metadata" element that this metadata provides
     * more information about. 
     */
    private java.lang.String _about;

    /**
     * Field _type
     */
    private java.lang.String _type = "simple";

    /**
     * Field _href
     */
    private java.lang.Object _href;

    /**
     * Field _role
     */
    private java.lang.Object _role;

    /**
     * Field _arcrole
     */
    private java.lang.Object _arcrole;

    /**
     * Field _title
     */
    private java.lang.Object _title;

    /**
     * The 'show' attribute is used to communicate the desired
     * presentation 
     *  of the ending resource on traversal from the starting
     * resource; it's 
     *  value should be treated as follows: 
     *  new - load ending resource in a new window, frame, pane, or
     * other 
     *  presentation context
     *  replace - load the resource in the same window, frame,
     * pane, or 
     *  other presentation context
     *  embed - load ending resource in place of the presentation
     * of the 
     *  starting resource
     *  other - behavior is unconstrained; examine other markup in
     * the 
     *  link for hints 
     *  none - behavior is unconstrained 
     *  
     */
    private java.lang.Object _show;

    /**
     * The 'actuate' attribute is used to communicate the desired
     * timing 
     *  of traversal from the starting resource to the ending
     * resource; 
     *  it's value should be treated as follows:
     *  onLoad - traverse to the ending resource immediately on
     * loading 
     *  the starting resource 
     *  onRequest - traverse from the starting resource to the
     * ending 
     *  resource only on a post-loading event triggered for 
     *  this purpose 
     *  other - behavior is unconstrained; examine other markup in
     * link 
     *  for hints 
     *  none - behavior is unconstrained
     *  
     */
    private java.lang.Object _actuate;

    /**
     * Abstract element containing more metadata about the element
     * that includes the containing "metadata" element. A specific
     * server implementation, or an Implementation Specification,
     * can define concrete elements in the AbstractMetaData
     * substitution group. 
     */
    private java.lang.Object _abstractMetaData;


      //----------------/
     //- Constructors -/
    //----------------/

    public MetadataType() 
     {
        super();
        setType("simple");
    } //-- nl.b3p.xml.ows.v100.serviceidentification.MetadataType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'about'. The field 'about' has
     * the following description: Optional reference to the aspect
     * of the element which includes this "metadata" element that
     * this metadata provides more information about. 
     * 
     * @return String
     * @return the value of field 'about'.
     */
    public java.lang.String getAbout()
    {
        return this._about;
    } //-- java.lang.String getAbout() 

    /**
     * Returns the value of field 'abstractMetaData'. The field
     * 'abstractMetaData' has the following description: Abstract
     * element containing more metadata about the element that
     * includes the containing "metadata" element. A specific
     * server implementation, or an Implementation Specification,
     * can define concrete elements in the AbstractMetaData
     * substitution group. 
     * 
     * @return Object
     * @return the value of field 'abstractMetaData'.
     */
    public java.lang.Object getAbstractMetaData()
    {
        return this._abstractMetaData;
    } //-- java.lang.Object getAbstractMetaData() 

    /**
     * Returns the value of field 'actuate'. The field 'actuate'
     * has the following description: The 'actuate' attribute is
     * used to communicate the desired timing 
     *  of traversal from the starting resource to the ending
     * resource; 
     *  it's value should be treated as follows:
     *  onLoad - traverse to the ending resource immediately on
     * loading 
     *  the starting resource 
     *  onRequest - traverse from the starting resource to the
     * ending 
     *  resource only on a post-loading event triggered for 
     *  this purpose 
     *  other - behavior is unconstrained; examine other markup in
     * link 
     *  for hints 
     *  none - behavior is unconstrained
     *  
     * 
     * @return Object
     * @return the value of field 'actuate'.
     */
    public java.lang.Object getActuate()
    {
        return this._actuate;
    } //-- java.lang.Object getActuate() 

    /**
     * Returns the value of field 'arcrole'.
     * 
     * @return Object
     * @return the value of field 'arcrole'.
     */
    public java.lang.Object getArcrole()
    {
        return this._arcrole;
    } //-- java.lang.Object getArcrole() 

    /**
     * Returns the value of field 'href'.
     * 
     * @return Object
     * @return the value of field 'href'.
     */
    public java.lang.Object getHref()
    {
        return this._href;
    } //-- java.lang.Object getHref() 

    /**
     * Returns the value of field 'role'.
     * 
     * @return Object
     * @return the value of field 'role'.
     */
    public java.lang.Object getRole()
    {
        return this._role;
    } //-- java.lang.Object getRole() 

    /**
     * Returns the value of field 'show'. The field 'show' has the
     * following description: The 'show' attribute is used to
     * communicate the desired presentation 
     *  of the ending resource on traversal from the starting
     * resource; it's 
     *  value should be treated as follows: 
     *  new - load ending resource in a new window, frame, pane, or
     * other 
     *  presentation context
     *  replace - load the resource in the same window, frame,
     * pane, or 
     *  other presentation context
     *  embed - load ending resource in place of the presentation
     * of the 
     *  starting resource
     *  other - behavior is unconstrained; examine other markup in
     * the 
     *  link for hints 
     *  none - behavior is unconstrained 
     *  
     * 
     * @return Object
     * @return the value of field 'show'.
     */
    public java.lang.Object getShow()
    {
        return this._show;
    } //-- java.lang.Object getShow() 

    /**
     * Returns the value of field 'title'.
     * 
     * @return Object
     * @return the value of field 'title'.
     */
    public java.lang.Object getTitle()
    {
        return this._title;
    } //-- java.lang.Object getTitle() 

    /**
     * Returns the value of field 'type'.
     * 
     * @return String
     * @return the value of field 'type'.
     */
    public java.lang.String getType()
    {
        return this._type;
    } //-- java.lang.String getType() 

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
     * Sets the value of field 'about'. The field 'about' has the
     * following description: Optional reference to the aspect of
     * the element which includes this "metadata" element that this
     * metadata provides more information about. 
     * 
     * @param about the value of field 'about'.
     */
    public void setAbout(java.lang.String about)
    {
        this._about = about;
    } //-- void setAbout(java.lang.String) 

    /**
     * Sets the value of field 'abstractMetaData'. The field
     * 'abstractMetaData' has the following description: Abstract
     * element containing more metadata about the element that
     * includes the containing "metadata" element. A specific
     * server implementation, or an Implementation Specification,
     * can define concrete elements in the AbstractMetaData
     * substitution group. 
     * 
     * @param abstractMetaData the value of field 'abstractMetaData'
     */
    public void setAbstractMetaData(java.lang.Object abstractMetaData)
    {
        this._abstractMetaData = abstractMetaData;
    } //-- void setAbstractMetaData(java.lang.Object) 

    /**
     * Sets the value of field 'actuate'. The field 'actuate' has
     * the following description: The 'actuate' attribute is used
     * to communicate the desired timing 
     *  of traversal from the starting resource to the ending
     * resource; 
     *  it's value should be treated as follows:
     *  onLoad - traverse to the ending resource immediately on
     * loading 
     *  the starting resource 
     *  onRequest - traverse from the starting resource to the
     * ending 
     *  resource only on a post-loading event triggered for 
     *  this purpose 
     *  other - behavior is unconstrained; examine other markup in
     * link 
     *  for hints 
     *  none - behavior is unconstrained
     *  
     * 
     * @param actuate the value of field 'actuate'.
     */
    public void setActuate(java.lang.Object actuate)
    {
        this._actuate = actuate;
    } //-- void setActuate(java.lang.Object) 

    /**
     * Sets the value of field 'arcrole'.
     * 
     * @param arcrole the value of field 'arcrole'.
     */
    public void setArcrole(java.lang.Object arcrole)
    {
        this._arcrole = arcrole;
    } //-- void setArcrole(java.lang.Object) 

    /**
     * Sets the value of field 'href'.
     * 
     * @param href the value of field 'href'.
     */
    public void setHref(java.lang.Object href)
    {
        this._href = href;
    } //-- void setHref(java.lang.Object) 

    /**
     * Sets the value of field 'role'.
     * 
     * @param role the value of field 'role'.
     */
    public void setRole(java.lang.Object role)
    {
        this._role = role;
    } //-- void setRole(java.lang.Object) 

    /**
     * Sets the value of field 'show'. The field 'show' has the
     * following description: The 'show' attribute is used to
     * communicate the desired presentation 
     *  of the ending resource on traversal from the starting
     * resource; it's 
     *  value should be treated as follows: 
     *  new - load ending resource in a new window, frame, pane, or
     * other 
     *  presentation context
     *  replace - load the resource in the same window, frame,
     * pane, or 
     *  other presentation context
     *  embed - load ending resource in place of the presentation
     * of the 
     *  starting resource
     *  other - behavior is unconstrained; examine other markup in
     * the 
     *  link for hints 
     *  none - behavior is unconstrained 
     *  
     * 
     * @param show the value of field 'show'.
     */
    public void setShow(java.lang.Object show)
    {
        this._show = show;
    } //-- void setShow(java.lang.Object) 

    /**
     * Sets the value of field 'title'.
     * 
     * @param title the value of field 'title'.
     */
    public void setTitle(java.lang.Object title)
    {
        this._title = title;
    } //-- void setTitle(java.lang.Object) 

    /**
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(java.lang.String type)
    {
        this._type = type;
    } //-- void setType(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return MetadataType
     */
    public static nl.b3p.xml.ows.v100.serviceidentification.MetadataType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.serviceidentification.MetadataType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.serviceidentification.MetadataType.class, reader);
    } //-- nl.b3p.xml.ows.v100.serviceidentification.MetadataType unmarshal(java.io.Reader) 

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
