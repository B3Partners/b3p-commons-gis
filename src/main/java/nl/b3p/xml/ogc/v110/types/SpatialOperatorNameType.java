/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v110.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Hashtable;

/**
 * Class SpatialOperatorNameType.
 * 
 * @version $Revision$ $Date$
 */
public class SpatialOperatorNameType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The BBOX type
     */
    public static final int BBOX_TYPE = 0;

    /**
     * The instance of the BBOX type
     */
    public static final SpatialOperatorNameType BBOX = new SpatialOperatorNameType(BBOX_TYPE, "BBOX");

    /**
     * The Equals type
     */
    public static final int EQUALS_TYPE = 1;

    /**
     * The instance of the Equals type
     */
    public static final SpatialOperatorNameType EQUALS = new SpatialOperatorNameType(EQUALS_TYPE, "Equals");

    /**
     * The Disjoint type
     */
    public static final int DISJOINT_TYPE = 2;

    /**
     * The instance of the Disjoint type
     */
    public static final SpatialOperatorNameType DISJOINT = new SpatialOperatorNameType(DISJOINT_TYPE, "Disjoint");

    /**
     * The Intersects type
     */
    public static final int INTERSECTS_TYPE = 3;

    /**
     * The instance of the Intersects type
     */
    public static final SpatialOperatorNameType INTERSECTS = new SpatialOperatorNameType(INTERSECTS_TYPE, "Intersects");

    /**
     * The Touches type
     */
    public static final int TOUCHES_TYPE = 4;

    /**
     * The instance of the Touches type
     */
    public static final SpatialOperatorNameType TOUCHES = new SpatialOperatorNameType(TOUCHES_TYPE, "Touches");

    /**
     * The Crosses type
     */
    public static final int CROSSES_TYPE = 5;

    /**
     * The instance of the Crosses type
     */
    public static final SpatialOperatorNameType CROSSES = new SpatialOperatorNameType(CROSSES_TYPE, "Crosses");

    /**
     * The Within type
     */
    public static final int WITHIN_TYPE = 6;

    /**
     * The instance of the Within type
     */
    public static final SpatialOperatorNameType WITHIN = new SpatialOperatorNameType(WITHIN_TYPE, "Within");

    /**
     * The Contains type
     */
    public static final int CONTAINS_TYPE = 7;

    /**
     * The instance of the Contains type
     */
    public static final SpatialOperatorNameType CONTAINS = new SpatialOperatorNameType(CONTAINS_TYPE, "Contains");

    /**
     * The Overlaps type
     */
    public static final int OVERLAPS_TYPE = 8;

    /**
     * The instance of the Overlaps type
     */
    public static final SpatialOperatorNameType OVERLAPS = new SpatialOperatorNameType(OVERLAPS_TYPE, "Overlaps");

    /**
     * The Beyond type
     */
    public static final int BEYOND_TYPE = 9;

    /**
     * The instance of the Beyond type
     */
    public static final SpatialOperatorNameType BEYOND = new SpatialOperatorNameType(BEYOND_TYPE, "Beyond");

    /**
     * The DWithin type
     */
    public static final int DWITHIN_TYPE = 10;

    /**
     * The instance of the DWithin type
     */
    public static final SpatialOperatorNameType DWITHIN = new SpatialOperatorNameType(DWITHIN_TYPE, "DWithin");

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

    private SpatialOperatorNameType(int type, java.lang.String value) 
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- nl.b3p.xml.ogc.v110.types.SpatialOperatorNameType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * SpatialOperatorNameType
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
     * Returns the type of this SpatialOperatorNameType
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
        members.put("BBOX", BBOX);
        members.put("Equals", EQUALS);
        members.put("Disjoint", DISJOINT);
        members.put("Intersects", INTERSECTS);
        members.put("Touches", TOUCHES);
        members.put("Crosses", CROSSES);
        members.put("Within", WITHIN);
        members.put("Contains", CONTAINS);
        members.put("Overlaps", OVERLAPS);
        members.put("Beyond", BEYOND);
        members.put("DWithin", DWITHIN);
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
     * SpatialOperatorNameType
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
     * Returns a new SpatialOperatorNameType based on the given
     * String value.
     * 
     * @param string
     * @return SpatialOperatorNameType
     */
    public static nl.b3p.xml.ogc.v110.types.SpatialOperatorNameType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid SpatialOperatorNameType";
            throw new IllegalArgumentException(err);
        }
        return (SpatialOperatorNameType) obj;
    } //-- nl.b3p.xml.ogc.v110.types.SpatialOperatorNameType valueOf(java.lang.String) 

}
