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

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class SpatialOperatorsType.
 * 
 * @version $Revision$ $Date$
 */
public class SpatialOperatorsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _spatialOperatorList
     */
    private java.util.ArrayList _spatialOperatorList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SpatialOperatorsType() 
     {
        super();
        _spatialOperatorList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ogc.v110.SpatialOperatorsType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addSpatialOperator
     * 
     * 
     * 
     * @param vSpatialOperator
     */
    public void addSpatialOperator(nl.b3p.xml.ogc.v110.SpatialOperator vSpatialOperator)
        throws java.lang.IndexOutOfBoundsException
    {
        _spatialOperatorList.add(vSpatialOperator);
    } //-- void addSpatialOperator(nl.b3p.xml.ogc.v110.SpatialOperator) 

    /**
     * Method addSpatialOperator
     * 
     * 
     * 
     * @param index
     * @param vSpatialOperator
     */
    public void addSpatialOperator(int index, nl.b3p.xml.ogc.v110.SpatialOperator vSpatialOperator)
        throws java.lang.IndexOutOfBoundsException
    {
        _spatialOperatorList.add(index, vSpatialOperator);
    } //-- void addSpatialOperator(int, nl.b3p.xml.ogc.v110.SpatialOperator) 

    /**
     * Method clearSpatialOperator
     * 
     */
    public void clearSpatialOperator()
    {
        _spatialOperatorList.clear();
    } //-- void clearSpatialOperator() 

    /**
     * Method enumerateSpatialOperator
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateSpatialOperator()
    {
        return Collections.enumeration(_spatialOperatorList);
    } //-- java.util.Enumeration enumerateSpatialOperator() 

    /**
     * Method getSpatialOperator
     * 
     * 
     * 
     * @param index
     * @return SpatialOperator
     */
    public nl.b3p.xml.ogc.v110.SpatialOperator getSpatialOperator(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _spatialOperatorList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ogc.v110.SpatialOperator) _spatialOperatorList.get(index);
    } //-- nl.b3p.xml.ogc.v110.SpatialOperator getSpatialOperator(int) 

    /**
     * Method getSpatialOperator
     * 
     * 
     * 
     * @return SpatialOperator
     */
    public nl.b3p.xml.ogc.v110.SpatialOperator[] getSpatialOperator()
    {
        int size = _spatialOperatorList.size();
        nl.b3p.xml.ogc.v110.SpatialOperator[] mArray = new nl.b3p.xml.ogc.v110.SpatialOperator[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ogc.v110.SpatialOperator) _spatialOperatorList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ogc.v110.SpatialOperator[] getSpatialOperator() 

    /**
     * Method getSpatialOperatorCount
     * 
     * 
     * 
     * @return int
     */
    public int getSpatialOperatorCount()
    {
        return _spatialOperatorList.size();
    } //-- int getSpatialOperatorCount() 

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
     * Method removeSpatialOperator
     * 
     * 
     * 
     * @param vSpatialOperator
     * @return boolean
     */
    public boolean removeSpatialOperator(nl.b3p.xml.ogc.v110.SpatialOperator vSpatialOperator)
    {
        boolean removed = _spatialOperatorList.remove(vSpatialOperator);
        return removed;
    } //-- boolean removeSpatialOperator(nl.b3p.xml.ogc.v110.SpatialOperator) 

    /**
     * Method setSpatialOperator
     * 
     * 
     * 
     * @param index
     * @param vSpatialOperator
     */
    public void setSpatialOperator(int index, nl.b3p.xml.ogc.v110.SpatialOperator vSpatialOperator)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _spatialOperatorList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _spatialOperatorList.set(index, vSpatialOperator);
    } //-- void setSpatialOperator(int, nl.b3p.xml.ogc.v110.SpatialOperator) 

    /**
     * Method setSpatialOperator
     * 
     * 
     * 
     * @param spatialOperatorArray
     */
    public void setSpatialOperator(nl.b3p.xml.ogc.v110.SpatialOperator[] spatialOperatorArray)
    {
        //-- copy array
        _spatialOperatorList.clear();
        for (int i = 0; i < spatialOperatorArray.length; i++) {
            _spatialOperatorList.add(spatialOperatorArray[i]);
        }
    } //-- void setSpatialOperator(nl.b3p.xml.ogc.v110.SpatialOperator) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return SpatialOperatorsType
     */
    public static nl.b3p.xml.ogc.v110.SpatialOperatorsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v110.SpatialOperatorsType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.SpatialOperatorsType.class, reader);
    } //-- nl.b3p.xml.ogc.v110.SpatialOperatorsType unmarshal(java.io.Reader) 

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
