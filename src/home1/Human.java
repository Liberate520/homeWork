package home1;

import java.io.Serializable;
import java.util.ArrayList;

public class Human implements Serializable, Comparable<Human> {
    private boolean alive;
    private String name;
    private String sex;
    private int age;
    private ArrayList<Human> children;
    private Human father;
    private Human mother;
    private static final long serialVersionUID = 1L;

    public Human() {
        this.alive = true;
        this.name = "Chad";
        this.sex = "муж";
        this.age = 18;
        children = new ArrayList<>();
        FamilyTree.addFamilyTree(this);
    }

    public Human(boolean alive, String name, String sex, int age, Human father, Human mother) {
        this();
        this.father = father;
        this.mother = mother;
    }

    // Геттеры
    public boolean isAlive() {
        return alive;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    // public void - реализовать логику getChildren при отсутствии детей

    public ArrayList<Human> getChildren() {
        return children;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    // Сеттеры
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }


    public void SaveObj(IO save) {
        save.save("FamilyTree.data", this);
    }


    @Override
    public String toString() {
        return "Human [alive=" + alive + ", name=" + name + ", sex=" + sex + ", age=" + age + ", children=" + children
                + ", father=" + father + ", mother=" + mother + "]";
    }

    @Override
    public int compareTo(Human o) {
        return name.compareToIgnoreCase(o.name);
    }

    

}
