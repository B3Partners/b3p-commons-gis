/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v110;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Reports the list of identifiers of all features created 
 *  by a transaction request. New features are created using
 *  the Insert action and the list of idetifiers must be 
 *  presented in the same order as the Insert actions were
 *  encountered in the transaction request. Features may
 *  optionally be correlated with identifiers using the 
 *  handle attribute (if it was specified on the Insert 
 *  element).
 *  
 * 
 * @version $Revision$ $Date$
 */
public class InsertResultsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _featureList
     */
    private java.util.ArrayList _featureList;


      //----------------/
     //- Constructors -/
    //----------------/

    public InsertResultsType() 
     {
        super();
        _featureList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v110.InsertResultsType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addFeature
     * 
     * 
     * 
     * @param vFeature
     */
    public void addFeature(nl.b3p.xml.wfs.v110.Feature vFeature)
        throws java.lang.IndexOutOfBoundsException
    {
        _featureList.add(vFeature);
    } //-- void addFeature(nl.b3p.xml.wfs.v110.Feature) 

    /**
     * Method addFeature
     * 
     * 
     * 
     * @param index
     * @param vFeature
     */
    public void addFeature(int index, nl.b3p.xml.wfs.v110.Feature vFeature)
        throws java.lang.IndexOutOfBoundsException
    {
        _featureList.add(index, vFeature);
    } //-- void addFeature(int, nl.b3p.xml.wfs.v110.Feature) 

    /**
     * Method clearFeature
     * 
     */
    public void clearFeature()
    {
        _featureList.clear();
    } //-- void clearFeature() 

    /**
     * Method enumerateFeature
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateFeature()
    {
        return Collections.enumeration(_featureList);
    } //-- java.util.Enumeration enumerateFeature() 

    /**
     * Method getFeature
     * 
     * 
     * 
     * @param index
     * @return Feature
     */
    public nl.b3p.xml.wfs.v110.Feature getFeature(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _featureList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v110.Feature) _featureList.get(index);
    } //-- nl.b3p.xml.wfs.v110.Feature getFeature(int) 

    /**
     * Method getFeature
     * 
     * 
     * 
     * @return Feature
     */
    public nl.b3p.xml.wfs.v110.Feature[] getFeature()
    {
        int size = _featureList.size();
        nl.b3p.xml.wfs.v110.Feature[] mArray = new nl.b3p.xml.wfs.v110.Feature[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v110.Feature) _featureList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v110.Feature[] getFeature() 

    /**
     * Method getFeatureCount
     * 
     * 
     * 
     * @return int
     */
    public int getFeatureCount()
    {
        return _featureList.size();
    } //-- int getFeatureCount() 

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
     * Method removeFeature
     * 
     * 
     * 
     * @param vFeature
     * @return boolean
     */
    public boolean removeFeature(nl.b3p.xml.wfs.v110.Feature vFeature)
    {
        boolean removed = _featureList.remove(vFeature);
        return removed;
    } //-- boolean removeFeature(nl.b3p.xml.wfs.v110.Feature) 

    /**
     * Method setFeature
     * 
     * 
     * 
     * @param index
     * @param vFeature
     */
    public void setFeature(int index, nl.b3p.xml.wfs.v110.Feature vFeature)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _featureList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _featureList.set(index, vFeature);
    } //-- void setFeature(int, nl.b3p.xml.wfs.v110.Feature) 

    /**
     * Method setFeature
     * 
     * 
     * 
     * @param featureArray
     */
    public void setFeature(nl.b3p.xml.wfs.v110.Feature[] featureArray)
    {
        //-- copy array
        _featureList.clear();
        for (int i = 0; i < featureArray.length; i++) {
            _featureList.add(featureArray[i]);
        }
    } //-- void setFeature(nl.b3p.xml.wfs.v110.Feature) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return InsertResultsType
     */
    public static nl.b3p.xml.wfs.v110.InsertResultsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.InsertResultsType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.InsertResultsType.class, reader);
    } //-- nl.b3p.xml.wfs.v110.InsertResultsType unmarshal(java.io.Reader) 

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
