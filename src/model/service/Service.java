package model.service;

import model.person.Gender;
import model.person.Person;

import java.time.LocalDate;

public interface Service {
    String getFamilyInfo();
    String getPersonInfo(int id);
    void createNewFamilyTree(String familyName);
    void createCustomTree();
    void addInFamily(String name, LocalDate birthDate, Gender gender);
    void addDeathDate(int id, LocalDate deathDate);
    void getMarried(int husbandID, int wifeID);
    void getChild(int childID, int fatherID, int motherID);
    void saveFamilyTree();
    void downloadFamilyTree(String name);
    void sortByName();
    void sortByBirthDate();
    Person findByID(int id);
    int getTreeSize();
}
