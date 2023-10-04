package ru.gb.family_tree.Tree;

import ru.gb.family_tree.Family.Gender;

import java.time.LocalDate;

public interface FamilyTreeItem {
    int getAge();
    String getName();
    LocalDate getDateOfBirth();
    Gender getGender();
    long getId();
    void setId(long id);

}
