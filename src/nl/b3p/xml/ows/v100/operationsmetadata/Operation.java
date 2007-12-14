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
 * Metadata for one operation that this server implements. 
 * 
 * @version $Revision$ $Date$
 */
public class Operation implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Name or identifier of this operation (request) (for example,
     * GetCapabilities). The list of required and optional
     * operations implemented shall be specified in the
     * Implementation Specification for this service. 
     */
    private java.lang.String _name;

    /**
     * Unordered list of Distributed Computing Platforms (DCPs)
     * supported for this operation. At present, only the HTTP DCP
     * is defined, so this element will appear only once. 
     */
    private java.util.ArrayList _DCPList;

    /**
     * Optional unordered list of parameter domains that each apply
     * to this operation which this server implements. If one of
     * these Parameter elements has the same "name" attribute as a
     * Parameter element in the OperationsMetadata element, this
     * Parameter element shall override the other one for this
     * operation. The list of required and optional parameter
     * domain limitations for this operation shall be specified in
     * the Implementation Specification for this service. 
     */
    private java.util.ArrayList _parameter_OperationList;

    /**
     * Optional unordered list of valid domain constraints on
     * non-parameter quantities that each apply to this operation.
     * If one of these Constraint elements has the same "name"
     * attribute as a Constraint element in the OperationsMetadata
     * element, this Constraint element shall override the other
     * one for this operation. The list of required and optional
     * constraints for this operation shall be specified in the
     * Implementation Specification for this service. 
     */
    private java.util.ArrayList _constraint_OperationList;

    /**
     * Optional unordered list of additional metadata about this
     * operation and its' implementation. A list of required and
     * optional metadata elements for this operation should be
     * specified in the Implementation Specification for this
     * service. (Informative: This metadata might specify the
     * operation request parameters or provide the XML Schemas for
     * the operation request.) 
     */
    private java.util.ArrayList _metadataList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Operation() 
     {
        super();
        _DCPList = new java.util.ArrayList();
        _parameter_OperationList = new java.util.ArrayList();
        _constraint_OperationList = new java.util.ArrayList();
        _metadataList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.operationsmetadata.Operation()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addConstraint_Operation
     * 
     * 
     * 
     * @param vConstraint_Operation
     */
    public void addConstraint_Operation(nl.b3p.xml.ows.v100.operationsmetadata.Constraint_Operation vConstraint_Operation)
        throws java.lang.IndexOutOfBoundsException
    {
        _constraint_OperationList.add(vConstraint_Operation);
    } //-- void addConstraint_Operation(nl.b3p.xml.ows.v100.operationsmetadata.Constraint_Operation) 

    /**
     * Method addConstraint_Operation
     * 
     * 
     * 
     * @param index
     * @param vConstraint_Operation
     */
    public void addConstraint_Operation(int index, nl.b3p.xml.ows.v100.operationsmetadata.Constraint_Operation vConstraint_Operation)
        throws java.lang.IndexOutOfBoundsException
    {
        _constraint_OperationList.add(index, vConstraint_Operation);
    } //-- void addConstraint_Operation(int, nl.b3p.xml.ows.v100.operationsmetadata.Constraint_Operation) 

    /**
     * Method addDCP
     * 
     * 
     * 
     * @param vDCP
     */
    public void addDCP(nl.b3p.xml.ows.v100.operationsmetadata.DCP vDCP)
        throws java.lang.IndexOutOfBoundsException
    {
        _DCPList.add(vDCP);
    } //-- void addDCP(nl.b3p.xml.ows.v100.operationsmetadata.DCP) 

    /**
     * Method addDCP
     * 
     * 
     * 
     * @param index
     * @param vDCP
     */
    public void addDCP(int index, nl.b3p.xml.ows.v100.operationsmetadata.DCP vDCP)
        throws java.lang.IndexOutOfBoundsException
    {
        _DCPList.add(index, vDCP);
    } //-- void addDCP(int, nl.b3p.xml.ows.v100.operationsmetadata.DCP) 

    /**
     * Method addMetadata
     * 
     * 
     * 
     * @param vMetadata
     */
    public void addMetadata(nl.b3p.xml.ows.v100.operationsmetadata.Metadata vMetadata)
        throws java.lang.IndexOutOfBoundsException
    {
        _metadataList.add(vMetadata);
    } //-- void addMetadata(nl.b3p.xml.ows.v100.operationsmetadata.Metadata) 

    /**
     * Method addMetadata
     * 
     * 
     * 
     * @param index
     * @param vMetadata
     */
    public void addMetadata(int index, nl.b3p.xml.ows.v100.operationsmetadata.Metadata vMetadata)
        throws java.lang.IndexOutOfBoundsException
    {
        _metadataList.add(index, vMetadata);
    } //-- void addMetadata(int, nl.b3p.xml.ows.v100.operationsmetadata.Metadata) 

    /**
     * Method addParameter_Operation
     * 
     * 
     * 
     * @param vParameter_Operation
     */
    public void addParameter_Operation(nl.b3p.xml.ows.v100.operationsmetadata.Parameter_Operation vParameter_Operation)
        throws java.lang.IndexOutOfBoundsException
    {
        _parameter_OperationList.add(vParameter_Operation);
    } //-- void addParameter_Operation(nl.b3p.xml.ows.v100.operationsmetadata.Parameter_Operation) 

    /**
     * Method addParameter_Operation
     * 
     * 
     * 
     * @param index
     * @param vParameter_Operation
     */
    public void addParameter_Operation(int index, nl.b3p.xml.ows.v100.operationsmetadata.Parameter_Operation vParameter_Operation)
        throws java.lang.IndexOutOfBoundsException
    {
        _parameter_OperationList.add(index, vParameter_Operation);
    } //-- void addParameter_Operation(int, nl.b3p.xml.ows.v100.operationsmetadata.Parameter_Operation) 

    /**
     * Method clearConstraint_Operation
     * 
     */
    public void clearConstraint_Operation()
    {
        _constraint_OperationList.clear();
    } //-- void clearConstraint_Operation() 

    /**
     * Method clearDCP
     * 
     */
    public void clearDCP()
    {
        _DCPList.clear();
    } //-- void clearDCP() 

    /**
     * Method clearMetadata
     * 
     */
    public void clearMetadata()
    {
        _metadataList.clear();
    } //-- void clearMetadata() 

    /**
     * Method clearParameter_Operation
     * 
     */
    public void clearParameter_Operation()
    {
        _parameter_OperationList.clear();
    } //-- void clearParameter_Operation() 

    /**
     * Method enumerateConstraint_Operation
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateConstraint_Operation()
    {
        return Collections.enumeration(_constraint_OperationList);
    } //-- java.util.Enumeration enumerateConstraint_Operation() 

    /**
     * Method enumerateDCP
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateDCP()
    {
        return Collections.enumeration(_DCPList);
    } //-- java.util.Enumeration enumerateDCP() 

    /**
     * Method enumerateMetadata
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateMetadata()
    {
        return Collections.enumeration(_metadataList);
    } //-- java.util.Enumeration enumerateMetadata() 

    /**
     * Method enumerateParameter_Operation
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateParameter_Operation()
    {
        return Collections.enumeration(_parameter_OperationList);
    } //-- java.util.Enumeration enumerateParameter_Operation() 

    /**
     * Method getConstraint_Operation
     * 
     * 
     * 
     * @param index
     * @return Constraint_Operation
     */
    public nl.b3p.xml.ows.v100.operationsmetadata.Constraint_Operation getConstraint_Operation(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _constraint_OperationList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.operationsmetadata.Constraint_Operation) _constraint_OperationList.get(index);
    } //-- nl.b3p.xml.ows.v100.operationsmetadata.Constraint_Operation getConstraint_Operation(int) 

    /**
     * Method getConstraint_Operation
     * 
     * 
     * 
     * @return Constraint_Operation
     */
    public nl.b3p.xml.ows.v100.operationsmetadata.Constraint_Operation[] getConstraint_Operation()
    {
        int size = _constraint_OperationList.size();
        nl.b3p.xml.ows.v100.operationsmetadata.Constraint_Operation[] mArray = new nl.b3p.xml.ows.v100.operationsmetadata.Constraint_Operation[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.operationsmetadata.Constraint_Operation) _constraint_OperationList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.operationsmetadata.Constraint_Operation[] getConstraint_Operation() 

    /**
     * Method getConstraint_OperationCount
     * 
     * 
     * 
     * @return int
     */
    public int getConstraint_OperationCount()
    {
        return _constraint_OperationList.size();
    } //-- int getConstraint_OperationCount() 

    /**
     * Method getDCP
     * 
     * 
     * 
     * @param index
     * @return DCP
     */
    public nl.b3p.xml.ows.v100.operationsmetadata.DCP getDCP(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _DCPList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.operationsmetadata.DCP) _DCPList.get(index);
    } //-- nl.b3p.xml.ows.v100.operationsmetadata.DCP getDCP(int) 

    /**
     * Method getDCP
     * 
     * 
     * 
     * @return DCP
     */
    public nl.b3p.xml.ows.v100.operationsmetadata.DCP[] getDCP()
    {
        int size = _DCPList.size();
        nl.b3p.xml.ows.v100.operationsmetadata.DCP[] mArray = new nl.b3p.xml.ows.v100.operationsmetadata.DCP[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.operationsmetadata.DCP) _DCPList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.operationsmetadata.DCP[] getDCP() 

    /**
     * Method getDCPCount
     * 
     * 
     * 
     * @return int
     */
    public int getDCPCount()
    {
        return _DCPList.size();
    } //-- int getDCPCount() 

    /**
     * Method getMetadata
     * 
     * 
     * 
     * @param index
     * @return Metadata
     */
    public nl.b3p.xml.ows.v100.operationsmetadata.Metadata getMetadata(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _metadataList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.operationsmetadata.Metadata) _metadataList.get(index);
    } //-- nl.b3p.xml.ows.v100.operationsmetadata.Metadata getMetadata(int) 

    /**
     * Method getMetadata
     * 
     * 
     * 
     * @return Metadata
     */
    public nl.b3p.xml.ows.v100.operationsmetadata.Metadata[] getMetadata()
    {
        int size = _metadataList.size();
        nl.b3p.xml.ows.v100.operationsmetadata.Metadata[] mArray = new nl.b3p.xml.ows.v100.operationsmetadata.Metadata[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.operationsmetadata.Metadata) _metadataList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.operationsmetadata.Metadata[] getMetadata() 

    /**
     * Method getMetadataCount
     * 
     * 
     * 
     * @return int
     */
    public int getMetadataCount()
    {
        return _metadataList.size();
    } //-- int getMetadataCount() 

    /**
     * Returns the value of field 'name'. The field 'name' has the
     * following description: Name or identifier of this operation
     * (request) (for example, GetCapabilities). The list of
     * required and optional operations implemented shall be
     * specified in the Implementation Specification for this
     * service. 
     * 
     * @return String
     * @return the value of field 'name'.
     */
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Method getParameter_Operation
     * 
     * 
     * 
     * @param index
     * @return Parameter_Operation
     */
    public nl.b3p.xml.ows.v100.operationsmetadata.Parameter_Operation getParameter_Operation(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _parameter_OperationList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.operationsmetadata.Parameter_Operation) _parameter_OperationList.get(index);
    } //-- nl.b3p.xml.ows.v100.operationsmetadata.Parameter_Operation getParameter_Operation(int) 

    /**
     * Method getParameter_Operation
     * 
     * 
     * 
     * @return Parameter_Operation
     */
    public nl.b3p.xml.ows.v100.operationsmetadata.Parameter_Operation[] getParameter_Operation()
    {
        int size = _parameter_OperationList.size();
        nl.b3p.xml.ows.v100.operationsmetadata.Parameter_Operation[] mArray = new nl.b3p.xml.ows.v100.operationsmetadata.Parameter_Operation[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.operationsmetadata.Parameter_Operation) _parameter_OperationList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.operationsmetadata.Parameter_Operation[] getParameter_Operation() 

    /**
     * Method getParameter_OperationCount
     * 
     * 
     * 
     * @return int
     */
    public int getParameter_OperationCount()
    {
        return _parameter_OperationList.size();
    } //-- int getParameter_OperationCount() 

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
     * Method removeConstraint_Operation
     * 
     * 
     * 
     * @param vConstraint_Operation
     * @return boolean
     */
    public boolean removeConstraint_Operation(nl.b3p.xml.ows.v100.operationsmetadata.Constraint_Operation vConstraint_Operation)
    {
        boolean removed = _constraint_OperationList.remove(vConstraint_Operation);
        return removed;
    } //-- boolean removeConstraint_Operation(nl.b3p.xml.ows.v100.operationsmetadata.Constraint_Operation) 

    /**
     * Method removeDCP
     * 
     * 
     * 
     * @param vDCP
     * @return boolean
     */
    public boolean removeDCP(nl.b3p.xml.ows.v100.operationsmetadata.DCP vDCP)
    {
        boolean removed = _DCPList.remove(vDCP);
        return removed;
    } //-- boolean removeDCP(nl.b3p.xml.ows.v100.operationsmetadata.DCP) 

    /**
     * Method removeMetadata
     * 
     * 
     * 
     * @param vMetadata
     * @return boolean
     */
    public boolean removeMetadata(nl.b3p.xml.ows.v100.operationsmetadata.Metadata vMetadata)
    {
        boolean removed = _metadataList.remove(vMetadata);
        return removed;
    } //-- boolean removeMetadata(nl.b3p.xml.ows.v100.operationsmetadata.Metadata) 

    /**
     * Method removeParameter_Operation
     * 
     * 
     * 
     * @param vParameter_Operation
     * @return boolean
     */
    public boolean removeParameter_Operation(nl.b3p.xml.ows.v100.operationsmetadata.Parameter_Operation vParameter_Operation)
    {
        boolean removed = _parameter_OperationList.remove(vParameter_Operation);
        return removed;
    } //-- boolean removeParameter_Operation(nl.b3p.xml.ows.v100.operationsmetadata.Parameter_Operation) 

    /**
     * Method setConstraint_Operation
     * 
     * 
     * 
     * @param index
     * @param vConstraint_Operation
     */
    public void setConstraint_Operation(int index, nl.b3p.xml.ows.v100.operationsmetadata.Constraint_Operation vConstraint_Operation)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _constraint_OperationList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _constraint_OperationList.set(index, vConstraint_Operation);
    } //-- void setConstraint_Operation(int, nl.b3p.xml.ows.v100.operationsmetadata.Constraint_Operation) 

    /**
     * Method setConstraint_Operation
     * 
     * 
     * 
     * @param constraint_OperationArray
     */
    public void setConstraint_Operation(nl.b3p.xml.ows.v100.operationsmetadata.Constraint_Operation[] constraint_OperationArray)
    {
        //-- copy array
        _constraint_OperationList.clear();
        for (int i = 0; i < constraint_OperationArray.length; i++) {
            _constraint_OperationList.add(constraint_OperationArray[i]);
        }
    } //-- void setConstraint_Operation(nl.b3p.xml.ows.v100.operationsmetadata.Constraint_Operation) 

    /**
     * Method setDCP
     * 
     * 
     * 
     * @param index
     * @param vDCP
     */
    public void setDCP(int index, nl.b3p.xml.ows.v100.operationsmetadata.DCP vDCP)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _DCPList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _DCPList.set(index, vDCP);
    } //-- void setDCP(int, nl.b3p.xml.ows.v100.operationsmetadata.DCP) 

    /**
     * Method setDCP
     * 
     * 
     * 
     * @param DCPArray
     */
    public void setDCP(nl.b3p.xml.ows.v100.operationsmetadata.DCP[] DCPArray)
    {
        //-- copy array
        _DCPList.clear();
        for (int i = 0; i < DCPArray.length; i++) {
            _DCPList.add(DCPArray[i]);
        }
    } //-- void setDCP(nl.b3p.xml.ows.v100.operationsmetadata.DCP) 

    /**
     * Method setMetadata
     * 
     * 
     * 
     * @param index
     * @param vMetadata
     */
    public void setMetadata(int index, nl.b3p.xml.ows.v100.operationsmetadata.Metadata vMetadata)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _metadataList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _metadataList.set(index, vMetadata);
    } //-- void setMetadata(int, nl.b3p.xml.ows.v100.operationsmetadata.Metadata) 

    /**
     * Method setMetadata
     * 
     * 
     * 
     * @param metadataArray
     */
    public void setMetadata(nl.b3p.xml.ows.v100.operationsmetadata.Metadata[] metadataArray)
    {
        //-- copy array
        _metadataList.clear();
        for (int i = 0; i < metadataArray.length; i++) {
            _metadataList.add(metadataArray[i]);
        }
    } //-- void setMetadata(nl.b3p.xml.ows.v100.operationsmetadata.Metadata) 

    /**
     * Sets the value of field 'name'. The field 'name' has the
     * following description: Name or identifier of this operation
     * (request) (for example, GetCapabilities). The list of
     * required and optional operations implemented shall be
     * specified in the Implementation Specification for this
     * service. 
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Method setParameter_Operation
     * 
     * 
     * 
     * @param index
     * @param vParameter_Operation
     */
    public void setParameter_Operation(int index, nl.b3p.xml.ows.v100.operationsmetadata.Parameter_Operation vParameter_Operation)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _parameter_OperationList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _parameter_OperationList.set(index, vParameter_Operation);
    } //-- void setParameter_Operation(int, nl.b3p.xml.ows.v100.operationsmetadata.Parameter_Operation) 

    /**
     * Method setParameter_Operation
     * 
     * 
     * 
     * @param parameter_OperationArray
     */
    public void setParameter_Operation(nl.b3p.xml.ows.v100.operationsmetadata.Parameter_Operation[] parameter_OperationArray)
    {
        //-- copy array
        _parameter_OperationList.clear();
        for (int i = 0; i < parameter_OperationArray.length; i++) {
            _parameter_OperationList.add(parameter_OperationArray[i]);
        }
    } //-- void setParameter_Operation(nl.b3p.xml.ows.v100.operationsmetadata.Parameter_Operation) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Operation
     */
    public static nl.b3p.xml.ows.v100.operationsmetadata.Operation unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.operationsmetadata.Operation) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.operationsmetadata.Operation.class, reader);
    } //-- nl.b3p.xml.ows.v100.operationsmetadata.Operation unmarshal(java.io.Reader) 

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
