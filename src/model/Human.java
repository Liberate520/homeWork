package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Human implements Serializable, Comparable<Human> {
    private int id;
    private String name;
    private Gender gender;
    private Human father;
    private Human mother;
    private int birthYear;
    private List<Human> children;

    public Human(int id, String name, Gender gender, Human father, Human mother, int birthYear) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
    }

    public Human(int id, String name, Gender gender, int birthYear) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.father = null;
        this.mother = null;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("%d. полное имя: %s; год рождения: %d;\n ",this.id, this.name, this.birthYear);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

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
        return name.compareTo(human.getName());
    }
}