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
public class FeatureCollectionType extends nl.b3p.xml.gml.v212.AbstractFeatureCollectionType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The value of the lockId attribute is an identifier
     *  that a Web Feature Service generates and which a
     *  client application can use in subsequent operations
     *  (such as a Transaction request) to reference the set
     *  of locked features.
     *  
     */
    private java.lang.String _lockId;


      //----------------/
     //- Constructors -/
    //----------------/

    public FeatureCollectionType() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v100.transaction.FeatureCollectionType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'lockId'. The field 'lockId' has
     * the following description: The value of the lockId attribute
     * is an identifier
     *  that a Web Feature Service generates and which a
     *  client application can use in subsequent operations
     *  (such as a Transaction request) to reference the set
     *  of locked features.
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
     * Sets the value of field 'lockId'. The field 'lockId' has the
     * following description: The value of the lockId attribute is
     * an identifier
     *  that a Web Feature Service generates and which a
     *  client application can use in subsequent operations
     *  (such as a Transaction request) to reference the set
     *  of locked features.
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
     * @return FeatureCollectionType
     */
    public static nl.b3p.xml.wfs.v100.transaction.FeatureCollectionType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.transaction.FeatureCollectionType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.transaction.FeatureCollectionType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.transaction.FeatureCollectionType unmarshal(java.io.Reader) 

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
