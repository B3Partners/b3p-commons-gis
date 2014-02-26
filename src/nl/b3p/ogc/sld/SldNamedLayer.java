package nl.b3p.ogc.sld;

import java.util.ArrayList;
import java.util.List;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
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
    private static XPathExpression xpath_namedStyle;
    private static XPathExpression xpath_layerFeatureConstraints;
    
    static{
        try{
            xpath_name = xpath.compile("Name");
            xpath_userStyle = xpath.compile("UserStyle");
            xpath_namedStyle = xpath.compile("NamedStyle");
            xpath_layerFeatureConstraints = xpath.compile("LayerFeatureConstraints");
        }catch(Exception e){}
    }

    public SldNamedLayer() {
    }
    
    public SldNamedLayer(List<SldNode> styles, String namedLayerName) throws Exception{
        String xml = "";
        xml += "<NamedLayer>";
        xml += "<Name>" + namedLayerName + "</Name>";
        for (SldNode style : styles) {
            xml += style.getSldPart();
        }
        xml += "</NamedLayer>";
        Document doc=SldReader.getDocument(xml,"UTF-8");
        
        this.node=doc.getDocumentElement();  
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
    
    public List<SldNamedStyle> getNamedStyles() throws Exception {
        NodeList nodeSet = (NodeList) xpath_namedStyle.evaluate(node, XPathConstants.NODESET);
        List<SldNamedStyle> namedStyles = new ArrayList<SldNamedStyle>();
        SldLayerFeatureConstraints constriants = this.getLayerFeatureConstraints();
        for (int i = 0; i < nodeSet.getLength(); i++) {
            Node n = (Node) nodeSet.item(i);
            SldNamedStyle sldNamedStyle = new SldNamedStyle(n);
            //named layer without a constraint is 'useless' in a request
            sldNamedStyle.setFeatureConstraints(constriants);
            namedStyles.add(sldNamedStyle);
        }
        return namedStyles;
    }
    
    public SldLayerFeatureConstraints getLayerFeatureConstraints() throws Exception {
        
        NodeList nodeSet = (NodeList) xpath_layerFeatureConstraints.evaluate(node, XPathConstants.NODESET);

        SldLayerFeatureConstraints layerFeatureConstraints =null;
        if (nodeSet.getLength()>0){
            Node n = (Node) nodeSet.item(0);
            layerFeatureConstraints = new SldLayerFeatureConstraints(n);
        }
        return layerFeatureConstraints;
    }
    
    public List<SldNode> getStyles() throws Exception{
        List<SldNode> list = new ArrayList<SldNode>();
        list.addAll(this.getUserStyles());
        list.addAll(this.getNamedStyles());        
        return list;
    }
}