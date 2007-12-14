/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100.subset19115;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Unordered list of one or more commonly used or formalised
 * word(s) or phrase(s) used to describe the subject. When needed,
 * the optional "type" can name the type of the associated list of
 * keywords that shall all have the same type. Also when needed,
 * the codeSpace attribute of that "type" can reference the type
 * name authority and/or thesaurus. For OWS use, the optional
 * thesaurusName element was omitted as being complex information
 * that could be referenced by the codeSpace attribute of the Type
 * element. 
 * 
 * @version $Revision$ $Date$
 */
public class KeywordsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _keywordList
     */
    private java.util.ArrayList _keywordList;

    /**
     * Field _type
     */
    private nl.b3p.xml.ows.v100.subset19115.Type _type;


      //----------------/
     //- Constructors -/
    //----------------/

    public KeywordsType() 
     {
        super();
        _keywordList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.subset19115.KeywordsType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addKeyword
     * 
     * 
     * 
     * @param vKeyword
     */
    public void addKeyword(java.lang.String vKeyword)
        throws java.lang.IndexOutOfBoundsException
    {
        _keywordList.add(vKeyword);
    } //-- void addKeyword(java.lang.String) 

    /**
     * Method addKeyword
     * 
     * 
     * 
     * @param index
     * @param vKeyword
     */
    public void addKeyword(int index, java.lang.String vKeyword)
        throws java.lang.IndexOutOfBoundsException
    {
        _keywordList.add(index, vKeyword);
    } //-- void addKeyword(int, java.lang.String) 

    /**
     * Method clearKeyword
     * 
     */
    public void clearKeyword()
    {
        _keywordList.clear();
    } //-- void clearKeyword() 

    /**
     * Method enumerateKeyword
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateKeyword()
    {
        return Collections.enumeration(_keywordList);
    } //-- java.util.Enumeration enumerateKeyword() 

    /**
     * Method getKeyword
     * 
     * 
     * 
     * @param index
     * @return String
     */
    public java.lang.String getKeyword(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _keywordList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_keywordList.get(index);
    } //-- java.lang.String getKeyword(int) 

    /**
     * Method getKeyword
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String[] getKeyword()
    {
        int size = _keywordList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_keywordList.get(index);
        }
        return mArray;
    } //-- java.lang.String[] getKeyword() 

    /**
     * Method getKeywordCount
     * 
     * 
     * 
     * @return int
     */
    public int getKeywordCount()
    {
        return _keywordList.size();
    } //-- int getKeywordCount() 

    /**
     * Returns the value of field 'type'.
     * 
     * @return Type
     * @return the value of field 'type'.
     */
    public nl.b3p.xml.ows.v100.subset19115.Type getType()
    {
        return this._type;
    } //-- nl.b3p.xml.ows.v100.subset19115.Type getType() 

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
     * Method removeKeyword
     * 
     * 
     * 
     * @param vKeyword
     * @return boolean
     */
    public boolean removeKeyword(java.lang.String vKeyword)
    {
        boolean removed = _keywordList.remove(vKeyword);
        return removed;
    } //-- boolean removeKeyword(java.lang.String) 

    /**
     * Method setKeyword
     * 
     * 
     * 
     * @param index
     * @param vKeyword
     */
    public void setKeyword(int index, java.lang.String vKeyword)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _keywordList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _keywordList.set(index, vKeyword);
    } //-- void setKeyword(int, java.lang.String) 

    /**
     * Method setKeyword
     * 
     * 
     * 
     * @param keywordArray
     */
    public void setKeyword(java.lang.String[] keywordArray)
    {
        //-- copy array
        _keywordList.clear();
        for (int i = 0; i < keywordArray.length; i++) {
            _keywordList.add(keywordArray[i]);
        }
    } //-- void setKeyword(java.lang.String) 

    /**
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(nl.b3p.xml.ows.v100.subset19115.Type type)
    {
        this._type = type;
    } //-- void setType(nl.b3p.xml.ows.v100.subset19115.Type) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return KeywordsType
     */
    public static nl.b3p.xml.ows.v100.subset19115.KeywordsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.subset19115.KeywordsType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.subset19115.KeywordsType.class, reader);
    } //-- nl.b3p.xml.ows.v100.subset19115.KeywordsType unmarshal(java.io.Reader) 

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
