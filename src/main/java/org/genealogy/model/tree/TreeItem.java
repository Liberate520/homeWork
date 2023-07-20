package org.genealogy.model.tree;

import org.genealogy.model.person.Gender;
import org.genealogy.model.person.Human;

public interface TreeItem {
    String getName();
    int getAge();

    int getId();

    void addChild(Human child);

    void setDateOfBirth(int day, int month, int year);

    void setDateOfDeath(int day, int month, int year);

    void setGender(Gender gender);
}