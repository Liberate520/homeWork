package Model.Relation;

public enum RelationType {
    Parent, Child, Sibling, Spouse;

    public RelationType getOppositeType() {
        switch (this) {
            case Child:
                return Parent;
            case Parent:
                return Child;
            case Sibling:
                return Sibling;
            case Spouse:
                return Spouse;
        }
        return null;
    }
}
