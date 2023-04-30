package model.familytree;

import model.human.Gender;

public interface FamilyTreeItem {
    String getName();
    Integer getAge();
    String getLastname();
    Gender getGender();
    Integer getId();
}
