package com.romanovcopy.gmail_Genealogy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name; // Имя
    private String surname; // Фамилия
    private LocalDate dateOfBirth; // Дата рождения
    private LocalDate dateOfDeath; // Дата смерти

    private Gender gender; // Пол
    private List<Person> children; // Дети
    private List<Person> parents; // Родители
    private MaritalStatus maritalStatus; // Семейное положение



    public Person(String name, String surname, LocalDate dateOfBirth, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.maritalStatus = MaritalStatus.SINGLE;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void addChild(Person child){
        children.add(child);
    }

    public void addParent(Person parent) {
        parents.add(parent);
    }

    public List<Person> getChildren() {
        return children;
    }

    public List<Person> getParents() {
        return parents;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ").append(name).append(" ").append(surname).append("\n");
        stringBuilder.append("Date of Birth: ").append(dateOfBirth).append("\n");
        stringBuilder.append("Gender: ").append(gender).append("\n");
        stringBuilder.append("Marital Status: ").append(maritalStatus).append("\n");
        return stringBuilder.toString();
    }
}
