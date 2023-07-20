package homeWork.FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import homeWork.FamilyTree.iterators.TreeItem;
import homeWork.human.Human;
import homeWork.human.comparators.HumanComparatorByAge;
import homeWork.human.comparators.HumanComparatorByName;

public class FamilyTree<E extends TreeItem> implements Serializable, Iterable<E> {
    private ArrayList<E> familyTree;

    public FamilyTree(ArrayList<E> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addHuman(E human) {
        familyTree.add(human);
    }

    public boolean add(E human) {
        if (familyTree == null) {
            this.familyTree = new ArrayList<>();
        }
        if (human == null) {
            return false;
        }
        if (!familyTree.contains(human)) {
            familyTree.add(human);
            return true;
        }
        addToParents(human);
        addToChildren(human);
        return false;
    }

    private void addToParents(E human) {
        for (E parent : human.getParents()) {
            parent.addParent(human);
        }
    }

    private void addToChildren(E human) {
        for (E children : human.getChildren()) {
            children.addParent(human);
        }
    }

    public E getByName(String name) {
        for (E human : familyTree) {
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }

    public String getHumanInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(familyTree.size());
        sb.append(" объектов: \n ");
        for (E human : familyTree) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getHumanInfo();
    }

    @Override
    public Iterator<E> iterator() {
        return familyTree.iterator();
    }

    public void sortByName() {
        familyTree.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        familyTree.sort(new HumanComparatorByAge());
    }

    public Object size() {
        return familyTree.size();
    }
}
