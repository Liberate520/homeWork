package Dragons;

import People.Gender;
import People.Person;
import People.TreeElements;

import java.util.List;

public class Dragon extends Person implements TreeElements {
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

    @Override
    public String getTreeInfo() {
        return null;
    }
}
