package com.pamihnenkov;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Human {


    private String name;
    private String surname;
    private String lastname;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Set<Human> childs = new HashSet<>();
    private Set<Human> parents = new HashSet<>();
    private final Gender gender;


    public Human(String name, String surname, String lastname, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    public String getLastname() {
        return lastname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate(){
        return deathDate;
    }

    public Set<Human> getChilds() {
        return childs;
    }

    public void addChild(Human child) {
        this.childs.add(child);
    }

    public Set<Human> getParents(){
        return parents;
    }

    public void addParent(Human parent){
        if (parents.contains(parent)) return;
        if (parents.size() < 2){
            if (parents.stream().noneMatch(human -> human.gender == parent.gender)) parents.add(parent);
            else throw new IllegalArgumentException("В списке родителей уже есть человек с полом " + parent.gender);
        } else throw new IllegalArgumentException("Список родителей уже содержит обоих родителей");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (!name.equals(human.name)) return false;
        if (!surname.equals(human.surname)) return false;
        if (!lastname.equals(human.lastname)) return false;
        if (!birthDate.equals(human.birthDate)) return false;
        if (!Objects.equals(deathDate, human.deathDate)) return false;
        return gender == human.gender;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + birthDate.hashCode();
        result = 31 * result + (deathDate != null ? deathDate.hashCode() : 0);
        result = 31 * result + gender.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public int getAge(){
        if (deathDate != null) return Period.between(birthDate,deathDate).getYears();
        else return Period.between(birthDate,LocalDate.now()).getYears();
    }
}
