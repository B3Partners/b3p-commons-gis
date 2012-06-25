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
package nl.b3p.ogc.utils;

import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jump.feature.FeatureCollection;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import nl.b3p.xml.wfs.DescribeFeatureType;
import nl.b3p.xml.wfs.FeatureType;
import nl.b3p.xml.wfs.FeatureTypeList;
import nl.b3p.xml.wfs.Filter;
import nl.b3p.xml.wfs.GetCapabilities;
import nl.b3p.xml.wfs.GetFeature;
import nl.b3p.xml.wfs.WFS_Capabilities;
import nl.b3p.xml.wfs.Transaction;
import java.io.StringReader;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import nl.b3p.commons.xml.IgnoreEntityResolver;
import nl.b3p.gis.B3PCredentials;
import nl.b3p.gis.CredentialsParser;
import nl.b3p.xml.wfs.v110.TransactionTypeChoice;
import nl.b3p.xml.wfs.v110.TransactionTypeChoiceItem;
import nl.b3p.xml.wfs.v110.types.ResultTypeType;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.dom.DeferredElementNSImpl;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.util.XSDSchemaLocationResolver;
import org.exolab.castor.types.AnyNode;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.geotools.feature.DefaultFeatureCollection;
import org.geotools.filter.text.cql2.CQL;
import org.geotools.filter.v1_0.OGCConfiguration;
import org.geotools.xml.Encoder;
import org.opengis.feature.Feature;
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
    private static String GETMETHOD = "GET";
    private static String POSTMETHOD = "POST";

    /**
     *Doe een getCapabilities request naar de host aangegeven in de OGCRequest die meegegeven wordt
     */
    public static WFS_Capabilities getCapabilities(OGCRequest original) throws Exception {
        WFS_Capabilities returnvalue;
        OGCRequest or = (OGCRequest) original.clone();
        or.removeAllWFSParameters();
        or.addOrReplaceParameter(OGCConstants.WMS_SERVICE, OGCConstants.WFS_SERVICE_WFS);
        or.addOrReplaceParameter(OGCConstants.WMS_REQUEST, OGCConstants.WFS_REQUEST_GetCapabilities);
        if (original.getParameter(OGCConstants.WMS_VERSION) != null) {
            or.addOrReplaceParameter(OGCConstants.WMS_VERSION, original.getParameter(OGCConstants.WMS_VERSION));
        }
        String host = or.getUrlWithNonOGCparams();
        //Element el=doRequest(getGetCapabilitiesRequest(or),host);
        String url = or.getUrl();
        Element el = doRequest(url, host, or.getNameSpaces(), or.getUsername(), or.getPassword());
        if (el.getTagName().contains(OGCConstants.WFS_OBJECT_CAPABILITIES)) {
            String version = el.getAttribute(OGCConstants.WMS_VERSION.toLowerCase());
            if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)) {
                if (original.getParameter(OGCConstants.WMS_VERSION) == null) {
                    original.addOrReplaceParameter(OGCConstants.WMS_VERSION, version);
                }
                returnvalue = getCapabilitiesVersion100(el);
            } else if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_110)) {
                if (original.getParameter(OGCConstants.WMS_VERSION) == null) {
                    original.addOrReplaceParameter(OGCConstants.WMS_VERSION, version);
                }
                returnvalue = getCapabilitiesVersion110(el);
            } else {
                throw new UnsupportedOperationException("WFS GetCapabilities version: " + version + " not supported");
            }
        } else {
            log.error("Unexpected element returned: " + el.getTagName());
            throw new Exception("Unexpected element returned: " + el.getTagName());
        }
        original.setCapabilities(returnvalue);
        return returnvalue;
    }

    /**
     *Doe een request naar de host die meegegeven is stuur het object als body
     *Kijkt tevens of het een serviceExceptionReport is en trowed dat dan als Exception.
     *@return het element dat terug gegeven wordt door de server
     */
    public static Element doRequest(Object o, String host, String username, String password) throws Exception {
        return doRequest(o, host, null, username, password);

    }

    public static Element doRequest(Object o, String host, HashMap namespaces, String username, String password) throws Exception {
        Element el = readXml2Element(new InputStreamReader(getInputStreamReader(o, host, namespaces, username, password)));
        if (OGCRequest.removeNamespace(el.getTagName()).equalsIgnoreCase(OGCConstants.WFS_OBJECT_SERVICEEXCEPTIONREPORT)) {
            nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport ser = getServiceExceptionReport(el);
            StringBuffer sb = new StringBuffer();
            nl.b3p.xml.ogc.v100.exception.ServiceException se = null;
            for (int i = 0; i < ser.getServiceExceptionCount(); i++) {
                if (i != 0) {
                    sb.append(" and ");
                }
                se = ser.getServiceException(i);
                sb.append(se.getContent());
            }
            throw new Exception(sb.toString());
        }
        return el;

    }

    /**
     *Doet het request en returned het antwoord als inputstream. LetOp: checked niet of het een serviceExceptionReport is
     *
     */
    private static InputStream getInputStreamReader(Object o, String host, HashMap namespaces, String username, String password) throws Exception {
        B3PCredentials credentials  = new B3PCredentials();
        credentials.setUserName(username);
        credentials.setPassword(password);
        
        HttpClient client = CredentialsParser.CommonsHttpClientCredentials(credentials);
        
        int status;
        HttpMethod httpmethod = null;
        if (o instanceof String) {
            String url = (String) o;
            url = url.replaceAll(" ", "%20");
            httpmethod = new GetMethod(url);
        } else {
            String body = null;
            StringWriter sw = new StringWriter();
            Marshaller m = new Marshaller(sw);
            m.setMarshalAsDocument(false);
            m.setNamespaceMapping("xsi", "http://www.w3.org/2001/XMLSchema-instance");
            m.setSchemaLocation("http://www.opengis.net/wfs ../wfs/1.1.0/WFS.xsd");
            m.setNamespaceMapping("wfs", "http://www.opengis.net/wfs");
            m.setNamespaceMapping("gml", "http://www.opengis.net/gml");
            m.setNamespaceMapping("ogc", "http://www.opengis.net/ogc");
            if (namespaces != null) {
                Iterator it = namespaces.keySet().iterator();
                while (it.hasNext()) {
                    String key = (String) it.next();
                    String value = (String) namespaces.get(key);
                    if (key != null && value != null) {
                        m.setNamespaceMapping(key, value);
                    }
                }
            }
            //m.setNamespaceMapping("app", "http://www.deegree.org/app");
            m.marshal(o);
            body = sw.toString();
            PostMethod postmethod = new PostMethod(host);
            //work around voor esri post request. Contenttype mag geen text/xml zijn.
            //postmethod.setRequestEntity(new StringRequestEntity(body, "text/xml", "UTF-8"));
            postmethod.setRequestEntity(new StringRequestEntity(body, null, null));
            httpmethod = postmethod;
        }
        
        status = client.executeMethod(httpmethod);
        if (status == HttpStatus.SC_OK) {
            /*DEBUG:
            String s=method.getResponseBodyAsString();
            return new StringBufferInputStream(s);
             */
            return httpmethod.getResponseBodyAsStream();
        } else {
            log.error("Url returned status: " + status + ": " + httpmethod.getResponseBodyAsString());
            throw new Exception("Url returned status: " + status + ": " + httpmethod.getResponseBodyAsString());
        }
    }

    /**
     *Doe een getDescribeFeatureType request naar de host aangegeven in de OGCRequest die meegegeven wordt
     */
    public static Element getDescribeFeatureType(OGCRequest original) throws Exception {
        WFS_Capabilities cap = null;
        if (original.getCapabilities() == null) {
            cap = getCapabilities(original);
        } else {
            cap = original.getCapabilities();
        }
        List methodsAllowed = extractHttpMethodsAllowed(cap, OGCConstants.WFS_REQUEST_DescribeFeatureType);
        Element returnvalue = null;
        OGCRequest or = (OGCRequest) original.clone();
        or.addOrReplaceParameter(OGCConstants.WMS_SERVICE, OGCConstants.WFS_SERVICE_WFS);
        or.addOrReplaceParameter(OGCConstants.WMS_REQUEST, OGCConstants.WFS_REQUEST_DescribeFeatureType);

        String host = or.getUrlWithNonOGCparams();
        if (methodsAllowed.contains(POSTMETHOD)) {
            returnvalue = doRequest(getDescribeFeatureTypeRequest(or), host, or.getNameSpaces(), or.getUsername(), or.getPassword());
        } else if (methodsAllowed.contains(GETMETHOD)) {
            returnvalue = doRequest(or.getUrl(), host, or.getUsername(), or.getPassword());
        }
        return returnvalue;
    }

    /** Haal de elementen uit de describefeaturetype request
     */
    public static ArrayList getDescribeFeatureElements(Element el) throws Exception {
        //Haal eerst de complexTypes type elementen op en de prefix.
        String namespaceUri = el.getNamespaceURI();
        NodeList childs = el.getChildNodes();
        String prefix = "";
        for (int i = 0; i < childs.getLength() && prefix.length() == 0; i++) {
            Node n = childs.item(i);
            if (n instanceof DeferredElementNSImpl) {
                Element e = (Element) n;
                if (e.getLocalName().equalsIgnoreCase("element")) {
                    if (e.getAttribute("type") != null && e.getAttribute("type").contains(":")) {
                        prefix = e.getAttribute("type").split(":")[0];
                    }
                }
            }
        }
        String featureNameSpace = null;
        if (prefix.length() > 0) {
            featureNameSpace = el.getAttribute("xmlns:" + prefix);
        }
        String s = elementToString(el);
        if (el == null) {
            return null;
        }
        NodeList nlist = el.getElementsByTagNameNS(namespaceUri, "complexType");
        if (!(nlist.getLength() > 0)) {
            log.error("no complexType element found");
            return null;
        }
        ArrayList returnValue = new ArrayList();
        for (int i = 0; i < nlist.getLength(); i++) {
            Element e = (Element) nlist.item(i);
            NodeList nl = e.getElementsByTagNameNS(namespaceUri, "element");
            for (int b = 0; b < nl.getLength(); b++) {
                Element element = (Element) nl.item(b);
                if (featureNameSpace != null && featureNameSpace.length() > 0) {
                    element.setAttribute("name", "{" + featureNameSpace + "}" + element.getAttribute("name"));
                }
                returnValue.add(element);
            }
        }
        return returnValue;
    }

    /**Get the feature in the capabilities with given name.
     *
     */
    public static FeatureType getCapabilitieFeatureType(WFS_Capabilities cap, String name) {
        FeatureTypeList ftl = cap.getFeatureTypeList();
        for (int i = 0; i < ftl.getFeatureTypeCount(); i++) {
            FeatureType ft = ftl.getFeatureType(i);
            if (ft.getName().equalsIgnoreCase(name)) {
                return ft;
            }
        }
        return null;
    }
    // *The request object functions.

    /**Get the DescribeFeaturetype Request object.
     */
    public static DescribeFeatureType getDescribeFeatureTypeRequest(OGCRequest original) throws Exception {
        OGCRequest or = (OGCRequest) original.clone();
        or.addOrReplaceParameter(OGCConstants.REQUEST, OGCConstants.WFS_REQUEST_DescribeFeatureType);
        DescribeFeatureType dft = null;
        if (or.getParameter(OGCConstants.VERSION) == null) {
            getCapabilities(or);
            original.addOrReplaceParameter(OGCConstants.VERSION, or.getParameter(OGCConstants.VERSION));
        }
        if (or.getFinalVersion() != null && !or.getFinalVersion().equalsIgnoreCase(OGCConstants.WFS_VERSION_UNSPECIFIED) && !or.getParameter(OGCConstants.VERSION).equalsIgnoreCase(or.getFinalVersion())) {
            or.addOrReplaceParameter(OGCConstants.VERSION, or.getFinalVersion());
        }
        if (OGCConstants.WFS_VERSION_100.equalsIgnoreCase(or.getParameter(OGCConstants.VERSION))) {
            dft = new nl.b3p.xml.wfs.v100.DescribeFeatureType();
        } else if (OGCConstants.WFS_VERSION_110.equalsIgnoreCase(or.getParameter(OGCConstants.VERSION))) {
            dft = new nl.b3p.xml.wfs.v110.DescribeFeatureType();
        } else {
            throw new UnsupportedOperationException("WFS DescribeFeatureTypeRequest version: " + or.getParameter(OGCConstants.VERSION) + " not supported");
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
        if (or.getParameter(OGCConstants.VERSION) != null && or.getFinalVersion() != null && !or.getParameter(OGCConstants.VERSION).equalsIgnoreCase(or.getFinalVersion()) && !or.getFinalVersion().equalsIgnoreCase(OGCConstants.WFS_VERSION_UNSPECIFIED)) {
            or.addOrReplaceParameter(OGCConstants.VERSION, or.getFinalVersion());
        }
        if (OGCConstants.WFS_VERSION_100.equalsIgnoreCase(or.getParameter(OGCConstants.VERSION))) {
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
    public static GetFeature getGetFeatureRequest(OGCRequest original) throws MarshalException, ValidationException, Exception {
        OGCRequest or = (OGCRequest) original.clone();
        or.addOrReplaceParameter(OGCConstants.REQUEST, OGCConstants.WFS_REQUEST_GetFeature);

        GetFeature gf = null;
        if (or.getParameter(OGCConstants.VERSION) == null) {
            getCapabilities(or);
            original.addOrReplaceParameter(OGCConstants.VERSION, or.getParameter(OGCConstants.VERSION));
        }
        if (or.getFinalVersion() != null && !or.getParameter(OGCConstants.VERSION).equalsIgnoreCase(or.getFinalVersion())) {
            or.addOrReplaceParameter(OGCConstants.VERSION, or.getFinalVersion());
        }
        if (OGCConstants.WFS_VERSION_100.equalsIgnoreCase(or.getParameter(OGCConstants.VERSION))) {
            gf = new nl.b3p.xml.wfs.v100.GetFeature();
        } else if (OGCConstants.WFS_VERSION_110.equalsIgnoreCase(or.getParameter(OGCConstants.VERSION))) {
            gf = new nl.b3p.xml.wfs.v110.GetFeature();
        } else {
            throw new UnsupportedOperationException("WFS GetFeatureRequest version: " + or.getParameter(OGCConstants.VERSION) + " not supported");
        }

        if (or.getParameter(OGCConstants.VERSION) != null) {
            gf.setVersion(or.getParameter(OGCConstants.VERSION));
        }
        if (or.getParameter(OGCConstants.SERVICE) != null) {
            gf.setService(or.getParameter(OGCConstants.SERVICE));
        }
        if (or.getParameter(OGCConstants.WFS_PARAM_MAXFEATURES) != null) {
            int mf;
            try {
                mf = Integer.parseInt(or.getParameter(OGCConstants.WFS_PARAM_MAXFEATURES));
            } catch (NumberFormatException nfe) {
                mf=10;
                log.debug("error parsing MAXFEATURES, using:" + mf, nfe);
            }
            gf.setMaxFeatures(mf);
        }
        if (or.getParameter(OGCConstants.WFS_PARAM_OUTPUTFORMAT) != null) {
            gf.setOutputFormat(or.getParameter(OGCConstants.WFS_PARAM_OUTPUTFORMAT));
        } else {
            gf.setOutputFormat(null);
        }

        if (gf instanceof nl.b3p.xml.wfs.v100.GetFeature) {
            nl.b3p.xml.wfs.v100.GetFeature gfv100 = (nl.b3p.xml.wfs.v100.GetFeature) gf;
            //nl.b3p.xml.wfs.v100.Query q = new nl.b3p.xml.wfs.v100.Query();
            nl.b3p.xml.ogc.v100.Filter filter=null;
            //make filter
            if (or.getParameter(OGCConstants.WFS_PARAM_FILTER) != null) {
                try {
                    filter = (nl.b3p.xml.ogc.v100.Filter) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.Filter.class, new StringReader(or.getParameter(OGCConstants.WFS_PARAM_FILTER)));                    
                } catch (Exception e) {
                    log.error("Filter v100 (WFS version 1.0.0) not correct", e);
                }
            }
            nl.b3p.xml.ogc.v100.PropertyName[] properties=null;
            //make properties
            if (or.getParameter(OGCConstants.WFS_PARAM_PROPERTYNAME) != null) {
                try {
                    String[] propertyNames = or.getParameter(OGCConstants.WFS_PARAM_PROPERTYNAME).split(",");
                    properties = new nl.b3p.xml.ogc.v100.PropertyName[propertyNames.length];
                    for (int i = 0; i < propertyNames.length; i++) {
                        properties[i] = new nl.b3p.xml.ogc.v100.PropertyName();
                        properties[i].setContent(propertyNames[i]);
                    }
                    //q.setPropertyName(p);
                } catch (Exception e) {
                    log.error("PropertyName v100 (WFS version 1.0.0) not correct", e);
                }
            }
            if (or.getParameter(OGCConstants.WFS_PARAM_TYPENAME) != null) {                
                String[] typenames=or.getParameter(OGCConstants.WFS_PARAM_TYPENAME).split(",");
                for (int i=0; i < typenames.length; i++){
                    nl.b3p.xml.wfs.v100.Query q = new nl.b3p.xml.wfs.v100.Query();
                    q.setTypeName(typenames[i]);
                    if (filter!=null){
                        q.setFilter(filter);                        
                    }
                    if (properties!=null){
                        q.setPropertyName(properties);
                    }                    
                    gfv100.addQuery(q);
                }               
            }else{            
                nl.b3p.xml.wfs.v100.Query q = new nl.b3p.xml.wfs.v100.Query();
                if (filter!=null){
                    q.setFilter(filter);                        
                }
                if (properties!=null){
                    q.setPropertyName(properties);
                } 
                gfv100.addQuery(q);
            }
            
        } else if (gf instanceof nl.b3p.xml.wfs.v110.GetFeature) {
            nl.b3p.xml.wfs.v110.GetFeature gfv110 = (nl.b3p.xml.wfs.v110.GetFeature) gf;
            nl.b3p.xml.ogc.v110.Filter filter=null;
            //make filter            
            if (or.getParameter(OGCConstants.WFS_PARAM_FILTER) != null) {
                try {
                    filter = (nl.b3p.xml.ogc.v110.Filter) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.Filter.class, new StringReader(or.getParameter(OGCConstants.WFS_PARAM_FILTER)));                    
                } catch (Exception e) {
                    log.error("Filter v110 (WFS version 1.1.0) not correct", e);
                    // without throwing exception it goes on but without aplying filter
                    throw new UnsupportedOperationException("Filter is not correct!");
                }
            }
            //make querytypechoice
            nl.b3p.xml.wfs.v110.QueryTypeChoice[] queryTypeChoice=null;
            if (or.getParameter(OGCConstants.WFS_PARAM_PROPERTYNAME) != null) {
                try {
                    String[] propertyNames = or.getParameter(OGCConstants.WFS_PARAM_PROPERTYNAME).split(",");
                    queryTypeChoice = new nl.b3p.xml.wfs.v110.QueryTypeChoice[1];
                    queryTypeChoice[0] = new nl.b3p.xml.wfs.v110.QueryTypeChoice();
                    for (int i = 0; i < propertyNames.length; i++) {
                        nl.b3p.xml.wfs.v110.QueryTypeChoiceItem queryTypeChoiceItem = new nl.b3p.xml.wfs.v110.QueryTypeChoiceItem();
                        queryTypeChoiceItem.setPropertyName(propertyNames[i]);
                        queryTypeChoice[0].addQueryTypeChoiceItem(queryTypeChoiceItem);
                    }                    
                } catch (Exception e) {
                    log.error("PropertyName v100 (WFS version 1.0.0) not correct", e);
                }
            }
            if (or.getParameter(OGCConstants.WFS_PARAM_TYPENAME) != null) {
                String[] typeNames=or.getParameter(OGCConstants.WFS_PARAM_TYPENAME).split(",");
                for (int i=0; i < typeNames.length; i++){                    
                    nl.b3p.xml.wfs.v110.Query q = new nl.b3p.xml.wfs.v110.Query();
                    q.setTypeName(typeNames[i]);
                    if (or.getParameter(OGCConstants.WFS_PARAM_SRSNAME) != null) {
                        q.setSrsName(or.getParameter(OGCConstants.WFS_PARAM_SRSNAME));
                    }
                    if (or.getParameter(OGCConstants.WFS_PARAM_RESULTTYPE) != null) {
                        ResultTypeType resultType = gfv110.getResultType().valueOf(or.getParameter(OGCConstants.WFS_PARAM_RESULTTYPE));
                        gfv110.setResultType(resultType);
                    }
                    if (filter!=null){
                        q.setFilter(filter);
                    }
                    if(queryTypeChoice!=null){
                        q.setQueryTypeChoice(queryTypeChoice);
                    }
                    gfv110.addQuery(q);
                }                
            }else{
                nl.b3p.xml.wfs.v110.Query q = new nl.b3p.xml.wfs.v110.Query();                
                if (or.getParameter(OGCConstants.WFS_PARAM_SRSNAME) != null) {
                    q.setSrsName(or.getParameter(OGCConstants.WFS_PARAM_SRSNAME));
                }
                if (or.getParameter(OGCConstants.WFS_PARAM_RESULTTYPE) != null) {
                    ResultTypeType resultType = gfv110.getResultType().valueOf(or.getParameter(OGCConstants.WFS_PARAM_RESULTTYPE));
                    gfv110.setResultType(resultType);
                }
                if (filter!=null){
                    q.setFilter(filter);
                }
                if(queryTypeChoice!=null){
                    q.setQueryTypeChoice(queryTypeChoice);
                }
                gfv110.addQuery(q);
            }
        }
        return gf;
    }

    public static Transaction getTransactionRequest(OGCRequest original) throws MarshalException, ValidationException, Exception {
        OGCRequest or = (OGCRequest) original.clone();
        or.addOrReplaceParameter(OGCConstants.REQUEST, OGCConstants.WFS_REQUEST_Transaction);

        Transaction tr = null;
        if (or.getParameter(OGCConstants.VERSION) == null) {
            getCapabilities(or);
            original.addOrReplaceParameter(OGCConstants.VERSION, or.getParameter(OGCConstants.VERSION));
        }
        if (or.getFinalVersion() != null && !or.getFinalVersion().equalsIgnoreCase(OGCConstants.WFS_VERSION_UNSPECIFIED) && !or.getParameter(OGCConstants.VERSION).equalsIgnoreCase(or.getFinalVersion())) {
            or.addOrReplaceParameter(OGCConstants.VERSION, or.getFinalVersion());
        }
        if (OGCConstants.WFS_VERSION_100.equalsIgnoreCase(or.getParameter(OGCConstants.VERSION))) {
            tr = new nl.b3p.xml.wfs.v100.transaction.Transaction();
        } else if (OGCConstants.WFS_VERSION_110.equalsIgnoreCase(or.getParameter(OGCConstants.VERSION))) {
            tr = new nl.b3p.xml.wfs.v110.Transaction();
        } else {
            throw new UnsupportedOperationException("WFS TransactionRequest version: " + or.getParameter(OGCConstants.VERSION) + " not supported!");
        }
        if (or.getParameter(OGCConstants.VERSION) != null) {
            tr.setVersion(or.getParameter(OGCConstants.VERSION));
        }
        if (or.getParameter(OGCConstants.SERVICE) != null) {
            tr.setService(or.getParameter(OGCConstants.SERVICE));
        }
        if (or.getParameter(OGCConstants.WFS_PARAM_HANDLE) != null) {
            tr.setHandle(or.getParameter(OGCConstants.WFS_PARAM_HANDLE));
        }
        if (or.getParameter(OGCConstants.WFS_PARAM_LOCKID) != null) {
            tr.setLockId(or.getParameter(OGCConstants.WFS_PARAM_LOCKID));
        }
        if (tr instanceof nl.b3p.xml.wfs.v110.Transaction) {
            nl.b3p.xml.wfs.v110.Transaction trV110 = (nl.b3p.xml.wfs.v110.Transaction) tr;
            if (or.getParameter(OGCConstants.WFS_PARAM_RELEASEACTION) != null) {
                String release = or.getParameter(OGCConstants.WFS_PARAM_RELEASEACTION);
                nl.b3p.xml.wfs.v110.types.AllSomeType releaseAction = (nl.b3p.xml.wfs.v110.types.AllSomeType) Unmarshaller.unmarshal(nl.b3p.xml.wfs.v110.types.AllSomeType.class, new StringReader(release));
                trV110.setReleaseAction(releaseAction);
            }
            // add all elements
            List TransactionList = or.getTransactionElementList(or.getAbbr());
            TransactionTypeChoice ttc = new TransactionTypeChoice();
            Iterator it = TransactionList.iterator();
            while (it.hasNext()) {
                TransactionTypeChoiceItem ttci = new TransactionTypeChoiceItem();
                Object o = it.next();
                if (o instanceof nl.b3p.xml.wfs.v110.Delete) {
                    nl.b3p.xml.wfs.v110.Delete delete = (nl.b3p.xml.wfs.v110.Delete) o;
                    ttci.setDelete(delete);
                } else if (o instanceof nl.b3p.xml.wfs.v110.Insert) {
                    nl.b3p.xml.wfs.v110.Insert insert = (nl.b3p.xml.wfs.v110.Insert) o;
                    ttci.setInsert(insert);
                } else if (o instanceof nl.b3p.xml.wfs.v110.Update) {
                    nl.b3p.xml.wfs.v110.Update update = (nl.b3p.xml.wfs.v110.Update) o;
                    ttci.setUpdate(update);
                }
                ttc.addTransactionTypeChoiceItem(ttci);
            }
            trV110.addTransactionTypeChoice(ttc);
        }

        return tr;
    }

    /***
     * The request parameter of the OGCRequest must be filled because it is used to choose the body returned.
     */
    public static String getRequestBody(OGCRequest or) throws Exception {
        String body = null;
        Object castorObject = null;
        if (or.getParameter(OGCConstants.REQUEST) == null || or.getParameter(OGCConstants.REQUEST).length() <= 0) {
            return body;
        }
        if (or.getParameter(OGCConstants.REQUEST).equalsIgnoreCase(OGCConstants.WFS_REQUEST_DescribeFeatureType)) {
            castorObject = getDescribeFeatureTypeRequest(or);
        } else if (or.getParameter(OGCConstants.REQUEST).equalsIgnoreCase(OGCConstants.WFS_REQUEST_GetFeature)) {
            castorObject = getGetFeatureRequest(or);
        } else if (or.getParameter(OGCConstants.REQUEST).equalsIgnoreCase(OGCConstants.WFS_REQUEST_GetCapabilities)) {
            castorObject = getGetCapabilitiesRequest(or);
        } else if (or.getParameter(OGCConstants.REQUEST).equalsIgnoreCase(OGCConstants.WFS_REQUEST_Transaction)) {
            castorObject = getTransactionRequest(or);
        } else {
            throw new UnsupportedOperationException("Request: " + or.getParameter(OGCConstants.REQUEST) + " wordt (nog) niet ondersteund");
        }
        StringWriter sw = new StringWriter();
        Marshaller m = new Marshaller(sw);
        if (or.getNameSpaces() != null) {
            Set mapEntries = or.getNameSpaces().entrySet();
            Iterator it = mapEntries.iterator();
            while (it.hasNext()) {
                Map.Entry me = (Map.Entry) it.next();
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
    public static nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport getServiceExceptionReport(Element element) throws MarshalException, ValidationException {
        Unmarshaller um = new Unmarshaller(nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport.class);
        Object o = um.unmarshal(element);
        return (nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport) o;
    }

    public static nl.b3p.xml.wfs.v110.WFS_Capabilities getCapabilitiesVersion110(Element element) throws ValidationException, Exception {
        //log.debug("Response ok, trying to create FeatureCollection....");
        Unmarshaller um = new Unmarshaller(nl.b3p.xml.wfs.v110.WFS_Capabilities.class);
        Object o = um.unmarshal(element);
        return (nl.b3p.xml.wfs.v110.WFS_Capabilities) o;
    }

    public static nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities getCapabilitiesVersion100(Element element) throws ValidationException, Exception {
        Unmarshaller um = new Unmarshaller(nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities.class);
        Object o = um.unmarshal(element);
        return (nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities) o;
    }

    /**
     *Voegt een bbox toe aan het GetFeature object.
     */
    public static void addBboxFilter(GetFeature gf, String attributeName, double[] bbox, String srsName, FeatureType ft) throws Exception {
        Filter filter = OgcWfsClient.createBboxFilter(attributeName, bbox, srsName, ft);
        if (gf instanceof nl.b3p.xml.wfs.v100.GetFeature) {
            ((nl.b3p.xml.wfs.v100.GetFeature) gf).getQuery(0).setFilter((nl.b3p.xml.ogc.v100.Filter) filter);
        } else if (gf instanceof nl.b3p.xml.wfs.v110.GetFeature) {
            ((nl.b3p.xml.wfs.v110.GetFeature) gf).getQuery(0).setFilter((nl.b3p.xml.ogc.v110.Filter) filter);
        }
    }

    public static void addPolygonFilter(GetFeature gf, String attributeName, String polygon, String srsName, FeatureType ft) throws Exception {
        Filter filter = OgcWfsClient.createPolygonFilter(attributeName, polygon, srsName, ft);
        if (gf instanceof nl.b3p.xml.wfs.v100.GetFeature) {
            ((nl.b3p.xml.wfs.v100.GetFeature) gf).getQuery(0).setFilter((nl.b3p.xml.ogc.v100.Filter) filter);
        } else if (gf instanceof nl.b3p.xml.wfs.v110.GetFeature) {
            ((nl.b3p.xml.wfs.v110.GetFeature) gf).getQuery(0).setFilter((nl.b3p.xml.ogc.v110.Filter) filter);
        }
    }

    public static void addQueryFilter(GetFeature gf, String adminQuery, String srsName, FeatureType ft) throws Exception {
        Filter filter = OgcWfsClient.createQueryFilter(gf, adminQuery, srsName, ft);

        if (ft instanceof nl.b3p.xml.wfs.v100.capabilities.FeatureType) {
            ((nl.b3p.xml.wfs.v100.GetFeature) gf).getQuery(0).setFilter((nl.b3p.xml.ogc.v100.Filter) filter);
        } else if (ft instanceof nl.b3p.xml.wfs.v110.FeatureType) {
            ((nl.b3p.xml.wfs.v110.GetFeature) gf).getQuery(0).setFilter((nl.b3p.xml.ogc.v110.Filter) filter);
        }
    }

    /**
     *Creates a bbox filter
     */
    public static nl.b3p.xml.wfs.Filter createBboxFilter(String attributeName, double[] bbox, String srsName, nl.b3p.xml.wfs.FeatureType feature) throws Exception {
        //als er een namespaceuri voor staat die verwijderen.
        if (attributeName.indexOf("{") >= 0 && attributeName.indexOf("}") >= 0) {
            attributeName = attributeName.substring(attributeName.indexOf("}") + 1);
        }
        if (feature instanceof nl.b3p.xml.wfs.v100.capabilities.FeatureType) {
            StringBuffer sb = new StringBuffer();
            sb.append("<Filter><BBOX><PropertyName>");
            sb.append(attributeName);
            sb.append("</PropertyName>");
            sb.append("<gml:Box");
            if (srsName != null) {
                sb.append(" srsName=\"");
                sb.append(srsName);
            }
            sb.append("\"><gml:coordinates>");
            sb.append(bbox[0]).append(",").append(bbox[1]);
            sb.append(" ");
            sb.append(bbox[2]).append(",").append(bbox[3]);
            sb.append("</gml:coordinates></gml:Box>");
            sb.append("</BBOX></Filter>");
            return (nl.b3p.xml.ogc.v100.Filter) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.Filter.class, new StringReader(sb.toString()));
        } else if (feature instanceof nl.b3p.xml.wfs.v110.FeatureType) {
            StringBuffer sb = new StringBuffer();
            sb.append("<Filter><Intersects><PropertyName>");
            sb.append(attributeName);
            //sb.append("app:geom");
            sb.append("</PropertyName>");
            sb.append("<gml:Envelope");
            if (srsName != null) {
                sb.append(" srsName=\"");
                sb.append(srsName);
            }
            sb.append("\"><gml:lowerCorner>");
            sb.append(bbox[0]).append(" ").append(bbox[1]);
            sb.append("</gml:lowerCorner><gml:upperCorner>");
            sb.append(bbox[2]).append(" ").append(bbox[3]);
            sb.append("</gml:upperCorner></gml:Envelope>");
            sb.append("</Intersects></Filter>");
            return (nl.b3p.xml.ogc.v110.Filter) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.Filter.class, new StringReader(sb.toString()));
        } else {
            throw new UnsupportedOperationException("Given Feature not supported" +
                    ", class: " + (feature == null ? "" : feature.getClass()) +
                    ", attribute: " + attributeName);
        }
    }

    /*
     * Creates a polygon filter
     */
    public static nl.b3p.xml.wfs.Filter createPolygonFilter(String attributeName, String polygon, String srsName, nl.b3p.xml.wfs.FeatureType feature) throws Exception {
        //als er een namespaceuri voor staat die verwijderen.
        if (attributeName.indexOf("{") >= 0 && attributeName.indexOf("}") >= 0) {
            attributeName = attributeName.substring(attributeName.indexOf("}") + 1);
        }

        if (feature instanceof nl.b3p.xml.wfs.v100.capabilities.FeatureType) {
            /*
             * Omdat in de polygon de spaties en komma's precies anders om staan en ArcGis zich
             * niks van de cs en ts settings aantrekt word de polygon veranderd zodat deze aan
             * de default cs en ts voldoet.
             */
            String newPolygon = "";
            String[] splitKomma = polygon.split(",");
            for(int i = 0; i < splitKomma.length; i++){
                String[] splitSpatie = splitKomma[i].split(" ");
                if(i+1 < splitKomma.length ){
                    newPolygon += splitSpatie[0] + "," + splitSpatie[1] + " ";
                }else{
                    newPolygon += splitSpatie[0] + "," + splitSpatie[1];
                }
            }

            StringBuffer sb = new StringBuffer();
            sb.append("<Filter><Intersects><PropertyName>");
            sb.append(attributeName);
            sb.append("</PropertyName>");
            sb.append("<gml:Polygon");
            if (srsName != null) {
                sb.append(" srsName=\"");
                sb.append(srsName);
            }
            sb.append("\"><gml:outerBoundaryIs>");
            sb.append("<gml:LinearRing>");
            /* cs, ts en decimal zijn ingesteld zoals de default. */
            sb.append("<gml:coordinates cs=\",\" decimal=\".\" ts=\" \">");
            //sb.append(polygon);
            sb.append(newPolygon);
            sb.append("</gml:coordinates>");
            sb.append("</gml:LinearRing>");
            sb.append("</gml:outerBoundaryIs>");
            sb.append("</gml:Polygon>");
            sb.append("</Intersects></Filter>");
            
            return (nl.b3p.xml.ogc.v100.Filter) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.Filter.class, new StringReader(sb.toString()));
        } else if (feature instanceof nl.b3p.xml.wfs.v110.FeatureType) {
            StringBuffer sb = new StringBuffer();
            sb.append("<Filter><Intersects><PropertyName>");
            sb.append(attributeName);
            sb.append("</PropertyName>");
            sb.append("<gml:Polygon");
            if (srsName != null) {
                sb.append(" srsName=\"");
                sb.append(srsName);
            }
            sb.append("\"><gml:outerBoundaryIs>");
            sb.append("<gml:LinearRing>");
            sb.append("<gml:posList>");
            sb.append(polygon);
            sb.append("</gml:posList>");
            sb.append("</gml:LinearRing>");
            sb.append("</gml:outerBoundaryIs>");
            sb.append("</gml:Polygon>");
            sb.append("</Intersects></Filter>");
            return (nl.b3p.xml.ogc.v110.Filter) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.Filter.class, new StringReader(sb.toString()));
        } else {
            throw new UnsupportedOperationException("Given Feature not supported");
        }
    }

    /*
     * Creates a filter
     */
    public static nl.b3p.xml.wfs.Filter createQueryFilter(GetFeature gf, String query, String srsName, nl.b3p.xml.wfs.FeatureType feature) throws Exception {
        org.opengis.filter.Filter filter = CQL.toFilter(query);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //create the encoder
        Encoder encoder = new Encoder(new OGCConfiguration());
        QName name = new QName("http://www.opengis.net/ogc", "Filter");
        encoder.encode(filter, name, baos);
        String s = baos.toString();

        if (feature instanceof nl.b3p.xml.wfs.v100.capabilities.FeatureType) {
            return (nl.b3p.xml.ogc.v100.Filter) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.Filter.class, new StringReader(s));
        } else if (feature instanceof nl.b3p.xml.wfs.v110.FeatureType) {
            return (nl.b3p.xml.ogc.v110.Filter) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.Filter.class, new StringReader(s));
        } else {
            throw new UnsupportedOperationException("Given Feature not supported");
        }
    }

    public static void addPropertyIsEqualToFilter(GetFeature gf, String propertyName, String compareValue) {

        if (gf instanceof nl.b3p.xml.wfs.v100.GetFeature) {
            Filter filter = OgcWfsClient.createPropertyIsEqualToFilter(propertyName, compareValue, OGCConstants.WFS_VERSION_100);
            ((nl.b3p.xml.wfs.v100.GetFeature) gf).getQuery(0).setFilter((nl.b3p.xml.ogc.v100.Filter) filter);
        } else if (gf instanceof nl.b3p.xml.wfs.v110.GetFeature) {
            Filter filter = OgcWfsClient.createPropertyIsEqualToFilter(propertyName, compareValue, OGCConstants.WFS_VERSION_110);
            ((nl.b3p.xml.wfs.v110.GetFeature) gf).getQuery(0).setFilter((nl.b3p.xml.ogc.v110.Filter) filter);

        }
    }

    private static Filter createPropertyIsEqualToFilter(String propertyName, String compareValue, String version) {
        if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)) {
            nl.b3p.xml.ogc.v100.Filter filter = new nl.b3p.xml.ogc.v100.Filter();
            nl.b3p.xml.ogc.v100.PropertyIsEqualTo piet = new nl.b3p.xml.ogc.v100.PropertyIsEqualTo();
            nl.b3p.xml.ogc.v100.PropertyName pn = new nl.b3p.xml.ogc.v100.PropertyName();
            nl.b3p.xml.ogc.v100.Literal l = new nl.b3p.xml.ogc.v100.Literal();
            //bij mapserver gaat dit niet helemaal goed. Omdat de query geen ms: aan kan. (de prefix van de namespace)
            if (propertyName.contains(":")) {
                propertyName = propertyName.replaceAll("ms:", "");
            }
            pn.setContent(propertyName);
            l.setContent(compareValue);
            piet.setPropertyName(pn);
            piet.setLiteral(l);
            filter.setPropertyIsEqualTo(piet);
            return filter;

        } else if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_110)) {
            nl.b3p.xml.ogc.v110.Filter filter = new nl.b3p.xml.ogc.v110.Filter();
            nl.b3p.xml.ogc.v110.PropertyIsEqualTo piet = new nl.b3p.xml.ogc.v110.PropertyIsEqualTo();
            nl.b3p.xml.ogc.v110.PropertyName pn = new nl.b3p.xml.ogc.v110.PropertyName();
            nl.b3p.xml.ogc.v110.Literal l = new nl.b3p.xml.ogc.v110.Literal();
            pn.setContent(propertyName);
            l.setContent(compareValue);
            piet.setPropertyName(pn);
            piet.setLiteral(l);
            filter.setPropertyIsEqualTo(piet);
            return filter;
        } else {
            throw new UnsupportedOperationException("Given Version not supported: " + version);
        }
    }

    public static ArrayList getFeatureElements(GetFeature gf, OGCRequest or) throws Exception {
        ArrayList returnList = new ArrayList();
        Element elem = doRequest(gf, or.getUrlWithNonOGCparams(), or.getNameSpaces(), or.getUsername(), or.getPassword());
        String outputFormat = gf.getOutputFormat();
        String version = "";
        if (gf instanceof nl.b3p.xml.wfs.v100.GetFeature) {
            version = "1.0.0";
        } else if (gf instanceof nl.b3p.xml.wfs.v110.GetFeature) {
            version = "1.1.0";
        }
        int gmlVersion = 2;
        if ("1.1.0".equals(version) && outputFormat != null && !"GML2".equalsIgnoreCase(outputFormat) && outputFormat.indexOf("gml/2") == -1) {
            gmlVersion = 3;
        }

        org.geotools.gml2.GMLConfiguration configGml2 = null;
        configGml2 = new org.geotools.gml2.GMLConfiguration();
        configGml2.getContext().registerComponentInstance(new XSDSchemaLocationResolver() {

            public String resolveSchemaLocation(XSDSchema xsds, String string, String string1) {
                return "dummy";
            }
        });

        org.geotools.gml3.GMLConfiguration configGml3 = null;
        configGml3 = new org.geotools.gml3.GMLConfiguration();
        configGml3.getContext().registerComponentInstance(new XSDSchemaLocationResolver() {

            public String resolveSchemaLocation(XSDSchema xsds, String string, String string1) {
                return "dummy";
            }
        });

        // TODO validatie uitzetten, maar hoe?
        org.geotools.xml.Parser parser = null;
        if (gmlVersion == 2) {
            parser = new org.geotools.xml.Parser(configGml2);
        } else {
            parser = new org.geotools.xml.Parser(configGml3);
        }

        Object o = null;
        try {
            o = parser.parse(new StringReader(elementToString(elem)));
        } catch (Exception ex) {
            log.warn("GML version " + gmlVersion + " not correct. Trying other version:", ex);
            if (gmlVersion == 2) {
                parser = new org.geotools.xml.Parser(configGml3);
            } else {
                parser = new org.geotools.xml.Parser(configGml2);
            }
            try {
                o = parser.parse(new StringReader(elementToString(elem)));
            } catch (Exception ex2) {
                log.error("No GML version correct. Giving up...", ex2);
                throw new Exception("No suitable GML parser found", ex2);
            }
        }
        FeatureCollection fc = null;
        if (o instanceof FeatureCollection) {
            fc = (FeatureCollection) o;
            returnList.addAll(fc.getFeatures());
        } else if (o instanceof HashMap) {
            Object l = ((HashMap) o).get("featureMember");
            if (l instanceof List) {
                returnList.addAll((List) l);
            } else if (l instanceof Feature) {
                returnList.add(l);
            }
        } else if (o instanceof DefaultFeatureCollection) {
            DefaultFeatureCollection dfc = (DefaultFeatureCollection) o;
            Object[] featureArray = dfc.toArray();
            for (int i = 0; i < featureArray.length; i++) {
                returnList.add(featureArray[i]);
            }
        } else if (o instanceof Envelope) {
            log.debug("no features found");
        } else {
            throw new UnsupportedOperationException("Can not make returnList from " + o.getClass());
        }
        return returnList;
    }

    protected static Element readXml2Element(Reader src) throws Exception {
        Document doc = null;

        InputSource ips = new InputSource(src);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);

        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.parse(ips);
        return doc.getDocumentElement();
    }

    public static String elementToString(Element e) throws Exception {
        TransformerFactory transfac = TransformerFactory.newInstance();
        Transformer trans = transfac.newTransformer();
        trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        trans.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter sw = new StringWriter();
        StreamResult sr = new StreamResult(sw);
        DOMSource ds = new DOMSource(e);
        trans.transform(ds, sr);
        return sw.toString();
    }

    public static AnyNode xmlStringToAnyNode(String xml) throws Exception {
        AnyNode anyNode = null;
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLReader reader = saxParser.getXMLReader();

            org.exolab.castor.xml.util.SAX2ANY handler = new org.exolab.castor.xml.util.SAX2ANY();

            IgnoreEntityResolver r = new IgnoreEntityResolver();
            reader.setEntityResolver(r);

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

    private static List extractHttpMethodsAllowed(WFS_Capabilities cap, String requestName) {
        ArrayList methodsAllowed = new ArrayList();
        if (cap instanceof nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities) {
            nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities cap100 = (nl.b3p.xml.wfs.v100.capabilities.WFS_Capabilities) cap;
            for (int i = 0; i < cap100.getCapability().getRequest().getRequestTypeItemCount(); i++) {
                nl.b3p.xml.wfs.v100.capabilities.RequestTypeItem rti = cap100.getCapability().getRequest().getRequestTypeItem(i);
                if (OGCConstants.WFS_REQUEST_DescribeFeatureType.equalsIgnoreCase(requestName)) {
                    if (rti.getDescribeFeatureType() != null) {
                        nl.b3p.xml.wfs.v100.capabilities.DCPType_DescribeFeatureTypeType[] requestDcpTypes = rti.getDescribeFeatureType().getDCPType_DescribeFeatureTypeType();
                        for (int i2 = 0; i2 < requestDcpTypes.length; i2++) {
                            nl.b3p.xml.wfs.v100.capabilities.HTTP http = requestDcpTypes[i2].getHTTP();
                            for (int i3 = 0; i3 < http.getHTTPTypeItemCount(); i3++) {
                                if (http.getHTTPTypeItem(i3).getGet() != null) {
                                    methodsAllowed.add(GETMETHOD);
                                }
                                if (http.getHTTPTypeItem(i3).getPost() != null) {
                                    methodsAllowed.add(POSTMETHOD);
                                }
                            }

                        }
                    }
                } else if (OGCConstants.WFS_REQUEST_GetCapabilities.equalsIgnoreCase(requestName)) {
                    if (rti.getGetCapabilities() != null) {
                        nl.b3p.xml.wfs.v100.capabilities.DCPType_GetCapabilitiesType[] requestDcpTypes = rti.getGetCapabilities().getDCPType_GetCapabilitiesType();
                        for (int i2 = 0; i2 < requestDcpTypes.length; i2++) {
                            nl.b3p.xml.wfs.v100.capabilities.HTTP http = requestDcpTypes[i2].getHTTP();
                            for (int i3 = 0; i3 < http.getHTTPTypeItemCount(); i3++) {
                                if (http.getHTTPTypeItem(i3).getGet() != null) {
                                    methodsAllowed.add(GETMETHOD);
                                }
                                if (http.getHTTPTypeItem(i3).getPost() != null) {
                                    methodsAllowed.add(POSTMETHOD);
                                }
                            }

                        }
                    }
                } else if (OGCConstants.WFS_REQUEST_GetFeature.equalsIgnoreCase(requestName)) {
                    if (rti.getGetFeature() != null) {
                        nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType[] requestDcpTypes = rti.getGetFeature().getDCPType_FeatureTypeType();
                        for (int i2 = 0; i2 < requestDcpTypes.length; i2++) {
                            nl.b3p.xml.wfs.v100.capabilities.HTTP http = requestDcpTypes[i2].getHTTP();
                            for (int i3 = 0; i3 < http.getHTTPTypeItemCount(); i3++) {
                                if (http.getHTTPTypeItem(i3).getGet() != null) {
                                    methodsAllowed.add(GETMETHOD);
                                }
                                if (http.getHTTPTypeItem(i3).getPost() != null) {
                                    methodsAllowed.add(POSTMETHOD);
                                }
                            }

                        }
                    }
                } else if (OGCConstants.WFS_REQUEST_Transaction.equalsIgnoreCase(requestName)) {
                    if (rti.getTransaction() != null) {
                        nl.b3p.xml.wfs.v100.capabilities.DCPType_TransactionType[] requestDcpTypes = rti.getTransaction().getDCPType_TransactionType();
                        for (int i2 = 0; i2 < requestDcpTypes.length; i2++) {
                            nl.b3p.xml.wfs.v100.capabilities.HTTP http = requestDcpTypes[i2].getHTTP();
                            for (int i3 = 0; i3 < http.getHTTPTypeItemCount(); i3++) {
                                if (http.getHTTPTypeItem(i3).getGet() != null) {
                                    methodsAllowed.add(GETMETHOD);
                                }
                                if (http.getHTTPTypeItem(i3).getPost() != null) {
                                    methodsAllowed.add(POSTMETHOD);
                                }
                            }

                        }
                    }
                } else if (OGCConstants.WFS_REQUEST_GetFeatureWithLock.equalsIgnoreCase(requestName)) {
                    if (rti.getGetFeatureWithLock() != null) {
                        nl.b3p.xml.wfs.v100.capabilities.DCPType_FeatureTypeType[] requestDcpTypes = rti.getGetFeatureWithLock().getDCPType_FeatureTypeType();
                        for (int i2 = 0; i2 < requestDcpTypes.length; i2++) {
                            nl.b3p.xml.wfs.v100.capabilities.HTTP http = requestDcpTypes[i2].getHTTP();
                            for (int i3 = 0; i3 < http.getHTTPTypeItemCount(); i3++) {
                                if (http.getHTTPTypeItem(i3).getGet() != null) {
                                    methodsAllowed.add(GETMETHOD);
                                }
                                if (http.getHTTPTypeItem(i3).getPost() != null) {
                                    methodsAllowed.add(POSTMETHOD);
                                }
                            }

                        }
                    }
                } else if (OGCConstants.WFS_REQUEST_LockFeature.equalsIgnoreCase(requestName)) {
                    if (rti.getLockFeature() != null) {
                        nl.b3p.xml.wfs.v100.capabilities.DCPType[] requestDcpTypes = rti.getLockFeature().getDCPType();
                        for (int i2 = 0; i2 < requestDcpTypes.length; i2++) {
                            nl.b3p.xml.wfs.v100.capabilities.HTTP http = requestDcpTypes[i2].getHTTP();
                            for (int i3 = 0; i3 < http.getHTTPTypeItemCount(); i3++) {
                                if (http.getHTTPTypeItem(i3).getGet() != null) {
                                    methodsAllowed.add(GETMETHOD);
                                }
                                if (http.getHTTPTypeItem(i3).getPost() != null) {
                                    methodsAllowed.add(POSTMETHOD);
                                }
                            }

                        }
                    }
                }
            }
        } else if (cap instanceof nl.b3p.xml.wfs.v110.WFS_Capabilities) {
            nl.b3p.xml.wfs.v110.WFS_Capabilities cap110 = (nl.b3p.xml.wfs.v110.WFS_Capabilities) cap;
            if (cap110.getOperationsMetadata() != null) {
                nl.b3p.xml.ows.v100.OperationsMetadata metadata = cap110.getOperationsMetadata();
                for (int i = 0; i < metadata.getOperationCount(); i++) {
                    if (requestName.equalsIgnoreCase(metadata.getOperation(i).getName())) {
                        for (int i2 = 0; i2 < metadata.getOperation(i).getDCPCount(); i2++) {
                            nl.b3p.xml.ows.v100.DCP dcp = metadata.getOperation(i).getDCP(i2);
                            if (dcp.getHTTP() != null) {
                                for (int i3 = 0; i3 < dcp.getHTTP().getHTTPItemCount(); i3++) {
                                    nl.b3p.xml.ows.v100.HTTPItem httpitem = dcp.getHTTP().getHTTPItem(i3);
                                    if (httpitem.getPost() != null) {
                                        methodsAllowed.add(POSTMETHOD);
                                    }
                                    if (httpitem.getGet() != null) {
                                        methodsAllowed.add(GETMETHOD);
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
        return methodsAllowed;
    }

    /*
     * Combines 2 filters with <AND> and will add it to the getFeature.
     * Will look like:
     * <filter>
     * <and>
     * geomFilter
     * queryFilter
     * </and>
     * </filter>
     */
    public static void addCombinedAndFilter(GetFeature gf, FeatureType ft, Filter queryFilter, Filter geomFilter) throws Exception {
        Filter combinedFilter = null;

        String geomFilterString = OgcWfsClient.removeFilterTags(geomFilter);
        String queryFilterString = OgcWfsClient.removeFilterTags(queryFilter);

        StringBuffer sb = new StringBuffer();
        sb.append("<Filter><And>");
        sb.append(geomFilterString);
        sb.append(queryFilterString);
        sb.append("</And></Filter>");

        String filter = sb.toString();

        if (ft instanceof nl.b3p.xml.wfs.v100.capabilities.FeatureType) {
            combinedFilter = (nl.b3p.xml.ogc.v100.Filter) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v100.Filter.class, new StringReader(filter));
            ((nl.b3p.xml.wfs.v100.GetFeature) gf).getQuery(0).setFilter((nl.b3p.xml.ogc.v100.Filter) combinedFilter);
        } else if (ft instanceof nl.b3p.xml.wfs.v110.FeatureType) {
            combinedFilter = (nl.b3p.xml.ogc.v110.Filter) Unmarshaller.unmarshal(nl.b3p.xml.ogc.v110.Filter.class, new StringReader(filter));
            ((nl.b3p.xml.wfs.v110.GetFeature) gf).getQuery(0).setFilter((nl.b3p.xml.ogc.v110.Filter) combinedFilter);
        } else {
            throw new UnsupportedOperationException("Given Feature not supported");
        }
    }

    /*
     * Returns everything between the <filter></filter> tages as a string.
     */
    public static String removeFilterTags(Filter filter) throws MarshalException, ValidationException {
        String filterString = "";

        StringWriter sw = new StringWriter();
        Marshaller.marshal(filter, sw);
        String tempString = sw.toString();

        String[] tempArray = tempString.split("<");
        for (int i = 0; i < tempArray.length; i++) {
            if (!tempArray[i].equals("") && !tempArray[i].startsWith("Filter") && !tempArray[i].startsWith("/Filter") && !tempArray[i].startsWith("?xml")) {
                filterString += "<" + tempArray[i];
            }
        }

        return filterString;
    }
}
