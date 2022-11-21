package org.lesson01;

/**
 * Класс описывающий Человека
 * с полями <b>fName</b> - имя, <b>sName</b> - фамилия, <b>bData</b> - отчество, <b>gender</b> - дата рождения
 */
public class Person {
    private final String fName;
    private final String sName;
    private final String bDate;
    private final Gender gender;

    /**
     * Конструктор - создание нового объекта
     */
    public Person(String firstName, String surName, String birthDate, Gender gender) {
        this.fName = firstName;
        this.sName = surName;
        this.bDate = birthDate;
        this.gender = gender;
    }

    public String getFirstName() {
        return this.fName;
    }

    public String getSurName() {
        return this.sName;
    }

    public String getBirthDate() {
        return this.bDate;
    }

    public Gender getGender() {
        return this.gender;
    }

    /**
     * Переопределение вывода экземпляра на печать в виде "Имя Фамилия Дата рождения Пол"
     */
    @Override
    public String toString() {
        return String.format("%s %s %s %s", fName, sName, bDate, gender);
    }
}
