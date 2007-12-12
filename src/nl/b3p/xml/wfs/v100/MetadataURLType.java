/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class MetadataURLType.
 * 
 * @version $Revision$ $Date$
 */
public class MetadataURLType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * internal content storage
     */
    private java.lang.String _content = "";

    /**
     * Field _type
     */
    private nl.b3p.xml.wfs.v100.types.MetadataURLTypeTypeType _type;

    /**
     * Field _format
     */
    private nl.b3p.xml.wfs.v100.types.MetadataURLTypeFormatType _format;


      //----------------/
     //- Constructors -/
    //----------------/

    public MetadataURLType() 
     {
        super();
        setContent("");
    } //-- nl.b3p.xml.wfs.v100.MetadataURLType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'content'. The field 'content'
     * has the following description: internal content storage
     * 
     * @return String
     * @return the value of field 'content'.
     */
    public java.lang.String getContent()
    {
        return this._content;
    } //-- java.lang.String getContent() 

    /**
     * Returns the value of field 'format'.
     * 
     * @return MetadataURLTypeFormatType
     * @return the value of field 'format'.
     */
    public nl.b3p.xml.wfs.v100.types.MetadataURLTypeFormatType getFormat()
    {
        return this._format;
    } //-- nl.b3p.xml.wfs.v100.types.MetadataURLTypeFormatType getFormat() 

    /**
     * Returns the value of field 'type'.
     * 
     * @return MetadataURLTypeTypeType
     * @return the value of field 'type'.
     */
    public nl.b3p.xml.wfs.v100.types.MetadataURLTypeTypeType getType()
    {
        return this._type;
    } //-- nl.b3p.xml.wfs.v100.types.MetadataURLTypeTypeType getType() 

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
     * Sets the value of field 'content'. The field 'content' has
     * the following description: internal content storage
     * 
     * @param content the value of field 'content'.
     */
    public void setContent(java.lang.String content)
    {
        this._content = content;
    } //-- void setContent(java.lang.String) 

    /**
     * Sets the value of field 'format'.
     * 
     * @param format the value of field 'format'.
     */
    public void setFormat(nl.b3p.xml.wfs.v100.types.MetadataURLTypeFormatType format)
    {
        this._format = format;
    } //-- void setFormat(nl.b3p.xml.wfs.v100.types.MetadataURLTypeFormatType) 

    /**
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(nl.b3p.xml.wfs.v100.types.MetadataURLTypeTypeType type)
    {
        this._type = type;
    } //-- void setType(nl.b3p.xml.wfs.v100.types.MetadataURLTypeTypeType) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return MetadataURLType
     */
    public static nl.b3p.xml.wfs.v100.MetadataURLType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.MetadataURLType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.MetadataURLType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.MetadataURLType unmarshal(java.io.Reader) 

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
