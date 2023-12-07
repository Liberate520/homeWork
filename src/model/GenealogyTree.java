package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator; 
import java.util.List;
import java.util.Map;

public class GenealogyTree <T extends Person> implements Iterable<T> {
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
            if (child.getGender().equals("male")) {
                child.setFather(parent);
            } else {
                child.setMother(parent);
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return people.values().iterator();
    }

    public List<T> sortByName() {
        List<T> sortedList = new ArrayList<>(people.values());
        sortedList.sort(Comparator.comparing(Person::getFirstName));
        return sortedList;
    }

    public List<T> sortByDateOfBirth() {
        List<T> sortedList = new ArrayList<>(people.values());
        sortedList.sort(Comparator.comparing(Person::getDateOfBirth));
        return sortedList;
    }
}