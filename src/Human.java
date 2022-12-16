
package ForkDZ.OOP_homeWork_1.src;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String gender;
    private Human father;
    private Human mother;
    private Human brotherOrSister;
    private List<Human> brothersOrSisters = new ArrayList<>();

    private List<Human> children = new ArrayList<>();

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Human(String name, String gender, Human father, Human mother, Human brotherOrSister) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        father.children.add(this);
        mother.children.add(this);
        brotherOrSister.brothersOrSisters.add(this);
        this.brothersOrSisters.add(brotherOrSister);
        // System.out.println(brotherOrSister);

    }

    public Human(String name, String gender, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        // this.children = new ArrayList<>();
        father.children.add(this);
        mother.children.add(this);
    }

    public Human(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Human getBrotherOrSister() {
        return brotherOrSister;
    }

    public void setBrotherOrSister(Human brotherOrSister) {
        this.brotherOrSister = brotherOrSister;
    }

    public List<Human> getBrothersOrSisters() {
        return brothersOrSisters;
    }

    public void setBrothersOrSisters(List<Human> brothersOrSisters) {
        this.brothersOrSisters = brothersOrSisters;
    }

    @Override
    public String toString() {
        return name; // + " Пол: " + gender + " Мать: " + mother + " Отец: " + father + "; \n";
    }
}
