/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100.transaction;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class InsertResultType.
 * 
 * @version $Revision$ $Date$
 */
public class InsertResultType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _handle
     */
    private java.lang.String _handle;

    /**
     * Field _featureIdList
     */
    private java.util.ArrayList _featureIdList;


      //----------------/
     //- Constructors -/
    //----------------/

    public InsertResultType() 
     {
        super();
        _featureIdList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v100.transaction.InsertResultType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addFeatureId
     * 
     * 
     * 
     * @param vFeatureId
     */
    public void addFeatureId(nl.b3p.xml.ogc.v100.FeatureId vFeatureId)
        throws java.lang.IndexOutOfBoundsException
    {
        _featureIdList.add(vFeatureId);
    } //-- void addFeatureId(nl.b3p.xml.ogc.v100.FeatureId) 

    /**
     * Method addFeatureId
     * 
     * 
     * 
     * @param index
     * @param vFeatureId
     */
    public void addFeatureId(int index, nl.b3p.xml.ogc.v100.FeatureId vFeatureId)
        throws java.lang.IndexOutOfBoundsException
    {
        _featureIdList.add(index, vFeatureId);
    } //-- void addFeatureId(int, nl.b3p.xml.ogc.v100.FeatureId) 

    /**
     * Method clearFeatureId
     * 
     */
    public void clearFeatureId()
    {
        _featureIdList.clear();
    } //-- void clearFeatureId() 

    /**
     * Method enumerateFeatureId
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateFeatureId()
    {
        return Collections.enumeration(_featureIdList);
    } //-- java.util.Enumeration enumerateFeatureId() 

    /**
     * Method getFeatureId
     * 
     * 
     * 
     * @param index
     * @return FeatureId
     */
    public nl.b3p.xml.ogc.v100.FeatureId getFeatureId(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _featureIdList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ogc.v100.FeatureId) _featureIdList.get(index);
    } //-- nl.b3p.xml.ogc.v100.FeatureId getFeatureId(int) 

    /**
     * Method getFeatureId
     * 
     * 
     * 
     * @return FeatureId
     */
    public nl.b3p.xml.ogc.v100.FeatureId[] getFeatureId()
    {
        int size = _featureIdList.size();
        nl.b3p.xml.ogc.v100.FeatureId[] mArray = new nl.b3p.xml.ogc.v100.FeatureId[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ogc.v100.FeatureId) _featureIdList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ogc.v100.FeatureId[] getFeatureId() 

    /**
     * Method getFeatureIdCount
     * 
     * 
     * 
     * @return int
     */
    public int getFeatureIdCount()
    {
        return _featureIdList.size();
    } //-- int getFeatureIdCount() 

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
     * Method removeFeatureId
     * 
     * 
     * 
     * @param vFeatureId
     * @return boolean
     */
    public boolean removeFeatureId(nl.b3p.xml.ogc.v100.FeatureId vFeatureId)
    {
        boolean removed = _featureIdList.remove(vFeatureId);
        return removed;
    } //-- boolean removeFeatureId(nl.b3p.xml.ogc.v100.FeatureId) 

    /**
     * Method setFeatureId
     * 
     * 
     * 
     * @param index
     * @param vFeatureId
     */
    public void setFeatureId(int index, nl.b3p.xml.ogc.v100.FeatureId vFeatureId)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _featureIdList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _featureIdList.set(index, vFeatureId);
    } //-- void setFeatureId(int, nl.b3p.xml.ogc.v100.FeatureId) 

    /**
     * Method setFeatureId
     * 
     * 
     * 
     * @param featureIdArray
     */
    public void setFeatureId(nl.b3p.xml.ogc.v100.FeatureId[] featureIdArray)
    {
        //-- copy array
        _featureIdList.clear();
        for (int i = 0; i < featureIdArray.length; i++) {
            _featureIdList.add(featureIdArray[i]);
        }
    } //-- void setFeatureId(nl.b3p.xml.ogc.v100.FeatureId) 

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
     * @return InsertResultType
     */
    public static nl.b3p.xml.wfs.v100.transaction.InsertResultType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.transaction.InsertResultType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.transaction.InsertResultType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.transaction.InsertResultType unmarshal(java.io.Reader) 

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
