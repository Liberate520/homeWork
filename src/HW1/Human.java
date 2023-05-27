package HW1;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Human father;
    private Human mother;
    List<Human> children;

    public Human(String name) {
        this.name = name;
        this.father = null;
        this.mother = null;
        this.children = new ArrayList<>();
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }


    public void showChildren() {
        if (!children.isEmpty()) {
            System.out.println("Родитель: " + name);
            int count = 1;
            for (Human child : children) {
                System.out.printf("-> Ребенок %d: %s\n", count++, child.getName());
            }
        } else {
            System.out.printf("%s не имеет детей.", name);
        }
    }

    @Override
    public String toString() {
        ArrayList<String> temp = new ArrayList<>();
        for (Human child : children) {
            temp.add(child.getName());
        }
        return "Human{" +
                "name='" + name + '\'' +
                ", father=" + ((father != null) ? father.getName() : "unknown") +
                ", mother=" + ((mother != null) ? mother.getName() : "unknown") +
                ", children=" + temp + "}";

    }
}
