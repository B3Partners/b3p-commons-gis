/*
 * WfsCapabilitiesReader.java
 *
 * Created on May 22, 2008, 2:00 PM
 *
 * Class to make GetCapabilities request for new Serviceprovider and make objects so it can be saves in the database
 */

package nl.b3p.ogc.wfs.v110;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import nl.b3p.ogc.utils.OGCConstants;
import nl.b3p.xml.wfs.v100.capabilities.FeatureType;
//import nl.b3p.xml.wfs.v110.FeatureType;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Jytte
 */
public class WfsCapabilitiesReader {
    private HashMap nameSpaces;
    private String schemaLocation;
    
    /** Creates a new instance of WfsCapabilitiesReader */
    public WfsCapabilitiesReader() {
        this.setNamespaces();
    }
    
    public WfsServiceProvider getProvider(String url)throws IOException, Exception {
        WfsServiceProvider provider = new WfsServiceProvider();
        
        PostMethod method = null;
        HttpClient client = new HttpClient();        
        String host = url;
        method = new PostMethod(host); 
        String body = getGetCapabilitieBody();
        method.setRequestEntity(new StringRequestEntity(body,"text/xml", "UTF-8"));
        int status = client.executeMethod(method);
        if (status == HttpStatus.SC_OK){
            InputStream is = method.getResponseBodyAsStream();
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            Document doc = builder.parse(is);
            Element rootElement = doc.getDocumentElement();
            
            Unmarshaller um;
            Object o;
            String version = rootElement.getAttribute(OGCConstants.VERSION.toLowerCase());
            if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)){
                um = new Unmarshaller(nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities.class);
                o = um.unmarshal(rootElement);              
                nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities wfsCapabilities = (nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities)o;
                
                provider.setWfsVersion(wfsCapabilities.getVersion());
                Date date =  new Date(System.currentTimeMillis());
                provider.setUpdatedDate(date);
                String title = wfsCapabilities.getService().getTitle();
                provider.setName("OGC:WFS");
                provider.setTitle(title);
                /*
                 * Info in Serviceprovider en layers opslaan
                 */
                nl.b3p.xml.wfs.v100.capabilities.FeatureType[] featureTypeArray = wfsCapabilities.getFeatureTypeList().getFeatureType();
                for(int i = 0; i < featureTypeArray.length; i++){
                    nl.b3p.xml.wfs.v100.capabilities.FeatureType featureType = featureTypeArray[i];
                    WfsLayer layer = new WfsLayer();
                    String[] name = featureType.getName().split("}");
                    layer.setName(name[1]); 
                    String layerTitle = featureType.getTitle();
                    if(layerTitle != "" && layerTitle != null){
                        layer.setTitle(layerTitle);
                    }else{
                        layer.setTitle(name[1]);
                    }
                    layer.setWfsServiceProvider(provider);
                    provider.addWfsLayer(layer);
                }
            }else{
                um = new Unmarshaller(nl.b3p.xml.wfs.v110.WFS_Capabilities.class);
                o = um.unmarshal(rootElement);              
                nl.b3p.xml.wfs.v110.WFS_Capabilities wfsCapabilities = (nl.b3p.xml.wfs.v110.WFS_Capabilities)o;
                
                provider.setWfsVersion(wfsCapabilities.getVersion());
                Date date =  new Date(System.currentTimeMillis());
                provider.setUpdatedDate(date);
                String title = wfsCapabilities.getServiceProvider().getProviderName();
                provider.setName("OGC:WFS");
                provider.setTitle(title);
                /*
                 * Info in Serviceprovider en layers opslaan
                 */    

                nl.b3p.xml.wfs.v110.FeatureType[] featureTypeArray = wfsCapabilities.getFeatureTypeList().getFeatureType();
                for(int i = 0; i < featureTypeArray.length; i++){
                    nl.b3p.xml.wfs.v110.FeatureType featureType = featureTypeArray[i];
                    WfsLayer layer = new WfsLayer();
                    String[] name = featureType.getName().split("}");
                    layer.setName(name[1]);
                    String layerTitle = featureType.getTitle();
                    if(layerTitle != "" && layerTitle != null){
                        layer.setTitle(layerTitle);
                    }else{
                        layer.setTitle(name[1]);
                    }
                    layer.setWfsServiceProvider(provider);
                    provider.addWfsLayer(layer);
                }
            }
        }
        
        provider.setUrl(url);
        return provider;
    }
    
    public String getGetCapabilitieBody(){
        String body = null;
        nl.b3p.xml.wfs.v110.GetCapabilities getCapabilities = new nl.b3p.xml.wfs.v110.GetCapabilities();
        getCapabilities.setService(OGCConstants.WFS_SERVICE_WFS);
        /*
         * getCapabilities body maken
         */
        try{
            StringWriter sw = new StringWriter();
            Marshaller m = new Marshaller(sw);
            if(nameSpaces != null){
                Set keys = nameSpaces.keySet();
                Iterator it = keys.iterator();
                for (int i = 0; it.hasNext(); i++) {
                    String prefix = (String) it.next();
                    String location = (String) nameSpaces.get(prefix);
                    m.setNamespaceMapping(prefix, location);
                }
            }
            m.setSchemaLocation(schemaLocation);

            m.marshal(getCapabilities);
            body = sw.toString();
        }catch(Exception e){
            throw new UnsupportedOperationException("Failed to make body for getCapabilities request!");
        }
        
        return body;
    }
    
    /*
     * Makes HashMaps of nameSpaces and schemalocations so they can be added to the getCapabilities request.
     * Because there is no request to save the namespaces from they are set here. Probably not all namespaces
     * are necessary.
     */
    public void setNamespaces(){
        nameSpaces = new HashMap();
        nameSpaces.put("wfs", "http://www.opengis.net/wfs");
        nameSpaces.put("gml", "http://www.opengis.net/gml");
        nameSpaces.put("ogc", "http://www.opengis.net/ogc");
        nameSpaces.put("app", "http://www.deegree.org/app");
        nameSpaces.put("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        
        schemaLocation = "http://www.opengis.net/wfs ../wfs/1.1.0/WFS.xsd";
    }
}