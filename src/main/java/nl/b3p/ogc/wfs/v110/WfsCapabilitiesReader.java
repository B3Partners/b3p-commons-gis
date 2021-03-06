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
import nl.b3p.commons.services.B3PCredentials;
import nl.b3p.commons.services.HttpClientConfigured;
import nl.b3p.ogc.utils.OGCCommunication;
import nl.b3p.ogc.utils.OGCConstants;
import nl.b3p.ogc.utils.OGCRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
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

    /** Creates a new instance of WfsCapabilitiesReader */
    public WfsCapabilitiesReader() {
    }
    
    public WfsServiceProvider getProvider(String url) throws IOException, Exception {
        return getProvider(url,null);
    }

    public WfsServiceProvider getProvider(String url, B3PCredentials credentials) throws IOException, Exception {
        WfsServiceProvider provider = new WfsServiceProvider();
        
        HttpClientConfigured hcc = new HttpClientConfigured(credentials);
                
        OGCRequest or = new OGCRequest(url);
        or.addOrReplaceParameter(OGCConstants.WMS_REQUEST, OGCConstants.WFS_REQUEST_GetCapabilities);
        or.addOrReplaceParameter(OGCConstants.SERVICE, OGCConstants.WMS_PARAM_WFS);
        String eUrl = or.getUrl();

        HttpGet httpget = new HttpGet(eUrl);
        HttpResponse response = hcc.execute(httpget);
        
        try {
            HttpEntity entity = response.getEntity();

            if (entity == null) {
                //TODO uitzoeken of dit een goede test is.
                String body = getGetCapabilitieBody();
                HttpPost httppost = new HttpPost(body);
             //work around voor esri post request. Contenttype mag geen text/xml zijn.
                //postmethod.setRequestEntity(new StringRequestEntity(body, "text/xml", "UTF-8"));
                httppost.setEntity(new StringEntity(body));
                response = hcc.execute(httppost);
                entity = response.getEntity();
            }

            if (entity != null) {
                InputStream is = entity.getContent();

                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                dbf.setNamespaceAware(true);
                DocumentBuilder builder = dbf.newDocumentBuilder();
                Document doc = builder.parse(is);
                Element rootElement = doc.getDocumentElement();
   
                OGCCommunication ogcc = new OGCCommunication();
                ogcc.findNameSpace(doc);
                
                Unmarshaller um;
                Object o;
                String version = rootElement.getAttribute(OGCConstants.VERSION.toLowerCase());
                if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)) {
                    um = new Unmarshaller(nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities.class);
                    o = um.unmarshal(rootElement);
                    nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities wfsCapabilities = (nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities) o;

                    provider.setWfsVersion(wfsCapabilities.getVersion());
                    Date date = new Date(System.currentTimeMillis());
                    provider.setUpdatedDate(date);
                    String title = wfsCapabilities.getService().getTitle();
                    provider.setName("OGC:WFS");
                    provider.setTitle(title);
                    /*
                     * Info in Serviceprovider en layers opslaan
                     */
                    nl.b3p.xml.wfs.v100.capabilities.FeatureType[] featureTypeArray = wfsCapabilities.getFeatureTypeList().getFeatureType();
                    for (int i = 0; i < featureTypeArray.length; i++) {
                        nl.b3p.xml.wfs.v100.capabilities.FeatureType featureType = featureTypeArray[i];
                        WfsLayer layer = new WfsLayer();
                        String lname = ogcc.fixNsPrefix(featureType.getName());
                        layer.setName(lname);
                        String layerTitle = featureType.getTitle();
                        if (layerTitle != null && layerTitle.length() != 0) {
                            layer.setTitle(layerTitle);
                        } else {
                            layer.setTitle(layer.getName());
                        }
                        layer.setWfsServiceProvider(provider);
                        provider.addWfsLayer(layer);
                    }
                } else {
                    um = new Unmarshaller(nl.b3p.xml.wfs.v110.WFS_Capabilities.class);
                    o = um.unmarshal(rootElement);
                    nl.b3p.xml.wfs.v110.WFS_Capabilities wfsCapabilities = (nl.b3p.xml.wfs.v110.WFS_Capabilities) o;

                    provider.setWfsVersion(wfsCapabilities.getVersion());
                    Date date = new Date(System.currentTimeMillis());
                    provider.setUpdatedDate(date);
                    String title = wfsCapabilities.getServiceProvider().getProviderName();
                    provider.setName("OGC:WFS");
                    provider.setTitle(title);
                    /*
                     * Info in Serviceprovider en layers opslaan
                     */

                    nl.b3p.xml.wfs.v110.FeatureType[] featureTypeArray = wfsCapabilities.getFeatureTypeList().getFeatureType();
                    for (int i = 0; i < featureTypeArray.length; i++) {
                        nl.b3p.xml.wfs.v110.FeatureType featureType = featureTypeArray[i];
                        WfsLayer layer = new WfsLayer();
                        String lname = ogcc.fixNsPrefix(featureType.getName());
                        layer.setName(lname);
                        String layerTitle = featureType.getTitle();
                        if (layerTitle != null && layerTitle.length() != 0) {
                            layer.setTitle(layerTitle);
                        } else {
                            layer.setTitle(layer.getName());
                        }
                        layer.setWfsServiceProvider(provider);
                        provider.addWfsLayer(layer);
                    }
                }
            } else {
                log.error("Error doing Post getCapabilities: "
                        + response.getStatusLine().getStatusCode() + ": "
                        + getGetCapabilitieBody());
                throw new Exception("Error doing HTTPPost and HTTPGet method. Code returned: "
                        + response.getStatusLine().getStatusCode() + " request: "
                        + or.getUrl());
            }

        } finally {
            hcc.close(response);
            hcc.close();
        }

        provider.setUrl(url);
        return provider;
    }

    public String getGetCapabilitieBody() {
        String body = null;
        nl.b3p.xml.wfs.v110.GetCapabilities getCapabilities = new nl.b3p.xml.wfs.v110.GetCapabilities();
        getCapabilities.setService(OGCConstants.WFS_SERVICE_WFS);
        /*
         * getCapabilities body maken
         */
        try {
            StringWriter sw = new StringWriter();
            Marshaller m = new Marshaller(sw);
            m.setNamespaceMapping("wfs", "http://www.opengis.net/wfs");
            m.setNamespaceMapping("gml", "http://www.opengis.net/gml");
            m.setNamespaceMapping("ogc", "http://www.opengis.net/ogc");
            m.setNamespaceMapping("app", "http://www.deegree.org/app");
            m.setNamespaceMapping("xsi", "http://www.w3.org/2001/XMLSchema-instance");
            m.setSchemaLocation("http://www.opengis.net/wfs ../wfs/1.1.0/WFS.xsd");

            m.marshal(getCapabilities);
            body = sw.toString();
        } catch (Exception e) {
            throw new UnsupportedOperationException("Failed to make body for getCapabilities request!");
        }

        return body;
    }
}
