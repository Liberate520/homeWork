package human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private static int counter = 0;
    private int id;
    private String firstName;
    private String lastName;
    private List<Person> children;
    private List<Person> parents;
    private String dateOfBirth;
    private String dateOfDeath;
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

    public List<Person> getChildren() {
        return children;
    }

    public List<Person> getParents() {
        return parents;
    }

    public void addChild(Person child) {
        children.add(child);
        child.addParent(this);
    }

    public void addParent(Person parent) {
        parents.add(parent);
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
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