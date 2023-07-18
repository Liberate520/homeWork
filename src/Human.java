import java.io.Serializable;
import java.time.LocalDate;

public class Human implements Serializable {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Human mother;
    private Human father;
    private Human children;

    public Human(String firstName, String lastName, LocalDate birthDate, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
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

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }
    public Human getChildren() {
        return children;
    }

    public void setchildren(Human children) {
        this.children = children;
    }
    public int getAge() {
        LocalDate now = LocalDate.now();
        if (deathDate != null && deathDate.isBefore(now)) {
            return deathDate.getYear() - birthDate.getYear();
        } else {
            return now.getYear() - birthDate.getYear();
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (Gender: " + gender + ", Birthdate: " + birthDate + ")";
    }
}
