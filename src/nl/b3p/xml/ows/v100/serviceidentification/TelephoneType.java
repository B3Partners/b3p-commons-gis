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
 * Telephone numbers for contacting the responsible individual or
 * organization. 
 * 
 * @version $Revision$ $Date$
 */
public class TelephoneType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Telephone number by which individuals can speak to the
     * responsible organization or individual. 
     */
    private java.util.ArrayList _voiceList;

    /**
     * Telephone number of a facsimile machine for the responsible
     * organization or individual. 
     */
    private java.util.ArrayList _facsimileList;


      //----------------/
     //- Constructors -/
    //----------------/

    public TelephoneType() 
     {
        super();
        _voiceList = new java.util.ArrayList();
        _facsimileList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.serviceidentification.TelephoneType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addFacsimile
     * 
     * 
     * 
     * @param vFacsimile
     */
    public void addFacsimile(java.lang.String vFacsimile)
        throws java.lang.IndexOutOfBoundsException
    {
        _facsimileList.add(vFacsimile);
    } //-- void addFacsimile(java.lang.String) 

    /**
     * Method addFacsimile
     * 
     * 
     * 
     * @param index
     * @param vFacsimile
     */
    public void addFacsimile(int index, java.lang.String vFacsimile)
        throws java.lang.IndexOutOfBoundsException
    {
        _facsimileList.add(index, vFacsimile);
    } //-- void addFacsimile(int, java.lang.String) 

    /**
     * Method addVoice
     * 
     * 
     * 
     * @param vVoice
     */
    public void addVoice(java.lang.String vVoice)
        throws java.lang.IndexOutOfBoundsException
    {
        _voiceList.add(vVoice);
    } //-- void addVoice(java.lang.String) 

    /**
     * Method addVoice
     * 
     * 
     * 
     * @param index
     * @param vVoice
     */
    public void addVoice(int index, java.lang.String vVoice)
        throws java.lang.IndexOutOfBoundsException
    {
        _voiceList.add(index, vVoice);
    } //-- void addVoice(int, java.lang.String) 

    /**
     * Method clearFacsimile
     * 
     */
    public void clearFacsimile()
    {
        _facsimileList.clear();
    } //-- void clearFacsimile() 

    /**
     * Method clearVoice
     * 
     */
    public void clearVoice()
    {
        _voiceList.clear();
    } //-- void clearVoice() 

    /**
     * Method enumerateFacsimile
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateFacsimile()
    {
        return Collections.enumeration(_facsimileList);
    } //-- java.util.Enumeration enumerateFacsimile() 

    /**
     * Method enumerateVoice
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateVoice()
    {
        return Collections.enumeration(_voiceList);
    } //-- java.util.Enumeration enumerateVoice() 

    /**
     * Method getFacsimile
     * 
     * 
     * 
     * @param index
     * @return String
     */
    public java.lang.String getFacsimile(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _facsimileList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_facsimileList.get(index);
    } //-- java.lang.String getFacsimile(int) 

    /**
     * Method getFacsimile
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String[] getFacsimile()
    {
        int size = _facsimileList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_facsimileList.get(index);
        }
        return mArray;
    } //-- java.lang.String[] getFacsimile() 

    /**
     * Method getFacsimileCount
     * 
     * 
     * 
     * @return int
     */
    public int getFacsimileCount()
    {
        return _facsimileList.size();
    } //-- int getFacsimileCount() 

    /**
     * Method getVoice
     * 
     * 
     * 
     * @param index
     * @return String
     */
    public java.lang.String getVoice(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _voiceList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_voiceList.get(index);
    } //-- java.lang.String getVoice(int) 

    /**
     * Method getVoice
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String[] getVoice()
    {
        int size = _voiceList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_voiceList.get(index);
        }
        return mArray;
    } //-- java.lang.String[] getVoice() 

    /**
     * Method getVoiceCount
     * 
     * 
     * 
     * @return int
     */
    public int getVoiceCount()
    {
        return _voiceList.size();
    } //-- int getVoiceCount() 

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
     * Method removeFacsimile
     * 
     * 
     * 
     * @param vFacsimile
     * @return boolean
     */
    public boolean removeFacsimile(java.lang.String vFacsimile)
    {
        boolean removed = _facsimileList.remove(vFacsimile);
        return removed;
    } //-- boolean removeFacsimile(java.lang.String) 

    /**
     * Method removeVoice
     * 
     * 
     * 
     * @param vVoice
     * @return boolean
     */
    public boolean removeVoice(java.lang.String vVoice)
    {
        boolean removed = _voiceList.remove(vVoice);
        return removed;
    } //-- boolean removeVoice(java.lang.String) 

    /**
     * Method setFacsimile
     * 
     * 
     * 
     * @param index
     * @param vFacsimile
     */
    public void setFacsimile(int index, java.lang.String vFacsimile)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _facsimileList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _facsimileList.set(index, vFacsimile);
    } //-- void setFacsimile(int, java.lang.String) 

    /**
     * Method setFacsimile
     * 
     * 
     * 
     * @param facsimileArray
     */
    public void setFacsimile(java.lang.String[] facsimileArray)
    {
        //-- copy array
        _facsimileList.clear();
        for (int i = 0; i < facsimileArray.length; i++) {
            _facsimileList.add(facsimileArray[i]);
        }
    } //-- void setFacsimile(java.lang.String) 

    /**
     * Method setVoice
     * 
     * 
     * 
     * @param index
     * @param vVoice
     */
    public void setVoice(int index, java.lang.String vVoice)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _voiceList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _voiceList.set(index, vVoice);
    } //-- void setVoice(int, java.lang.String) 

    /**
     * Method setVoice
     * 
     * 
     * 
     * @param voiceArray
     */
    public void setVoice(java.lang.String[] voiceArray)
    {
        //-- copy array
        _voiceList.clear();
        for (int i = 0; i < voiceArray.length; i++) {
            _voiceList.add(voiceArray[i]);
        }
    } //-- void setVoice(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return TelephoneType
     */
    public static nl.b3p.xml.ows.v100.serviceidentification.TelephoneType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.serviceidentification.TelephoneType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.serviceidentification.TelephoneType.class, reader);
    } //-- nl.b3p.xml.ows.v100.serviceidentification.TelephoneType unmarshal(java.io.Reader) 

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
