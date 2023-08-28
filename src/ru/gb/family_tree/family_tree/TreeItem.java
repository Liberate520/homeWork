package ru.gb.family_tree.family_tree;

import java.time.LocalDate;
import java.util.List;

public interface TreeItem<T> {
    long getId();
    void setId(long id);
    boolean addChild(T human);
    boolean addParent(T human);
    T getFather();
    T getMother();
    String getName();
    LocalDate getBirthDate();
    int getAge();
    List<T> getParents();
    List<T> getChildren();
    T getSpouse();
    void setSpouse(T human);
}
