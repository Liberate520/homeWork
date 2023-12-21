package ru.gb.family_tree.family_tree.model.human;

import java.time.LocalDate;

public class HumanBuilder {

    public Human build(String name,Gender gender,LocalDate birthDate){
        return new Human(name, birthDate,gender);
    }
    public Human build(String name,Gender gender,LocalDate birthDate,LocalDate deathDate){
        return new Human(name, birthDate,deathDate,gender);
    }
}
