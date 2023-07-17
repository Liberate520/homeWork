package family_tree.familytree;

import family_tree.familytree.iterator.PersonIterator;
import family_tree.person.*;
import family_tree.person.comparator.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private List<E> allPersons;
    private E peakMother;
    private E peakFather;

    // constructors
    public FamilyTree() {
        allPersons = new ArrayList<>();
    }

    public FamilyTree(E person) {
        allPersons = new ArrayList<>();
        allPersons.add(person);
    }

    public void addPerson(E person) {
        if (allPersons == null) {
            allPersons = new ArrayList<>();
        }
        allPersons.add(person);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E person:this) {
            sb.append(String.format("%s \n", person));
        }
        return sb.toString().substring(0,sb.length()-3);
    }

    public String printShort() {
        int index = 1;
        StringBuilder sb = new StringBuilder();
        for (E person:this) {
            sb.append(String.format("%s. ", index++));
            sb.append(person.getName());
            sb.append(" ");
            sb.append(person.getBirthDate());
            sb.append(" ");
            sb.append(person.getAge());
            sb.append(" л.(г.)");
            sb.append("\n");
        }
        return sb.toString().substring(0,sb.length()-1);
    }

    public void setPeak(String name) {
        for (E person : this) {
            if (person.getName().equalsIgnoreCase(name))
                if (person.getGender()== Gender.Female) {
                    this.peakMother = person;
                } else {
                    this.peakFather = person;
                }
        }
    }

    public E getPeakMother() {
        return peakMother;
    }

    public E getPeakFather() {
        return peakFather;
    }

    public E getPersonByName(String name) {
        for (E personAtList:this) {
            if (personAtList.getName().equalsIgnoreCase(name)){
                return personAtList;
            }
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new PersonIterator<>(this.allPersons);
    }

    public void sortByName() {
        Collections.sort(this.allPersons, new PersonComparatorByName<>());
    }

    public void sortByNameReverse() {
        Collections.sort(this.allPersons, new PersonComparatorByNameReverse<>());
    }

    public void sortByAge() {
        Collections.sort(this.allPersons,new PersonComparatorByAge<>());
    }

    public void sortByAgeReverse() {
        Collections.sort(this.allPersons,new PersonComparatorByAgeReverse<>());
    }

    public void sortByBirth() {
        Collections.sort(this.allPersons,new PersonComparatorByBirth<>());
    }

    public void sortByBirthReverse() {
        Collections.sort(this.allPersons,new PersonComparatorByBirthReverse<>());
    }

    public void sortByChildren() {
        Collections.sort(this.allPersons,new PersonComparatorByChildren<>());
    }

    public void sortByChildrenReverse() {
        Collections.sort(this.allPersons,new PersonComparatorByChildrenReverse<>());
    }

    public boolean delByName(String name) {
        E person = this.getPersonByName(name);
        return this.allPersons.remove(person);
    }

    public E getPersonByIndex(int index) {
        if (index < this.allPersons.size()) {
            return this.allPersons.get(index);
        }
        return null;
    }

    public int getSize() {
        return this.allPersons.size();
    }

    public List<E> getAllUnits() {
        return this.allPersons;
    }

}
