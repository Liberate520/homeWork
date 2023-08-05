import java.text.ParseException;
import java.time.LocalDate;

public class Dog implements Buffer{
    private String name;
    private LocalDate birthday;

    private LocalDate deathDate;
    private Gender gender;

    public Dog(String name, LocalDate birthday, LocalDate deathDate, Gender gender) throws ParseException {
        this.name = name;
        this.birthday = birthday;
        this.deathDate = deathDate;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthday;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Gender getGender() {
        return gender;
    }
}