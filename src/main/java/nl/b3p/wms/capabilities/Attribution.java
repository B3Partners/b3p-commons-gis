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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Attribution implements XMLElement {

    private Integer id;
    private String title;
    private String attributionURL;
    private String logoURL;
    private String logoFormat;
    private String logoWidth;
    private String logoHeight;
    private Layer layer;
    // <editor-fold defaultstate="" desc="getter and setter methods.">
    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAttributionURL() {
        return attributionURL;
    }

    public void setAttributionURL(String attributionURL) {
        this.attributionURL = attributionURL;
    }

    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

    public String getLogoWidth() {
        return logoWidth;
    }

    public void setLogoWidth(String logoWidth) {
        this.logoWidth = logoWidth;
    }

    public String getLogoHeight() {
        return logoHeight;
    }

    public void setLogoHeight(String logoHeight) {
        this.logoHeight = logoHeight;
    }

    public String getLogoFormat() {
        return logoFormat;
    }

    public void setLogoFormat(String logoFormat) {
        this.logoFormat = logoFormat;
    }

    public Layer getLayer() {
        return layer;
    }

    public void setLayer(Layer layer) {
        this.layer = layer;
    }
    // </editor-fold>
    /** Method that will create a deep copy of this object.
     *
     * @return an object of type Object
     */
    // <editor-fold defaultstate="" desc="clone() method">
    public Object clone() {
        Attribution cloneAtt = new Attribution();
        if (null != this.id) {
            cloneAtt.id = new Integer(this.id.intValue());
        }
        if (null != this.title) {
            cloneAtt.title = new String(this.title);
        }
        if (null != this.attributionURL) {
            cloneAtt.attributionURL = new String(this.attributionURL);
        }
        if (null != this.logoURL) {
            cloneAtt.logoURL = new String(this.logoURL);
        }
        if (null != this.logoFormat) {
            cloneAtt.logoFormat = new String(this.logoFormat);
        }
        if (null != this.logoWidth) {
            cloneAtt.logoWidth = new String(this.logoWidth);
        }
        if (null != this.logoHeight) {
            cloneAtt.logoHeight = new String(this.logoHeight);
        }
        return cloneAtt;
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
        Element attributionElement = doc.createElement("Attribution");

        //title element
        Element titleElement = doc.createElement("Title");
        Text text = doc.createTextNode(this.getTitle());
        titleElement.appendChild(text);
        attributionElement.appendChild(titleElement);
        //end title element

        //onlineResource element
        Element attOnlineElement = doc.createElement("OnlineResource");
        attOnlineElement.setAttribute("xlink:href", this.getAttributionURL());
        attOnlineElement.setAttribute("xlink:type", "simple");
        attOnlineElement.setAttribute("xmlns:xlink", "http://www.w3.org/1999/xlink");
        attributionElement.appendChild(attOnlineElement);
        //end onlineResource element

        //Logo element
        Element logoElement = doc.createElement("LogoURL");
        logoElement.setAttribute("width", this.getLogoWidth());
        logoElement.setAttribute("height", this.getLogoHeight());

        //format element
        Element formatElement = doc.createElement("Format");
        text = doc.createTextNode(this.getLogoFormat());
        formatElement.appendChild(text);
        logoElement.appendChild(formatElement);
        //end format element

        //onlineResource element
        Element logoOnlineElement = doc.createElement("OnlineResource");
        logoOnlineElement.setAttribute("xlink:href", this.getLogoURL());
        logoOnlineElement.setAttribute("xlink:type", "simple");
        logoOnlineElement.setAttribute("xmlns:xlink", "http://www.w3.org/1999/xlink");
        logoElement.appendChild(logoOnlineElement);
        //end onlineResource element

        attributionElement.appendChild(logoElement);
        //end Logo element

        rootElement.appendChild(attributionElement);
        return rootElement;
    }
    // </editor-fold>
}