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
 * Class DCPTypeType.
 * 
 * @version $Revision$ $Date$
 */
public class DCPTypeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _HTTP
     */
    private nl.b3p.xml.wfs.v100.capabilities.HTTP _HTTP;


      //----------------/
     //- Constructors -/
    //----------------/

    public DCPTypeType() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v100.capabilities.DCPTypeType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'HTTP'.
     * 
     * @return HTTP
     * @return the value of field 'HTTP'.
     */
    public nl.b3p.xml.wfs.v100.capabilities.HTTP getHTTP()
    {
        return this._HTTP;
    } //-- nl.b3p.xml.wfs.v100.capabilities.HTTP getHTTP() 

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
     * Sets the value of field 'HTTP'.
     * 
     * @param HTTP the value of field 'HTTP'.
     */
    public void setHTTP(nl.b3p.xml.wfs.v100.capabilities.HTTP HTTP)
    {
        this._HTTP = HTTP;
    } //-- void setHTTP(nl.b3p.xml.wfs.v100.capabilities.HTTP) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return DCPTypeType
     */
    public static nl.b3p.xml.wfs.v100.capabilities.DCPTypeType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.capabilities.DCPTypeType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.capabilities.DCPTypeType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.capabilities.DCPTypeType unmarshal(java.io.Reader) 

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
