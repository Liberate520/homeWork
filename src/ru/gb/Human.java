package ru.gb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Human {

//    private int id;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human parent1, parent2;
    private Gender gender;
    private List<Human> children = new LinkedList<>();



    public Human(String name, LocalDate birthDate,
                 LocalDate deathDate, Human parent1,
                 Human parent2, Gender gender, List<Human> children) {
//        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.gender = gender;
        this.children = (children !=null) ? children :new ArrayList<>();

        if (parent1!=null){
            parent1.addChild(this);
        }
        if (parent2!=null){
            parent2.addChild(this);
        }
    }
    public String getName(){return name;}
    public LocalDate getBirthDate(){return birthDate;}
    public LocalDate getDeathDate(){return deathDate;}

    public Human getParent1() {
        return parent1;
    }
    public Human getParent2() {
        return parent2;
    }
    public Gender getGender() {
        return gender;
    }

    public List<Human> getChildren() {
        return children;
    }
    public  void addChild(Human child){
        children.add(child);
    }

    @Override
    public String toString() {
        StringBuilder childrenNames = new StringBuilder();
        for (Human child : children) {
            if (childrenNames.length() > 0) {
                childrenNames.append(", ");
            }
            childrenNames.append(child.getName());
        }
        return
                "ФИО: " + name +
                ", Дата рождения: " + birthDate +
                ", Дата смерти: " + (deathDate !=null ? deathDate.toString(): "null") +
                ", Родитель 1: " + (parent1 != null ? parent1.getName() : "null") +
                ", Родитель 2: " + (parent2 != null ? parent2.getName() : "null") +
                ", Пол: " + (gender==Gender.Male? "Мужской": "Женский") +
                ", Дети: " + (childrenNames.isEmpty() ? "null":childrenNames) + ".";

    }
}
