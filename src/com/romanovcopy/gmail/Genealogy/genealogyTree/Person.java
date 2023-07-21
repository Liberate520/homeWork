package com.romanovcopy.gmail.Genealogy.genealogyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable{

    private String name; // Имя
    private String patronymic;//Отчество
    private String surname; // Фамилия
    private LocalDate dateOfBirth; // Дата рождения
    private LocalDate dateOfDeath; // Дата смерти
    private Gender gender; // Пол
    private List<Person> children; // Дети
    private List<Person> parents; // Родители
    private MaritalStatus maritalStatus; // Семейное положение
    private String id;



    public Person(String surname, String name, String patronymic, LocalDate dateOfBirth, Gender gender, MaritalStatus maritalStatus) {
        this.name = name;
        this.surname = surname;
        this.patronymic=patronymic;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.maritalStatus = maritalStatus;
        id=createId();
    }

    /**
     * уникальный идентификатор
     * @return
     */
    public String getId(){
        return id;
    }
    /**
     * Имя
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Фамилия
     * @return
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Отчество
     * @return
     */
    public  String getPatronymic(){ return patronymic; }

    /**
     * Дата рождения
     * @return
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Текущий возраст
     * @return
     */
    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    /**
     * пол
     * @return
     */
    public Gender getGender() {
        return gender;
    }
    /**
     * добавить ребенка
     * @param child
     */
    public void addChild(Person child){
        children.add(child);
    }
    /**
     * добавить родителя
     * @param parent
     */
    public void addParent(Person parent) {
        parents.add(parent);
    }
    /**
     * получить всех детей
     * @return
     */
    public List<Person> getChildren() {
        return children;
    }
    /**
     * получить родителей
     * @return
     */
    public List<Person> getParents() {
        return parents;
    }
    /**
     * семейный статус
     * @return
     */
    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }
    /**
     * изменение семейного статуса
     * @param maritalStatus
     */
    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    /**
     * дата смерти
     * @param dateOfDeath
     */
    public void setDateOfDeath(LocalDate dateOfDeath){
        this.dateOfDeath=dateOfDeath;
    }
    /**
     * генерация ключа исходя из текущей даты
     * @return
     */
    private String createId(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        return formattedDateTime;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Id: "+ getId()+"\n").append("Фамилия: "+getSurname()+"\n").append("Имя: "+getName()+"\n").
                append("Отчество: "+getPatronymic()+"\n").append("Дата рождения: "+dateOfBirth+"\n").
                append("Пол: "+gender+"\n").append("Семейное положение: "+maritalStatus+"\n");
        return stringBuilder.toString();
    }


}
