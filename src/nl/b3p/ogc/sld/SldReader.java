package nl.b3p.ogc.sld;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import nl.b3p.commons.services.B3PCredentials;
import nl.b3p.commons.services.HttpClientConfigured;
import nl.b3p.commons.xml.DocumentHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Boy de Wit
 */
public class SldReader {

    private static final Log log = LogFactory.getLog(SldReader.class);

    public List<SldNamedLayer> getNamedLayers(Document doc) throws Exception {
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        setNameSpaceContext(xpath);

        String expr = "/sld:StyledLayerDescriptor/sld:NamedLayer";
        NodeList nodeSet = (NodeList) xpath.evaluate(expr, doc, XPathConstants.NODESET);

        List<SldNamedLayer> namedLayers= new ArrayList<SldNamedLayer>();
        for (int i = 0; i < nodeSet.getLength(); i++) {
            Node node = (Node) nodeSet.item(i);
            
            SldNamedLayer sldNamedLayer = new SldNamedLayer(node);
            namedLayers.add(sldNamedLayer);
        }

        return namedLayers;
    }
    /**
     * get the named layers by providing the url
     */
    public List<SldNamedLayer> getNamedLayersByUrl(String url,B3PCredentials credentials) throws Exception {
        Document doc = getDocument(url,credentials);
        return getNamedLayers(doc);
    }
    
    public List<SldNamedLayer> getNamedLayersByUrl(String url) throws Exception {
        return getNamedLayersByUrl(url, null);
    }
    
    /**
     * get the named layers by provinding the complete SLD
     */
    public List<SldNamedLayer> getNamedLayersBySld(String sld, String charSet) throws Exception{
        Document doc = getDocument(sld,charSet);
        return getNamedLayers(doc);
    }
    
    public List<SldNamedLayer> getNamedLayers(String url, String layerName) throws Exception{
        return getNamedLayers(url,layerName,null);
    }
    
    public List<SldNamedLayer> getNamedLayers(String url, String layerName,B3PCredentials credentials) throws Exception{
        List<SldNamedLayer> allNamedLayers=getNamedLayersByUrl(url,credentials);
        List<SldNamedLayer> namedLayersWithName=new ArrayList<SldNamedLayer>();
        for (SldNamedLayer namedLayer : allNamedLayers){
            if (namedLayer.getName().equals(layerName)){
                namedLayersWithName.add(namedLayer);
            }
        }
        return namedLayersWithName;
    }
    
    public List<SldNamedLayer> getNamedLayers(List<SldNamedLayer> namedLayers, String layerName) throws Exception{        
        List<SldNamedLayer> namedLayersWithName=new ArrayList<SldNamedLayer>();
        for (SldNamedLayer namedLayer : namedLayers){
            
            String name = namedLayer.getName();
            
            if (name.equalsIgnoreCase(layerName)) {
                namedLayersWithName.add(namedLayer);
            }
        }
        
        return namedLayersWithName;
    }
    
    
    public List<SldUserStyle> getUserStyles(Node node) throws Exception {
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        setNameSpaceContext(xpath);

        String expr = "sld:UserStyle";
        NodeList nodeSet = (NodeList) xpath.evaluate(expr, node, XPathConstants.NODESET);

        List<SldUserStyle> userStyles = new ArrayList<SldUserStyle>();
        for (int i = 0; i < nodeSet.getLength(); i++) {
            Node n = (Node) nodeSet.item(i);

            /*String name = getStyleName(n);
            String sldPart = serializeXpathNode(n);*/

            SldUserStyle sldUserStyle = new SldUserStyle(node);
            userStyles.add(sldUserStyle);
        }

        return userStyles;
    }

    private Document getDocument(String urlString, B3PCredentials credentials) throws Exception {
        HttpClientConfigured hcc = new HttpClientConfigured(credentials);
        HttpGet request = new HttpGet(urlString);

        HttpResponse response = null;
        try {
            response = hcc.execute(request);
            HttpEntity entity = response.getEntity();

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new Exception("Error connecting to server. Status code: " + statusCode);
            }
            return getDocument(entity.getContent());
        } finally {
            hcc.close(response);
            hcc.close();
        }
    }
    
    public static Document getDocument(InputStream is) throws Exception {        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.parse(is);
        log.debug("content after parsing: " + DocumentHelper.document2String(doc));
        return doc;        
    }
    
    public static Document getDocument(String sld, String charSet) throws Exception{
        InputStream is = null;
        try {            
            is = new ByteArrayInputStream(sld.getBytes(charSet));
            return getDocument(is);
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
                } else if ("se".equals(prefix)) {
                    return "http://www.opengis.net/se";
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
