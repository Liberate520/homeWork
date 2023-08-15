package homeWork.familytree;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;



    // Constructor with name, date of birth, and gender
    public Human(String name, LocalDate dateOfBirth, Gender gender) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    // Additional constructor with name, date of birth, date of death, and gender
    public Human(String name, LocalDate dateOfBirth, LocalDate dateOfDeath, Gender gender) {
        this(name, dateOfBirth, gender);
        this.dateOfDeath = dateOfDeath;
    }



    // Method to calculate the age of the person
    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        if (dateOfDeath != null) {
            return Period.between(dateOfBirth, dateOfDeath).getYears();
        } else {
            return Period.between(dateOfBirth, currentDate).getYears();
        }
    }

    // Method to add a child to the person's children list
    public void addChild(Human child) {
        children.add(child);
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



