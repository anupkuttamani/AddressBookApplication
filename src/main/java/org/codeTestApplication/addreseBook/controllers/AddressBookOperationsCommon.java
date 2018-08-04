package org.codeTestApplication.addreseBook.controllers;

import org.codeTestApplication.addreseBook.beans.Person;

import java.util.List;

/**
 * Created by default on 04-Aug-18.
 */
public interface AddressBookOperationsCommon {

    /**
     * get all the contacts in the address book
     */
    public List<Person> getAllContacts();

    /**
     * add new contacts to address book
     *
     * @param person
     */
    public void addContacts(Person person);

    /**
     * remove existing contacts from address book
     *
     * @param person
     */
    public void removeContacts(Person person);

}
