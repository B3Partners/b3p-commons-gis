/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100.capabilities;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class LatLongBoundingBoxType.
 * 
 * @version $Revision$ $Date$
 */
public class LatLongBoundingBoxType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _minx
     */
    private java.lang.String _minx;

    /**
     * Field _miny
     */
    private java.lang.String _miny;

    /**
     * Field _maxx
     */
    private java.lang.String _maxx;

    /**
     * Field _maxy
     */
    private java.lang.String _maxy;


      //----------------/
     //- Constructors -/
    //----------------/

    public LatLongBoundingBoxType() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v100.capabilities.LatLongBoundingBoxType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'maxx'.
     * 
     * @return String
     * @return the value of field 'maxx'.
     */
    public java.lang.String getMaxx()
    {
        return this._maxx;
    } //-- java.lang.String getMaxx() 

    /**
     * Returns the value of field 'maxy'.
     * 
     * @return String
     * @return the value of field 'maxy'.
     */
    public java.lang.String getMaxy()
    {
        return this._maxy;
    } //-- java.lang.String getMaxy() 

    /**
     * Returns the value of field 'minx'.
     * 
     * @return String
     * @return the value of field 'minx'.
     */
    public java.lang.String getMinx()
    {
        return this._minx;
    } //-- java.lang.String getMinx() 

    /**
     * Returns the value of field 'miny'.
     * 
     * @return String
     * @return the value of field 'miny'.
     */
    public java.lang.String getMiny()
    {
        return this._miny;
    } //-- java.lang.String getMiny() 

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
     * Sets the value of field 'maxx'.
     * 
     * @param maxx the value of field 'maxx'.
     */
    public void setMaxx(java.lang.String maxx)
    {
        this._maxx = maxx;
    } //-- void setMaxx(java.lang.String) 

    /**
     * Sets the value of field 'maxy'.
     * 
     * @param maxy the value of field 'maxy'.
     */
    public void setMaxy(java.lang.String maxy)
    {
        this._maxy = maxy;
    } //-- void setMaxy(java.lang.String) 

    /**
     * Sets the value of field 'minx'.
     * 
     * @param minx the value of field 'minx'.
     */
    public void setMinx(java.lang.String minx)
    {
        this._minx = minx;
    } //-- void setMinx(java.lang.String) 

    /**
     * Sets the value of field 'miny'.
     * 
     * @param miny the value of field 'miny'.
     */
    public void setMiny(java.lang.String miny)
    {
        this._miny = miny;
    } //-- void setMiny(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return LatLongBoundingBoxType
     */
    public static nl.b3p.xml.wfs.v100.capabilities.LatLongBoundingBoxType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.capabilities.LatLongBoundingBoxType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.capabilities.LatLongBoundingBoxType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.capabilities.LatLongBoundingBoxType unmarshal(java.io.Reader) 

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
