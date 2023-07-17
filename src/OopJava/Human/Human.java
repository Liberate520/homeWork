package OopJava.Human;

import java.util.List;
import java.io.*;
public class Human implements Serializable{
    private String name;
    private Gender gender;
    private Human father;
    private Human mother;
    List<Human> kids;
    private int year;

    public Human(String name, Gender gender, int year, Human father, Human mother, List<Human> kids) {
        this.name = name;
        this.gender = gender;
        this.year = year;
        this.father = father;
        this.mother = mother;
        this.kids = kids;
    }

    public Human(String name, Gender gender, int year, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.year = year;
        this.father = father;
        this.mother = mother;
    }
    public Human(String name, Gender gender, int year) {
        this.name = name;
        this.gender = gender;
        this.year = year;
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
        return "father - " + father;
    }
    public String getMotherStr() {
        return "mother - " + mother;
    }
    public String getChild() {
        return "children - " + kids.toString();
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
        if (kids != null)
            str += " " + getChild();
        return str;
    }
}
