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
 * The TransactionResults element may be used to report exception
 *  codes and messages for all actions of a transaction that failed
 *  to complete successfully.
 *  
 * 
 * @version $Revision$ $Date$
 */
public class TransactionResultsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The Action element reports an exception code
     *  and exception message indicating why the
     *  corresponding action of a transaction request
     *  failed.
     *  
     */
    private java.util.ArrayList _actionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public TransactionResultsType() 
     {
        super();
        _actionList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v110.TransactionResultsType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addAction
     * 
     * 
     * 
     * @param vAction
     */
    public void addAction(nl.b3p.xml.wfs.v110.Action vAction)
        throws java.lang.IndexOutOfBoundsException
    {
        _actionList.add(vAction);
    } //-- void addAction(nl.b3p.xml.wfs.v110.Action) 

    /**
     * Method addAction
     * 
     * 
     * 
     * @param index
     * @param vAction
     */
    public void addAction(int index, nl.b3p.xml.wfs.v110.Action vAction)
        throws java.lang.IndexOutOfBoundsException
    {
        _actionList.add(index, vAction);
    } //-- void addAction(int, nl.b3p.xml.wfs.v110.Action) 

    /**
     * Method clearAction
     * 
     */
    public void clearAction()
    {
        _actionList.clear();
    } //-- void clearAction() 

    /**
     * Method enumerateAction
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateAction()
    {
        return Collections.enumeration(_actionList);
    } //-- java.util.Enumeration enumerateAction() 

    /**
     * Method getAction
     * 
     * 
     * 
     * @param index
     * @return Action
     */
    public nl.b3p.xml.wfs.v110.Action getAction(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _actionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.wfs.v110.Action) _actionList.get(index);
    } //-- nl.b3p.xml.wfs.v110.Action getAction(int) 

    /**
     * Method getAction
     * 
     * 
     * 
     * @return Action
     */
    public nl.b3p.xml.wfs.v110.Action[] getAction()
    {
        int size = _actionList.size();
        nl.b3p.xml.wfs.v110.Action[] mArray = new nl.b3p.xml.wfs.v110.Action[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.wfs.v110.Action) _actionList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.wfs.v110.Action[] getAction() 

    /**
     * Method getActionCount
     * 
     * 
     * 
     * @return int
     */
    public int getActionCount()
    {
        return _actionList.size();
    } //-- int getActionCount() 

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
     * Method removeAction
     * 
     * 
     * 
     * @param vAction
     * @return boolean
     */
    public boolean removeAction(nl.b3p.xml.wfs.v110.Action vAction)
    {
        boolean removed = _actionList.remove(vAction);
        return removed;
    } //-- boolean removeAction(nl.b3p.xml.wfs.v110.Action) 

    /**
     * Method setAction
     * 
     * 
     * 
     * @param index
     * @param vAction
     */
    public void setAction(int index, nl.b3p.xml.wfs.v110.Action vAction)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _actionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _actionList.set(index, vAction);
    } //-- void setAction(int, nl.b3p.xml.wfs.v110.Action) 

    /**
     * Method setAction
     * 
     * 
     * 
     * @param actionArray
     */
    public void setAction(nl.b3p.xml.wfs.v110.Action[] actionArray)
    {
        //-- copy array
        _actionList.clear();
        for (int i = 0; i < actionArray.length; i++) {
            _actionList.add(actionArray[i]);
        }
    } //-- void setAction(nl.b3p.xml.wfs.v110.Action) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return TransactionResultsType
     */
    public static nl.b3p.xml.wfs.v110.TransactionResultsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.TransactionResultsType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.TransactionResultsType.class, reader);
    } //-- nl.b3p.xml.wfs.v110.TransactionResultsType unmarshal(java.io.Reader) 

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
