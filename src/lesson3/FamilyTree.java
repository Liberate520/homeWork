package lesson3;

import Comparators.ComparatorByName;
import Comparators.ComparatorByBirthDate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humanList;

    public FamilyTree() { this(new ArrayList<>()); }

    public FamilyTree(List<Human> humanList) { this.humanList = humanList; }

    public boolean add(Human human){
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

    public Human getByName(String name){
        for (Human human : humanList){
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
        for (Human human : humanList){
            res.append(human.getInfo());
            res.append("\n");
        }
        return res.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return humanList.iterator();
    }

    public void sortByName() {
        Collections.sort(humanList, new ComparatorByName());
    }

    public void sortByBirthDate() {
        Collections.sort(humanList, new ComparatorByBirthDate());
    }
}
