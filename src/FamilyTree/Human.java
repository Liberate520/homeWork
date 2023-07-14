package FamilyTree;

import java.util.List;
import java.io.*;
public class Human implements Serializable{
    private String name;
    private Gender gender;
    private Human father;
    private Human mother;
    List<Human> childrens;
    private int year;

    public Human(String name, Gender gender, int year, Human father, Human mother, List<Human> childrens) {
        this.name = name;
        this.gender = gender;
        this.year = year;
        this.father = father;
        this.mother = mother;
        this.childrens = childrens;
    }

    public Human(String name, Gender gender, int year, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.year = year;
        this.father = father;
        this.mother = mother;
    }
    public Human(String name, Gender gender, int year, List<Human> childrens) {
        this.name = name;
        this.gender = gender;
        this.year = year;
        this.childrens = childrens;
    }

    public String getName() {
        return name;
    }
    public Gender getGender() {
        return gender;
    }
    public Human getFather() {
        return father;
    }
    public Human getMother() {
        return mother;
    }
    public String getFatherStr() {
        return "Отец: " + father.toString();
    }
    public String getMotherStr() {
        return "Мама: " + mother.toString();
    }
    public String getChildren() {
        return "Ребёнок: " + childrens.toString();
    }
    public int getYear() {
        return year;
    }
    @Override
    public String toString() {
        String str;
        str = getName() + " (" + getYear() + ")";
        if (father != null)
            str += ": " + getFatherStr() + ";";
        if (mother != null)
            str += " " + getMotherStr();
        if (childrens != null)
            str += " " + getChildren();
        return str;
    }
}