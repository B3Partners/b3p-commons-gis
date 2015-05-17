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
 * Class OperationType.
 * 
 * @version $Revision$ $Date$
 */
public class OperationType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The Insert type
     */
    public static final int INSERT_TYPE = 0;

    /**
     * The instance of the Insert type
     */
    public static final OperationType INSERT = new OperationType(INSERT_TYPE, "Insert");

    /**
     * The Update type
     */
    public static final int UPDATE_TYPE = 1;

    /**
     * The instance of the Update type
     */
    public static final OperationType UPDATE = new OperationType(UPDATE_TYPE, "Update");

    /**
     * The Delete type
     */
    public static final int DELETE_TYPE = 2;

    /**
     * The instance of the Delete type
     */
    public static final OperationType DELETE = new OperationType(DELETE_TYPE, "Delete");

    /**
     * The Query type
     */
    public static final int QUERY_TYPE = 3;

    /**
     * The instance of the Query type
     */
    public static final OperationType QUERY = new OperationType(QUERY_TYPE, "Query");

    /**
     * The Lock type
     */
    public static final int LOCK_TYPE = 4;

    /**
     * The instance of the Lock type
     */
    public static final OperationType LOCK = new OperationType(LOCK_TYPE, "Lock");

    /**
     * The GetGmlObject type
     */
    public static final int GETGMLOBJECT_TYPE = 5;

    /**
     * The instance of the GetGmlObject type
     */
    public static final OperationType GETGMLOBJECT = new OperationType(GETGMLOBJECT_TYPE, "GetGmlObject");

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

    private OperationType(int type, java.lang.String value) 
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- nl.b3p.xml.wfs.v110.types.OperationType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * OperationType
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
     * Returns the type of this OperationType
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
        members.put("Insert", INSERT);
        members.put("Update", UPDATE);
        members.put("Delete", DELETE);
        members.put("Query", QUERY);
        members.put("Lock", LOCK);
        members.put("GetGmlObject", GETGMLOBJECT);
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
     * Returns the String representation of this OperationType
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
     * Returns a new OperationType based on the given String value.
     * 
     * @param string
     * @return OperationType
     */
    public static nl.b3p.xml.wfs.v110.types.OperationType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid OperationType";
            throw new IllegalArgumentException(err);
        }
        return (OperationType) obj;
    } //-- nl.b3p.xml.wfs.v110.types.OperationType valueOf(java.lang.String) 

}
