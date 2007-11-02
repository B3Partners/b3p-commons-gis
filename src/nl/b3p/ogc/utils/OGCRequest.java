/*
 * WMSParamUtil.java
 *
 * Created on 1 maart 2007, 14:44
 *
 * This util class is compatible with WFS 1.1.0 and WMS 1.1.1
 * 
 */

package nl.b3p.ogc.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Roy Braam
 */

/*TODO: Deze class is nu case insensitive doordat er bij add/remove/get/etc. Parameter worden de parameters opgehaald
 en opgeslagen in hoofdletters. Als KBconstants de goede Static String waarden heeft (casesensitive) dan kan het hier weg 
 zodat de klasse casesensitife is. Tevens kunnen dan alle strings die hier in staan worden vervangen door de constanten.*/
public class OGCRequest implements KBConstants{
    private static final Log log = LogFactory.getLog(OGCRequest.class);
    private String httpHost;
    private HashMap parameters;
    private HashMap nameSpaces;
    private HashMap schemaLocations;
    /*Default constr.*/
    public OGCRequest() {
    }
    /** Main constructor
     *
     * @param url The url that fills the OGCUrl object
     * 
     */
    public OGCRequest(String url){
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
                    addOrReplaceParameter(keyValuePair[0],keyValuePair[1]);
                else
                    addOrReplaceParameter(keyValuePair[0],null);
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
            s.append("<wfs:").append(this.getParameter(OGCRequest.WMS_REQUEST));
            if (this.getParameter(OGCRequest.WMS_VERSION)!=null)
                s.append(" version=\"").append(this.getParameter(OGCRequest.WMS_VERSION)).append("\"");
            if (this.getParameter(OGCRequest.WMS_SERVICE)!=null)
                s.append(" service=\"").append(this.getParameter(OGCRequest.WMS_SERVICE)).append("\"");
            if (this.getParameter(OGCRequest.WFS_PARAM_OUTPUTFORMAT)!=null)
                s.append(" outputFormat=\"").append(this.getParameter(OGCRequest.WFS_PARAM_OUTPUTFORMAT)).append("\"");
            if (this.getParameter(OGCRequest.WFS_PARAM_MAXFEATURES)!=null){
                s.append(" maxFeatures=\"").append(this.getParameter(OGCRequest.WFS_PARAM_MAXFEATURES)).append("\"");
            }
            
            String[] _nameSpaces=getNameSpacesArray();
            if (_nameSpaces!=null){
                for(int i=0; i < _nameSpaces.length; i++){
                    s.append(" ");
                    s.append(_nameSpaces[i]);
                }
            }
            String[] _schemaLocations=getSchemaLocationsArray();
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
                        s.append("<wfs:TypeName>");
                        s.append(types[i]);
                        s.append("</wfs:TypeName>");
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
                        else if (getParameter(WMS_PARAM_BBOX)!=null){
                            String[] tokens = getParameter(WMS_PARAM_BBOX).split(",");
                            s.append("<BBOX><PropertyName>msGeometry</PropertyName><Box><coordinates>");                            
                            s.append(tokens[0]+","+tokens[1]+" "+tokens[2]+","+tokens[3]);
                            s.append("</coordinates></Box></BBOX>");                                                        
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
            log.debug("Body created: "+s.toString());
            return s.toString();
        }else{            
            return null;
        }
    }
    
    public String getUrlWithNonOGCparams(){
        OGCRequest ogcu=(OGCRequest)this.clone();
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
        if (param==null)
            return null;
        param=param.toUpperCase();
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
        if (param==null)
            return null;
        param=param.toUpperCase();
        Object o=parameters.get(param);
        if (o==null)
            return null;
        return (String)o;
    }
    
    public boolean containsParameter(String param) {
        if (param == null)
            return false;
        
        param = param.toUpperCase();
        return parameters.containsKey(param);
    }
    
    /*Returns all nonOGC params
     */
    public HashMap getNonOGCParameters(){
        OGCRequest o = (OGCRequest) this.clone();
        o.removeAllWFSParameters();
        o.removeAllWMSParameters();
        return o.getParameters();
    }
     /** Adds or replaces a param with a value
     *
     * @param param The definition of the param that needs to be added or replaced.     
     * @param value The value that needs to be added
      *
     * @return previous value associated with specified param, or null  if there was no mapping for param
     */
    public String addOrReplaceParameter(String param, String value){
        if (param==null)
            return null;
        param=param.toUpperCase();
        Object o=parameters.get(param);
        if (value!=null)
            value=value.trim();
        parameters.put(param,value);
        if (o==null)
            return null;
        return (String)o;        
    }
    /** Adds or replaces a string with params
     *
     * @param params A String with parameters seperated by a '&'
     * 
      *
     * @return the number of added params
     */
    public int addOrReplaceParameters(String params){
        if (params==null)
            return 0;
        String tokens[]=params.split("&");
        for (int i=0; i < tokens.length; i++){           
            if (tokens[i].contains("=")){
                String keyValuePair[]=tokens[i].split("=");
                if (keyValuePair.length==2)
                    addOrReplaceParameter(keyValuePair[0],keyValuePair[1]);
                else
                    addOrReplaceParameter(keyValuePair[0],null);
            }            
        }
        return tokens.length;
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
    public String[] getParametersArray(){
        if (parameters==null)
            return null;
        String [] returnvalue= new String[parameters.size()];
        Set keys=parameters.keySet();
        Iterator it =keys.iterator();
        for (int i=0; it.hasNext(); i++){
            String key=(String)it.next();
            String value=(String)parameters.get(key);
            if(value == null) {
                value = "";
            }
            returnvalue[i]=key+"="+value;
        }
        return returnvalue;
    } 
    public String[] getNameSpacesArray() {
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
    private String[] getSchemaLocationsArray() {
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
    public Object clone(){
        OGCRequest returnv = new OGCRequest();
        returnv.setHttpHost(new String(this.getHttpHost()));
        if (this.getParameters()!=null)
            returnv.setParameters((HashMap)this.getParameters().clone());
        if (this.getNameSpaces()!=null)
            returnv.setNameSpaces((HashMap)this.getNameSpaces().clone());
        if (this.getSchemaLocations()!=null)
            returnv.setSchemaLocations((HashMap) this.getSchemaLocations().clone());
        return returnv;
    }

    protected String getHttpHost() {
        return httpHost;
    }

    protected void setHttpHost(String httpHost) {
        this.httpHost = httpHost;
    }

    protected HashMap getParameters() {
        return parameters;
    }

    protected void setParameters(HashMap parameters) {
        this.parameters = parameters;
    }

    protected void setNameSpaces(HashMap nameSpaces) {
        this.nameSpaces = nameSpaces;
    }

    protected void setSchemaLocations(HashMap schemaLocations) {
        this.schemaLocations = schemaLocations;
    }

    public HashMap getNameSpaces() {
        return nameSpaces;
    }

    public HashMap getSchemaLocations() {
        return schemaLocations;
    }
    
    public boolean isValidRequestURL(StringBuffer reason) throws Exception {        
        if (parameters == null)
            return false;
        
        if (reason == null)
            reason = new StringBuffer();
        
        if (containsParameter(REQUEST)) {
            String request = (String) parameters.get(REQUEST);
            if(request == null || request.equals("")) {
                throw new UnsupportedOperationException("No request parameter found in url!");
            }
            
            List requiredParams = null;
            if (SUPPORTED_REQUESTS.contains(request)) {
                if(request.equals(WMS_REQUEST_GetCapabilities)) {
                    if (containsParameter(SERVICE)) {
                        String service = (String) parameters.get(SERVICE);
                        if(service == null || service.equals("")) {
                            throw new UnsupportedOperationException("No service parameter for request found in url!");
                        }
                        if(service.equalsIgnoreCase(WMS_SERVICE_WMS)) {
                            requiredParams = REQUIRED_PARAMS_GetCapabilities;
                        } else if (service.equalsIgnoreCase(WFS_SERVICE_WFS)) {
                            //het is een WFS request
                        } else {
                            throw new UnsupportedOperationException("Service '" + service + "' not supported!");
                        }
                    } else {
                        throw new UnsupportedOperationException("No service parameter for request found in url!");
                    }
                } else if (request.equals(WMS_REQUEST_GetMap)) {
                    requiredParams = PARAMS_GetMap;
                } else if (request.equals(WMS_REQUEST_GetFeatureInfo)){
                    requiredParams = PARAMS_GetFeatureInfo;
                } else if (request.equals(WMS_REQUEST_GetLegendGraphic)) {
                    requiredParams = PARAMS_GetLegendGraphic;
                }                        
                if (isValidRequestURL(requiredParams, request, reason)) {
                    return true;
                }                        
            } else {
                throw new UnsupportedOperationException("Request '" + request + "' not supported! Use GetCapabilities request to " +
                    "get the list of supported functions. Usage: i.e. http://urltoserver/personalurl?REQUEST=GetCapabilities&" +
                    "VERSION=1.1.1&SERVICE=WMS");
            }            
        } else {
            throw new UnsupportedOperationException("No request parameter found in url!");
        }
        return false;
    }
    
    private boolean isValidRequestURL(List requiredParams, String request, StringBuffer reason) throws Exception {
        if (parameters == null || requiredParams == null || (parameters.isEmpty() && !requiredParams.isEmpty()))
            return false;
        
        Iterator it = requiredParams.iterator();
        while (it.hasNext()) {
            String parameter = (String) it.next();
            if(!parameters.containsKey(parameter)){
                reason.append("Not all parameters for request '");
                reason.append(request);
                reason.append("' are available, missing parameter: ");
                reason.append(parameter);
                reason.append(".");
                return false;
            }
                
        }
        
        //Alle parameter keys zijn wel aanwezig, test nu op waarden
        it = requiredParams.iterator();
        while (it.hasNext()) {
            String parameter = (String) it.next();
            if(!parameter.equalsIgnoreCase(WMS_PARAM_STYLES))
                if(this.getParameter(parameter) == null) {
                    //TODO:
                    //Deze throw clausule straks nog uitbreiden met eventuele hints als
                    //deze voor handen zijn, door in de constanten voor de verschillende
                    //params een lijst te generenen met waarden die daar voor verplicht zijn
                    //en wat de maximum waarden dan zijn....
                    reason.append("Value for parameter ");
                    reason.append(parameter);
                    reason.append(" is missing.");
                    return false;
            
                    //Hier moet dus niet alleen een controle uitgevoerd worden of een value
                    //bestaat, maar ook of deze value voor de betreffende parameter kolpt
                    //indien ja, dan kan gewoon true gereturned worden, anders moet er OF
                    //een foutmelding gegeven worden dat de value niet bestaat OF
                    //een foutmelding gegeven worden dat de value niet klopt!
                }
        }
        
        return true;
    }
    /*
    private void validateParams() throws Exception {
        int width  = Integer.parseInt(getParameter(WMS_PARAM_WIDTH));
        int height = Integer.parseInt(getParameter(WMS_PARAM_HEIGHT));
        if(width < 1 || height < 1 || width > 2048 || height > 2048) {
            log.error("Image wrong size: width, height: " + width + ", " + height);
            throw new Exception(IMAGE_SIZE_EXCEPTION);
        }
        
        String [] boxx = (getParameter(WMS_PARAM_BBOX)).split(",");
        if(boxx.length < 4) {
            log.error("BBOX wrong size: " + boxx.length);
            throw new Exception(BBOX_EXCEPTION);
        }
        
        double minx=0.0, miny=0.0, maxx=-1.0, maxy=-1.0;
        try {
            minx = Double.parseDouble(boxx[0]);
            miny = Double.parseDouble(boxx[1]);
            maxx = Double.parseDouble(boxx[2]);
            maxy = Double.parseDouble(boxx[3]);
            if (minx > maxx || miny > maxy) {
                throw new Exception("");
            }
        } catch (Exception e) {
            log.error("BBOX error minx, miny, maxx, maxy: " + minx+ ", "+ miny+ ", "+maxx+ ", "+maxy);
            throw new Exception(BBOX_EXCEPTION);
        }
    }
    
    
    public static void main(String [] args) {
        OGCRequest ogc = new OGCRequest();
        Iterator it = TEST_URLS.iterator();
        while (it.hasNext()) {
            String url = (String) it.next();
            ogc.setUrl(url);
            
            try {
                boolean isvalid = ogc.isValidRequestURL();
                System.out.println(isvalid);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public static final List TEST_URLS = Arrays.asList(new String[] {
        "http://www.kb.nl/wms?REQUEST=GetCapabilities&SERVICE=wms&VERSION=1.1.1",
        //"http://www.kb.nl/wms?REQUEST=GetCapabilities&SERVICE=wms",
        "http://www.kb.nl/wms?REQUEST=GetMap&SERVICE=wms&VERSION=1.1.1&LAYERS=&STYLES=&SRS=&BBOX=&WIDTH=&HEIGHT=&FORMAT=",
        "http://www.kb.nl/wms?REQUEST=GetCapabilities"
    });
    */
}
