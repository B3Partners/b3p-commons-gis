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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import nl.b3p.ogc.wfs.v110.WfsLayer;
import nl.b3p.ogc.wfs.v110.WfsServiceProvider;
import nl.b3p.wms.capabilities.ServiceProvider;
import nl.b3p.wms.capabilities.Layer;
import nl.b3p.wms.capabilities.Style;

/**
 *
 * @author Chris
 */
public class SpLayerSummary {

    private Integer serviceproviderId = null;
    private String username = null;
    private String password = null;
    private String spUrl = null;
    private String spAbbr = null;
    private String spInUrl = null;
     
    private List<LayerSummary> layers = null;

    public SpLayerSummary(
            Integer serviceproviderId,
            Integer layerId,
            String layerName,
            String spUrl,
            String spAbbr,
            String queryable, 
            Set<Style> styles) {
        this(serviceproviderId,layerId,layerName,spUrl,spAbbr,queryable,styles,null,null);
    }
    
    public SpLayerSummary(
            Integer serviceproviderId,
            Integer layerId,
            String layerName,
            String spUrl,
            String spAbbr,
            String queryable, 
            Set<Style> styles,
            String username,
            String password) {
        this.serviceproviderId = serviceproviderId;
        this.username = username;
        this.password = password;
        this.spUrl = spUrl;
        this.spAbbr = spAbbr;
        
        try {
            LayerSummary ls = OGCCommunication.splitLayerWithoutNsFix(layerName, false, spAbbr, null);
            ls.setLayerId(layerId);
            ls.setQueryable(queryable);
            ls.setStyles(styles);

            List<LayerSummary> lsl = new ArrayList();
            lsl.add(ls);
            this.setLayers(lsl);
        } catch (Exception ex) {
            // no layer
        }
    }

    public SpLayerSummary(Layer l, String queryable) {
        this(l.getServiceProvider().getId(),
                l.getId(),
                l.getName(),
                l.getServiceProvider().getUrl(),
                l.getServiceProvider().getAbbr(),
                queryable,l.getStyles(),l.getServiceProvider().getUserName(),l.getServiceProvider().getPassword());
    }

    public SpLayerSummary(WfsLayer l, String queryable) {
        this(l.getWfsServiceProvider().getId(),
                l.getId(),
                l.getName(),
                l.getWfsServiceProvider().getUrl(),
                l.getWfsServiceProvider().getAbbr(),
                queryable,null,l.getWfsServiceProvider().getUsername(),l.getWfsServiceProvider().getPassword());
    }
    
    public SpLayerSummary(WfsLayer l, String queryable,ServiceProvider sp) {
        this(l,queryable);
        
        setServiceProvider(sp);
    }
    
    public SpLayerSummary(WfsLayer l, String queryable,WfsServiceProvider sp) {
        this(l,queryable);
        
        setServiceProvider(sp);
    }
    
    public SpLayerSummary(Layer l, String queryable,ServiceProvider sp) {
        this(l,queryable);
        
        setServiceProvider(sp);
    }
    
    public SpLayerSummary(Layer l, String queryable,WfsServiceProvider sp) {
        this(l,queryable);
        
        setServiceProvider(sp);
    }

    public SpLayerSummary() {
    }

    public Integer getServiceproviderId() {
        return serviceproviderId;
    }

    public void setServiceproviderId(Integer serviceproviderId) {
        this.serviceproviderId = serviceproviderId;
    }

    public String getLayerName() {
        if (this.getLayers()!=null && !this.getLayers().isEmpty()) {
            return this.getLayers().get(0).getLayerName();
        }
        return null;
    }

    public String getSpUrl() {
        return spUrl;
    }

    public void setSpUrl(String spUrl) {
        this.spUrl = spUrl;
    }

    public String getSpAbbr() {
        return spAbbr;
    }
    
    public final void setServiceProvider(WfsServiceProvider sp){
        this.username   = sp.getUsername();
        this.password   = sp.getPassword();
    }
    
    public final void setServiceProvider(ServiceProvider sp){
        if( sp == null )    return;
        this.username   = sp.getUserName();
        this.password   = sp.getPassword();
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }

    public void setSpAbbr(String spAbbr) {
        this.spAbbr = spAbbr;
    }

    public List<LayerSummary> getLayers() {
        return layers;
    }

    public final void setLayers(List<LayerSummary> layers) {
        this.layers = layers;
    }

    public void addLayer(LayerSummary layerName) {
        if (layers == null) {
            layers = new ArrayList<LayerSummary>();
        }
        layers.add(layerName);
    }

    public void addLayers(List<LayerSummary> lss) {
        if (layers == null) {
            layers = new ArrayList<LayerSummary>();
        }
        layers.addAll(lss);
    }

    public String getLayersAsString() {
        if (layers == null) {
            return null;
        }
        StringBuffer ll = new StringBuffer();
        Iterator it = layers.iterator();
        while (it.hasNext()) {
            LayerSummary l = (LayerSummary) it.next();
            if (ll.length() != 0) {
                ll.append(",");
            }
            ll.append(l.getLayerName());
        }
        return ll.toString();
    }

//    public static List condenseSpSummaryLists(List spLayerSummaryList, String urlSp) {
//        Iterator spIt = spLayerSummaryList.iterator();
//        // voor vervangen in response, alleen sp indien niet in url
//        List<LayerSummary> spLayers = new ArrayList();
//        while (spIt.hasNext()) {
//            SpLayerSummary sp = (SpLayerSummary) spIt.next();
//            spUrl = sp.getSpUrl();
//            spAbbr = sp.getSpAbbr();
//            if (spName != null) {
//                if (spName.equalsIgnoreCase(spAbbr)) {
//                    spAbbr = null;
//                } else {
//                    // sp in url, andere sp dan weglaten
//                    continue;
//                }
//            }
//            List tlayers = sp.getLayers();
//            if (tlayers == null) {
//                String layerName = sp.getLayerName();
//                LayerSummary layer = new LayerSummary();
//                layer.setSpAbbr(spAbbr);
//                layer.setLayerName(layerName);
//                spLayers.add(layer);
//                continue;
//            }
//            Iterator it2 = tlayers.iterator();
//            while (it2.hasNext()) {
//                String layerName = (String) it2.next();
//                LayerSummary layer = new LayerSummary();
//                layer.setSpAbbr(spAbbr);
//                layer.setLayerName(layerName);
//                spLayers.add(layer);
//            }
//
//        }   
//        if (spLayers.isEmpty()) {
//            throw new UnsupportedOperationException("No Serviceprovider for this service available!");
//        }
//        return spLayers;
//    }
    
    
     public String getQueryable() {
        if (this.getLayers()!=null && !this.getLayers().isEmpty()) {
            return this.getLayers().get(0).getQueryable();
        }
        return null;
    }


    /**
     * Get the style with the given stylename
     * @return Returns null if no style with the given name is found.
     */
    public Style getStyle(String layerName,String styleName){
        if (layerName==null || styleName==null) {
            return null;
        }
        for (LayerSummary ls : this.getLayers()) {
            if (!layerName.equals(ls.getLayerName())) {
                continue;
            }
            Set<Style> layerStyles = ls.getStyles();
            Iterator<Style> it = layerStyles.iterator();
            while (it.hasNext()) {
                Style s = it.next();
                if (styleName.equals(s.getName())) {
                    return s;
                }
            }
        }
        return null;
    }

    /**
     * @return the spInUrl
     */
    public String getSpInUrl() {
        return spInUrl;
    }

    /**
     * @param spInUrl the spInUrl to set
     */
    public void setSpInUrl(String spInUrl) {
        this.spInUrl = spInUrl;
    }

}
