package ru.java_oop.family_tree.service;

import ru.java_oop.family_tree.family_tree.FamilyTree;
import ru.java_oop.family_tree.human.Gender;
import ru.java_oop.family_tree.human.Human;

import java.time.LocalDate;

public class Service {
    private long id;
    private FamilyTree<?> familyTree;

    public Service(FamilyTree<?> familyTree) {
        this.familyTree = familyTree;
    }

    public Human addFamilyMember(String name, Gender gender, LocalDate birthDate) {
        return addFamilyMember(name, gender, birthDate, null, null, null);
    }

    public Human addFamilyMember(String name, Gender gender, LocalDate birthDate, Human mother, Human father) {
        return addFamilyMember(name, gender, birthDate, null, mother, father);
    }

    public Human addFamilyMember(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father) {
        Human human = new Human(id++, name, gender, birthDate, deathDate, mother, father);
        familyTree.addFamilyMember(human);
        return human;
    }

    public String getFamilyTreeInfo() {
        return familyTree.toString();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public boolean setWedding(long entityId1, long entityId2) {
        return familyTree.setWedding(entityId1, entityId2);
    }

}
