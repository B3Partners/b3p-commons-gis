/*
 * B3P Kaartenbalie is a OGC WMS/WFS proxy that adds functionality
 * for authentication/authorization, pricing and usage reporting.
 *
 * Copyright 2006, 2007, 2008 B3Partners BV
 * 
 * This file is part of B3P Kaartenbalie.
 * 
 * B3P Kaartenbalie is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * B3P Kaartenbalie is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with B3P Kaartenbalie.  If not, see <http://www.gnu.org/licenses/>.
 */
package nl.b3p.ogc.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import nl.b3p.ogc.wfs.v110.WfsLayer;
import nl.b3p.wms.capabilities.Layer;
import nl.b3p.wms.capabilities.Style;

/**
 *
 * @author Chris
 */
public class LayerSummary {

    private Integer layerId = null;
    private String layerName = null;
    private String spAbbr = null;
    private String prefix = null;
    private String nsUrl = null;
    private String error = null;
    private String queryable = null;
    private Set<Style> styles;


    public LayerSummary(
            Integer layerId,
            String layerName,
            String spAbbr,
            String queryable,
            Set styles) {
        this.layerId = layerId;
        this.layerName = layerName;
        this.spAbbr = spAbbr;
        this.queryable = queryable;
        this.styles = styles;
    }

    public LayerSummary(Layer l, String queryable) {
        this(l.getId(),
                l.getName(),
                l.getServiceProvider().getAbbr(),
                queryable,l.getStyles());
    }

    public LayerSummary(WfsLayer l, String queryable) {
        this(l.getId(),
                l.getName(),
                l.getWfsServiceProvider().getAbbr(),
                queryable, null);
    }
    
    
    public LayerSummary() {
    }

    
    public Integer getLayerId() {
        return layerId;
    }

    public void setLayerId(Integer layerId) {
        this.layerId = layerId;
    }

    public String getLayerName() {
        return layerName;
    }

    public void setLayerName(String layerName) {
        this.layerName = layerName;
    }

    public String getSpAbbr() {
        return spAbbr;
    }
    
    public String getQueryable() {
        return queryable;
    }

    public void setQueryable(String queryable) {
        this.queryable = queryable;
    }

    /**
     * @return the prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * @param prefix the prefix to set
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * @return the nsUrl
     */
    public String getNsUrl() {
        return nsUrl;
    }

    /**
     * @param nsUrl the nsUrl to set
     */
    public void setNsUrl(String nsUrl) {
        this.nsUrl = nsUrl;
    }

    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * @return the styles
     */
    public Set<Style> getStyles() {
        return styles;
    }

    /**
     * @param styles the styles to set
     */
    public void setStyles(Set<Style> styles) {
        this.styles = styles;
    }
    
    /**
     * Get the style with the given stylename
     * @return Returns null if no style with the given name is found.
     */
    public Style getStyle(String styleName){
        if (styleName==null || this.getStyles()==null) {
            return null;
        }
        Iterator<Style> it= this.getStyles().iterator();
        while(it.hasNext()){
            Style s= it.next();
            if (styleName.equals(s.getName())){
                return s;
            }
        }
        return null;
    }

    public void addStyles(Set<Style> styles) {
        if (this.getStyles()==null){
            this.setStyles(new HashSet<Style>());
        }
        this.getStyles().addAll(styles);
    }   

    /**
     * @param spAbbr the spAbbr to set
     */
    public void setSpAbbr(String spAbbr) {
        this.spAbbr = spAbbr;
    }
    
    public static List<LayerSummary> createLayerSummaryList(List<String> layers, String spInUrl, boolean splitName) throws Exception {
        List<LayerSummary> tempList = new ArrayList();
        Iterator it = layers.iterator();
        while (it.hasNext()) {
            String layer = it.next().toString();
            LayerSummary m = OGCCommunication.splitLayerWithoutNsFix(layer, splitName, spInUrl, null);
            String spAbbr = m.getSpAbbr();
            if (spInUrl==null) {
                // indien geen sp in url, alles toevoegen
                tempList.add(m);
            } else if (spAbbr.equals(spInUrl) || 
                    spAbbr.equals(KBConfiguration.SERVICEPROVIDER_BASE_ABBR)) {
                // alleen toevoegen indien van de zelfde sp of b3p layering
                tempList.add(m);
            }
        }
        return tempList;
    }
    
    public String getLayersAsString(List<LayerSummary> lsl) {
        if (lsl == null) {
            return null;
        }
        StringBuffer ll = new StringBuffer();
        Iterator it = lsl.iterator();
        while (it.hasNext()) {
            LayerSummary l = (LayerSummary) it.next();
            if (ll.length() != 0) {
                ll.append(",");
            }
            ll.append(l.getLayerName());
        }
        return ll.toString();
    }
    
    public static String[] getLayersAsArray(List<LayerSummary> lsl) {
        if (lsl == null) {
            return null;
        }
        String[] la = new String[lsl.size()];
        for (int i=0; i<lsl.size(); i++) {
            LayerSummary l = lsl.get(i);
            la[i] = l.getLayerName();
        }
        return la;
    }
}
