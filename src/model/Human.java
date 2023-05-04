package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human>, TreeGroupItem {
    private String firstName;
    private String lastName;
    private Integer age;
    private Human mother;
    private Human father;
    private List<Human> childrens;

    public Human(String firstName, String lastName, int age) {this(firstName,
            lastName, age, null, null);}

    public Human(String firstname, String lastname, Integer age, Human mother, Human father) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.age = age;
        this.mother = mother;
        this.father = father;
        childrens = new ArrayList<>();
    }

    @Override
    public int compareTo(Human o) {
       return firstName.compareTo(o.firstName);
    }

    public boolean addChild(Human child) {
        if (!childrens.contains(child)){
            childrens.add(child);
            return true;
        }
        return false;
    }

    public List<Human> getChildrens() {
        return childrens;
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(firstName);
        sb.append(", ");
        sb.append("Фамилия:");
        sb.append(lastName);
        sb.append(", Возраст: ");
        sb.append(age);
        return sb.toString();
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + age + ")";
    }


}