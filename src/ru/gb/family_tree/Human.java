package ru.gb.family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String gender;
    private LocalDate birthDay;
    private LocalDate deathDay;
    private Human mother;
    private Human father;
    private List<Human> childrens;

    public Human(String surname, String name, String patronymic, String gender, LocalDate birthDay, LocalDate deathDay) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.gender = gender;
        this.birthDay = birthDay;
        this.deathDay = deathDay;
        this.childrens = new ArrayList<>();
    }

    public Human(String surname, String name, String patronymic, String gender, LocalDate birthDay) {
        this(surname, name, patronymic, gender, birthDay, null);
    }

    public Human(String surname, String name, String patronymic, String gender) {
        this(surname, name, patronymic, gender, null, null);
    }

    public int id() {
        return id;
    }

    public String surname() {
        return surname;
    }

    public String name() {
        return name;
    }
    
    public String patronymic() {
        return patronymic;
    }

    public String gender() {
        return gender;
    }

    public LocalDate birthDay() {
        if (birthDay.equals(null)) {
            return LocalDate.of(0, 0, 0);
        }
        return birthDay;
    }

    public LocalDate deathDay() {
        if (deathDay.equals(null)) {
            return LocalDate.of(0, 0, 0);
        }
        return deathDay;
    }

    public Human father() {
        return father;
    }

    public Human mother() {
        return mother;
    }

    public List<Human> childrens() {
        return childrens;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void setDeathDay(LocalDate deathDay) {
        this.deathDay = deathDay;
    }

    public void setMotherInfo(Human mother) {
        this.mother = mother;
    }

    public void setFatherInfo(Human father) {
        this.father = father;
    }

    public void addChildrenInfo(Human children) {
        this.childrens.add(children);
    }

    public void addChildrensInfo(List<Human> childrens) {
        for (Human children : childrens) {
            this.childrens.add(children);
        }
    }

    public void removeChildrenInfo(int childrenId) {
        for (int i = 0; i < childrens.size(); i++) {
            if (childrens.get(i).id() == childrenId) {
                childrens.remove(i);
            }
        }
    }

    public void clearChildrenInfo() {
        childrens.clear();
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Фамилия: " + surname + ", Имя: " + name + ", Отчество: " + patronymic + ", Дата рождения: " + birthDay;
    }

}
