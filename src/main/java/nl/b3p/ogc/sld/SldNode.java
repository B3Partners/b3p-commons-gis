package nl.b3p.ogc.sld;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import nl.b3p.commons.xml.DocumentHelper;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * versie 1.0.0
 * <pre>
 * <?xml version="1.0" encoding="ISO-8859-1"?>
 * <StyledLayerDescriptor version="1.0.0"
 *    xsi:schemaLocation="http://www.opengis.net/sld StyledLayerDescriptor.xsd"
 *    xmlns="http://www.opengis.net/sld"
 *    xmlns:ogc="http://www.opengis.net/ogc"
 *    xmlns:xlink="http://www.w3.org/1999/xlink"
 *    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
 * 
 *    <NamedLayer>
 *       <Name>OCEANSEA_1M:Foundation</Name>
 *       <UserStyle>
 *          <Name>GEOSYM</Name>
 *          <IsDefault>1</IsDefault>
 *          <FeatureTypeStyle>
 *             <Rule>
 *                <Name>main</Name>
 *                <PolygonSymbolizer>
 *                   <Geometry>
 *                      <ogc:PropertyName>GEOMETRY</ogc:PropertyName>
 *                   </Geometry>
 *                   <Fill>
 *                      <CssParameter name="fill">#96C3F5</CssParameter>
 *                   </Fill>
 *                </PolygonSymbolizer>
 *             </Rule>
 *          </FeatureTypeStyle>
 *       </UserStyle>
 *    </NamedLayer>
 * 
 * </StyledLayerDescriptor>
 * </pre>
 * 
 * versie 1.1.0
 * <pre>
 * <?xml version="1.0" encoding="ISO-8859-1"?>
 * <StyledLayerDescriptor version="1.1.0" xsi:schemaLocation="http://www.opengis.net/sld StyledLayerDescriptor.xsd" xmlns="http://www.opengis.net/sld" 
 * xmlns:ogc="http://www.opengis.net/ogc" xmlns:se="http://www.opengis.net/se" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
 * 	<NamedLayer>
 * 		<se:Name>OCEANSEA_1M:Foundation</se:Name>
 * 		<UserStyle>
 * 			<se:Name>GEOSYM</se:Name>
 * 			<IsDefault>1</IsDefault>
 * 			<se:FeatureTypeStyle>
 * 				<se:FeatureTypeName>Foundation</se:FeatureTypeName>
 * 				<se:Rule>
 * 					<se:Name>main</se:Name>
 * 					<se:PolygonSymbolizer uom="http://www.opengis.net/sld/units/pixel">
 * 						<se:Name>MySymbol</se:Name>
 * 						<se:Description>
 * 							<se:Title>Example Symbol</se:Title>
 * 							<se:Abstract>This is just a simple example.</se:Abstract>
 * 						</se:Description>
 * 						<se:Geometry>
 * 							<ogc:PropertyName>GEOMETRY</ogc:PropertyName>
 * 						</se:Geometry>
 * 						<se:Fill>
 * 							<se:SvgParameter name="fill">#96C3F5</se:SvgParameter>
 * 						</se:Fill>
 * 					</se:PolygonSymbolizer>
 * 				</se:Rule>
 * 			</se:FeatureTypeStyle>
 * 		</UserStyle>
 * 	</NamedLayer>
 * </StyledLayerDescriptor>
 * </pre>
 * 
 * B3partners B.V. http://www.b3partners.nl
 * @author Roy
 * Created on 1-sep-2011, 11:34:49
 */
abstract public class SldNode {
    private static final Log log = LogFactory.getLog(SldNamedLayer.class);
    
    private static XPathFactory factory = null;
    protected static XPath xpath = null;
    
    protected Node node; 
    
    protected String version = "1.1.0";
    protected List<String> supportedVersions = Arrays.asList("1.0.0","1.1.0");
    
    
    public abstract String getName() throws Exception; 
    
    public SldNode() throws XPathExpressionException {
        if (factory == null) {
            factory = XPathFactory.newInstance();
            xpath = factory.newXPath();
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
    
    public SldNode(String version) throws XPathExpressionException {
        this();
        if (supportedVersions.contains(version)) {
            this.version = version;
        } else {
            throw new NotImplementedException();
        }
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
    
    public String getSldPart() {
        return serializeXpathNode(node);
    }
    
    protected boolean isTextNode(Node node) {
        short nodeType;

        if (node == null) {
            return false;
        }

        nodeType = node.getNodeType();

        return nodeType == Node.CDATA_SECTION_NODE || nodeType == Node.TEXT_NODE;
    }
    
    public Node getNode() {
        return node;
    }
    
    public void setNode(Node node) {
        this.node = node;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }
    
    public static String getSldNodeString(String ver) {
        if (ver.equalsIgnoreCase("1.0.0")) {
            return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                    + "<StyledLayerDescriptor"
                    + " xmlns=\"http://www.opengis.net/sld\""
                    + " xmlns:ogc=\"http://www.opengis.net/ogc\""
                    + " xmlns:se=\"http://www.opengis.net/se\""
                    + " xmlns:xlink=\"http://www.w3.org/1999/xlink\""
                    + " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""
                    + " xsi:schemaLocation=\"http://www.opengis.net/sld http://schemas.opengis.net/sld/1.0.0/StyledLayerDescriptor.xsd\""
                    + " version=\"1.0.0\""
                    + "/>";
        } else if (ver.equalsIgnoreCase("1.1.0")) {
            return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                    + "<StyledLayerDescriptor"
                    + " xmlns=\"http://www.opengis.net/sld\""
                    + " xmlns:ogc=\"http://www.opengis.net/ogc\""
                    + " xmlns:se=\"http://www.opengis.net/se\""
                    + " xmlns:xlink=\"http://www.w3.org/1999/xlink\""
                    + " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""
                    + " xsi:schemaLocation=\"http://www.opengis.net/sld http://schemas.opengis.net/sld/1.1.0/StyledLayerDescriptor.xsd\""
                    + " version=\"1.1.0\""
                    + "/>";
        } else {
            throw new NotImplementedException();
        }
    }

    public static String getSld100Example() {
        return "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>"
                + "<StyledLayerDescriptor version=\"1.0.0\""
                + "   xsi:schemaLocation=\"http://www.opengis.net/sld StyledLayerDescriptor.xsd\""
                + "   xmlns=\"http://www.opengis.net/sld\""
                + "   xmlns:ogc=\"http://www.opengis.net/ogc\""
                + "   xmlns:xlink=\"http://www.w3.org/1999/xlink\""
                + "   xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "   <NamedLayer>"
                + "      <Name>OCEANSEA_1M:Foundation</Name>"
                + "      <UserStyle>"
                + "         <Name>GEOSYM</Name>"
                + "         <IsDefault>1</IsDefault>"
                + "         <FeatureTypeStyle>"
                + "            <Rule>"
                + "               <Name>main</Name>"
                + "               <PolygonSymbolizer>"
                + "                  <Geometry>"
                + "                     <ogc:PropertyName>GEOMETRY</ogc:PropertyName>"
                + "                  </Geometry>"
                + "                  <Fill>"
                + "                     <CssParameter name=\"fill\">#96C3F5</CssParameter>"
                + "                  </Fill>"
                + "               </PolygonSymbolizer>"
                + "            </Rule>"
                + "         </FeatureTypeStyle>"
                + "      </UserStyle>"
                + "   </NamedLayer>"
                + "</StyledLayerDescriptor>";
    }

    public static String getSld110Example() {
        return "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>"
                + "<StyledLayerDescriptor version=\"1.1.0\" xsi:schemaLocation=\"http://www.opengis.net/sld StyledLayerDescriptor.xsd\" xmlns=\"http://www.opengis.net/sld\" "
                + "xmlns:ogc=\"http://www.opengis.net/ogc\" xmlns:se=\"http://www.opengis.net/se\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "	<NamedLayer>"
                + "		<se:Name xmlns:se=\"http://www.opengis.net/se\">OCEANSEA_1M:Foundation</se:Name>"
                + "		<UserStyle>"
                + "			<se:Name>GEOSYM</se:Name>"
                + "			<IsDefault>1</IsDefault>"
                + "			<se:FeatureTypeStyle>"
                + "				<se:FeatureTypeName>Foundation</se:FeatureTypeName>"
                + "				<se:Rule>"
                + "					<se:Name>main</se:Name>"
                + "					<se:PolygonSymbolizer uom=\"http://www.opengis.net/sld/units/pixel\">"
                + "						<se:Name>MySymbol</se:Name>"
                + "						<se:Description>"
                + "							<se:Title>Example Symbol</se:Title>"
                + "							<se:Abstract>This is just a simple example.</se:Abstract>"
                + "						</se:Description>"
                + "						<se:Geometry>"
                + "							<ogc:PropertyName>GEOMETRY</ogc:PropertyName>"
                + "						</se:Geometry>"
                + "						<se:Fill>"
                + "							<se:SvgParameter name=\"fill\">#96C3F5</se:SvgParameter>"
                + "						</se:Fill>"
                + "					</se:PolygonSymbolizer>"
                + "				</se:Rule>"
                + "			</se:FeatureTypeStyle>"
                + "		</UserStyle>"
                + "	</NamedLayer>"
                + "</StyledLayerDescriptor>";
    }

    public static void main(String [] args) throws Exception {
        Document nl110Doc = SldWriter.getDocument(getSld110Example(), "UTF-8");
        Document nl100Doc = SldWriter.getDocument(getSld100Example(), "UTF-8");

        SldWriter sr = new SldWriter();
        sr.parseDocument(nl110Doc);
        System.out.println("110 doc, version: " + sr.getVersion());
        List<SldNamedLayer> nl110List = sr.getNamedlayers();

        SldWriter sr2 = new SldWriter();
        sr2.parseDocument(nl100Doc);
        System.out.println("100 doc, version: " + sr2.getVersion());
        List<SldNamedLayer> nl100List = sr2.getNamedlayers();
        
        Document sldDoc = SldWriter.getDocument(getSldNodeString("1.1.0"), "UTF-8");
        for (SldNamedLayer snl : nl110List){
            Node snlNode = snl.getNode();
            Node importedNode = sldDoc.importNode(snlNode, true);
            sldDoc.getFirstChild().appendChild(importedNode);
        }
        for (SldNamedLayer snl : nl100List){
            Node snlNode = snl.getNode();
            Node importedNode = sldDoc.importNode(snlNode, true);
            sldDoc.getFirstChild().appendChild(importedNode);
        }
        sldDoc.normalizeDocument();
        
        String sldString = DocumentHelper.document2String(sldDoc);
        System.out.println(sldString);
        String newSldString = sldString
                .replaceFirst("xmlns:se=\"http://www.opengis.net/se\"", "HACKHACK")
                .replaceAll(" xmlns:se=\"http://www.opengis.net/se\"", "")
                .replaceFirst("HACKHACK","xmlns:se=\"http://www.opengis.net/se\"");
        System.out.println(newSldString);
        Document newSldDoc = SldWriter.getDocument(newSldString, "UTF-8");
        System.out.println(DocumentHelper.document2String(newSldDoc));

    }
}
