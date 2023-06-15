package models.members;

import java.time.LocalDate;

public interface FamilyMember {
    String getName();
    Gender getGender();
    int getChildrenAmount();
    LocalDate getBirthday();
    FamilyMember getFather();
    FamilyMember getMother();
    void setName(String name);
    void setGender(Gender gender);
    void setBirthday(LocalDate birthday);
    void setFather(FamilyMember father);
    void setMother(FamilyMember mother);
    void addChild(FamilyMember child);
    void removeChild(FamilyMember child);
}
