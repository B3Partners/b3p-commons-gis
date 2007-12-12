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

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class FeatureTypeType.
 * 
 * @version $Revision$ $Date$
 */
public class FeatureTypeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _title
     */
    private java.lang.String _title;

    /**
     * Field _abstract
     */
    private java.lang.String _abstract;

    /**
     * Field _keywords
     */
    private java.lang.String _keywords;

    /**
     * Field _SRS
     */
    private java.lang.String _SRS;

    /**
     * Field _operations
     */
    private nl.b3p.xml.wfs.v100.Operations _operations;

    /**
     * Field _latLongBoundingBoxList
     */
    private java.util.ArrayList _latLongBoundingBoxList;

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
        _latLongBoundingBoxList = new java.util.ArrayList();
        _metadataURLList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v100.FeatureTypeType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addLatLongBoundingBox
     * 
     * 
     * 
     * @param vLatLongBoundingBox
     */
    public void addLatLongBoundingBox(nl.b3p.xml.wfs.v100.LatLongBoundingBox vLatLongBoundingBox)
        throws java.lang.IndexOutOfBoundsException
    {
        _latLongBoundingBoxList.add(vLatLongBoundingBox);
    } //-- void addLatLongBoundingBox(nl.b3p.xml.wfs.v100.LatLongBoundingBox) 

    /**
     * Method addLatLongBoundingBox
     * 
     * 
     * 
     * @param index
     * @param vLatLongBoundingBox
     */
    public void addLatLongBoundingBox(int index, nl.b3p.xml.wfs.v100.LatLongBoundingBox vLatLongBoundingBox)
        throws java.lang.IndexOutOfBoundsException
    {
        _latLongBoundingBoxList.add(index, vLatLongBoundingBox);
    } //-- void addLatLongBoundingBox(int, nl.b3p.xml.wfs.v100.LatLongBoundingBox) 

    /**
     * Method addMetadataURL
     * 
     * 
     * 
     * @param vMetadataURL
     */
    public void addMetadataURL(nl.b3p.xml.wfs.v100.MetadataURL vMetadataURL)
        throws java.lang.IndexOutOfBoundsException
    {
        _metadataURLList.add(vMetadataURL);
    } //-- void addMetadataURL(nl.b3p.xml.wfs.v100.MetadataURL) 

    /**
     * Method addMetadataURL
     * 
     * 
     * 
     * @param index
     * @param vMetadataURL
     */
    public void addMetadataURL(int index, nl.b3p.xml.wfs.v100.MetadataURL vMetadataURL)
        throws java.lang.IndexOutOfBoundsException
    {
        _metadataURLList.add(index, vMetadataURL);
    } //-- void addMetadataURL(int, nl.b3p.xml.wfs.v100.MetadataURL) 

    /**
     * Method clearLatLongBoundingBox
     * 
     */
    public void clearLatLongBoundingBox()
    {
        _latLongBoundingBoxList.clear();
    } //-- void clearLatLongBoundingBox() 

    /**
     * Method clearMetadataURL
     * 
     */
    public void clearMetadataURL()
    {
        _metadataURLList.clear();
    } //-- void clearMetadataURL() 

    /**
     * Method enumerateLatLongBoundingBox
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateLatLongBoundingBox()
    {
        return Collections.enumeration(_latLongBoundingBoxList);
    } //-- java.util.Enumeration enumerateLatLongBoundingBox() 

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
     * Returns the value of field 'abstract'.
     * 
     * @return String
     * @return the value of field 'abstract'.
     */
    public java.lang.String getAbstract()
    {
        return this._abstract;
    } //-- java.lang.String getAbstract() 

    /**
     * Returns the value of field 'keywords'.
     * 
     * @return String
     * @return the value of field 'keywords'.
     */
    public java.lang.String getKeywords()
    {
        return this._keywords;
    } //-- java.lang.String getKeywords() 

    /**
     * Method getLatLongBoundingBox
     * 
     * 
     * 
     * @param index
     * @return LatLongBoundingBox
     */
    public nl.b3p.xml.wfs.v100.LatLongBoundingBox getLatLongBoundingBox(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _latLongBoundingBoxList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v100.LatLongBoundingBox) _latLongBoundingBoxList.get(index);
    } //-- nl.b3p.xml.wfs.v100.LatLongBoundingBox getLatLongBoundingBox(int) 

    /**
     * Method getLatLongBoundingBox
     * 
     * 
     * 
     * @return LatLongBoundingBox
     */
    public nl.b3p.xml.wfs.v100.LatLongBoundingBox[] getLatLongBoundingBox()
    {
        int size = _latLongBoundingBoxList.size();
        nl.b3p.xml.wfs.v100.LatLongBoundingBox[] mArray = new nl.b3p.xml.wfs.v100.LatLongBoundingBox[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v100.LatLongBoundingBox) _latLongBoundingBoxList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v100.LatLongBoundingBox[] getLatLongBoundingBox() 

    /**
     * Method getLatLongBoundingBoxCount
     * 
     * 
     * 
     * @return int
     */
    public int getLatLongBoundingBoxCount()
    {
        return _latLongBoundingBoxList.size();
    } //-- int getLatLongBoundingBoxCount() 

    /**
     * Method getMetadataURL
     * 
     * 
     * 
     * @param index
     * @return MetadataURL
     */
    public nl.b3p.xml.wfs.v100.MetadataURL getMetadataURL(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _metadataURLList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v100.MetadataURL) _metadataURLList.get(index);
    } //-- nl.b3p.xml.wfs.v100.MetadataURL getMetadataURL(int) 

    /**
     * Method getMetadataURL
     * 
     * 
     * 
     * @return MetadataURL
     */
    public nl.b3p.xml.wfs.v100.MetadataURL[] getMetadataURL()
    {
        int size = _metadataURLList.size();
        nl.b3p.xml.wfs.v100.MetadataURL[] mArray = new nl.b3p.xml.wfs.v100.MetadataURL[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v100.MetadataURL) _metadataURLList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v100.MetadataURL[] getMetadataURL() 

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
     * Returns the value of field 'name'.
     * 
     * @return String
     * @return the value of field 'name'.
     */
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Returns the value of field 'operations'.
     * 
     * @return Operations
     * @return the value of field 'operations'.
     */
    public nl.b3p.xml.wfs.v100.Operations getOperations()
    {
        return this._operations;
    } //-- nl.b3p.xml.wfs.v100.Operations getOperations() 

    /**
     * Returns the value of field 'SRS'.
     * 
     * @return String
     * @return the value of field 'SRS'.
     */
    public java.lang.String getSRS()
    {
        return this._SRS;
    } //-- java.lang.String getSRS() 

    /**
     * Returns the value of field 'title'.
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
     * Method removeLatLongBoundingBox
     * 
     * 
     * 
     * @param vLatLongBoundingBox
     * @return boolean
     */
    public boolean removeLatLongBoundingBox(nl.b3p.xml.wfs.v100.LatLongBoundingBox vLatLongBoundingBox)
    {
        boolean removed = _latLongBoundingBoxList.remove(vLatLongBoundingBox);
        return removed;
    } //-- boolean removeLatLongBoundingBox(nl.b3p.xml.wfs.v100.LatLongBoundingBox) 

    /**
     * Method removeMetadataURL
     * 
     * 
     * 
     * @param vMetadataURL
     * @return boolean
     */
    public boolean removeMetadataURL(nl.b3p.xml.wfs.v100.MetadataURL vMetadataURL)
    {
        boolean removed = _metadataURLList.remove(vMetadataURL);
        return removed;
    } //-- boolean removeMetadataURL(nl.b3p.xml.wfs.v100.MetadataURL) 

    /**
     * Sets the value of field 'abstract'.
     * 
     * @param _abstract
     * @param abstract the value of field 'abstract'.
     */
    public void setAbstract(java.lang.String _abstract)
    {
        this._abstract = _abstract;
    } //-- void setAbstract(java.lang.String) 

    /**
     * Sets the value of field 'keywords'.
     * 
     * @param keywords the value of field 'keywords'.
     */
    public void setKeywords(java.lang.String keywords)
    {
        this._keywords = keywords;
    } //-- void setKeywords(java.lang.String) 

    /**
     * Method setLatLongBoundingBox
     * 
     * 
     * 
     * @param index
     * @param vLatLongBoundingBox
     */
    public void setLatLongBoundingBox(int index, nl.b3p.xml.wfs.v100.LatLongBoundingBox vLatLongBoundingBox)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _latLongBoundingBoxList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _latLongBoundingBoxList.set(index, vLatLongBoundingBox);
    } //-- void setLatLongBoundingBox(int, nl.b3p.xml.wfs.v100.LatLongBoundingBox) 

    /**
     * Method setLatLongBoundingBox
     * 
     * 
     * 
     * @param latLongBoundingBoxArray
     */
    public void setLatLongBoundingBox(nl.b3p.xml.wfs.v100.LatLongBoundingBox[] latLongBoundingBoxArray)
    {
        //-- copy array
        _latLongBoundingBoxList.clear();
        for (int i = 0; i < latLongBoundingBoxArray.length; i++) {
            _latLongBoundingBoxList.add(latLongBoundingBoxArray[i]);
        }
    } //-- void setLatLongBoundingBox(nl.b3p.xml.wfs.v100.LatLongBoundingBox) 

    /**
     * Method setMetadataURL
     * 
     * 
     * 
     * @param index
     * @param vMetadataURL
     */
    public void setMetadataURL(int index, nl.b3p.xml.wfs.v100.MetadataURL vMetadataURL)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _metadataURLList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _metadataURLList.set(index, vMetadataURL);
    } //-- void setMetadataURL(int, nl.b3p.xml.wfs.v100.MetadataURL) 

    /**
     * Method setMetadataURL
     * 
     * 
     * 
     * @param metadataURLArray
     */
    public void setMetadataURL(nl.b3p.xml.wfs.v100.MetadataURL[] metadataURLArray)
    {
        //-- copy array
        _metadataURLList.clear();
        for (int i = 0; i < metadataURLArray.length; i++) {
            _metadataURLList.add(metadataURLArray[i]);
        }
    } //-- void setMetadataURL(nl.b3p.xml.wfs.v100.MetadataURL) 

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Sets the value of field 'operations'.
     * 
     * @param operations the value of field 'operations'.
     */
    public void setOperations(nl.b3p.xml.wfs.v100.Operations operations)
    {
        this._operations = operations;
    } //-- void setOperations(nl.b3p.xml.wfs.v100.Operations) 

    /**
     * Sets the value of field 'SRS'.
     * 
     * @param SRS the value of field 'SRS'.
     */
    public void setSRS(java.lang.String SRS)
    {
        this._SRS = SRS;
    } //-- void setSRS(java.lang.String) 

    /**
     * Sets the value of field 'title'.
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
     * @return FeatureTypeType
     */
    public static nl.b3p.xml.wfs.v100.FeatureTypeType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.FeatureTypeType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.FeatureTypeType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.FeatureTypeType unmarshal(java.io.Reader) 

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
