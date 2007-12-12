/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100;

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
public class RequestMethodType extends nl.b3p.xml.ows.v100.OnlineResourceType 
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
    private java.util.ArrayList _constraintList;


      //----------------/
     //- Constructors -/
    //----------------/

    public RequestMethodType() 
     {
        super();
        _constraintList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.RequestMethodType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addConstraint
     * 
     * 
     * 
     * @param vConstraint
     */
    public void addConstraint(nl.b3p.xml.ows.v100.Constraint vConstraint)
        throws java.lang.IndexOutOfBoundsException
    {
        _constraintList.add(vConstraint);
    } //-- void addConstraint(nl.b3p.xml.ows.v100.Constraint) 

    /**
     * Method addConstraint
     * 
     * 
     * 
     * @param index
     * @param vConstraint
     */
    public void addConstraint(int index, nl.b3p.xml.ows.v100.Constraint vConstraint)
        throws java.lang.IndexOutOfBoundsException
    {
        _constraintList.add(index, vConstraint);
    } //-- void addConstraint(int, nl.b3p.xml.ows.v100.Constraint) 

    /**
     * Method clearConstraint
     * 
     */
    public void clearConstraint()
    {
        _constraintList.clear();
    } //-- void clearConstraint() 

    /**
     * Method enumerateConstraint
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateConstraint()
    {
        return Collections.enumeration(_constraintList);
    } //-- java.util.Enumeration enumerateConstraint() 

    /**
     * Method getConstraint
     * 
     * 
     * 
     * @param index
     * @return Constraint
     */
    public nl.b3p.xml.ows.v100.Constraint getConstraint(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _constraintList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.Constraint) _constraintList.get(index);
    } //-- nl.b3p.xml.ows.v100.Constraint getConstraint(int) 

    /**
     * Method getConstraint
     * 
     * 
     * 
     * @return Constraint
     */
    public nl.b3p.xml.ows.v100.Constraint[] getConstraint()
    {
        int size = _constraintList.size();
        nl.b3p.xml.ows.v100.Constraint[] mArray = new nl.b3p.xml.ows.v100.Constraint[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.Constraint) _constraintList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.Constraint[] getConstraint() 

    /**
     * Method getConstraintCount
     * 
     * 
     * 
     * @return int
     */
    public int getConstraintCount()
    {
        return _constraintList.size();
    } //-- int getConstraintCount() 

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
     * Method removeConstraint
     * 
     * 
     * 
     * @param vConstraint
     * @return boolean
     */
    public boolean removeConstraint(nl.b3p.xml.ows.v100.Constraint vConstraint)
    {
        boolean removed = _constraintList.remove(vConstraint);
        return removed;
    } //-- boolean removeConstraint(nl.b3p.xml.ows.v100.Constraint) 

    /**
     * Method setConstraint
     * 
     * 
     * 
     * @param index
     * @param vConstraint
     */
    public void setConstraint(int index, nl.b3p.xml.ows.v100.Constraint vConstraint)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _constraintList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _constraintList.set(index, vConstraint);
    } //-- void setConstraint(int, nl.b3p.xml.ows.v100.Constraint) 

    /**
     * Method setConstraint
     * 
     * 
     * 
     * @param constraintArray
     */
    public void setConstraint(nl.b3p.xml.ows.v100.Constraint[] constraintArray)
    {
        //-- copy array
        _constraintList.clear();
        for (int i = 0; i < constraintArray.length; i++) {
            _constraintList.add(constraintArray[i]);
        }
    } //-- void setConstraint(nl.b3p.xml.ows.v100.Constraint) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return OnlineResourceType
     */
    public static nl.b3p.xml.ows.v100.OnlineResourceType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.OnlineResourceType) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.RequestMethodType.class, reader);
    } //-- nl.b3p.xml.ows.v100.OnlineResourceType unmarshal(java.io.Reader) 

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
