/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v110.capabilities;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class SpatialOperatorType.
 * 
 * @version $Revision$ $Date$
 */
public class SpatialOperatorType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private nl.b3p.xml.ogc.v110.capabilities.types.SpatialOperatorNameType _name;

    /**
     * Field _geometryOperands_SpatialOperatorType
     */
    private nl.b3p.xml.ogc.v110.capabilities.GeometryOperands_SpatialOperatorType _geometryOperands_SpatialOperatorType;


      //----------------/
     //- Constructors -/
    //----------------/

    public SpatialOperatorType() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v110.capabilities.SpatialOperatorType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field
     * 'geometryOperands_SpatialOperatorType'.
     * 
     * @return GeometryOperands_SpatialOperatorType
     * @return the value of field
     * 'geometryOperands_SpatialOperatorType'.
     */
    public nl.b3p.xml.ogc.v110.capabilities.GeometryOperands_SpatialOperatorType getGeometryOperands_SpatialOperatorType()
    {
        return this._geometryOperands_SpatialOperatorType;
    } //-- nl.b3p.xml.ogc.v110.capabilities.GeometryOperands_SpatialOperatorType getGeometryOperands_SpatialOperatorType() 

    /**
     * Returns the value of field 'name'.
     * 
     * @return SpatialOperatorNameType
     * @return the value of field 'name'.
     */
    public nl.b3p.xml.ogc.v110.capabilities.types.SpatialOperatorNameType getName()
    {
        return this._name;
    } //-- nl.b3p.xml.ogc.v110.capabilities.types.SpatialOperatorNameType getName() 

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
     * Sets the value of field
     * 'geometryOperands_SpatialOperatorType'.
     * 
     * @param geometryOperands_SpatialOperatorType the value of
     * field 'geometryOperands_SpatialOperatorType'.
     */
    public void setGeometryOperands_SpatialOperatorType(nl.b3p.xml.ogc.v110.capabilities.GeometryOperands_SpatialOperatorType geometryOperands_SpatialOperatorType)
    {
        this._geometryOperands_SpatialOperatorType = geometryOperands_SpatialOperatorType;
    } //-- void setGeometryOperands_SpatialOperatorType(nl.b3p.xml.ogc.v110.capabilities.GeometryOperands_SpatialOperatorType) 

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(nl.b3p.xml.ogc.v110.capabilities.types.SpatialOperatorNameType name)
    {
        this._name = name;
    } //-- void setName(nl.b3p.xml.ogc.v110.capabilities.types.SpatialOperatorNameType) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return SpatialOperatorType
     */
    public static nl.b3p.xml.ogc.v110.capabilities.SpatialOperatorType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v110.capabilities.SpatialOperatorType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.capabilities.SpatialOperatorType.class, reader);
    } //-- nl.b3p.xml.ogc.v110.capabilities.SpatialOperatorType unmarshal(java.io.Reader) 

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
