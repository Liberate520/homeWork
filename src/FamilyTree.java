package Seminars_OOP.HW_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human>{
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
            // if (writable instanceof FileHandler) {
                if (writable.read() == null) {
                    return new FamilyTree();
                } else 
                {
                    return (FamilyTree) writable.read();
                }
            // }
        // } else {
        //     System.out.println("Ошибка загрузки файла");
        //     return null;
        }
        return null;
    }

    public Human getHumanByName_1(String name) {
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public void sortByName() {
        Collections.sort(humanList);
    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(humanList);
    }

    
}


