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
 * Class DistanceBufferType.
 * 
 * @version $Revision$ $Date$
 */
public class DistanceBufferType extends nl.b3p.xml.ogc.v110.SpatialOpsType 
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
     * Field _Geometry
     */
    private java.lang.Object _Geometry;

    /**
     * Field _distance
     */
    private nl.b3p.xml.ogc.v110.Distance _distance;


      //----------------/
     //- Constructors -/
    //----------------/

    public DistanceBufferType() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v110.DistanceBufferType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'distance'.
     * 
     * @return Distance
     * @return the value of field 'distance'.
     */
    public nl.b3p.xml.ogc.v110.Distance getDistance()
    {
        return this._distance;
    } //-- nl.b3p.xml.ogc.v110.Distance getDistance() 

    /**
     * Returns the value of field 'Geometry'.
     * 
     * @return Object
     * @return the value of field 'Geometry'.
     */
    public java.lang.Object getGeometry()
    {
        return this._Geometry;
    } //-- java.lang.Object getGeometry() 

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
     * Sets the value of field 'distance'.
     * 
     * @param distance the value of field 'distance'.
     */
    public void setDistance(nl.b3p.xml.ogc.v110.Distance distance)
    {
        this._distance = distance;
    } //-- void setDistance(nl.b3p.xml.ogc.v110.Distance) 

    /**
     * Sets the value of field 'Geometry'.
     * 
     * @param Geometry the value of field 'Geometry'.
     */
    public void setGeometry(java.lang.Object Geometry)
    {
        this._Geometry = Geometry;
    } //-- void setGeometry(java.lang.Object) 

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
        return (nl.b3p.xml.ogc.v110.SpatialOpsType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.DistanceBufferType.class, reader);
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
