package ru.gb.family_tree.model.tree;

import ru.gb.family_tree.model.human.Gender;
import java.time.LocalDate;


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
