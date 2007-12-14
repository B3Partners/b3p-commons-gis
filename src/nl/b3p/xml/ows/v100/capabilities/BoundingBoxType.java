/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100.capabilities;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
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
    private java.util.ArrayList _lowerCornerList;

    /**
     * Position of the bounding box corner at which the value of
     * each coordinate normally is the algebraic maximum within
     * this bounding box. In some cases, this position is normally
     * displayed at the bottom, such as the bottom right for some
     * image coordinates. For more information, see Subclauses
     * 10.2.5 and C.13. 
     */
    private java.util.ArrayList _upperCornerList;


      //----------------/
     //- Constructors -/
    //----------------/

    public BoundingBoxType() 
     {
        super();
        _lowerCornerList = new java.util.ArrayList();
        _upperCornerList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.capabilities.BoundingBoxType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addLowerCorner
     * 
     * 
     * 
     * @param vLowerCorner
     */
    public void addLowerCorner(double vLowerCorner)
        throws java.lang.IndexOutOfBoundsException
    {
        _lowerCornerList.add(new java.lang.Double(vLowerCorner));
    } //-- void addLowerCorner(double) 

    /**
     * Method addLowerCorner
     * 
     * 
     * 
     * @param index
     * @param vLowerCorner
     */
    public void addLowerCorner(int index, double vLowerCorner)
        throws java.lang.IndexOutOfBoundsException
    {
        _lowerCornerList.add(index, new java.lang.Double(vLowerCorner));
    } //-- void addLowerCorner(int, double) 

    /**
     * Method addUpperCorner
     * 
     * 
     * 
     * @param vUpperCorner
     */
    public void addUpperCorner(double vUpperCorner)
        throws java.lang.IndexOutOfBoundsException
    {
        _upperCornerList.add(new java.lang.Double(vUpperCorner));
    } //-- void addUpperCorner(double) 

    /**
     * Method addUpperCorner
     * 
     * 
     * 
     * @param index
     * @param vUpperCorner
     */
    public void addUpperCorner(int index, double vUpperCorner)
        throws java.lang.IndexOutOfBoundsException
    {
        _upperCornerList.add(index, new java.lang.Double(vUpperCorner));
    } //-- void addUpperCorner(int, double) 

    /**
     * Method clearLowerCorner
     * 
     */
    public void clearLowerCorner()
    {
        _lowerCornerList.clear();
    } //-- void clearLowerCorner() 

    /**
     * Method clearUpperCorner
     * 
     */
    public void clearUpperCorner()
    {
        _upperCornerList.clear();
    } //-- void clearUpperCorner() 

    /**
     * Method deleteDimensions
     * 
     */
    public void deleteDimensions()
    {
        this._has_dimensions= false;
    } //-- void deleteDimensions() 

    /**
     * Method enumerateLowerCorner
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateLowerCorner()
    {
        return Collections.enumeration(_lowerCornerList);
    } //-- java.util.Enumeration enumerateLowerCorner() 

    /**
     * Method enumerateUpperCorner
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateUpperCorner()
    {
        return Collections.enumeration(_upperCornerList);
    } //-- java.util.Enumeration enumerateUpperCorner() 

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
     * Method getLowerCorner
     * 
     * 
     * 
     * @param index
     * @return double
     */
    public double getLowerCorner(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _lowerCornerList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return ((java.lang.Double)_lowerCornerList.get(index)).doubleValue();
    } //-- double getLowerCorner(int) 

    /**
     * Method getLowerCorner
     * 
     * 
     * 
     * @return double
     */
    public double[] getLowerCorner()
    {
        int size = _lowerCornerList.size();
        double[] mArray = new double[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = ((java.lang.Double)_lowerCornerList.get(index)).doubleValue();
        }
        return mArray;
    } //-- double[] getLowerCorner() 

    /**
     * Method getLowerCornerCount
     * 
     * 
     * 
     * @return int
     */
    public int getLowerCornerCount()
    {
        return _lowerCornerList.size();
    } //-- int getLowerCornerCount() 

    /**
     * Method getUpperCorner
     * 
     * 
     * 
     * @param index
     * @return double
     */
    public double getUpperCorner(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _upperCornerList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return ((java.lang.Double)_upperCornerList.get(index)).doubleValue();
    } //-- double getUpperCorner(int) 

    /**
     * Method getUpperCorner
     * 
     * 
     * 
     * @return double
     */
    public double[] getUpperCorner()
    {
        int size = _upperCornerList.size();
        double[] mArray = new double[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = ((java.lang.Double)_upperCornerList.get(index)).doubleValue();
        }
        return mArray;
    } //-- double[] getUpperCorner() 

    /**
     * Method getUpperCornerCount
     * 
     * 
     * 
     * @return int
     */
    public int getUpperCornerCount()
    {
        return _upperCornerList.size();
    } //-- int getUpperCornerCount() 

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
     * Method removeLowerCorner
     * 
     * 
     * 
     * @param vLowerCorner
     * @return boolean
     */
    public boolean removeLowerCorner(double vLowerCorner)
    {
        boolean removed = _lowerCornerList.remove(new java.lang.Double(vLowerCorner));
        return removed;
    } //-- boolean removeLowerCorner(double) 

    /**
     * Method removeUpperCorner
     * 
     * 
     * 
     * @param vUpperCorner
     * @return boolean
     */
    public boolean removeUpperCorner(double vUpperCorner)
    {
        boolean removed = _upperCornerList.remove(new java.lang.Double(vUpperCorner));
        return removed;
    } //-- boolean removeUpperCorner(double) 

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
     * Method setLowerCorner
     * 
     * 
     * 
     * @param index
     * @param vLowerCorner
     */
    public void setLowerCorner(int index, double vLowerCorner)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _lowerCornerList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _lowerCornerList.set(index, new java.lang.Double(vLowerCorner));
    } //-- void setLowerCorner(int, double) 

    /**
     * Method setLowerCorner
     * 
     * 
     * 
     * @param lowerCornerArray
     */
    public void setLowerCorner(double[] lowerCornerArray)
    {
        //-- copy array
        _lowerCornerList.clear();
        for (int i = 0; i < lowerCornerArray.length; i++) {
            _lowerCornerList.add(new java.lang.Double(lowerCornerArray[i]));
        }
    } //-- void setLowerCorner(double) 

    /**
     * Method setUpperCorner
     * 
     * 
     * 
     * @param index
     * @param vUpperCorner
     */
    public void setUpperCorner(int index, double vUpperCorner)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _upperCornerList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _upperCornerList.set(index, new java.lang.Double(vUpperCorner));
    } //-- void setUpperCorner(int, double) 

    /**
     * Method setUpperCorner
     * 
     * 
     * 
     * @param upperCornerArray
     */
    public void setUpperCorner(double[] upperCornerArray)
    {
        //-- copy array
        _upperCornerList.clear();
        for (int i = 0; i < upperCornerArray.length; i++) {
            _upperCornerList.add(new java.lang.Double(upperCornerArray[i]));
        }
    } //-- void setUpperCorner(double) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return BoundingBoxType
     */
    public static nl.b3p.xml.ows.v100.capabilities.BoundingBoxType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.capabilities.BoundingBoxType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.capabilities.BoundingBoxType.class, reader);
    } //-- nl.b3p.xml.ows.v100.capabilities.BoundingBoxType unmarshal(java.io.Reader) 

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
