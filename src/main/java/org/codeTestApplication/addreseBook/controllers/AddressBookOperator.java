package org.codeTestApplication.addreseBook.controllers;

import org.codeTestApplication.addreseBook.beans.Person;

import java.util.*;

/**
 * Created by anup on 05-Aug-18.
 */
public class AddressBookOperator {

    public List<AddressBook> simpleAddressBooks;


    public AddressBookOperator() {
        this.simpleAddressBooks = new ArrayList<AddressBook>();
    }


    public void addAddressBook(AddressBook addressBook) {

        simpleAddressBooks.add(addressBook);

    }

    public boolean removeAddressBook(AddressBook addressBook) {

        if (simpleAddressBooks.isEmpty()) {
            return false;
        }

        return simpleAddressBooks.remove(addressBook);

    }

    public List<Person> getAllContact() {

        List<Person> allContacts = new ArrayList<Person>();

        simpleAddressBooks.forEach(ab -> {
            allContacts.addAll(ab.getAllContacts());
        });
        return allContacts;
    }

    public List<Person> getContactByAddressBook(AddressBook addressBook) {

        List<Person> contacts = new ArrayList<Person>();

        simpleAddressBooks.forEach(ab -> {
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


    private Set<Person> getUniqueContacts() {

        Set<Person> uniqueContacts = new TreeSet<Person>();
        Set<Person> commonContacts = new HashSet<Person>();
        Set<Person> allContacts = new HashSet<Person>();
        List<Person> contacts = null;

        for (AddressBook addrBook : simpleAddressBooks) {

            contacts = addrBook.getAllContacts();
            allContacts.addAll(uniqueContacts);
            allContacts.addAll(contacts);

            contacts.retainAll(uniqueContacts);
            commonContacts.addAll(contacts);
            allContacts.removeAll(commonContacts);

            uniqueContacts.clear();
            uniqueContacts.addAll(allContacts);

        }

        return uniqueContacts;
    }

    public void printUniqueContacts() {
        getUniqueContacts().stream().forEach(p -> System.out.println(p));
    }

    public List<AddressBook> getSimpleAddressBooks() {
        return simpleAddressBooks;
    }
}
