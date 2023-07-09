package ru.gb.family_tree.Servise;

import java.time.LocalDate;

public interface TreeItem {
    String getName();
    int getAge();
    LocalDate getBirthday();

    String getSurname();

    String getNumPassport();

    void setId(int i);

}
