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

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class GeometryOperandsType.
 * 
 * @version $Revision$ $Date$
 */
public class GeometryOperandsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _geometryOperandList
     */
    private java.util.ArrayList _geometryOperandList;


      //----------------/
     //- Constructors -/
    //----------------/

    public GeometryOperandsType() 
     {
        super();
        _geometryOperandList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ogc.v110.capabilities.GeometryOperandsType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addGeometryOperand
     * 
     * 
     * 
     * @param vGeometryOperand
     */
    public void addGeometryOperand(nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType vGeometryOperand)
        throws java.lang.IndexOutOfBoundsException
    {
        _geometryOperandList.add(vGeometryOperand);
    } //-- void addGeometryOperand(nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType) 

    /**
     * Method addGeometryOperand
     * 
     * 
     * 
     * @param index
     * @param vGeometryOperand
     */
    public void addGeometryOperand(int index, nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType vGeometryOperand)
        throws java.lang.IndexOutOfBoundsException
    {
        _geometryOperandList.add(index, vGeometryOperand);
    } //-- void addGeometryOperand(int, nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType) 

    /**
     * Method clearGeometryOperand
     * 
     */
    public void clearGeometryOperand()
    {
        _geometryOperandList.clear();
    } //-- void clearGeometryOperand() 

    /**
     * Method enumerateGeometryOperand
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateGeometryOperand()
    {
        return Collections.enumeration(_geometryOperandList);
    } //-- java.util.Enumeration enumerateGeometryOperand() 

    /**
     * Method getGeometryOperand
     * 
     * 
     * 
     * @param index
     * @return GeometryOperandType
     */
    public nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType getGeometryOperand(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _geometryOperandList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType) _geometryOperandList.get(index);
    } //-- nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType getGeometryOperand(int) 

    /**
     * Method getGeometryOperand
     * 
     * 
     * 
     * @return GeometryOperandType
     */
    public nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType[] getGeometryOperand()
    {
        int size = _geometryOperandList.size();
        nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType[] mArray = new nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType) _geometryOperandList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType[] getGeometryOperand() 

    /**
     * Method getGeometryOperandCount
     * 
     * 
     * 
     * @return int
     */
    public int getGeometryOperandCount()
    {
        return _geometryOperandList.size();
    } //-- int getGeometryOperandCount() 

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
     * Method removeGeometryOperand
     * 
     * 
     * 
     * @param vGeometryOperand
     * @return boolean
     */
    public boolean removeGeometryOperand(nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType vGeometryOperand)
    {
        boolean removed = _geometryOperandList.remove(vGeometryOperand);
        return removed;
    } //-- boolean removeGeometryOperand(nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType) 

    /**
     * Method setGeometryOperand
     * 
     * 
     * 
     * @param index
     * @param vGeometryOperand
     */
    public void setGeometryOperand(int index, nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType vGeometryOperand)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _geometryOperandList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _geometryOperandList.set(index, vGeometryOperand);
    } //-- void setGeometryOperand(int, nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType) 

    /**
     * Method setGeometryOperand
     * 
     * 
     * 
     * @param geometryOperandArray
     */
    public void setGeometryOperand(nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType[] geometryOperandArray)
    {
        //-- copy array
        _geometryOperandList.clear();
        for (int i = 0; i < geometryOperandArray.length; i++) {
            _geometryOperandList.add(geometryOperandArray[i]);
        }
    } //-- void setGeometryOperand(nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return GeometryOperandsType
     */
    public static nl.b3p.xml.ogc.v110.capabilities.GeometryOperandsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v110.capabilities.GeometryOperandsType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.capabilities.GeometryOperandsType.class, reader);
    } //-- nl.b3p.xml.ogc.v110.capabilities.GeometryOperandsType unmarshal(java.io.Reader) 

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
