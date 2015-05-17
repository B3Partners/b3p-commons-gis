/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v110;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * An element of this type that describes a GML object in an
 *  application namespace shall have an xml xmlns specifier,
 *  e.g. xmlns:bo="http://www.BlueOx.org/BlueOx"
 *  
 * 
 * @version $Revision$ $Date$
 */
public class GMLObjectTypeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Name of this GML Object type, including any namespace
     * prefix.
     *  
     */
    private java.lang.String _name;

    /**
     * Title of this GML Object type, normally used for display
     *  to a human.
     *  
     */
    private java.lang.String _title;

    /**
     * Brief narrative description of this GML Object type,
     * normally
     *  used for display to a human.
     *  
     */
    private java.lang.String _abstract;

    /**
     * Field _keywordsList
     */
    private java.util.ArrayList _keywordsList;

    /**
     * Field _outputFormats_GMLObjectTypeType
     */
    private nl.b3p.xml.wfs.v110.OutputFormats_GMLObjectTypeType _outputFormats_GMLObjectTypeType;


      //----------------/
     //- Constructors -/
    //----------------/

    public GMLObjectTypeType() 
     {
        super();
        _keywordsList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v110.GMLObjectTypeType()


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
    public void addKeywords(nl.b3p.xml.ows.v100.Keywords vKeywords)
        throws java.lang.IndexOutOfBoundsException
    {
        _keywordsList.add(vKeywords);
    } //-- void addKeywords(nl.b3p.xml.ows.v100.Keywords) 

    /**
     * Method addKeywords
     * 
     * 
     * 
     * @param index
     * @param vKeywords
     */
    public void addKeywords(int index, nl.b3p.xml.ows.v100.Keywords vKeywords)
        throws java.lang.IndexOutOfBoundsException
    {
        _keywordsList.add(index, vKeywords);
    } //-- void addKeywords(int, nl.b3p.xml.ows.v100.Keywords) 

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
     * of this GML Object type, normally
     *  used for display to a human.
     *  
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
    public nl.b3p.xml.ows.v100.Keywords getKeywords(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _keywordsList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.Keywords) _keywordsList.get(index);
    } //-- nl.b3p.xml.ows.v100.Keywords getKeywords(int) 

    /**
     * Method getKeywords
     * 
     * 
     * 
     * @return Keywords
     */
    public nl.b3p.xml.ows.v100.Keywords[] getKeywords()
    {
        int size = _keywordsList.size();
        nl.b3p.xml.ows.v100.Keywords[] mArray = new nl.b3p.xml.ows.v100.Keywords[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.Keywords) _keywordsList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.Keywords[] getKeywords() 

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
     * Returns the value of field 'name'. The field 'name' has the
     * following description: Name of this GML Object type,
     * including any namespace prefix.
     *  
     * 
     * @return String
     * @return the value of field 'name'.
     */
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Returns the value of field
     * 'outputFormats_GMLObjectTypeType'.
     * 
     * @return OutputFormats_GMLObjectTypeType
     * @return the value of field 'outputFormats_GMLObjectTypeType'.
     */
    public nl.b3p.xml.wfs.v110.OutputFormats_GMLObjectTypeType getOutputFormats_GMLObjectTypeType()
    {
        return this._outputFormats_GMLObjectTypeType;
    } //-- nl.b3p.xml.wfs.v110.OutputFormats_GMLObjectTypeType getOutputFormats_GMLObjectTypeType() 

    /**
     * Returns the value of field 'title'. The field 'title' has
     * the following description: Title of this GML Object type,
     * normally used for display
     *  to a human.
     *  
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
    public boolean removeKeywords(nl.b3p.xml.ows.v100.Keywords vKeywords)
    {
        boolean removed = _keywordsList.remove(vKeywords);
        return removed;
    } //-- boolean removeKeywords(nl.b3p.xml.ows.v100.Keywords) 

    /**
     * Sets the value of field 'abstract'. The field 'abstract' has
     * the following description: Brief narrative description of
     * this GML Object type, normally
     *  used for display to a human.
     *  
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
    public void setKeywords(int index, nl.b3p.xml.ows.v100.Keywords vKeywords)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _keywordsList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _keywordsList.set(index, vKeywords);
    } //-- void setKeywords(int, nl.b3p.xml.ows.v100.Keywords) 

    /**
     * Method setKeywords
     * 
     * 
     * 
     * @param keywordsArray
     */
    public void setKeywords(nl.b3p.xml.ows.v100.Keywords[] keywordsArray)
    {
        //-- copy array
        _keywordsList.clear();
        for (int i = 0; i < keywordsArray.length; i++) {
            _keywordsList.add(keywordsArray[i]);
        }
    } //-- void setKeywords(nl.b3p.xml.ows.v100.Keywords) 

    /**
     * Sets the value of field 'name'. The field 'name' has the
     * following description: Name of this GML Object type,
     * including any namespace prefix.
     *  
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Sets the value of field 'outputFormats_GMLObjectTypeType'.
     * 
     * @param outputFormats_GMLObjectTypeType the value of field
     * 'outputFormats_GMLObjectTypeType'.
     */
    public void setOutputFormats_GMLObjectTypeType(nl.b3p.xml.wfs.v110.OutputFormats_GMLObjectTypeType outputFormats_GMLObjectTypeType)
    {
        this._outputFormats_GMLObjectTypeType = outputFormats_GMLObjectTypeType;
    } //-- void setOutputFormats_GMLObjectTypeType(nl.b3p.xml.wfs.v110.OutputFormats_GMLObjectTypeType) 

    /**
     * Sets the value of field 'title'. The field 'title' has the
     * following description: Title of this GML Object type,
     * normally used for display
     *  to a human.
     *  
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
     * @return GMLObjectTypeType
     */
    public static nl.b3p.xml.wfs.v110.GMLObjectTypeType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.GMLObjectTypeType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.GMLObjectTypeType.class, reader);
    } //-- nl.b3p.xml.wfs.v110.GMLObjectTypeType unmarshal(java.io.Reader) 

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
