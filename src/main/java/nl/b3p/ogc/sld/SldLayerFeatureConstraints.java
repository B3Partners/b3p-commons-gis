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

import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Node;

/**
 *
 * @author Roy Braam
 */
public class SldLayerFeatureConstraints extends SldNode {

    SldLayerFeatureConstraints() throws XPathExpressionException {
        super();
    }

    SldLayerFeatureConstraints(Node n) throws XPathExpressionException {
        this();
        this.node=n;
    }

    @Override
    public String getName() throws XPathExpressionException {
        return "LayerFeatureConstraint";
    }
  
}