package FamilyTree.Person;

import java.time.LocalDate;

public class PersonBuilder {

    public Person build(String name, String surname, Gender gender, LocalDate burnData, Person mother, Person father) {
        return new Person(name, surname, gender, burnData, mother, father );
    }

    public Person build(String name, String surname, Gender gender, LocalDate burnData) {
        return new Person(name, surname, gender, burnData, null, null );
    }

    public Person build(String name, String surname, Gender gender) {
        return new Person(name, surname, gender, LocalDate.EPOCH, null, null );
    }
}
