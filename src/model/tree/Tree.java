package model.tree;

import model.GroupItem;
import model.tree.comparators.TreeComparatorByDOB;
import model.tree.comparators.TreeComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree<T extends GroupItem> implements Serializable, Iterable<T> {
    private List<T> personList;

    public Tree() {
        personList = new ArrayList<>();
    }

    public void addPerson(T person) {
        personList.add(person);
        T tempPerson;
        if (person.getFather() != null) {
            tempPerson = (T) person.getFather();
            tempPerson.addChild(person);
        }
        if (person.getMother() != null) {
            tempPerson = (T) person.getMother();
            tempPerson.addChild(person);
        }
    }

    public List<T> getPersonList() {
        return personList;
    }

    public void setPersonList(List<T> personList) {
        this.personList = personList;
    }

    public T findPersonByName(String name) {
        for (T item : personList) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public List<T> findSiblings(T person) {
        List<T> siblingsList = new ArrayList<>();
        List<T> tempList = new ArrayList<>();
        T tempPerson;
        tempList.add(person);
        tempPerson = (T) person.getMother();
        siblingsList = tempPerson.getChildren();
        tempPerson = (T) person.getFather();
        siblingsList.removeAll(tempPerson.getChildren());
        siblingsList.addAll(tempPerson.getChildren());
        siblingsList.removeAll(tempList);
        return siblingsList;
    }

    public void sortByName(){
        personList.sort(new TreeComparatorByName<>());
    }

    public void sortByDOB(){
        personList.sort(new TreeComparatorByDOB<>());
    }

    @Override
    public Iterator<T> iterator() {
        return new TreeIterator<>(personList);
    }
}