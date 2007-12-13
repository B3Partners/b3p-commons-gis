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
 * Class MetadataURLTypeFormatType.
 * 
 * @version $Revision$ $Date$
 */
public class MetadataURLTypeFormatType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The text/xml type
     */
    public static final int TEXT_XML_TYPE = 0;

    /**
     * The instance of the text/xml type
     */
    public static final MetadataURLTypeFormatType TEXT_XML = new MetadataURLTypeFormatType(TEXT_XML_TYPE, "text/xml");

    /**
     * The text/html type
     */
    public static final int TEXT_HTML_TYPE = 1;

    /**
     * The instance of the text/html type
     */
    public static final MetadataURLTypeFormatType TEXT_HTML = new MetadataURLTypeFormatType(TEXT_HTML_TYPE, "text/html");

    /**
     * The text/sgml type
     */
    public static final int TEXT_SGML_TYPE = 2;

    /**
     * The instance of the text/sgml type
     */
    public static final MetadataURLTypeFormatType TEXT_SGML = new MetadataURLTypeFormatType(TEXT_SGML_TYPE, "text/sgml");

    /**
     * The text/plain type
     */
    public static final int TEXT_PLAIN_TYPE = 3;

    /**
     * The instance of the text/plain type
     */
    public static final MetadataURLTypeFormatType TEXT_PLAIN = new MetadataURLTypeFormatType(TEXT_PLAIN_TYPE, "text/plain");

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
    } //-- nl.b3p.xml.wfs.v110.types.MetadataURLTypeFormatType(int, java.lang.String)


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
        members.put("text/xml", TEXT_XML);
        members.put("text/html", TEXT_HTML);
        members.put("text/sgml", TEXT_SGML);
        members.put("text/plain", TEXT_PLAIN);
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
    public static nl.b3p.xml.wfs.v110.types.MetadataURLTypeFormatType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid MetadataURLTypeFormatType";
            throw new IllegalArgumentException(err);
        }
        return (MetadataURLTypeFormatType) obj;
    } //-- nl.b3p.xml.wfs.v110.types.MetadataURLTypeFormatType valueOf(java.lang.String) 

}
