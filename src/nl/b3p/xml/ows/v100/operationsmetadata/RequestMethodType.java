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
 * Connect point URL and any constraints for this HTTP request
 * method for this operation request. In the OnlineResourceType,
 * the xlink:href attribute in the xlink:simpleLink attribute group
 * shall be used to contain this URL. The other attributes in the
 * xlink:simpleLink attribute group should not be used. 
 * 
 * @version $Revision$ $Date$
 */
public class RequestMethodType extends nl.b3p.xml.ows.v100.operationsmetadata.OnlineResourceType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Optional unordered list of valid domain constraints on
     * non-parameter quantities that each apply to this request
     * method for this operation. If one of these Constraint
     * elements has the same "name" attribute as a Constraint
     * element in the OperationsMetadata or Operation element, this
     * Constraint element shall override the other one for this
     * operation. The list of required and optional constraints for
     * this request method for this operation shall be specified in
     * the Implementation Specification for this service. 
     */
    private java.util.ArrayList _constraint_RequestMethodTypeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public RequestMethodType() 
     {
        super();
        _constraint_RequestMethodTypeList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.operationsmetadata.RequestMethodType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addConstraint_RequestMethodType
     * 
     * 
     * 
     * @param vConstraint_RequestMethodType
     */
    public void addConstraint_RequestMethodType(nl.b3p.xml.ows.v100.operationsmetadata.Constraint_RequestMethodType vConstraint_RequestMethodType)
        throws java.lang.IndexOutOfBoundsException
    {
        _constraint_RequestMethodTypeList.add(vConstraint_RequestMethodType);
    } //-- void addConstraint_RequestMethodType(nl.b3p.xml.ows.v100.operationsmetadata.Constraint_RequestMethodType) 

    /**
     * Method addConstraint_RequestMethodType
     * 
     * 
     * 
     * @param index
     * @param vConstraint_RequestMethodType
     */
    public void addConstraint_RequestMethodType(int index, nl.b3p.xml.ows.v100.operationsmetadata.Constraint_RequestMethodType vConstraint_RequestMethodType)
        throws java.lang.IndexOutOfBoundsException
    {
        _constraint_RequestMethodTypeList.add(index, vConstraint_RequestMethodType);
    } //-- void addConstraint_RequestMethodType(int, nl.b3p.xml.ows.v100.operationsmetadata.Constraint_RequestMethodType) 

    /**
     * Method clearConstraint_RequestMethodType
     * 
     */
    public void clearConstraint_RequestMethodType()
    {
        _constraint_RequestMethodTypeList.clear();
    } //-- void clearConstraint_RequestMethodType() 

    /**
     * Method enumerateConstraint_RequestMethodType
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateConstraint_RequestMethodType()
    {
        return Collections.enumeration(_constraint_RequestMethodTypeList);
    } //-- java.util.Enumeration enumerateConstraint_RequestMethodType() 

    /**
     * Method getConstraint_RequestMethodType
     * 
     * 
     * 
     * @param index
     * @return Constraint_RequestMethodType
     */
    public nl.b3p.xml.ows.v100.operationsmetadata.Constraint_RequestMethodType getConstraint_RequestMethodType(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _constraint_RequestMethodTypeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.operationsmetadata.Constraint_RequestMethodType) _constraint_RequestMethodTypeList.get(index);
    } //-- nl.b3p.xml.ows.v100.operationsmetadata.Constraint_RequestMethodType getConstraint_RequestMethodType(int) 

    /**
     * Method getConstraint_RequestMethodType
     * 
     * 
     * 
     * @return Constraint_RequestMethodType
     */
    public nl.b3p.xml.ows.v100.operationsmetadata.Constraint_RequestMethodType[] getConstraint_RequestMethodType()
    {
        int size = _constraint_RequestMethodTypeList.size();
        nl.b3p.xml.ows.v100.operationsmetadata.Constraint_RequestMethodType[] mArray = new nl.b3p.xml.ows.v100.operationsmetadata.Constraint_RequestMethodType[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.operationsmetadata.Constraint_RequestMethodType) _constraint_RequestMethodTypeList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.operationsmetadata.Constraint_RequestMethodType[] getConstraint_RequestMethodType() 

    /**
     * Method getConstraint_RequestMethodTypeCount
     * 
     * 
     * 
     * @return int
     */
    public int getConstraint_RequestMethodTypeCount()
    {
        return _constraint_RequestMethodTypeList.size();
    } //-- int getConstraint_RequestMethodTypeCount() 

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
     * Method removeConstraint_RequestMethodType
     * 
     * 
     * 
     * @param vConstraint_RequestMethodType
     * @return boolean
     */
    public boolean removeConstraint_RequestMethodType(nl.b3p.xml.ows.v100.operationsmetadata.Constraint_RequestMethodType vConstraint_RequestMethodType)
    {
        boolean removed = _constraint_RequestMethodTypeList.remove(vConstraint_RequestMethodType);
        return removed;
    } //-- boolean removeConstraint_RequestMethodType(nl.b3p.xml.ows.v100.operationsmetadata.Constraint_RequestMethodType) 

    /**
     * Method setConstraint_RequestMethodType
     * 
     * 
     * 
     * @param index
     * @param vConstraint_RequestMethodType
     */
    public void setConstraint_RequestMethodType(int index, nl.b3p.xml.ows.v100.operationsmetadata.Constraint_RequestMethodType vConstraint_RequestMethodType)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _constraint_RequestMethodTypeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _constraint_RequestMethodTypeList.set(index, vConstraint_RequestMethodType);
    } //-- void setConstraint_RequestMethodType(int, nl.b3p.xml.ows.v100.operationsmetadata.Constraint_RequestMethodType) 

    /**
     * Method setConstraint_RequestMethodType
     * 
     * 
     * 
     * @param constraint_RequestMethodTypeArray
     */
    public void setConstraint_RequestMethodType(nl.b3p.xml.ows.v100.operationsmetadata.Constraint_RequestMethodType[] constraint_RequestMethodTypeArray)
    {
        //-- copy array
        _constraint_RequestMethodTypeList.clear();
        for (int i = 0; i < constraint_RequestMethodTypeArray.length; i++) {
            _constraint_RequestMethodTypeList.add(constraint_RequestMethodTypeArray[i]);
        }
    } //-- void setConstraint_RequestMethodType(nl.b3p.xml.ows.v100.operationsmetadata.Constraint_RequestMethodType) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return OnlineResourceType
     */
    public static nl.b3p.xml.ows.v100.operationsmetadata.OnlineResourceType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.operationsmetadata.OnlineResourceType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.operationsmetadata.RequestMethodType.class, reader);
    } //-- nl.b3p.xml.ows.v100.operationsmetadata.OnlineResourceType unmarshal(java.io.Reader) 

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
