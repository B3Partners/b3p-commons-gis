/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v110.sort;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class SortByType.
 * 
 * @version $Revision$ $Date$
 */
public class SortByType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _sortPropertyList
     */
    private java.util.ArrayList _sortPropertyList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SortByType() 
     {
        super();
        _sortPropertyList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ogc.v110.sort.SortByType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addSortProperty
     * 
     * 
     * 
     * @param vSortProperty
     */
    public void addSortProperty(nl.b3p.xml.ogc.v110.sort.SortProperty vSortProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        _sortPropertyList.add(vSortProperty);
    } //-- void addSortProperty(nl.b3p.xml.ogc.v110.sort.SortProperty) 

    /**
     * Method addSortProperty
     * 
     * 
     * 
     * @param index
     * @param vSortProperty
     */
    public void addSortProperty(int index, nl.b3p.xml.ogc.v110.sort.SortProperty vSortProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        _sortPropertyList.add(index, vSortProperty);
    } //-- void addSortProperty(int, nl.b3p.xml.ogc.v110.sort.SortProperty) 

    /**
     * Method clearSortProperty
     * 
     */
    public void clearSortProperty()
    {
        _sortPropertyList.clear();
    } //-- void clearSortProperty() 

    /**
     * Method enumerateSortProperty
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateSortProperty()
    {
        return Collections.enumeration(_sortPropertyList);
    } //-- java.util.Enumeration enumerateSortProperty() 

    /**
     * Method getSortProperty
     * 
     * 
     * 
     * @param index
     * @return SortProperty
     */
    public nl.b3p.xml.ogc.v110.sort.SortProperty getSortProperty(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _sortPropertyList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ogc.v110.sort.SortProperty) _sortPropertyList.get(index);
    } //-- nl.b3p.xml.ogc.v110.sort.SortProperty getSortProperty(int) 

    /**
     * Method getSortProperty
     * 
     * 
     * 
     * @return SortProperty
     */
    public nl.b3p.xml.ogc.v110.sort.SortProperty[] getSortProperty()
    {
        int size = _sortPropertyList.size();
        nl.b3p.xml.ogc.v110.sort.SortProperty[] mArray = new nl.b3p.xml.ogc.v110.sort.SortProperty[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ogc.v110.sort.SortProperty) _sortPropertyList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ogc.v110.sort.SortProperty[] getSortProperty() 

    /**
     * Method getSortPropertyCount
     * 
     * 
     * 
     * @return int
     */
    public int getSortPropertyCount()
    {
        return _sortPropertyList.size();
    } //-- int getSortPropertyCount() 

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
     * Method removeSortProperty
     * 
     * 
     * 
     * @param vSortProperty
     * @return boolean
     */
    public boolean removeSortProperty(nl.b3p.xml.ogc.v110.sort.SortProperty vSortProperty)
    {
        boolean removed = _sortPropertyList.remove(vSortProperty);
        return removed;
    } //-- boolean removeSortProperty(nl.b3p.xml.ogc.v110.sort.SortProperty) 

    /**
     * Method setSortProperty
     * 
     * 
     * 
     * @param index
     * @param vSortProperty
     */
    public void setSortProperty(int index, nl.b3p.xml.ogc.v110.sort.SortProperty vSortProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _sortPropertyList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _sortPropertyList.set(index, vSortProperty);
    } //-- void setSortProperty(int, nl.b3p.xml.ogc.v110.sort.SortProperty) 

    /**
     * Method setSortProperty
     * 
     * 
     * 
     * @param sortPropertyArray
     */
    public void setSortProperty(nl.b3p.xml.ogc.v110.sort.SortProperty[] sortPropertyArray)
    {
        //-- copy array
        _sortPropertyList.clear();
        for (int i = 0; i < sortPropertyArray.length; i++) {
            _sortPropertyList.add(sortPropertyArray[i]);
        }
    } //-- void setSortProperty(nl.b3p.xml.ogc.v110.sort.SortProperty) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return SortByType
     */
    public static nl.b3p.xml.ogc.v110.sort.SortByType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v110.sort.SortByType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.sort.SortByType.class, reader);
    } //-- nl.b3p.xml.ogc.v110.sort.SortByType unmarshal(java.io.Reader) 

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
