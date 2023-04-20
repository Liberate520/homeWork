package service.tree;


import service.Persons.Comparators.DateComparator;
import service.Persons.Comparators.HumanIterator;
import service.Persons.Comparators.NameComparator;
import service.Persons.Human;
import service.Persons.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;



public class FamilyTree<T extends Person> implements Serializable, Iterable<T> {
    private ArrayList t;
    private ArrayList<T> familyTree = new ArrayList<>();
    @Override
    public String toString()
    {
        return familyTree.toString();
    }
    @Override
    public Iterator<T> iterator()
    {
        return new HumanIterator(t);
    }
    public void add(T person)
    {
        familyTree.add(person);
    }
    public int size()
    {
        return familyTree.size();
    }
    public Object get(int i) {
        return familyTree.get(i);
    }
    public Object getName()
    {
        return getName();
    }
    public void sort(NameComparator nameComparator)
    {
        familyTree.sort(new NameComparator());
    }
    public void sort(DateComparator dateComparator)
    {
        familyTree.sort(new DateComparator());
    }
//
//    private Human human;
//    private ArrayList<T> familyTree = new ArrayList<>();
//
//    public ArrayList<T> getFamilyTree() {
//        return familyTree;
//    }
//
//    public void addHuman(T human) {
//        familyTree.add(human);
//        if (human.getMother() != null) {
//            human.getMother().addChildren(human);
//        }
//        if (human.getFather() != null) {
//            human.getFather().addChildren(human);
//        }
//    }
//
//    public T find(String name) {
//        for (T human : familyTree) {
//            if (human.getName().equalsIgnoreCase(name)) {
//                System.out.println(human);
//                return human;
//            }
//        }
//        return null;
//    }
//
//
//    @Override
//    public String toString() {
//        StringBuilder str = new StringBuilder();
//        str.append(this.familyTree);
//        return str.toString();
//    }
//    @Override
//    public Iterator<T> iterator(){
//        return new HumanIterator<T>(familyTree);
//    }
//    public void sortByDate() {
//        familyTree.sort(new DateComparator());
//    }
//    public void sortByName() {
//        familyTree.sort(new NameComparator());
//    }


}
