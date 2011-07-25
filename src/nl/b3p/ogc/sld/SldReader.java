package nl.b3p.ogc.sld;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Boy de Wit
 */
public class SldReader {

    private static final Log logFile = LogFactory.getLog(SldReader.class);

    public void getNamedLayers(String url) throws Exception {
        Document doc = getDocument(url);

        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        setNameSpaceContext(xpath);

        String expr = "/StyledLayerDescriptor/NamedLayer";
        NodeList nodeSet = (NodeList) xpath.evaluate(expr, doc, XPathConstants.NODESET);

        for (int i = 0; i < nodeSet.getLength(); i++) {
            Node node = (Node) nodeSet.item(i);
            getUserStyles(node);
        }
    }

    public void getUserStyles(Node node) throws Exception {
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        setNameSpaceContext(xpath);

        String expr = "UserStyle";
        NodeList nodeSet = (NodeList) xpath.evaluate(expr, node, XPathConstants.NODESET);

        for (int i = 0; i < nodeSet.getLength(); i++) {
            Node n = (Node) nodeSet.item(i);
            getStyleName(n);
        }
    }

    public String getStyleName(Node node) throws XPathExpressionException {
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
}
