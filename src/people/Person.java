package people;

import serialization.FileHandler;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person extends FileHandler {
    private int id;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private List<Person> husbands;
    private Person mother;
    private Person father;
    private List<Person> children;

    public Person(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        id = -1;
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        husbands = new ArrayList<>();
        children = new ArrayList<>();
    }

    public Person (String name, LocalDate birthDate, Gender gender) {
        this(name, birthDate, null, gender);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return  "\t" + name + " (" + gender + ")\n" +
                "\t(" + birthDate.getYear() + " - " + deathDate.getYear() + ")\n";
    }

}
