/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v100.capabilities;

/**
 * Class Scalar_CapabilitiesTypeItem.
 * 
 * @version $Revision$ $Date$
 */
public class Scalar_CapabilitiesTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _logical_Operators
     */
    private nl.b3p.xml.ogc.v100.capabilities.Logical_Operators _logical_Operators;

    /**
     * Field _comparison_Operators
     */
    private nl.b3p.xml.ogc.v100.capabilities.Comparison_Operators _comparison_Operators;

    /**
     * Field _arithmetic_Operators
     */
    private nl.b3p.xml.ogc.v100.capabilities.Arithmetic_Operators _arithmetic_Operators;


      //----------------/
     //- Constructors -/
    //----------------/

    public Scalar_CapabilitiesTypeItem() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v100.capabilities.Scalar_CapabilitiesTypeItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'arithmetic_Operators'.
     * 
     * @return Arithmetic_Operators
     * @return the value of field 'arithmetic_Operators'.
     */
    public nl.b3p.xml.ogc.v100.capabilities.Arithmetic_Operators getArithmetic_Operators()
    {
        return this._arithmetic_Operators;
    } //-- nl.b3p.xml.ogc.v100.capabilities.Arithmetic_Operators getArithmetic_Operators() 

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
     * Returns the value of field 'comparison_Operators'.
     * 
     * @return Comparison_Operators
     * @return the value of field 'comparison_Operators'.
     */
    public nl.b3p.xml.ogc.v100.capabilities.Comparison_Operators getComparison_Operators()
    {
        return this._comparison_Operators;
    } //-- nl.b3p.xml.ogc.v100.capabilities.Comparison_Operators getComparison_Operators() 

    /**
     * Returns the value of field 'logical_Operators'.
     * 
     * @return Logical_Operators
     * @return the value of field 'logical_Operators'.
     */
    public nl.b3p.xml.ogc.v100.capabilities.Logical_Operators getLogical_Operators()
    {
        return this._logical_Operators;
    } //-- nl.b3p.xml.ogc.v100.capabilities.Logical_Operators getLogical_Operators() 

    /**
     * Sets the value of field 'arithmetic_Operators'.
     * 
     * @param arithmetic_Operators the value of field
     * 'arithmetic_Operators'.
     */
    public void setArithmetic_Operators(nl.b3p.xml.ogc.v100.capabilities.Arithmetic_Operators arithmetic_Operators)
    {
        this._arithmetic_Operators = arithmetic_Operators;
        this._choiceValue = arithmetic_Operators;
    } //-- void setArithmetic_Operators(nl.b3p.xml.ogc.v100.capabilities.Arithmetic_Operators) 

    /**
     * Sets the value of field 'comparison_Operators'.
     * 
     * @param comparison_Operators the value of field
     * 'comparison_Operators'.
     */
    public void setComparison_Operators(nl.b3p.xml.ogc.v100.capabilities.Comparison_Operators comparison_Operators)
    {
        this._comparison_Operators = comparison_Operators;
        this._choiceValue = comparison_Operators;
    } //-- void setComparison_Operators(nl.b3p.xml.ogc.v100.capabilities.Comparison_Operators) 

    /**
     * Sets the value of field 'logical_Operators'.
     * 
     * @param logical_Operators the value of field
     * 'logical_Operators'.
     */
    public void setLogical_Operators(nl.b3p.xml.ogc.v100.capabilities.Logical_Operators logical_Operators)
    {
        this._logical_Operators = logical_Operators;
        this._choiceValue = logical_Operators;
    } //-- void setLogical_Operators(nl.b3p.xml.ogc.v100.capabilities.Logical_Operators) 

}
