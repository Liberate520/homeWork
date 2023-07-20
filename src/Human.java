import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Human{
    private Gender gender;
    private String firstName;
    private String lastName;
    private String surName;
    private LocalDate dateOfBirth;
//    private int yearOfBirth;


    public Human (String firstName, String lastName, String surName,
                  LocalDate dateOfBirth, Gender gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }


    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurName() {
        return surName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "Имя: " + firstName + "\nФамилия: " + lastName + "\nОтчество: "
                + surName + "\nГод рождения: " + dateOfBirth +
                "\nПол: " + gender;
    }
}
