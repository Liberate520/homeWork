package model.Dragons;

import model.People.Gender;
import model.People.Person;

public class Dragon extends Person {
    public Dragon(String firstName, String lastName, String birthDate, String deathDate, Gender gender, Person mother, Person father) {
        super(firstName, lastName, birthDate, deathDate, gender, mother, father);
    }

    public Dragon(String firstName, String lastName, String birthDate, String deathDate, Gender gender) {
        super(firstName, lastName, birthDate, deathDate, gender);
    }

    public Dragon(int id, String firstName, String lastName, String birthDate, String deathDate, Gender gender, Person mother, Person father) {
        super(id, firstName, lastName, birthDate, deathDate, gender, mother, father);
    }

    public Dragon(int id, String firstName, String lastName, String birthDate, String deathDate, Gender gender) {
        super(id, firstName, lastName, birthDate, deathDate, gender);
    }
}
