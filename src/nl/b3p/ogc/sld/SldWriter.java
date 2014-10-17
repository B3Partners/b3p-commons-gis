package nl.b3p.ogc.sld;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import nl.b3p.commons.services.B3PCredentials;
import nl.b3p.commons.services.HttpClientConfigured;
import nl.b3p.commons.xml.DocumentHelper;
import nl.b3p.ogc.utils.OGCCommunication;
import nl.b3p.wms.capabilities.Layer;
import nl.b3p.wms.capabilities.Style;
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
 * @author Chris van Lith
 */
public class SldWriter {

    private static final Log log = LogFactory.getLog(SldWriter.class);
    private String version = "1.1.0";
    private String encoding = "UTF-8";
    
    private List<SldNamedLayer> namedlayers = null;
    
    public SldWriter() {
    }
    
    public SldWriter(List<SldNamedLayer> namedlayers) {
        this.namedlayers = namedlayers;
    }
    
    public SldWriter(String version) {
        this.version = version;
    }
    
    public SldWriter(List<SldNamedLayer> namedlayers, String version) {
        this(version);
        this.namedlayers = namedlayers;
    }
    
    public void parseDocument(Document doc) throws Exception {
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        setNameSpaceContext(xpath);
        
        String expr1 = "/sld:StyledLayerDescriptor/@version";
        version = (String) xpath.evaluate(expr1, doc, XPathConstants.STRING);

        String expr = "/sld:StyledLayerDescriptor/sld:NamedLayer";
        NodeList nodeSet = (NodeList) xpath.evaluate(expr, doc, XPathConstants.NODESET);

        List<SldNamedLayer> namedLayers= new ArrayList<SldNamedLayer>();
        for (int i = 0; i < nodeSet.getLength(); i++) {
            Node node = (Node) nodeSet.item(i);
            
            SldNamedLayer sldNamedLayer = new SldNamedLayer(node);
            namedLayers.add(sldNamedLayer);
        }

        this.namedlayers = namedLayers;
    }
    /**
     * get the sld by providing the url
     */
    public void parseByUrl(String url, B3PCredentials credentials) throws Exception {
        Document doc = getDocument(url, credentials);
        parseDocument(doc);
    }
    
    public void parseByUrl(String url) throws Exception {
        parseByUrl(url, null);
    }
    
    /**
     * get the named layers by provinding the complete SLD
     */
    public void parseString(String sld, String charSet) throws Exception{
        if (charSet==null) {
            charSet = encoding;
        }
        Document doc = getDocument(sld, charSet);
        parseDocument(doc);
    }
    
    public List<SldUserStyle> getUserStyles(String layerName) throws Exception {
        if (namedlayers == null) {
            return null;
        }
        List<SldUserStyle> userStyles = new ArrayList<SldUserStyle>();
        Iterator<SldNamedLayer> it = namedlayers.iterator();
        while (it.hasNext()) {
            SldNamedLayer nl = it.next();
            String name = nl.getName();
            if (name.equalsIgnoreCase(layerName)) {
                userStyles.addAll(nl.getUserStyles());
            }
        }
        return userStyles;
    }
    
    public List<SldNamedLayer> getNamedLayers(String layerName) throws Exception {
        if (namedlayers == null) {
            return null;
        }
        List<SldNamedLayer> namedLayers = new ArrayList<SldNamedLayer>();
        Iterator<SldNamedLayer> it = namedlayers.iterator();
        while (it.hasNext()) {
            SldNamedLayer nl = it.next();
            String name = nl.getName();
            if (name.equalsIgnoreCase(layerName)) {
                namedLayers.add(nl);
            }
        }
        return namedLayers;
    }
    
    public void addSldStylesSet(Layer layer) throws Exception {
        //get only the named layers for this layer
        List<SldNamedLayer> namedLayers = getNamedLayers(layer.getName());
        if (namedLayers==null) {
            return;
        }
        
        Set<Style> styles = new HashSet<Style>();
        for (SldNamedLayer namedLayer : namedLayers) {
            List<SldNode> stylesAndConstraints = namedLayer.getStyles();
            
            for (SldNode sldStyle : stylesAndConstraints) {
                Style style = new Style();
                style.setLayer(layer);

                if (layer.getStyles() == null) {
                    layer.setStyles(new HashSet<Style>());
                }

                String newStyleName = getUniqueStyleName(layer.getStyles(), sldStyle.getName());
                style.setName(newStyleName);
                //een style moet een name hebben om aan te roepen
                if (style.getName() == null
                        || style.getName().length() == 0) {
                    style.setName(layer.getName() + "_SLD");
                }
                
                style.setTitle(sldStyle.getName());
                style.setSldPart(sldStyle.getSldPart());
                
                if (sldStyle instanceof SldNamedStyle){
                    SldLayerFeatureConstraints constraints=((SldNamedStyle)sldStyle).getFeatureConstraints();
                    if(constraints!=null){
                        style.setSldConstraints(constraints.getSldPart());
                    }                    
                }
                styles.add(style);
            }
        }
        if (layer.getStyles() != null && !styles.isEmpty()) {
            layer.getStyles().addAll(styles);
        }
    }
    
    private String getUniqueStyleName(Set<Style> styles, String name) throws Exception {        
        return getUniqueStyleName(styles, name, null);
    }
    
    private String getUniqueStyleName(Set<Style> styles, String name, Integer tries) throws Exception {    
        if (styles == null || name==null) {
            return null;
        }
        if (tries!=null && tries==10)
            throw new Exception("Can't create unique name for style");
                
        String newName=name;
        if (tries!=null)
            newName+=tries;
        
        Iterator<Style> it = styles.iterator();
        boolean unique=true;
        while (it.hasNext()&& unique){
            Style s= it.next();
            if (s.getName().equals(newName))
                unique=false;
        }
        if (!unique){
            if (tries==null)
                tries= new Integer("0");
            tries++;            
            return getUniqueStyleName(styles, name, tries);
        }
        return newName;
    }
    
    
    private List<SldUserStyle> getUserStyles(Node node) throws Exception {
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        setNameSpaceContext(xpath);

        String expr = "sld:UserStyle";
        NodeList nodeSet = (NodeList) xpath.evaluate(expr, node, XPathConstants.NODESET);

        List<SldUserStyle> userStyles = new ArrayList<SldUserStyle>();
        for (int i = 0; i < nodeSet.getLength(); i++) {
            Node n = (Node) nodeSet.item(i);
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
     
    public void addNamedLayers(List<SldNamedLayer> namedlayers) {
        if (this.namedlayers == null) {
            this.namedlayers = namedlayers;
        } else {
            this.namedlayers.addAll(namedlayers);
        }
    }
    
    public void addNamedLayer(SldNamedLayer namedlayer) {
        if (this.namedlayers == null) {
            this.namedlayers = new ArrayList<SldNamedLayer>();
        }
        namedlayers.add(namedlayer);
    }
    
    public void replaceAndFilterOnNames(String spAbbr, List<String> realLayernames) throws Exception {
        if (namedlayers == null || spAbbr==null || spAbbr.isEmpty()) {
            return;
        }
        synchronized (namedlayers) {
            List<SldNamedLayer> replacedAndFilteredlayers = new ArrayList<SldNamedLayer>();
            Iterator<SldNamedLayer> it = namedlayers.iterator();
            while (it.hasNext()) {
                SldNamedLayer nl = it.next();
                String[] codeAndName = OGCCommunication.toCodeAndName(nl.getName());
                if (codeAndName[0] != null
                        && codeAndName[0].equals(spAbbr)) {
                    nl.setName(codeAndName[1]);
                    replacedAndFilteredlayers.add(nl);
                } else if (codeAndName[0] == null
                        && codeAndName[1] != null
                        && realLayernames != null) {
                    // Als er geen afkorting in namedlayer zit is
                    // codeAndName[0] null. Kijken of name overeenkomt 
                    // met een layer uit service ?
                    Iterator<String> it2 = realLayernames.iterator();
                    while (it2.hasNext()) {
                        String ln = it2.next();
                        if (ln.equals(codeAndName[1])) {
                            replacedAndFilteredlayers.add(nl);
                        }
                    }
                }
            }
            this.namedlayers = replacedAndFilteredlayers;
        }
    }

    public List<SldNamedLayer> createNamedLayersWithKBStyles(List<Style> kbStyles) throws UnsupportedEncodingException, IOException, XPathExpressionException, Exception{        
        List<SldNamedLayer> namedLayers= new ArrayList<SldNamedLayer>();
        for (Style kbStyle : kbStyles){
            List<SldNode> sldStyles= new ArrayList<SldNode>();            
            if (kbStyle.getSldConstraints()!=null){
                Document docConstraint=getDocument(kbStyle.getSldConstraints(),encoding);
                sldStyles.add(new SldLayerFeatureConstraints(docConstraint.getDocumentElement()));                
            }
            Document doc=getDocument(kbStyle.getSldPart(),encoding);
            String nodeName = doc.getDocumentElement().getNodeName();
            if (nodeName.toLowerCase().indexOf("namedstyle")!=-1){
                sldStyles.add(new SldNamedStyle(doc.getDocumentElement()));
            }else{
                sldStyles.add(new SldUserStyle(doc.getDocumentElement()));
            }
            SldNamedLayer snl = new SldNamedLayer(sldStyles,kbStyle.getLayer().getName());
            namedLayers.add(snl);
        }        
        return namedLayers;
    }

    public String createSLD() throws Exception{
        Document sldDoc = getDocument(SldNode.getSldNodeString(version), encoding);
        for (SldNamedLayer snl : namedlayers){
            Node snlNode = snl.getNode();
            Node importedNode = sldDoc.importNode(snlNode, true);
            sldDoc.getFirstChild().appendChild(importedNode);
            sldDoc.normalizeDocument();
        }
        String sldString = DocumentHelper.document2String(sldDoc);
        //TODO mapserver kan sld niet lezen als er een namespace staat bij Name!!!
        //Dit kan omdat de namespace se al gedeclareerd is in het root element.
        String newSldString = sldString
                .replaceFirst("xmlns:se=\"http://www.opengis.net/se\"", "HACKHACK")
                .replaceAll(" xmlns:se=\"http://www.opengis.net/se\"", "")
                .replaceFirst("HACKHACK", "xmlns:se=\"http://www.opengis.net/se\"");
        return newSldString;
    }

    /**
     * @return the namedlayers
     */
    public List<SldNamedLayer> getNamedlayers() {
        return namedlayers;
    }

    /**
     * @param namedlayers the namedlayers to set
     */
    public void setNamedlayers(List<SldNamedLayer> namedlayers) {
        this.namedlayers = namedlayers;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }
}
