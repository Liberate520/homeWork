package person;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import tree.Gender;



public class Person implements Serializable{
    private int id;
    private String firstName;
    private String lastname;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private int idMather;
    private int idFather;

    public Person(int id, String firstName, String lastname, LocalDate dateOfBirth, Gender gender2, int idMather, int idFather) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.deathDate = null;
        this.gender = gender;
        this.idMather = idMather;
        this.idFather = idFather;
    }


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public Gender getGender() {
        return gender;
    } 

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public int getIdMather() {
        return idMather;
    }

    public int getIdFather() {
        return idFather;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public int getAge() {
        LocalDate currenDate = LocalDate.now();
        if (getDeathDate() == null)
            return Period.between(birthDate, currenDate).getYears();
        else
            return Period.between(birthDate, deathDate).getYears();
    }

    @Override
    public String toString() {
        if (deathDate != null) {
            return "id %d, %s %s дата рождения - %s' Дата смерти - %s'".formatted(id, firstName, lastname, birthDate, deathDate);
        }
        return "id %d, %s %s дата рождения - %s".formatted(id, firstName, lastname, birthDate);
    }

}