package TASK2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneBook implements Iterable<Contact>{

    private List<Contact> contactList;
    

    public List<Contact> getContactList() {
        return contactList;
    }

    public PhoneBook() {
        contactList = new ArrayList<>();
    }

    public void addContact(String name, int phone){
        Contact contact = new Contact(name, phone);
        contactList.add(contact);
    }

    public void getContact(String name){
        for (Contact contact : contactList) {
            
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Result -> " + contact);
            } 
        }
    }

    public void sortByName(){
        contactList.sort(new ContactComparatorByname());
    }

    @Override
    public Iterator<Contact> iterator() {
        return new PhoneBookIterator(contactList);
    }
}
