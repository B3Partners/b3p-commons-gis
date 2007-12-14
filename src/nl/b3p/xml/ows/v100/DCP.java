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
 * Information for one distributed Computing Platform (DCP)
 * supported for this operation. At present, only the HTTP DCP is
 * defined, so this element only includes the HTTP element.
 * 
 * 
 * @version $Revision$ $Date$
 */
public class DCP implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Connect point URLs for the HTTP Distributed Computing
     * Platform (DCP). Normally, only one Get and/or one Post is
     * included in this element. More than one Get and/or Post is
     * allowed to support including alternative URLs for uses such
     * as load balancing or backup. 
     */
    private nl.b3p.xml.ows.v100.HTTP _HTTP;


      //----------------/
     //- Constructors -/
    //----------------/

    public DCP() 
     {
        super();
    } //-- nl.b3p.xml.ows.v100.DCP()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return Object
     * @return the value of field 'choiceValue'.
     */
    public java.lang.Object getChoiceValue()
    {
        return this._choiceValue;
    } //-- java.lang.Object getChoiceValue() 

    /**
     * Returns the value of field 'HTTP'. The field 'HTTP' has the
     * following description: Connect point URLs for the HTTP
     * Distributed Computing Platform (DCP). Normally, only one Get
     * and/or one Post is included in this element. More than one
     * Get and/or Post is allowed to support including alternative
     * URLs for uses such as load balancing or backup. 
     * 
     * @return HTTP
     * @return the value of field 'HTTP'.
     */
    public nl.b3p.xml.ows.v100.HTTP getHTTP()
    {
        return this._HTTP;
    } //-- nl.b3p.xml.ows.v100.HTTP getHTTP() 

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
     * Sets the value of field 'HTTP'. The field 'HTTP' has the
     * following description: Connect point URLs for the HTTP
     * Distributed Computing Platform (DCP). Normally, only one Get
     * and/or one Post is included in this element. More than one
     * Get and/or Post is allowed to support including alternative
     * URLs for uses such as load balancing or backup. 
     * 
     * @param HTTP the value of field 'HTTP'.
     */
    public void setHTTP(nl.b3p.xml.ows.v100.HTTP HTTP)
    {
        this._HTTP = HTTP;
        this._choiceValue = HTTP;
    } //-- void setHTTP(nl.b3p.xml.ows.v100.HTTP) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return DCP
     */
    public static nl.b3p.xml.ows.v100.DCP unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.DCP) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.DCP.class, reader);
    } //-- nl.b3p.xml.ows.v100.DCP unmarshal(java.io.Reader) 

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
