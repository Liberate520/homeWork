package FamilyTree.model.Person;

import java.time.LocalDate;

public class PersonBuilder {

    public Person build(int id, String name, String surname, Gender gender, LocalDate burnData, Person mother, Person father) {
        return new Person(id, name, surname, gender, burnData, mother, father );
    }

    public Person build(int id, String name, String surname, Gender gender, LocalDate burnData) {
        return new Person(id, name, surname, gender, burnData, null, null );
    }

    public Person build(int id, String name, String surname, Gender gender) {
        return new Person(id, name, surname, gender, LocalDate.EPOCH, null, null );
    }
}
