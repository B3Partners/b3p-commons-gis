/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v100.capabilities;

/**
 * Class Arithmetic_OperatorsTypeItem.
 * 
 * @version $Revision$ $Date$
 */
public class Arithmetic_OperatorsTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _simple_Arithmetic
     */
    private nl.b3p.xml.ogc.v100.capabilities.Simple_Arithmetic _simple_Arithmetic;

    /**
     * Field _functions
     */
    private nl.b3p.xml.ogc.v100.capabilities.Functions _functions;


      //----------------/
     //- Constructors -/
    //----------------/

    public Arithmetic_OperatorsTypeItem() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v100.capabilities.Arithmetic_OperatorsTypeItem()


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
    public nl.b3p.xml.ogc.v100.capabilities.Functions getFunctions()
    {
        return this._functions;
    } //-- nl.b3p.xml.ogc.v100.capabilities.Functions getFunctions() 

    /**
     * Returns the value of field 'simple_Arithmetic'.
     * 
     * @return Simple_Arithmetic
     * @return the value of field 'simple_Arithmetic'.
     */
    public nl.b3p.xml.ogc.v100.capabilities.Simple_Arithmetic getSimple_Arithmetic()
    {
        return this._simple_Arithmetic;
    } //-- nl.b3p.xml.ogc.v100.capabilities.Simple_Arithmetic getSimple_Arithmetic() 

    /**
     * Sets the value of field 'functions'.
     * 
     * @param functions the value of field 'functions'.
     */
    public void setFunctions(nl.b3p.xml.ogc.v100.capabilities.Functions functions)
    {
        this._functions = functions;
        this._choiceValue = functions;
    } //-- void setFunctions(nl.b3p.xml.ogc.v100.capabilities.Functions) 

    /**
     * Sets the value of field 'simple_Arithmetic'.
     * 
     * @param simple_Arithmetic the value of field
     * 'simple_Arithmetic'.
     */
    public void setSimple_Arithmetic(nl.b3p.xml.ogc.v100.capabilities.Simple_Arithmetic simple_Arithmetic)
    {
        this._simple_Arithmetic = simple_Arithmetic;
        this._choiceValue = simple_Arithmetic;
    } //-- void setSimple_Arithmetic(nl.b3p.xml.ogc.v100.capabilities.Simple_Arithmetic) 

}
