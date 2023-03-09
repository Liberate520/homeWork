package model;

import model.comparate.PersonComparatorName;
import model.comparate.PersonComparatorYear;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;


public class FamilyTree<T extends Person> implements Iterable<T>, Serializable {
    private List<T> humanList;
    public FamilyTree() {
        this(new ArrayList<>());
    }
    public FamilyTree(List<T> humanList) {
        this.humanList = humanList;
    }

    public boolean add(T T) {
        if (T == null) {

            return false;
        }
        if (!humanList.contains(T)){
            humanList.add(T);
            if (T.getFather() != null){
                T.getFather().addChild(T);
            }
            if (T.getMother() != null){
                T.getMother().addChild(T);
            }
            return true;
        }
        return false;
    }
    public T getByName(int id) {
        for (T T: humanList) {
            if (Objects.equals(T.getId(), id)){
                return T;
            }
        }
        return null;
    }
    public void search(String search) {
        Predicate<T> dynasty = n -> n.getName().equals(search);
        humanList.stream()
                .filter(dynasty)
                .forEach(System.out::println);
    }
    public void List() {
        System.out.println();
        System.out.println("Генеалогическое древо Романовых: ");

        for (T p : humanList) {
            System.out.println(p);
        }
    }
    public void sortByName() {
        humanList.sort(new PersonComparatorName());
    }
    public void sortByYear() {
        humanList.sort(new PersonComparatorYear());
    }

    @Override
    public Iterator<T> iterator() {
        return new PersonIterator<>(humanList);
    }

}