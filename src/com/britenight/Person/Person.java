package com.britenight.Person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Person implements Serializable, Comparable<Object> {
    private final long id;
    private final LocalDate dateOfBirth;
    private String name;
    private Gender gender;

    public Person(long id, String name, LocalDate dateOfBirth, Gender gender) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("%s | %s - %s, %s", id, name, gender, dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfBirth, gender);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Person && this.hashCode() == obj.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        if (this.name.compareTo(((Person) o).getName()) == 0) {
            return this.dateOfBirth.compareTo(((Person) o).getDateOfBirth());
        }
        return this.name.compareTo(((Person) o).getName());
    }

    //region Getters
    public long getId() {
        return id;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public Gender getGender() {
        return gender;
    }
    public String getName() {
        return name;
    }
    //endregion

    //region Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    //endregion
}
