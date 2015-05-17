/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Optional unordered list of valid domain constraints on
 * non-parameter quantities that each apply to this operation. If
 * one of these Constraint elements has the same "name" attribute
 * as a Constraint element in the OperationsMetadata element, this
 * Constraint element shall override the other one for this
 * operation. The list of required and optional constraints for
 * this operation shall be specified in the Implementation
 * Specification for this service. 
 * 
 * @version $Revision$ $Date$
 */
public class Constraint_Operation extends DomainType 
implements java.io.Serializable
{


      //----------------/
     //- Constructors -/
    //----------------/

    public Constraint_Operation() 
     {
        super();
    } //-- nl.b3p.xml.ows.v100.Constraint_Operation()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return DomainType
     */
    public static nl.b3p.xml.ows.v100.DomainType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.DomainType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.Constraint_Operation.class, reader);
    } //-- nl.b3p.xml.ows.v100.DomainType unmarshal(java.io.Reader) 

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
