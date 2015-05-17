/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.wfs.v100.capabilities;

/**
 * Class HTTPTypeItem.
 * 
 * @version $Revision$ $Date$
 */
public class HTTPTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _get
     */
    private nl.b3p.xml.wfs.v100.capabilities.Get _get;

    /**
     * Field _post
     */
    private nl.b3p.xml.wfs.v100.capabilities.Post _post;


      //----------------/
     //- Constructors -/
    //----------------/

    public HTTPTypeItem() 
     {
        super();
    } //-- nl.b3p.xml.wfs.v100.capabilities.HTTPTypeItem()


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
     * Returns the value of field 'get'.
     * 
     * @return Get
     * @return the value of field 'get'.
     */
    public nl.b3p.xml.wfs.v100.capabilities.Get getGet()
    {
        return this._get;
    } //-- nl.b3p.xml.wfs.v100.capabilities.Get getGet() 

    /**
     * Returns the value of field 'post'.
     * 
     * @return Post
     * @return the value of field 'post'.
     */
    public nl.b3p.xml.wfs.v100.capabilities.Post getPost()
    {
        return this._post;
    } //-- nl.b3p.xml.wfs.v100.capabilities.Post getPost() 

    /**
     * Sets the value of field 'get'.
     * 
     * @param get the value of field 'get'.
     */
    public void setGet(nl.b3p.xml.wfs.v100.capabilities.Get get)
    {
        this._get = get;
        this._choiceValue = get;
    } //-- void setGet(nl.b3p.xml.wfs.v100.capabilities.Get) 

    /**
     * Sets the value of field 'post'.
     * 
     * @param post the value of field 'post'.
     */
    public void setPost(nl.b3p.xml.wfs.v100.capabilities.Post post)
    {
        this._post = post;
        this._choiceValue = post;
    } //-- void setPost(nl.b3p.xml.wfs.v100.capabilities.Post) 

}
