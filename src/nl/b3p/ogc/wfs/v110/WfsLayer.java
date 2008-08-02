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

/**
 *
 * @author Jytte
 */
public class WfsLayer {

    private int id;
    private String name;
    private String title;
    private String metaData;
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

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setWfsServiceProvider(WfsServiceProvider wfsServiceProvider) {
        this.wfsServiceProvider = wfsServiceProvider;
    }

    public WfsServiceProvider getWfsServiceProvider() {
        return wfsServiceProvider;
    }

    public String getSpAbbr() {
        if (wfsServiceProvider == null) {
            return "0";
        }
        String abbr = wfsServiceProvider.getAbbr();
        if (abbr == null) {
            return "0";
        }
        return abbr;
    }

    public String getUniqueName() {
        // Indien naam leeg is, dan mag de layer nooit getoond worden via GetMap
        // dus wij mogen naam nooit vullen als hij oorspronkelijk leeg was!
        if (this.getName() == null) {
            return null;
        }
        return getSpAbbr() + "_" + this.getName();
    }
}
