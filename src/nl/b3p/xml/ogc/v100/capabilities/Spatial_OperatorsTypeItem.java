/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v100.capabilities;

/**
 * Class Spatial_OperatorsTypeItem.
 * 
 * @version $Revision$ $Date$
 */
public class Spatial_OperatorsTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _BBOX
     */
    private nl.b3p.xml.ogc.v100.capabilities.BBOX _BBOX;

    /**
     * Field _equals
     */
    private nl.b3p.xml.ogc.v100.capabilities.Equals _equals;

    /**
     * Field _disjoint
     */
    private nl.b3p.xml.ogc.v100.capabilities.Disjoint _disjoint;

    /**
     * Field _intersect
     */
    private nl.b3p.xml.ogc.v100.capabilities.Intersect _intersect;

    /**
     * Field _touches
     */
    private nl.b3p.xml.ogc.v100.capabilities.Touches _touches;

    /**
     * Field _crosses
     */
    private nl.b3p.xml.ogc.v100.capabilities.Crosses _crosses;

    /**
     * Field _within
     */
    private nl.b3p.xml.ogc.v100.capabilities.Within _within;

    /**
     * Field _contains
     */
    private nl.b3p.xml.ogc.v100.capabilities.Contains _contains;

    /**
     * Field _overlaps
     */
    private nl.b3p.xml.ogc.v100.capabilities.Overlaps _overlaps;

    /**
     * Field _beyond
     */
    private nl.b3p.xml.ogc.v100.capabilities.Beyond _beyond;

    /**
     * Field _DWithin
     */
    private nl.b3p.xml.ogc.v100.capabilities.DWithin _DWithin;


      //----------------/
     //- Constructors -/
    //----------------/

    public Spatial_OperatorsTypeItem() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v100.capabilities.Spatial_OperatorsTypeItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'BBOX'.
     * 
     * @return BBOX
     * @return the value of field 'BBOX'.
     */
    public nl.b3p.xml.ogc.v100.capabilities.BBOX getBBOX()
    {
        return this._BBOX;
    } //-- nl.b3p.xml.ogc.v100.capabilities.BBOX getBBOX() 

    /**
     * Returns the value of field 'beyond'.
     * 
     * @return Beyond
     * @return the value of field 'beyond'.
     */
    public nl.b3p.xml.ogc.v100.capabilities.Beyond getBeyond()
    {
        return this._beyond;
    } //-- nl.b3p.xml.ogc.v100.capabilities.Beyond getBeyond() 

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
    public nl.b3p.xml.ogc.v100.capabilities.Contains getContains()
    {
        return this._contains;
    } //-- nl.b3p.xml.ogc.v100.capabilities.Contains getContains() 

    /**
     * Returns the value of field 'crosses'.
     * 
     * @return Crosses
     * @return the value of field 'crosses'.
     */
    public nl.b3p.xml.ogc.v100.capabilities.Crosses getCrosses()
    {
        return this._crosses;
    } //-- nl.b3p.xml.ogc.v100.capabilities.Crosses getCrosses() 

    /**
     * Returns the value of field 'DWithin'.
     * 
     * @return DWithin
     * @return the value of field 'DWithin'.
     */
    public nl.b3p.xml.ogc.v100.capabilities.DWithin getDWithin()
    {
        return this._DWithin;
    } //-- nl.b3p.xml.ogc.v100.capabilities.DWithin getDWithin() 

    /**
     * Returns the value of field 'disjoint'.
     * 
     * @return Disjoint
     * @return the value of field 'disjoint'.
     */
    public nl.b3p.xml.ogc.v100.capabilities.Disjoint getDisjoint()
    {
        return this._disjoint;
    } //-- nl.b3p.xml.ogc.v100.capabilities.Disjoint getDisjoint() 

    /**
     * Returns the value of field 'equals'.
     * 
     * @return Equals
     * @return the value of field 'equals'.
     */
    public nl.b3p.xml.ogc.v100.capabilities.Equals getEquals()
    {
        return this._equals;
    } //-- nl.b3p.xml.ogc.v100.capabilities.Equals getEquals() 

    /**
     * Returns the value of field 'intersect'.
     * 
     * @return Intersect
     * @return the value of field 'intersect'.
     */
    public nl.b3p.xml.ogc.v100.capabilities.Intersect getIntersect()
    {
        return this._intersect;
    } //-- nl.b3p.xml.ogc.v100.capabilities.Intersect getIntersect() 

    /**
     * Returns the value of field 'overlaps'.
     * 
     * @return Overlaps
     * @return the value of field 'overlaps'.
     */
    public nl.b3p.xml.ogc.v100.capabilities.Overlaps getOverlaps()
    {
        return this._overlaps;
    } //-- nl.b3p.xml.ogc.v100.capabilities.Overlaps getOverlaps() 

    /**
     * Returns the value of field 'touches'.
     * 
     * @return Touches
     * @return the value of field 'touches'.
     */
    public nl.b3p.xml.ogc.v100.capabilities.Touches getTouches()
    {
        return this._touches;
    } //-- nl.b3p.xml.ogc.v100.capabilities.Touches getTouches() 

    /**
     * Returns the value of field 'within'.
     * 
     * @return Within
     * @return the value of field 'within'.
     */
    public nl.b3p.xml.ogc.v100.capabilities.Within getWithin()
    {
        return this._within;
    } //-- nl.b3p.xml.ogc.v100.capabilities.Within getWithin() 

    /**
     * Sets the value of field 'BBOX'.
     * 
     * @param BBOX the value of field 'BBOX'.
     */
    public void setBBOX(nl.b3p.xml.ogc.v100.capabilities.BBOX BBOX)
    {
        this._BBOX = BBOX;
        this._choiceValue = BBOX;
    } //-- void setBBOX(nl.b3p.xml.ogc.v100.capabilities.BBOX) 

    /**
     * Sets the value of field 'beyond'.
     * 
     * @param beyond the value of field 'beyond'.
     */
    public void setBeyond(nl.b3p.xml.ogc.v100.capabilities.Beyond beyond)
    {
        this._beyond = beyond;
        this._choiceValue = beyond;
    } //-- void setBeyond(nl.b3p.xml.ogc.v100.capabilities.Beyond) 

    /**
     * Sets the value of field 'contains'.
     * 
     * @param contains the value of field 'contains'.
     */
    public void setContains(nl.b3p.xml.ogc.v100.capabilities.Contains contains)
    {
        this._contains = contains;
        this._choiceValue = contains;
    } //-- void setContains(nl.b3p.xml.ogc.v100.capabilities.Contains) 

    /**
     * Sets the value of field 'crosses'.
     * 
     * @param crosses the value of field 'crosses'.
     */
    public void setCrosses(nl.b3p.xml.ogc.v100.capabilities.Crosses crosses)
    {
        this._crosses = crosses;
        this._choiceValue = crosses;
    } //-- void setCrosses(nl.b3p.xml.ogc.v100.capabilities.Crosses) 

    /**
     * Sets the value of field 'DWithin'.
     * 
     * @param DWithin the value of field 'DWithin'.
     */
    public void setDWithin(nl.b3p.xml.ogc.v100.capabilities.DWithin DWithin)
    {
        this._DWithin = DWithin;
        this._choiceValue = DWithin;
    } //-- void setDWithin(nl.b3p.xml.ogc.v100.capabilities.DWithin) 

    /**
     * Sets the value of field 'disjoint'.
     * 
     * @param disjoint the value of field 'disjoint'.
     */
    public void setDisjoint(nl.b3p.xml.ogc.v100.capabilities.Disjoint disjoint)
    {
        this._disjoint = disjoint;
        this._choiceValue = disjoint;
    } //-- void setDisjoint(nl.b3p.xml.ogc.v100.capabilities.Disjoint) 

    /**
     * Sets the value of field 'equals'.
     * 
     * @param equals the value of field 'equals'.
     */
    public void setEquals(nl.b3p.xml.ogc.v100.capabilities.Equals equals)
    {
        this._equals = equals;
        this._choiceValue = equals;
    } //-- void setEquals(nl.b3p.xml.ogc.v100.capabilities.Equals) 

    /**
     * Sets the value of field 'intersect'.
     * 
     * @param intersect the value of field 'intersect'.
     */
    public void setIntersect(nl.b3p.xml.ogc.v100.capabilities.Intersect intersect)
    {
        this._intersect = intersect;
        this._choiceValue = intersect;
    } //-- void setIntersect(nl.b3p.xml.ogc.v100.capabilities.Intersect) 

    /**
     * Sets the value of field 'overlaps'.
     * 
     * @param overlaps the value of field 'overlaps'.
     */
    public void setOverlaps(nl.b3p.xml.ogc.v100.capabilities.Overlaps overlaps)
    {
        this._overlaps = overlaps;
        this._choiceValue = overlaps;
    } //-- void setOverlaps(nl.b3p.xml.ogc.v100.capabilities.Overlaps) 

    /**
     * Sets the value of field 'touches'.
     * 
     * @param touches the value of field 'touches'.
     */
    public void setTouches(nl.b3p.xml.ogc.v100.capabilities.Touches touches)
    {
        this._touches = touches;
        this._choiceValue = touches;
    } //-- void setTouches(nl.b3p.xml.ogc.v100.capabilities.Touches) 

    /**
     * Sets the value of field 'within'.
     * 
     * @param within the value of field 'within'.
     */
    public void setWithin(nl.b3p.xml.ogc.v100.capabilities.Within within)
    {
        this._within = within;
        this._choiceValue = within;
    } //-- void setWithin(nl.b3p.xml.ogc.v100.capabilities.Within) 

}
