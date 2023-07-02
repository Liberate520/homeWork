import java.time.LocalDate;

public class Human {
    private String fullName;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Gender gender;


    public Human(String fullName, LocalDate dateOfBirth, LocalDate dateOfDeath, Gender gender) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }
}