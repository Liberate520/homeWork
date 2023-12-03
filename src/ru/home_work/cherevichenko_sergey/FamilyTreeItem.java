package ru.home_work.cherevichenko_sergey;

import ru.home_work.cherevichenko_sergey.human.Gender;
import ru.home_work.cherevichenko_sergey.human.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface FamilyTreeItem<E> {
    String getName();

    String getLastName();

    LocalDate getBirthDay();
    LocalDate getDateDeath();

    Gender getGender();

     List<E> getChildren();

}
