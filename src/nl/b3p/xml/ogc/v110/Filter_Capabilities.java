/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v110;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class Filter_Capabilities.
 * 
 * @version $Revision$ $Date$
 */
public class Filter_Capabilities implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _spatial_Capabilities
     */
    private nl.b3p.xml.ogc.v110.Spatial_Capabilities _spatial_Capabilities;

    /**
     * Field _scalar_Capabilities
     */
    private nl.b3p.xml.ogc.v110.Scalar_Capabilities _scalar_Capabilities;

    /**
     * Field _id_Capabilities
     */
    private nl.b3p.xml.ogc.v110.Id_Capabilities _id_Capabilities;


      //----------------/
     //- Constructors -/
    //----------------/

    public Filter_Capabilities() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v110.Filter_Capabilities()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'id_Capabilities'.
     * 
     * @return Id_Capabilities
     * @return the value of field 'id_Capabilities'.
     */
    public nl.b3p.xml.ogc.v110.Id_Capabilities getId_Capabilities()
    {
        return this._id_Capabilities;
    } //-- nl.b3p.xml.ogc.v110.Id_Capabilities getId_Capabilities() 

    /**
     * Returns the value of field 'scalar_Capabilities'.
     * 
     * @return Scalar_Capabilities
     * @return the value of field 'scalar_Capabilities'.
     */
    public nl.b3p.xml.ogc.v110.Scalar_Capabilities getScalar_Capabilities()
    {
        return this._scalar_Capabilities;
    } //-- nl.b3p.xml.ogc.v110.Scalar_Capabilities getScalar_Capabilities() 

    /**
     * Returns the value of field 'spatial_Capabilities'.
     * 
     * @return Spatial_Capabilities
     * @return the value of field 'spatial_Capabilities'.
     */
    public nl.b3p.xml.ogc.v110.Spatial_Capabilities getSpatial_Capabilities()
    {
        return this._spatial_Capabilities;
    } //-- nl.b3p.xml.ogc.v110.Spatial_Capabilities getSpatial_Capabilities() 

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
     * Sets the value of field 'id_Capabilities'.
     * 
     * @param id_Capabilities the value of field 'id_Capabilities'.
     */
    public void setId_Capabilities(nl.b3p.xml.ogc.v110.Id_Capabilities id_Capabilities)
    {
        this._id_Capabilities = id_Capabilities;
    } //-- void setId_Capabilities(nl.b3p.xml.ogc.v110.Id_Capabilities) 

    /**
     * Sets the value of field 'scalar_Capabilities'.
     * 
     * @param scalar_Capabilities the value of field
     * 'scalar_Capabilities'.
     */
    public void setScalar_Capabilities(nl.b3p.xml.ogc.v110.Scalar_Capabilities scalar_Capabilities)
    {
        this._scalar_Capabilities = scalar_Capabilities;
    } //-- void setScalar_Capabilities(nl.b3p.xml.ogc.v110.Scalar_Capabilities) 

    /**
     * Sets the value of field 'spatial_Capabilities'.
     * 
     * @param spatial_Capabilities the value of field
     * 'spatial_Capabilities'.
     */
    public void setSpatial_Capabilities(nl.b3p.xml.ogc.v110.Spatial_Capabilities spatial_Capabilities)
    {
        this._spatial_Capabilities = spatial_Capabilities;
    } //-- void setSpatial_Capabilities(nl.b3p.xml.ogc.v110.Spatial_Capabilities) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Filter_Capabilities
     */
    public static nl.b3p.xml.ogc.v110.Filter_Capabilities unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v110.Filter_Capabilities) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.Filter_Capabilities.class, reader);
    } //-- nl.b3p.xml.ogc.v110.Filter_Capabilities unmarshal(java.io.Reader) 

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
