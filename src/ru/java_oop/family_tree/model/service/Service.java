package ru.java_oop.family_tree.model.service;

import ru.java_oop.family_tree.model.family_tree.FamilyTree;
import ru.java_oop.family_tree.model.family_tree.FamilyTreeItem;
import ru.java_oop.family_tree.model.human.Gender;
import ru.java_oop.family_tree.model.human.Human;

import java.time.LocalDate;

public class Service {
    private long id;
    private FamilyTree<?> familyTree;

    public Service() {
        this.familyTree = new FamilyTree<>();
    }

    public FamilyTreeItem<?> addHumanFamilyMember(String name, Gender gender, LocalDate birthDate) {
        return addHumanFamilyMember(name, gender, birthDate, null, null, null);
    }

    public FamilyTreeItem<?> addHumanFamilyMember(String name, Gender gender, LocalDate birthDate, Human mother, Human father) {
        return addHumanFamilyMember(name, gender, birthDate, null, mother, father);
    }

    public FamilyTreeItem<?> addHumanFamilyMember(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father) {
        FamilyTreeItem<?> familyTreeItem = new Human(id++, name, gender, birthDate, deathDate, mother, father);
        familyTree.addFamilyMember(familyTreeItem);
        return familyTreeItem;
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

    public FamilyTree<?> getFamilyTreeAsObject() {
        return this.familyTree;
    }

    public void setFamilyTree(FamilyTree<?> familyTree) {
        this.familyTree = familyTree;
    }
}
