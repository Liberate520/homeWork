package ru.gb.family_tree.Family;

import java.util.List;

public class Human {
    private String name;
    private Gender gender;
    private String dateOfBirth;
    private String dateOfDeath;

    public Human(String name, Gender gender,
                 String dateOfBirth, String dateOfDeath){
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Name: " + name + ", Gender: " + gender + ", Date of birth: " + dateOfBirth +
                ", Date of death: " + dateOfDeath;

    }
}