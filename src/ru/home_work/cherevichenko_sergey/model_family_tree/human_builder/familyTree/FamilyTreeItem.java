package ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree;

import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human.Gender;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<E> {
    String getName();

    String getLastName();

    LocalDate getBirthDay();

    LocalDate getDateDeath();

    Gender getGender();

    List<E> getChildren();


}
