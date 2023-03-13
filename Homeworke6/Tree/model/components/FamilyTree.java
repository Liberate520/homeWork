package model.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import model.comparator.HumanComparatorByDate;
import model.comparator.HumanComparatorByName;

public class FamilyTree<T extends Human> implements Serializable, Iterable<T>{
    private List<T> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<T> humanList) {
        this.humanList = humanList;
    }

    public List<T> getHumanList() {
        return humanList;
    }

    public void setHumanList(List<T> humanList) {
        this.humanList = humanList;
    }

    public boolean add(T human) {
        if (human == null) return false;
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getMother() != null) human.getMother().addChild(human);
            if (human.getFather() != null) human.getFather().addChild(human);
            return true;
        }
        return false;
    }

    public T getByName(String name) {
        for (T human : humanList) {
            if (human.getFullName().equals(name))
                return human;
        }
        return null;
    }

    public boolean deletePerson(T human){
        if (human == null){
            return false;
        }
        if (humanList.contains(human)){
            humanList.remove(human);
            if (human.getFather() != null){
                human.getFather().removeChild(human);
            }
            if (human.getMother() != null){
                human.getMother().removeChild(human);
            }
            for ( Human child : human.getChildren()){
                child.removeMother();
                child.removeFather();
            }
            return true;
        }
        return true;
    }

    public String getInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Number of people in the tree: " + humanList.size() + "\n");
        for (T human : humanList)
            res.append(human.getInfo());
        return res.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return humanList.iterator();
    }

    public void sortByName() {
        Collections.sort(humanList, new HumanComparatorByName<T>());
    }

    public void sortByAge() {
        Collections.sort(humanList, new HumanComparatorByDate<T>());
    }
}