/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100.capabilities;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * General metadata identifying and describing a set of data. This
 * type shall be extended if needed for each specific OWS to
 * include additional metadata for each type of dataset. If needed,
 * this type should first be restricted for each specific OWS to
 * change the multiplicity (or optionality) of some elements. 
 * 
 * @version $Revision$ $Date$
 */
public class IdentificationType extends nl.b3p.xml.ows.v100.capabilities.DescriptionType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Optional unique identifier or name of this dataset. 
     */
    private nl.b3p.xml.ows.v100.capabilities.Identifier _identifier;

    /**
     * Unordered list of zero or more bounding boxes whose union
     * describes the extent of this dataset. 
     */
    private java.util.ArrayList _boundingBoxList;

    /**
     * Unordered list of zero or more references to data formats
     * supported for server outputs. 
     */
    private java.util.ArrayList _outputFormatList;

    /**
     * Unordered list of zero or more available coordinate
     * reference systems. 
     */
    private java.util.ArrayList _availableCRSList;

    /**
     * Optional unordered list of additional metadata about this
     * data(set). A list of optional metadata elements for this
     * data identification could be specified in the Implementation
     * Specification for this service. 
     */
    private java.util.ArrayList _metadataList;


      //----------------/
     //- Constructors -/
    //----------------/

    public IdentificationType() 
     {
        super();
        _boundingBoxList = new java.util.ArrayList();
        _outputFormatList = new java.util.ArrayList();
        _availableCRSList = new java.util.ArrayList();
        _metadataList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.capabilities.IdentificationType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addAvailableCRS
     * 
     * 
     * 
     * @param vAvailableCRS
     */
    public void addAvailableCRS(java.lang.String vAvailableCRS)
        throws java.lang.IndexOutOfBoundsException
    {
        _availableCRSList.add(vAvailableCRS);
    } //-- void addAvailableCRS(java.lang.String) 

    /**
     * Method addAvailableCRS
     * 
     * 
     * 
     * @param index
     * @param vAvailableCRS
     */
    public void addAvailableCRS(int index, java.lang.String vAvailableCRS)
        throws java.lang.IndexOutOfBoundsException
    {
        _availableCRSList.add(index, vAvailableCRS);
    } //-- void addAvailableCRS(int, java.lang.String) 

    /**
     * Method addBoundingBox
     * 
     * 
     * 
     * @param vBoundingBox
     */
    public void addBoundingBox(nl.b3p.xml.ows.v100.capabilities.BoundingBox vBoundingBox)
        throws java.lang.IndexOutOfBoundsException
    {
        _boundingBoxList.add(vBoundingBox);
    } //-- void addBoundingBox(nl.b3p.xml.ows.v100.capabilities.BoundingBox) 

    /**
     * Method addBoundingBox
     * 
     * 
     * 
     * @param index
     * @param vBoundingBox
     */
    public void addBoundingBox(int index, nl.b3p.xml.ows.v100.capabilities.BoundingBox vBoundingBox)
        throws java.lang.IndexOutOfBoundsException
    {
        _boundingBoxList.add(index, vBoundingBox);
    } //-- void addBoundingBox(int, nl.b3p.xml.ows.v100.capabilities.BoundingBox) 

    /**
     * Method addMetadata
     * 
     * 
     * 
     * @param vMetadata
     */
    public void addMetadata(nl.b3p.xml.ows.v100.capabilities.Metadata vMetadata)
        throws java.lang.IndexOutOfBoundsException
    {
        _metadataList.add(vMetadata);
    } //-- void addMetadata(nl.b3p.xml.ows.v100.capabilities.Metadata) 

    /**
     * Method addMetadata
     * 
     * 
     * 
     * @param index
     * @param vMetadata
     */
    public void addMetadata(int index, nl.b3p.xml.ows.v100.capabilities.Metadata vMetadata)
        throws java.lang.IndexOutOfBoundsException
    {
        _metadataList.add(index, vMetadata);
    } //-- void addMetadata(int, nl.b3p.xml.ows.v100.capabilities.Metadata) 

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
     * Method clearAvailableCRS
     * 
     */
    public void clearAvailableCRS()
    {
        _availableCRSList.clear();
    } //-- void clearAvailableCRS() 

    /**
     * Method clearBoundingBox
     * 
     */
    public void clearBoundingBox()
    {
        _boundingBoxList.clear();
    } //-- void clearBoundingBox() 

    /**
     * Method clearMetadata
     * 
     */
    public void clearMetadata()
    {
        _metadataList.clear();
    } //-- void clearMetadata() 

    /**
     * Method clearOutputFormat
     * 
     */
    public void clearOutputFormat()
    {
        _outputFormatList.clear();
    } //-- void clearOutputFormat() 

    /**
     * Method enumerateAvailableCRS
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateAvailableCRS()
    {
        return Collections.enumeration(_availableCRSList);
    } //-- java.util.Enumeration enumerateAvailableCRS() 

    /**
     * Method enumerateBoundingBox
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateBoundingBox()
    {
        return Collections.enumeration(_boundingBoxList);
    } //-- java.util.Enumeration enumerateBoundingBox() 

    /**
     * Method enumerateMetadata
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateMetadata()
    {
        return Collections.enumeration(_metadataList);
    } //-- java.util.Enumeration enumerateMetadata() 

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
     * Method getAvailableCRS
     * 
     * 
     * 
     * @param index
     * @return String
     */
    public java.lang.String getAvailableCRS(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _availableCRSList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_availableCRSList.get(index);
    } //-- java.lang.String getAvailableCRS(int) 

    /**
     * Method getAvailableCRS
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String[] getAvailableCRS()
    {
        int size = _availableCRSList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_availableCRSList.get(index);
        }
        return mArray;
    } //-- java.lang.String[] getAvailableCRS() 

    /**
     * Method getAvailableCRSCount
     * 
     * 
     * 
     * @return int
     */
    public int getAvailableCRSCount()
    {
        return _availableCRSList.size();
    } //-- int getAvailableCRSCount() 

    /**
     * Method getBoundingBox
     * 
     * 
     * 
     * @param index
     * @return BoundingBox
     */
    public nl.b3p.xml.ows.v100.capabilities.BoundingBox getBoundingBox(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _boundingBoxList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.capabilities.BoundingBox) _boundingBoxList.get(index);
    } //-- nl.b3p.xml.ows.v100.capabilities.BoundingBox getBoundingBox(int) 

    /**
     * Method getBoundingBox
     * 
     * 
     * 
     * @return BoundingBox
     */
    public nl.b3p.xml.ows.v100.capabilities.BoundingBox[] getBoundingBox()
    {
        int size = _boundingBoxList.size();
        nl.b3p.xml.ows.v100.capabilities.BoundingBox[] mArray = new nl.b3p.xml.ows.v100.capabilities.BoundingBox[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.capabilities.BoundingBox) _boundingBoxList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.capabilities.BoundingBox[] getBoundingBox() 

    /**
     * Method getBoundingBoxCount
     * 
     * 
     * 
     * @return int
     */
    public int getBoundingBoxCount()
    {
        return _boundingBoxList.size();
    } //-- int getBoundingBoxCount() 

    /**
     * Returns the value of field 'identifier'. The field
     * 'identifier' has the following description: Optional unique
     * identifier or name of this dataset. 
     * 
     * @return Identifier
     * @return the value of field 'identifier'.
     */
    public nl.b3p.xml.ows.v100.capabilities.Identifier getIdentifier()
    {
        return this._identifier;
    } //-- nl.b3p.xml.ows.v100.capabilities.Identifier getIdentifier() 

    /**
     * Method getMetadata
     * 
     * 
     * 
     * @param index
     * @return Metadata
     */
    public nl.b3p.xml.ows.v100.capabilities.Metadata getMetadata(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _metadataList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.capabilities.Metadata) _metadataList.get(index);
    } //-- nl.b3p.xml.ows.v100.capabilities.Metadata getMetadata(int) 

    /**
     * Method getMetadata
     * 
     * 
     * 
     * @return Metadata
     */
    public nl.b3p.xml.ows.v100.capabilities.Metadata[] getMetadata()
    {
        int size = _metadataList.size();
        nl.b3p.xml.ows.v100.capabilities.Metadata[] mArray = new nl.b3p.xml.ows.v100.capabilities.Metadata[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.capabilities.Metadata) _metadataList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.capabilities.Metadata[] getMetadata() 

    /**
     * Method getMetadataCount
     * 
     * 
     * 
     * @return int
     */
    public int getMetadataCount()
    {
        return _metadataList.size();
    } //-- int getMetadataCount() 

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
     * Method removeAvailableCRS
     * 
     * 
     * 
     * @param vAvailableCRS
     * @return boolean
     */
    public boolean removeAvailableCRS(java.lang.String vAvailableCRS)
    {
        boolean removed = _availableCRSList.remove(vAvailableCRS);
        return removed;
    } //-- boolean removeAvailableCRS(java.lang.String) 

    /**
     * Method removeBoundingBox
     * 
     * 
     * 
     * @param vBoundingBox
     * @return boolean
     */
    public boolean removeBoundingBox(nl.b3p.xml.ows.v100.capabilities.BoundingBox vBoundingBox)
    {
        boolean removed = _boundingBoxList.remove(vBoundingBox);
        return removed;
    } //-- boolean removeBoundingBox(nl.b3p.xml.ows.v100.capabilities.BoundingBox) 

    /**
     * Method removeMetadata
     * 
     * 
     * 
     * @param vMetadata
     * @return boolean
     */
    public boolean removeMetadata(nl.b3p.xml.ows.v100.capabilities.Metadata vMetadata)
    {
        boolean removed = _metadataList.remove(vMetadata);
        return removed;
    } //-- boolean removeMetadata(nl.b3p.xml.ows.v100.capabilities.Metadata) 

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
     * Method setAvailableCRS
     * 
     * 
     * 
     * @param index
     * @param vAvailableCRS
     */
    public void setAvailableCRS(int index, java.lang.String vAvailableCRS)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _availableCRSList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _availableCRSList.set(index, vAvailableCRS);
    } //-- void setAvailableCRS(int, java.lang.String) 

    /**
     * Method setAvailableCRS
     * 
     * 
     * 
     * @param availableCRSArray
     */
    public void setAvailableCRS(java.lang.String[] availableCRSArray)
    {
        //-- copy array
        _availableCRSList.clear();
        for (int i = 0; i < availableCRSArray.length; i++) {
            _availableCRSList.add(availableCRSArray[i]);
        }
    } //-- void setAvailableCRS(java.lang.String) 

    /**
     * Method setBoundingBox
     * 
     * 
     * 
     * @param index
     * @param vBoundingBox
     */
    public void setBoundingBox(int index, nl.b3p.xml.ows.v100.capabilities.BoundingBox vBoundingBox)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _boundingBoxList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _boundingBoxList.set(index, vBoundingBox);
    } //-- void setBoundingBox(int, nl.b3p.xml.ows.v100.capabilities.BoundingBox) 

    /**
     * Method setBoundingBox
     * 
     * 
     * 
     * @param boundingBoxArray
     */
    public void setBoundingBox(nl.b3p.xml.ows.v100.capabilities.BoundingBox[] boundingBoxArray)
    {
        //-- copy array
        _boundingBoxList.clear();
        for (int i = 0; i < boundingBoxArray.length; i++) {
            _boundingBoxList.add(boundingBoxArray[i]);
        }
    } //-- void setBoundingBox(nl.b3p.xml.ows.v100.capabilities.BoundingBox) 

    /**
     * Sets the value of field 'identifier'. The field 'identifier'
     * has the following description: Optional unique identifier or
     * name of this dataset. 
     * 
     * @param identifier the value of field 'identifier'.
     */
    public void setIdentifier(nl.b3p.xml.ows.v100.capabilities.Identifier identifier)
    {
        this._identifier = identifier;
    } //-- void setIdentifier(nl.b3p.xml.ows.v100.capabilities.Identifier) 

    /**
     * Method setMetadata
     * 
     * 
     * 
     * @param index
     * @param vMetadata
     */
    public void setMetadata(int index, nl.b3p.xml.ows.v100.capabilities.Metadata vMetadata)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _metadataList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _metadataList.set(index, vMetadata);
    } //-- void setMetadata(int, nl.b3p.xml.ows.v100.capabilities.Metadata) 

    /**
     * Method setMetadata
     * 
     * 
     * 
     * @param metadataArray
     */
    public void setMetadata(nl.b3p.xml.ows.v100.capabilities.Metadata[] metadataArray)
    {
        //-- copy array
        _metadataList.clear();
        for (int i = 0; i < metadataArray.length; i++) {
            _metadataList.add(metadataArray[i]);
        }
    } //-- void setMetadata(nl.b3p.xml.ows.v100.capabilities.Metadata) 

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
     * @return DescriptionType
     */
    public static nl.b3p.xml.ows.v100.capabilities.DescriptionType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.capabilities.DescriptionType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.capabilities.IdentificationType.class, reader);
    } //-- nl.b3p.xml.ows.v100.capabilities.DescriptionType unmarshal(java.io.Reader) 

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
