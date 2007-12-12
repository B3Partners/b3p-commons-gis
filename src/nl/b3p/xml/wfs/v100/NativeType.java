/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class NativeType.
 * 
 * @version $Revision$ $Date$
 */
public class NativeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The vendorId attribute is used to specify the name of
     *  vendor who's vendor specific command the client
     *  application wishes to execute.
     *  
     */
    private java.lang.String _vendorId;

    /**
     * In the event that a Web Feature Service does not recognize
     *  the vendorId or does not recognize the vendor specific
     * command,
     *  the safeToIgnore attribute is used to indicate whether the 
     *  exception can be safely ignored. A value of TRUE means that
     *  the Web Feature Service may ignore the command. A value of
     *  FALSE means that a Web Feature Service cannot ignore the
     *  command and an exception should be raised if a problem is 
     *  encountered.
     *  
     */
    private boolean _safeToIgnore;

    /**
     * keeps track of state for field: _safeToIgnore
     */
    private boolean _has_safeToIgnore;


      //----------------/
     //- Constructors -/
    //----------------/

    public NativeType() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v100.NativeType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteSafeToIgnore
     * 
     */
    public void deleteSafeToIgnore()
    {
        this._has_safeToIgnore= false;
    } //-- void deleteSafeToIgnore() 

    /**
     * Returns the value of field 'safeToIgnore'. The field
     * 'safeToIgnore' has the following description: In the event
     * that a Web Feature Service does not recognize
     *  the vendorId or does not recognize the vendor specific
     * command,
     *  the safeToIgnore attribute is used to indicate whether the 
     *  exception can be safely ignored. A value of TRUE means that
     *  the Web Feature Service may ignore the command. A value of
     *  FALSE means that a Web Feature Service cannot ignore the
     *  command and an exception should be raised if a problem is 
     *  encountered.
     *  
     * 
     * @return boolean
     * @return the value of field 'safeToIgnore'.
     */
    public boolean getSafeToIgnore()
    {
        return this._safeToIgnore;
    } //-- boolean getSafeToIgnore() 

    /**
     * Returns the value of field 'vendorId'. The field 'vendorId'
     * has the following description: The vendorId attribute is
     * used to specify the name of
     *  vendor who's vendor specific command the client
     *  application wishes to execute.
     *  
     * 
     * @return String
     * @return the value of field 'vendorId'.
     */
    public java.lang.String getVendorId()
    {
        return this._vendorId;
    } //-- java.lang.String getVendorId() 

    /**
     * Method hasSafeToIgnore
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasSafeToIgnore()
    {
        return this._has_safeToIgnore;
    } //-- boolean hasSafeToIgnore() 

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
     * Sets the value of field 'safeToIgnore'. The field
     * 'safeToIgnore' has the following description: In the event
     * that a Web Feature Service does not recognize
     *  the vendorId or does not recognize the vendor specific
     * command,
     *  the safeToIgnore attribute is used to indicate whether the 
     *  exception can be safely ignored. A value of TRUE means that
     *  the Web Feature Service may ignore the command. A value of
     *  FALSE means that a Web Feature Service cannot ignore the
     *  command and an exception should be raised if a problem is 
     *  encountered.
     *  
     * 
     * @param safeToIgnore the value of field 'safeToIgnore'.
     */
    public void setSafeToIgnore(boolean safeToIgnore)
    {
        this._safeToIgnore = safeToIgnore;
        this._has_safeToIgnore = true;
    } //-- void setSafeToIgnore(boolean) 

    /**
     * Sets the value of field 'vendorId'. The field 'vendorId' has
     * the following description: The vendorId attribute is used to
     * specify the name of
     *  vendor who's vendor specific command the client
     *  application wishes to execute.
     *  
     * 
     * @param vendorId the value of field 'vendorId'.
     */
    public void setVendorId(java.lang.String vendorId)
    {
        this._vendorId = vendorId;
    } //-- void setVendorId(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return NativeType
     */
    public static nl.b3p.xml.wfs.v100.NativeType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.NativeType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.NativeType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.NativeType unmarshal(java.io.Reader) 

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
