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
    private java.util.ArrayList _parameterList;

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
    private java.util.ArrayList _constraintList;

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
        _parameterList = new java.util.ArrayList();
        _constraintList = new java.util.ArrayList();
        _metadataList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ows.v100.Operation()


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
     * Method addDCP
     * 
     * 
     * 
     * @param vDCP
     */
    public void addDCP(nl.b3p.xml.ows.v100.DCP vDCP)
        throws java.lang.IndexOutOfBoundsException
    {
        _DCPList.add(vDCP);
    } //-- void addDCP(nl.b3p.xml.ows.v100.DCP) 

    /**
     * Method addDCP
     * 
     * 
     * 
     * @param index
     * @param vDCP
     */
    public void addDCP(int index, nl.b3p.xml.ows.v100.DCP vDCP)
        throws java.lang.IndexOutOfBoundsException
    {
        _DCPList.add(index, vDCP);
    } //-- void addDCP(int, nl.b3p.xml.ows.v100.DCP) 

    /**
     * Method addMetadata
     * 
     * 
     * 
     * @param vMetadata
     */
    public void addMetadata(nl.b3p.xml.ows.v100.Metadata vMetadata)
        throws java.lang.IndexOutOfBoundsException
    {
        _metadataList.add(vMetadata);
    } //-- void addMetadata(nl.b3p.xml.ows.v100.Metadata) 

    /**
     * Method addMetadata
     * 
     * 
     * 
     * @param index
     * @param vMetadata
     */
    public void addMetadata(int index, nl.b3p.xml.ows.v100.Metadata vMetadata)
        throws java.lang.IndexOutOfBoundsException
    {
        _metadataList.add(index, vMetadata);
    } //-- void addMetadata(int, nl.b3p.xml.ows.v100.Metadata) 

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
     * Method getDCP
     * 
     * 
     * 
     * @param index
     * @return DCP
     */
    public nl.b3p.xml.ows.v100.DCP getDCP(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _DCPList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.DCP) _DCPList.get(index);
    } //-- nl.b3p.xml.ows.v100.DCP getDCP(int) 

    /**
     * Method getDCP
     * 
     * 
     * 
     * @return DCP
     */
    public nl.b3p.xml.ows.v100.DCP[] getDCP()
    {
        int size = _DCPList.size();
        nl.b3p.xml.ows.v100.DCP[] mArray = new nl.b3p.xml.ows.v100.DCP[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.DCP) _DCPList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.DCP[] getDCP() 

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
    public nl.b3p.xml.ows.v100.Metadata getMetadata(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _metadataList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ows.v100.Metadata) _metadataList.get(index);
    } //-- nl.b3p.xml.ows.v100.Metadata getMetadata(int) 

    /**
     * Method getMetadata
     * 
     * 
     * 
     * @return Metadata
     */
    public nl.b3p.xml.ows.v100.Metadata[] getMetadata()
    {
        int size = _metadataList.size();
        nl.b3p.xml.ows.v100.Metadata[] mArray = new nl.b3p.xml.ows.v100.Metadata[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ows.v100.Metadata) _metadataList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ows.v100.Metadata[] getMetadata() 

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
     * Method removeDCP
     * 
     * 
     * 
     * @param vDCP
     * @return boolean
     */
    public boolean removeDCP(nl.b3p.xml.ows.v100.DCP vDCP)
    {
        boolean removed = _DCPList.remove(vDCP);
        return removed;
    } //-- boolean removeDCP(nl.b3p.xml.ows.v100.DCP) 

    /**
     * Method removeMetadata
     * 
     * 
     * 
     * @param vMetadata
     * @return boolean
     */
    public boolean removeMetadata(nl.b3p.xml.ows.v100.Metadata vMetadata)
    {
        boolean removed = _metadataList.remove(vMetadata);
        return removed;
    } //-- boolean removeMetadata(nl.b3p.xml.ows.v100.Metadata) 

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
     * Method setDCP
     * 
     * 
     * 
     * @param index
     * @param vDCP
     */
    public void setDCP(int index, nl.b3p.xml.ows.v100.DCP vDCP)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _DCPList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _DCPList.set(index, vDCP);
    } //-- void setDCP(int, nl.b3p.xml.ows.v100.DCP) 

    /**
     * Method setDCP
     * 
     * 
     * 
     * @param DCPArray
     */
    public void setDCP(nl.b3p.xml.ows.v100.DCP[] DCPArray)
    {
        //-- copy array
        _DCPList.clear();
        for (int i = 0; i < DCPArray.length; i++) {
            _DCPList.add(DCPArray[i]);
        }
    } //-- void setDCP(nl.b3p.xml.ows.v100.DCP) 

    /**
     * Method setMetadata
     * 
     * 
     * 
     * @param index
     * @param vMetadata
     */
    public void setMetadata(int index, nl.b3p.xml.ows.v100.Metadata vMetadata)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _metadataList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _metadataList.set(index, vMetadata);
    } //-- void setMetadata(int, nl.b3p.xml.ows.v100.Metadata) 

    /**
     * Method setMetadata
     * 
     * 
     * 
     * @param metadataArray
     */
    public void setMetadata(nl.b3p.xml.ows.v100.Metadata[] metadataArray)
    {
        //-- copy array
        _metadataList.clear();
        for (int i = 0; i < metadataArray.length; i++) {
            _metadataList.add(metadataArray[i]);
        }
    } //-- void setMetadata(nl.b3p.xml.ows.v100.Metadata) 

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
     * @return Operation
     */
    public static nl.b3p.xml.ows.v100.Operation unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ows.v100.Operation) Unmarshaller.unmarshal(nl.b3p.xml.ows.v100.Operation.class, reader);
    } //-- nl.b3p.xml.ows.v100.Operation unmarshal(java.io.Reader) 

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
