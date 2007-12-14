/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v110.capabilities.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Hashtable;

/**
 * Class GeometryOperandType.
 * 
 * @version $Revision$ $Date$
 */
public class GeometryOperandType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The gml:Envelope type
     */
    public static final int GML_ENVELOPE_TYPE = 0;

    /**
     * The instance of the gml:Envelope type
     */
    public static final GeometryOperandType GML_ENVELOPE = new GeometryOperandType(GML_ENVELOPE_TYPE, "gml:Envelope");

    /**
     * The gml:Point type
     */
    public static final int GML_POINT_TYPE = 1;

    /**
     * The instance of the gml:Point type
     */
    public static final GeometryOperandType GML_POINT = new GeometryOperandType(GML_POINT_TYPE, "gml:Point");

    /**
     * The gml:LineString type
     */
    public static final int GML_LINESTRING_TYPE = 2;

    /**
     * The instance of the gml:LineString type
     */
    public static final GeometryOperandType GML_LINESTRING = new GeometryOperandType(GML_LINESTRING_TYPE, "gml:LineString");

    /**
     * The gml:Polygon type
     */
    public static final int GML_POLYGON_TYPE = 3;

    /**
     * The instance of the gml:Polygon type
     */
    public static final GeometryOperandType GML_POLYGON = new GeometryOperandType(GML_POLYGON_TYPE, "gml:Polygon");

    /**
     * The gml:ArcByCenterPoint type
     */
    public static final int GML_ARCBYCENTERPOINT_TYPE = 4;

    /**
     * The instance of the gml:ArcByCenterPoint type
     */
    public static final GeometryOperandType GML_ARCBYCENTERPOINT = new GeometryOperandType(GML_ARCBYCENTERPOINT_TYPE, "gml:ArcByCenterPoint");

    /**
     * The gml:CircleByCenterPoint type
     */
    public static final int GML_CIRCLEBYCENTERPOINT_TYPE = 5;

    /**
     * The instance of the gml:CircleByCenterPoint type
     */
    public static final GeometryOperandType GML_CIRCLEBYCENTERPOINT = new GeometryOperandType(GML_CIRCLEBYCENTERPOINT_TYPE, "gml:CircleByCenterPoint");

    /**
     * The gml:Arc type
     */
    public static final int GML_ARC_TYPE = 6;

    /**
     * The instance of the gml:Arc type
     */
    public static final GeometryOperandType GML_ARC = new GeometryOperandType(GML_ARC_TYPE, "gml:Arc");

    /**
     * The gml:Circle type
     */
    public static final int GML_CIRCLE_TYPE = 7;

    /**
     * The instance of the gml:Circle type
     */
    public static final GeometryOperandType GML_CIRCLE = new GeometryOperandType(GML_CIRCLE_TYPE, "gml:Circle");

    /**
     * The gml:ArcByBulge type
     */
    public static final int GML_ARCBYBULGE_TYPE = 8;

    /**
     * The instance of the gml:ArcByBulge type
     */
    public static final GeometryOperandType GML_ARCBYBULGE = new GeometryOperandType(GML_ARCBYBULGE_TYPE, "gml:ArcByBulge");

    /**
     * The gml:Bezier type
     */
    public static final int GML_BEZIER_TYPE = 9;

    /**
     * The instance of the gml:Bezier type
     */
    public static final GeometryOperandType GML_BEZIER = new GeometryOperandType(GML_BEZIER_TYPE, "gml:Bezier");

    /**
     * The gml:Clothoid type
     */
    public static final int GML_CLOTHOID_TYPE = 10;

    /**
     * The instance of the gml:Clothoid type
     */
    public static final GeometryOperandType GML_CLOTHOID = new GeometryOperandType(GML_CLOTHOID_TYPE, "gml:Clothoid");

    /**
     * The gml:CubicSpline type
     */
    public static final int GML_CUBICSPLINE_TYPE = 11;

    /**
     * The instance of the gml:CubicSpline type
     */
    public static final GeometryOperandType GML_CUBICSPLINE = new GeometryOperandType(GML_CUBICSPLINE_TYPE, "gml:CubicSpline");

    /**
     * The gml:Geodesic type
     */
    public static final int GML_GEODESIC_TYPE = 12;

    /**
     * The instance of the gml:Geodesic type
     */
    public static final GeometryOperandType GML_GEODESIC = new GeometryOperandType(GML_GEODESIC_TYPE, "gml:Geodesic");

    /**
     * The gml:OffsetCurve type
     */
    public static final int GML_OFFSETCURVE_TYPE = 13;

    /**
     * The instance of the gml:OffsetCurve type
     */
    public static final GeometryOperandType GML_OFFSETCURVE = new GeometryOperandType(GML_OFFSETCURVE_TYPE, "gml:OffsetCurve");

    /**
     * The gml:Triangle type
     */
    public static final int GML_TRIANGLE_TYPE = 14;

    /**
     * The instance of the gml:Triangle type
     */
    public static final GeometryOperandType GML_TRIANGLE = new GeometryOperandType(GML_TRIANGLE_TYPE, "gml:Triangle");

    /**
     * The gml:PolyhedralSurface type
     */
    public static final int GML_POLYHEDRALSURFACE_TYPE = 15;

    /**
     * The instance of the gml:PolyhedralSurface type
     */
    public static final GeometryOperandType GML_POLYHEDRALSURFACE = new GeometryOperandType(GML_POLYHEDRALSURFACE_TYPE, "gml:PolyhedralSurface");

    /**
     * The gml:TriangulatedSurface type
     */
    public static final int GML_TRIANGULATEDSURFACE_TYPE = 16;

    /**
     * The instance of the gml:TriangulatedSurface type
     */
    public static final GeometryOperandType GML_TRIANGULATEDSURFACE = new GeometryOperandType(GML_TRIANGULATEDSURFACE_TYPE, "gml:TriangulatedSurface");

    /**
     * The gml:Tin type
     */
    public static final int GML_TIN_TYPE = 17;

    /**
     * The instance of the gml:Tin type
     */
    public static final GeometryOperandType GML_TIN = new GeometryOperandType(GML_TIN_TYPE, "gml:Tin");

    /**
     * The gml:Solid type
     */
    public static final int GML_SOLID_TYPE = 18;

    /**
     * The instance of the gml:Solid type
     */
    public static final GeometryOperandType GML_SOLID = new GeometryOperandType(GML_SOLID_TYPE, "gml:Solid");

    /**
     * Field _memberTable
     */
    private static java.util.Hashtable _memberTable = init();

    /**
     * Field type
     */
    private int type = -1;

    /**
     * Field stringValue
     */
    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private GeometryOperandType(int type, java.lang.String value) 
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * GeometryOperandType
     * 
     * @return Enumeration
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getType
     * 
     * Returns the type of this GeometryOperandType
     * 
     * @return int
     */
    public int getType()
    {
        return this.type;
    } //-- int getType() 

    /**
     * Method init
     * 
     * 
     * 
     * @return Hashtable
     */
    private static java.util.Hashtable init()
    {
        Hashtable members = new Hashtable();
        members.put("gml:Envelope", GML_ENVELOPE);
        members.put("gml:Point", GML_POINT);
        members.put("gml:LineString", GML_LINESTRING);
        members.put("gml:Polygon", GML_POLYGON);
        members.put("gml:ArcByCenterPoint", GML_ARCBYCENTERPOINT);
        members.put("gml:CircleByCenterPoint", GML_CIRCLEBYCENTERPOINT);
        members.put("gml:Arc", GML_ARC);
        members.put("gml:Circle", GML_CIRCLE);
        members.put("gml:ArcByBulge", GML_ARCBYBULGE);
        members.put("gml:Bezier", GML_BEZIER);
        members.put("gml:Clothoid", GML_CLOTHOID);
        members.put("gml:CubicSpline", GML_CUBICSPLINE);
        members.put("gml:Geodesic", GML_GEODESIC);
        members.put("gml:OffsetCurve", GML_OFFSETCURVE);
        members.put("gml:Triangle", GML_TRIANGLE);
        members.put("gml:PolyhedralSurface", GML_POLYHEDRALSURFACE);
        members.put("gml:TriangulatedSurface", GML_TRIANGULATEDSURFACE);
        members.put("gml:Tin", GML_TIN);
        members.put("gml:Solid", GML_SOLID);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method readResolve
     * 
     *  will be called during deserialization to replace the
     * deserialized object with the correct constant instance.
     * <br/>
     * 
     * @return Object
     */
    private java.lang.Object readResolve()
    {
        return valueOf(this.stringValue);
    } //-- java.lang.Object readResolve() 

    /**
     * Method toString
     * 
     * Returns the String representation of this
     * GeometryOperandType
     * 
     * @return String
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOf
     * 
     * Returns a new GeometryOperandType based on the given String
     * value.
     * 
     * @param string
     * @return GeometryOperandType
     */
    public static nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid GeometryOperandType";
            throw new IllegalArgumentException(err);
        }
        return (GeometryOperandType) obj;
    } //-- nl.b3p.xml.ogc.v110.capabilities.types.GeometryOperandType valueOf(java.lang.String) 

}
