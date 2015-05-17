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
 * Class PropertyIsBetweenType.
 * 
 * @version $Revision$ $Date$
 */
public class PropertyIsBetweenType extends nl.b3p.xml.ogc.v110.ComparisonOpsType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _expression
     */
    private nl.b3p.xml.ogc.v110.Expression _expression;

    /**
     * Field _lowerBoundary
     */
    private nl.b3p.xml.ogc.v110.LowerBoundary _lowerBoundary;

    /**
     * Field _upperBoundary
     */
    private nl.b3p.xml.ogc.v110.UpperBoundary _upperBoundary;


      //----------------/
     //- Constructors -/
    //----------------/

    public PropertyIsBetweenType() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v110.PropertyIsBetweenType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'expression'.
     * 
     * @return Expression
     * @return the value of field 'expression'.
     */
    public nl.b3p.xml.ogc.v110.Expression getExpression()
    {
        return this._expression;
    } //-- nl.b3p.xml.ogc.v110.Expression getExpression() 

    /**
     * Returns the value of field 'lowerBoundary'.
     * 
     * @return LowerBoundary
     * @return the value of field 'lowerBoundary'.
     */
    public nl.b3p.xml.ogc.v110.LowerBoundary getLowerBoundary()
    {
        return this._lowerBoundary;
    } //-- nl.b3p.xml.ogc.v110.LowerBoundary getLowerBoundary() 

    /**
     * Returns the value of field 'upperBoundary'.
     * 
     * @return UpperBoundary
     * @return the value of field 'upperBoundary'.
     */
    public nl.b3p.xml.ogc.v110.UpperBoundary getUpperBoundary()
    {
        return this._upperBoundary;
    } //-- nl.b3p.xml.ogc.v110.UpperBoundary getUpperBoundary() 

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
     * Sets the value of field 'expression'.
     * 
     * @param expression the value of field 'expression'.
     */
    public void setExpression(nl.b3p.xml.ogc.v110.Expression expression)
    {
        this._expression = expression;
    } //-- void setExpression(nl.b3p.xml.ogc.v110.Expression) 

    /**
     * Sets the value of field 'lowerBoundary'.
     * 
     * @param lowerBoundary the value of field 'lowerBoundary'.
     */
    public void setLowerBoundary(nl.b3p.xml.ogc.v110.LowerBoundary lowerBoundary)
    {
        this._lowerBoundary = lowerBoundary;
    } //-- void setLowerBoundary(nl.b3p.xml.ogc.v110.LowerBoundary) 

    /**
     * Sets the value of field 'upperBoundary'.
     * 
     * @param upperBoundary the value of field 'upperBoundary'.
     */
    public void setUpperBoundary(nl.b3p.xml.ogc.v110.UpperBoundary upperBoundary)
    {
        this._upperBoundary = upperBoundary;
    } //-- void setUpperBoundary(nl.b3p.xml.ogc.v110.UpperBoundary) 

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
        return (nl.b3p.xml.ogc.v110.ComparisonOpsType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.PropertyIsBetweenType.class, reader);
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
