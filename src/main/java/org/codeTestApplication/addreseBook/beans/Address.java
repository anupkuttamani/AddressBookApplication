package org.codeTestApplication.addreseBook.beans;

import java.io.Serializable;

/**
 * Created by Anup on 04-Aug-18.
 */
public class Address implements Serializable {

    private String streetNumber;
    private String streetName;
    private String suburb;
    private String postcode;
    private String state;


    public Address(String streetNumber, String streetName, String suburb, String postcode, String state) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.suburb = suburb;
        this.postcode = postcode;
        this.state = state;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (streetNumber != null ? !streetNumber.equals(address.streetNumber) : address.streetNumber != null)
            return false;
        if (!streetName.equals(address.streetName)) return false;
        if (!suburb.equals(address.suburb)) return false;
        if (!postcode.equals(address.postcode)) return false;
        return state.equals(address.state);
    }

    @Override
    public int hashCode() {
        int result = streetNumber != null ? streetNumber.hashCode() : 0;
        result = 31 * result + streetName.hashCode();
        result = 31 * result + suburb.hashCode();
        result = 31 * result + postcode.hashCode();
        result = 31 * result + state.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", suburb='" + suburb + '\'' +
                ", postcode='" + postcode + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
