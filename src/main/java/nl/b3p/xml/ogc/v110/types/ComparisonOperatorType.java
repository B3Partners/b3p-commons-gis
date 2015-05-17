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
 * Class ComparisonOperatorType.
 * 
 * @version $Revision$ $Date$
 */
public class ComparisonOperatorType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The LessThan type
     */
    public static final int LESSTHAN_TYPE = 0;

    /**
     * The instance of the LessThan type
     */
    public static final ComparisonOperatorType LESSTHAN = new ComparisonOperatorType(LESSTHAN_TYPE, "LessThan");

    /**
     * The GreaterThan type
     */
    public static final int GREATERTHAN_TYPE = 1;

    /**
     * The instance of the GreaterThan type
     */
    public static final ComparisonOperatorType GREATERTHAN = new ComparisonOperatorType(GREATERTHAN_TYPE, "GreaterThan");

    /**
     * The LessThanEqualTo type
     */
    public static final int LESSTHANEQUALTO_TYPE = 2;

    /**
     * The instance of the LessThanEqualTo type
     */
    public static final ComparisonOperatorType LESSTHANEQUALTO = new ComparisonOperatorType(LESSTHANEQUALTO_TYPE, "LessThanEqualTo");

    /**
     * The GreaterThanEqualTo type
     */
    public static final int GREATERTHANEQUALTO_TYPE = 3;

    /**
     * The instance of the GreaterThanEqualTo type
     */
    public static final ComparisonOperatorType GREATERTHANEQUALTO = new ComparisonOperatorType(GREATERTHANEQUALTO_TYPE, "GreaterThanEqualTo");

    /**
     * The EqualTo type
     */
    public static final int EQUALTO_TYPE = 4;

    /**
     * The instance of the EqualTo type
     */
    public static final ComparisonOperatorType EQUALTO = new ComparisonOperatorType(EQUALTO_TYPE, "EqualTo");

    /**
     * The NotEqualTo type
     */
    public static final int NOTEQUALTO_TYPE = 5;

    /**
     * The instance of the NotEqualTo type
     */
    public static final ComparisonOperatorType NOTEQUALTO = new ComparisonOperatorType(NOTEQUALTO_TYPE, "NotEqualTo");

    /**
     * The Like type
     */
    public static final int LIKE_TYPE = 6;

    /**
     * The instance of the Like type
     */
    public static final ComparisonOperatorType LIKE = new ComparisonOperatorType(LIKE_TYPE, "Like");

    /**
     * The Between type
     */
    public static final int BETWEEN_TYPE = 7;

    /**
     * The instance of the Between type
     */
    public static final ComparisonOperatorType BETWEEN = new ComparisonOperatorType(BETWEEN_TYPE, "Between");

    /**
     * The NullCheck type
     */
    public static final int NULLCHECK_TYPE = 8;

    /**
     * The instance of the NullCheck type
     */
    public static final ComparisonOperatorType NULLCHECK = new ComparisonOperatorType(NULLCHECK_TYPE, "NullCheck");

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

    private ComparisonOperatorType(int type, java.lang.String value) 
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- nl.b3p.xml.ogc.v110.types.ComparisonOperatorType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * ComparisonOperatorType
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
     * Returns the type of this ComparisonOperatorType
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
        members.put("LessThan", LESSTHAN);
        members.put("GreaterThan", GREATERTHAN);
        members.put("LessThanEqualTo", LESSTHANEQUALTO);
        members.put("GreaterThanEqualTo", GREATERTHANEQUALTO);
        members.put("EqualTo", EQUALTO);
        members.put("NotEqualTo", NOTEQUALTO);
        members.put("Like", LIKE);
        members.put("Between", BETWEEN);
        members.put("NullCheck", NULLCHECK);
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
     * ComparisonOperatorType
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
     * Returns a new ComparisonOperatorType based on the given
     * String value.
     * 
     * @param string
     * @return ComparisonOperatorType
     */
    public static nl.b3p.xml.ogc.v110.types.ComparisonOperatorType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid ComparisonOperatorType";
            throw new IllegalArgumentException(err);
        }
        return (ComparisonOperatorType) obj;
    } //-- nl.b3p.xml.ogc.v110.types.ComparisonOperatorType valueOf(java.lang.String) 

}
