package ru.geekbrains.family_tree;

import java.time.YearMonth;
import java.util.ArrayList;

/**
 * Человек, обязательно имеющий имя, фамилию, пол и год рождения. Может иметь
 * отца, мать и детей.
 */
public class Human {

    /**
     * Имя человека.
     */
    private String name;

    /**
     * Фамилия человека.
     */
    private String surname;

    /**
     * Пол человека.
     */
    private Sex sex;
       
    /**
     * Год рождения человека.
     */
    private int birthYear;

    /**
     * Отец человека.
     */
    private Human father;

    /**
     * Мать человека.
     */
    private Human mother;

    /**
     * Дети человека.
     */
    private ArrayList<Human> children;

    public Human(String name, String surname, Sex sex, int birthYear,
                 Human father, Human mother, ArrayList<Human> children) {
        if (name.isEmpty()) {
            throw new RuntimeException("Не введено имя.");
        }

        if (surname.isEmpty()) {
            throw new RuntimeException("Не введена фамилия.");
        }

        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.birthYear = birthYear;
        this.father = father;
        this.mother = mother;
        this.children = children;
    }

    public Human(String name, String surname, Sex sex, int birthYear) {
        if (name.isEmpty()) {
            throw new RuntimeException("Не введено имя.");
        }

        if (surname.isEmpty()) {
            throw new RuntimeException("Не введена фамилия.");
        }

        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.birthYear = birthYear;
    }

    /**
     * Возвращает имя человека.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя человека.
     */
    public void setName(String name) {
        if (name.isEmpty()) {
            throw new RuntimeException("Не введено имя.");
        }
        this.name = name;
    }

    /**
     * Возвращает фамилию человека.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Устанавливает фамилию человека.
     */
    public void setSurname(String surname) {
        if (surname.isEmpty()) {
            throw new RuntimeException("Не введена фамилия.");
        }
        this.surname = surname;
    }

    /**
     * Возвращает пол человека.
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * Устанавливает пол человека.
     */
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    /**
     * Возвращает год рождения человека.
     */
    public int getBirthYear() {
        return birthYear;
    }

    /**
     * Устанавливает год рождения человека.
     */
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    /**
     * Возвращает отца человека.
     */
    public Human getFather() {
        return father;
    }

    /**
     * Устанавливает отца человека.
     */
    public void setFather(Human father) {
        this.father = father;
    }

    /**
     * Возвращает мать человека.
     */
    public Human getMother() {
        return mother;
    }

    /**
     * Устанавливает мать человека.
     */
    public void setMother(Human mother) {
        this.mother = mother;
    }

    /**
     * Возвращает детей человека.
     */
    public ArrayList<Human> getChildren() {
        if (this.children.size() == 0) {
            System.out.println("Детей нет.");
        }
        return children;
    }

    /**
     * Добавляет ребёнка человека.
     */
    void addChild(Human child) {
        children.add(child);
    }

    /**
     * Устанавливает детей человека.
     */
    void setChildren(ArrayList<Human> children) {
        this.children = children;
    }

    /**
     * Возвращает возраст человека.
     */
    int getAge() {
        return YearMonth.now().getYear() - birthYear;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %d", name, surname, sex, birthYear);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Human human = (Human) object;
        return name == human.name && surname == human.surname &&
               sex == human.sex && birthYear == human.birthYear;
    }
}
