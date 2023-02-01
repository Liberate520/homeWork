package Homework_002;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {

    private List<Human> humans;

    public FamilyTree(List<Human> humans) {
        this.humans = humans;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void add(Human human) {
        humans.add(human);
    }

    public List<Human> getAll() {
        return this.humans;
    }

    public String getGenderById(int id) {
        for (Human human : this.humans) {
            if (human.getId().equals(id)) {
                return human.getGender();
            }
        }
        return null;
    }

    public Human getHumanById(int id) {
        for (Human human : this.humans) {
            if (human.getId().equals(id)) {
                return human;
            }
        }
        return null;
    }

    public List<Human> getHumansByGender(String gender) {
        List<Human> newHumans = new ArrayList<>();
        for (Human human : this.humans) {
            if (human.getGender().equals(gender)) {
                newHumans.add(human);
            }
        }
        return newHumans;
    }


    public Human getHumanByName(String name) {
        for (Human human : humans) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }
}
