package model.human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.human.formatters.HumanChildrenInfo;
import model.human.formatters.HumanFormat;
import model.human.formatters.HumanFullInfo;
import model.human.formatters.HumanShortInfo;
import model.tree.TreeItem;

public class Human implements Serializable, Comparable<Human>, TreeItem<Human> {
    private String name;
    private String surName;
    private String fatherName;
    private Human mother;
    private Human father;
    private List<Human> childrens;
    private Gender gender;
    private int age;

    private Human(String name, String surName, String fatherName, Human mother, Human father,
            ArrayList<Human> childrens, Gender gender, int age) {
        this.name = name;
        this.surName = surName;
        this.fatherName = fatherName;
        this.mother = mother;
        this.father = father;
        this.childrens = childrens;
        this.gender = gender;
        this.age = age;
    }

    public Human(String name, String surName, String fatherName, Human mother, Human father, Gender gender, int age) {
        this(name, surName, fatherName, mother, father, new ArrayList<Human>(), gender, age);
    }

    public Human(String name, String surName, Gender gender, int age) {
        this(name, surName, "", null, null, new ArrayList<Human>(), gender, age);
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Human o) {
        return this.surName.compareTo(o.surName);

    }

    public String getFullInfo() {
        HumanFormat humanFormat = new HumanFullInfo(this);
        return humanFormat.showHumanInfo();
    }

    public String getShortInfo() {
        HumanFormat humanFormat = new HumanShortInfo(this);
        return humanFormat.showHumanInfo();
    }

    public String getFullName() {
        String temp = ((this.fatherName != null && (!this.fatherName.equals(""))) ? " " + this.fatherName : "");
        return this.surName + " " + this.name + temp;
    }

    public List<Human> getChildrens() {

        return this.childrens;
    }

    public String getChildrenInfo() {

        HumanFormat humanFormat = new HumanChildrenInfo(this);
        return humanFormat.showHumanInfo();
    }

    public Human getMother() {
        return this.mother;
    }

    public void addParent(Human human) {
        if (human.getGender().equals(Gender.Male)) {
            this.father = human;
        } else {
            this.mother = human;
        }
    }

    public void removeParent(Human human) {
        if (human.getGender().equals(Gender.Female) && this.mother.equals(human)) {
            this.mother = null;
        } else if (human.getGender().equals(Gender.Male) && this.father.equals(human)) {
            this.father = null;
        }
    }

    public Human getFather() {
        return this.father;
    }

    public Gender getGender() {
        return this.gender;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void addChildren(Human newHuman) {
        List<Human> childrens = getChildrens();
        if (!childrens.contains(newHuman)) {
            childrens.add(newHuman);
            this.childrens = childrens;
        }
    }

    public void removeChildren(Human newHuman) {
        List<Human> childrens = getChildrens();
        if (childrens.contains(newHuman)) {
            childrens.remove(newHuman);
            this.childrens = childrens;
        }
    }

    public String toString() {
        String temp = ((this.fatherName != null && (!this.fatherName.equals(""))) ? " " + this.fatherName : "");
        return this.surName + " " + this.name + temp;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return this.getFullName().equals(human.getFullName());
    }

    public String getSurName() {
        return surName;
    }
}
