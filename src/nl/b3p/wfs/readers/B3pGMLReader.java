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
    public HashMap readWFSUrl(String wfsGetFeatureUrl) throws Exception {
        HashMap templates=createGMLInputTemplateFromWFS(wfsGetFeatureUrl);
        OGCUrl wfsgf=new OGCUrl(wfsGetFeatureUrl); 
        Set typenames=templates.keySet();
        Iterator it= typenames.iterator();
        HashMap features= new HashMap();
        while (it.hasNext()){
            String typeName=(String)it.next();
            GMLInputTemplate git = (GMLInputTemplate)templates.get(typeName);
            wfsgf.addOrReplaceParameter(OGCUrl.WFS_PARAM_TYPENAME,typeName);
            HttpClient client = new HttpClient();        
            PostMethod method = new PostMethod(wfsgf.getUrlWithNonOGCparams()); 
            String body=wfsgf.getXMLBody();
            method.setRequestEntity(new StringRequestEntity(body,"text/xml", "UTF-8"));
            int status=client.executeMethod(method);
            if (status== HttpStatus.SC_OK){
                /*String s=method.getResponseBodyAsString();
                s+="1";*/
                InputStreamReader isr=new InputStreamReader(method.getResponseBodyAsStream());
                GMLReader gr= new GMLReader();
                gr.setInputTemplate(git);                
                FeatureCollection fc=gr.read(isr);
                features.put(typeName,fc);      
            }
        }
        if (features.size()==0){
            return null;
        }else{
            return features;
        }
     }
        
       /* URL url = new URL(wfsGetFeatureUrl);
        URLConnection conn=url.openConnection();
        InputStreamReader isr=new InputStreamReader(conn.getInputStream());                
        
        //GMLInputTemplate git = createGMLInputTemplateFromWFS("");
        GMLInputTemplate git = new GMLInputTemplate();
        git.load(new StringReader(template));
        setInputTemplate(git);
        FeatureCollection fcAll=read(isr);
        isr.close();
        return fcAll;
        */
   
    /**//*String template="<?xml version='1.0' encoding='UTF-8'?><JCSGMLInputTemplate>"+
                "<CollectionElement>wfs:FeatureCollection</CollectionElement>" +
                "<FeatureElement>gml:featureMember</FeatureElement>" +
                "<GeometryElement>ms:msGeometry</GeometryElement>" +
                "" +
                "<column><name>ts</name><type>STRING</type><valueelement elementname=\"ms:ts\"/><valuelocation position=\"body\"/></column>" +
                "<column><name>ts_naam</name><type>STRING</type><valueelement elementname=\"ms:ts_naam\"/><valuelocation position=\"body\"/></column>" +
                "</ColumnDefinitions>" +
                "</JCSGMLInputTemplate>";*/
    /**
     *Creates GMLInputTemplates for every Featuretype/TypeName in the given url. It puts all GMLInputTemplates in a 
     *HashMap with the TypeName as key.
     *
     *@param wfsGetFeatureUrl The getFeature url
     *@return a hashmap with al inputtemplates as values en the TypeNames as keys
     */
    public HashMap createGMLInputTemplateFromWFS(String wfsGetFeatureUrl) throws TransformerException, Exception{
        OGCUrl wfsGetFeature = new OGCUrl(wfsGetFeatureUrl);
        HashMap templates=new HashMap();
        //validate the url
        if (wfsGetFeature.getParameter(OGCUrl.WMS_VERSION)==null || wfsGetFeature.getParameter(OGCUrl.WFS_PARAM_TYPENAME)==null){
            return null;
        }
        OGCUrl wfsDFT= new OGCUrl(wfsGetFeatureUrl);
        wfsDFT.removeAllWFSParameters();
        wfsDFT.addOrReplaceParameter(OGCUrl.WMS_VERSION,wfsGetFeature.getParameter(OGCUrl.WMS_VERSION));
        wfsDFT.addOrReplaceParameter(OGCUrl.WFS_PARAM_TYPENAME,wfsGetFeature.getParameter(OGCUrl.WFS_PARAM_TYPENAME));
        wfsDFT.addOrReplaceParameter(OGCUrl.WMS_SERVICE,OGCUrl.WFS_SERVICE_WFS);
        wfsDFT.addOrReplaceParameter(OGCUrl.WMS_REQUEST,OGCUrl.WFS_REQUEST_DiscribeFeatureType);
                           
        Document doc=getDocumentByHTTPPost(wfsDFT.getUrlWithNonOGCparams(),wfsDFT.getXMLBody());
        if (doc!=null){                            
            NodeList docChilds=doc.getDocumentElement().getChildNodes();
            //First create a map with names and types.
            HashMap elementsMap=new HashMap();
            for (int dc= 0; dc< docChilds.getLength(); dc++){
                if (docChilds.item(dc).getNodeName().equalsIgnoreCase("element")){
                    Element e= (Element) docChilds.item(dc);
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
                if (docChilds.item(dc).getNodeName().equalsIgnoreCase(COMPLEXTYPE)){
                    Node n = docChilds.item(dc);
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
                        if (e.getAttribute("type").equalsIgnoreCase("gml:GeometryPropertyType")){
                            geom.append("<GeometryElement>");
                            geom.append("ms:"+e.getAttribute("name"));
                            geom.append("</GeometryElement>");                                
                        }                                            
                        if (e.getAttribute("type")!=null && allowedType(e.getAttribute("type")) && e.getAttribute("name")!=null){                        
                            cols.append("<column><name>");
                            cols.append(e.getAttribute("name"));
                            cols.append("</name><type>");
                            cols.append(e.getAttribute("type"));
                            cols.append("</type><valueelement elementname=\"");
                            //sb.append(doc.getDocumentElement().getPrefix());
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
                        } catch (ParseException ex) {
                            log.error(ex);
                        }
                    }                      
                }
            }
            if (templates.size()>0){
                return templates;
            }
            return null;
        }
        
        /*HttpClient client = new HttpClient();
        GetMethod method = new GetMethod();
        client.getHttpConnectionManager().getParams().setConnectionTimeout((int)maxResponseTime);      */ 
        return null;
    }
     public static void main(String [] args) throws IOException, ParseException, Exception{
         String w1url="http://w1.b3p.nl/cgi-bin/mapserv.exe?SRSNAME=EPSG:28992&TYPENAME=tankstations_centroid&BBOX=70000,300000,305000,425000&VERSION=1.0.0&SERVICE=WFS&map=e:/mapserver/pnb_wis/pnb_wis2.map&REQUEST=GetFeature";
         String royurl="http://b3p-roy/cgi-bin/mapserv.exe?map=C:/mapserver/map/pnb_wis/geoplaza.map&SERVICE=WFS&REQUEST=GetFeature&VERSION=1.0.0&TYPENAME=tankstations_centroid&BBOX=70000,300000,305000,425000&SRSNAME=EPSG:28992";         
         B3pGMLReader reader = new B3pGMLReader();
         reader.readWFSUrl(royurl);
     }

    private ArrayList getElementsWithTagname(Node node, String tagname) {
        ArrayList al = new ArrayList();
        if (node.getNodeName().equalsIgnoreCase(tagname)){
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
                xmlResult=xmlResult;
            }else{
                log.error("Can't get document. Cause error code: "+status);                     
            }                
        }catch (SAXException se){
             log.error(se);
        }catch(TransformerConfigurationException tce){
            log.error(tce);
        }catch(TransformerException te){
            log.error(te);
        }catch (IOException ex) {
             log.error(ex);
        }finally {
            // Release the connection.
            method.releaseConnection();
        } 
        return doc;
    }
}
