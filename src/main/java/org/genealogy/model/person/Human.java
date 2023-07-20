package org.genealogy.model.person;

import org.genealogy.model.tree.TreeItem;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements TreeItem, Comparable<Human>, Serializable {
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
        this.firstName = firstName;
        this.lastName = lastName;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
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

    @Override
    public void addChild(Human child) {
        children.add(child);
        child.addParent(this);
    }

    public String getChildren() {
        StringBuilder str = new StringBuilder();
        str.append("Список ID детей: ");
        for (Human child : children) {
            str.append(child.getId()).append(", ");
        }
        return str.toString();
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
            return "ID: " + getId() + ", " + getName() + " " + getLastName() + ", Годы жизни: (" + getDateOfBirth() + " - " + getDateOfDeath() + "), Пол: " + getGender() + ", Дополнительная информация: " + getExtraInfo() + ", " + getChildren();
        } else {
            return "ID: " + getId() + ", " + getName() + " " + getLastName() + ", Возраст: (" + getAge() + "), Пол: " + getGender() + ", Дополнительная информация: " + getExtraInfo() + ", " + getChildren();
        }
    }
}


