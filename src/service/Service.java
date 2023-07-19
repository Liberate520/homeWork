package service;

import familyTree.FamilyTree;
import human.Human;
import human.HumanIterator;
import saveAndRead.Interf;
import saveAndRead.SaveAndRead;

import java.time.LocalDate;

public class Service {
    private int id;
    private FamilyTree<Human> familyGroup;

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
    public void saveFamilyGroup(String str) {
        SaveAndRead save = new SaveAndRead();
        save.saveFile(this.familyGroup, str);
    }

    public void loadFamilyGroup(String str) {
        Interf load = new SaveAndRead();
        this.familyGroup = load.loadFile(str);
        id = 1;
        for (Human item : this.familyGroup) {
            if (id < item.getId()) id = item.getId();
        }
    }

    public Object searchHuman(String lastName) {
        return familyGroup.searchHuman(lastName);
    }
}