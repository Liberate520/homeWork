package GenealogicalTree;

import java.io.*;
import java.util.*;

public class Person_class implements Serializable {
    private String name;
    private String gender;
    private List<Person> children;
    private List<Person> parents;
    private String dateOfBirth;
    private String dateOfDeath;

    public Person_class(String name, String gender, String dateOfBirth, String dateOfDeath) {

    }

    public void Person(String name, String gender, String dateOfBirth, String dateOfDeath) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public List<Person> getChildren() {
        return children;
    }

    public List<Person> getParents() {
        return parents;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public void addParent(Person parent) {
        parents.add(parent);
    }

    public void removeChild(Person child) {
        children.remove(child);
    }

    public void removeParent(Person parent) {
        parents.remove(parent);
    }

    public void addChildren(List<Person> children) {
        this.children.addAll(children);
    }

    public void addParents(List<Person> parents) {
        this.parents.addAll(parents);
    }

    public void removeChildren(List<Person> children) {
        this.children.removeAll(children);
    }

    public void removeParents(List<Person> parents) {
        this.parents.removeAll(parents);
    }
}