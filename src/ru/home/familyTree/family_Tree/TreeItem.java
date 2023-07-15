package ru.home.familyTree.family_Tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface ThreeItem<T> extends Serializable {
    String getName();
    int getAge();
    LocalDate getDateOfBirth();
    T getFather();
    T getMather();
    void addChild(T child);
    void addParent(T parent);
    List<T> getChildren();
    List<T> getParents();

}
