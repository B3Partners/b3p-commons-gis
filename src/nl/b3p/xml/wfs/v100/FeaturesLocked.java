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
 * 
 * @version $Revision$ $Date$
 */
public class FeaturesLocked extends FeaturesLockedType 
implements java.io.Serializable
{


      //----------------/
     //- Constructors -/
    //----------------/

    public FeaturesLocked() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v100.FeaturesLocked()


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
     * @return FeaturesLockedType
     */
    public static nl.b3p.xml.wfs.v100.FeaturesLockedType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.FeaturesLockedType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.FeaturesLocked.class, reader);
    } //-- nl.b3p.xml.wfs.v100.FeaturesLockedType unmarshal(java.io.Reader) 

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
