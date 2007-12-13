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
 * An Insert element may contain a feature collection or one 
 *  or more feature instances to be inserted into the 
 *  repository.
 *  
 * 
 * @version $Revision$ $Date$
 */
public class InsertElementType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The idgen attribute control how a WFS generates identifiers
     *  from newly created feature instances using the Insert
     * action.
     *  The default action is to have the WFS generate a new id for
     *  the features. This is also backward compatible with WFS 1.0
     *  where the only action was for the WFS to generate an new
     * id.
     *  
     */
    private nl.b3p.xml.wfs.v110.types.IdentifierGenerationOptionType _idgen = nl.b3p.xml.wfs.v110.types.IdentifierGenerationOptionType.valueOf("GenerateNew");

    /**
     * The handle attribute allows a client application
     *  to assign a client-generated request identifier
     *  to an Insert action. The handle is included to
     *  facilitate error reporting. If an Insert action
     *  in a Transaction request fails, then a WFS may
     *  include the handle in an exception report to localize
     *  the error. If no handle is included of the offending
     *  Insert element then a WFS may employee other means of
     *  localizing the error (e.g. line number).
     *  
     */
    private java.lang.String _handle;

    /**
     * This inputFormat attribute is used to indicate 
     *  the format used to encode a feature instance in
     *  an Insert element. The default value of
     *  'text/xml; subtype=gml/3.1.1' is used to indicate
     *  that feature encoding is GML3. Another example
     *  might be 'text/xml; subtype=gml/2.1.2' indicating
     *  that the feature us encoded in GML2. A WFS must
     *  declare in the capabilities document, using a 
     *  Parameter element, which version of GML it supports.
     *  
     */
    private java.lang.String _inputFormat = "text/xml; subtype=gml/3.1.1";

    /**
     * ===== PAV 12NOV2004 ====
     *  WHY IS THIS HERE? WOULDN'T WE KNOW THE INCOMING SRS FROM
     * THE 
     *  GML GEOMETRY ELEMENTS? I ASSUME THAT IF THE INCOMING SRS
     *  DOES NOT MATCH ONE OF THE STORAGE SRS(s) THEN THE WFS WOULD
     *  EITHER PROJECT INTO THE STORAGE SRS OR RAISE AN EXCEPTION.
     *  
     */
    private java.lang.String _srsName;

    /**
     * Field _FeatureList
     */
    private java.util.ArrayList _FeatureList;


      //----------------/
     //- Constructors -/
    //----------------/

    public InsertElementType() 
     {
        super();
        setIdgen(nl.b3p.xml.wfs.v110.types.IdentifierGenerationOptionType.valueOf("GenerateNew"));
        setInputFormat("text/xml; subtype=gml/3.1.1");
        _FeatureList = new java.util.ArrayList();
    } //-- nl.b3p.xml.wfs.v110.InsertElementType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addFeature
     * 
     * 
     * 
     * @param vFeature
     */
    public void addFeature(java.lang.Object vFeature)
        throws java.lang.IndexOutOfBoundsException
    {
        _FeatureList.add(vFeature);
    } //-- void addFeature(java.lang.Object) 

    /**
     * Method addFeature
     * 
     * 
     * 
     * @param index
     * @param vFeature
     */
    public void addFeature(int index, java.lang.Object vFeature)
        throws java.lang.IndexOutOfBoundsException
    {
        _FeatureList.add(index, vFeature);
    } //-- void addFeature(int, java.lang.Object) 

    /**
     * Method clearFeature
     * 
     */
    public void clearFeature()
    {
        _FeatureList.clear();
    } //-- void clearFeature() 

    /**
     * Method enumerateFeature
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateFeature()
    {
        return Collections.enumeration(_FeatureList);
    } //-- java.util.Enumeration enumerateFeature() 

    /**
     * Method getFeature
     * 
     * 
     * 
     * @param index
     * @return Object
     */
    public java.lang.Object getFeature(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _FeatureList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (java.lang.Object) _FeatureList.get(index);
    } //-- java.lang.Object getFeature(int) 

    /**
     * Method getFeature
     * 
     * 
     * 
     * @return Object
     */
    public java.lang.Object[] getFeature()
    {
        int size = _FeatureList.size();
        java.lang.Object[] mArray = new java.lang.Object[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (java.lang.Object) _FeatureList.get(index);
        }
        return mArray;
    } //-- java.lang.Object[] getFeature() 

    /**
     * Method getFeatureCount
     * 
     * 
     * 
     * @return int
     */
    public int getFeatureCount()
    {
        return _FeatureList.size();
    } //-- int getFeatureCount() 

    /**
     * Returns the value of field 'handle'. The field 'handle' has
     * the following description: The handle attribute allows a
     * client application
     *  to assign a client-generated request identifier
     *  to an Insert action. The handle is included to
     *  facilitate error reporting. If an Insert action
     *  in a Transaction request fails, then a WFS may
     *  include the handle in an exception report to localize
     *  the error. If no handle is included of the offending
     *  Insert element then a WFS may employee other means of
     *  localizing the error (e.g. line number).
     *  
     * 
     * @return String
     * @return the value of field 'handle'.
     */
    public java.lang.String getHandle()
    {
        return this._handle;
    } //-- java.lang.String getHandle() 

    /**
     * Returns the value of field 'idgen'. The field 'idgen' has
     * the following description: The idgen attribute control how a
     * WFS generates identifiers
     *  from newly created feature instances using the Insert
     * action.
     *  The default action is to have the WFS generate a new id for
     *  the features. This is also backward compatible with WFS 1.0
     *  where the only action was for the WFS to generate an new
     * id.
     *  
     * 
     * @return IdentifierGenerationOptionType
     * @return the value of field 'idgen'.
     */
    public nl.b3p.xml.wfs.v110.types.IdentifierGenerationOptionType getIdgen()
    {
        return this._idgen;
    } //-- nl.b3p.xml.wfs.v110.types.IdentifierGenerationOptionType getIdgen() 

    /**
     * Returns the value of field 'inputFormat'. The field
     * 'inputFormat' has the following description: This
     * inputFormat attribute is used to indicate 
     *  the format used to encode a feature instance in
     *  an Insert element. The default value of
     *  'text/xml; subtype=gml/3.1.1' is used to indicate
     *  that feature encoding is GML3. Another example
     *  might be 'text/xml; subtype=gml/2.1.2' indicating
     *  that the feature us encoded in GML2. A WFS must
     *  declare in the capabilities document, using a 
     *  Parameter element, which version of GML it supports.
     *  
     * 
     * @return String
     * @return the value of field 'inputFormat'.
     */
    public java.lang.String getInputFormat()
    {
        return this._inputFormat;
    } //-- java.lang.String getInputFormat() 

    /**
     * Returns the value of field 'srsName'. The field 'srsName'
     * has the following description: ===== PAV 12NOV2004 ====
     *  WHY IS THIS HERE? WOULDN'T WE KNOW THE INCOMING SRS FROM
     * THE 
     *  GML GEOMETRY ELEMENTS? I ASSUME THAT IF THE INCOMING SRS
     *  DOES NOT MATCH ONE OF THE STORAGE SRS(s) THEN THE WFS WOULD
     *  EITHER PROJECT INTO THE STORAGE SRS OR RAISE AN EXCEPTION.
     *  
     * 
     * @return String
     * @return the value of field 'srsName'.
     */
    public java.lang.String getSrsName()
    {
        return this._srsName;
    } //-- java.lang.String getSrsName() 

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
     * Method removeFeature
     * 
     * 
     * 
     * @param vFeature
     * @return boolean
     */
    public boolean removeFeature(java.lang.Object vFeature)
    {
        boolean removed = _FeatureList.remove(vFeature);
        return removed;
    } //-- boolean removeFeature(java.lang.Object) 

    /**
     * Method setFeature
     * 
     * 
     * 
     * @param index
     * @param vFeature
     */
    public void setFeature(int index, java.lang.Object vFeature)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _FeatureList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _FeatureList.set(index, vFeature);
    } //-- void setFeature(int, java.lang.Object) 

    /**
     * Method setFeature
     * 
     * 
     * 
     * @param featureArray
     */
    public void setFeature(java.lang.Object[] featureArray)
    {
        //-- copy array
        _FeatureList.clear();
        for (int i = 0; i < featureArray.length; i++) {
            _FeatureList.add(featureArray[i]);
        }
    } //-- void setFeature(java.lang.Object) 

    /**
     * Sets the value of field 'handle'. The field 'handle' has the
     * following description: The handle attribute allows a client
     * application
     *  to assign a client-generated request identifier
     *  to an Insert action. The handle is included to
     *  facilitate error reporting. If an Insert action
     *  in a Transaction request fails, then a WFS may
     *  include the handle in an exception report to localize
     *  the error. If no handle is included of the offending
     *  Insert element then a WFS may employee other means of
     *  localizing the error (e.g. line number).
     *  
     * 
     * @param handle the value of field 'handle'.
     */
    public void setHandle(java.lang.String handle)
    {
        this._handle = handle;
    } //-- void setHandle(java.lang.String) 

    /**
     * Sets the value of field 'idgen'. The field 'idgen' has the
     * following description: The idgen attribute control how a WFS
     * generates identifiers
     *  from newly created feature instances using the Insert
     * action.
     *  The default action is to have the WFS generate a new id for
     *  the features. This is also backward compatible with WFS 1.0
     *  where the only action was for the WFS to generate an new
     * id.
     *  
     * 
     * @param idgen the value of field 'idgen'.
     */
    public void setIdgen(nl.b3p.xml.wfs.v110.types.IdentifierGenerationOptionType idgen)
    {
        this._idgen = idgen;
    } //-- void setIdgen(nl.b3p.xml.wfs.v110.types.IdentifierGenerationOptionType) 

    /**
     * Sets the value of field 'inputFormat'. The field
     * 'inputFormat' has the following description: This
     * inputFormat attribute is used to indicate 
     *  the format used to encode a feature instance in
     *  an Insert element. The default value of
     *  'text/xml; subtype=gml/3.1.1' is used to indicate
     *  that feature encoding is GML3. Another example
     *  might be 'text/xml; subtype=gml/2.1.2' indicating
     *  that the feature us encoded in GML2. A WFS must
     *  declare in the capabilities document, using a 
     *  Parameter element, which version of GML it supports.
     *  
     * 
     * @param inputFormat the value of field 'inputFormat'.
     */
    public void setInputFormat(java.lang.String inputFormat)
    {
        this._inputFormat = inputFormat;
    } //-- void setInputFormat(java.lang.String) 

    /**
     * Sets the value of field 'srsName'. The field 'srsName' has
     * the following description: ===== PAV 12NOV2004 ====
     *  WHY IS THIS HERE? WOULDN'T WE KNOW THE INCOMING SRS FROM
     * THE 
     *  GML GEOMETRY ELEMENTS? I ASSUME THAT IF THE INCOMING SRS
     *  DOES NOT MATCH ONE OF THE STORAGE SRS(s) THEN THE WFS WOULD
     *  EITHER PROJECT INTO THE STORAGE SRS OR RAISE AN EXCEPTION.
     *  
     * 
     * @param srsName the value of field 'srsName'.
     */
    public void setSrsName(java.lang.String srsName)
    {
        this._srsName = srsName;
    } //-- void setSrsName(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return InsertElementType
     */
    public static nl.b3p.xml.wfs.v110.InsertElementType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (nl.b3p.xml.wfs.v110.InsertElementType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.InsertElementType.class, reader);
    } //-- nl.b3p.xml.wfs.v110.InsertElementType unmarshal(java.io.Reader) 

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
