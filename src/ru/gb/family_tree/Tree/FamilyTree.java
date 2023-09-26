package ru.gb.family_tree.Tree;

import ru.gb.family_tree.Family.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }

    public void addHuman(Human human) {
        humans.add(human);
    }

    public String getHumansNames() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family:\n");
        for (Human human : humans) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getHumansNames();
    }
}
