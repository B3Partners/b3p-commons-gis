/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * XML encoded minimum rectangular bounding box (or region)
 * parameter, surrounding all the associated data. This box is
 * specialized for use with the 2D WGS 84 coordinate reference
 * system with decimal values of longitude and latitude. This type
 * is adapted from the general BoundingBoxType, with modified
 * contents and documentation for use with the 2D WGS 84 coordinate
 * reference system. 
 * 
 * @version $Revision$ $Date$
 */
public class WGS84BoundingBoxType extends nl.b3p.xml.ows.v100.BoundingBoxType 
implements java.io.Serializable
{


      //----------------/
     //- Constructors -/
    //----------------/

    public WGS84BoundingBoxType() 
     {
        super();
        setCrs("urn:ogc:def:crs:OGC:2:84");
    } //-- nl.b3p.xml.ows.v100.WGS84BoundingBoxType()


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
     * @return BoundingBoxType
     */
    public static nl.b3p.xml.ows.v100.BoundingBoxType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.BoundingBoxType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.WGS84BoundingBoxType.class, reader);
    } //-- nl.b3p.xml.ows.v100.BoundingBoxType unmarshal(java.io.Reader) 

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
