package com.pamihnenkov.view;

import com.pamihnenkov.model.FamilyTreeMember;

import java.util.Collection;

public interface View {
    void start();
    void finish();

    void addNewMember();
    void addRelativeForPerson();
    void getBrothersAndSister();
    void showAllMembers();
    void getSortedByBirthdate();
    void getSortedByAge();


}
