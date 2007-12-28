/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v110;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class BinaryComparisonOpType.
 * 
 * @version $Revision$ $Date$
 */
public class BinaryComparisonOpType extends nl.b3p.xml.ogc.v110.ComparisonOpsType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _matchCase
     */
    private boolean _matchCase = true;

    /**
     * keeps track of state for field: _matchCase
     */
    private boolean _has_matchCase;

    /**
     * Field _sub
     */
    private nl.b3p.xml.ogc.v110.Sub _sub;

    /**
     * Field _propertyName
     */
    private nl.b3p.xml.ogc.v110.PropertyName _propertyName;

    /**
     * Field _mul
     */
    private nl.b3p.xml.ogc.v110.Mul _mul;

    /**
     * Field _literal
     */
    private nl.b3p.xml.ogc.v110.Literal _literal;

    /**
     * Field _function
     */
    private nl.b3p.xml.ogc.v110.Function _function;

    /**
     * Field _div
     */
    private nl.b3p.xml.ogc.v110.Div _div;

    /**
     * Field _add
     */
    private nl.b3p.xml.ogc.v110.Add _add;


      //----------------/
     //- Constructors -/
    //----------------/

    public BinaryComparisonOpType() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v110.BinaryComparisonOpType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteMatchCase
     * 
     */
    public void deleteMatchCase()
    {
        this._has_matchCase= false;
    } //-- void deleteMatchCase() 

    /**
     * Returns the value of field 'add'.
     * 
     * @return Add
     * @return the value of field 'add'.
     */
    public nl.b3p.xml.ogc.v110.Add getAdd()
    {
        return this._add;
    } //-- nl.b3p.xml.ogc.v110.Add getAdd() 

    /**
     * Returns the value of field 'div'.
     * 
     * @return Div
     * @return the value of field 'div'.
     */
    public nl.b3p.xml.ogc.v110.Div getDiv()
    {
        return this._div;
    } //-- nl.b3p.xml.ogc.v110.Div getDiv() 

    /**
     * Returns the value of field 'function'.
     * 
     * @return Function
     * @return the value of field 'function'.
     */
    public nl.b3p.xml.ogc.v110.Function getFunction()
    {
        return this._function;
    } //-- nl.b3p.xml.ogc.v110.Function getFunction() 

    /**
     * Returns the value of field 'literal'.
     * 
     * @return Literal
     * @return the value of field 'literal'.
     */
    public nl.b3p.xml.ogc.v110.Literal getLiteral()
    {
        return this._literal;
    } //-- nl.b3p.xml.ogc.v110.Literal getLiteral() 

    /**
     * Returns the value of field 'matchCase'.
     * 
     * @return boolean
     * @return the value of field 'matchCase'.
     */
    public boolean getMatchCase()
    {
        return this._matchCase;
    } //-- boolean getMatchCase() 

    /**
     * Returns the value of field 'mul'.
     * 
     * @return Mul
     * @return the value of field 'mul'.
     */
    public nl.b3p.xml.ogc.v110.Mul getMul()
    {
        return this._mul;
    } //-- nl.b3p.xml.ogc.v110.Mul getMul() 

    /**
     * Returns the value of field 'propertyName'.
     * 
     * @return PropertyName
     * @return the value of field 'propertyName'.
     */
    public nl.b3p.xml.ogc.v110.PropertyName getPropertyName()
    {
        return this._propertyName;
    } //-- nl.b3p.xml.ogc.v110.PropertyName getPropertyName() 

    /**
     * Returns the value of field 'sub'.
     * 
     * @return Sub
     * @return the value of field 'sub'.
     */
    public nl.b3p.xml.ogc.v110.Sub getSub()
    {
        return this._sub;
    } //-- nl.b3p.xml.ogc.v110.Sub getSub() 

    /**
     * Method hasMatchCase
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasMatchCase()
    {
        return this._has_matchCase;
    } //-- boolean hasMatchCase() 

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
     * Sets the value of field 'add'.
     * 
     * @param add the value of field 'add'.
     */
    public void setAdd(nl.b3p.xml.ogc.v110.Add add)
    {
        this._add = add;
    } //-- void setAdd(nl.b3p.xml.ogc.v110.Add) 

    /**
     * Sets the value of field 'div'.
     * 
     * @param div the value of field 'div'.
     */
    public void setDiv(nl.b3p.xml.ogc.v110.Div div)
    {
        this._div = div;
    } //-- void setDiv(nl.b3p.xml.ogc.v110.Div) 

    /**
     * Sets the value of field 'function'.
     * 
     * @param function the value of field 'function'.
     */
    public void setFunction(nl.b3p.xml.ogc.v110.Function function)
    {
        this._function = function;
    } //-- void setFunction(nl.b3p.xml.ogc.v110.Function) 

    /**
     * Sets the value of field 'literal'.
     * 
     * @param literal the value of field 'literal'.
     */
    public void setLiteral(nl.b3p.xml.ogc.v110.Literal literal)
    {
        this._literal = literal;
    } //-- void setLiteral(nl.b3p.xml.ogc.v110.Literal) 

    /**
     * Sets the value of field 'matchCase'.
     * 
     * @param matchCase the value of field 'matchCase'.
     */
    public void setMatchCase(boolean matchCase)
    {
        this._matchCase = matchCase;
        this._has_matchCase = true;
    } //-- void setMatchCase(boolean) 

    /**
     * Sets the value of field 'mul'.
     * 
     * @param mul the value of field 'mul'.
     */
    public void setMul(nl.b3p.xml.ogc.v110.Mul mul)
    {
        this._mul = mul;
    } //-- void setMul(nl.b3p.xml.ogc.v110.Mul) 

    /**
     * Sets the value of field 'propertyName'.
     * 
     * @param propertyName the value of field 'propertyName'.
     */
    public void setPropertyName(nl.b3p.xml.ogc.v110.PropertyName propertyName)
    {
        this._propertyName = propertyName;
    } //-- void setPropertyName(nl.b3p.xml.ogc.v110.PropertyName) 

    /**
     * Sets the value of field 'sub'.
     * 
     * @param sub the value of field 'sub'.
     */
    public void setSub(nl.b3p.xml.ogc.v110.Sub sub)
    {
        this._sub = sub;
    } //-- void setSub(nl.b3p.xml.ogc.v110.Sub) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return ComparisonOpsType
     */
    public static nl.b3p.xml.ogc.v110.ComparisonOpsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v110.ComparisonOpsType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.BinaryComparisonOpType.class, reader);
    } //-- nl.b3p.xml.ogc.v110.ComparisonOpsType unmarshal(java.io.Reader) 

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
