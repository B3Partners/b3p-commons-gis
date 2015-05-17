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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Dimensions implements XMLElement {

    private Integer id;
    private String dimensionsName;
    private String dimensionsUnit;
    private String dimensionsUnitSymbol;
    private String extentName;
    private String extentDefaults;
    private String extentNearestValue;
    private String extentMultipleValues;
    private String extentCurrent;
    private Layer layer;
    // <editor-fold defaultstate="" desc="getter and setter methods.">
    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getDimensionsName() {
        return dimensionsName;
    }

    public void setDimensionsName(String dimensionsName) {
        this.dimensionsName = dimensionsName;
    }

    public String getDimensionsUnit() {
        return dimensionsUnit;
    }

    public void setDimensionsUnit(String dimensionsUnit) {
        this.dimensionsUnit = dimensionsUnit;
    }

    public String getDimensionsUnitSymbol() {
        return dimensionsUnitSymbol;
    }

    public void setDimensionsUnitSymbol(String dimensionsUnitSymbol) {
        this.dimensionsUnitSymbol = dimensionsUnitSymbol;
    }

    public String getExtentName() {
        return extentName;
    }

    public void setExtentName(String extentName) {
        this.extentName = extentName;
    }

    public String getExtentDefaults() {
        return extentDefaults;
    }

    public void setExtentDefaults(String extentDefaults) {
        this.extentDefaults = extentDefaults;
    }

    public String getExtentNearestValue() {
        return extentNearestValue;
    }

    public void setExtentNearestValue(String extentNearestValue) {
        this.extentNearestValue = extentNearestValue;
    }

    public String getExtentMultipleValues() {
        return extentMultipleValues;
    }

    public void setExtentMultipleValues(String extentMultipleValues) {
        this.extentMultipleValues = extentMultipleValues;
    }

    public String getExtentCurrent() {
        return extentCurrent;
    }

    public void setExtentCurrent(String extentCurrent) {
        this.extentCurrent = extentCurrent;
    }

    public Layer getLayer() {
        return layer;
    }

    public void setLayer(Layer layer) {
        this.layer = layer;
    }
    // </editor-fold>
    /** Method that will create a deep copy of this object.
     *
     * @return an object of type Object
     */
    // <editor-fold defaultstate="" desc="clone() method">
    public Object clone() {
        Dimensions cloneDim = new Dimensions();
        if (null != this.id) {
            cloneDim.id = new Integer(this.id.intValue());
        }
        if (null != this.dimensionsName) {
            cloneDim.dimensionsName = new String(this.dimensionsName);
        }
        if (null != this.dimensionsUnit) {
            cloneDim.dimensionsUnit = new String(this.dimensionsUnit);
        }
        if (null != this.dimensionsUnitSymbol) {
            cloneDim.dimensionsUnitSymbol = new String(this.dimensionsUnitSymbol);
        }
        if (null != this.extentName) {
            cloneDim.extentName = new String(this.extentName);
        }
        if (null != this.extentDefaults) {
            cloneDim.extentDefaults = new String(this.extentDefaults);
        }
        if (null != this.extentNearestValue) {
            cloneDim.extentNearestValue = new String(this.extentNearestValue);
        }
        if (null != this.extentMultipleValues) {
            cloneDim.extentMultipleValues = new String(this.extentMultipleValues);
        }
        if (null != this.extentCurrent) {
            cloneDim.extentCurrent = new String(this.extentCurrent);
        }
        return cloneDim;
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

        Element dimensionElement = doc.createElement("Dimension");
        dimensionElement.setAttribute("name", this.getDimensionsName());
        dimensionElement.setAttribute("units", this.getDimensionsUnit());
        dimensionElement.setAttribute("unitSymbol", this.getDimensionsUnitSymbol());
        rootElement.appendChild(dimensionElement);

        Element extentElement = doc.createElement("Extent");
        extentElement.setAttribute("name", this.getExtentName());
        if (null != this.getExtentDefaults()) {
            extentElement.setAttribute("default", this.getExtentDefaults());
        }
        if (null != this.getExtentNearestValue()) {
            extentElement.setAttribute("nearestValue", this.getExtentNearestValue());
        }
        if (null != this.getExtentMultipleValues()) {
            extentElement.setAttribute("multipleValues", this.getExtentMultipleValues());
        }
        if (null != this.getExtentCurrent()) {
            extentElement.setAttribute("current", this.getExtentCurrent());
        }
        rootElement.appendChild(extentElement);

        return rootElement;
    }
    // </editor-fold>
}