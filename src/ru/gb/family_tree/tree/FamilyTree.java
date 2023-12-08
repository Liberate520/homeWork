package ru.gb.family_tree.tree;

import ru.gb.family_tree.humans.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private long humansId;
    private List<E> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public boolean addHumans(E human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChild(human);

            return true;
        }
        return false;
    }

    private void addToParents(E human) {
        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChild(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<E> getByName(String name) {
        List<E> res = new ArrayList<>();
        for (E human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    public boolean remove(long humansId) {
        if (checkId(humansId)) {
            E e = getByID(humansId);
            return humanList.remove(e);
        }
        return false;
    }

    private boolean checkId(long id) {
        return id < humansId && id >= 0;
    }

    private E getByID(long id) {
        if (checkId(id)) {
            for (E human : humanList) {
                if (human.getId() == id) {
                    return human;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("In the tree: ");
        stringBuilder.append(humanList.size());
        stringBuilder.append(" objects: \n");
        for (E human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(humanList);
    }

    public void sortByName() {
        humanList.sort(new FamilyTreeComparatorByName<>());
    }

    public void sortByDate() {
        humanList.sort(new FamilyTreeComparatorByDate<>());
    }
}
