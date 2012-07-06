package nl.b3p.gis;

import nl.b3p.ogc.wfs.v110.WfsServiceProvider;
import nl.b3p.wms.capabilities.ServiceProvider;

/**
 *
 * @author rachelle
 */
public class B3PCredentials {
    private String userName = null;
    private String password = null;
    private String proxyHost = null;
    private int proxyPort  = 80;
    private String proxyUserName = null;
    private String proxyPassword = null;
    
    public void parseCredentials(WfsServiceProvider sp){
        this.userName   = sp.getUsername();
        this.password   = sp.getPassword();
    }
    
    public void parseCredentials(ServiceProvider sp){
        this.userName   = sp.getUserName();
        this.password   = sp.getPassword();
    }
    
    public String getUserName(){
        return this.userName;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setPassword(String password){
        this.password   = password;
    }
    
    public String getProxyHost(){
        return this.proxyHost;
    }
    
    public void setProxyHost(String proxyHost){
        this.proxyHost  = proxyHost;
    }
    
    public int getProxyPort(){
        return this.proxyPort;
    }
    
    public void setProxyPort(int proxyPort){
        this.proxyPort  = proxyPort;
    }
    
    public String getProxyUserName(){
        return this.proxyUserName;
    }    
    
    public void setProxyUserName(String proxyUserName){
        this.proxyUserName  = proxyUserName;
    }
    
    public String getProxyPassword(){
        return this.proxyPassword;
    }    
    
    public void setProxyPassword(String proxyPassword){
        this.proxyPassword  = proxyPassword;
    }
}
