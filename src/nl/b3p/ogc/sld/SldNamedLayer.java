package nl.b3p.ogc.sld;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Boy de Wit
 */
public class SldNamedLayer extends SldNode{
    private static final Log log = LogFactory.getLog(SldNamedLayer.class);
        
    private static XPathExpression xpath_name;
    private static XPathExpression xpath_userStyle;
    
    static{
        try{
            xpath_name = xpath.compile("Name");
            xpath_userStyle = xpath.compile("UserStyle");
        }catch(Exception e){}
    }
    
    private Node node;

    public SldNamedLayer() {
    }

    public SldNamedLayer(Node node) {
        this.node = node;
    }

    public String getName() throws XPathExpressionException {
        return xpath_name.evaluate(node);
    }

    public void setName(String name) throws XPathExpressionException {
        //this.name = name;
        Node n=(Node) xpath_name.evaluate(node, XPathConstants.NODE);
        n.setTextContent(name);
        //n.setNodeValue(name);
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public String getSldPart() {
        return serializeXpathNode(node);
    }

    public List<SldUserStyle> getUserStyles() throws Exception {
        
        NodeList nodeSet = (NodeList) xpath_userStyle.evaluate(node, XPathConstants.NODESET);

        List<SldUserStyle> userStyles = new ArrayList<SldUserStyle>();
        for (int i = 0; i < nodeSet.getLength(); i++) {
            Node n = (Node) nodeSet.item(i);
            SldUserStyle sldUserStyle = new SldUserStyle(n);
            userStyles.add(sldUserStyle);
        }

        return userStyles;
    }
}