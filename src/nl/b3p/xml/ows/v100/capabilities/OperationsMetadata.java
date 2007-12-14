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
    private java.util.ArrayList _parameter_OperationsMetadataList;

    /**
     * Optional unordered list of valid domain constraints on
     * non-parameter quantities that each apply to this server. The
     * list of required and optional constraints shall be specified
     * in the Implementation Specification for this service. 
     */
    private java.util.ArrayList _constraint_OperationsMetadataList;

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
        _parameter_OperationsMetadataList = new java.util.ArrayList();
        _constraint_OperationsMetadataList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.capabilities.OperationsMetadata()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addConstraint_OperationsMetadata
     * 
     * 
     * 
     * @param vConstraint_OperationsMetadata
     */
    public void addConstraint_OperationsMetadata(nl.b3p.xml.ows.v100.capabilities.Constraint_OperationsMetadata vConstraint_OperationsMetadata)
        throws java.lang.IndexOutOfBoundsException
    {
        _constraint_OperationsMetadataList.add(vConstraint_OperationsMetadata);
    } //-- void addConstraint_OperationsMetadata(nl.b3p.xml.ows.v100.capabilities.Constraint_OperationsMetadata) 

    /**
     * Method addConstraint_OperationsMetadata
     * 
     * 
     * 
     * @param index
     * @param vConstraint_OperationsMetadata
     */
    public void addConstraint_OperationsMetadata(int index, nl.b3p.xml.ows.v100.capabilities.Constraint_OperationsMetadata vConstraint_OperationsMetadata)
        throws java.lang.IndexOutOfBoundsException
    {
        _constraint_OperationsMetadataList.add(index, vConstraint_OperationsMetadata);
    } //-- void addConstraint_OperationsMetadata(int, nl.b3p.xml.ows.v100.capabilities.Constraint_OperationsMetadata) 

    /**
     * Method addOperation
     * 
     * 
     * 
     * @param vOperation
     */
    public void addOperation(nl.b3p.xml.ows.v100.capabilities.Operation vOperation)
        throws java.lang.IndexOutOfBoundsException
    {
        _operationList.add(vOperation);
    } //-- void addOperation(nl.b3p.xml.ows.v100.capabilities.Operation) 

    /**
     * Method addOperation
     * 
     * 
     * 
     * @param index
     * @param vOperation
     */
    public void addOperation(int index, nl.b3p.xml.ows.v100.capabilities.Operation vOperation)
        throws java.lang.IndexOutOfBoundsException
    {
        _operationList.add(index, vOperation);
    } //-- void addOperation(int, nl.b3p.xml.ows.v100.capabilities.Operation) 

    /**
     * Method addParameter_OperationsMetadata
     * 
     * 
     * 
     * @param vParameter_OperationsMetadata
     */
    public void addParameter_OperationsMetadata(nl.b3p.xml.ows.v100.capabilities.Parameter_OperationsMetadata vParameter_OperationsMetadata)
        throws java.lang.IndexOutOfBoundsException
    {
        _parameter_OperationsMetadataList.add(vParameter_OperationsMetadata);
    } //-- void addParameter_OperationsMetadata(nl.b3p.xml.ows.v100.capabilities.Parameter_OperationsMetadata) 

    /**
     * Method addParameter_OperationsMetadata
     * 
     * 
     * 
     * @param index
     * @param vParameter_OperationsMetadata
     */
    public void addParameter_OperationsMetadata(int index, nl.b3p.xml.ows.v100.capabilities.Parameter_OperationsMetadata vParameter_OperationsMetadata)
        throws java.lang.IndexOutOfBoundsException
    {
        _parameter_OperationsMetadataList.add(index, vParameter_OperationsMetadata);
    } //-- void addParameter_OperationsMetadata(int, nl.b3p.xml.ows.v100.capabilities.Parameter_OperationsMetadata) 

    /**
     * Method clearConstraint_OperationsMetadata
     * 
     */
    public void clearConstraint_OperationsMetadata()
    {
        _constraint_OperationsMetadataList.clear();
    } //-- void clearConstraint_OperationsMetadata() 

    /**
     * Method clearOperation
     * 
     */
    public void clearOperation()
    {
        _operationList.clear();
    } //-- void clearOperation() 

    /**
     * Method clearParameter_OperationsMetadata
     * 
     */
    public void clearParameter_OperationsMetadata()
    {
        _parameter_OperationsMetadataList.clear();
    } //-- void clearParameter_OperationsMetadata() 

    /**
     * Method enumerateConstraint_OperationsMetadata
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateConstraint_OperationsMetadata()
    {
        return Collections.enumeration(_constraint_OperationsMetadataList);
    } //-- java.util.Enumeration enumerateConstraint_OperationsMetadata() 

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
     * Method enumerateParameter_OperationsMetadata
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateParameter_OperationsMetadata()
    {
        return Collections.enumeration(_parameter_OperationsMetadataList);
    } //-- java.util.Enumeration enumerateParameter_OperationsMetadata() 

    /**
     * Method getConstraint_OperationsMetadata
     * 
     * 
     * 
     * @param index
     * @return Constraint_OperationsMetadata
     */
    public nl.b3p.xml.ows.v100.capabilities.Constraint_OperationsMetadata getConstraint_OperationsMetadata(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _constraint_OperationsMetadataList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.capabilities.Constraint_OperationsMetadata) _constraint_OperationsMetadataList.get(index);
    } //-- nl.b3p.xml.ows.v100.capabilities.Constraint_OperationsMetadata getConstraint_OperationsMetadata(int) 

    /**
     * Method getConstraint_OperationsMetadata
     * 
     * 
     * 
     * @return Constraint_OperationsMetadata
     */
    public nl.b3p.xml.ows.v100.capabilities.Constraint_OperationsMetadata[] getConstraint_OperationsMetadata()
    {
        int size = _constraint_OperationsMetadataList.size();
        nl.b3p.xml.ows.v100.capabilities.Constraint_OperationsMetadata[] mArray = new nl.b3p.xml.ows.v100.capabilities.Constraint_OperationsMetadata[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.capabilities.Constraint_OperationsMetadata) _constraint_OperationsMetadataList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.capabilities.Constraint_OperationsMetadata[] getConstraint_OperationsMetadata() 

    /**
     * Method getConstraint_OperationsMetadataCount
     * 
     * 
     * 
     * @return int
     */
    public int getConstraint_OperationsMetadataCount()
    {
        return _constraint_OperationsMetadataList.size();
    } //-- int getConstraint_OperationsMetadataCount() 

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
    public nl.b3p.xml.ows.v100.capabilities.Operation getOperation(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _operationList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.capabilities.Operation) _operationList.get(index);
    } //-- nl.b3p.xml.ows.v100.capabilities.Operation getOperation(int) 

    /**
     * Method getOperation
     * 
     * 
     * 
     * @return Operation
     */
    public nl.b3p.xml.ows.v100.capabilities.Operation[] getOperation()
    {
        int size = _operationList.size();
        nl.b3p.xml.ows.v100.capabilities.Operation[] mArray = new nl.b3p.xml.ows.v100.capabilities.Operation[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.capabilities.Operation) _operationList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.capabilities.Operation[] getOperation() 

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
     * Method getParameter_OperationsMetadata
     * 
     * 
     * 
     * @param index
     * @return Parameter_OperationsMetadata
     */
    public nl.b3p.xml.ows.v100.capabilities.Parameter_OperationsMetadata getParameter_OperationsMetadata(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _parameter_OperationsMetadataList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.capabilities.Parameter_OperationsMetadata) _parameter_OperationsMetadataList.get(index);
    } //-- nl.b3p.xml.ows.v100.capabilities.Parameter_OperationsMetadata getParameter_OperationsMetadata(int) 

    /**
     * Method getParameter_OperationsMetadata
     * 
     * 
     * 
     * @return Parameter_OperationsMetadata
     */
    public nl.b3p.xml.ows.v100.capabilities.Parameter_OperationsMetadata[] getParameter_OperationsMetadata()
    {
        int size = _parameter_OperationsMetadataList.size();
        nl.b3p.xml.ows.v100.capabilities.Parameter_OperationsMetadata[] mArray = new nl.b3p.xml.ows.v100.capabilities.Parameter_OperationsMetadata[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.capabilities.Parameter_OperationsMetadata) _parameter_OperationsMetadataList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.capabilities.Parameter_OperationsMetadata[] getParameter_OperationsMetadata() 

    /**
     * Method getParameter_OperationsMetadataCount
     * 
     * 
     * 
     * @return int
     */
    public int getParameter_OperationsMetadataCount()
    {
        return _parameter_OperationsMetadataList.size();
    } //-- int getParameter_OperationsMetadataCount() 

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
     * Method removeConstraint_OperationsMetadata
     * 
     * 
     * 
     * @param vConstraint_OperationsMetadata
     * @return boolean
     */
    public boolean removeConstraint_OperationsMetadata(nl.b3p.xml.ows.v100.capabilities.Constraint_OperationsMetadata vConstraint_OperationsMetadata)
    {
        boolean removed = _constraint_OperationsMetadataList.remove(vConstraint_OperationsMetadata);
        return removed;
    } //-- boolean removeConstraint_OperationsMetadata(nl.b3p.xml.ows.v100.capabilities.Constraint_OperationsMetadata) 

    /**
     * Method removeOperation
     * 
     * 
     * 
     * @param vOperation
     * @return boolean
     */
    public boolean removeOperation(nl.b3p.xml.ows.v100.capabilities.Operation vOperation)
    {
        boolean removed = _operationList.remove(vOperation);
        return removed;
    } //-- boolean removeOperation(nl.b3p.xml.ows.v100.capabilities.Operation) 

    /**
     * Method removeParameter_OperationsMetadata
     * 
     * 
     * 
     * @param vParameter_OperationsMetadata
     * @return boolean
     */
    public boolean removeParameter_OperationsMetadata(nl.b3p.xml.ows.v100.capabilities.Parameter_OperationsMetadata vParameter_OperationsMetadata)
    {
        boolean removed = _parameter_OperationsMetadataList.remove(vParameter_OperationsMetadata);
        return removed;
    } //-- boolean removeParameter_OperationsMetadata(nl.b3p.xml.ows.v100.capabilities.Parameter_OperationsMetadata) 

    /**
     * Method setConstraint_OperationsMetadata
     * 
     * 
     * 
     * @param index
     * @param vConstraint_OperationsMetadata
     */
    public void setConstraint_OperationsMetadata(int index, nl.b3p.xml.ows.v100.capabilities.Constraint_OperationsMetadata vConstraint_OperationsMetadata)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _constraint_OperationsMetadataList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _constraint_OperationsMetadataList.set(index, vConstraint_OperationsMetadata);
    } //-- void setConstraint_OperationsMetadata(int, nl.b3p.xml.ows.v100.capabilities.Constraint_OperationsMetadata) 

    /**
     * Method setConstraint_OperationsMetadata
     * 
     * 
     * 
     * @param constraint_OperationsMetadataArray
     */
    public void setConstraint_OperationsMetadata(nl.b3p.xml.ows.v100.capabilities.Constraint_OperationsMetadata[] constraint_OperationsMetadataArray)
    {
        //-- copy array
        _constraint_OperationsMetadataList.clear();
        for (int i = 0; i < constraint_OperationsMetadataArray.length; i++) {
            _constraint_OperationsMetadataList.add(constraint_OperationsMetadataArray[i]);
        }
    } //-- void setConstraint_OperationsMetadata(nl.b3p.xml.ows.v100.capabilities.Constraint_OperationsMetadata) 

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
    public void setOperation(int index, nl.b3p.xml.ows.v100.capabilities.Operation vOperation)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _operationList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _operationList.set(index, vOperation);
    } //-- void setOperation(int, nl.b3p.xml.ows.v100.capabilities.Operation) 

    /**
     * Method setOperation
     * 
     * 
     * 
     * @param operationArray
     */
    public void setOperation(nl.b3p.xml.ows.v100.capabilities.Operation[] operationArray)
    {
        //-- copy array
        _operationList.clear();
        for (int i = 0; i < operationArray.length; i++) {
            _operationList.add(operationArray[i]);
        }
    } //-- void setOperation(nl.b3p.xml.ows.v100.capabilities.Operation) 

    /**
     * Method setParameter_OperationsMetadata
     * 
     * 
     * 
     * @param index
     * @param vParameter_OperationsMetadata
     */
    public void setParameter_OperationsMetadata(int index, nl.b3p.xml.ows.v100.capabilities.Parameter_OperationsMetadata vParameter_OperationsMetadata)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _parameter_OperationsMetadataList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _parameter_OperationsMetadataList.set(index, vParameter_OperationsMetadata);
    } //-- void setParameter_OperationsMetadata(int, nl.b3p.xml.ows.v100.capabilities.Parameter_OperationsMetadata) 

    /**
     * Method setParameter_OperationsMetadata
     * 
     * 
     * 
     * @param parameter_OperationsMetadataArray
     */
    public void setParameter_OperationsMetadata(nl.b3p.xml.ows.v100.capabilities.Parameter_OperationsMetadata[] parameter_OperationsMetadataArray)
    {
        //-- copy array
        _parameter_OperationsMetadataList.clear();
        for (int i = 0; i < parameter_OperationsMetadataArray.length; i++) {
            _parameter_OperationsMetadataList.add(parameter_OperationsMetadataArray[i]);
        }
    } //-- void setParameter_OperationsMetadata(nl.b3p.xml.ows.v100.capabilities.Parameter_OperationsMetadata) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return OperationsMetadata
     */
    public static nl.b3p.xml.ows.v100.capabilities.OperationsMetadata unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.capabilities.OperationsMetadata) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.capabilities.OperationsMetadata.class, reader);
    } //-- nl.b3p.xml.ows.v100.capabilities.OperationsMetadata unmarshal(java.io.Reader) 

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
