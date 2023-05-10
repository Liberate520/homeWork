package model.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import human.Human;

public class FamilyTree<E extends Human> implements Iterable<E>, Serializable {
    // private E value;

    private List<E> humansList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humansList) {
        this.humansList = humansList;
    }

    public boolean add(E human) {
        if (human == null) {
            return false;
        }
        if (!humansList.contains(human)) {
            humansList.add(human);
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

    public E getByName(String name) {
        for (E human : humansList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humansList.size());
        sb.append(" обьектов \n ");
        for (E human : humansList) {
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<E> getHumansList() {
        return humansList;
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return humansList.iterator();
    }

}
