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
package nl.b3p.wms.capabilities;

import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import nl.b3p.ogc.utils.KBCrypter;
import nl.b3p.ogc.utils.OGCCommunication;
import nl.b3p.ogc.utils.OGCConstants;
import nl.b3p.ogc.utils.OGCRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class LayerDomainResource implements XMLElement {

    public static final String METADATA_DOMAIN = "MetadataURL";
    private static final Log log = LogFactory.getLog(LayerDomainResource.class);
    private Integer id;
    private Set formats;
    private String url;
    private String domain;
    private Layer layer;

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public Set getFormats() {
        return formats;
    }

    public void setFormats(Set formats) {
        this.formats = formats;
    }

    public void addFormat(String f) {
        if (null == formats) {
            formats = new HashSet();
        }
        formats.add(f);
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Layer getLayer() {
        return layer;
    }

    public void setLayer(Layer layer) {
        this.layer = layer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /** Method that will create a deep copy of this object.
     *
     * @return an object of type Object
     */
    public Object clone() {
        LayerDomainResource cloneLDR = new LayerDomainResource();
        if (null != this.id) {
            cloneLDR.id = new Integer(this.id.intValue());
        }
        if (null != this.formats) {
            cloneLDR.formats = new HashSet(this.formats);
        }
        if (null != this.url) {
            cloneLDR.url = new String(this.url);
        }
        if (null != this.domain) {
            cloneLDR.domain = new String(this.domain);
        }
        return cloneLDR;
    }

    protected void convertValues2KB(HashMap conversionValues) {
        String newUrl = (String) conversionValues.get("url");
        String spAbbr = (String) conversionValues.get("spAbbr");
        String layerName = (String) conversionValues.get("layerName");
        String layerUniqueName = null;
        String spAbbrUrl = (String) conversionValues.get("spAbbrUrl");
        if (spAbbrUrl!=null && spAbbrUrl.equalsIgnoreCase(spAbbr)) {
            layerUniqueName = layerName;
        } else {
            layerUniqueName = OGCCommunication.attachSp(spAbbr, layerName);
        }
         
        int pos = newUrl.indexOf("?");
        if (pos == -1) {
            newUrl += "?";
        } else {
            newUrl += "&";
        }
        
        OGCRequest ogcrequest = new OGCRequest(this.getUrl());
        String ls = ogcrequest.getParameter(OGCConstants.SERVICE);
        String lmd = ogcrequest.getParameter(OGCConstants.METADATA_LAYER);
        if (METADATA_DOMAIN.equalsIgnoreCase(domain)) {
            // check if metadata url is from kaartenbalie and has correct layerid
            if (ls != null && ls.equalsIgnoreCase(OGCConstants.NONOGC_SERVICE_METADATA)
                    && lmd != null && lmd.equalsIgnoreCase(layerUniqueName)) {
                // if so replace with proper url
                // TODO check if de metadata is from other kaartenbalie
                newUrl += OGCConstants.SERVICE;
                newUrl += "=";
                newUrl += OGCConstants.NONOGC_SERVICE_METADATA;
                newUrl += "&";
                newUrl += OGCConstants.WMS_PARAM_LAYER;
                newUrl += "=";
                newUrl += layerUniqueName;

                this.setUrl(newUrl);
            } else {
                // return with url unchanged, no obfuscation
            }
        } else {
            // use obfuscation
            newUrl += OGCConstants.SERVICE;
            newUrl += "=";
            newUrl += OGCConstants.NONOGC_SERVICE_PROXY;
            newUrl += "&";
            newUrl += OGCConstants.WMS_PARAM_LAYER;
            newUrl += "=";
            newUrl += layerUniqueName;
            newUrl += "&";
            newUrl += OGCConstants.PROXY_URL;
            newUrl += "=";
            try {
                String originalURL = this.getUrl();
                newUrl += KBCrypter.encryptText(originalURL);
                this.setUrl(newUrl);
            } catch (Exception ex) {
                log.error("error:", ex);
            }
        }
    }
    
    /** Method that will create piece of the XML tree to create a proper XML docuement.
     *
     * @param doc Document object which is being used to create new Elements
     * @param rootElement The element where this object belongs to.
     *
     * @return an object of type Element
     */
    public Element toElement(Document doc, Element rootElement) {

        Element domainElement = doc.createElement(this.getDomain());
        if (null != this.getFormats() && this.getFormats().size() != 0) {
            Iterator it = formats.iterator();
            while (it.hasNext()) {
                Element formatElement = doc.createElement("Format");
                Text text = doc.createTextNode((String) it.next());
                formatElement.appendChild(text);
                domainElement.appendChild(formatElement);
            }
        }
        if (this.getUrl() != null) {
            Element onlineElement = doc.createElement("OnlineResource");
            onlineElement.setAttribute("xlink:href", this.getUrl());
            onlineElement.setAttribute("xlink:type", "simple");
            onlineElement.setAttribute("xmlns:xlink", "http://www.w3.org/1999/xlink");
            domainElement.appendChild(onlineElement);
        }

        rootElement.appendChild(domainElement);
        return rootElement;
    }
}
