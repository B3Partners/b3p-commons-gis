/*
 * @(#)KBConstants.java
 * @author C. van Lith
 * @version 1.00, 26 december 2006
 *
 * @copyright 2007 B3Partners. All rights reserved.
 * B3Partners PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package nl.b3p.ogc.utils;

import java.util.Arrays;
import java.util.List;
/*TODO: KB Constants moet nog een keer worden opgesplitst in KBconstants en OGCconstants.
 */
public interface KBConstants extends OGCConstants {
    
    // <editor-fold defaultstate="" desc="Predefined static final CapabilityRequest strings">
    public static final String SERVICE_NAME = "OGC:WMS";
    public static final String SERVICE_TITLE = "Kaartenbalie Map Portal";
    public static final String SERVICE_ABSTRACT = "Controlled access to OGC WMS maps. See B3P GIS at http://www.b3partners.nl/";
    public static final String SERVICE_FEES = "None";
    public static final String SERVICE_CONSTRAINTS = "None";
    
    public static final String CONTACT_PERSON = "Chris van Lith";
    public static final String CONTACT_POSITION = "Partner";
    public static final String CONTACT_ORGANIZATION = "B3Partners";
    public static final String CONTACT_ADDRESS = "Zonnebaan 12C";
    public static final String CONTACT_ADDRESS_TYPE = "Postal";
    public static final String CONTACT_POSTCODE = "3542 EC";
    public static final String CONTACT_CITY = "Utrecht";
    public static final String CONTACT_STATE_OR_PROVINCE = "Utrecht";
    public static final String CONTACT_COUNTRY = "The Netherlands";
    public static final String CONTACT_VOICETELEPHONE = "+31 30 214 20 81";
    public static final String CONTACT_FASCIMILEPHONE = "";
    public static final String CONTACT_EMAIL = "info@b3partners.nl";
    public static final String CONTACT_WEBSITE = "http://www.b3partners.nl/";
    
    public static final String SERVICEPROVIDER_NAME = "OGC:WMS";
    public static final String SERVICEPROVIDER_TITLE = "Kaartenbalie WMS Portal";
    public static final String SERVICEPROVIDER_ABSTRACT = "Controlled access to OGC WMS maps. See B3P GIS at http://www.b3partners.nl/";
    public static final String SERVICEPROVIDER_FEES = "none";
    public static final String SERVICEPROVIDER_ACCESSCONSTRAINTS = "none";
    
    public static final String TOPLAYERNAME = "B3P_Kaartenbalie";
    // </editor-fold>
    
    // <editor-fold defaultstate="" desc="Predefined static final user strings">
    public static final String KB_USER = "user" ;
    public static final String KB_PERSONAL_URL = "personalURL" ;
    public static final String KB_DEFAULT_ROLE = "gebruiker";
    // </editor-fold>
    
    // <editor-fold defaultstate="" desc="Predefined static final exception strings">
    public static final String GETMAP_EXCEPTION = "Kaartenbalie GetMap fout: Ongeldige kaartlaag in de LAYERS parameter, update uw service providers in Kaartenbalie.";
    public static final String GETMAP_QUERYABLE_EXCEPTION = "Kaartenbalie GetMap fout: Gevraagde kaartlaag is niet queryable.";
    public static final String FEATUREINFO_EXCEPTION = "Kaartenbalie GetFeatureInfo fout: Ongeldige kaartlaag in de LAYERS parameter, update uw service providers in Kaartenbalie.";
    public static final String FEATUREINFO_QUERYABLE_EXCEPTION = "Kaartenbalie GetFeatureInfo fout: Gevraagde kaartlaag is niet queryable.";
    public static final String LEGENDGRAPHIC_EXCEPTION = "Kaartenbalie GetLegendGraphic fout: Ongeldige kaartlaag in de LAYERS parameter, update uw service providers in Kaartenbalie.";
    public static final String IMAGE_SIZE_EXCEPTION = "Kaartenbalie GetMap fout: afbeelding WIDTH and HEIGHT moet tussen 1 en 2048 pixels zijn.";
    public static final String BBOX_EXCEPTION = "Kaartenbalie GetMap fout: Ongeldige BBOX waarden.";
    public static final String SRS_EXCEPTION = "Kaartenbalie GetMap fout: SRS moet geldig zijn voor alle kaartlagen.";
    
    public static final String UNSUPPORTED_VERSION = "Opgegeven VERSION wordt niet ondersteund door Kaartenbalie";
    public static final String UNSUPPORTED_SERVICE = "Opgegeven SERVICE wordt niet ondersteund door Kaartenbalie";
    public static final String UNSUPPORTED_REQUEST = "Opgegeven REQUEST is niet geldig voor het ophalen van een GetCapability";
    // </editor-fold>
    
    public static final String CHARSET = "UTF-8";
    public static final String MD_ALGORITHM= "MD5";
}