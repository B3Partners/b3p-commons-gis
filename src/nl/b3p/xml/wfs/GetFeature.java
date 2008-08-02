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
public interface GetFeature {

    public void clearQuery();

    public void deleteMaxFeatures();

    public java.util.Enumeration enumerateQuery();

    public int getMaxFeatures();

    public java.lang.String getService();

    public java.lang.String getOutputFormat();

    public int getQueryCount();

    public java.lang.String getVersion();

    public boolean hasMaxFeatures();

    public boolean isValid();

    public void setMaxFeatures(int maxFeatures);

    public void setService(java.lang.String service);

    public void setOutputFormat(java.lang.String outputFormat);

    public void setVersion(java.lang.String version);

    public void validate() throws org.exolab.castor.xml.ValidationException;
}
