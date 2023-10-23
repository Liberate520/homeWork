package ru.gb.f_tree.human;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Human {
    private final UUID id;
    private final String lastname;
    private final String name;
    private LocalDate birthday;
    private LocalDate deathday;
    private Gender gender;
    private final List<Human> parents;
    private final List<Human> children;
    private Human spouse;

    public Human(String lastname, String name, Gender gender) {
        this.id = UUID.randomUUID();
        this.lastname = lastname;
        this.name = name;
        this.gender = gender;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public int getAge() {
        if (this.deathday == null) {
            return Period.between(this.birthday, LocalDate.now()).getYears();
        } else {
            return Period.between(this.birthday, this.deathday).getYears();
        }
    }

    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return this.lastname + " " + this.name;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setDeathday(LocalDate deathday) {
        this.deathday = deathday;
    }

    public void setParent(Human parent) {
        this.parents.add(parent);
    }

    public void setChild(Human child) {
        this.children.add(child);
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    @Override
    public String toString() {
        return "Фамилия: " + lastname + ", имя: " + name;
    }
}
