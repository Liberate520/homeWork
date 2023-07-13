package family_tree.familytree;

import family_tree.familytree.iterator.PersonIterator;
import family_tree.person.*;
import family_tree.person.comparator.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Person> {
    private List<Person> allPersons;
    private Person peakMother;
    private Person peakFather;

    // constructors
    public FamilyTree() {
        allPersons = new ArrayList<>();
    }

    public FamilyTree(Person person) {
        allPersons = new ArrayList<>();
        allPersons.add(person);
    }

    public void addPerson(Person person) {
        if (allPersons == null) {
            allPersons = new ArrayList<>();
        }
        allPersons.add(person);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person person:this) {
            sb.append(String.format("%s \n", person));
        }
        return sb.toString();
    }

    public void setPeak(String name) {
        for (Person person : this) {
            if (person.getName().equalsIgnoreCase(name))
                if (person.getGender()== Gender.Female) {
                    this.peakMother = person;
                } else {
                    this.peakFather = person;
                }
        }
    }

    public Person getPeakMother() {
        return peakMother;
    }

    public Person getPeakFather() {
        return peakFather;
    }

    public Person getPersonByName(String name) {
        for (Person personAtList:this) {
            if (personAtList.getName().equalsIgnoreCase(name)){
                return personAtList;
            }
        }
        return null;
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(this.allPersons);
    }

    public void sortByName() {
        Collections.sort(this.allPersons);
    }

    public void sortByNameReverse() {
        Collections.sort(this.allPersons, new PersonComparatorByNameReverse());
    }

    public void sortByAge() {
        Collections.sort(this.allPersons,new PersonComparatorByAge());
    }

    public void sortByAgeReverse() {
        Collections.sort(this.allPersons,new PersonComparatorByAgeReverse());
    }

    public void sortByBirth() {
        Collections.sort(this.allPersons,new PersonComparatorByBirth());
    }

    public void sortByBirthReverse() {
        Collections.sort(this.allPersons,new PersonComparatorByBirthReverse());
    }

    public void sortByChildren() {
        Collections.sort(this.allPersons,new PersonComparatorByChildren());
    }

    public void sortByChildrenReverse() {
        Collections.sort(this.allPersons,new PersonComparatorByChildrenReverse());
    }
}
