package org.genealogy.model.person;

import org.genealogy.model.tree.TreeItem;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements TreeItem, Comparable<Human> {
    private static int counter = 0;
    private int id;
    private String firstName;
    private String lastName;
    private List<Human> children;
    private List<Human> parents;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Gender gender;
    private String extraInfo;

    public Human(String firstName, String lastName) {
        this.id = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int getAge() {
        if(getDateOfBirth() != null) {
            return Period.between(getDateOfBirth(), LocalDate.now()).getYears();
        }
        return 1;
    }

    public void addChild(Human child) {
        children.add(child);
        child.addParent(this);
    }

    public void addParent(Human parent) {
        parents.add(parent);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int day, int month, int year) {
        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(int day, int month, int year) {
        this.dateOfDeath = LocalDate.of(year, month, day);
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    @Override
    public int compareTo(Human o) {
        return firstName.compareTo(o.firstName);
    }

    @Override
    public String toString() {
        if (getDateOfDeath() != null) {
            return getId() + ", " + getName() + " " + getLastName() + ", (" + getDateOfBirth() + " - " + getDateOfDeath() + "), " + getGender() + ", " + getExtraInfo();
        } else {
            return getId() + ", " + getName() + " " + getLastName() + ", (" + getAge() + "), " + getGender() + ", " + getExtraInfo();
        }
    }
}


