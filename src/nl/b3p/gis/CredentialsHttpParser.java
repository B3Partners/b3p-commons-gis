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

import java.io.IOException;
import java.net.URL;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.AuthCache;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

public class CredentialsHttpParser {
    public static final int RTIMEOUT = 20000;
    public static final int PORT = AuthScope.ANY_PORT;
    public static final String HOST = AuthScope.ANY_HOST; // "localhost";
    public static final ProtocolVersion HTTP_VERSION2 = new org.apache.http.ProtocolVersion("HTTP",1,1);
        
    /**
     * Generates the authentication HttpClient with default settings
     * 
     * @return HttpClient
     */
    public static DefaultHttpClient HttpClientCredentials() throws IOException{
        return CredentialsHttpParser.HttpClientCredentials(null, HOST, PORT, RTIMEOUT,HTTP_VERSION2);
    }
            
    /**
     * Generates the authentication HttpClient with default host, default port (any) and default timeout
     * 
     * @param credentials   The credentials
     * @return HttpClient
     */
    public static DefaultHttpClient HttpClientCredentials(B3PCredentials credentials) throws IOException{
        return CredentialsHttpParser.HttpClientCredentials(credentials,HOST,PORT,RTIMEOUT,HTTP_VERSION2);
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
    public static DefaultHttpClient HttpClientCredentials(B3PCredentials credentials,String url,int port,int timeout) throws IOException{
        return CredentialsHttpParser.HttpClientCredentials(credentials,url,port,timeout,HTTP_VERSION2);
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
    public static DefaultHttpClient HttpClientCredentials(B3PCredentials credentials,String url,int port,int timeout,org.apache.http.ProtocolVersion http_version) throws IOException{        
        if( !http_version.getProtocol().equalsIgnoreCase("HTTP") || !((http_version.getMajor() == 0 && http_version.getMinor() != 9) || (http_version.getMajor() == 1 && http_version.getMinor() != 0) || (http_version.getMajor() == 1 && http_version.getMinor() != 1) ) ){
            http_version = HTTP_VERSION2;
        }
        
        if (port != 80 && port != 443) {
            port = CredentialsParser.PORT;
        }
        
        URL aURL = new URL(url);
        String hostname = aURL.getHost();
        
        org.apache.http.HttpHost targetHost = new org.apache.http.HttpHost(hostname, port); 

        DefaultHttpClient httpclient = new DefaultHttpClient();
        
        httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,RTIMEOUT);
        httpclient.getParams().setParameter("http.protocol.version", http_version);

        if (credentials == null || credentials.getPassword() == null || credentials.getPassword().equals("")) {
            return httpclient;
        }

        org.apache.http.auth.AuthScope scope = new org.apache.http.auth.AuthScope(targetHost.getHostName(), targetHost.getPort());
        org.apache.http.auth.UsernamePasswordCredentials defaultcreds = new org.apache.http.auth.UsernamePasswordCredentials(credentials.getUserName(),credentials.getPassword());
        httpclient.getCredentialsProvider().setCredentials(scope,defaultcreds);

        // Create AuthCache instance
        AuthCache authCache = new BasicAuthCache();
        // Generate BASIC scheme object and add it to the local auth cache
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(targetHost, basicAuth);

        // Add AuthCache to the execution context
        BasicHttpContext localcontext = new BasicHttpContext();
        localcontext.setAttribute("preemptive-auth", basicAuth);
        localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache); 
        
        //if( credentials.getProxyHost() != null ){
          //  client  = CredentialsHttpParser.setProxy(client, credentials);
        //}
        
        //try {
        HttpGet httpget = new HttpGet(url);
            for (int i = 0; i < 3; i++) {
                HttpResponse response = httpclient.execute(targetHost, httpget, localcontext);
                HttpEntity entity = response.getEntity();
                EntityUtils.consume(entity);
            }
        //} catch (IOException ex) {}
        
        return httpclient;
    }
    
    /**
     * Adds a proxy to the HttpClient
     * 
     * @param client        The HttpClient
     * @param credentials   The credentials
     * @return The modified HttpClient
     */
    public static DefaultHttpClient setProxy(DefaultHttpClient client,B3PCredentials credentials){ /*
        HostConfiguration config = client. .getHostConfiguration();
        config.setProxy(credentials.getProxyHost(), credentials.getProxyPort());
        
        if( credentials.getProxyUserName() != null && credentials.getProxyPassword() != null ){
            Credentials pCredentials = new UsernamePasswordCredentials(credentials.getProxyUserName(), credentials.getProxyPassword());
            AuthScope authScope = new AuthScope(credentials.getProxyHost(), credentials.getProxyPort());

            client.getState().setProxyCredentials(authScope, pCredentials);
        }
        */
        return client;
    }
}
