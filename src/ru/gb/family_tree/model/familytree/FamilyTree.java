package ru.gb.family_tree.model.familytree;

import ru.gb.family_tree.model.comparator.FamilyTreeIterator;
import ru.gb.family_tree.model.comparator.TreeNode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private long subId;
    private List<E> subList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> subList) {
        this.subList = subList;
    }

    public boolean addSub(E sub) {
        if (sub == null) {
            return false;
        }
        if (!subList.contains(sub)) {
            subList.add(sub);
            sub.setId(subId++);

            addToParents(sub);
            addToChild(sub);

            return true;
        }
        return false;
    }

    private void addToParents(E sub) {
        for (E parent : sub.getParents()) {
            parent.addChild(sub);
        }
    }

    private void addToChild(E sub) {
        for (E child : sub.getChildren()) {
            child.addParent(sub);
        }
    }

    public List<E> getByName(String name) {
        List<E> res = new ArrayList<>();
        for (E sub : subList) {
            if (sub.getName().equals(name)) {
                res.add(sub);
            }
        }
        return res;
    }

    public boolean remove(long subId) {
        if (checkId(subId)) {
            E e = getByID(subId);
            return subList.remove(e);
        }
        return false;
    }

    private boolean checkId(long id) {
        if (id >= subId || id < 0){
            return false;
        }
        for (E sub: subList){
            if (sub.getId() == id){
                return true;
            }
        }
        return false;
    }

    public E getByID(long id) {
        for (E sub : subList) {
            if (sub.getId() == id) {
                return sub;
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
        stringBuilder.append(subList.size());
        stringBuilder.append(" objects: \n");
        for (E sub : subList) {
            stringBuilder.append(sub);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(subList);
    }
}
