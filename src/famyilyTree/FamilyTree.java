package famyilyTree;

import human.Human;
import human.HumanComparatorByID;
import human.HumanComparatorByLastName;
import human.HumanIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    List<Human> humanList;

    public FamilyTree(List<Human> familyTree) {
        this.humanList = familyTree;
    }
    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }

    public List<Human> getFamilyTree() {
        return humanList;
    }

    // Добавить новый объект Human в лист дерева
    public void add(Human human) {
        if (!humanList.contains(human)) {
            this.humanList.add(human);
            if (human.getFather() != null) human.getFather().addChild(human);
            if (human.getMother() != null) human.getMother().addChild(human);
        }
    }

    public Human getById(int id) {
        for (Human human: humanList) {
            if (human.getId() == id)
                return human;
        }
        return null;
    }
    @Override
    public Iterator<Human> iterator() { return new HumanIterator(humanList); }

    public void sortByID() {
        humanList.sort(new HumanComparatorByID());
    }

    public void sortByLastName() {
        humanList.sort(new HumanComparatorByLastName());
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов \n");
        for (Human human: humanList) {
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (!(obj instanceof FamilyTree)) { return false; }
        FamilyTree other = (FamilyTree) obj;
        return this.humanList.equals(other.humanList);
    }
}
