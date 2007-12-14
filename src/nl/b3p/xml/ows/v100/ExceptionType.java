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

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * An Exception element describes one detected error that a server
 * chooses to convey to the client. 
 * 
 * @version $Revision$ $Date$
 */
public class ExceptionType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * A code representing the type of this exception, which shall
     * be selected from a set of exceptionCode values specified for
     * the specific service operation and server. 
     */
    private java.lang.String _exceptionCode;

    /**
     * When included, this locator shall indicate to the client
     * where an exception was encountered in servicing the client's
     * operation request. This locator should be included whenever
     * meaningful information can be provided by the server. The
     * contents of this locator will depend on the specific
     * exceptionCode and OWS service, and shall be specified in the
     * OWS Implementation Specification. 
     */
    private java.lang.String _locator;

    /**
     * Ordered sequence of text strings that describe this specific
     * exception or error. The contents of these strings are left
     * open to definition by each server implementation. A server
     * is strongly encouraged to include at least one ExceptionText
     * value, to provide more information about the detected error
     * than provided by the exceptionCode. When included, multiple
     * ExceptionText values shall provide hierarchical information
     * about one detected error, with the most significant
     * information listed first. 
     */
    private java.util.ArrayList _exceptionTextList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ExceptionType() 
     {
        super();
        _exceptionTextList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.ExceptionType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addExceptionText
     * 
     * 
     * 
     * @param vExceptionText
     */
    public void addExceptionText(java.lang.String vExceptionText)
        throws java.lang.IndexOutOfBoundsException
    {
        _exceptionTextList.add(vExceptionText);
    } //-- void addExceptionText(java.lang.String) 

    /**
     * Method addExceptionText
     * 
     * 
     * 
     * @param index
     * @param vExceptionText
     */
    public void addExceptionText(int index, java.lang.String vExceptionText)
        throws java.lang.IndexOutOfBoundsException
    {
        _exceptionTextList.add(index, vExceptionText);
    } //-- void addExceptionText(int, java.lang.String) 

    /**
     * Method clearExceptionText
     * 
     */
    public void clearExceptionText()
    {
        _exceptionTextList.clear();
    } //-- void clearExceptionText() 

    /**
     * Method enumerateExceptionText
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateExceptionText()
    {
        return Collections.enumeration(_exceptionTextList);
    } //-- java.util.Enumeration enumerateExceptionText() 

    /**
     * Returns the value of field 'exceptionCode'. The field
     * 'exceptionCode' has the following description: A code
     * representing the type of this exception, which shall be
     * selected from a set of exceptionCode values specified for
     * the specific service operation and server. 
     * 
     * @return String
     * @return the value of field 'exceptionCode'.
     */
    public java.lang.String getExceptionCode()
    {
        return this._exceptionCode;
    } //-- java.lang.String getExceptionCode() 

    /**
     * Method getExceptionText
     * 
     * 
     * 
     * @param index
     * @return String
     */
    public java.lang.String getExceptionText(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _exceptionTextList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_exceptionTextList.get(index);
    } //-- java.lang.String getExceptionText(int) 

    /**
     * Method getExceptionText
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String[] getExceptionText()
    {
        int size = _exceptionTextList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_exceptionTextList.get(index);
        }
        return mArray;
    } //-- java.lang.String[] getExceptionText() 

    /**
     * Method getExceptionTextCount
     * 
     * 
     * 
     * @return int
     */
    public int getExceptionTextCount()
    {
        return _exceptionTextList.size();
    } //-- int getExceptionTextCount() 

    /**
     * Returns the value of field 'locator'. The field 'locator'
     * has the following description: When included, this locator
     * shall indicate to the client where an exception was
     * encountered in servicing the client's operation request.
     * This locator should be included whenever meaningful
     * information can be provided by the server. The contents of
     * this locator will depend on the specific exceptionCode and
     * OWS service, and shall be specified in the OWS
     * Implementation Specification. 
     * 
     * @return String
     * @return the value of field 'locator'.
     */
    public java.lang.String getLocator()
    {
        return this._locator;
    } //-- java.lang.String getLocator() 

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
     * Method removeExceptionText
     * 
     * 
     * 
     * @param vExceptionText
     * @return boolean
     */
    public boolean removeExceptionText(java.lang.String vExceptionText)
    {
        boolean removed = _exceptionTextList.remove(vExceptionText);
        return removed;
    } //-- boolean removeExceptionText(java.lang.String) 

    /**
     * Sets the value of field 'exceptionCode'. The field
     * 'exceptionCode' has the following description: A code
     * representing the type of this exception, which shall be
     * selected from a set of exceptionCode values specified for
     * the specific service operation and server. 
     * 
     * @param exceptionCode the value of field 'exceptionCode'.
     */
    public void setExceptionCode(java.lang.String exceptionCode)
    {
        this._exceptionCode = exceptionCode;
    } //-- void setExceptionCode(java.lang.String) 

    /**
     * Method setExceptionText
     * 
     * 
     * 
     * @param index
     * @param vExceptionText
     */
    public void setExceptionText(int index, java.lang.String vExceptionText)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _exceptionTextList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _exceptionTextList.set(index, vExceptionText);
    } //-- void setExceptionText(int, java.lang.String) 

    /**
     * Method setExceptionText
     * 
     * 
     * 
     * @param exceptionTextArray
     */
    public void setExceptionText(java.lang.String[] exceptionTextArray)
    {
        //-- copy array
        _exceptionTextList.clear();
        for (int i = 0; i < exceptionTextArray.length; i++) {
            _exceptionTextList.add(exceptionTextArray[i]);
        }
    } //-- void setExceptionText(java.lang.String) 

    /**
     * Sets the value of field 'locator'. The field 'locator' has
     * the following description: When included, this locator shall
     * indicate to the client where an exception was encountered in
     * servicing the client's operation request. This locator
     * should be included whenever meaningful information can be
     * provided by the server. The contents of this locator will
     * depend on the specific exceptionCode and OWS service, and
     * shall be specified in the OWS Implementation Specification. 
     * 
     * @param locator the value of field 'locator'.
     */
    public void setLocator(java.lang.String locator)
    {
        this._locator = locator;
    } //-- void setLocator(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return ExceptionType
     */
    public static nl.b3p.xml.ows.v100.ExceptionType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.ExceptionType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.ExceptionType.class, reader);
    } //-- nl.b3p.xml.ows.v100.ExceptionType unmarshal(java.io.Reader) 

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
