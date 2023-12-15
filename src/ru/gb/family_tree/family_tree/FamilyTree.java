package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.HumanComparatorByBirthDate;
import ru.gb.family_tree.human.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private int countPeople;
    private List<Human> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public void add(Human human) {
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(countPeople++);
            addToParents(human);
            addToChildren(human);
        }
    }

    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<Human> getByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В древе: ");
        sb.append(humanList.size());
        sb.append(" человек \n");
        for (Human human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByBirthDate(){
        humanList.sort(new HumanComparatorByBirthDate());
    }
}
