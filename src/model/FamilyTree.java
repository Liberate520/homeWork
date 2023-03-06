package model;

import comparators.ComparatorByName;
import comparators.ComparatorByBirthDate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {
    private List<T> humanList;

    public FamilyTree() { this(new ArrayList<>()); }

    public FamilyTree(List<T> humanList) { this.humanList = humanList; }

    public boolean add(T human){
        if (human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            if (human.getFather() != null){
                human.getFather().addChild(human);
            }
            if (human.getMother() != null){
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }
    public boolean delete(T human){
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

    public T getByName(String name){
        for (T human : humanList){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }

    public String getInfo(){
        StringBuilder res = new StringBuilder();
        res.append(humanList.size());
        res.append(" objects in the tree: \n");
        for (T human : humanList){
            res.append(human.getInfo());
            res.append("\n");
        }
        return res.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return humanList.iterator();
    }

    public void sortByName() {
        Collections.sort(humanList, new ComparatorByName<T>());
    }

    public void sortByBirthDate() {
        Collections.sort(humanList, new ComparatorByBirthDate<T>());
    }
}
