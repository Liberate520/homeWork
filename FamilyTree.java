package Seminars_OOP.HW_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable{
    public List<Human> humanList;
    private Writable writable;

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void addHuman(Human human) {
        humanList.add(human);
    }

    public List<Human> getHumanByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human Human : humanList) {
            if (Human.getName().equals(name)) {
                res.add(Human);
            }
        }
        return res;
    }

    public List<Human> getAllHuman() {
        return humanList;
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public void saveFamilyTree() {
        writable.save(this);
    }

    public FamilyTree readFamilyTree() {
        if (writable != null) {
            if (writable instanceof FileHandler) {
                if (writable.read() == null) {
                    return new FamilyTree();
                } else {
                    return (FamilyTree) writable.read();
                }
            }
        } else {
            System.out.println("Ошибка загрузки файла");
            return null;
        }
        return null;
    }

}
