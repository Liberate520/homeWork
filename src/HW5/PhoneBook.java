package HW5;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map <String, List<Integer>> contacts;

    public PhoneBook(Map<String, List<Integer>> contacts) {
        this.contacts = contacts;
    }

    public PhoneBook() {

    }

    public Map<String, List<Integer>> getContacts() {
        return contacts;
    }

    public void setContacts(Map<String, List<Integer>> contacts) {
        this.contacts = contacts;
    }

    public void printContacts(){
        if (this.contacts == null)
            System.out.println("Телефонная книга пуста.");
        else {
            for (String key: contacts.keySet()){
                System.out.println(key +": "+contacts.get(key));
            }
        }
    }

}
