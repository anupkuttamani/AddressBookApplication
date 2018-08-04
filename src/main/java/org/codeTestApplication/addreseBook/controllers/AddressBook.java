package org.codeTestApplication.addreseBook.controllers;

import org.codeTestApplication.addreseBook.beans.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by default on 04-Aug-18.
 */
public class AddressBook implements AddressBookOperationsCommon {

    private String addressBookName;
    private List<Person> contacts;


    public AddressBook(String addressBookName) {
        this.addressBookName = addressBookName;
        this.contacts = new ArrayList<Person>();
    }

    /**
     * get all the contacts in the address book
     */
    public List<Person> getAllContacts() {

        return contacts;
    }

    /**
     * add new contacts to address book
     *
     * @param person
     */
    public void addContacts(Person person) {

        contacts.add(person);
    }

    /**
     * remove existing contacts from address book
     *
     * @param person
     */
    public void removeContacts(Person person) {

        if (!contacts.isEmpty()) {
            contacts.remove(person);
        }
    }
}
