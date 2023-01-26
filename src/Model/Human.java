package Seminars_OOP.HW_7.src.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Human implements Serializable, Comparable<Human> {
    private String name;
    private int yearOfBirth;
    private String gender;
    private Human father;
    private Human mother;
    private List<Human> childrenList;

    public Human(String name, int yearOfBirth, String gender, Human father, Human mother) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.father = (Human) father;
        this.mother = (Human) mother;
        this.childrenList = new ArrayList<Human>();
    }

    public Human(String name, int yearOfBirth, String gender) {
        this(name, yearOfBirth, gender, null, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return childrenList;
    }

    public void setChildren(List<Human> childrenList) {
        this.childrenList = childrenList;
    }

    public static void addChild(Human human) {
        if (human.father != null) {
            human.father.childrenList.add(human);
        }
        if (human.mother != null) {
            human.mother.childrenList.add(human);
        }
    }

    @Override
    public String toString() {
        return name + ": " + yearOfBirth + ", (" + gender + ")";
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.getName());
    }

    public static class ComparatorByAge implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
            return Integer.compare(o1.getYearOfBirth(), o2.getYearOfBirth());
        }

    }
}
