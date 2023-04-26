package src.main.java;
import java.util.ArrayList;

public class Person {
    private String fullName;
    private Gender gender;
    private int birthYear;
    private Person mother;
    private Person father;
    private ArrayList<Person> children;

    public Person(String fullName, Gender gender, int birthYear) {
        this.fullName = fullName;
        this.gender = gender;
        this.birthYear = birthYear;
        children = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void addChild(Person child) {
        children.add(child);
        if (this.gender == Gender.FEMALE) {
            child.setMother(this);
        } else {
            child.setFather(this);
        }
    }
}
