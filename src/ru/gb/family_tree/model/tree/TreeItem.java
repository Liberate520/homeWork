package ru.gb.family_tree.model.tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeItem<T> extends Serializable , Comparable<T>{
    String getFullName();
    T getFather();
    T getMother();
    int getAge();
    String getInfo();
    List<T> getChildren();
    List<T> getParents();
    void addChild(T human);
    void addParent(T human);
    LocalDate getDateOfBirth();
    LocalDate getDateOfDeath();
}
