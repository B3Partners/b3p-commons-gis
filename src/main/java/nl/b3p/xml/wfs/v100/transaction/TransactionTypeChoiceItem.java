/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100.transaction;

/**
 * Class TransactionTypeChoiceItem.
 * 
 * @version $Revision$ $Date$
 */
public class TransactionTypeChoiceItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The Insert element is used to indicate that the Web Feature
     *  Service should create a new instance of a feature type. The
     *  feature instance is specified using GML2 and one or more 
     *  feature instances to be created can be contained inside the
     *  Insert element.
     *  
     */
    private nl.b3p.xml.wfs.v100.transaction.Insert _insert;

    /**
     * One or more existing feature instances can be changed by
     *  using the Update element. Changing a feature instance
     *  means that the current value of one or more properties of
     *  the feature are replaced with new values. The Update
     *  element contains one or more Property elements. A
     *  Property element contains the name or a feature property
     *  who's value is to be changed and the replacement value
     *  for that property.
     *  
     */
    private nl.b3p.xml.wfs.v100.transaction.Update _update;

    /**
     * The Delete element is used to indicate that one or more
     *  feature instances should be removed from the feature
     *  repository.
     *  
     */
    private nl.b3p.xml.wfs.v100.transaction.Delete _delete;

    /**
     * Many times, a Web Feature Service interacts with a
     * repository
     *  that may have special vendor specific capabilities. The
     * native
     *  element allows vendor specific command to be passed to the
     *  repository via the Web Feature Service.
     *  
     */
    private nl.b3p.xml.wfs.v100.transaction.Native _native;


      //----------------/
     //- Constructors -/
    //----------------/

    public TransactionTypeChoiceItem() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v100.transaction.TransactionTypeChoiceItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'delete'. The field 'delete' has
     * the following description: The Delete element is used to
     * indicate that one or more
     *  feature instances should be removed from the feature
     *  repository.
     *  
     * 
     * @return Delete
     * @return the value of field 'delete'.
     */
    public nl.b3p.xml.wfs.v100.transaction.Delete getDelete()
    {
        return this._delete;
    } //-- nl.b3p.xml.wfs.v100.transaction.Delete getDelete() 

    /**
     * Returns the value of field 'insert'. The field 'insert' has
     * the following description: The Insert element is used to
     * indicate that the Web Feature
     *  Service should create a new instance of a feature type. The
     *  feature instance is specified using GML2 and one or more 
     *  feature instances to be created can be contained inside the
     *  Insert element.
     *  
     * 
     * @return Insert
     * @return the value of field 'insert'.
     */
    public nl.b3p.xml.wfs.v100.transaction.Insert getInsert()
    {
        return this._insert;
    } //-- nl.b3p.xml.wfs.v100.transaction.Insert getInsert() 

    /**
     * Returns the value of field 'native'. The field 'native' has
     * the following description: Many times, a Web Feature Service
     * interacts with a repository
     *  that may have special vendor specific capabilities. The
     * native
     *  element allows vendor specific command to be passed to the
     *  repository via the Web Feature Service.
     *  
     * 
     * @return Native
     * @return the value of field 'native'.
     */
    public nl.b3p.xml.wfs.v100.transaction.Native getNative()
    {
        return this._native;
    } //-- nl.b3p.xml.wfs.v100.transaction.Native getNative() 

    /**
     * Returns the value of field 'update'. The field 'update' has
     * the following description: One or more existing feature
     * instances can be changed by
     *  using the Update element. Changing a feature instance
     *  means that the current value of one or more properties of
     *  the feature are replaced with new values. The Update
     *  element contains one or more Property elements. A
     *  Property element contains the name or a feature property
     *  who's value is to be changed and the replacement value
     *  for that property.
     *  
     * 
     * @return Update
     * @return the value of field 'update'.
     */
    public nl.b3p.xml.wfs.v100.transaction.Update getUpdate()
    {
        return this._update;
    } //-- nl.b3p.xml.wfs.v100.transaction.Update getUpdate() 

    /**
     * Sets the value of field 'delete'. The field 'delete' has the
     * following description: The Delete element is used to
     * indicate that one or more
     *  feature instances should be removed from the feature
     *  repository.
     *  
     * 
     * @param delete the value of field 'delete'.
     */
    public void setDelete(nl.b3p.xml.wfs.v100.transaction.Delete delete)
    {
        this._delete = delete;
    } //-- void setDelete(nl.b3p.xml.wfs.v100.transaction.Delete) 

    /**
     * Sets the value of field 'insert'. The field 'insert' has the
     * following description: The Insert element is used to
     * indicate that the Web Feature
     *  Service should create a new instance of a feature type. The
     *  feature instance is specified using GML2 and one or more 
     *  feature instances to be created can be contained inside the
     *  Insert element.
     *  
     * 
     * @param insert the value of field 'insert'.
     */
    public void setInsert(nl.b3p.xml.wfs.v100.transaction.Insert insert)
    {
        this._insert = insert;
    } //-- void setInsert(nl.b3p.xml.wfs.v100.transaction.Insert) 

    /**
     * Sets the value of field 'native'. The field 'native' has the
     * following description: Many times, a Web Feature Service
     * interacts with a repository
     *  that may have special vendor specific capabilities. The
     * native
     *  element allows vendor specific command to be passed to the
     *  repository via the Web Feature Service.
     *  
     * 
     * @param _native
     * @param native the value of field 'native'.
     */
    public void setNative(nl.b3p.xml.wfs.v100.transaction.Native _native)
    {
        this._native = _native;
    } //-- void setNative(nl.b3p.xml.wfs.v100.transaction.Native) 

    /**
     * Sets the value of field 'update'. The field 'update' has the
     * following description: One or more existing feature
     * instances can be changed by
     *  using the Update element. Changing a feature instance
     *  means that the current value of one or more properties of
     *  the feature are replaced with new values. The Update
     *  element contains one or more Property elements. A
     *  Property element contains the name or a feature property
     *  who's value is to be changed and the replacement value
     *  for that property.
     *  
     * 
     * @param update the value of field 'update'.
     */
    public void setUpdate(nl.b3p.xml.wfs.v100.transaction.Update update)
    {
        this._update = update;
    } //-- void setUpdate(nl.b3p.xml.wfs.v100.transaction.Update) 

}
