package nl.b3p.ogc.sld;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Boy de Wit
 */
public class SldReader {

    public List<String> getNamedLayers(String url) throws Exception {
        List<String> layers = new ArrayList();

        Document doc = getDocument(url);

        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();

        XPathExpression exNamedLayers = xpath.compile("/StyledLayerDescriptor/NamedLayer/Name");
        NodeList namedLayers = (NodeList) exNamedLayers.evaluate(doc.getDocumentElement(), XPathConstants.NODESET);

        for (int i = 0; i < namedLayers.getLength(); i++) {
            if (namedLayers.item(i) != null) {
                if (namedLayers.item(i).getFirstChild() != null) {
                    String namedLayerName = namedLayers.item(i).getFirstChild()
                            .getNodeValue();

                    layers.add(namedLayerName);
                }
            }
        }

        return layers;
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
