package org.genealogy.model.tree;

import org.genealogy.model.person.Gender;
import org.genealogy.model.person.Human;
import org.genealogy.model.tree.comparators.HumanComparatorByAge;
import org.genealogy.model.tree.comparators.HumanComparatorByName;
import org.genealogy.model.tree.iterators.TreeIterator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenealogyTree<E extends TreeItem> implements Iterable<E>, Serializable {
    private List<E> people;
    public GenealogyTree()
    {
        this.people = new ArrayList<>();
    }

    public void addHuman(E person)
    {
        people.add(person);
    }

    public void addDateOfBirth(int id, int day, int month, int year) {
        for (E person : people) {
            if (person.getId() == id) {
                person.setDateOfBirth(day, month, year);
            }
        }
    }

    public void addDateOfDeath(int id, int day, int month, int year) {
        for (E person : people) {
            if (person.getId() == id) {
                person.setDateOfDeath(day, month, year);
            }
        }
    }

    public void addChildren(int parentId, int childId) {
        for (E parent : people) {
            if (parent.getId() == parentId) {
                for (E child : people) {
                    if (child.getId() == childId) {
                        parent.addChild((Human) child);
                    }
                }
            }
        }
    }

    public void addGender(int id, Gender gender) {
        for (E person : people) {
            if (person.getId() == id) {
                person.setGender(gender);
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<>(people);
    }

    public void sortByName(){
        people.sort(new HumanComparatorByName<>());
    }

    public void sortByAge(){
        people.sort(new HumanComparatorByAge<>());
    }
}
