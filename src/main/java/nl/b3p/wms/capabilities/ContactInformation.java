/*
 * B3P Commons GIS is a library with commonly used classes for OGC
 * reading and writing. Included are wms, wfs, gml, csv and other
 * general helper classes and extensions.
 *
 * Copyright 2005 - 2008 B3Partners BV
 * 
 * This file is part of B3P Commons GIS.
 * 
 * B3P Commons GIS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * B3P Commons GIS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with B3P Commons GIS.  If not, see <http://www.gnu.org/licenses/>.
 */
package nl.b3p.wms.capabilities;

import nl.b3p.ogc.utils.KBConfiguration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class ContactInformation implements XMLElement {

    private Integer id;
    private String contactPerson;
    private String contactPosition;
    private String contactOrganization;
    private String address;
    private String addressType;
    private String postcode;
    private String city;
    private String stateOrProvince;
    private String country;
    private String voiceTelephone;
    private String fascimileTelephone;
    private String emailAddress;
    private ServiceProvider serviceProvider;

    /** default ContactInformation() constructor.
     */
    // <editor-fold defaultstate="" desc="default ContactInformation() constructor">
    public ContactInformation() {
        contactPerson = KBConfiguration.CONTACT_PERSON;
        contactPosition = KBConfiguration.CONTACT_POSITION;
        contactOrganization = KBConfiguration.CONTACT_ORGANIZATION;
        address = KBConfiguration.CONTACT_ADDRESS;
        addressType = KBConfiguration.CONTACT_ADDRESS_TYPE;
        postcode = KBConfiguration.CONTACT_POSTCODE;
        city = KBConfiguration.CONTACT_CITY;
        stateOrProvince = KBConfiguration.CONTACT_STATE_OR_PROVINCE;
        country = KBConfiguration.CONTACT_COUNTRY;
        voiceTelephone = KBConfiguration.CONTACT_VOICETELEPHONE;
        fascimileTelephone = KBConfiguration.CONTACT_FASCIMILEPHONE;
        emailAddress = KBConfiguration.CONTACT_EMAIL;
    }
    // </editor-fold>
    // <editor-fold defaultstate="" desc="getter and setter methods.">
    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPosition() {
        return contactPosition;
    }

    public void setContactPosition(String contactPosition) {
        this.contactPosition = contactPosition;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVoiceTelephone() {
        return voiceTelephone;
    }

    public void setVoiceTelephone(String voiceTelephone) {
        this.voiceTelephone = voiceTelephone;
    }

    public String getFascimileTelephone() {
        return fascimileTelephone;
    }

    public void setFascimileTelephone(String fascimileTelephone) {
        this.fascimileTelephone = fascimileTelephone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getContactOrganization() {
        return contactOrganization;
    }

    public void setContactOrganization(String contactOrganization) {
        this.contactOrganization = contactOrganization;
    }
    // </editor-fold>
    /*
    The String class does not allow you to clone String objects because Java has a policy where it shares a single
    String object among multiple references, and cloning violates that policy. The String sharing policy helps reduce
    a program's memory requirements. For example, suppose you create a String object that contains a sequence of 100
    characters. (Note: A String object treats a string as a sequence of characters.) Because each character occupies
    two bytes (remember Unicode?), 200 bytes of storage dedicate to containing the string. Now, suppose you need an
    array of 1,000 copies of the object. If each array element references a separate String object containing the same
    sequence of characters, the program will require 200,000 bytes to hold all the characters in all copies of the
    string. However, by sharing the single String object, the program only requires 200 characters for a single string,
    and each element in the array references that same String object. Because of the String sharing policy, strings are
    considered immutable.
     */
    /** Method that will create a deep copy of this object.
     *
     * @return an object of type Object
     */
    // <editor-fold defaultstate="" desc="clone() method">
    public Object clone() {
        ContactInformation cloneCI = new ContactInformation();
        if (null != this.id) {
            cloneCI.id = new Integer(this.id.intValue());
        }
        if (null != this.contactPerson) {
            cloneCI.contactPerson = new String(this.contactPerson);
        }
        if (null != this.contactPosition) {
            cloneCI.contactPosition = new String(this.contactPosition);
        }
        if (null != this.contactOrganization) {
            cloneCI.contactOrganization = new String(this.contactOrganization);
        }
        if (null != this.address) {
            cloneCI.address = new String(this.address);
        }
        if (null != this.addressType) {
            cloneCI.addressType = new String(this.addressType);
        }
        if (null != this.postcode) {
            cloneCI.postcode = new String(this.postcode);
        }
        if (null != this.city) {
            cloneCI.city = new String(this.city);
        }
        if (null != this.stateOrProvince) {
            cloneCI.stateOrProvince = new String(this.stateOrProvince);
        }
        if (null != this.country) {
            cloneCI.country = new String(this.country);
        }
        if (null != this.voiceTelephone) {
            cloneCI.voiceTelephone = new String(this.voiceTelephone);
        }
        if (null != this.fascimileTelephone) {
            cloneCI.fascimileTelephone = new String(this.fascimileTelephone);
        }
        if (null != this.emailAddress) {
            cloneCI.emailAddress = new String(this.emailAddress);
        }
        return cloneCI;
    }
    // </editor-fold>
    /** Method that will create piece of the XML tree to create a proper XML docuement.
     *
     * @param doc Document object which is being used to create new Elements
     * @param rootElement The element where this object belongs to.
     *
     * @return an object of type Element
     */
    // <editor-fold defaultstate="" desc="toElement(Document doc, Element rootElement) method">
    public Element toElement(Document doc, Element rootElement) {

        Element contactElement = doc.createElement("ContactInformation");

        //contact person primary element
        Element personPrimElement = doc.createElement("ContactPersonPrimary");

        //contact person element
        if (null != this.getContactPerson()) {
            Element personElement = doc.createElement("ContactPerson");
            Text text = doc.createTextNode(this.getContactPerson());
            personElement.appendChild(text);
            personPrimElement.appendChild(personElement);
        }
        //end contact person element

        //contact organization element
        if (null != this.getContactOrganization()) {
            Element orgElement = doc.createElement("ContactOrganization");
            Text text = doc.createTextNode(this.getContactOrganization());
            orgElement.appendChild(text);
            personPrimElement.appendChild(orgElement);
        }
        //end contact organization element

        contactElement.appendChild(personPrimElement);
        //end contact person primary element

        //contact position element
        if (null != this.getContactPosition()) {
            Element posElement = doc.createElement("ContactPosition");
            Text text = doc.createTextNode(this.getContactPosition());
            posElement.appendChild(text);
            contactElement.appendChild(posElement);
        }
        //end contact position element

        //address element
        Element addressElement = doc.createElement("ContactAddress");
        if (null != this.getAddressType()) {
            Element addressTypeElement = doc.createElement("AddressType");
            Text text = doc.createTextNode(this.getAddressType());
            addressTypeElement.appendChild(text);
            addressElement.appendChild(addressTypeElement);
        }
        if (null != this.getAddress()) {
            Element streetElement = doc.createElement("Address");
            Text text = doc.createTextNode(this.getAddress());
            streetElement.appendChild(text);
            addressElement.appendChild(streetElement);
        }
        if (null != this.getCity()) {
            Element cityElement = doc.createElement("City");
            Text text = doc.createTextNode(this.getCity());
            cityElement.appendChild(text);
            addressElement.appendChild(cityElement);
        }
        if (null != this.getStateOrProvince()) {
            Element stateElement = doc.createElement("StateOrProvince");
            Text text = doc.createTextNode(this.getStateOrProvince());
            stateElement.appendChild(text);
            addressElement.appendChild(stateElement);
        }
        if (null != this.getPostcode()) {
            Element postalElement = doc.createElement("PostCode");
            Text text = doc.createTextNode(this.getPostcode());
            postalElement.appendChild(text);
            addressElement.appendChild(postalElement);
        }
        if (null != this.getCountry()) {
            Element countryElement = doc.createElement("Country");
            Text text = doc.createTextNode(this.getCountry());
            countryElement.appendChild(text);
            addressElement.appendChild(countryElement);
        }
        contactElement.appendChild(addressElement);
        //end address element

        //voice phone element
        if (null != this.getVoiceTelephone()) {
            Element vTelElement = doc.createElement("ContactVoiceTelephone");
            Text text = doc.createTextNode(this.getVoiceTelephone());
            vTelElement.appendChild(text);
            contactElement.appendChild(vTelElement);
        }
        //end voice phone element

        //fascimile phone element
        if (null != this.getFascimileTelephone()) {
            Element fTelElement = doc.createElement("ContactFacsimileTelephone");
            Text text = doc.createTextNode(this.getFascimileTelephone());
            fTelElement.appendChild(text);
            contactElement.appendChild(fTelElement);
        }
        //end fascimile phone element

        //email element
        if (null != this.getEmailAddress()) {
            Element mailElement = doc.createElement("ContactElectronicMailAddress");
            Text text = doc.createTextNode(this.getEmailAddress());
            mailElement.appendChild(text);
            contactElement.appendChild(mailElement);
        }
        //end email element

        rootElement.appendChild(contactElement);
        return rootElement;
    }
    // </editor-fold>
    /**
     * Method which set all variables from the given contact information.
     * It's like a copy function.
     */
    public void copyElements(ContactInformation ci) {
        if (ci == null) {
            return;
        }
        this.setAddress(ci.getAddress());
        this.setAddressType(ci.getAddressType());
        this.setCity(ci.getCity());
        this.setContactOrganization(ci.getContactOrganization());
        this.setContactPerson(ci.getContactPerson());
        this.setContactPosition(ci.getContactPosition());
        this.setCountry(ci.getCountry());
        this.setEmailAddress(ci.getEmailAddress());
        this.setFascimileTelephone(ci.getFascimileTelephone());
        this.setPostcode(ci.getPostcode());
        this.setStateOrProvince(ci.getStateOrProvince());
        this.setVoiceTelephone(ci.getVoiceTelephone());
    }
}