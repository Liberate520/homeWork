import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String firstName;
    private final String lastName;

    private final Gender gender;

    private final LocalDate birthDate;
    private final Person father;
    private final Person mother;
    private List<Person> children = new ArrayList<>();

    public Person(String firstName, String lastName, Gender gender, LocalDate birthDate, Person father, Person mother) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.father = father;
        this.mother = mother;
        this.father.children.add(this);
        this.mother.children.add(this);
    }

    public Person(String firstName, String lastName, Gender gender, LocalDate birthDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.father = null;
        this.mother = null;
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }

    public List<Person> getChildren() {
        return children;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + gender;
    }
}
