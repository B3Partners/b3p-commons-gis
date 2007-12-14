/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v110;

/**
 * Class QueryTypeChoiceItem.
 * 
 * @version $Revision$ $Date$
 */
public class QueryTypeChoiceItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The Property element is used to specify one or more
     *  properties of a feature whose values are to be retrieved
     *  by a Web Feature Service. 
     *  
     *  While a Web Feature Service should endeavour to satisfy
     *  the exact request specified, in some instance this may
     *  not be possible. Specifically, a Web Feature Service
     *  must generate a valid GML3 response to a Query operation.
     *  The schema used to generate the output may include 
     *  properties that are mandatory. In order that the output
     *  validates, these mandatory properties must be specified
     *  in the request. If they are not, a Web Feature Service
     *  may add them automatically to the Query before processing
     *  it. Thus a client application should, in general, be
     *  prepared to receive more properties than it requested.
     *  
     *  Of course, using the DescribeFeatureType request, a client
     *  application can determine which properties are mandatory
     *  and request them in the first place.
     *  
     */
    private java.lang.String _propertyName;

    /**
     * This element may be used in place of an wfs:PropertyName
     * element
     *  in a wfs:Query element in a wfs:GetFeature element to
     * selectively
     *  request the traversal of nested XLinks in the returned
     * element for
     *  the named property. This element may not be used in other
     * requests
     *  -- GetFeatureWithLock, LockFeature, Insert, Update, Delete
     * -- in
     *  this version of the WFS specification.
     *  
     */
    private nl.b3p.xml.wfs.v110.XlinkPropertyName _xlinkPropertyName;

    /**
     * A function may be used as a select item in a query.
     *  However, if a function is used, care must be taken
     *  to ensure that the result type matches the type in the 
     *  
     *  
     */
    private nl.b3p.xml.ogc.v110.Function _function;


      //----------------/
     //- Constructors -/
    //----------------/

    public QueryTypeChoiceItem() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v110.QueryTypeChoiceItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'function'. The field 'function'
     * has the following description: A function may be used as a
     * select item in a query.
     *  However, if a function is used, care must be taken
     *  to ensure that the result type matches the type in the 
     *  
     *  
     * 
     * @return Function
     * @return the value of field 'function'.
     */
    public nl.b3p.xml.ogc.v110.Function getFunction()
    {
        return this._function;
    } //-- nl.b3p.xml.ogc.v110.Function getFunction() 

    /**
     * Returns the value of field 'propertyName'. The field
     * 'propertyName' has the following description: The Property
     * element is used to specify one or more
     *  properties of a feature whose values are to be retrieved
     *  by a Web Feature Service. 
     *  
     *  While a Web Feature Service should endeavour to satisfy
     *  the exact request specified, in some instance this may
     *  not be possible. Specifically, a Web Feature Service
     *  must generate a valid GML3 response to a Query operation.
     *  The schema used to generate the output may include 
     *  properties that are mandatory. In order that the output
     *  validates, these mandatory properties must be specified
     *  in the request. If they are not, a Web Feature Service
     *  may add them automatically to the Query before processing
     *  it. Thus a client application should, in general, be
     *  prepared to receive more properties than it requested.
     *  
     *  Of course, using the DescribeFeatureType request, a client
     *  application can determine which properties are mandatory
     *  and request them in the first place.
     *  
     * 
     * @return String
     * @return the value of field 'propertyName'.
     */
    public java.lang.String getPropertyName()
    {
        return this._propertyName;
    } //-- java.lang.String getPropertyName() 

    /**
     * Returns the value of field 'xlinkPropertyName'. The field
     * 'xlinkPropertyName' has the following description: This
     * element may be used in place of an wfs:PropertyName element
     *  in a wfs:Query element in a wfs:GetFeature element to
     * selectively
     *  request the traversal of nested XLinks in the returned
     * element for
     *  the named property. This element may not be used in other
     * requests
     *  -- GetFeatureWithLock, LockFeature, Insert, Update, Delete
     * -- in
     *  this version of the WFS specification.
     *  
     * 
     * @return XlinkPropertyName
     * @return the value of field 'xlinkPropertyName'.
     */
    public nl.b3p.xml.wfs.v110.XlinkPropertyName getXlinkPropertyName()
    {
        return this._xlinkPropertyName;
    } //-- nl.b3p.xml.wfs.v110.XlinkPropertyName getXlinkPropertyName() 

    /**
     * Sets the value of field 'function'. The field 'function' has
     * the following description: A function may be used as a
     * select item in a query.
     *  However, if a function is used, care must be taken
     *  to ensure that the result type matches the type in the 
     *  
     *  
     * 
     * @param function the value of field 'function'.
     */
    public void setFunction(nl.b3p.xml.ogc.v110.Function function)
    {
        this._function = function;
    } //-- void setFunction(nl.b3p.xml.ogc.v110.Function) 

    /**
     * Sets the value of field 'propertyName'. The field
     * 'propertyName' has the following description: The Property
     * element is used to specify one or more
     *  properties of a feature whose values are to be retrieved
     *  by a Web Feature Service. 
     *  
     *  While a Web Feature Service should endeavour to satisfy
     *  the exact request specified, in some instance this may
     *  not be possible. Specifically, a Web Feature Service
     *  must generate a valid GML3 response to a Query operation.
     *  The schema used to generate the output may include 
     *  properties that are mandatory. In order that the output
     *  validates, these mandatory properties must be specified
     *  in the request. If they are not, a Web Feature Service
     *  may add them automatically to the Query before processing
     *  it. Thus a client application should, in general, be
     *  prepared to receive more properties than it requested.
     *  
     *  Of course, using the DescribeFeatureType request, a client
     *  application can determine which properties are mandatory
     *  and request them in the first place.
     *  
     * 
     * @param propertyName the value of field 'propertyName'.
     */
    public void setPropertyName(java.lang.String propertyName)
    {
        this._propertyName = propertyName;
    } //-- void setPropertyName(java.lang.String) 

    /**
     * Sets the value of field 'xlinkPropertyName'. The field
     * 'xlinkPropertyName' has the following description: This
     * element may be used in place of an wfs:PropertyName element
     *  in a wfs:Query element in a wfs:GetFeature element to
     * selectively
     *  request the traversal of nested XLinks in the returned
     * element for
     *  the named property. This element may not be used in other
     * requests
     *  -- GetFeatureWithLock, LockFeature, Insert, Update, Delete
     * -- in
     *  this version of the WFS specification.
     *  
     * 
     * @param xlinkPropertyName the value of field
     * 'xlinkPropertyName'.
     */
    public void setXlinkPropertyName(nl.b3p.xml.wfs.v110.XlinkPropertyName xlinkPropertyName)
    {
        this._xlinkPropertyName = xlinkPropertyName;
    } //-- void setXlinkPropertyName(nl.b3p.xml.wfs.v110.XlinkPropertyName) 

}
