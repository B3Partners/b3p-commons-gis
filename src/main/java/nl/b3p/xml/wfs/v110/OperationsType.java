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
 * Class OperationsType.
 * 
 * @version $Revision$ $Date$
 */
public class OperationsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _operationList
     */
    private java.util.ArrayList _operationList;


      //----------------/
     //- Constructors -/
    //----------------/

    public OperationsType() 
     {
        super();
        _operationList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v110.OperationsType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addOperation
     * 
     * 
     * 
     * @param vOperation
     */
    public void addOperation(nl.b3p.xml.wfs.v110.types.OperationType vOperation)
        throws java.lang.IndexOutOfBoundsException
    {
        _operationList.add(vOperation);
    } //-- void addOperation(nl.b3p.xml.wfs.v110.types.OperationType) 

    /**
     * Method addOperation
     * 
     * 
     * 
     * @param index
     * @param vOperation
     */
    public void addOperation(int index, nl.b3p.xml.wfs.v110.types.OperationType vOperation)
        throws java.lang.IndexOutOfBoundsException
    {
        _operationList.add(index, vOperation);
    } //-- void addOperation(int, nl.b3p.xml.wfs.v110.types.OperationType) 

    /**
     * Method clearOperation
     * 
     */
    public void clearOperation()
    {
        _operationList.clear();
    } //-- void clearOperation() 

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
     * Method getOperation
     * 
     * 
     * 
     * @param index
     * @return OperationType
     */
    public nl.b3p.xml.wfs.v110.types.OperationType getOperation(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _operationList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v110.types.OperationType) _operationList.get(index);
    } //-- nl.b3p.xml.wfs.v110.types.OperationType getOperation(int) 

    /**
     * Method getOperation
     * 
     * 
     * 
     * @return OperationType
     */
    public nl.b3p.xml.wfs.v110.types.OperationType[] getOperation()
    {
        int size = _operationList.size();
        nl.b3p.xml.wfs.v110.types.OperationType[] mArray = new nl.b3p.xml.wfs.v110.types.OperationType[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v110.types.OperationType) _operationList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v110.types.OperationType[] getOperation() 

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
     * Method removeOperation
     * 
     * 
     * 
     * @param vOperation
     * @return boolean
     */
    public boolean removeOperation(nl.b3p.xml.wfs.v110.types.OperationType vOperation)
    {
        boolean removed = _operationList.remove(vOperation);
        return removed;
    } //-- boolean removeOperation(nl.b3p.xml.wfs.v110.types.OperationType) 

    /**
     * Method setOperation
     * 
     * 
     * 
     * @param index
     * @param vOperation
     */
    public void setOperation(int index, nl.b3p.xml.wfs.v110.types.OperationType vOperation)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _operationList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _operationList.set(index, vOperation);
    } //-- void setOperation(int, nl.b3p.xml.wfs.v110.types.OperationType) 

    /**
     * Method setOperation
     * 
     * 
     * 
     * @param operationArray
     */
    public void setOperation(nl.b3p.xml.wfs.v110.types.OperationType[] operationArray)
    {
        //-- copy array
        _operationList.clear();
        for (int i = 0; i < operationArray.length; i++) {
            _operationList.add(operationArray[i]);
        }
    } //-- void setOperation(nl.b3p.xml.wfs.v110.types.OperationType) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return OperationsType
     */
    public static nl.b3p.xml.wfs.v110.OperationsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.OperationsType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.OperationsType.class, reader);
    } //-- nl.b3p.xml.wfs.v110.OperationsType unmarshal(java.io.Reader) 

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
