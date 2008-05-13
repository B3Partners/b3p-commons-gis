/*
 * WfsServiceProvider.java
 *
 * Created on May 8, 2008, 4:51 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package nl.b3p.ogc.wfs.v110;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author Jytte
 */
public class WfsServiceProvider {
    
    private int id;
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
    
    private Set getWfsLayers() {
        return wfsLayers;
    }
    
    public void setWfsLayers(Set wfsLayers) {
        this.wfsLayers = wfsLayers;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public String getAbbr(){
        return abbr;
    }
    public void setAbbr(String abbr){
        this.abbr = abbr;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getTitle(){
        return title;
    }
    public void setTitle(String Title){
        this.title = title;
    }
    
    public String getGivenName(){
        return givenName;
    }
    public void setGivenName(String GivenName){
        this.givenName = givenName;
    }
    
    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url = url;
    }
    
    public String getWfsVersion(){
        return wfsVersion;
    }
    public void setWfsVersion(String wfsVersion){
        this.wfsVersion = wfsVersion;
    }
    
    public Date getUpdatedDate(){
        return updatedDate;
    }
    public void setUpdatedDate(Date updatedDate){
        this.updatedDate = updatedDate;
    }
    
}
