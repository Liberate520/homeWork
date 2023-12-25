package ru.gb.family_tree.model.human;

import java.time.LocalDate;

public class HumanBuilder {
    public Human build(String name, Gender gender, LocalDate birthDate) {
        return new Human(name, gender, birthDate);
    }
}
