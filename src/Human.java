package src;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String surname;
    private Gender gender;
    private int born;
    private Human father;
    private Human mother;
    private List<String> children;

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

    public void addChildren(String child) {
        children.add(child);
    }

    public List getChildren() {
        return children;
    }

    public Human(String name, Human father, Human mother) {
        this.name = name;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public Human(String name) {
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
            return name + " имеет отца по имени " + father.getName() + " ,и мать по имени " + mother.getName()
                    + " и имеет детей: " + children;
    }

}