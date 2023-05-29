import java.time.LocalDate;
import java.util.List;

public class Human {
    private Human mother;
    private Human father;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Human(String firstName, String lastName, LocalDate birthDate, Human mother, Human father) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.mother = mother;
        this.father = father;
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

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    @Override
    public String toString() {
        if (mother != null && father != null) {
            return firstName + " " + lastName + " " + birthDate + " (мать: " + mother + ", отец: " + father + ")";
        } else if (mother != null && father == null) {
            return firstName + " " + lastName + " " + birthDate + " (мать: " + mother + ")";
        } else if (mother == null && father != null) {
            return firstName + " " + lastName + " " + birthDate + " (отец: " + father + ")";
        } else {
            return firstName + " " + lastName + " " + birthDate;
        }
    }
}
