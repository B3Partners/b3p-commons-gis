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

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class FilterType.
 * 
 * @version $Revision$ $Date$
 */
public class FilterType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _spatialOps
     */
    private nl.b3p.xml.ogc.v100.SpatialOps _spatialOps;

    /**
     * Field _comparisonOps
     */
    private nl.b3p.xml.ogc.v100.ComparisonOps _comparisonOps;

    /**
     * Field _logicOps
     */
    private nl.b3p.xml.ogc.v100.LogicOps _logicOps;

    /**
     * Field _featureIdList
     */
    private java.util.ArrayList _featureIdList;


      //----------------/
     //- Constructors -/
    //----------------/

    public FilterType() 
     {
        super();
        _featureIdList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ogc.v100.FilterType()


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
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return Object
     * @return the value of field 'choiceValue'.
     */
    public java.lang.Object getChoiceValue()
    {
        return this._choiceValue;
    } //-- java.lang.Object getChoiceValue() 

    /**
     * Returns the value of field 'comparisonOps'.
     * 
     * @return ComparisonOps
     * @return the value of field 'comparisonOps'.
     */
    public nl.b3p.xml.ogc.v100.ComparisonOps getComparisonOps()
    {
        return this._comparisonOps;
    } //-- nl.b3p.xml.ogc.v100.ComparisonOps getComparisonOps() 

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
     * Returns the value of field 'logicOps'.
     * 
     * @return LogicOps
     * @return the value of field 'logicOps'.
     */
    public nl.b3p.xml.ogc.v100.LogicOps getLogicOps()
    {
        return this._logicOps;
    } //-- nl.b3p.xml.ogc.v100.LogicOps getLogicOps() 

    /**
     * Returns the value of field 'spatialOps'.
     * 
     * @return SpatialOps
     * @return the value of field 'spatialOps'.
     */
    public nl.b3p.xml.ogc.v100.SpatialOps getSpatialOps()
    {
        return this._spatialOps;
    } //-- nl.b3p.xml.ogc.v100.SpatialOps getSpatialOps() 

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
     * Sets the value of field 'comparisonOps'.
     * 
     * @param comparisonOps the value of field 'comparisonOps'.
     */
    public void setComparisonOps(nl.b3p.xml.ogc.v100.ComparisonOps comparisonOps)
    {
        this._comparisonOps = comparisonOps;
        this._choiceValue = comparisonOps;
    } //-- void setComparisonOps(nl.b3p.xml.ogc.v100.ComparisonOps) 

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
     * Sets the value of field 'logicOps'.
     * 
     * @param logicOps the value of field 'logicOps'.
     */
    public void setLogicOps(nl.b3p.xml.ogc.v100.LogicOps logicOps)
    {
        this._logicOps = logicOps;
        this._choiceValue = logicOps;
    } //-- void setLogicOps(nl.b3p.xml.ogc.v100.LogicOps) 

    /**
     * Sets the value of field 'spatialOps'.
     * 
     * @param spatialOps the value of field 'spatialOps'.
     */
    public void setSpatialOps(nl.b3p.xml.ogc.v100.SpatialOps spatialOps)
    {
        this._spatialOps = spatialOps;
        this._choiceValue = spatialOps;
    } //-- void setSpatialOps(nl.b3p.xml.ogc.v100.SpatialOps) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return FilterType
     */
    public static nl.b3p.xml.ogc.v100.FilterType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v100.FilterType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.FilterType.class, reader);
    } //-- nl.b3p.xml.ogc.v100.FilterType unmarshal(java.io.Reader) 

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
