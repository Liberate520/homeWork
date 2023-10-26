package ru.gb.family_tree.person;

import java.util.ArrayList;

public class Person {
    private final String name;
    private final Gender gender;
    private final ArrayList<Person> children;
    private final ArrayList<Person> parents;

    /**
     * Конструктор
     * @param name: Имя
     * @param gender: Пол
     */
    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }


    /**
     * Добавление ребенка
     * @param child: Ребенок
     */
    public void addChild(Person child) {
        if (!children.contains(child)) {
            children.add(child);
        }

        // добавление родителя ребенку при добавлении ребенка этому человеку
        if (!child.getParents().contains(this)) {
            child.addParent(this);
        }
    }

    /**
     * Добавление родителя
     * @param parent: Родитель
     */
    public void addParent(Person parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
        }

        // добавление ребенка родителю при добавлении родителя этому человеку
        if (!parent.getChildren().contains(this)) {
            parent.addChild(this);
        }
    }

    public ArrayList<Person> getChildren() {return children;}

    public ArrayList<Person> getParents() {return parents;}

    public String getName() {return name;}

    public Gender getGender() {return gender;}

    @Override
    public String toString() {
        return getName() + ", " + getGender();
    }
}
