package model;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> implements GenealogicalTree<T> {
    private List<T> treeElementList;

    public Tree(List<T> treeElementList) {
        this.treeElementList = treeElementList;
    }

    public Tree() {
        this(new ArrayList<>());
    }

    public List<T> getPersonList() {
        return treeElementList;
    }

    public void setPersonList(List<T> treeElementList) {
        this.treeElementList = treeElementList;
    }

    public void addElement(T treeElement) {
        treeElementList.add(treeElement);
    }

    @Override
    public T findElement(String name) {
        for (T treeElement : treeElementList) {
            if (treeElement.equals(name)) {
                return treeElement;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return "personList = " + treeElementList;
    }
}