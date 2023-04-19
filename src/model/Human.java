package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human> {
    private int id;
    private String fullName;
    private Gender gender;
    private Human father;
    private Human mother;
    private int birthYear;
    private List<Human> children;

    public Human(int id, String fullName, Gender gender, Human father, Human mother, int birthYear) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
    }

    public Human(int id, String fullName, Gender gender, int birthYear) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.father = null;
        this.mother = null;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("id : %d; полное имя: %s; год рождения: %d;\n ", this.id, this.fullName, this.birthYear);
    }

    public String getFullName() {
        return fullName;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public int getId() { return id; }

    public int getBirthYear() {
        return birthYear;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        int ageParentMin = 18;
        if (child.getBirthYear() > this.getBirthYear() + ageParentMin) {
            this.children.add(child);
        } else {
            System.out.printf("Ошибка!!! Родители не могут быть моложе %s лет \n", ageParentMin);
        }
    }

    @Override
    public int compareTo(Human human) {
        return fullName.compareTo(human.getFullName());
    }
}
