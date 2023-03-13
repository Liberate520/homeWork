package homeWork.Homeworke3;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import homeWork.Homeworke3.comparator.HumanComparatorByDate;
import homeWork.Homeworke3.comparator.HumanComparatorByName;

public class FamilyTree implements Serializable, Iterable<Human>{
    private Writable writable;
    private List<Human> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public List<Human> getHumanList() {
        return humanList;
    }
    public void setHumanList(List<Human> humanList) {
        this.humanList = humanList;
    }

    public Writable getWritable() {
        return writable;
    }
    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public boolean add(Human human) {
        if (human == null) return false;
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getMother() != null) human.getMother().addChild(human);
            if (human.getFather() != null) human.getFather().addChild(human);
            return true;
        }
        return false;
    }

    public Human getByName(String name) {
        for (Human human : humanList) {
            if (human.getFullName() == name)
                return human;
        }
        return null;
    }

    @Override
    public String toString() {
        String list = "";
        for (Human human : humanList)
            list += human.toString();
        return list;
    }

    @Override
    public Iterator<Human> iterator() {
        return humanList.iterator();
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByDate());
    }
}