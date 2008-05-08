/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.b3p.ogc.utils;

import com.vividsolutions.jump.feature.FeatureCollection;
import com.vividsolutions.jump.io.GMLInputTemplate;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import nl.b3p.gis.readers.B3pGMLReader;
import nl.b3p.xml.wfs.DescribeFeatureType;
import nl.b3p.xml.wfs.FeatureType;
import nl.b3p.xml.wfs.FeatureTypeList;
import nl.b3p.xml.wfs.Filter;
import nl.b3p.xml.wfs.GetCapabilities;
import nl.b3p.xml.wfs.GetFeature;
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
import org.apache.xerces.dom.DeferredElementNSImpl;
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
import org.xml.sax.XMLReader;

/**
 *
 * @author Roy
 */
public class OgcWfsClient {
    private static final Log log = LogFactory.getLog(OgcWfsClient.class);
    /**
     *Doe een getCapabilities request naar de host aangegeven in de OGCRequest die meegegeven wordt
     */
    public static WFS_Capabilities getCapabilities(OGCRequest original) throws Exception{
        WFS_Capabilities returnvalue;
        OGCRequest or=(OGCRequest) original.clone();
        or.addOrReplaceParameter(OGCConstants.WMS_SERVICE, OGCConstants.WFS_SERVICE_WFS);
        or.addOrReplaceParameter(OGCConstants.WMS_REQUEST, OGCConstants.WFS_REQUEST_GetCapabilities);
        String host = or.getUrlWithNonOGCparams();
        Element el=doRequest(getGetCapabilitiesRequest(or),host);
        if (el.getTagName().contains(OGCConstants.WFS_OBJECT_CAPABILITIES)){
            String version=el.getAttribute(OGCConstants.WMS_VERSION.toLowerCase());
            if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)){
                original.addOrReplaceParameter(OGCConstants.WMS_VERSION,version);
                return getCapabilitiesVersion100(el);
            }else if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_110)){
                original.addOrReplaceParameter(OGCConstants.WMS_VERSION,version);
                return getCapabilitiesVersion110(el);
            }else{
                throw new UnsupportedOperationException("WFS GetCapabilities version: "+version+" not supported");
            }
            
        }else{
            log.error("Unexpected element returned: "+el.getTagName());
            throw new Exception("Unexpected element returned: "+el.getTagName());
        }
    }
    /**
     *Doe een request naar de host die meegegeven is stuur het object als body
     *Kijkt tevens of het een serviceExceptionReport is en trowed dat dan als Exception.
     *@return het element dat terug gegeven wordt door de server
     */
    public static Element doRequest(Object o, String host) throws Exception{
        Element el=readXml2Element(new InputStreamReader(doRequestInputStreamReader(o,host)));
        if (el.getTagName().equalsIgnoreCase(OGCConstants.WFS_OBJECT_SERVICEEXCEPTIONREPORT)){
            nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport ser= getServiceExceptionReport(el);
            StringBuffer sb=new StringBuffer();
            nl.b3p.xml.ogc.v100.exception.ServiceException se=null;
            for (int i=0; i < ser.getServiceExceptionCount(); i++){
                if (i!=0)sb.append(" and ");
                se= ser.getServiceException(i);
                sb.append(se.getContent());
                
            }
            throw new Exception(sb.toString());
        }
        return el;
        
    }
    /**
     *Doet het request en returned het antwoord als iputstream. LetOp: checked niet of het een serviceExceptionReport is
     *
     */
    private static InputStream doRequestInputStreamReader(Object o, String host) throws Exception {
        String body = null;
        StringWriter sw = new StringWriter();
        Marshaller m = new Marshaller(sw);
        m.setMarshalAsDocument(false);
        m.setNamespaceMapping("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        m.setSchemaLocation("http://www.opengis.net/wfs ../wfs/1.1.0/WFS.xsd");
        m.setNamespaceMapping("wfs", "http://www.opengis.net/wfs");
        m.setNamespaceMapping("gml", "http://www.opengis.net/gml");
        m.setNamespaceMapping("ogc", "http://www.opengis.net/ogc");
        m.setNamespaceMapping("app", "http://www.deegree.org/app");
        m.marshal(o);
        body = sw.toString();
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(host);
        method.setRequestEntity(new StringRequestEntity(body, "text/xml", "UTF-8"));
        int status = client.executeMethod(method);
        if (status == HttpStatus.SC_OK) {
            return method.getResponseBodyAsStream();
        }else{
            log.error("Url returned status: "+status + ": "+method.getResponseBodyAsString());
            throw new Exception("Url returned status: "+status + ": "+method.getResponseBodyAsString());
        }
    }
    /**
     *Doe een getDescribeFeatureType request naar de host aangegeven in de OGCRequest die meegegeven wordt
     */
    public static Element getDescribeFeatureType(OGCRequest original) throws Exception{
        Element returnvalue = null;
        OGCRequest or=(OGCRequest) original.clone();
        or.addOrReplaceParameter(OGCConstants.WMS_SERVICE, OGCConstants.WFS_SERVICE_WFS);
        or.addOrReplaceParameter(OGCConstants.WMS_REQUEST, OGCConstants.WFS_REQUEST_DescribeFeatureType);
        String host = or.getUrlWithNonOGCparams();
        returnvalue=doRequest(getDescribeFeatureTypeRequest(or),host);
        return returnvalue;
    }
    /** Haal de elementen uit de describefeaturetype request
     */
    public static NodeList getDescribeFeatureElements(Element el) throws Exception{
        //Haal eerst de complexTypes type elementen op en de prefix.
        NodeList childs=el.getChildNodes();
        String prefix="";
        for (int i=0; i < childs.getLength() && prefix.length()==0; i++){
            Node n= childs.item(i);
            if (n instanceof DeferredElementNSImpl){
                Element e = (Element)n;
                if (e.getLocalName().equalsIgnoreCase("element")){
                    if(e.getAttribute("type")!=null && e.getAttribute("type").contains(":")){
                        prefix=e.getAttribute("type").split(":")[0];
                    }
                }
            }
        }
        String s=elementToString(el);
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
        if (prefix.length()>0){
            for (int i=0; i < nl.getLength(); i++){
                Element e=(Element) nl.item(i);
                e.setAttribute("name",prefix+":"+e.getAttribute("name"));
            }
        }
        return nl;
    }
    /**Get the feature in the capabilities with given name.
     *
     */
    public static FeatureType getCapabilitieFeatureType(WFS_Capabilities cap, String name){
        FeatureTypeList ftl=cap.getFeatureTypeList();
        for (int i=0; i < ftl.getFeatureTypeCount(); i++){
            FeatureType ft= ftl.getFeatureType(i);
            if (ft.getName().equalsIgnoreCase(name)){
                return ft;
            }
        }
        return null;
    }
    
    
    // *The request object functions.
    
    /**Get the DescribeFeaturetype Request object.
     */
    public static DescribeFeatureType getDescribeFeatureTypeRequest(OGCRequest original) throws Exception{
        OGCRequest or= (OGCRequest) original.clone();
        or.addOrReplaceParameter(OGCConstants.REQUEST,OGCConstants.WFS_REQUEST_DescribeFeatureType);
        DescribeFeatureType dft=null;
        if(or.getParameter(OGCConstants.VERSION)==null){
            getCapabilities(or);
            original.addOrReplaceParameter(OGCConstants.VERSION,or.getParameter(OGCConstants.VERSION));
        }
        if (or.getParameter(OGCConstants.VERSION).equalsIgnoreCase(OGCConstants.WFS_VERSION_100)){
            dft=new nl.b3p.xml.wfs.v100.DescribeFeatureType();
        }else if (or.getParameter(OGCConstants.VERSION).equalsIgnoreCase(OGCConstants.WFS_VERSION_110)){
            dft=new nl.b3p.xml.wfs.v110.DescribeFeatureType();
        }else{
            throw new UnsupportedOperationException("WFS DescribeFeatureTypeRequest version: "+or.getParameter(OGCConstants.VERSION)+" not supported");
        }
        if (or.getParameter(OGCConstants.VERSION) != null) {
            dft.setVersion(or.getParameter(OGCConstants.VERSION));
        }
        if (or.getParameter(OGCConstants.SERVICE) != null) {
            dft.setService(or.getParameter(OGCConstants.SERVICE));
        }
        if (or.getParameter(OGCConstants.WFS_PARAM_OUTPUTFORMAT) != null) {
            dft.setOutputFormat(or.getParameter(OGCConstants.WFS_PARAM_OUTPUTFORMAT));
        } else {
            //temp oplossing. Default value wordt niet ondersteund....
            dft.setOutputFormat(null);
        }
        if (or.getParameter(OGCConstants.WFS_PARAM_TYPENAME) != null) {
            String[] types = or.getParameter(OGCConstants.WFS_PARAM_TYPENAME).split(",");
            for (int i = 0; i < types.length; i++) {
                dft.addTypeName(types[i]);
            }
        }
        return dft;
    }
    /**Get the GetCapabilities request object
     */
    public static GetCapabilities getGetCapabilitiesRequest(OGCRequest or) {
        if(OGCConstants.WFS_VERSION_100.equalsIgnoreCase(or.getParameter(OGCConstants.VERSION))){
            nl.b3p.xml.wfs.v100.GetCapabilities gc = new nl.b3p.xml.wfs.v100.GetCapabilities();
            gc.setService(OGCConstants.WFS_SERVICE_WFS);
            gc.setVersion(or.getParameter(OGCConstants.VERSION));
            return gc;
        }
        
        nl.b3p.xml.wfs.v110.GetCapabilities gc = new nl.b3p.xml.wfs.v110.GetCapabilities();
        gc.setService(OGCConstants.WFS_SERVICE_WFS);
        return gc;
    }
    /**Get the GetFeature request object.
     *
     */
    public static GetFeature getGetFeatureRequest(OGCRequest original) throws MarshalException, ValidationException, Exception{
        OGCRequest or = (OGCRequest) original.clone();
        or.addOrReplaceParameter(OGCConstants.REQUEST,OGCConstants.WFS_REQUEST_GetFeature);
        
        GetFeature gf = null;
        if(or.getParameter(OGCConstants.VERSION)== null){
            getCapabilities(or);
            original.addOrReplaceParameter(OGCConstants.VERSION,or.getParameter(OGCConstants.VERSION));
        }
        if (or.getParameter(OGCConstants.VERSION).equalsIgnoreCase(OGCConstants.WFS_VERSION_100)){
            gf = new nl.b3p.xml.wfs.v100.GetFeature();
        }else if (or.getParameter(OGCConstants.VERSION).equalsIgnoreCase(OGCConstants.WFS_VERSION_110)){
            gf = new nl.b3p.xml.wfs.v110.GetFeature();
        }else{
            throw new UnsupportedOperationException("WFS GetFeatureRequest version: "+or.getParameter(OGCConstants.VERSION)+" not supported");
        }
        
        if (or.getParameter(OGCConstants.VERSION) != null) {
            gf.setVersion(or.getParameter(OGCConstants.VERSION));
        }
        if (or.getParameter(OGCConstants.SERVICE) != null) {
            gf.setService(or.getParameter(OGCConstants.SERVICE));
        }
        if (or.getParameter(OGCConstants.WFS_PARAM_OUTPUTFORMAT) != null) {
            gf.setOutputFormat(or.getParameter(OGCConstants.WFS_PARAM_OUTPUTFORMAT));
        }
        
        if (gf instanceof nl.b3p.xml.wfs.v100.GetFeature){
            nl.b3p.xml.wfs.v100.GetFeature gfv100 = (nl.b3p.xml.wfs.v100.GetFeature)gf;
            nl.b3p.xml.wfs.v100.Query q = new nl.b3p.xml.wfs.v100.Query();
            if (or.getParameter(OGCConstants.WFS_PARAM_TYPENAME) != null) {
                q.setTypeName(or.getParameter(OGCConstants.WFS_PARAM_TYPENAME));
                // lijkt zinloos om een komma gescheiden string eerst de , er uit te halen en ze er vervolgens weer tussen te plaatsen.
                /*StringBuffer s = new StringBuffer();
                String[] typenames = or.getParameter(OGCConstants.WFS_PARAM_TYPENAME).split(",");
                for (int i = 0; i < typenames.length; i++) {
                    if (i != 0) {
                        s.append(",");
                    }
                    s.append(typenames[i]);
                }
                q.setTypeName(s.toString());*/
            }
            if (or.getParameter(OGCConstants.WFS_PARAM_FILTER) != null) {
                try{
                    nl.b3p.xml.ogc.v100.Filter f=(nl.b3p.xml.ogc.v100.Filter)Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.Filter.class, new StringReader(or.getParameter(OGCConstants.WFS_PARAM_FILTER)));
                    q.setFilter(f);
                }catch(Exception e){
                    log.error("Filter v100 (WFS version 1.0.0) not correct",e);
                }
            }
            // It is doing nothing with te BBox yet. There always seems te be a filter when tere is a BBox.
            /*else if (or.getParameter(OGCConstants.WFS_PARAM_BBOX) != null) {
                //todo: msGeometry is nog hard er ingezet omdat er vanuit wordt gegaan dat mapserver altijd 1.0.0 versie gebruikt en degree 1.1.0
                StringBuffer s = new StringBuffer();
                String[] tokens = or.getParameter(OGCConstants.WMS_PARAM_BBOX).split(",");
                s.append("<Filter><BBOX><PropertyName>msGeometry</PropertyName><Box><coordinates>");
                s.append(tokens[0] + "," + tokens[1] + " " + tokens[2] + "," + tokens[3]);
                s.append("</coordinates></Box></BBOX></Filter>");
                nl.b3p.xml.ogc.v100.Filter f=(nl.b3p.xml.ogc.v100.Filter)Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.Filter.class, new StringReader(s.toString()));
                q.setFilter(f);
            }*/
            gfv100.addQuery(q);
        }else if (gf instanceof nl.b3p.xml.wfs.v110.GetFeature){
            nl.b3p.xml.wfs.v110.GetFeature gfv110 = (nl.b3p.xml.wfs.v110.GetFeature)gf;
            nl.b3p.xml.wfs.v110.Query q = new nl.b3p.xml.wfs.v110.Query();
            if (or.getParameter(OGCConstants.WFS_PARAM_TYPENAME) != null) {
                // lijkt zinloos om een komma gescheiden string eerst de , er uit te halen en ze er vervolgens weer tussen te plaatsen.
                q.setTypeName(or.getParameter(OGCConstants.WFS_PARAM_TYPENAME));
                /*String[] typenames = or.getParameter(OGCConstants.WFS_PARAM_TYPENAME).split(",");
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < typenames.length; i++) {
                    if (i!=0){
                        sb.append(",");
                    }
                    sb.append(typenames[i]);
                }
                q.setTypeName(sb.toString());*/
            }
            if (or.getParameter(OGCConstants.WFS_PARAM_SRSNAME) != null) {
                q.setSrsName(or.getParameter(OGCConstants.WFS_PARAM_SRSNAME));
            }
            if (or.getParameter(OGCConstants.WFS_PARAM_FILTER) != null) {
                try{
                    nl.b3p.xml.ogc.v110.Filter f = (nl.b3p.xml.ogc.v110.Filter)Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.Filter.class, new StringReader(or.getParameter(OGCConstants.WFS_PARAM_FILTER)));
                    q.setFilter(f);
                }catch(Exception e){
                    log.error("Filter v110 (WFS version 1.1.0) not correct",e);
                    // without throwing exception it goes on but without aplying filter
                    throw new UnsupportedOperationException("Filter is not correct!");
                }
            }
            // It is doing nothing with te BBox yet. There always seems te be a filter when tere is a BBox.
            /*else if (or.getParameter(OGCConstants.WFS_PARAM_BBOX) != null) {
                StringBuffer s = new StringBuffer();
                String[] tokens = or.getParameter(OGCConstants.WMS_PARAM_BBOX).split(",");
                s.append("<Filter><BBOX><PropertyName>msGeometry</PropertyName><Box><coordinates>");
                s.append(tokens[0] + "," + tokens[1] + " " + tokens[2] + "," + tokens[3]);
                s.append("</coordinates></Box></BBOX></Filter>");
                nl.b3p.xml.ogc.v110.Filter f=(nl.b3p.xml.ogc.v110.Filter)Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.Filter.class, new StringReader(s.toString()));
                q.setFilter(f);
            }*/
            gfv110.addQuery(q);
        }
        
        return gf;
    }
    
//        public static GetFeature getGetFeatureRequest(OGCRequest original) throws MarshalException, ValidationException, Exception{
//        OGCRequest or = (OGCRequest) original.clone();
//        or.addOrReplaceParameter(OGCConstants.WMS_REQUEST,OGCConstants.WFS_REQUEST_GetFeature);
//        GetFeature gf = null;
//        if(or.getParameter(OGCConstants.WMS_VERSION)==null){
//            getCapabilities(or);
//            original.addOrReplaceParameter(OGCConstants.WMS_VERSION,or.getParameter(OGCConstants.WMS_VERSION));
//        }
//        if (or.getParameter(OGCConstants.WMS_VERSION).equalsIgnoreCase(OGCConstants.WFS_VERSION_100)){
//            gf=new nl.b3p.xml.wfs.v100.GetFeature();
//        }else if (or.getParameter(OGCConstants.WMS_VERSION).equalsIgnoreCase(OGCConstants.WFS_VERSION_110)){
//            gf=new nl.b3p.xml.wfs.v110.GetFeature();
//        }else{
//            throw new UnsupportedOperationException("WFS DescribeFeatureTypeRequest version: "+or.getParameter(OGCConstants.WMS_VERSION)+" not supported");
//        }
//        if (or.getParameter(OGCConstants.WMS_VERSION) != null) {
//            gf.setVersion(or.getParameter(OGCConstants.WMS_VERSION));
//        }
//        if (or.getParameter(OGCConstants.WMS_SERVICE) != null) {
//            gf.setService(or.getParameter(OGCConstants.WMS_SERVICE));
//        }
//        if (or.getParameter(OGCConstants.WFS_PARAM_OUTPUTFORMAT) != null) {
//            gf.setOutputFormat(or.getParameter(OGCConstants.WFS_PARAM_OUTPUTFORMAT));
//        }
//        if (gf instanceof nl.b3p.xml.wfs.v100.GetFeature){
//            nl.b3p.xml.wfs.v100.GetFeature gfv100=(nl.b3p.xml.wfs.v100.GetFeature)gf;
//            nl.b3p.xml.wfs.v100.Query q = new nl.b3p.xml.wfs.v100.Query();
//            if (or.getParameter(OGCConstants.WFS_PARAM_TYPENAME) != null) {
//                StringBuffer s = new StringBuffer();
//                String[] typenames = or.getParameter(OGCConstants.WFS_PARAM_TYPENAME).split(",");
//                for (int i = 0; i < typenames.length; i++) {
//                    if (i != 0) {
//                        s.append(",");
//                    }
//                    s.append(typenames[i]);
//                }
//                q.setTypeName(s.toString());
//            }
//            if (or.getParameter(OGCConstants.WFS_PARAM_FILTER) != null) {
//                try{
//                    nl.b3p.xml.ogc.v100.Filter f=(nl.b3p.xml.ogc.v100.Filter)Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.Filter.class, new StringReader(or.getParameter(OGCConstants.WFS_PARAM_FILTER)));
//                    q.setFilter(f);
//                }catch(Exception e){
//                    log.error("Filter v100 (WFS version 1.0.0) not correct",e);
//                }
//            } else if (or.getParameter(OGCConstants.WMS_PARAM_BBOX) != null) {
//                //todo: msGeometry is nog hard er ingezet omdat er vanuit wordt gegaan dat mapserver altijd 1.0.0 versie gebruikt en degree 1.1.0
//                StringBuffer s = new StringBuffer();
//                String[] tokens = or.getParameter(OGCConstants.WMS_PARAM_BBOX).split(",");
//                s.append("<Filter><BBOX><PropertyName>msGeometry</PropertyName><Box><coordinates>");
//                s.append(tokens[0] + "," + tokens[1] + " " + tokens[2] + "," + tokens[3]);
//                s.append("</coordinates></Box></BBOX></Filter>");
//                nl.b3p.xml.ogc.v100.Filter f=(nl.b3p.xml.ogc.v100.Filter)Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.Filter.class, new StringReader(s.toString()));
//                q.setFilter(f);
//            }
//            gfv100.addQuery(q);
//        }else if (gf instanceof nl.b3p.xml.wfs.v110.GetFeature){
//            nl.b3p.xml.wfs.v110.GetFeature gfv110=(nl.b3p.xml.wfs.v110.GetFeature)gf;
//            nl.b3p.xml.wfs.v110.Query q = new nl.b3p.xml.wfs.v110.Query();
//            if (or.getParameter(OGCConstants.WFS_PARAM_TYPENAME) != null) {
//                String[] typenames = or.getParameter(OGCConstants.WFS_PARAM_TYPENAME).split(",");
//                StringBuffer sb = new StringBuffer();
//                for (int i = 0; i < typenames.length; i++) {
//                    if (i!=0){
//                        sb.append(",");
//                    }
//                    sb.append(typenames[i]);
//                }
//                q.setTypeName(sb.toString());
//            }
//            if (or.getParameter(OGCConstants.WMS_PARAM_SRS) != null) {
//                q.setSrsName(or.getParameter(OGCConstants.WMS_PARAM_SRS));
//            }
//            if (or.getParameter(OGCConstants.WFS_PARAM_FILTER) != null) {
//                try{
//                    nl.b3p.xml.ogc.v110.Filter f=(nl.b3p.xml.ogc.v110.Filter)Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.Filter.class, new StringReader(or.getParameter(OGCConstants.WFS_PARAM_FILTER)));
//                    q.setFilter(f);
//                }catch(Exception e){
//                    log.error("Filter v110 (WFS version 1.1.0) not correct",e);
//                }
//
//            } else if (or.getParameter(OGCConstants.WMS_PARAM_BBOX) != null) {
//                StringBuffer s = new StringBuffer();
//                String[] tokens = or.getParameter(OGCConstants.WMS_PARAM_BBOX).split(",");
//                s.append("<Filter><BBOX><PropertyName>msGeometry</PropertyName><Box><coordinates>");
//                s.append(tokens[0] + "," + tokens[1] + " " + tokens[2] + "," + tokens[3]);
//                s.append("</coordinates></Box></BBOX></Filter>");
//                nl.b3p.xml.ogc.v110.Filter f=(nl.b3p.xml.ogc.v110.Filter)Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.Filter.class, new StringReader(s.toString()));
//                q.setFilter(f);
//            }
//            gfv110.addQuery(q);
//        }
//
//        return gf;
//    }
    /***
     * The request parameter of the OGCRequest must be filled because it is used to choose the body returned.
     */
    public static String getRequestBody(OGCRequest or) throws Exception{
        String body = null;
        Object castorObject=null;
        if (or.getParameter(OGCConstants.REQUEST) == null || or.getParameter(OGCConstants.REQUEST).length() <= 0) {
            return body;
        }
        if (or.getParameter(OGCConstants.REQUEST).equalsIgnoreCase(OGCConstants.WFS_REQUEST_DescribeFeatureType)) {
            castorObject = getDescribeFeatureTypeRequest(or);
        } else if (or.getParameter(OGCConstants.REQUEST).equalsIgnoreCase(OGCConstants.WFS_REQUEST_GetFeature)) {
            castorObject = getGetFeatureRequest(or);
        } else if (or.getParameter(OGCConstants.REQUEST).equalsIgnoreCase(OGCConstants.WFS_REQUEST_GetCapabilities)) {
            castorObject = getGetCapabilitiesRequest(or);
        } else {
            throw new UnsupportedOperationException("Request: " + or.getParameter(OGCConstants.REQUEST) + " wordt (nog) niet ondersteund");
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
    /**
     *Unmarshal the object to a serviceexception report.
     */
    public static nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport getServiceExceptionReport(Element element) throws MarshalException, ValidationException{
        Unmarshaller um = new Unmarshaller(nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport.class);
        Object o = um.unmarshal(element);
        return (nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport)o;
    }
    
    public static nl.b3p.xml.wfs.v110.WFS_Capabilities getCapabilitiesVersion110(Element element) throws ValidationException, Exception{
        //log.debug("Response ok, trying to create FeatureCollection....");
        Unmarshaller um = new Unmarshaller(nl.b3p.xml.wfs.v110.WFS_Capabilities.class);
        Object o = um.unmarshal(element);
        return (nl.b3p.xml.wfs.v110.WFS_Capabilities)o;
    }
    public static nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities getCapabilitiesVersion100(Element element) throws ValidationException, Exception {
        Unmarshaller um = new Unmarshaller(nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities.class);
        Object o = um.unmarshal(element);
        return (nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities)o;
    }
    
    /**
     *Voegt een bbox toe aan het GetFeature object.
     */
    public static void addBboxFilter(GetFeature gf, String attributeName, double[] bbox, FeatureType ft) throws Exception {
        Filter filter= OgcWfsClient.createBboxFilter(attributeName,bbox, ft);
        if (gf instanceof nl.b3p.xml.wfs.v100.GetFeature){
            ((nl.b3p.xml.wfs.v100.GetFeature)gf).getQuery(0).setFilter((nl.b3p.xml.ogc.v100.Filter)filter);
        }else if (gf instanceof nl.b3p.xml.wfs.v110.GetFeature){
            ((nl.b3p.xml.wfs.v110.GetFeature)gf).getQuery(0).setFilter((nl.b3p.xml.ogc.v110.Filter)filter);
        }
    }
    /**
     *Creates a bbox filter
     */
    public static nl.b3p.xml.wfs.Filter createBboxFilter(String attributeName, double[] bbox, nl.b3p.xml.wfs.FeatureType feature) throws Exception{
        if (feature instanceof nl.b3p.xml.wfs.v100.capabilities.FeatureType){
            StringBuffer sb = new StringBuffer();
            sb.append("<Filter><BBOX><PropertyName>");
            sb.append(attributeName);
            sb.append("</PropertyName>");
            sb.append("<gml:Box srsName=\"");
            if (((nl.b3p.xml.wfs.v100.capabilities.FeatureType)feature).getSRS()!=null)
                sb.append(((nl.b3p.xml.wfs.v100.capabilities.FeatureType)feature).getSRS());
            else
                sb.append(28992);
            sb.append("\"><gml:coordinates>");
            sb.append(bbox[0]).append(",").append(bbox[1]);
            sb.append(" ");
            sb.append(bbox[2]).append(",").append(bbox[3]);
            sb.append("</gml:coordinates></gml:Box>");
            sb.append("</BBOX></Filter>");
            return (nl.b3p.xml.ogc.v100.Filter)Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.Filter.class, new StringReader(sb.toString()));
        }else if (feature instanceof nl.b3p.xml.wfs.v110.FeatureType){
            StringBuffer sb = new StringBuffer();
            sb.append("<Filter><Intersects><PropertyName>");
            sb.append(attributeName);
            //sb.append("app:geom");
            sb.append("</PropertyName>");
            sb.append("<gml:Envelope srsName=\"");
            if (((nl.b3p.xml.wfs.v110.FeatureType)feature).getFeatureTypeTypeChoice().getFeatureTypeTypeChoiceSequence().getDefaultSRS()!=null)
                sb.append(((nl.b3p.xml.wfs.v110.FeatureType)feature).getFeatureTypeTypeChoice().getFeatureTypeTypeChoiceSequence().getDefaultSRS());
            else
                sb.append(28992);
            sb.append("\"><gml:lowerCorner>");
            sb.append(bbox[0]).append(" ").append(bbox[1]);
            sb.append("</gml:lowerCorner><gml:upperCorner>");
            sb.append(bbox[2]).append(" ").append(bbox[3]);
            sb.append("</gml:upperCorner></gml:Envelope>");
            sb.append("</Intersects></Filter>");
            return (nl.b3p.xml.ogc.v110.Filter)Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.Filter.class, new StringReader(sb.toString()));
        }else{
            throw new UnsupportedOperationException("Given Feature not supported");
        }
    }
    
    public static void addPropertyIsEqualToFilter(GetFeature gf, String propertyName, String compareValue) {
        
        if (gf instanceof nl.b3p.xml.wfs.v100.GetFeature){
            Filter filter= OgcWfsClient.createPropertyIsEqualToFilter(propertyName,compareValue,OGCConstants.WFS_VERSION_100);
            ((nl.b3p.xml.wfs.v100.GetFeature)gf).getQuery(0).setFilter((nl.b3p.xml.ogc.v100.Filter)filter);
        }else if (gf instanceof nl.b3p.xml.wfs.v110.GetFeature){
            Filter filter= OgcWfsClient.createPropertyIsEqualToFilter(propertyName,compareValue,OGCConstants.WFS_VERSION_110);
            ((nl.b3p.xml.wfs.v110.GetFeature)gf).getQuery(0).setFilter((nl.b3p.xml.ogc.v110.Filter)filter);
            
        }
    }
    private static Filter createPropertyIsEqualToFilter(String propertyName, String compareValue, String version) {
        if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)){
            nl.b3p.xml.ogc.v100.Filter filter = new nl.b3p.xml.ogc.v100.Filter();
            nl.b3p.xml.ogc.v100.PropertyIsEqualTo piet = new nl.b3p.xml.ogc.v100.PropertyIsEqualTo();
            nl.b3p.xml.ogc.v100.PropertyName pn = new nl.b3p.xml.ogc.v100.PropertyName();
            nl.b3p.xml.ogc.v100.Literal l = new nl.b3p.xml.ogc.v100.Literal();
            //bij mapserver gaat dit niet helemaal goed. Omdat de query geen ms: aan kan. (de prefix van de namespace)
            if (propertyName.contains(":")){
                propertyName=propertyName.replaceAll("ms:","");
            }
            pn.setContent(propertyName);
            l.setContent(compareValue);
            piet.setPropertyName(pn);
            piet.setLiteral(l);
            filter.setPropertyIsEqualTo(piet);
            return filter;
            
        }else if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_110)){
            nl.b3p.xml.ogc.v110.Filter filter = new nl.b3p.xml.ogc.v110.Filter();
            nl.b3p.xml.ogc.v110.PropertyIsEqualTo piet = new nl.b3p.xml.ogc.v110.PropertyIsEqualTo();
            nl.b3p.xml.ogc.v110.PropertyName pn= new nl.b3p.xml.ogc.v110.PropertyName();
            nl.b3p.xml.ogc.v110.Literal l = new nl.b3p.xml.ogc.v110.Literal();
            pn.setContent(propertyName);
            l.setContent(compareValue);
            piet.setPropertyName(pn);
            piet.setLiteral(l);
            filter.setPropertyIsEqualTo(piet);
            return filter;
        }else{
            throw new UnsupportedOperationException("Given Version not supported: "+version);
        }
    }
    
    public static ArrayList getFeatureElements(GetFeature gf, OGCRequest or) throws Exception{
        ArrayList returnList= new ArrayList();
        Element e=doRequest(gf,or.getUrlWithNonOGCparams());
        B3pGMLReader bgr = new B3pGMLReader();
        HashMap hm=bgr.createGMLInputTemplates(getDescribeFeatureType(or));
        Iterator it = hm.values().iterator();
        while (it.hasNext()){
            GMLInputTemplate template= (GMLInputTemplate) it.next();
            bgr.setInputTemplate(template);
            FeatureCollection fc=bgr.read(new StringReader(elementToString(e)));
            returnList.addAll(fc.getFeatures());
        }
        return returnList;
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
    
    public static String elementToString(Element e) throws Exception{
        TransformerFactory transfac = TransformerFactory.newInstance();
        Transformer trans = transfac.newTransformer();
        trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        trans.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter sw = new StringWriter();
        StreamResult sr = new StreamResult(sw);
        DOMSource  ds = new DOMSource(e);
        trans.transform(ds,sr);
        return sw.toString();
    }
    public static AnyNode xmlStringToAnyNode(String xml) throws Exception {
        AnyNode anyNode = null;
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLReader reader = saxParser.getXMLReader();
            
            org.exolab.castor.xml.util.SAX2ANY handler = new org.exolab.castor.xml.util.SAX2ANY();
            
            reader.setContentHandler(handler);
            reader.setErrorHandler(handler);
            InputSource source = new InputSource(new StringReader(xml));
            reader.parse(source);
            
            anyNode = handler.getStartingNode();
        } catch (Exception e) {
            log.error("error", e);
        }
        return anyNode;
        
    }
}
