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
 * Class ActionType.
 * 
 * @version $Revision$ $Date$
 */
public class ActionType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The locator attribute is used to locate an action 
     *  within a <Transaction> element. The value
     *  of the locator attribute is either a string that
     *  is equal to the value of the handle attribute
     *  specified on an <Insert>, <Update>
     *  or <Delete> action. If a value is not 
     *  specified for the handle attribute then a WFS 
     *  may employ some other means of locating the 
     *  action. For example, the value of the locator
     *  attribute may be an integer indicating the order
     *  of the action (i.e. 1=First action, 2=Second action,
     *  etc.).
     *  
     */
    private java.lang.String _locator;

    /**
     * The code attribute may be used to specify an 
     *  exception code indicating why an action failed.
     *  
     */
    private java.lang.String _code;

    /**
     * If an action fails, the message element may be used
     *  to supply an exception message.
     *  
     */
    private java.lang.String _message;


      //----------------/
     //- Constructors -/
    //----------------/

    public ActionType() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v110.ActionType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'code'. The field 'code' has the
     * following description: The code attribute may be used to
     * specify an 
     *  exception code indicating why an action failed.
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
     * Returns the value of field 'locator'. The field 'locator'
     * has the following description: The locator attribute is used
     * to locate an action 
     *  within a <Transaction> element. The value
     *  of the locator attribute is either a string that
     *  is equal to the value of the handle attribute
     *  specified on an <Insert>, <Update>
     *  or <Delete> action. If a value is not 
     *  specified for the handle attribute then a WFS 
     *  may employ some other means of locating the 
     *  action. For example, the value of the locator
     *  attribute may be an integer indicating the order
     *  of the action (i.e. 1=First action, 2=Second action,
     *  etc.).
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
     * Returns the value of field 'message'. The field 'message'
     * has the following description: If an action fails, the
     * message element may be used
     *  to supply an exception message.
     *  
     * 
     * @return String
     * @return the value of field 'message'.
     */
    public java.lang.String getMessage()
    {
        return this._message;
    } //-- java.lang.String getMessage() 

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
     * following description: The code attribute may be used to
     * specify an 
     *  exception code indicating why an action failed.
     *  
     * 
     * @param code the value of field 'code'.
     */
    public void setCode(java.lang.String code)
    {
        this._code = code;
    } //-- void setCode(java.lang.String) 

    /**
     * Sets the value of field 'locator'. The field 'locator' has
     * the following description: The locator attribute is used to
     * locate an action 
     *  within a <Transaction> element. The value
     *  of the locator attribute is either a string that
     *  is equal to the value of the handle attribute
     *  specified on an <Insert>, <Update>
     *  or <Delete> action. If a value is not 
     *  specified for the handle attribute then a WFS 
     *  may employ some other means of locating the 
     *  action. For example, the value of the locator
     *  attribute may be an integer indicating the order
     *  of the action (i.e. 1=First action, 2=Second action,
     *  etc.).
     *  
     * 
     * @param locator the value of field 'locator'.
     */
    public void setLocator(java.lang.String locator)
    {
        this._locator = locator;
    } //-- void setLocator(java.lang.String) 

    /**
     * Sets the value of field 'message'. The field 'message' has
     * the following description: If an action fails, the message
     * element may be used
     *  to supply an exception message.
     *  
     * 
     * @param message the value of field 'message'.
     */
    public void setMessage(java.lang.String message)
    {
        this._message = message;
    } //-- void setMessage(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return ActionType
     */
    public static nl.b3p.xml.wfs.v110.ActionType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.ActionType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.ActionType.class, reader);
    } //-- nl.b3p.xml.wfs.v110.ActionType unmarshal(java.io.Reader) 

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
