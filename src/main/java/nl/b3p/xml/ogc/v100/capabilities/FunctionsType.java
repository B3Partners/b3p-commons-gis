/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v100.capabilities;

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
     * Field _function_Names
     */
    private nl.b3p.xml.ogc.v100.capabilities.Function_Names _function_Names;


      //----------------/
     //- Constructors -/
    //----------------/

    public FunctionsType() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v100.capabilities.FunctionsType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'function_Names'.
     * 
     * @return Function_Names
     * @return the value of field 'function_Names'.
     */
    public nl.b3p.xml.ogc.v100.capabilities.Function_Names getFunction_Names()
    {
        return this._function_Names;
    } //-- nl.b3p.xml.ogc.v100.capabilities.Function_Names getFunction_Names() 

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
     * Sets the value of field 'function_Names'.
     * 
     * @param function_Names the value of field 'function_Names'.
     */
    public void setFunction_Names(nl.b3p.xml.ogc.v100.capabilities.Function_Names function_Names)
    {
        this._function_Names = function_Names;
    } //-- void setFunction_Names(nl.b3p.xml.ogc.v100.capabilities.Function_Names) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return FunctionsType
     */
    public static nl.b3p.xml.ogc.v100.capabilities.FunctionsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v100.capabilities.FunctionsType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.capabilities.FunctionsType.class, reader);
    } //-- nl.b3p.xml.ogc.v100.capabilities.FunctionsType unmarshal(java.io.Reader) 

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
