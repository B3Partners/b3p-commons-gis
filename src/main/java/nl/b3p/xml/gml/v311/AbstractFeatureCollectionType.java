/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.gml.v311;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;

/**
 * Class AbstractFeatureCollectionType.
 * 
 * @version $Revision$ $Date$
 */
public abstract class AbstractFeatureCollectionType extends nl.b3p.xml.gml.v311.AbstractFeatureType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _featureMemberList
     */
    private java.util.ArrayList _featureMemberList;

    /**
     * Field _featureMembers
     */
    private java.lang.Object _featureMembers;


      //----------------/
     //- Constructors -/
    //----------------/

    public AbstractFeatureCollectionType() 
     {
        super();
        _featureMemberList = new java.util.ArrayList();
    } //-- nl.b3p.xml.gml.v311.AbstractFeatureCollectionType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addFeatureMember
     * 
     * 
     * 
     * @param vFeatureMember
     */
    public void addFeatureMember(java.lang.Object vFeatureMember)
        throws java.lang.IndexOutOfBoundsException
    {
        _featureMemberList.add(vFeatureMember);
    } //-- void addFeatureMember(java.lang.Object) 

    /**
     * Method addFeatureMember
     * 
     * 
     * 
     * @param index
     * @param vFeatureMember
     */
    public void addFeatureMember(int index, java.lang.Object vFeatureMember)
        throws java.lang.IndexOutOfBoundsException
    {
        _featureMemberList.add(index, vFeatureMember);
    } //-- void addFeatureMember(int, java.lang.Object) 

    /**
     * Method clearFeatureMember
     * 
     */
    public void clearFeatureMember()
    {
        _featureMemberList.clear();
    } //-- void clearFeatureMember() 

    /**
     * Method enumerateFeatureMember
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateFeatureMember()
    {
        return Collections.enumeration(_featureMemberList);
    } //-- java.util.Enumeration enumerateFeatureMember() 

    /**
     * Method getFeatureMember
     * 
     * 
     * 
     * @param index
     * @return Object
     */
    public java.lang.Object getFeatureMember(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _featureMemberList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (java.lang.Object) _featureMemberList.get(index);
    } //-- java.lang.Object getFeatureMember(int) 

    /**
     * Method getFeatureMember
     * 
     * 
     * 
     * @return Object
     */
    public java.lang.Object[] getFeatureMember()
    {
        int size = _featureMemberList.size();
        java.lang.Object[] mArray = new java.lang.Object[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (java.lang.Object) _featureMemberList.get(index);
        }
        return mArray;
    } //-- java.lang.Object[] getFeatureMember() 

    /**
     * Method getFeatureMemberCount
     * 
     * 
     * 
     * @return int
     */
    public int getFeatureMemberCount()
    {
        return _featureMemberList.size();
    } //-- int getFeatureMemberCount() 

    /**
     * Returns the value of field 'featureMembers'.
     * 
     * @return Object
     * @return the value of field 'featureMembers'.
     */
    public java.lang.Object getFeatureMembers()
    {
        return this._featureMembers;
    } //-- java.lang.Object getFeatureMembers() 

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
     * Method removeFeatureMember
     * 
     * 
     * 
     * @param vFeatureMember
     * @return boolean
     */
    public boolean removeFeatureMember(java.lang.Object vFeatureMember)
    {
        boolean removed = _featureMemberList.remove(vFeatureMember);
        return removed;
    } //-- boolean removeFeatureMember(java.lang.Object) 

    /**
     * Method setFeatureMember
     * 
     * 
     * 
     * @param index
     * @param vFeatureMember
     */
    public void setFeatureMember(int index, java.lang.Object vFeatureMember)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _featureMemberList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _featureMemberList.set(index, vFeatureMember);
    } //-- void setFeatureMember(int, java.lang.Object) 

    /**
     * Method setFeatureMember
     * 
     * 
     * 
     * @param featureMemberArray
     */
    public void setFeatureMember(java.lang.Object[] featureMemberArray)
    {
        //-- copy array
        _featureMemberList.clear();
        for (int i = 0; i < featureMemberArray.length; i++) {
            _featureMemberList.add(featureMemberArray[i]);
        }
    } //-- void setFeatureMember(java.lang.Object) 

    /**
     * Sets the value of field 'featureMembers'.
     * 
     * @param featureMembers the value of field 'featureMembers'.
     */
    public void setFeatureMembers(java.lang.Object featureMembers)
    {
        this._featureMembers = featureMembers;
    } //-- void setFeatureMembers(java.lang.Object) 

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
