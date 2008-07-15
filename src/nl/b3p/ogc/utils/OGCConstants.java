/*
 * @(#)OGCConstants.java
 * @author N. de Goeij
 * @version 1.00, 31 oktober 2007
 *
 * @copyright 2007 B3Partners. All rights reserved.
 * B3Partners PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package nl.b3p.ogc.utils;

import java.util.Arrays;
import java.util.List;

public interface OGCConstants {
    
    // <editor-fold defaultstate="" desc="Predefined static final WMS request keys strings">
    // Required request keys for GetCapabilities:
    public static final String WMS_VERSION = "VERSION";
    public static final String WMS_REQUEST = "REQUEST";
    public static final String WMS_SERVICE = "SERVICE";
    
    public static final String VERSION = "VERSION";
    public static final String REQUEST = "REQUEST";
    public static final String SERVICE = "SERVICE";
    
    // Optional request keys for GetCapabilities:
    public static final String UPDATESEQUENCE = "UPDATESEQUENCE";
    
    // REQUEST & VERSION are already defined above
    // Required request keys for GetMap:
    public static final String WMS_PARAM_LAYERS = "LAYERS";
    public static final String WMS_PARAM_STYLES = "STYLES";
    public static final String WMS_PARAM_SRS = "SRS";
    public static final String WMS_PARAM_BBOX = "BBOX";
    public static final String WMS_PARAM_WIDTH = "WIDTH";
    public static final String WMS_PARAM_HEIGHT = "HEIGHT";
    public static final String WMS_PARAM_FORMAT = "FORMAT";
    
    // Optional request keys for GetMap:
    public static final String WMS_PARAM_TRANSPARENT = "TRANSPARENT";
    public static final String WMS_PARAM_BGCOLOR = "BGCOLOR";
    public static final String WMS_PARAM_EXCEPTIONS = "EXCEPTIONS";
    public static final String WMS_PARAM_TIME = "TIME";
    public static final String WMS_PARAM_ELEVATION = "ELEVATION";
    public static final String WMS_PARAM_SLD = "SLD";
    public static final String WMS_PARAM_WFS = "WFS";
    
    // REQUEST & VERSION are already defined above
    // Required request keys for GetFeatureInfo:
    public static final String WMS_PARAM_QUERY_LAYERS = "QUERY_LAYERS";
    public static final String WMS_PARAM_X = "X";
    public static final String WMS_PARAM_Y = "Y";
    
    // Optional request keys for GetFeatureInfo:
    public static final String WMS_PARAM_INFO_FORMAT = "INFO_FORMAT";
    public static final String WMS_PARAM_FEATURECOUNT = "FEATURECOUNT";
    public static final String WMS_PARAM_EXCEPTION_FORMAT = "EXCEPTIONS";
    
    // REQUEST, VERSION, FORMAT, SLD, WIDTH, HEIGHT & EXCEPTIONS are already defined above
    // Required request keys for GetLegendGraphic:
    public static final String WMS_PARAM_LAYER = "LAYER";
    
    // Optional request keys for GetLegendGraphic:
    public static final String WMS_PARAM_STYLE = "STYLE";
    public static final String WMS_PARAM_FEATURETYPE = "FEATURETYPE";
    public static final String WMS_PARAM_RULE = "RULE";
    public static final String WMS_PARAM_SCALE = "SCALE";
    public static final String WMS_PARAM_SLD_BODY = "SLD_BODY";
    
    // Required request keys for DescribeLayer:
    // SERVICE, REQUEST, VERSION & LAYERS are already defined above
    // DescribeLayer has no optional request keys
    // </editor-fold>
    
    // <editor-fold defaultstate="" desc="Predefined static final WMS request params strings">
    public static final String WMS_REQUEST_GetCapabilities = "GetCapabilities";
    public static final String WMS_REQUEST_GetMap = "GetMap";
    public static final String WMS_REQUEST_GetFeatureInfo = "GetFeatureInfo";
    public static final String WMS_REQUEST_GetLegendGraphic = "GetLegendGraphic";
    public static final String WMS_REQUEST_GetStyles = "GetStyles";
    public static final String WMS_REQUEST_PutStyles = "PutStyles";
    public static final String WMS_REQUEST_DescribeLayer = "DescribeLayer";

    
    public static final String WMS_SERVICE_WMS = "WMS";
    
    public static final String WMS_VERSION_110 = "1.1.0";
    public static final String WMS_VERSION_111 = "1.1.1";
    
    public static final String WMS_PARAM_TRANSPARENT_TRUE = "TRUE";
    
    //Output formats GetCapabilities:
    public static final String WMS_PARAM_WMS_XML = "application/vnd.ogc.wms_xml";
    public static final String WMS_PARAM_WMS_GML = "application/vnd.ogc.wms_gml";
    
    //Exception formats:
    public static final String WMS_PARAM_EXCEPTION_XML = "application/vnd.ogc.se_xml";
    public static final String WMS_PARAM_EXCEPTION_INIMAGE = "application/vnd.ogc.se_inimage";
    public static final String WMS_PARAM_SHORT_EXCEPTION_INIMAGE = "inimage";
    public static final String WMS_PARAM_EXCEPTION_BLANK = "application/vnd.ogc.se_blank";
    
    //Output formats GetMap:
    public static final String FORMAT_PNG   = "image/png";
    public static final String FORMAT_JPEG  = "image/jpeg";
    public static final String FORMAT_TIFF  = "image/tiff";
    public static final String FORMAT_GIF   = "image/gif";
    
    public static final String FORMAT_INIMAGE = "INIMAGE";
    // </editor-fold>
    
    // <editor-fold defaultstate="" desc="Predefined static final WFS request keys strings">
    /*TODO: dit moet nog een keer aangepast worden!!
     *Hier moeten alle WFS parameters inkomen.Niet alleen de WFS parameters die WMS niet heeft (zoals nu)
     */
    public static final String WFS_PARAM_BBOX = "BBOX";
    public static final String WFS_PARAM_OUTPUTFORMAT= "OUTPUTFORMAT";
    public static final String WFS_PARAM_INPUTFORMAT= "INPUTFORMAT";
    public static final String WFS_PARAM_TYPENAME= "TYPENAME";
    public static final String WFS_PARAM_HANDLE= "HANDLE";
    public static final String WFS_PARAM_RESULTTYPE="RESULTTYPE";
    public static final String WFS_PARAM_PROPERTYNAME="PROPERTYNAME";
    public static final String WFS_PARAM_FEATUREVERSION="FEATUREVERSION";
    public static final String WFS_PARAM_MAXFEATURES="MAXFEATURES";
    public static final String WFS_PARAM_EXPIRY="EXPIRY";
    public static final String WFS_PARAM_SRSNAME="SRSNAME";
    public static final String WFS_PARAM_FEATUREID="FEATUREID";
    public static final String WFS_PARAM_FILTER="FILTER";
    public static final String WFS_PARAM_TRAVERSEXLINKDEPTH="TRAVERSEXLINKDEPTH";
    public static final String WFS_PARAM_TRAVERSEXLINKEXPIRY="TRAVERSEXLINKEXPIRY";
    public static final String WFS_PARAM_SORTBY="SORTBY";
    public static final String WFS_PARAM_PROPTRAVXLINKEXPIRY="PROPTRAVXLINKEXPIRY";
    public static final String WFS_PARAM_PROPTRAVXLINKDEPTH="PROPTRAVXLINKDEPTH";
    public static final String WFS_PARAM_GMLOBJECTID="GMLOBJECTID";
    public static final String WFS_PARAM_LOCKID="LOCKID";
    public static final String WFS_PARAM_RELEASEACTION="RELEASEACTION";
    public static final String WFS_PARAM_OPERATION="OPERATION";
    
    public static final String WFS_TRANSACTION_DELETE="delete";
    public static final String WFS_TRANSACTION_UPDATE="update";
    public static final String WFS_TRANSACTION_INSERT="insert";
    public static final String WFS_TRANSACTION_NATIVE="native";
    
    public static final String WFS_VERSION_100="1.0.0";
    public static final String WFS_VERSION_110="1.1.0";
    public static final String WFS_VERSION_UNSPECIFIED="unspecified";
    
    public static final String WFS_REQUEST_GetFeature="GetFeature";
    public static final String WFS_REQUEST_DescribeFeatureType="DescribeFeatureType";
    public static final String WFS_REQUEST_GetCapabilities="GetCapabilities";
    public static final String WFS_REQUEST_Transaction="Transaction";
    public static final String WFS_REQUEST_GetFeatureWithLock="GetFeatureWithLock";
    public static final String WFS_REQUEST_LockFeature="LockFeature";
    
    public static final String WFS_SERVICE_WFS="WFS";
    public static final String FEATURE_INFO_FORMAT = "application/vnd.ogc.gml";
    
    public static final String WFS_OBJECT_CAPABILITIES="WFS_Capabilities";
    
    public static final String WFS_GETCAPABILITIES="wfs:GetCapabilities";
    public static final String WFS_DESCRIBEFEATURETYPE="wfs:DescribeFeatureType";
    public static final String WFS_GETFEATURE="wfs:GetFeature";
    public static final String WFS_TRANSACTION="wfs:Transaction";
    public static final String WFS_LOCKFEATURE="wfs:LockFeature";
    public static final String WFS_GETFEATUREWITHLOCK="wfs:GetFeatureWithLock";
    
    public static final String WFS_CAPABILITIES="wfs:WFS_Capabilities";
    public static final String WFS_FEATURECOLLECTION="wfs:FeatureCollection"; 
    
    public static final String WFS_OBJECT_SERVICEEXCEPTIONREPORT="ServiceExceptionReport";
    public static final String WFS_OBJECT_GEOMETRYTYPE="gml:GeometryPropertyType";
    
    public static final String WFS_SERVER_EXCEPTION="ServiceExceptionReport";
    public static final String WFS_TRANSACTIONRESPONSE="TransactionResponse";
    // </editor-fold>
    
    // <editor-fold defaultstate="" desc="List with essential parameters per wms service.">
    /**
     * List with essential parameters per wms service.
     */
    public static final List REQUIRED_PARAMS_GetCapabilities = Arrays.asList(new String[] {
        REQUEST,
        SERVICE,
        VERSION
    });
    
    public static final List WFS_REQUIRED_PARAMS_GetCapabilities = Arrays.asList(new String[] {
        REQUEST,
        SERVICE,
        VERSION
    });
    
    public static final List WFS_REQUIRED_PARAMS_GetFeature = Arrays.asList(new String[] {
        REQUEST,
        SERVICE,
        VERSION
    });
    
    public static final List WFS_REQUIRED_PARAMS_DescribeFeatureType = Arrays.asList(new String[] {
        REQUEST,
        SERVICE,
        VERSION,
        WFS_PARAM_OUTPUTFORMAT,
        WFS_PARAM_TYPENAME
    });
    
    public static final List WFS_REQUIRED_PARAMS_Transaction = Arrays.asList(new String[] {
        REQUEST,
        SERVICE,
        VERSION
    });
    
    
    public static final List NON_REQUIRED_PARAMS_GetCapabilities = Arrays.asList(new String[] {
        UPDATESEQUENCE
    });
    
    public static final List PARAMS_GetMap = Arrays.asList(new String[] {
        REQUEST,
        VERSION,
        WMS_PARAM_LAYERS,
        WMS_PARAM_STYLES,
        WMS_PARAM_SRS,
        WMS_PARAM_BBOX,
        WMS_PARAM_WIDTH,
        WMS_PARAM_HEIGHT,
        WMS_PARAM_FORMAT
    });
    
    public static final List NON_REQUIRED_PARAMS_GetMap = Arrays.asList(new String[] {
        WMS_PARAM_TRANSPARENT,
        WMS_PARAM_BGCOLOR,
        WMS_PARAM_EXCEPTIONS,
        WMS_PARAM_TIME,
        WMS_PARAM_ELEVATION,
        WMS_PARAM_SLD,
        WMS_PARAM_WFS
    });
    
    public static final List PARAMS_GetFeatureInfo = Arrays.asList(new String[] {
        REQUEST,
        VERSION,
        WMS_PARAM_QUERY_LAYERS,
        WMS_PARAM_X,
        WMS_PARAM_Y,
        WMS_PARAM_LAYERS,
        WMS_PARAM_STYLES,
        WMS_PARAM_SRS,
        WMS_PARAM_BBOX,
        WMS_PARAM_WIDTH,
        WMS_PARAM_HEIGHT,
        WMS_PARAM_FORMAT
    });
    
    public static final List NON_REQUIRED_PARAMS_GetFeatureInfo = Arrays.asList(new String[] {
        WMS_PARAM_INFO_FORMAT,
        WMS_PARAM_FEATURECOUNT,
        WMS_PARAM_EXCEPTION_FORMAT
    });
    
    public static final List PARAMS_GetLegendGraphic = Arrays.asList(new String[] {
        REQUEST,
        VERSION,
        WMS_PARAM_FORMAT,
        WMS_PARAM_LAYER
    });
    
    public static final List NON_REQUIRED_PARAMS_GetLegendGraphic = Arrays.asList(new String[] {
        WMS_PARAM_STYLE,
        WMS_PARAM_FEATURETYPE,
        WMS_PARAM_RULE,
        WMS_PARAM_SCALE,
        WMS_PARAM_SLD,
        WMS_PARAM_WIDTH,
        WMS_PARAM_HEIGHT,
        WMS_PARAM_EXCEPTIONS,
        WMS_PARAM_SLD_BODY
    });
    
    public static final List PARAMS_DescribeLayer = Arrays.asList(new String[] {
        REQUEST,
        SERVICE,
        VERSION,
        WMS_PARAM_LAYERS
    });
    // </editor-fold>
    
    // <editor-fold defaultstate="" desc="List with implemented requests.">
    /**
     * List with implemented requests.
     */
    public static final List SUPPORTED_REQUESTS = Arrays.asList(new String[] {
        WMS_REQUEST_GetCapabilities,
        WMS_REQUEST_GetMap,
        WMS_REQUEST_GetFeatureInfo,
        WMS_REQUEST_GetLegendGraphic,
        WFS_REQUEST_GetFeature,
        WFS_REQUEST_DescribeFeatureType,
        WFS_REQUEST_GetCapabilities,
        WFS_REQUEST_Transaction
    });
    // </editor-fold>
    
    public static final List SUPPORT_WFS_REQUESTS = Arrays.asList(new String[] {
        WFS_REQUEST_DescribeFeatureType,
        WFS_REQUEST_GetCapabilities,
        WFS_REQUEST_GetFeature,
        //WFS_REQUEST_GetFeatureWithLock,
        //WFS_REQUEST_LockFeature,
        WFS_REQUEST_Transaction
    });
    
    // <editor-fold defaultstate="" desc="List with implemented services.">
    /**
     * List with implemented services.
     */
    public static final List SUPPORTED_SERVICES = Arrays.asList(new String[] {
        WMS_SERVICE_WMS
    });
    // </editor-fold>
    
    // <editor-fold defaultstate="" desc="List with implemented versions.">
    /**
     * List with implemented versions.
     */
    public static final List SUPPORTED_VERSIONS = Arrays.asList(new String[] {
        WMS_VERSION_111, WMS_VERSION_110
    });
    // </editor-fold>
    
    /**
     * List with implemented versions for WFS.
     */
    public static final List SUPPORTED_WFS_VERSIONS = Arrays.asList(new String[] {
        WFS_VERSION_100, WFS_VERSION_110
    });
    
    // <editor-fold defaultstate="" desc="List with implemented exceptions.">
    /**
     * List with implemented exceptions.
     */
    public static final List SUPPORTED_EXCEPTIONS = Arrays.asList(new String[] {
        WMS_PARAM_WMS_XML,
        WMS_PARAM_EXCEPTION_XML
    });
    // </editor-fold>
    
}