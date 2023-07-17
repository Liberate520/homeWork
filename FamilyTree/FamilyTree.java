package homeWork.FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import homeWork.human.Human;
import homeWork.human.comparators.HumanComparatorByAge;
import homeWork.human.comparators.HumanComparatorByName;

public class FamilyTree implements Serializable, Iterable<Human> {
    private ArrayList<Human> familyTree;

    public FamilyTree(ArrayList<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addHuman(Human human) {
        familyTree.add(human);
    }

    public boolean add(Human human) {
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

    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addParent(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human children : human.getChildren()) {
            children.addParent(human);
        }
    }

    public Human getByName(String name) {
        for (Human human : familyTree) {
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
        for (Human human : familyTree) {
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
    public Iterator<Human> iterator() {
        return familyTree.iterator();
    }

    public void sortByName() {
        familyTree.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        familyTree.sort(new HumanComparatorByAge());
    }

    public void addStudent(Human human) {
    }

    public Object size() {
        return null;
    }

}
