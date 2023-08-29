package ru.gb.Tree.FamilyTree;

import java.time.LocalDate;


public interface TreeItem <E> {
    String getName();
    int getAge();
    LocalDate getBirthDate();
    int getId();
    E getSpouse();
    void setSpouse(E spouse);
}
