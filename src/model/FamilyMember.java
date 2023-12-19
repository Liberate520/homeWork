package model;

import java.util.List;

public interface FamilyMember {
    String getFirstName();
    String getLastName();
    String getDateOfBirth();
    String getGender();

    void addChild(FamilyMember child);

    FamilyMember getFather();
    void setFather(FamilyMember father);

    FamilyMember getMother();
    void setMother(FamilyMember mother);

    List<FamilyMember> getChildren();
}