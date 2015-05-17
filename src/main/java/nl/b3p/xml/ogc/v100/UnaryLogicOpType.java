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

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class UnaryLogicOpType.
 * 
 * @version $Revision$ $Date$
 */
public class UnaryLogicOpType extends nl.b3p.xml.ogc.v100.LogicOpsType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _propertyIsNull
     */
    private nl.b3p.xml.ogc.v100.PropertyIsNull _propertyIsNull;

    /**
     * Field _propertyIsNotEqualTo
     */
    private nl.b3p.xml.ogc.v100.PropertyIsNotEqualTo _propertyIsNotEqualTo;

    /**
     * Field _propertyIsLike
     */
    private nl.b3p.xml.ogc.v100.PropertyIsLike _propertyIsLike;

    /**
     * Field _propertyIsLessThanOrEqualTo
     */
    private nl.b3p.xml.ogc.v100.PropertyIsLessThanOrEqualTo _propertyIsLessThanOrEqualTo;

    /**
     * Field _propertyIsLessThan
     */
    private nl.b3p.xml.ogc.v100.PropertyIsLessThan _propertyIsLessThan;

    /**
     * Field _propertyIsGreaterThanOrEqualTo
     */
    private nl.b3p.xml.ogc.v100.PropertyIsGreaterThanOrEqualTo _propertyIsGreaterThanOrEqualTo;

    /**
     * Field _propertyIsGreaterThan
     */
    private nl.b3p.xml.ogc.v100.PropertyIsGreaterThan _propertyIsGreaterThan;

    /**
     * Field _propertyIsEqualTo
     */
    private nl.b3p.xml.ogc.v100.PropertyIsEqualTo _propertyIsEqualTo;

    /**
     * Field _propertyIsBetween
     */
    private nl.b3p.xml.ogc.v100.PropertyIsBetween _propertyIsBetween;

    /**
     * Field _within
     */
    private nl.b3p.xml.ogc.v100.Within _within;

    /**
     * Field _touches
     */
    private nl.b3p.xml.ogc.v100.Touches _touches;

    /**
     * Field _overlaps
     */
    private nl.b3p.xml.ogc.v100.Overlaps _overlaps;

    /**
     * Field _intersects
     */
    private nl.b3p.xml.ogc.v100.Intersects _intersects;

    /**
     * Field _equals
     */
    private nl.b3p.xml.ogc.v100.Equals _equals;

    /**
     * Field _disjoint
     */
    private nl.b3p.xml.ogc.v100.Disjoint _disjoint;

    /**
     * Field _DWithin
     */
    private nl.b3p.xml.ogc.v100.DWithin _DWithin;

    /**
     * Field _crosses
     */
    private nl.b3p.xml.ogc.v100.Crosses _crosses;

    /**
     * Field _contains
     */
    private nl.b3p.xml.ogc.v100.Contains _contains;

    /**
     * Field _beyond
     */
    private nl.b3p.xml.ogc.v100.Beyond _beyond;

    /**
     * Field _BBOX
     */
    private nl.b3p.xml.ogc.v100.BBOX _BBOX;

    /**
     * Field _or
     */
    private nl.b3p.xml.ogc.v100.Or _or;

    /**
     * Field _not
     */
    private nl.b3p.xml.ogc.v100.Not _not;

    /**
     * Field _and
     */
    private nl.b3p.xml.ogc.v100.And _and;

    /**
     * Field _intersect
     */
    private nl.b3p.xml.ogc.v100.Intersect _intersect;


      //----------------/
     //- Constructors -/
    //----------------/

    public UnaryLogicOpType() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v100.UnaryLogicOpType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'and'.
     * 
     * @return And
     * @return the value of field 'and'.
     */
    public nl.b3p.xml.ogc.v100.And getAnd()
    {
        return this._and;
    } //-- nl.b3p.xml.ogc.v100.And getAnd() 

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
     * Returns the value of field 'intersect'.
     * 
     * @return Intersect
     * @return the value of field 'intersect'.
     */
    public nl.b3p.xml.ogc.v100.Intersect getIntersect()
    {
        return this._intersect;
    } //-- nl.b3p.xml.ogc.v100.Intersect getIntersect() 

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
     * Returns the value of field 'not'.
     * 
     * @return Not
     * @return the value of field 'not'.
     */
    public nl.b3p.xml.ogc.v100.Not getNot()
    {
        return this._not;
    } //-- nl.b3p.xml.ogc.v100.Not getNot() 

    /**
     * Returns the value of field 'or'.
     * 
     * @return Or
     * @return the value of field 'or'.
     */
    public nl.b3p.xml.ogc.v100.Or getOr()
    {
        return this._or;
    } //-- nl.b3p.xml.ogc.v100.Or getOr() 

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
     * Returns the value of field 'propertyIsBetween'.
     * 
     * @return PropertyIsBetween
     * @return the value of field 'propertyIsBetween'.
     */
    public nl.b3p.xml.ogc.v100.PropertyIsBetween getPropertyIsBetween()
    {
        return this._propertyIsBetween;
    } //-- nl.b3p.xml.ogc.v100.PropertyIsBetween getPropertyIsBetween() 

    /**
     * Returns the value of field 'propertyIsEqualTo'.
     * 
     * @return PropertyIsEqualTo
     * @return the value of field 'propertyIsEqualTo'.
     */
    public nl.b3p.xml.ogc.v100.PropertyIsEqualTo getPropertyIsEqualTo()
    {
        return this._propertyIsEqualTo;
    } //-- nl.b3p.xml.ogc.v100.PropertyIsEqualTo getPropertyIsEqualTo() 

    /**
     * Returns the value of field 'propertyIsGreaterThan'.
     * 
     * @return PropertyIsGreaterThan
     * @return the value of field 'propertyIsGreaterThan'.
     */
    public nl.b3p.xml.ogc.v100.PropertyIsGreaterThan getPropertyIsGreaterThan()
    {
        return this._propertyIsGreaterThan;
    } //-- nl.b3p.xml.ogc.v100.PropertyIsGreaterThan getPropertyIsGreaterThan() 

    /**
     * Returns the value of field 'propertyIsGreaterThanOrEqualTo'.
     * 
     * @return PropertyIsGreaterThanOrEqualTo
     * @return the value of field 'propertyIsGreaterThanOrEqualTo'.
     */
    public nl.b3p.xml.ogc.v100.PropertyIsGreaterThanOrEqualTo getPropertyIsGreaterThanOrEqualTo()
    {
        return this._propertyIsGreaterThanOrEqualTo;
    } //-- nl.b3p.xml.ogc.v100.PropertyIsGreaterThanOrEqualTo getPropertyIsGreaterThanOrEqualTo() 

    /**
     * Returns the value of field 'propertyIsLessThan'.
     * 
     * @return PropertyIsLessThan
     * @return the value of field 'propertyIsLessThan'.
     */
    public nl.b3p.xml.ogc.v100.PropertyIsLessThan getPropertyIsLessThan()
    {
        return this._propertyIsLessThan;
    } //-- nl.b3p.xml.ogc.v100.PropertyIsLessThan getPropertyIsLessThan() 

    /**
     * Returns the value of field 'propertyIsLessThanOrEqualTo'.
     * 
     * @return PropertyIsLessThanOrEqualTo
     * @return the value of field 'propertyIsLessThanOrEqualTo'.
     */
    public nl.b3p.xml.ogc.v100.PropertyIsLessThanOrEqualTo getPropertyIsLessThanOrEqualTo()
    {
        return this._propertyIsLessThanOrEqualTo;
    } //-- nl.b3p.xml.ogc.v100.PropertyIsLessThanOrEqualTo getPropertyIsLessThanOrEqualTo() 

    /**
     * Returns the value of field 'propertyIsLike'.
     * 
     * @return PropertyIsLike
     * @return the value of field 'propertyIsLike'.
     */
    public nl.b3p.xml.ogc.v100.PropertyIsLike getPropertyIsLike()
    {
        return this._propertyIsLike;
    } //-- nl.b3p.xml.ogc.v100.PropertyIsLike getPropertyIsLike() 

    /**
     * Returns the value of field 'propertyIsNotEqualTo'.
     * 
     * @return PropertyIsNotEqualTo
     * @return the value of field 'propertyIsNotEqualTo'.
     */
    public nl.b3p.xml.ogc.v100.PropertyIsNotEqualTo getPropertyIsNotEqualTo()
    {
        return this._propertyIsNotEqualTo;
    } //-- nl.b3p.xml.ogc.v100.PropertyIsNotEqualTo getPropertyIsNotEqualTo() 

    /**
     * Returns the value of field 'propertyIsNull'.
     * 
     * @return PropertyIsNull
     * @return the value of field 'propertyIsNull'.
     */
    public nl.b3p.xml.ogc.v100.PropertyIsNull getPropertyIsNull()
    {
        return this._propertyIsNull;
    } //-- nl.b3p.xml.ogc.v100.PropertyIsNull getPropertyIsNull() 

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
     * Sets the value of field 'and'.
     * 
     * @param and the value of field 'and'.
     */
    public void setAnd(nl.b3p.xml.ogc.v100.And and)
    {
        this._and = and;
        this._choiceValue = and;
    } //-- void setAnd(nl.b3p.xml.ogc.v100.And) 

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
     * Sets the value of field 'intersect'.
     * 
     * @param intersect the value of field 'intersect'.
     */
    public void setIntersect(nl.b3p.xml.ogc.v100.Intersect intersect)
    {
        this._intersect = intersect;
        this._choiceValue = intersect;
    } //-- void setIntersect(nl.b3p.xml.ogc.v100.Intersect) 

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
     * Sets the value of field 'not'.
     * 
     * @param not the value of field 'not'.
     */
    public void setNot(nl.b3p.xml.ogc.v100.Not not)
    {
        this._not = not;
        this._choiceValue = not;
    } //-- void setNot(nl.b3p.xml.ogc.v100.Not) 

    /**
     * Sets the value of field 'or'.
     * 
     * @param or the value of field 'or'.
     */
    public void setOr(nl.b3p.xml.ogc.v100.Or or)
    {
        this._or = or;
        this._choiceValue = or;
    } //-- void setOr(nl.b3p.xml.ogc.v100.Or) 

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
     * Sets the value of field 'propertyIsBetween'.
     * 
     * @param propertyIsBetween the value of field
     * 'propertyIsBetween'.
     */
    public void setPropertyIsBetween(nl.b3p.xml.ogc.v100.PropertyIsBetween propertyIsBetween)
    {
        this._propertyIsBetween = propertyIsBetween;
        this._choiceValue = propertyIsBetween;
    } //-- void setPropertyIsBetween(nl.b3p.xml.ogc.v100.PropertyIsBetween) 

    /**
     * Sets the value of field 'propertyIsEqualTo'.
     * 
     * @param propertyIsEqualTo the value of field
     * 'propertyIsEqualTo'.
     */
    public void setPropertyIsEqualTo(nl.b3p.xml.ogc.v100.PropertyIsEqualTo propertyIsEqualTo)
    {
        this._propertyIsEqualTo = propertyIsEqualTo;
        this._choiceValue = propertyIsEqualTo;
    } //-- void setPropertyIsEqualTo(nl.b3p.xml.ogc.v100.PropertyIsEqualTo) 

    /**
     * Sets the value of field 'propertyIsGreaterThan'.
     * 
     * @param propertyIsGreaterThan the value of field
     * 'propertyIsGreaterThan'.
     */
    public void setPropertyIsGreaterThan(nl.b3p.xml.ogc.v100.PropertyIsGreaterThan propertyIsGreaterThan)
    {
        this._propertyIsGreaterThan = propertyIsGreaterThan;
        this._choiceValue = propertyIsGreaterThan;
    } //-- void setPropertyIsGreaterThan(nl.b3p.xml.ogc.v100.PropertyIsGreaterThan) 

    /**
     * Sets the value of field 'propertyIsGreaterThanOrEqualTo'.
     * 
     * @param propertyIsGreaterThanOrEqualTo the value of field
     * 'propertyIsGreaterThanOrEqualTo'.
     */
    public void setPropertyIsGreaterThanOrEqualTo(nl.b3p.xml.ogc.v100.PropertyIsGreaterThanOrEqualTo propertyIsGreaterThanOrEqualTo)
    {
        this._propertyIsGreaterThanOrEqualTo = propertyIsGreaterThanOrEqualTo;
        this._choiceValue = propertyIsGreaterThanOrEqualTo;
    } //-- void setPropertyIsGreaterThanOrEqualTo(nl.b3p.xml.ogc.v100.PropertyIsGreaterThanOrEqualTo) 

    /**
     * Sets the value of field 'propertyIsLessThan'.
     * 
     * @param propertyIsLessThan the value of field
     * 'propertyIsLessThan'.
     */
    public void setPropertyIsLessThan(nl.b3p.xml.ogc.v100.PropertyIsLessThan propertyIsLessThan)
    {
        this._propertyIsLessThan = propertyIsLessThan;
        this._choiceValue = propertyIsLessThan;
    } //-- void setPropertyIsLessThan(nl.b3p.xml.ogc.v100.PropertyIsLessThan) 

    /**
     * Sets the value of field 'propertyIsLessThanOrEqualTo'.
     * 
     * @param propertyIsLessThanOrEqualTo the value of field
     * 'propertyIsLessThanOrEqualTo'.
     */
    public void setPropertyIsLessThanOrEqualTo(nl.b3p.xml.ogc.v100.PropertyIsLessThanOrEqualTo propertyIsLessThanOrEqualTo)
    {
        this._propertyIsLessThanOrEqualTo = propertyIsLessThanOrEqualTo;
        this._choiceValue = propertyIsLessThanOrEqualTo;
    } //-- void setPropertyIsLessThanOrEqualTo(nl.b3p.xml.ogc.v100.PropertyIsLessThanOrEqualTo) 

    /**
     * Sets the value of field 'propertyIsLike'.
     * 
     * @param propertyIsLike the value of field 'propertyIsLike'.
     */
    public void setPropertyIsLike(nl.b3p.xml.ogc.v100.PropertyIsLike propertyIsLike)
    {
        this._propertyIsLike = propertyIsLike;
        this._choiceValue = propertyIsLike;
    } //-- void setPropertyIsLike(nl.b3p.xml.ogc.v100.PropertyIsLike) 

    /**
     * Sets the value of field 'propertyIsNotEqualTo'.
     * 
     * @param propertyIsNotEqualTo the value of field
     * 'propertyIsNotEqualTo'.
     */
    public void setPropertyIsNotEqualTo(nl.b3p.xml.ogc.v100.PropertyIsNotEqualTo propertyIsNotEqualTo)
    {
        this._propertyIsNotEqualTo = propertyIsNotEqualTo;
        this._choiceValue = propertyIsNotEqualTo;
    } //-- void setPropertyIsNotEqualTo(nl.b3p.xml.ogc.v100.PropertyIsNotEqualTo) 

    /**
     * Sets the value of field 'propertyIsNull'.
     * 
     * @param propertyIsNull the value of field 'propertyIsNull'.
     */
    public void setPropertyIsNull(nl.b3p.xml.ogc.v100.PropertyIsNull propertyIsNull)
    {
        this._propertyIsNull = propertyIsNull;
        this._choiceValue = propertyIsNull;
    } //-- void setPropertyIsNull(nl.b3p.xml.ogc.v100.PropertyIsNull) 

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
     * @return LogicOpsType
     */
    public static nl.b3p.xml.ogc.v100.LogicOpsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v100.LogicOpsType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.UnaryLogicOpType.class, reader);
    } //-- nl.b3p.xml.ogc.v100.LogicOpsType unmarshal(java.io.Reader) 

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
