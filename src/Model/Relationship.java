package Model;

import java.io.Serializable;
import java.util.Objects;

public class Relationship implements Serializable {
    private int person1Id;
    private int person2Id;
    private RelationshipType type;

    public Relationship(int person1Id, int person2Id, RelationshipType type) {
        Objects.requireNonNull(type, "type cannot be null");
        this.person1Id = person1Id;
        this.person2Id = person2Id;
        this.type = type;
    }

    public int getPerson1Id() {
        return person1Id;
    }

    public int getPerson2Id() {
        return person2Id;
    }

    public RelationshipType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Relationship{" +
                "person1Id=" + person1Id +
                ", person2Id=" + person2Id +
                ", type=" + type +
                '}';
    }
}
