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
package nl.b3p.ogc.wfs.v110;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Jytte
 */
public class WfsServiceProvider {

    private Integer id;
    private String abbr;
    private String name;
    private String title;
    private String givenName;
    private String url;
    private String wfsVersion;
    private Date updatedDate;
    private Set wfsLayers;

    /** Creates a new instance of WfsServiceProvider */
    public WfsServiceProvider() {
    }

    public Set getWfsLayers() {
        return wfsLayers;
    }

    public void setWfsLayers(Set wfsLayers) {
        this.wfsLayers = wfsLayers;
    }

    public void addWfsLayer(WfsLayer layer) {
        if (wfsLayers == null) {
            wfsLayers = new HashSet();
        }
        wfsLayers.add(layer);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
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

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWfsVersion() {
        return wfsVersion;
    }

    public void setWfsVersion(String wfsVersion) {
        this.wfsVersion = wfsVersion;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

}
