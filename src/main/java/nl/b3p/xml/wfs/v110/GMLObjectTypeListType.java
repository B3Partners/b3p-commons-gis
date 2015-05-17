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
 * Class GMLObjectTypeListType.
 * 
 * @version $Revision$ $Date$
 */
public class GMLObjectTypeListType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Name of this GML object type, including any namespace prefix
     *  
     */
    private java.util.ArrayList _GMLObjectTypeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public GMLObjectTypeListType() 
     {
        super();
        _GMLObjectTypeList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v110.GMLObjectTypeListType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addGMLObjectType
     * 
     * 
     * 
     * @param vGMLObjectType
     */
    public void addGMLObjectType(nl.b3p.xml.wfs.v110.GMLObjectType vGMLObjectType)
        throws java.lang.IndexOutOfBoundsException
    {
        _GMLObjectTypeList.add(vGMLObjectType);
    } //-- void addGMLObjectType(nl.b3p.xml.wfs.v110.GMLObjectType) 

    /**
     * Method addGMLObjectType
     * 
     * 
     * 
     * @param index
     * @param vGMLObjectType
     */
    public void addGMLObjectType(int index, nl.b3p.xml.wfs.v110.GMLObjectType vGMLObjectType)
        throws java.lang.IndexOutOfBoundsException
    {
        _GMLObjectTypeList.add(index, vGMLObjectType);
    } //-- void addGMLObjectType(int, nl.b3p.xml.wfs.v110.GMLObjectType) 

    /**
     * Method clearGMLObjectType
     * 
     */
    public void clearGMLObjectType()
    {
        _GMLObjectTypeList.clear();
    } //-- void clearGMLObjectType() 

    /**
     * Method enumerateGMLObjectType
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateGMLObjectType()
    {
        return Collections.enumeration(_GMLObjectTypeList);
    } //-- java.util.Enumeration enumerateGMLObjectType() 

    /**
     * Method getGMLObjectType
     * 
     * 
     * 
     * @param index
     * @return GMLObjectType
     */
    public nl.b3p.xml.wfs.v110.GMLObjectType getGMLObjectType(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _GMLObjectTypeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v110.GMLObjectType) _GMLObjectTypeList.get(index);
    } //-- nl.b3p.xml.wfs.v110.GMLObjectType getGMLObjectType(int) 

    /**
     * Method getGMLObjectType
     * 
     * 
     * 
     * @return GMLObjectType
     */
    public nl.b3p.xml.wfs.v110.GMLObjectType[] getGMLObjectType()
    {
        int size = _GMLObjectTypeList.size();
        nl.b3p.xml.wfs.v110.GMLObjectType[] mArray = new nl.b3p.xml.wfs.v110.GMLObjectType[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v110.GMLObjectType) _GMLObjectTypeList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v110.GMLObjectType[] getGMLObjectType() 

    /**
     * Method getGMLObjectTypeCount
     * 
     * 
     * 
     * @return int
     */
    public int getGMLObjectTypeCount()
    {
        return _GMLObjectTypeList.size();
    } //-- int getGMLObjectTypeCount() 

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
     * Method removeGMLObjectType
     * 
     * 
     * 
     * @param vGMLObjectType
     * @return boolean
     */
    public boolean removeGMLObjectType(nl.b3p.xml.wfs.v110.GMLObjectType vGMLObjectType)
    {
        boolean removed = _GMLObjectTypeList.remove(vGMLObjectType);
        return removed;
    } //-- boolean removeGMLObjectType(nl.b3p.xml.wfs.v110.GMLObjectType) 

    /**
     * Method setGMLObjectType
     * 
     * 
     * 
     * @param index
     * @param vGMLObjectType
     */
    public void setGMLObjectType(int index, nl.b3p.xml.wfs.v110.GMLObjectType vGMLObjectType)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _GMLObjectTypeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _GMLObjectTypeList.set(index, vGMLObjectType);
    } //-- void setGMLObjectType(int, nl.b3p.xml.wfs.v110.GMLObjectType) 

    /**
     * Method setGMLObjectType
     * 
     * 
     * 
     * @param GMLObjectTypeArray
     */
    public void setGMLObjectType(nl.b3p.xml.wfs.v110.GMLObjectType[] GMLObjectTypeArray)
    {
        //-- copy array
        _GMLObjectTypeList.clear();
        for (int i = 0; i < GMLObjectTypeArray.length; i++) {
            _GMLObjectTypeList.add(GMLObjectTypeArray[i]);
        }
    } //-- void setGMLObjectType(nl.b3p.xml.wfs.v110.GMLObjectType) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return GMLObjectTypeListType
     */
    public static nl.b3p.xml.wfs.v110.GMLObjectTypeListType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.GMLObjectTypeListType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.GMLObjectTypeListType.class, reader);
    } //-- nl.b3p.xml.wfs.v110.GMLObjectTypeListType unmarshal(java.io.Reader) 

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
