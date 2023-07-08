package human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person<T> implements Serializable {
    private static int counter = 0;
    private int id;
    private String firstName;
    private String lastName;
    private List<Person<T>> children;
    private List<Person<T>> parents;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private String gender;

    public Person(String firstName, String lastName) {
        this.id = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Person<T>> getChildren() {
        return children;
    }

    public List<Person<T>> getParents() {
        return parents;
    }

    public void addChild(Person<T> child) {
        children.add(child);
        child.addParent(this);
    }

    public void addParent(Person<T> parent) {
        parents.add(parent);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int day, int month, int year) {
        this.dateOfBirth = LocalDate.of(year,month,day);
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(int day, int month, int year) {
        this.dateOfDeath = LocalDate.of(year,month,day);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        if (getDateOfDeath() != null) {
            return getId() + ", " + getName() + " " + getLastName() + ", (" + getDateOfBirth() + " - " + getDateOfDeath() + "), " + getGender();
        } else {
            return getId() + ", " + getName() + " " + getLastName() + ", (" + getDateOfBirth() + "), " + getGender();
        }
    }
}