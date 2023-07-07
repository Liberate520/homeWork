package ru.gb.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> childs;

    public Human(String surname, String name, String patronymic, String gender, LocalDate birthDate, LocalDate deathDate) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.childs = new ArrayList<>();
    }

    public Human(String surname, String name, String patronymic, String gender, LocalDate birthDate) {
        this(surname, name, patronymic, gender, birthDate, null);
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

    public LocalDate birthDate() {
        if (birthDate.equals(null)) {
            return LocalDate.of(0, 0, 0);
        }
        return birthDate;
    }

    public LocalDate deathDate() {
        if (deathDate.equals(null)) {
            return LocalDate.of(0, 0, 0);
        }
        return deathDate;
    }

    public Human father() {
        return father;
    }

    public Human mother() {
        return mother;
    }

    public List<Human> childs() {
        return childs;
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

    public void setbirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setdeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setMotherInfo(Human mother) {
        this.mother = mother;
    }

    public void setFatherInfo(Human father) {
        this.father = father;
    }

    public void addChildInfo(Human child) {
        this.childs.add(child);
    }

    public void addChildInfo(List<Human> childs) {
        for (Human child : childs) {
            this.childs.add(child);
        }
    }

    public void removeChildInfo(int childId) {
        for (int i = 0; i < childs.size(); i++) {
            if (childs.get(i).id() == childId) {
                childs.remove(i);
            }
        }
    }

    public void clearChildInfo() {
        childs.clear();
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Фамилия: " + surname + ", Имя: " + name + ", Отчество: " + patronymic + ", Дата рождения: " + birthDate;
    }

}
