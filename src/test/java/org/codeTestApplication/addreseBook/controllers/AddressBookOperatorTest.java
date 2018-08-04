package org.codeTestApplication.addreseBook.controllers;

import org.codeTestApplication.addreseBook.beans.Address;
import org.codeTestApplication.addreseBook.beans.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created by default on 05-Aug-18.
 */
class AddressBookOperatorTest {

    private  AddressBookOperator addressBookOperator;
    private  AddressBook addressBook;
    private Person person1;
    private Person person2;

    @BeforeEach
   public  void setUp() {
        System.out.println("Hello JUnit5!");
        addressBookOperator = new AddressBookOperator();
        addressBook =new AddressBook("Simple Address Book1");
        Address address = getAddress("SomeStreet","somestreetName","somesuburb","3001","vic");
        person1 = new Person("Smith","John","0455236528","test@test.com",address);
        addressBook.addContacts(person1);
    }

    @Test
    void addAddressBook() {
        System.out.println("Add Address");
        addressBookOperator.addAddressBook(addressBook);
        System.out.println("Add Address "+ addressBookOperator.getAllContact());
    }

    @Test
    void removeAddressBook() {
    }

    @Test
    void getAllContact() {
    }

    @Test
    void getContactByAddressBook() {
    }

    @Test
    void printContacts() {
    }

    @Test
    void printContactsByAddressBook() {
    }


    private Address getAddress(String streetNumber, String streetName, String suburb, String postcode, String state) {

        return new Address(streetNumber, streetName, suburb, postcode, state);
    }

}