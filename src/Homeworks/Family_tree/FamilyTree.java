package Homeworks.Family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyTree implements Serializable {
    private List<Human> people;
    private Map<Human, List<Human>> relationships;

    @Override
    public String toString() {
        return "FamilyTree [\npeople=" + people + ", \nrelationships=" + relationships + "\n]";
    }

    public FamilyTree() { // правая часть конструктора в Main
        this.people = new ArrayList<>();
        this.relationships = new HashMap<>();
    }

    public void addPerson(Human person) {
        people.add(person);
    }

    public void addParentChildRelationships(Human parent, Human child) {
        if (!relationships.containsKey(parent)) {
            relationships.put(parent, new ArrayList<>());
        }
        relationships.get(parent).add(child);
    }

    public List<Human> getChildren(Human person) {
        return relationships.getOrDefault(person, new ArrayList<>());
    }

    public List<Human> getPeople() {
        return people;
    }

    public void setPeople(List<Human> people) {
        this.people = people;
    }

    public Map<Human, List<Human>> getRelationships() {
        return relationships;
    }

    public void setRelationships(Map<Human, List<Human>> relationships) {
        this.relationships = relationships;
    }
}
