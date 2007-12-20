/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.b3p.ogc.utils;

import com.vividsolutions.wms.Capabilities;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.print.Doc;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import nl.b3p.xml.ogc.v100.exception.ServiceException;
import nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport;
import nl.b3p.xml.wfs.DescribeFeatureType;
import nl.b3p.xml.wfs.FeatureTypeList;
import nl.b3p.xml.wfs.GetFeature;
import nl.b3p.xml.wfs.WFS_Capabilities;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import nl.b3p.xml.wfs.v100.GetCapabilities;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.exolab.castor.types.AnyNode;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 *
 * @author Roy
 */
public class OgcWfsClient {
    private static final Log log = LogFactory.getLog(OgcWfsClient.class);
    
    public static WFS_Capabilities getCapabilities(OGCRequest original) throws Exception{
        WFS_Capabilities returnvalue;
        OGCRequest or=(OGCRequest) original.clone();
        or.addOrReplaceParameter(OGCRequest.WMS_SERVICE, OGCRequest.WFS_SERVICE_WFS);
        or.addOrReplaceParameter(OGCRequest.WMS_REQUEST, OGCRequest.WFS_REQUEST_GetCapabilities);        
        HttpClient client = new HttpClient();
        String host = or.getUrlWithNonOGCparams();
        PostMethod method = new PostMethod(host);
        String body = getRequestBody(or);
        method.setRequestEntity(new StringRequestEntity(body, "text/xml", "UTF-8"));
        int status = client.executeMethod(method);
        if (status == HttpStatus.SC_OK) {
            Element el=readXml2Element(new InputStreamReader(method.getResponseBodyAsStream()));
            if (el.getTagName().contains(OGCConstants.WFS_OBJECT_CAPABILITIES)){
                String version=el.getAttribute(OGCConstants.WMS_VERSION.toLowerCase());
                if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)){                    
                    original.addOrReplaceParameter(OGCRequest.WMS_VERSION,version);
                    return getCapabilitiesVersion100(el);
                }else if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_110)){
                    original.addOrReplaceParameter(OGCRequest.WMS_VERSION,version);
                    return getCapabilitiesVersion110(el);
                }else{
                    throw new UnsupportedOperationException("WFS GetCapabilities version: "+version+" not supported");
                }
                
            }else{
                throw new Exception ("Unsuspected element returned: "+el.getTagName());
            }
        }else{
            throw new Exception("Url returned status: "+status + ": "+method.getResponseBodyAsString());            
                    
        }
        
    }
    
    public static Element getDescribeFeatureType(OGCRequest original) throws Exception{
        Element returnvalue = null;
        OGCRequest or=(OGCRequest) original.clone();
        or.addOrReplaceParameter(OGCRequest.WMS_SERVICE, OGCRequest.WFS_SERVICE_WFS);
        or.addOrReplaceParameter(OGCRequest.WMS_REQUEST, OGCRequest.WFS_REQUEST_DescribeFeatureType);
        if (or.getParameter(OGCRequest.WMS_VERSION)==null){
            getCapabilities(or);
        }
        HttpClient client = new HttpClient();
        String host = or.getUrlWithNonOGCparams();
        PostMethod method = new PostMethod(host);
        String body = getRequestBody(or);
        method.setRequestEntity(new StringRequestEntity(body, "text/xml", "UTF-8"));
        int status = client.executeMethod(method);
        if (status == HttpStatus.SC_OK) {
            returnvalue=readXml2Element(new InputStreamReader(method.getResponseBodyAsStream()));
            if (returnvalue.getTagName().equalsIgnoreCase(OGCConstants.WFS_OBJECT_SERVICEEXCEPTIONREPORT)){
                ServiceExceptionReport ser= getServiceExceptionReport(returnvalue);
                StringBuffer sb=new StringBuffer();
                ServiceException se=null;
                for (int i=0; i < ser.getServiceExceptionCount(); i++){
                    se= ser.getServiceException(i);
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
    /***/
    public static NodeList getFeatureElements(OGCRequest or) throws Exception{
            Element el=OgcWfsClient.getDescribeFeatureType(or);            
            if (el==null)
                return null;
            NodeList nlist=el.getElementsByTagName("complexType");
            if (!(nlist.getLength()>0))
                nlist=el.getElementsByTagName("xsd:complexType");
            if (!(nlist.getLength()>0)){
                log.error("no complexType element found");
                return null;
            }
            NodeList nl=((Element)nlist.item(0)).getElementsByTagName("element");
            if (nl==null || !(nl.getLength()>0))
                nl=((Element)nlist.item(0)).getElementsByTagName("xsd:element");
            return nl;
    }
    /**Get the DescribeFeaturetype Request object.
     */
    public static DescribeFeatureType getDescribeFeatureTypeRequest(OGCRequest or) throws Exception{
        if (or.getParameter(OGCRequest.WMS_REQUEST).equalsIgnoreCase(or.WFS_REQUEST_DescribeFeatureType)) {
            DescribeFeatureType dft=null;
            if(or.getParameter(OGCRequest.WMS_VERSION)==null){
                getCapabilities(or);
            }
            if (or.getParameter(OGCRequest.WMS_VERSION).equalsIgnoreCase(OGCRequest.WFS_VERSION_100)){
                dft=new nl.b3p.xml.wfs.v100.DescribeFeatureType();
            }else if (or.getParameter(OGCRequest.WMS_VERSION).equalsIgnoreCase(OGCRequest.WFS_VERSION_100)){
                dft=new nl.b3p.xml.wfs.v110.DescribeFeatureType();
            }else{
                throw new UnsupportedOperationException("WFS DescribeFeatureTypeRequest version: "+or.getParameter(OGCRequest.WMS_VERSION)+" not supported");
            }            
            if (or.getParameter(OGCRequest.WMS_VERSION) != null) {
                dft.setVersion(or.getParameter(OGCRequest.WMS_VERSION));
            }
            if (or.getParameter(OGCRequest.WMS_SERVICE) != null) {
                dft.setService(or.getParameter(OGCRequest.WMS_SERVICE));
            }
            if (or.getParameter(OGCRequest.WFS_PARAM_OUTPUTFORMAT) != null) {
                dft.setOutputFormat(or.getParameter(OGCRequest.WFS_PARAM_OUTPUTFORMAT));
            } else {
                //temp oplossing. Default value wordt niet ondersteund....
                dft.setOutputFormat(null);
            }
            if (or.getParameter(OGCRequest.WFS_PARAM_TYPENAME) != null) {
                String[] types = or.getParameter(OGCRequest.WFS_PARAM_TYPENAME).split(",");
                for (int i = 0; i < types.length; i++) {
                    dft.addTypeName(types[i]);
                }
            }
            return dft;
            
        }
        return null;
    }
    /**
     */
    public static GetCapabilities getGetCapabilitiesRequest(OGCRequest or) {
        GetCapabilities gc = new GetCapabilities();
        gc.setService(OGCRequest.WFS_SERVICE_WFS);
        return gc;
    }
    /**
     *
     */
    public static GetFeature getGetFeatureRequest(OGCRequest or) throws MarshalException, ValidationException, Exception{
        GetFeature gf=null;
        if (or.getParameter(OGCRequest.WMS_REQUEST).equalsIgnoreCase(OGCRequest.WFS_REQUEST_GetFeature)) {
            if(or.getParameter(OGCRequest.WMS_VERSION)==null){
                getCapabilities(or);
            }
            if (or.getParameter(OGCRequest.WMS_VERSION).equalsIgnoreCase(OGCRequest.WFS_VERSION_100)){
                gf=new nl.b3p.xml.wfs.v100.GetFeature();
            }else if (or.getParameter(OGCRequest.WMS_VERSION).equalsIgnoreCase(OGCRequest.WFS_VERSION_100)){
                gf=new nl.b3p.xml.wfs.v110.GetFeature();
            }else{
                throw new UnsupportedOperationException("WFS DescribeFeatureTypeRequest version: "+or.getParameter(OGCRequest.WMS_VERSION)+" not supported");
            }    
            if (or.getParameter(OGCRequest.WMS_VERSION) != null) {
                gf.setVersion(or.getParameter(OGCRequest.WMS_VERSION));
            }
            if (or.getParameter(OGCRequest.WMS_SERVICE) != null) {
                gf.setService(or.getParameter(OGCRequest.WMS_SERVICE));
            }
            if (or.getParameter(OGCRequest.WFS_PARAM_OUTPUTFORMAT) != null) {
                gf.setOutputFormat(or.getParameter(OGCRequest.WFS_PARAM_OUTPUTFORMAT));
            }
            if (gf instanceof nl.b3p.xml.wfs.v100.GetFeature){
                nl.b3p.xml.wfs.v100.GetFeature gfv100=(nl.b3p.xml.wfs.v100.GetFeature)gf;
                nl.b3p.xml.wfs.v100.Query q = new nl.b3p.xml.wfs.v100.Query();
                if (or.getParameter(OGCRequest.WFS_PARAM_TYPENAME) != null) {
                    StringBuffer s = new StringBuffer();
                    String[] typenames = or.getParameter(OGCRequest.WFS_PARAM_TYPENAME).split(",");
                    for (int i = 0; i < typenames.length; i++) {
                        if (i != 0) {
                            s.append(",");
                        }
                        s.append(typenames[i]);
                    }
                    q.setTypeName(s.toString());
                }
                if (or.getParameter(OGCRequest.WFS_PARAM_FILTER) != null) {
                    try{
                        nl.b3p.xml.ogc.v100.Filter f=(nl.b3p.xml.ogc.v100.Filter)Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.Filter.class, new StringReader(or.getParameter(OGCRequest.WFS_PARAM_FILTER)));                    
                        q.setFilter(f);
                    }catch(Exception e){
                        log.error("Filter v100 (WFS version 1.0.0) not correct",e);
                    }
                } else if (or.getParameter(OGCRequest.WMS_PARAM_BBOX) != null) {                    
                    //todo: msGeometry is nog hard er ingezet omdat er vanuit wordt gegaan dat mapserver altijd 1.0.0 versie gebruikt en degree 1.1.0
                    StringBuffer s = new StringBuffer();
                    String[] tokens = or.getParameter(OGCRequest.WMS_PARAM_BBOX).split(",");
                    s.append("<Filter><BBOX><PropertyName>msGeometry</PropertyName><Box><coordinates>");
                    s.append(tokens[0] + "," + tokens[1] + " " + tokens[2] + "," + tokens[3]);
                    s.append("</coordinates></Box></BBOX></Filter>");
                    nl.b3p.xml.ogc.v100.Filter f=(nl.b3p.xml.ogc.v100.Filter)Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.Filter.class, new StringReader(s.toString()));
                    q.setFilter(f);
                }                
            }else if (gf instanceof nl.b3p.xml.wfs.v110.GetFeature){
                nl.b3p.xml.wfs.v110.GetFeature gfv110=(nl.b3p.xml.wfs.v110.GetFeature)gf;
                nl.b3p.xml.wfs.v110.Query q = new nl.b3p.xml.wfs.v110.Query();                
                if (or.getParameter(OGCRequest.WFS_PARAM_TYPENAME) != null) {
                    String[] typenames = or.getParameter(OGCRequest.WFS_PARAM_TYPENAME).split(",");
                    for (int i = 0; i < typenames.length; i++) {
                        q.addTypeName(typenames[i]);
                    }                    
                }
                if (or.getParameter(OGCRequest.WMS_PARAM_SRS) != null) {
                    q.setSrsName(or.getParameter(OGCRequest.WMS_PARAM_SRS));
                }
                if (or.getParameter(OGCRequest.WFS_PARAM_FILTER) != null) {
                    try{
                        nl.b3p.xml.ogc.v110.Filter f=(nl.b3p.xml.ogc.v110.Filter)Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.Filter.class, new StringReader(or.getParameter(OGCRequest.WFS_PARAM_FILTER)));                    
                        q.setFilter(f);
                    }catch(Exception e){
                        log.error("Filter v110 (WFS version 1.1.0) not correct",e);
                    }

                } else if (or.getParameter(OGCRequest.WMS_PARAM_BBOX) != null) {
                    StringBuffer s = new StringBuffer();
                    String[] tokens = or.getParameter(OGCRequest.WMS_PARAM_BBOX).split(",");
                    s.append("<Filter><BBOX><PropertyName>msGeometry</PropertyName><Box><coordinates>");
                    s.append(tokens[0] + "," + tokens[1] + " " + tokens[2] + "," + tokens[3]);
                    s.append("</coordinates></Box></BBOX></Filter>");
                    nl.b3p.xml.ogc.v110.Filter f=(nl.b3p.xml.ogc.v110.Filter)Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.Filter.class, new StringReader(s.toString()));                    
                    q.setFilter(f);
                }
                gfv110.addQuery(q);
            }
        }
        return gf;
    }
    
    public static String getRequestBody (OGCRequest or) throws Exception{
        String body = null;
        Object castorObject=null;
        if (or.getParameter(OGCRequest.WMS_REQUEST) == null || or.getParameter(OGCRequest.WMS_REQUEST).length() <= 0) {
            return body;
        }
        if (or.getParameter(OGCRequest.WMS_REQUEST).equalsIgnoreCase(OGCRequest.WFS_REQUEST_DescribeFeatureType)) {
            castorObject=getDescribeFeatureTypeRequest(or);
        } else if (or.getParameter(OGCRequest.WMS_REQUEST).equalsIgnoreCase(OGCRequest.WFS_REQUEST_GetFeature)) {
            castorObject=getGetFeatureRequest(or);
        } else if (or.getParameter(OGCRequest.WMS_REQUEST).equalsIgnoreCase(OGCRequest.WFS_REQUEST_GetCapabilities)) {
            castorObject=getGetCapabilitiesRequest(or);
        } else {
            throw new UnsupportedOperationException("Request: " + or.getParameter(OGCRequest.WMS_REQUEST) + " wordt (nog) niet ondersteund");
        }
        StringWriter sw = new StringWriter();
        Marshaller m = new Marshaller(sw);
        if (or.getNameSpaces() != null) {
            Set mapEntries = or.getNameSpaces().entrySet();
            Iterator it = mapEntries.iterator();
            while (it.hasNext()) {
                Map.Entry me = (Map.Entry)it.next();
                m.setNamespaceMapping((String) me.getKey(), (String) me.getValue());
            }
        }
        m.setNamespaceMapping("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        m.setSchemaLocation("http://www.opengis.net/wfs ../wfs/1.1.0/WFS.xsd");
        if (castorObject != null) {
            m.marshal(castorObject);
            body = sw.toString();
        }
        return body;
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
    private static AnyNode xmlStringToAnyNode(String xml) throws ParserConfigurationException, SAXException, IOException {
        AnyNode anyNode = null;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XMLReader reader = saxParser.getXMLReader();

        org.exolab.castor.xml.util.SAX2ANY handler = new org.exolab.castor.xml.util.SAX2ANY();

        reader.setContentHandler(handler);
        reader.setErrorHandler(handler);
        InputSource source = new InputSource(new StringReader(xml));
        reader.parse(source);

        anyNode = handler.getStartingNode();

        return anyNode;
    }

    
    
}
