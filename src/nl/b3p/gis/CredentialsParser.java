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

/*
 * CredentialsParser.java
 *
 * Created on June 22, 2012, 3:30 PM
 *
 * Class to generate a HttpClient and adding the credentials for DIGEST and BASIC autorisation
 */

package nl.b3p.gis;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthPolicy;
import org.apache.commons.httpclient.auth.AuthScope;

/**
 *
 * @author rachelle
 */
public class CredentialsParser {
    private static int RTIMEOUT = 20000;
    private static int port = AuthScope.ANY_PORT;
    
    /**
     * Generates the authentication HttpClient with default port (any) and default timeout
     * 
     * @param url           The URL
     * @param username      The username
     * @param password      The password
     * @return HttpClient
     */
    public static HttpClient HttpClientCredentials(String url,String username,String password){
        return CredentialsParser.HttpClientCredentials(url,username,password,CredentialsParser.port,CredentialsParser.RTIMEOUT);
    }
    
    /**
     * Generates the authentication HttpClient
     * 
     * @param url           The URL
     * @param username      The username
     * @param password      The password
     * @param port          The communication port (80|443)
     * @param timeout       The connection timeout in milliseconds
     * @return HttpClient
     */
    public static HttpClient HttpClientCredentials(String url,String username,String password,int port,int timeout){
        HttpClient client   = new HttpClient();  
        client.getHttpConnectionManager().getParams().setConnectionTimeout(RTIMEOUT);
        
        if( username != null ){
            client.getParams().setAuthenticationPreemptive(true);
            
            if( port != 80 && port != 443 ) port    = CredentialsParser.port;
            
            List authPrefs = new ArrayList(2);
            authPrefs.add(AuthPolicy.DIGEST);
            authPrefs.add(AuthPolicy.BASIC);
            // This will exclude the NTLM authentication scheme
            client.getParams().setParameter(AuthPolicy.AUTH_SCHEME_PRIORITY, authPrefs);

            UsernamePasswordCredentials defaultcreds = new UsernamePasswordCredentials(username, password);
            AuthScope scope = new AuthScope(url, port, AuthScope.ANY_REALM);
            client.getState().setCredentials(scope, defaultcreds);
        }
        
        return client;
    }
}
