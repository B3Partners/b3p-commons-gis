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
 * Unordered list of zero or more names of requested sections in
 * complete service metadata document. Each Section value shall
 * contain an allowed section name as specified by each OWS
 * specification. See Sections parameter subclause for more
 * information. 
 * 
 * @version $Revision$ $Date$
 */
public class SectionsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _sectionList
     */
    private java.util.ArrayList _sectionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SectionsType() 
     {
        super();
        _sectionList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.capabilities.SectionsType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addSection
     * 
     * 
     * 
     * @param vSection
     */
    public void addSection(java.lang.String vSection)
        throws java.lang.IndexOutOfBoundsException
    {
        _sectionList.add(vSection);
    } //-- void addSection(java.lang.String) 

    /**
     * Method addSection
     * 
     * 
     * 
     * @param index
     * @param vSection
     */
    public void addSection(int index, java.lang.String vSection)
        throws java.lang.IndexOutOfBoundsException
    {
        _sectionList.add(index, vSection);
    } //-- void addSection(int, java.lang.String) 

    /**
     * Method clearSection
     * 
     */
    public void clearSection()
    {
        _sectionList.clear();
    } //-- void clearSection() 

    /**
     * Method enumerateSection
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateSection()
    {
        return Collections.enumeration(_sectionList);
    } //-- java.util.Enumeration enumerateSection() 

    /**
     * Method getSection
     * 
     * 
     * 
     * @param index
     * @return String
     */
    public java.lang.String getSection(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _sectionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_sectionList.get(index);
    } //-- java.lang.String getSection(int) 

    /**
     * Method getSection
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String[] getSection()
    {
        int size = _sectionList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_sectionList.get(index);
        }
        return mArray;
    } //-- java.lang.String[] getSection() 

    /**
     * Method getSectionCount
     * 
     * 
     * 
     * @return int
     */
    public int getSectionCount()
    {
        return _sectionList.size();
    } //-- int getSectionCount() 

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
     * Method removeSection
     * 
     * 
     * 
     * @param vSection
     * @return boolean
     */
    public boolean removeSection(java.lang.String vSection)
    {
        boolean removed = _sectionList.remove(vSection);
        return removed;
    } //-- boolean removeSection(java.lang.String) 

    /**
     * Method setSection
     * 
     * 
     * 
     * @param index
     * @param vSection
     */
    public void setSection(int index, java.lang.String vSection)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _sectionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _sectionList.set(index, vSection);
    } //-- void setSection(int, java.lang.String) 

    /**
     * Method setSection
     * 
     * 
     * 
     * @param sectionArray
     */
    public void setSection(java.lang.String[] sectionArray)
    {
        //-- copy array
        _sectionList.clear();
        for (int i = 0; i < sectionArray.length; i++) {
            _sectionList.add(sectionArray[i]);
        }
    } //-- void setSection(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return SectionsType
     */
    public static nl.b3p.xml.ows.v100.capabilities.SectionsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.capabilities.SectionsType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.capabilities.SectionsType.class, reader);
    } //-- nl.b3p.xml.ows.v100.capabilities.SectionsType unmarshal(java.io.Reader) 

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
