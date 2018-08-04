package org.codeTestApplication.addreseBook.controllers;

import org.codeTestApplication.addreseBook.beans.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anup on 05-Aug-18.
 */
public class AddressBookOperator {

    public List<AddressBook> simpleAddressBook;


    public AddressBookOperator() {
        this.simpleAddressBook = new ArrayList<AddressBook>();
    }


    public void addAddressBook(AddressBook addressBook) {

        simpleAddressBook.add(addressBook);

    }

    public boolean removeAddressBook(AddressBook addressBook) {

        if (!simpleAddressBook.isEmpty()) {
            return false;
        }

        return simpleAddressBook.remove(addressBook);

    }

    public List<Person> getAllContact() {

        List<Person> allContacts = new ArrayList<Person>();

        simpleAddressBook.forEach(ab -> {
            allContacts.addAll(ab.getAllContacts());
        });
        return allContacts;
    }

    public List<Person> getContactByAddressBook(AddressBook addressBook) {

        List<Person> contacts = new ArrayList<Person>();

        simpleAddressBook.forEach(ab -> {
            if (addressBook.equals(ab)) {
                contacts.addAll(ab.getAllContacts());
            }
        });

        return contacts;
    }

    public void printContacts() {

        getAllContact().forEach(c -> System.out.println(c));
    }

    public void printContactsByAddressBook(AddressBook addressBook) {

        getContactByAddressBook(addressBook).forEach(c -> System.out.println(c));
    }
}
