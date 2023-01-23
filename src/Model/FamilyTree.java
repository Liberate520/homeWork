package Seminars_OOP.HW_5.src.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Human> implements Serializable, Iterable<T>{
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
        }
        return null;
    }

    public Human getHumanByName(String name) {

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

    public void sortByAge(){
        Collections.sort(getAllHuman(),
                new ComparatorByAge());
    }


    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator(humanList);
    }

    
}


