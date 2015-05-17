/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v110;

/**
 * Class FeaturesLockedTypeItem.
 * 
 * @version $Revision$ $Date$
 */
public class FeaturesLockedTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _featureId
     */
    private nl.b3p.xml.ogc.v110.FeatureId _featureId;


      //----------------/
     //- Constructors -/
    //----------------/

    public FeaturesLockedTypeItem() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v110.FeaturesLockedTypeItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'featureId'.
     * 
     * @return FeatureId
     * @return the value of field 'featureId'.
     */
    public nl.b3p.xml.ogc.v110.FeatureId getFeatureId()
    {
        return this._featureId;
    } //-- nl.b3p.xml.ogc.v110.FeatureId getFeatureId() 

    /**
     * Sets the value of field 'featureId'.
     * 
     * @param featureId the value of field 'featureId'.
     */
    public void setFeatureId(nl.b3p.xml.ogc.v110.FeatureId featureId)
    {
        this._featureId = featureId;
    } //-- void setFeatureId(nl.b3p.xml.ogc.v110.FeatureId) 

}
