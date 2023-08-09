package human;

import java.io.Serializable;
import java.time.LocalDate;

public class Human implements Serializable {
    private int id;
    private String name;
    private String lastname;
    private LocalDate birthdate;
    private LocalDate deathdate;
    private Gender gender;

    public Human(String name, String lastname, LocalDate birthdate, LocalDate deathdate, Gender gender) {
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.deathdate = deathdate;
        this.gender = gender;
    }

    public Human(String name, String lastname, LocalDate birthdate) {
        this(name, lastname, birthdate, null, null);
    }

    public Human(String name, String lastname, LocalDate birthdate, Gender gender) {
        this(name, lastname, birthdate, null, gender);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public LocalDate getDeathdate() {
    return birthdate;
    }

    public Gender gender() {
    return gender;
    }

    @Override
    public String toString() {
        return "id: " + id + 
        ", name: " + name + 
        ", lastname: " + lastname + 
        ", gender: " + gender + 
        ", birhtdate: " + birthdate + " г.р." +
        ", deathdate: " + deathdate + " г.р.";
    }
}