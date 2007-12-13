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
 * Class ServiceType.
 * 
 * @version $Revision$ $Date$
 */
public class ServiceType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _title
     */
    private java.lang.String _title;

    /**
     * Field _abstract
     */
    private java.lang.String _abstract;

    /**
     * Field _keywords
     */
    private java.lang.String _keywords;

    /**
     * Field _onlineResource
     */
    private java.lang.Object _onlineResource;

    /**
     * Field _fees
     */
    private java.lang.String _fees;

    /**
     * Field _accessConstraints
     */
    private java.lang.String _accessConstraints;


      //----------------/
     //- Constructors -/
    //----------------/

    public ServiceType() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v100.capabilities.ServiceType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'abstract'.
     * 
     * @return String
     * @return the value of field 'abstract'.
     */
    public java.lang.String getAbstract()
    {
        return this._abstract;
    } //-- java.lang.String getAbstract() 

    /**
     * Returns the value of field 'accessConstraints'.
     * 
     * @return String
     * @return the value of field 'accessConstraints'.
     */
    public java.lang.String getAccessConstraints()
    {
        return this._accessConstraints;
    } //-- java.lang.String getAccessConstraints() 

    /**
     * Returns the value of field 'fees'.
     * 
     * @return String
     * @return the value of field 'fees'.
     */
    public java.lang.String getFees()
    {
        return this._fees;
    } //-- java.lang.String getFees() 

    /**
     * Returns the value of field 'keywords'.
     * 
     * @return String
     * @return the value of field 'keywords'.
     */
    public java.lang.String getKeywords()
    {
        return this._keywords;
    } //-- java.lang.String getKeywords() 

    /**
     * Returns the value of field 'name'.
     * 
     * @return String
     * @return the value of field 'name'.
     */
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Returns the value of field 'onlineResource'.
     * 
     * @return Object
     * @return the value of field 'onlineResource'.
     */
    public java.lang.Object getOnlineResource()
    {
        return this._onlineResource;
    } //-- java.lang.Object getOnlineResource() 

    /**
     * Returns the value of field 'title'.
     * 
     * @return String
     * @return the value of field 'title'.
     */
    public java.lang.String getTitle()
    {
        return this._title;
    } //-- java.lang.String getTitle() 

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
     * Sets the value of field 'abstract'.
     * 
     * @param _abstract
     * @param abstract the value of field 'abstract'.
     */
    public void setAbstract(java.lang.String _abstract)
    {
        this._abstract = _abstract;
    } //-- void setAbstract(java.lang.String) 

    /**
     * Sets the value of field 'accessConstraints'.
     * 
     * @param accessConstraints the value of field
     * 'accessConstraints'.
     */
    public void setAccessConstraints(java.lang.String accessConstraints)
    {
        this._accessConstraints = accessConstraints;
    } //-- void setAccessConstraints(java.lang.String) 

    /**
     * Sets the value of field 'fees'.
     * 
     * @param fees the value of field 'fees'.
     */
    public void setFees(java.lang.String fees)
    {
        this._fees = fees;
    } //-- void setFees(java.lang.String) 

    /**
     * Sets the value of field 'keywords'.
     * 
     * @param keywords the value of field 'keywords'.
     */
    public void setKeywords(java.lang.String keywords)
    {
        this._keywords = keywords;
    } //-- void setKeywords(java.lang.String) 

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Sets the value of field 'onlineResource'.
     * 
     * @param onlineResource the value of field 'onlineResource'.
     */
    public void setOnlineResource(java.lang.Object onlineResource)
    {
        this._onlineResource = onlineResource;
    } //-- void setOnlineResource(java.lang.Object) 

    /**
     * Sets the value of field 'title'.
     * 
     * @param title the value of field 'title'.
     */
    public void setTitle(java.lang.String title)
    {
        this._title = title;
    } //-- void setTitle(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return ServiceType
     */
    public static nl.b3p.xml.wfs.v100.capabilities.ServiceType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.capabilities.ServiceType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.capabilities.ServiceType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.capabilities.ServiceType unmarshal(java.io.Reader) 

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
