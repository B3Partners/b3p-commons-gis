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
 * Class BinarySpatialOpTypeChoice.
 * 
 * @version $Revision$ $Date$
 */
public class BinarySpatialOpTypeChoice implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _Geometry
     */
    private java.lang.Object _Geometry;

    /**
     * Field _Point
     */
    private java.lang.Object _Point;

    /**
     * Field _Polygon
     */
    private java.lang.Object _Polygon;

    /**
     * Field _LineString
     */
    private java.lang.Object _LineString;

    /**
     * Field _box
     */
    private java.lang.Object _box;


      //----------------/
     //- Constructors -/
    //----------------/

    public BinarySpatialOpTypeChoice() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v100.BinarySpatialOpTypeChoice()


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
     * Returns the value of field 'LineString'.
     * 
     * @return Object
     * @return the value of field 'LineString'.
     */
    public java.lang.Object getLineString()
    {
        return this._LineString;
    } //-- java.lang.Object getLineString() 

    /**
     * Returns the value of field 'Point'.
     * 
     * @return Object
     * @return the value of field 'Point'.
     */
    public java.lang.Object getPoint()
    {
        return this._Point;
    } //-- java.lang.Object getPoint() 

    /**
     * Returns the value of field 'Polygon'.
     * 
     * @return Object
     * @return the value of field 'Polygon'.
     */
    public java.lang.Object getPolygon()
    {
        return this._Polygon;
    } //-- java.lang.Object getPolygon() 

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
     * Sets the value of field 'Geometry'.
     * 
     * @param Geometry the value of field 'Geometry'.
     */
    public void setGeometry(java.lang.Object Geometry)
    {
        this._Geometry = Geometry;
    } //-- void setGeometry(java.lang.Object) 

    /**
     * Sets the value of field 'LineString'.
     * 
     * @param LineString the value of field 'LineString'.
     */
    public void setLineString(java.lang.Object LineString)
    {
        this._LineString = LineString;
    } //-- void setLineString(java.lang.Object) 

    /**
     * Sets the value of field 'Point'.
     * 
     * @param Point the value of field 'Point'.
     */
    public void setPoint(java.lang.Object Point)
    {
        this._Point = Point;
    } //-- void setPoint(java.lang.Object) 

    /**
     * Sets the value of field 'Polygon'.
     * 
     * @param Polygon the value of field 'Polygon'.
     */
    public void setPolygon(java.lang.Object Polygon)
    {
        this._Polygon = Polygon;
    } //-- void setPolygon(java.lang.Object) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return BinarySpatialOpTypeChoice
     */
    public static nl.b3p.xml.ogc.v100.BinarySpatialOpTypeChoice unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v100.BinarySpatialOpTypeChoice) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.BinarySpatialOpTypeChoice.class, reader);
    } //-- nl.b3p.xml.ogc.v100.BinarySpatialOpTypeChoice unmarshal(java.io.Reader) 

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
