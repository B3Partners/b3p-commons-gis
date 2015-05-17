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

import nl.b3p.ogc.utils.OGCCommunication;

/**
 *
 * @author Jytte
 */
public class WfsLayer {

    private int id;
    private String name;
    private String title;
    private String metadata;
    private WfsServiceProvider wfsServiceProvider;

    /** Creates a new instance of WfsLayer */
    public WfsLayer() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setWfsServiceProvider(WfsServiceProvider wfsServiceProvider) {
        this.wfsServiceProvider = wfsServiceProvider;
    }

    public WfsServiceProvider getWfsServiceProvider() {
        return wfsServiceProvider;
    }

    public String getSpAbbr() {
        if (wfsServiceProvider == null) {
            return null;
        }
        return wfsServiceProvider.getAbbr();
    }

    public String getUniqueName() {
		return OGCCommunication.attachSp(getSpAbbr(), getName());
    }
}
