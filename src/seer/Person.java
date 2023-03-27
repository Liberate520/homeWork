package seer;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private Person father;
    private Person mother;
    private ArrayList<Person> children;

    public Person(String name, int age, Person father, Person mother) {
        this.name = name;
        this.age = age;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public ArrayList<Person> getAllChildren() {
        ArrayList<Person> allChildren = new ArrayList<>();
        for (Person child : children) {
            allChildren.add(child);
            allChildren.addAll(child.getAllChildren());
        }
        return allChildren;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }
}