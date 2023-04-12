package famyilyTree;

import human.Human;
import human.HumanComparatorByID;
import human.HumanComparatorByLastName;
import human.HumanIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {
    List<T> humanList;

    public FamilyTree(List<T> familyTree) {
        this.humanList = familyTree;
    }
    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }

    public List<T> getFamilyTree() {
        return humanList;
    }

    // Добавить новый объект Human в лист дерева
    public void add(T human) {
        if (!humanList.contains(human)) {
            this.humanList.add(human);
            if (human.getFather() != null) human.getFather().addChild(human);
            if (human.getMother() != null) human.getMother().addChild(human);
        }
    }

    public T getById(int id) {
        for (T human: humanList) {
            if (human.getId() == id)
                return human;
        }
        return null;
    }
    @Override
    public Iterator<T> iterator() { return new HumanIterator<T>(humanList); }

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
        for (T human: humanList) {
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
