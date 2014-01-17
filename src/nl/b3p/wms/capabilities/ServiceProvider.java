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

import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import nl.b3p.gis.B3PCredentials;
import nl.b3p.ogc.ServiceProviderInterface;
import nl.b3p.ogc.utils.KBConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class ServiceProvider implements XMLElement, ServiceProviderInterface {
    private static final Log log = LogFactory.getLog(ServiceProvider.class);
    private Integer id;
    private String abbr;
    private String name;
    private String title;
    private String abstracts;
    private String fees;
    private String accessConstraints;
    private String givenName;
    private String url;
    private String wmsVersion;
    private Date updatedDate;
    private ContactInformation contactInformation;
    private Set domainResource;
    private Set serviceProviderKeywordList;
    private Set exceptions;
    private Set layers;
    private Set<TileSet> tileSets;
    private Layer topLayer;
    private Set allRoles;
    private String code;
    private boolean isSynchronized = false;

    private Date expireDate;
    private String userName;
    private String personalCode;

    private String status;

    /* password to check againt when object is already been cached */
    private String password;

    private String sldUrl;
    
    private Boolean ignoreResource;
    private Boolean allowed = Boolean.TRUE;
    
    private String urlServiceProvideCode = null;

    /** default ServiceProvider() constructor.
     */
    // <editor-fold defaultstate="" desc="default ServiceProvider() constructor">
    public ServiceProvider() {
        name = KBConfiguration.SERVICEPROVIDER_NAME;
        title = KBConfiguration.SERVICEPROVIDER_TITLE;
        abstracts = KBConfiguration.SERVICEPROVIDER_ABSTRACT;
        fees = KBConfiguration.SERVICEPROVIDER_FEES;
        accessConstraints = KBConfiguration.SERVICEPROVIDER_ACCESSCONSTRAINTS;
    }
    // </editor-fold>
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

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getAccessConstraints() {
        return accessConstraints;
    }

    public void setAccessConstraints(String accessConstraints) {
        this.accessConstraints = accessConstraints;
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

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
        if (contactInformation != null) {
            contactInformation.setServiceProvider(this);
        }
    }

    public Set getExceptions() {
        return exceptions;
    }

    public void setExceptions(Set exceptions) {
        this.exceptions = exceptions;
    }

    public void addException(String except) {
        if (exceptions == null) {
            exceptions = new HashSet();
        }
        exceptions.add(except);
    }

    public Set getDomainResource() {
        return domainResource;
    }

    public void setDomainResource(Set domainResource) {
        this.domainResource = domainResource;
    }

    public void addDomainResource(ServiceDomainResource dr) {
        if (domainResource == null) {
            domainResource = new HashSet();
        }
        domainResource.add(dr);
        dr.setServiceProvider(this);
    }

    public void setAllRoles(Set allRoles) {
        this.allRoles = allRoles;
    }

    public Set getAllRoles() {
        return allRoles;
    }

    public void addRole(Roles role) {
        if (allRoles == null) {
            allRoles = new HashSet();
        }
        allRoles.add(role);
    }

    public String getOrganizationCode() {
        return code;
    }

    public void setOrganizationCode(String code) {
        this.code = code;
    }

    public Set getAllLayers() {
        if (!isIsSynchronized() && topLayer != null) {
            try{
                layers = topLayer.buildLayerSet(null, this);
            }catch (Exception e){
                log.error("Can not build layer set.",e);
            }
            setIsSynchronized(true);
        }
        return layers;
    }

    private Layer defineTopLayer() {
        if (layers == null) {
            return null;
        }
        Iterator it = layers.iterator();
        Layer parent = null;
        while (it.hasNext()) {
            Layer layer = (Layer) it.next();
            if (layer.getParent() == null) {
                if (parent != null) {
                    throw new Error("inconsistente database, meerdere top layers! service provider id " + getId());
                }
                parent = layer;
            }
        }
        return parent;
    }
    //Er zijn drie opties
    //-er is een set aanwezig --> nog geen boomstructuur
    //-er is een boom aanwezig --> nog geen setstructuur
    //-er is een boom aanwezig --> oude setstructuur
    //bij deze laatste geldt eigenlijk dat de set aangepast wordt aan de nieuwe boomstructuur.....
    public Layer getTopLayer() throws Exception {
        if (!isIsSynchronized() && topLayer == null) {
            topLayer = defineTopLayer();
            if (topLayer != null) {
                topLayer.buildLayerTree(layers);
            }
            setIsSynchronized(true);
        }
        return topLayer;
    }

    public void setTopLayer(Layer topLayer) {
        setIsSynchronized(false);
        this.topLayer = topLayer;
    }

    public Set getServiceProviderKeywordList() {
        return serviceProviderKeywordList;
    }

    public void setServiceProviderKeywordList(Set serviceProviderKeywordList) {
        this.serviceProviderKeywordList = serviceProviderKeywordList;
    }

    public void addKeyword(String keyword) {
        if (null == serviceProviderKeywordList) {
            serviceProviderKeywordList = new HashSet();
        }
        /* Voeg geen leeg keyword toe, in de mapping staat de inhoud van
         * de set namelijk op not-null
         */
        if(keyword != null && keyword.trim().length() != 0) {
            serviceProviderKeywordList.add(keyword);
        }
    }
    // </editor-fold>
    
    /** Method that will overwrite the URL's stored in the database with the URL specified for Kaartenbalie.
     * This new URL indicate the link to the kaartenbalie, while the old link is used to indicate the URL
     * to the real location of the service. Because the client which is connected to kaartenbalie has to send
     * his requests back to kaartenbalie and not directly to the official resource, the URL has to be replaced.
     *
     * @param newUrl String representing the URL the old URL has to be replaced with.
     */
    // <editor-fold defaultstate="" desc="convertValues2KB(String newUrl) method">
    public void convertValues2KB(HashMap conversionValues) throws Exception {
        conversionValues.put("spAbbrUrl", this.getUrlServiceProvideCode());
        conversionValues.put("spAbbr", this.abbr);
        String newUrl = (String)conversionValues.get("url");
        this.url = newUrl;

        if (domainResource != null) {
            Iterator it = domainResource.iterator();
            while (it.hasNext()) {
                ServiceDomainResource sdr = (ServiceDomainResource) it.next();
                sdr.convertValues2KB(conversionValues);
            }
        }
        Layer tl = getTopLayer();
        if (tl != null) {
            tl.convertValues2KB(conversionValues);           
        }
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

        Element serviceElement = doc.createElement("Service");

        if (null != this.getName()) {
            Element nameElement = doc.createElement("Name");
            Text text = doc.createTextNode(this.getName());
            nameElement.appendChild(text);
            serviceElement.appendChild(nameElement);
        }

        if (null != this.getTitle()) {
            Element titleElement = doc.createElement("Title");
            Text text = doc.createTextNode(this.getTitle());
            titleElement.appendChild(text);
            serviceElement.appendChild(titleElement);
        }
        if (null != this.getAbstracts()) {
            Element abstractElement = doc.createElement("Abstract");
            Text text = doc.createTextNode(this.getAbstracts());
            abstractElement.appendChild(text);
            serviceElement.appendChild(abstractElement);
        }

        if (null != this.getServiceProviderKeywordList() && !this.getServiceProviderKeywordList().isEmpty()) {
            Element keywordListElement = doc.createElement("KeywordList");

            Iterator it = this.getServiceProviderKeywordList().iterator();
            while (it.hasNext()) {
                String keyword = (String) it.next();
                Element keywordElement = doc.createElement("Keyword");
                Text text = doc.createTextNode(keyword);
                keywordElement.appendChild(text);
                keywordListElement.appendChild(keywordElement);
            }

            serviceElement.appendChild(keywordListElement);
        }

        if (null != this.getUrl()) {
            Element onlineElement = doc.createElement("OnlineResource");
            onlineElement.setAttribute("xlink:href", this.getUrl());
            onlineElement.setAttribute("xlink:type", "simple");
            onlineElement.setAttribute("xmlns:xlink", "http://www.w3.org/1999/xlink");
            serviceElement.appendChild(onlineElement);
        }

        if (null != this.getContactInformation()) { 
            serviceElement = this.getContactInformation().toElement(doc, serviceElement);
        }

        if (null != this.getFees()) {
            Element feesElement = doc.createElement("Fees");
            Text text = doc.createTextNode(this.getFees());
            feesElement.appendChild(text);
            serviceElement.appendChild(feesElement);
        }
        if (null != this.getAccessConstraints()) {
            Element accessElement = doc.createElement("AccessConstraints");
            Text text = doc.createTextNode(this.getAccessConstraints());
            accessElement.appendChild(text);
            serviceElement.appendChild(accessElement);
        }
        //End of Service

        //Start of Capability
        Element capabilityElement = doc.createElement("Capability");

        //De verschillende request mogelijkheden....
        Element requestElement = doc.createElement("Request");

        if (domainResource != null) {
            HashMap sdrhash = new HashMap();
            ServiceDomainResource sdr = null;
            Iterator it = domainResource.iterator();
            while (it.hasNext()) {
                sdr = (ServiceDomainResource) it.next();
                sdrhash.put(sdr.getDomain(), sdr);
            }

            sdr = (ServiceDomainResource) sdrhash.get("GetCapabilities");
            if (sdr != null) {
                requestElement = sdr.toElement(doc, requestElement);
            }
            sdr = (ServiceDomainResource) sdrhash.get("GetMap");
            if (sdr != null) {
                requestElement = sdr.toElement(doc, requestElement);
            }
            sdr = (ServiceDomainResource) sdrhash.get("GetFeatureInfo");
            if (sdr != null) {
                requestElement = sdr.toElement(doc, requestElement);
            }
            sdr = (ServiceDomainResource) sdrhash.get("DescribeLayer");
            if (sdr != null) {
                requestElement = sdr.toElement(doc, requestElement);
            }
            sdr = (ServiceDomainResource) sdrhash.get("GetLegendGraphic");
            if (sdr != null) {
                requestElement = sdr.toElement(doc, requestElement);
            }
            sdr = (ServiceDomainResource) sdrhash.get("GetStyles");
            if (sdr != null) {
                requestElement = sdr.toElement(doc, requestElement);
            }
            capabilityElement.appendChild(requestElement);
        }

        Element exceptionElement = doc.createElement("Exception");
        if (exceptions != null) {
            //De exception formaten
            Iterator it = exceptions.iterator();
            while (it.hasNext()) {
                Element formatElement = doc.createElement("Format");
                Text text = doc.createTextNode((String) it.next());
                formatElement.appendChild(text);
                exceptionElement.appendChild(formatElement);
            }
        }
        capabilityElement.appendChild(exceptionElement);

        //Vendor specifieke elementen
        Element vendorSpecificElement = doc.createElement("VendorSpecificCapabilities");
        if (getAllRoles() != null && !getAllRoles().isEmpty()) {
            Iterator it = getAllRoles().iterator();
            while (it.hasNext()) {
                Roles role = (Roles) it.next();
                Element roleElement = doc.createElement("Role");
                roleElement.setAttribute("id", role.getRole());
                vendorSpecificElement.appendChild(roleElement);
            }
        } else {
            Element roleElement = doc.createElement("Role");
            roleElement.setAttribute("id", KBConfiguration.KB_DEFAULT_ROLE);
            vendorSpecificElement.appendChild(roleElement);
        }

        if (this.getOrganizationCode() != null) {
            Element orgcode = doc.createElement("OrganizationCode");
            Text text = doc.createTextNode(this.getOrganizationCode());
            orgcode.appendChild(text);
            vendorSpecificElement.appendChild(orgcode);
        }

        if (this.getExpireDate() != null) {
            Element expireDate = doc.createElement("ExpireDate");
            Text text = doc.createTextNode(this.getExpireDate().toString());
            expireDate.appendChild(text);
            vendorSpecificElement.appendChild(expireDate);
        }

        if (this.getUserName() != null) {
            Element userName = doc.createElement("UserName");
            Text text = doc.createTextNode(this.getUserName());
            userName.appendChild(text);
            vendorSpecificElement.appendChild(userName);
        }

        if (this.getPersonalCode() != null) {
            Element pCode = doc.createElement("PersonalCode");
            Text text = doc.createTextNode(this.getPersonalCode());
            pCode.appendChild(text);
            vendorSpecificElement.appendChild(pCode);
        }
        //add the styles
        if (this.getTileSets()!=null){
            Iterator<TileSet> it=this.getTileSets().iterator();
            while(it.hasNext()){                
                TileSet ts=it.next();
                ts.setUrlServiceProvideCode(getUrlServiceProvideCode());
                if (ts!=null) {
                    vendorSpecificElement.appendChild(ts.toElement(doc,doc.createElement("TileSet")));
                }
            }            
        }

        capabilityElement.appendChild(vendorSpecificElement);

        //De beschikbare layers.
        if (topLayer != null) {
            capabilityElement = topLayer.toElement(doc, capabilityElement);        //End of Capability
        }
        rootElement.appendChild(serviceElement);
        rootElement.appendChild(capabilityElement);
        return rootElement;
    }
    // </editor-fold>
    public String getWmsVersion() {
        return wmsVersion;
    }

    public void setWmsVersion(String wmsVersion) {
        this.wmsVersion = wmsVersion;
    }

    private Set getLayers() {
        return layers;
    }

    public void setLayers(Set layers) {
        this.layers = layers;
        setIsSynchronized(false);
    }

    public boolean isIsSynchronized() {
        return isSynchronized;
    }

    public void setIsSynchronized(boolean isSynchronized) {
        this.isSynchronized = isSynchronized;
    }

    public String getAbbr() {
        if (abbr == null && id != null) {
            return id.toString();
        }
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSldUrl() {
        return sldUrl;
    }

    public void setSldUrl(String sldUrl) {
        this.sldUrl = sldUrl;
    }

    public ServiceProvider shallowClone() {
        ServiceProvider sc = new ServiceProvider();
        sc.setAbbr(this.getAbbr());
        sc.setAbstracts(this.getAbstracts());
        sc.setAccessConstraints(this.getAccessConstraints());
        sc.setFees(this.getFees());
        sc.setGivenName(this.getGivenName());
        sc.setIsSynchronized(false);
        sc.setName(this.getName());
        sc.setTitle(this.getTitle());
        sc.setUrl(this.getUrl());
        sc.setWmsVersion(this.getWmsVersion());
        sc.setUserName(this.getUserName());
        sc.setPassword(this.getPassword());
 
        sc.setUpdatedDate(this.getUpdatedDate());
//        sc.setContactInformation(this.getContactInformation());
//        sc.setCode(this.getCode());
        sc.setExpireDate(this.getExpireDate());
        sc.setPersonalCode(this.getPersonalCode());
        sc.setStatus(this.getStatus());
        sc.setSldUrl(this.getSldUrl());
        sc.setIgnoreResource(this.getIgnoreResource());
        sc.setAllowed(this.getAllowed());
        sc.setUrlServiceProvideCode(this.getUrlServiceProvideCode());
        
        HashSet dr=new HashSet();
        dr.addAll(this.getDomainResource());
        sc.setDomainResource(dr);
        
        return sc;
    }
    /**
     * Returns the ServiceDomainResource with the given operationname and null if not exists
     */
    public ServiceDomainResource getServiceDomainResourceByOperationName(String operationName){
        if (this.getDomainResource()==null)
            return null;
        Iterator<ServiceDomainResource> sdit= this.getDomainResource().iterator();
        boolean canHandleGetLegend=false;
        while (sdit.hasNext() && !canHandleGetLegend){
            ServiceDomainResource sdr=sdit.next();
            if (sdr.getDomain().equals(operationName)){
                return sdr;
            }
        }
        return null;
    }

    public String getType() {
        return "WMS";
    }

    public Set<TileSet> getTileSets() {
        return tileSets;
    }

    public void setTileSets(Set<TileSet> tileSets) {
        this.tileSets = tileSets;
    }

    public void addTileSet(TileSet ts) {
        if (this.tileSets==null){
            this.tileSets = new HashSet<TileSet>();            
        }
        this.tileSets.add(ts);
    }
    /**
     * Returned de tileset van (alleen) deze layer. Als er meerder layers in een tileset
     * zitten wordt deze tileset niet gereturned.
     */
    public TileSet getTileSet(Layer layer){
        if (this.tileSets==null){
            return null;
        }
        Iterator<TileSet> tilesetIt=this.tileSets.iterator();
        while(tilesetIt.hasNext()){
            TileSet ts=tilesetIt.next();
            //return alleen tilesets die gedekt worden door de layer.
            if (ts.getLayers()!=null && ts.getLayers().size()==1){
                if(ts.getLayers().contains(layer)){
                    return ts;
                }
            }
        }
        return null;
    }

    public Boolean getIgnoreResource() {
        return ignoreResource;
    }

    public void setIgnoreResource(Boolean ignoreResource) {
        this.ignoreResource = ignoreResource;
    }

    /**
     * Returns the service login credentials
     * 
     * @return The credentials
     */
    public B3PCredentials getCredentials() {
        B3PCredentials credentials  = new B3PCredentials();
        credentials.setUserName(this.userName);
        credentials.setPassword(this.password);
        
        return credentials;
    }
    
    public void setAllowed(Boolean allowed){
        this.allowed    = allowed;
    }

    public Boolean getAllowed() {
        return this.allowed;
    }

    /**
     * @return the urlServiceProvideCode
     */
    public String getUrlServiceProvideCode() {
        return urlServiceProvideCode;
    }

    /**
     * @param urlServiceProvideCode the urlServiceProvideCode to set
     */
    public void setUrlServiceProvideCode(String urlServiceProvideCode) {
        this.urlServiceProvideCode = urlServiceProvideCode;
    }
}