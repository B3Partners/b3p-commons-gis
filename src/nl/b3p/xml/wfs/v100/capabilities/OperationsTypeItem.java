/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100.capabilities;

/**
 * Class OperationsTypeItem.
 * 
 * @version $Revision$ $Date$
 */
public class OperationsTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _insert
     */
    private nl.b3p.xml.wfs.v100.capabilities.Insert _insert;

    /**
     * Field _update
     */
    private nl.b3p.xml.wfs.v100.capabilities.Update _update;

    /**
     * Field _delete
     */
    private nl.b3p.xml.wfs.v100.capabilities.Delete _delete;

    /**
     * Field _query
     */
    private nl.b3p.xml.wfs.v100.capabilities.Query _query;

    /**
     * Field _lock
     */
    private nl.b3p.xml.wfs.v100.capabilities.Lock _lock;


      //----------------/
     //- Constructors -/
    //----------------/

    public OperationsTypeItem() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v100.capabilities.OperationsTypeItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return Object
     * @return the value of field 'choiceValue'.
     */
    public java.lang.Object getChoiceValue()
    {
        return this._choiceValue;
    } //-- java.lang.Object getChoiceValue() 

    /**
     * Returns the value of field 'delete'.
     * 
     * @return Delete
     * @return the value of field 'delete'.
     */
    public nl.b3p.xml.wfs.v100.capabilities.Delete getDelete()
    {
        return this._delete;
    } //-- nl.b3p.xml.wfs.v100.capabilities.Delete getDelete() 

    /**
     * Returns the value of field 'insert'.
     * 
     * @return Insert
     * @return the value of field 'insert'.
     */
    public nl.b3p.xml.wfs.v100.capabilities.Insert getInsert()
    {
        return this._insert;
    } //-- nl.b3p.xml.wfs.v100.capabilities.Insert getInsert() 

    /**
     * Returns the value of field 'lock'.
     * 
     * @return Lock
     * @return the value of field 'lock'.
     */
    public nl.b3p.xml.wfs.v100.capabilities.Lock getLock()
    {
        return this._lock;
    } //-- nl.b3p.xml.wfs.v100.capabilities.Lock getLock() 

    /**
     * Returns the value of field 'query'.
     * 
     * @return Query
     * @return the value of field 'query'.
     */
    public nl.b3p.xml.wfs.v100.capabilities.Query getQuery()
    {
        return this._query;
    } //-- nl.b3p.xml.wfs.v100.capabilities.Query getQuery() 

    /**
     * Returns the value of field 'update'.
     * 
     * @return Update
     * @return the value of field 'update'.
     */
    public nl.b3p.xml.wfs.v100.capabilities.Update getUpdate()
    {
        return this._update;
    } //-- nl.b3p.xml.wfs.v100.capabilities.Update getUpdate() 

    /**
     * Sets the value of field 'delete'.
     * 
     * @param delete the value of field 'delete'.
     */
    public void setDelete(nl.b3p.xml.wfs.v100.capabilities.Delete delete)
    {
        this._delete = delete;
        this._choiceValue = delete;
    } //-- void setDelete(nl.b3p.xml.wfs.v100.capabilities.Delete) 

    /**
     * Sets the value of field 'insert'.
     * 
     * @param insert the value of field 'insert'.
     */
    public void setInsert(nl.b3p.xml.wfs.v100.capabilities.Insert insert)
    {
        this._insert = insert;
        this._choiceValue = insert;
    } //-- void setInsert(nl.b3p.xml.wfs.v100.capabilities.Insert) 

    /**
     * Sets the value of field 'lock'.
     * 
     * @param lock the value of field 'lock'.
     */
    public void setLock(nl.b3p.xml.wfs.v100.capabilities.Lock lock)
    {
        this._lock = lock;
        this._choiceValue = lock;
    } //-- void setLock(nl.b3p.xml.wfs.v100.capabilities.Lock) 

    /**
     * Sets the value of field 'query'.
     * 
     * @param query the value of field 'query'.
     */
    public void setQuery(nl.b3p.xml.wfs.v100.capabilities.Query query)
    {
        this._query = query;
        this._choiceValue = query;
    } //-- void setQuery(nl.b3p.xml.wfs.v100.capabilities.Query) 

    /**
     * Sets the value of field 'update'.
     * 
     * @param update the value of field 'update'.
     */
    public void setUpdate(nl.b3p.xml.wfs.v100.capabilities.Update update)
    {
        this._update = update;
        this._choiceValue = update;
    } //-- void setUpdate(nl.b3p.xml.wfs.v100.capabilities.Update) 

}
