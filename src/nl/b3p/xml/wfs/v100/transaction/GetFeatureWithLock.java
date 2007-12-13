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
 * This is the root element for the GetFeatureWithLock request.
 *  The GetFeatureWithLock operation performs identically to a
 *  GetFeature request except that the GetFeatureWithLock request
 *  locks all the feature instances in the result set and returns
 *  a lock identifier to a client application in the response.
 *  
 * 
 * @version $Revision$ $Date$
 */
public class GetFeatureWithLock extends GetFeatureWithLockType 
implements java.io.Serializable
{


      //----------------/
     //- Constructors -/
    //----------------/

    public GetFeatureWithLock() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v100.transaction.GetFeatureWithLock()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return GetFeatureWithLockType
     */
    public static nl.b3p.xml.wfs.v100.transaction.GetFeatureWithLockType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.transaction.GetFeatureWithLockType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.transaction.GetFeatureWithLock.class, reader);
    } //-- nl.b3p.xml.wfs.v100.transaction.GetFeatureWithLockType unmarshal(java.io.Reader) 

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
