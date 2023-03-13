package homeWork.Homeworke2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable{
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
}