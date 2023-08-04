package model.person;

import model.family_tree.TreeNode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable, Comparable<Person>, TreeNode<Person> {
    private int id;
    private String firstName;
    private String lastName;

    private Gender gender;

    private final LocalDate birthDate;
    private LocalDate deathDate;
    private Person father;
    private Person mother;
    private List<Person> children;

    public Person(String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate, Person father, Person mother) {
        id = -1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public Person(String firstName, String lastName, Gender gender, LocalDate birthDate, Person father, Person mother) {
        this(firstName, lastName, gender, birthDate, null, father, mother);
    }

    public Person(String firstName, String lastName, Gender gender, LocalDate birthDate) {
        this(firstName, lastName, gender, birthDate, null, null, null);
    }

    public boolean addChild(Person child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public int getAge() {
        if (deathDate == null)
            return getPeriod(birthDate, LocalDate.now());
        else
            return getPeriod(birthDate, deathDate);
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public Person getFather() {
        return father;
    }

    public boolean addFather(Person parent) {
        if (parent != null){
            this.father = parent;
            return true;
        }
        return false;
    }

    public Person getMother() {
        return mother;
    }

    public boolean addMother(Person parent) {
        if (parent != null){
            this.mother = parent;
            return true;
        }
        return false;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Person> getChildren() {
        return children;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName(){return firstName + " " + lastName;}

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    @Override
    public List<Person> getParents() {
        List<Person> parents = new ArrayList<>();
        if (getFather() != null) parents.add(getFather());
        if (getMother() != null) parents.add(getMother());
        return parents;
    }

    public void setDeathDate(LocalDate deathDate) {
        deathDate = deathDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + gender + ", " + getAge();
    }

    @Override
    public int compareTo(Person o) {
        return firstName.compareTo(o.firstName);
    }
}
