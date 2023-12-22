package model.creatures;

import java.time.LocalDate;

public class HumanBuilder {

    private int id = 0;

    public Human build(String firstName, String lastName, Gender gender,
                       LocalDate birthDate) {
        return new Human(id++, firstName, lastName, gender, birthDate);
    }
}
