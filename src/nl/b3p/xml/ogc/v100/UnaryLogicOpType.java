/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v100;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class UnaryLogicOpType.
 * 
 * @version $Revision$ $Date$
 */
public class UnaryLogicOpType extends nl.b3p.xml.ogc.v100.LogicOpsType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _comparisonOps
     */
    private nl.b3p.xml.ogc.v100.ComparisonOps _comparisonOps;

    /**
     * Field _spatialOps
     */
    private nl.b3p.xml.ogc.v100.SpatialOps _spatialOps;

    /**
     * Field _logicOps
     */
    private nl.b3p.xml.ogc.v100.LogicOps _logicOps;


      //----------------/
     //- Constructors -/
    //----------------/

    public UnaryLogicOpType() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v100.UnaryLogicOpType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return Object
     * @return the value of field 'choiceValue'.
     */
    public java.lang.Object getChoiceValue()
    {
        return this._choiceValue;
    } //-- java.lang.Object getChoiceValue() 

    /**
     * Returns the value of field 'comparisonOps'.
     * 
     * @return ComparisonOps
     * @return the value of field 'comparisonOps'.
     */
    public nl.b3p.xml.ogc.v100.ComparisonOps getComparisonOps()
    {
        return this._comparisonOps;
    } //-- nl.b3p.xml.ogc.v100.ComparisonOps getComparisonOps() 

    /**
     * Returns the value of field 'logicOps'.
     * 
     * @return LogicOps
     * @return the value of field 'logicOps'.
     */
    public nl.b3p.xml.ogc.v100.LogicOps getLogicOps()
    {
        return this._logicOps;
    } //-- nl.b3p.xml.ogc.v100.LogicOps getLogicOps() 

    /**
     * Returns the value of field 'spatialOps'.
     * 
     * @return SpatialOps
     * @return the value of field 'spatialOps'.
     */
    public nl.b3p.xml.ogc.v100.SpatialOps getSpatialOps()
    {
        return this._spatialOps;
    } //-- nl.b3p.xml.ogc.v100.SpatialOps getSpatialOps() 

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
     * Sets the value of field 'comparisonOps'.
     * 
     * @param comparisonOps the value of field 'comparisonOps'.
     */
    public void setComparisonOps(nl.b3p.xml.ogc.v100.ComparisonOps comparisonOps)
    {
        this._comparisonOps = comparisonOps;
        this._choiceValue = comparisonOps;
    } //-- void setComparisonOps(nl.b3p.xml.ogc.v100.ComparisonOps) 

    /**
     * Sets the value of field 'logicOps'.
     * 
     * @param logicOps the value of field 'logicOps'.
     */
    public void setLogicOps(nl.b3p.xml.ogc.v100.LogicOps logicOps)
    {
        this._logicOps = logicOps;
        this._choiceValue = logicOps;
    } //-- void setLogicOps(nl.b3p.xml.ogc.v100.LogicOps) 

    /**
     * Sets the value of field 'spatialOps'.
     * 
     * @param spatialOps the value of field 'spatialOps'.
     */
    public void setSpatialOps(nl.b3p.xml.ogc.v100.SpatialOps spatialOps)
    {
        this._spatialOps = spatialOps;
        this._choiceValue = spatialOps;
    } //-- void setSpatialOps(nl.b3p.xml.ogc.v100.SpatialOps) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return LogicOpsType
     */
    public static nl.b3p.xml.ogc.v100.LogicOpsType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.ogc.v100.LogicOpsType) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.UnaryLogicOpType.class, reader);
    } //-- nl.b3p.xml.ogc.v100.LogicOpsType unmarshal(java.io.Reader) 

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
