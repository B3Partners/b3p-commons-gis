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
 * Reports the total number of features affected by some kind 
 *  of write action (i.e, insert, update, delete).
 *  
 * 
 * @version $Revision$ $Date$
 */
public class TransactionSummaryType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _totalInserted
     */
    private int _totalInserted;

    /**
     * keeps track of state for field: _totalInserted
     */
    private boolean _has_totalInserted;

    /**
     * Field _totalUpdated
     */
    private int _totalUpdated;

    /**
     * keeps track of state for field: _totalUpdated
     */
    private boolean _has_totalUpdated;

    /**
     * Field _totalDeleted
     */
    private int _totalDeleted;

    /**
     * keeps track of state for field: _totalDeleted
     */
    private boolean _has_totalDeleted;


      //----------------/
     //- Constructors -/
    //----------------/

    public TransactionSummaryType() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v110.TransactionSummaryType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteTotalDeleted
     * 
     */
    public void deleteTotalDeleted()
    {
        this._has_totalDeleted= false;
    } //-- void deleteTotalDeleted() 

    /**
     * Method deleteTotalInserted
     * 
     */
    public void deleteTotalInserted()
    {
        this._has_totalInserted= false;
    } //-- void deleteTotalInserted() 

    /**
     * Method deleteTotalUpdated
     * 
     */
    public void deleteTotalUpdated()
    {
        this._has_totalUpdated= false;
    } //-- void deleteTotalUpdated() 

    /**
     * Returns the value of field 'totalDeleted'.
     * 
     * @return int
     * @return the value of field 'totalDeleted'.
     */
    public int getTotalDeleted()
    {
        return this._totalDeleted;
    } //-- int getTotalDeleted() 

    /**
     * Returns the value of field 'totalInserted'.
     * 
     * @return int
     * @return the value of field 'totalInserted'.
     */
    public int getTotalInserted()
    {
        return this._totalInserted;
    } //-- int getTotalInserted() 

    /**
     * Returns the value of field 'totalUpdated'.
     * 
     * @return int
     * @return the value of field 'totalUpdated'.
     */
    public int getTotalUpdated()
    {
        return this._totalUpdated;
    } //-- int getTotalUpdated() 

    /**
     * Method hasTotalDeleted
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasTotalDeleted()
    {
        return this._has_totalDeleted;
    } //-- boolean hasTotalDeleted() 

    /**
     * Method hasTotalInserted
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasTotalInserted()
    {
        return this._has_totalInserted;
    } //-- boolean hasTotalInserted() 

    /**
     * Method hasTotalUpdated
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasTotalUpdated()
    {
        return this._has_totalUpdated;
    } //-- boolean hasTotalUpdated() 

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
     * Sets the value of field 'totalDeleted'.
     * 
     * @param totalDeleted the value of field 'totalDeleted'.
     */
    public void setTotalDeleted(int totalDeleted)
    {
        this._totalDeleted = totalDeleted;
        this._has_totalDeleted = true;
    } //-- void setTotalDeleted(int) 

    /**
     * Sets the value of field 'totalInserted'.
     * 
     * @param totalInserted the value of field 'totalInserted'.
     */
    public void setTotalInserted(int totalInserted)
    {
        this._totalInserted = totalInserted;
        this._has_totalInserted = true;
    } //-- void setTotalInserted(int) 

    /**
     * Sets the value of field 'totalUpdated'.
     * 
     * @param totalUpdated the value of field 'totalUpdated'.
     */
    public void setTotalUpdated(int totalUpdated)
    {
        this._totalUpdated = totalUpdated;
        this._has_totalUpdated = true;
    } //-- void setTotalUpdated(int) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return TransactionSummaryType
     */
    public static nl.b3p.xml.wfs.v110.TransactionSummaryType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.TransactionSummaryType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.TransactionSummaryType.class, reader);
    } //-- nl.b3p.xml.wfs.v110.TransactionSummaryType unmarshal(java.io.Reader) 

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
