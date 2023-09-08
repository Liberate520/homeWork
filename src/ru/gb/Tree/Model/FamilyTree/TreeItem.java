package ru.gb.Tree.Model.FamilyTree;

import java.time.LocalDate;



public interface TreeItem <E> {
    String getName();
    int getAge();
    LocalDate getBirthDate();
    Integer getId();
    E getSpouse();
    void setSpouse(E spouse);
}
