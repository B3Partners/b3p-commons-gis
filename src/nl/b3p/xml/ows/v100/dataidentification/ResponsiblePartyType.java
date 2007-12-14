/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100.dataidentification;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Identification of, and means of communication with, person
 * responsible for the server. At least one of IndividualName,
 * OrganisationName, or PositionName shall be included. 
 * 
 * @version $Revision$ $Date$
 */
public class ResponsiblePartyType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Name of the responsible person: surname, given name, title
     * separated by a delimiter. 
     */
    private java.lang.String _individualName;

    /**
     * Name of the responsible organization. 
     */
    private java.lang.String _organisationName;

    /**
     * Role or position of the responsible person. 
     */
    private java.lang.String _positionName;

    /**
     * Address of the responsible party. 
     */
    private nl.b3p.xml.ows.v100.dataidentification.ContactInfo _contactInfo;

    /**
     * Function performed by the responsible party. Possible values
     * of this Role shall include the values and the meanings
     * listed in Subclause B.5.5 of ISO 19115:2003. 
     */
    private nl.b3p.xml.ows.v100.dataidentification.Role _role;


      //----------------/
     //- Constructors -/
    //----------------/

    public ResponsiblePartyType() 
     {
        super();
    } //-- nl.b3p.xml.ows.v100.dataidentification.ResponsiblePartyType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'contactInfo'. The field
     * 'contactInfo' has the following description: Address of the
     * responsible party. 
     * 
     * @return ContactInfo
     * @return the value of field 'contactInfo'.
     */
    public nl.b3p.xml.ows.v100.dataidentification.ContactInfo getContactInfo()
    {
        return this._contactInfo;
    } //-- nl.b3p.xml.ows.v100.dataidentification.ContactInfo getContactInfo() 

    /**
     * Returns the value of field 'individualName'. The field
     * 'individualName' has the following description: Name of the
     * responsible person: surname, given name, title separated by
     * a delimiter. 
     * 
     * @return String
     * @return the value of field 'individualName'.
     */
    public java.lang.String getIndividualName()
    {
        return this._individualName;
    } //-- java.lang.String getIndividualName() 

    /**
     * Returns the value of field 'organisationName'. The field
     * 'organisationName' has the following description: Name of
     * the responsible organization. 
     * 
     * @return String
     * @return the value of field 'organisationName'.
     */
    public java.lang.String getOrganisationName()
    {
        return this._organisationName;
    } //-- java.lang.String getOrganisationName() 

    /**
     * Returns the value of field 'positionName'. The field
     * 'positionName' has the following description: Role or
     * position of the responsible person. 
     * 
     * @return String
     * @return the value of field 'positionName'.
     */
    public java.lang.String getPositionName()
    {
        return this._positionName;
    } //-- java.lang.String getPositionName() 

    /**
     * Returns the value of field 'role'. The field 'role' has the
     * following description: Function performed by the responsible
     * party. Possible values of this Role shall include the values
     * and the meanings listed in Subclause B.5.5 of ISO
     * 19115:2003. 
     * 
     * @return Role
     * @return the value of field 'role'.
     */
    public nl.b3p.xml.ows.v100.dataidentification.Role getRole()
    {
        return this._role;
    } //-- nl.b3p.xml.ows.v100.dataidentification.Role getRole() 

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
     * Sets the value of field 'contactInfo'. The field
     * 'contactInfo' has the following description: Address of the
     * responsible party. 
     * 
     * @param contactInfo the value of field 'contactInfo'.
     */
    public void setContactInfo(nl.b3p.xml.ows.v100.dataidentification.ContactInfo contactInfo)
    {
        this._contactInfo = contactInfo;
    } //-- void setContactInfo(nl.b3p.xml.ows.v100.dataidentification.ContactInfo) 

    /**
     * Sets the value of field 'individualName'. The field
     * 'individualName' has the following description: Name of the
     * responsible person: surname, given name, title separated by
     * a delimiter. 
     * 
     * @param individualName the value of field 'individualName'.
     */
    public void setIndividualName(java.lang.String individualName)
    {
        this._individualName = individualName;
    } //-- void setIndividualName(java.lang.String) 

    /**
     * Sets the value of field 'organisationName'. The field
     * 'organisationName' has the following description: Name of
     * the responsible organization. 
     * 
     * @param organisationName the value of field 'organisationName'
     */
    public void setOrganisationName(java.lang.String organisationName)
    {
        this._organisationName = organisationName;
    } //-- void setOrganisationName(java.lang.String) 

    /**
     * Sets the value of field 'positionName'. The field
     * 'positionName' has the following description: Role or
     * position of the responsible person. 
     * 
     * @param positionName the value of field 'positionName'.
     */
    public void setPositionName(java.lang.String positionName)
    {
        this._positionName = positionName;
    } //-- void setPositionName(java.lang.String) 

    /**
     * Sets the value of field 'role'. The field 'role' has the
     * following description: Function performed by the responsible
     * party. Possible values of this Role shall include the values
     * and the meanings listed in Subclause B.5.5 of ISO
     * 19115:2003. 
     * 
     * @param role the value of field 'role'.
     */
    public void setRole(nl.b3p.xml.ows.v100.dataidentification.Role role)
    {
        this._role = role;
    } //-- void setRole(nl.b3p.xml.ows.v100.dataidentification.Role) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return ResponsiblePartyType
     */
    public static nl.b3p.xml.ows.v100.dataidentification.ResponsiblePartyType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.dataidentification.ResponsiblePartyType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.dataidentification.ResponsiblePartyType.class, reader);
    } //-- nl.b3p.xml.ows.v100.dataidentification.ResponsiblePartyType unmarshal(java.io.Reader) 

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
