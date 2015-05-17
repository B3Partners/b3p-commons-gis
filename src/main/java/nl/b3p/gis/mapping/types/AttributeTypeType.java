/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.gis.mapping.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Hashtable;

/**
 * Class AttributeTypeType.
 * 
 * @version $Revision$ $Date$
 */
public class AttributeTypeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The STRING type
     */
    public static final int STRING_TYPE = 0;

    /**
     * The instance of the STRING type
     */
    public static final AttributeTypeType STRING = new AttributeTypeType(STRING_TYPE, "STRING");

    /**
     * The INTEGER type
     */
    public static final int INTEGER_TYPE = 1;

    /**
     * The instance of the INTEGER type
     */
    public static final AttributeTypeType INTEGER = new AttributeTypeType(INTEGER_TYPE, "INTEGER");

    /**
     * The DOUBLE type
     */
    public static final int DOUBLE_TYPE = 2;

    /**
     * The instance of the DOUBLE type
     */
    public static final AttributeTypeType DOUBLE = new AttributeTypeType(DOUBLE_TYPE, "DOUBLE");

    /**
     * The DATE type
     */
    public static final int DATE_TYPE = 3;

    /**
     * The instance of the DATE type
     */
    public static final AttributeTypeType DATE = new AttributeTypeType(DATE_TYPE, "DATE");

    /**
     * The GEOMETRY type
     */
    public static final int GEOMETRY_TYPE = 4;

    /**
     * The instance of the GEOMETRY type
     */
    public static final AttributeTypeType GEOMETRY = new AttributeTypeType(GEOMETRY_TYPE, "GEOMETRY");

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

    private AttributeTypeType(int type, java.lang.String value) 
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- nl.b3p.gis.mapping.types.AttributeTypeType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * AttributeTypeType
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
     * Returns the type of this AttributeTypeType
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
        members.put("STRING", STRING);
        members.put("INTEGER", INTEGER);
        members.put("DOUBLE", DOUBLE);
        members.put("DATE", DATE);
        members.put("GEOMETRY", GEOMETRY);
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
     * Returns the String representation of this AttributeTypeType
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
     * Returns a new AttributeTypeType based on the given String
     * value.
     * 
     * @param string
     * @return AttributeTypeType
     */
    public static nl.b3p.gis.mapping.types.AttributeTypeType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid AttributeTypeType";
            throw new IllegalArgumentException(err);
        }
        return (AttributeTypeType) obj;
    } //-- nl.b3p.gis.mapping.types.AttributeTypeType valueOf(java.lang.String) 

}
