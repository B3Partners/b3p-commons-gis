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

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class ServiceDomainResource implements XMLElement {

    private Integer id;
    private Set formats;
    private String getUrl;
    private String postUrl;
    private String domain;
    private ServiceProvider serviceProvider;
    // <editor-fold defaultstate="" desc="getter and setter methods.">
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

    public String getGetUrl() {
        return getUrl;
    }

    public void setGetUrl(String getUrl) {
        this.getUrl = getUrl;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
    // </editor-fold>
    /** Method that will create a deep copy of this object.
     *
     * @return an object of type Object
     */
    // <editor-fold defaultstate="" desc="clone() method">
    public Object clone() {
        ServiceDomainResource cloneSDR = new ServiceDomainResource();
        if (null != this.id) {
            cloneSDR.id = new Integer(this.id.intValue());
        }
        if (null != this.formats) {
            cloneSDR.formats = new HashSet(this.formats);
        }
        if (null != this.getUrl) {
            cloneSDR.getUrl = new String(this.getUrl);
        }
        if (null != this.postUrl) {
            cloneSDR.postUrl = new String(this.postUrl);
        }
        if (null != this.domain) {
            cloneSDR.domain = new String(this.domain);
        }
        return cloneSDR;
    }
    // </editor-fold>
    /** Method that will overwrite the URL's stored in the database with the URL specified for Kaartenbalie.
     * This new URL indicate the link to the kaartenbalie, while the old link is used to indicate the URL
     * to the real location of the service. Because the client which is connected to kaartenbalie has to send
     * his requests back to kaartenbalie and not directly to the official resource, the URL has to be replaced.
     *
     * @param newUrl String representing the URL the old URL has to be replaced with.
     */
    // <editor-fold defaultstate="" desc="overwriteURL(String newUrl) method">
    protected void overwriteURL(String newUrl) {
        this.setGetUrl(newUrl);
        this.setPostUrl(newUrl);
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

        if (null != this.getGetUrl() || null != this.getPostUrl()) {
            Element dcptElement = doc.createElement("DCPType");
            Element httpElement = doc.createElement("HTTP");
            if (null != this.getGetUrl()) {
                Element getElement = doc.createElement("Get");
                Element onlineElement = doc.createElement("OnlineResource");
                onlineElement.setAttribute("xlink:href", this.getGetUrl());
                onlineElement.setAttribute("xlink:type", "simple");
                onlineElement.setAttribute("xmlns:xlink", "http://www.w3.org/1999/xlink");
                getElement.appendChild(onlineElement);
                httpElement.appendChild(getElement);
                dcptElement.appendChild(httpElement);
                domainElement.appendChild(dcptElement);
            }

            if (null != this.getPostUrl()) {
                Element postElement = doc.createElement("Post");
                Element onlineElement = doc.createElement("OnlineResource");
                onlineElement.setAttribute("xlink:href", this.getPostUrl());
                onlineElement.setAttribute("xlink:type", "simple");
                onlineElement.setAttribute("xmlns:xlink", "http://www.w3.org/1999/xlink");
                postElement.appendChild(onlineElement);
                httpElement.appendChild(postElement);
                dcptElement.appendChild(httpElement);
                domainElement.appendChild(dcptElement);
            }
        }

        rootElement.appendChild(domainElement);
        return rootElement;
    }
    // </editor-fold>
    /**
     * Public method which checks if this service domain resource is in a list with service domain rsources given as a parameter.
     */
    public boolean inList(Set sdrs) {
        if (sdrs == null) {
            return false;
        }
        Iterator it = sdrs.iterator();
        while (it.hasNext()) {
            ServiceDomainResource sdr = (ServiceDomainResource) it.next();
            if (this.equals(sdr)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Public method to check wether the given service domain resource as parameter equals this service domain resource.
     */
    private boolean equals(ServiceDomainResource sdr) {
        if (sdr == null) {
            return false;
        }
        if (this.getDomain().equals(sdr.getDomain()) &&
                this.getGetUrl().equals(sdr.getGetUrl()) &&
                this.getPostUrl().equals(sdr.getPostUrl())) {
            return true;
        }
        return false;
    }
}