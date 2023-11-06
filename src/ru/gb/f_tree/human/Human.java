package ru.gb.f_tree.human;

import ru.gb.f_tree.f_mem.FamilyMember;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.time.Period.between;

public class Human implements Serializable, FamilyMember, Nameble {
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


    public String getAge() {
        return String.valueOf(between(this.birthday, Objects.requireNonNullElseGet(this.deathday, LocalDate::now)).getYears());
    }

    private int toString(int years) {
        return years;
    }

    public UUID getId() {
        return id;
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
    @Override
    public String getName() {
        return getFullName();
    }

    @Override
    public String getFullName() {
        return null;
    }

    @Override
    public List<FamilyMember> getParents() {
        return parents.stream().map(parent -> (FamilyMember) parent).collect(Collectors.toList());
    }
}
