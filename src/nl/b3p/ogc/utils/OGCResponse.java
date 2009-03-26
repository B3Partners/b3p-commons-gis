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
import java.util.Set;
import java.util.Iterator;
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
    private HashMap nameSpaces;
    private HashMap schemaLocations;
    private String srs = null;
    private List supportedOperations = new ArrayList();

    /** Creates a new instance of OGCResponse */
    public OGCResponse() {
    }

    public void rebuildResponse(Element rootElement, OGCRequest request, String prefix) {
        this.httpHost = request.getHost();
        nameSpaces = new HashMap();
        findNameSpace(rootElement);
        Unmarshaller um;
        Object o;

        // if no prefix is given (wfs is default namespave), prefix it with wfs:
        String tagName = rootElement.getTagName();
        if (!tagName.startsWith(OGCConstants.WFS_NAMESPACE_PREFIX)) {
        	tagName = OGCConstants.WFS_NAMESPACE_PREFIX + tagName;
        }
        
        try {
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
                checkSupportedOperations(OGCConstants.SUPPORT_WFS_REQUESTS);
            } else if (tagName.equalsIgnoreCase(OGCConstants.WFS_FEATURECOLLECTION)) {
                response = OGCConstants.WFS_FEATURECOLLECTION;
                version = request.getFinalVersion();

                if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)) {
                    um = new Unmarshaller(nl.b3p.xml.wfs.v100.FeatureCollection.class);
                    o = um.unmarshal(rootElement);
                    nl.b3p.xml.wfs.v100.FeatureCollection featureCollection = (nl.b3p.xml.wfs.v100.FeatureCollection) o;

                    featureCollectionV100.add(replaceFeatureCollectionV100Url(featureCollection, prefix));
                } else {
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
        } catch (Exception e) {
            throw new UnsupportedOperationException("Failed to rebuild response! Exception: " + e);
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
            featureTypeList[b].setName("app:" + prefix + featureTypeList[b].getName());
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
            String layer = featureTypeList[b].getName().split("}")[1];
            featureTypeList[b].setName("app:" + prefix + "_" + layer);
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
                        http.getHTTPItem(x).getGet().setHref(httpHost + "?");
                    } else if (http.getHTTPItem(x).getPost() != null) {
                        http.getHTTPItem(x).getPost().setHref(httpHost);
                    }
                }
            }
        }
        checkSupportedOperations(newSupportedOperations);
        wfsCapabilities.getServiceProvider().getServiceContact().getContactInfo().getOnlineResource().setHref(httpHost);
        setSrs(null);
        return wfsCapabilities;
    }

    public nl.b3p.xml.wfs.v100.FeatureCollection replaceFeatureCollectionV100Url(nl.b3p.xml.wfs.v100.FeatureCollection featureCollection, String serverPrefix) {
        String newSchemalocations = "";
        if (schemaLocations != null) {
            Set keys = schemaLocations.keySet();
            Iterator it = keys.iterator();
            for (int i = 0; it.hasNext(); i++) {
                String prefix = (String) it.next();
                String location = (String) schemaLocations.get(prefix);
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
        if (schemaLocations != null) {
            Set keys = schemaLocations.keySet();
            Iterator it = keys.iterator();
            for (int i = 0; it.hasNext(); i++) {
                String prefix = (String) it.next();
                String location = (String) schemaLocations.get(prefix);
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
                        String changedlayer = layer[0] + ":" + serverPrefix + "_" + layer[1];
                        newToken = newToken + "&" + newKvp[0] + "=" + changedlayer;
                        ;
                    } else {
                        newToken = newToken + "&" + kvpSplit[z];
                    }
                }
                if (x != 0) {
                    newSchemalocations = newSchemalocations + " " + httpHost + "?" + newToken;
                } else {
                    newSchemalocations = newSchemalocations + httpHost + "?" + newToken;
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

    public String getResponseBody(List spInfo) {
        String body = null;
        Object castorObject = null;
        List layers = new ArrayList();
        Iterator iter = spInfo.iterator();
        while (iter.hasNext()) {
            HashMap sp = (HashMap) iter.next();
            String layerName = "app:" + sp.get("spAbbr") + "_" + sp.get("layer");
            layers.add(layerName);
        }

        if (response == null || response.length() <= 0) {
            return body;
        }
        if (response.equals(OGCConstants.WFS_CAPABILITIES)) {
            castorObject = mergeCapabilities(layers);
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
            if (schemaLocations != null) {
                Set keys = schemaLocations.keySet();
                Iterator it = keys.iterator();
                for (int i = 0; it.hasNext(); i++) {
                    String prefix = (String) it.next();
                    String location = (String) schemaLocations.get(prefix);
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

    public void findNameSpace(Node node) {
        NamedNodeMap map = node.getAttributes();
        if (map != null) {
            for (int i = 0; map.getLength() > i; i++) {
                String name = map.item(i).getNodeName();
                String[] tokens = name.split(":",2);
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
            if (schemaLocations == null) {
                schemaLocations = new HashMap();
            }
            schemaLocations.put(prefix, location);
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
                    i++;
                } else {
                    Object[] o = newFeatureCollection.getFeatureMember();
                    for (int x = 0; x < o.length; x++) {
                        Object featureMember = o[x];
                        featureCollection.addFeatureMember(featureMember);
                    }
                    i++;
                }
            }
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
        Iterator it = getCapabilitiesV110.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (i == 0) {
                newWfsCapabilitiesV110 = (nl.b3p.xml.wfs.v110.WFS_Capabilities) it.next();
                i = +1;
                nl.b3p.xml.wfs.v110.FeatureTypeList typeList = newWfsCapabilitiesV110.getFeatureTypeList();
                for (int x = 0; x < typeList.getFeatureTypeCount(); x++) {
                    nl.b3p.xml.wfs.v110.FeatureType feature = typeList.getFeatureType(x);
                    boolean hasRights = false;
                    Iterator il = layers.iterator();
                    while (il.hasNext()) {
                        String lName = il.next().toString();
                        String temp = feature.getName();
                        if (lName.equalsIgnoreCase(feature.getName())) {
                            hasRights = true;
                        }
                    }
                    if (hasRights == false) {
                        newWfsCapabilitiesV110.getFeatureTypeList().removeFeatureType(feature);
                    }
                }
            } else {
                nl.b3p.xml.wfs.v110.WFS_Capabilities nextWfsCapabilitiesV110 = (nl.b3p.xml.wfs.v110.WFS_Capabilities) it.next();
                nl.b3p.xml.wfs.v110.FeatureType[] featureTypes = nextWfsCapabilitiesV110.getFeatureTypeList().getFeatureType();
                for (int x = 0; x < featureTypes.length; x++) {
                    nl.b3p.xml.wfs.v110.FeatureType feature = featureTypes[x];
                    boolean hasRights = false;
                    Iterator il = layers.iterator();
                    while (il.hasNext()) {
                        String lName = il.next().toString();
                        if (lName.equalsIgnoreCase(feature.getName())) {
                            hasRights = true;
                        }
                    }
                    if (hasRights == true) {
                        newWfsCapabilitiesV110.getFeatureTypeList().addFeatureType(feature);
                    }
                }
                checkFilterCapabilities(newWfsCapabilitiesV110.getFilter_Capabilities(), nextWfsCapabilitiesV110.getFilter_Capabilities());
            }
        }

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
        Iterator it = getCapabilitiesV100.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (i == 0) {
                newWfsCapabilitiesV100 = (nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities) it.next();
                i = +1;
                nl.b3p.xml.wfs.v100.capabilities.FeatureTypeList typeList = newWfsCapabilitiesV100.getFeatureTypeList();
                for (int x = 0; x < typeList.getFeatureTypeCount(); x++) {
                    FeatureType feature = typeList.getFeatureType(x);
                    boolean hasRights = false;
                    Iterator il = layers.iterator();
                    while (il.hasNext()) {
                        String lName = il.next().toString();
                        if (lName.equalsIgnoreCase(feature.getName())) {
                            hasRights = true;
                        }
                    }
                    if (hasRights == false) {
                        newWfsCapabilitiesV100.getFeatureTypeList().removeFeatureType(feature);
                    }
                }
            } else {
                nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities nextWfsCapabilitiesV100 = (nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities) it.next();
                nl.b3p.xml.wfs.v100.capabilities.FeatureType[] featureTypes = nextWfsCapabilitiesV100.getFeatureTypeList().getFeatureType();
                for (int x = 0; x < featureTypes.length; x++) {
                    FeatureType feature = featureTypes[x];
                    boolean hasRights = false;
                    Iterator il = layers.iterator();
                    while (il.hasNext()) {
                        String lName = il.next().toString();
                        if (lName.equalsIgnoreCase(feature.getName())) {
                            hasRights = true;
                        }
                    }
                    if (hasRights == true) {
                        newWfsCapabilitiesV100.getFeatureTypeList().addFeatureType(feature);
                    }
                }
                checkFilterCapabilities(newWfsCapabilitiesV100.getFilter_Capabilities(), nextWfsCapabilitiesV100.getFilter_Capabilities());
            }
        }

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
                    filter.getSpatial_Capabilities().getGeometryOperands_Spatial_CapabilitiesType().removeGeometryOperand(geometryOperand[i]);
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
                    filter.getSpatial_Capabilities().getSpatialOperators().removeSpatialOperator(spatialOperator[x]);
                }
            }

            nl.b3p.xml.ogc.v110.LogicalOperators logicalOperators = filter.getScalar_Capabilities().getLogicalOperators();
            nl.b3p.xml.ogc.v110.LogicalOperators newLogicalOperators = newFilter.getScalar_Capabilities().getLogicalOperators();
            if (!logicalOperators.toString().equals(newLogicalOperators.toString())) {
                if (logicalOperators != null && newLogicalOperators == null) {
                    filter.getScalar_Capabilities().setLogicalOperators(null);
                }
            }

            nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem[] comparisonOperators = filter.getScalar_Capabilities().getComparisonOperators().getComparisonOperatorsTypeItem();
            nl.b3p.xml.ogc.v110.ComparisonOperatorsTypeItem[] newComparisonOperators = newFilter.getScalar_Capabilities().getComparisonOperators().getComparisonOperatorsTypeItem();
            for (int o = 0; o < comparisonOperators.length; o++) {
                boolean isValid = false;
                String value = comparisonOperators[o].getComparisonOperator().toString();
                for (int p = 0; p < newComparisonOperators.length; p++) {
                    String newValue = newComparisonOperators[p].getComparisonOperator().toString();
                    if (value.equals(newValue)) {
                        isValid = true;
                    }
                }
                if (isValid == false) {
                    filter.getScalar_Capabilities().getComparisonOperators().removeComparisonOperatorsTypeItem(comparisonOperators[o]);
                }
            }

            nl.b3p.xml.ogc.v110.ArithmeticOperatorsTypeItem[] arithmeticOperators = filter.getScalar_Capabilities().getArithmeticOperators().getArithmeticOperatorsTypeItem();
            nl.b3p.xml.ogc.v110.ArithmeticOperatorsTypeItem[] newArithmeticOperators = newFilter.getScalar_Capabilities().getArithmeticOperators().getArithmeticOperatorsTypeItem();
            for (int f = 0; f < arithmeticOperators.length; f++) {
                boolean isValid = false;
                String value = arithmeticOperators[f].getSimpleArithmetic().toString();
                for (int h = 0; h < newArithmeticOperators.length; h++) {
                    String newValue = newArithmeticOperators[h].getSimpleArithmetic().toString();
                    if (value.equals(newValue)) {
                        isValid = true;
                    }
                }
                if (isValid == false) {
                    filter.getScalar_Capabilities().getArithmeticOperators().removeArithmeticOperatorsTypeItem(arithmeticOperators[f]);
                }
            }

            nl.b3p.xml.ogc.v110.Id_CapabilitiesTypeItem[] idCapabilities = filter.getId_Capabilities().getId_CapabilitiesTypeItem();
            nl.b3p.xml.ogc.v110.Id_CapabilitiesTypeItem[] newIdCapabilities = newFilter.getId_Capabilities().getId_CapabilitiesTypeItem();
            for (int a = 0; a < idCapabilities.length; a++) {
                boolean isValid = false;
                String value = idCapabilities[a].getChoiceValue().toString();
                for (int b = 0; b < newIdCapabilities.length; b++) {
                    String newValue = newIdCapabilities[b].getChoiceValue().toString();
                    if (value.equals(newValue)) {
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
                String value = spatialOperators[i].toString();
                for (int j = 0; j < newSpatialOperators.length; j++) {
                    String newValue = newSpatialOperators[j].toString();
                    if (value.equals(newValue)) {
                        isValid = true;
                    }
                }
                if (isValid == false) {
                    filter.getSpatial_Capabilities().getSpatial_Operators().removeSpatial_OperatorsTypeItem(spatialOperators[i]);
                }
            }

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
                                String value = arithmeticOperators[k].toString();
                                for (int l = 0; l < newArithmeticOperators.length; l++) {
                                    String newValue = newArithmeticOperators[l].toString();
                                    if (value.equals(newValue)) {
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
                                String value = comparisonOperators[k].toString();
                                for (int l = 0; l < newComparisonOperators.length; l++) {
                                    String newValue = newComparisonOperators[l].toString();
                                    if (value.equals(newValue)) {
                                        isValid = true;
                                    }
                                }
                                if (isValid == false) {
                                    filter.getScalar_Capabilities().getScalar_CapabilitiesTypeItem(x).getComparison_Operators().removeComparison_OperatorsTypeItem(comparisonOperators[k]);
                                }
                            }
                        }
                    }
                } else if (scalarCapabilities[x].getLogical_Operators() != null) {
                    boolean isValid = false;
                    String value = scalarCapabilities[x].getLogical_Operators().toString();
                    for (int y = 0; y < newScalarCapabilities.length; y++) {
                        String newValue = newScalarCapabilities[y].getLogical_Operators().toString();
                        if (value.equals(newValue)) {
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
}
