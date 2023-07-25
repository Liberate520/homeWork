package com.britenight.Person;

import com.britenight.MVP.Presenter.Fabric;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class Person implements Serializable, Comparable<Person> {
    private final long id;
    private String name;
    private Gender gender;
    private final LocalDate dateOfBirth;


    public Person(long id, String name, Gender gender, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }


    //region Getters

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
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

    //region DefaultOverride

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfBirth, gender);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Person && this.hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s | %s - %s, %s", id, name, gender, dateOfBirth);
    }

    @Override
    public int compareTo(Person o) {
        int comp = this.name.compareTo(o.getName());
        if (comp != 0) {
            return comp;
        }
        return this.dateOfBirth.compareTo(o.getDateOfBirth());
    }

    //endregion
}
