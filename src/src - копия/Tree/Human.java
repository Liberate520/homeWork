package Tree;

import java.io.Serializable;

public class Human implements Serializable,Comparable<Human> {
    private String name;
    private int age;
    private String gender;
    private Human father;
    private Human mother;

    public Human(String name, int age, String gender, Human father, Human mother) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
    }

    public Human(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;


    }

    public Human() {
        this.name = "Базовое имя";

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", father=" + father +
                ", mother=" + mother +
                '}';
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}
