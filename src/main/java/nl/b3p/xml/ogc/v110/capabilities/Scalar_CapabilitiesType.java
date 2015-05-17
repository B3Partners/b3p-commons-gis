/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v110.capabilities;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class Scalar_CapabilitiesType.
 * 
 * @version $Revision$ $Date$
 */
public class Scalar_CapabilitiesType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _logicalOperators
     */
    private nl.b3p.xml.ogc.v110.capabilities.LogicalOperators _logicalOperators;

    /**
     * Field _comparisonOperators
     */
    private nl.b3p.xml.ogc.v110.capabilities.ComparisonOperators _comparisonOperators;

    /**
     * Field _arithmeticOperators
     */
    private nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperators _arithmeticOperators;


      //----------------/
     //- Constructors -/
    //----------------/

    public Scalar_CapabilitiesType() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v110.capabilities.Scalar_CapabilitiesType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'arithmeticOperators'.
     * 
     * @return ArithmeticOperators
     * @return the value of field 'arithmeticOperators'.
     */
    public nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperators getArithmeticOperators()
    {
        return this._arithmeticOperators;
    } //-- nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperators getArithmeticOperators() 

    /**
     * Returns the value of field 'comparisonOperators'.
     * 
     * @return ComparisonOperators
     * @return the value of field 'comparisonOperators'.
     */
    public nl.b3p.xml.ogc.v110.capabilities.ComparisonOperators getComparisonOperators()
    {
        return this._comparisonOperators;
    } //-- nl.b3p.xml.ogc.v110.capabilities.ComparisonOperators getComparisonOperators() 

    /**
     * Returns the value of field 'logicalOperators'.
     * 
     * @return LogicalOperators
     * @return the value of field 'logicalOperators'.
     */
    public nl.b3p.xml.ogc.v110.capabilities.LogicalOperators getLogicalOperators()
    {
        return this._logicalOperators;
    } //-- nl.b3p.xml.ogc.v110.capabilities.LogicalOperators getLogicalOperators() 

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
     * Sets the value of field 'arithmeticOperators'.
     * 
     * @param arithmeticOperators the value of field
     * 'arithmeticOperators'.
     */
    public void setArithmeticOperators(nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperators arithmeticOperators)
    {
        this._arithmeticOperators = arithmeticOperators;
    } //-- void setArithmeticOperators(nl.b3p.xml.ogc.v110.capabilities.ArithmeticOperators) 

    /**
     * Sets the value of field 'comparisonOperators'.
     * 
     * @param comparisonOperators the value of field
     * 'comparisonOperators'.
     */
    public void setComparisonOperators(nl.b3p.xml.ogc.v110.capabilities.ComparisonOperators comparisonOperators)
    {
        this._comparisonOperators = comparisonOperators;
    } //-- void setComparisonOperators(nl.b3p.xml.ogc.v110.capabilities.ComparisonOperators) 

    /**
     * Sets the value of field 'logicalOperators'.
     * 
     * @param logicalOperators the value of field 'logicalOperators'
     */
    public void setLogicalOperators(nl.b3p.xml.ogc.v110.capabilities.LogicalOperators logicalOperators)
    {
        this._logicalOperators = logicalOperators;
    } //-- void setLogicalOperators(nl.b3p.xml.ogc.v110.capabilities.LogicalOperators) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Scalar_CapabilitiesType
     */
    public static nl.b3p.xml.ogc.v110.capabilities.Scalar_CapabilitiesType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v110.capabilities.Scalar_CapabilitiesType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.capabilities.Scalar_CapabilitiesType.class, reader);
    } //-- nl.b3p.xml.ogc.v110.capabilities.Scalar_CapabilitiesType unmarshal(java.io.Reader) 

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
