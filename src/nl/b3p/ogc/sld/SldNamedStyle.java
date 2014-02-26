/*
 * Copyright (C) 2013 B3Partners B.V.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package nl.b3p.ogc.sld;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import static nl.b3p.ogc.sld.SldNode.xpath;
import org.w3c.dom.Node;

/**
 *
 * @author Roy Braam
 */
public class SldNamedStyle extends SldNode{
    
    private static XPathExpression xpath_name;
    private SldLayerFeatureConstraints constriants;
    static{
        try{
            xpath_name = xpath.compile("Name");
        }catch(Exception e){}
    }
       
    public SldNamedStyle() {
    }

    public SldNamedStyle(Node node) {
        this.node = node;
    }
   
    public String getName() throws XPathExpressionException {
        String name="";
        if (this.constriants!=null){
            name+=this.constriants.getName()+" - ";                    
        }
        name+=xpath_name.evaluate(node);        
        return name;
    }
    public void setName(String name) throws XPathExpressionException{
        //this.name = name;
        Node n=(Node) xpath_name.evaluate(node, XPathConstants.NODE);
        n.setNodeValue(name);
    }
    
    @Override
    public String getSldPart() {
        String sldPart="";
        
        sldPart+= super.getSldPart();
        return sldPart;
    }
    
    public SldLayerFeatureConstraints getFeatureConstraints() {
        return constriants;
    }
    
    public void setFeatureConstraints(SldLayerFeatureConstraints constriants) {
        this.constriants = constriants;
    }
    
}