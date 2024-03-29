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
package nl.b3p.wms.capabilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import nl.b3p.ogc.utils.LayerSummary;
import nl.b3p.ogc.utils.OGCCommunication;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Layer implements XMLElement,Comparable{

    private static final Log log = LogFactory.getLog(Layer.class);
    private Integer id;
    private String name;
    private String title;
    private String abstracts;
    private String queryable = "0";
    private String cascaded = "0";
    private String opaque = "0";
    private String nosubsets = "0";
    private String fixedWidth = "0";
    private String fixedHeight = "0";
    private String scaleHintMin = "0";
    private String scaleHintMax = "0";
    private Attribution attribution;
    private Layer parent;
    private ServiceProvider serviceProvider;
    private Set dimensions;
    private Set keywordList;
    private Set styles;
    private Set domainResource;
    private Set identifiers;
    private Set organizationLayers;
    private Set srsbb;
    private Set layers;
    private String oldMetadata;
    private String metadata;
    private Set layerMetadata;

    // <editor-fold defaultstate="" desc="getter and setter methods.">
    public Integer getId() {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getQueryable() {
        return queryable;
    }

    public void setQueryable(String queryable) {
        this.queryable = queryable;
    }

    public String getCascaded() {
        return cascaded;
    }

    public void setCascaded(String cascaded) {
        this.cascaded = cascaded;
    }

    public String getOpaque() {
        return opaque;
    }

    public void setOpaque(String opaque) {
        this.opaque = opaque;
    }

    public String getNosubsets() {
        return nosubsets;
    }

    public void setNosubsets(String nosubsets) {
        this.nosubsets = nosubsets;
    }

    public String getFixedWidth() {
        return fixedWidth;
    }

    public void setFixedWidth(String fixedWidth) {
        this.fixedWidth = fixedWidth;
    }

    public String getFixedHeight() {
        return fixedHeight;
    }

    public void setFixedHeight(String fixedHeight) {
        this.fixedHeight = fixedHeight;
    }
   //TODO: Waarom is dit geen double??
    public String getScaleHintMin() {
        return scaleHintMin;
    }

    public void setScaleHintMin(String scaleHintMin) {
        this.scaleHintMin = scaleHintMin;
    }
//TODO: Waarom is dit geen double??
    public String getScaleHintMax() {
        return scaleHintMax;
    }

    public void setScaleHintMax(String scaleHintMax) {
        this.scaleHintMax = scaleHintMax;
    }

    public Layer getParent() {
        return parent;
    }

    public void setParent(Layer parent) {
        this.parent = parent;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public Set buildLayerSet(Set layerset, ServiceProvider serviceProvider) throws Exception {
        if (layerset == null) {
            layerset = new HashSet();
        }
        this.serviceProvider = serviceProvider;
        /* TODO: Check op dubbele namen nagaan */
        if (layerset.contains(this) && this.getName()!=null) {
            String msg = "Conflicting layer names: layer to add to set equals layer already in set, layer is not added! ";
            log.error(msg);
            throw new Exception(msg);
        }

        layerset.add(this);

        Set layers = getLayers();
        if (layers == null || layers.isEmpty()) {
            return layerset;
        }
        Iterator it = layers.iterator();
        while (it.hasNext()) {
            Layer subLayer = (Layer) it.next();
            layerset = subLayer.buildLayerSet(layerset, serviceProvider);
        }
        return layerset;
    }

    public Set getDimensions() {
        return dimensions;
    }

    public void setDimensions(Set dimensions) {
        this.dimensions = dimensions;
    }

    public void addDimension(Dimensions dimension) {
        if (dimensions == null) {
            dimensions = new HashSet();
        }
        dimensions.add(dimension);
        dimension.setLayer(this);
    }

    public Set getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(Set keywordList) {
        this.keywordList = keywordList;
    }

    public void addKeyword(String keyword) {
        if (keywordList == null) {
            keywordList = new HashSet();
        }
        keywordList.add(keyword);
    }

    public Set<Style> getStyles() {
        return styles;
    }

    public void setStyles(Set<Style> styles) {
        this.styles = styles;
    }

    public void addStyle(Style style) {
        if (null == styles) {
            styles = new HashSet<Style>();
        }
        styles.add(style);
        style.setLayer(this);
    }

    public Set getDomainResource() {
        return domainResource;
    }

    public void setDomainResource(Set domainResource) {
        this.domainResource = domainResource;
    }

    public void addDomainResource(LayerDomainResource dr) {
        if (null == domainResource) {
            domainResource = new HashSet();
        }
        domainResource.add(dr);
        dr.setLayer(this);
    }

    public Set getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(Set identifiers) {
        this.identifiers = identifiers;
    }

    public void addIdentifier(Identifier identifier) {
        if (null == identifiers) {
            identifiers = new HashSet();
        }
        identifiers.add(identifier);
        identifier.setLayer(this);
    }

    public Set getOrganizationLayers() {
        return organizationLayers;
    }

    public void setOrganizationLayers(Set organizationLayers) {
        this.organizationLayers = organizationLayers;
    }

    public Set getSrsbb() {
        return srsbb;
    }

    public void setSrsbb(Set srsbb) {
        this.srsbb = srsbb;
    }

    public void addSrsbb(SrsBoundingBox s) {
        if (null == srsbb) {
            srsbb = new HashSet();
        }
        srsbb.add(s);
        s.setLayer(this);
    }

    public Set getLayers() {
        return layers;
    }

    public void setLayers(Set layers) {
        this.layers = layers;
    }

    public void addLayer(Layer layer) throws Exception {
        if (layers == null) {
            layers = new HashSet();
        }
        /* TODO: Check op dubbele namen nagaan */
        /* name, title en cascaded moeten uniek zijn binnen siblings */
        if (layers.contains(layer)) {
            String thisLayerDesc = "sp_abbr="
                        + (getServiceProvider() == null ? "(null)" : getServiceProvider().getAbbr())
                        + ", name=" + getName()
                        + ", title=" + getTitle()
                        + ", cascaded=" + getCascaded();
            String layerDesc = "sp_abbr="
                        + (layer.getServiceProvider() == null ? "(null)" : layer.getServiceProvider().getAbbr())
                        + ", name=" + layer.getName()
                        + ", title=" + layer.getTitle()
                        + ", cascaded=" + layer.getCascaded();

            String msg = "Duplicate sibling layer added to parent [" + thisLayerDesc + "]: duplicate [" + layerDesc + "]";

            throw new Exception(msg);
        } else {
            layers.add(layer);
            layer.setParent(this);
        }
    }

    public Layer buildLayerTree(Set layerset) throws Exception {
        // eerst layers verwijderen voor het opnieuw toevoegen
        layers.clear();
        if (layerset == null) {
            return this;
        }
        Integer cId = getId();
        if (cId == null) {
            return this;
        }
        Iterator it = layerset.iterator();
        while (it.hasNext()) {
            Layer layer = (Layer) it.next();
            Layer parent = layer.getParent();
            if (parent == null) {
                continue;
            }
            Integer pId = parent.getId();
            if (pId == null) {
                continue;
            }
            if (cId.intValue() == pId.intValue()) {
                addLayer(layer);
                layer.buildLayerTree(layerset);
            }

        }
        return this;
    }

    public Attribution getAttribution() {
        return attribution;
    }

    public void setAttribution(Attribution attribution) {
        this.attribution = attribution;
        if (null != attribution) {
            attribution.setLayer(this);
        }
    }

    public String getSpAbbr() {
        if (serviceProvider == null) {
            return null;
        }
        return serviceProvider.getAbbr();
    }

    public String getUniqueName() {

        if (this.getName() == null) {
            return null;
        }

        String spAbbrUrl = null;
        if (this.getServiceProvider() != null) {
            spAbbrUrl = this.getServiceProvider().getUrlServiceProvideCode();
        }
        String spAbbr = this.getSpAbbr();
        if (spAbbrUrl != null && spAbbrUrl.equalsIgnoreCase(spAbbr)) {
            return this.getName();
        }

        LayerSummary ls = null;
        try {
            ls = OGCCommunication.splitLayerWithoutNsFix(this.getName(), false, getSpAbbr(), null);
        } catch (Exception ex) {
            return OGCCommunication.attachSp(getSpAbbr(), this.getName());
        }
        return OGCCommunication.buildFullLayerName(ls);
     }


    public String getCompleteTitle(){
        if (getTitle()==null){
            return null;
        }
        LayerSummary ls = null;
        try {
             ls = OGCCommunication.splitLayerWithoutNsFix(getTitle().replace(" ", ""), false, getSpAbbr(), null);
        } catch (Exception ex) {
            return OGCCommunication.attachSp(getSpAbbr(), getTitle().replace(" ", ""));
        }
        return OGCCommunication.buildFullLayerName(ls);

    }

    public String getMetadata() {
        Set<LayerMetadata> metaDataLayers = getLayerMetadata();

        if (metaDataLayers == null || metaDataLayers.isEmpty()) {
            return getOldMetadata();
        }

        for (LayerMetadata lmd : metaDataLayers) {
            if (lmd.getMetadata() != null) {
                return lmd.getMetadata();
            }
        }

        return null;
    }

    public void setMetadata(String metaData) {
        if (metaData != null) {
            Set<LayerMetadata> metaDataLayers = getLayerMetadata();

            if (metaDataLayers.isEmpty()) {
                LayerMetadata lmd = new LayerMetadata();
                lmd.setLayer(this);
                lmd.setMetadata(metaData);
                metaDataLayers.add(lmd);
            } else {

                boolean first = true;
                Iterator<LayerMetadata> iterator = metaDataLayers.iterator();

                while (iterator.hasNext()) {
                    LayerMetadata lmd = iterator.next();
                    if (first) {
                        lmd.setMetadata(metaData);
                        first = false;
                    } else {
                        iterator.remove();
                    }
                }

            }

            this.setOldMetadata(null);
        }
    }

    private String getOldMetadata() {
        return oldMetadata;
    }

    private void setOldMetadata(String oldMetadata) {
        this.oldMetadata = oldMetadata;
    }

    public Set getLayerMetadata() {
        if (layerMetadata==null) {
             layerMetadata = new HashSet();
        }
        return layerMetadata;
    }

    public void setLayerMetadata(Set layerMetadata) {
        this.layerMetadata = layerMetadata;
    }

    // </editor-fold>
    public Set getAuthSubLayersClone(Set authLayerIds) {
        if (authLayerIds == null || authLayerIds.isEmpty()) {
            return null;
        }
        Set subLayers = this.getLayers();
        if (subLayers == null || subLayers.isEmpty()) {
            return null;
        }
        Set authSubLayers = null;
        Iterator it = subLayers.iterator();
        while (it.hasNext()) {
            Layer subLayer = (Layer) it.next();
            Layer subLayerCloned = (Layer) subLayer.clone();
            Set authSubSubLayers = subLayerCloned.getAuthSubLayersClone(authLayerIds);
            // niet toevoegen indien deze layer en alle sublayers niet toegankelijk
            boolean layerAuthorized = authLayerIds.contains(subLayer.getId());
            if (!layerAuthorized && (authSubSubLayers == null || authSubSubLayers.isEmpty())) {
                continue;
            }
            subLayerCloned.setLayers(authSubSubLayers);
            // layer alleen als placeholder indien niet toegankelijk maar wel toegankelijke sublayers heeft
            if (!layerAuthorized) {
                subLayerCloned.setName(null);
            } else {
                log.debug("layer authorized, name: " + subLayerCloned.getUniqueName());
            }
            if (authSubLayers == null) {
                authSubLayers = new HashSet();
            }
            authSubLayers.add(subLayerCloned);
        }
        return authSubLayers;
    }

    /** Method that will overwrite the URL's stored in the database with the URL specified for Kaartenbalie.
     * This new URL indicate the link to the kaartenbalie, while the old link is used to indicate the URL
     * to the real location of the service. Because the client which is connected to kaartenbalie has to send
     * his requests back to kaartenbalie and not directly to the official resource, the URL has to be replaced.
     *
     * @param newUrl String representing the URL the old URL has to be replaced with.
     */
    // <editor-fold defaultstate="" desc="convertValues2KB(String newUrl) method">
    protected void convertValues2KB(HashMap conversionValues) {
        conversionValues.put("layerName", this.getName());
        ServiceProvider sp = this.getServiceProvider();
        if (sp!=null) {
            conversionValues.put("spAbbr", sp.getAbbr());
        }
        Iterator it;
        //Layers:
        if (null != this.getLayers() && this.getLayers().size() != 0) {
            it = this.getLayers().iterator();
            while (it.hasNext()) {
                Layer l = (Layer) it.next();
                l.convertValues2KB(conversionValues);
            }
        }

        //LayerDomainResource:
        if (null != domainResource) {
            it = domainResource.iterator();
            while (it.hasNext()) {
                LayerDomainResource ldr = (LayerDomainResource) it.next();
                ldr.convertValues2KB(conversionValues);
            }
        }

        //Styles:
        if (null != this.getStyles() && this.getStyles().size() != 0) {
            it = styles.iterator();
            while (it.hasNext()) {
                Style style = (Style) it.next();
                style.convertValues2KB(conversionValues);
            }
        }
    }
    // </editor-fold>
    /** Method that will create a deep copy of this object.
     *
     * @return an object of type Object
     */
    // <editor-fold defaultstate="" desc="clone() method">
    public Object clone() {
        Layer cloneLayer = new Layer();

        // voeg een lichte copy van de serviceprovider toe om
        // later een unieke naam te kunnen maken.
        ServiceProvider sp = this.getServiceProvider();
        if (sp != null) {
            ServiceProvider cloneSp = sp.shallowClone();
            cloneLayer.setServiceProvider(cloneSp);
        }

        if (null != this.id) {
            cloneLayer.id = new Integer(this.id.intValue());
        }
        if (null != this.name) {
            cloneLayer.name = new String(this.name);
        }
        if (null != this.title) {
            cloneLayer.title = new String(this.title);
        }
        if (null != this.abstracts) {
            cloneLayer.abstracts = new String(this.abstracts);
        }
        if (null != this.queryable) {
            cloneLayer.queryable = new String(this.queryable);
        }
        if (null != this.cascaded) {
            cloneLayer.cascaded = new String(this.cascaded);
        }
        if (null != this.opaque) {
            cloneLayer.opaque = new String(this.opaque);
        }
        if (null != this.nosubsets) {
            cloneLayer.nosubsets = new String(this.nosubsets);
        }
        if (null != this.fixedWidth) {
            cloneLayer.fixedWidth = new String(this.fixedWidth);
        }
        if (null != this.fixedHeight) {
            cloneLayer.fixedHeight = new String(this.fixedHeight);
        }
        if (null != this.scaleHintMin) {
            cloneLayer.scaleHintMin = new String(this.scaleHintMin);
        }
        if (null != this.scaleHintMax) {
            cloneLayer.scaleHintMax = new String(this.scaleHintMax);
        }
        if (null != this.attribution) {
            cloneLayer.attribution = (Attribution) this.attribution.clone();
            cloneLayer.attribution.setLayer(cloneLayer);
        }
        if (null != this.dimensions) {
            cloneLayer.dimensions = new HashSet();
            Iterator it = this.dimensions.iterator();
            while (it.hasNext()) {
                Dimensions dim = (Dimensions) ((Dimensions) it.next()).clone();
                dim.setLayer(cloneLayer);
                cloneLayer.dimensions.add(dim);
            }
        }
        if (null != this.keywordList) {
            cloneLayer.keywordList = new HashSet(this.keywordList);
        }
        if (null != this.styles) {
            cloneLayer.styles = new HashSet();
            Iterator it = this.styles.iterator();
            while (it.hasNext()) {
                Style style = (Style) ((Style) it.next()).clone();
                style.setLayer(cloneLayer);
                cloneLayer.styles.add(style);
            }
        }
        if (null != this.domainResource) {
            cloneLayer.domainResource = new HashSet();
            Iterator it = this.domainResource.iterator();
            while (it.hasNext()) {
                LayerDomainResource ldr = (LayerDomainResource) ((LayerDomainResource) it.next()).clone();
                ldr.setLayer(cloneLayer);
                cloneLayer.domainResource.add(ldr);
            }
        }
        if (null != this.identifiers) {
            cloneLayer.identifiers = new HashSet();
            Iterator it = this.identifiers.iterator();
            while (it.hasNext()) {
                Identifier identifier = (Identifier) ((Identifier) it.next()).clone();
                identifier.setLayer(cloneLayer);
                cloneLayer.identifiers.add(identifier);
            }
        }
        if (null != this.organizationLayers) {
            cloneLayer.organizationLayers = new HashSet(this.organizationLayers);
        }
        if (null != srsbb) {
            cloneLayer.srsbb = new HashSet();
            Iterator it = srsbb.iterator();
            while (it.hasNext()) {
                SrsBoundingBox s = (SrsBoundingBox) ((SrsBoundingBox) it.next()).clone();
                s.setLayer(cloneLayer);
                cloneLayer.srsbb.add(s);
            }
        }
        if (null != this.layers) {
            cloneLayer.layers = new HashSet();
            Iterator it = this.layers.iterator();
            while (it.hasNext()) {
                Layer layer = (Layer) ((Layer) it.next()).clone();
                layer.setParent(cloneLayer);
                cloneLayer.layers.add(layer);
            }
        }

        // Skip cloning of stuff not used in toElement():

        // oldMetadata, metadata, layerMetadata

        return cloneLayer;
    }
    // </editor-fold>
    /** Method that will create piece of the XML tree to create a proper XML docuement.
     *
     * @param doc Document object which is being used to create new Elements
     * @param rootElement The element where this object belongs to.
     *
     * @return an object of type Element
     */
    // <editor-fold defaultstate="" desc="toElement(Document doc, Element rootElement) method">
    public Element toElement(Document doc, Element rootElement) {

        Element layerElement = doc.createElement("Layer");

        if (null != this.getQueryable()) {
            layerElement.setAttribute("queryable", this.getQueryable());
        }
        if (null != this.getCascaded()) {
            layerElement.setAttribute("cascaded", this.getCascaded());
        }
        if (null != this.getOpaque()) {
            layerElement.setAttribute("opaque", this.getOpaque());
        }
        if (null != this.getNosubsets()) {
            layerElement.setAttribute("noSubsets", this.getNosubsets());
        }
        if (null != this.getFixedWidth()) {
            layerElement.setAttribute("fixedWidth", this.getFixedWidth());
        }
        if (null != this.getFixedHeight()) {
            layerElement.setAttribute("fixedHeight", this.getFixedHeight());
        }

        if (null != this.getName()) {
            Element nameElement = doc.createElement("Name");
            Text text = doc.createTextNode(this.getUniqueName());
            nameElement.appendChild(text);
            layerElement.appendChild(nameElement);
        }

        if (null != this.getTitle()) {
            Element titleElement = doc.createElement("Title");
            Text text = doc.createTextNode(this.getTitle());
            titleElement.appendChild(text);
            layerElement.appendChild(titleElement);
        }

        if (null != this.getAbstracts()) {
            Element abstractElement = doc.createElement("Abstract");
            Text text = doc.createTextNode(this.getAbstracts());
            abstractElement.appendChild(text);
            layerElement.appendChild(abstractElement);
        }

        if (null != this.getKeywordList() && this.getKeywordList().size() != 0) {
            Element keywordListElement = doc.createElement("KeywordList");
            Iterator it = this.getKeywordList().iterator();
            while (it.hasNext()) {
                String keyword = (String) it.next();
                Element keywordElement = doc.createElement("Keyword");
                Text text = doc.createTextNode(keyword);
                keywordElement.appendChild(text);
                keywordListElement.appendChild(keywordElement);
            }
            layerElement.appendChild(keywordListElement);
        }

        ArrayList hlist = null;
        Hashtable srshash = new Hashtable();
        SrsBoundingBox srsbb = null;
        if (null != this.getSrsbb() && this.getSrsbb().size() != 0) {
            Iterator it = this.getSrsbb().iterator();
            while (it.hasNext()) {
                srsbb = (SrsBoundingBox) it.next();
                if (srsbb.getType() == null) {
                    continue;
                }
                hlist = (ArrayList) srshash.get(srsbb.getType());
                if (hlist == null) {
                    hlist = new ArrayList();
                }
                hlist.add(srsbb);
                srshash.put(srsbb.getType(), hlist);
            }
        }

        hlist = (ArrayList) srshash.get("SRS");
        if (hlist != null && !hlist.isEmpty()) {
            Iterator it = hlist.iterator();
            while (it.hasNext()) {
                srsbb = (SrsBoundingBox) it.next();
                layerElement = srsbb.toElement(doc, layerElement);
            }
        }
        hlist = (ArrayList) srshash.get("LatLonBoundingBox");
        if (hlist != null && !hlist.isEmpty()) {
            Iterator it = hlist.iterator();
            if (it.hasNext()) { // max 1 latlon box
                srsbb = (SrsBoundingBox) it.next();
                layerElement = srsbb.toElement(doc, layerElement);
            }
        }
        hlist = (ArrayList) srshash.get("BoundingBox");
        if (hlist != null && !hlist.isEmpty()) {
            Iterator it = hlist.iterator();
            while (it.hasNext()) {
                srsbb = (SrsBoundingBox) it.next();
                layerElement = srsbb.toElement(doc, layerElement);
            }
        }

        if (null != this.getDimensions() && this.getDimensions().size() != 0) {
            Iterator it = this.getDimensions().iterator();
            while (it.hasNext()) {
                Dimensions dim = (Dimensions) it.next();
                layerElement = dim.toElement(doc, layerElement);
            }
        }

        if (null != this.getAttribution()) {
            layerElement = this.getAttribution().toElement(doc, layerElement);
        }

        Hashtable ldrhash = new Hashtable();
        LayerDomainResource ldr = null;
        if (null != this.getDomainResource() && this.getDomainResource().size() != 0) {
            Iterator it = domainResource.iterator();
            while (it.hasNext()) {
                ldr = (LayerDomainResource) it.next();
                if (ldr.getDomain() == null) {
                    continue;
                }
                hlist = (ArrayList) ldrhash.get(ldr.getDomain());
                if (hlist == null) {
                    hlist = new ArrayList();
                }
                hlist.add(ldr);
                ldrhash.put(ldr.getDomain(), hlist);
            }
        }

        hlist = (ArrayList) ldrhash.get("AuthorityURL");
        if (hlist != null && !hlist.isEmpty()) {
            Iterator it = hlist.iterator();
            while (it.hasNext()) {
                ldr = (LayerDomainResource) it.next();
                layerElement = ldr.toElement(doc, layerElement);
            }
        }

        if (null != this.getIdentifiers() && this.getIdentifiers().size() != 0) {
            Iterator it = identifiers.iterator();
            while (it.hasNext()) {
                Identifier i = (Identifier) it.next();
                layerElement = i.toElement(doc, layerElement);
            }
        }

        hlist = (ArrayList) ldrhash.get("MetadataURL");
        if (hlist != null && !hlist.isEmpty()) {
            Iterator it = hlist.iterator();
            while (it.hasNext()) {
                ldr = (LayerDomainResource) it.next();
                layerElement = ldr.toElement(doc, layerElement);
            }
        }

        hlist = (ArrayList) ldrhash.get("DataURL");
        if (hlist != null && !hlist.isEmpty()) {
            Iterator it = hlist.iterator();
            while (it.hasNext()) {
                ldr = (LayerDomainResource) it.next();
                layerElement = ldr.toElement(doc, layerElement);
            }
        }

        hlist = (ArrayList) ldrhash.get("FeatureListURL");
        if (hlist != null && !hlist.isEmpty()) {
            Iterator it = hlist.iterator();
            while (it.hasNext()) {
                ldr = (LayerDomainResource) it.next();
                layerElement = ldr.toElement(doc, layerElement);
            }
        }

        if (null != this.getStyles() && this.getStyles().size() != 0) {
            Iterator it = styles.iterator();
            while (it.hasNext()) {
                Style style = (Style) it.next();
                layerElement = style.toElement(doc, layerElement);
            }
        }

        if (null != this.getScaleHintMin() && null != this.getScaleHintMax()) {
            try{
                if (Double.parseDouble(this.getScaleHintMin())>0 || Double.parseDouble(this.getScaleHintMax())>0){
                    Element scaleHintElement = doc.createElement("ScaleHint");
                    scaleHintElement.setAttribute("min", this.getScaleHintMin());
                    scaleHintElement.setAttribute("max", this.getScaleHintMax());
                    layerElement.appendChild(scaleHintElement);
                }
            }catch(NumberFormatException nfe){
                log.error("Stored scalehint is not a number:  "+this.getScaleHintMax()+ " min "+this.getScaleHintMin() );
            }
        }

        if (null != this.getLayers() && this.getLayers().size() != 0) {
            Iterator it = this.getLayers().iterator();
            while (it.hasNext()) {
                Layer l = (Layer) it.next();
                layerElement = l.toElement(doc, layerElement);
            }
        }

        rootElement.appendChild(layerElement);
        return rootElement;
    }
    // </editor-fold>
    public Layer getTopLayer() {
        Layer parent = this.getParent();
        if (parent != null) {
            return parent.getTopLayer();
        } else {
            return this;
        }
    }

    /**
     * Get a map of tuples containing the identity of this layer, for purposes
     * of comparing the identity maps of different layers. The
     * includeServiceProviderAbbr can be used to create identity maps which
     * do or do not include the service provider abbreviation. The properties
     * which are always added to the map are getName(), getTitle() and getCascaded()
     *
     * @param includeServiceProviderAbbr if getServiceProvider().getAbbr() should be included in the map.
     * @return A Map containing tuples of identifier properties
     */
    public Map getIdentityMap(boolean includeServiceProviderAbbr) {
        Map tuples = new HashMap();
        tuples.put("name", getName());
        tuples.put("title", getTitle());
        tuples.put("cascaded", getCascaded());
        if(includeServiceProviderAbbr) {
            tuples.put("sp_abbr", getServiceProvider() == null ? "(null)" : getServiceProvider().getAbbr());
        }
        return tuples;
    }

    /**
     * Public method to check wether the given layer as parameter equals this layer.
     */
    public boolean equals(Layer layer) {
        EqualsBuilder eb = new EqualsBuilder();
        if (this.getServiceProvider()!=null)
            eb.append(this.getServiceProvider().getAbbr(), layer.getServiceProvider().getAbbr());
        eb.append(this.getName(), layer.getName());
        eb.append(this.getTitle(), layer.getTitle());
        eb.append(this.getCascaded(), layer.getCascaded());
        return eb.isEquals();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Layer)) {
            return false;
        }
        Layer l = (Layer) o;
        return equals(l);
    }

    public int hashCode() {
        HashCodeBuilder hcb =new HashCodeBuilder(17, 37);
        if (this.getServiceProvider()!=null)
            hcb.append(this.getServiceProvider().getAbbr());
        hcb.append(this.getName());
        hcb.append(this.getTitle());
        hcb.append(this.getCascaded());
        return hcb.toHashCode();
    }

    /**
     * Public method which checks if this layer is in a list with layers given as a parameter.
     */
    public boolean inList(Set layers) {
        if (layers == null) {
            return false;
        }
        Iterator it = layers.iterator();
        while (it.hasNext()) {
            Layer layer = (Layer) it.next();
            if (this.equals(layer)) {
                return true;
            }
        }
        return false;
    }
    public String toString(){
        String returnValue="";
        if (this.getName()!=null){
            returnValue+=this.getName();
        }
        if (this.getTitle()!=null){
            returnValue+=" ("+this.getTitle()+")";
        }
        return returnValue;
    }

    public int compareTo(Object o) {
        if (o==null){
            return 1;
        }
        if (! (o instanceof Layer)){
            return 1;
        }
        Layer l = (Layer)o;
        return this.toString().compareTo(l.toString());
    }

}
