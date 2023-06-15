package models;

import models.members.FamilyMember;

public interface Predicate {
    boolean isEqual(FamilyMember member);
}
