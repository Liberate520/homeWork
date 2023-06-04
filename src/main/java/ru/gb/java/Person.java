package ru.gb.java;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Person implements Serializable {
    String name;
    String dateOfBirth;
    String dateOfDeath;

    public Person(String name, String dateOfBirth, String dateOfDeath) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    public Person() {
    }

    public Person(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = "";
    }

    public Person addPerson() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите ФИО: ");
        String name = sc.next();
        System.out.print("Введите дату рождения: ");
        String dateOfBirth = sc.next();

        System.out.print("Введите дату смерти: ");
        String dateOfDeath = sc.next();
        return new Person(name, dateOfBirth, dateOfDeath);
    }

    public void addMultiplePersons(List<Person> listPerson) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество человек для добавления: ");
        int count = sc.nextInt();

        for (int i = 1; i <= count; i++) {
            listPerson.add(addPerson());
        }
    }

    @Override
    public String toString() {
        return "ФИО: " + name + " дата рождения: " + dateOfBirth + " дата смерти: " + dateOfDeath;
    }
}
