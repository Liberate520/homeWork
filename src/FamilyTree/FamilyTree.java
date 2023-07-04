package FamilyTree;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import FamilyTree.Comparators.PersonComparatorByAge;
import FamilyTree.Comparators.PersonComparatorBySename;
import FamilyTree.Iterators.PersonIterator;

public class FamilyTree implements Serializable, Iterable<Person> {

    private String sename;
    private List<Person> persons;

    public FamilyTree(String sename) {
        this.sename = sename;
        this.persons = new LinkedList<Person>();
    }

    public String getSename() {
        return this.sename;
    }

    public Person getPersonById(int id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public Map<Integer, List<Person>> getAllChildren(int personId) {
        return getAllChildren(getPersonById(personId));
    }

    public Map<Integer, List<Person>> getAllChildren(Person person) {
        Map<Integer, List<Person>> generationFiltered = new TreeMap<>();
        Queue<Person> queue = new LinkedList<>();
        Person earlyPerson = null;
        queue.offer(person);
        int step = 0;
        while (!queue.isEmpty()) {
            Person currentPerson = queue.poll();
            if (earlyPerson != null && isOneGeneration(earlyPerson, currentPerson)) {
                var children = generationFiltered.get(step);
                children.addAll(currentPerson.getChildren());
                generationFiltered.replace(step, children);
            } else if (currentPerson.getChildren().size() > 0) {
                generationFiltered.put(++step, currentPerson.getChildren());

            }
            queue.addAll(currentPerson.getChildren());
            earlyPerson = currentPerson;
        }
        return generationFiltered;

    }

    public Boolean addOnlyPerson(Person person) {
        return addPerson(person, false);
    }

    public Boolean addPersonAndRelatives(Person person) {
        return addPerson(person, true);
    }

    public Boolean addOnlyPersons(List<Person> persons) {
        return addPersons(persons, false);
    }

    public Boolean addPersonsAndRelatives(List<Person> persons) {
        return addPersons(persons, true);
    }

    public void sortByName() {
        Collections.sort(this.persons);
    }

    public void sortByAge() {
        Collections.sort(this.persons, new PersonComparatorByAge());
    }

    public void sortBySename() {
        Collections.sort(this.persons, new PersonComparatorBySename());
    }

    public static Boolean isOneGeneration(Person person1, Person person2) {
        var parrents1 = person1.getParrents();
        var parrents2 = person2.getParrents();
        for (Person parrent1 : parrents1) {
            for (Person parrent2 : parrents2) {
                if (parrent1.equals(parrent2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean addPerson(Person person, Boolean allRelatives) {
        if (person != null && !this.persons.contains(person)) {
            this.persons.add(person);
            person.setSename(this);
        } else {
            return false;
        }
        if (allRelatives) {
            addPersons(person.getParrents(), allRelatives);
            addPersons(person.getChildren(), allRelatives);
        }
        return true;
    }

    private Boolean addPersons(List<Person> persons, Boolean allRelatives) {
        if (persons == null || persons.size() == 0) {
            return false;
        }
        for (Person person : persons) {
            addPerson(person, allRelatives);
        }
        return true;
    }

    public boolean contains(Person person) {
        return this.persons.contains(person);
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(persons);
    }

}
