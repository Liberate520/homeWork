package homeWork;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Human implements Serializable {
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Gender gender;
    private Human father;
    private Human mother;

    public enum Gender {
        MALE, FEMALE
    }

    public Human(String name, LocalDate dateOfBirth, Gender gender) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public Human(String name, LocalDate dateOfBirth, LocalDate dateOfDeath, Gender gender) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.gender = gender;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        if (dateOfDeath != null) {
            return Period.between(dateOfBirth, dateOfDeath).getYears();
        } else {
            return Period.between(dateOfBirth, currentDate).getYears();
        }
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    @Override
    public String toString() {
        String info = "Name: " + name + ", Gender: " + gender + ", Age: " + getAge();
        if (dateOfDeath != null) {
            info += ", Date of Death: " + dateOfDeath;
        }
        if (father != null) {
            info += ", Father: " + father.getName();
        }
        if (mother != null) {
            info += ", Mother: " + mother.getName();
        }
        return info;
    }
}


