/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100.serviceidentification;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * General metadata for this specific server. This XML Schema of
 * this section shall be the same for all OWS. 
 * 
 * @version $Revision$ $Date$
 */
public class ServiceIdentification extends nl.b3p.xml.ows.v100.serviceidentification.DescriptionType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * A service type name from a registry of services. For
     * example, the values of the codeSpace URI and name and code
     * string may be "OGC" and "catalogue." This type name is
     * normally used for machine-to-machine communication. 
     */
    private nl.b3p.xml.ows.v100.serviceidentification.ServiceType _serviceType;

    /**
     * Unordered list of one or more versions of this service type
     * implemented by this server. This information is not adequate
     * for version negotiation, and shall not be used for that
     * purpose. 
     */
    private java.util.ArrayList _serviceTypeVersionList;

    /**
     * If this element is omitted, no meaning is implied. 
     */
    private java.lang.String _fees;

    /**
     * Unordered list of access constraints applied to assure the
     * protection of privacy or intellectual property, and any
     * other restrictions on retrieving or using data from or
     * otherwise using this server. The reserved value NONE (case
     * insensitive) shall be used to mean no access constraints are
     * imposed. If this element is omitted, no meaning is implied. 
     */
    private java.util.ArrayList _accessConstraintsList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ServiceIdentification() 
     {
        super();
        _serviceTypeVersionList = new java.util.ArrayList();
        _accessConstraintsList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.serviceidentification.ServiceIdentification()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addAccessConstraints
     * 
     * 
     * 
     * @param vAccessConstraints
     */
    public void addAccessConstraints(java.lang.String vAccessConstraints)
        throws java.lang.IndexOutOfBoundsException
    {
        _accessConstraintsList.add(vAccessConstraints);
    } //-- void addAccessConstraints(java.lang.String) 

    /**
     * Method addAccessConstraints
     * 
     * 
     * 
     * @param index
     * @param vAccessConstraints
     */
    public void addAccessConstraints(int index, java.lang.String vAccessConstraints)
        throws java.lang.IndexOutOfBoundsException
    {
        _accessConstraintsList.add(index, vAccessConstraints);
    } //-- void addAccessConstraints(int, java.lang.String) 

    /**
     * Method addServiceTypeVersion
     * 
     * 
     * 
     * @param vServiceTypeVersion
     */
    public void addServiceTypeVersion(java.lang.String vServiceTypeVersion)
        throws java.lang.IndexOutOfBoundsException
    {
        _serviceTypeVersionList.add(vServiceTypeVersion);
    } //-- void addServiceTypeVersion(java.lang.String) 

    /**
     * Method addServiceTypeVersion
     * 
     * 
     * 
     * @param index
     * @param vServiceTypeVersion
     */
    public void addServiceTypeVersion(int index, java.lang.String vServiceTypeVersion)
        throws java.lang.IndexOutOfBoundsException
    {
        _serviceTypeVersionList.add(index, vServiceTypeVersion);
    } //-- void addServiceTypeVersion(int, java.lang.String) 

    /**
     * Method clearAccessConstraints
     * 
     */
    public void clearAccessConstraints()
    {
        _accessConstraintsList.clear();
    } //-- void clearAccessConstraints() 

    /**
     * Method clearServiceTypeVersion
     * 
     */
    public void clearServiceTypeVersion()
    {
        _serviceTypeVersionList.clear();
    } //-- void clearServiceTypeVersion() 

    /**
     * Method enumerateAccessConstraints
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateAccessConstraints()
    {
        return Collections.enumeration(_accessConstraintsList);
    } //-- java.util.Enumeration enumerateAccessConstraints() 

    /**
     * Method enumerateServiceTypeVersion
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateServiceTypeVersion()
    {
        return Collections.enumeration(_serviceTypeVersionList);
    } //-- java.util.Enumeration enumerateServiceTypeVersion() 

    /**
     * Method getAccessConstraints
     * 
     * 
     * 
     * @param index
     * @return String
     */
    public java.lang.String getAccessConstraints(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _accessConstraintsList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_accessConstraintsList.get(index);
    } //-- java.lang.String getAccessConstraints(int) 

    /**
     * Method getAccessConstraints
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String[] getAccessConstraints()
    {
        int size = _accessConstraintsList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_accessConstraintsList.get(index);
        }
        return mArray;
    } //-- java.lang.String[] getAccessConstraints() 

    /**
     * Method getAccessConstraintsCount
     * 
     * 
     * 
     * @return int
     */
    public int getAccessConstraintsCount()
    {
        return _accessConstraintsList.size();
    } //-- int getAccessConstraintsCount() 

    /**
     * Returns the value of field 'fees'. The field 'fees' has the
     * following description: If this element is omitted, no
     * meaning is implied. 
     * 
     * @return String
     * @return the value of field 'fees'.
     */
    public java.lang.String getFees()
    {
        return this._fees;
    } //-- java.lang.String getFees() 

    /**
     * Returns the value of field 'serviceType'. The field
     * 'serviceType' has the following description: A service type
     * name from a registry of services. For example, the values of
     * the codeSpace URI and name and code string may be "OGC" and
     * "catalogue." This type name is normally used for
     * machine-to-machine communication. 
     * 
     * @return ServiceType
     * @return the value of field 'serviceType'.
     */
    public nl.b3p.xml.ows.v100.serviceidentification.ServiceType getServiceType()
    {
        return this._serviceType;
    } //-- nl.b3p.xml.ows.v100.serviceidentification.ServiceType getServiceType() 

    /**
     * Method getServiceTypeVersion
     * 
     * 
     * 
     * @param index
     * @return String
     */
    public java.lang.String getServiceTypeVersion(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _serviceTypeVersionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_serviceTypeVersionList.get(index);
    } //-- java.lang.String getServiceTypeVersion(int) 

    /**
     * Method getServiceTypeVersion
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String[] getServiceTypeVersion()
    {
        int size = _serviceTypeVersionList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_serviceTypeVersionList.get(index);
        }
        return mArray;
    } //-- java.lang.String[] getServiceTypeVersion() 

    /**
     * Method getServiceTypeVersionCount
     * 
     * 
     * 
     * @return int
     */
    public int getServiceTypeVersionCount()
    {
        return _serviceTypeVersionList.size();
    } //-- int getServiceTypeVersionCount() 

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
     * Method removeAccessConstraints
     * 
     * 
     * 
     * @param vAccessConstraints
     * @return boolean
     */
    public boolean removeAccessConstraints(java.lang.String vAccessConstraints)
    {
        boolean removed = _accessConstraintsList.remove(vAccessConstraints);
        return removed;
    } //-- boolean removeAccessConstraints(java.lang.String) 

    /**
     * Method removeServiceTypeVersion
     * 
     * 
     * 
     * @param vServiceTypeVersion
     * @return boolean
     */
    public boolean removeServiceTypeVersion(java.lang.String vServiceTypeVersion)
    {
        boolean removed = _serviceTypeVersionList.remove(vServiceTypeVersion);
        return removed;
    } //-- boolean removeServiceTypeVersion(java.lang.String) 

    /**
     * Method setAccessConstraints
     * 
     * 
     * 
     * @param index
     * @param vAccessConstraints
     */
    public void setAccessConstraints(int index, java.lang.String vAccessConstraints)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _accessConstraintsList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _accessConstraintsList.set(index, vAccessConstraints);
    } //-- void setAccessConstraints(int, java.lang.String) 

    /**
     * Method setAccessConstraints
     * 
     * 
     * 
     * @param accessConstraintsArray
     */
    public void setAccessConstraints(java.lang.String[] accessConstraintsArray)
    {
        //-- copy array
        _accessConstraintsList.clear();
        for (int i = 0; i < accessConstraintsArray.length; i++) {
            _accessConstraintsList.add(accessConstraintsArray[i]);
        }
    } //-- void setAccessConstraints(java.lang.String) 

    /**
     * Sets the value of field 'fees'. The field 'fees' has the
     * following description: If this element is omitted, no
     * meaning is implied. 
     * 
     * @param fees the value of field 'fees'.
     */
    public void setFees(java.lang.String fees)
    {
        this._fees = fees;
    } //-- void setFees(java.lang.String) 

    /**
     * Sets the value of field 'serviceType'. The field
     * 'serviceType' has the following description: A service type
     * name from a registry of services. For example, the values of
     * the codeSpace URI and name and code string may be "OGC" and
     * "catalogue." This type name is normally used for
     * machine-to-machine communication. 
     * 
     * @param serviceType the value of field 'serviceType'.
     */
    public void setServiceType(nl.b3p.xml.ows.v100.serviceidentification.ServiceType serviceType)
    {
        this._serviceType = serviceType;
    } //-- void setServiceType(nl.b3p.xml.ows.v100.serviceidentification.ServiceType) 

    /**
     * Method setServiceTypeVersion
     * 
     * 
     * 
     * @param index
     * @param vServiceTypeVersion
     */
    public void setServiceTypeVersion(int index, java.lang.String vServiceTypeVersion)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _serviceTypeVersionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _serviceTypeVersionList.set(index, vServiceTypeVersion);
    } //-- void setServiceTypeVersion(int, java.lang.String) 

    /**
     * Method setServiceTypeVersion
     * 
     * 
     * 
     * @param serviceTypeVersionArray
     */
    public void setServiceTypeVersion(java.lang.String[] serviceTypeVersionArray)
    {
        //-- copy array
        _serviceTypeVersionList.clear();
        for (int i = 0; i < serviceTypeVersionArray.length; i++) {
            _serviceTypeVersionList.add(serviceTypeVersionArray[i]);
        }
    } //-- void setServiceTypeVersion(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return DescriptionType
     */
    public static nl.b3p.xml.ows.v100.serviceidentification.DescriptionType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.serviceidentification.DescriptionType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.serviceidentification.ServiceIdentification.class, reader);
    } //-- nl.b3p.xml.ows.v100.serviceidentification.DescriptionType unmarshal(java.io.Reader) 

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
