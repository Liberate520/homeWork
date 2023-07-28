package family_tree;

import human.Human;
import human.comparator.HumanComparatorByBirthDay;
import human.iterator.HumanIterator;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humansList;

    public FamilyTree(List<Human> humansList){
        this.humansList = humansList;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public void addHuman(Human human){
        humansList.add(human);
    }
    public void marry(Human firstHuman, Human secondHuman) {
        firstHuman.marry(secondHuman);
    }

    public void addChild(Human parent, Human child) {
        parent.addChild(child);
        child.addParent(parent);
    }

    public void addParent(Human child, Human parent) {
        parent.addChild(child);
        child.addParent(parent);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Human human: humansList){
            sb.append(human.toString());
            sb.append("\n\r");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humansList);
    }

    public void sortByName(){
        Collections.sort(humansList);
    }

    public void sortByDateBirthDay(){
        Collections.sort(humansList, new HumanComparatorByBirthDay());
    }
}
