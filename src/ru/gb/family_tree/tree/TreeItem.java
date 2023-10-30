package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Gender;

import java.time.LocalDate;
import java.util.List;

public interface TreeItem {
    String getName();    

    void setId(int id);

    int getId();

    String getLastname();

    Gender getGender();

    LocalDate getBirthday();

    Object getSpouse();

    String getParents();

    String getChildren();

    int age();

    String getAge();
}
