package tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {

    private final List<Human> humanList;


    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            return true;

        }
        return false;

    }

    public String getInfoTree() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов : \n");
        for (Human human : humanList) {
            sb.append((human.getInfoHuman()));
            sb.append("\n");

        }
        return sb.toString();
    }


    public Human findHumanByName(String name) {
        for (Human human : humanList) {
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;

    }

    public Human findHumanByFIO(String surName, String name, String secondName) {
        for (Human human : humanList) {
            if (human.getInfoName().equalsIgnoreCase(surName + name + secondName)) {
                return human;
            }
        }
        return null;
    }


}






















