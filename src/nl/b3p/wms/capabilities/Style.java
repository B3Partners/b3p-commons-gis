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
import java.util.Hashtable;
import java.util.Iterator;
import nl.b3p.ogc.utils.OGCConstants;
import nl.b3p.ogc.utils.OGCRequest;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Style implements XMLElement {

    private Integer id;
    private String name = "default";
    private String title;
    private String abstracts;
    private Layer layer;
    private Set domainResource;
    private String sldPart;

    // <editor-fold defaultstate="" desc="getter and setter methods.">
    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public Set getDomainResource() {
        return domainResource;
    }

    public void setDomainResource(Set domainResource) {
        this.domainResource = domainResource;
    }

    public void addDomainResource(StyleDomainResource dr) {
        if (null == domainResource) {
            domainResource = new HashSet();
        }
        domainResource.add(dr);
        dr.setStyle(this);
    }

    public Layer getLayer() {
        return layer;
    }

    public void setLayer(Layer layer) {
        this.layer = layer;
    }

    public String getSldPart() {
        return sldPart;
    }

    public void setSldPart(String sldPart) {
        this.sldPart = sldPart;
    }

    // </editor-fold>
    /** Method that will overwrite the URL's stored in the database with the URL specified for Kaartenbalie.
     * This new URL indicate the link to the kaartenbalie, while the old link is used to indicate the URL
     * to the real location of the service. Because the client which is connected to kaartenbalie has to send
     * his requests back to kaartenbalie and not directly to the official resource, the URL has to be replaced.
     *
     * @param newUrl String representing the URL the old URL has to be replaced with.
     */
    // <editor-fold defaultstate="" desc="convertValues2KB(String newUrl) method">
    protected void convertValues2KB(HashMap conversionValues) {
        Iterator it;
        //check if its a Kaartenbalie added sld style.
        if (this.sldPart!=null && (this.getDomainResource()==null || this.getDomainResource().size() == 0)){
            //check if this serviceProvider supports GetLegendGraphic requests
            ServiceProvider sp= this.getLayer().getServiceProvider();  
            ServiceDomainResource getLegendResource=sp.getServiceDomainResourceByOperationName("GetLegendGraphic");            
            if(getLegendResource!=null){
                //make getLegendGraphic url   
                String wmsVersion=sp.getWmsVersion();
                OGCRequest url = new OGCRequest(this.getLayer().getServiceProvider().getUrl());
                url.addOrReplaceParameter(OGCConstants.WMS_REQUEST, OGCConstants.WMS_REQUEST_GetLegendGraphic);
                if (wmsVersion!=null){
                    url.addOrReplaceParameter(OGCConstants.WMS_VERSION, wmsVersion);
                }else{
                    //if no version then fallback to 1.1.1
                    url.addOrReplaceNameSpace(OGCConstants.WMS_VERSION, OGCConstants.WMS_VERSION_111);
                }
                url.addOrReplaceParameter(OGCConstants.WMS_PARAM_LAYER, this.getLayer().getName());
                String format="image/png";
                if(getLegendResource.getFormats()!=null){
                    format=(String) getLegendResource.getFormats().iterator().next();
                }
                    
                //todo: uitzoeken welk formaat ondersteund wordt.
                url.addOrReplaceParameter(OGCConstants.WMS_PARAM_FORMAT,format);

                //make SLDProxy Url.
                String sldProxyUrl=(String)conversionValues.get("url");
                sldProxyUrl = sldProxyUrl.replace("/services/", "/ProxySLD/");
                if (sldProxyUrl.indexOf("?")!=sldProxyUrl.length()-1 &&
                        sldProxyUrl.indexOf("&")!=sldProxyUrl.length()-1){
                    sldProxyUrl+= sldProxyUrl.indexOf("?")>0 ? "&" : "?";
                }
                sldProxyUrl+="styles=";
                sldProxyUrl+=this.getId();
                sldProxyUrl+="&";            
                url.addOrReplaceParameter(OGCConstants.WMS_PARAM_SLD,sldProxyUrl);

                //make StyleDomainResource and add to style.
                StyleDomainResource sdr = new StyleDomainResource();
                sdr.setDomain("LegendURL");
                sdr.setUrl(url.toString()); 
                HashSet set = new HashSet();
                set.add(sdr);
                setDomainResource(set);
            }
        }
        //StyleDomainResource:
        if (null != this.getDomainResource() && this.getDomainResource().size() != 0) {
            it = this.getDomainResource().iterator();
            while (it.hasNext()) {
                StyleDomainResource sdr = (StyleDomainResource) it.next();
                sdr.convertValues2KB(conversionValues);
            }
        }
    }
    // </editor-fold>
    /** Method that will create a deep copy of this object.
     *
     * @return an object of type Object
     */
    // <editor-fold defaultstate="" desc="clone() method">
    public Object clone() {
        Style cloneStyle = new Style();
        if (null != this.id) {
            cloneStyle.id = new Integer(this.id.intValue());
        }
        if (null != this.name) {
            cloneStyle.name = new String(this.name);
        }
        if (null != this.title) {
            cloneStyle.title = new String(this.title);
        }
        if (null != this.abstracts) {
            cloneStyle.abstracts = new String(this.abstracts);
        }
        if (null != this.domainResource) {
            cloneStyle.domainResource = new HashSet();
            Iterator it = this.domainResource.iterator();
            while (it.hasNext()) {
                StyleDomainResource sdr = (StyleDomainResource) ((StyleDomainResource) it.next()).clone();
                sdr.setStyle(cloneStyle);
                cloneStyle.domainResource.add(sdr);
            }
        }

        if (null != this.sldPart) {
            cloneStyle.sldPart = new String(this.sldPart);
        }

        return cloneStyle;
    }
    // </editor-fold>
    /** Method that will create piece of the XML tree to create a proper XML docuement.
     *
     * @param doc Document object which is being used to create new Elements
     * @param rootElement The element where this object belongs to.
     *
     * @return an object of type Element
     */
    // <editor-fold defaultstate="" desc="toElement(Document doc, Element rootElement) method">
    public Element toElement(Document doc, Element rootElement) {
        Element styleElement = doc.createElement("Style");
        if (null != this.getName()) {
            Element nameElement = doc.createElement("Name");
            Text text = doc.createTextNode(this.getName());
            nameElement.appendChild(text);
            styleElement.appendChild(nameElement);
        }
        if (null != this.getTitle()) {
            Element titleElement = doc.createElement("Title");
            Text text = doc.createTextNode(this.getTitle());
            titleElement.appendChild(text);
            styleElement.appendChild(titleElement);
        }

        /*
        if (null != this.getDomainResource() && this.getDomainResource().size() != 0) {
        Iterator it = this.getDomainResource().iterator();
        while (it.hasNext()) {
        StyleDomainResource sdr = (StyleDomainResource)it.next();
        sdr.toElement(doc, styleElement);
        }
        }
         **/

        if (null != this.getDomainResource() && this.getDomainResource().size() != 0) {
            Hashtable sdrhash = new Hashtable();
            StyleDomainResource sdr = null;
            Iterator it = domainResource.iterator();
            while (it.hasNext()) {
                sdr = (StyleDomainResource) it.next();
                if (sdr.getDomain() == null) {
                    continue;
                } else if (sdr.getDomain().equalsIgnoreCase("LegendURL")) {
                    sdrhash.put("LegendURL", sdr);
                } else if (sdr.getDomain().equalsIgnoreCase("StyleSheetURL")) {
                    sdrhash.put("StyleSheetURL", sdr);
                } else if (sdr.getDomain().equalsIgnoreCase("StyleURL")) {
                    sdrhash.put("StyleURL", sdr);
                } else {
                    continue;
                }
            }
            sdr = (StyleDomainResource) sdrhash.get("LegendURL");
            if (sdr != null) {
                styleElement = sdr.toElement(doc, styleElement);
            }
            sdr = (StyleDomainResource) sdrhash.get("StyleSheetURL");
            if (sdr != null) {
                styleElement = sdr.toElement(doc, styleElement);
            }
            sdr = (StyleDomainResource) sdrhash.get("StyleURL");
            if (sdr != null) {
                styleElement = sdr.toElement(doc, styleElement);
            }
        }

        rootElement.appendChild(styleElement);
        return rootElement;
    }
    // </editor-fold>
}