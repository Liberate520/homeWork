package model.people;

import model.family.FamilyMember;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements FamilyMember<Human> {
    private final String name;
    private final String familyName;
    private final Gender gender;
    private final LocalDate birthData;
    private LocalDate deathData;
    private Human mother;
    private Human father;
    private final List<Human> childrens;

    public Human(String name, String familyName, Gender gender, LocalDate birthData, Human mother, Human father) {
        this.name = name;
        this.familyName = familyName;
        this.gender = gender;
        this.birthData = birthData;
        this.childrens = new ArrayList<>();
        if (mother != null && isGenderCorrect(mother, Gender.female)) {
            this.mother = mother;
            addChildren(mother);
        }
        if (father != null && isGenderCorrect(father, Gender.male)) {
            this.father = father;
            addChildren(father);
        }

    }

    private void addChildren(Human human) {
        if (!human.childrens.contains(this)) {
            human.childrens.add(this);
        }
    }
    private boolean isGenderCorrect(Human human, Gender gender) {
        return human.getGender().equals(gender);
    }

    public String fullInfo() {
        return name + " " + familyName +
                ", Дата рождения: " + birthData +
                ", Дата смерти: " + deathData +
                ", Возраст: " + getAge() +
                ", Мать " + mother +
                ", Отец " + father +
                ", Дети " + childrens;
    }

    public int getAge() {
        return getPeriod(birthData, Objects.requireNonNullElseGet(deathData, LocalDate::now));
    }
    private int getPeriod (LocalDate birthData, LocalDate data) {
        return Period.between(birthData, data).getYears();
    }
    public String getName() {
        return name;
    }
    public String getFamilyName() {
        return familyName;
    }
    public Human getMother() {
        return mother;
    }
    public Human getFather() {
        return father;
    }
    public Gender getGender() {
        return gender;
    }
    public List<Human> getChildrens() {
        return childrens;
    }
    public LocalDate getBirthData() {
        return birthData;
    }

    public void setDeathData(LocalDate deathData) {
        this.deathData = deathData;
    }

    @Override
    public String toString() {
        return name + " " + familyName;
    }
}

