package model.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable{
    private String fullName;
    private String yearOfBirth;
    private Human mother;
    private Human father;
    private List<Human> children;
    
    public Human(String fullName, String dateBirth) {
        this(fullName, dateBirth, null, null);
    }

    public Human(String fullName, String dateBirth, Human mother, Human father) {
        this.fullName = fullName;
        this.yearOfBirth = dateBirth;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Full name: " + fullName);
        sb.append(", Year of birth: " + yearOfBirth);
        sb.append(", Mother: " + checkMother());
        sb.append(", Father: " + checkFather());
        sb.append(", Children: " + checkChildren() + "\n");
        return sb.toString();
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
        StringBuilder res = new StringBuilder();
        if (children.size() != 0) {
            res.append(children.get(0).getFullName());
            for (int i = 1; i < children.size(); i++)
                res.append(", " + getFullName());
            return res.toString();
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

    public void removeMother() {
        mother = null;
    }

    public void removeFather() {
        father = null;
    }

    public  void removeChild(Human human) {
        children.remove(human);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Human)) return false;
        Human human = (Human) obj;
        return human.getFullName().equals(getFullName());
    }

    public String getFullName() {
        return fullName;
    }
    public String getYearOfBirth() {
        return yearOfBirth;
    }
    public Human getMother() {
        return mother;
    }
    public Human getFather() {
        return father;
    }
    public List<Human> getChildren() {
        return this.children;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
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
}
