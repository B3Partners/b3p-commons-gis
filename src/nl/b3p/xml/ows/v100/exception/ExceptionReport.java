/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100.exception;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Report message returned to the client that requested any OWS
 * operation when the server detects an error while processing that
 * operation request. 
 * 
 * @version $Revision$ $Date$
 */
public class ExceptionReport implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Specification version for OWS operation. The string value
     * shall contain one x.y.z "version" value (e.g., "2.1.3"). A
     * version number shall contain three non-negative integers
     * separated by decimal points, in the form "x.y.z". The
     * integers y and z shall not exceed 99. Each version shall be
     * for the Implementation Specification (document) and the
     * associated XML Schemas to which requested operations will
     * conform. An Implementation Specification version normally
     * specifies XML Schemas against which an XML encoded operation
     * response must conform and should be validated. See Version
     * negotiation subclause for more information. 
     */
    private java.lang.String _version;

    /**
     * Identifier of the language used by all included exception
     * text values. These language identifiers shall be as
     * specified in IETF RFC 1766. When this attribute is omitted,
     * the language used is not identified. 
     */
    private java.lang.String _language;

    /**
     * Unordered list of one or more Exception elements that each
     * describes an error. These Exception elements shall be
     * interpreted by clients as being independent of one another
     * (not hierarchical). 
     */
    private java.util.ArrayList _exceptionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ExceptionReport() 
     {
        super();
        _exceptionList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.exception.ExceptionReport()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addException
     * 
     * 
     * 
     * @param vException
     */
    public void addException(nl.b3p.xml.ows.v100.exception.Exception vException)
        throws java.lang.IndexOutOfBoundsException
    {
        _exceptionList.add(vException);
    } //-- void addException(nl.b3p.xml.ows.v100.exception.Exception) 

    /**
     * Method addException
     * 
     * 
     * 
     * @param index
     * @param vException
     */
    public void addException(int index, nl.b3p.xml.ows.v100.exception.Exception vException)
        throws java.lang.IndexOutOfBoundsException
    {
        _exceptionList.add(index, vException);
    } //-- void addException(int, nl.b3p.xml.ows.v100.exception.Exception) 

    /**
     * Method clearException
     * 
     */
    public void clearException()
    {
        _exceptionList.clear();
    } //-- void clearException() 

    /**
     * Method enumerateException
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateException()
    {
        return Collections.enumeration(_exceptionList);
    } //-- java.util.Enumeration enumerateException() 

    /**
     * Method getException
     * 
     * 
     * 
     * @param index
     * @return Exception
     */
    public nl.b3p.xml.ows.v100.exception.Exception getException(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _exceptionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.exception.Exception) _exceptionList.get(index);
    } //-- nl.b3p.xml.ows.v100.exception.Exception getException(int) 

    /**
     * Method getException
     * 
     * 
     * 
     * @return Exception
     */
    public nl.b3p.xml.ows.v100.exception.Exception[] getException()
    {
        int size = _exceptionList.size();
        nl.b3p.xml.ows.v100.exception.Exception[] mArray = new nl.b3p.xml.ows.v100.exception.Exception[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.exception.Exception) _exceptionList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.exception.Exception[] getException() 

    /**
     * Method getExceptionCount
     * 
     * 
     * 
     * @return int
     */
    public int getExceptionCount()
    {
        return _exceptionList.size();
    } //-- int getExceptionCount() 

    /**
     * Returns the value of field 'language'. The field 'language'
     * has the following description: Identifier of the language
     * used by all included exception text values. These language
     * identifiers shall be as specified in IETF RFC 1766. When
     * this attribute is omitted, the language used is not
     * identified. 
     * 
     * @return String
     * @return the value of field 'language'.
     */
    public java.lang.String getLanguage()
    {
        return this._language;
    } //-- java.lang.String getLanguage() 

    /**
     * Returns the value of field 'version'. The field 'version'
     * has the following description: Specification version for OWS
     * operation. The string value shall contain one x.y.z
     * "version" value (e.g., "2.1.3"). A version number shall
     * contain three non-negative integers separated by decimal
     * points, in the form "x.y.z". The integers y and z shall not
     * exceed 99. Each version shall be for the Implementation
     * Specification (document) and the associated XML Schemas to
     * which requested operations will conform. An Implementation
     * Specification version normally specifies XML Schemas against
     * which an XML encoded operation response must conform and
     * should be validated. See Version negotiation subclause for
     * more information. 
     * 
     * @return String
     * @return the value of field 'version'.
     */
    public java.lang.String getVersion()
    {
        return this._version;
    } //-- java.lang.String getVersion() 

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
     * Method removeException
     * 
     * 
     * 
     * @param vException
     * @return boolean
     */
    public boolean removeException(nl.b3p.xml.ows.v100.exception.Exception vException)
    {
        boolean removed = _exceptionList.remove(vException);
        return removed;
    } //-- boolean removeException(nl.b3p.xml.ows.v100.exception.Exception) 

    /**
     * Method setException
     * 
     * 
     * 
     * @param index
     * @param vException
     */
    public void setException(int index, nl.b3p.xml.ows.v100.exception.Exception vException)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _exceptionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _exceptionList.set(index, vException);
    } //-- void setException(int, nl.b3p.xml.ows.v100.exception.Exception) 

    /**
     * Method setException
     * 
     * 
     * 
     * @param exceptionArray
     */
    public void setException(nl.b3p.xml.ows.v100.exception.Exception[] exceptionArray)
    {
        //-- copy array
        _exceptionList.clear();
        for (int i = 0; i < exceptionArray.length; i++) {
            _exceptionList.add(exceptionArray[i]);
        }
    } //-- void setException(nl.b3p.xml.ows.v100.exception.Exception) 

    /**
     * Sets the value of field 'language'. The field 'language' has
     * the following description: Identifier of the language used
     * by all included exception text values. These language
     * identifiers shall be as specified in IETF RFC 1766. When
     * this attribute is omitted, the language used is not
     * identified. 
     * 
     * @param language the value of field 'language'.
     */
    public void setLanguage(java.lang.String language)
    {
        this._language = language;
    } //-- void setLanguage(java.lang.String) 

    /**
     * Sets the value of field 'version'. The field 'version' has
     * the following description: Specification version for OWS
     * operation. The string value shall contain one x.y.z
     * "version" value (e.g., "2.1.3"). A version number shall
     * contain three non-negative integers separated by decimal
     * points, in the form "x.y.z". The integers y and z shall not
     * exceed 99. Each version shall be for the Implementation
     * Specification (document) and the associated XML Schemas to
     * which requested operations will conform. An Implementation
     * Specification version normally specifies XML Schemas against
     * which an XML encoded operation response must conform and
     * should be validated. See Version negotiation subclause for
     * more information. 
     * 
     * @param version the value of field 'version'.
     */
    public void setVersion(java.lang.String version)
    {
        this._version = version;
    } //-- void setVersion(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return ExceptionReport
     */
    public static nl.b3p.xml.ows.v100.exception.ExceptionReport unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.exception.ExceptionReport) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.exception.ExceptionReport.class, reader);
    } //-- nl.b3p.xml.ows.v100.exception.ExceptionReport unmarshal(java.io.Reader) 

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
