package com.homeWork.familytreeapp.model;

public class Human implements Person<Human> {
    private String name;
    private int age;
    private String gender;
    private Human parent;

    public Human(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setParent(Human parent) {
        this.parent = parent;
    }

    @Override
    public Human getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Возраст: " + age + ", Пол: " + gender;
    }

    @Override
    public Human createNewInstance(String name, int age, String gender) {
        return new Human(name, age, gender);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Human human = (Human) obj;
        return age == human.age &&
                name.equals(human.name) &&
                gender.equals(human.gender);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        result = 31 * result + gender.hashCode();
        return result;
    }
}


