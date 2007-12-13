/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v110;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class OutputFormatListType.
 * 
 * @version $Revision$ $Date$
 */
public class OutputFormatListType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items
     */
    private java.util.ArrayList _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public OutputFormatListType() 
     {
        super();
        _items = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v110.OutputFormatListType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addOutputFormatListTypeItem
     * 
     * 
     * 
     * @param vOutputFormatListTypeItem
     */
    public void addOutputFormatListTypeItem(nl.b3p.xml.wfs.v110.OutputFormatListTypeItem vOutputFormatListTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vOutputFormatListTypeItem);
    } //-- void addOutputFormatListTypeItem(nl.b3p.xml.wfs.v110.OutputFormatListTypeItem) 

    /**
     * Method addOutputFormatListTypeItem
     * 
     * 
     * 
     * @param index
     * @param vOutputFormatListTypeItem
     */
    public void addOutputFormatListTypeItem(int index, nl.b3p.xml.wfs.v110.OutputFormatListTypeItem vOutputFormatListTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vOutputFormatListTypeItem);
    } //-- void addOutputFormatListTypeItem(int, nl.b3p.xml.wfs.v110.OutputFormatListTypeItem) 

    /**
     * Method clearOutputFormatListTypeItem
     * 
     */
    public void clearOutputFormatListTypeItem()
    {
        _items.clear();
    } //-- void clearOutputFormatListTypeItem() 

    /**
     * Method enumerateOutputFormatListTypeItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateOutputFormatListTypeItem()
    {
        return Collections.enumeration(_items);
    } //-- java.util.Enumeration enumerateOutputFormatListTypeItem() 

    /**
     * Method getOutputFormatListTypeItem
     * 
     * 
     * 
     * @param index
     * @return OutputFormatListTypeItem
     */
    public nl.b3p.xml.wfs.v110.OutputFormatListTypeItem getOutputFormatListTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v110.OutputFormatListTypeItem) _items.get(index);
    } //-- nl.b3p.xml.wfs.v110.OutputFormatListTypeItem getOutputFormatListTypeItem(int) 

    /**
     * Method getOutputFormatListTypeItem
     * 
     * 
     * 
     * @return OutputFormatListTypeItem
     */
    public nl.b3p.xml.wfs.v110.OutputFormatListTypeItem[] getOutputFormatListTypeItem()
    {
        int size = _items.size();
        nl.b3p.xml.wfs.v110.OutputFormatListTypeItem[] mArray = new nl.b3p.xml.wfs.v110.OutputFormatListTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v110.OutputFormatListTypeItem) _items.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v110.OutputFormatListTypeItem[] getOutputFormatListTypeItem() 

    /**
     * Method getOutputFormatListTypeItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getOutputFormatListTypeItemCount()
    {
        return _items.size();
    } //-- int getOutputFormatListTypeItemCount() 

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
     * Method removeOutputFormatListTypeItem
     * 
     * 
     * 
     * @param vOutputFormatListTypeItem
     * @return boolean
     */
    public boolean removeOutputFormatListTypeItem(nl.b3p.xml.wfs.v110.OutputFormatListTypeItem vOutputFormatListTypeItem)
    {
        boolean removed = _items.remove(vOutputFormatListTypeItem);
        return removed;
    } //-- boolean removeOutputFormatListTypeItem(nl.b3p.xml.wfs.v110.OutputFormatListTypeItem) 

    /**
     * Method setOutputFormatListTypeItem
     * 
     * 
     * 
     * @param index
     * @param vOutputFormatListTypeItem
     */
    public void setOutputFormatListTypeItem(int index, nl.b3p.xml.wfs.v110.OutputFormatListTypeItem vOutputFormatListTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vOutputFormatListTypeItem);
    } //-- void setOutputFormatListTypeItem(int, nl.b3p.xml.wfs.v110.OutputFormatListTypeItem) 

    /**
     * Method setOutputFormatListTypeItem
     * 
     * 
     * 
     * @param outputFormatListTypeItemArray
     */
    public void setOutputFormatListTypeItem(nl.b3p.xml.wfs.v110.OutputFormatListTypeItem[] outputFormatListTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < outputFormatListTypeItemArray.length; i++) {
            _items.add(outputFormatListTypeItemArray[i]);
        }
    } //-- void setOutputFormatListTypeItem(nl.b3p.xml.wfs.v110.OutputFormatListTypeItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return OutputFormatListType
     */
    public static nl.b3p.xml.wfs.v110.OutputFormatListType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.OutputFormatListType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.OutputFormatListType.class, reader);
    } //-- nl.b3p.xml.wfs.v110.OutputFormatListType unmarshal(java.io.Reader) 

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
