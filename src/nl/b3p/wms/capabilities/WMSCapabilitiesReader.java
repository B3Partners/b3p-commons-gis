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
Since some documents give errors, below are some documents defined with special settings to
filter out the different kind of errors:
- no errors but missing doctype in file
WMT_MS wmt = wms.getWMT_MS("wmtIII");

- time out due to server offline
WMT_MS wmt = wms.getWMT_MS("http://demo.cubewerx.com/demo/cubeserv/cubeserv.cgi?SERVICE=WMS&VERSION=1.1.1&REQUEST=GetCapabilities");

- error due to link in doctype
WMT_MS wmt = wms.getWMT_MS("http://viz.globe.gov/viz-bin/wmt.cgi?SERVICE=WMS&VERSION=1.1.1&REQUEST=GetCapabilities");
 */
package nl.b3p.wms.capabilities;

import nl.b3p.ogc.utils.KBConfiguration;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import java.util.Stack;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.xml.sax.Attributes;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import nl.b3p.commons.xml.IgnoreEntityResolver;
import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.SAXException;

public class WMSCapabilitiesReader {

    private static final Log log = LogFactory.getLog(WMSCapabilitiesReader.class);
    private static final String VALIDATION_FEATURE = "http://xml.org/sax/features/validation";
    private static final String SCHEMA_FEATURE = "http://apache.org/xml/features/validation/schema";
    private static final String SCHEMA_FACTORY = "http://www.w3.org/2001/XMLSchema";
    private static final String SCHEMA_FILE = "wms.xsd";
    private static final String host = AuthScope.ANY_HOST; // "localhost";
    private static final int port = AuthScope.ANY_PORT;
    private static final int RTIMEOUT = 20000;
    private Stack stack = new Stack();
    private Switcher s = null;
    private ServiceProvider serviceProvider = null;

    /** Constructor of the WMSCapabilitiesReader.
     *
     * @param serviceProvider ServiceProvider object in which all information has to be saved.
     */
    // <editor-fold defaultstate="" desc="WMSCapabilitiesReader(ServiceProvider serviceProvider) constructor.">
    public WMSCapabilitiesReader() {
        this.setElementHandlers();
    }
    // </editor-fold>

    private void checkObject(Object obj) throws SAXException {
        if (obj != null) {
            return;
        }
        StringBuffer message = new StringBuffer();
        message.append("No service provider created, possible cause: invalid GetCapabilities xml. ");
        if (obj instanceof ServiceProvider) {
            message.append("Service provider is null. ");
        } else if (obj instanceof Layer) {
            message.append("Layer is null. ");
            //TODO andere objecten
        }
        throw new SAXException(message.toString());
    }

    public ByteArrayOutputStream getCapabilities(String location) throws Exception {
        return getCapabilities(location, null, null);
    }

    public ByteArrayOutputStream getCapabilities(String location, String username, String password) throws Exception {
        HttpClient client = new HttpClient();
        client.getHttpConnectionManager().
                getParams().setConnectionTimeout(RTIMEOUT);

        if (username != null && password != null) {
            client.getParams().setAuthenticationPreemptive(true);
            Credentials defaultcreds = new UsernamePasswordCredentials(username, password);
            AuthScope authScope = new AuthScope(host, port);
            client.getState().setCredentials(authScope, defaultcreds);
        }

        // Create a method instance.
        GetMethod method = new GetMethod(location);
        ByteArrayOutputStream out = null;
        try {
            int statusCode = client.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
//                log.error("Host: " + location + " error: " + method.getStatusLine().getReasonPhrase());
                throw new Exception("Host: " + location + " error: " + method.getStatusLine().getReasonPhrase());
            }
            String mimeType = null;
            if (method.getResponseHeader("Content-Type") != null) {
                mimeType = method.getResponseHeader("Content-Type").getValue();
            }
            if (mimeType == null || mimeType.indexOf("xml") == -1) {
//                log.error("Host: " + location + " error: Cannot get a GetCapabilities document from server");
                throw new Exception("Host: " + location + " error: Cannot get a GetCapabilities document from server");
            }
            if (mimeType.equals("application/vnd.ogc.se_xml")) {
//                log.error("Host: " + location + " error: Cannot get a GetCapabilities document. reason: " + method.getResponseBodyAsString());
                throw new Exception("Host: " + location + " error: Cannot get a GetCapabilities document. reason: " + method.getResponseBodyAsString());
            }

            InputStream is = method.getResponseBodyAsStream();
            int len = 0;
            out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            while ((len = is.read(buf)) > -1) {
                out.write(buf, 0, len);
            }

        } catch (IOException ex) {
            log.error("Could not read inputsource.", ex);

        } finally {
            // Release the connection.
            method.releaseConnection();
        }

        if (out == null) {
//            log.error("Host: " + location + " error: No service provider object could be created, unkown reason!");
            throw new Exception("Host: " + location + " error: No service provider object could be created, unkown reason!");
        }
        return out;
    }

    /** Private method which validates a XML document at a given location.
     *
     * @param location String representing the location where the document can be found.
     *
     * @return a filled ServiceProvider with the information read from the XML document.
     *
     * @throws IOException
     * @throws SAXException
     */
    // <editor-fold defaultstate="" desc="getProvider(String location) method.">
    public ServiceProvider getProvider(String location) throws IOException, SAXException, Exception {
        return getProvider(location, null, null);
    }

    public ServiceProvider getProvider(String location, String username, String password) throws IOException, SAXException, Exception {

        ByteArrayOutputStream getCap = getCapabilities(location, username, password);
        //String xml = getCapabilities(location, username, password);
        ByteArrayInputStream in = new ByteArrayInputStream(getCap.toByteArray());


        //Nu kan het service provider object gemaakt en gevuld worden
        serviceProvider = new ServiceProvider();
        XMLReader reader = org.xml.sax.helpers.XMLReaderFactory.createXMLReader();
        // niet zinvol met IgnoreEntityResolver hierna
//        reader.setFeature(VALIDATION_FEATURE, true);
//        reader.setFeature(SCHEMA_FEATURE, true);

        IgnoreEntityResolver r = new IgnoreEntityResolver();
        reader.setEntityResolver(r);

        reader.setContentHandler(s);
        InputSource is = new InputSource(in);
        is.setEncoding(KBConfiguration.CHARSET);

        reader.parse(is);

        if (serviceProvider == null) {
            log.error("Host: " + location + " error: No service provider object could be created, unkown reason!");
            throw new Exception("Host: " + location + " error: No service provider object could be created, unkown reason!");
        }
        return serviceProvider;
    }
    // </editor-fold>

    /** Private method which validates a XML document at a given location.
     *
     * @param location String representing the location where the document can be found.
     *
     * @throws IOException
     * @throws SAXException
     */
    // <editor-fold defaultstate="" desc="validate(String location) method.">
    private void validate(String location) throws IOException, SAXException {
        SchemaFactory factory = SchemaFactory.newInstance(SCHEMA_FACTORY);
        File schemaLocation = new File(SCHEMA_FILE);
        Schema schema = factory.newSchema(schemaLocation);
        Validator validator = schema.newValidator();

        Source source = new StreamSource(new File(location));
        validator.validate(source);
    }
    // </editor-fold>

    /** Private method which initializes all the elementhandlers.
     * Each element in the xml document has to be treated in its own way therefore each element has its
     * own handler which controls the actions to be taken if an element of a certain kind is found.
     */
    // <editor-fold defaultstate="" desc="setElementHandlers() method.">
    private void setElementHandlers() {
        s = new Switcher();
        s.setElementHandler("WMT_MS_Capabilities", new WMTHandler());
        s.setElementHandler("Service", new ServiceHandler());
        s.setElementHandler("Name", new NameHandler());
        s.setElementHandler("Title", new TitleHandler());
        s.setElementHandler("Abstract", new AbstractHandler());
        s.setElementHandler("Fees", new FeesHandler());
        s.setElementHandler("AccessConstraints", new ConstraintsHandler());
        s.setElementHandler("OnlineResource", new OnlineResourceHandler());
        s.setElementHandler("KeywordList", new KeywordListHandler());
        s.setElementHandler("Keyword", new KeywordHandler());
        s.setElementHandler("City", new CityHandler());
        s.setElementHandler("Address", new AddressHandler());
        s.setElementHandler("AddressType", new AddressTypeHandler());
        s.setElementHandler("StateOrProvince", new StateOrProvinceHandler());
        s.setElementHandler("PostCode", new PostCodeHandler());
        s.setElementHandler("Country", new CountryHandler());
        s.setElementHandler("ContactOrganization", new ContactOrganizationHandler());
        s.setElementHandler("ContactPerson", new ContactPersonHandler());
        s.setElementHandler("ContactPersonPrimary", new ContactPersonPrimaryHandler());
        s.setElementHandler("ContactPosition", new ContactPositionHandler());
        s.setElementHandler("ContactAddress", new ContactAddressHandler());
        s.setElementHandler("ContactVoiceTelephone", new ContactVoiceTelephoneHandler());
        s.setElementHandler("ContactFacsimileTelephone", new ContactFacsimileTelephoneHandler());
        s.setElementHandler("ContactElectronicMailAddress", new ContactElectronicMailAddressHandler());
        s.setElementHandler("ContactInformation", new ContactInformationHandler());
        s.setElementHandler("Format", new FormatHandler());
        s.setElementHandler("SRS", new SRSHandler());
        s.setElementHandler("Capability", new CapabilityHandler());
        s.setElementHandler("Request", new RequestHandler());
        s.setElementHandler("Exception", new ExceptionHandler());
        s.setElementHandler("GetCapabilities", new GetCapabilitiesHandler());
        s.setElementHandler("GetMap", new GetMapHandler());
        s.setElementHandler("GetFeatureInfo", new GetFeatureInfoHandler());
        s.setElementHandler("DescribeLayer", new DescribeLayerHandler());
        s.setElementHandler("GetLegendGraphic", new GetLegendGraphicHandler());
        s.setElementHandler("GetStyles", new GetStylesHandler());
        s.setElementHandler("Style", new StyleHandler());
        s.setElementHandler("LegendURL", new LegendURLHandler());
        s.setElementHandler("Layer", new LayerHandler());
        s.setElementHandler("Attribution", new AttributionHandler());
        s.setElementHandler("DCPType", new DCPTypeHandler());
        s.setElementHandler("Get", new GetHandler());
        s.setElementHandler("Post", new PostHandler());
        s.setElementHandler("HTTP", new HTTPHandler());
        s.setElementHandler("PutStyles", new PutStylesHandler());
        s.setElementHandler("BoundingBox", new BoundingBoxHandler());
        s.setElementHandler("LatLonBoundingBox", new LatLonBoundingBoxHandler());
        s.setElementHandler("Dimension", new DimensionHandler());
        s.setElementHandler("Extent", new ExtentHandler());
        s.setElementHandler("AuthorityURL", new AuthorityURLHandler());
        s.setElementHandler("Identifier", new IdentifierHandler());
        s.setElementHandler("MetadataURL", new MetadataURLHandler());
        s.setElementHandler("DataURL", new DataURLHandler());
        s.setElementHandler("FeatureListURL", new FeatureListURLHandler());
        s.setElementHandler("ScaleHint", new ScaleHintHandler());
        s.setElementHandler("LogoURL", new LogoURLHandler());
        s.setElementHandler("StyleURL", new StyleURLHandler());
        s.setElementHandler("StyleSheetURL", new StyleSheetURLHandler());
        s.setElementHandler("LegendURL", new LegendURLHandler());

        //These two Handlers are not being used
        s.setElementHandler("VendorSpecificCapabilities", new VendorSpecificCapabilitiesHandler());
        s.setElementHandler("Role", new RoleHandler());
        s.setElementHandler("OrganizationCode", new OrganizationCodeHandler());        
        s.setElementHandler("ExpireDate", new ExpireDateHandler());
        s.setElementHandler("UserName", new UserNameHandler());
        s.setElementHandler("PersonalCode", new PersonalCodeHandler());
        //s.setElementHandler("UserDefinedSymbolization", new UserDefinedSymbolizationHandler());
    }
    // </editor-fold>

    /**
     * Below are all Handlers defined.
     * Each element is passed to it's own handler which takes action on its own and
     * gives control back immediatly after its action
     */
    // <editor-fold defaultstate="" desc="Defined Handlers.">
    private class WMTHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            //<WMT_MS_Capabilities version="1.1.1">
            checkObject(serviceProvider);
            String version = attributes.getValue("version");
            serviceProvider.setWmsVersion(version);
            stack.push(serviceProvider);
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }

    private class ServiceHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }

    private class CapabilityHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }

    private class RequestHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }

    private class ExceptionHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }

    private class GetCapabilitiesHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            String domain = new String("GetCapabilities");
            stack.push(domain);
            ServiceDomainResource domainResource = new ServiceDomainResource();
            stack.push(domainResource);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            ServiceDomainResource domainResource = (ServiceDomainResource) stack.pop();
            //remove the domainname
            stack.pop();
            ServiceProvider serviceProvider = (ServiceProvider) stack.peek();
            checkObject(serviceProvider);
            serviceProvider.addDomainResource(domainResource);
        }
    }

    private class GetMapHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            String domain = new String("GetMap");
            stack.push(domain);
            ServiceDomainResource domainResource = new ServiceDomainResource();
            stack.push(domainResource);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            ServiceDomainResource domainResource = (ServiceDomainResource) stack.pop();
            //remove the domainname
            stack.pop();
            ServiceProvider serviceProvider = (ServiceProvider) stack.peek();
            checkObject(serviceProvider);
            serviceProvider.addDomainResource(domainResource);
        }
    }

    private class GetFeatureInfoHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            String domain = new String("GetFeatureInfo");
            stack.push(domain);
            ServiceDomainResource domainResource = new ServiceDomainResource();
            stack.push(domainResource);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            ServiceDomainResource domainResource = (ServiceDomainResource) stack.pop();
            //remove the domainname
            stack.pop();
            ServiceProvider serviceProvider = (ServiceProvider) stack.peek();
            checkObject(serviceProvider);
            serviceProvider.addDomainResource(domainResource);
        }
    }

    private class DescribeLayerHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            String domain = new String("DescribeLayer");
            stack.push(domain);
            ServiceDomainResource domainResource = new ServiceDomainResource();
            stack.push(domainResource);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            ServiceDomainResource domainResource = (ServiceDomainResource) stack.pop();
            //remove the domainname
            stack.pop();
            ServiceProvider serviceProvider = (ServiceProvider) stack.peek();
            checkObject(serviceProvider);
            serviceProvider.addDomainResource(domainResource);
        }
    }

    private class GetLegendGraphicHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            String domain = new String("GetLegendGraphic");
            stack.push(domain);
            ServiceDomainResource domainResource = new ServiceDomainResource();
            stack.push(domainResource);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            ServiceDomainResource domainResource = (ServiceDomainResource) stack.pop();
            //remove the domainname
            stack.pop();
            ServiceProvider serviceProvider = (ServiceProvider) stack.peek();
            checkObject(serviceProvider);
            serviceProvider.addDomainResource(domainResource);
        }
    }

    private class GetStylesHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            String domain = new String("GetStyles");
            stack.push(domain);
            ServiceDomainResource domainResource = new ServiceDomainResource();
            stack.push(domainResource);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            ServiceDomainResource domainResource = (ServiceDomainResource) stack.pop();
            //remove the domainname
            stack.pop();
            ServiceProvider serviceProvider = (ServiceProvider) stack.peek();
            checkObject(serviceProvider);
            serviceProvider.addDomainResource(domainResource);
        }
    }

    private class PutStylesHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            String domain = new String("PutStyles");
            stack.push(domain);
            ServiceDomainResource domainResource = new ServiceDomainResource();
            stack.push(domainResource);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            ServiceDomainResource domainResource = (ServiceDomainResource) stack.pop();
            //remove the domainname
            stack.pop();
            ServiceProvider serviceProvider = (ServiceProvider) stack.peek();
            checkObject(serviceProvider);
            serviceProvider.addDomainResource(domainResource);
        }
    }

    private class DCPTypeHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }

    private class HTTPHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }

    private class GetHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            String get = new String("GET");
            stack.push(get);
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }

    private class PostHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            String post = new String("POST");
            stack.push(post);
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }

    private class LayerHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            Layer layer = new Layer();
            String queryable = attributes.getValue("queryable");
            String cascaded = attributes.getValue("cascaded");
            String opaque = attributes.getValue("opaque");
            String noSubsets = attributes.getValue("noSubsets");
            String fixedWidth = attributes.getValue("fixedWidth");
            String fixedHeight = attributes.getValue("fixedHeight");
            layer.setQueryable(queryable);

            /*
             * A Layer is said to have been "cascaded" if it was obtained from an originating server and
             * then included in the Capabilities XML of a different server. The second server may
             * simply offer an additional access point for the Layer, or may add value by offering
             * additional output formats or spatial reference systems.
             * If a WMS cascades the content of another WMS then it shall increment by 1 the value of
             * the cascaded attribute for the affected layers. If that attribute is missing from the
             * originating WMS's Capabilities XML, then the Cascading WMS shall insert the attribute
             * and set it to 1.
             */
            if (cascaded == null) {
                cascaded = "1";
            } else {
                int c = Integer.parseInt(cascaded);
                c++;
                cascaded = "" + c;

            }

            layer.setCascaded(cascaded);
            layer.setOpaque(opaque);
            layer.setNosubsets(noSubsets);
            layer.setFixedWidth(fixedWidth);
            layer.setFixedHeight(fixedHeight);
            stack.push(layer);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Layer layer = (Layer) stack.pop();
            Object obj = stack.peek();
            if (obj instanceof Layer) {
                Layer layerAtStack = (Layer) obj;
                checkObject(layerAtStack);
                try {
                    layerAtStack.addLayer(layer);
                } catch (Exception ex) {
                    throw new SAXException(ex);
                }
            } else if (obj instanceof ServiceProvider) {
                ServiceProvider serviceProvider = (ServiceProvider) obj;
                checkObject(serviceProvider);
                serviceProvider.setTopLayer(layer);
            }
        }
    }

    private class StyleHandler extends ElementHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes atts) {
            Style style = new Style();
            stack.push(style);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            Style style = (Style) stack.pop();
            Layer layer = (Layer) stack.peek();
            checkObject(layer);

            if (style.getName() == null || style.getName().equals("")) {
                style.setName("default");
            }

            if (style.getTitle() == null || style.getTitle().equals("")) {
                style.setTitle("default");
            }
            
            layer.addStyle(style);
        }
    }

    private class FormatHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object object = stack.peek();
            if (object instanceof LayerDomainResource) {
                LayerDomainResource domainResource = (LayerDomainResource) object;
                checkObject(domainResource);
                domainResource.addFormat(sb.toString());
            } else if (object instanceof ServiceDomainResource) {
                ServiceDomainResource domainResource = (ServiceDomainResource) object;
                checkObject(domainResource);
                domainResource.addFormat(sb.toString());
            } else if (object instanceof StyleDomainResource) {
                StyleDomainResource domainResource = (StyleDomainResource) object;
                checkObject(domainResource);
                domainResource.addFormat(sb.toString());
            } else if (object instanceof Attribution) {
                Attribution attribution = (Attribution) object;
                checkObject(attribution);
                attribution.setLogoFormat(sb.toString());
            } else if (object instanceof ServiceProvider) {
                ServiceProvider serviceProvider = (ServiceProvider) object;
                checkObject(serviceProvider);
                serviceProvider.addException(sb.toString());
            }
        }
    }

    private class SRSHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object object = stack.peek();
            if (object instanceof Layer) {
                Layer layer = (Layer) object;
                checkObject(layer);
                String srssen = sb.toString();
                if (srssen.contains(" ")) {
                    String[] tokens = srssen.split(" ");
                    //doorloop de door spatie gescheiden srsen
                    for (int t = 0; t < tokens.length; t++) {
                        SrsBoundingBox srsbb = new SrsBoundingBox();
                        srsbb.setSrs(tokens[t]);
                        layer.addSrsbb(srsbb);
                    }
                } else if (srssen.length() > 0) {
                    SrsBoundingBox srsbb = new SrsBoundingBox();
                    srsbb.setSrs(srssen);
                    layer.addSrsbb(srsbb);
                }
            }
        }
    }
    //Begin part of layer

    private class BoundingBoxHandler extends ElementHandler {
        //instance of Layer

        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            Object object = stack.peek();
            if (object instanceof Layer) {
                Layer layer = (Layer) object;
                SrsBoundingBox srsbb = new SrsBoundingBox();
                srsbb.setSrs(attributes.getValue("SRS"));
                srsbb.setMinx(attributes.getValue("minx"));
                srsbb.setMiny(attributes.getValue("miny"));
                srsbb.setMaxx(attributes.getValue("maxx"));
                srsbb.setMaxy(attributes.getValue("maxy"));
                srsbb.setResx(attributes.getValue("resx"));
                srsbb.setResy(attributes.getValue("resy"));
                srsbb.setLayer(layer);
                layer.addSrsbb(srsbb);

            }
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }

    private class LatLonBoundingBoxHandler extends ElementHandler {
        //instance of Layer

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            Object object = stack.peek();
            if (object instanceof Layer) {
                Layer layer = (Layer) object;
                checkObject(layer);
                SrsBoundingBox srsbb = new SrsBoundingBox();
                //srsbb.setSrs("EPSG:4326");
                srsbb.setMinx(attributes.getValue("minx"));
                srsbb.setMiny(attributes.getValue("miny"));
                srsbb.setMaxx(attributes.getValue("maxx"));
                srsbb.setMaxy(attributes.getValue("maxy"));
                srsbb.setLayer(layer);
                layer.addSrsbb(srsbb);
            }
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }

    private class DimensionHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            Dimensions dimension = new Dimensions();
            String name = attributes.getValue("name");
            String units = attributes.getValue("units");
            String unitSymbol = attributes.getValue("unitSymbol");
            dimension.setDimensionsName(name);
            dimension.setDimensionsUnit(units);
            dimension.setDimensionsUnitSymbol(unitSymbol);
            stack.push(dimension);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Dimensions dimension = (Dimensions) stack.pop();
            Object object = stack.peek();
            if (object instanceof Layer) {
                Layer layer = (Layer) object;
                checkObject(layer);
                layer.addDimension(dimension);
            }
        }
    }

    private class ExtentHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            Object object = stack.peek();
            if (object instanceof Layer) {
                Layer layer = (Layer) object;
                checkObject(layer);
                layer.getDimensions();
                //Still need to do something here
                //Get the Identifiers and look through them to find the one with the same
                //name as the one we have here. Add the value to this identifier and add the
                //identifier again to the Set of identifiers
                //place the renewed Set back in the Layer object.

                String name = attributes.getValue("name");
                String defaults = attributes.getValue("default");
                String nearestValue = attributes.getValue("nearestValue");
                String multipleValues = attributes.getValue("multipleValues");
                String current = attributes.getValue("current");
                //extent.setName(name);
                //extent.setDefaults(defaults);
                //extent.setNearestValue(nearestValue);
                //extent.setMultipleValues(multipleValues);
                //extent.setCurrent(current);
            }
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }

    private class AuthorityURLHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            Identifier identifier = new Identifier();
            String authority = attributes.getValue("name");
            identifier.setAuthorityName(authority);
            stack.push(identifier);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Identifier identifier = (Identifier) stack.pop();
            Object object = stack.peek();
            if (object instanceof Layer) {
                Layer layer = (Layer) object;
                checkObject(layer);
                layer.addIdentifier(identifier);
            }
        }
    }

    private class IdentifierHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            Object object = stack.peek();
            if (object instanceof Layer) {
                Layer layer = (Layer) object;
                checkObject(layer);
                layer.getIdentifiers();
                //Still need to do something here
                //Get the Identifiers and look through them to find the one with the same
                //name as the one we have here. Add the value to this identifier and add the
                //identifier again to the Set of identifiers
                //place the renewed Set back in the Layer object.
            }
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }

    private class MetadataURLHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            String domain = new String("MetadataURL");
            stack.push(domain);
            LayerDomainResource domainResource = new LayerDomainResource();
            stack.push(domainResource);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            LayerDomainResource domainResource = (LayerDomainResource) stack.pop();
            //remove domainname
            stack.pop();
            Layer layer = (Layer) stack.peek();
            checkObject(layer);
            layer.addDomainResource(domainResource);
        }
    }

    private class DataURLHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            String domain = new String("DataURL");
            stack.push(domain);
            LayerDomainResource domainResource = new LayerDomainResource();
            stack.push(domainResource);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            LayerDomainResource domainResource = (LayerDomainResource) stack.pop();
            //remove domainname
            stack.pop();
            Layer layer = (Layer) stack.peek();
            checkObject(layer);
            layer.addDomainResource(domainResource);
        }
    }

    private class FeatureListURLHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            String domain = new String("FeatureListURL");
            stack.push(domain);
            LayerDomainResource domainResource = new LayerDomainResource();
            stack.push(domainResource);

        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            LayerDomainResource domainResource = (LayerDomainResource) stack.pop();
            //remove domainname
            stack.pop();
            Layer layer = (Layer) stack.peek();
            checkObject(layer);
            layer.addDomainResource(domainResource);
        }
    }

    private class ScaleHintHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            String min = attributes.getValue("min");
            String max = attributes.getValue("max");

            Object object = stack.peek();
            if (object instanceof Layer) {
                Layer layer = (Layer) object;
                checkObject(layer);
                layer.setScaleHintMin(min);
                layer.setScaleHintMax(max);
            }
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }
    //End part of layer
    //Part of attribution

    private class AttributionHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            Attribution attribution = new Attribution();
            stack.push(attribution);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Attribution attribution = (Attribution) stack.pop();
            Object object = stack.peek();
            if (object instanceof Layer) {
                Layer layer = (Layer) object;
                checkObject(layer);
                if (attribution == null) {
                    log.debug("Attribution is null, but still getting here.... explain to me");
                }
                layer.setAttribution(attribution);
            }
        }
    }

    private class LogoURLHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            String width = attributes.getValue("width");
            String height = attributes.getValue("height");
            Object object = stack.peek();
            if (object instanceof Attribution) {
                Attribution attribution = (Attribution) object;
                checkObject(attribution);
                attribution.setLogoWidth(width);
                attribution.setLogoHeight(height);
            }
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }
    //End part of attribution
    //Part of style

    private class StyleURLHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            String domain = new String("StyleURLHandler");
            stack.push(domain);
            StyleDomainResource domainResource = new StyleDomainResource();
            stack.push(domainResource);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            StyleDomainResource domainResource = (StyleDomainResource) stack.pop();
            //remove domainname
            stack.pop();
            Style style = (Style) stack.peek();
            checkObject(style);
            style.addDomainResource(domainResource);
        }
    }

    private class StyleSheetURLHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            String domain = new String("StyleSheetURL");
            stack.push(domain);
            StyleDomainResource domainResource = new StyleDomainResource();
            stack.push(domainResource);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            StyleDomainResource domainResource = (StyleDomainResource) stack.pop();
            //remove domainname
            stack.pop();
            Style style = (Style) stack.peek();
            checkObject(style);
            style.addDomainResource(domainResource);
        }
    }

    private class LegendURLHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            String domain = new String("LegendURL");
            stack.push(domain);
            StyleDomainResource domainResource = new StyleDomainResource();
            domainResource.setWidth(atts.getValue("width"));
            domainResource.setHeight(atts.getValue("height"));
            stack.push(domainResource);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            StyleDomainResource domainResource = (StyleDomainResource) stack.pop();
            //remove domainname
            stack.pop();
            Style style = (Style) stack.peek();
            checkObject(style);
            style.addDomainResource(domainResource);
        }
    }
    //End part of style

    private class NameHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object object = stack.peek();
            if (object instanceof ServiceProvider) {
                ServiceProvider serviceProvider = (ServiceProvider) object;
                checkObject(serviceProvider);
                serviceProvider.setName(sb.toString());
            } else if (object instanceof Layer) {
                Layer layer = (Layer) object;
                checkObject(layer);
                layer.setName(sb.toString());
            } else if (object instanceof Style) {
                Style style = (Style) object;
                checkObject(style);
                style.setName(sb.toString());
            }
        }
    }

    private class TitleHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object object = stack.peek();
            if (object instanceof ServiceProvider) {
                ServiceProvider serviceProvider = (ServiceProvider) object;
                checkObject(serviceProvider);
                serviceProvider.setTitle(sb.toString());
            } else if (object instanceof Layer) {
                Layer layer = (Layer) object;
                checkObject(layer);
                layer.setTitle(sb.toString());
            } else if (object instanceof Attribution) {
                Attribution attribution = (Attribution) object;
                checkObject(attribution);
                attribution.setTitle(sb.toString());
            } else if (object instanceof Style) {
                Style style = (Style) object;
                checkObject(style);
                style.setTitle(sb.toString());
            }
        }
    }

    private class AbstractHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object object = stack.peek();
            if (object instanceof ServiceProvider) {
                ServiceProvider serviceProvider = (ServiceProvider) object;
                checkObject(serviceProvider);
                serviceProvider.setAbstracts(sb.toString());
            } else if (object instanceof Layer) {
                Layer layer = (Layer) object;
                checkObject(layer);
                layer.setAbstracts(sb.toString());
            } else if (object instanceof Style) {
                Style style = (Style) object;
                checkObject(style);
                style.setAbstracts(sb.toString());
            }
        }
    }

    private class FeesHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object object = stack.peek();
            if (object instanceof ServiceProvider) {
                ServiceProvider serviceProvider = (ServiceProvider) object;
                checkObject(serviceProvider);
                serviceProvider.setFees(sb.toString());
            }
        }
    }

    private class ConstraintsHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object object = stack.peek();
            if (object instanceof ServiceProvider) {
                ServiceProvider serviceProvider = (ServiceProvider) object;
                checkObject(serviceProvider);
                serviceProvider.setAccessConstraints(sb.toString());
            }
        }
    }

    private class KeywordListHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes attributes) {
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }

    private class KeywordHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object object = stack.peek();
            if (object instanceof ServiceProvider) {
                ServiceProvider serviceProvider = (ServiceProvider) object;
                checkObject(serviceProvider);
                serviceProvider.addKeyword(sb.toString());
            } else if (object instanceof Layer) {
                Layer layer = (Layer) object;
                checkObject(layer);
                layer.addKeyword(sb.toString());
            }
        }
    }

    private class OnlineResourceHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            String xlink = attributes.getValue("xmlns:xlink"); //not being used
            String type = attributes.getValue("xlink:type"); //not being used
            String href = attributes.getValue("xlink:href");

            //Stappenplan
            // eerst controleren of bovenste in stack een String met POST of GET is
            // zo ja dan weten we dat de laag eronder een ServiceDomainResource is
            // voer dan de stappen uit voor het vullen van een SDR:
            Object object = stack.peek();
            if (object instanceof String) {
                String method = (String) object;
                checkObject(method);
                if (method.equals("GET") || method.equals("POST")) {
                    stack.pop();
                    Object object2 = stack.peek();
                    if (object2 instanceof ServiceDomainResource) {
                        //Het object moet tijdelijk uit de stack gehaald worden om het onderliggende object te kunnen benaderen
                        ServiceDomainResource domainResource = (ServiceDomainResource) stack.pop();
                        //Het onderliggende object is een string met de domainnaam waar deze resource toe behoort
                        String domain = (String) stack.peek();
                        //vul de resource met de juiste gegevens
                        domainResource.setDomain(domain);
                        if (method.equals("GET")) {
                            domainResource.setGetUrl(href);
                        } else if (method.equals("POST")) {
                            domainResource.setPostUrl(href);
                        }
                        stack.push(domainResource);
                    }
                }
            } else if (object instanceof LayerDomainResource) {
                LayerDomainResource domainResource = (LayerDomainResource) stack.pop();
                checkObject(domainResource);
                String domain = (String) stack.peek();
                domainResource.setUrl(href);
                domainResource.setDomain(domain);
                stack.push(domainResource);
            } else if (object instanceof StyleDomainResource) {
                StyleDomainResource domainResource = (StyleDomainResource) stack.pop();
                checkObject(domainResource);
                String domain = (String) stack.peek();
                domainResource.setUrl(href);
                domainResource.setDomain(domain);
                stack.push(domainResource);
            } else if (object instanceof ServiceProvider) {
                ServiceProvider serviceProvider = (ServiceProvider) object;
                checkObject(serviceProvider);
                serviceProvider.setUrl(href);
            } else if (object instanceof Attribution) {
                Attribution attribution = (Attribution) object;
                checkObject(attribution);
                attribution.setAttributionURL(href);
            } else if (object instanceof Identifier) {
                Identifier identifier = (Identifier) object;
                checkObject(identifier);
                identifier.setAuthorityURL(href);
            }
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }
    //Below the handlers which handle all information about contact

    private class ContactInformationHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            ContactInformation contactInformation = new ContactInformation();
            stack.push(contactInformation);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            ContactInformation contactInformation = (ContactInformation) stack.pop();
            Object object = stack.peek();
            if (object instanceof ServiceProvider) {
                ServiceProvider serviceProvider = (ServiceProvider) object;
                checkObject(serviceProvider);
                serviceProvider.setContactInformation(contactInformation);
            }
        }
    }

    private class ContactPersonPrimaryHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }

    private class ContactPersonHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object object = stack.peek();
            if (object instanceof ContactInformation) {
                ContactInformation contactInformation = (ContactInformation) object;
                checkObject(contactInformation);
                contactInformation.setContactPerson(sb.toString());
            }
        }
    }

    private class ContactOrganizationHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object object = stack.peek();
            if (object instanceof ContactInformation) {
                ContactInformation contactInformation = (ContactInformation) object;
                checkObject(contactInformation);
                contactInformation.setContactOrganization(sb.toString());
            }
        }
    }

    private class ContactPositionHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object object = stack.peek();
            if (object instanceof ContactInformation) {
                ContactInformation contactInformation = (ContactInformation) object;
                checkObject(contactInformation);
                contactInformation.setContactPosition(sb.toString());
            }
        }
    }

    private class ContactAddressHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }

    private class AddressTypeHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object object = stack.peek();
            if (object instanceof ContactInformation) {
                ContactInformation contactInformation = (ContactInformation) object;
                checkObject(contactInformation);
                contactInformation.setAddressType(sb.toString());
            }
        }
    }

    private class AddressHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object object = stack.peek();
            if (object instanceof ContactInformation) {
                ContactInformation contactInformation = (ContactInformation) object;
                checkObject(contactInformation);
                contactInformation.setAddress(sb.toString());
            }
        }
    }

    private class CityHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object object = stack.peek();
            if (object instanceof ContactInformation) {
                ContactInformation contactInformation = (ContactInformation) object;
                checkObject(contactInformation);
                contactInformation.setCity(sb.toString());
            }
        }
    }

    private class StateOrProvinceHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object object = stack.peek();
            if (object instanceof ContactInformation) {
                ContactInformation contactInformation = (ContactInformation) object;
                checkObject(contactInformation);
                contactInformation.setStateOrProvince(sb.toString());
            }
        }
    }

    private class PostCodeHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object object = stack.peek();
            if (object instanceof ContactInformation) {
                ContactInformation contactInformation = (ContactInformation) object;
                checkObject(contactInformation);
                contactInformation.setPostcode(sb.toString());
            }
        }
    }

    private class CountryHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object object = stack.peek();
            if (object instanceof ContactInformation) {
                ContactInformation contactInformation = (ContactInformation) object;
                checkObject(contactInformation);
                contactInformation.setCountry(sb.toString());
            }
        }
    }

    private class ContactVoiceTelephoneHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object object = stack.peek();
            if (object instanceof ContactInformation) {
                ContactInformation contactInformation = (ContactInformation) object;
                checkObject(contactInformation);
                contactInformation.setVoiceTelephone(sb.toString());
            }
        }
    }

    private class ContactFacsimileTelephoneHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object object = stack.peek();
            if (object instanceof ContactInformation) {
                ContactInformation contactInformation = (ContactInformation) object;
                checkObject(contactInformation);
                contactInformation.setFascimileTelephone(sb.toString());
            }
        }
    }

    private class ContactElectronicMailAddressHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Object object = stack.peek();
            if (object instanceof ContactInformation) {
                ContactInformation contactInformation = (ContactInformation) object;
                checkObject(contactInformation);
                contactInformation.setEmailAddress(sb.toString());
            }
        }
    }
    //These two Handlers are not being used, since it's not clear yet how to make advantage of them

    private class VendorSpecificCapabilitiesHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes attributes) {
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }

    private class RoleHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            Roles roles = new Roles();
            roles.setRole(atts.getValue("id"));
            stack.push(roles);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            Roles roles = (Roles) stack.pop();
            ServiceProvider serviceProvider = (ServiceProvider) stack.peek();
            checkObject(serviceProvider);
            serviceProvider.addRole(roles);
        }
    }

    private class OrganizationCodeHandler extends ElementHandler {

        StringBuffer sb;

        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            ServiceProvider serviceProvider = (ServiceProvider) stack.peek();
            checkObject(serviceProvider);
            serviceProvider.setOrganizationCode(sb.toString());
        }
    }

    private class ExpireDateHandler extends ElementHandler {

        StringBuffer sb;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        @Override
        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            ServiceProvider serviceProvider = (ServiceProvider) stack.peek();
            checkObject(serviceProvider);

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date today = null;

            try {
                today = df.parse(sb.toString());
            } catch (ParseException e) {
                log.error("Error pasring string to Date." + e);
            }

            serviceProvider.setExpireDate(today);
        }
    }

    private class UserNameHandler extends ElementHandler {

        StringBuffer sb;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        @Override
        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            ServiceProvider serviceProvider = (ServiceProvider) stack.peek();
            checkObject(serviceProvider);
            serviceProvider.setUserName(sb.toString());
        }
    }

    private class PersonalCodeHandler extends ElementHandler {

        StringBuffer sb;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes atts) {
            sb = new StringBuffer();
        }

        @Override
        public void characters(char[] chars, int start, int len) {
            sb.append(chars, start, len);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            ServiceProvider serviceProvider = (ServiceProvider) stack.peek();
            checkObject(serviceProvider);
            serviceProvider.setPersonalCode(sb.toString());
        }
    }

    private class UserDefinedSymbolizationHandler extends ElementHandler {

        public void startElement(String uri, String localName, String qName, Attributes attributes) {
        }

        public void endElement(String uri, String localName, String qName) {
        }
    }
    //end not being used
    // </editor-fold>
}
