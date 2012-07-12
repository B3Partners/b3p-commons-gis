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
 *
 * Created on June 22, 2012, 3:30 PM
 *
 * Class to generate a HttpClient and adding the credentials for DIGEST and BASIC autorisation
 * 
 * @author Rachelle Scheijen
 */

package nl.b3p.gis;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.auth.AuthPolicy;
import org.apache.commons.httpclient.auth.AuthScope;

public class CredentialsParser {
    public static final int RTIMEOUT = 20000;
    public static final int PORT = AuthScope.ANY_PORT;
    public static final String HOST = AuthScope.ANY_HOST; // "localhost";
    public static final HttpVersion HTTP_VERSION = HttpVersion.HTTP_1_1;
    
    /**
     * Generates the authentication HttpClient with default settings
     * 
     * @return HttpClient
     */
    public static HttpClient CommonsHttpClientCredentials(){
        return CredentialsParser.CommonsHttpClientCredentials(null, HOST, PORT, RTIMEOUT,HTTP_VERSION);
    }
            
    /**
     * Generates the authentication HttpClient with default host, default port (any) and default timeout
     * 
     * @param credentials   The credentials
     * @return HttpClient
     */
    public static HttpClient CommonsHttpClientCredentials(B3PCredentials credentials){
        return CredentialsParser.CommonsHttpClientCredentials(credentials,HOST,PORT,RTIMEOUT,HTTP_VERSION);
    }
    
    
    /**
     * Generates the authentication HttpClient
     * 
     * @param credentials   The credentials 
     * @param url           The host URL
     * @param port          The communication port (80|443)
     * @param timeout       The connection timeout in milliseconds
     * @return HttpClient
     */
    public static HttpClient CommonsHttpClientCredentials(B3PCredentials credentials,String url,int port,int timeout){
        return CredentialsParser.CommonsHttpClientCredentials(credentials,url,port,timeout,HTTP_VERSION);
    }
        
    /**
     * Generates the authentication HttpClient
     * 
     * @param credentials   The credentials 
     * @param url           The host URL
     * @param port          The communication port (80|443)
     * @param timeout       The connection timeout in milliseconds
     * @param http_version  The http version
     * @return HttpClient
     */
    public static HttpClient CommonsHttpClientCredentials(B3PCredentials credentials,String url,int port,int timeout,HttpVersion http_version){
        HttpClient client   = new HttpClient();  
        client.getHttpConnectionManager().getParams().setConnectionTimeout(RTIMEOUT);
        
        HttpVersion version = HttpVersion.HTTP_1_1;
        if( http_version == HttpVersion.HTTP_0_9 || http_version == HttpVersion.HTTP_1_0 ){
            version = http_version;
        }
        
        client.getParams().setParameter("http.protocol.version", version);
        
        if (credentials == null || credentials.getPassword() == null) {
            return client;
        }
        
        if ( credentials.getUserName() != null && credentials.getPassword() != null) {
            client.getParams().setAuthenticationPreemptive(true);
            
            if( port != 80 && port != 443 ) port    = CredentialsParser.PORT;
            
            List authPrefs = new ArrayList(2);
            authPrefs.add(AuthPolicy.DIGEST);
            authPrefs.add(AuthPolicy.BASIC);
            // This will exclude the NTLM authentication scheme
            client.getParams().setParameter(AuthPolicy.AUTH_SCHEME_PRIORITY, authPrefs);
            UsernamePasswordCredentials defaultcreds = new UsernamePasswordCredentials(credentials.getUserName(), credentials.getPassword());
            AuthScope scope = new AuthScope(url, port);
            client.getState().setCredentials(scope, defaultcreds);
        }
        
        if( credentials.getProxyHost() != null ){
            client  = CredentialsParser.setProxy(client, credentials);
        }
        
        return client;
    }
    
    /**
     * Adds a proxy to the HttpClient
     * 
     * @param client        The HttpClient
     * @param credentials   The credentials
     * @return The modified HttpClient
     */
    public static HttpClient setProxy(HttpClient client,B3PCredentials credentials){
        HostConfiguration config = client.getHostConfiguration();
        config.setProxy(credentials.getProxyHost(), credentials.getProxyPort());
        
        if( credentials.getProxyUserName() != null && credentials.getProxyPassword() != null ){
            Credentials pCredentials = new UsernamePasswordCredentials(credentials.getProxyUserName(), credentials.getProxyPassword());
            AuthScope authScope = new AuthScope(credentials.getProxyHost(), credentials.getProxyPort());

            client.getState().setProxyCredentials(authScope, pCredentials);
        }
        
        return client;
    }
}
