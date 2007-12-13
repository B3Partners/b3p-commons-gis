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
 * Valid domain (or set of values) of one parameter or other
 * quantity used by this server. A non-parameter quantity may not
 * be explicitly represented in the server software. (Informative:
 * An example is the outputFormat parameter of a WFS. Each WFS
 * server should provide a Parameter element for the outputFormat
 * parameter that lists the supported output formats, such as GML2,
 * GML3, etc. as the allowed "Value" elements.) 
 * 
 * @version $Revision$ $Date$
 */
public class DomainType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Name or identifier of this parameter or other quantity. 
     */
    private java.lang.String _name;

    /**
     * Unordered list of all the valid values for this parameter or
     * other quantity. For those parameters that contain a list or
     * sequence of values, these values shall be for individual
     * values in the list. The allowed set of values and the
     * allowed server restrictions on that set of values shall be
     * specified in the Implementation Specification for this
     * service. 
     */
    private java.util.ArrayList _valueList;

    /**
     * Optional unordered list of additional metadata about this
     * parameter. A list of required and optional metadata elements
     * for this domain should be specified in the Implementation
     * Specification for this service. (Informative: This metadata
     * might specify the meanings of the valid values.) 
     */
    private java.util.ArrayList _metadataList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DomainType() 
     {
        super();
        _valueList = new java.util.ArrayList();
        _metadataList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.DomainType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addMetadata
     * 
     * 
     * 
     * @param vMetadata
     */
    public void addMetadata(nl.b3p.xml.ows.v100.Metadata vMetadata)
        throws java.lang.IndexOutOfBoundsException
    {
        _metadataList.add(vMetadata);
    } //-- void addMetadata(nl.b3p.xml.ows.v100.Metadata) 

    /**
     * Method addMetadata
     * 
     * 
     * 
     * @param index
     * @param vMetadata
     */
    public void addMetadata(int index, nl.b3p.xml.ows.v100.Metadata vMetadata)
        throws java.lang.IndexOutOfBoundsException
    {
        _metadataList.add(index, vMetadata);
    } //-- void addMetadata(int, nl.b3p.xml.ows.v100.Metadata) 

    /**
     * Method addValue
     * 
     * 
     * 
     * @param vValue
     */
    public void addValue(java.lang.String vValue)
        throws java.lang.IndexOutOfBoundsException
    {
        _valueList.add(vValue);
    } //-- void addValue(java.lang.String) 

    /**
     * Method addValue
     * 
     * 
     * 
     * @param index
     * @param vValue
     */
    public void addValue(int index, java.lang.String vValue)
        throws java.lang.IndexOutOfBoundsException
    {
        _valueList.add(index, vValue);
    } //-- void addValue(int, java.lang.String) 

    /**
     * Method clearMetadata
     * 
     */
    public void clearMetadata()
    {
        _metadataList.clear();
    } //-- void clearMetadata() 

    /**
     * Method clearValue
     * 
     */
    public void clearValue()
    {
        _valueList.clear();
    } //-- void clearValue() 

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
     * Method enumerateValue
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateValue()
    {
        return Collections.enumeration(_valueList);
    } //-- java.util.Enumeration enumerateValue() 

    /**
     * Method getMetadata
     * 
     * 
     * 
     * @param index
     * @return Metadata
     */
    public nl.b3p.xml.ows.v100.Metadata getMetadata(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _metadataList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.Metadata) _metadataList.get(index);
    } //-- nl.b3p.xml.ows.v100.Metadata getMetadata(int) 

    /**
     * Method getMetadata
     * 
     * 
     * 
     * @return Metadata
     */
    public nl.b3p.xml.ows.v100.Metadata[] getMetadata()
    {
        int size = _metadataList.size();
        nl.b3p.xml.ows.v100.Metadata[] mArray = new nl.b3p.xml.ows.v100.Metadata[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.Metadata) _metadataList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.Metadata[] getMetadata() 

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
     * Returns the value of field 'name'. The field 'name' has the
     * following description: Name or identifier of this parameter
     * or other quantity. 
     * 
     * @return String
     * @return the value of field 'name'.
     */
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Method getValue
     * 
     * 
     * 
     * @param index
     * @return String
     */
    public java.lang.String getValue(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _valueList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_valueList.get(index);
    } //-- java.lang.String getValue(int) 

    /**
     * Method getValue
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String[] getValue()
    {
        int size = _valueList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_valueList.get(index);
        }
        return mArray;
    } //-- java.lang.String[] getValue() 

    /**
     * Method getValueCount
     * 
     * 
     * 
     * @return int
     */
    public int getValueCount()
    {
        return _valueList.size();
    } //-- int getValueCount() 

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
     * Method removeMetadata
     * 
     * 
     * 
     * @param vMetadata
     * @return boolean
     */
    public boolean removeMetadata(nl.b3p.xml.ows.v100.Metadata vMetadata)
    {
        boolean removed = _metadataList.remove(vMetadata);
        return removed;
    } //-- boolean removeMetadata(nl.b3p.xml.ows.v100.Metadata) 

    /**
     * Method removeValue
     * 
     * 
     * 
     * @param vValue
     * @return boolean
     */
    public boolean removeValue(java.lang.String vValue)
    {
        boolean removed = _valueList.remove(vValue);
        return removed;
    } //-- boolean removeValue(java.lang.String) 

    /**
     * Method setMetadata
     * 
     * 
     * 
     * @param index
     * @param vMetadata
     */
    public void setMetadata(int index, nl.b3p.xml.ows.v100.Metadata vMetadata)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _metadataList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _metadataList.set(index, vMetadata);
    } //-- void setMetadata(int, nl.b3p.xml.ows.v100.Metadata) 

    /**
     * Method setMetadata
     * 
     * 
     * 
     * @param metadataArray
     */
    public void setMetadata(nl.b3p.xml.ows.v100.Metadata[] metadataArray)
    {
        //-- copy array
        _metadataList.clear();
        for (int i = 0; i < metadataArray.length; i++) {
            _metadataList.add(metadataArray[i]);
        }
    } //-- void setMetadata(nl.b3p.xml.ows.v100.Metadata) 

    /**
     * Sets the value of field 'name'. The field 'name' has the
     * following description: Name or identifier of this parameter
     * or other quantity. 
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Method setValue
     * 
     * 
     * 
     * @param index
     * @param vValue
     */
    public void setValue(int index, java.lang.String vValue)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _valueList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _valueList.set(index, vValue);
    } //-- void setValue(int, java.lang.String) 

    /**
     * Method setValue
     * 
     * 
     * 
     * @param valueArray
     */
    public void setValue(java.lang.String[] valueArray)
    {
        //-- copy array
        _valueList.clear();
        for (int i = 0; i < valueArray.length; i++) {
            _valueList.add(valueArray[i]);
        }
    } //-- void setValue(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return DomainType
     */
    public static nl.b3p.xml.ows.v100.DomainType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.DomainType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.DomainType.class, reader);
    } //-- nl.b3p.xml.ows.v100.DomainType unmarshal(java.io.Reader) 

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
