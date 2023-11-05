package ru.gb.familyTree.dog;

import ru.gb.familyTree.Entity;
import ru.gb.familyTree.Gender;

import java.io.Serializable;
import java.time.LocalDate;

public class Dog extends Entity implements Serializable{
    private String nameOfAnimal;//кличка
    private String breed;//порода
    public Dog (int id, String nameOfAnimal, String breed, LocalDate DayOfBirth, LocalDate DayOfDeath, Gender gender){
        super(id, DayOfBirth, DayOfDeath, gender);
        this.setId(id);
        this.setNameOfAnimal(nameOfAnimal);
        this.setBreed(breed);
        this.setDayOfBirth(DayOfBirth);
        this.setDayOfDeath(DayOfDeath);
        this.setGender(gender);
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNameOfAnimal(String nameOfAnimal) {
        this.nameOfAnimal = nameOfAnimal;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public void setDayOfBirth(LocalDate DayOfBirth) {
        this.DayOfBirth = DayOfBirth;
    }
    public void setDayOfDeath(LocalDate DayOfDeath) {
        this.DayOfDeath = DayOfDeath;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public int getId() {
        return id;
    }
    public String getNameOfAnimal() {
        return nameOfAnimal;
    }
    public String getBreed() {
        return breed;
    }
    public LocalDate getDayOfBirth() {
        return DayOfBirth;
    }
    public LocalDate getDayOfDeath() {
        return DayOfDeath;
    }
    public String getGenderString(Gender gender) {
        if (gender == Gender.Female) {
            return "жен.";
        } else {
            return "муж.";
        }
    }

    @Override
    public String toString() {
        return String.format("Собака: %d: %s %s (%s - %s), %s",
                getId(), getNameOfAnimal(), getBreed(), getDayOfBirth(), getDayOfDeath(), getGenderString(gender));
    }
}
