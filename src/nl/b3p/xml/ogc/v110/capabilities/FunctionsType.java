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
 * Class FunctionsType.
 * 
 * @version $Revision$ $Date$
 */
public class FunctionsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _functionNames
     */
    private nl.b3p.xml.ogc.v110.capabilities.FunctionNames _functionNames;


      //----------------/
     //- Constructors -/
    //----------------/

    public FunctionsType() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v110.capabilities.FunctionsType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'functionNames'.
     * 
     * @return FunctionNames
     * @return the value of field 'functionNames'.
     */
    public nl.b3p.xml.ogc.v110.capabilities.FunctionNames getFunctionNames()
    {
        return this._functionNames;
    } //-- nl.b3p.xml.ogc.v110.capabilities.FunctionNames getFunctionNames() 

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
     * Sets the value of field 'functionNames'.
     * 
     * @param functionNames the value of field 'functionNames'.
     */
    public void setFunctionNames(nl.b3p.xml.ogc.v110.capabilities.FunctionNames functionNames)
    {
        this._functionNames = functionNames;
    } //-- void setFunctionNames(nl.b3p.xml.ogc.v110.capabilities.FunctionNames) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return FunctionsType
     */
    public static nl.b3p.xml.ogc.v110.capabilities.FunctionsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v110.capabilities.FunctionsType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.capabilities.FunctionsType.class, reader);
    } //-- nl.b3p.xml.ogc.v110.capabilities.FunctionsType unmarshal(java.io.Reader) 

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
