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
 * B3pGMLReader.java
 *
 * Created on 9 oktober 2007, 13:31
 *
 * Autor: Roy
 */
package nl.b3p.gis.readers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import nl.b3p.ogc.utils.OGCConstants;
import nl.b3p.ogc.utils.OgcWfsClient;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.xerces.parsers.DOMParser;
import com.vividsolutions.jump.io.GMLInputTemplate;
import com.vividsolutions.jump.io.GMLReader;
import com.vividsolutions.jump.io.ParseException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import nl.b3p.ogc.utils.OGCRequest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.util.XSDSchemaLocationResolver;
import org.geotools.data.DataUtilities;
import org.geotools.feature.FeatureCollection;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
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
public class B3pGMLReader extends GMLReader {

    private static final Log log = LogFactory.getLog(B3pGMLReader.class);
    private static final String COMPLEXTYPE = "complexType";
    private static final String EXTENSION = "extension";
    private static final String ELEMENT = "element";
    private int maxColumnNameLength = 0;

    /** Creates a new instance of B3pGMLReader */
    public B3pGMLReader() {
        super();
    }
/** Reads a GML from a WFSgetFeature url and returns a FeatureCollection with all found Geometry objects.
     *
     * @param wfsGetFeatureUrl The wfs getFeature url.
     *
     * @return a hashmap with key's the featuretypes and as values the featurecollections
     */
    public HashMap<String,FeatureCollection> readWFSUrl(OGCRequest wfsgf) throws TransformerException, Exception {
        wfsgf.addOrReplaceParameter(OGCConstants.WMS_REQUEST, OGCConstants.WFS_REQUEST_GetFeature);

        HashMap features = new HashMap();
        PostMethod method = null;
        String[] featureTypes = null;
        if (wfsgf.getParameter(OGCConstants.WFS_PARAM_TYPENAME) != null) {
            featureTypes = wfsgf.getParameter(OGCConstants.WFS_PARAM_TYPENAME).split(",");
        }
        //doe per featureType een apart verzoek.
        for (int i = 0; i < featureTypes.length; i++) {
            wfsgf.addOrReplaceParameter(OGCConstants.WFS_PARAM_TYPENAME, featureTypes[i]);
            HttpClient client = new HttpClient();
            String host = wfsgf.getUrlWithNonOGCparams();
            method = new PostMethod(host);
            String body = wfsgf.getXMLBody();
            //work around voor ESRI post request. Contenttype mag geen text/xml zijn.
            //method.setRequestEntity(new StringRequestEntity(body, "text/xml", "UTF-8"));
            method.setRequestEntity(new StringRequestEntity(body, null, null));
            int status = client.executeMethod(method);
            if (status == HttpStatus.SC_OK) {
                log.debug("Response ok, trying to create FeatureCollection....");

                String outputFormat = wfsgf.getParameter(OGCConstants.WFS_PARAM_OUTPUTFORMAT);
                org.geotools.xml.Parser parser = createGmlParser(outputFormat);

                Object o= parser.parse(method.getResponseBodyAsStream());

                FeatureCollection fc= convertParsedObjectToFeatureCollection(o);
                
                /*check if there are features found*/
                if(fc!=null){
                    features.put(featureTypes[i],fc);
                    if (fc.size() == 0) {
                        //There are no Features loaded. So redo the post method and show the response to user.
                        PostMethod method2 = new PostMethod(host);
                        //work around voor ESRI post request. Contenttype mag geen text/xml zijn.
                        //method2.setRequestEntity(new StringRequestEntity(body, "text/xml", "UTF-8"));
                        method2.setRequestEntity(new StringRequestEntity(body, null, null));
                        client.executeMethod(method2);
                        String cause = method2.getResponseBodyAsString(1000);
                        if (cause.indexOf("<ServiceExceptionReport") > 0) {
                            throw new Exception("Service returned exception: " + cause);
                        } else {
                            log.info("No features returned");
                        }
                    }
                }
            } else {
                log.error("Failed to connect with " + wfsgf.getUrlWithNonOGCparams() + " Using body: " + body);
            }
        }
        if (features.size() == 0) {
            return null;
        } else {
            return features;
        }
    }
    /**
     * Convert The object representation of the root element of the document when parsed to a OpenGis FeatureCollection
     * return null if failed. THE JUMP FEATURECOLLECTION IS NOT SUPPORTED
     * @param o  The object representation of the root element of the document (result of org.geotools.xml.Parser.parse())
     * @return a featureCollection.
     */
    public FeatureCollection convertParsedObjectToFeatureCollection (Object o){
        FeatureCollection fc=null;
        if (o instanceof HashMap) {
            Object l = ((HashMap) o).get("featureMember");
            if (l instanceof List) {
                fc=DataUtilities.collection((List)l);
            } else if (l instanceof org.opengis.feature.simple.SimpleFeature) {
                fc=DataUtilities.collection((SimpleFeature)l);
            }
        } else if (o instanceof FeatureCollection) {
            fc = (FeatureCollection) o;
        }else{
            log.error("Unable to convert parsed Object to featurecollection. Object: "+o.toString());
            fc=null;
        }
        return fc;
    }

    public org.geotools.xml.Parser createGmlParser(String outputFormat) {
        org.geotools.xml.Parser parser = null;
        if (outputFormat==null || (outputFormat != null && (outputFormat.toLowerCase().indexOf("gml/2") >= 0 || outputFormat.equalsIgnoreCase("gml2")))) {
            org.geotools.gml2.GMLConfiguration gmlconfig = new org.geotools.gml2.GMLConfiguration();
            gmlconfig.getContext().registerComponentInstance(new XSDSchemaLocationResolver() {
                public String resolveSchemaLocation(XSDSchema xsds, String string, String string1) {
                    return "dummy";
                }
            });
            parser = new org.geotools.xml.Parser(gmlconfig);
        } else{
            org.geotools.gml3.GMLConfiguration gmlconfig = new org.geotools.gml3.GMLConfiguration();
            gmlconfig.getContext().registerComponentInstance(new XSDSchemaLocationResolver() {
                public String resolveSchemaLocation(XSDSchema xsds, String string, String string1) {
                    return "dummy";
                }
            });
            parser = new org.geotools.xml.Parser(new org.geotools.gml3.GMLConfiguration());
        }
        return parser;
    }

    /**
     *@param el Een XML/GML element met daarin het antwoord op een describe feature type request.
     *@deprecated was used for creating elements using JUMP
     */
    public HashMap createGMLInputTemplates(Element el) throws Exception {
        HashMap templates = new HashMap();
        ArrayList usedColumnames = new ArrayList();
        NodeList docChilds = el.getChildNodes();
        //Element schema=doc.getDocumentElement();
        String target = el.getAttribute("targetNamespace");
        String defaultPrefix = null;
        NamedNodeMap attributes = el.getAttributes();
        //get the target namespace and add the namespaces to the ogcrequest
        for (int i = 0; i < attributes.getLength(); i++) {
            Node n = attributes.item(i);
            //if its a namespace:
            if (n.getNodeName().contains("xmlns")) {
                //ogcrequest.addOrReplaceNameSpace(n.getLocalName(),n.getNodeValue());
                if (target.equalsIgnoreCase(n.getNodeValue())) {
                    defaultPrefix = n.getLocalName();
                }
            }
        }
        //First create a map with names and types.
        HashMap elementsMap = new HashMap();
        for (int dc = 0; dc < docChilds.getLength(); dc++) {
            Node n = docChilds.item(dc);
            if (n.getLocalName() != null && n.getLocalName().equalsIgnoreCase("element")) {
                Element e = (Element) n;
                String type = e.getAttribute("type");
                if (type.contains(":")) {
                    type = type.split(":")[1];
                }
                String name = e.getAttribute("name");
                elementsMap.put(type, name);
            }
        }
        for (int dc = 0; dc < docChilds.getLength(); dc++) {
            ArrayList elements = new ArrayList();
            //als de tagname complextype is 
            Node n = docChilds.item(dc);
            if (n.getLocalName() != null && n.getLocalName().equalsIgnoreCase(COMPLEXTYPE)) {
                String type = ((Element) n).getAttribute("name");
                String name = "";
                if (elementsMap.get(type) != null) {
                    name = (String) elementsMap.get(type);
                }
                elements = getElementsWithTagname(n, "element");

                StringBuffer cols = new StringBuffer();
                StringBuffer geom = new StringBuffer();

                for (int i = 0; i < elements.size(); i++) {
                    Element e = (Element) elements.get(i);
                    String names = e.getNamespaceURI();
                    String prefix = e.getPrefix();
                    //if (e.getAttribute("type").equalsIgnoreCase("gml:GeometryPropertyType")){
                    String elType = e.getAttribute("type");
                    if (elType.startsWith("gml:")) {
                        geom.append("<GeometryElement>");
                        if (defaultPrefix != null && !e.getAttribute("name").contains(defaultPrefix + ":")) {
                            geom.append(defaultPrefix + ":");
                        }
                        geom.append(e.getAttribute("name"));
                        geom.append("</GeometryElement>");
                    } else if (e.getAttribute("ref").startsWith("gml:")) {
                        geom.append("<GeometryElement>");
                        geom.append(e.getAttribute("ref"));
                        geom.append("</GeometryElement>");
                    }
                    elType = allowedType(elType);
                    if (elType != null && e.getAttribute("name") != null) {
                        cols.append("<column><name>");
                        if (maxColumnNameLength > 0 && e.getAttribute("name").length() > maxColumnNameLength) {
                            String newName = "";
                            //ARCIMS maakt hele lange namen met veel punten er tussen. Het laatste stukje is interessant
                            if (e.getAttribute("name").lastIndexOf(".") > maxColumnNameLength) {
                                int lastIndexOfPoint = e.getAttribute("name").lastIndexOf(".");
                                newName = e.getAttribute("name").substring(lastIndexOfPoint + 1);
                            } else {
                                newName = e.getAttribute("name");
                            }
                            if (newName.length() > maxColumnNameLength) {
                                newName = newName.substring(0, maxColumnNameLength);
                            }
                            if (usedColumnames.contains(newName)) {
                                newName = newName.substring(0, maxColumnNameLength - 1);
                                int nameCounter = 1;
                                newName += nameCounter;
                                while (usedColumnames.contains(newName)) {
                                    nameCounter++;
                                    String nn = "" + nameCounter;
                                    if (nn.length() >= newName.length()) {
                                        //can't create a unique name
                                        newName = e.getAttribute("name");
                                        break;
                                    }
                                    newName = newName.substring(0, newName.length() - nn.length());
                                    newName += nameCounter;
                                }
                            }
                            usedColumnames.add(newName);
                            cols.append(newName);
                        } else {
                            cols.append(e.getAttribute("name"));
                        }
                        cols.append("</name><type>");
                        //if (defaultPrefix!=null)
                        //    cols.append(defaultPrefix+":");
                        String t = e.getAttribute("type").toUpperCase();
                        if (t.contains(":")) {
                            if (t.split(":").length > 1) {
                                t = t.split(":")[1];
                            }
                        }
                        cols.append(t);
                        cols.append("</type><valueelement elementname=\"");
                        //sb.append(doc.getDocumentElement().getPrefix());
                        if (defaultPrefix != null && !e.getAttribute("name").contains(defaultPrefix + ":")) {
                            cols.append(defaultPrefix + ":");
                        }
                        cols.append(e.getAttribute("name"));
                        cols.append("\"/><valuelocation position=\"body\"/></column>");
                    }
                }
                if (geom.length() > 0) {
                    StringBuffer sb = new StringBuffer();
                    sb.append("<?xml version='1.0' encoding='UTF-8'?>");
                    sb.append("<JCSGMLInputTemplate>");
                    sb.append("<CollectionElement>FeatureCollection</CollectionElement>");
                    sb.append("<FeatureElement>");
                    if (name != null && name.length() > 0) {
                        if (defaultPrefix != null && defaultPrefix.length() > 0) {
                            sb.append(defaultPrefix + ":");
                        }
                        sb.append(name);
                    } else {
                        sb.append("gml:featureMember");
                    }
                    sb.append("</FeatureElement>");
                    sb.append(geom.toString());
                    if (cols.length() > 0) {
                        sb.append("<ColumnDefinitions>");
                        sb.append(cols.toString());
                        //sb.append("<column><name>naam</name><type>STRING</type><valueelement elementname=\"app:naam\"/><valuelocation position=\"body\"/></column>");
                        sb.append("</ColumnDefinitions>");
                    }
                    sb.append("</JCSGMLInputTemplate>");
                    GMLInputTemplate git = new GMLInputTemplate();
                    String template = sb.toString();
                    git.load(new StringReader(sb.toString()), type);
                    log.debug("Template: " + sb.toString());
                    templates.put(name, git);

                }
            }
        }
        return templates;
    }

    /**
     *Creates GMLInputTemplates for every Featuretype/TypeName in the given url. It puts all GMLInputTemplates in a 
     *HashMap with the TypeName as key.
     *
     *@param wfsGetFeatureUrl The getFeature url
     *@return a hashmap with al inputtemplates as values en the TypeNames as keys
     */
    public HashMap createGMLInputTemplateFromWFS(OGCRequest ogcrequest) throws TransformerException, Exception {
        HashMap templates = null;
        //validate the url
        if (ogcrequest.getParameter(OGCConstants.WMS_VERSION) == null || ogcrequest.getParameter(OGCConstants.WFS_PARAM_TYPENAME) == null) {
            return null;
        }
        OGCRequest wfsDFT = (OGCRequest) ogcrequest.clone();
        //wfsDFT.removeAllWFSParameters();
        //wfsDFT.addOrReplaceParameter(OGCConstants.WMS_VERSION,ogcrequest.getParameter(OGCConstants.WMS_VERSION));

        wfsDFT.addOrReplaceParameter(OGCConstants.WMS_SERVICE, OGCConstants.WFS_SERVICE_WFS);
        wfsDFT.addOrReplaceParameter(OGCConstants.WMS_REQUEST, OGCConstants.WFS_REQUEST_DescribeFeatureType);
        /* if (ogcrequest.getParameter(OGCConstants.WFS_PARAM_OUTPUTFORMAT)!=null){
        wfsDFT.addOrReplaceParameter(OGCConstants.WFS_PARAM_OUTPUTFORMAT,ogcrequest.getParameter(OGCConstants.WFS_PARAM_OUTPUTFORMAT));
        }*/
        //TODO: Helaas is het bij degree niet mogelijk om meerdere typenames tegelijk op te vragen in een DescribeFeatureType
        //Als work around wordt voor elk type een apparte DescribeFeatureType gedaan.
        String[] types = ogcrequest.getParameter(OGCConstants.WFS_PARAM_TYPENAME).split(",");
        for (int b = 0; b < types.length; b++) {
            wfsDFT.addOrReplaceParameter(OGCConstants.WFS_PARAM_TYPENAME, types[b]);
            //String body=wfsDFT.getXMLBody();
            //Document doc=getDocumentByHTTPPost(wfsDFT.getUrlWithNonOGCparams(),body);        
            Element el = OgcWfsClient.getDescribeFeatureType(wfsDFT);
            if (el != null) {
                if (templates == null) {
                    templates = new HashMap();
                }
                templates.putAll(createGMLInputTemplates(el));
            }
        }
        if (templates != null && templates.size() > 0) {
            return templates;
        }
        return null;
    }

    public static void main(String[] args) throws IOException, ParseException, Exception {
        String w1url = "http://w1.b3p.nl/cgi-bin/mapserv.exe?SRSNAME=EPSG:28992&TYPENAME=tankstations_centroid&BBOX=70000,300000,305000,425000&VERSION=1.0.0&SERVICE=WFS&map=e:/mapserver/pnb_wis/pnb_wis2.map&REQUEST=GetFeature";
        String royurl = "http://b3p-roy/cgi-bin/mapserv.exe?map=C:/mapserver/map/pnb_wis/geoplaza.map&SERVICE=WFS&REQUEST=GetFeature&VERSION=1.0.0&TYPENAME=tankstations_centroid&BBOX=70000,300000,305000,425000&SRSNAME=EPSG:28992";
        String degreeurl = "http://portal.prvlimburg.nl/risicokaart_prof/ogcwebservices?SRSNAME=EPSG:28992&TYPENAME=app:Incident&VERSION=1.1.0&SERVICE=WFS&REQUEST=GetFeature&namespace=xmlns(app=http://www.deegree.org/app)";
        B3pGMLReader reader = new B3pGMLReader();
        OGCRequest ogcr = new OGCRequest(royurl);
        ogcr.getUrl();
        reader.readWFSUrl(ogcr);

    }

    private ArrayList getElementsWithTagname(Node node, String tagname) {
        ArrayList al = new ArrayList();
        if (node.getLocalName() != null && node.getLocalName().equalsIgnoreCase(tagname)) {
            al.add(node);
        }
        if (node.hasChildNodes()) {
            for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                al.addAll(getElementsWithTagname(node.getChildNodes().item(i), tagname));
            }
        }
        return al;
    }

    private String allowedType(String type) {
        if (type.contains(":")) {
            String tokens[] = type.split(":");
            if (tokens.length > 1) {
                type = tokens[1];
            }
        }
        if (type.equalsIgnoreCase("STRING") || type.equalsIgnoreCase("INTEGER") || type.equalsIgnoreCase("DOUBLE")) {
            return type;
        } else if (type.equalsIgnoreCase("int")) {
            return "INTEGER";
        } else {
            return "STRING";
        }
    }

    private Document getDocumentByHTTPPost(String host, String body) throws UnsupportedEncodingException, SAXException, IOException, TransformerConfigurationException, TransformerException {
        Document doc = null;
        PostMethod method = null;
        HttpClient client = new HttpClient();
        method = new PostMethod(host);
        //work around voor Esri Post request. Content type mag geen text/xml zijn.
        //method.setRequestEntity(new StringRequestEntity(body, "text/xml", "UTF-8"));
        method.setRequestEntity(new StringRequestEntity(body, null, null));
        int status = client.executeMethod(method);
        if (status == HttpStatus.SC_OK) {
            DOMParser dp = new DOMParser();
            //String s = method.getResponseBodyAsString();
            //s+="s";
            dp.parse(new InputSource(method.getResponseBodyAsStream()));
            doc = dp.getDocument();
            //for testing
            TransformerFactory transfac = TransformerFactory.newInstance();
            Transformer trans = transfac.newTransformer();
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            StringWriter sw = new StringWriter();
            StreamResult sr = new StreamResult(sw);
            DOMSource ds = new DOMSource(doc);
            trans.transform(ds, sr);
            String xmlResult = sw.toString();
            log.debug("Returned document: " + xmlResult);
        } else {
            log.error("Can't get document. Cause error code: " + status);
        }

        return doc;
    }

    /**Get the maximal ColumnName Length. Default it's 0. If it is 0 the columnname length has no Maximum
     *
     *@return the maximal columnName length
     */
    public int getMaxColumnNameLength() {
        return maxColumnNameLength;
    }

    /**Set the maximal ColumnName Length. Default it's 0. If it is 0 the columnname length has no Maximum
     *@param maxColumnNameLength the new maximum columnlength
     */
    public void setMaxColumnNameLength(int maxColumnNameLength) {
        this.maxColumnNameLength = maxColumnNameLength;
    }
}
