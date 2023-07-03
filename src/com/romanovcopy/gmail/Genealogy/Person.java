package com.romanovcopy.gmail.Genealogy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name; // Имя
    private String patronymic;//Отчество
    private String surname; // Фамилия
    private LocalDate dateOfBirth; // Дата рождения
    private LocalDate dateOfDeath; // Дата смерти

    private Gender gender; // Пол
    private List<Person> children; // Дети
    private List<Person> parents; // Родители
    private MaritalStatus maritalStatus; // Семейное положение



    public Person(String name, String surname, String patronymic, LocalDate dateOfBirth, Gender gender, MaritalStatus maritalStatus) {
        this.name = name;
        this.surname = surname;
        this.patronymic=patronymic;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.maritalStatus = maritalStatus;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    public  String getPatronymic(){ return patronymic; }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
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
        stringBuilder.append("Фамилия: ").append(getSurname()).append("\n").append("Имя: ").
                append(getName()).append("\n").append("Отчество: ").append(getPatronymic()).append("\n");
        stringBuilder.append("Дата рождения: ").append(dateOfBirth).append("\n");
        stringBuilder.append("Пол: ").append(gender).append("\n");
        stringBuilder.append("Семейное положение: ").append(maritalStatus).append("\n");
        return stringBuilder.toString();
    }
}
