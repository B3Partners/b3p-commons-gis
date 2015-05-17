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
 * OGCResponse.java
 *
 * Created on May 16, 2008, 9:32 AM
 *
 * Vergelijkbare klasse als OGCRequest.java maar dan om de response mee te verwerken die
 * de serviceprviders stuurt na een request.
 */
package nl.b3p.ogc.utils;

import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import static nl.b3p.ogc.utils.OGCCommunication.buildFullLayerName;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Chris
 */
public abstract class OGCResponse extends OGCCommunication implements OGCConstants {

    protected static final Log log = LogFactory.getLog(OGCResponse.class);
    protected String httpHost;
    protected String version;
    protected nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport newWfsV100ExceptionReport;
    protected nl.b3p.xml.ows.v100.ExceptionReport newOwsV100ExceptionReport;
    protected boolean usableResponse = false;
    protected boolean alreadyDirectWritten = false;
    
    /** Creates a new instance of OGCResponse */
    protected OGCResponse() {
    }

    public static boolean isWfsV100ErrorResponse(Element rootElement) {
        String tagName = OGCRequest.removeNamespace(rootElement.getTagName());

        if (tagName.equalsIgnoreCase(OGCConstants.WFS_SERVER_EXCEPTION)) {
            return true;
        } 
        return false;
    }
    
    public static boolean isOwsV100ErrorResponse(Element rootElement) {
        String tagName = OGCRequest.removeNamespace(rootElement.getTagName());

        if (tagName.equalsIgnoreCase(OGCConstants.WFS_OWS_EXCEPTION)) {
            return true;
        } 
        return false;
    }

    /**
     * In dit deel wordt ook de naam van de kaartlaag/featuretype aangepast
     * aan de gebruikte naam in het request.
     * @param doc
     * @param request
     * @param prefix
     * @throws Exception 
     */
    public abstract void rebuildResponse(Document doc, OGCRequest request, String prefix) throws Exception;
 
    /**
     * In dit deel wordt dus niet de naam van kaartlaag/featuretype aangepast,
     * dit moet al in de methode rebuildResponse zijn gebeurd
     * @param layers
     * @param ogcrequest
     * @param encoding
     * @return 
     */
    public abstract String getResponseBody(List<SpLayerSummary> layers, OGCRequest ogcrequest, String encoding);
    
    public void setUsableResponse(boolean usable) {
        usableResponse = usable;
    }
    
    public boolean isUsableResponse() {
        return usableResponse;
    }
    
    public boolean hasWfsV100ErrorResponse() {
        return newWfsV100ExceptionReport!=null;
    }
    
    public boolean hasOwsV100ErrorResponse() {
        return newOwsV100ExceptionReport!=null;
    }
    
    public void logErrorResponse(String encoding) {
        if (hasWfsV100ErrorResponse()) {
                log.error("Response was given while an underlying error (WFS 1.0.0) was detected but ignored: "
                + this.getWfsV100ErrorResponseBody(encoding));
        }
        if (hasOwsV100ErrorResponse()) {
                log.error("Response was given while an underlying error (OWS 1.0.0) was detected but ignored: "
                + this.getOwsV100ErrorResponseBody(encoding));
        }
    }
    
    /**
     * Nu wordt alleen laatste fout weggeschreven, nog verbeteren indien
     * mogelijk dat fouten bij elkaar worden opgeteld.
     * @param doc
     * @param request
     * @param prefix
     * @throws Exception
     */
    public void rebuildWfsV100ErrorResponse(Document doc, OGCRequest request, String prefix) throws Exception {
        Element element = (Element) doc.getDocumentElement();
        this.httpHost = request.getUrlWithNonOGCparams();
        Unmarshaller um;
        Object o;
 
       version = request.getFinalVersion();

        um = new Unmarshaller(nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport.class);
        o = um.unmarshal(element);
        nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport exceptionReport = (nl.b3p.xml.ogc.v100.exception.ServiceExceptionReport) o;

        newWfsV100ExceptionReport = exceptionReport;
    }
    
    public void rebuildOwsV100ErrorResponse(Document doc, OGCRequest request, String prefix) throws Exception {
        Element element = (Element) doc.getDocumentElement();
        this.httpHost = request.getUrlWithNonOGCparams();
        Unmarshaller um;
        Object o;
 
        version = request.getFinalVersion();

        um = new Unmarshaller(nl.b3p.xml.ows.v100.ExceptionReport.class);
        o = um.unmarshal(element);
        nl.b3p.xml.ows.v100.ExceptionReport exceptionReport = (nl.b3p.xml.ows.v100.ExceptionReport) o;

        newOwsV100ExceptionReport = exceptionReport;
    }

     public String getWfsV100ErrorResponseBody(String encoding) {
        Object castorObject = newWfsV100ExceptionReport;
        return marshalObject(castorObject, encoding);
     }
     
     public String getOwsV100ErrorResponseBody(String encoding) {
        Object castorObject = newOwsV100ExceptionReport;
        return marshalObject(castorObject, encoding);
     }

     protected String marshalObject(Object castorObject) {
         return marshalObject(castorObject, null);
     }
     protected String marshalObject(Object castorObject, String encoding) {
        String body = null;
        try {
            StringWriter sw = new StringWriter();
            Marshaller m = new Marshaller(sw);
            m.setEncoding(encoding);
            
            if (this.getNameSpaces() != null) {
                Set keys = this.getNameSpaces().keySet();
                Iterator it = keys.iterator();
                for (int i = 0; it.hasNext(); i++) {
                    String prefix = (String) it.next();
                    String location = (String) this.getNameSpace(prefix);
                    m.setNamespaceMapping(prefix, location);
                }
            }
            if (getSchemaLocations() != null) {
                Set keys = getSchemaLocations().keySet();
                Iterator it = keys.iterator();
                for (int i = 0; it.hasNext(); i++) {
                    String prefix = (String) it.next();
                    String location = (String) getSchemaLocations().get(prefix);
                    m.setSchemaLocation(location);
                }
            }

            if (castorObject != null) {
                m.marshal(castorObject);
                body = sw.toString();
            }
        } catch (Exception e) {
            throw new UnsupportedOperationException("Failed to get body of XML! Exception: " + e);
        }
        return body;
    }

    protected NodeList getNodeListFromXPath(Node currentNode, String xPathFrag) throws Exception {
        if (xPathFrag == null || xPathFrag.length() == 0) {
            return null;
        }
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        xpath.setNamespaceContext(getNamespaceContext());

        XPathExpression expr = xpath.compile(xPathFrag);
        Object result = expr.evaluate(currentNode, XPathConstants.NODESET);
        return (NodeList) result;
    }

    /**
     * find layername in requestlayers that corresponds to response layername
     * @param responseName name as found in response form underlying service
     * @param layerMapList
     * @return name as found in request and thus should be used in passed response
     * @throws Exception 
     */
    public String getRequestName(String responseName, List<SpLayerSummary> spLayerMapList, String spInUrl) throws Exception {
        for (SpLayerSummary sls : spLayerMapList) {
            LayerSummary responseLayerMap = splitLayerInParts(responseName, true, spInUrl, null);
            String responseLayerName = responseLayerMap.getLayerName();
            if (responseLayerName == null) {
                // impossible
                return null;
            }
            List<LayerSummary> lsl = sls.getLayers();
            for (LayerSummary requestLayerMap : lsl) {
                //only check on pure layer name without namespace
                //hack necessary because response does not (always) return
                //same namespace as in request.
                String requestLayerName = requestLayerMap.getLayerName();
                if (requestLayerName != null && requestLayerName.equals(responseLayerName)) {
                    if (spInUrl==null) {
                        return buildFullLayerName(requestLayerMap);
                    } else {
                        return buildLayerNameWithoutSp(requestLayerMap);
                    }
                }

            }
        }
        return null;
    }
      
    protected String serializeNode(Node doc) throws TransformerConfigurationException, TransformerException {
        StringWriter outText = new StringWriter();
        StreamResult sr = new StreamResult(outText);
        Properties oprops = new Properties();
        oprops.put(OutputKeys.METHOD, "xml");
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.setOutputProperties(oprops);
        t.transform(new DOMSource(doc), sr);
        return outText.toString();
    }

    /**
     * @return the alreadyDirectWritten
     */
    public boolean isAlreadyDirectWritten() {
        return alreadyDirectWritten;
    }

    /**
     * @param alreadyDirectWritten the alreadyDirectWritten to set
     */
    public void setAlreadyDirectWritten(boolean alreadyDirectWritten) {
        this.alreadyDirectWritten = alreadyDirectWritten;
    }

 }
