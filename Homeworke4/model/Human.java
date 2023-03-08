package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable{
    private String fullName;
    private int yearOfBirth;
    private Human mother;
    private Human father;
    private List<Human> children;
    
    public Human(String fullName, int dateBirth) {
        this(fullName, dateBirth, null, null);
    }

    public Human(String fullName, int dateBirth, Human mother, Human father) {
        this.fullName = fullName;
        this.yearOfBirth = dateBirth;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public Human getMother() {
        return mother;
    }
    public Human getFather() {
        return father;
    }
    public List<Human> getChildren() {
        return children;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setYearOfBirth(int dateBirth) {
        this.yearOfBirth = dateBirth;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public void setChildren(List<Human> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Full name: " + fullName + ", Year of birth: " 
        + yearOfBirth + ", Mother: " + checkMother() + ", Father: " 
        + checkFather() + ", Children: " + checkChildren() + "\n";
        // return "Full name:     " + fullName + "\nYear of birth: " 
        // + yearOfBirth + "\nMother:        " + checkMother() + "\nFather:        " 
        // + checkFather() + "\nChildren:      " + checkChildren() + "\n=======================\n";
    }
    
    public String checkMother() {
        if (mother == null) return " - ";
        else return mother.getFullName();
    }

    public String checkFather() {
        if (father == null) return " - ";
        else return father.getFullName();
    }

    public String checkChildren() {
        if (children.size() != 0) {
            String childrens = children.get(0).getFullName();
            for (int i = 1; i < children.size(); i++)
                childrens += (", " + getFullName());
            return childrens;
        }
        else return " - ";
    }

    public boolean addChild(Human human) {
        if (!children.contains(human)) {
            children.add(human);
            return true;
        }
        else return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Human)) return false;
        Human human = (Human) obj;
        return human.getFullName().equals(getFullName());
    }
}
