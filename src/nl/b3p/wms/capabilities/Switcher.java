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

import java.util.Hashtable;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class Switcher implements ContentHandler {

    private Hashtable rules = new Hashtable();
    private Stack stack = new Stack();

    /** Method which adds a new handler to the hash table.
     *
     * @param name String representing the name of the TAG to handle
     * @param handler String representing the name of the handler to handle this TAG
     */
    // <editor-fold defaultstate="" desc="setElementHandler(String name, ElementHandler handler) method.">
    public void setElementHandler(String name, ElementHandler handler) {
        rules.put(name, handler);
    }
    // </editor-fold>
    /** Method defining the start of an element.
     *
     * @param uri String representing the uri
     * @param localName String representing the local name
     * @param qName String representing the qName
     * @param atts Attributes of a specific element
     *
     * @throws SAXException
     */
    // <editor-fold defaultstate="" desc="startElement (String uri, String localName, String qName, Attributes atts) method.">
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        ElementHandler handler = (ElementHandler) rules.get(localName);
        stack.push(handler);

        if (handler != null) {
            handler.startElement(uri, localName, qName, atts);
        }
    }
    // </editor-fold>
    /** Method defining the end of an element.
     *
     * @param uri String representing the uri
     * @param localName String representing the local name
     * @param qName String representing the qName
     *
     * @throws SAXException
     */
    // <editor-fold defaultstate="" desc="endElement (String uri, String localName, String qName) method.">
    public void endElement(String uri, String localName, String qName) throws SAXException {
        ElementHandler handler = (ElementHandler) stack.pop();
        if (handler != null) {
            handler.endElement(uri, localName, qName);
        }
    }
    // </editor-fold>
    /** Method defining the character data.
     *
     * @param ch char array
     * @param start integer where to start
     * @param length integer with the amount of characters to read
     *
     * @throws SAXException
     */
    // <editor-fold defaultstate="" desc="characters (char[] ch, int start, int length) method.">
    public void characters(char[] ch, int start, int length) throws SAXException {
        ElementHandler handler = (ElementHandler) stack.peek();
        if (handler != null) {
            handler.characters(ch, start, length);
            String s = new String(ch, start, length);
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="" desc="Methods overriding the methods declared in the interface.">
    public void skippedEntity(String name) throws SAXException {
    }

    public void setDocumentLocator(Locator locator) {
    }

    public void startDocument() throws SAXException {
    }

    public void endDocument() throws SAXException {
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }

    public void endPrefixMapping(String prefix) throws SAXException {
    }

    public void ignorableWhitespace(char ch[], int start, int length) throws SAXException {
    }

    public void processingInstruction(String target, String data) throws SAXException {
    }
    // </editor-fold>
}