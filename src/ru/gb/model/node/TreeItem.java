package ru.gb.model.node;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeItem<E> extends Serializable {
    List<E> getParents();

    void addChild(E treeItem);

    List<E> getChildren();

    void addParent(E treeItem);

    String getName();

    int getAge();

    void setGender(String genderStr);

    void setDeathDate(LocalDate deathDate);
}
