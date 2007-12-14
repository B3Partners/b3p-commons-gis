/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100.dataidentification;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * XML encoded minimum rectangular bounding box (or region)
 * parameter, surrounding all the associated data. This box is
 * specialized for use with the 2D WGS 84 coordinate reference
 * system with decimal values of longitude and latitude. This type
 * is adapted from the general BoundingBoxType, with modified
 * contents and documentation for use with the 2D WGS 84 coordinate
 * reference system. 
 * 
 * @version $Revision$ $Date$
 */
public class WGS84BoundingBoxType extends nl.b3p.xml.ows.v100.dataidentification.BoundingBoxType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Position of the bounding box corner at which the values of
     * longitude and latitude normally are the algebraic minimums
     * within this bounding box. For more information, see
     * Subclauses 10.4.5 and C.13. 
     */
    private java.util.ArrayList _lowerCornerList;

    /**
     * Position of the bounding box corner at which the values of
     * longitude and latitude normally are the algebraic minimums
     * within this bounding box. For more information, see
     * Subclauses 10.4.5 and C.13. 
     */
    private java.util.ArrayList _upperCornerList;


      //----------------/
     //- Constructors -/
    //----------------/

    public WGS84BoundingBoxType() 
     {
        super();
        setCrs("urn:ogc:def:crs:OGC:2:84");
        _lowerCornerList = new java.util.ArrayList();
        _upperCornerList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.dataidentification.WGS84BoundingBoxType()


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
    public static nl.b3p.xml.ows.v100.dataidentification.BoundingBoxType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.dataidentification.BoundingBoxType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.dataidentification.WGS84BoundingBoxType.class, reader);
    } //-- nl.b3p.xml.ows.v100.dataidentification.BoundingBoxType unmarshal(java.io.Reader) 

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
