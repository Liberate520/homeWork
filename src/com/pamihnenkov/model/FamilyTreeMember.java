package com.pamihnenkov.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;
import java.util.UUID;

public interface FamilyTreeMember<T> {

    void addChild(T child);
    void addParent(T parent);
    int getAge();
    String getName();
    String getSurname();
    String getLastname();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    Set<T> getChilds();
    Set<T> getParents();
    UUID getId();
}
