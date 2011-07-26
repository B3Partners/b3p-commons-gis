package nl.b3p.ogc.sld;

import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.util.Iterator;
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Boy de Wit
 */
public class SldReader {

    private static final Log logFile = LogFactory.getLog(SldReader.class);

    public SldNamedLayer[] getNamedLayers(String url) throws Exception {
        Document doc = getDocument(url);

        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        setNameSpaceContext(xpath);

        String expr = "/StyledLayerDescriptor/NamedLayer";
        NodeList nodeSet = (NodeList) xpath.evaluate(expr, doc, XPathConstants.NODESET);

        SldNamedLayer[] namedLayers = new SldNamedLayer[nodeSet.getLength()];
        for (int i = 0; i < nodeSet.getLength(); i++) {
            Node node = (Node) nodeSet.item(i);

            String name = getStyleName(node);
            String sldPart = serializeXpathNode(node);

            SldNamedLayer sldNamedLayer = new SldNamedLayer(name, sldPart, node);
            namedLayers[i] = sldNamedLayer;
        }

        return namedLayers;
    }

    public SldUserStyle[] getUserStyles(SldNamedLayer sldNamedLayer) throws Exception {
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        setNameSpaceContext(xpath);

        String expr = "UserStyle";
        Node node = sldNamedLayer.getNode();
        NodeList nodeSet = (NodeList) xpath.evaluate(expr, node, XPathConstants.NODESET);

        SldUserStyle[] userStyles = new SldUserStyle[nodeSet.getLength()];
        for (int i = 0; i < nodeSet.getLength(); i++) {
            Node n = (Node) nodeSet.item(i);

            String name = getStyleName(n);
            String sldPart = serializeXpathNode(n);

            SldUserStyle sldUserStyle = new SldUserStyle(name, sldPart, node);
            userStyles[i] = sldUserStyle;
        }

        return userStyles;
    }

    private String getStyleName(Node node) throws XPathExpressionException {
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        setNameSpaceContext(xpath);

        XPathExpression xPathExpression = xpath.compile("Name");
        String name = xPathExpression.evaluate(node);

        return name;
    }

    private Document getDocument(String urlString) throws Exception {
        InputStream is = null;

        try {
            URL url = new URL(urlString.trim());
            is = url.openConnection().getInputStream();

            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(is);

            return doc;
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    private void setNameSpaceContext(XPath xpath) {
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

    private String serializeXpathNode(Node node) {
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
            logFile.error("Fout tijdens serializen XPath Node: " + e);
        }

        return writer.toString();
    }

    private boolean isTextNode(Node node) {
        short nodeType;

        if (node == null) {
            return false;
        }

        nodeType = node.getNodeType();

        return nodeType == Node.CDATA_SECTION_NODE || nodeType == Node.TEXT_NODE;
    }
}
