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
 * The TranactionType defines the Transaction operation. A
 *  Transaction element contains one or more Insert, Update
 *  Delete and Native elements that allow a client application
 *  to create, modify or remove feature instances from the 
 *  feature repository that a Web Feature Service controls.
 *  
 * 
 * @version $Revision$ $Date$
 */
public class TransactionType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _version
     */
    private java.lang.String _version = "1.0.0";

    /**
     * Field _service
     */
    private java.lang.String _service = "WFS";

    /**
     * Field _handle
     */
    private java.lang.String _handle;

    /**
     * The releaseAction attribute is used to control how a Web
     *  Feature service releases locks on feature instances after
     *  a Transaction request has been processed.
     * 
     *  Valid values are ALL or SOME.
     * 
     *  A value of ALL means that the Web Feature Service should
     *  release the locks of all feature instances locked with the
     *  specified lockId, regardless or whether or not the features
     *  were actually modified.
     * 
     *  A value of SOME means that the Web Feature Service will 
     *  only release the locks held on feature instances that 
     *  were actually operated upon by the transaction. The lockId
     *  that the client application obtained shall remain valid and
     *  the other, unmodified, feature instances shall remain
     * locked.
     *  If the expiry attribute was specified in the original
     * operation 
     *  that locked the feature instances, then the expiry counter
     *  will be reset to give the client application that same
     * amount
     *  of time to post subsequent transactions against the locked
     *  features.
     *  
     */
    private nl.b3p.xml.wfs.v100.transaction.types.AllSomeType _releaseAction;

    /**
     * In order for a client application to operate upon locked
     *  feature instances, the Transaction request must include
     *  the LockId element. The content of this element must be
     *  the lock identifier the client application obtained from
     *  a previous GetFeatureWithLock or LockFeature operation.
     * 
     *  If the correct lock identifier is specified the Web
     *  Feature Service knows that the client application may
     *  operate upon the locked feature instances.
     * 
     *  No LockId element needs to be specified to operate upon
     *  unlocked features.
     *  
     */
    private java.lang.String _lockId;

    /**
     * Field _transactionTypeChoiceList
     */
    private java.util.ArrayList _transactionTypeChoiceList;


      //----------------/
     //- Constructors -/
    //----------------/

    public TransactionType() 
     {
        super();
        setVersion("1.0.0");
        setService("WFS");
        _transactionTypeChoiceList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v100.transaction.TransactionType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addTransactionTypeChoice
     * 
     * 
     * 
     * @param vTransactionTypeChoice
     */
    public void addTransactionTypeChoice(nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoice vTransactionTypeChoice)
        throws java.lang.IndexOutOfBoundsException
    {
        _transactionTypeChoiceList.add(vTransactionTypeChoice);
    } //-- void addTransactionTypeChoice(nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoice) 

    /**
     * Method addTransactionTypeChoice
     * 
     * 
     * 
     * @param index
     * @param vTransactionTypeChoice
     */
    public void addTransactionTypeChoice(int index, nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoice vTransactionTypeChoice)
        throws java.lang.IndexOutOfBoundsException
    {
        _transactionTypeChoiceList.add(index, vTransactionTypeChoice);
    } //-- void addTransactionTypeChoice(int, nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoice) 

    /**
     * Method clearTransactionTypeChoice
     * 
     */
    public void clearTransactionTypeChoice()
    {
        _transactionTypeChoiceList.clear();
    } //-- void clearTransactionTypeChoice() 

    /**
     * Method enumerateTransactionTypeChoice
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateTransactionTypeChoice()
    {
        return Collections.enumeration(_transactionTypeChoiceList);
    } //-- java.util.Enumeration enumerateTransactionTypeChoice() 

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
     * Returns the value of field 'lockId'. The field 'lockId' has
     * the following description: In order for a client application
     * to operate upon locked
     *  feature instances, the Transaction request must include
     *  the LockId element. The content of this element must be
     *  the lock identifier the client application obtained from
     *  a previous GetFeatureWithLock or LockFeature operation.
     * 
     *  If the correct lock identifier is specified the Web
     *  Feature Service knows that the client application may
     *  operate upon the locked feature instances.
     * 
     *  No LockId element needs to be specified to operate upon
     *  unlocked features.
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
     * Returns the value of field 'releaseAction'. The field
     * 'releaseAction' has the following description: The
     * releaseAction attribute is used to control how a Web
     *  Feature service releases locks on feature instances after
     *  a Transaction request has been processed.
     * 
     *  Valid values are ALL or SOME.
     * 
     *  A value of ALL means that the Web Feature Service should
     *  release the locks of all feature instances locked with the
     *  specified lockId, regardless or whether or not the features
     *  were actually modified.
     * 
     *  A value of SOME means that the Web Feature Service will 
     *  only release the locks held on feature instances that 
     *  were actually operated upon by the transaction. The lockId
     *  that the client application obtained shall remain valid and
     *  the other, unmodified, feature instances shall remain
     * locked.
     *  If the expiry attribute was specified in the original
     * operation 
     *  that locked the feature instances, then the expiry counter
     *  will be reset to give the client application that same
     * amount
     *  of time to post subsequent transactions against the locked
     *  features.
     *  
     * 
     * @return AllSomeType
     * @return the value of field 'releaseAction'.
     */
    public nl.b3p.xml.wfs.v100.transaction.types.AllSomeType getReleaseAction()
    {
        return this._releaseAction;
    } //-- nl.b3p.xml.wfs.v100.transaction.types.AllSomeType getReleaseAction() 

    /**
     * Returns the value of field 'service'.
     * 
     * @return String
     * @return the value of field 'service'.
     */
    public java.lang.String getService()
    {
        return this._service;
    } //-- java.lang.String getService() 

    /**
     * Method getTransactionTypeChoice
     * 
     * 
     * 
     * @param index
     * @return TransactionTypeChoice
     */
    public nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoice getTransactionTypeChoice(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _transactionTypeChoiceList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoice) _transactionTypeChoiceList.get(index);
    } //-- nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoice getTransactionTypeChoice(int) 

    /**
     * Method getTransactionTypeChoice
     * 
     * 
     * 
     * @return TransactionTypeChoice
     */
    public nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoice[] getTransactionTypeChoice()
    {
        int size = _transactionTypeChoiceList.size();
        nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoice[] mArray = new nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoice[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoice) _transactionTypeChoiceList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoice[] getTransactionTypeChoice() 

    /**
     * Method getTransactionTypeChoiceCount
     * 
     * 
     * 
     * @return int
     */
    public int getTransactionTypeChoiceCount()
    {
        return _transactionTypeChoiceList.size();
    } //-- int getTransactionTypeChoiceCount() 

    /**
     * Returns the value of field 'version'.
     * 
     * @return String
     * @return the value of field 'version'.
     */
    public java.lang.String getVersion()
    {
        return this._version;
    } //-- java.lang.String getVersion() 

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
     * Method removeTransactionTypeChoice
     * 
     * 
     * 
     * @param vTransactionTypeChoice
     * @return boolean
     */
    public boolean removeTransactionTypeChoice(nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoice vTransactionTypeChoice)
    {
        boolean removed = _transactionTypeChoiceList.remove(vTransactionTypeChoice);
        return removed;
    } //-- boolean removeTransactionTypeChoice(nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoice) 

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
     * Sets the value of field 'lockId'. The field 'lockId' has the
     * following description: In order for a client application to
     * operate upon locked
     *  feature instances, the Transaction request must include
     *  the LockId element. The content of this element must be
     *  the lock identifier the client application obtained from
     *  a previous GetFeatureWithLock or LockFeature operation.
     * 
     *  If the correct lock identifier is specified the Web
     *  Feature Service knows that the client application may
     *  operate upon the locked feature instances.
     * 
     *  No LockId element needs to be specified to operate upon
     *  unlocked features.
     *  
     * 
     * @param lockId the value of field 'lockId'.
     */
    public void setLockId(java.lang.String lockId)
    {
        this._lockId = lockId;
    } //-- void setLockId(java.lang.String) 

    /**
     * Sets the value of field 'releaseAction'. The field
     * 'releaseAction' has the following description: The
     * releaseAction attribute is used to control how a Web
     *  Feature service releases locks on feature instances after
     *  a Transaction request has been processed.
     * 
     *  Valid values are ALL or SOME.
     * 
     *  A value of ALL means that the Web Feature Service should
     *  release the locks of all feature instances locked with the
     *  specified lockId, regardless or whether or not the features
     *  were actually modified.
     * 
     *  A value of SOME means that the Web Feature Service will 
     *  only release the locks held on feature instances that 
     *  were actually operated upon by the transaction. The lockId
     *  that the client application obtained shall remain valid and
     *  the other, unmodified, feature instances shall remain
     * locked.
     *  If the expiry attribute was specified in the original
     * operation 
     *  that locked the feature instances, then the expiry counter
     *  will be reset to give the client application that same
     * amount
     *  of time to post subsequent transactions against the locked
     *  features.
     *  
     * 
     * @param releaseAction the value of field 'releaseAction'.
     */
    public void setReleaseAction(nl.b3p.xml.wfs.v100.transaction.types.AllSomeType releaseAction)
    {
        this._releaseAction = releaseAction;
    } //-- void setReleaseAction(nl.b3p.xml.wfs.v100.transaction.types.AllSomeType) 

    /**
     * Sets the value of field 'service'.
     * 
     * @param service the value of field 'service'.
     */
    public void setService(java.lang.String service)
    {
        this._service = service;
    } //-- void setService(java.lang.String) 

    /**
     * Method setTransactionTypeChoice
     * 
     * 
     * 
     * @param index
     * @param vTransactionTypeChoice
     */
    public void setTransactionTypeChoice(int index, nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoice vTransactionTypeChoice)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _transactionTypeChoiceList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _transactionTypeChoiceList.set(index, vTransactionTypeChoice);
    } //-- void setTransactionTypeChoice(int, nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoice) 

    /**
     * Method setTransactionTypeChoice
     * 
     * 
     * 
     * @param transactionTypeChoiceArray
     */
    public void setTransactionTypeChoice(nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoice[] transactionTypeChoiceArray)
    {
        //-- copy array
        _transactionTypeChoiceList.clear();
        for (int i = 0; i < transactionTypeChoiceArray.length; i++) {
            _transactionTypeChoiceList.add(transactionTypeChoiceArray[i]);
        }
    } //-- void setTransactionTypeChoice(nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoice) 

    /**
     * Sets the value of field 'version'.
     * 
     * @param version the value of field 'version'.
     */
    public void setVersion(java.lang.String version)
    {
        this._version = version;
    } //-- void setVersion(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return TransactionType
     */
    public static nl.b3p.xml.wfs.v100.transaction.TransactionType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.transaction.TransactionType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.transaction.TransactionType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.transaction.TransactionType unmarshal(java.io.Reader) 

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
