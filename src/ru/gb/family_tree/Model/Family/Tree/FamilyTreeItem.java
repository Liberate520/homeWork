package ru.gb.family_tree.Model.Family.Tree;

import ru.gb.family_tree.Model.Family.Family.Gender;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> {
    int getAge();
    String getName();
    LocalDate getDateOfBirth();
    Gender getGender();
    long getId();
    void setId(long id);
    T getFather();
    T getMother();
    boolean addChild(T human);
    boolean addParent(T human);
    LocalDate getDateOfDeath();
    List<T> getChildren();
    List<T> getParents();
    T getSpouse();
    void setSpouse(T human);
}
