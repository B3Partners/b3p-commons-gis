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
package nl.b3p.xml.wfs;

/**
 *
 * @author Roy
 */
public interface FeatureTypeList {

    public int getFeatureTypeCount();

    public java.util.Enumeration enumerateFeatureType();

    public nl.b3p.xml.wfs.FeatureType getFeatureType(int index);

    public nl.b3p.xml.wfs.FeatureType[] getFeatureType();

    public void clearFeatureType();
}
