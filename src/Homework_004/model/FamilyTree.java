package Homework_004.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree <T extends BaseType> implements Serializable, Writable, Iterable<T> {

    private List<T> humans;

    public FamilyTree(List<T> humans) {
        this.humans = humans;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }


    public void add(T human) {
        humans.add(human);
    }

    public List<T> getAll() {
        return this.humans;
    }

    public String getGenderById(int id) {
        for (T human : this.humans) {
            if (human.getId()==id) {
                return human.getGender();
            }
        }
        return null;
    }

    public T getHumanById(int id) {
        for (T human : this.humans) {
            if (human.getId()==id) {
                return human;
            }
        }
        return null;
    }

    public List<T> getHumansByGender(String gender) {
        List<T> newHumans = new ArrayList<>();
        for (T human : this.humans) {
            if (human.getGender().equals(gender)) {
                newHumans.add(human);
            }
        }
        return newHumans;
    }


    public T getHumanByName(String name) {
        for (T human : humans) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }
   
    @Override
    public String toString(){
        return getAll().toString(); 
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator(this.humans);
    }
}
