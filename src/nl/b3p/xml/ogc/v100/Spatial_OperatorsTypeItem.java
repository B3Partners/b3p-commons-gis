/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v100;

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
    private nl.b3p.xml.ogc.v100.BBOX _BBOX;

    /**
     * Field _equals
     */
    private nl.b3p.xml.ogc.v100.Equals _equals;

    /**
     * Field _disjoint
     */
    private nl.b3p.xml.ogc.v100.Disjoint _disjoint;

    /**
     * Field _intersect
     */
    private nl.b3p.xml.ogc.v100.Intersect _intersect;

    /**
     * Field _touches
     */
    private nl.b3p.xml.ogc.v100.Touches _touches;

    /**
     * Field _crosses
     */
    private nl.b3p.xml.ogc.v100.Crosses _crosses;

    /**
     * Field _within
     */
    private nl.b3p.xml.ogc.v100.Within _within;

    /**
     * Field _contains
     */
    private nl.b3p.xml.ogc.v100.Contains _contains;

    /**
     * Field _overlaps
     */
    private nl.b3p.xml.ogc.v100.Overlaps _overlaps;

    /**
     * Field _beyond
     */
    private nl.b3p.xml.ogc.v100.Beyond _beyond;

    /**
     * Field _DWithin
     */
    private nl.b3p.xml.ogc.v100.DWithin _DWithin;


      //----------------/
     //- Constructors -/
    //----------------/

    public Spatial_OperatorsTypeItem() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v100.Spatial_OperatorsTypeItem()


      //-----------/
     //- Methods -/
    //-----------/

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

}
