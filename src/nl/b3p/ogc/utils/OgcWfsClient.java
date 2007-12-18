/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.b3p.ogc.utils;

import com.vividsolutions.wms.Capabilities;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import javax.print.Doc;
import nl.b3p.xml.ogc.v100.exception.ServiceException;
import nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport;
import nl.b3p.xml.wfs.FeatureTypeList;
import nl.b3p.xml.wfs.WFS_Capabilities;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author Roy
 */
public class OgcWfsClient {
    private static final Log log = LogFactory.getLog(OgcWfsClient.class);
    
    public static WFS_Capabilities getCapabilities(OGCRequest or) throws Exception{
        WFS_Capabilities returnvalue;
        or.addOrReplaceParameter(OGCRequest.WMS_SERVICE, OGCRequest.WFS_SERVICE_WFS);
        or.addOrReplaceParameter(OGCRequest.WMS_REQUEST, OGCRequest.WFS_REQUEST_GetCapabilities);        
        HttpClient client = new HttpClient();
        String host = or.getUrlWithNonOGCparams();
        PostMethod method = new PostMethod(host);
        String body = or.getXMLBody();
        method.setRequestEntity(new StringRequestEntity(body, "text/xml", "UTF-8"));
        int status = client.executeMethod(method);
        if (status == HttpStatus.SC_OK) {
            String s=method.getResponseBodyAsString();
            Element el=readXml2Element(new StringReader(s));
            if (el.getTagName().equalsIgnoreCase(OGCConstants.WFS_OBJECT_CAPABILITIES)){
                String version=el.getAttribute(OGCConstants.WMS_VERSION.toLowerCase());
                if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)){
                    return getCapabilitiesVersion100(el);
                }else if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_110)){
                    return getCapabilitiesVersion110(el);
                }else{
                    throw new UnsupportedOperationException("WFS GetCapabilities version: "+version+" not supported");
                }
            }else{
                throw new Exception ("Unsuspected element returned: "+el.getTagName());
            }
        }else{
            log.error("Url returned status: "+status);            
            return null;           
        }
        
    }
    
    public static Element getDescribeFeatureType(OGCRequest or) throws Exception{
        Element returnvalue = null;
        or.addOrReplaceParameter(OGCRequest.WMS_SERVICE, OGCRequest.WFS_SERVICE_WFS);
        or.addOrReplaceParameter(OGCRequest.WMS_REQUEST, OGCRequest.WFS_REQUEST_DiscribeFeatureType);        
        HttpClient client = new HttpClient();
        String host = or.getUrlWithNonOGCparams();
        PostMethod method = new PostMethod(host);
        String body = or.getXMLBody();
        method.setRequestEntity(new StringRequestEntity(body, "text/xml", "UTF-8"));
        int status = client.executeMethod(method);
        if (status == HttpStatus.SC_OK) {
            returnvalue=readXml2Element(new InputStreamReader(method.getResponseBodyAsStream()));
            if (returnvalue.getTagName().equalsIgnoreCase(OGCConstants.WFS_OBJECT_SERVICEEXCEPTIONREPORT)){
                ServiceExceptionReport ser= getServiceExceptionReport(returnvalue);
                StringBuffer sb=new StringBuffer();
                for (int i=0; i < ser.getServiceExceptionCount(); i++){
                    ServiceException se= ser.getServiceException(i);
                    sb.append(se.getContent());
                    sb.append(" and ");                    
                }
                log.error(sb.toString());
                return null;
            }            
        }else{
           log.error("Url returned status: "+status);            
           return null;
        }
        return returnvalue;
    }
    
    public static ServiceExceptionReport getServiceExceptionReport(Element element) throws MarshalException, ValidationException{
        Unmarshaller um = new Unmarshaller(ServiceExceptionReport.class);
        Object o = um.unmarshal(element);
        return (ServiceExceptionReport)o;   
    }
    
    private static nl.b3p.xml.wfs.v110.WFS_Capabilities getCapabilitiesVersion110(Element element) throws ValidationException, Exception{
        //log.debug("Response ok, trying to create FeatureCollection....");            
        Unmarshaller um = new Unmarshaller(nl.b3p.xml.wfs.v110.WFS_Capabilities.class);
        Object o = um.unmarshal(element);
        return (nl.b3p.xml.wfs.v110.WFS_Capabilities)o;                
    }
    private static nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities getCapabilitiesVersion100(Element element) throws ValidationException, Exception {
        Unmarshaller um = new Unmarshaller(nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities.class);
        Object o = um.unmarshal(element);
        return (nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities)o;        
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
