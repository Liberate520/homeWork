package ru.gb.node;

import ru.gb.treeItem.comparators.ItemComparatorByAge;
import ru.gb.treeItem.comparators.ItemComparatorByName;
import ru.gb.person.Person;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FamilyTree<E extends TreeItem<E>> implements Serializable, Iterable<Person> {
    private List<E> treeItemList;

    public FamilyTree(List<E> treeItemList) { this.treeItemList = treeItemList; }

    public FamilyTree() { this(new ArrayList<>()); }

    public void add(E treeItem) {
        if (treeItem == null) { return; }
        if (!treeItemList.contains(treeItem)) {
            treeItemList.add(treeItem);

            addToParents(treeItem);
            addToChildren(treeItem);

        }
    }

    private void addToParents(E treeItem) {
        for (E parent : treeItem.getParents()) {
            parent.addChild(treeItem);
        }
    }

    private void addToChildren(E treeItem) {
        for (E child : treeItem.getChildren()) {
            child.addParent(treeItem);
        }
    }

    public E getByName(String name) {
        for (E treeItem : treeItemList) {
            if (treeItem.getName().equals(name)) {
                return treeItem;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(treeItemList.size());
        sb.append(" объектов: \n");
        for (E treeItem : treeItemList) {
            sb.append(treeItem);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator iterator() {
        return new ItemIterator<E>(treeItemList);
    }

    public void sortByName() {
        treeItemList.sort(new ItemComparatorByName<E>());
    }

    public void sortByAge() {
        treeItemList.sort(new ItemComparatorByAge<E>());
    }
}