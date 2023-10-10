package Model.builder;

import Model.obj.Gender;
import Model.obj.human.Human;

import java.time.LocalDate;

public class MyHumanBuilder {

    public Human createHuman(String fstName, String lstName, LocalDate bornDate, LocalDate deathDate, Gender gender) {
        return new Human(fstName, lstName, bornDate, deathDate, gender, null, null);
    }
}
