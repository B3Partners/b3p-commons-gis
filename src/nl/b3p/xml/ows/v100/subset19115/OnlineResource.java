/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100.subset19115;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * On-line information that can be used to contact the individual
 * or organization. OWS specifics: The xlink:href attribute in the
 * xlink:simpleLink attribute group shall be used to reference this
 * resource. Whenever practical, the xlink:href attribute with type
 * anyURI should be a URL from which more contact information can
 * be electronically retrieved. The xlink:title attribute with type
 * "string" can be used to name this set of information. The other
 * attributes in the xlink:simpleLink attribute group should not be
 * used. 
 * 
 * @version $Revision$ $Date$
 */
public class OnlineResource extends OnlineResourceType 
implements java.io.Serializable
{


      //----------------/
     //- Constructors -/
    //----------------/

    public OnlineResource() 
     {
        super();
    } //-- nl.b3p.xml.ows.v100.subset19115.OnlineResource()


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
     * @return OnlineResourceType
     */
    public static nl.b3p.xml.ows.v100.subset19115.OnlineResourceType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.subset19115.OnlineResourceType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.subset19115.OnlineResource.class, reader);
    } //-- nl.b3p.xml.ows.v100.subset19115.OnlineResourceType unmarshal(java.io.Reader) 

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
