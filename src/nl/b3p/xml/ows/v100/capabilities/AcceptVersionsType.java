/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100.capabilities;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Prioritized sequence of one or more specification versions
 * accepted by client, with preferred versions listed first. See
 * Version negotiation subclause for more information. 
 * 
 * @version $Revision$ $Date$
 */
public class AcceptVersionsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _versionList
     */
    private java.util.ArrayList _versionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public AcceptVersionsType() 
     {
        super();
        _versionList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.capabilities.AcceptVersionsType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addVersion
     * 
     * 
     * 
     * @param vVersion
     */
    public void addVersion(java.lang.String vVersion)
        throws java.lang.IndexOutOfBoundsException
    {
        _versionList.add(vVersion);
    } //-- void addVersion(java.lang.String) 

    /**
     * Method addVersion
     * 
     * 
     * 
     * @param index
     * @param vVersion
     */
    public void addVersion(int index, java.lang.String vVersion)
        throws java.lang.IndexOutOfBoundsException
    {
        _versionList.add(index, vVersion);
    } //-- void addVersion(int, java.lang.String) 

    /**
     * Method clearVersion
     * 
     */
    public void clearVersion()
    {
        _versionList.clear();
    } //-- void clearVersion() 

    /**
     * Method enumerateVersion
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateVersion()
    {
        return Collections.enumeration(_versionList);
    } //-- java.util.Enumeration enumerateVersion() 

    /**
     * Method getVersion
     * 
     * 
     * 
     * @param index
     * @return String
     */
    public java.lang.String getVersion(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _versionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_versionList.get(index);
    } //-- java.lang.String getVersion(int) 

    /**
     * Method getVersion
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String[] getVersion()
    {
        int size = _versionList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_versionList.get(index);
        }
        return mArray;
    } //-- java.lang.String[] getVersion() 

    /**
     * Method getVersionCount
     * 
     * 
     * 
     * @return int
     */
    public int getVersionCount()
    {
        return _versionList.size();
    } //-- int getVersionCount() 

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
     * Method removeVersion
     * 
     * 
     * 
     * @param vVersion
     * @return boolean
     */
    public boolean removeVersion(java.lang.String vVersion)
    {
        boolean removed = _versionList.remove(vVersion);
        return removed;
    } //-- boolean removeVersion(java.lang.String) 

    /**
     * Method setVersion
     * 
     * 
     * 
     * @param index
     * @param vVersion
     */
    public void setVersion(int index, java.lang.String vVersion)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _versionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _versionList.set(index, vVersion);
    } //-- void setVersion(int, java.lang.String) 

    /**
     * Method setVersion
     * 
     * 
     * 
     * @param versionArray
     */
    public void setVersion(java.lang.String[] versionArray)
    {
        //-- copy array
        _versionList.clear();
        for (int i = 0; i < versionArray.length; i++) {
            _versionList.add(versionArray[i]);
        }
    } //-- void setVersion(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return AcceptVersionsType
     */
    public static nl.b3p.xml.ows.v100.capabilities.AcceptVersionsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.capabilities.AcceptVersionsType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.capabilities.AcceptVersionsType.class, reader);
    } //-- nl.b3p.xml.ows.v100.capabilities.AcceptVersionsType unmarshal(java.io.Reader) 

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
