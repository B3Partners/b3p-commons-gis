/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v110;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class BBOXType.
 * 
 * @version $Revision$ $Date$
 */
public class BBOXType extends nl.b3p.xml.ogc.v110.SpatialOpsType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _propertyName
     */
    private nl.b3p.xml.ogc.v110.PropertyName _propertyName;

    /**
     * Field _envelope
     */
    private java.lang.Object _envelope;


      //----------------/
     //- Constructors -/
    //----------------/

    public BBOXType() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v110.BBOXType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'envelope'.
     * 
     * @return Object
     * @return the value of field 'envelope'.
     */
    public java.lang.Object getEnvelope()
    {
        return this._envelope;
    } //-- java.lang.Object getEnvelope() 

    /**
     * Returns the value of field 'propertyName'.
     * 
     * @return PropertyName
     * @return the value of field 'propertyName'.
     */
    public nl.b3p.xml.ogc.v110.PropertyName getPropertyName()
    {
        return this._propertyName;
    } //-- nl.b3p.xml.ogc.v110.PropertyName getPropertyName() 

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
     * Sets the value of field 'envelope'.
     * 
     * @param envelope the value of field 'envelope'.
     */
    public void setEnvelope(java.lang.Object envelope)
    {
        this._envelope = envelope;
    } //-- void setEnvelope(java.lang.Object) 

    /**
     * Sets the value of field 'propertyName'.
     * 
     * @param propertyName the value of field 'propertyName'.
     */
    public void setPropertyName(nl.b3p.xml.ogc.v110.PropertyName propertyName)
    {
        this._propertyName = propertyName;
    } //-- void setPropertyName(nl.b3p.xml.ogc.v110.PropertyName) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return SpatialOpsType
     */
    public static nl.b3p.xml.ogc.v110.SpatialOpsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v110.SpatialOpsType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.BBOXType.class, reader);
    } //-- nl.b3p.xml.ogc.v110.SpatialOpsType unmarshal(java.io.Reader) 

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
