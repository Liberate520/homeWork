package ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.service_tree;

import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human.Gender;
import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

// Класс для создания человека и использования в классе высшего программирования ServiceTree
public class HumanBuilder implements Serializable {
    public Human build(String name, String lastName, Gender gender,
                       LocalDate birthDay, LocalDate dateDeath, ArrayList<Human> children) {
        Human human = new Human(name, lastName, gender, birthDay, dateDeath, new ArrayList<>(0));
        return human;
    }
}
