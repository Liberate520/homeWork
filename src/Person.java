import java.util.ArrayList;
import java.util.List;

class Person {
    private String firstName;
    private String lastName;
    private Gender gender;
    private int birthYear;
    private int deathYear;
    private List<Person> children;
    private List<Relationship> relationships;

    public Person(String firstName, String lastName, Gender gender, int birthYear, int deathYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.children = new ArrayList<>();
        this.relationships = new ArrayList<>();
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public int getAge() {
        int currentYear = java.time.Year.now().getValue();
        return deathYear > 0 ? deathYear - birthYear : currentYear - birthYear;
    }

    public int getYearsSinceDeath() {
        if (deathYear > 0) {
            int currentYear = java.time.Year.now().getValue();
            return currentYear - deathYear;
        }
        return 0;
    }

    public boolean isAlive() {
        return deathYear == -1;
    }

    public void addRelationship(Person person, RelationshipType type) {
        relationships.add(new Relationship(this, person, type));
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }
    public void addParent(Person parent, RelationshipType type) {
        parent.addChild(this);
        this.addRelationship(parent, type);
    }

    public void addSpouse(Person spouse) {
        this.addRelationship(spouse, RelationshipType.SPOUSE);
        spouse.addRelationship(this, RelationshipType.SPOUSE);
    }
}