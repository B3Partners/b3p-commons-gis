/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v110.capabilities;

/**
 * Class Id_CapabilitiesTypeItem.
 * 
 * @version $Revision$ $Date$
 */
public class Id_CapabilitiesTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _EID
     */
    private nl.b3p.xml.ogc.v110.capabilities.EID _EID;

    /**
     * Field _FID
     */
    private nl.b3p.xml.ogc.v110.capabilities.FID _FID;


      //----------------/
     //- Constructors -/
    //----------------/

    public Id_CapabilitiesTypeItem() 
     {
        super();
    } //-- nl.b3p.xml.ogc.v110.capabilities.Id_CapabilitiesTypeItem()


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
     * Returns the value of field 'EID'.
     * 
     * @return EID
     * @return the value of field 'EID'.
     */
    public nl.b3p.xml.ogc.v110.capabilities.EID getEID()
    {
        return this._EID;
    } //-- nl.b3p.xml.ogc.v110.capabilities.EID getEID() 

    /**
     * Returns the value of field 'FID'.
     * 
     * @return FID
     * @return the value of field 'FID'.
     */
    public nl.b3p.xml.ogc.v110.capabilities.FID getFID()
    {
        return this._FID;
    } //-- nl.b3p.xml.ogc.v110.capabilities.FID getFID() 

    /**
     * Sets the value of field 'EID'.
     * 
     * @param EID the value of field 'EID'.
     */
    public void setEID(nl.b3p.xml.ogc.v110.capabilities.EID EID)
    {
        this._EID = EID;
        this._choiceValue = EID;
    } //-- void setEID(nl.b3p.xml.ogc.v110.capabilities.EID) 

    /**
     * Sets the value of field 'FID'.
     * 
     * @param FID the value of field 'FID'.
     */
    public void setFID(nl.b3p.xml.ogc.v110.capabilities.FID FID)
    {
        this._FID = FID;
        this._choiceValue = FID;
    } //-- void setFID(nl.b3p.xml.ogc.v110.capabilities.FID) 

}
