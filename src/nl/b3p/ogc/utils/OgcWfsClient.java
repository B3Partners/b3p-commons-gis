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
import nl.b3p.xml.ogc.v100.exception.ServiceException;
import nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport;
import nl.b3p.xml.wfs.DescribeFeatureType;
import nl.b3p.xml.wfs.FeatureType;
import nl.b3p.xml.wfs.FeatureTypeList;
import nl.b3p.xml.wfs.Filter;
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
        or.addOrReplaceParameter(OGCRequest.WMS_SERVICE, OGCRequest.WFS_SERVICE_WFS);
        or.addOrReplaceParameter(OGCRequest.WMS_REQUEST, OGCRequest.WFS_REQUEST_GetCapabilities);        
        String host = or.getUrlWithNonOGCparams();
        Element el=doRequest(getGetCapabilitiesRequest(or),host);
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
    }
    /**
     *Doe een request naar de host die meegegeven is stuur het object als body
     *Kijkt tevens of het een serviceExceptionReport is en trowed dat dan als Exception.
     *@return het element dat terug gegeven wordt door de server
     */
    public static Element doRequest(Object o, String host) throws Exception{
        Element el=readXml2Element(new InputStreamReader(doRequestInputStreamReader(o,host)));
        if (el.getTagName().equalsIgnoreCase(OGCConstants.WFS_OBJECT_SERVICEEXCEPTIONREPORT)){
            ServiceExceptionReport ser= getServiceExceptionReport(el);
            StringBuffer sb=new StringBuffer();
            ServiceException se=null;
            for (int i=0; i < ser.getServiceExceptionCount(); i++){
                se= ser.getServiceException(i);
                sb.append(se.getContent());
                sb.append(" and ");                    
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
           throw new Exception("Url returned status: "+status + ": "+method.getResponseBodyAsString());   
        }   
    }
    /**
     *Doe een getDescribeFeatureType request naar de host aangegeven in de OGCRequest die meegegeven wordt
     */
    public static Element getDescribeFeatureType(OGCRequest original) throws Exception{
        Element returnvalue = null;
        OGCRequest or=(OGCRequest) original.clone();
        or.addOrReplaceParameter(OGCRequest.WMS_SERVICE, OGCRequest.WFS_SERVICE_WFS);
        or.addOrReplaceParameter(OGCRequest.WMS_REQUEST, OGCRequest.WFS_REQUEST_DescribeFeatureType);
        String host = or.getUrlWithNonOGCparams();
        returnvalue=doRequest(getDescribeFeatureTypeRequest(or),host);        
        return returnvalue;
    }    
    /** Haal de elementen uit de describefeaturetype request
     */
    public static NodeList getFeatureElements(Element el) throws Exception{
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
        or.addOrReplaceParameter(OGCRequest.WMS_REQUEST,OGCRequest.WFS_REQUEST_DescribeFeatureType);
        DescribeFeatureType dft=null;
        if(or.getParameter(OGCRequest.WMS_VERSION)==null){
            getCapabilities(or);
            original.addOrReplaceParameter(OGCRequest.WMS_VERSION,or.getParameter(OGCRequest.WMS_VERSION));
        }
        if (or.getParameter(OGCRequest.WMS_VERSION).equalsIgnoreCase(OGCRequest.WFS_VERSION_100)){
            dft=new nl.b3p.xml.wfs.v100.DescribeFeatureType();
        }else if (or.getParameter(OGCRequest.WMS_VERSION).equalsIgnoreCase(OGCRequest.WFS_VERSION_110)){
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
    /**Get the GetCapabilities request object
     */
    public static GetCapabilities getGetCapabilitiesRequest(OGCRequest or) {
        GetCapabilities gc = new GetCapabilities();
        gc.setService(OGCRequest.WFS_SERVICE_WFS);
        return gc;
    }
    /**Get the GetFeature request object.
     *
     */
    public static GetFeature getGetFeatureRequest(OGCRequest original) throws MarshalException, ValidationException, Exception{
        OGCRequest or = (OGCRequest) original.clone();
        or.addOrReplaceParameter(OGCRequest.WMS_REQUEST,OGCRequest.WFS_REQUEST_GetFeature);
        GetFeature gf=null;        
        if(or.getParameter(OGCRequest.WMS_VERSION)==null){
            getCapabilities(or);
            original.addOrReplaceParameter(OGCRequest.WMS_VERSION,or.getParameter(OGCRequest.WMS_VERSION));
        }
        if (or.getParameter(OGCRequest.WMS_VERSION).equalsIgnoreCase(OGCRequest.WFS_VERSION_100)){
            gf=new nl.b3p.xml.wfs.v100.GetFeature();
        }else if (or.getParameter(OGCRequest.WMS_VERSION).equalsIgnoreCase(OGCRequest.WFS_VERSION_110)){
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
            gfv100.addQuery(q);
        }else if (gf instanceof nl.b3p.xml.wfs.v110.GetFeature){
            nl.b3p.xml.wfs.v110.GetFeature gfv110=(nl.b3p.xml.wfs.v110.GetFeature)gf;
            nl.b3p.xml.wfs.v110.Query q = new nl.b3p.xml.wfs.v110.Query();                
            if (or.getParameter(OGCRequest.WFS_PARAM_TYPENAME) != null) {
                String[] typenames = or.getParameter(OGCRequest.WFS_PARAM_TYPENAME).split(",");
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < typenames.length; i++) {                    
                    if (i!=0){
                        sb.append(",");
                    }
                    sb.append(typenames[i]);
                }
                q.setTypeName(sb.toString());
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
        
        return gf;
    }
    /***
     * The request parameter of the OGCRequest must be filled because it is used to choose the body returned.
     */
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
    /**
     *Unmarshal the object to a serviceexception report.
     */
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
            return createBboxFilter(attributeName, bbox,(nl.b3p.xml.wfs.v100.capabilities.FeatureType)feature);
        }else if (feature instanceof nl.b3p.xml.wfs.v110.FeatureType){
            return createBboxFilter(attributeName, bbox,(nl.b3p.xml.wfs.v110.FeatureType)feature);
        }else{
            throw new UnsupportedOperationException("Given Feature not supported");
        }
    }
    /**
     *Creates a bbox filter
     */
    private static nl.b3p.xml.ogc.v100.Filter createBboxFilter(String attributeName, double[] bbox, nl.b3p.xml.wfs.v100.capabilities.FeatureType feature) throws Exception{        
        StringBuffer sb = new StringBuffer();
        sb.append("<Filter><BBOX><PropertyName>");
        sb.append(attributeName);
        sb.append("</PropertyName>");
        sb.append("<gml:Box srsName=\"http://www.opengis.net/gml/srs/epsg.xml#");
        sb.append(28992);
        sb.append("\"><gml:coordinates>");
        sb.append(bbox[0]).append(",").append(bbox[1]);
        sb.append(" ");
        sb.append(bbox[2]).append(",").append(bbox[3]);
        sb.append("</gml:coordinates></gml:Box>");
        sb.append("</BBOX></Filter>");
        return (nl.b3p.xml.ogc.v100.Filter)Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.Filter.class, new StringReader(sb.toString()));
        
    }
    /**
     *Creates a bbox filter
     */
    private static nl.b3p.xml.ogc.v110.Filter createBboxFilter(String attributeName, double[] bbox, nl.b3p.xml.wfs.v110.FeatureType feature) throws Exception{        
        StringBuffer sb = new StringBuffer();
        sb.append("<Filter><Within><PropertyName>");
        sb.append(attributeName);        
        //sb.append("app:geom");
        sb.append("</PropertyName>");
        sb.append("<gml:Envelope srsName=\"http://www.opengis.net/gml/srs/epsg.xml#");
        sb.append(28992);
        sb.append("\"><gml:lowerCorner>");
        sb.append(bbox[0]).append(" ").append(bbox[1]);
        sb.append("</gml:lowerCorner><gml:upperCorner>");
        sb.append(bbox[2]).append(" ").append(bbox[3]);
        sb.append("</gml:upperCorner></gml:Envelope>");
        sb.append("</Within></Filter>");
        return (nl.b3p.xml.ogc.v110.Filter)Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.Filter.class, new StringReader(sb.toString()));
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
        DOMSource  ds = new DOMSource (e);
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
