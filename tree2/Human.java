package homeWork.tree2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Human {
    private String name;
    private LocalDate birthdate;
    private Human mother;
    private Human father;
    private ArrayList<Human> children;


    public Human(String name, LocalDate birthdate, Human mother, Human father, ArrayList<Human> children) {
        this.name = name;
        this.birthdate = birthdate;
        this.mother = mother;
        this.father = father;
        this.children = children;
    }

    public Human(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
        this.mother = null;
        this.father = null;
        this.children = new ArrayList<>();
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public ArrayList<Human> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return name;
    }
}
