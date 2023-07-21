package family_tree;

import java.time.LocalDate;
import java.time.Period;

public class Human {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private int age;
    private FamilyStatus familyStatus;



    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, FamilyStatus familyStatus){
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.familyStatus = familyStatus;
        this.age = Period.between(dateOfDeath, dateOfBirth).getYears();
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public Gender getGender(Gender gender) {
        return gender;
    }

    public LocalDate setDateOfBirth(LocalDate dateOfBirth){
        return dateOfBirth;
    }
    public LocalDate getDateOfDeath(LocalDate dateOfDeath){
        return dateOfDeath;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", dateOfBirth: " + dateOfBirth  + ",age : " + age + ",familyStatus: " + familyStatus;
    }
}
