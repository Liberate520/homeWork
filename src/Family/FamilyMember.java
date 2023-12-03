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
    Human getMother();
    Human getFather();
    Gender getGender();
    List getChildrens();

    LocalDate getBirthData();

    void setDeathData(LocalDate deathData);
}
