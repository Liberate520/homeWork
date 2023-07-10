import java.time.LocalDate;
import java.util.List;

public class Human {
    Gender gender;
    LocalDate birthDate;
    LocalDate deathDate;
    Human father, mother;
    List<Human> children;
}
