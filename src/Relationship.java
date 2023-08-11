import java.util.Objects;

class Relationship {
        private Person person1;
    private Person person2;
    private RelationshipType type;

    public Relationship( Person person1, Person person2, RelationshipType type) {
        Objects.requireNonNull(person1, "person1 cannot be null");
        Objects.requireNonNull(person2, "person2 cannot be null");
        Objects.requireNonNull(type, "type cannot be null");


        this.person1 = person1;
        this.person2 = person2;
        this.type = type;
    }

    public Person getPerson1() {
        return person1;
    }

    public Person getPerson2() {
        return person2;
    }

    public RelationshipType getType() {
        return type;
    }
}