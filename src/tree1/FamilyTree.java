package tree1;
import java.util.ArrayList;
import java.util.List;

import human1.Human;
import human1.HumanComparatorById;
import human1.HumanComparatorByName;

import java.io.Serializable;
import java.util.Iterator;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }
    // public void addHumanList(Human humanList) {
    //     this.humanList.add(humanList);
    // }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            if(human.getMother() != null) {
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }

    public Human getByName(String name) {
        for(Human human: humanList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public String printTree() {
        StringBuilder sb = new StringBuilder();
        sb.append("В фамильном дереве ");
        sb.append(humanList.size());
        sb.append(" людей: \n");
        for (Human human: humanList) {
            sb.append(human.printHuman());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getInfo() {
        return String.format("Семья: ", printTree());
    }

    @Override
    public String toString() {
        return printTree();
    }

    @Override
    public Iterator<Human> iterator() {
        return new TreeIterator(humanList);
    }

    public void sortById() {
        humanList.sort(new HumanComparatorById());
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }
}