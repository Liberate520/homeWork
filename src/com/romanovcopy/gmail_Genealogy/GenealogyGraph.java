package com.romanovcopy.gmail_Genealogy;

import java.util.*;

public class GenealogyGraph {

    private Map<String, Person> people;

    public GenealogyGraph() {
        this.people = new HashMap<>();
    }

    public void addPerson(Person person) {
        people.put(person.getSurname(), person);
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
     * поиск по фамилии
     * @param surname фамилия
     * @return список найденных объектов
     */
    public ArrayList<Person>search(String surname){
        ArrayList<Person>list=new ArrayList<>();
        for (String key : people.keySet()) {
            if (people.get(key).getSurname().equals(surname) ) {
                list.add(people.get(key));
            }
        }
        return list;
    }

    /**
     * поиск по фамилии и имени
     * @param surname фамилия
     * @param name имя
     * @return список найденных объектов
     */
    public ArrayList<Person>search(String surname, String name){
        ArrayList<Person>list=new ArrayList<>();
        for (String key : people.keySet()) {
            if (people.get(key).getSurname().equals(surname) && people.get(key).getName().equals(name)) {
                list.add(people.get(key));
            }
        }
        return list;
    }

    /**
     * поиск по фамилии имени и отчеству
     * @param surname
     * @param name
     * @param patronymic
     * @return
     */
    public ArrayList<Person>search(String surname, String name, String patronymic){
        ArrayList<Person>list=new ArrayList<>();
        for (String key : people.keySet()) {
            if (people.get(key).getSurname().equals(surname) && people.get(key).getName().equals(name) && people.get(key).getPatronymic().equals(patronymic)) {
                list.add(people.get(key));
            }
        }
        return list;
    }

}
