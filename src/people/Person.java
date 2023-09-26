package people;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private int birthDate;
    private int deathDate;
    private Gender gender;
    private List<Person> husbands;
    private Person mother;
    private Person father;
    private List<Person> children;

    public Person(String name, int birthDate, int deathDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        husbands = new ArrayList<>();
        children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setHusband(List<Person> husbands) {
        this.husbands = husbands;
    }

    public List<Person> getHusbands() {
        return husbands;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getFather() {
        return father;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getMother() {
        return mother;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public List<Person> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return  name + " (" + gender + ")\n" +
                "(" + birthDate + " - " + deathDate + ")\n";
    }

}
