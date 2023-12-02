package ru.gb.family_tree;

import java.time.LocalDate;

public class Human {
    Gender gender;
    LocalDate birthDate;
    Human mother, father;
    Lest<Human> children;
}
