package model.FamilyTree.Interface;

import model.creature.Creature;
import model.creature.Gender;
import model.creature.Interface.*;
import model.creature.methods.Print;

import java.time.LocalDate;
import java.util.List;

public interface CreatureItem<T> extends AddChildren<T>, ParentsInfo<T>, AgeInfo, PrintInfo{
    long getId();
    void setId(long id);
    String getName();
    Gender getGender();
    void setGender(Gender gender);
}

