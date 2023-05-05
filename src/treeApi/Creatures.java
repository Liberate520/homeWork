package src.treeApi;

import java.util.ArrayList;
import java.util.List;

public class Creatures implements GetInfo {
    private String name;
    private Creatures father;
    private Creatures mother;
    private List<Creatures> children = new ArrayList<>();
    private int id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Creatures getFather() {
        return father;
    }

    public Creatures getMother() {
        return mother;
    }

    public void setFather(Creatures father) {
        this.father = father;
    }

    public void setMother(Creatures mother) {
        this.mother = mother;
    }

    public void addChildren(Creatures child) {
        children.add(child);
    }

    @Override
    public String getInfo() {
        return "Hello";
    }
}
