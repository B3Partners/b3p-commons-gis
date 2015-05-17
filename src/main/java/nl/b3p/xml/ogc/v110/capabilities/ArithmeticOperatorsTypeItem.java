/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v110.capabilities;

/**
 * Class ArithmeticOperatorsTypeItem.
 * 
 * @version $Revision$ $Date$
 */
public class ArithmeticOperatorsTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _simpleArithmetic
     */
    private nl.b3p.xml.ogc.v110.capabilities.SimpleArithmetic _simpleArithmetic;

    /**
     * Field _functions
     */
    private nl.b3p.xml.ogc.v110.capabilities.Functions _functions;


      //----------------/
     //- Constructors -/
    //----------------/

    public ArithmeticOperatorsTypeItem() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperatorsTypeItem()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'functions'.
     * 
     * @return Functions
     * @return the value of field 'functions'.
     */
    public nl.b3p.xml.ogc.v110.capabilities.Functions getFunctions()
    {
        return this._functions;
    } //-- nl.b3p.xml.ogc.v110.capabilities.Functions getFunctions() 

    /**
     * Returns the value of field 'simpleArithmetic'.
     * 
     * @return SimpleArithmetic
     * @return the value of field 'simpleArithmetic'.
     */
    public nl.b3p.xml.ogc.v110.capabilities.SimpleArithmetic getSimpleArithmetic()
    {
        return this._simpleArithmetic;
    } //-- nl.b3p.xml.ogc.v110.capabilities.SimpleArithmetic getSimpleArithmetic() 

    /**
     * Sets the value of field 'functions'.
     * 
     * @param functions the value of field 'functions'.
     */
    public void setFunctions(nl.b3p.xml.ogc.v110.capabilities.Functions functions)
    {
        this._functions = functions;
        this._choiceValue = functions;
    } //-- void setFunctions(nl.b3p.xml.ogc.v110.capabilities.Functions) 

    /**
     * Sets the value of field 'simpleArithmetic'.
     * 
     * @param simpleArithmetic the value of field 'simpleArithmetic'
     */
    public void setSimpleArithmetic(nl.b3p.xml.ogc.v110.capabilities.SimpleArithmetic simpleArithmetic)
    {
        this._simpleArithmetic = simpleArithmetic;
        this._choiceValue = simpleArithmetic;
    } //-- void setSimpleArithmetic(nl.b3p.xml.ogc.v110.capabilities.SimpleArithmetic) 

}
