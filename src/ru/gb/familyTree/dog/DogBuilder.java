package ru.gb.familyTree.dog;

import ru.gb.familyTree.Gender;

import java.time.LocalDate;

public class DogBuilder {
    private int id;
    private String nameOfAnimal;
    private String breed;
    private LocalDate dayOfBirth = null;
    private LocalDate dayOfDeath = null;
    private Gender gender;

    public DogBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public DogBuilder setNameOfAnimal(String nameOfAnimal) {
        this.nameOfAnimal = nameOfAnimal;
        return this;
    }

    public DogBuilder setBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public DogBuilder setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
        return this;
    }

    public DogBuilder setDayOfDeath(LocalDate dayOfDeath) {
        this.dayOfDeath = dayOfDeath;
        return this;
    }

    public DogBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Dog createDog() {
        return new Dog(id, nameOfAnimal, breed, dayOfBirth, dayOfDeath, gender);
    }
}