package ru.gb.family_tree.family_tree.model.human;

import java.time.LocalDate;

public class HumanBuilder {

    public Human build(String name,Gender gender,LocalDate birthDate,Human mother,Human father){
        return new Human(name, birthDate,gender,mother,father);
    }
    public Human build(String name,Gender gender,LocalDate birthDate,LocalDate deathDate,Human mother,Human father){
        return new Human(name, birthDate,deathDate,gender,mother,father);
    }
}
