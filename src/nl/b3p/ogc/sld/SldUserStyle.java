package nl.b3p.ogc.sld;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import org.apache.commons.lang.NotImplementedException;
import org.w3c.dom.Node;

/**
 *
 * @author Boy de Wit
 */
public class SldUserStyle extends SldNode {
    
    private static XPathExpression xpath_name = null;
       
    public SldUserStyle() throws XPathExpressionException {
        super();
        initXpath();
    }
    
    public SldUserStyle(String version) throws XPathExpressionException {
        super(version);
        initXpath();
    }
    
    private void initXpath() throws XPathExpressionException {
        if (xpath_name == null) {
            if (version.equalsIgnoreCase("1.0.0")) {
                xpath_name = xpath.compile("sld:Name");
            } else if (version.equalsIgnoreCase("1.1.0")) {
                xpath_name = xpath.compile("se:Name");
            } else {
                throw new NotImplementedException();
            }
        }
    }

    public SldUserStyle(Node node) throws XPathExpressionException {
        this();
        this.node = node;
    }
    
    public SldUserStyle(Node node, String version) throws XPathExpressionException {
        this(version);
        this.node = node;
    }

    public String getName() throws XPathExpressionException {
        return xpath_name.evaluate(node);
    }

    public void setName(String name) throws XPathExpressionException{
        //this.name = name;
        Node n=(Node) xpath_name.evaluate(node, XPathConstants.NODE);
        n.setNodeValue(name);
    }
}