package ru.gb.familyTree;

import java.io.Serializable;
import java.time.LocalDate;

public class Entity implements Serializable {
    public int id;
    public LocalDate DayOfBirth;// дата рождения
    public LocalDate DayOfDeath;// дата смерти
    public Gender gender;// пол

    public Entity (int id, LocalDate DayOfBirth, LocalDate DayOfDeath, Gender gender){
        this.id = id;
        this.DayOfBirth = DayOfBirth;
        this.DayOfDeath = DayOfDeath;
        this.gender = gender;
    }
}
