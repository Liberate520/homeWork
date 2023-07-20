package ru.geekbrains.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Человек, обязательно имеющий имя, фамилию, пол и дату рождения. Может иметь
 * дату смерти, отца, мать и детей.
 */
public class Human implements Serializable {

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
     * Дата рождения человека.
     */
    private LocalDate birthDate;

    /**
     * Дата смерти человека.
     */
    private LocalDate deathDate;

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

    public Human(String name, String surname, Sex sex, LocalDate birthDate,
                 LocalDate deathDate, Human father, Human mother,
                 ArrayList<Human> children) {
        if (name.isEmpty()) {
            throw new RuntimeException("Не введено имя.");
        }

        if (surname.isEmpty()) {
            throw new RuntimeException("Не введена фамилия.");
        }

        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        this.children = children;
    }

    public Human(String name, String surname, Sex sex, LocalDate birthDate,
                 Human father, Human mother, ArrayList<Human> children) {
        this(name, surname, sex, birthDate, null, father, mother, children);
        if (name.isEmpty()) {
            throw new RuntimeException("Не введено имя.");
        }

        if (surname.isEmpty()) {
            throw new RuntimeException("Не введена фамилия.");
        }
    }

    public Human(String name, String surname, Sex sex, LocalDate birthDate) {
        this(name, surname, sex, birthDate, null, null, null);
        if (name.isEmpty()) {
            throw new RuntimeException("Не введено имя.");
        }

        if (surname.isEmpty()) {
            throw new RuntimeException("Не введена фамилия.");
        }
    }

    public Human() {
        this(null, null, null, null);
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
     * Возвращает дату рождения человека.
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Устанавливает дату рождения человека.
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Возвращает дату смерти человека.
     */
    public LocalDate getDeathDate() {
        return deathDate;
    }

    /**
     * Устанавливает дату смерти человека.
     */
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
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
    public void addChild(Human child) {
        children.add(child);
    }

    /**
     * Устанавливает детей человека.
     */
    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }

    /**
     * Возвращает возраст человека.
     */
    public int getAge() {
        if (deathDate == null) {
            return LocalDate.now().getYear() - birthDate.getYear();
        }
        return deathDate.getYear() - birthDate.getYear();
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", name, surname, sex, birthDate);
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
               sex == human.sex && birthDate == human.birthDate;
    }
}
