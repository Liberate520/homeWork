package ru.java_oop.family_tree.family_tree;

import ru.java_oop.family_tree.human.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Serializable {
    String getName();
    int getAge();
    long getId();
    void setId(long id);
    void setParents(List<T> parents);
    void addParent(T parent);
    List<T> getParents();
    List<T> getChildren();
    void addChild(T child);
    T getSpouse();
    void setSpouse(T spouse);
    Gender getGender();
    void setChildren(List<T> parents);
    T getFather();
    T getMother();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
}
