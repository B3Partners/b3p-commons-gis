/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100;

/**
 * Class RequestTypeItem.
 * 
 * @version $Revision$ $Date$
 */
public class RequestTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _getCapabilities
     */
    private nl.b3p.xml.wfs.v100.GetCapabilities _getCapabilities;

    /**
     * Field _describeFeatureType
     */
    private nl.b3p.xml.wfs.v100.DescribeFeatureType _describeFeatureType;

    /**
     * Field _transaction
     */
    private nl.b3p.xml.wfs.v100.Transaction _transaction;

    /**
     * Field _getFeature
     */
    private nl.b3p.xml.wfs.v100.GetFeature _getFeature;

    /**
     * Field _getFeatureWithLock
     */
    private nl.b3p.xml.wfs.v100.GetFeatureWithLock _getFeatureWithLock;

    /**
     * Field _lockFeature
     */
    private nl.b3p.xml.wfs.v100.LockFeature _lockFeature;


      //----------------/
     //- Constructors -/
    //----------------/

    public RequestTypeItem() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v100.RequestTypeItem()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'describeFeatureType'.
     * 
     * @return DescribeFeatureType
     * @return the value of field 'describeFeatureType'.
     */
    public nl.b3p.xml.wfs.v100.DescribeFeatureType getDescribeFeatureType()
    {
        return this._describeFeatureType;
    } //-- nl.b3p.xml.wfs.v100.DescribeFeatureType getDescribeFeatureType() 

    /**
     * Returns the value of field 'getCapabilities'.
     * 
     * @return GetCapabilities
     * @return the value of field 'getCapabilities'.
     */
    public nl.b3p.xml.wfs.v100.GetCapabilities getGetCapabilities()
    {
        return this._getCapabilities;
    } //-- nl.b3p.xml.wfs.v100.GetCapabilities getGetCapabilities() 

    /**
     * Returns the value of field 'getFeature'.
     * 
     * @return GetFeature
     * @return the value of field 'getFeature'.
     */
    public nl.b3p.xml.wfs.v100.GetFeature getGetFeature()
    {
        return this._getFeature;
    } //-- nl.b3p.xml.wfs.v100.GetFeature getGetFeature() 

    /**
     * Returns the value of field 'getFeatureWithLock'.
     * 
     * @return GetFeatureWithLock
     * @return the value of field 'getFeatureWithLock'.
     */
    public nl.b3p.xml.wfs.v100.GetFeatureWithLock getGetFeatureWithLock()
    {
        return this._getFeatureWithLock;
    } //-- nl.b3p.xml.wfs.v100.GetFeatureWithLock getGetFeatureWithLock() 

    /**
     * Returns the value of field 'lockFeature'.
     * 
     * @return LockFeature
     * @return the value of field 'lockFeature'.
     */
    public nl.b3p.xml.wfs.v100.LockFeature getLockFeature()
    {
        return this._lockFeature;
    } //-- nl.b3p.xml.wfs.v100.LockFeature getLockFeature() 

    /**
     * Returns the value of field 'transaction'.
     * 
     * @return Transaction
     * @return the value of field 'transaction'.
     */
    public nl.b3p.xml.wfs.v100.Transaction getTransaction()
    {
        return this._transaction;
    } //-- nl.b3p.xml.wfs.v100.Transaction getTransaction() 

    /**
     * Sets the value of field 'describeFeatureType'.
     * 
     * @param describeFeatureType the value of field
     * 'describeFeatureType'.
     */
    public void setDescribeFeatureType(nl.b3p.xml.wfs.v100.DescribeFeatureType describeFeatureType)
    {
        this._describeFeatureType = describeFeatureType;
        this._choiceValue = describeFeatureType;
    } //-- void setDescribeFeatureType(nl.b3p.xml.wfs.v100.DescribeFeatureType) 

    /**
     * Sets the value of field 'getCapabilities'.
     * 
     * @param getCapabilities the value of field 'getCapabilities'.
     */
    public void setGetCapabilities(nl.b3p.xml.wfs.v100.GetCapabilities getCapabilities)
    {
        this._getCapabilities = getCapabilities;
        this._choiceValue = getCapabilities;
    } //-- void setGetCapabilities(nl.b3p.xml.wfs.v100.GetCapabilities) 

    /**
     * Sets the value of field 'getFeature'.
     * 
     * @param getFeature the value of field 'getFeature'.
     */
    public void setGetFeature(nl.b3p.xml.wfs.v100.GetFeature getFeature)
    {
        this._getFeature = getFeature;
        this._choiceValue = getFeature;
    } //-- void setGetFeature(nl.b3p.xml.wfs.v100.GetFeature) 

    /**
     * Sets the value of field 'getFeatureWithLock'.
     * 
     * @param getFeatureWithLock the value of field
     * 'getFeatureWithLock'.
     */
    public void setGetFeatureWithLock(nl.b3p.xml.wfs.v100.GetFeatureWithLock getFeatureWithLock)
    {
        this._getFeatureWithLock = getFeatureWithLock;
        this._choiceValue = getFeatureWithLock;
    } //-- void setGetFeatureWithLock(nl.b3p.xml.wfs.v100.GetFeatureWithLock) 

    /**
     * Sets the value of field 'lockFeature'.
     * 
     * @param lockFeature the value of field 'lockFeature'.
     */
    public void setLockFeature(nl.b3p.xml.wfs.v100.LockFeature lockFeature)
    {
        this._lockFeature = lockFeature;
        this._choiceValue = lockFeature;
    } //-- void setLockFeature(nl.b3p.xml.wfs.v100.LockFeature) 

    /**
     * Sets the value of field 'transaction'.
     * 
     * @param transaction the value of field 'transaction'.
     */
    public void setTransaction(nl.b3p.xml.wfs.v100.Transaction transaction)
    {
        this._transaction = transaction;
        this._choiceValue = transaction;
    } //-- void setTransaction(nl.b3p.xml.wfs.v100.Transaction) 

}
