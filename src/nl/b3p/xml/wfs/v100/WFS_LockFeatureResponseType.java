/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * The WFS_LockFeatureResponseType is used to define an
 *  element to contains the response to a LockFeature
 *  operation.
 *  
 * 
 * @version $Revision$ $Date$
 */
public class WFS_LockFeatureResponseType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The WFS_LockFeatureResponse includes a LockId element
     *  that contains a lock identifier. The lock identifier
     *  can be used by a client, in subsequent operations, to
     *  operate upon the locked feature instances.
     *  
     */
    private java.lang.String _lockId;

    /**
     * The LockFeature or GetFeatureWithLock operations
     *  identify and attempt to lock a set of feature 
     *  instances that satisfy the constraints specified 
     *  in the request. In the event that the lockAction
     *  attribute (on the LockFeature or GetFeatureWithLock
     *  elements) is set to SOME, a Web Feature Service will
     *  attempt to lock as many of the feature instances from
     *  the result set as possible.
     * 
     *  The FeaturesLocked element contains list of ogc:FeatureId
     *  elements enumerating the feature instances that a WFS
     *  actually managed to lock.
     *  
     */
    private nl.b3p.xml.wfs.v100.FeaturesLocked _featuresLocked;

    /**
     * In contrast to the FeaturesLocked element, the
     *  FeaturesNotLocked element contains a list of 
     *  ogc:Filter elements identifying feature instances
     *  that a WFS did not manage to lock because they were
     *  already locked by another process.
     *  
     */
    private nl.b3p.xml.wfs.v100.FeaturesNotLocked _featuresNotLocked;


      //----------------/
     //- Constructors -/
    //----------------/

    public WFS_LockFeatureResponseType() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v100.WFS_LockFeatureResponseType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'featuresLocked'. The field
     * 'featuresLocked' has the following description: The
     * LockFeature or GetFeatureWithLock operations
     *  identify and attempt to lock a set of feature 
     *  instances that satisfy the constraints specified 
     *  in the request. In the event that the lockAction
     *  attribute (on the LockFeature or GetFeatureWithLock
     *  elements) is set to SOME, a Web Feature Service will
     *  attempt to lock as many of the feature instances from
     *  the result set as possible.
     * 
     *  The FeaturesLocked element contains list of ogc:FeatureId
     *  elements enumerating the feature instances that a WFS
     *  actually managed to lock.
     *  
     * 
     * @return FeaturesLocked
     * @return the value of field 'featuresLocked'.
     */
    public nl.b3p.xml.wfs.v100.FeaturesLocked getFeaturesLocked()
    {
        return this._featuresLocked;
    } //-- nl.b3p.xml.wfs.v100.FeaturesLocked getFeaturesLocked() 

    /**
     * Returns the value of field 'featuresNotLocked'. The field
     * 'featuresNotLocked' has the following description: In
     * contrast to the FeaturesLocked element, the
     *  FeaturesNotLocked element contains a list of 
     *  ogc:Filter elements identifying feature instances
     *  that a WFS did not manage to lock because they were
     *  already locked by another process.
     *  
     * 
     * @return FeaturesNotLocked
     * @return the value of field 'featuresNotLocked'.
     */
    public nl.b3p.xml.wfs.v100.FeaturesNotLocked getFeaturesNotLocked()
    {
        return this._featuresNotLocked;
    } //-- nl.b3p.xml.wfs.v100.FeaturesNotLocked getFeaturesNotLocked() 

    /**
     * Returns the value of field 'lockId'. The field 'lockId' has
     * the following description: The WFS_LockFeatureResponse
     * includes a LockId element
     *  that contains a lock identifier. The lock identifier
     *  can be used by a client, in subsequent operations, to
     *  operate upon the locked feature instances.
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
     * Sets the value of field 'featuresLocked'. The field
     * 'featuresLocked' has the following description: The
     * LockFeature or GetFeatureWithLock operations
     *  identify and attempt to lock a set of feature 
     *  instances that satisfy the constraints specified 
     *  in the request. In the event that the lockAction
     *  attribute (on the LockFeature or GetFeatureWithLock
     *  elements) is set to SOME, a Web Feature Service will
     *  attempt to lock as many of the feature instances from
     *  the result set as possible.
     * 
     *  The FeaturesLocked element contains list of ogc:FeatureId
     *  elements enumerating the feature instances that a WFS
     *  actually managed to lock.
     *  
     * 
     * @param featuresLocked the value of field 'featuresLocked'.
     */
    public void setFeaturesLocked(nl.b3p.xml.wfs.v100.FeaturesLocked featuresLocked)
    {
        this._featuresLocked = featuresLocked;
    } //-- void setFeaturesLocked(nl.b3p.xml.wfs.v100.FeaturesLocked) 

    /**
     * Sets the value of field 'featuresNotLocked'. The field
     * 'featuresNotLocked' has the following description: In
     * contrast to the FeaturesLocked element, the
     *  FeaturesNotLocked element contains a list of 
     *  ogc:Filter elements identifying feature instances
     *  that a WFS did not manage to lock because they were
     *  already locked by another process.
     *  
     * 
     * @param featuresNotLocked the value of field
     * 'featuresNotLocked'.
     */
    public void setFeaturesNotLocked(nl.b3p.xml.wfs.v100.FeaturesNotLocked featuresNotLocked)
    {
        this._featuresNotLocked = featuresNotLocked;
    } //-- void setFeaturesNotLocked(nl.b3p.xml.wfs.v100.FeaturesNotLocked) 

    /**
     * Sets the value of field 'lockId'. The field 'lockId' has the
     * following description: The WFS_LockFeatureResponse includes
     * a LockId element
     *  that contains a lock identifier. The lock identifier
     *  can be used by a client, in subsequent operations, to
     *  operate upon the locked feature instances.
     *  
     * 
     * @param lockId the value of field 'lockId'.
     */
    public void setLockId(java.lang.String lockId)
    {
        this._lockId = lockId;
    } //-- void setLockId(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return WFS_LockFeatureResponseType
     */
    public static nl.b3p.xml.wfs.v100.WFS_LockFeatureResponseType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.WFS_LockFeatureResponseType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.WFS_LockFeatureResponseType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.WFS_LockFeatureResponseType unmarshal(java.io.Reader) 

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
