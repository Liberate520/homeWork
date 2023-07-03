package com.romanovcopy.gmail.Genealogy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GenealogyGraph {

    private Map<String, Person> people;

    public GenealogyGraph() {
        this.people = new HashMap<>();
    }

    public void addPerson(Person person) {
        people.put(createId(), person);
    }

    /**
     * отношение родителя и ребенка
     * @param parent родитель
     * @param child ребенок
     */
    public void addParentChildRelationship(Person parent, Person child) {
        if (parent != null && child != null) {
            parent.addChild(child);
            child.addParent(parent);
        }
    }

    /**
     * получение родителей ребенка
     * @param child
     * @return список родителей
     */
    public List<Person> getParents(Person child) {
        if (child != null) {
            return child.getParents();
        }
        return Collections.emptyList();
    }

    /**
     * получение детей родителя
     * @param parent родитель
     * @return список детей
     */
    public List<Person> getChildren(Person parent) {
        if (parent != null) {
            return parent.getChildren();
        }
        return Collections.emptyList();
    }

    /**
     * поиск объектов по совпадению строк
     * @param searchKey строка поиска
     * @return список найденных объектов
     */
    public ArrayList<Person>search(String searchKey){
        var myKey=searchKey.toLowerCase();
        ArrayList<Person>list=new ArrayList<>();
        for (String key : people.keySet()) {
            var persone=people.get(key);
            boolean res=persone.getSurname().toLowerCase().contains(myKey)||
                    persone.getName().toLowerCase().contains(myKey)||
                    persone.getPatronymic().toLowerCase().contains(myKey);
            if(res){
                list.add(persone);
            }
        }
        return list;
    }


    /**
     * генерация ключа исходя из текущей даты
     * @return
     */
    private String createId(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        return formattedDateTime;
    }

}
