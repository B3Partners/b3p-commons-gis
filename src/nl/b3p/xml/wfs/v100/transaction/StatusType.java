/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100.transaction;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class StatusType.
 * 
 * @version $Revision$ $Date$
 */
public class StatusType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _SUCCESS
     */
    private nl.b3p.xml.wfs.v100.transaction.SUCCESS _SUCCESS;

    /**
     * Field _FAILED
     */
    private nl.b3p.xml.wfs.v100.transaction.FAILED _FAILED;

    /**
     * Field _PARTIAL
     */
    private nl.b3p.xml.wfs.v100.transaction.PARTIAL _PARTIAL;


      //----------------/
     //- Constructors -/
    //----------------/

    public StatusType() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v100.transaction.StatusType()


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
     * Returns the value of field 'FAILED'.
     * 
     * @return FAILED
     * @return the value of field 'FAILED'.
     */
    public nl.b3p.xml.wfs.v100.transaction.FAILED getFAILED()
    {
        return this._FAILED;
    } //-- nl.b3p.xml.wfs.v100.transaction.FAILED getFAILED() 

    /**
     * Returns the value of field 'PARTIAL'.
     * 
     * @return PARTIAL
     * @return the value of field 'PARTIAL'.
     */
    public nl.b3p.xml.wfs.v100.transaction.PARTIAL getPARTIAL()
    {
        return this._PARTIAL;
    } //-- nl.b3p.xml.wfs.v100.transaction.PARTIAL getPARTIAL() 

    /**
     * Returns the value of field 'SUCCESS'.
     * 
     * @return SUCCESS
     * @return the value of field 'SUCCESS'.
     */
    public nl.b3p.xml.wfs.v100.transaction.SUCCESS getSUCCESS()
    {
        return this._SUCCESS;
    } //-- nl.b3p.xml.wfs.v100.transaction.SUCCESS getSUCCESS() 

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
     * Sets the value of field 'FAILED'.
     * 
     * @param FAILED the value of field 'FAILED'.
     */
    public void setFAILED(nl.b3p.xml.wfs.v100.transaction.FAILED FAILED)
    {
        this._FAILED = FAILED;
        this._choiceValue = FAILED;
    } //-- void setFAILED(nl.b3p.xml.wfs.v100.transaction.FAILED) 

    /**
     * Sets the value of field 'PARTIAL'.
     * 
     * @param PARTIAL the value of field 'PARTIAL'.
     */
    public void setPARTIAL(nl.b3p.xml.wfs.v100.transaction.PARTIAL PARTIAL)
    {
        this._PARTIAL = PARTIAL;
        this._choiceValue = PARTIAL;
    } //-- void setPARTIAL(nl.b3p.xml.wfs.v100.transaction.PARTIAL) 

    /**
     * Sets the value of field 'SUCCESS'.
     * 
     * @param SUCCESS the value of field 'SUCCESS'.
     */
    public void setSUCCESS(nl.b3p.xml.wfs.v100.transaction.SUCCESS SUCCESS)
    {
        this._SUCCESS = SUCCESS;
        this._choiceValue = SUCCESS;
    } //-- void setSUCCESS(nl.b3p.xml.wfs.v100.transaction.SUCCESS) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return StatusType
     */
    public static nl.b3p.xml.wfs.v100.transaction.StatusType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.transaction.StatusType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.transaction.StatusType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.transaction.StatusType unmarshal(java.io.Reader) 

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
