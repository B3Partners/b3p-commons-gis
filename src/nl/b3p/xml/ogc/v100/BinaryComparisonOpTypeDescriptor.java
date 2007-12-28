/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.2</a>, using an XML
 * Schema.
 * $Id$
 */

package nl.b3p.xml.ogc.v100;

/**
 * Class BinaryComparisonOpTypeDescriptor.
 * 
 * @version $Revision$ $Date$
 */
public class BinaryComparisonOpTypeDescriptor extends nl.b3p.xml.ogc.v100.ComparisonOpsTypeDescriptor {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field elementDefinition
     */
    private boolean elementDefinition;

    /**
     * Field nsPrefix
     */
    private java.lang.String nsPrefix;

    /**
     * Field nsURI
     */
    private java.lang.String nsURI;

    /**
     * Field xmlName
     */
    private java.lang.String xmlName;

    /**
     * Field identity
     */
    private org.exolab.castor.xml.XMLFieldDescriptor identity;


      //----------------/
     //- Constructors -/
    //----------------/

    public BinaryComparisonOpTypeDescriptor() 
     {
        super();
        setExtendsWithoutFlatten(new nl.b3p.xml.ogc.v100.ComparisonOpsTypeDescriptor());
        nsURI = "http://www.opengis.net/ogc";
        xmlName = "BinaryComparisonOpType";
        elementDefinition = false;
        
        //-- set grouping compositor
        setCompositorAsSequence();
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.mapping.FieldHandler             handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors
        
        //-- initialize element descriptors
        
        //-- _div
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(nl.b3p.xml.ogc.v100.Div.class, "_div", "Div", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                BinaryComparisonOpType target = (BinaryComparisonOpType) object;
                return target.getDiv();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    BinaryComparisonOpType target = (BinaryComparisonOpType) object;
                    target.setDiv( (nl.b3p.xml.ogc.v100.Div) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new nl.b3p.xml.ogc.v100.Div();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.opengis.net/ogc");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _div
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _function
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(nl.b3p.xml.ogc.v100.Function.class, "_function", "Function", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                BinaryComparisonOpType target = (BinaryComparisonOpType) object;
                return target.getFunction();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    BinaryComparisonOpType target = (BinaryComparisonOpType) object;
                    target.setFunction( (nl.b3p.xml.ogc.v100.Function) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new nl.b3p.xml.ogc.v100.Function();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.opengis.net/ogc");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _function
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _literal
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(nl.b3p.xml.ogc.v100.Literal.class, "_literal", "Literal", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                BinaryComparisonOpType target = (BinaryComparisonOpType) object;
                return target.getLiteral();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    BinaryComparisonOpType target = (BinaryComparisonOpType) object;
                    target.setLiteral( (nl.b3p.xml.ogc.v100.Literal) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new nl.b3p.xml.ogc.v100.Literal();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.opengis.net/ogc");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _literal
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _mul
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(nl.b3p.xml.ogc.v100.Mul.class, "_mul", "Mul", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                BinaryComparisonOpType target = (BinaryComparisonOpType) object;
                return target.getMul();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    BinaryComparisonOpType target = (BinaryComparisonOpType) object;
                    target.setMul( (nl.b3p.xml.ogc.v100.Mul) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new nl.b3p.xml.ogc.v100.Mul();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.opengis.net/ogc");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _mul
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _propertyName
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(nl.b3p.xml.ogc.v100.PropertyName.class, "_propertyName", "PropertyName", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                BinaryComparisonOpType target = (BinaryComparisonOpType) object;
                return target.getPropertyName();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    BinaryComparisonOpType target = (BinaryComparisonOpType) object;
                    target.setPropertyName( (nl.b3p.xml.ogc.v100.PropertyName) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new nl.b3p.xml.ogc.v100.PropertyName();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.opengis.net/ogc");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _propertyName
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _sub
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(nl.b3p.xml.ogc.v100.Sub.class, "_sub", "Sub", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                BinaryComparisonOpType target = (BinaryComparisonOpType) object;
                return target.getSub();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    BinaryComparisonOpType target = (BinaryComparisonOpType) object;
                    target.setSub( (nl.b3p.xml.ogc.v100.Sub) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new nl.b3p.xml.ogc.v100.Sub();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.opengis.net/ogc");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _sub
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _add
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(nl.b3p.xml.ogc.v100.Add.class, "_add", "Add", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                BinaryComparisonOpType target = (BinaryComparisonOpType) object;
                return target.getAdd();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    BinaryComparisonOpType target = (BinaryComparisonOpType) object;
                    target.setAdd( (nl.b3p.xml.ogc.v100.Add) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new nl.b3p.xml.ogc.v100.Add();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.opengis.net/ogc");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _add
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
    } //-- nl.b3p.xml.ogc.v100.BinaryComparisonOpTypeDescriptor()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method getAccessMode
     * 
     * 
     * 
     * @return AccessMode
     */
    public org.exolab.castor.mapping.AccessMode getAccessMode()
    {
        return null;
    } //-- org.exolab.castor.mapping.AccessMode getAccessMode() 

    /**
     * Method getExtends
     * 
     * 
     * 
     * @return ClassDescriptor
     */
    public org.exolab.castor.mapping.ClassDescriptor getExtends()
    {
        return super.getExtends();
    } //-- org.exolab.castor.mapping.ClassDescriptor getExtends() 

    /**
     * Method getIdentity
     * 
     * 
     * 
     * @return FieldDescriptor
     */
    public org.exolab.castor.mapping.FieldDescriptor getIdentity()
    {
        if (identity == null)
            return super.getIdentity();
        return identity;
    } //-- org.exolab.castor.mapping.FieldDescriptor getIdentity() 

    /**
     * Method getJavaClass
     * 
     * 
     * 
     * @return Class
     */
    public java.lang.Class getJavaClass()
    {
        return nl.b3p.xml.ogc.v100.BinaryComparisonOpType.class;
    } //-- java.lang.Class getJavaClass() 

    /**
     * Method getNameSpacePrefix
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String getNameSpacePrefix()
    {
        return nsPrefix;
    } //-- java.lang.String getNameSpacePrefix() 

    /**
     * Method getNameSpaceURI
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String getNameSpaceURI()
    {
        return nsURI;
    } //-- java.lang.String getNameSpaceURI() 

    /**
     * Method getValidator
     * 
     * 
     * 
     * @return TypeValidator
     */
    public org.exolab.castor.xml.TypeValidator getValidator()
    {
        return this;
    } //-- org.exolab.castor.xml.TypeValidator getValidator() 

    /**
     * Method getXMLName
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String getXMLName()
    {
        return xmlName;
    } //-- java.lang.String getXMLName() 

    /**
     * Method isElementDefinition
     * 
     * 
     * 
     * @return boolean
     */
    public boolean isElementDefinition()
    {
        return elementDefinition;
    } //-- boolean isElementDefinition() 

}
