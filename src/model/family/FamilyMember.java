package model.family;

import model.human.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyMember<T> extends Serializable {
    String fullInfo();
    int getAge();
    String getName();
    String getFamilyName();
    T getMother();
    T getFather();
    Gender getGender();
    List<T> getChildrens();

    LocalDate getBirthData();

    void setDeathData(LocalDate deathData);
}
