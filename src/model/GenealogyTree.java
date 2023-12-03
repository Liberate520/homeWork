package model;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import io.FileWritableReadable;

import java.util.Iterator;
import java.util.List;

public class GenealogyTree implements FileWritableReadable, Iterable<Person>  {
    private Map<String, Person> people;

    public GenealogyTree() {
        this.people = new HashMap<>();
    }

    public void addPerson(String key, Person person) {
        people.put(key, person);
    }

    public Person getPerson(String key) {
        return people.get(key);
    }

    public void addChild(String parentKey, String childKey) {
        Person parent = people.get(parentKey);
        Person child = people.get(childKey);
        if (parent != null && child != null) {
            parent.addChild(child);
            if (child.getGender().equals("male")) {
                child.setFather(parent);
            } else {
                child.setMother(parent);
            }
        }
    }

     public void writeToFile(String filename, GenealogyTree genealogyTree) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(genealogyTree);
        }
    }

    @Override
    public GenealogyTree readFromFile(String filename) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (GenealogyTree) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Iterator<Person> iterator() {
        return people.values().iterator();
    }

    public List<Person> sortByName() {
        List<Person> sortedList = new ArrayList<>(people.values());
        sortedList.sort(Comparator.comparing(Person::getFirstName));
        return sortedList;
    }

    public List<Person> sortByDateOfBirth() {
        List<Person> sortedList = new ArrayList<>(people.values());
        sortedList.sort(Comparator.comparing(Person::getDateOfBirth));
        return sortedList;
    }
}
