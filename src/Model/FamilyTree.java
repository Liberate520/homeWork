package Seminars_OOP.HW_7.src.Model;

import java.io.*;
import java.util.*;

public class FamilyTree<T extends Human> implements Serializable, Iterable<T>{

    public List<Human> humanList;
    private Writable writable;

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }


    public FamilyTree() {
        this(new ArrayList<Human>());
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
                if (writable.read() == null) {
                    return new FamilyTree();
                } else 
                {
                    return (FamilyTree) writable.read();
                }
        }
        return null;
    }


    public Human getHumanByName(String nameOfHuman) {

        for (Human human : humanList) {
            if (human.getName().equals(nameOfHuman)) {
                return human;
            }
        }
        return null;
    }


    public void sortByName() {
        Collections.sort(humanList);
    }


    public void sortByAge(){
        getAllHuman().sort(new ComparatorByAge());
    }


    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator(humanList);
    }

    
}


