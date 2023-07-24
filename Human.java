import java.util.*;
import java.text.*;
import java.io.*;
import java.time.LocalDate;

public class Human implements Serializable {
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
            this.dateOfBirth = dateOfBirth;
            this.status = status;
    }

    public Human() {
    }

    @Override
    public String toString() {
        return  " имя - " + name +
                ", пол - " + gender +
                ", дата рождения - " + dateOfBirth.toString();
    }

    public String getDob() {
        return dob;
    }
    public String getName() {
        return name;
    }
    public Gender getGender() {
        return gender;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
