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
 * Class DeleteElementType.
 * 
 * @version $Revision$ $Date$
 */
public class DeleteElementType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _handle
     */
    private java.lang.String _handle;

    /**
     * Field _typeName
     */
    private java.lang.String _typeName;

    /**
     * The Filter element is used to constrain the scope
     *  of the delete operation to those features identified
     *  by the filter. Feature instances can be specified
     *  explicitly and individually using the identifier of
     *  each feature instance OR a set of features to be
     *  operated on can be identified by specifying spatial
     *  and non-spatial constraints in the filter.
     *  If no filter is specified then an exception should
     *  be raised since it is unlikely that a client application
     *  intends to delete all feature instances.
     *  
     */
    private nl.b3p.xml.ogc.v100.Filter _filter;


      //----------------/
     //- Constructors -/
    //----------------/

    public DeleteElementType() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v100.transaction.DeleteElementType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'filter'. The field 'filter' has
     * the following description: The Filter element is used to
     * constrain the scope
     *  of the delete operation to those features identified
     *  by the filter. Feature instances can be specified
     *  explicitly and individually using the identifier of
     *  each feature instance OR a set of features to be
     *  operated on can be identified by specifying spatial
     *  and non-spatial constraints in the filter.
     *  If no filter is specified then an exception should
     *  be raised since it is unlikely that a client application
     *  intends to delete all feature instances.
     *  
     * 
     * @return Filter
     * @return the value of field 'filter'.
     */
    public nl.b3p.xml.ogc.v100.Filter getFilter()
    {
        return this._filter;
    } //-- nl.b3p.xml.ogc.v100.Filter getFilter() 

    /**
     * Returns the value of field 'handle'.
     * 
     * @return String
     * @return the value of field 'handle'.
     */
    public java.lang.String getHandle()
    {
        return this._handle;
    } //-- java.lang.String getHandle() 

    /**
     * Returns the value of field 'typeName'.
     * 
     * @return String
     * @return the value of field 'typeName'.
     */
    public java.lang.String getTypeName()
    {
        return this._typeName;
    } //-- java.lang.String getTypeName() 

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
     * Sets the value of field 'filter'. The field 'filter' has the
     * following description: The Filter element is used to
     * constrain the scope
     *  of the delete operation to those features identified
     *  by the filter. Feature instances can be specified
     *  explicitly and individually using the identifier of
     *  each feature instance OR a set of features to be
     *  operated on can be identified by specifying spatial
     *  and non-spatial constraints in the filter.
     *  If no filter is specified then an exception should
     *  be raised since it is unlikely that a client application
     *  intends to delete all feature instances.
     *  
     * 
     * @param filter the value of field 'filter'.
     */
    public void setFilter(nl.b3p.xml.ogc.v100.Filter filter)
    {
        this._filter = filter;
    } //-- void setFilter(nl.b3p.xml.ogc.v100.Filter) 

    /**
     * Sets the value of field 'handle'.
     * 
     * @param handle the value of field 'handle'.
     */
    public void setHandle(java.lang.String handle)
    {
        this._handle = handle;
    } //-- void setHandle(java.lang.String) 

    /**
     * Sets the value of field 'typeName'.
     * 
     * @param typeName the value of field 'typeName'.
     */
    public void setTypeName(java.lang.String typeName)
    {
        this._typeName = typeName;
    } //-- void setTypeName(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return DeleteElementType
     */
    public static nl.b3p.xml.wfs.v100.transaction.DeleteElementType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v100.transaction.DeleteElementType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v100.transaction.DeleteElementType.class, reader);
    } //-- nl.b3p.xml.wfs.v100.transaction.DeleteElementType unmarshal(java.io.Reader) 

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
