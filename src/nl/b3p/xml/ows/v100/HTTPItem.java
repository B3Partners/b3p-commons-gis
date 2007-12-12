/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ows.v100;

/**
 * Class HTTPItem.
 * 
 * @version $Revision$ $Date$
 */
public class HTTPItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Connect point URL prefix and any constraints for the HTTP
     * "Get" request method for this operation request. 
     */
    private nl.b3p.xml.ows.v100.Get _get;

    /**
     * Connect point URL and any constraints for the HTTP "Post"
     * request method for this operation request. 
     */
    private nl.b3p.xml.ows.v100.Post _post;


      //----------------/
     //- Constructors -/
    //----------------/

    public HTTPItem() 
     {
        super();
    } //-- nl.b3p.xml.ows.v100.HTTPItem()


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
     * Returns the value of field 'get'. The field 'get' has the
     * following description: Connect point URL prefix and any
     * constraints for the HTTP "Get" request method for this
     * operation request. 
     * 
     * @return Get
     * @return the value of field 'get'.
     */
    public nl.b3p.xml.ows.v100.Get getGet()
    {
        return this._get;
    } //-- nl.b3p.xml.ows.v100.Get getGet() 

    /**
     * Returns the value of field 'post'. The field 'post' has the
     * following description: Connect point URL and any constraints
     * for the HTTP "Post" request method for this operation
     * request. 
     * 
     * @return Post
     * @return the value of field 'post'.
     */
    public nl.b3p.xml.ows.v100.Post getPost()
    {
        return this._post;
    } //-- nl.b3p.xml.ows.v100.Post getPost() 

    /**
     * Sets the value of field 'get'. The field 'get' has the
     * following description: Connect point URL prefix and any
     * constraints for the HTTP "Get" request method for this
     * operation request. 
     * 
     * @param get the value of field 'get'.
     */
    public void setGet(nl.b3p.xml.ows.v100.Get get)
    {
        this._get = get;
        this._choiceValue = get;
    } //-- void setGet(nl.b3p.xml.ows.v100.Get) 

    /**
     * Sets the value of field 'post'. The field 'post' has the
     * following description: Connect point URL and any constraints
     * for the HTTP "Post" request method for this operation
     * request. 
     * 
     * @param post the value of field 'post'.
     */
    public void setPost(nl.b3p.xml.ows.v100.Post post)
    {
        this._post = post;
        this._choiceValue = post;
    } //-- void setPost(nl.b3p.xml.ows.v100.Post) 

}
