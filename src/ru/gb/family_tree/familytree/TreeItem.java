package ru.gb.family_tree.familytree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeItem<E> extends Serializable {
    void setId(int id);
    int getId();
    E getFather();
    E getMother();
    Boolean addChild(E human);
    Boolean addParent(E human);
    String getName();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<E> getParents();
    List<E> getChildren();


    int getAge();

    String getInfo();
}
