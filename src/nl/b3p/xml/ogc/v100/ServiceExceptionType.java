/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v100;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * The ServiceExceptionType type defines the ServiceException
 *  element. The content of the element is an exception message
 *  that the service wished to convey to the client application.
 *  
 * 
 * @version $Revision$ $Date$
 */
public class ServiceExceptionType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * internal content storage
     */
    private java.lang.String _content = "";

    /**
     * A service may associate a code with an exception
     *  by using the code attribute.
     *  
     */
    private java.lang.String _code;

    /**
     * The locator attribute may be used by a service to
     *  indicate to a client where in the client's request
     *  an exception was encountered. If the request included
     *  a 'handle' attribute, this may be used to identify the
     *  offending component of the request. Otherwise the 
     *  service may try to use other means to locate the 
     *  exception such as line numbers or byte offset from the
     *  begining of the request, etc ...
     *  
     */
    private java.lang.String _locator;


      //----------------/
     //- Constructors -/
    //----------------/

    public ServiceExceptionType() 
     {
        super();
        setContent("");
    } //-- nl.b3p.xml.ogc.v100.ServiceExceptionType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'code'. The field 'code' has the
     * following description: A service may associate a code with
     * an exception
     *  by using the code attribute.
     *  
     * 
     * @return String
     * @return the value of field 'code'.
     */
    public java.lang.String getCode()
    {
        return this._code;
    } //-- java.lang.String getCode() 

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
     * Returns the value of field 'locator'. The field 'locator'
     * has the following description: The locator attribute may be
     * used by a service to
     *  indicate to a client where in the client's request
     *  an exception was encountered. If the request included
     *  a 'handle' attribute, this may be used to identify the
     *  offending component of the request. Otherwise the 
     *  service may try to use other means to locate the 
     *  exception such as line numbers or byte offset from the
     *  begining of the request, etc ...
     *  
     * 
     * @return String
     * @return the value of field 'locator'.
     */
    public java.lang.String getLocator()
    {
        return this._locator;
    } //-- java.lang.String getLocator() 

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
     * Sets the value of field 'code'. The field 'code' has the
     * following description: A service may associate a code with
     * an exception
     *  by using the code attribute.
     *  
     * 
     * @param code the value of field 'code'.
     */
    public void setCode(java.lang.String code)
    {
        this._code = code;
    } //-- void setCode(java.lang.String) 

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
     * Sets the value of field 'locator'. The field 'locator' has
     * the following description: The locator attribute may be used
     * by a service to
     *  indicate to a client where in the client's request
     *  an exception was encountered. If the request included
     *  a 'handle' attribute, this may be used to identify the
     *  offending component of the request. Otherwise the 
     *  service may try to use other means to locate the 
     *  exception such as line numbers or byte offset from the
     *  begining of the request, etc ...
     *  
     * 
     * @param locator the value of field 'locator'.
     */
    public void setLocator(java.lang.String locator)
    {
        this._locator = locator;
    } //-- void setLocator(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return ServiceExceptionType
     */
    public static nl.b3p.xml.ogc.v100.ServiceExceptionType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v100.ServiceExceptionType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.ServiceExceptionType.class, reader);
    } //-- nl.b3p.xml.ogc.v100.ServiceExceptionType unmarshal(java.io.Reader) 

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
