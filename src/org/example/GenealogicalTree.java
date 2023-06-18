package org.example;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class GenealogicalTree<T> implements Serializable, Iterable<Person> {
    private List<Person> people;
    private List<Relationship> relationships;
    private DataStorage<GenealogicalTree<T>> dataStorage;

    public GenealogicalTree(DataStorage<GenealogicalTree<T>> dataStorage) {
        this.people = new ArrayList<>();
        this.relationships = new ArrayList<>();
        this.dataStorage = dataStorage;
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void addRelationship(Relationship relationship) {
        relationships.add(relationship);
    }

    public void saveTree(String fileName) {
        try {
            dataStorage.saveData(this, fileName);
            System.out.println("Tree successfully saved to file.");
        } catch (Exception e) {
            System.out.println("Error saving tree to file: " + e.getMessage());
        }
    }

    public void loadTree(String fileName) {
        try {
            GenealogicalTree<T> loadedTree = dataStorage.loadData(fileName);
            if (loadedTree != null) {
                this.people = loadedTree.people;
                this.relationships = loadedTree.relationships;
                System.out.println("Tree loaded successfully from file.");
            } else {
                System.out.println("Error loading tree from file: Loaded tree is null.");
            }
        } catch (Exception e) {
            System.out.println("Error loading tree from file: " + e.getMessage());
        }
    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(people);
    }

    public List<Relationship> getRelationships() {
        return Collections.unmodifiableList(relationships);
    }

    public void sortPeople(Comparator<Person> comparator) {
        people.sort(comparator);
    }

    @Override
    public Iterator<Person> iterator() {
        return people.iterator();
    }
}
