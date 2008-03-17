/*
 * @(#)KBConfiguration.java
 * @author C. van Lith
 * @version 1.00, 26 december 2006
 *
 * @copyright 2007 B3Partners. All rights reserved.
 * B3Partners PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package nl.b3p.ogc.utils;

import java.awt.Color;
import java.awt.Font;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class KBConfiguration {
    
    public static boolean METADATA_ENABLED = true;
    
    public static String SERVICE_NAME = "OGC:WMS";
    public static String SERVICE_TITLE = "Kaartenbalie Map Portal";
    public static String SERVICE_ABSTRACT = "Controlled access to OGC WMS maps. See B3P GIS at http://www.b3partners.nl/";
    public static String SERVICE_FEES = "None";
    public static String SERVICE_CONSTRAINTS = "None";
    
    public static String CONTACT_PERSON = "Chris van Lith";
    public static String CONTACT_POSITION = "Partner";
    public static String CONTACT_ORGANIZATION = "B3Partners";
    public static String CONTACT_ADDRESS = "Zonnebaan 12C";
    public static String CONTACT_ADDRESS_TYPE = "Postal";
    public static String CONTACT_POSTCODE = "3542 EC";
    public static String CONTACT_CITY = "Utrecht";
    public static String CONTACT_STATE_OR_PROVINCE = "Utrecht";
    public static String CONTACT_COUNTRY = "The Netherlands";
    public static String CONTACT_VOICETELEPHONE = "+31 30 214 20 81";
    public static String CONTACT_FASCIMILEPHONE = "";
    public static String CONTACT_EMAIL = "info@b3partners.nl";
    public static String CONTACT_WEBSITE = "http://www.b3partners.nl/";
    
    public static String SERVICEPROVIDER_NAME = "OGC:WMS";
    public static String SERVICEPROVIDER_TITLE = "Kaartenbalie WMS Portal";
    public static String SERVICEPROVIDER_ABSTRACT = "Controlled access to OGC WMS maps. See B3P GIS at http://www.b3partners.nl/";
    public static String SERVICEPROVIDER_FEES = "none";
    public static String SERVICEPROVIDER_ACCESSCONSTRAINTS = "none";
    
    
    public static String TOPLAYERNAME = "B3P Kaartenbalie";
    
    public static String KB_USER = "user" ;
    public static String KB_PERSONAL_URL = "personalURL" ;
    public static String KB_DEFAULT_ROLE = "gebruiker";
    
    public static String KB_PROXY_URL = "purl";
    public static String KB_PROXY = "proxy";
    public static String KB_ENCRYPT_KEY = "proxy007"; // minimaal 8 bytes voor encrypting
    public static String KB_PROXY_EXECPTION = "Kaartenbalie Proxy fout: parameter purl niet gevonden.";
    
    public static String GETMAP_EXCEPTION = "Kaartenbalie GetMap fout: Ongeldige kaartlaag in de LAYERS parameter, update uw service providers in Kaartenbalie.";
    public static String GETMAP_QUERYABLE_EXCEPTION = "Kaartenbalie GetMap fout: Gevraagde kaartlaag is niet queryable.";
    public static String FEATUREINFO_EXCEPTION = "Kaartenbalie GetFeatureInfo fout: Ongeldige kaartlaag in de LAYERS parameter, update uw service providers in Kaartenbalie.";
    public static String FEATUREINFO_QUERYABLE_EXCEPTION = "Kaartenbalie GetFeatureInfo fout: Gevraagde kaartlaag is niet queryable.";
    public static String LEGENDGRAPHIC_EXCEPTION = "Kaartenbalie GetLegendGraphic fout: Ongeldige kaartlaag in de LAYERS parameter, update uw service providers in Kaartenbalie.";
    public static String IMAGE_SIZE_EXCEPTION = "Kaartenbalie GetMap fout: afbeelding WIDTH and HEIGHT moet tussen 1 en 2048 pixels zijn.";
    public static String BBOX_EXCEPTION = "Kaartenbalie GetMap fout: Ongeldige BBOX waarden.";
    public static String SRS_EXCEPTION = "Kaartenbalie GetMap fout: SRS moet geldig zijn voor alle kaartlagen.";
    
    public static String UNSUPPORTED_VERSION = "Opgegeven VERSION wordt niet ondersteund door Kaartenbalie";
    public static String UNSUPPORTED_SERVICE = "Opgegeven SERVICE wordt niet ondersteund door Kaartenbalie";
    public static String UNSUPPORTED_REQUEST = "Opgegeven REQUEST is niet geldig voor het ophalen van een GetCapability";
    
    
    /*
     * For titel layer
     */
    
    public static String MESSAGE_TITLE_LAYER = "B3P Kaartenbalie";
    public static String MESSAGE_TITLE_BALANCE = "Tegoed: ";
    public static String MESSAGE_TITLE_CREDITS = "Kosten: ";
    public static String MESSAGE_TITLE_UNIT = "c";
    
    /*
     * For Accounting...
     */
    
    public static String MESSAGE_AUTHORIZATION_INTRO = "Eén of meer van de door u opgevraagde kaarten vereisen autorisatie voor het afboeken van het credittegoed. ";
    public static String MESSAGE_AUTHORIZATION_START = "Vink hiertoe de goedkeuringskaart '";
    public static String MESSAGE_AUTHORIZATION_END = "' aan.\n";
    public static String MESSAGE_NO_DISPLAY_AGAIN = "Hierna zal de kaart worden getoond en dit bericht niet meer weergegeven worden.\n";
    public static String MESSAGE_REQUIRED_CREDITS = "Het aantal benodigde credits voor deze kaart bedraagt:\n ";
    
    public static final String[] ACCOUNTING_WMS_REQUESTS = new String[] {
        OGCConstants.WMS_REQUEST_GetMap,
        OGCConstants.WMS_REQUEST_GetFeatureInfo,
        OGCConstants.WMS_REQUEST_GetLegendGraphic};
    public static final String[] ACCOUNTING_WFS_REQUESTS = new String[] {
    };
    
    /*
     * Layering...
     */
    
    public static String SERVICEPROVIDER_BASE_ABBR = "b3p";
    public static String SERVICEPROVIDER_BASE_HTTP = "http://layering.kaartenbalie.nl/";
    public static String[] SUPPORTED_PROJECTIONS = new String[] {"EPSG:28992","EPSG:4326"};
    public static String DEFAULT_PROJECTION = "EPSG:28992";
    
    
    public static final String CHARSET = "UTF-8";
    public static final String MD_ALGORITHM= "MD5";
    
    /*
     * General OHD
     */
    public static Font OHD_messageBoxFont = new Font("monospaced", Font.PLAIN,  12);
    
    /*
     * LabelBox
     */
    public static Color OHD_labelBoxColor = new Color(255,240,196,150);
    public static Color OHD_labelFontBoxColor = new Color(25,98,153);
    
    /*
     * Box
     */
    public static Color OHD_fontBoxColor = new Color(255,240,196);
    public static Color OHD_borderBoxTopLeft = new Color(88,169,228);
    public static Color OHD_borderBoxBottomRight = new Color(20,82,126);
    public static Color OHD_borderBoxBackground = new Color(25,98,153,150);
    public static int OHD_padding = 2;
    public static int OHD_lineSpacing = 6;
    
    // Properties override
    
    private static final String SUFFIX = ".properties";
    private static final String KBCONFIG = "kbconfig";
    
    
    public static void configure() {
        configure(KBCONFIG);
    }
    
    public static void configure(String kbcprop) {
        Properties prop = loadProperties(kbcprop);
        
        BBOX_EXCEPTION=prop.getProperty("BBOX_EXCEPTION",BBOX_EXCEPTION);
        CONTACT_ADDRESS=prop.getProperty("CONTACT_ADDRESS",CONTACT_ADDRESS);
        CONTACT_ADDRESS_TYPE=prop.getProperty("CONTACT_ADDRESS_TYPE",CONTACT_ADDRESS_TYPE);
        CONTACT_CITY=prop.getProperty("CONTACT_CITY",CONTACT_CITY);
        CONTACT_COUNTRY=prop.getProperty("CONTACT_COUNTRY",CONTACT_COUNTRY);
        CONTACT_EMAIL=prop.getProperty("CONTACT_EMAIL",CONTACT_EMAIL);
        CONTACT_FASCIMILEPHONE=prop.getProperty("CONTACT_FASCIMILEPHONE",CONTACT_FASCIMILEPHONE);
        CONTACT_ORGANIZATION=prop.getProperty("CONTACT_ORGANIZATION",CONTACT_ORGANIZATION);
        CONTACT_PERSON=prop.getProperty("CONTACT_PERSON",CONTACT_PERSON);
        CONTACT_POSITION=prop.getProperty("CONTACT_POSITION",CONTACT_POSITION);
        CONTACT_POSTCODE=prop.getProperty("CONTACT_POSTCODE",CONTACT_POSTCODE);
        CONTACT_STATE_OR_PROVINCE=prop.getProperty("CONTACT_STATE_OR_PROVINCE",CONTACT_STATE_OR_PROVINCE);
        CONTACT_VOICETELEPHONE=prop.getProperty("CONTACT_VOICETELEPHONE",CONTACT_VOICETELEPHONE);
        CONTACT_WEBSITE=prop.getProperty("CONTACT_WEBSITE",CONTACT_WEBSITE);
        DEFAULT_PROJECTION=prop.getProperty("DEFAULT_PROJECTION",DEFAULT_PROJECTION);
        FEATUREINFO_EXCEPTION=prop.getProperty("FEATUREINFO_EXCEPTION",FEATUREINFO_EXCEPTION);
        FEATUREINFO_QUERYABLE_EXCEPTION=prop.getProperty("FEATUREINFO_QUERYABLE_EXCEPTION",FEATUREINFO_QUERYABLE_EXCEPTION);
        GETMAP_EXCEPTION=prop.getProperty("GETMAP_EXCEPTION",GETMAP_EXCEPTION);
        GETMAP_QUERYABLE_EXCEPTION=prop.getProperty("GETMAP_QUERYABLE_EXCEPTION",GETMAP_QUERYABLE_EXCEPTION);
        IMAGE_SIZE_EXCEPTION=prop.getProperty("IMAGE_SIZE_EXCEPTION",IMAGE_SIZE_EXCEPTION);
        KB_DEFAULT_ROLE=prop.getProperty("KB_DEFAULT_ROLE",KB_DEFAULT_ROLE);
        
        //KB_PERSONAL_URL=prop.getProperty("KB_PERSONAL_URL",KB_PERSONAL_URL);
        
        KB_PROXY=prop.getProperty("KB_PROXY",KB_PROXY);
        KB_PROXY_EXECPTION=prop.getProperty("KB_PROXY_EXECPTION",KB_PROXY_EXECPTION);
        KB_ENCRYPT_KEY=prop.getProperty("KB_PROXY_KEY",KB_ENCRYPT_KEY);
        KB_PROXY_URL=prop.getProperty("KB_PROXY_URL",KB_PROXY_URL);
        
        //KB_USER=prop.getProperty("KB_USER",KB_USER);
        
        LEGENDGRAPHIC_EXCEPTION=prop.getProperty("LEGENDGRAPHIC_EXCEPTION",LEGENDGRAPHIC_EXCEPTION);
        MESSAGE_AUTHORIZATION_END=prop.getProperty("MESSAGE_AUTHORIZATION_END",MESSAGE_AUTHORIZATION_END);
        MESSAGE_AUTHORIZATION_INTRO=prop.getProperty("MESSAGE_AUTHORIZATION_INTRO",MESSAGE_AUTHORIZATION_INTRO);
        MESSAGE_AUTHORIZATION_START=prop.getProperty("MESSAGE_AUTHORIZATION_START",MESSAGE_AUTHORIZATION_START);
        MESSAGE_NO_DISPLAY_AGAIN=prop.getProperty("MESSAGE_NO_DISPLAY_AGAIN",MESSAGE_NO_DISPLAY_AGAIN);
        MESSAGE_REQUIRED_CREDITS=prop.getProperty("MESSAGE_REQUIRED_CREDITS",MESSAGE_REQUIRED_CREDITS);
        MESSAGE_TITLE_BALANCE=prop.getProperty("MESSAGE_TITLE_BALANCE",MESSAGE_TITLE_BALANCE);
        MESSAGE_TITLE_CREDITS=prop.getProperty("MESSAGE_TITLE_CREDITS",MESSAGE_TITLE_CREDITS);
        MESSAGE_TITLE_LAYER=prop.getProperty("MESSAGE_TITLE_LAYER",MESSAGE_TITLE_LAYER);
        MESSAGE_TITLE_UNIT=prop.getProperty("MESSAGE_TITLE_UNIT",MESSAGE_TITLE_UNIT);
        
        OHD_borderBoxBackground = getColorFromProperties(prop, "OHD_borderBoxBackground", OHD_borderBoxBackground); 
        OHD_borderBoxBottomRight = getColorFromProperties(prop, "OHD_borderBoxBottomRight", OHD_borderBoxBottomRight); 
        OHD_borderBoxTopLeft = getColorFromProperties(prop, "OHD_borderBoxTopLeft", OHD_borderBoxTopLeft); 
        OHD_fontBoxColor = getColorFromProperties(prop, "OHD_fontBoxColor", OHD_fontBoxColor); 
        OHD_labelBoxColor = getColorFromProperties(prop, "OHD_labelBoxColor", OHD_labelBoxColor);
        OHD_labelFontBoxColor = getColorFromProperties(prop, "OHD_labelFontBoxColor", OHD_labelFontBoxColor); 
        
        String tOHD_lineSpacing=prop.getProperty("OHD_lineSpacing");
        try {
            int i = Integer.parseInt(tOHD_lineSpacing);
            OHD_lineSpacing = i;
        } catch (NumberFormatException nfe) {}
        String tOHD_padding=prop.getProperty("OHD_padding");
        try {
            int i = Integer.parseInt(tOHD_padding);
            OHD_padding = i;
        } catch (NumberFormatException nfe) {}
        
        SERVICEPROVIDER_ABSTRACT=prop.getProperty("SERVICEPROVIDER_ABSTRACT",SERVICEPROVIDER_ABSTRACT);
        SERVICEPROVIDER_ACCESSCONSTRAINTS=prop.getProperty("SERVICEPROVIDER_ACCESSCONSTRAINTS",SERVICEPROVIDER_ACCESSCONSTRAINTS);
        SERVICEPROVIDER_BASE_ABBR=prop.getProperty("SERVICEPROVIDER_BASE_ABBR",SERVICEPROVIDER_BASE_ABBR);
        SERVICEPROVIDER_BASE_HTTP=prop.getProperty("SERVICEPROVIDER_BASE_HTTP",SERVICEPROVIDER_BASE_HTTP);
        SERVICEPROVIDER_FEES=prop.getProperty("SERVICEPROVIDER_FEES",SERVICEPROVIDER_FEES);
        SERVICEPROVIDER_NAME=prop.getProperty("SERVICEPROVIDER_NAME",SERVICEPROVIDER_NAME);
        SERVICEPROVIDER_TITLE=prop.getProperty("SERVICEPROVIDER_TITLE",SERVICEPROVIDER_TITLE);
        SERVICE_ABSTRACT=prop.getProperty("SERVICE_ABSTRACT",SERVICE_ABSTRACT);
        SERVICE_CONSTRAINTS=prop.getProperty("SERVICE_CONSTRAINTS",SERVICE_CONSTRAINTS);
        SERVICE_FEES=prop.getProperty("SERVICE_FEES",SERVICE_FEES);
        SERVICE_NAME=prop.getProperty("SERVICE_NAME",SERVICE_NAME);
        SERVICE_TITLE=prop.getProperty("SERVICE_TITLE",SERVICE_TITLE);
        SRS_EXCEPTION=prop.getProperty("SRS_EXCEPTION",SRS_EXCEPTION);
        
        String tSUPPORTED_PROJECTIONS=prop.getProperty("SUPPORTED_PROJECTIONS");
        if (tSUPPORTED_PROJECTIONS!=null && tSUPPORTED_PROJECTIONS.length()!=0) {
            SUPPORTED_PROJECTIONS = tSUPPORTED_PROJECTIONS.split(",");
        }
        
        TOPLAYERNAME=prop.getProperty("TOPLAYERNAME",TOPLAYERNAME);
        UNSUPPORTED_REQUEST=prop.getProperty("UNSUPPORTED_REQUEST",UNSUPPORTED_REQUEST);
        UNSUPPORTED_SERVICE=prop.getProperty("UNSUPPORTED_SERVICE",UNSUPPORTED_SERVICE);
        UNSUPPORTED_VERSION=prop.getProperty("UNSUPPORTED_VERSION",UNSUPPORTED_VERSION);
        
    }
    
    protected static Color getColorFromProperties(Properties prop, String name, Color defval) {
        String value = prop.getProperty(name);
        if (value==null)
            return defval;
        
        String[] aValue = value.split(",");
        if (aValue.length==3 || aValue.length==4) {
            try {
                int r = Integer.parseInt(aValue[0]);
                int g = Integer.parseInt(aValue[1]);
                int b = Integer.parseInt(aValue[2]);
                int a = -1;
                if (aValue.length==4)
                    a = Integer.parseInt(aValue[3]);
                if (a==-1)
                    return new Color(r,g,b);
                else
                    return new Color(r,g,b,a);
            } catch (NumberFormatException nfe) {}
        }
        return defval;
    }
    
    public static Properties loadProperties(final String name) {
        return loadProperties(name,
                Thread.currentThread().getContextClassLoader());
    }
    
    public static Properties loadProperties(String name, ClassLoader loader) {
        if (name == null)
            throw new IllegalArgumentException("null input: name");
        
        if (name.startsWith("/"))
            name = name.substring(1);
        
        if (name.endsWith(SUFFIX))
            name = name.substring(0, name.length() - SUFFIX.length());
        
        Properties result = null;
        
        InputStream in = null;
        try {
            if (loader == null) loader = ClassLoader.getSystemClassLoader();
            
            name = name.replace('/', '.');
            
            // throws MissingResourceException on lookup failures:
            final ResourceBundle rb = ResourceBundle.getBundle(name,
                    Locale.getDefault(), loader);
            
            result = new Properties();
            for (Enumeration keys = rb.getKeys(); keys.hasMoreElements();) {
                final String key = (String) keys.nextElement();
                final String value = rb.getString(key);
                
                result.put(key, value);
            }
        } catch (Exception e) {
            result = null;
        } finally {
            if (in != null) try { in.close(); } catch (Throwable ignore) {}
        }
        
        if (result == null) {
            throw new IllegalArgumentException("could not load [" + name + "]" +
                    " as a resource bundle");
        }
        
        return result;
    }
    
    
}