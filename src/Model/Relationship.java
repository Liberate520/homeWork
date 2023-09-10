package Model;

import java.io.Serializable;

public class Relationship implements Serializable {
    private FamilyMember person1;
    private FamilyMember person2;
    private RelationshipType type;
    public Relationship(FamilyMember person1, FamilyMember person2, RelationshipType type) {
        this.person1 = person1;
        this.person2 = person2;
        this.type = type;
    }
    public FamilyMember getPerson1() {
        return person1;
    }
    public FamilyMember getPerson2() {
        return person2;
    }
    public RelationshipType getType() {
        return type;
    }
    @Override
    public String toString() {
        return person1.getFullName() + " - " + type + " - " + person2.getFullName();
    }
}
