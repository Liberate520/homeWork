package ru.java_oop.family_tree.human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private int id;
    private String name;
    private String familyName;
    private String surName;
    private Gender gender;
    private LocalDate birthDate;
    private Human mother, father;
    private List<Human> children;
    private Human NullHuman;

    public Human(int id, String name, String familyName, Gender gender, LocalDate birthDate, Human mother, Human father) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
    }

    public Human(int id, String name, String familyName, Gender gender, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.mother = NullHuman;
        this.father = NullHuman;
        this.children = new ArrayList<>();
    }

    public Human(int id, String name, String familyName, String surName, Gender gender, LocalDate birthDate, Human mother, Human father, List<Human> children) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.surName = surName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
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

    public void addChild(Human child){
        this.children.add(child);
    }

    public String getChildrenIDsList(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(this.id).append(", Name: ").append(this.name).append(", Birth date: ").append(this.birthDate);
        if (this.father != NullHuman) {
            sb.append("\nFather ID: ").append(this.father.getId());
        }
        if (this.mother != NullHuman) {
            sb.append(", Mother ID: ").append(this.mother.getId());
        }
        if (!this.children.isEmpty()){
            sb.append("\nChildren list: ").append(this.children);
        }
        return sb.toString();
    }
}
