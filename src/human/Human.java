package human;

import java.io.Serializable;
import java.time.LocalDate;

public class Human implements Serializable {
    private long id;
    private String name;
    private String lastname;
    private LocalDate birthdate;
    private LocalDate deathdate;
    private Gender gender;
    private int age;

    public Human(Long id, String name, String lastname, LocalDate birthdate, LocalDate deathdate, Gender gender, Integer age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.deathdate = deathdate;
        this.gender = gender;
        this.age = age;
    }

    public Human(String name, String lastname, LocalDate birthdate) {
        this(null, name, lastname, birthdate, null, null, null);
    }

    public Human(String name, String lastname, LocalDate birthdate, Gender gender) {
        this(null, name, lastname, birthdate, null, gender, null);
    }

    public Human(Long id, String name, Integer age) {
        this(id, name, null, null, null, null, age);
    }

    // public int getId() {
    //     return id;
    // }

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

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "id: " + id + 
        ", name: " + name + 
        ", lastname: " + lastname + 
        ", gender: " + gender + 
        ", birhtdate: " + birthdate + " г.р." +
        ", deathdate: " + deathdate + " г.р." + 
        ", age: " + age + " лет";
    }
}