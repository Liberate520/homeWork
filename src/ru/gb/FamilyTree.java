package ru.gb;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public Human getHumanByName(String humanName) {
        for (Human human : humanList) {
            if (human.getName().equals(humanName)) {
                return human;

            }
        }

        return null;
    }


    public void addHuman(Human human) {
        humanList.add(human);
    }

    public String getHumanListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное древо:\n");
        for (Human human : humanList
        ) {
            stringBuilder.append(human);
            stringBuilder.append("\n");


        }
        return stringBuilder.toString();

    }
}
