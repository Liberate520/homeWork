package com.pamihnenkov.model;

import com.pamihnenkov.model.enums.Gender;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Human implements Serializable, FamilyTreeMember<Human> {

    @Serial
    private static final long serialVersionUID = 1L;
    private final UUID id;
    private final String name;
    private final String surname;
    private final String lastname;
    private final LocalDate birthDate;
    private final LocalDate deathDate;
    private final Set<Human> childs = new HashSet<>();
    private final Set<Human> parents = new HashSet<>();
    private final Gender gender;

    public Human(UUID id,String name, String surname, String lastname, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
    }


    public void addChild(Human child) {
        this.childs.add(child);
    }

    public void addParent(Human parent){
        if (parents.contains(parent)) return;
        if (parents.size() < 2){
            if (parents.stream().noneMatch(human -> human.gender == parent.gender)) parents.add(parent);
            else throw new IllegalArgumentException("В списке родителей уже есть человек с полом " + parent.gender);
        } else throw new IllegalArgumentException("Список родителей уже содержит обоих родителей");
    }

    public int getAge(){
        if (deathDate != null) return Period.between(birthDate,deathDate).getYears();
        else return Period.between(birthDate,LocalDate.now()).getYears();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (!Objects.equals(name, human.name)) return false;
        if (!Objects.equals(surname, human.surname)) return false;
        if (!Objects.equals(lastname, human.lastname)) return false;
        if (!Objects.equals(birthDate, human.birthDate)) return false;
        if (!Objects.equals(deathDate, human.deathDate)) return false;
        return gender == human.gender;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (deathDate != null ? deathDate.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate='" + birthDate.format(DateTimeFormatter.ISO_LOCAL_DATE) + '\'' +
                '}';
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

    public Set<Human> getParents(){
        return parents;
    }

    public UUID getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }
}
