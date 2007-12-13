/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.b3p.ogc.utils;

import java.io.InputStreamReader;
import java.io.Reader;
//import nl.b3p.xml.wfs.v110.WFS_Capabilities;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

/**
 *
 * @author Roy
 */
public class OgcWfsClient {

    public static nl.b3p.xml.wfs.v110.WFS_Capabilities getCapabilitiesVersion110(OGCRequest or) throws ValidationException, Exception{
        or.addOrReplaceParameter(OGCRequest.WMS_SERVICE, OGCRequest.WFS_SERVICE_WFS);
        or.addOrReplaceParameter(OGCRequest.WMS_REQUEST, OGCRequest.WFS_REQUEST_GetCapabilities);
        HttpClient client = new HttpClient();
        String host = or.getUrlWithNonOGCparams();
        PostMethod method = new PostMethod(host);
        String body = or.getXMLBody();
        method.setRequestEntity(new StringRequestEntity(body, "text/xml", "UTF-8"));
        int status = client.executeMethod(method);
        if (status == HttpStatus.SC_OK) {
            //log.debug("Response ok, trying to create FeatureCollection....");
            Reader r = new InputStreamReader(method.getResponseBodyAsStream());
            Unmarshaller um = new Unmarshaller(nl.b3p.xml.wfs.v110.WFS_Capabilities.class);
            try{
                Object o = um.unmarshal(r);
                return (nl.b3p.xml.wfs.v110.WFS_Capabilities)o;
            }catch(ValidationException v){
                um=new Unmarshaller(nl.b3p.xml.ows.v100.ExceptionReport.class);
                Object ex=um.unmarshal(r);
            }
            catch(MarshalException v){
                um=new Unmarshaller(nl.b3p.xml.ows.v100.ExceptionReport.class);
                Object ex=um.unmarshal(r);
            }
            
        }
        return null;
    }
    public static nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities getCapabilitiesVersion100(OGCRequest or) throws ValidationException, Exception {
        or.addOrReplaceParameter(OGCRequest.WMS_SERVICE, OGCRequest.WFS_SERVICE_WFS);
        or.addOrReplaceParameter(OGCRequest.WMS_REQUEST, OGCRequest.WFS_REQUEST_GetCapabilities);
        HttpClient client = new HttpClient();
        String host = or.getUrlWithNonOGCparams();
        PostMethod method = new PostMethod(host);
        String body = or.getXMLBody();
        method.setRequestEntity(new StringRequestEntity(body, "text/xml", "UTF-8"));
        int status = client.executeMethod(method);
        if (status == HttpStatus.SC_OK) {
            //log.debug("Response ok, trying to create FeatureCollection....");
            String s= method.getResponseBodyAsString();            
            StringReader r = new StringReader(s);
            //Element resultElement= readXml2Element(r);
            
            Unmarshaller um = new Unmarshaller(nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities.class);
            Object o = um.unmarshal(r);
            return (nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities)o;
        }
        return null;
    }
    
    protected static Element readXml2Element(Reader src) throws Exception {
        Document doc = null;
        
        InputSource ips = new InputSource(src);
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);

        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.parse( ips );
        return doc.getDocumentElement();
    }
}
