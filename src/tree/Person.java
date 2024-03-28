package tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable{
    private String name;
    private Gender gender;
    private LocalDate birthYear;
    private LocalDate deathYear;
    private Person mother;
    private Person father;

    private List<Person> children;

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }



    public Person(String name, Gender gender, LocalDate birthYear) {
        this.name = name;
        this.gender = gender;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthYear() {
        return birthYear;
    }

    public LocalDate getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(LocalDate deathYear) {
        this.deathYear = deathYear;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }


    @Override
    public String toString() {
        return name + " (" + gender + ") - " + birthYear + (deathYear != null ? "-" + deathYear : "");
    }
}
