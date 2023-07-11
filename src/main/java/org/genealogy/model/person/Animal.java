package org.genealogy.model.person;

import org.genealogy.model.tree.TreeItem;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Animal implements TreeItem, Comparable<Animal>{
    private String firstName;
    private List<Animal> children;
    private List<Animal> parents;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Gender gender;

    public Animal(String firstName) {
        this.firstName = firstName;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }
    @Override
    public String getName() {
        return firstName;
    }

    @Override
    public int getAge() {
        return Period.between(LocalDate.now(), getDateOfBirth()).getYears();
    }

    public void addChild(Animal child) {
        children.add(child);
        child.addParent(this);
    }

    public void addParent(Animal parent) {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public int compareTo(Animal o) {
        return firstName.compareTo(o.firstName);
    }
}


