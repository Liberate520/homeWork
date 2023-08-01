package Model;

import java.time.Period;
import java.io.*;
import java.time.LocalDate;


public class Human implements Serializable{
    private String dob; // дата рождения
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private String status;

    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, String status) {
            this.name = name;
            this.gender = gender;
            this.dateOfBirth = dateOfBirth;
            this.dateOfDeath = dateOfDeath;
            this.status = status;
    }
    public Human() {
    }

    @Override
    public String toString() {
        return  "Имя - " + name +
                ", пол - " + gender +
                ", дата рождения - " + dateOfBirth.toString();
    }

    public String getDob() {
        return dateOfBirth.toString();
    }
    public int getAge(){
        if (dateOfDeath == null){
            return Period.between(dateOfBirth, LocalDate.now()).getYears();
        } else {
            return Period.between(dateOfBirth, dateOfDeath).getYears();
        }
    }
    public String getName() {
        return name;
    }
    public Gender getGender() {
        return gender;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(Gender gender) {
        this.gender = gender; }
    public void setAge(LocalDate date){
        this.dateOfBirth = date; }
    public void setDateOfDeath(LocalDate date){
        this.dateOfDeath = date; }
    public void setStatus(String status){
        this.status = status; }
}
