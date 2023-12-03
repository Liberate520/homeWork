package ru.home_work.cherevichenko_sergey;

import ru.home_work.cherevichenko_sergey.human.Gender;

import java.time.LocalDate;
import java.util.List;

public class Dog implements  FamilyTreeItem{
    private String name;
    private String lastName;
    private Gender gender;
    private LocalDate birthDay;
    private LocalDate dateDeath;
    private List<Dog> dogs;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public LocalDate getBirthDay() {
        return birthDay;
    }

    @Override
    public LocalDate getDateDeath() {
        return dateDeath;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public List getChildren() {
        return dogs;
    }
}
