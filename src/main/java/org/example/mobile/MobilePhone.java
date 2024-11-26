package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;



    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }
    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>(contacts);
    }

    public Boolean addNewContact(Contact contact){
        if (findContact(contact.getName()) == -1) { // Contact not found
            myContacts.add(contact);
            return true;
        }
        return false;
    }
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundIndex = findContact(oldContact);
        if (foundIndex >= 0) {
            myContacts.set(foundIndex, newContact);
            return true;
        }
        return false;}
    public boolean removeContact(Contact contact) {
        int foundIndex = findContact(contact);
        if (foundIndex >= 0) {
            myContacts.remove(foundIndex);
            return true;
        }
        return false; // Contact not found
    }
    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }
    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(name)) {
                return i; // Return index if found
            }
        }
        return -1; // Not found
    }
    public Contact queryContact(String name) {
        int index = findContact(name);
        if (index >= 0) {
            return myContacts.get(index); // Return the contact if found
        }
        return null; // Not found
    }
    public void printContacts() {
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}
