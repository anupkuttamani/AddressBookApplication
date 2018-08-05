package org.codeTestApplication.addreseBook.controllers;

import org.codeTestApplication.addreseBook.beans.Address;
import org.codeTestApplication.addreseBook.beans.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by default on 05-Aug-18.
 */
class AddressBookTest {

    private AddressBook addressBook1;
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private Person person5;

    @BeforeEach
    public void setUp() {
        addressBook1 = new AddressBook("Simple Address Book1");
        Address address = getAddress("11", "somestreetName", "somesuburb", "3001", "vic");
        person1 = new Person("Smith", "John", "0455236528", "test@test.com", address);
        address = getAddress("12", "somestreetName1", "samesubrub", "3001", "vic");
        person2 = new Person("Steve", "Robert", "0469582558", "test1@test.com", address);
        address = getAddress("13", "somestreetName2", "samesubrub", "3001", "vic");
        person3 = new Person("Rayan", "Mayor", "0469582558", "test2@test.com", address);
        address = getAddress("14", "somestreetName3", "samesubrub", "3001", "vic");
        person4 = new Person("David", "Roberts", "0485886658", "test3@test.com", address);
        address = getAddress("15", "somestreetName4", "someOtherSubrub1", "3002", "vic");
        person5 = new Person("John", "David", "0485876658", "test4@test.com", address);

    }

    @Test
    void getAllContacts() {

        addressBook1.addContacts(person1);
        addressBook1.addContacts(person2);
        addressBook1.addContacts(person3);
        addressBook1.addContacts(person4);
        addressBook1.addContacts(person5);
        int sizeAfter = addressBook1.getAllContacts().size();

        assertEquals( 5, sizeAfter);

    }

    @Test
    void addContacts() {

        int initialSize = addressBook1.getAllContacts().size();
        addressBook1.addContacts(person1);
        addressBook1.addContacts(person2);
        addressBook1.addContacts(person3);
        addressBook1.addContacts(person4);
        addressBook1.addContacts(person5);
        int sizeAfter = addressBook1.getAllContacts().size();

        assertEquals(sizeAfter, 5);
        assertEquals(initialSize + 5, sizeAfter);
    }

    @Test
    void removeContacts() {

        addressBook1.addContacts(person1);
        addressBook1.addContacts(person2);
        addressBook1.addContacts(person3);
        addressBook1.addContacts(person4);
        addressBook1.addContacts(person5);
        int sizeBefore = addressBook1.getAllContacts().size();
        addressBook1.removeContacts(person2);
        addressBook1.removeContacts(person3);
        addressBook1.removeContacts(person4);
        int sizeAfter = addressBook1.getAllContacts().size();
        assertEquals(sizeBefore - 3, sizeAfter);

    }


    private Address getAddress(String streetNumber, String streetName, String suburb, String postcode, String state) {

        return new Address(streetNumber, streetName, suburb, postcode, state);
    }

}