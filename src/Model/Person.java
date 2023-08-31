package Model;

import java.time.LocalDate;

public class Person extends FamilyMember {
    private Gender gender;

    public Person(int id, String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        super(id, firstName, lastName, gender, birthDate, deathDate);
    }

    // Additional attributes, methods specific to humans...
}
