package Model.Person;
import Model.FamilyMember;
import Model.Gender;
import java.time.LocalDate;
public class Person extends FamilyMember<PersonData> {
    public Person(int id, String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        super(id, firstName, lastName, gender, birthDate, deathDate, new PersonData(gender));
    }
    // атрибуты и методы, специфичные для класса Person
}
