/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100.capabilities;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class DescribeFeatureTypeType.
 * 
 * @version $Revision$ $Date$
 */
public class DescribeFeatureTypeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _schemaDescriptionLanguage
     */
    private nl.b3p.xml.wfs.v100.capabilities.SchemaDescriptionLanguage _schemaDescriptionLanguage;

    /**
     * Field _DCPType_DescribeFeatureTypeTypeList
     */
    private java.util.ArrayList _DCPType_DescribeFeatureTypeTypeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DescribeFeatureTypeType() 
     {
        super();
        _DCPType_DescribeFeatureTypeTypeList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v100.capabilities.DescribeFeatureTypeType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addDCPType_DescribeFeatureTypeType
     * 
     * 
     * 
     * @param vDCPType_DescribeFeatureTypeType
     */
    public void addDCPType_DescribeFeatureTypeType(nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType vDCPType_DescribeFeatureTypeType)
        throws java.lang.IndexOutOfBoundsException
    {
        _DCPType_DescribeFeatureTypeTypeList.add(vDCPType_DescribeFeatureTypeType);
    } //-- void addDCPType_DescribeFeatureTypeType(nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType) 

    /**
     * Method addDCPType_DescribeFeatureTypeType
     * 
     * 
     * 
     * @param index
     * @param vDCPType_DescribeFeatureTypeType
     */
    public void addDCPType_DescribeFeatureTypeType(int index, nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType vDCPType_DescribeFeatureTypeType)
        throws java.lang.IndexOutOfBoundsException
    {
        _DCPType_DescribeFeatureTypeTypeList.add(index, vDCPType_DescribeFeatureTypeType);
    } //-- void addDCPType_DescribeFeatureTypeType(int, nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType) 

    /**
     * Method clearDCPType_DescribeFeatureTypeType
     * 
     */
    public void clearDCPType_DescribeFeatureTypeType()
    {
        _DCPType_DescribeFeatureTypeTypeList.clear();
    } //-- void clearDCPType_DescribeFeatureTypeType() 

    /**
     * Method enumerateDCPType_DescribeFeatureTypeType
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateDCPType_DescribeFeatureTypeType()
    {
        return Collections.enumeration(_DCPType_DescribeFeatureTypeTypeList);
    } //-- java.util.Enumeration enumerateDCPType_DescribeFeatureTypeType() 

    /**
     * Method getDCPType_DescribeFeatureTypeType
     * 
     * 
     * 
     * @param index
     * @return DCPType_DescribeFeatureTypeType
     */
    public nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType getDCPType_DescribeFeatureTypeType(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _DCPType_DescribeFeatureTypeTypeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType) _DCPType_DescribeFeatureTypeTypeList.get(index);
    } //-- nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType getDCPType_DescribeFeatureTypeType(int) 

    /**
     * Method getDCPType_DescribeFeatureTypeType
     * 
     * 
     * 
     * @return DCPType_DescribeFeatureTypeType
     */
    public nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType[] getDCPType_DescribeFeatureTypeType()
    {
        int size = _DCPType_DescribeFeatureTypeTypeList.size();
        nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType[] mArray = new nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType) _DCPType_DescribeFeatureTypeTypeList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType[] getDCPType_DescribeFeatureTypeType() 

    /**
     * Method getDCPType_DescribeFeatureTypeTypeCount
     * 
     * 
     * 
     * @return int
     */
    public int getDCPType_DescribeFeatureTypeTypeCount()
    {
        return _DCPType_DescribeFeatureTypeTypeList.size();
    } //-- int getDCPType_DescribeFeatureTypeTypeCount() 

    /**
     * Returns the value of field 'schemaDescriptionLanguage'.
     * 
     * @return SchemaDescriptionLanguage
     * @return the value of field 'schemaDescriptionLanguage'.
     */
    public nl.b3p.xml.wfs.v100.capabilities.SchemaDescriptionLanguage getSchemaDescriptionLanguage()
    {
        return this._schemaDescriptionLanguage;
    } //-- nl.b3p.xml.wfs.v100.capabilities.SchemaDescriptionLanguage getSchemaDescriptionLanguage() 

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
     * Method removeDCPType_DescribeFeatureTypeType
     * 
     * 
     * 
     * @param vDCPType_DescribeFeatureTypeType
     * @return boolean
     */
    public boolean removeDCPType_DescribeFeatureTypeType(nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType vDCPType_DescribeFeatureTypeType)
    {
        boolean removed = _DCPType_DescribeFeatureTypeTypeList.remove(vDCPType_DescribeFeatureTypeType);
        return removed;
    } //-- boolean removeDCPType_DescribeFeatureTypeType(nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType) 

    /**
     * Method setDCPType_DescribeFeatureTypeType
     * 
     * 
     * 
     * @param index
     * @param vDCPType_DescribeFeatureTypeType
     */
    public void setDCPType_DescribeFeatureTypeType(int index, nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType vDCPType_DescribeFeatureTypeType)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _DCPType_DescribeFeatureTypeTypeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _DCPType_DescribeFeatureTypeTypeList.set(index, vDCPType_DescribeFeatureTypeType);
    } //-- void setDCPType_DescribeFeatureTypeType(int, nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType) 

    /**
     * Method setDCPType_DescribeFeatureTypeType
     * 
     * 
     * 
     * @param DCPType_DescribeFeatureTypeTypeArray
     */
    public void setDCPType_DescribeFeatureTypeType(nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType[] DCPType_DescribeFeatureTypeTypeArray)
    {
        //-- copy array
        _DCPType_DescribeFeatureTypeTypeList.clear();
        for (int i = 0; i < DCPType_DescribeFeatureTypeTypeArray.length; i++) {
            _DCPType_DescribeFeatureTypeTypeList.add(DCPType_DescribeFeatureTypeTypeArray[i]);
        }
    } //-- void setDCPType_DescribeFeatureTypeType(nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType) 

    /**
     * Sets the value of field 'schemaDescriptionLanguage'.
     * 
     * @param schemaDescriptionLanguage the value of field
     * 'schemaDescriptionLanguage'.
     */
    public void setSchemaDescriptionLanguage(nl.b3p.xml.wfs.v100.capabilities.SchemaDescriptionLanguage schemaDescriptionLanguage)
    {
        this._schemaDescriptionLanguage = schemaDescriptionLanguage;
    } //-- void setSchemaDescriptionLanguage(nl.b3p.xml.wfs.v100.capabilities.SchemaDescriptionLanguage) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return DescribeFeatureTypeType
     */
    public static nl.b3p.xml.wfs.v100.capabilities.DescribeFeatureTypeType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.capabilities.DescribeFeatureTypeType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.capabilities.DescribeFeatureTypeType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.capabilities.DescribeFeatureTypeType unmarshal(java.io.Reader) 

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
