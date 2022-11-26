package HW5;

import java.util.*;

public class PhoneBook {
    private Map <String , String> contacts;


    public PhoneBook(){
        contacts = new HashMap<>();
    }

    void add(String num, String name){
        contacts.put(num, name);
    }

    //Удаление по номеру телефона
    void remove(String num){
        contacts.remove(num);
    }

     public String findName(String number) {
         String result = "Нет контакта с таким номером.";
         String name = contacts.get(number);
         if (name != null) {
             result = name;
         }
         return result;
     }

     public List<String> findNumber(String name){
        List<String> result = new ArrayList<>();
        for (Map.Entry entry : contacts.entrySet()) {
            if (name.equalsIgnoreCase((String)entry.getValue())) {
                result.add((String) entry.getKey());
            }
        }
        if (result.size() == 0) result.add("Контакт не найден");
        return result;
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
