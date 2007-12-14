/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v110;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Collections;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class FunctionType.
 * 
 * @version $Revision$ $Date$
 */
public class FunctionType extends nl.b3p.xml.ogc.v110.ExpressionType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _expressionList
     */
    private java.util.ArrayList _expressionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public FunctionType() 
     {
        super();
        _expressionList = new java.util.ArrayList();
    } //-- nl.b3p.xml.ogc.v110.FunctionType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addExpression
     * 
     * 
     * 
     * @param vExpression
     */
    public void addExpression(nl.b3p.xml.ogc.v110.Expression vExpression)
        throws java.lang.IndexOutOfBoundsException
    {
        _expressionList.add(vExpression);
    } //-- void addExpression(nl.b3p.xml.ogc.v110.Expression) 

    /**
     * Method addExpression
     * 
     * 
     * 
     * @param index
     * @param vExpression
     */
    public void addExpression(int index, nl.b3p.xml.ogc.v110.Expression vExpression)
        throws java.lang.IndexOutOfBoundsException
    {
        _expressionList.add(index, vExpression);
    } //-- void addExpression(int, nl.b3p.xml.ogc.v110.Expression) 

    /**
     * Method clearExpression
     * 
     */
    public void clearExpression()
    {
        _expressionList.clear();
    } //-- void clearExpression() 

    /**
     * Method enumerateExpression
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateExpression()
    {
        return Collections.enumeration(_expressionList);
    } //-- java.util.Enumeration enumerateExpression() 

    /**
     * Method getExpression
     * 
     * 
     * 
     * @param index
     * @return Expression
     */
    public nl.b3p.xml.ogc.v110.Expression getExpression(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _expressionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (nl.b3p.xml.ogc.v110.Expression) _expressionList.get(index);
    } //-- nl.b3p.xml.ogc.v110.Expression getExpression(int) 

    /**
     * Method getExpression
     * 
     * 
     * 
     * @return Expression
     */
    public nl.b3p.xml.ogc.v110.Expression[] getExpression()
    {
        int size = _expressionList.size();
        nl.b3p.xml.ogc.v110.Expression[] mArray = new nl.b3p.xml.ogc.v110.Expression[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (nl.b3p.xml.ogc.v110.Expression) _expressionList.get(index);
        }
        return mArray;
    } //-- nl.b3p.xml.ogc.v110.Expression[] getExpression() 

    /**
     * Method getExpressionCount
     * 
     * 
     * 
     * @return int
     */
    public int getExpressionCount()
    {
        return _expressionList.size();
    } //-- int getExpressionCount() 

    /**
     * Returns the value of field 'name'.
     * 
     * @return String
     * @return the value of field 'name'.
     */
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

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
     * Method removeExpression
     * 
     * 
     * 
     * @param vExpression
     * @return boolean
     */
    public boolean removeExpression(nl.b3p.xml.ogc.v110.Expression vExpression)
    {
        boolean removed = _expressionList.remove(vExpression);
        return removed;
    } //-- boolean removeExpression(nl.b3p.xml.ogc.v110.Expression) 

    /**
     * Method setExpression
     * 
     * 
     * 
     * @param index
     * @param vExpression
     */
    public void setExpression(int index, nl.b3p.xml.ogc.v110.Expression vExpression)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _expressionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _expressionList.set(index, vExpression);
    } //-- void setExpression(int, nl.b3p.xml.ogc.v110.Expression) 

    /**
     * Method setExpression
     * 
     * 
     * 
     * @param expressionArray
     */
    public void setExpression(nl.b3p.xml.ogc.v110.Expression[] expressionArray)
    {
        //-- copy array
        _expressionList.clear();
        for (int i = 0; i < expressionArray.length; i++) {
            _expressionList.add(expressionArray[i]);
        }
    } //-- void setExpression(nl.b3p.xml.ogc.v110.Expression) 

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return ExpressionType
     */
    public static nl.b3p.xml.ogc.v110.ExpressionType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v110.ExpressionType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.FunctionType.class, reader);
    } //-- nl.b3p.xml.ogc.v110.ExpressionType unmarshal(java.io.Reader) 

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
