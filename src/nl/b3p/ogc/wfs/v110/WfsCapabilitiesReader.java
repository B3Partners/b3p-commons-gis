/*
 * B3P Commons GIS is a library with commonly used classes for OGC
 * reading and writing. Included are wms, wfs, gml, csv and other
 * general helper classes and extensions.
 *
 * Copyright 2005 - 2008 B3Partners BV
 * 
 * This file is part of B3P Commons GIS.
 * 
 * B3P Commons GIS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * B3P Commons GIS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with B3P Commons GIS.  If not, see <http://www.gnu.org/licenses/>.
 */

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
import nl.b3p.ogc.utils.OGCRequest;
//import nl.b3p.xml.wfs.v110.FeatureType;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Jytte
 */
public class WfsCapabilitiesReader {
    private static final Log log = LogFactory.getLog(WfsCapabilitiesReader.class);
    private HashMap nameSpaces;
    private String schemaLocation;
    
    /** Creates a new instance of WfsCapabilitiesReader */
    public WfsCapabilitiesReader() {
        this.setNamespaces();
    }
    
    public WfsServiceProvider getProvider(String url)throws IOException, Exception {
        WfsServiceProvider provider = new WfsServiceProvider();
        HttpMethod method=null;
        //PostMethod postMethod = null;
        HttpClient client = new HttpClient();        
        String host = url;
        OGCRequest or = new OGCRequest(url);
        or.addOrReplaceParameter(OGCConstants.WMS_REQUEST, OGCConstants.WFS_REQUEST_GetCapabilities);
        or.addOrReplaceParameter(OGCConstants.SERVICE, OGCConstants.WMS_PARAM_WFS);
        method= new GetMethod(or.getUrl());
        int status=client.executeMethod(method);
        if (status != HttpStatus.SC_OK){
            log.error("Error doing Get getCapabilities: "+status+": "+method.getResponseBodyAsString());
            log.info("try doing a Post getCapabilities");
            method = new PostMethod(host);
            String body = getGetCapabilitieBody();
            ((PostMethod)method).setRequestEntity(new StringRequestEntity(body,"text/xml", "UTF-8"));
            status = client.executeMethod(method);
        }
        if(status == HttpStatus.SC_OK){
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
        }else{
            log.error("Error doing Post getCapabilities: "+status+": "+method.getResponseBodyAsString());
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
