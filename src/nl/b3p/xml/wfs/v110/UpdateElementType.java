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
 * Class UpdateElementType.
 * 
 * @version $Revision$ $Date$
 */
public class UpdateElementType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The handle attribute allows a client application
     *  to assign a client-generated request identifier
     *  to an Insert action. The handle is included to
     *  facilitate error reporting. If an Update action
     *  in a Transaction request fails, then a WFS may
     *  include the handle in an exception report to localize
     *  the error. If no handle is included of the offending
     *  Insert element then a WFS may employee other means of
     *  localizing the error (e.g. line number).
     *  
     */
    private java.lang.String _handle;

    /**
     * The value of the typeName attribute is the name 
     *  of the feature type to be updated. The name
     *  specified must be a valid type that belongs to
     *  the feature content as defined by the GML
     *  Application Schema.
     *  
     */
    private java.lang.String _typeName;

    /**
     * This inputFormat attribute is used to indicate 
     *  the format used to encode a feature instance in
     *  an Insert element. The default value of
     *  'text/xml; subtype=gml/3.1.1' is used to indicate
     *  that feature encoding is GML3. Another example
     *  might be 'text/xml; subtype=gml/2.1.2' indicating
     *  that the feature us encoded in GML2. A WFS must
     *  declare in the capabilities document, using a 
     *  Parameter element, which version of GML it supports.
     *  
     */
    private java.lang.String _inputFormat = "x-application/gml:3";

    /**
     * DO WE NEED THIS HERE?
     *  
     */
    private java.lang.String _srsName;

    /**
     * Changing or updating a feature instance means that
     *  the current value of one or more properties of
     *  the feature are replaced with new values. The Update
     *  element contains one or more Property elements. A
     *  Property element contains the name or a feature property
     *  who's value is to be changed and the replacement value
     *  for that property.
     *  
     */
    private java.util.ArrayList _propertyList;

    /**
     * The Filter element is used to constrain the scope
     *  of the update operation to those features identified
     *  by the filter. Feature instances can be specified
     *  explicitly and individually using the identifier of
     *  each feature instance OR a set of features to be
     *  operated on can be identified by specifying spatial
     *  and non-spatial constraints in the filter.
     *  If no filter is specified then update operation 
     *  applies to all feature instances.
     *  
     */
    private nl.b3p.xml.ogc.v110.Filter _filter;


      //----------------/
     //- Constructors -/
    //----------------/

    public UpdateElementType() 
     {
        super();
        setInputFormat("x-application/gml:3");
        _propertyList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v110.UpdateElementType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addProperty
     * 
     * 
     * 
     * @param vProperty
     */
    public void addProperty(nl.b3p.xml.wfs.v110.Property vProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        _propertyList.add(vProperty);
    } //-- void addProperty(nl.b3p.xml.wfs.v110.Property) 

    /**
     * Method addProperty
     * 
     * 
     * 
     * @param index
     * @param vProperty
     */
    public void addProperty(int index, nl.b3p.xml.wfs.v110.Property vProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        _propertyList.add(index, vProperty);
    } //-- void addProperty(int, nl.b3p.xml.wfs.v110.Property) 

    /**
     * Method clearProperty
     * 
     */
    public void clearProperty()
    {
        _propertyList.clear();
    } //-- void clearProperty() 

    /**
     * Method enumerateProperty
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateProperty()
    {
        return Collections.enumeration(_propertyList);
    } //-- java.util.Enumeration enumerateProperty() 

    /**
     * Returns the value of field 'filter'. The field 'filter' has
     * the following description: The Filter element is used to
     * constrain the scope
     *  of the update operation to those features identified
     *  by the filter. Feature instances can be specified
     *  explicitly and individually using the identifier of
     *  each feature instance OR a set of features to be
     *  operated on can be identified by specifying spatial
     *  and non-spatial constraints in the filter.
     *  If no filter is specified then update operation 
     *  applies to all feature instances.
     *  
     * 
     * @return Filter
     * @return the value of field 'filter'.
     */
    public nl.b3p.xml.ogc.v110.Filter getFilter()
    {
        return this._filter;
    } //-- nl.b3p.xml.ogc.v110.Filter getFilter() 

    /**
     * Returns the value of field 'handle'. The field 'handle' has
     * the following description: The handle attribute allows a
     * client application
     *  to assign a client-generated request identifier
     *  to an Insert action. The handle is included to
     *  facilitate error reporting. If an Update action
     *  in a Transaction request fails, then a WFS may
     *  include the handle in an exception report to localize
     *  the error. If no handle is included of the offending
     *  Insert element then a WFS may employee other means of
     *  localizing the error (e.g. line number).
     *  
     * 
     * @return String
     * @return the value of field 'handle'.
     */
    public java.lang.String getHandle()
    {
        return this._handle;
    } //-- java.lang.String getHandle() 

    /**
     * Returns the value of field 'inputFormat'. The field
     * 'inputFormat' has the following description: This
     * inputFormat attribute is used to indicate 
     *  the format used to encode a feature instance in
     *  an Insert element. The default value of
     *  'text/xml; subtype=gml/3.1.1' is used to indicate
     *  that feature encoding is GML3. Another example
     *  might be 'text/xml; subtype=gml/2.1.2' indicating
     *  that the feature us encoded in GML2. A WFS must
     *  declare in the capabilities document, using a 
     *  Parameter element, which version of GML it supports.
     *  
     * 
     * @return String
     * @return the value of field 'inputFormat'.
     */
    public java.lang.String getInputFormat()
    {
        return this._inputFormat;
    } //-- java.lang.String getInputFormat() 

    /**
     * Method getProperty
     * 
     * 
     * 
     * @param index
     * @return Property
     */
    public nl.b3p.xml.wfs.v110.Property getProperty(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _propertyList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v110.Property) _propertyList.get(index);
    } //-- nl.b3p.xml.wfs.v110.Property getProperty(int) 

    /**
     * Method getProperty
     * 
     * 
     * 
     * @return Property
     */
    public nl.b3p.xml.wfs.v110.Property[] getProperty()
    {
        int size = _propertyList.size();
        nl.b3p.xml.wfs.v110.Property[] mArray = new nl.b3p.xml.wfs.v110.Property[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v110.Property) _propertyList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v110.Property[] getProperty() 

    /**
     * Method getPropertyCount
     * 
     * 
     * 
     * @return int
     */
    public int getPropertyCount()
    {
        return _propertyList.size();
    } //-- int getPropertyCount() 

    /**
     * Returns the value of field 'srsName'. The field 'srsName'
     * has the following description: DO WE NEED THIS HERE?
     *  
     * 
     * @return String
     * @return the value of field 'srsName'.
     */
    public java.lang.String getSrsName()
    {
        return this._srsName;
    } //-- java.lang.String getSrsName() 

    /**
     * Returns the value of field 'typeName'. The field 'typeName'
     * has the following description: The value of the typeName
     * attribute is the name 
     *  of the feature type to be updated. The name
     *  specified must be a valid type that belongs to
     *  the feature content as defined by the GML
     *  Application Schema.
     *  
     * 
     * @return String
     * @return the value of field 'typeName'.
     */
    public java.lang.String getTypeName()
    {
        return this._typeName;
    } //-- java.lang.String getTypeName() 

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
     * Method removeProperty
     * 
     * 
     * 
     * @param vProperty
     * @return boolean
     */
    public boolean removeProperty(nl.b3p.xml.wfs.v110.Property vProperty)
    {
        boolean removed = _propertyList.remove(vProperty);
        return removed;
    } //-- boolean removeProperty(nl.b3p.xml.wfs.v110.Property) 

    /**
     * Sets the value of field 'filter'. The field 'filter' has the
     * following description: The Filter element is used to
     * constrain the scope
     *  of the update operation to those features identified
     *  by the filter. Feature instances can be specified
     *  explicitly and individually using the identifier of
     *  each feature instance OR a set of features to be
     *  operated on can be identified by specifying spatial
     *  and non-spatial constraints in the filter.
     *  If no filter is specified then update operation 
     *  applies to all feature instances.
     *  
     * 
     * @param filter the value of field 'filter'.
     */
    public void setFilter(nl.b3p.xml.ogc.v110.Filter filter)
    {
        this._filter = filter;
    } //-- void setFilter(nl.b3p.xml.ogc.v110.Filter) 

    /**
     * Sets the value of field 'handle'. The field 'handle' has the
     * following description: The handle attribute allows a client
     * application
     *  to assign a client-generated request identifier
     *  to an Insert action. The handle is included to
     *  facilitate error reporting. If an Update action
     *  in a Transaction request fails, then a WFS may
     *  include the handle in an exception report to localize
     *  the error. If no handle is included of the offending
     *  Insert element then a WFS may employee other means of
     *  localizing the error (e.g. line number).
     *  
     * 
     * @param handle the value of field 'handle'.
     */
    public void setHandle(java.lang.String handle)
    {
        this._handle = handle;
    } //-- void setHandle(java.lang.String) 

    /**
     * Sets the value of field 'inputFormat'. The field
     * 'inputFormat' has the following description: This
     * inputFormat attribute is used to indicate 
     *  the format used to encode a feature instance in
     *  an Insert element. The default value of
     *  'text/xml; subtype=gml/3.1.1' is used to indicate
     *  that feature encoding is GML3. Another example
     *  might be 'text/xml; subtype=gml/2.1.2' indicating
     *  that the feature us encoded in GML2. A WFS must
     *  declare in the capabilities document, using a 
     *  Parameter element, which version of GML it supports.
     *  
     * 
     * @param inputFormat the value of field 'inputFormat'.
     */
    public void setInputFormat(java.lang.String inputFormat)
    {
        this._inputFormat = inputFormat;
    } //-- void setInputFormat(java.lang.String) 

    /**
     * Method setProperty
     * 
     * 
     * 
     * @param index
     * @param vProperty
     */
    public void setProperty(int index, nl.b3p.xml.wfs.v110.Property vProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _propertyList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _propertyList.set(index, vProperty);
    } //-- void setProperty(int, nl.b3p.xml.wfs.v110.Property) 

    /**
     * Method setProperty
     * 
     * 
     * 
     * @param propertyArray
     */
    public void setProperty(nl.b3p.xml.wfs.v110.Property[] propertyArray)
    {
        //-- copy array
        _propertyList.clear();
        for (int i = 0; i < propertyArray.length; i++) {
            _propertyList.add(propertyArray[i]);
        }
    } //-- void setProperty(nl.b3p.xml.wfs.v110.Property) 

    /**
     * Sets the value of field 'srsName'. The field 'srsName' has
     * the following description: DO WE NEED THIS HERE?
     *  
     * 
     * @param srsName the value of field 'srsName'.
     */
    public void setSrsName(java.lang.String srsName)
    {
        this._srsName = srsName;
    } //-- void setSrsName(java.lang.String) 

    /**
     * Sets the value of field 'typeName'. The field 'typeName' has
     * the following description: The value of the typeName
     * attribute is the name 
     *  of the feature type to be updated. The name
     *  specified must be a valid type that belongs to
     *  the feature content as defined by the GML
     *  Application Schema.
     *  
     * 
     * @param typeName the value of field 'typeName'.
     */
    public void setTypeName(java.lang.String typeName)
    {
        this._typeName = typeName;
    } //-- void setTypeName(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return UpdateElementType
     */
    public static nl.b3p.xml.wfs.v110.UpdateElementType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.UpdateElementType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.UpdateElementType.class, reader);
    } //-- nl.b3p.xml.wfs.v110.UpdateElementType unmarshal(java.io.Reader) 

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
