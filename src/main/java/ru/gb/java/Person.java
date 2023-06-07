package ru.gb.java;

import java.io.Serializable;
import java.util.*;

public class Person implements Serializable, IterablePerson {
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

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "ФИО: " + name + " дата рождения: " + dateOfBirth + " дата смерти: " + dateOfDeath + "\n";
    }

    @Override
    public void sortedNamePerson(List<Person> listPerson) {
        int sizeList = listPerson.size();
        for (int i = 0; i < sizeList - 1; i++) {
            for (int j = 0; j < sizeList - i - 1; j++) {
                Person p1 = listPerson.get(j);
                Person p2 = listPerson.get(j + 1);
                if (p1.getName().compareToIgnoreCase(p2.getName()) > 0) {
                    listPerson.set(j, p2);
                    listPerson.set(j + 1, p1);
                }
            }
        }
        System.out.println("Отсортированный список по имени:");
        for (Person obj : listPerson) {
            System.out.println(obj.getName() + " дата рождения:  " + obj.getDateOfBirth());
        }
    }

    @Override
    public void sortedDatePerson(List<Person> listPerson) {
        int sizeList = listPerson.size();
        for (int i = 0; i < sizeList - 1; i++) {
            for (int j = 0; j < sizeList - i - 1; j++) {
                Person p1 = listPerson.get(j);
                Person p2 = listPerson.get(j + 1);
                if (p1.getDateOfBirth().compareToIgnoreCase(p2.getDateOfBirth()) > 0) {
                    listPerson.set(j, p2);
                    listPerson.set(j + 1, p1);
                }
            }
        }
        System.out.println("Отсортированный список по дате рождения:");
        for (Person obj : listPerson) {
            System.out.println(obj.getName() + " дата рождения:  " + obj.getDateOfBirth());
        }
    }
}