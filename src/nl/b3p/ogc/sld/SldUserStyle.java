package nl.b3p.ogc.sld;

import nl.b3p.wms.capabilities.Style;
import org.w3c.dom.Node;

/**
 *
 * @author Boy de Wit
 */
public class SldUserStyle {

    private String name;
    private String sldPart;
    private Node node;

    public SldUserStyle() {
    }

    public SldUserStyle(String name, String sldPart, Node node) {
        this.name = name;
        this.sldPart = sldPart;
        this.node = node;
    }
    
    public SldUserStyle(Style s){
        this.setName(s.getName());
        this.setSldPart(s.getSldPart());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public String getSldPart() {
        return sldPart;
    }

    public void setSldPart(String sldPart) {
        this.sldPart = sldPart;
    }
}