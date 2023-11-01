package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.time.LocalDate;
import java.util.List;

public interface TreeItem {
    String getName();    

    void setId(int id);

    int getId();

    String getLastname();

    Gender getGender();

    LocalDate getBirthday();

    String getSpouse();

    String getParents();

    String getChildren();

    int age();

    String getAge();
}
