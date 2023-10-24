package ru.gb.human;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Human {
    private String name;
    private Gender gender;
    private LocalDate bornDate;
    private Human father;
    private Human mother;

    public Human(String name, Gender gender, Human father, Human mother, String bornDate) {
        this.name = name;
        this.gender = gender;
        this.bornDate = LocalDate.parse(bornDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.father = father;
        this.mother = mother;
    }

    public Human(String name, Gender gender, String bornDate) {
        this.name = name;
        this.gender = gender;
        this.bornDate = LocalDate.parse(bornDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getFather() {
        return father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getMother() {
        return mother;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ")
                .append(name)
                .append("\n")
                .append("Gender: ")
                .append(gender)
                .append("\n");
        if (father != null) {
            sb.append("Father: ")
                    .append(father.getName())
                    .append("\n");
        }
        if (mother != null) {
            sb.append("Mother: ")
                    .append(mother.getName())
                    .append("\n");
        }
        sb.append("Birthday: ")
                .append(bornDate)
                .append("\n");
        return sb.toString();
    }
}
