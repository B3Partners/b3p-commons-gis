/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100.operationsmetadata;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Location of the responsible individual or organization. 
 * 
 * @version $Revision$ $Date$
 */
public class AddressType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Address line for the location. 
     */
    private java.util.ArrayList _deliveryPointList;

    /**
     * City of the location. 
     */
    private java.lang.String _city;

    /**
     * State or province of the location. 
     */
    private java.lang.String _administrativeArea;

    /**
     * ZIP or other postal code. 
     */
    private java.lang.String _postalCode;

    /**
     * Country of the physical address. 
     */
    private java.lang.String _country;

    /**
     * Address of the electronic mailbox of the responsible
     * organization or individual. 
     */
    private java.util.ArrayList _electronicMailAddressList;


      //----------------/
     //- Constructors -/
    //----------------/

    public AddressType() 
     {
        super();
        _deliveryPointList = new java.util.ArrayList();
        _electronicMailAddressList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.operationsmetadata.AddressType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addDeliveryPoint
     * 
     * 
     * 
     * @param vDeliveryPoint
     */
    public void addDeliveryPoint(java.lang.String vDeliveryPoint)
        throws java.lang.IndexOutOfBoundsException
    {
        _deliveryPointList.add(vDeliveryPoint);
    } //-- void addDeliveryPoint(java.lang.String) 

    /**
     * Method addDeliveryPoint
     * 
     * 
     * 
     * @param index
     * @param vDeliveryPoint
     */
    public void addDeliveryPoint(int index, java.lang.String vDeliveryPoint)
        throws java.lang.IndexOutOfBoundsException
    {
        _deliveryPointList.add(index, vDeliveryPoint);
    } //-- void addDeliveryPoint(int, java.lang.String) 

    /**
     * Method addElectronicMailAddress
     * 
     * 
     * 
     * @param vElectronicMailAddress
     */
    public void addElectronicMailAddress(java.lang.String vElectronicMailAddress)
        throws java.lang.IndexOutOfBoundsException
    {
        _electronicMailAddressList.add(vElectronicMailAddress);
    } //-- void addElectronicMailAddress(java.lang.String) 

    /**
     * Method addElectronicMailAddress
     * 
     * 
     * 
     * @param index
     * @param vElectronicMailAddress
     */
    public void addElectronicMailAddress(int index, java.lang.String vElectronicMailAddress)
        throws java.lang.IndexOutOfBoundsException
    {
        _electronicMailAddressList.add(index, vElectronicMailAddress);
    } //-- void addElectronicMailAddress(int, java.lang.String) 

    /**
     * Method clearDeliveryPoint
     * 
     */
    public void clearDeliveryPoint()
    {
        _deliveryPointList.clear();
    } //-- void clearDeliveryPoint() 

    /**
     * Method clearElectronicMailAddress
     * 
     */
    public void clearElectronicMailAddress()
    {
        _electronicMailAddressList.clear();
    } //-- void clearElectronicMailAddress() 

    /**
     * Method enumerateDeliveryPoint
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateDeliveryPoint()
    {
        return Collections.enumeration(_deliveryPointList);
    } //-- java.util.Enumeration enumerateDeliveryPoint() 

    /**
     * Method enumerateElectronicMailAddress
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateElectronicMailAddress()
    {
        return Collections.enumeration(_electronicMailAddressList);
    } //-- java.util.Enumeration enumerateElectronicMailAddress() 

    /**
     * Returns the value of field 'administrativeArea'. The field
     * 'administrativeArea' has the following description: State or
     * province of the location. 
     * 
     * @return String
     * @return the value of field 'administrativeArea'.
     */
    public java.lang.String getAdministrativeArea()
    {
        return this._administrativeArea;
    } //-- java.lang.String getAdministrativeArea() 

    /**
     * Returns the value of field 'city'. The field 'city' has the
     * following description: City of the location. 
     * 
     * @return String
     * @return the value of field 'city'.
     */
    public java.lang.String getCity()
    {
        return this._city;
    } //-- java.lang.String getCity() 

    /**
     * Returns the value of field 'country'. The field 'country'
     * has the following description: Country of the physical
     * address. 
     * 
     * @return String
     * @return the value of field 'country'.
     */
    public java.lang.String getCountry()
    {
        return this._country;
    } //-- java.lang.String getCountry() 

    /**
     * Method getDeliveryPoint
     * 
     * 
     * 
     * @param index
     * @return String
     */
    public java.lang.String getDeliveryPoint(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _deliveryPointList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_deliveryPointList.get(index);
    } //-- java.lang.String getDeliveryPoint(int) 

    /**
     * Method getDeliveryPoint
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String[] getDeliveryPoint()
    {
        int size = _deliveryPointList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_deliveryPointList.get(index);
        }
        return mArray;
    } //-- java.lang.String[] getDeliveryPoint() 

    /**
     * Method getDeliveryPointCount
     * 
     * 
     * 
     * @return int
     */
    public int getDeliveryPointCount()
    {
        return _deliveryPointList.size();
    } //-- int getDeliveryPointCount() 

    /**
     * Method getElectronicMailAddress
     * 
     * 
     * 
     * @param index
     * @return String
     */
    public java.lang.String getElectronicMailAddress(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _electronicMailAddressList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_electronicMailAddressList.get(index);
    } //-- java.lang.String getElectronicMailAddress(int) 

    /**
     * Method getElectronicMailAddress
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String[] getElectronicMailAddress()
    {
        int size = _electronicMailAddressList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_electronicMailAddressList.get(index);
        }
        return mArray;
    } //-- java.lang.String[] getElectronicMailAddress() 

    /**
     * Method getElectronicMailAddressCount
     * 
     * 
     * 
     * @return int
     */
    public int getElectronicMailAddressCount()
    {
        return _electronicMailAddressList.size();
    } //-- int getElectronicMailAddressCount() 

    /**
     * Returns the value of field 'postalCode'. The field
     * 'postalCode' has the following description: ZIP or other
     * postal code. 
     * 
     * @return String
     * @return the value of field 'postalCode'.
     */
    public java.lang.String getPostalCode()
    {
        return this._postalCode;
    } //-- java.lang.String getPostalCode() 

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
     * Method removeDeliveryPoint
     * 
     * 
     * 
     * @param vDeliveryPoint
     * @return boolean
     */
    public boolean removeDeliveryPoint(java.lang.String vDeliveryPoint)
    {
        boolean removed = _deliveryPointList.remove(vDeliveryPoint);
        return removed;
    } //-- boolean removeDeliveryPoint(java.lang.String) 

    /**
     * Method removeElectronicMailAddress
     * 
     * 
     * 
     * @param vElectronicMailAddress
     * @return boolean
     */
    public boolean removeElectronicMailAddress(java.lang.String vElectronicMailAddress)
    {
        boolean removed = _electronicMailAddressList.remove(vElectronicMailAddress);
        return removed;
    } //-- boolean removeElectronicMailAddress(java.lang.String) 

    /**
     * Sets the value of field 'administrativeArea'. The field
     * 'administrativeArea' has the following description: State or
     * province of the location. 
     * 
     * @param administrativeArea the value of field
     * 'administrativeArea'.
     */
    public void setAdministrativeArea(java.lang.String administrativeArea)
    {
        this._administrativeArea = administrativeArea;
    } //-- void setAdministrativeArea(java.lang.String) 

    /**
     * Sets the value of field 'city'. The field 'city' has the
     * following description: City of the location. 
     * 
     * @param city the value of field 'city'.
     */
    public void setCity(java.lang.String city)
    {
        this._city = city;
    } //-- void setCity(java.lang.String) 

    /**
     * Sets the value of field 'country'. The field 'country' has
     * the following description: Country of the physical address. 
     * 
     * @param country the value of field 'country'.
     */
    public void setCountry(java.lang.String country)
    {
        this._country = country;
    } //-- void setCountry(java.lang.String) 

    /**
     * Method setDeliveryPoint
     * 
     * 
     * 
     * @param index
     * @param vDeliveryPoint
     */
    public void setDeliveryPoint(int index, java.lang.String vDeliveryPoint)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _deliveryPointList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _deliveryPointList.set(index, vDeliveryPoint);
    } //-- void setDeliveryPoint(int, java.lang.String) 

    /**
     * Method setDeliveryPoint
     * 
     * 
     * 
     * @param deliveryPointArray
     */
    public void setDeliveryPoint(java.lang.String[] deliveryPointArray)
    {
        //-- copy array
        _deliveryPointList.clear();
        for (int i = 0; i < deliveryPointArray.length; i++) {
            _deliveryPointList.add(deliveryPointArray[i]);
        }
    } //-- void setDeliveryPoint(java.lang.String) 

    /**
     * Method setElectronicMailAddress
     * 
     * 
     * 
     * @param index
     * @param vElectronicMailAddress
     */
    public void setElectronicMailAddress(int index, java.lang.String vElectronicMailAddress)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _electronicMailAddressList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _electronicMailAddressList.set(index, vElectronicMailAddress);
    } //-- void setElectronicMailAddress(int, java.lang.String) 

    /**
     * Method setElectronicMailAddress
     * 
     * 
     * 
     * @param electronicMailAddressArray
     */
    public void setElectronicMailAddress(java.lang.String[] electronicMailAddressArray)
    {
        //-- copy array
        _electronicMailAddressList.clear();
        for (int i = 0; i < electronicMailAddressArray.length; i++) {
            _electronicMailAddressList.add(electronicMailAddressArray[i]);
        }
    } //-- void setElectronicMailAddress(java.lang.String) 

    /**
     * Sets the value of field 'postalCode'. The field 'postalCode'
     * has the following description: ZIP or other postal code. 
     * 
     * @param postalCode the value of field 'postalCode'.
     */
    public void setPostalCode(java.lang.String postalCode)
    {
        this._postalCode = postalCode;
    } //-- void setPostalCode(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return AddressType
     */
    public static nl.b3p.xml.ows.v100.operationsmetadata.AddressType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.operationsmetadata.AddressType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.operationsmetadata.AddressType.class, reader);
    } //-- nl.b3p.xml.ows.v100.operationsmetadata.AddressType unmarshal(java.io.Reader) 

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
