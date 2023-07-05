package ru.gb.family_tree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String surname;
    private int birthYear;
    private Integer deathYear;
    private Gender gender;
    private List<Person> parents;
    private List<Person> children;

    public Person(String name, String surname, int birthYear, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.gender = gender;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public Gender getGender() {
        return gender;
    }

    public void addChild(Person child) {
        children.add(child);
        child.addParent(this);
    }

    private void addParent(Person parent) {
        parents.add(parent);
    }

    public List<Person> getChildren() {
        return children;
    }

    public List<Person> getParents() {
        return parents;
    }
}
