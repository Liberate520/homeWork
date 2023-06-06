package members;

import java.time.LocalDate;

public interface FamilyMember {
    String getName();
    Gender getGender();
    int getChildrenAmount();
    LocalDate getBirthday();
    FamilyMember getFather();
    FamilyMember getMother();
    Boolean ContainsChild(FamilyMember child);
    Boolean addChild(FamilyMember child);
}
