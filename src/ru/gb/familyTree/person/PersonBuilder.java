package ru.gb.familyTree.person;

import ru.gb.familyTree.tree.FamilyTree;

import java.time.LocalDate;

public class PersonBuilder {
    private int id;
    private String firstName;
    private String secondName = "";
    private String lastName = "";
    private LocalDate startDay = null;
    private LocalDate stopDay = null;
    private Gender gender = Gender.Male;

    public PersonBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public PersonBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }
    public PersonBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder setStartDay(LocalDate startDay) {
        this.startDay = startDay;
        return this;
    }

    public PersonBuilder setStopDay(LocalDate stopDay) {
        this.stopDay = stopDay;
        return this;
    }

    public PersonBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Person createPerson() {
        return new Person(id, firstName, secondName, lastName, startDay, stopDay, gender);
    }
}