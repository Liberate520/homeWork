package HW5;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map <String , String> contacts;


    public PhoneBook(){
        contacts = new HashMap<>();
    }

    void add(String num, String name){
        contacts.put(name, num);
    }

    void printBook(){
        for (String key: contacts.keySet()){
            if (contacts == null)
                System.out.println("Книга пуста.");
            else
                System.out.println(key +": "+contacts.get(key));
        }
    }




}
