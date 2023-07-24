package ru.gb.family_tree.model.tree;

import ru.gb.family_tree.model.human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeItem<T> extends GetByAge, GetByName, Serializable , Comparable<T>{
//    int getId();
    T getFather();
    T getMother();
    String getInfo();
    void addChild(T human);
    void addParent(T human);
    LocalDate getDateOfBirth();
//    LocalDate getDateOfDeath();

    public List<T> getChildren();

    public List<T> getParents();


    ////
    String getNameFather();
    String getNameMother();

}
