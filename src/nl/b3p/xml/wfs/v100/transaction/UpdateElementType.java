/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100.transaction;

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
     * Field _handle
     */
    private java.lang.String _handle;

    /**
     * Field _typeName
     */
    private java.lang.String _typeName;

    /**
     * The Property element is used to specify the new
     *  value of a feature property inside an Update element.
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
     *  If no filter is specified, then the update operation 
     *  applies to all feature instances.
     *  
     */
    private nl.b3p.xml.ogc.v100.Filter _filter;


      //----------------/
     //- Constructors -/
    //----------------/

    public UpdateElementType() 
     {
        super();
        _propertyList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v100.transaction.UpdateElementType()


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
    public void addProperty(nl.b3p.xml.wfs.v100.transaction.Property vProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        _propertyList.add(vProperty);
    } //-- void addProperty(nl.b3p.xml.wfs.v100.transaction.Property) 

    /**
     * Method addProperty
     * 
     * 
     * 
     * @param index
     * @param vProperty
     */
    public void addProperty(int index, nl.b3p.xml.wfs.v100.transaction.Property vProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        _propertyList.add(index, vProperty);
    } //-- void addProperty(int, nl.b3p.xml.wfs.v100.transaction.Property) 

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
     *  If no filter is specified, then the update operation 
     *  applies to all feature instances.
     *  
     * 
     * @return Filter
     * @return the value of field 'filter'.
     */
    public nl.b3p.xml.ogc.v100.Filter getFilter()
    {
        return this._filter;
    } //-- nl.b3p.xml.ogc.v100.Filter getFilter() 

    /**
     * Returns the value of field 'handle'.
     * 
     * @return String
     * @return the value of field 'handle'.
     */
    public java.lang.String getHandle()
    {
        return this._handle;
    } //-- java.lang.String getHandle() 

    /**
     * Method getProperty
     * 
     * 
     * 
     * @param index
     * @return Property
     */
    public nl.b3p.xml.wfs.v100.transaction.Property getProperty(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _propertyList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v100.transaction.Property) _propertyList.get(index);
    } //-- nl.b3p.xml.wfs.v100.transaction.Property getProperty(int) 

    /**
     * Method getProperty
     * 
     * 
     * 
     * @return Property
     */
    public nl.b3p.xml.wfs.v100.transaction.Property[] getProperty()
    {
        int size = _propertyList.size();
        nl.b3p.xml.wfs.v100.transaction.Property[] mArray = new nl.b3p.xml.wfs.v100.transaction.Property[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v100.transaction.Property) _propertyList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v100.transaction.Property[] getProperty() 

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
     * Returns the value of field 'typeName'.
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
    public boolean removeProperty(nl.b3p.xml.wfs.v100.transaction.Property vProperty)
    {
        boolean removed = _propertyList.remove(vProperty);
        return removed;
    } //-- boolean removeProperty(nl.b3p.xml.wfs.v100.transaction.Property) 

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
     *  If no filter is specified, then the update operation 
     *  applies to all feature instances.
     *  
     * 
     * @param filter the value of field 'filter'.
     */
    public void setFilter(nl.b3p.xml.ogc.v100.Filter filter)
    {
        this._filter = filter;
    } //-- void setFilter(nl.b3p.xml.ogc.v100.Filter) 

    /**
     * Sets the value of field 'handle'.
     * 
     * @param handle the value of field 'handle'.
     */
    public void setHandle(java.lang.String handle)
    {
        this._handle = handle;
    } //-- void setHandle(java.lang.String) 

    /**
     * Method setProperty
     * 
     * 
     * 
     * @param index
     * @param vProperty
     */
    public void setProperty(int index, nl.b3p.xml.wfs.v100.transaction.Property vProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _propertyList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _propertyList.set(index, vProperty);
    } //-- void setProperty(int, nl.b3p.xml.wfs.v100.transaction.Property) 

    /**
     * Method setProperty
     * 
     * 
     * 
     * @param propertyArray
     */
    public void setProperty(nl.b3p.xml.wfs.v100.transaction.Property[] propertyArray)
    {
        //-- copy array
        _propertyList.clear();
        for (int i = 0; i < propertyArray.length; i++) {
            _propertyList.add(propertyArray[i]);
        }
    } //-- void setProperty(nl.b3p.xml.wfs.v100.transaction.Property) 

    /**
     * Sets the value of field 'typeName'.
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
    public static nl.b3p.xml.wfs.v100.transaction.UpdateElementType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.transaction.UpdateElementType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.transaction.UpdateElementType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.transaction.UpdateElementType unmarshal(java.io.Reader) 

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
