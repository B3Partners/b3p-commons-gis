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
 * Metadata about the operations and related abilities specified by
 * this service and implemented by this server, including the URLs
 * for operation requests. The basic contents of this section shall
 * be the same for all OWS types, but individual services can add
 * elements and/or change the optionality of optional elements. 
 * 
 * @version $Revision$ $Date$
 */
public class OperationsMetadata implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Metadata for unordered list of all the (requests for)
     * operations that this server interface implements. The list
     * of required and optional operations implemented shall be
     * specified in the Implementation Specification for this
     * service. 
     */
    private java.util.ArrayList _operationList;

    /**
     * Optional unordered list of parameter valid domains that each
     * apply to one or more operations which this server interface
     * implements. The list of required and optional parameter
     * domain limitations shall be specified in the Implementation
     * Specification for this service. 
     */
    private java.util.ArrayList _parameterList;

    /**
     * Optional unordered list of valid domain constraints on
     * non-parameter quantities that each apply to this server. The
     * list of required and optional constraints shall be specified
     * in the Implementation Specification for this service. 
     */
    private java.util.ArrayList _constraintList;

    /**
     * Individual software vendors and servers can use this element
     * to provide metadata about any additional server abilities. 
     */
    private java.lang.Object _extendedCapabilities;


      //----------------/
     //- Constructors -/
    //----------------/

    public OperationsMetadata() 
     {
        super();
        _operationList = new java.util.ArrayList();
        _parameterList = new java.util.ArrayList();
        _constraintList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.OperationsMetadata()


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
     * Method addOperation
     * 
     * 
     * 
     * @param vOperation
     */
    public void addOperation(nl.b3p.xml.ows.v100.Operation vOperation)
        throws java.lang.IndexOutOfBoundsException
    {
        _operationList.add(vOperation);
    } //-- void addOperation(nl.b3p.xml.ows.v100.Operation) 

    /**
     * Method addOperation
     * 
     * 
     * 
     * @param index
     * @param vOperation
     */
    public void addOperation(int index, nl.b3p.xml.ows.v100.Operation vOperation)
        throws java.lang.IndexOutOfBoundsException
    {
        _operationList.add(index, vOperation);
    } //-- void addOperation(int, nl.b3p.xml.ows.v100.Operation) 

    /**
     * Method addParameter
     * 
     * 
     * 
     * @param vParameter
     */
    public void addParameter(nl.b3p.xml.ows.v100.Parameter vParameter)
        throws java.lang.IndexOutOfBoundsException
    {
        _parameterList.add(vParameter);
    } //-- void addParameter(nl.b3p.xml.ows.v100.Parameter) 

    /**
     * Method addParameter
     * 
     * 
     * 
     * @param index
     * @param vParameter
     */
    public void addParameter(int index, nl.b3p.xml.ows.v100.Parameter vParameter)
        throws java.lang.IndexOutOfBoundsException
    {
        _parameterList.add(index, vParameter);
    } //-- void addParameter(int, nl.b3p.xml.ows.v100.Parameter) 

    /**
     * Method clearConstraint
     * 
     */
    public void clearConstraint()
    {
        _constraintList.clear();
    } //-- void clearConstraint() 

    /**
     * Method clearOperation
     * 
     */
    public void clearOperation()
    {
        _operationList.clear();
    } //-- void clearOperation() 

    /**
     * Method clearParameter
     * 
     */
    public void clearParameter()
    {
        _parameterList.clear();
    } //-- void clearParameter() 

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
     * Method enumerateOperation
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateOperation()
    {
        return Collections.enumeration(_operationList);
    } //-- java.util.Enumeration enumerateOperation() 

    /**
     * Method enumerateParameter
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateParameter()
    {
        return Collections.enumeration(_parameterList);
    } //-- java.util.Enumeration enumerateParameter() 

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
     * Returns the value of field 'extendedCapabilities'. The field
     * 'extendedCapabilities' has the following description:
     * Individual software vendors and servers can use this element
     * to provide metadata about any additional server abilities. 
     * 
     * @return Object
     * @return the value of field 'extendedCapabilities'.
     */
    public java.lang.Object getExtendedCapabilities()
    {
        return this._extendedCapabilities;
    } //-- java.lang.Object getExtendedCapabilities() 

    /**
     * Method getOperation
     * 
     * 
     * 
     * @param index
     * @return Operation
     */
    public nl.b3p.xml.ows.v100.Operation getOperation(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _operationList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.Operation) _operationList.get(index);
    } //-- nl.b3p.xml.ows.v100.Operation getOperation(int) 

    /**
     * Method getOperation
     * 
     * 
     * 
     * @return Operation
     */
    public nl.b3p.xml.ows.v100.Operation[] getOperation()
    {
        int size = _operationList.size();
        nl.b3p.xml.ows.v100.Operation[] mArray = new nl.b3p.xml.ows.v100.Operation[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.Operation) _operationList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.Operation[] getOperation() 

    /**
     * Method getOperationCount
     * 
     * 
     * 
     * @return int
     */
    public int getOperationCount()
    {
        return _operationList.size();
    } //-- int getOperationCount() 

    /**
     * Method getParameter
     * 
     * 
     * 
     * @param index
     * @return Parameter
     */
    public nl.b3p.xml.ows.v100.Parameter getParameter(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _parameterList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.Parameter) _parameterList.get(index);
    } //-- nl.b3p.xml.ows.v100.Parameter getParameter(int) 

    /**
     * Method getParameter
     * 
     * 
     * 
     * @return Parameter
     */
    public nl.b3p.xml.ows.v100.Parameter[] getParameter()
    {
        int size = _parameterList.size();
        nl.b3p.xml.ows.v100.Parameter[] mArray = new nl.b3p.xml.ows.v100.Parameter[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.Parameter) _parameterList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.Parameter[] getParameter() 

    /**
     * Method getParameterCount
     * 
     * 
     * 
     * @return int
     */
    public int getParameterCount()
    {
        return _parameterList.size();
    } //-- int getParameterCount() 

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
     * Method removeOperation
     * 
     * 
     * 
     * @param vOperation
     * @return boolean
     */
    public boolean removeOperation(nl.b3p.xml.ows.v100.Operation vOperation)
    {
        boolean removed = _operationList.remove(vOperation);
        return removed;
    } //-- boolean removeOperation(nl.b3p.xml.ows.v100.Operation) 

    /**
     * Method removeParameter
     * 
     * 
     * 
     * @param vParameter
     * @return boolean
     */
    public boolean removeParameter(nl.b3p.xml.ows.v100.Parameter vParameter)
    {
        boolean removed = _parameterList.remove(vParameter);
        return removed;
    } //-- boolean removeParameter(nl.b3p.xml.ows.v100.Parameter) 

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
     * Sets the value of field 'extendedCapabilities'. The field
     * 'extendedCapabilities' has the following description:
     * Individual software vendors and servers can use this element
     * to provide metadata about any additional server abilities. 
     * 
     * @param extendedCapabilities the value of field
     * 'extendedCapabilities'.
     */
    public void setExtendedCapabilities(java.lang.Object extendedCapabilities)
    {
        this._extendedCapabilities = extendedCapabilities;
    } //-- void setExtendedCapabilities(java.lang.Object) 

    /**
     * Method setOperation
     * 
     * 
     * 
     * @param index
     * @param vOperation
     */
    public void setOperation(int index, nl.b3p.xml.ows.v100.Operation vOperation)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _operationList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _operationList.set(index, vOperation);
    } //-- void setOperation(int, nl.b3p.xml.ows.v100.Operation) 

    /**
     * Method setOperation
     * 
     * 
     * 
     * @param operationArray
     */
    public void setOperation(nl.b3p.xml.ows.v100.Operation[] operationArray)
    {
        //-- copy array
        _operationList.clear();
        for (int i = 0; i < operationArray.length; i++) {
            _operationList.add(operationArray[i]);
        }
    } //-- void setOperation(nl.b3p.xml.ows.v100.Operation) 

    /**
     * Method setParameter
     * 
     * 
     * 
     * @param index
     * @param vParameter
     */
    public void setParameter(int index, nl.b3p.xml.ows.v100.Parameter vParameter)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _parameterList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _parameterList.set(index, vParameter);
    } //-- void setParameter(int, nl.b3p.xml.ows.v100.Parameter) 

    /**
     * Method setParameter
     * 
     * 
     * 
     * @param parameterArray
     */
    public void setParameter(nl.b3p.xml.ows.v100.Parameter[] parameterArray)
    {
        //-- copy array
        _parameterList.clear();
        for (int i = 0; i < parameterArray.length; i++) {
            _parameterList.add(parameterArray[i]);
        }
    } //-- void setParameter(nl.b3p.xml.ows.v100.Parameter) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return OperationsMetadata
     */
    public static nl.b3p.xml.ows.v100.OperationsMetadata unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.OperationsMetadata) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.OperationsMetadata.class, reader);
    } //-- nl.b3p.xml.ows.v100.OperationsMetadata unmarshal(java.io.Reader) 

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
