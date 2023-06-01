package tree;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Human {
    private static int global_id;
    private int id;
    private String surName;
    private String name;
    private String secondName;
    private Gender gender;
    private LocalDate birthday;
    private LocalDate die;
    private Human father;
    private Human mother;
    private List<Human> children;


    public Human(int id, String surName, String name, String secondName, Gender gender, LocalDate birthday, LocalDate die, Human father, Human mother, List<Human> children) {
        this.id = id;
        this.surName = surName;
        this.name = name;
        this.secondName = secondName;
        this.gender = gender;
        this.birthday = birthday;
        this.die = die;
        this.father = father;
        this.mother = mother;
        this.children = children;
    }

    public Human() {
        this("Unknown", "Unknown", "Unknown", null, null);
    }


    public String getSurName() {
        return surName;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", father=" + father +
                ", mother=" + mother +
                '}';
    }
}

