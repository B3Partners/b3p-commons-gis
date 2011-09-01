package nl.b3p.ogc.sld;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import nl.b3p.wms.capabilities.Style;
import org.w3c.dom.Node;

/**
 *
 * @author Boy de Wit
 */
public class SldUserStyle extends SldNode{
    
    private static XPathExpression xpath_name;
    
    private Node node;    
    
    static{
        try{
            xpath_name = xpath.compile("Name");
        }catch(Exception e){}
    }
       
    public SldUserStyle() {
    }

    public SldUserStyle(Node node) {
        this.node = node;
    }
    
    /*public SldUserStyle(Style s) throws XPathExpressionException{
       this.setName(s.getName());
        this.setSldPart(s.getSldPart());
        
    }*/

    public String getName() throws XPathExpressionException {
        return xpath_name.evaluate(node);
    }

    public void setName(String name) throws XPathExpressionException{
        //this.name = name;
        Node n=(Node) xpath_name.evaluate(node, XPathConstants.NODE);
        n.setNodeValue(name);
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

}