package ru.gb.node;

import java.util.List;

public interface TreeItem<E> {
    List<E> getParents();

    void addChild(E treeItem);

    List<E> getChildren();

    void addParent(E treeItem);

    String getName();

    int getAge();
}
