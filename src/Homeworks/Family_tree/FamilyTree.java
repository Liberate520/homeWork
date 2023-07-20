package Homeworks.Family_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyTree {
    private List<Human> people;
    private Map<Human, List<Human>> relationships;

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
}
