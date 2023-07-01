package com.britenight;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {
    //region Variables
    private final long id;
    private final List<Person> parents;
    private final List<Person> children;
    private List<Person> spouses;
    private String firstName;
    private String lastName;
    private String middleName;
    private final LocalDate dateOfBirth;
    private Gender gender;
    //endregion

    //region Constructors
    public Person(long id, String firstName, String lastName, String middleName, LocalDate dateOfBirth, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        parents = new ArrayList<>();
        spouses = new ArrayList<>();
        children = new ArrayList<>();
    }
    //endregion

    //region OverrideMethods
    @Override
    public String toString()
    {
        return String.format("%s %s %s, %s, %s", firstName, middleName, lastName, gender, dateOfBirth);
    }
    //endregion

    //region Getters
    public List<Person> getSpouses() {
        return spouses;
    }

    public long getId() {
        return id;
    }

    public List<Person> getParents() {
        return parents;
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

    public String getMiddleName() {
        return middleName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }
    //endregion

    //region Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    //endregion

    //region RelationsManagement
    public void addParent(Person parent)
    {
        parents.add(parent);
    }

    public void addSpouse(Person spouse)
    {
        spouses.add(spouse);
    }

    public void addChild(Person child)
    {
        children.add(child);
    }

    public void removeParent(Person parent)
    {
        parents.remove(parent);
    }

    public void removeSpouse(Person spouse)
    {
        spouses.remove(spouse);
    }

    public void removeChild(Person child)
    {
        children.remove(child);
    }
    //endregion
}
