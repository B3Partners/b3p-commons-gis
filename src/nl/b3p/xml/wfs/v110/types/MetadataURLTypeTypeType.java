/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v110.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Hashtable;

/**
 * Class MetadataURLTypeTypeType.
 * 
 * @version $Revision$ $Date$
 */
public class MetadataURLTypeTypeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The TC211 type
     */
    public static final int TC211_TYPE = 0;

    /**
     * The instance of the TC211 type
     */
    public static final MetadataURLTypeTypeType TC211 = new MetadataURLTypeTypeType(TC211_TYPE, "TC211");

    /**
     * The FGDC type
     */
    public static final int FGDC_TYPE = 1;

    /**
     * The instance of the FGDC type
     */
    public static final MetadataURLTypeTypeType FGDC = new MetadataURLTypeTypeType(FGDC_TYPE, "FGDC");

    /**
     * The 19115 type
     */
    public static final int VALUE_19115_TYPE = 2;

    /**
     * The instance of the 19115 type
     */
    public static final MetadataURLTypeTypeType VALUE_19115 = new MetadataURLTypeTypeType(VALUE_19115_TYPE, "19115");

    /**
     * The 19139 type
     */
    public static final int VALUE_19139_TYPE = 3;

    /**
     * The instance of the 19139 type
     */
    public static final MetadataURLTypeTypeType VALUE_19139 = new MetadataURLTypeTypeType(VALUE_19139_TYPE, "19139");

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

    private MetadataURLTypeTypeType(int type, java.lang.String value) 
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- nl.b3p.xml.wfs.v110.types.MetadataURLTypeTypeType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * MetadataURLTypeTypeType
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
     * Returns the type of this MetadataURLTypeTypeType
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
        members.put("TC211", TC211);
        members.put("FGDC", FGDC);
        members.put("19115", VALUE_19115);
        members.put("19139", VALUE_19139);
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
     * MetadataURLTypeTypeType
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
     * Returns a new MetadataURLTypeTypeType based on the given
     * String value.
     * 
     * @param string
     * @return MetadataURLTypeTypeType
     */
    public static nl.b3p.xml.wfs.v110.types.MetadataURLTypeTypeType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid MetadataURLTypeTypeType";
            throw new IllegalArgumentException(err);
        }
        return (MetadataURLTypeTypeType) obj;
    } //-- nl.b3p.xml.wfs.v110.types.MetadataURLTypeTypeType valueOf(java.lang.String) 

}
