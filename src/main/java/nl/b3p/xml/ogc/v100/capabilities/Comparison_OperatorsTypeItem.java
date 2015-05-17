/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v100.capabilities;

/**
 * Class Comparison_OperatorsTypeItem.
 * 
 * @version $Revision$ $Date$
 */
public class Comparison_OperatorsTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _simple_Comparisons
     */
    private nl.b3p.xml.ogc.v100.capabilities.Simple_Comparisons _simple_Comparisons;

    /**
     * Field _like
     */
    private nl.b3p.xml.ogc.v100.capabilities.Like _like;

    /**
     * Field _between
     */
    private nl.b3p.xml.ogc.v100.capabilities.Between _between;

    /**
     * Field _nullCheck
     */
    private nl.b3p.xml.ogc.v100.capabilities.NullCheck _nullCheck;


      //----------------/
     //- Constructors -/
    //----------------/

    public Comparison_OperatorsTypeItem() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'between'.
     * 
     * @return Between
     * @return the value of field 'between'.
     */
    public nl.b3p.xml.ogc.v100.capabilities.Between getBetween()
    {
        return this._between;
    } //-- nl.b3p.xml.ogc.v100.capabilities.Between getBetween() 

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
     * Returns the value of field 'like'.
     * 
     * @return Like
     * @return the value of field 'like'.
     */
    public nl.b3p.xml.ogc.v100.capabilities.Like getLike()
    {
        return this._like;
    } //-- nl.b3p.xml.ogc.v100.capabilities.Like getLike() 

    /**
     * Returns the value of field 'nullCheck'.
     * 
     * @return NullCheck
     * @return the value of field 'nullCheck'.
     */
    public nl.b3p.xml.ogc.v100.capabilities.NullCheck getNullCheck()
    {
        return this._nullCheck;
    } //-- nl.b3p.xml.ogc.v100.capabilities.NullCheck getNullCheck() 

    /**
     * Returns the value of field 'simple_Comparisons'.
     * 
     * @return Simple_Comparisons
     * @return the value of field 'simple_Comparisons'.
     */
    public nl.b3p.xml.ogc.v100.capabilities.Simple_Comparisons getSimple_Comparisons()
    {
        return this._simple_Comparisons;
    } //-- nl.b3p.xml.ogc.v100.capabilities.Simple_Comparisons getSimple_Comparisons() 

    /**
     * Sets the value of field 'between'.
     * 
     * @param between the value of field 'between'.
     */
    public void setBetween(nl.b3p.xml.ogc.v100.capabilities.Between between)
    {
        this._between = between;
        this._choiceValue = between;
    } //-- void setBetween(nl.b3p.xml.ogc.v100.capabilities.Between) 

    /**
     * Sets the value of field 'like'.
     * 
     * @param like the value of field 'like'.
     */
    public void setLike(nl.b3p.xml.ogc.v100.capabilities.Like like)
    {
        this._like = like;
        this._choiceValue = like;
    } //-- void setLike(nl.b3p.xml.ogc.v100.capabilities.Like) 

    /**
     * Sets the value of field 'nullCheck'.
     * 
     * @param nullCheck the value of field 'nullCheck'.
     */
    public void setNullCheck(nl.b3p.xml.ogc.v100.capabilities.NullCheck nullCheck)
    {
        this._nullCheck = nullCheck;
        this._choiceValue = nullCheck;
    } //-- void setNullCheck(nl.b3p.xml.ogc.v100.capabilities.NullCheck) 

    /**
     * Sets the value of field 'simple_Comparisons'.
     * 
     * @param simple_Comparisons the value of field
     * 'simple_Comparisons'.
     */
    public void setSimple_Comparisons(nl.b3p.xml.ogc.v100.capabilities.Simple_Comparisons simple_Comparisons)
    {
        this._simple_Comparisons = simple_Comparisons;
        this._choiceValue = simple_Comparisons;
    } //-- void setSimple_Comparisons(nl.b3p.xml.ogc.v100.capabilities.Simple_Comparisons) 

}
