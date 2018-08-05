package org.codeTestApplication.addreseBook.controllers;

import org.codeTestApplication.addreseBook.beans.Address;
import org.codeTestApplication.addreseBook.beans.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by default on 05-Aug-18.
 */
class AddressBookOperatorTest {


    private AddressBookOperator addressBookOperator;
    private AddressBook addressBook1;
    private AddressBook addressBook2;
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private Person person5;


    @BeforeEach
    public void setUp() {

        addressBookOperator = new AddressBookOperator();
        addressBook1 = new AddressBook("Simple Address Book1");
        addressBook2 = new AddressBook("Simple Address Book2");
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
    public void addAddressBook() {

        int addressBookbefore = addressBookOperator.getSimpleAddressBooks().size();
        createAddressBooksForTest();
        int addressBookafter = addressBookOperator.getSimpleAddressBooks().size();

        assertEquals(addressBookafter, addressBookbefore + 2);
        assertEquals(addressBook1.getAllContacts().size(), 3);
        assertEquals(addressBook2.getAllContacts().size(), 2);
    }

    @Test
    public void removeAddressBook() {

        createAddressBooksForTest();
        int addressBookbefore = addressBookOperator.getSimpleAddressBooks().size();
        assertTrue(addressBookOperator.removeAddressBook(addressBook1));
        int addressBookafter = addressBookOperator.getSimpleAddressBooks().size();
        assertEquals(addressBookafter, addressBookbefore - 1);
        assertTrue(addressBookOperator.getSimpleAddressBooks().get(0).getAddressBookName().equals("Simple Address Book2"));
    }

    @Test
    public void getAllContact() {
        createAddressBooksForTest();
        List<Person> p = addressBookOperator.getAllContact();
        int absize1 = addressBook1.getAllContacts().size();
        int absize2 = addressBook2.getAllContacts().size();
        assertNotNull(p);
        assertEquals(p.size(), 5);
        assertEquals(absize1 + absize2, 5);
    }

    @Test
    public void getContactByAddressBook() {
        createAddressBooksForTest();
        List<Person> p = addressBookOperator.getContactByAddressBook(addressBook1);
        int absize1 = addressBook1.getAllContacts().size();
        assertNotNull(p);
        assertEquals(p.size(), 3);
        assertEquals(absize1, p.size());
    }

    @Test
    public void printContacts() {
        System.out.println("----------Print contact for Address Book:------------------");
        createAddressBooksForTest();
        addressBookOperator.printContacts();
    }

    @Test
    public void printContactsByAddressBook() {
        createAddressBooksForTest();
        System.out.println("----------Print contact for Address Book:" + addressBook1.getAddressBookName() + "------------------");
        addressBookOperator.printContactsByAddressBook(addressBook1);
        System.out.println("----------Print contact for Address Book:" + addressBook2.getAddressBookName() + "------------------");
        addressBookOperator.printContactsByAddressBook(addressBook2);
    }


    private void createAddressBooksForTest() {

        addressBook1.addContacts(person1);
        addressBook1.addContacts(person2);
        addressBook1.addContacts(person3);
        addressBook2.addContacts(person4);
        addressBook2.addContacts(person5);
        addressBookOperator.addAddressBook(addressBook1);
        addressBookOperator.addAddressBook(addressBook2);
    }


    private Address getAddress(String streetNumber, String streetName, String suburb, String postcode, String state) {

        return new Address(streetNumber, streetName, suburb, postcode, state);
    }

}