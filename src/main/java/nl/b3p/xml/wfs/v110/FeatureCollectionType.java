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

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * This type defines a container for the response to a 
 *  GetFeature or GetFeatureWithLock request. If the
 *  request is GetFeatureWithLock, the lockId attribute
 *  must be populated. The lockId attribute can otherwise
 *  be safely ignored.
 *  
 * 
 * @version $Revision$ $Date$
 */
public class FeatureCollectionType extends nl.b3p.xml.gml.v311.AbstractFeatureCollectionType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The value of the lockId attribute is an identifier
     *  that a Web Feature Service generates when responding
     *  to a GetFeatureWithLock request. A client application
     *  can use this value in subsequent operations (such as a
     *  Transaction request) to reference the set of locked
     *  features.
     *  
     */
    private java.lang.String _lockId;

    /**
     * The timeStamp attribute should contain the date and time
     *  that the response was generated.
     *  
     */
    private java.util.Date _timeStamp;

    /**
     * The numberOfFeatures attribute should contain a
     *  count of the number of features in the response.
     *  That is a count of all features elements dervied
     *  from gml:AbstractFeatureType.
     *  
     */
    private int _numberOfFeatures;

    /**
     * keeps track of state for field: _numberOfFeatures
     */
    private boolean _has_numberOfFeatures;


      //----------------/
     //- Constructors -/
    //----------------/

    public FeatureCollectionType() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v110.FeatureCollectionType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteNumberOfFeatures
     * 
     */
    public void deleteNumberOfFeatures()
    {
        this._has_numberOfFeatures= false;
    } //-- void deleteNumberOfFeatures() 

    /**
     * Returns the value of field 'lockId'. The field 'lockId' has
     * the following description: The value of the lockId attribute
     * is an identifier
     *  that a Web Feature Service generates when responding
     *  to a GetFeatureWithLock request. A client application
     *  can use this value in subsequent operations (such as a
     *  Transaction request) to reference the set of locked
     *  features.
     *  
     * 
     * @return String
     * @return the value of field 'lockId'.
     */
    public java.lang.String getLockId()
    {
        return this._lockId;
    } //-- java.lang.String getLockId() 

    /**
     * Returns the value of field 'numberOfFeatures'. The field
     * 'numberOfFeatures' has the following description: The
     * numberOfFeatures attribute should contain a
     *  count of the number of features in the response.
     *  That is a count of all features elements dervied
     *  from gml:AbstractFeatureType.
     *  
     * 
     * @return int
     * @return the value of field 'numberOfFeatures'.
     */
    public int getNumberOfFeatures()
    {
        return this._numberOfFeatures;
    } //-- int getNumberOfFeatures() 

    /**
     * Returns the value of field 'timeStamp'. The field
     * 'timeStamp' has the following description: The timeStamp
     * attribute should contain the date and time
     *  that the response was generated.
     *  
     * 
     * @return Date
     * @return the value of field 'timeStamp'.
     */
    public java.util.Date getTimeStamp()
    {
        return this._timeStamp;
    } //-- java.util.Date getTimeStamp() 

    /**
     * Method hasNumberOfFeatures
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasNumberOfFeatures()
    {
        return this._has_numberOfFeatures;
    } //-- boolean hasNumberOfFeatures() 

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
     * Sets the value of field 'lockId'. The field 'lockId' has the
     * following description: The value of the lockId attribute is
     * an identifier
     *  that a Web Feature Service generates when responding
     *  to a GetFeatureWithLock request. A client application
     *  can use this value in subsequent operations (such as a
     *  Transaction request) to reference the set of locked
     *  features.
     *  
     * 
     * @param lockId the value of field 'lockId'.
     */
    public void setLockId(java.lang.String lockId)
    {
        this._lockId = lockId;
    } //-- void setLockId(java.lang.String) 

    /**
     * Sets the value of field 'numberOfFeatures'. The field
     * 'numberOfFeatures' has the following description: The
     * numberOfFeatures attribute should contain a
     *  count of the number of features in the response.
     *  That is a count of all features elements dervied
     *  from gml:AbstractFeatureType.
     *  
     * 
     * @param numberOfFeatures the value of field 'numberOfFeatures'
     */
    public void setNumberOfFeatures(int numberOfFeatures)
    {
        this._numberOfFeatures = numberOfFeatures;
        this._has_numberOfFeatures = true;
    } //-- void setNumberOfFeatures(int) 

    /**
     * Sets the value of field 'timeStamp'. The field 'timeStamp'
     * has the following description: The timeStamp attribute
     * should contain the date and time
     *  that the response was generated.
     *  
     * 
     * @param timeStamp the value of field 'timeStamp'.
     */
    public void setTimeStamp(java.util.Date timeStamp)
    {
        this._timeStamp = timeStamp;
    } //-- void setTimeStamp(java.util.Date) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return FeatureCollectionType
     */
    public static nl.b3p.xml.wfs.v110.FeatureCollectionType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.FeatureCollectionType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.FeatureCollectionType.class, reader);
    } //-- nl.b3p.xml.wfs.v110.FeatureCollectionType unmarshal(java.io.Reader) 

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
