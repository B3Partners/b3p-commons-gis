package nl.b3p.ogc.sld;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Boy de Wit
 */
public class SldReader {

    private static final Log logFile = LogFactory.getLog(SldReader.class);

    public List<Node> getNamedLayers(String url) throws Exception {
        List<Node> nodes = new ArrayList();

        Document doc = getDocument(url);

        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();

        XPathExpression exNamedLayers = xpath.compile("/StyledLayerDescriptor/NamedLayer");
        NodeList namedLayers = (NodeList) exNamedLayers.evaluate(doc.getDocumentElement(), XPathConstants.NODESET);

        for (int i = 0; i < namedLayers.getLength(); i++) {
            if (namedLayers.item(i) != null) {
                Node node = namedLayers.item(i);
                nodes.add(node);
            }
        }

        for (Node n : nodes) {
            getUserStyles(n);
        }

        return nodes;
    }

    public List<Node> getUserStyles(Node n) throws Exception {
        List<Node> nodes = new ArrayList();

        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();

        XPathExpression exUserStyles = xpath.compile("UserStyle/*");
        NodeList userStyles = (NodeList) exUserStyles.evaluate(n, XPathConstants.NODESET);

        for (int i = 0; i < userStyles.getLength(); i++) {
            if (userStyles.item(i) != null) {
                Node node = userStyles.item(i);
                nodes.add(node);

                getUserStyleName(node);
            }
        }

        return nodes;
    }

    public String getUserStyleName(Node n) {
        String name = null;

        if (n.getAttributes().getNamedItem("Name") != null) {
            name = n.getAttributes().getNamedItem("Name").getNodeValue();
            logFile.info("UserStyle name=" + name);
        }

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
}
