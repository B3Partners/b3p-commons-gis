/*
 * B3P Commons GIS is a library with commonly used classes for OGC
 * reading and writing. Included are wms, wfs, gml, csv and other
 * general helper classes and extensions.
 *
 * Copyright 2005 - 2013 B3Partners BV
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
 * OGCCommunication.java
 *
 * Created on 11-10-2013
 *
 * Superklasse van OGCRequest.java en OGCResponse.java
 */
package nl.b3p.ogc.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.NamespaceContext;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Chris van Lith
 */
public class OGCCommunication implements OGCConstants {

    protected HashMap nameSpaces;
    protected HashMap schemaLocations;

    
    public void addOrReplaceNameSpace(String prefix, String nsUrl) {
        if (prefix != null && nsUrl != null) {
            if (nameSpaces == null) {
                addOpengisNamespaces();
            }
            nameSpaces.put(prefix, nsUrl);
        }
    }
    
    public final void findNameSpace(Node node) {
        NamedNodeMap map = node.getAttributes();
        if (map != null) {
            for (int i = 0; map.getLength() > i; i++) {
                String value = map.item(i).getNodeValue();
                if (value == null || value.length() == 0) {
                    continue;
                }
                String name = map.item(i).getNodeName();
                String[] tokens = name.split(":");
                if (tokens[0].equalsIgnoreCase("xmlns")) {
                    if (tokens.length > 1) {
                        addOrReplaceNameSpace(tokens[1], value);
                    } else {
                        // namespace context kent een default ns
                        addOrReplaceNameSpace("", value);
                    }
                } else if (tokens.length == 2) {
                    if (tokens[1].equalsIgnoreCase("SchemaLocation")) {
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

    protected void addOrReplaceSchemaLocation(String prefix, String location) {
        if (prefix != null && location != null) {
            if (schemaLocations == null) {
                addOpengisSchemaLocations();
            }
            schemaLocations.put(prefix, location);
        }
    }

    protected final void setNameSpaces(HashMap nameSpaces) {
        this.nameSpaces = nameSpaces;
    }

    protected HashMap getNameSpaces() {
        return nameSpaces;
    }

    /**
     * @return the schemaLocations
     */
    protected HashMap getSchemaLocations() {
        return schemaLocations;
    }

    /**
     * @param schemaLocations the schemaLocations to set
     */
    protected final void setSchemaLocations(HashMap schemaLocations) {
        this.schemaLocations = schemaLocations;
    }

    protected String getNameSpace(String param) {
        if (param == null || nameSpaces == null) {
            return null;
        }
        return (String) nameSpaces.get(param);
    }

    public String getNameSpacePrefix(String namespaceUrl) {
        if (nameSpaces == null || nameSpaces.isEmpty()) {
            return null;
        }
        for (Iterator iterator = nameSpaces.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry entry = (Map.Entry) iterator.next();
            if (entry.getValue().equals(namespaceUrl)) {
                return (String) entry.getKey();
            }
        }
        //als namespace nog niet is toegevoegd
        String prefix = null;
        int nsTeller = 1;
        //kijk of de namespace prefix al bestaat anders ophogen en nogmaals proberen
        String ns = getNameSpace("ns" + nsTeller);
        while (ns != null) {
            nsTeller++;
            ns = getNameSpace("ns" + nsTeller);
        }
        prefix = "ns" + nsTeller;
        addOrReplaceNameSpace(prefix, namespaceUrl);
        return prefix;
    }
    
    protected String[] getNameSpacesArray() {
        if (nameSpaces == null) {
            return null;
        }
        String[] returnvalue = new String[nameSpaces.size()];
        Set keys = nameSpaces.keySet();
        Iterator it = keys.iterator();
        for (int i = 0; it.hasNext(); i++) {
            String prefix = (String) it.next();
            String location = (String) nameSpaces.get(prefix);
            returnvalue[i] = "xmlns:" + prefix + "=\"" + location + "\"";
        }
        return returnvalue;
    }

    protected String[] getSchemaLocationsArray() {
        if (schemaLocations == null) {
            return null;
        }
        String[] returnvalue = new String[schemaLocations.size()];
        Set keys = schemaLocations.keySet();
        Iterator it = keys.iterator();
        for (int i = 0; it.hasNext(); i++) {
            String prefix = (String) it.next();
            String location = (String) schemaLocations.get(prefix);
            returnvalue[i] = prefix + ":schemaLocation=\"" + location + "\"";
        }
        return returnvalue;
    }

    /**
     * Adds all namespaces needed for OpenGis
     */
    protected final void addOpengisNamespaces() {
        if (nameSpaces == null) {
            nameSpaces = new HashMap();
        }
        if (!nameSpaces.containsKey("wfs")) {
            addOrReplaceNameSpace("wfs", "http://www.opengis.net/wfs");
        }
        if (!nameSpaces.containsKey("xsi")) {
            addOrReplaceNameSpace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        }
        if (!nameSpaces.containsKey("gml")) {
            addOrReplaceNameSpace("gml", "http://www.opengis.net/gml");
        }
        if (!nameSpaces.containsKey("ogc")) {
            addOrReplaceNameSpace("ogc", "http://www.opengis.net/ogc");
        }
        if (!nameSpaces.containsKey("ows")) {
            addOrReplaceNameSpace("ows", "http://www.opengis.net/ows");
        }
    }

    /**
     * Adds all Schemalocations needed for OpenGis
     */
    protected final void addOpengisSchemaLocations() {
        if (schemaLocations == null) {
            schemaLocations = new HashMap();
        }
        if (!schemaLocations.containsKey("xsi")) {
            // cvl: uitgezet want wfs 1.0.0 en 1.1.0 hebben zelfde url
            // addOrReplaceSchemaLocation("xsi", "http://www.opengis.net/wfs ../wfs/1.1.0/WFS.xsd");
        }
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
    
    public LayerSummary splitLayerInParts(String fullLayerName) throws Exception {
        return splitLayerInParts(fullLayerName, true, null, null);
    }
    
    public static LayerSummary splitLayerWithoutNsFix(String fullLayerName) throws Exception {
        return splitLayerWithoutNsFix(fullLayerName, true, null, null);
    }

   
    public LayerSummary splitLayerInParts(String fullLayerName, boolean splitName, String defaultSp, String defaultNs) throws Exception {
        LayerSummary m = splitLayerWithoutNsFix(fullLayerName, splitName, defaultSp, defaultNs);
        String tPrefix = m.getPrefix();
        String tNsUrl = m.getNsUrl();
        if (tNsUrl!= null && !tNsUrl.isEmpty()) {
            tPrefix = getNameSpacePrefix(tNsUrl);
            m.setPrefix(tPrefix);
        } else if (tPrefix!= null && !tPrefix.isEmpty()) {
            tNsUrl = getNameSpace(tPrefix);
            m.setNsUrl(tNsUrl);
        }
       return m;
    }

    /**
     * parse full name of layer, use splitName boolean to parse layernames
     * known to not have a service provider in the name to prevend problems
     * with underscores in names.
     * 
     * <li>{ns-uri}sp_layername
     * <li>{ns-uri}layername (no service provider)
     * <li>ns:layername (no service provider)
     * <li>sp_ns:layername
     * <li>sp_layername (no name space)
     * <li>layername (no service provider and name space)
     * 
     * @param fullLayerName
     * @param splitName try to split out service provider 
     * @return
     * @throws Exception 
     */
    public static LayerSummary splitLayerWithoutNsFix(String fullLayerName, boolean splitName) throws Exception {
        return splitLayerWithoutNsFix(fullLayerName, splitName, null, null);
    }
    
    public static LayerSummary splitLayerWithoutNsFix(String fullLayerName, boolean splitName, String defaultSp, String defaultNs) throws Exception {
        String tPrefix = null;
        String tLayerName = null;
        String tSpAbbr = null;
        String tSpLayerName = null;
        String tNsUrl = null;
        
        if (fullLayerName == null) {
            return null;
        }
        String[] temp = fullLayerName.split("}");
        if (temp.length > 1) {
            tSpLayerName = temp[1];
            int index1 = fullLayerName.indexOf("{");
            int index2 = fullLayerName.indexOf("}");
            tNsUrl = fullLayerName.substring(index1 + 1, index2);
        } else {
            String temp2[] = temp[0].split(":");
            if (temp2.length > 1) {
                tSpLayerName = temp2[1];
                tPrefix = temp2[0];
            } else {
                tSpLayerName = fullLayerName;
            }
        }

        tLayerName = tSpLayerName;
        if (splitName || 
                    tSpLayerName.startsWith(KBConfiguration.SERVICEPROVIDER_BASE_ABBR + "_")) {
            int index1 = tSpLayerName.indexOf("_");
            if (index1 != -1) {
                tSpAbbr = tSpLayerName.substring(0, index1);
                tLayerName = tSpLayerName.substring(index1 + 1);
            }
        }
        
        if (tLayerName.isEmpty()) {
            throw new Exception(KBConfiguration.REQUEST_LAYERNAME_EXCEPTION + ": " + tLayerName);
        }

        if (defaultSp!=null && tSpAbbr==null) {
            tSpAbbr = defaultSp;
        }
        if (defaultNs!=null && tPrefix==null) {
            tPrefix = defaultNs;
        }
        
        LayerSummary returnMap = new LayerSummary();
        returnMap.setPrefix(tPrefix);
        returnMap.setSpAbbr(tSpAbbr);
        returnMap.setLayerName(tLayerName);
        returnMap.setNsUrl(tNsUrl);
        return returnMap;
    }
    
    /**
     * methode splitst lange layer naam volgens abbr_layer in een service provider
     * deel (layerCode genoemd) en een echte layer naam (layerName)
     * <p>
     * @param completeLayerName lange layer naam
     * @return straing array met 2 strings: abbr en layer
     * @throws java.lang.Exception fout in format lange layer naam
     */
    public static String[] toCodeAndName(String completeLayerName) throws Exception {
         
        LayerSummary m = splitLayerWithoutNsFix(completeLayerName);
        if (m==null) {
            return null;
        }
        String layerCode = m.getSpAbbr();
        // plak de oorspronkelijke ns weer aan de kaartlaag indien van toepassing
        String layerName = buildLayerNameWithoutSp(m);
        return new String[]{layerCode, layerName};
    }
    
    public static String getLayerName(String ln) {
        try {
            LayerSummary m = splitLayerWithoutNsFix(ln);
            return buildLayerNameWithoutNs(m);
        } catch (Exception ex) {
            // uitzoeken of deze niet gewoon gegooid kan worden
        }
        return null;
    }

    static public String attachSp(String sp, String l) {
        try {
            LayerSummary m = splitLayerWithoutNsFix(l, false, sp, null);
            return buildFullLayerName(m);
        } catch (Exception ex) {
            // uitzoeken of deze niet gewoon gegooid kan worden
        }
        return null;
    }

    static public String attachSpNs(String sp, String l, String ns) {
        if (l == null || l.isEmpty()) {
            return null;
        }
        if (sp == null || sp.isEmpty()) {
            if (ns == null || ns.isEmpty()) {
                return l;
            } else {
                return ns + ":" + l;
            }
        }
        if (ns == null || ns.isEmpty()) {
            return sp + "_" + l;
        } else {
            return ns + ":" + sp + "_" + l;
        }
    }
    
    public static String buildFullLayerName(LayerSummary m) {
        String tPrefix = m.getPrefix();
        String tSpAbbr = m.getSpAbbr();
        String tLayerName = m.getLayerName();
        return attachSpNs(tSpAbbr, tLayerName, tPrefix);
    }
    
    public static String buildLayerNameWithoutSp(LayerSummary m) {
        String tPrefix = m.getPrefix();
        String tLayerName = m.getLayerName();
        return attachSpNs(null, tLayerName, tPrefix);
    }

    public static String buildLayerNameWithoutNs(LayerSummary m) {
        String tSpAbbr =  m.getSpAbbr();
        String tLayerName =  m.getLayerName();
        return attachSpNs(tSpAbbr, tLayerName, null);
    }
        
    public static String replaceIds(String originalId, String sp, String ns) {
        if (sp==null) {
            if (ns==null) {
                return originalId;
            } else {
                return ns + ":" + originalId;
            }
        }
        String[] idSplit = originalId.split(sp + "_");
        String newId = "";
        for (int i = 0; i < idSplit.length; i++) {
           newId += idSplit[i];
           if (i < (idSplit.length - 1) && ns!=null) {
                newId += ns + ":";
            }
        }
        return newId;
    }
    
    protected final String stripNs(String key) {
        String[] temp = key.split("}");
        if (temp.length == 2) {
            return temp[1];
        } else {
            return key;
        }
    }
 
    public String fixNsPrefix(String ft) {
        int index1 = ft.indexOf("{");
        int index2 = ft.indexOf("}");
        if (index1 >= 0 && index2 >= 0) {
            String nameSpaceUri = ft.substring(index1 + 1, index2);
            String prefix = getNameSpacePrefix(nameSpaceUri);
            return prefix + ":" + ft.substring(index2 + 1);
        }
        return ft;
    }

    /**
     * This method determines the featureTypeName based on the given layer and
     * prefix. Since the layer contains a {namespaceUrl} in the layer, it first
     * needs to determine the namespace prefix. This value is saved in the
     * featureTypeNamespacePrefix instance variable, for later use.
     *
     * @param prefix
     * @param layer
     * @return
     */
    protected final String determineFeatureTypeName(String spAbbr, String layer) {
        try {
            LayerSummary m = splitLayerInParts(layer, false, spAbbr, null);
            return buildFullLayerName(m);
        } catch (Exception ex) {
            // uitzoeken of deze niet gegooid kan worden
        }
        return null;
    }
    
    protected static String cleanPrefixInBody(String body, String prefix, String nsUrl, String ns) {
        String old = "";
        if (nsUrl != null) {
            old += nsUrl;
        }
        if (prefix != null) {
            old += prefix;
        }
        if (old.length() == 0) {
            return body;
        }
        String nsnew = "";
        if (ns != null) {
            nsnew += ns;
        }
        StringBuffer bBody = new StringBuffer(body);
        for (int start = bBody.indexOf(old); start >= 0;) {
            bBody.replace(start, start + old.length(), nsnew);
        }
        return bBody.toString();
    }

  }
