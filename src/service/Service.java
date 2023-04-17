package service;

import familyTree.FamilyTree;
import human.Human;

import java.time.LocalDate;

public class Service {
    private int id;
    private FamilyTree familyGroup;

    public Service(FamilyTree familyGroup) {
        this.familyGroup = familyGroup;

    }

    public FamilyTree getFamilyGroup() {
        return familyGroup;
    }

    public void addHuman(String firstName, String lastname, LocalDate dateOfBirth, Human mather, Human father) {
        id++;
        familyGroup.add(new Human(id, firstName, lastname, dateOfBirth, father.getIdMather(), mather.getIdFather()));
    }

    public void addHuman(String firstName, String lastname, LocalDate dateOfBirth) {
        id++;
        familyGroup.add(new Human(id, firstName, lastname, dateOfBirth));
    }

    public void sortByID() {
        familyGroup.sortByID();
    }

    public void sortByLastName() {
        familyGroup.sortByLastName();
    }

    public boolean delHuman(int id) {
        familyGroup.delHuman(id);
        return true;
    }

    public void loadFamilyGroup(String nameFile) {
        familyGroup.loadFamilyGroup(nameFile);
    }

    public Object searchHuman(String lastName) {
        return familyGroup.searchHuman(lastName);
    }
}
