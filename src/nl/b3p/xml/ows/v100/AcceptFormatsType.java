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
 * Prioritized sequence of zero or more GetCapabilities operation
 * response formats desired by client, with preferred formats
 * listed first. Each response format shall be identified by its
 * MIME type. See AcceptFormats parameter use subclause for more
 * information. 
 * 
 * @version $Revision$ $Date$
 */
public class AcceptFormatsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _outputFormatList
     */
    private java.util.ArrayList _outputFormatList;


      //----------------/
     //- Constructors -/
    //----------------/

    public AcceptFormatsType() 
     {
        super();
        _outputFormatList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.AcceptFormatsType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addOutputFormat
     * 
     * 
     * 
     * @param vOutputFormat
     */
    public void addOutputFormat(java.lang.String vOutputFormat)
        throws java.lang.IndexOutOfBoundsException
    {
        _outputFormatList.add(vOutputFormat);
    } //-- void addOutputFormat(java.lang.String) 

    /**
     * Method addOutputFormat
     * 
     * 
     * 
     * @param index
     * @param vOutputFormat
     */
    public void addOutputFormat(int index, java.lang.String vOutputFormat)
        throws java.lang.IndexOutOfBoundsException
    {
        _outputFormatList.add(index, vOutputFormat);
    } //-- void addOutputFormat(int, java.lang.String) 

    /**
     * Method clearOutputFormat
     * 
     */
    public void clearOutputFormat()
    {
        _outputFormatList.clear();
    } //-- void clearOutputFormat() 

    /**
     * Method enumerateOutputFormat
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateOutputFormat()
    {
        return Collections.enumeration(_outputFormatList);
    } //-- java.util.Enumeration enumerateOutputFormat() 

    /**
     * Method getOutputFormat
     * 
     * 
     * 
     * @param index
     * @return String
     */
    public java.lang.String getOutputFormat(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _outputFormatList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_outputFormatList.get(index);
    } //-- java.lang.String getOutputFormat(int) 

    /**
     * Method getOutputFormat
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String[] getOutputFormat()
    {
        int size = _outputFormatList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_outputFormatList.get(index);
        }
        return mArray;
    } //-- java.lang.String[] getOutputFormat() 

    /**
     * Method getOutputFormatCount
     * 
     * 
     * 
     * @return int
     */
    public int getOutputFormatCount()
    {
        return _outputFormatList.size();
    } //-- int getOutputFormatCount() 

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
     * Method removeOutputFormat
     * 
     * 
     * 
     * @param vOutputFormat
     * @return boolean
     */
    public boolean removeOutputFormat(java.lang.String vOutputFormat)
    {
        boolean removed = _outputFormatList.remove(vOutputFormat);
        return removed;
    } //-- boolean removeOutputFormat(java.lang.String) 

    /**
     * Method setOutputFormat
     * 
     * 
     * 
     * @param index
     * @param vOutputFormat
     */
    public void setOutputFormat(int index, java.lang.String vOutputFormat)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _outputFormatList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _outputFormatList.set(index, vOutputFormat);
    } //-- void setOutputFormat(int, java.lang.String) 

    /**
     * Method setOutputFormat
     * 
     * 
     * 
     * @param outputFormatArray
     */
    public void setOutputFormat(java.lang.String[] outputFormatArray)
    {
        //-- copy array
        _outputFormatList.clear();
        for (int i = 0; i < outputFormatArray.length; i++) {
            _outputFormatList.add(outputFormatArray[i]);
        }
    } //-- void setOutputFormat(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return AcceptFormatsType
     */
    public static nl.b3p.xml.ows.v100.AcceptFormatsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.AcceptFormatsType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.AcceptFormatsType.class, reader);
    } //-- nl.b3p.xml.ows.v100.AcceptFormatsType unmarshal(java.io.Reader) 

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
