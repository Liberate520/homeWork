package ru.gb.family_tree;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Human {
    String name;
    private int age;
    Gender gender;
    LocalDate birthDate;
    LocalDate deathDate;

    Human mother, father;
    List<Human> children;

    public Human(String name, LocalDate bDate, LocalDate dDate, Gender gender) {
        this.name = name;
        this.birthDate = bDate;
        this.deathDate = dDate;
        age = getAge();
    }

    public Human(String name, LocalDate bDate,Gender gender) {
        this.name = name;
        this.birthDate = bDate;
        this.deathDate = null;
        age = getAge();
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        if (deathDate != null) {
            return Period.between(birthDate, deathDate).getYears();
        } else {
            return Period.between(birthDate, currentDate).getYears();
        }
    }
    String getName(){
        return name;
    }
}

