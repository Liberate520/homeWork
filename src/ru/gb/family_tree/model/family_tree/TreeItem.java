package ru.gb.family_tree.model.family_tree;

import java.io.Serializable;
import java.util.List;

public interface TreeItem<T> extends Serializable {
    String getName();
    int getAge();
    String getFather();
    String getMother();
    List<T> getChildren();
    List<T> getParents();
    long getId();
}
