/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class InsertElementType.
 * 
 * @version $Revision$ $Date$
 */
public class InsertElementType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _handle
     */
    private java.lang.String _handle;

    /**
     * Field _FeatureList
     */
    private java.util.ArrayList _FeatureList;


      //----------------/
     //- Constructors -/
    //----------------/

    public InsertElementType() 
     {
        super();
        _FeatureList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v100.InsertElementType()


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
    public void addFeature(java.lang.Object vFeature)
        throws java.lang.IndexOutOfBoundsException
    {
        _FeatureList.add(vFeature);
    } //-- void addFeature(java.lang.Object) 

    /**
     * Method addFeature
     * 
     * 
     * 
     * @param index
     * @param vFeature
     */
    public void addFeature(int index, java.lang.Object vFeature)
        throws java.lang.IndexOutOfBoundsException
    {
        _FeatureList.add(index, vFeature);
    } //-- void addFeature(int, java.lang.Object) 

    /**
     * Method clearFeature
     * 
     */
    public void clearFeature()
    {
        _FeatureList.clear();
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
        return Collections.enumeration(_FeatureList);
    } //-- java.util.Enumeration enumerateFeature() 

    /**
     * Method getFeature
     * 
     * 
     * 
     * @param index
     * @return Object
     */
    public java.lang.Object getFeature(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _FeatureList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (java.lang.Object) _FeatureList.get(index);
    } //-- java.lang.Object getFeature(int) 

    /**
     * Method getFeature
     * 
     * 
     * 
     * @return Object
     */
    public java.lang.Object[] getFeature()
    {
        int size = _FeatureList.size();
        java.lang.Object[] mArray = new java.lang.Object[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (java.lang.Object) _FeatureList.get(index);
        }
        return mArray;
    } //-- java.lang.Object[] getFeature() 

    /**
     * Method getFeatureCount
     * 
     * 
     * 
     * @return int
     */
    public int getFeatureCount()
    {
        return _FeatureList.size();
    } //-- int getFeatureCount() 

    /**
     * Returns the value of field 'handle'.
     * 
     * @return String
     * @return the value of field 'handle'.
     */
    public java.lang.String getHandle()
    {
        return this._handle;
    } //-- java.lang.String getHandle() 

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
    public boolean removeFeature(java.lang.Object vFeature)
    {
        boolean removed = _FeatureList.remove(vFeature);
        return removed;
    } //-- boolean removeFeature(java.lang.Object) 

    /**
     * Method setFeature
     * 
     * 
     * 
     * @param index
     * @param vFeature
     */
    public void setFeature(int index, java.lang.Object vFeature)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _FeatureList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _FeatureList.set(index, vFeature);
    } //-- void setFeature(int, java.lang.Object) 

    /**
     * Method setFeature
     * 
     * 
     * 
     * @param featureArray
     */
    public void setFeature(java.lang.Object[] featureArray)
    {
        //-- copy array
        _FeatureList.clear();
        for (int i = 0; i < featureArray.length; i++) {
            _FeatureList.add(featureArray[i]);
        }
    } //-- void setFeature(java.lang.Object) 

    /**
     * Sets the value of field 'handle'.
     * 
     * @param handle the value of field 'handle'.
     */
    public void setHandle(java.lang.String handle)
    {
        this._handle = handle;
    } //-- void setHandle(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return InsertElementType
     */
    public static nl.b3p.xml.wfs.v100.InsertElementType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.InsertElementType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.InsertElementType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.InsertElementType unmarshal(java.io.Reader) 

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
