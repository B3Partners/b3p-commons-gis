/*
 * B3pGMLReader.java
 *
 * Created on 9 oktober 2007, 13:31
 *
 * Autor: Roy
 */

package nl.b3p.wfs.readers;

import com.vividsolutions.jump.feature.FeatureCollection;
import com.vividsolutions.jump.feature.FeatureDataset;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.xerces.parsers.DOMParser;
import com.vividsolutions.jump.io.GMLInputTemplate;
import com.vividsolutions.jump.io.GMLReader;
import com.vividsolutions.jump.io.ParseException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import nl.b3p.ogc.utils.OGCUrl;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 *
 * @author Roy
 */
public class B3pGMLReader extends GMLReader{
    private static final Log log = LogFactory.getLog(B3pGMLReader.class);

    private static final String COMPLEXTYPE= "complexType";
    private static final String EXTENSION= "extension";
    private static final String ELEMENT= "element";
    
    /** Creates a new instance of B3pGMLReader */
    public B3pGMLReader() {
        super();        
    }
    /** Reads a GML from a WFSgetFeature url and returns a FeatureCollection with all found Geometry objects.
     * The template that is used to read the GML is created with a WFS DescribeFeatureType request. All attributes given
     * will be added in the template.
     *
     * @param wfsGetFeatureUrl The wfs getFeature url. The request needs to be valid, at the moment no check is done.
     *  at least the attributes 'version' and 'typename' needs to be filled for creating a DescribeFeatureType request.
     *
     */
    public HashMap readWFSUrl(OGCUrl wfsgf) throws TransformerException, Exception{
        //OGCUrl wfsgf=new OGCUrl(wfsGetFeatureUrl); 
        HashMap templates=createGMLInputTemplateFromWFS(wfsgf);        
        if (templates==null){
            log.error("No Templates founed/created.");
            return null;
        }                
        HashMap features= new HashMap();
        PostMethod method = null;
        String[] featureTypes=null;
        if (wfsgf.getParameter(OGCUrl.WFS_PARAM_TYPENAME)!=null)
            featureTypes= wfsgf.getParameter(OGCUrl.WFS_PARAM_TYPENAME).split(",");
        for (int i=0; i < featureTypes.length; i++){
            try{
                Object o=null;
                o=templates.get(featureTypes[i]);
                if(o==null){
                    String[] tokens=featureTypes[i].split(":");
                    if (tokens.length>1)
                        o=templates.get(tokens[1]);
                    
                } 
                if (o==null){
                    log.error("Kan template niet vinden voor "+featureTypes[i]);
                }
                GMLInputTemplate git = (GMLInputTemplate)o;
                wfsgf.addOrReplaceParameter(OGCUrl.WFS_PARAM_TYPENAME,featureTypes[i]);
                HttpClient client = new HttpClient();        
                String host=wfsgf.getUrlWithNonOGCparams();
                method = new PostMethod(host); 
                String body=wfsgf.getXMLBody();
                method.setRequestEntity(new StringRequestEntity(body,"text/xml", "UTF-8"));
                int status=client.executeMethod(method);
                if (status== HttpStatus.SC_OK){
                    log.debug("Response ok, trying to create FeatureCollection....");
                    Reader r = null;
                    r=new InputStreamReader(method.getResponseBodyAsStream());                    
                    GMLReader gr= new GMLReader();
                    gr.setInputTemplate(git);                
                    FeatureCollection fc=gr.read(r);
                    if (fc.size()==0){
                        //There are no Features loaded. So redo the post method and show the response to user.
                        PostMethod method2= new PostMethod(host);
                        method2.setRequestEntity(new StringRequestEntity(body,"text/xml", "UTF-8"));
                        client.executeMethod(method2);
                        String cause=method2.getResponseBodyAsString(1000);
                        if(log.isDebugEnabled()){                            
                            log.error("No features returned cause(first 1000 characters): "+cause);
                        }                        
                    }
                    features.put(featureTypes[i],fc);   
                }else{
                    log.error("Failed to connect with "+wfsgf.getUrlWithNonOGCparams()+" Using body: "+body);
                }
            }catch(IOException ioe){
                log.error("",ioe);
            }catch (Exception e){
                log.error("",e);
            }
            finally{
                method.releaseConnection();
            }
        }
        if (features.size()==0){            
            return null;
        }else{
            return features;
        }
     }   
   
    /**
     *Creates GMLInputTemplates for every Featuretype/TypeName in the given url. It puts all GMLInputTemplates in a 
     *HashMap with the TypeName as key.
     *
     *@param wfsGetFeatureUrl The getFeature url
     *@return a hashmap with al inputtemplates as values en the TypeNames as keys
     */
    public HashMap createGMLInputTemplateFromWFS(OGCUrl ogcrequest) throws TransformerException, Exception{
        HashMap templates=new HashMap();
        //validate the url
        if (ogcrequest.getParameter(OGCUrl.WMS_VERSION)==null || ogcrequest.getParameter(OGCUrl.WFS_PARAM_TYPENAME)==null){
            return null;
        }
        OGCUrl wfsDFT= (OGCUrl)ogcrequest.clone();
        wfsDFT.removeAllWFSParameters();
        wfsDFT.addOrReplaceParameter(OGCUrl.WMS_VERSION,ogcrequest.getParameter(OGCUrl.WMS_VERSION));
        
        wfsDFT.addOrReplaceParameter(OGCUrl.WMS_SERVICE,OGCUrl.WFS_SERVICE_WFS);
        wfsDFT.addOrReplaceParameter(OGCUrl.WMS_REQUEST,OGCUrl.WFS_REQUEST_DiscribeFeatureType);
        
        //TODO: Helaas is het bij degree niet mogelijk om meerdere typenames tegelijk op te vragen in een DescribeFeatureType
        //Als work around wordt voor elk type een apparte DescribeFeatureType gedaan.
        String[] types =ogcrequest.getParameter(OGCUrl.WFS_PARAM_TYPENAME).split(",");
        for (int b=0; b < types.length; b++){
            wfsDFT.addOrReplaceParameter(OGCUrl.WFS_PARAM_TYPENAME,types[b]);
            String body=wfsDFT.getXMLBody();
            Document doc=getDocumentByHTTPPost(wfsDFT.getUrlWithNonOGCparams(),body);        
            if (doc!=null){                            
                NodeList docChilds=doc.getDocumentElement().getChildNodes();
                Element schema=doc.getDocumentElement();
                String target=schema.getAttribute("targetNamespace");
                String defaultPrefix = null;
                NamedNodeMap attributes=schema.getAttributes();
                //get the target namespace and add the namespaces to the ogcrequest
                for (int i=0; i < attributes.getLength(); i++){
                    Node n=attributes.item(i);
                    //if its a namespace:
                    if (n.getNodeName().contains("xmlns")){
                        ogcrequest.addOrReplaceNameSpace(n.getLocalName(),n.getNodeValue());
                        if (target.equalsIgnoreCase(n.getNodeValue())){
                            defaultPrefix=n.getLocalName();
                        }
                    }
                }
                //First create a map with names and types.
                HashMap elementsMap=new HashMap();
                for (int dc= 0; dc< docChilds.getLength(); dc++){
                    Node n = docChilds.item(dc);         
                    if (n.getLocalName()!=null && n.getLocalName().equalsIgnoreCase("element")){ 
                        Element e= (Element) n;
                        String type=e.getAttribute("type");
                        if (type.contains(":"))
                            type=type.split(":")[1];
                        String name=e.getAttribute("name");
                        elementsMap.put(type,name);
                    }
                }
                for (int dc= 0; dc < docChilds.getLength(); dc++){                   
                    ArrayList elements=new ArrayList();
                    //als de tagname complextype is 
                    Node n = docChilds.item(dc);                
                    if (n.getLocalName()!=null && n.getLocalName().equalsIgnoreCase(COMPLEXTYPE)){
                        String type=((Element)n).getAttribute("name");
                        String name="";
                        if (elementsMap.get(type)!=null){
                            name=(String)elementsMap.get(type);
                        }
                        elements=getElementsWithTagname(n,"element");

                        StringBuffer cols= new StringBuffer();
                        StringBuffer geom= new StringBuffer();

                        for (int i =0; i < elements.size(); i++){
                            Element e = (Element)elements.get(i);
                            String names=e.getNamespaceURI();
                            String prefix=e.getPrefix();
                            if (e.getAttribute("type").equalsIgnoreCase("gml:GeometryPropertyType")){
                                geom.append("<GeometryElement>");
                                if (defaultPrefix!=null && !e.getAttribute("name").contains(defaultPrefix+":"))
                                    geom.append(defaultPrefix+":");
                                geom.append(e.getAttribute("name"));
                                geom.append("</GeometryElement>");                                
                            }                                            
                            if (e.getAttribute("type")!=null && allowedType(e.getAttribute("type")) && e.getAttribute("name")!=null){                        
                                cols.append("<column><name>");
                                cols.append(e.getAttribute("name"));
                                cols.append("</name><type>");
                                //if (defaultPrefix!=null)
                                //    cols.append(defaultPrefix+":");
                                String t=e.getAttribute("type").toUpperCase();
                                if (t.contains(":")){
                                    if (t.split(":").length>1)
                                        t=t.split(":")[1];
                                }
                                cols.append(t);
                                cols.append("</type><valueelement elementname=\"");
                                //sb.append(doc.getDocumentElement().getPrefix());
                                if (defaultPrefix!=null && !e.getAttribute("name").contains(defaultPrefix+":"))
                                    cols.append(defaultPrefix+":");
                                cols.append(e.getAttribute("name"));
                                cols.append("\"/><valuelocation position=\"body\"/></column>");
                            }
                        }
                        if (geom.length()>0){          
                            StringBuffer sb = new StringBuffer();
                            sb.append("<?xml version='1.0' encoding='UTF-8'?>");
                            sb.append("<JCSGMLInputTemplate>");
                            sb.append("<CollectionElement>wfs:FeatureCollection</CollectionElement>");
                            sb.append("<FeatureElement>gml:featureMember</FeatureElement>");
                            sb.append(geom.toString());
                            if (cols.length()>0){
                                sb.append("<ColumnDefinitions>");
                                sb.append(cols.toString());
                                sb.append("</ColumnDefinitions>");
                            }
                            sb.append("</JCSGMLInputTemplate>");
                            GMLInputTemplate git = new GMLInputTemplate();
                            String template=sb.toString();
                            try {
                                git.load(new StringReader(sb.toString()));
                                templates.put(name,git);
                                log.debug("Template: "+sb.toString());
                            } catch (ParseException ex) {
                                log.error("",ex);
                            }
                        }                      
                    }                
                }            
            }
        }
        if (templates.size()>0){
            return templates;
        }        
        return null;
    }
     public static void main(String [] args) throws IOException, ParseException, Exception{
         String w1url="http://w1.b3p.nl/cgi-bin/mapserv.exe?SRSNAME=EPSG:28992&TYPENAME=tankstations_centroid&BBOX=70000,300000,305000,425000&VERSION=1.0.0&SERVICE=WFS&map=e:/mapserver/pnb_wis/pnb_wis2.map&REQUEST=GetFeature";
         String royurl="http://b3p-roy/cgi-bin/mapserv.exe?map=C:/mapserver/map/pnb_wis/geoplaza.map&SERVICE=WFS&REQUEST=GetFeature&VERSION=1.0.0&TYPENAME=tankstations_centroid&BBOX=70000,300000,305000,425000&SRSNAME=EPSG:28992";         
         B3pGMLReader reader = new B3pGMLReader();
         reader.readWFSUrl(new OGCUrl(royurl));
     }

    private ArrayList getElementsWithTagname(Node node, String tagname) {
        ArrayList al = new ArrayList();
        if (node.getLocalName()!=null && node.getLocalName().equalsIgnoreCase(tagname)){
            al.add(node);
        }
        if (node.hasChildNodes()){
            for (int i=0; i < node.getChildNodes().getLength(); i++){
                al.addAll(getElementsWithTagname(node.getChildNodes().item(i),tagname));
            }
        }
        return al;
    }
    
    private boolean allowedType(String type){
        if (type.contains(":")){
            String tokens[]=type.split(":");
            if (tokens.length>1)
                type=tokens[1];
        }
        if (type.equalsIgnoreCase("STRING") || type.equalsIgnoreCase("INTEGER") || type.equalsIgnoreCase("DOUBLE"))
            return true;
        else
            return false;
    }    
    private Document getDocumentByHTTPPost(String host, String body){
        Document doc=null;
        PostMethod method = null;        
        try{
            HttpClient client = new HttpClient();        
            method = new PostMethod(host);        
            method.setRequestEntity(new StringRequestEntity(body,"text/xml", "UTF-8"));
            int status=client.executeMethod(method);
            if (status== HttpStatus.SC_OK){
                DOMParser dp = new DOMParser();
                //String s = method.getResponseBodyAsString();
                //s+="s";
                dp.parse(new InputSource(method.getResponseBodyAsStream()));
                doc=dp.getDocument();
                //for testing
                TransformerFactory transfac = TransformerFactory.newInstance();  
                Transformer trans = transfac.newTransformer(); 
                trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");  
                trans.setOutputProperty(OutputKeys.INDENT, "yes");
                StringWriter sw = new StringWriter();
                StreamResult sr = new StreamResult(sw);
                DOMSource  ds = new DOMSource (doc);
                trans.transform(ds,sr);
                String xmlResult=sw.toString();
                log.debug("Returned document: "+xmlResult);
            }else{
                log.error("Can't get document. Cause error code: "+status);                     
            }                
        }catch (SAXException se){
             log.error("",se);
        }catch(TransformerConfigurationException tce){
            log.error("",tce);
        }catch(TransformerException te){
            log.error("",te);
        }catch (IOException ex) {
             log.error("",ex);
        }finally {
            // Release the connection.
            method.releaseConnection();
        } 
        return doc;
    }
}
