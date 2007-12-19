/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * XML encoded minimum rectangular bounding box (or region)
 * parameter, surrounding all the associated data. This type is
 * adapted from the EnvelopeType of GML 3.1, with modified contents
 * and documentation for encoding a MINIMUM size box SURROUNDING
 * all associated data. 
 * 
 * @version $Revision$ $Date$
 */
public class BoundingBoxType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Usually references the definition of a CRS, as specified in
     * [OGC Topic 2]. Such a CRS definition can be XML encoded
     * using the gml:CoordinateReferenceSystemType in [GML 3.1].
     * For well known references, it is not required that a CRS
     * definition exist at the location the URI points to. If no
     * anyURI value is included, the applicable CRS must be either:
     * a) Specified outside the bounding box, but inside a data
     * structure that includes this bounding box, as specified for
     * a specific OWS use of this bounding box type.
     * b) Fixed and specified in the Implementation Specification
     * for a specific OWS use of the bounding box type. 
     */
    private java.lang.String _crs;

    /**
     * The number of dimensions in this CRS (the length of a
     * coordinate sequence in this use of the PositionType). This
     * number is specified by the CRS definition, but can also be
     * specified here. 
     */
    private int _dimensions;

    /**
     * keeps track of state for field: _dimensions
     */
    private boolean _has_dimensions;

    /**
     * Position of the bounding box corner at which the value of
     * each coordinate normally is the algebraic minimum within
     * this bounding box. In some cases, this position is normally
     * displayed at the top, such as the top left for some image
     * coordinates. For more information, see Subclauses 10.2.5 and
     * C.13. 
     */
    private java.lang.String _lowerCorner;

    /**
     * Position of the bounding box corner at which the value of
     * each coordinate normally is the algebraic maximum within
     * this bounding box. In some cases, this position is normally
     * displayed at the bottom, such as the bottom right for some
     * image coordinates. For more information, see Subclauses
     * 10.2.5 and C.13. 
     */
    private java.lang.String _upperCorner;


      //----------------/
     //- Constructors -/
    //----------------/

    public BoundingBoxType() 
     {
        super();
    } //-- nl.b3p.xml.ows.v100.BoundingBoxType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteDimensions
     * 
     */
    public void deleteDimensions()
    {
        this._has_dimensions= false;
    } //-- void deleteDimensions() 

    /**
     * Returns the value of field 'crs'. The field 'crs' has the
     * following description: Usually references the definition of
     * a CRS, as specified in [OGC Topic 2]. Such a CRS definition
     * can be XML encoded using the
     * gml:CoordinateReferenceSystemType in [GML 3.1]. For well
     * known references, it is not required that a CRS definition
     * exist at the location the URI points to. If no anyURI value
     * is included, the applicable CRS must be either:
     * a) Specified outside the bounding box, but inside a data
     * structure that includes this bounding box, as specified for
     * a specific OWS use of this bounding box type.
     * b) Fixed and specified in the Implementation Specification
     * for a specific OWS use of the bounding box type. 
     * 
     * @return String
     * @return the value of field 'crs'.
     */
    public java.lang.String getCrs()
    {
        return this._crs;
    } //-- java.lang.String getCrs() 

    /**
     * Returns the value of field 'dimensions'. The field
     * 'dimensions' has the following description: The number of
     * dimensions in this CRS (the length of a coordinate sequence
     * in this use of the PositionType). This number is specified
     * by the CRS definition, but can also be specified here. 
     * 
     * @return int
     * @return the value of field 'dimensions'.
     */
    public int getDimensions()
    {
        return this._dimensions;
    } //-- int getDimensions() 

    /**
     * Returns the value of field 'lowerCorner'. The field
     * 'lowerCorner' has the following description: Position of the
     * bounding box corner at which the value of each coordinate
     * normally is the algebraic minimum within this bounding box.
     * In some cases, this position is normally displayed at the
     * top, such as the top left for some image coordinates. For
     * more information, see Subclauses 10.2.5 and C.13. 
     * 
     * @return String
     * @return the value of field 'lowerCorner'.
     */
    public java.lang.String getLowerCorner()
    {
        return this._lowerCorner;
    } //-- java.lang.String getLowerCorner() 

    /**
     * Returns the value of field 'upperCorner'. The field
     * 'upperCorner' has the following description: Position of the
     * bounding box corner at which the value of each coordinate
     * normally is the algebraic maximum within this bounding box.
     * In some cases, this position is normally displayed at the
     * bottom, such as the bottom right for some image coordinates.
     * For more information, see Subclauses 10.2.5 and C.13. 
     * 
     * @return String
     * @return the value of field 'upperCorner'.
     */
    public java.lang.String getUpperCorner()
    {
        return this._upperCorner;
    } //-- java.lang.String getUpperCorner() 

    /**
     * Method hasDimensions
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasDimensions()
    {
        return this._has_dimensions;
    } //-- boolean hasDimensions() 

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
     * Sets the value of field 'crs'. The field 'crs' has the
     * following description: Usually references the definition of
     * a CRS, as specified in [OGC Topic 2]. Such a CRS definition
     * can be XML encoded using the
     * gml:CoordinateReferenceSystemType in [GML 3.1]. For well
     * known references, it is not required that a CRS definition
     * exist at the location the URI points to. If no anyURI value
     * is included, the applicable CRS must be either:
     * a) Specified outside the bounding box, but inside a data
     * structure that includes this bounding box, as specified for
     * a specific OWS use of this bounding box type.
     * b) Fixed and specified in the Implementation Specification
     * for a specific OWS use of the bounding box type. 
     * 
     * @param crs the value of field 'crs'.
     */
    public void setCrs(java.lang.String crs)
    {
        this._crs = crs;
    } //-- void setCrs(java.lang.String) 

    /**
     * Sets the value of field 'dimensions'. The field 'dimensions'
     * has the following description: The number of dimensions in
     * this CRS (the length of a coordinate sequence in this use of
     * the PositionType). This number is specified by the CRS
     * definition, but can also be specified here. 
     * 
     * @param dimensions the value of field 'dimensions'.
     */
    public void setDimensions(int dimensions)
    {
        this._dimensions = dimensions;
        this._has_dimensions = true;
    } //-- void setDimensions(int) 

    /**
     * Sets the value of field 'lowerCorner'. The field
     * 'lowerCorner' has the following description: Position of the
     * bounding box corner at which the value of each coordinate
     * normally is the algebraic minimum within this bounding box.
     * In some cases, this position is normally displayed at the
     * top, such as the top left for some image coordinates. For
     * more information, see Subclauses 10.2.5 and C.13. 
     * 
     * @param lowerCorner the value of field 'lowerCorner'.
     */
    public void setLowerCorner(java.lang.String lowerCorner)
    {
        this._lowerCorner = lowerCorner;
    } //-- void setLowerCorner(java.lang.String) 

    /**
     * Sets the value of field 'upperCorner'. The field
     * 'upperCorner' has the following description: Position of the
     * bounding box corner at which the value of each coordinate
     * normally is the algebraic maximum within this bounding box.
     * In some cases, this position is normally displayed at the
     * bottom, such as the bottom right for some image coordinates.
     * For more information, see Subclauses 10.2.5 and C.13. 
     * 
     * @param upperCorner the value of field 'upperCorner'.
     */
    public void setUpperCorner(java.lang.String upperCorner)
    {
        this._upperCorner = upperCorner;
    } //-- void setUpperCorner(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return BoundingBoxType
     */
    public static nl.b3p.xml.ows.v100.BoundingBoxType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.BoundingBoxType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.BoundingBoxType.class, reader);
    } //-- nl.b3p.xml.ows.v100.BoundingBoxType unmarshal(java.io.Reader) 

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
