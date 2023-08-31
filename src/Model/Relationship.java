package Model;

import java.io.Serializable;
import java.util.Objects;

public class Relationship implements Serializable {
    private FamilyMember familyMember1;
    private FamilyMember familyMember2;
    private RelationshipType type;

    public Relationship(FamilyMember familyMember1, FamilyMember familyMember2, RelationshipType type) {
        Objects.requireNonNull(familyMember1, "familyMember1 cannot be null");
        Objects.requireNonNull(familyMember2, "familyMember2 cannot be null");
        Objects.requireNonNull(type, "type cannot be null");


        this.familyMember1 = familyMember1;
        this.familyMember2 = familyMember2;
        this.type = type;
    }

    public FamilyMember getPerson1() {
        return familyMember1;
    }

    public FamilyMember getPerson2() {
        return familyMember2;
    }

    public RelationshipType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Model.Relationship{" +
                "familyMember1=" + familyMember1.getFullName() +
                ", familyMember2=" + familyMember2.getFullName() +
                ", type=" + type +
                '}';
    }
}