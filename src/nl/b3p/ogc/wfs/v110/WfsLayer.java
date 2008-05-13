/*
 * WfsLayer.java
 *
 * Created on May 8, 2008, 3:36 PM
 *
 */

package nl.b3p.ogc.wfs.v110;

import nl.b3p.wms.capabilities.ServiceProvider;

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
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    
    public void setMetaData(String metaData){
        this.metaData = metaData;
    }
    public String getMetaData(){
        return metaData;
    }
    
    public void setWfsServiceProvider(WfsServiceProvider wfsServiceProvider){
        this.wfsServiceProvider = wfsServiceProvider;
    }
    public WfsServiceProvider getWfsServiceProvider(){
        return wfsServiceProvider;
    }
}
