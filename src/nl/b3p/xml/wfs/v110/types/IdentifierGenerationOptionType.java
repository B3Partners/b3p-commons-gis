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
 * Class IdentifierGenerationOptionType.
 * 
 * @version $Revision$ $Date$
 */
public class IdentifierGenerationOptionType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The UseExisting type
     */
    public static final int USEEXISTING_TYPE = 0;

    /**
     * The instance of the UseExisting type
     */
    public static final IdentifierGenerationOptionType USEEXISTING = new IdentifierGenerationOptionType(USEEXISTING_TYPE, "UseExisting");

    /**
     * The ReplaceDuplicate type
     */
    public static final int REPLACEDUPLICATE_TYPE = 1;

    /**
     * The instance of the ReplaceDuplicate type
     */
    public static final IdentifierGenerationOptionType REPLACEDUPLICATE = new IdentifierGenerationOptionType(REPLACEDUPLICATE_TYPE, "ReplaceDuplicate");

    /**
     * The GenerateNew type
     */
    public static final int GENERATENEW_TYPE = 2;

    /**
     * The instance of the GenerateNew type
     */
    public static final IdentifierGenerationOptionType GENERATENEW = new IdentifierGenerationOptionType(GENERATENEW_TYPE, "GenerateNew");

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

    private IdentifierGenerationOptionType(int type, java.lang.String value) 
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- nl.b3p.xml.wfs.v110.types.IdentifierGenerationOptionType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * IdentifierGenerationOptionType
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
     * Returns the type of this IdentifierGenerationOptionType
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
        members.put("UseExisting", USEEXISTING);
        members.put("ReplaceDuplicate", REPLACEDUPLICATE);
        members.put("GenerateNew", GENERATENEW);
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
     * IdentifierGenerationOptionType
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
     * Returns a new IdentifierGenerationOptionType based on the
     * given String value.
     * 
     * @param string
     * @return IdentifierGenerationOptionType
     */
    public static nl.b3p.xml.wfs.v110.types.IdentifierGenerationOptionType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid IdentifierGenerationOptionType";
            throw new IllegalArgumentException(err);
        }
        return (IdentifierGenerationOptionType) obj;
    } //-- nl.b3p.xml.wfs.v110.types.IdentifierGenerationOptionType valueOf(java.lang.String) 

}
