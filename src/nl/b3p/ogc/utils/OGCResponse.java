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

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.Properties;
import javax.xml.namespace.NamespaceContext;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import nl.b3p.xml.ows.v100.DCP;
import nl.b3p.xml.ows.v100.HTTP;
import nl.b3p.xml.ows.v100.Operation;
import nl.b3p.xml.wfs.Filter_Capabilities;
import nl.b3p.xml.wfs.v100.capabilities.DCPType;
import nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType;
import nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType;
import nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType;
import nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType;
import nl.b3p.xml.wfs.v100.capabilities.FeatureType;
import nl.b3p.xml.wfs.v100.capabilities.HTTPTypeItem;
import nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem;
import org.apache.xerces.dom.DeferredElementNSImpl;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Jytte
 */
public class OGCResponse {

    private String httpHost;
    private String response;
    private String version;
    private List versions = new ArrayList();
    private nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities newWfsCapabilitiesV100;
    private nl.b3p.xml.wfs.v110.WFS_Capabilities newWfsCapabilitiesV110;
    private nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport newExceptionReport;
    private nl.b3p.xml.wfs.v100.transaction.TransactionResult newTransactionResponseV100;
    private nl.b3p.xml.wfs.v110.TransactionResponse newTransactionResponseV110;
    private List getCapabilitiesV100 = new ArrayList();
    private List getCapabilitiesV110 = new ArrayList();
    private List featureCollectionV100 = new ArrayList();
    private List featureCollectionV110 = new ArrayList();
    private HashMap nameSpaces = null;
    private HashMap schemaLocations;
    private String srs = null;
    private List supportedOperations = new ArrayList();
//    private Node currentNode = null;

    /** Creates a new instance of OGCResponse */
    public OGCResponse() {
    }

//    public OGCResponse(Node current) {
//        this.currentNode = current;
//        findNameSpace(currentNode);
//    }

    public NodeList getNodeListFromXPath(Node currentNode, String xPathFrag) throws Exception {
        if (xPathFrag == null || xPathFrag.length() == 0) {
            return null;
        }
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        xpath.setNamespaceContext(getNamespaceContext());

        XPathExpression expr = xpath.compile(xPathFrag);
        Object result = expr.evaluate(currentNode, XPathConstants.NODESET);
        return (NodeList) result;
    }

    private void replaceFeatureTypeName(Element elem, String spAbbr) throws Exception {
        // update layer names in response
        String wfsPrefix = getNameSpacePrefix("http://www.opengis.net/wfs");
        String gmlPrefix = getNameSpacePrefix("http://www.opengis.net/gml");
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
        return;
    }

    public void rebuildResponse(Element rootElement, OGCRequest request, String prefix) throws Exception {
        this.httpHost = request.getUrlWithNonOGCparams();
        if (nameSpaces == null) {
            nameSpaces = new HashMap();

        }
        findNameSpace(rootElement);
        Unmarshaller um;
        Object o;

        String tagName = OGCRequest.removeNamespace(rootElement.getTagName());

        if (tagName.equalsIgnoreCase(OGCConstants.WFS_CAPABILITIES)) {
            response = OGCConstants.WFS_CAPABILITIES;
            version = rootElement.getAttribute(OGCConstants.VERSION.toLowerCase());
            isSupportedVersion(version);

            if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)) {
                um = new Unmarshaller(nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities.class);
                o = um.unmarshal(rootElement);
                nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities wfsCapabilities = (nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities) o;

                getCapabilitiesV100.add(replaceCapabilitiesV100Url(wfsCapabilities, prefix));
            } else {
                um = new Unmarshaller(nl.b3p.xml.wfs.v110.WFS_Capabilities.class);
                o = um.unmarshal(rootElement);
                nl.b3p.xml.wfs.v110.WFS_Capabilities wfsCapabilities = (nl.b3p.xml.wfs.v110.WFS_Capabilities) o;

                getCapabilitiesV110.add(replaceCapabilitiesV110Url(wfsCapabilities, prefix));
            }
            checkSupportedOperations(OGCConstants.SUPPORTED_WFS_REQUESTS);
        } else if (tagName.equalsIgnoreCase(OGCConstants.WFS_FEATURECOLLECTION)) {
            response = OGCConstants.WFS_FEATURECOLLECTION;
            version = request.getFinalVersion();

            if (version != null && version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)) {
                // replace in dom tree, AnyNode is not mutable
                replaceFeatureTypeName(rootElement, prefix);

                um = new Unmarshaller(nl.b3p.xml.wfs.v100.FeatureCollection.class);
                o = um.unmarshal(rootElement);
                nl.b3p.xml.wfs.v100.FeatureCollection featureCollection = (nl.b3p.xml.wfs.v100.FeatureCollection) o;

                featureCollectionV100.add(replaceFeatureCollectionV100Url(featureCollection, prefix));
            } else {
                // replace in dom tree, AnyNode is not mutable
                replaceFeatureTypeName(rootElement, prefix);

                um = new Unmarshaller(nl.b3p.xml.wfs.v110.FeatureCollection.class);
                o = um.unmarshal(rootElement);
                nl.b3p.xml.wfs.v110.FeatureCollection featureCollection = (nl.b3p.xml.wfs.v110.FeatureCollection) o;

                featureCollectionV110.add(replaceFeatureCollectionV110Url(featureCollection, prefix));
            }
        } else if (tagName.equalsIgnoreCase(OGCConstants.WFS_SERVER_EXCEPTION)) {
            response = OGCConstants.WFS_SERVER_EXCEPTION;
            version = request.getFinalVersion();

            um = new Unmarshaller(nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport.class);
            o = um.unmarshal(rootElement);
            nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport exceptionReport = (nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport) o;

            newExceptionReport = exceptionReport;
        } else if (tagName.equalsIgnoreCase(OGCConstants.WFS_TRANSACTIONRESPONSE)) {
            response = OGCConstants.WFS_TRANSACTIONRESPONSE;
            version = request.getFinalVersion();

            if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)) {
                um = new Unmarshaller(nl.b3p.xml.wfs.v100.transaction.TransactionResult.class);
                o = um.unmarshal(rootElement);
                nl.b3p.xml.wfs.v100.transaction.TransactionResult transactionResponse = (nl.b3p.xml.wfs.v100.transaction.TransactionResult) o;

                newTransactionResponseV100 = replaceTransactionResponseV100Url(transactionResponse, prefix);
            } else {
                um = new Unmarshaller(nl.b3p.xml.wfs.v110.TransactionResponse.class);
                o = um.unmarshal(rootElement);
                nl.b3p.xml.wfs.v110.TransactionResponse transactionResponse = (nl.b3p.xml.wfs.v110.TransactionResponse) o;

                newTransactionResponseV110 = replaceTransactionResponseV110Url(transactionResponse, prefix);
            }
        }
    }

    public nl.b3p.xml.wfs.v100.transaction.TransactionResult replaceTransactionResponseV100Url(nl.b3p.xml.wfs.v100.transaction.TransactionResult transactionResponse, String prefix) {
        /* Niet helemaal duidelijk of er aan de respons xml nog wat moet gebeuren */
        return transactionResponse;
    }

    public nl.b3p.xml.wfs.v110.TransactionResponse replaceTransactionResponseV110Url(nl.b3p.xml.wfs.v110.TransactionResponse transactionResponse, String prefix) {
        /* Niet helemaal duidelijk of er aan de respons xml nog wat moet gebeuren */
        return transactionResponse;
    }

    public nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities replaceCapabilitiesV100Url(nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities wfsCapabilities, String prefix) {
        wfsCapabilities.getService().setOnlineResource(httpHost);
        nl.b3p.xml.wfs.v100.capabilities.FeatureType[] featureTypeList = wfsCapabilities.getFeatureTypeList().getFeatureType();
        for (int b = 0; b < featureTypeList.length; b++) {
            String layer = featureTypeList[b].getName();
            String featureTypeName = this.determineFeatureTypeName(prefix, layer);
            featureTypeList[b].setName(featureTypeName);
        }
        List newSupportedOperations = new ArrayList();
        int requestCount = wfsCapabilities.getCapability().getRequest().getRequestTypeItemCount();
        for (int i = 0; i < requestCount; i++) {
            RequestTypeItem requestItem = wfsCapabilities.getCapability().getRequest().getRequestTypeItem(i);
            if (requestItem.getDescribeFeatureType() != null) {
                newSupportedOperations.add(OGCConstants.WFS_REQUEST_DescribeFeatureType);
                int dcpCount = requestItem.getDescribeFeatureType().getDCPType_DescribeFeatureTypeTypeCount();
                for (int x = 0; x < dcpCount; x++) {
                    DCPType_DescribeFeatureTypeType dcp = requestItem.getDescribeFeatureType().getDCPType_DescribeFeatureTypeType(x);
                    int httpItemCount = dcp.getHTTP().getHTTPTypeItemCount();
                    for (int y = 0; y < httpItemCount; y++) {
                        replaceUrl(dcp.getHTTP().getHTTPTypeItem(y));
                    }
                }
            } else if (requestItem.getGetCapabilities() != null) {
                newSupportedOperations.add(OGCConstants.WFS_REQUEST_GetCapabilities);
                int dcpCount = requestItem.getGetCapabilities().getDCPType_GetCapabilitiesTypeCount();
                for (int x = 0; x < dcpCount; x++) {
                    DCPType_GetCapabilitiesType dcp = requestItem.getGetCapabilities().getDCPType_GetCapabilitiesType(x);
                    int httpItemCount = dcp.getHTTP().getHTTPTypeItemCount();
                    for (int y = 0; y < httpItemCount; y++) {
                        replaceUrl(dcp.getHTTP().getHTTPTypeItem(y));
                    }
                }
            } else if (requestItem.getGetFeature() != null) {
                newSupportedOperations.add(OGCConstants.WFS_REQUEST_GetFeature);
                int dcpCount = requestItem.getGetFeature().getDCPType_FeatureTypeTypeCount();
                for (int x = 0; x < dcpCount; x++) {
                    DCPType_FeatureTypeType dcp = requestItem.getGetFeature().getDCPType_FeatureTypeType(x);
                    int httpItemCount = dcp.getHTTP().getHTTPTypeItemCount();
                    for (int y = 0; y < httpItemCount; y++) {
                        replaceUrl(dcp.getHTTP().getHTTPTypeItem(y));
                    }
                }
            } else if (requestItem.getGetFeatureWithLock() != null) {
                newSupportedOperations.add(OGCConstants.WFS_REQUEST_GetFeatureWithLock);
                int dcpCount = requestItem.getGetFeatureWithLock().getDCPType_FeatureTypeTypeCount();
                for (int x = 0; x < dcpCount; x++) {
                    DCPType_FeatureTypeType dcp = requestItem.getGetFeatureWithLock().getDCPType_FeatureTypeType(x);
                    int httpItemCount = dcp.getHTTP().getHTTPTypeItemCount();
                    for (int y = 0; y < httpItemCount; y++) {
                        replaceUrl(dcp.getHTTP().getHTTPTypeItem(y));
                    }
                }
            } else if (requestItem.getLockFeature() != null) {
                newSupportedOperations.add(OGCConstants.WFS_REQUEST_LockFeature);
                int dcpCount = requestItem.getLockFeature().getDCPTypeCount();
                for (int x = 0; x < dcpCount; x++) {
                    DCPType dcp = requestItem.getLockFeature().getDCPType(x);
                    int httpItemCount = dcp.getHTTP().getHTTPTypeItemCount();
                    for (int y = 0; y < httpItemCount; y++) {
                        replaceUrl(dcp.getHTTP().getHTTPTypeItem(y));
                    }
                }
            } else if (requestItem.getTransaction() != null) {
                newSupportedOperations.add(OGCConstants.WFS_REQUEST_Transaction);
                int dcpCount = requestItem.getTransaction().getDCPType_TransactionTypeCount();
                for (int x = 0; x < dcpCount; x++) {
                    DCPType_TransactionType dcp = requestItem.getTransaction().getDCPType_TransactionType(x);
                    int httpItemCount = dcp.getHTTP().getHTTPTypeItemCount();
                    for (int y = 0; y < httpItemCount; y++) {
                        replaceUrl(dcp.getHTTP().getHTTPTypeItem(y));
                    }
                }
            }
        }
        checkSupportedOperations(newSupportedOperations);
        setSrs(null);
        return wfsCapabilities;
    }

    public void replaceUrl(HTTPTypeItem httpItem) {
        if (httpItem.getGet() != null) {
            httpItem.getGet().setOnlineResource(httpHost);
        } else if (httpItem.getPost() != null) {
            httpItem.getPost().setOnlineResource(httpHost);
        }
    }

    public nl.b3p.xml.wfs.v110.WFS_Capabilities replaceCapabilitiesV110Url(nl.b3p.xml.wfs.v110.WFS_Capabilities wfsCapabilities, String prefix) {
        nl.b3p.xml.wfs.v110.FeatureType[] featureTypeList = wfsCapabilities.getFeatureTypeList().getFeatureType();
        for (int b = 0; b < featureTypeList.length; b++) {
            String layer = featureTypeList[b].getName();
            String featureTypeName = this.determineFeatureTypeName(prefix, layer);
            featureTypeList[b].setName(featureTypeName);
        }
        List newSupportedOperations = new ArrayList();
        int operationCount = wfsCapabilities.getOperationsMetadata().getOperationCount();
        for (int i = 0; i < operationCount; i++) {
            Operation operation = wfsCapabilities.getOperationsMetadata().getOperation(i);
            if (!newSupportedOperations.contains(operation.getName())) {
                newSupportedOperations.add(operation.getName());
            }
            int dcpCount = operation.getDCPCount();
            for (int n = 0; n < dcpCount; n++) {
                DCP dcp = operation.getDCP(n);
                HTTP http = dcp.getHTTP();
                int httpCount = http.getHTTPItemCount();
                for (int x = 0; x < httpCount; x++) {
                    if (http.getHTTPItem(x).getGet() != null) {
                        http.getHTTPItem(x).getGet().setHref(httpHost);
                    } else if (http.getHTTPItem(x).getPost() != null) {
                        http.getHTTPItem(x).getPost().setHref(httpHost);
                    }
                }
            }
        }
        checkSupportedOperations(newSupportedOperations);
        //Check for null. Only check the values that can be null according the specs.
        if (wfsCapabilities.getServiceProvider() != null
                && wfsCapabilities.getServiceProvider().getServiceContact().getContactInfo() != null
                && wfsCapabilities.getServiceProvider().getServiceContact().getContactInfo().getOnlineResource() != null) {
            wfsCapabilities.getServiceProvider().getServiceContact().getContactInfo().getOnlineResource().setHref(httpHost);
        }
        setSrs(null);
        return wfsCapabilities;
    }

    /**
     * This method determines the featureTypeName based on the given layer and prefix.
     * Since the layer contains a {namespaceUrl} in the layer, it first needs to
     * determine the namespace prefix. This value is saved in the featureTypeNamespacePrefix
     * instance variable, for later use. 
     * 
     * @param prefix
     * @param layer
     * @return
     */
    private String determineFeatureTypeName(String prefix, String layer) {
        String featureTypeNamespacePrefix = "";

        int index = layer.indexOf("}");
        if (index > -1) {
            String namespace = layer.substring(1, index);
            featureTypeNamespacePrefix = getNameSpacePrefix(namespace);
            if (!"".equals(featureTypeNamespacePrefix)) {
                featureTypeNamespacePrefix += ":";
            }
            layer = layer.substring(index + 1);//rename layer by removing namepace url
        }

        return featureTypeNamespacePrefix + prefix + "_" + layer;
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
        // kan er nu even niet achter komen hoe ik de srs uit het object kan halen.
        setSrs(null);
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
        // kan er nu even niet achter komen hoe ik de srs uit het object kan halen.
        setSrs(null);
        return featureCollection;
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
                        String[] layer = newKvp[1].split(":");
                        String changedlayer = null;
                        if (layer.length > 1) {
                            changedlayer = layer[0] + ":" + serverPrefix + "_" + layer[1];
                        } else {
                            changedlayer = serverPrefix + "_" + layer[0];
                        }
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

    public String getResponseBody(List layers) {
        String body = null;
        Object castorObject = null;

        if (response == null || response.length() <= 0) {
            return body;
        }
        if (response.equals(OGCConstants.WFS_CAPABILITIES)) {
            List tlayers = new ArrayList();
            Iterator iter = layers.iterator();
            while (iter.hasNext()) {
                HashMap sp = (HashMap) iter.next();
                String layerName = determineFeatureTypeName((String) sp.get("spAbbr"), (String) sp.get("layer"));
                tlayers.add(layerName);
            }
            castorObject = mergeCapabilities(tlayers);
        } else if (response.equals(OGCConstants.WFS_SERVER_EXCEPTION)) {
            castorObject = newExceptionReport;
        } else if (response.equals(OGCConstants.WFS_FEATURECOLLECTION)) {
            Object o = mergeFeatureCollection();
            if (version.equals(OGCConstants.WFS_VERSION_100)) {
                castorObject = (nl.b3p.xml.wfs.v100.FeatureCollection) o;
            } else {
                castorObject = (nl.b3p.xml.wfs.v110.FeatureCollection) o;
            }
        } else if (response.equals(OGCConstants.WFS_TRANSACTIONRESPONSE)) {
            if (version.equals(OGCConstants.WFS_VERSION_100)) {
                castorObject = newTransactionResponseV100;
            } else {
                castorObject = newTransactionResponseV110;
            }
        }

        try {
            StringWriter sw = new StringWriter();
            Marshaller m = new Marshaller(sw);

            if (nameSpaces != null) {
                Set keys = nameSpaces.keySet();
                Iterator it = keys.iterator();
                for (int i = 0; it.hasNext(); i++) {
                    String prefix = (String) it.next();
                    String location = (String) nameSpaces.get(prefix);
                    m.setNamespaceMapping(prefix, location);
                }
            }
            if (getSchemaLocations() != null) {
                Set keys = getSchemaLocations().keySet();
                Iterator it = keys.iterator();
                for (int i = 0; it.hasNext(); i++) {
                    String prefix = (String) it.next();
                    String location = (String) getSchemaLocations().get(prefix);
                    m.setSchemaLocation(location);
                }
            }

            if (castorObject != null) {
                m.marshal(castorObject);
                body = sw.toString();
            }
        } catch (Exception e) {
            throw new UnsupportedOperationException("Failed to get body of XML! Exception: " + e);
        }

        return body;
    }

    public String serializeNode(Node doc) throws TransformerConfigurationException, TransformerException {
        StringWriter outText = new StringWriter();
        StreamResult sr = new StreamResult(outText);
        Properties oprops = new Properties();
        oprops.put(OutputKeys.METHOD, "xml");
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.setOutputProperties(oprops);
        t.transform(new DOMSource(doc), sr);
        return outText.toString();
    }

    public NamespaceContext getNamespaceContext() {

        return new NamespaceContext() {

            public String getNamespaceURI(String prefix) {
                return (String) nameSpaces.get(prefix);
            }

            // Dummy implementation - not used!
            public Iterator getPrefixes(String val) {
                return null;
            }

            // Dummy implemenation - not used!
            public String getPrefix(String uri) {
                return null;
            }
        };
    }

    public Map splitLayerInParts(String fullLayerName) {
        return splitLayerInParts(fullLayerName, true);
    }

    public Map splitLayerInParts(String fullLayerName, boolean splitName) {
        String tPrefix = null;
        String tLayerName = null;
        String tSpAbbr = null;
        String tSpLayerName = null;
        String tNsUrl = null;
        String[] temp = fullLayerName.split("}");
        if (temp.length > 1) {
            tSpLayerName = temp[1];
            int index1 = fullLayerName.indexOf("{");
            int index2 = fullLayerName.indexOf("}");
            tNsUrl = fullLayerName.substring(index1 + 1, index2);
            tPrefix = getNameSpacePrefix(tNsUrl);
        } else {
            String temp2[] = temp[0].split(":");
            if (temp2.length > 1) {
                tSpLayerName = temp2[1];
                tPrefix = temp2[0];
                tNsUrl = getNameSpace(tPrefix);
            } else {
                tSpLayerName = fullLayerName;
           }
        }
        // assume same for now
        tLayerName = tSpLayerName;
        if (splitName) {
            int index1 = tSpLayerName.indexOf("_");
            if (index1 != -1) {
                tSpAbbr = tSpLayerName.substring(0, index1);
                tLayerName = tSpLayerName.substring(index1 + 1);
            }
        }
        Map returnMap = new HashMap();
        returnMap.put("prefix",tPrefix);
        returnMap.put("spAbbr",tSpAbbr);
        returnMap.put("layerName",tLayerName);
        returnMap.put("spLayerName",tSpLayerName);
        returnMap.put("nsUrl",tNsUrl);
        return returnMap;
    }


    public String getNameSpace(String prefix) {
        return (String) nameSpaces.get(prefix);
    }

    public String getNameSpacePrefix(String namespace) {
        if (nameSpaces.size() == 0) {
            return "";
        }
        // iterate through namespaces to find prefix
        String prefix = "";
        for (Iterator iterator = nameSpaces.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry entry = (Map.Entry) iterator.next();
            if (entry.getValue().equals(namespace)) {
                prefix = (String) entry.getKey();
                // if default namespace and one explicit namespace refer to same url
                // xpath search needs explicit namespace
                if (prefix!=null && prefix.length()>0) {
                    return prefix;
                }
            }
        }
        return prefix;
    }

    public void findNameSpace(Node node) {
        NamedNodeMap map = node.getAttributes();
        if (map != null) {
            for (int i = 0; map.getLength() > i; i++) {
                String name = map.item(i).getNodeName();
                String[] tokens = name.split(":", 2);
                if (tokens[0].equalsIgnoreCase("xmlns")) {
                    String value = map.item(i).getNodeValue();
                    addOrReplaceNameSpace(tokens.length == 1 ? "" : tokens[1], value);
                } else if (tokens.length == 2) {
                    if (tokens[1].equalsIgnoreCase("SchemaLocation")) {
                        String value = map.item(i).getNodeValue();
                        addOrReplaceSchemaLocation(tokens[1], value);
                    }
                }
            }
        }
        if (node.hasChildNodes()) {
            NodeList lijst = node.getChildNodes();
            for (int i = 0; i < lijst.getLength(); i++) {
                findNameSpace(lijst.item(i));
            }
        }
    }

    public void addOrReplaceNameSpace(String prefix, String nsUrl) {
        if (prefix != null && nsUrl != null) {
            if (nameSpaces == null) {
                nameSpaces = new HashMap();
            }
            nameSpaces.put(prefix, nsUrl);
        }
    }

    public void addOrReplaceSchemaLocation(String prefix, String location) {
        if (prefix != null && location != null) {
            if (getSchemaLocations() == null) {
                setSchemaLocations(new HashMap());
            }
            getSchemaLocations().put(prefix, location);
        }
    }

    public void setSrs(String srs) {
        this.srs = srs;
    }

    public String getSrs() {
        return srs;
    }

    public void clearGetCapabilitiesV110() {
        getCapabilitiesV110.clear();
    }

    public void clearGetCapabilitiesV100() {
        getCapabilitiesV100.clear();
    }

    public void clearVersions() {
        versions.clear();
    }

    public boolean isSupportedVersion(String version) {
        if (OGCConstants.SUPPORTED_WFS_VERSIONS.contains(version)) {
            if (!versions.contains(version) && version != null) {
                versions.add(version);
            }
            return true;
        } else {
            throw new UnsupportedOperationException("WFS Version the serviceProvider returned is not supported by Kaartenbalie!");
        }
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
                    featureCount = newFeatureCollection.getNumberOfFeatures();
                    i++;
                } else {
                    featureCount += newFeatureCollection.getNumberOfFeatures();
                    Object[] o = newFeatureCollection.getFeatureMember();
                    for (int x = 0; x < o.length; x++) {
                        Object featureMember = o[x];
                        featureCollection.addFeatureMember(featureMember);
                    }
                    i++;
                }
            }
            featureCollection.setNumberOfFeatures(featureCount);
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
            }
            //featureCollection.setNumberOfFeatures(featureCount); not supported by wfs 1.0.0
            return featureCollection;
        }
    }

    public Object mergeCapabilities(List layers) {
        Object capabilities = new Object();
        if (versions.size() > 1) {
            //meerdere versies
            throw new UnsupportedOperationException("Capabilities with more versions are not yet supported!");
        } else if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)) {
            capabilities = getFeatureTypesV100(layers);
        } else if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_110)) {
            capabilities = getFeatureTypesV110(layers);
        }
        return capabilities;
    }

    public nl.b3p.xml.wfs.v110.WFS_Capabilities getFeatureTypesV110(List layers) {
        List foundFeatureTypes = new ArrayList();

        Iterator it = getCapabilitiesV110.iterator();
        while (it.hasNext()) {
            nl.b3p.xml.wfs.v110.WFS_Capabilities nextWfsCapabilitiesV110 = (nl.b3p.xml.wfs.v110.WFS_Capabilities) it.next();
            nl.b3p.xml.wfs.v110.FeatureTypeList nextTypeList = nextWfsCapabilitiesV110.getFeatureTypeList();
            for (int x = 0; x < nextTypeList.getFeatureTypeCount(); x++) {
                nl.b3p.xml.wfs.v110.FeatureType feature = nextTypeList.getFeatureType(x);
                // TODO hack, nog beter uitzoeken
                String name = feature.getName();
                int i = 0;
                i = Math.max(i, name.lastIndexOf(":") + 1);
                i = Math.max(i, name.lastIndexOf("}") + 1);
                String featureName = name.substring(i);

                Iterator il = layers.iterator();
                while (il.hasNext()) {
                    String lName = (String) il.next();
                    if (lName.equalsIgnoreCase(featureName)) {
                        foundFeatureTypes.add(feature);
                    }
                }
            }
            if (newWfsCapabilitiesV110 == null) {
                newWfsCapabilitiesV110 = nextWfsCapabilitiesV110;
            } else {
                checkFilterCapabilities(newWfsCapabilitiesV110.getFilter_Capabilities(), nextWfsCapabilitiesV110.getFilter_Capabilities());
            }
        }

        if (newWfsCapabilitiesV110 == null) {
            return null;
        }

        // toevoegen van de featureTypes met rechten
        Iterator it2 = foundFeatureTypes.iterator();
        nl.b3p.xml.wfs.v110.FeatureTypeList foundTypeList = new nl.b3p.xml.wfs.v110.FeatureTypeList();
        while (it2.hasNext()) {
            foundTypeList.addFeatureType((nl.b3p.xml.wfs.v110.FeatureType) it2.next());
        }
        newWfsCapabilitiesV110.setFeatureTypeList(foundTypeList);

        Operation[] operations = newWfsCapabilitiesV110.getOperationsMetadata().getOperation();
        String[] names = new String[operations.length];
        for (int x = 0; x < operations.length; x++) {
            names[x] = operations[x].getName();
        }
        for (int y = 0; y < names.length; y++) {
            if (!supportedOperations.contains(names[y])) {
                Operation remove = operations[y];
                newWfsCapabilitiesV110.getOperationsMetadata().removeOperation(remove);
            }
        }

        clearGetCapabilitiesV110();
        this.clearVersions();
        return newWfsCapabilitiesV110;
    }

    public nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities getFeatureTypesV100(List layers) {
        List foundFeatureTypes = new ArrayList();

        Iterator it = getCapabilitiesV100.iterator();
        while (it.hasNext()) {
            nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities nextWfsCapabilitiesV100 = (nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities) it.next();
            nl.b3p.xml.wfs.v100.capabilities.FeatureType[] featureTypes = nextWfsCapabilitiesV100.getFeatureTypeList().getFeatureType();
            for (int x = 0; x < featureTypes.length; x++) {
                FeatureType feature = featureTypes[x];
                // TODO hack, nog beter uitzoeken
                String name = feature.getName();
                int i = 0;
                i = Math.max(i, name.lastIndexOf(":") + 1);
                i = Math.max(i, name.lastIndexOf("}") + 1);
                String featureName = name.substring(i);

                Iterator il = layers.iterator();
                while (il.hasNext()) {
                    String lName = (String) il.next();
                    if (lName.equalsIgnoreCase(featureName)) {
                        foundFeatureTypes.add(feature);
                    }
                }
            }
            if (newWfsCapabilitiesV100 == null) {
                newWfsCapabilitiesV100 = nextWfsCapabilitiesV100;
            } else {
                checkFilterCapabilities(newWfsCapabilitiesV100.getFilter_Capabilities(), nextWfsCapabilitiesV100.getFilter_Capabilities());
            }
        }

        if (newWfsCapabilitiesV100 == null) {
            return null;
        }

        // toevoegen van de featureTypes met rechten
        Iterator it2 = foundFeatureTypes.iterator();
        nl.b3p.xml.wfs.v100.capabilities.FeatureTypeList foundTypeList = new nl.b3p.xml.wfs.v100.capabilities.FeatureTypeList();
        while (it2.hasNext()) {
            foundTypeList.addFeatureType((nl.b3p.xml.wfs.v100.capabilities.FeatureType) it2.next());
        }
        newWfsCapabilitiesV100.setFeatureTypeList(foundTypeList);

        RequestTypeItem[] operations = newWfsCapabilitiesV100.getCapability().getRequest().getRequestTypeItem();
        String[] names = new String[operations.length];
        for (int x = 0; x < operations.length; x++) {
            if (operations[x].getDescribeFeatureType() != null) {
                names[x] = OGCConstants.WFS_REQUEST_DescribeFeatureType;
            } else if (operations[x].getGetCapabilities() != null) {
                names[x] = OGCConstants.WFS_REQUEST_GetCapabilities;
            } else if (operations[x].getGetFeature() != null) {
                names[x] = OGCConstants.WFS_REQUEST_GetFeature;
            } else if (operations[x].getGetFeatureWithLock() != null) {
                names[x] = OGCConstants.WFS_REQUEST_GetFeatureWithLock;
            } else if (operations[x].getLockFeature() != null) {
                names[x] = OGCConstants.WFS_REQUEST_LockFeature;
            } else if (operations[x].getTransaction() != null) {
                names[x] = OGCConstants.WFS_REQUEST_Transaction;
            }
        }
        for (int y = 0; y < names.length; y++) {
            if (!supportedOperations.contains(names[y])) {
                RequestTypeItem requestItem = newWfsCapabilitiesV100.getCapability().getRequest().getRequestTypeItem(y);
                newWfsCapabilitiesV100.getCapability().getRequest().removeRequestTypeItem(requestItem);
            }
        }

        clearGetCapabilitiesV100();
        this.clearVersions();
        return newWfsCapabilitiesV100;
    }

    //TODO concurrent modification error check uitvoeren
    public void checkFilterCapabilities(Filter_Capabilities filterCapabilities, Filter_Capabilities newFilterCapabilities) {
        if (filterCapabilities instanceof nl.b3p.xml.ogc.v110.Filter_Capabilities) {
            nl.b3p.xml.ogc.v110.Filter_Capabilities filter = (nl.b3p.xml.ogc.v110.Filter_Capabilities) filterCapabilities;
            nl.b3p.xml.ogc.v110.Filter_Capabilities newFilter = (nl.b3p.xml.ogc.v110.Filter_Capabilities) newFilterCapabilities;

            nl.b3p.xml.ogc.v110.types.GeometryOperandType[] geometryOperand = filter.getSpatial_Capabilities().getGeometryOperands_Spatial_CapabilitiesType().getGeometryOperand();
            nl.b3p.xml.ogc.v110.types.GeometryOperandType[] newGeometryOperand = newFilter.getSpatial_Capabilities().getGeometryOperands_Spatial_CapabilitiesType().getGeometryOperand();
            for (int i = 0; i < geometryOperand.length; i++) {
                boolean isValid = false;
                String value = geometryOperand[i].toString();
                for (int j = 0; j < newGeometryOperand.length; j++) {
                    String newValue = newGeometryOperand[j].toString();
                    if (value.equals(newValue)) {
                        isValid = true;
                    }
                }
                if (isValid == false) {
//                    filter.getSpatial_Capabilities().getGeometryOperands_Spatial_CapabilitiesType().removeGeometryOperand(geometryOperand[i]);
                }
            }

            nl.b3p.xml.ogc.v110.SpatialOperator[] spatialOperator = filter.getSpatial_Capabilities().getSpatialOperators().getSpatialOperator();
            nl.b3p.xml.ogc.v110.SpatialOperator[] newSpatialOperator = newFilter.getSpatial_Capabilities().getSpatialOperators().getSpatialOperator();
            for (int x = 0; x < spatialOperator.length; x++) {
                boolean isValid = false;
                String value = spatialOperator[x].getName().toString();
                for (int y = 0; y < newSpatialOperator.length; y++) {
                    String newValue = newSpatialOperator[y].getName().toString();
                    if (value.equals(newValue)) {
                        isValid = true;
                    }
                }
                if (isValid == false) {
//                    filter.getSpatial_Capabilities().getSpatialOperators().removeSpatialOperator(spatialOperator[x]);
                }
            }

            nl.b3p.xml.ogc.v110.LogicalOperators logicalOperators = filter.getScalar_Capabilities().getLogicalOperators();
            nl.b3p.xml.ogc.v110.LogicalOperators newLogicalOperators = newFilter.getScalar_Capabilities().getLogicalOperators();
            if (!logicalOperators.toString().equals(newLogicalOperators.toString())) {
                if (logicalOperators != null && newLogicalOperators == null) {
                    filter.getScalar_Capabilities().setLogicalOperators(null);
                }
            }

            nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem[] comparisonOperators = null;
            if (filter.getScalar_Capabilities().getComparisonOperators() != null) {
                comparisonOperators = filter.getScalar_Capabilities().getComparisonOperators().getComparisonOperatorsTypeItem();
            }
            nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem[] newComparisonOperators = null;
            if (newFilter.getScalar_Capabilities().getComparisonOperators() != null) {
                newComparisonOperators = newFilter.getScalar_Capabilities().getComparisonOperators().getComparisonOperatorsTypeItem();
            }
            if (comparisonOperators != null) {
                for (int o = 0; o < comparisonOperators.length; o++) {
                    boolean isValid = false;
                    Class valueClass = comparisonOperators[o].getComparisonOperator().getClass();
                    if (newComparisonOperators != null) {
                        for (int p = 0; p < newComparisonOperators.length; p++) {
                            Class newValueClass = newComparisonOperators[p].getComparisonOperator().getClass();
                            if (valueClass.equals(newValueClass)) {
                                isValid = true;
                            }
                        }
                    }
                    if (isValid == false) {
                        filter.getScalar_Capabilities().getComparisonOperators().removeComparisonOperatorsTypeItem(comparisonOperators[o]);
                    }
                }
            }
            nl.b3p.xml.ogc.v110.ArithmeticOperatorsTypeItem[] arithmeticOperators = null;
            if (filter.getScalar_Capabilities().getArithmeticOperators() != null) {
                arithmeticOperators = filter.getScalar_Capabilities().getArithmeticOperators().getArithmeticOperatorsTypeItem();
            }
            nl.b3p.xml.ogc.v110.ArithmeticOperatorsTypeItem[] newArithmeticOperators = null;
            if (newFilter.getScalar_Capabilities().getArithmeticOperators() != null) {
                newFilter.getScalar_Capabilities().getArithmeticOperators().getArithmeticOperatorsTypeItem();
            }
            if (arithmeticOperators != null) {
                for (int f = 0; f < arithmeticOperators.length; f++) {
                    boolean isValid = false;
                    Class valueClass = arithmeticOperators[f].getSimpleArithmetic().getClass();
                    if (newArithmeticOperators != null) {
                        for (int h = 0; h < newArithmeticOperators.length; h++) {
                            Class newValueClass = newArithmeticOperators[h].getSimpleArithmetic().getClass();
                            if (valueClass.equals(newValueClass)) {
                                isValid = true;
                            }
                        }
                    }
                    if (isValid == false) {
                        filter.getScalar_Capabilities().getArithmeticOperators().removeArithmeticOperatorsTypeItem(arithmeticOperators[f]);
                    }
                }
            }

            nl.b3p.xml.ogc.v110.Id_CapabilitiesTypeItem[] idCapabilities = filter.getId_Capabilities().getId_CapabilitiesTypeItem();
            nl.b3p.xml.ogc.v110.Id_CapabilitiesTypeItem[] newIdCapabilities = newFilter.getId_Capabilities().getId_CapabilitiesTypeItem();
            for (int a = 0; a < idCapabilities.length; a++) {
                boolean isValid = false;
                Class valueClass = idCapabilities[a].getChoiceValue().getClass();
                for (int b = 0; b < newIdCapabilities.length; b++) {
                    Class newValueClass = newIdCapabilities[b].getChoiceValue().getClass();
                    if (valueClass.equals(newValueClass)) {
                        isValid = true;
                    }
                }
                if (isValid == false) {
                    filter.getId_Capabilities().removeId_CapabilitiesTypeItem(idCapabilities[a]);
                }
            }

        } else if (filterCapabilities instanceof nl.b3p.xml.ogc.v100.capabilities.Filter_Capabilities) {
            nl.b3p.xml.ogc.v100.capabilities.Filter_Capabilities filter = (nl.b3p.xml.ogc.v100.capabilities.Filter_Capabilities) filterCapabilities;
            nl.b3p.xml.ogc.v100.capabilities.Filter_Capabilities newFilter = (nl.b3p.xml.ogc.v100.capabilities.Filter_Capabilities) newFilterCapabilities;

            nl.b3p.xml.ogc.v100.capabilities.Spatial_OperatorsTypeItem[] spatialOperators = filter.getSpatial_Capabilities().getSpatial_Operators().getSpatial_OperatorsTypeItem();
            nl.b3p.xml.ogc.v100.capabilities.Spatial_OperatorsTypeItem[] newSpatialOperators = newFilter.getSpatial_Capabilities().getSpatial_Operators().getSpatial_OperatorsTypeItem();
            for (int i = 0; i < spatialOperators.length; i++) {
                boolean isValid = false;
                Class valueClass = spatialOperators[i].getChoiceValue().getClass();
                for (int j = 0; j < newSpatialOperators.length; j++) {
                    Class newValueClass = newSpatialOperators[j].getChoiceValue().getClass();
                    if (newValueClass.equals(valueClass)) {
                        isValid = true;
                    }
                }
                if (isValid == false) {
                    filter.getSpatial_Capabilities().getSpatial_Operators().removeSpatial_OperatorsTypeItem(spatialOperators[i]);
                }
            }
//            for (int i = 0; i < newSpatialOperators.length; i++) {
//                boolean isValid = false;
//                Class newValueClass = newSpatialOperators[i].getChoiceValue().getClass();
//                for (int j = 0; j < spatialOperators.length; j++) {
//                    Class valueClass = spatialOperators[j].getChoiceValue().getClass();
//                    if (newValueClass.equals(valueClass)) {
//                        isValid = true;
//                    }
//                }
//                if (isValid == false) {
//                    filter.getSpatial_Capabilities().getSpatial_Operators().addSpatial_OperatorsTypeItem(newSpatialOperators[i]);
//                }
//            }

            nl.b3p.xml.ogc.v100.capabilities.Scalar_CapabilitiesTypeItem[] scalarCapabilities = filter.getScalar_Capabilities().getScalar_CapabilitiesTypeItem();
            nl.b3p.xml.ogc.v100.capabilities.Scalar_CapabilitiesTypeItem[] newScalarCapabilities = newFilter.getScalar_Capabilities().getScalar_CapabilitiesTypeItem();
            for (int x = 0; x < scalarCapabilities.length; x++) {
                if (scalarCapabilities[x].getArithmetic_Operators() != null) {
                    nl.b3p.xml.ogc.v100.capabilities.Arithmetic_OperatorsTypeItem[] arithmeticOperators = scalarCapabilities[x].getArithmetic_Operators().getArithmetic_OperatorsTypeItem();
                    for (int y = 0; y < newScalarCapabilities.length; y++) {
                        if (newScalarCapabilities[y].getArithmetic_Operators() != null) {
                            nl.b3p.xml.ogc.v100.capabilities.Arithmetic_OperatorsTypeItem[] newArithmeticOperators = newScalarCapabilities[y].getArithmetic_Operators().getArithmetic_OperatorsTypeItem();

                            for (int k = 0; k < arithmeticOperators.length; k++) {
                                boolean isValid = false;
                                Class valueClass = arithmeticOperators[k].getChoiceValue().getClass();
                                for (int l = 0; l < newArithmeticOperators.length; l++) {
                                    Class newValueClass = newArithmeticOperators[l].getChoiceValue().getClass();
                                    if (valueClass.equals(newValueClass)) {
                                        isValid = true;
                                    }
                                }
                                if (isValid == false) {
                                    filter.getScalar_Capabilities().getScalar_CapabilitiesTypeItem(x).getArithmetic_Operators().removeArithmetic_OperatorsTypeItem(arithmeticOperators[k]);
                                }
                            }
                        }
                    }
                } else if (scalarCapabilities[x].getComparison_Operators() != null) {
                    nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem[] comparisonOperators = scalarCapabilities[x].getComparison_Operators().getComparison_OperatorsTypeItem();
                    for (int y = 0; y < newScalarCapabilities.length; y++) {
                        if (newScalarCapabilities[y].getComparison_Operators() != null) {
                            nl.b3p.xml.ogc.v100.capabilities.Comparison_OperatorsTypeItem[] newComparisonOperators = newScalarCapabilities[y].getComparison_Operators().getComparison_OperatorsTypeItem();

                            for (int k = 0; k < comparisonOperators.length; k++) {
                                boolean isValid = false;
                                Class valueClass = comparisonOperators[k].getChoiceValue().getClass();
                                for (int l = 0; l < newComparisonOperators.length; l++) {
                                    Class newValueClass = newComparisonOperators[l].getChoiceValue().getClass();
                                    if (valueClass.equals(newValueClass)) {
                                        isValid = true;
                                    }
                                }
                                if (isValid == false) {
                                    if (x < filter.getScalar_Capabilities().getScalar_CapabilitiesTypeItemCount()) {
                                        filter.getScalar_Capabilities().getScalar_CapabilitiesTypeItem(x).getComparison_Operators().removeComparison_OperatorsTypeItem(comparisonOperators[k]);
                                    }
                                }
                            }
                        }
                    }
                } else if (scalarCapabilities[x].getLogical_Operators() != null) {
                    boolean isValid = false;
                    Class valueClass = scalarCapabilities[x].getLogical_Operators().getClass();
                    for (int y = 0; y < newScalarCapabilities.length; y++) {
                        Class newValueClass = null;
                        if (newScalarCapabilities != null && newScalarCapabilities[y].getLogical_Operators() != null) {
                            newValueClass = newScalarCapabilities[y].getLogical_Operators().getClass();
                        }
                        if (valueClass.equals(newValueClass)) {
                            isValid = true;
                        }
                    }
                    if (isValid == false) {
                        filter.getScalar_Capabilities().removeScalar_CapabilitiesTypeItem(scalarCapabilities[x]);
                    }
                }
            }
        }
    }

    private void checkSupportedOperations(List newSupportedOperations) {
        if (supportedOperations.size() < 1) {
            supportedOperations = newSupportedOperations;
        } else {
            boolean equals = true;
            if (supportedOperations.size() == newSupportedOperations.size()) {
                Iterator it = newSupportedOperations.iterator();
                while (it.hasNext()) {
                    if (!supportedOperations.contains(it.next())) {
                        equals = false;
                    }
                }
            } else {
                equals = false;
            }
            if (equals == false) {
                List remove = new ArrayList();
                Iterator it = supportedOperations.iterator();
                while (it.hasNext()) {
                    Object o = it.next();
                    if (!newSupportedOperations.contains(o)) {
                        remove.add(o);
                    }
                }
                Iterator itremove = remove.iterator();
                while (itremove.hasNext()) {
                    supportedOperations.remove(itremove.next());
                }
            }
        }
    }

    /**
     * @return the schemaLocations
     */
    public HashMap getSchemaLocations() {
        return schemaLocations;
    }

    /**
     * @param schemaLocations the schemaLocations to set
     */
    public void setSchemaLocations(HashMap schemaLocations) {
        this.schemaLocations = schemaLocations;
    }

}
