package model;
import java.util.ArrayList;
import java.util.List;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private Person father;
    private Person mother;
    private List<Person> children;

    public Person(String firstName, String lastName, String dateOfBirth, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    @Override
    public int compareTo(Person other) {
        return this.getFirstName().compareTo(other.getFirstName());
    }
}
