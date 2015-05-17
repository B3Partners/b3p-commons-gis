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
 * Class UpperBoundaryType.
 * 
 * @version $Revision$ $Date$
 */
public class UpperBoundaryType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _expression
     */
    private nl.b3p.xml.ogc.v110.Expression _expression;


      //----------------/
     //- Constructors -/
    //----------------/

    public UpperBoundaryType() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v110.UpperBoundaryType()


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
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return UpperBoundaryType
     */
    public static nl.b3p.xml.ogc.v110.UpperBoundaryType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v110.UpperBoundaryType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.UpperBoundaryType.class, reader);
    } //-- nl.b3p.xml.ogc.v110.UpperBoundaryType unmarshal(java.io.Reader) 

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
