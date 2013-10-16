/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.b3p.wms.capabilities;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import nl.b3p.ogc.utils.OGCCommunication;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * B3partners B.V. http://www.b3partners.nl
 * @author Roy
 * Created on 30-sep-2011, 10:53:38
 */
public class TileSet {
    private Integer id;
    private String srs;
    private SrsBoundingBox boundingBox;
    private String resolutions;
    private Integer width;
    private Integer height;
    private String format;
    private Set<Layer> layers;
    private String styles;
    private String layerString;
    private ServiceProvider serviceProvider;
    
     private String urlServiceProvideCode = null;

    //<editor-fold defaultstate="collapsed" desc="Getters/setters">
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getSrs() {
        return srs;
    }
    
    public void setSrs(String srs) {
        this.srs = srs;
    }
    
    public String getResolutions() {
        return resolutions;
    }
    
    public void setResolutions(String resolutions) {
        this.resolutions = resolutions;
    }
    
    public Integer getWidth() {
        return width;
    }
    
    public void setWidth(Integer width) {
        this.width = width;
    }
    
    public Integer getHeight() {
        return height;
    }
    
    public void setHeight(Integer height) {
        this.height = height;
    }
    
    public String getFormat() {
        return format;
    }
    
    public void setFormat(String format) {
        this.format = format;
    }
    
    public Set<Layer> getLayers() {
        return layers;
    }
    
    public void setLayers(Set<Layer> layers) {
        this.layers = layers;
    }

    public String getUrlServiceProvideCode() {
        return urlServiceProvideCode;
    }

    public void setUrlServiceProvideCode(String urlServiceProvideCode) {
        this.urlServiceProvideCode = urlServiceProvideCode;
    }
    
    public String getStyles() {
        return styles;
    }
    
    public void setStyles(String styles) {
        this.styles = styles;
    }
        
    public SrsBoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(SrsBoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }
    
    public String getLayerString() {
        return layerString;
    }

    public void setLayerString(String layerString) {
        this.layerString = layerString;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
    //</editor-fold>

    void addLayer(Layer l) {
        if (layers==null){
            layers=new HashSet<Layer>();
        }
        layers.add(l);
    }
    
    public Element toElement(Document doc, Element rootElement){        
        
        if (this.getSrs()!=null){
            Element element = (Element) doc.createElement("SRS");
            Text text = doc.createTextNode(this.getSrs());
            element.appendChild(text);
            rootElement.appendChild(element);
        }
        
        if (this.getBoundingBox()!=null){           
            rootElement=this.getBoundingBox().toElement(doc,rootElement);   
        }
        
        if (this.getResolutions()!=null){            
            Element element = doc.createElement("Resolutions");
            Text text = doc.createTextNode(this.getResolutions());
            element.appendChild(text);
            rootElement.appendChild(element);
        }
        
        if (this.getWidth()!=null){
            Element element = doc.createElement("Width");
            Text text = doc.createTextNode(""+this.getWidth());
            element.appendChild(text);
            rootElement.appendChild(element);
        }
        
        if (this.getHeight()!=null){
            Element element = doc.createElement("Height");
            Text text = doc.createTextNode(""+this.getHeight());
            element.appendChild(text);
            rootElement.appendChild(element);
        }
        
        if (this.getFormat()!=null){
            Element element = doc.createElement("Format");
            Text text = doc.createTextNode(this.getFormat());
            element.appendChild(text);
            rootElement.appendChild(element);
        }
        
        if (this.getLayers()!=null){
            String layerString="";
            Iterator<Layer> lit=this.getLayers().iterator();
            while (lit.hasNext()){
                Layer l = lit.next();
                
                if (layerString.length()>0){
                    layerString+=",";
                }
				layerString+=OGCCommunication.attachSp(l.getSpAbbr(), l.getName());
            }
            Element element = doc.createElement("Layers");
            Text text = doc.createTextNode(layerString);
            element.appendChild(text);
            rootElement.appendChild(element);
        }
        if (this.getStyles()!=null){
            Element element = (Element) doc.createElement("Styles");
            Text text = doc.createTextNode(this.getStyles());
            element.appendChild(text);
            rootElement.appendChild(element);
        }
                
        
        return rootElement;
    }


}
