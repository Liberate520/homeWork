package model;

public interface GenealogicalTree<T> {

    void addElement(T treeElement);
    T findElement(String name);
}
