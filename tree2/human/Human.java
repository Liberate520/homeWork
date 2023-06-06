package homeWork.tree2.human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;

public class Human implements Serializable, Comparable<Human>, HumanObjectInterface {
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
        this(name, birthdate, null, null, new ArrayList<>());
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

    @Override
    public String getName() {
        return this.name;
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

    public int getAge() {
        int i = LocalDate.now().getYear() - this.getBirthdate().getYear();
        return i; }

    public ArrayList<Human> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return name + ": " + this.getBirthdate();
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.getName());
    }

}
