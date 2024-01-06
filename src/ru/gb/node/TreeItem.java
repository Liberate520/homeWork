package ru.gb.node;

import java.io.Serializable;
import java.util.List;

public interface TreeItem<E> extends Serializable {
    List<E> getParents();

    void addChild(E treeItem);

    List<E> getChildren();

    void addParent(E treeItem);

    String getName();

    int getAge();
}
