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
 * An element of this type that describes a feature in an
 * application
 *  namespace shall have an xml xmlns specifier, e.g.
 *  xmlns:bo="http://www.BlueOx.org/BlueOx"
 *  
 * 
 * @version $Revision$ $Date$
 */
public class FeatureTypeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Name of this feature type, including any namespace prefix
     *  
     */
    private java.lang.String _name;

    /**
     * Title of this feature type, normally used for display
     *  to a human.
     *  
     */
    private java.lang.String _title;

    /**
     * Brief narrative description of this feature type, normally
     *  used for display to a human.
     *  
     */
    private java.lang.String _abstract;

    /**
     * Field _keywordsList
     */
    private java.util.ArrayList _keywordsList;

    /**
     * Field _featureTypeTypeChoice
     */
    private nl.b3p.xml.wfs.v110.FeatureTypeTypeChoice _featureTypeTypeChoice;

    /**
     * Field _operations_FeatureTypeType
     */
    private nl.b3p.xml.wfs.v110.Operations_FeatureTypeType _operations_FeatureTypeType;

    /**
     * Field _outputFormats_FeatureTypeType
     */
    private nl.b3p.xml.wfs.v110.OutputFormats_FeatureTypeType _outputFormats_FeatureTypeType;

    /**
     * Field _WGS84BoundingBoxList
     */
    private java.util.ArrayList _WGS84BoundingBoxList;

    /**
     * Field _metadataURLList
     */
    private java.util.ArrayList _metadataURLList;


      //----------------/
     //- Constructors -/
    //----------------/

    public FeatureTypeType() 
     {
        super();
        _keywordsList = new java.util.ArrayList();
        _WGS84BoundingBoxList = new java.util.ArrayList();
        _metadataURLList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v110.FeatureTypeType()


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
     * Method addMetadataURL
     * 
     * 
     * 
     * @param vMetadataURL
     */
    public void addMetadataURL(nl.b3p.xml.wfs.v110.MetadataURL vMetadataURL)
        throws java.lang.IndexOutOfBoundsException
    {
        _metadataURLList.add(vMetadataURL);
    } //-- void addMetadataURL(nl.b3p.xml.wfs.v110.MetadataURL) 

    /**
     * Method addMetadataURL
     * 
     * 
     * 
     * @param index
     * @param vMetadataURL
     */
    public void addMetadataURL(int index, nl.b3p.xml.wfs.v110.MetadataURL vMetadataURL)
        throws java.lang.IndexOutOfBoundsException
    {
        _metadataURLList.add(index, vMetadataURL);
    } //-- void addMetadataURL(int, nl.b3p.xml.wfs.v110.MetadataURL) 

    /**
     * Method addWGS84BoundingBox
     * 
     * 
     * 
     * @param vWGS84BoundingBox
     */
    public void addWGS84BoundingBox(nl.b3p.xml.ows.v100.WGS84BoundingBox vWGS84BoundingBox)
        throws java.lang.IndexOutOfBoundsException
    {
        _WGS84BoundingBoxList.add(vWGS84BoundingBox);
    } //-- void addWGS84BoundingBox(nl.b3p.xml.ows.v100.WGS84BoundingBox) 

    /**
     * Method addWGS84BoundingBox
     * 
     * 
     * 
     * @param index
     * @param vWGS84BoundingBox
     */
    public void addWGS84BoundingBox(int index, nl.b3p.xml.ows.v100.WGS84BoundingBox vWGS84BoundingBox)
        throws java.lang.IndexOutOfBoundsException
    {
        _WGS84BoundingBoxList.add(index, vWGS84BoundingBox);
    } //-- void addWGS84BoundingBox(int, nl.b3p.xml.ows.v100.WGS84BoundingBox) 

    /**
     * Method clearKeywords
     * 
     */
    public void clearKeywords()
    {
        _keywordsList.clear();
    } //-- void clearKeywords() 

    /**
     * Method clearMetadataURL
     * 
     */
    public void clearMetadataURL()
    {
        _metadataURLList.clear();
    } //-- void clearMetadataURL() 

    /**
     * Method clearWGS84BoundingBox
     * 
     */
    public void clearWGS84BoundingBox()
    {
        _WGS84BoundingBoxList.clear();
    } //-- void clearWGS84BoundingBox() 

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
     * Method enumerateMetadataURL
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateMetadataURL()
    {
        return Collections.enumeration(_metadataURLList);
    } //-- java.util.Enumeration enumerateMetadataURL() 

    /**
     * Method enumerateWGS84BoundingBox
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateWGS84BoundingBox()
    {
        return Collections.enumeration(_WGS84BoundingBoxList);
    } //-- java.util.Enumeration enumerateWGS84BoundingBox() 

    /**
     * Returns the value of field 'abstract'. The field 'abstract'
     * has the following description: Brief narrative description
     * of this feature type, normally
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
     * Returns the value of field 'featureTypeTypeChoice'.
     * 
     * @return FeatureTypeTypeChoice
     * @return the value of field 'featureTypeTypeChoice'.
     */
    public nl.b3p.xml.wfs.v110.FeatureTypeTypeChoice getFeatureTypeTypeChoice()
    {
        return this._featureTypeTypeChoice;
    } //-- nl.b3p.xml.wfs.v110.FeatureTypeTypeChoice getFeatureTypeTypeChoice() 

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
     * Method getMetadataURL
     * 
     * 
     * 
     * @param index
     * @return MetadataURL
     */
    public nl.b3p.xml.wfs.v110.MetadataURL getMetadataURL(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _metadataURLList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v110.MetadataURL) _metadataURLList.get(index);
    } //-- nl.b3p.xml.wfs.v110.MetadataURL getMetadataURL(int) 

    /**
     * Method getMetadataURL
     * 
     * 
     * 
     * @return MetadataURL
     */
    public nl.b3p.xml.wfs.v110.MetadataURL[] getMetadataURL()
    {
        int size = _metadataURLList.size();
        nl.b3p.xml.wfs.v110.MetadataURL[] mArray = new nl.b3p.xml.wfs.v110.MetadataURL[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v110.MetadataURL) _metadataURLList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v110.MetadataURL[] getMetadataURL() 

    /**
     * Method getMetadataURLCount
     * 
     * 
     * 
     * @return int
     */
    public int getMetadataURLCount()
    {
        return _metadataURLList.size();
    } //-- int getMetadataURLCount() 

    /**
     * Returns the value of field 'name'. The field 'name' has the
     * following description: Name of this feature type, including
     * any namespace prefix
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
     * Returns the value of field 'operations_FeatureTypeType'.
     * 
     * @return Operations_FeatureTypeType
     * @return the value of field 'operations_FeatureTypeType'.
     */
    public nl.b3p.xml.wfs.v110.Operations_FeatureTypeType getOperations_FeatureTypeType()
    {
        return this._operations_FeatureTypeType;
    } //-- nl.b3p.xml.wfs.v110.Operations_FeatureTypeType getOperations_FeatureTypeType() 

    /**
     * Returns the value of field 'outputFormats_FeatureTypeType'.
     * 
     * @return OutputFormats_FeatureTypeType
     * @return the value of field 'outputFormats_FeatureTypeType'.
     */
    public nl.b3p.xml.wfs.v110.OutputFormats_FeatureTypeType getOutputFormats_FeatureTypeType()
    {
        return this._outputFormats_FeatureTypeType;
    } //-- nl.b3p.xml.wfs.v110.OutputFormats_FeatureTypeType getOutputFormats_FeatureTypeType() 

    /**
     * Returns the value of field 'title'. The field 'title' has
     * the following description: Title of this feature type,
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
     * Method getWGS84BoundingBox
     * 
     * 
     * 
     * @param index
     * @return WGS84BoundingBox
     */
    public nl.b3p.xml.ows.v100.WGS84BoundingBox getWGS84BoundingBox(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _WGS84BoundingBoxList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.WGS84BoundingBox) _WGS84BoundingBoxList.get(index);
    } //-- nl.b3p.xml.ows.v100.WGS84BoundingBox getWGS84BoundingBox(int) 

    /**
     * Method getWGS84BoundingBox
     * 
     * 
     * 
     * @return WGS84BoundingBox
     */
    public nl.b3p.xml.ows.v100.WGS84BoundingBox[] getWGS84BoundingBox()
    {
        int size = _WGS84BoundingBoxList.size();
        nl.b3p.xml.ows.v100.WGS84BoundingBox[] mArray = new nl.b3p.xml.ows.v100.WGS84BoundingBox[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.WGS84BoundingBox) _WGS84BoundingBoxList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.WGS84BoundingBox[] getWGS84BoundingBox() 

    /**
     * Method getWGS84BoundingBoxCount
     * 
     * 
     * 
     * @return int
     */
    public int getWGS84BoundingBoxCount()
    {
        return _WGS84BoundingBoxList.size();
    } //-- int getWGS84BoundingBoxCount() 

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
     * Method removeMetadataURL
     * 
     * 
     * 
     * @param vMetadataURL
     * @return boolean
     */
    public boolean removeMetadataURL(nl.b3p.xml.wfs.v110.MetadataURL vMetadataURL)
    {
        boolean removed = _metadataURLList.remove(vMetadataURL);
        return removed;
    } //-- boolean removeMetadataURL(nl.b3p.xml.wfs.v110.MetadataURL) 

    /**
     * Method removeWGS84BoundingBox
     * 
     * 
     * 
     * @param vWGS84BoundingBox
     * @return boolean
     */
    public boolean removeWGS84BoundingBox(nl.b3p.xml.ows.v100.WGS84BoundingBox vWGS84BoundingBox)
    {
        boolean removed = _WGS84BoundingBoxList.remove(vWGS84BoundingBox);
        return removed;
    } //-- boolean removeWGS84BoundingBox(nl.b3p.xml.ows.v100.WGS84BoundingBox) 

    /**
     * Sets the value of field 'abstract'. The field 'abstract' has
     * the following description: Brief narrative description of
     * this feature type, normally
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
     * Sets the value of field 'featureTypeTypeChoice'.
     * 
     * @param featureTypeTypeChoice the value of field
     * 'featureTypeTypeChoice'.
     */
    public void setFeatureTypeTypeChoice(nl.b3p.xml.wfs.v110.FeatureTypeTypeChoice featureTypeTypeChoice)
    {
        this._featureTypeTypeChoice = featureTypeTypeChoice;
    } //-- void setFeatureTypeTypeChoice(nl.b3p.xml.wfs.v110.FeatureTypeTypeChoice) 

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
     * Method setMetadataURL
     * 
     * 
     * 
     * @param index
     * @param vMetadataURL
     */
    public void setMetadataURL(int index, nl.b3p.xml.wfs.v110.MetadataURL vMetadataURL)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _metadataURLList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _metadataURLList.set(index, vMetadataURL);
    } //-- void setMetadataURL(int, nl.b3p.xml.wfs.v110.MetadataURL) 

    /**
     * Method setMetadataURL
     * 
     * 
     * 
     * @param metadataURLArray
     */
    public void setMetadataURL(nl.b3p.xml.wfs.v110.MetadataURL[] metadataURLArray)
    {
        //-- copy array
        _metadataURLList.clear();
        for (int i = 0; i < metadataURLArray.length; i++) {
            _metadataURLList.add(metadataURLArray[i]);
        }
    } //-- void setMetadataURL(nl.b3p.xml.wfs.v110.MetadataURL) 

    /**
     * Sets the value of field 'name'. The field 'name' has the
     * following description: Name of this feature type, including
     * any namespace prefix
     *  
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Sets the value of field 'operations_FeatureTypeType'.
     * 
     * @param operations_FeatureTypeType the value of field
     * 'operations_FeatureTypeType'.
     */
    public void setOperations_FeatureTypeType(nl.b3p.xml.wfs.v110.Operations_FeatureTypeType operations_FeatureTypeType)
    {
        this._operations_FeatureTypeType = operations_FeatureTypeType;
    } //-- void setOperations_FeatureTypeType(nl.b3p.xml.wfs.v110.Operations_FeatureTypeType) 

    /**
     * Sets the value of field 'outputFormats_FeatureTypeType'.
     * 
     * @param outputFormats_FeatureTypeType the value of field
     * 'outputFormats_FeatureTypeType'.
     */
    public void setOutputFormats_FeatureTypeType(nl.b3p.xml.wfs.v110.OutputFormats_FeatureTypeType outputFormats_FeatureTypeType)
    {
        this._outputFormats_FeatureTypeType = outputFormats_FeatureTypeType;
    } //-- void setOutputFormats_FeatureTypeType(nl.b3p.xml.wfs.v110.OutputFormats_FeatureTypeType) 

    /**
     * Sets the value of field 'title'. The field 'title' has the
     * following description: Title of this feature type, normally
     * used for display
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
     * Method setWGS84BoundingBox
     * 
     * 
     * 
     * @param index
     * @param vWGS84BoundingBox
     */
    public void setWGS84BoundingBox(int index, nl.b3p.xml.ows.v100.WGS84BoundingBox vWGS84BoundingBox)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _WGS84BoundingBoxList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _WGS84BoundingBoxList.set(index, vWGS84BoundingBox);
    } //-- void setWGS84BoundingBox(int, nl.b3p.xml.ows.v100.WGS84BoundingBox) 

    /**
     * Method setWGS84BoundingBox
     * 
     * 
     * 
     * @param WGS84BoundingBoxArray
     */
    public void setWGS84BoundingBox(nl.b3p.xml.ows.v100.WGS84BoundingBox[] WGS84BoundingBoxArray)
    {
        //-- copy array
        _WGS84BoundingBoxList.clear();
        for (int i = 0; i < WGS84BoundingBoxArray.length; i++) {
            _WGS84BoundingBoxList.add(WGS84BoundingBoxArray[i]);
        }
    } //-- void setWGS84BoundingBox(nl.b3p.xml.ows.v100.WGS84BoundingBox) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return FeatureTypeType
     */
    public static nl.b3p.xml.wfs.v110.FeatureTypeType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.FeatureTypeType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.FeatureTypeType.class, reader);
    } //-- nl.b3p.xml.wfs.v110.FeatureTypeType unmarshal(java.io.Reader) 

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
