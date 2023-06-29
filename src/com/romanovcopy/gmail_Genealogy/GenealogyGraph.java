package com.romanovcopy.gmail_Genealogy;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

}
