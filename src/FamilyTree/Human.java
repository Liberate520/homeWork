package FamilyTree;

import FamilyTree.interfaces.TreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Human implements Serializable, Comparable<Human>, TreeItem {
    private String name;
    private int age;
    private Gender gender;
    private Human father;
    private Human mother;

    private ArrayList<Human> childrens;


    public Human(String name, int age, Gender gender, Human father, Human mother) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.childrens = new ArrayList<>();

    }

    public void showChildrens() {
        System.out.println("Childrens: ");

        for (Human children : childrens) {
            System.out.println(children);
        }

        System.out.println();
    }

    @Override
    public void addChild(TreeItem child) {
        this.childrens.add((Human) child);
    }

    public Human getFather() {
        return this.father;
    }

    public Human getMother() {
        return this.mother;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }


    public ArrayList<Human> getChildrens() {
        return this.childrens;
    }

    @Override
    public String toString() {
        return "Имя: " + name + "; Возраст: " + age + "; Отец: " + father + "; Мама: " + mother;
    }

    private Gender getGender() {return gender;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Human)) {
            return false;
        }

        Human human = (Human) obj;
        return human.getName().equals((getName()));
    }

    @Override
    public int compareTo(Human o) {
        return Integer.compare(this.getAge(), o.getAge());
    }
}
