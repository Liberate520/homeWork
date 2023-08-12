import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Person {
    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Person> children;
    private List<Relationship> relationships;

    public Person(int id, String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.children = new ArrayList<>();
        this.relationships = new ArrayList<>();
    }


    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        return deathDate != null ? deathDate.getYear() - birthDate.getYear() : currentDate.getYear() - birthDate.getYear();
    }

    public int getYearsSinceDeath() {
        if (deathDate != null) {
            LocalDate currentDate = LocalDate.now();
            return currentDate.getYear() - deathDate.getYear();
        }
        return 0;
    }

    public boolean isAlive() {
        return deathDate == null;
    }

    public void addRelationship(Relationship relationship) {
        relationships.add(relationship);
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }

    public String getDeathYear() {
        if (deathDate != null) {
            return String.valueOf(deathDate.getYear());
        } else {
            return "N/A"; // Или любое другое значение, указывающее на отсутствие данных о смерти
        }
    }

    public void addRelationship(Person child, RelationshipType type) {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + getFullName() + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", deathDate=" + getDeathYear() +
                '}';
    }

}