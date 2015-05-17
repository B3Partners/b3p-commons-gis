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
 * Class FeatureTypeTypeChoiceSequence.
 * 
 * @version $Revision$ $Date$
 */
public class FeatureTypeTypeChoiceSequence implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The DefaultSRS element indicated which spatial
     *  reference system shall be used by a WFS to
     *  express the state of a spatial feature if not
     *  otherwise explicitly identified within a query
     *  or transaction request. The SRS may be indicated
     *  using either the EPSG form (EPSG:posc code) or
     *  the URL form defined in subclause 4.3.2 of
     *  refernce[2].
     *  
     */
    private java.lang.String _defaultSRS;

    /**
     * The OtherSRS element is used to indicate other 
     *  supported SRSs within query and transaction 
     *  operations. A supported SRS means that the 
     *  WFS supports the transformation of spatial
     *  properties between the OtherSRS and the internal
     *  storage SRS. The effects of such transformations 
     *  must be considered when determining and declaring 
     *  the guaranteed data accuracy.
     *  
     */
    private java.util.ArrayList _otherSRSList;


      //----------------/
     //- Constructors -/
    //----------------/

    public FeatureTypeTypeChoiceSequence() 
     {
        super();
        _otherSRSList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v110.FeatureTypeTypeChoiceSequence()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addOtherSRS
     * 
     * 
     * 
     * @param vOtherSRS
     */
    public void addOtherSRS(java.lang.String vOtherSRS)
        throws java.lang.IndexOutOfBoundsException
    {
        _otherSRSList.add(vOtherSRS);
    } //-- void addOtherSRS(java.lang.String) 

    /**
     * Method addOtherSRS
     * 
     * 
     * 
     * @param index
     * @param vOtherSRS
     */
    public void addOtherSRS(int index, java.lang.String vOtherSRS)
        throws java.lang.IndexOutOfBoundsException
    {
        _otherSRSList.add(index, vOtherSRS);
    } //-- void addOtherSRS(int, java.lang.String) 

    /**
     * Method clearOtherSRS
     * 
     */
    public void clearOtherSRS()
    {
        _otherSRSList.clear();
    } //-- void clearOtherSRS() 

    /**
     * Method enumerateOtherSRS
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateOtherSRS()
    {
        return Collections.enumeration(_otherSRSList);
    } //-- java.util.Enumeration enumerateOtherSRS() 

    /**
     * Returns the value of field 'defaultSRS'. The field
     * 'defaultSRS' has the following description: The DefaultSRS
     * element indicated which spatial
     *  reference system shall be used by a WFS to
     *  express the state of a spatial feature if not
     *  otherwise explicitly identified within a query
     *  or transaction request. The SRS may be indicated
     *  using either the EPSG form (EPSG:posc code) or
     *  the URL form defined in subclause 4.3.2 of
     *  refernce[2].
     *  
     * 
     * @return String
     * @return the value of field 'defaultSRS'.
     */
    public java.lang.String getDefaultSRS()
    {
        return this._defaultSRS;
    } //-- java.lang.String getDefaultSRS() 

    /**
     * Method getOtherSRS
     * 
     * 
     * 
     * @param index
     * @return String
     */
    public java.lang.String getOtherSRS(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _otherSRSList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_otherSRSList.get(index);
    } //-- java.lang.String getOtherSRS(int) 

    /**
     * Method getOtherSRS
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String[] getOtherSRS()
    {
        int size = _otherSRSList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_otherSRSList.get(index);
        }
        return mArray;
    } //-- java.lang.String[] getOtherSRS() 

    /**
     * Method getOtherSRSCount
     * 
     * 
     * 
     * @return int
     */
    public int getOtherSRSCount()
    {
        return _otherSRSList.size();
    } //-- int getOtherSRSCount() 

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
     * Method removeOtherSRS
     * 
     * 
     * 
     * @param vOtherSRS
     * @return boolean
     */
    public boolean removeOtherSRS(java.lang.String vOtherSRS)
    {
        boolean removed = _otherSRSList.remove(vOtherSRS);
        return removed;
    } //-- boolean removeOtherSRS(java.lang.String) 

    /**
     * Sets the value of field 'defaultSRS'. The field 'defaultSRS'
     * has the following description: The DefaultSRS element
     * indicated which spatial
     *  reference system shall be used by a WFS to
     *  express the state of a spatial feature if not
     *  otherwise explicitly identified within a query
     *  or transaction request. The SRS may be indicated
     *  using either the EPSG form (EPSG:posc code) or
     *  the URL form defined in subclause 4.3.2 of
     *  refernce[2].
     *  
     * 
     * @param defaultSRS the value of field 'defaultSRS'.
     */
    public void setDefaultSRS(java.lang.String defaultSRS)
    {
        this._defaultSRS = defaultSRS;
    } //-- void setDefaultSRS(java.lang.String) 

    /**
     * Method setOtherSRS
     * 
     * 
     * 
     * @param index
     * @param vOtherSRS
     */
    public void setOtherSRS(int index, java.lang.String vOtherSRS)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _otherSRSList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _otherSRSList.set(index, vOtherSRS);
    } //-- void setOtherSRS(int, java.lang.String) 

    /**
     * Method setOtherSRS
     * 
     * 
     * 
     * @param otherSRSArray
     */
    public void setOtherSRS(java.lang.String[] otherSRSArray)
    {
        //-- copy array
        _otherSRSList.clear();
        for (int i = 0; i < otherSRSArray.length; i++) {
            _otherSRSList.add(otherSRSArray[i]);
        }
    } //-- void setOtherSRS(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return FeatureTypeTypeChoiceSequence
     */
    public static nl.b3p.xml.wfs.v110.FeatureTypeTypeChoiceSequence unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.FeatureTypeTypeChoiceSequence) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.FeatureTypeTypeChoiceSequence.class, reader);
    } //-- nl.b3p.xml.wfs.v110.FeatureTypeTypeChoiceSequence unmarshal(java.io.Reader) 

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
