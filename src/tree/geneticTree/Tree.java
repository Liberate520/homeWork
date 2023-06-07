package tree.geneticTree;

import tree.human.Human;
import tree.human.HumanComparatorByAge;
import tree.human.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree implements Serializable, Iterable<Human> {
    private List<Human> humanList;

    public Tree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public Tree() {
        this(new ArrayList<>());
    }

    public Human getByName(String name) {
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public void add(Human human) {
        humanList.add(human);
        if (human.getFather() != null) {
            human.getFather().addChildren(human);
        }
        if (human.getMother() != null) {
            human.getMother().addChildren(human);
        }
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human : humanList) {
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return humanList.iterator();
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge());
    }
}
