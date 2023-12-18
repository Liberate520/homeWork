package ru.gb.family_tree_homework.family_tree_API.human.builder;

import ru.gb.family_tree_homework.family_tree_API.human.Gender;
import ru.gb.family_tree_homework.family_tree_API.human.Human;

import java.time.LocalDate;

public class HumanBuilder {
    public Human build(String name, Gender gender, LocalDate birthDate){
        return new Human(name, gender, birthDate);
    }
}
