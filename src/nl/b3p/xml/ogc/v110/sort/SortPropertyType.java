/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v110.sort;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class SortPropertyType.
 * 
 * @version $Revision$ $Date$
 */
public class SortPropertyType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _propertyName
     */
    private nl.b3p.xml.ogc.v110.sort.PropertyName _propertyName;

    /**
     * Field _sortOrder
     */
    private nl.b3p.xml.ogc.v110.sort.types.SortOrderType _sortOrder;


      //----------------/
     //- Constructors -/
    //----------------/

    public SortPropertyType() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v110.sort.SortPropertyType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'propertyName'.
     * 
     * @return PropertyName
     * @return the value of field 'propertyName'.
     */
    public nl.b3p.xml.ogc.v110.sort.PropertyName getPropertyName()
    {
        return this._propertyName;
    } //-- nl.b3p.xml.ogc.v110.sort.PropertyName getPropertyName() 

    /**
     * Returns the value of field 'sortOrder'.
     * 
     * @return SortOrderType
     * @return the value of field 'sortOrder'.
     */
    public nl.b3p.xml.ogc.v110.sort.types.SortOrderType getSortOrder()
    {
        return this._sortOrder;
    } //-- nl.b3p.xml.ogc.v110.sort.types.SortOrderType getSortOrder() 

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
     * Sets the value of field 'propertyName'.
     * 
     * @param propertyName the value of field 'propertyName'.
     */
    public void setPropertyName(nl.b3p.xml.ogc.v110.sort.PropertyName propertyName)
    {
        this._propertyName = propertyName;
    } //-- void setPropertyName(nl.b3p.xml.ogc.v110.sort.PropertyName) 

    /**
     * Sets the value of field 'sortOrder'.
     * 
     * @param sortOrder the value of field 'sortOrder'.
     */
    public void setSortOrder(nl.b3p.xml.ogc.v110.sort.types.SortOrderType sortOrder)
    {
        this._sortOrder = sortOrder;
    } //-- void setSortOrder(nl.b3p.xml.ogc.v110.sort.types.SortOrderType) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return SortPropertyType
     */
    public static nl.b3p.xml.ogc.v110.sort.SortPropertyType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v110.sort.SortPropertyType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.sort.SortPropertyType.class, reader);
    } //-- nl.b3p.xml.ogc.v110.sort.SortPropertyType unmarshal(java.io.Reader) 

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
