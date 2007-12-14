/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100.serviceidentification;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Name or code with an (optional) authority. If the codeSpace
 * attribute is present, its value should reference a dictionary,
 * thesaurus, or authority for the name or code, such as the
 * organisation who assigned the value, or the dictionary from
 * which it is taken. Type copied from basicTypes.xsd of GML 3 with
 * documentation edited, for possible use outside the
 * ServiceIdentification section of a service metadata document. 
 * 
 * @version $Revision$ $Date$
 */
public class CodeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * internal content storage
     */
    private java.lang.String _content = "";

    /**
     * Field _codeSpace
     */
    private java.lang.String _codeSpace;


      //----------------/
     //- Constructors -/
    //----------------/

    public CodeType() 
     {
        super();
        setContent("");
    } //-- nl.b3p.xml.ows.v100.serviceidentification.CodeType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'codeSpace'.
     * 
     * @return String
     * @return the value of field 'codeSpace'.
     */
    public java.lang.String getCodeSpace()
    {
        return this._codeSpace;
    } //-- java.lang.String getCodeSpace() 

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
     * Sets the value of field 'codeSpace'.
     * 
     * @param codeSpace the value of field 'codeSpace'.
     */
    public void setCodeSpace(java.lang.String codeSpace)
    {
        this._codeSpace = codeSpace;
    } //-- void setCodeSpace(java.lang.String) 

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
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return CodeType
     */
    public static nl.b3p.xml.ows.v100.serviceidentification.CodeType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.serviceidentification.CodeType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.serviceidentification.CodeType.class, reader);
    } //-- nl.b3p.xml.ows.v100.serviceidentification.CodeType unmarshal(java.io.Reader) 

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
