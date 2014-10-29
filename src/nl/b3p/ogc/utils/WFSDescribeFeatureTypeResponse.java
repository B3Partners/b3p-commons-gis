/*
 * B3P Commons GIS is a library with commonly used classes for OGC
 * reading and writing. Included are wms, wfs, gml, csv and other
 * general helper classes and extensions.
 *
 * Copyright 2005 - 2008 B3Partners BV
 * 
 * This file is part of B3P Commons GIS.
 * 
 * B3P Commons GIS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * B3P Commons GIS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with B3P Commons GIS.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * WFSDescribeFeatureTypeResponse.java
 *
 * Created on May 16, 2008, 9:32 AM
 *
 * Vergelijkbare klasse als OGCRequest.java maar dan om de response mee te verwerken die
 * de serviceprviders stuurt na een request.
 */
package nl.b3p.ogc.utils;

import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Chris
 */
public class WFSDescribeFeatureTypeResponse extends OGCResponse implements OGCConstants {

    private Document doc = null;

    public void rebuildResponse(Document doc, OGCRequest request, String prefix) throws Exception {
        this.setUsableResponse(true);
        findNameSpace(doc);
        rebuildNodeWithNameReplace(doc, prefix);
        this.doc = doc;
    }

    public String getResponseBody(List<SpLayerSummary> layers, OGCRequest ogcrequest, String encoding) {
        if (!this.isUsableResponse()) {
            if (this.hasWfsV100ErrorResponse()) {
                return this.getWfsV100ErrorResponseBody(encoding);
            } else if (this.hasOwsV100ErrorResponse()) {
                return this.getOwsV100ErrorResponseBody(encoding);
            } else {
                throw new UnsupportedOperationException("Failed to get suitable reponse! ");
            }
        }
        if (this.hasWfsV100ErrorResponse()) {
            logErrorResponse(encoding);
        }
        try {
            return serializeNode(doc);
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Failed to get body of XML! Exception: " + ex);
        }
    }

    private void rebuildNodeWithNameReplace(Node currentNode, String spAbbr) throws Exception {
        String prefix = getNameSpacePrefix("http://www.w3.org/2001/XMLSchema", true);
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        if (prefix != null && prefix.length() > 0) {
            sb.append(prefix);
            sb.append(":");
        }
        sb.append("schema");
        String parentPath = sb.toString();
        
        Node parentNode = null;
        NodeList parentNodes = getNodeListFromXPath(currentNode, parentPath);
        if (parentNodes.getLength() == 1) {
            parentNode = parentNodes.item(0);
            NodeList nodes = parentNode.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                Node n = nodes.item(i);
                String nodeName = n.getNodeName();
                if (nodeName==null || !nodeName.equals("element")) {
                    continue;
                }
                NamedNodeMap nnm = n.getAttributes();
                if (nnm == null) {
                    continue;
                }
                Node nameAttr = nnm.getNamedItem("name");
                if (nameAttr == null) {
                    continue;
                }
                String textContent = nameAttr.getTextContent();
                String newName = determineFeatureTypeName(spAbbr, textContent);
                nameAttr.setTextContent(newName);
            }
        }

    }

}
