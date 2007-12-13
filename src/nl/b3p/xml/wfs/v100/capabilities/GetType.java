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
 * Class GetType.
 * 
 * @version $Revision$ $Date$
 */
public class GetType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _onlineResource
     */
    private java.lang.String _onlineResource;


      //----------------/
     //- Constructors -/
    //----------------/

    public GetType() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v100.capabilities.GetType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'onlineResource'.
     * 
     * @return String
     * @return the value of field 'onlineResource'.
     */
    public java.lang.String getOnlineResource()
    {
        return this._onlineResource;
    } //-- java.lang.String getOnlineResource() 

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
     * Sets the value of field 'onlineResource'.
     * 
     * @param onlineResource the value of field 'onlineResource'.
     */
    public void setOnlineResource(java.lang.String onlineResource)
    {
        this._onlineResource = onlineResource;
    } //-- void setOnlineResource(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return GetType
     */
    public static nl.b3p.xml.wfs.v100.capabilities.GetType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.capabilities.GetType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.capabilities.GetType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.capabilities.GetType unmarshal(java.io.Reader) 

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
