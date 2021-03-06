/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v100;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class PropertyIsLikeType.
 * 
 * @version $Revision$ $Date$
 */
public class PropertyIsLikeType extends nl.b3p.xml.ogc.v100.ComparisonOpsType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _wildCard
     */
    private java.lang.String _wildCard;

    /**
     * Field _singleChar
     */
    private java.lang.String _singleChar;

    /**
     * Field _escape
     */
    private java.lang.String _escape;

    /**
     * Field _propertyName
     */
    private nl.b3p.xml.ogc.v100.PropertyName _propertyName;

    /**
     * Field _literal
     */
    private nl.b3p.xml.ogc.v100.Literal _literal;


      //----------------/
     //- Constructors -/
    //----------------/

    public PropertyIsLikeType() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v100.PropertyIsLikeType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'escape'.
     * 
     * @return String
     * @return the value of field 'escape'.
     */
    public java.lang.String getEscape()
    {
        return this._escape;
    } //-- java.lang.String getEscape() 

    /**
     * Returns the value of field 'literal'.
     * 
     * @return Literal
     * @return the value of field 'literal'.
     */
    public nl.b3p.xml.ogc.v100.Literal getLiteral()
    {
        return this._literal;
    } //-- nl.b3p.xml.ogc.v100.Literal getLiteral() 

    /**
     * Returns the value of field 'propertyName'.
     * 
     * @return PropertyName
     * @return the value of field 'propertyName'.
     */
    public nl.b3p.xml.ogc.v100.PropertyName getPropertyName()
    {
        return this._propertyName;
    } //-- nl.b3p.xml.ogc.v100.PropertyName getPropertyName() 

    /**
     * Returns the value of field 'singleChar'.
     * 
     * @return String
     * @return the value of field 'singleChar'.
     */
    public java.lang.String getSingleChar()
    {
        return this._singleChar;
    } //-- java.lang.String getSingleChar() 

    /**
     * Returns the value of field 'wildCard'.
     * 
     * @return String
     * @return the value of field 'wildCard'.
     */
    public java.lang.String getWildCard()
    {
        return this._wildCard;
    } //-- java.lang.String getWildCard() 

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
     * Sets the value of field 'escape'.
     * 
     * @param escape the value of field 'escape'.
     */
    public void setEscape(java.lang.String escape)
    {
        this._escape = escape;
    } //-- void setEscape(java.lang.String) 

    /**
     * Sets the value of field 'literal'.
     * 
     * @param literal the value of field 'literal'.
     */
    public void setLiteral(nl.b3p.xml.ogc.v100.Literal literal)
    {
        this._literal = literal;
    } //-- void setLiteral(nl.b3p.xml.ogc.v100.Literal) 

    /**
     * Sets the value of field 'propertyName'.
     * 
     * @param propertyName the value of field 'propertyName'.
     */
    public void setPropertyName(nl.b3p.xml.ogc.v100.PropertyName propertyName)
    {
        this._propertyName = propertyName;
    } //-- void setPropertyName(nl.b3p.xml.ogc.v100.PropertyName) 

    /**
     * Sets the value of field 'singleChar'.
     * 
     * @param singleChar the value of field 'singleChar'.
     */
    public void setSingleChar(java.lang.String singleChar)
    {
        this._singleChar = singleChar;
    } //-- void setSingleChar(java.lang.String) 

    /**
     * Sets the value of field 'wildCard'.
     * 
     * @param wildCard the value of field 'wildCard'.
     */
    public void setWildCard(java.lang.String wildCard)
    {
        this._wildCard = wildCard;
    } //-- void setWildCard(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return ComparisonOpsType
     */
    public static nl.b3p.xml.ogc.v100.ComparisonOpsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v100.ComparisonOpsType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.PropertyIsLikeType.class, reader);
    } //-- nl.b3p.xml.ogc.v100.ComparisonOpsType unmarshal(java.io.Reader) 

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
