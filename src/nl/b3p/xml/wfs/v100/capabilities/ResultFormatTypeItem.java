/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100.capabilities;

/**
 * Class ResultFormatTypeItem.
 * 
 * @version $Revision$ $Date$
 */
public class ResultFormatTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _GML2
     */
    private nl.b3p.xml.wfs.v100.capabilities.GML2 _GML2;

    /**
     * Field _GML3
     */
    private java.lang.Object _GML3;

    /**
     * Field _GEOJSON
     */
    private java.lang.Object _GEOJSON;

    /**
     * Field _CSV
     */
    private java.lang.Object _CSV;

    /**
     * Field _SHAPEZIP
     */
    private java.lang.Object _SHAPEZIP;
    
    /**
     * Field _JSON
     */
    private java.lang.Object _JSON;

    /**
     * Field _KML
     */
    private java.lang.Object _KML;

      //----------------/
     //- Constructors -/
    //----------------/

    public ResultFormatTypeItem() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v100.capabilities.ResultFormatTypeItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'CSV'.
     * 
     * @return Object
     * @return the value of field 'CSV'.
     */
    public java.lang.Object getCSV()
    {
        return this._CSV;
    } //-- java.lang.Object getCSV() 

    /**
     * Returns the value of field 'GEOJSON'.
     * 
     * @return Object
     * @return the value of field 'GEOJSON'.
     */
    public java.lang.Object getGEOJSON()
    {
        return this._GEOJSON;
    } //-- java.lang.Object getGEOJSON() 

    /**
     * Returns the value of field 'GML2'.
     * 
     * @return GML2
     * @return the value of field 'GML2'.
     */
    public nl.b3p.xml.wfs.v100.capabilities.GML2 getGML2()
    {
        return this._GML2;
    } //-- nl.b3p.xml.wfs.v100.capabilities.GML2 getGML2() 

    /**
     * Returns the value of field 'GML3'.
     * 
     * @return Object
     * @return the value of field 'GML3'.
     */
    public java.lang.Object getGML3()
    {
        return this._GML3;
    } //-- java.lang.Object getGML3() 

    /**
     * Returns the value of field 'SHAPEZIP'.
     * 
     * @return Object
     * @return the value of field 'SHAPEZIP'.
     */
    public java.lang.Object getSHAPEZIP()
    {
        return this._SHAPEZIP;
    } //-- java.lang.Object getSHAPEZIP() 

    /**
     * Sets the value of field 'CSV'.
     * 
     * @param CSV the value of field 'CSV'.
     */
    public void setCSV(java.lang.Object CSV)
    {
        this._CSV = CSV;
    } //-- void setCSV(java.lang.Object) 

    /**
     * Sets the value of field 'GEOJSON'.
     * 
     * @param GEOJSON the value of field 'GEOJSON'.
     */
    public void setGEOJSON(java.lang.Object GEOJSON)
    {
        this._GEOJSON = GEOJSON;
    } //-- void setGEOJSON(java.lang.Object) 

    /**
     * Sets the value of field 'GML2'.
     * 
     * @param GML2 the value of field 'GML2'.
     */
    public void setGML2(nl.b3p.xml.wfs.v100.capabilities.GML2 GML2)
    {
        this._GML2 = GML2;
    } //-- void setGML2(nl.b3p.xml.wfs.v100.capabilities.GML2) 

    /**
     * Sets the value of field 'GML3'.
     * 
     * @param GML3 the value of field 'GML3'.
     */
    public void setGML3(java.lang.Object GML3)
    {
        this._GML3 = GML3;
    } //-- void setGML3(java.lang.Object) 

    /**
     * Sets the value of field 'SHAPEZIP'.
     * 
     * @param SHAPEZIP the value of field 'SHAPEZIP'.
     */
    public void setSHAPEZIP(java.lang.Object SHAPEZIP)
    {
        this._SHAPEZIP = SHAPEZIP;
    } //-- void setSHAPEZIP(java.lang.Object) 
    
    
    public java.lang.Object getJSON()
    {
        return this._JSON;
    }
    
    public void setJSON(java.lang.Object JSON)
    {
        this._JSON = JSON;
    }
    
    public java.lang.Object getKML()
    {
        return this._KML;
    }
    
    public void setKML(java.lang.Object KML)
    {
        this._KML = KML;
    }

}
