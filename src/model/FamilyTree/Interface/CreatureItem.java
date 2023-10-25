package model.FamilyTree.Interface;

import model.creature.Creature;
import model.creature.Gender;
import model.creature.Interface.*;
import model.creature.methods.Print;

import java.time.LocalDate;
import java.util.List;

public interface CreatureItem<T> extends AddChildren<T>, ParentsInfo<T>, AgeInfo {
    long getId();
    void setId(long id);
    String getName();
    void setName(String name);
    Gender getGender();
    void setGender(Gender gender);
    T getMother();
    void setMother(T mother);
}

