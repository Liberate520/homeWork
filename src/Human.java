package scr;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String surname;
    private Gender gender;
    private int born;
    private Human father;
    private Human mother;
    private List<Human> children;

    public String getName() {
        return name;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }


    public void addChildren(Human child) {
        children.add(child);
    }

    public void getChildren() {
        System.out.println(children);
    }

    Human(String name, Human father, Human mother) {
        this.name = name;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    Human(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
        if (father == null || mother == null) {
            return name + " имеет ребенка по имени" + children;
        } else if (this.children.size() <= 0)
            return name + " имеет отца по имени " + father.getName() + " ,и мать по имени " + mother.getName();
        else
            return name + " имеет отца по имени " + father.getName() + " ,и мать по имени " + mother.getName()+ " и имеет детей: " + children;
    }

}