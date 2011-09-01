/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.b3p.ogc.sld;

import java.io.StringWriter;
import java.util.Iterator;
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;

/**
 * B3partners B.V. http://www.b3partners.nl
 * @author Roy
 * Created on 1-sep-2011, 11:34:49
 */
public class SldNode {
    private static final Log log = LogFactory.getLog(SldNamedLayer.class);
    
    protected static XPathFactory factory = XPathFactory.newInstance();
    protected static XPath xpath = factory.newXPath();
    
    static{
        xpath.setNamespaceContext((NamespaceContext) new NamespaceContext() {
            public String getNamespaceURI(String prefix) {
                if (prefix == null) {
                    throw new NullPointerException("Null prefix");
                } else if ("sld".equals(prefix)) {
                    return "http://www.opengis.net/sld";
                } else if ("ogc".equals(prefix)) {
                    return "http://www.opengis.net/ogc";
                } else if ("xml".equals(prefix)) {
                    return XMLConstants.XML_NS_URI;
                }
                return XMLConstants.NULL_NS_URI;
            }
            public String getPrefix(String namespaceURI) {
                throw new UnsupportedOperationException("");
            }
            public Iterator getPrefixes(String namespaceURI) {
                throw new UnsupportedOperationException("");
            }
        });               
    }
    
    protected String serializeXpathNode(Node node) {
        StringWriter writer = new StringWriter();

        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer;

            transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

            if (isTextNode(node)) {
                writer.write(node.getNodeValue());
            } else if (node.getNodeType() == Node.ATTRIBUTE_NODE) {
                writer.write(((Attr) node).getValue());
            } else if (node.getNodeType() == Node.ELEMENT_NODE) {
                transformer.transform(new DOMSource(node), new StreamResult(writer));
            }
            
        } catch (Exception e) {
            log.error("Fout tijdens serializen XPath Node: " + e);
        }

        return writer.toString();
    }
    protected boolean isTextNode(Node node) {
        short nodeType;

        if (node == null) {
            return false;
        }

        nodeType = node.getNodeType();

        return nodeType == Node.CDATA_SECTION_NODE || nodeType == Node.TEXT_NODE;
    }
}
