package Family;

import Human.Human;
import Human.Gender;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

public interface FamilyMember {
    String fullInfo();
    int getAge();
    String getName();
    String getFamilyName();
    FamilyMember getMother();
    FamilyMember getFather();
    Gender getGender();
    List<FamilyMember> getChildrens();

    LocalDate getBirthData();

    void setDeathData(LocalDate deathData);
}
