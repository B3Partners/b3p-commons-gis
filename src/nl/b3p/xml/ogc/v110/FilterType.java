/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v110;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class FilterType.
 * 
 * @version $Revision$ $Date$
 */
public class FilterType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _spatialOps
     */
    private nl.b3p.xml.ogc.v110.SpatialOps _spatialOps;

    /**
     * Field _comparisonOps
     */
    private nl.b3p.xml.ogc.v110.ComparisonOps _comparisonOps;

    /**
     * Field _logicOps
     */
    private nl.b3p.xml.ogc.v110.LogicOps _logicOps;

    /**
     * Field _IdList
     */
    private java.util.ArrayList _IdList;


      //----------------/
     //- Constructors -/
    //----------------/

    public FilterType() 
     {
        super();
        _IdList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ogc.v110.FilterType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addId
     * 
     * 
     * 
     * @param vId
     */
    public void addId(nl.b3p.xml.ogc.v110._Id vId)
        throws java.lang.IndexOutOfBoundsException
    {
        _IdList.add(vId);
    } //-- void addId(nl.b3p.xml.ogc.v110._Id) 

    /**
     * Method addId
     * 
     * 
     * 
     * @param index
     * @param vId
     */
    public void addId(int index, nl.b3p.xml.ogc.v110._Id vId)
        throws java.lang.IndexOutOfBoundsException
    {
        _IdList.add(index, vId);
    } //-- void addId(int, nl.b3p.xml.ogc.v110._Id) 

    /**
     * Method clearId
     * 
     */
    public void clearId()
    {
        _IdList.clear();
    } //-- void clearId() 

    /**
     * Method enumerateId
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateId()
    {
        return Collections.enumeration(_IdList);
    } //-- java.util.Enumeration enumerateId() 

    /**
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return Object
     * @return the value of field 'choiceValue'.
     */
    public java.lang.Object getChoiceValue()
    {
        return this._choiceValue;
    } //-- java.lang.Object getChoiceValue() 

    /**
     * Returns the value of field 'comparisonOps'.
     * 
     * @return ComparisonOps
     * @return the value of field 'comparisonOps'.
     */
    public nl.b3p.xml.ogc.v110.ComparisonOps getComparisonOps()
    {
        return this._comparisonOps;
    } //-- nl.b3p.xml.ogc.v110.ComparisonOps getComparisonOps() 

    /**
     * Method getId
     * 
     * 
     * 
     * @param index
     * @return _Id
     */
    public nl.b3p.xml.ogc.v110._Id getId(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _IdList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ogc.v110._Id) _IdList.get(index);
    } //-- nl.b3p.xml.ogc.v110._Id getId(int) 

    /**
     * Method getId
     * 
     * 
     * 
     * @return _Id
     */
    public nl.b3p.xml.ogc.v110._Id[] getId()
    {
        int size = _IdList.size();
        nl.b3p.xml.ogc.v110._Id[] mArray = new nl.b3p.xml.ogc.v110._Id[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ogc.v110._Id) _IdList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ogc.v110._Id[] getId() 

    /**
     * Method getIdCount
     * 
     * 
     * 
     * @return int
     */
    public int getIdCount()
    {
        return _IdList.size();
    } //-- int getIdCount() 

    /**
     * Returns the value of field 'logicOps'.
     * 
     * @return LogicOps
     * @return the value of field 'logicOps'.
     */
    public nl.b3p.xml.ogc.v110.LogicOps getLogicOps()
    {
        return this._logicOps;
    } //-- nl.b3p.xml.ogc.v110.LogicOps getLogicOps() 

    /**
     * Returns the value of field 'spatialOps'.
     * 
     * @return SpatialOps
     * @return the value of field 'spatialOps'.
     */
    public nl.b3p.xml.ogc.v110.SpatialOps getSpatialOps()
    {
        return this._spatialOps;
    } //-- nl.b3p.xml.ogc.v110.SpatialOps getSpatialOps() 

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
     * Method removeId
     * 
     * 
     * 
     * @param vId
     * @return boolean
     */
    public boolean removeId(nl.b3p.xml.ogc.v110._Id vId)
    {
        boolean removed = _IdList.remove(vId);
        return removed;
    } //-- boolean removeId(nl.b3p.xml.ogc.v110._Id) 

    /**
     * Sets the value of field 'comparisonOps'.
     * 
     * @param comparisonOps the value of field 'comparisonOps'.
     */
    public void setComparisonOps(nl.b3p.xml.ogc.v110.ComparisonOps comparisonOps)
    {
        this._comparisonOps = comparisonOps;
        this._choiceValue = comparisonOps;
    } //-- void setComparisonOps(nl.b3p.xml.ogc.v110.ComparisonOps) 

    /**
     * Method setId
     * 
     * 
     * 
     * @param index
     * @param vId
     */
    public void setId(int index, nl.b3p.xml.ogc.v110._Id vId)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _IdList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _IdList.set(index, vId);
    } //-- void setId(int, nl.b3p.xml.ogc.v110._Id) 

    /**
     * Method setId
     * 
     * 
     * 
     * @param idArray
     */
    public void setId(nl.b3p.xml.ogc.v110._Id[] idArray)
    {
        //-- copy array
        _IdList.clear();
        for (int i = 0; i < idArray.length; i++) {
            _IdList.add(idArray[i]);
        }
    } //-- void setId(nl.b3p.xml.ogc.v110._Id) 

    /**
     * Sets the value of field 'logicOps'.
     * 
     * @param logicOps the value of field 'logicOps'.
     */
    public void setLogicOps(nl.b3p.xml.ogc.v110.LogicOps logicOps)
    {
        this._logicOps = logicOps;
        this._choiceValue = logicOps;
    } //-- void setLogicOps(nl.b3p.xml.ogc.v110.LogicOps) 

    /**
     * Sets the value of field 'spatialOps'.
     * 
     * @param spatialOps the value of field 'spatialOps'.
     */
    public void setSpatialOps(nl.b3p.xml.ogc.v110.SpatialOps spatialOps)
    {
        this._spatialOps = spatialOps;
        this._choiceValue = spatialOps;
    } //-- void setSpatialOps(nl.b3p.xml.ogc.v110.SpatialOps) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return FilterType
     */
    public static nl.b3p.xml.ogc.v110.FilterType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v110.FilterType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.FilterType.class, reader);
    } //-- nl.b3p.xml.ogc.v110.FilterType unmarshal(java.io.Reader) 

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
