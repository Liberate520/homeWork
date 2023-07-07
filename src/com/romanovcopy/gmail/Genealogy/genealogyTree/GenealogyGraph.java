package com.romanovcopy.gmail.Genealogy.genealogyTree;

import com.romanovcopy.gmail.Genealogy.comparatorsAndIterators.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GenealogyGraph implements Serializable, Iterable<Person> {

    private HashMap<String, Person> people;

    public GenealogyGraph() {
        this.people = new HashMap<>();
    }

    public void addPerson(Person person) {
        people.put(person.getId(), person);
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
     * получить ключ по значению
     * @param person значение
     * @return ключ
     */
    public String getKey(Person person){
        return getKeyByValue(people,person);
    }

    /**
     * получение ключа в библиотеке по значению
     * @param map библиотека
     * @param person значение
     * @return ключ или null, если дерево не найдено
     */
    private String getKeyByValue(HashMap<String, Person>map, Person person){
        for (var entry : map.entrySet()) {
            if (person.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
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
            var person=people.get(key);
            boolean res=person.getSurname().toLowerCase().contains(myKey)||
                    person.getName().toLowerCase().contains(myKey)||
                    person.getPatronymic().toLowerCase().contains(myKey);
            if(res){
                list.add(person);
            }
        }
        return list;
    }

    /**
     * замена объектов
     * @param lastObject старый объект
     * @param newObject новый объект
     */
    public void replace(Person lastObject, Person newObject){
        var key=getKey(lastObject);
        people.put(key,newObject);
    }




    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(people);
    }
}
