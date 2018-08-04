package org.codeTestApplication.addreseBook.beans;

import java.io.Serializable;

/**
 * Created by anup on 04-Aug-18.
 */
public class Person implements Serializable {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailID;
    private Address contactAddress;

    public Person(String firstName, String lastName, String phoneNumber, String emailID, Address contactAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailID = emailID;
        this.contactAddress = contactAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailID() {
        return emailID;
    }

    public Address getContactAddress() {
        return contactAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(person.phoneNumber) : person.phoneNumber != null) return false;
        if (!emailID.equals(person.emailID)) return false;
        return contactAddress != null ? contactAddress.equals(person.contactAddress) : person.contactAddress == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + emailID.hashCode();
        result = 31 * result + (contactAddress != null ? contactAddress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailID='" + emailID + '\'' +
                ", contactAddress=" + contactAddress +
                '}';
    }
}
