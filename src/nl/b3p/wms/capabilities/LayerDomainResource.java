/**
 * @(#)LayerDomainResource.java
 * @author N. de Goeij
 * @version 1.00 2006/10/11
 *
 * Purpose: Bean representing a LayerDomainResource.
 *
 * @copyright 2007 All rights reserved. B3Partners
 */

package nl.b3p.wms.capabilities;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import nl.b3p.ogc.utils.KBCrypter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class LayerDomainResource implements XMLElement {
    
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
        LayerDomainResource cloneLDR        = new LayerDomainResource();
        if (null != this.id) {
            cloneLDR.id                     = new Integer(this.id.intValue());
        }
        if (null != this.formats) {
            cloneLDR.formats                = new HashSet(this.formats);
        }
        if (null != this.url) {
            cloneLDR.url                    = new String(this.url);
        }
        if (null != this.domain) {
            cloneLDR.domain                 = new String(this.domain);
        }
        return cloneLDR;
    }
    
    protected void overwriteURL(String newUrl) {
        String originalURL = this.getUrl();
        int pos = newUrl.indexOf("?");
        if (pos==-1) {
            newUrl += "?purl=";
        } else {
            newUrl += "&purl=";
        }
        try {
            newUrl += KBCrypter.encryptText(originalURL);
            this.setUrl(newUrl);
        } catch (Exception ex) {
            log.error("error:", ex);
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
                Text text = doc.createTextNode((String)it.next());
                formatElement.appendChild(text);
                domainElement.appendChild(formatElement);
            }
        }
        if (this.getUrl()!=null) {
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