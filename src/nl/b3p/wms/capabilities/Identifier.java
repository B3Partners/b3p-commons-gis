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

public class Identifier implements XMLElement {

    private Integer id;
    private String authorityName;
    private String value;
    private String authorityURL;
    private Layer layer;
    // <editor-fold defaultstate="" desc="getter and setter methods.">
    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public String getAuthorityURL() {
        return authorityURL;
    }

    public void setAuthorityURL(String authorityURL) {
        this.authorityURL = authorityURL;
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
        Identifier cloneIdent = new Identifier();
        if (null != this.id) {
            cloneIdent.id = new Integer(this.id.intValue());
        }
        if (null != this.authorityName) {
            cloneIdent.authorityName = new String(this.authorityName);
        }
        if (null != this.value) {
            cloneIdent.value = new String(this.value);
        }
        if (null != this.authorityURL) {
            cloneIdent.authorityURL = new String(this.authorityURL);
        }
        return cloneIdent;
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

        Element authorityElement = doc.createElement("AuthorityURL");
        authorityElement.setAttribute("authority", this.getAuthorityName());

        Element onlineElement = doc.createElement("OnlineResource");
        onlineElement.setAttribute("xlink:href", this.getAuthorityURL());
        onlineElement.setAttribute("xlink:type", "simple");
        onlineElement.setAttribute("xmlns:xlink", "http://www.w3.org/1999/xlink");
        authorityElement.appendChild(onlineElement);

        rootElement.appendChild(authorityElement);

        Element identifierElement = doc.createElement("Identifier");
        identifierElement.setAttribute("authority", this.getAuthorityName());
        Text text = doc.createTextNode(this.getAuthorityName());
        identifierElement.appendChild(text);

        rootElement.appendChild(identifierElement);
        return rootElement;
    }
    // </editor-fold>
}
