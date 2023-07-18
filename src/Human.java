import java.util.Calendar;
import java.util.Date;

public class Human {
    private String firstName;
    private String lastName;
    private String surName;
    private int yearOfBirth;


    public Human (String firstName, String lastName, String surName, int yearOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.yearOfBirth = yearOfBirth;
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

    public int getDateOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return "Имя: " + firstName + "\nФамилия: " + lastName + "\nОтчество: "
                + surName + "\nГод рождения: " + yearOfBirth + "\n";
    }
}
