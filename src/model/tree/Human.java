package model.tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(int id, String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father, List<Human> children) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        this.children = children;
    }

    public Human(int id, String name, Gender gender, LocalDate birthDate) {
        this(id, name, gender, birthDate, null, null, null, new ArrayList<>());
    }

    public Human() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void addChild(Human human) {
        children.add(human);
    }

    @Override
    public String toString() {
        return "\nHuman{" +
                "id = " + id +
                ", name ='" + name + '\'' +
                ", gender = " + gender +
                ", birthDate = " + birthDate +
                ", deathDate = " + deathDate +
                ", children = " + children +
                '}';
    }

    public enum Gender {
        male, female
    }
}
