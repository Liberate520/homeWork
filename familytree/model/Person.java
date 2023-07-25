package homeWork_oop.familytree.model;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String firstName;
    private String lastName;


    private LocalDate birthday;
    private LocalDate dayOfDeath;
    private String fatherFirstName;
    private String fatherLastName;
    private String motherFirstName;
    private String motherLastName;
    
    public Person() {
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    

    

    
    public String getFatherFirstName() {
        return fatherFirstName;
    }
    
    public void setFatherFirstName(String fatherFirstName) {
        this.fatherFirstName = fatherFirstName;
    }
    
    public String getFatherLastName() {
        return fatherLastName;
    }
    
    public void setFatherLastName(String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }
    
    public String getMotherFirstName() {
        return motherFirstName;
    }
    
    public void setMotherFirstName(String motherFirstName) {
        this.motherFirstName = motherFirstName;
    }
    
    public String getMotherLastName() {
        return motherLastName;
    }
    
    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public LocalDate getDateBirthday(){return birthday;}
    public int getAge() {
        if (dayOfDeath == null) {
            return getPeriod(birthday, LocalDate.now());
        } else {
            return getPeriod(birthday, dayOfDeath);
        }
    }

    private int getPeriod(LocalDate birthday, LocalDate dayOfDeath) {
        Period diff = Period.between(birthday, dayOfDeath);
        return diff.getYears();
    }
    public void setBirthday(String dateBirthday){
        LocalDate birthday = LocalDate.parse(dateBirthday);
        this.birthday = birthday;
    }


    @Override
    public String toString() {
        return "Person{" +
                "Имя: '" + firstName + '\'' +
                ", Фамилия: '" + lastName + '\'' +
                ", Дата рождения: " + birthday +
                ", Имя отца: '" + fatherFirstName + '\'' +
                ", Фамилия отца: '" + fatherLastName + '\'' +
                ", Имя матери: '" + motherFirstName + '\'' +
                ", Фамилия матери: '" + motherLastName + '\'' +
                ", Возраст: '" + getAge() + '\'' +
                '}';
    }
}