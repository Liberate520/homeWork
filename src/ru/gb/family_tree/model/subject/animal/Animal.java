package ru.gb.family_tree.model.subject.animal;

import ru.gb.family_tree.model.gender.Gender;
import ru.gb.family_tree.model.subject.human.Human;

import java.time.LocalDate;

// Пример класса, если мы хотим дерево не с людьми
public class Animal extends Human {

    public Animal(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        super(name, gender, birthDate, deathDate, father, mother);
    }

    public Animal(String name, Gender gender, LocalDate birthDate) {
        super(name, gender, birthDate);
    }

    public Animal(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        super(name, gender, birthDate, null, father, mother);
    }
}
