package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private String name;
    private int age;
    private List<Person> children;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.children = new ArrayList<>();
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public List<Person> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}