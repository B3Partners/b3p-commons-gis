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
 * Class BBOXType.
 * 
 * @version $Revision$ $Date$
 */
public class BBOXType extends nl.b3p.xml.ogc.v100.SpatialOpsType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _propertyName
     */
    private nl.b3p.xml.ogc.v100.PropertyName _propertyName;

    /**
     * Field _box
     */
    private java.lang.Object _box;


      //----------------/
     //- Constructors -/
    //----------------/

    public BBOXType() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v100.BBOXType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'box'.
     * 
     * @return Object
     * @return the value of field 'box'.
     */
    public java.lang.Object getBox()
    {
        return this._box;
    } //-- java.lang.Object getBox() 

    /**
     * Returns the value of field 'propertyName'.
     * 
     * @return PropertyName
     * @return the value of field 'propertyName'.
     */
    public nl.b3p.xml.ogc.v100.PropertyName getPropertyName()
    {
        return this._propertyName;
    } //-- nl.b3p.xml.ogc.v100.PropertyName getPropertyName() 

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
     * Sets the value of field 'box'.
     * 
     * @param box the value of field 'box'.
     */
    public void setBox(java.lang.Object box)
    {
        this._box = box;
    } //-- void setBox(java.lang.Object) 

    /**
     * Sets the value of field 'propertyName'.
     * 
     * @param propertyName the value of field 'propertyName'.
     */
    public void setPropertyName(nl.b3p.xml.ogc.v100.PropertyName propertyName)
    {
        this._propertyName = propertyName;
    } //-- void setPropertyName(nl.b3p.xml.ogc.v100.PropertyName) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return SpatialOpsType
     */
    public static nl.b3p.xml.ogc.v100.SpatialOpsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v100.SpatialOpsType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.BBOXType.class, reader);
    } //-- nl.b3p.xml.ogc.v100.SpatialOpsType unmarshal(java.io.Reader) 

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
