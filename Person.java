import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {
    private LocalDate birthDate;
    private LocalDate deathDate;
    protected String firstname;
    private String surname;
    private String patronymic;
    private Gender gender;

    public Person(Gender gender, String surename, String firstname, String patronymic, LocalDate birthDate, LocalDate deathDate) {
        this.firstname = firstname;
        this.surname = surename;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

	public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    
    public String getInfo(){
        return String.format("Полное имя: %s %s %s Дата рождения: %s Дата смерти: %s", surname, firstname, patronymic, birthDate, deathDate);
    }

}