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
 * Class Spatial_CapabilitiesType.
 * 
 * @version $Revision$ $Date$
 */
public class Spatial_CapabilitiesType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _spatial_Operators
     */
    private nl.b3p.xml.ogc.v100.Spatial_Operators _spatial_Operators;


      //----------------/
     //- Constructors -/
    //----------------/

    public Spatial_CapabilitiesType() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v100.Spatial_CapabilitiesType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'spatial_Operators'.
     * 
     * @return Spatial_Operators
     * @return the value of field 'spatial_Operators'.
     */
    public nl.b3p.xml.ogc.v100.Spatial_Operators getSpatial_Operators()
    {
        return this._spatial_Operators;
    } //-- nl.b3p.xml.ogc.v100.Spatial_Operators getSpatial_Operators() 

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
     * Sets the value of field 'spatial_Operators'.
     * 
     * @param spatial_Operators the value of field
     * 'spatial_Operators'.
     */
    public void setSpatial_Operators(nl.b3p.xml.ogc.v100.Spatial_Operators spatial_Operators)
    {
        this._spatial_Operators = spatial_Operators;
    } //-- void setSpatial_Operators(nl.b3p.xml.ogc.v100.Spatial_Operators) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Spatial_CapabilitiesType
     */
    public static nl.b3p.xml.ogc.v100.Spatial_CapabilitiesType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v100.Spatial_CapabilitiesType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.Spatial_CapabilitiesType.class, reader);
    } //-- nl.b3p.xml.ogc.v100.Spatial_CapabilitiesType unmarshal(java.io.Reader) 

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
