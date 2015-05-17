/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100.capabilities.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Hashtable;

/**
 * Class MetadataURLTypeFormatType.
 * 
 * @version $Revision$ $Date$
 */
public class MetadataURLTypeFormatType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The XML type
     */
    public static final int XML_TYPE = 0;

    /**
     * The instance of the XML type
     */
    public static final MetadataURLTypeFormatType XML = new MetadataURLTypeFormatType(XML_TYPE, "XML");

    /**
     * The SGML type
     */
    public static final int SGML_TYPE = 1;

    /**
     * The instance of the SGML type
     */
    public static final MetadataURLTypeFormatType SGML = new MetadataURLTypeFormatType(SGML_TYPE, "SGML");

    /**
     * The TXT type
     */
    public static final int TXT_TYPE = 2;

    /**
     * The instance of the TXT type
     */
    public static final MetadataURLTypeFormatType TXT = new MetadataURLTypeFormatType(TXT_TYPE, "TXT");

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

    private MetadataURLTypeFormatType(int type, java.lang.String value) 
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- nl.b3p.xml.wfs.v100.capabilities.types.MetadataURLTypeFormatType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * MetadataURLTypeFormatType
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
     * Returns the type of this MetadataURLTypeFormatType
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
        members.put("XML", XML);
        members.put("SGML", SGML);
        members.put("TXT", TXT);
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
     * MetadataURLTypeFormatType
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
     * Returns a new MetadataURLTypeFormatType based on the given
     * String value.
     * 
     * @param string
     * @return MetadataURLTypeFormatType
     */
    public static nl.b3p.xml.wfs.v100.capabilities.types.MetadataURLTypeFormatType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid MetadataURLTypeFormatType";
            throw new IllegalArgumentException(err);
        }
        return (MetadataURLTypeFormatType) obj;
    } //-- nl.b3p.xml.wfs.v100.capabilities.types.MetadataURLTypeFormatType valueOf(java.lang.String) 

}
