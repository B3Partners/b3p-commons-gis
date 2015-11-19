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
 * WFSGetCapabilitiesResponse.java
 *
 * Created on May 16, 2008, 9:32 AM
 *
 * Vergelijkbare klasse als OGCRequest.java maar dan om de response mee te verwerken die
 * de serviceprviders stuurt na een request.
 */
package nl.b3p.ogc.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import nl.b3p.xml.ogc.v110.SimpleArithmetic;
import nl.b3p.xml.ows.v100.DCP;
import nl.b3p.xml.ows.v100.HTTP;
import nl.b3p.xml.ows.v100.Operation;
import nl.b3p.xml.ows.v100.OperationsMetadata;
import nl.b3p.xml.ows.v100.Parameter_Operation;
import nl.b3p.xml.ows.v100.ServiceContact;
import nl.b3p.xml.ows.v100.ServiceIdentification;
import nl.b3p.xml.ows.v100.ServiceProvider;
import nl.b3p.xml.wfs.Filter_Capabilities;
import nl.b3p.xml.wfs.v100.capabilities.DCPType;
import nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType;
import nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType;
import nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType;
import nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType;
import nl.b3p.xml.wfs.v100.capabilities.FeatureType;
import nl.b3p.xml.wfs.v100.capabilities.HTTPTypeItem;
import nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem;
import nl.b3p.xml.wfs.v100.capabilities.Service;
import org.exolab.castor.types.AnyNode;
import org.exolab.castor.xml.Unmarshaller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author Chris
 */
public class WFSGetCapabilitiesResponse extends OGCResponse implements OGCConstants {

    private nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities newWfsCapabilitiesV100;
    private nl.b3p.xml.wfs.v110.WFS_Capabilities newWfsCapabilitiesV110;
    private final List getCapabilitiesV100 = new ArrayList();
    private final List getCapabilitiesV110 = new ArrayList();
    private final List versions = new ArrayList();
    private List supportedOperations = new ArrayList();
    
    private String createVendorBlock(OGCRequest ogcrequest) {
        StringBuffer xml = new StringBuffer("<?xml version=\"1.0\"?>");
        xml.append("<kaartenbalie>");
        xml.append("<personalcode>");
        xml.append(ogcrequest.getPersonalCode());
        xml.append("</personalcode>");
        xml.append("<username>");
        xml.append(ogcrequest.getUsername());
        xml.append("</username>");
        xml.append("</kaartenbalie>");
        //ogcrequest.getPassword();
        //ogcrequest.getServiceProviderName();
        //ogcrequest.getUrl();
        
        return xml.toString();
    }
    
    private void buildHeader(OGCRequest ogcrequest) {
        
//        serviceProvider.setName(KBConfiguration.SERVICE_NAME);
//        serviceProvider.setTitle(KBConfiguration.SERVICE_TITLE);
//        serviceProvider.setAbstracts(KBConfiguration.SERVICE_ABSTRACT);
//        serviceProvider.setAccessConstraints(KBConfiguration.SERVICE_CONSTRAINTS);
//        serviceProvider.setFees(KBConfiguration.SERVICE_FEES);
//
//        ContactInformation ci = new ContactInformation();
//        ci.setContactPerson(KBConfiguration.CONTACT_PERSON);
//        ci.setContactPosition(KBConfiguration.CONTACT_POSITION);
//        ci.setContactOrganization(KBConfiguration.CONTACT_ORGANIZATION);
//        ci.setAddress(KBConfiguration.CONTACT_ADDRESS);
//        ci.setAddressType(KBConfiguration.CONTACT_ADDRESS_TYPE);
//        ci.setPostcode(KBConfiguration.CONTACT_POSTCODE);
//        ci.setCity(KBConfiguration.CONTACT_CITY);
//        ci.setStateOrProvince(KBConfiguration.CONTACT_STATE_OR_PROVINCE);
//        ci.setCountry(KBConfiguration.CONTACT_COUNTRY);
//        ci.setVoiceTelephone(KBConfiguration.CONTACT_VOICETELEPHONE);
//        ci.setFascimileTelephone(KBConfiguration.CONTACT_FASCIMILEPHONE);
//        ci.setEmailAddress(KBConfiguration.CONTACT_EMAIL);
//
//        serviceProvider.setContactInformation(ci);

         String vendorBlock = createVendorBlock(ogcrequest);
        
         if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)) {

            Service s = newWfsCapabilitiesV100.getService();
            s.setAbstract(KBConfiguration.SERVICE_ABSTRACT);
            s.setAccessConstraints("<![CDATA[" +vendorBlock+ "]]>");
            s.setFees(KBConfiguration.SERVICE_FEES);
            s.setKeywords("");
            s.setName(KBConfiguration.SERVICE_NAME);
//            s.setOnlineResource(null); // set in replaceCapabilities
            s.setTitle(KBConfiguration.SERVICE_TITLE);
            
         } else {
 
            ServiceIdentification si = newWfsCapabilitiesV110.getServiceIdentification();
            si.setTitle(KBConfiguration.SERVICE_TITLE);
            si.setAbstract(KBConfiguration.SERVICE_ABSTRACT);
            String[] ac = new String[] {KBConfiguration.SERVICE_CONSTRAINTS};
            si.setAccessConstraints(ac);
            si.setFees(KBConfiguration.SERVICE_FEES);
//            Keywords[] kwa = si.getKeywords();
//            Type t = kwa[0].getType();
//            kwa[0].setType(t);
//            String[] skw = new String[] {};
//            kwa[0].setKeyword(skw);
//            si.setKeywords(kwa);
//            si.setServiceType(null);
//            String[] stv = new String[] {};
//            si.setServiceTypeVersion(stv);
            
            
            ServiceProvider sp = newWfsCapabilitiesV110.getServiceProvider();
            sp.setProviderName(KBConfiguration.SERVICE_NAME);
            
//            ProviderSite ps = sp.getProviderSite();
//            ps.setActuate(null);
//            ps.setArcrole(null);
//            ps.setHref(null); // set in replaceCapabilities
//            ps.setShow(null);
//            ps.setTitle(null);
//            ps.setType("");
//            sp.setProviderSite(ps);
            
            ServiceContact sc = sp.getServiceContact();
            
//            ContactInfo ci = sc.getContactInfo();
//            ci.setAddress(null);
//            ci.setContactInstructions(null);
//            ci.setHoursOfService("");
//            ci.setOnlineResource(null);
//            ci.setPhone(null);
//            sc.setContactInfo(ci);
            
            sc.setIndividualName(KBConfiguration.CONTACT_PERSON);
            sc.setPositionName(KBConfiguration.CONTACT_POSITION);
            
//            Role r = sc.getRole();
//            r.setCodeSpace("");
//            r.setContent("");
//            sc.setRole(r);
            
            sp.setServiceContact(sc);
            
            OperationsMetadata om = newWfsCapabilitiesV110.getOperationsMetadata();
            
//            om.setConstraint_OperationsMetadata(null);
//            om.setOperation(null);
//            om.setParameter_OperationsMetadata(null);
            
            AnyNode extra = null;
            try {
                extra = OgcWfsClient.xmlStringToAnyNode(vendorBlock);
                om.setExtendedCapabilities(extra);
            } catch (Exception ex) {
                // geen extra's 
            }
            
        }
        
    }

    public void rebuildResponse(Document doc, OGCRequest request, String prefix) throws Exception {
        Element element = (Element) doc.getDocumentElement();
        this.httpHost = request.getUrlWithNonOGCparams();
        findNameSpace(doc);
        Unmarshaller um;
        Object o;
 
        version = element.getAttribute(OGCConstants.VERSION.toLowerCase());
        isSupportedVersion(version);

        if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)) {
            um = new Unmarshaller(nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities.class);
            o = um.unmarshal(element);
            nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities wfsCapabilities = (nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities) o;

            getCapabilitiesV100.add(replaceCapabilitiesV100Url(wfsCapabilities, prefix));
        } else {
            um = new Unmarshaller(nl.b3p.xml.wfs.v110.WFS_Capabilities.class);
            o = um.unmarshal(element);
            nl.b3p.xml.wfs.v110.WFS_Capabilities wfsCapabilities = (nl.b3p.xml.wfs.v110.WFS_Capabilities) o;

            getCapabilitiesV110.add(replaceCapabilitiesV110Url(wfsCapabilities, prefix));
        }
        checkSupportedOperations(OGCConstants.SUPPORTED_WFS_REQUESTS);
    }
    
    private void replaceUrl(HTTPTypeItem httpItem) {
        if (httpItem.getGet() != null) {
            httpItem.getGet().setOnlineResource(httpHost);
        } else if (httpItem.getPost() != null) {
            httpItem.getPost().setOnlineResource(httpHost);
        }
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
        return wfsCapabilities;
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
        return wfsCapabilities;
    }

    /**
     *
     * @param layers
     * @return
     */
    public String getResponseBody(List<SpLayerSummary> layers, OGCRequest ogcrequest, String encoding) {
        String spInUrl = ogcrequest.getServiceProviderName();
        Object castorObject = mergeCapabilities(layers, spInUrl);
        
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

        buildHeader(ogcrequest);
        
        return marshalObject(castorObject, encoding);
    }

    private void clearGetCapabilitiesV110() {
        getCapabilitiesV110.clear();
    }

    private void clearGetCapabilitiesV100() {
        getCapabilitiesV100.clear();
    }

    private Object mergeCapabilities(List<SpLayerSummary> spLayerSummaries, String spInUrl) {
        Object caps = new Object();
        if (versions.size() > 1) {
            //meerdere versies
            throw new UnsupportedOperationException("Capabilities with more versions are not yet supported!");
        } else if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)) {
            caps = getFeatureTypesV100(spLayerSummaries, spInUrl);
        } else if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_110)) {
            caps = getFeatureTypesV110(spLayerSummaries, spInUrl);
        }
        return caps;
    }

    private nl.b3p.xml.wfs.v110.WFS_Capabilities getFeatureTypesV110(List<SpLayerSummary> spLayerSummaries, String spInUrl) {
        
        //String layerName = determineFeatureTypeName((String) sp.get("spAbbr"), (String) sp.get("layer"));
        List foundFeatureTypes = new ArrayList();

        Iterator it = getCapabilitiesV110.iterator();
        while (it.hasNext()) {
            nl.b3p.xml.wfs.v110.WFS_Capabilities nextWfsCapabilitiesV110 = (nl.b3p.xml.wfs.v110.WFS_Capabilities) it.next();
            nl.b3p.xml.wfs.v110.FeatureTypeList nextTypeList = nextWfsCapabilitiesV110.getFeatureTypeList();
            for (int x = 0; x < nextTypeList.getFeatureTypeCount(); x++) {
                nl.b3p.xml.wfs.v110.FeatureType feature = nextTypeList.getFeatureType(x);
                String name = feature.getName();
                try {
                    if (getRequestName(name, spLayerSummaries, spInUrl) != null) {
                        // found so add to response
                        foundFeatureTypes.add(feature);
                    }
                } catch (Exception e) {
                    // do not add
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
            } else {
                Operation o = operations[y];
                Parameter_Operation[] poa = o.getParameter_Operation();
                for (int x = 0; x < poa.length; x++) {
                    if (poa[x]!=null && poa[x].getName()!=null &&
                        poa[x].getName().equalsIgnoreCase("outputFormat")) {
                        // add default for wfs 1.1: text/xml; subtype=gml/3.1.1
                        poa[x].setValue(0,"text/xml; subtype=gml/3.1.1");
                    }
                }
            }
        }
        
        clearGetCapabilitiesV110();
        this.clearVersions();
        this.setUsableResponse(true);
        return newWfsCapabilitiesV110;
    }

    private nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities getFeatureTypesV100(List<SpLayerSummary> spLayerSummaries, String spInUrl) {
        //String layerName = determineFeatureTypeName((String) sp.get("spAbbr"), (String) sp.get("layer"));
        List foundFeatureTypes = new ArrayList();

        Iterator it = getCapabilitiesV100.iterator();
        while (it.hasNext()) {
            nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities nextWfsCapabilitiesV100 = (nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities) it.next();
            nl.b3p.xml.wfs.v100.capabilities.FeatureType[] featureTypes = nextWfsCapabilitiesV100.getFeatureTypeList().getFeatureType();
            for (int x = 0; x < featureTypes.length; x++) {
                FeatureType feature = featureTypes[x];
                String name = feature.getName();
                try {
                    if (getRequestName(name, spLayerSummaries, spInUrl) != null) {
                        // found so add to response
                        foundFeatureTypes.add(feature);
                    }
                } catch (Exception e) {
                    // do not add
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
        List<RequestTypeItem> unsupportedRequestItems = new ArrayList<RequestTypeItem>();
        for (int x = 0; x < operations.length; x++) {
            boolean supported = true;
            if (operations[x].getDescribeFeatureType() != null &&
                !supportedOperations.contains(OGCConstants.WFS_REQUEST_DescribeFeatureType)) {
                supported = false;
            } else if (operations[x].getGetCapabilities() != null &&
                !supportedOperations.contains(OGCConstants.WFS_REQUEST_GetCapabilities)) {
                supported = false;
            } else if (operations[x].getGetFeature() != null &&
                !supportedOperations.contains(OGCConstants.WFS_REQUEST_GetFeature)) {
                supported = false;
            } else if (operations[x].getGetFeatureWithLock() != null &&
                !supportedOperations.contains(OGCConstants.WFS_REQUEST_GetFeatureWithLock)) {
                supported = false;
            } else if (operations[x].getLockFeature() != null &&
                !supportedOperations.contains(OGCConstants.WFS_REQUEST_LockFeature)) {
                supported = false;
            } else if (operations[x].getTransaction() != null &&
                !supportedOperations.contains(OGCConstants.WFS_REQUEST_Transaction)) {
                supported = false;
            }
            if (!supported) {
                unsupportedRequestItems.add(newWfsCapabilitiesV100.getCapability().getRequest().getRequestTypeItem(x));
            }
        }
        for (RequestTypeItem requestItem : unsupportedRequestItems) {
            newWfsCapabilitiesV100.getCapability().getRequest().removeRequestTypeItem(requestItem);
        }

        clearGetCapabilitiesV100();
        this.clearVersions();
        this.setUsableResponse(true);
        return newWfsCapabilitiesV100;
    }

    //TODO concurrent modification error check uitvoeren
    private void checkFilterCapabilities(Filter_Capabilities filterCapabilities, Filter_Capabilities newFilterCapabilities) {
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
                    SimpleArithmetic simpleArithmetic = arithmeticOperators[f].getSimpleArithmetic();
                    if (simpleArithmetic!=null) {
                        Class valueClass = simpleArithmetic.getClass();
                        if (newArithmeticOperators != null) {
                            for (int h = 0; h < newArithmeticOperators.length; h++) {
                                Class newValueClass = newArithmeticOperators[h].getSimpleArithmetic().getClass();
                                if (valueClass.equals(newValueClass)) {
                                    isValid = true;
                                }
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

    private void clearVersions() {
        versions.clear();
    }

    private boolean isSupportedVersion(String version) {
        if (OGCConstants.SUPPORTED_WFS_VERSIONS.contains(version)) {
            if (!versions.contains(version) && version != null) {
                versions.add(version);
            }
            return true;
        } else {
            throw new UnsupportedOperationException("WFS Version the serviceProvider returned is not supported by Kaartenbalie!");
        }
    }


}
