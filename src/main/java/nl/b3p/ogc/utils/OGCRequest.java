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
 * WMSParamUtil.java
 *
 * Created on 1 maart 2007, 14:44
 *
 * This util class is compatible with WFS 1.1.0 and WMS 1.1.1
 *
 */
package nl.b3p.ogc.utils;

import java.io.FileInputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import nl.b3p.xml.wfs.WFS_Capabilities;
import nl.b3p.xml.wfs.v110.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.w3c.dom.Element;

/**
 * @author Roy Braam
 */

/*TODO: Deze class is nu case insensitive doordat er bij add/remove/get/etc. Parameter worden de parameters opgehaald
en opgeslagen in hoofdletters. Als KBconstants de goede Static String waarden heeft (casesensitive) dan kan het hier weg
zodat de klasse casesensitife is. Tevens kunnen dan alle strings die hier in staan worden vervangen door de constanten.*/
public class OGCRequest extends OGCCommunication implements OGCConstants {

    protected static final Log log = LogFactory.getLog(OGCRequest.class);
    protected String httpMethod;
    protected String httpHost;
    protected WFS_Capabilities capabilities;
    protected HashMap parameters;
    protected HashMap transactionList = new HashMap();
    protected HashMap getFeatureFilterMap = new HashMap();
    protected HashMap getFeaturePropertyNameListMap = new HashMap();
    protected String abbr;
    protected ArrayList layers = new ArrayList();
    protected String username;
    protected String password;
    // version that will be returned to client
    protected String finalVersion;
    protected String serviceProviderName;
    private String personalCode;
    
    public static final List NAMESPACES_NOT_IN_URL = Arrays.asList(new String[]{
                "http://www.opengis.net/wfs",
                "http://www.w3.org/2001/xmlschema-instance",
                "http://www.opengis.net/gml",
                "http://www.opengis.net/ogc",
                "http://www.opengis.net/ows"
            });

    /*Default constr.*/
    public OGCRequest() {
        addOpengisNamespaces();
        parameters = new HashMap();
    }

    /** Main constructor
     *
     * @param url The url that fills the OGCUrl object
     *
     *  For HTTP GET
     */
    public OGCRequest(String url) {
        addOpengisNamespaces();
        parameters = new HashMap();
        setUrl(url);
    }

    public static String removeNamespace(String tagName) {
        if (tagName == null || tagName.length() == 0) {
            return "";
        }
        String[] tokens = tagName.split(":");
        if (tokens.length > 1) {
            return tokens[1];
        }
        return tokens[0];
    }

    /**
     * Constructor
     * For HTTP POST
     */
    public OGCRequest(Element rootElement, String url) throws ValidationException, Exception {
        addOpengisNamespaces();
        parameters = new HashMap();
        setUrl(url);
        findNameSpace(rootElement);

        Unmarshaller um;
        Object o;

        setFinalVersion(rootElement.getAttribute(OGCConstants.VERSION.toLowerCase()));
        String version = finalVersion;

        if (removeNamespace(rootElement.getTagName()).equalsIgnoreCase(OGCConstants.WFS_GETCAPABILITIES)) {
            if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)) {
                um = new Unmarshaller(nl.b3p.xml.wfs.v100.GetCapabilities.class);
                o = um.unmarshal(rootElement);
                nl.b3p.xml.wfs.v100.GetCapabilities getCapabilities = (nl.b3p.xml.wfs.v100.GetCapabilities) o;
                setGetCapabilitiesV100(getCapabilities);
            } else {
                um = new Unmarshaller(nl.b3p.xml.wfs.v110.GetCapabilities.class);
                o = um.unmarshal(rootElement);
                nl.b3p.xml.wfs.v110.GetCapabilities getCapabilities = (nl.b3p.xml.wfs.v110.GetCapabilities) o;
                setGetCapabilitiesV110(getCapabilities);
            }
        } else if (removeNamespace(rootElement.getTagName()).equalsIgnoreCase(OGCConstants.WFS_DESCRIBEFEATURETYPE)) {
            if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)) {
                um = new Unmarshaller(nl.b3p.xml.wfs.v100.DescribeFeatureType.class);
                o = um.unmarshal(rootElement);
                nl.b3p.xml.wfs.v100.DescribeFeatureType describeFeatureType = (nl.b3p.xml.wfs.v100.DescribeFeatureType) o;
                setDescribeFeatureTypeV100(describeFeatureType);
            } else {
                um = new Unmarshaller(nl.b3p.xml.wfs.v110.DescribeFeatureType.class);
                o = um.unmarshal(rootElement);
                nl.b3p.xml.wfs.v110.DescribeFeatureType describeFeatureType = (nl.b3p.xml.wfs.v110.DescribeFeatureType) o;
                setDescribeFeatureTypeV110(describeFeatureType);
            }
        } else if (removeNamespace(rootElement.getTagName()).equalsIgnoreCase(OGCConstants.WFS_GETFEATURE)) {
            if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)) {
                um = new Unmarshaller(nl.b3p.xml.wfs.v100.GetFeature.class);
                o = um.unmarshal(rootElement);
                nl.b3p.xml.wfs.v100.GetFeature getFeature = (nl.b3p.xml.wfs.v100.GetFeature) o;
                setGetFeatureV100(getFeature);
            } else {
                um = new Unmarshaller(nl.b3p.xml.wfs.v110.GetFeature.class);
                o = um.unmarshal(rootElement);
                nl.b3p.xml.wfs.v110.GetFeature getFeature = (nl.b3p.xml.wfs.v110.GetFeature) o;
                setGetFeatureV110(getFeature);
            }
        } else if (removeNamespace(rootElement.getTagName()).equalsIgnoreCase(OGCConstants.WFS_TRANSACTION)) {
            if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)) {
                um = new Unmarshaller(nl.b3p.xml.wfs.v100.capabilities.Transaction.class);
                o = um.unmarshal(rootElement);
                nl.b3p.xml.wfs.v100.transaction.Transaction transaction = (nl.b3p.xml.wfs.v100.transaction.Transaction) o;
                setTransactionV100(transaction);
            } else {
                um = new Unmarshaller(nl.b3p.xml.wfs.v110.Transaction.class);
                o = um.unmarshal(rootElement);
                nl.b3p.xml.wfs.v110.Transaction transaction = (nl.b3p.xml.wfs.v110.Transaction) o;
                setTransactionV110(transaction);
            }
        } else if (removeNamespace(rootElement.getTagName()).equalsIgnoreCase(OGCConstants.WFS_LOCKFEATURE)) {
            throw new UnsupportedOperationException("kaartenbalie doesn't suport " + OGCConstants.WFS_LOCKFEATURE + " yet!");
        } else if (removeNamespace(rootElement.getTagName()).equalsIgnoreCase(OGCConstants.WFS_GETFEATUREWITHLOCK)) {
            throw new UnsupportedOperationException("kaartenbalie doesn't suport " + OGCConstants.WFS_GETFEATUREWITHLOCK + " yet!");
        } else {
            throw new UnsupportedOperationException("No supported WFS service found in request!");
        }
    }

    /**
     * Serie of methods to fill the HashMap parameters
     */
    public final void setGetCapabilitiesV100(nl.b3p.xml.wfs.v100.GetCapabilities getCapabilities) {
        addOrReplaceParameter(OGCConstants.VERSION, getCapabilities.getVersion());
        addOrReplaceParameter(OGCConstants.SERVICE, getCapabilities.getService());
        addOrReplaceParameter(OGCConstants.REQUEST, OGCConstants.WFS_REQUEST_GetCapabilities);
    }

    public final void setGetCapabilitiesV110(nl.b3p.xml.wfs.v110.GetCapabilities getCapabilities) {
        addOrReplaceParameter(OGCConstants.VERSION, OGCConstants.WFS_VERSION_110);
        addOrReplaceParameter(OGCConstants.SERVICE, getCapabilities.getService());
        addOrReplaceParameter(OGCConstants.REQUEST, OGCConstants.WFS_REQUEST_GetCapabilities);
    }

    public final void setDescribeFeatureTypeV100(nl.b3p.xml.wfs.v100.DescribeFeatureType describeFeatureType) {
        addOrReplaceParameter(OGCConstants.VERSION, describeFeatureType.getVersion());
        addOrReplaceParameter(OGCConstants.SERVICE, describeFeatureType.getService());
        addOrReplaceParameter(OGCConstants.REQUEST, OGCConstants.WFS_REQUEST_DescribeFeatureType);
        addOrReplaceParameter(OGCConstants.WFS_PARAM_OUTPUTFORMAT, describeFeatureType.getOutputFormat());
        String[] list = describeFeatureType.getTypeName();
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < list.length; i++) {
            if (i != 0) {
                str.append(",");
            }
            str.append(list[i]);
        }
        addOrReplaceParameter(OGCConstants.WFS_PARAM_TYPENAME, str.toString());
    }

    public final void setDescribeFeatureTypeV110(nl.b3p.xml.wfs.v110.DescribeFeatureType describeFeatureType) {
        addOrReplaceParameter(OGCConstants.VERSION, describeFeatureType.getVersion());
        addOrReplaceParameter(OGCConstants.SERVICE, describeFeatureType.getService());
        addOrReplaceParameter(OGCConstants.REQUEST, OGCConstants.WFS_REQUEST_DescribeFeatureType);
        addOrReplaceParameter(OGCConstants.WFS_PARAM_OUTPUTFORMAT, describeFeatureType.getOutputFormat());
        String[] list = describeFeatureType.getTypeName();
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < list.length; i++) {
            if (i != 0) {
                str.append(",");
            }
            str.append(list[i]);
        }
        addOrReplaceParameter(OGCConstants.WFS_PARAM_TYPENAME, str.toString());
    }

    public final void setGetFeatureV100(nl.b3p.xml.wfs.v100.GetFeature getFeature) throws Exception {
        addOrReplaceParameter(OGCConstants.VERSION, getFeature.getVersion());
        addOrReplaceParameter(OGCConstants.SERVICE, getFeature.getService());
        addOrReplaceParameter(OGCConstants.REQUEST, OGCConstants.WFS_REQUEST_GetFeature);
        addOrReplaceParameter(OGCConstants.WFS_PARAM_HANDLE, getFeature.getHandle());
        addOrReplaceParameter(OGCConstants.WFS_PARAM_OUTPUTFORMAT, getFeature.getOutputFormat());
        if (getFeature.getMaxFeatures() > 0) {
            addOrReplaceParameter(OGCConstants.WFS_PARAM_MAXFEATURES, "" + getFeature.getMaxFeatures());
        }
        nl.b3p.xml.wfs.v100.Query[] qlist = getFeature.getQuery();
        if (qlist.length > 0) {
            for (int i = 0; i < qlist.length; i++) {
                String typename = qlist[i].getTypeName();
                String filter = null;
                if (qlist[i].getFilter() != null) {
                    StringWriter sw = new StringWriter();
                    Marshaller m = new Marshaller(sw);
                    m.marshal(qlist[i].getFilter());
                    filter = sw.toString();
                }
                addGetFeatureFilterMap(typename, filter);
                StringBuffer propertyNameList = new StringBuffer();
                for (int j = 0; j < qlist[i].getPropertyNameCount(); j++) {
                    propertyNameList.append(qlist[i].getPropertyName(j).getContent());
                    if (j + 1 < qlist[i].getPropertyNameCount()) {
                        propertyNameList.append(',');
                    }
                }
                addGetFeaturePropertyNameListMap(typename, propertyNameList.length() > 0 ? propertyNameList.toString() : null);
            }
        }
    }

    public final void setGetFeatureV110(nl.b3p.xml.wfs.v110.GetFeature getFeature) throws Exception {
        addOrReplaceParameter(OGCConstants.VERSION, getFeature.getVersion());
        addOrReplaceParameter(OGCConstants.SERVICE, getFeature.getService());
        addOrReplaceParameter(OGCConstants.WFS_PARAM_RESULTTYPE, getFeature.getResultType().toString());
        addOrReplaceParameter(OGCConstants.REQUEST, OGCConstants.WFS_REQUEST_GetFeature);
        addOrReplaceParameter(OGCConstants.WFS_PARAM_HANDLE, getFeature.getHandle());
        addOrReplaceParameter(OGCConstants.WFS_PARAM_OUTPUTFORMAT, getFeature.getOutputFormat());
        if (getFeature.getMaxFeatures() > 0) {
            addOrReplaceParameter(OGCConstants.WFS_PARAM_MAXFEATURES, "" + getFeature.getMaxFeatures());
        }
        addOrReplaceParameter(OGCConstants.WFS_PARAM_TRAVERSEXLINKDEPTH, getFeature.getTraverseXlinkDepth());
        addOrReplaceParameter(OGCConstants.WFS_PARAM_TRAVERSEXLINKEXPIRY, "" + getFeature.getTraverseXlinkExpiry());
        nl.b3p.xml.wfs.v110.Query[] qlist = getFeature.getQuery();
        if (qlist.length > 0) {
            for (int i = 0; i < qlist.length; i++) {
                String typename = qlist[i].getTypeName();
                String filter = null;
                if (qlist[i].getFilter() != null) {
                    StringWriter sw = new StringWriter();
                    Marshaller m = new Marshaller(sw);
                    m.marshal(qlist[i].getFilter());
                    filter = sw.toString();
                }
                addGetFeatureFilterMap(typename, filter);
                StringBuffer propertyNameList = new StringBuffer();
                for (int j = 0; j < qlist[i].getQueryTypeChoiceCount(); j++) {
                    for (int k = 0; k < qlist[i].getQueryTypeChoice(j).getQueryTypeChoiceItemCount(); k++) {
                        String propertyName = qlist[i].getQueryTypeChoice(j).getQueryTypeChoiceItem(k).getPropertyName();
                        if (propertyNameList.length() > 0) {
                            propertyNameList.append(',');
                        }
                        if (propertyName != null) {
                            propertyNameList.append(propertyName);
                        }
                    }
                }
                addGetFeaturePropertyNameListMap(typename, propertyNameList.length() > 0 ? propertyNameList.toString() : null);
            }
        }
    }

    public final void setTransactionV100(nl.b3p.xml.wfs.v100.transaction.Transaction transaction) throws Exception {
        addOrReplaceParameter(OGCConstants.VERSION, transaction.getVersion());
        addOrReplaceParameter(OGCConstants.SERVICE, transaction.getService());
        addOrReplaceParameter(OGCConstants.REQUEST, OGCConstants.WFS_REQUEST_Transaction);
        addOrReplaceParameter(OGCConstants.WFS_PARAM_HANDLE, transaction.getHandle());
        addOrReplaceParameter(OGCConstants.WFS_PARAM_LOCKID, transaction.getLockId());
        if (transaction.getReleaseAction() != null) {
            StringWriter sw = new StringWriter();
            Marshaller m = new Marshaller(sw);
            m.marshal(transaction.getReleaseAction());
            addOrReplaceParameter(OGCConstants.WFS_PARAM_RELEASEACTION, sw.toString());
        }

        nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoice[] transactionTypeChoiceList = transaction.getTransactionTypeChoice();
        int size = transactionTypeChoiceList.length;
        for (int i = 0; i < size; i++) {
            nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoice transactionTypeChoice = transactionTypeChoiceList[i];
            int count = transactionTypeChoice.getTransactionTypeChoiceItemCount();
            for (int x = 0; x < count; x++) {
                nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoiceItem transactionTypeChoiceItem = transactionTypeChoice.getTransactionTypeChoiceItem(x);
                if (transactionTypeChoiceItem.getDelete() != null) {
                    nl.b3p.xml.wfs.v100.transaction.Delete delete = transactionTypeChoiceItem.getDelete();
                    String layer = delete.getTypeName();
                    getLayers().add(layer);
					
                    LayerSummary map = splitLayerInParts(layer);
                    addElementToTransactionList(delete, map.getSpAbbr());
					
                } else if (transactionTypeChoiceItem.getInsert() != null) {
                    nl.b3p.xml.wfs.v100.transaction.Insert insert = transactionTypeChoiceItem.getInsert();

                    /* Nog niet duidelijk of dit gaat werken. Moet nog getest worden. */
                    StringWriter sw = new StringWriter();
                    Marshaller m = new Marshaller(sw);
                    m.marshal(insert);
                    String insertString = sw.toString();
                    String[] layer = insertString.split("<");
                    getLayers().add(layer[0]);
					
                    LayerSummary map = splitLayerInParts(layer[0]);
                    addElementToTransactionList(insert, map.getSpAbbr());

                } else if (transactionTypeChoiceItem.getUpdate() != null) {
                    nl.b3p.xml.wfs.v100.transaction.Update update = transactionTypeChoiceItem.getUpdate();
                    String layer = update.getTypeName();
                    getLayers().add(layer);
					
                    LayerSummary map = splitLayerInParts(layer);
                    addElementToTransactionList(update, map.getSpAbbr());
	
                } else if (transactionTypeChoiceItem.getNative() != null) {
                    nl.b3p.xml.wfs.v100.transaction.Native nativetransaction = transactionTypeChoiceItem.getNative();
                }
            }
        }
    }

    public final void setTransactionV110(nl.b3p.xml.wfs.v110.Transaction transaction) throws Exception {
        addOrReplaceParameter(OGCConstants.VERSION, transaction.getVersion());
        addOrReplaceParameter(OGCConstants.SERVICE, transaction.getService());
        addOrReplaceParameter(OGCConstants.REQUEST, OGCConstants.WFS_REQUEST_Transaction);
        addOrReplaceParameter(OGCConstants.WFS_PARAM_HANDLE, transaction.getHandle());
        addOrReplaceParameter(OGCConstants.WFS_PARAM_LOCKID, transaction.getLockId());
        if (transaction.getReleaseAction() != null) {
            StringWriter sw = new StringWriter();
            Marshaller m = new Marshaller(sw);
            m.marshal(transaction.getReleaseAction());
            addOrReplaceParameter(OGCConstants.WFS_PARAM_RELEASEACTION, sw.toString());
        }

        TransactionTypeChoice[] transactionTypeChoiceList = transaction.getTransactionTypeChoice();
        int size = transactionTypeChoiceList.length;
        for (int i = 0; i < size; i++) {
            TransactionTypeChoice transactionTypeChoice = transactionTypeChoiceList[i];
            int count = transactionTypeChoice.getTransactionTypeChoiceItemCount();
            for (int x = 0; x < count; x++) {
                TransactionTypeChoiceItem transactionTypeChoiceItem = transactionTypeChoice.getTransactionTypeChoiceItem(x);
                if (transactionTypeChoiceItem.getDelete() != null) {
                    Delete delete = transactionTypeChoiceItem.getDelete();
                    String layer = delete.getTypeName();
                    getLayers().add(layer);
 					
                    LayerSummary map = splitLayerInParts(layer);
                    addElementToTransactionList(delete, map.getSpAbbr());
					
                } else if (transactionTypeChoiceItem.getInsert() != null) {
                    Insert insert = transactionTypeChoiceItem.getInsert();

                    /* Nog niet duidelijk of dit gaat werken. Moet nog getest worden. */
                    StringWriter sw = new StringWriter();
                    Marshaller m = new Marshaller(sw);
                    m.marshal(insert);
                    String insertString = sw.toString();
                    String[] layer = insertString.split("<");
                    getLayers().add(layer[0]);
 					
                    LayerSummary map = splitLayerInParts(layer[0]);
                    addElementToTransactionList(insert, map.getSpAbbr());

                } else if (transactionTypeChoiceItem.getUpdate() != null) {
                    Update update = transactionTypeChoiceItem.getUpdate();
                    String layer = update.getTypeName();
                    getLayers().add(layer);
					
                    LayerSummary map = splitLayerInParts(layer);
                    addElementToTransactionList(update, map.getSpAbbr());
					
                } else if (transactionTypeChoiceItem.getNative() != null) {
                    Native nativetransaction = transactionTypeChoiceItem.getNative();
                }
            }
        }
    }

    /*
     * Methode that helps you fill the transactionList hashmap with a list of <insert>, <delete> or <update> elements.
     * One list for each serviceprovider. The hashmap contains a key (serviceprovider abbr) and value (list with elements)
     */
    public void addElementToTransactionList(Object element, String spAbbr) {
        if (!transactionList.containsKey(spAbbr)) {
            List temp = new ArrayList();
            temp.add(element);
            transactionList.put(spAbbr, temp);
        } else {
            List temp = (List) transactionList.get(spAbbr);
            temp.add(element);
        }
    }

    public HashMap getTransactionMap() {
        return transactionList;
    }

    public void setTransactionMap(HashMap transactionList) {
        this.transactionList = transactionList;
    }

    public List getTransactionElementList(String spAbbr) {
        return (List) transactionList.get(spAbbr);
    }

    public void setTransactionElementList(List elements, String spAbbr) {
        transactionList.put(spAbbr, elements);
    }

    public String[] getTransactionSpList() {
        Set spSet = transactionList.keySet();
        int size = spSet.size();
        String[] spArray = new String[size];
        Iterator it = spSet.iterator();
        for (int i = 0; i < size; i++) {
            spArray[i] = it.next().toString();
        }
        return spArray;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getAbbr() {
        return abbr;
    }

    public ArrayList getLayers() {
        return layers;
    }

    public HashMap getGetFeatureFilterMap() {
        return getFeatureFilterMap;
    }

    public void setGetFeatureFilterMap(HashMap getFeatureFilterMap) {
        this.getFeatureFilterMap = getFeatureFilterMap;
    }

    public void addGetFeatureFilterMap(String key, Object value) {
        getFeatureFilterMap.put(stripNs(key), value);
    }

    public String getGetFeatureFilter(String key) {
        Object o = getFeatureFilterMap.get(key);
        if (o == null) {
            return null;
        } else {
            return o.toString();
        }
    }

    public HashMap getGetFeaturePropertyNameListMap() {
        return getFeaturePropertyNameListMap;
    }

    public void setGetFeaturePropertyNameListMap(HashMap getFeaturePropertyNameListMap) {
        this.getFeaturePropertyNameListMap = getFeaturePropertyNameListMap;
    }

    public void addGetFeaturePropertyNameListMap(String key, Object value) {
         getFeaturePropertyNameListMap.put(stripNs(key), value);
    }

    public String getGetFeaturePropertyNameList(String key) {
        Object o = getFeaturePropertyNameListMap.get(key);
        if (o == null) {
            return null;
        } else {
            return o.toString();
        }
    }

    /** Main methode to fill the OGUrl object
     *
     * @param url The url that fills the OGCUrl object
     *
     * @return the param value that is removed or null if the parameter key not is found
     */
    public final void setUrl(String url) {
        if (url == null) {
            return;
        }
        
        String[] tokens = url.split("\\?|&");
        if (tokens.length > 0) {
            String[] pi = findServiceProviderNameAndPersonalCode(tokens[0]);
            this.serviceProviderName = pi[0];
            this.personalCode = pi[1];
            setHttpHost(fixHttpHost(tokens[0]));
        }
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].contains("=")) {
                String keyValuePair[] = tokens[i].split("=");
                //if it's a namespace
                if (keyValuePair[0].equalsIgnoreCase("NAMESPACE")) {
                    if (tokens[i].contains("(") && tokens[i].contains(")")) {
                        String namespacestring = tokens[i].substring(tokens[i].indexOf("(") + 1, tokens[i].indexOf(")"));
                        String[] namespaces = namespacestring.split(",");
                        for (int b = 0; b < namespaces.length; b++) {
                            if (namespaces[b].contains("=")) {
                                String prefixUriPair[] = namespaces[b].split("=");
                                if (prefixUriPair.length == 2) {
                                    addOrReplaceNameSpace(prefixUriPair[0], prefixUriPair[1]);
                                } else {
                                    if (namespaces[b].startsWith("=")) {
                                        // default namespace
                                        addOrReplaceNameSpace("", prefixUriPair[1]);
                                    } else {
                                        // illegal
//                                        addOrReplaceNameSpace(prefixUriPair[0], null);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (keyValuePair.length > 2) {
                        String value = "";
                        for (int b = 1; b < keyValuePair.length; b++) {
                            if (b != 1) {
                                value += "=";
                            }
                            value += keyValuePair[b];
                        }
                        addOrReplaceParameter(keyValuePair[0], value);
                    } else if (keyValuePair.length == 2) {
                        addOrReplaceParameter(keyValuePair[0], keyValuePair[1]);
                    } else {
                        addOrReplaceParameter(keyValuePair[0], null);
                    }
                }
            }
        }

        setFinalVersion(getParameter(OGCConstants.VERSION));
    }

    /** Gets the full url with the params
     *
     * @return the full url.
     */
    public String getUrl() {
        return getUrl(httpHost);
    }

    public String getUrl(String host) {
        StringBuffer sb = new StringBuffer();
        sb.append(host);
        Set keys = parameters.keySet();
        Iterator it = keys.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            if (o != null) {
                if (parameters.get(o) != null) {
                    sb.append(o);
                    sb.append("=");
                    try {
                        String s = (String) parameters.get(o);
                        s = URLEncoder.encode(s, "utf-8");
                        sb.append(s);
                    } catch (UnsupportedEncodingException nee) {
                        log.error("Fout bij encoding voor het opbouwen van url.", nee);
                    }
                    sb.append("&");
                }
            }
        }
        if (getNameSpaces() != null && getNameSpaces().size() > 0) {
            StringBuffer nsp = new StringBuffer("namespace=");
            Set mapEntries = getNameSpaces().entrySet();
            it = mapEntries.iterator();
            while (it.hasNext()) {
                if (nsp.length()>11) {
                    nsp.append(",");
                }
                Map.Entry me = (Entry) it.next();
                if (!NAMESPACES_NOT_IN_URL.contains(me.getValue().toString().toLowerCase())) {
                    nsp.append("xmlns(");
                    nsp.append(me.getKey());
                    nsp.append("=");
                    nsp.append(me.getValue());
                    nsp.append(")");
                }
            }
            if (nsp.length()>20) {
                sb.append(nsp.toString());
                sb.append("&");
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        } else {
            return null;
        }
    }

    /**
     *
     */
    public String getXMLBody() throws Exception {
        return OgcWfsClient.getRequestBody(this);
    }

    public String getUrlWithNonOGCparams() {
        OGCRequest ogcu = (OGCRequest) this.clone();
        ogcu.removeAllWMSParameters();
        ogcu.removeAllWFSParameters();
        ogcu.setNameSpaces(null);
        return ogcu.getUrl();
    }

    /** Removes a parameter
     *
     * @param param The definition of the param that needs to be removed.
     *
     * @return the param value that is removed or null if the parameter key not is found
     */
    public String removeParameter(String param) {
        if (param == null) {
            return null;
        }
        param = param.toUpperCase();
        Object o = parameters.remove(param);
        if (o == null) {
            return null;
        }
        return (String) o;
    }

    /**Return the value of the given param
     * @param param the param definition
     *
     * @return the value of the given param or null if the param isn't found.
     */
    public final String getParameter(String param) {
        if (param == null) {
            return null;
        }
        param = param.toUpperCase();
        Object o = parameters.get(param);
        if (o == null) {
            return null;
        }
        return (String) o;
    }

    public final boolean containsParameter(String param) {
        if (param == null) {
            return false;
        }

        param = param.toUpperCase();
        return parameters.containsKey(param);
    }

    /*Returns all nonOGC params
     */
    public HashMap getNonOGCParameters() {
        OGCRequest o = (OGCRequest) this.clone();
        o.removeAllWFSParameters();
        o.removeAllWMSParameters();
        return o.getParameters();
    }

    /** Adds or replaces a param with a value
     *
     * @param param The definition of the param that needs to be added or replaced.
     * @param value The value that needs to be added
     *
     * @return previous value associated with specified param, or null  if there was no mapping for param
     */
    public String addOrReplaceParameter(String param, String v) {
        String value;
        try {
            if (v != null) {
                value = URLDecoder.decode(v, "UTF-8");
            } else {
                value = v;
            }
        } catch (UnsupportedEncodingException ex) {
            value = v;
            log.error("Error decoding value. Try with the original value", ex);
        }
        if (param == null) {
            return null;
        }
        param = param.toUpperCase();
        Object o = parameters.get(param);
        if (value != null) {
            value = value.trim();
        }
        if (WFS_PARAM_TYPENAME.equals(param)) {
            value = fixNsPrefix(value);
        }
        parameters.put(param, value);
        if (o == null) {
            return null;
        }
        return (String) o;
    }

    /** Adds or replaces a string with params
     *
     * @param params A String with parameters seperated by a '&'
     *
     *
     * @return the number of added params
     */
    public int addOrReplaceParameters(String params) {
        if (params == null) {
            return 0;
        }
        String tokens[] = params.split("&");
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].contains("=")) {
                String keyValuePair[] = tokens[i].split("=");
                if (keyValuePair.length > 2) {
                    String value = "";
                    for (int b = 1; b < keyValuePair.length; b++) {
                        if (b != 1) {
                            value += "=";
                        }
                        value += keyValuePair[b];
                    }
                    addOrReplaceParameter(keyValuePair[0], value);
                } else if (keyValuePair.length == 2) {
                    addOrReplaceParameter(keyValuePair[0], keyValuePair[1]);
                } else {
                    addOrReplaceParameter(keyValuePair[0], null);
                }
            }
        }
        return tokens.length;
    }

    /** Removes all WMS parameters (version 1.1.1)
     *
     */
    public void removeAllWMSParameters() {
        removeParameter(WMS_PARAM_BBOX);
        removeParameter(WMS_PARAM_TRANSPARENT);
        removeParameter(WMS_PARAM_FORMAT);
        removeParameter(WMS_PARAM_INFO_FORMAT);
        removeParameter(WMS_PARAM_LAYERS);
        removeParameter(WMS_PARAM_QUERY_LAYERS);
        removeParameter(WMS_PARAM_WIDTH);
        removeParameter(WMS_PARAM_HEIGHT);
        removeParameter(WMS_PARAM_FEATURECOUNT);
        removeParameter(WMS_PARAM_X);
        removeParameter(WMS_PARAM_Y);
        removeParameter(WMS_VERSION);
        removeParameter(WMS_REQUEST);
        removeParameter(WMS_PARAM_STYLES);
        removeParameter(WMS_PARAM_SRS);
        removeParameter(WMS_PARAM_BGCOLOR);
        removeParameter(WMS_PARAM_EXCEPTIONS);
        removeParameter(WMS_PARAM_TIME);
        removeParameter(WMS_PARAM_ELEVATION);
        removeParameter(WMS_PARAM_SLD);
        removeParameter(WMS_PARAM_WFS);
        removeParameter(WMS_SERVICE);
        removeParameter(WMS_PARAM_LAYER);
    }

    /** Removes all WFS parameters (version 1.0.0???)
     *
     */
    public void removeAllWFSParameters() {
        /*TODO: misschien niet allwmsparameters verwijderen maar hier alle wfs params defineren.*/
        removeAllWMSParameters();
        removeParameter(WFS_PARAM_OUTPUTFORMAT);
        removeParameter(WFS_PARAM_TYPENAME);
        removeParameter(WFS_PARAM_RESULTTYPE);
        removeParameter(WFS_PARAM_PROPERTYNAME);
        removeParameter(WFS_PARAM_FEATUREVERSION);
        removeParameter(WFS_PARAM_MAXFEATURES);
        removeParameter(WFS_PARAM_EXPIRY);
        removeParameter(WFS_PARAM_SRSNAME);
        removeParameter(WFS_PARAM_FEATUREID);
        removeParameter(WFS_PARAM_FILTER);
        removeParameter(WFS_PARAM_SORTBY);
        removeParameter(WFS_PARAM_TRAVERSEXLINKDEPTH);
        removeParameter(WFS_PARAM_TRAVERSEXLINKEXPIRY);
        removeParameter(WFS_PARAM_PROPTRAVXLINKEXPIRY);
        removeParameter(WFS_PARAM_PROPTRAVXLINKDEPTH);
        removeParameter(WFS_PARAM_GMLOBJECTID);
        removeParameter(WFS_PARAM_RESULTTYPE);
        removeParameter(WFS_PARAM_BBOX);
        removeParameter(WFS_PARAM_INPUTFORMAT);
        removeParameter(WFS_PARAM_HANDLE);
        removeParameter(WFS_PARAM_LOCKID);
        removeParameter(WFS_PARAM_RELEASEACTION);
    }

    @Override
    public String toString() {
        return this.getUrl();
    }

    public String[] getParametersArray() {
        if (parameters == null) {
            return null;
        }
        String[] returnvalue = new String[parameters.size()];
        Set keys = parameters.keySet();
        Iterator it = keys.iterator();
        for (int i = 0; it.hasNext(); i++) {
            String key = (String) it.next();
            String value = (String) parameters.get(key);
            if (value == null) {
                value = "";
            }
//            try {
            //FIX so get requests will be valid when containing invalid values
//                returnvalue[i] = key + "=" + URLEncoder.encode(value, "UTF-8");
//            } catch (UnsupportedEncodingException e) {
            returnvalue[i] = key + "=" + value;
//            }
        }
        return returnvalue;
    }

    public Object clone() {
        OGCRequest returnv = new OGCRequest();
        if (this.getHttpHost()!=null) {
            returnv.setHttpHost(new String(this.getHttpHost()));
        }
        if (this.getServiceProviderName()!=null) {
            returnv.setServiceProviderName(new String(this.getServiceProviderName()));
        }
        if (this.getPersonalCode()!=null ){
            returnv.setPersonalCode(new String(this.getPersonalCode()));
        }
        if (getPassword() != null) {
            returnv.setPassword(new String(this.getPassword()));
        }
        if (getUsername() != null) {
            returnv.setUsername(new String(this.getUsername()));
        }
        if (this.getFinalVersion() != null) {
            returnv.setFinalVersion(new String(this.getFinalVersion()));
        }
        if (this.getParameters() != null) {
            returnv.setParameters((HashMap) this.getParameters().clone());
        }
        if (this.getNameSpaces() != null) {
            returnv.setNameSpaces((HashMap) this.getNameSpaces().clone());
        }
        if (this.getSchemaLocations() != null) {
            returnv.setSchemaLocations((HashMap) this.getSchemaLocations().clone());
        }
        if (this.getTransactionMap() != null) {
            returnv.setTransactionMap((HashMap) this.getTransactionMap().clone());
        }
        if (this.getAbbr() != null) {
            returnv.setAbbr(new String(this.getAbbr()));
        }

        if (this.getHttpMethod() != null) {
            returnv.setHttpMethod(new String(this.getHttpMethod()));
        }

        if (this.getCapabilities() != null) {
            returnv.setCapabilities(this.getCapabilities());
        }
        if (this.getGetFeatureFilterMap() != null) {
            returnv.setGetFeatureFilterMap((HashMap) this.getGetFeatureFilterMap().clone());
        }
        if (this.getGetFeaturePropertyNameListMap() != null) {
            returnv.setGetFeaturePropertyNameListMap((HashMap) this.getGetFeaturePropertyNameListMap().clone());
        }
        if (this.getLayers() != null) {
            returnv.setLayers((ArrayList) this.getLayers().clone());
        }

        if (this.getNameSpaces() != null) {
            returnv.setNameSpaces((HashMap) this.getNameSpaces().clone());
        }
        if (this.getSchemaLocations() != null) {
            returnv.setSchemaLocations((HashMap) this.getSchemaLocations().clone());
        }
        
        return returnv;
    }

//    public String getHost() {
//        return getHttpHost();
//    }
//
    public String getHttpHost() {
        return this.httpHost;
    }
    
    public void setHttpHost(String host) {
        this.httpHost = host;
    }

    public String fixHttpHost(String httpHost) {
        if (httpHost.indexOf('?') < 0) {
            return httpHost + "?";
        } else if (httpHost.indexOf('?') == httpHost.length() - 1) {
            return httpHost;
        } else if (httpHost.lastIndexOf('&') == httpHost.length() - 1) {
            return httpHost;
        } else {
            return httpHost + "&";
        }
    }

    /**
     * uitzoeken of de serviceprovider in de url zit, geldige patronen zijn:
     * <li>http://server/services/sp/pcode
     * <li>http://server/services/sp/pcode/
     * <li>http://server/services/pcode
     * <li>http://server/services/pcode/
     *
     * ongeldig zijn:
     * <li>http://server/services/sp/
     * <li>http://server/services/sp
     *
     * sp wordt als code geinterpreteerd.
     */
    public static String[] findServiceProviderNameAndPersonalCode(String httpHost) {
        String[] spPc = new String[]{null, null};
        if (httpHost==null) {
            return spPc;
        }
        String realHost = httpHost;
        String[] tmp = httpHost.split("\\?|&");
        if (tmp.length > 0) {
            realHost = tmp[0];
        }
        String[] parts = realHost.split("/services/");
        if (parts.length > 1) {
            parts = parts[1].split("/");
            // {"sp","pcode"} of {"pcode"}
            if (parts.length > 1) {
                spPc[0] = parts[0];
                spPc[1] = parts[1];
            } else if (parts.length == 1) {
                spPc[1] = parts[0];
            }
        }
        return spPc;
    }

    public static String findServiceProviderName(String httpHost) {
        return findServiceProviderNameAndPersonalCode(httpHost)[0];
    }

    public static String findPersonalCode(String httpHost) {
        return findServiceProviderNameAndPersonalCode(httpHost)[1];
    }

    public void setServiceProviderName(String sp) {
        this.serviceProviderName = sp;
    }

    public String getServiceProviderName() {
        return this.serviceProviderName;
    }

    /**
     * @return the personalCode
     */
    public String getPersonalCode() {
        return personalCode;
    }

    /**
     * @param personalCode the personalCode to set
     */
    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    /**
     * @param method - the HTTP method of the request (GET/POST/etc)
     */
    public void setHttpMethod(String method) {
        this.httpMethod = method;
    }

    /**
     * @return http method (GET/POST/etc)
     */
    public String getHttpMethod() {
        return this.httpMethod;
    }

    protected HashMap getParameters() {
        return parameters;
    }

    protected void setParameters(HashMap parameters) {
        this.parameters = parameters;
    }

    public void checkRequestURL() throws Exception {
        if (parameters == null) {
            throw new UnsupportedOperationException("No parameters found in url!");
        }
        String service = null;
        if (containsParameter(SERVICE)) {
            service = getParameter(SERVICE);
            if (service == null || service.equals("")) {
                throw new UnsupportedOperationException("Empty service parameter found in url!");
            }
            if (service.equalsIgnoreCase(NONOGC_SERVICE_METADATA)) {
                checkRequestURL(REQUIRED_PARAMS_METADATA, service);
                return;
            } else if (service.equalsIgnoreCase(NONOGC_SERVICE_PROXY)) {
                checkRequestURL(REQUIRED_PARAMS_PROXY, service);
                return;
            }
        }

        if (containsParameter(REQUEST)) {
            String request = getParameter(OGCConstants.REQUEST);
            if (request == null || request.equals("")) {
                throw new UnsupportedOperationException("Empty request parameter found in url!");
            }

            //Only Capabilities request require service param, which should be
            //checked by checkRequestUrl(requiredParams, request).
            //Server may erroneously require service param (http://trac.osgeo.org/mapserver/ticket/2737),
            //but Kaartenbalie shouldn't need it.
            List requiredParams = null;
            if (request.equals(WMS_REQUEST_GetCapabilities) && 
                    (OGCConstants.WMS_SERVICE_WMS.equalsIgnoreCase(service) || service == null) ) {
                requiredParams = REQUIRED_PARAMS_GetCapabilities;
            } else if (request.equals(WMS_REQUEST_GetMap)) {
                requiredParams = PARAMS_GetMap;
            } else if (request.equals(WMS_REQUEST_GetFeatureInfo)) {
                requiredParams = PARAMS_GetFeatureInfo;
            } else if (request.equals(WMS_REQUEST_GetLegendGraphic)) {
                requiredParams = PARAMS_GetLegendGraphic;
            } else if (request.equals(WMS_REQUEST_DescribeLayer)) {
                requiredParams = PARAMS_DescribeLayer;
            } else if (service.equalsIgnoreCase(OGCConstants.WFS_SERVICE_WFS) && request.equals(WFS_REQUEST_GetCapabilities)) {
                requiredParams = WFS_REQUIRED_PARAMS_GetCapabilities;
            } else if (request.equals(WFS_REQUEST_GetFeature)) {
                requiredParams = WFS_REQUIRED_PARAMS_GetFeature;
            } else if (request.equals(WFS_REQUEST_DescribeFeatureType)) {
                requiredParams = WFS_REQUIRED_PARAMS_DescribeFeatureType;
            } else if (request.equals(WFS_REQUEST_Transaction)) {
                requiredParams = WFS_REQUIRED_PARAMS_Transaction;
//            } else if (request.equalsIgnoreCase(WFS_REQUEST_GetFeatureWithLock)) {
//                throw new UnsupportedOperationException("Request '" + request + "' not supported!");
//            } else if (request.equalsIgnoreCase(WFS_REQUEST_LockFeature)) {
//                throw new UnsupportedOperationException("Request '" + request + "' not supported!");
            } else {
                throw new UnsupportedOperationException("Request '" + request + "' not supported! Use GetCapabilities request to "
                        + "get the list of supported functions.");
            }
            checkRequestURL(requiredParams, request);

        } else {
            throw new UnsupportedOperationException("No request parameter found!");
        }
    }

    protected void checkRequestURL(List requiredParams, String request) throws Exception {
        StringBuffer reason = new StringBuffer();
        if (parameters == null || requiredParams == null || (parameters.isEmpty() && !requiredParams.isEmpty())) {
            reason.append("Not all parameters for request '");
            reason.append(request);
            reason.append("' are available.");
            throw new UnsupportedOperationException(reason.toString());
        }

        Iterator it = requiredParams.iterator();
        while (it.hasNext()) {
            String parameter = (String) it.next();
            if (!parameters.containsKey(parameter)) {
                if (parameter.equalsIgnoreCase(WFS_PARAM_TYPENAME)) {
                    if (getFeatureFilterMap != null && !getFeatureFilterMap.isEmpty()) {
                        continue;
                    }
                }                
                reason.append("Not all parameters for request '");
                reason.append(request);
                reason.append("' are available, missing parameter: ");
                reason.append(parameter);
                reason.append(".");
                throw new UnsupportedOperationException(reason.toString());
            }
        }

        //Alle parameter keys zijn wel aanwezig, test nu op waarden
        it = requiredParams.iterator();
        while (it.hasNext()) {
            String parameter = (String) it.next();
            if (!parameter.equalsIgnoreCase(WMS_PARAM_STYLES) &&
                    !parameter.equalsIgnoreCase(WFS_PARAM_TYPENAME)) {
                if (this.getParameter(parameter) == null) {
                    reason.append("Value for parameter ");
                    reason.append(parameter);
                    reason.append(" is missing.");
                    throw new UnsupportedOperationException(reason.toString());
                }
            }
        }
    }

    public WFS_Capabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(WFS_Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    /*
     * Get and set for final version. This is the version the server will use to give a response
     * to the request of te client. It doesn't have to be the same version as the client requested.
     * See paragraph 6.2 of the WFS 1.1.0 specification for more details.
     */
    public final void setFinalVersion(String clientVersion) {
        if (clientVersion == null || clientVersion.equals("")
                || clientVersion.equals(OGCConstants.WFS_VERSION_UNSPECIFIED)) {
            finalVersion = OGCConstants.WFS_VERSION_UNSPECIFIED;
        } else if (OGCConstants.SUPPORTED_WFS_VERSIONS.contains(clientVersion)) {
            finalVersion = clientVersion;
        } else {
            String[] versionArray = clientVersion.split("\\.");
            String newVersion = "";
            for (int i = 0; i < versionArray.length; i++) {
                newVersion = newVersion + versionArray[i];
            }
            if (newVersion == null || newVersion.equals("")) {
                throw new UnsupportedOperationException("The version number was incorrect!");
            }
            int version = Integer.parseInt(newVersion);

            List suportedVersions = OGCConstants.SUPPORTED_WFS_VERSIONS;
            int versionSize = suportedVersions.size();
            int[] suportedVersionsInt = new int[versionSize];
            for (int x = 0; x < versionSize; x++) {
                String[] suportedArray = suportedVersions.get(x).toString().split("\\.");
                String tempversion = "";
                for (int y = 0; y < suportedArray.length; y++) {
                    tempversion = tempversion + suportedArray[y];
                }
                suportedVersionsInt[x] = Integer.parseInt(tempversion);
            }

            int lowestVersion = suportedVersionsInt[0];
            for (int z = 0; z < suportedVersionsInt.length; z++) {
                if (lowestVersion > suportedVersionsInt[z]) {
                    lowestVersion = suportedVersionsInt[z];
                }
            }
            if (version > lowestVersion) {
                for (int b = 0; b < suportedVersionsInt.length; b++) {
                    if (version > suportedVersionsInt[b]) {
                        if (lowestVersion < suportedVersionsInt[b]) {
                            lowestVersion = suportedVersionsInt[b];
                        }
                    }
                }
                if (lowestVersion == 110) {
                    finalVersion = OGCConstants.WFS_VERSION_110;
                } else if (lowestVersion == 100) {
                    finalVersion = OGCConstants.WFS_VERSION_100;
                }
            } else if (version < lowestVersion) {
                if (lowestVersion == 110) {
                    finalVersion = OGCConstants.WFS_VERSION_110;
                } else if (lowestVersion == 100) {
                    finalVersion = OGCConstants.WFS_VERSION_100;
                }
            }
        }
    }
    
    public final static HashMap scaleCalibrations = new HashMap();

    static {
        // defaultPixelsPerMeter = 3272, 3384: mattserver/Map.C, 3488: dcw
        scaleCalibrations.put("EPSG:28992", new Double(3272));
        // defaultPixelsPerlatLonDegree = 284479860
        scaleCalibrations.put("EPSG:4326", new Double(284479860));
        // TODO andere omrekenfactor toevoegen!
    }

    public double calcScale() {
        String projection = (String) parameters.get(WMS_PARAM_SRS);
        if (projection == null) {
            return 0.0;
        }
        Double scaleCalibration = (Double) scaleCalibrations.get(projection);
        if (scaleCalibration != null) {
            return calcScale(scaleCalibration.doubleValue());
        }
        return 0.0;
    }

    /**
     * Deze methode berekent de schaal waarbij de diagonaal van de viewport in
     * pixels wordt omgerekend naar kaarteenheden.
     *
     * @param scaleCalibration omrekenfactor van pixels naar kaarteenheden.
     * @return schaal van de kaart
     */
    public double calcScale(double scaleCalibration) {
        double dvm = 0; // diagonaal viewport in kaarteenheden
        try {
            String width = (String) parameters.get(WMS_PARAM_WIDTH);
            String height = (String) parameters.get(WMS_PARAM_HEIGHT);
            double w = Double.parseDouble(width);
            double h = Double.parseDouble(height);
            double d = Math.sqrt(w * w + h * h);
            dvm = d / scaleCalibration;
        } catch (NumberFormatException nfe) {
            log.debug("Fout omrekenen schaal: ", nfe);
            
            return 0.0;
        }
        if (dvm == 0.0) {
            return 0.0;
        }
        String bbox = (String) parameters.get(WMS_PARAM_BBOX);
        if (bbox == null) {
            return 0.0;
        }
        String[] bboxa = bbox.split(",");
        if (bboxa.length != 4) {
            return 0.0;
        }
        double dkm = 0; // diagonaal kaart in kaarteenheden
        try {
            String minx = bboxa[0];
            String maxx = bboxa[2];
            String miny = bboxa[1];
            String maxy = bboxa[3];
            double ix = Double.parseDouble(minx);
            double ax = Double.parseDouble(maxx);
            double iy = Double.parseDouble(miny);
            double ay = Double.parseDouble(maxy);
            dkm = Math.sqrt((ax - ix) * (ax - ix) + (ay - iy) * (ay - iy));
        } catch (NumberFormatException nfe) {
            log.debug("Fout omrekenen schaal: ", nfe);
            
            return 0.0;
        }

        return dkm / dvm;
    }


    public String getFinalVersion() {
        return finalVersion;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param layers the layers to set
     */
    public void setLayers(ArrayList layers) {
        this.layers = layers;
    }

}
