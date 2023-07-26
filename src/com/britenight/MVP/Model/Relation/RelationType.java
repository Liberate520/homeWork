package com.britenight.MVP.Model.Relation;

public enum RelationType {
    Parent, Child;

    public RelationType getOppositeType() {
        if (this == Child) {
            return Parent;
        } else {
            return Child;
        }
    }
}
