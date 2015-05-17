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
import org.apache.commons.lang.NotImplementedException;
import org.w3c.dom.Node;

/**
 *
 * @author Roy Braam
 */
public class SldNamedStyle extends SldNode {
    
    private static XPathExpression xpath_name = null;
    private SldLayerFeatureConstraints constraints;
       
    public SldNamedStyle() throws XPathExpressionException {
        super();
        initXpath();
    }
    
    public SldNamedStyle(String version) throws XPathExpressionException {
        super(version);
        initXpath();
    }
    
    private void initXpath() throws XPathExpressionException {
       if (xpath_name == null) {
            if (version.equalsIgnoreCase("1.0.0")) {
                xpath_name = xpath.compile("sld:Name");
            } else if (version.equalsIgnoreCase("1.1.0")) {
                xpath_name = xpath.compile("sld:Name");
            } else {
                throw new NotImplementedException();
            }
        }
    }

    public SldNamedStyle(Node node) throws XPathExpressionException {
        this();
        this.node = node;
    }
    
    public SldNamedStyle(Node node, String version) throws XPathExpressionException {
        this(version);
        this.node = node;
    }
   
    public String getName() throws XPathExpressionException {
        String name="";
        if (this.constraints!=null){
            name+=this.constraints.getName()+" - ";                    
        }
        name+=xpath_name.evaluate(node);        
        return name;
    }
    
    public void setName(String name) throws XPathExpressionException{
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
        return constraints;
    }
    
    public void setFeatureConstraints(SldLayerFeatureConstraints constraints) {
        this.constraints = constraints;
    }
    
}