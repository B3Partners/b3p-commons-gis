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
 * This type defines the LockFeature operation. The LockFeature
 *  element contains one or more Lock elements that define which
 *  features of a particular type should be locked. A lock
 *  identifier (lockId) is returned to the client application which
 *  can be used by subsequent operations to reference the locked
 *  features.
 *  
 * 
 * @version $Revision$ $Date$
 */
public class LockFeatureType extends nl.b3p.xml.wfs.v110.BaseRequestType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The expiry attribute is used to set the length
     *  of time (expressed in minutes) that features will
     *  remain locked as a result of a LockFeature
     *  request. After the expiry period elapses, the
     *  locked resources must be released. If the 
     *  expiry attribute is not set, then the default
     *  value of 5 minutes will be enforced.
     *  
     */
    private int _expiry = 5;

    /**
     * keeps track of state for field: _expiry
     */
    private boolean _has_expiry;

    /**
     * The lockAction attribute is used to indicate what
     *  a Web Feature Service should do when it encounters
     *  a feature instance that has already been locked by
     *  another client application.
     *  
     *  Valid values are ALL or SOME.
     *  
     *  ALL means that the Web Feature Service must acquire
     *  locks on all the requested feature instances. If it
     *  cannot acquire those locks then the request should
     *  fail. In this instance, all locks acquired by the
     *  operation should be released.
     *  
     *  SOME means that the Web Feature Service should lock
     *  as many of the requested features as it can.
     *  
     */
    private nl.b3p.xml.wfs.v110.types.AllSomeType _lockAction = nl.b3p.xml.wfs.v110.types.AllSomeType.valueOf("ALL");

    /**
     * The lock element is used to indicate which feature 
     *  instances of particular type are to be locked.
     *  
     */
    private java.util.ArrayList _lockList;


      //----------------/
     //- Constructors -/
    //----------------/

    public LockFeatureType() 
     {
        super();
        setLockAction(nl.b3p.xml.wfs.v110.types.AllSomeType.valueOf("ALL"));
        _lockList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v110.LockFeatureType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addLock
     * 
     * 
     * 
     * @param vLock
     */
    public void addLock(nl.b3p.xml.wfs.v110.Lock vLock)
        throws java.lang.IndexOutOfBoundsException
    {
        _lockList.add(vLock);
    } //-- void addLock(nl.b3p.xml.wfs.v110.Lock) 

    /**
     * Method addLock
     * 
     * 
     * 
     * @param index
     * @param vLock
     */
    public void addLock(int index, nl.b3p.xml.wfs.v110.Lock vLock)
        throws java.lang.IndexOutOfBoundsException
    {
        _lockList.add(index, vLock);
    } //-- void addLock(int, nl.b3p.xml.wfs.v110.Lock) 

    /**
     * Method clearLock
     * 
     */
    public void clearLock()
    {
        _lockList.clear();
    } //-- void clearLock() 

    /**
     * Method deleteExpiry
     * 
     */
    public void deleteExpiry()
    {
        this._has_expiry= false;
    } //-- void deleteExpiry() 

    /**
     * Method enumerateLock
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateLock()
    {
        return Collections.enumeration(_lockList);
    } //-- java.util.Enumeration enumerateLock() 

    /**
     * Returns the value of field 'expiry'. The field 'expiry' has
     * the following description: The expiry attribute is used to
     * set the length
     *  of time (expressed in minutes) that features will
     *  remain locked as a result of a LockFeature
     *  request. After the expiry period elapses, the
     *  locked resources must be released. If the 
     *  expiry attribute is not set, then the default
     *  value of 5 minutes will be enforced.
     *  
     * 
     * @return int
     * @return the value of field 'expiry'.
     */
    public int getExpiry()
    {
        return this._expiry;
    } //-- int getExpiry() 

    /**
     * Method getLock
     * 
     * 
     * 
     * @param index
     * @return Lock
     */
    public nl.b3p.xml.wfs.v110.Lock getLock(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _lockList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v110.Lock) _lockList.get(index);
    } //-- nl.b3p.xml.wfs.v110.Lock getLock(int) 

    /**
     * Method getLock
     * 
     * 
     * 
     * @return Lock
     */
    public nl.b3p.xml.wfs.v110.Lock[] getLock()
    {
        int size = _lockList.size();
        nl.b3p.xml.wfs.v110.Lock[] mArray = new nl.b3p.xml.wfs.v110.Lock[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v110.Lock) _lockList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v110.Lock[] getLock() 

    /**
     * Returns the value of field 'lockAction'. The field
     * 'lockAction' has the following description: The lockAction
     * attribute is used to indicate what
     *  a Web Feature Service should do when it encounters
     *  a feature instance that has already been locked by
     *  another client application.
     *  
     *  Valid values are ALL or SOME.
     *  
     *  ALL means that the Web Feature Service must acquire
     *  locks on all the requested feature instances. If it
     *  cannot acquire those locks then the request should
     *  fail. In this instance, all locks acquired by the
     *  operation should be released.
     *  
     *  SOME means that the Web Feature Service should lock
     *  as many of the requested features as it can.
     *  
     * 
     * @return AllSomeType
     * @return the value of field 'lockAction'.
     */
    public nl.b3p.xml.wfs.v110.types.AllSomeType getLockAction()
    {
        return this._lockAction;
    } //-- nl.b3p.xml.wfs.v110.types.AllSomeType getLockAction() 

    /**
     * Method getLockCount
     * 
     * 
     * 
     * @return int
     */
    public int getLockCount()
    {
        return _lockList.size();
    } //-- int getLockCount() 

    /**
     * Method hasExpiry
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasExpiry()
    {
        return this._has_expiry;
    } //-- boolean hasExpiry() 

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
     * Method removeLock
     * 
     * 
     * 
     * @param vLock
     * @return boolean
     */
    public boolean removeLock(nl.b3p.xml.wfs.v110.Lock vLock)
    {
        boolean removed = _lockList.remove(vLock);
        return removed;
    } //-- boolean removeLock(nl.b3p.xml.wfs.v110.Lock) 

    /**
     * Sets the value of field 'expiry'. The field 'expiry' has the
     * following description: The expiry attribute is used to set
     * the length
     *  of time (expressed in minutes) that features will
     *  remain locked as a result of a LockFeature
     *  request. After the expiry period elapses, the
     *  locked resources must be released. If the 
     *  expiry attribute is not set, then the default
     *  value of 5 minutes will be enforced.
     *  
     * 
     * @param expiry the value of field 'expiry'.
     */
    public void setExpiry(int expiry)
    {
        this._expiry = expiry;
        this._has_expiry = true;
    } //-- void setExpiry(int) 

    /**
     * Method setLock
     * 
     * 
     * 
     * @param index
     * @param vLock
     */
    public void setLock(int index, nl.b3p.xml.wfs.v110.Lock vLock)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _lockList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _lockList.set(index, vLock);
    } //-- void setLock(int, nl.b3p.xml.wfs.v110.Lock) 

    /**
     * Method setLock
     * 
     * 
     * 
     * @param lockArray
     */
    public void setLock(nl.b3p.xml.wfs.v110.Lock[] lockArray)
    {
        //-- copy array
        _lockList.clear();
        for (int i = 0; i < lockArray.length; i++) {
            _lockList.add(lockArray[i]);
        }
    } //-- void setLock(nl.b3p.xml.wfs.v110.Lock) 

    /**
     * Sets the value of field 'lockAction'. The field 'lockAction'
     * has the following description: The lockAction attribute is
     * used to indicate what
     *  a Web Feature Service should do when it encounters
     *  a feature instance that has already been locked by
     *  another client application.
     *  
     *  Valid values are ALL or SOME.
     *  
     *  ALL means that the Web Feature Service must acquire
     *  locks on all the requested feature instances. If it
     *  cannot acquire those locks then the request should
     *  fail. In this instance, all locks acquired by the
     *  operation should be released.
     *  
     *  SOME means that the Web Feature Service should lock
     *  as many of the requested features as it can.
     *  
     * 
     * @param lockAction the value of field 'lockAction'.
     */
    public void setLockAction(nl.b3p.xml.wfs.v110.types.AllSomeType lockAction)
    {
        this._lockAction = lockAction;
    } //-- void setLockAction(nl.b3p.xml.wfs.v110.types.AllSomeType) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return BaseRequestType
     */
    public static nl.b3p.xml.wfs.v110.BaseRequestType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.BaseRequestType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.LockFeatureType.class, reader);
    } //-- nl.b3p.xml.wfs.v110.BaseRequestType unmarshal(java.io.Reader) 

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
