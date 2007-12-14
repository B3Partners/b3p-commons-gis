/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100.dataidentification;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Human-readable descriptive information for the object it is
 * included within.
 * This type shall be extended if needed for specific OWS use to
 * include additional metadata for each type of information. This
 * type shall not be restricted for a specific OWS to change the
 * multiplicity (or optionality) of some elements. 
 * 
 * @version $Revision$ $Date$
 */
public class DescriptionType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Title of this resource, normally used for display to a human.
     */
    private java.lang.String _title;

    /**
     * Brief narrative description of this resource, normally used
     * for display to a human. 
     */
    private java.lang.String _abstract;

    /**
     * Field _keywordsList
     */
    private java.util.ArrayList _keywordsList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DescriptionType() 
     {
        super();
        _keywordsList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.dataidentification.DescriptionType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addKeywords
     * 
     * 
     * 
     * @param vKeywords
     */
    public void addKeywords(nl.b3p.xml.ows.v100.dataidentification.Keywords vKeywords)
        throws java.lang.IndexOutOfBoundsException
    {
        _keywordsList.add(vKeywords);
    } //-- void addKeywords(nl.b3p.xml.ows.v100.dataidentification.Keywords) 

    /**
     * Method addKeywords
     * 
     * 
     * 
     * @param index
     * @param vKeywords
     */
    public void addKeywords(int index, nl.b3p.xml.ows.v100.dataidentification.Keywords vKeywords)
        throws java.lang.IndexOutOfBoundsException
    {
        _keywordsList.add(index, vKeywords);
    } //-- void addKeywords(int, nl.b3p.xml.ows.v100.dataidentification.Keywords) 

    /**
     * Method clearKeywords
     * 
     */
    public void clearKeywords()
    {
        _keywordsList.clear();
    } //-- void clearKeywords() 

    /**
     * Method enumerateKeywords
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateKeywords()
    {
        return Collections.enumeration(_keywordsList);
    } //-- java.util.Enumeration enumerateKeywords() 

    /**
     * Returns the value of field 'abstract'. The field 'abstract'
     * has the following description: Brief narrative description
     * of this resource, normally used for display to a human. 
     * 
     * @return String
     * @return the value of field 'abstract'.
     */
    public java.lang.String getAbstract()
    {
        return this._abstract;
    } //-- java.lang.String getAbstract() 

    /**
     * Method getKeywords
     * 
     * 
     * 
     * @param index
     * @return Keywords
     */
    public nl.b3p.xml.ows.v100.dataidentification.Keywords getKeywords(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _keywordsList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.dataidentification.Keywords) _keywordsList.get(index);
    } //-- nl.b3p.xml.ows.v100.dataidentification.Keywords getKeywords(int) 

    /**
     * Method getKeywords
     * 
     * 
     * 
     * @return Keywords
     */
    public nl.b3p.xml.ows.v100.dataidentification.Keywords[] getKeywords()
    {
        int size = _keywordsList.size();
        nl.b3p.xml.ows.v100.dataidentification.Keywords[] mArray = new nl.b3p.xml.ows.v100.dataidentification.Keywords[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.dataidentification.Keywords) _keywordsList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.dataidentification.Keywords[] getKeywords() 

    /**
     * Method getKeywordsCount
     * 
     * 
     * 
     * @return int
     */
    public int getKeywordsCount()
    {
        return _keywordsList.size();
    } //-- int getKeywordsCount() 

    /**
     * Returns the value of field 'title'. The field 'title' has
     * the following description: Title of this resource, normally
     * used for display to a human. 
     * 
     * @return String
     * @return the value of field 'title'.
     */
    public java.lang.String getTitle()
    {
        return this._title;
    } //-- java.lang.String getTitle() 

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
     * Method removeKeywords
     * 
     * 
     * 
     * @param vKeywords
     * @return boolean
     */
    public boolean removeKeywords(nl.b3p.xml.ows.v100.dataidentification.Keywords vKeywords)
    {
        boolean removed = _keywordsList.remove(vKeywords);
        return removed;
    } //-- boolean removeKeywords(nl.b3p.xml.ows.v100.dataidentification.Keywords) 

    /**
     * Sets the value of field 'abstract'. The field 'abstract' has
     * the following description: Brief narrative description of
     * this resource, normally used for display to a human. 
     * 
     * @param _abstract
     * @param abstract the value of field 'abstract'.
     */
    public void setAbstract(java.lang.String _abstract)
    {
        this._abstract = _abstract;
    } //-- void setAbstract(java.lang.String) 

    /**
     * Method setKeywords
     * 
     * 
     * 
     * @param index
     * @param vKeywords
     */
    public void setKeywords(int index, nl.b3p.xml.ows.v100.dataidentification.Keywords vKeywords)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _keywordsList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _keywordsList.set(index, vKeywords);
    } //-- void setKeywords(int, nl.b3p.xml.ows.v100.dataidentification.Keywords) 

    /**
     * Method setKeywords
     * 
     * 
     * 
     * @param keywordsArray
     */
    public void setKeywords(nl.b3p.xml.ows.v100.dataidentification.Keywords[] keywordsArray)
    {
        //-- copy array
        _keywordsList.clear();
        for (int i = 0; i < keywordsArray.length; i++) {
            _keywordsList.add(keywordsArray[i]);
        }
    } //-- void setKeywords(nl.b3p.xml.ows.v100.dataidentification.Keywords) 

    /**
     * Sets the value of field 'title'. The field 'title' has the
     * following description: Title of this resource, normally used
     * for display to a human. 
     * 
     * @param title the value of field 'title'.
     */
    public void setTitle(java.lang.String title)
    {
        this._title = title;
    } //-- void setTitle(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return DescriptionType
     */
    public static nl.b3p.xml.ows.v100.dataidentification.DescriptionType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.dataidentification.DescriptionType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.dataidentification.DescriptionType.class, reader);
    } //-- nl.b3p.xml.ows.v100.dataidentification.DescriptionType unmarshal(java.io.Reader) 

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
