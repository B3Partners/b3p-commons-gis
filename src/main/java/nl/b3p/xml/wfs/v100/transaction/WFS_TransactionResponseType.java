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
 * The WFS_TransactionResponseType defines the format of
 *  the XML document that a Web Feature Service generates 
 *  in response to a Transaction request. The response 
 *  includes the completion status of the transaction 
 *  and the feature identifiers of any newly created
 *  feature instances.
 *  
 * 
 * @version $Revision$ $Date$
 */
public class WFS_TransactionResponseType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _version
     */
    private java.lang.String _version = "1.0.0";

    /**
     * The InsertResult element contains a list of ogc:FeatureId
     *  elements that identify any newly created feature instances.
     *  
     */
    private java.util.ArrayList _insertResultList;

    /**
     * The TransactionResult element contains a Status element
     *  indicating the completion status of a transaction. In
     *  the event that the transaction fails, additional element
     *  may be included to help locate which part of the
     * transaction
     *  failed and why.
     *  
     */
    private nl.b3p.xml.wfs.v100.transaction.TransactionResult _transactionResult;


      //----------------/
     //- Constructors -/
    //----------------/

    public WFS_TransactionResponseType() 
     {
        super();
        setVersion("1.0.0");
        _insertResultList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v100.transaction.WFS_TransactionResponseType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addInsertResult
     * 
     * 
     * 
     * @param vInsertResult
     */
    public void addInsertResult(nl.b3p.xml.wfs.v100.transaction.InsertResult vInsertResult)
        throws java.lang.IndexOutOfBoundsException
    {
        _insertResultList.add(vInsertResult);
    } //-- void addInsertResult(nl.b3p.xml.wfs.v100.transaction.InsertResult) 

    /**
     * Method addInsertResult
     * 
     * 
     * 
     * @param index
     * @param vInsertResult
     */
    public void addInsertResult(int index, nl.b3p.xml.wfs.v100.transaction.InsertResult vInsertResult)
        throws java.lang.IndexOutOfBoundsException
    {
        _insertResultList.add(index, vInsertResult);
    } //-- void addInsertResult(int, nl.b3p.xml.wfs.v100.transaction.InsertResult) 

    /**
     * Method clearInsertResult
     * 
     */
    public void clearInsertResult()
    {
        _insertResultList.clear();
    } //-- void clearInsertResult() 

    /**
     * Method enumerateInsertResult
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateInsertResult()
    {
        return Collections.enumeration(_insertResultList);
    } //-- java.util.Enumeration enumerateInsertResult() 

    /**
     * Method getInsertResult
     * 
     * 
     * 
     * @param index
     * @return InsertResult
     */
    public nl.b3p.xml.wfs.v100.transaction.InsertResult getInsertResult(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _insertResultList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v100.transaction.InsertResult) _insertResultList.get(index);
    } //-- nl.b3p.xml.wfs.v100.transaction.InsertResult getInsertResult(int) 

    /**
     * Method getInsertResult
     * 
     * 
     * 
     * @return InsertResult
     */
    public nl.b3p.xml.wfs.v100.transaction.InsertResult[] getInsertResult()
    {
        int size = _insertResultList.size();
        nl.b3p.xml.wfs.v100.transaction.InsertResult[] mArray = new nl.b3p.xml.wfs.v100.transaction.InsertResult[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v100.transaction.InsertResult) _insertResultList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v100.transaction.InsertResult[] getInsertResult() 

    /**
     * Method getInsertResultCount
     * 
     * 
     * 
     * @return int
     */
    public int getInsertResultCount()
    {
        return _insertResultList.size();
    } //-- int getInsertResultCount() 

    /**
     * Returns the value of field 'transactionResult'. The field
     * 'transactionResult' has the following description: The
     * TransactionResult element contains a Status element
     *  indicating the completion status of a transaction. In
     *  the event that the transaction fails, additional element
     *  may be included to help locate which part of the
     * transaction
     *  failed and why.
     *  
     * 
     * @return TransactionResult
     * @return the value of field 'transactionResult'.
     */
    public nl.b3p.xml.wfs.v100.transaction.TransactionResult getTransactionResult()
    {
        return this._transactionResult;
    } //-- nl.b3p.xml.wfs.v100.transaction.TransactionResult getTransactionResult() 

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
     * Method removeInsertResult
     * 
     * 
     * 
     * @param vInsertResult
     * @return boolean
     */
    public boolean removeInsertResult(nl.b3p.xml.wfs.v100.transaction.InsertResult vInsertResult)
    {
        boolean removed = _insertResultList.remove(vInsertResult);
        return removed;
    } //-- boolean removeInsertResult(nl.b3p.xml.wfs.v100.transaction.InsertResult) 

    /**
     * Method setInsertResult
     * 
     * 
     * 
     * @param index
     * @param vInsertResult
     */
    public void setInsertResult(int index, nl.b3p.xml.wfs.v100.transaction.InsertResult vInsertResult)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _insertResultList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _insertResultList.set(index, vInsertResult);
    } //-- void setInsertResult(int, nl.b3p.xml.wfs.v100.transaction.InsertResult) 

    /**
     * Method setInsertResult
     * 
     * 
     * 
     * @param insertResultArray
     */
    public void setInsertResult(nl.b3p.xml.wfs.v100.transaction.InsertResult[] insertResultArray)
    {
        //-- copy array
        _insertResultList.clear();
        for (int i = 0; i < insertResultArray.length; i++) {
            _insertResultList.add(insertResultArray[i]);
        }
    } //-- void setInsertResult(nl.b3p.xml.wfs.v100.transaction.InsertResult) 

    /**
     * Sets the value of field 'transactionResult'. The field
     * 'transactionResult' has the following description: The
     * TransactionResult element contains a Status element
     *  indicating the completion status of a transaction. In
     *  the event that the transaction fails, additional element
     *  may be included to help locate which part of the
     * transaction
     *  failed and why.
     *  
     * 
     * @param transactionResult the value of field
     * 'transactionResult'.
     */
    public void setTransactionResult(nl.b3p.xml.wfs.v100.transaction.TransactionResult transactionResult)
    {
        this._transactionResult = transactionResult;
    } //-- void setTransactionResult(nl.b3p.xml.wfs.v100.transaction.TransactionResult) 

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
     * @return WFS_TransactionResponseType
     */
    public static nl.b3p.xml.wfs.v100.transaction.WFS_TransactionResponseType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.transaction.WFS_TransactionResponseType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.transaction.WFS_TransactionResponseType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.transaction.WFS_TransactionResponseType unmarshal(java.io.Reader) 

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
