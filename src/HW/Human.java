package HW;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String surname;
    private String sex;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Human father;
    private Human mother;
    private List<Human> children;
    public Human(String name, String surname, String sex, LocalDate dateOfBirth) {
        this(name, surname, sex, dateOfBirth, null, null, null, new ArrayList<>());
    }
    public Human(String name, String surname, String sex, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        this(name, surname, sex, dateOfBirth, dateOfDeath, null, null, new ArrayList<>());
    }
    public Human (String name, String surname, String sex, LocalDate dateOfBirth, Human father, Human mother) {
        this (name, surname, sex, dateOfBirth, null, father, mother, new ArrayList<>());
    }
    public Human(String name, String surname, String sex, LocalDate dateOfBirth, LocalDate dateOfDeath, Human father, Human mother, List<Human> children) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.father = father;
        this.mother = mother;
        this.children = children;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(Human human) {
        this.children.add(human);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex='" + sex + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfDeath=" + dateOfDeath +
                ", father=" + ((father != null)? father.getName():"Unknown") +
                ", mother=" + ((mother != null)? mother.getName():"Unknown") +
                ", children=" + showChild() +
                '}';
    }

    private String showChild () {
        StringBuilder childResult = new StringBuilder();
        for (Human human : children) {
            childResult.append(human.getName() + " " + human.getSurname() + " ");
        }
        return childResult.toString();
    }
}
