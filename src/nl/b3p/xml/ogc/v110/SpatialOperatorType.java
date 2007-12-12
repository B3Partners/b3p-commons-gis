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
    private nl.b3p.xml.ogc.v110.types.SpatialOperatorNameType _name;

    /**
     * Field _geometryOperands
     */
    private nl.b3p.xml.ogc.v110.GeometryOperands _geometryOperands;


      //----------------/
     //- Constructors -/
    //----------------/

    public SpatialOperatorType() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v110.SpatialOperatorType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'geometryOperands'.
     * 
     * @return GeometryOperands
     * @return the value of field 'geometryOperands'.
     */
    public nl.b3p.xml.ogc.v110.GeometryOperands getGeometryOperands()
    {
        return this._geometryOperands;
    } //-- nl.b3p.xml.ogc.v110.GeometryOperands getGeometryOperands() 

    /**
     * Returns the value of field 'name'.
     * 
     * @return SpatialOperatorNameType
     * @return the value of field 'name'.
     */
    public nl.b3p.xml.ogc.v110.types.SpatialOperatorNameType getName()
    {
        return this._name;
    } //-- nl.b3p.xml.ogc.v110.types.SpatialOperatorNameType getName() 

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
     * Sets the value of field 'geometryOperands'.
     * 
     * @param geometryOperands the value of field 'geometryOperands'
     */
    public void setGeometryOperands(nl.b3p.xml.ogc.v110.GeometryOperands geometryOperands)
    {
        this._geometryOperands = geometryOperands;
    } //-- void setGeometryOperands(nl.b3p.xml.ogc.v110.GeometryOperands) 

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(nl.b3p.xml.ogc.v110.types.SpatialOperatorNameType name)
    {
        this._name = name;
    } //-- void setName(nl.b3p.xml.ogc.v110.types.SpatialOperatorNameType) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return SpatialOperatorType
     */
    public static nl.b3p.xml.ogc.v110.SpatialOperatorType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v110.SpatialOperatorType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.SpatialOperatorType.class, reader);
    } //-- nl.b3p.xml.ogc.v110.SpatialOperatorType unmarshal(java.io.Reader) 

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
