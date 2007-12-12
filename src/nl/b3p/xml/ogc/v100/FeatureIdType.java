/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v100;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class FeatureIdType.
 * 
 * @version $Revision$ $Date$
 */
public class FeatureIdType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _fid
     */
    private java.lang.String _fid;


      //----------------/
     //- Constructors -/
    //----------------/

    public FeatureIdType() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v100.FeatureIdType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'fid'.
     * 
     * @return String
     * @return the value of field 'fid'.
     */
    public java.lang.String getFid()
    {
        return this._fid;
    } //-- java.lang.String getFid() 

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
     * Sets the value of field 'fid'.
     * 
     * @param fid the value of field 'fid'.
     */
    public void setFid(java.lang.String fid)
    {
        this._fid = fid;
    } //-- void setFid(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return FeatureIdType
     */
    public static nl.b3p.xml.ogc.v100.FeatureIdType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v100.FeatureIdType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.FeatureIdType.class, reader);
    } //-- nl.b3p.xml.ogc.v100.FeatureIdType unmarshal(java.io.Reader) 

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
