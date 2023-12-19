package model;

import java.io.*;
import java.util.*;

public class GenealogyTree<T extends FamilyMember> implements Iterable<T>, GenealogyTreeService<T> {
    private Map<String, T> people;

    public GenealogyTree() {
        this.people = new HashMap<>();
    }

    public void addPerson(String key, T person) {
        people.put(key, person);
    }

    public T getPerson(String key) {
        return people.get(key);
    }

    public void addChild(String parentKey, String childKey) {
        T parent = people.get(parentKey);
        T child = people.get(childKey);
        if (parent != null && child != null) {
            parent.addChild(child);
            if (child instanceof Person) {
                // Check if the object is an instance of Person
                if (((Person) child).getGender().equals("male")) {
                    ((Person) child).setFather((Person) parent);
                } else {
                    ((Person) child).setMother((Person) parent);
                }
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return people.values().iterator();
    }

    @Override
    public List<T> sortByName() {
        List<T> sortedList = new ArrayList<>(people.values());
        sortedList.sort(Comparator.comparing(FamilyMember::getFirstName));
        return sortedList;
    }

    @Override
    public List<T> sortByDateOfBirth() {
        List<T> sortedList = new ArrayList<>(people.values());
        sortedList.sort(Comparator.comparing(FamilyMember::getDateOfBirth));
        return sortedList;
    }

    @Override
    public GenealogyTree<T> getGenealogyTree() {
        return this;
    }

    @Override
    public void saveGenealogyTree(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        }
    }

    @Override
    public void loadGenealogyTree(String filename) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            GenealogyTree<T> loadedTree = (GenealogyTree<T>) ois.readObject();
            this.people = loadedTree.people;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}