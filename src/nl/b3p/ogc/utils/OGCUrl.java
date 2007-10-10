/*
 * WMSParamUtil.java
 *
 * Created on 1 maart 2007, 14:44
 *
 * This util class is compatible with WFS 1.1.0 and WMS 1.1.1
 * 
 */

package nl.b3p.ogc.utils;

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
}
