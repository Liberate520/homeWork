package model.family_tree;

import model.human.comparator.HumanComparatorByBirthDay;
import model.human.comparator.HumanComparatorByName;
import model.human.iterator.HumanIterator;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<E extends FamilyTreeElement> implements Serializable, Iterable<E> {
    private List<E> humansList;

    public FamilyTree(List<E> humansList){
        this.humansList = humansList;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public void addHuman(E human){
        humansList.add(human);
    }
    public void marry(E firstHuman, E secondHuman) {
        firstHuman.marry(secondHuman);
    }

    public void addChild(E parent, E child) {
        parent.addChild(child);
        child.addParent(parent);
    }

    public void addParent(E child, E parent) {
        parent.addChild(child);
        child.addParent(parent);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E human: humansList){
            sb.append(human.toString());
            sb.append("\n\r");
        }
        return sb.toString();
    }

    public List<E> getHumanList() {
        return humansList;
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humansList);
    }

    public void sortByName(){
        Collections.sort(humansList, new HumanComparatorByName<>());
    }

    public void sortByDateBirthDay(){
        Collections.sort(humansList, new HumanComparatorByBirthDay());
    }
}
