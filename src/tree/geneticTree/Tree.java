package tree.geneticTree;

import tree.human.Human;
import tree.human.HumanComparatorByAge;
import tree.human.HumanComparatorByName;
import tree.service.Group;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree <T extends GroupItem> implements Serializable, Iterable<T>, Group<T> {
    private List<T> humanList;

    public Tree(List<T> humanList) {
        this.humanList = humanList;
    }

    public Tree() {
        this(new ArrayList<>());
    }

    public Human getByName(String name) {
        for (T human : humanList) {
            if (human.getName().equals(name)) {
                return (Human) human;
            }
        }
        return null;
    }

    public void addHuman(T human) {
        humanList.add(human);
        if (human.getFather() != null) {
            human.getFather().addChildren((Human) human);
        }
        if (human.getMother() != null) {
            human.getMother().addChildren((Human) human);
        }
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (T human : humanList) {
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return humanList.iterator();
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge<>());
    }
}
