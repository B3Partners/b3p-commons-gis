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
 * OGCResponse.java
 *
 * Created on May 16, 2008, 9:32 AM
 *
 * Vergelijkbare klasse als OGCRequest.java maar dan om de response mee te verwerken die
 * de serviceprviders stuurt na een request.
 */
package nl.b3p.ogc.utils;

import com.sun.org.apache.xerces.internal.dom.DeferredElementNSImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Iterator;
import org.exolab.castor.xml.Unmarshaller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Chris
 */
public class WFSGetFeatureResponse extends OGCResponse implements OGCConstants {

    private final List featureCollectionV100 = new ArrayList();
    private final List featureCollectionV110 = new ArrayList();

 
    protected void replaceFeatureTypeName(Element elem, String spAbbr) throws Exception {
        // update layer names in response
        String wfsPrefix = getNameSpacePrefix("http://www.opengis.net/wfs", true);
        String gmlPrefix = getNameSpacePrefix("http://www.opengis.net/gml", true);
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        if (wfsPrefix != null && wfsPrefix.length() > 0) {
            sb.append(wfsPrefix);
            sb.append(":");
        }
        sb.append("FeatureCollection/");
        if (gmlPrefix != null && gmlPrefix.length() > 0) {
            sb.append(gmlPrefix);
            sb.append(":");
        }
        sb.append("featureMember");
        NodeList nodes = getNodeListFromXPath(elem, sb.toString());
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            Node cn = n.getFirstChild();
             while (cn != null) {
                if (cn.getNodeType() == Node.ELEMENT_NODE) {
                    String cn_ns = cn.getNamespaceURI();
                    String oldName = null;
                    if (cn_ns != null && cn_ns.length() > 0) {
                        oldName = "{" + cn_ns + "}" + cn.getLocalName();
                    } else {
                        oldName = cn.getLocalName();
                    }
                    String newName = determineFeatureTypeName(spAbbr, oldName);
                    Element e = elem.getOwnerDocument().createElementNS(cn_ns, newName);
                    n.appendChild(e);

                    if (cn instanceof DeferredElementNSImpl || cn instanceof Element) {
                        Element e2 = (Element) cn;
                        NodeList childs = e2.getChildNodes();
                        for (int j = 0; j < childs.getLength(); j++) {
                            Node child = childs.item(j);
                            Node tempNode = child.cloneNode(true);
                            e.appendChild(tempNode);
                        }
                        n.replaceChild(e, cn);
                    }
                }
                cn = cn.getNextSibling();
            }
        }
    }

    public void rebuildResponse(Document doc, OGCRequest request, String prefix) throws Exception {
        Element element = (Element) doc.getDocumentElement();
        this.httpHost = request.getUrlWithNonOGCparams();
        findNameSpace(doc);
        Unmarshaller um;
        Object o;
 
        version = request.getFinalVersion();

        if (version != null && version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)) {
            // replace in dom tree, AnyNode is not mutable
            replaceFeatureTypeName(element, prefix);

            um = new Unmarshaller(nl.b3p.xml.wfs.v100.FeatureCollection.class);
            o = um.unmarshal(element);
            nl.b3p.xml.wfs.v100.FeatureCollection featureCollection = (nl.b3p.xml.wfs.v100.FeatureCollection) o;

            featureCollectionV100.add(replaceFeatureCollectionV100Url(featureCollection, prefix));
        } else {
            // replace in dom tree, AnyNode is not mutable
            replaceFeatureTypeName(element, prefix);

            um = new Unmarshaller(nl.b3p.xml.wfs.v110.FeatureCollection.class);
            o = um.unmarshal(element);
            nl.b3p.xml.wfs.v110.FeatureCollection featureCollection = (nl.b3p.xml.wfs.v110.FeatureCollection) o;

            featureCollectionV110.add(replaceFeatureCollectionV110Url(featureCollection, prefix));
        }
    }
    
    public String changeLocation(String location, String serverPrefix) {
        String newSchemalocations = "";
        String[] tokens = location.split(" ");
        for (int x = 0; x < tokens.length; x++) {
            String[] token = tokens[x].split("\\?", 2);
            if (token.length == 2) {
                String kvp = token[1];
                String newToken = "";
                String[] kvpSplit = kvp.split("\\&");
                for (int z = 0; z < kvpSplit.length; z++) {
                    String[] newKvp = kvpSplit[z].split("=");
                    if (newKvp[0].equals(OGCConstants.WFS_PARAM_TYPENAME)) {
                        String changedlayer = attachSp(serverPrefix, newKvp[1]);
                        newToken = newToken + "&" + newKvp[0] + "=" + changedlayer;
                    } else {
                        newToken = newToken + "&" + kvpSplit[z];
                    }
                }
                if (x != 0) {
                    newSchemalocations = newSchemalocations + " " + httpHost + newToken;
                } else {
                    newSchemalocations = newSchemalocations + httpHost + newToken;
                }
            } else {
                if (x != 0) {
                    newSchemalocations = newSchemalocations + " " + token[0];
                } else {
                    newSchemalocations = newSchemalocations + token[0];
                }
            }
        }
        return newSchemalocations;
    }
    
    public nl.b3p.xml.wfs.v100.FeatureCollection replaceFeatureCollectionV100Url(nl.b3p.xml.wfs.v100.FeatureCollection featureCollection, String serverPrefix) {
        String newSchemalocations = "";
        if (getSchemaLocations() != null) {
            Set keys = getSchemaLocations().keySet();
            Iterator it = keys.iterator();
            for (int i = 0; it.hasNext(); i++) {
                String prefix = (String) it.next();
                String location = (String) getSchemaLocations().get(prefix);
                newSchemalocations = changeLocation(location, serverPrefix);
                addOrReplaceSchemaLocation(prefix, newSchemalocations);
            }
        }
        return featureCollection;
    }

    public nl.b3p.xml.wfs.v110.FeatureCollection replaceFeatureCollectionV110Url(nl.b3p.xml.wfs.v110.FeatureCollection featureCollection, String serverPrefix) {
        String newSchemalocations = "";
        if (getSchemaLocations() != null) {
            Set keys = getSchemaLocations().keySet();
            Iterator it = keys.iterator();
            for (int i = 0; it.hasNext(); i++) {
                String prefix = (String) it.next();
                String location = (String) getSchemaLocations().get(prefix);
                newSchemalocations = changeLocation(location, serverPrefix);
                addOrReplaceSchemaLocation(prefix, newSchemalocations);
            }
        }
        return featureCollection;
    }

    public String getResponseBody(List<SpLayerSummary> layers, OGCRequest ogcrequest, String encoding) {
        Object castorObject = null;

        Object o = mergeFeatureCollection();

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
        if (version.equals(OGCConstants.WFS_VERSION_100)) {
            castorObject = (nl.b3p.xml.wfs.v100.FeatureCollection) o;
        } else {
            castorObject = (nl.b3p.xml.wfs.v110.FeatureCollection) o;
        }
        return marshalObject(castorObject, encoding);
    }

   public Object mergeFeatureCollection() {
        if (version.equals(OGCConstants.WFS_VERSION_110)) {
            nl.b3p.xml.wfs.v110.FeatureCollection featureCollection = null;

            Iterator it = featureCollectionV110.iterator();
            int i = 0;
            int featureCount = 0;
            while (it.hasNext()) {
                nl.b3p.xml.wfs.v110.FeatureCollection newFeatureCollection = (nl.b3p.xml.wfs.v110.FeatureCollection) it.next();
                if (i == 0) {
                    featureCollection = newFeatureCollection;
                    featureCount = newFeatureCollection.getFeatureMemberCount();
                    i++;
                } else {
                    featureCount += newFeatureCollection.getFeatureMemberCount();
                    Object[] o = newFeatureCollection.getFeatureMember();
                    for (int x = 0; x < o.length; x++) {
                        Object featureMember = o[x];
                        featureCollection.addFeatureMember(featureMember);
                    }
                    i++;
                }
                setUsableResponse(true);
            }
            if (featureCollection!=null) {
                featureCollection.setNumberOfFeatures(featureCount);
            }
            return featureCollection;
        } else {
            nl.b3p.xml.wfs.v100.FeatureCollection featureCollection = null;

            Iterator it = featureCollectionV100.iterator();
            int i = 0;
            int featureCount = 0;
            while (it.hasNext()) {
                nl.b3p.xml.wfs.v100.FeatureCollection newFeatureCollection = (nl.b3p.xml.wfs.v100.FeatureCollection) it.next();
                if (i == 0) {
                     featureCollection = newFeatureCollection;
                     featureCount = newFeatureCollection.getFeatureMemberCount();
                   i++;
                } else {
                    featureCount += newFeatureCollection.getFeatureMemberCount();
                    Object[] o = newFeatureCollection.getFeatureMember();
                    for (int x = 0; x < o.length; x++) {
                        Object featureMember = o[x];
                        featureCollection.addFeatureMember(featureMember);
                    }
                    i++;
                }
                setUsableResponse(true);
            }
            //featureCollection.setNumberOfFeatures(featureCount); not supported by wfs 1.0.0
            return featureCollection;
        }
    }

}
