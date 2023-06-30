package ru.gb.family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private int personId;
    private List<Human> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }
    
    public void addHuman(Human human) {
        human.setId(personId++);
        humans.add(human);
    }

    public void removeHuman(int id) {
        for (int i = 0; i < humans.size(); i++) {
            if (humans.get(i).id() == id) {
                humans.remove(i);
            }
        }
    }

    public void getHumans() {
        for (Human human : humans) {
            System.out.println(human);
        }
    }

    public void clearTree() {
        humans.clear();
    }
}
