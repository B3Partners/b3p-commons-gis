/*
 * WMSParamUtil.java
 *
 * Created on 1 maart 2007, 14:44
 *
 * This util class is compatible with WFS 1.1.0 and WMS 1.1.1
 * 
 */

package nl.b3p.ogc.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import nl.b3p.wms.capabilities.KBConstants;

/**
 *
 * @author Roy
 */
public class OGCUrl implements KBConstants{
    private String httpHost;
    private HashMap parameters;
    private HashMap nameSpaces;
    private HashMap schemaLocations;
    /*Default constr.*/
    public OGCUrl() {
    }
    /** Main constructor
     *
     * @param url The url that fills the OGCUrl object
     * 
     */
    public OGCUrl(String url){
        setUrl(url);
    }
     /** Main methode to fill the OGUrl object
     *
     * @param url The url that fills the OGCUrl object
     *
     * @return the param value that is removed or null if the parameter key not is found
     */
    public void setUrl(String url){
        if (url==null)
            return;
        parameters=new HashMap();
        httpHost="";
        String[] tokens=url.split ("\\?|&");
        for (int i=0; i < tokens.length; i++){
            if (i==0)
                httpHost=tokens[i];
            if (tokens[i].contains("=")){
                String keyValuePair[]=tokens[i].split("=");
                if (keyValuePair.length==2)
                    parameters.put(keyValuePair[0],keyValuePair[1]);
                else
                    parameters.put(keyValuePair[0],null);
            }            
        }
    }
    /** Gets the full url with the params
     *
     * @return the full url.
     */
    public String getUrl(){
        StringBuffer sb = new StringBuffer();
        sb.append(httpHost);
        sb.append("?");
        Set keys=parameters.keySet();
        Iterator it=keys.iterator();
        while(it.hasNext()){
            Object o= it.next();
            if (o!=null){
                sb.append(o);
                sb.append("=");
                if (parameters.get(o)!=null){
                    sb.append(parameters.get(o));
                }
                sb.append("&");
            }
        }
        if (sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
            return sb.toString();
        }else{
            return null;
        }
    }
    /**
     *Only WFS DiscribeFeaturetype and GetFeature are supported
     */
    public String getXMLBody() throws Exception{
        //check if request is either DiscribeFeaturetype or GetFeature
        if (getParameter(WMS_REQUEST)!=null && (getParameter(WMS_REQUEST).equalsIgnoreCase(WFS_REQUEST_DiscribeFeatureType)||getParameter(WMS_REQUEST).equalsIgnoreCase(WFS_REQUEST_GetFeature))){
            //set all needed namespaces and locations
            addOpengisNamespaces();
            addOpengisSchemaLocations();
            //build common part         
            StringBuffer s = new StringBuffer();
            s.append("<?xml version=\"1.0\"?>");
            s.append("<wfs:").append(this.getParameter(OGCUrl.WMS_REQUEST));
            if (this.getParameter(OGCUrl.WMS_VERSION)!=null)
                s.append(" version=\"").append(this.getParameter(OGCUrl.WMS_VERSION)).append("\"");
            if (this.getParameter(OGCUrl.WMS_SERVICE)!=null)
                s.append(" service=\"").append(this.getParameter(OGCUrl.WMS_SERVICE)).append("\"");
            if (this.getParameter(OGCUrl.WFS_PARAM_OUTPUTFORMAT)!=null)
                s.append(" outputFormat=\"").append(this.getParameter(OGCUrl.WFS_PARAM_OUTPUTFORMAT)).append("\"");
            if (this.getParameter(OGCUrl.WFS_PARAM_MAXFEATURES)!=null){
                s.append(" maxFeatures=\"").append(this.getParameter(OGCUrl.WFS_PARAM_MAXFEATURES)).append("\"");
            }
            String[] _nameSpaces=getNameSpaces();
            if (_nameSpaces!=null){
                for(int i=0; i < _nameSpaces.length; i++){
                    s.append(" ");
                    s.append(_nameSpaces[i]);
                }
            }
            String[] _schemaLocations=getSchemaLocations();
            if (_schemaLocations!=null){
                for(int i=0; i < _schemaLocations.length; i++){
                    s.append(" ").append(_schemaLocations[i]);
                }
            }
            s.append(">");
            //create request specific part
            if (getParameter(WMS_REQUEST).equalsIgnoreCase(WFS_REQUEST_DiscribeFeatureType)){
                if (getParameter(WFS_PARAM_TYPENAME)!=null){
                    String[] types = getParameter(WFS_PARAM_TYPENAME).split(",");
                    for (int i=0; i < types.length; i++){
                        s.append("<wfs:").append(WFS_PARAM_TYPENAME).append(">");
                        s.append(types[i]);
                        s.append("</wfs:").append(WFS_PARAM_TYPENAME).append(">");
                    }
                }else{
                    throw new Exception("Typname required for "+getParameter(WMS_REQUEST));
                }
            }
            else if (getParameter(WMS_REQUEST).equalsIgnoreCase(WFS_REQUEST_GetFeature)){
                if (getParameter(WFS_PARAM_TYPENAME)!=null){
                    s.append("<wfs:Query typeName=\"");
                    String[] typenames=getParameter(WFS_PARAM_TYPENAME).split(",");
                    for (int i=0; i < typenames.length; i++){
                        if (i!=0)
                            s.append(",");
                        s.append(typenames[i]);
                    }
                    s.append("\"");
                    if (getParameter(WMS_PARAM_SRS)!=null){
                        s.append(" srsName=\"");
                        s.append(getParameter(WMS_PARAM_SRS));
                        s.append("\"");
                    }
                    s.append(">");
                    if (getParameter(WFS_PARAM_FILTER)!=null || getParameter(WMS_PARAM_BBOX)!=null){
                        s.append("<ogc:Filter>");
                        if (getParameter(WFS_PARAM_FILTER)!=null)
                            s.append(getParameter(WFS_PARAM_FILTER));
                        if (getParameter(WMS_PARAM_BBOX)!=null){
                            String[] tokens = getParameter(WMS_PARAM_BBOX).split(",");
                            s.append("<BBOX><PropertyName>msGeometry</PropertyName><Box><coordinates>");                            
                            s.append(tokens[0]+","+tokens[1]+" "+tokens[2]+","+tokens[3]);
                            s.append("</coordinates></Box></BBOX>");
                            
                            /*s.append("<ogc:Not><ogc:Disjoint><ogc:PropertyName>msGeometry</ogc:PropertyName><gml:Envelope><gml:lowerCorner>");
                            s.append(tokens[0]+" "+tokens[1]);
                            s.append("</gml:lowerCorner><gml:upperCorner>");
                            s.append(tokens[2]+" "+tokens[3]);
                            s.append("</gml:upperCorner></gml:Envelope></ogc:Disjoint></ogc:Not>");*/
                            
                            //s.append("<ogc:Not><ogc:PropertyIsNull><ogc:PropertyName>msGeometry</ogc:PropertyName></ogc:PropertyIsNull></ogc:Not>");
                        }
                        s.append("</ogc:Filter>");
                    }
                    s.append("</wfs:Query>");
                }else{
                    throw new Exception("Typname required for "+getParameter(WMS_REQUEST));
                }
            }
            else{
                throw new Exception("Request not supported");
            }
            s.append("</wfs:");
            s.append(getParameter(WMS_REQUEST));
            s.append(">");
            return s.toString();
        }else{
            return null;
        }
    }
    
    public String getUrlWithNonOGCparams(){
        OGCUrl ogcu=new OGCUrl(getUrl());
        ogcu.removeAllWMSParameters();
        ogcu.removeAllWFSParameters();
        return ogcu.getUrl();
    }
     /** Removes a parameter
     *
     * @param param The definition of the param that needs to be removed.     
     *
     * @return the param value that is removed or null if the parameter key not is found
     */
    public String removeParameter(String param) {
        Object o=parameters.remove(param);
        if (o==null){
            return null;
        }
        return (String)o;        
    }
    /**Return the value of the given param
     * @param param the param definition
     *
     * @return the value of the given param or null if the param isn't found.
     */
    public String getParameter(String param) {
        Object o=parameters.get(param);
        if (o==null)
            return null;
        return (String)o;        
    }
     /** Adds or replaces a param with a value
     *
     * @param param The definition of the param that needs to be added or replaced.     
     * @param value The value that needs to be added
      *
     * @return previous value associated with specified param, or null  if there was no mapping for param
     */
    public String addOrReplaceParameter(String param, String value){
        Object o=parameters.get(param);
        parameters.put(param,value.trim());
        if (o==null)
            return null;
        return (String)o;
    }   
     /** Removes all WMS parameters (version 1.1.1)
     *    
     */
    public void removeAllWMSParameters(){
        removeParameter(WMS_PARAM_BBOX);
        removeParameter(WMS_PARAM_TRANSPARENT);
        removeParameter(WMS_PARAM_FORMAT);
        removeParameter(WMS_PARAM_INFO_FORMAT);
        removeParameter(WMS_PARAM_LAYERS);
        removeParameter(WMS_PARAM_QUERY_LAYERS);
        removeParameter(WMS_PARAM_WIDTH);
        removeParameter(WMS_PARAM_HEIGHT);
        removeParameter(WMS_PARAM_FEATURECOUNT);
        removeParameter(WMS_PARAM_X);
        removeParameter(WMS_PARAM_Y);
        removeParameter(WMS_VERSION);
        removeParameter(WMS_REQUEST);
        removeParameter(WMS_PARAM_STYLES);
        removeParameter(WMS_PARAM_SRS);
        removeParameter(WMS_PARAM_BGCOLOR);
        removeParameter(WMS_PARAM_EXCEPTIONS);
        removeParameter(WMS_PARAM_TIME);
        removeParameter(WMS_PARAM_ELEVATION);
        removeParameter(WMS_PARAM_SLD);
        removeParameter(WMS_PARAM_WFS);
        removeParameter(WMS_SERVICE);
    }
    /** Removes all WFS parameters (version 1.0.0???)
     *    
     */
    public void removeAllWFSParameters(){
        /*TODO: misschien niet allwmsparameters verwijderen maar hier alle wfs params defineren.*/
        removeAllWMSParameters();        
        removeParameter(WFS_PARAM_OUTPUTFORMAT);
        removeParameter(WFS_PARAM_TYPENAME);
        removeParameter(WFS_PARAM_RESULTTYPE);
        removeParameter(WFS_PARAM_PROPERTYNAME);
        removeParameter(WFS_PARAM_FEATUREVERSION);
        removeParameter(WFS_PARAM_MAXFEATURES);
        removeParameter(WFS_PARAM_EXPIRY);
        removeParameter(WFS_PARAM_SRSNAME);
        removeParameter(WFS_PARAM_FEATUREID);
        removeParameter(WFS_PARAM_FILTER);        
        removeParameter(WFS_PARAM_SORTBY);
        removeParameter(WFS_PARAM_TRAVERSEXLINKDEPTH);
        removeParameter(WFS_PARAM_TRAVERSEXLINKEXPIRY);
        removeParameter(WFS_PARAM_PROPTRAVXLINKEXPIRY);
        removeParameter(WFS_PARAM_PROPTRAVXLINKDEPTH);
        removeParameter(WFS_PARAM_GMLOBJECTID);
        removeParameter(WFS_PARAM_RESULTTYPE);
    }
    
    public String toString(){
        return this.getUrl();
    }

    private String[] getNameSpaces() {
        if (nameSpaces==null)
            return null;
        String[] returnvalue= new String[nameSpaces.size()];
        Set keys=nameSpaces.keySet();
        Iterator it=keys.iterator();
        for(int i=0; it.hasNext();i++){
            String prefix=(String)it.next();
            String location=(String)nameSpaces.get(prefix);
            returnvalue[i]="xmlns:"+prefix+"=\""+location+"\"";
        }
        return returnvalue;
    }
    
    public void addOrReplaceNameSpace(String prefix, String nsUrl){
        if (prefix!=null && nsUrl!=null){            
            if (nameSpaces==null)
                nameSpaces=new HashMap();
            nameSpaces.put(prefix,nsUrl);
        }
    }
    private String[] getSchemaLocations() {
        if (schemaLocations==null)
            return null;
        String[] returnvalue= new String[schemaLocations.size()];
        Set keys=schemaLocations.keySet();
        Iterator it=keys.iterator();
        for(int i=0; it.hasNext();i++){
            String prefix=(String)it.next();
            String location=(String)nameSpaces.get(prefix);
            returnvalue[i]=prefix+":schemaLocation=\""+location+"\"";
        }
        return returnvalue;
    }
    public void addOrReplaceSchemaLocation(String prefix, String location){
        if (prefix!=null && location!=null){
            if (schemaLocations==null)
                schemaLocations=new HashMap();
            schemaLocations.put(prefix,location);
        }
    }
    /**
     *Adds all namespaces needed for OpenGis
     */
    private void addOpengisNamespaces(){
        if (nameSpaces==null)
            nameSpaces=new HashMap();
        if (!nameSpaces.containsKey("wfs"))
            addOrReplaceNameSpace("wfs","http://www.opengis.net/wfs");        
        if (!nameSpaces.containsKey("xsi"))
            addOrReplaceNameSpace("xsi","http://www.w3.org/2001/XMLSchema-instance");
        if (!nameSpaces.containsKey("gml"))
            addOrReplaceNameSpace("gml","http://www.opengis.net/gml");
        if (!nameSpaces.containsKey("ogc"))
            addOrReplaceNameSpace("ogc","http://www.opengis.net/ogc");
    }
    /**
     *Adds all Schemalocations needed for OpenGis
     */
    private void addOpengisSchemaLocations(){
        if (schemaLocations==null)
            schemaLocations=new HashMap();
        if (!schemaLocations.containsKey("xsi"))
            addOrReplaceSchemaLocation("xsi","http://www.opengis.net/wfs ../wfs/1.1.0/WFS.xsd");
    }
}
