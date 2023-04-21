package src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable{
    private int id;
    private String name;
    private String surname;
    private int born;
    private Human father;
    private Human mother;
    private List<Human> children;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void addChildren(Human child) {
        children.add(child);
    }

    public String getChildren() {
        for (Human human : children) {
            return " " + human.getName();
        }
        return " " + name;
    }

    public Human(int id, String name, Human father, Human mother) {
        this.id = id;
        this.name = name;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public Human(int id, String name) {
        this.id = id;
        this.name = name;
        this.children = new ArrayList<>();
    }

    public String getInfo() {
        if (father == null || mother == null) {
            return name + " имеет ребенка по имени" + getChildren();
        } else if (this.children.size() <= 0)
            return name + " имеет отца по имени " + father.getName() + " и мать по имени " + mother.getName();
        else
            return name + " имеет отца по имени " + father.getName() + " и мать по имени " + mother.getName()
                    + " ,и имеет детей: " + getChildren();
    }


    @Override
    public String toString() {
        return getId() + " " + getName();
    }

}