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
 * The response for a transaction request that was successfully
 *  completed. If the transaction failed for any reason, an
 *  exception report is returned instead.
 *  
 * 
 * @version $Revision$ $Date$
 */
public class TransactionResponseType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The version attribute contains the version of the request
     *  that generated this response. So a V1.1.0 transaction
     *  request generates a V1.1.0 transaction response.
     *  
     */
    private java.lang.String _version = "1.1.0";

    /**
     * The TransactionSummary element is used to summarize
     *  the number of feature instances affected by the 
     *  transaction.
     *  
     */
    private nl.b3p.xml.wfs.v110.TransactionSummary _transactionSummary;

    /**
     * For systems that do not support atomic transactions,
     *  the TransactionResults element may be used to report
     *  exception codes and messages for all actions of a
     *  transaction that failed to execute successfully.
     *  
     */
    private nl.b3p.xml.wfs.v110.TransactionResults _transactionResults;

    /**
     * A transaction is a collection of Insert,Update and Delete
     *  actions. The Update and Delete actions modify features
     *  that already exist. The Insert action, however, creates
     *  new features. The InsertResults element is used to
     *  report the identifiers of the newly created features.
     *  
     */
    private nl.b3p.xml.wfs.v110.InsertResults _insertResults;


      //----------------/
     //- Constructors -/
    //----------------/

    public TransactionResponseType() 
     {
        super();
        setVersion("1.1.0");
    } //-- nl.b3p.xml.wfs.v110.TransactionResponseType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'insertResults'. The field
     * 'insertResults' has the following description: A transaction
     * is a collection of Insert,Update and Delete
     *  actions. The Update and Delete actions modify features
     *  that already exist. The Insert action, however, creates
     *  new features. The InsertResults element is used to
     *  report the identifiers of the newly created features.
     *  
     * 
     * @return InsertResults
     * @return the value of field 'insertResults'.
     */
    public nl.b3p.xml.wfs.v110.InsertResults getInsertResults()
    {
        return this._insertResults;
    } //-- nl.b3p.xml.wfs.v110.InsertResults getInsertResults() 

    /**
     * Returns the value of field 'transactionResults'. The field
     * 'transactionResults' has the following description: For
     * systems that do not support atomic transactions,
     *  the TransactionResults element may be used to report
     *  exception codes and messages for all actions of a
     *  transaction that failed to execute successfully.
     *  
     * 
     * @return TransactionResults
     * @return the value of field 'transactionResults'.
     */
    public nl.b3p.xml.wfs.v110.TransactionResults getTransactionResults()
    {
        return this._transactionResults;
    } //-- nl.b3p.xml.wfs.v110.TransactionResults getTransactionResults() 

    /**
     * Returns the value of field 'transactionSummary'. The field
     * 'transactionSummary' has the following description: The
     * TransactionSummary element is used to summarize
     *  the number of feature instances affected by the 
     *  transaction.
     *  
     * 
     * @return TransactionSummary
     * @return the value of field 'transactionSummary'.
     */
    public nl.b3p.xml.wfs.v110.TransactionSummary getTransactionSummary()
    {
        return this._transactionSummary;
    } //-- nl.b3p.xml.wfs.v110.TransactionSummary getTransactionSummary() 

    /**
     * Returns the value of field 'version'. The field 'version'
     * has the following description: The version attribute
     * contains the version of the request
     *  that generated this response. So a V1.1.0 transaction
     *  request generates a V1.1.0 transaction response.
     *  
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
     * Sets the value of field 'insertResults'. The field
     * 'insertResults' has the following description: A transaction
     * is a collection of Insert,Update and Delete
     *  actions. The Update and Delete actions modify features
     *  that already exist. The Insert action, however, creates
     *  new features. The InsertResults element is used to
     *  report the identifiers of the newly created features.
     *  
     * 
     * @param insertResults the value of field 'insertResults'.
     */
    public void setInsertResults(nl.b3p.xml.wfs.v110.InsertResults insertResults)
    {
        this._insertResults = insertResults;
    } //-- void setInsertResults(nl.b3p.xml.wfs.v110.InsertResults) 

    /**
     * Sets the value of field 'transactionResults'. The field
     * 'transactionResults' has the following description: For
     * systems that do not support atomic transactions,
     *  the TransactionResults element may be used to report
     *  exception codes and messages for all actions of a
     *  transaction that failed to execute successfully.
     *  
     * 
     * @param transactionResults the value of field
     * 'transactionResults'.
     */
    public void setTransactionResults(nl.b3p.xml.wfs.v110.TransactionResults transactionResults)
    {
        this._transactionResults = transactionResults;
    } //-- void setTransactionResults(nl.b3p.xml.wfs.v110.TransactionResults) 

    /**
     * Sets the value of field 'transactionSummary'. The field
     * 'transactionSummary' has the following description: The
     * TransactionSummary element is used to summarize
     *  the number of feature instances affected by the 
     *  transaction.
     *  
     * 
     * @param transactionSummary the value of field
     * 'transactionSummary'.
     */
    public void setTransactionSummary(nl.b3p.xml.wfs.v110.TransactionSummary transactionSummary)
    {
        this._transactionSummary = transactionSummary;
    } //-- void setTransactionSummary(nl.b3p.xml.wfs.v110.TransactionSummary) 

    /**
     * Sets the value of field 'version'. The field 'version' has
     * the following description: The version attribute contains
     * the version of the request
     *  that generated this response. So a V1.1.0 transaction
     *  request generates a V1.1.0 transaction response.
     *  
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
     * @return TransactionResponseType
     */
    public static nl.b3p.xml.wfs.v110.TransactionResponseType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.TransactionResponseType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.TransactionResponseType.class, reader);
    } //-- nl.b3p.xml.wfs.v110.TransactionResponseType unmarshal(java.io.Reader) 

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
