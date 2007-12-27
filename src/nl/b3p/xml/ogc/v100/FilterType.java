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
     * Field _beyond
     */
    private nl.b3p.xml.ogc.v100.Beyond _beyond;

    /**
     * Field _contains
     */
    private nl.b3p.xml.ogc.v100.Contains _contains;

    /**
     * Field _crosses
     */
    private nl.b3p.xml.ogc.v100.Crosses _crosses;

    /**
     * Field _DWithin
     */
    private nl.b3p.xml.ogc.v100.DWithin _DWithin;

    /**
     * Field _disjoint
     */
    private nl.b3p.xml.ogc.v100.Disjoint _disjoint;

    /**
     * Field _equals
     */
    private nl.b3p.xml.ogc.v100.Equals _equals;

    /**
     * Field _intersects
     */
    private nl.b3p.xml.ogc.v100.Intersects _intersects;

    /**
     * Field _overlaps
     */
    private nl.b3p.xml.ogc.v100.Overlaps _overlaps;

    /**
     * Field _touches
     */
    private nl.b3p.xml.ogc.v100.Touches _touches;

    /**
     * Field _within
     */
    private nl.b3p.xml.ogc.v100.Within _within;

    /**
     * Field _BBOX
     */
    private nl.b3p.xml.ogc.v100.BBOX _BBOX;

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
     * Returns the value of field 'BBOX'.
     * 
     * @return BBOX
     * @return the value of field 'BBOX'.
     */
    public nl.b3p.xml.ogc.v100.BBOX getBBOX()
    {
        return this._BBOX;
    } //-- nl.b3p.xml.ogc.v100.BBOX getBBOX() 

    /**
     * Returns the value of field 'beyond'.
     * 
     * @return Beyond
     * @return the value of field 'beyond'.
     */
    public nl.b3p.xml.ogc.v100.Beyond getBeyond()
    {
        return this._beyond;
    } //-- nl.b3p.xml.ogc.v100.Beyond getBeyond() 

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
     * Returns the value of field 'contains'.
     * 
     * @return Contains
     * @return the value of field 'contains'.
     */
    public nl.b3p.xml.ogc.v100.Contains getContains()
    {
        return this._contains;
    } //-- nl.b3p.xml.ogc.v100.Contains getContains() 

    /**
     * Returns the value of field 'crosses'.
     * 
     * @return Crosses
     * @return the value of field 'crosses'.
     */
    public nl.b3p.xml.ogc.v100.Crosses getCrosses()
    {
        return this._crosses;
    } //-- nl.b3p.xml.ogc.v100.Crosses getCrosses() 

    /**
     * Returns the value of field 'DWithin'.
     * 
     * @return DWithin
     * @return the value of field 'DWithin'.
     */
    public nl.b3p.xml.ogc.v100.DWithin getDWithin()
    {
        return this._DWithin;
    } //-- nl.b3p.xml.ogc.v100.DWithin getDWithin() 

    /**
     * Returns the value of field 'disjoint'.
     * 
     * @return Disjoint
     * @return the value of field 'disjoint'.
     */
    public nl.b3p.xml.ogc.v100.Disjoint getDisjoint()
    {
        return this._disjoint;
    } //-- nl.b3p.xml.ogc.v100.Disjoint getDisjoint() 

    /**
     * Returns the value of field 'equals'.
     * 
     * @return Equals
     * @return the value of field 'equals'.
     */
    public nl.b3p.xml.ogc.v100.Equals getEquals()
    {
        return this._equals;
    } //-- nl.b3p.xml.ogc.v100.Equals getEquals() 

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
     * Returns the value of field 'intersects'.
     * 
     * @return Intersects
     * @return the value of field 'intersects'.
     */
    public nl.b3p.xml.ogc.v100.Intersects getIntersects()
    {
        return this._intersects;
    } //-- nl.b3p.xml.ogc.v100.Intersects getIntersects() 

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
     * Returns the value of field 'overlaps'.
     * 
     * @return Overlaps
     * @return the value of field 'overlaps'.
     */
    public nl.b3p.xml.ogc.v100.Overlaps getOverlaps()
    {
        return this._overlaps;
    } //-- nl.b3p.xml.ogc.v100.Overlaps getOverlaps() 

    /**
     * Returns the value of field 'touches'.
     * 
     * @return Touches
     * @return the value of field 'touches'.
     */
    public nl.b3p.xml.ogc.v100.Touches getTouches()
    {
        return this._touches;
    } //-- nl.b3p.xml.ogc.v100.Touches getTouches() 

    /**
     * Returns the value of field 'within'.
     * 
     * @return Within
     * @return the value of field 'within'.
     */
    public nl.b3p.xml.ogc.v100.Within getWithin()
    {
        return this._within;
    } //-- nl.b3p.xml.ogc.v100.Within getWithin() 

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
     * Sets the value of field 'BBOX'.
     * 
     * @param BBOX the value of field 'BBOX'.
     */
    public void setBBOX(nl.b3p.xml.ogc.v100.BBOX BBOX)
    {
        this._BBOX = BBOX;
        this._choiceValue = BBOX;
    } //-- void setBBOX(nl.b3p.xml.ogc.v100.BBOX) 

    /**
     * Sets the value of field 'beyond'.
     * 
     * @param beyond the value of field 'beyond'.
     */
    public void setBeyond(nl.b3p.xml.ogc.v100.Beyond beyond)
    {
        this._beyond = beyond;
        this._choiceValue = beyond;
    } //-- void setBeyond(nl.b3p.xml.ogc.v100.Beyond) 

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
     * Sets the value of field 'contains'.
     * 
     * @param contains the value of field 'contains'.
     */
    public void setContains(nl.b3p.xml.ogc.v100.Contains contains)
    {
        this._contains = contains;
        this._choiceValue = contains;
    } //-- void setContains(nl.b3p.xml.ogc.v100.Contains) 

    /**
     * Sets the value of field 'crosses'.
     * 
     * @param crosses the value of field 'crosses'.
     */
    public void setCrosses(nl.b3p.xml.ogc.v100.Crosses crosses)
    {
        this._crosses = crosses;
        this._choiceValue = crosses;
    } //-- void setCrosses(nl.b3p.xml.ogc.v100.Crosses) 

    /**
     * Sets the value of field 'DWithin'.
     * 
     * @param DWithin the value of field 'DWithin'.
     */
    public void setDWithin(nl.b3p.xml.ogc.v100.DWithin DWithin)
    {
        this._DWithin = DWithin;
        this._choiceValue = DWithin;
    } //-- void setDWithin(nl.b3p.xml.ogc.v100.DWithin) 

    /**
     * Sets the value of field 'disjoint'.
     * 
     * @param disjoint the value of field 'disjoint'.
     */
    public void setDisjoint(nl.b3p.xml.ogc.v100.Disjoint disjoint)
    {
        this._disjoint = disjoint;
        this._choiceValue = disjoint;
    } //-- void setDisjoint(nl.b3p.xml.ogc.v100.Disjoint) 

    /**
     * Sets the value of field 'equals'.
     * 
     * @param equals the value of field 'equals'.
     */
    public void setEquals(nl.b3p.xml.ogc.v100.Equals equals)
    {
        this._equals = equals;
        this._choiceValue = equals;
    } //-- void setEquals(nl.b3p.xml.ogc.v100.Equals) 

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
     * Sets the value of field 'intersects'.
     * 
     * @param intersects the value of field 'intersects'.
     */
    public void setIntersects(nl.b3p.xml.ogc.v100.Intersects intersects)
    {
        this._intersects = intersects;
        this._choiceValue = intersects;
    } //-- void setIntersects(nl.b3p.xml.ogc.v100.Intersects) 

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
     * Sets the value of field 'overlaps'.
     * 
     * @param overlaps the value of field 'overlaps'.
     */
    public void setOverlaps(nl.b3p.xml.ogc.v100.Overlaps overlaps)
    {
        this._overlaps = overlaps;
        this._choiceValue = overlaps;
    } //-- void setOverlaps(nl.b3p.xml.ogc.v100.Overlaps) 

    /**
     * Sets the value of field 'touches'.
     * 
     * @param touches the value of field 'touches'.
     */
    public void setTouches(nl.b3p.xml.ogc.v100.Touches touches)
    {
        this._touches = touches;
        this._choiceValue = touches;
    } //-- void setTouches(nl.b3p.xml.ogc.v100.Touches) 

    /**
     * Sets the value of field 'within'.
     * 
     * @param within the value of field 'within'.
     */
    public void setWithin(nl.b3p.xml.ogc.v100.Within within)
    {
        this._within = within;
        this._choiceValue = within;
    } //-- void setWithin(nl.b3p.xml.ogc.v100.Within) 

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
