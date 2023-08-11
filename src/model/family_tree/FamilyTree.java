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

    public void marry(int firstIndex, int secondIndex) {
        if(firstIndex >= 0 && firstIndex < humansList.size() && secondIndex >=0 && secondIndex < humansList.size()) {
            humansList.get(firstIndex).marry(humansList.get(secondIndex));
        }
    }

    public void addChild(E parent, E child) {
        parent.addChild(child);
        child.addParent(parent);
    }

    public void addChild(int parentIndex, int childIndex) {
        if(parentIndex >= 0 && parentIndex < humansList.size() && childIndex >= 0 && childIndex < humansList.size()) {
            humansList.get(parentIndex).addChild(humansList.get(childIndex));
            humansList.get(childIndex).addParent(humansList.get(parentIndex));
        }
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
