/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v100.exception;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * The ServiceExceptionReport element contains one
 *  or more ServiceException elements that describe
 *  a service exception.
 *  
 * 
 * @version $Revision$ $Date$
 */
public class ServiceExceptionReport implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _version
     */
    private java.lang.String _version = "1.2.0";

    /**
     * The Service exception element is used to describe 
     *  a service exception.
     *  
     */
    private java.util.ArrayList _serviceExceptionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ServiceExceptionReport() 
     {
        super();
        setVersion("1.2.0");
        _serviceExceptionList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addServiceException
     * 
     * 
     * 
     * @param vServiceException
     */
    public void addServiceException(nl.b3p.xml.ogc.v100.exception.ServiceException vServiceException)
        throws java.lang.IndexOutOfBoundsException
    {
        _serviceExceptionList.add(vServiceException);
    } //-- void addServiceException(nl.b3p.xml.ogc.v100.exception.ServiceException) 

    /**
     * Method addServiceException
     * 
     * 
     * 
     * @param index
     * @param vServiceException
     */
    public void addServiceException(int index, nl.b3p.xml.ogc.v100.exception.ServiceException vServiceException)
        throws java.lang.IndexOutOfBoundsException
    {
        _serviceExceptionList.add(index, vServiceException);
    } //-- void addServiceException(int, nl.b3p.xml.ogc.v100.exception.ServiceException) 

    /**
     * Method clearServiceException
     * 
     */
    public void clearServiceException()
    {
        _serviceExceptionList.clear();
    } //-- void clearServiceException() 

    /**
     * Method enumerateServiceException
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateServiceException()
    {
        return Collections.enumeration(_serviceExceptionList);
    } //-- java.util.Enumeration enumerateServiceException() 

    /**
     * Method getServiceException
     * 
     * 
     * 
     * @param index
     * @return ServiceException
     */
    public nl.b3p.xml.ogc.v100.exception.ServiceException getServiceException(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _serviceExceptionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ogc.v100.exception.ServiceException) _serviceExceptionList.get(index);
    } //-- nl.b3p.xml.ogc.v100.exception.ServiceException getServiceException(int) 

    /**
     * Method getServiceException
     * 
     * 
     * 
     * @return ServiceException
     */
    public nl.b3p.xml.ogc.v100.exception.ServiceException[] getServiceException()
    {
        int size = _serviceExceptionList.size();
        nl.b3p.xml.ogc.v100.exception.ServiceException[] mArray = new nl.b3p.xml.ogc.v100.exception.ServiceException[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ogc.v100.exception.ServiceException) _serviceExceptionList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ogc.v100.exception.ServiceException[] getServiceException() 

    /**
     * Method getServiceExceptionCount
     * 
     * 
     * 
     * @return int
     */
    public int getServiceExceptionCount()
    {
        return _serviceExceptionList.size();
    } //-- int getServiceExceptionCount() 

    /**
     * Returns the value of field 'version'.
     * 
     * @return String
     * @return the value of field 'version'.
     */
    public java.lang.String getVersion()
    {
        return this._version;
    } //-- java.lang.String getVersion() 

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
     * Method removeServiceException
     * 
     * 
     * 
     * @param vServiceException
     * @return boolean
     */
    public boolean removeServiceException(nl.b3p.xml.ogc.v100.exception.ServiceException vServiceException)
    {
        boolean removed = _serviceExceptionList.remove(vServiceException);
        return removed;
    } //-- boolean removeServiceException(nl.b3p.xml.ogc.v100.exception.ServiceException) 

    /**
     * Method setServiceException
     * 
     * 
     * 
     * @param index
     * @param vServiceException
     */
    public void setServiceException(int index, nl.b3p.xml.ogc.v100.exception.ServiceException vServiceException)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _serviceExceptionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _serviceExceptionList.set(index, vServiceException);
    } //-- void setServiceException(int, nl.b3p.xml.ogc.v100.exception.ServiceException) 

    /**
     * Method setServiceException
     * 
     * 
     * 
     * @param serviceExceptionArray
     */
    public void setServiceException(nl.b3p.xml.ogc.v100.exception.ServiceException[] serviceExceptionArray)
    {
        //-- copy array
        _serviceExceptionList.clear();
        for (int i = 0; i < serviceExceptionArray.length; i++) {
            _serviceExceptionList.add(serviceExceptionArray[i]);
        }
    } //-- void setServiceException(nl.b3p.xml.ogc.v100.exception.ServiceException) 

    /**
     * Sets the value of field 'version'.
     * 
     * @param version the value of field 'version'.
     */
    public void setVersion(java.lang.String version)
    {
        this._version = version;
    } //-- void setVersion(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return ServiceExceptionReport
     */
    public static nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport.class, reader);
    } //-- nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport unmarshal(java.io.Reader) 

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
