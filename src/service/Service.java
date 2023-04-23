package service;

import tree.FamilyTree;
import tree.person.Person;
import tree.person.PersonIterator;
import SaveOrRead.Interf;
import SaveOrRead.SaveAndRead;

import java.time.LocalDate;

public class Service {
    private int id;
    private FamilyTree<Person> familyGroup;

    public Service(FamilyTree familyGroup) {
        this.familyGroup = familyGroup;

    }

    public FamilyTree getFamilyGroup() {
        return familyGroup;
    }

    public void addPerson(String firstName, String lastname, LocalDate dateOfBirth, Person mather, Person father) {
        id++;
        familyGroup.add(new Person(id, firstName, lastname, dateOfBirth, father.getIdMather(), mather.getIdFather()));
    }

    public void addPerson(String firstName, String lastname, LocalDate dateOfBirth) {
        id++;
        familyGroup.add(new Person(id, firstName, lastname, dateOfBirth));
    }

    public void sortByID() {
        familyGroup.sortByID();
    }

    public void sortByLastName() {
        familyGroup.sortByLastName();
    }

    public boolean delPerson(int id) {
        familyGroup.delPerson(id);
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
        for (Person item : this.familyGroup) {
            if (id < item.getId()) id = item.getId();
        }
    }

    public Object searchPerson(String lastName) {
        return familyGroup.searchPerson(lastName);
    }
}