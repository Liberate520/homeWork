package ru.gb.family_tree.model.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeItem<T> extends Serializable {
    String getName();

    int getAge();

    T getFather();

    T getMother();

    String getChildrenInfo();

    boolean addParent(T parent);

    boolean addChild(T child);

    List<T> getChildren();

    List<T> getParents();

    int getId();
}
