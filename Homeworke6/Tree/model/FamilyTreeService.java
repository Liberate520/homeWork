package model;

import model.components.FamilyTree;
import model.components.Human;
import model.fileManager.FileHandler;
import model.fileManager.Writable;

public class FamilyTreeService implements Service {
    private final Writable fileHandler;
    private FamilyTree<Human> familyTree;

    public FamilyTreeService() {
        this.fileHandler = new FileHandler("FamilyTree");
        familyTree = new FamilyTree<>();
    }

    @Override
    public String outputAList() {
        return familyTree.getInfo();
    }

    @Override
    public String searchByName(String name) {
        return familyTree.getByName(name).getInfo();
    }
    
    @Override
    public void load() {
        familyTree = (FamilyTree<Human>) fileHandler.load();
    }

    @Override
    public void save() {
        fileHandler.save(familyTree);
    }

    @Override
    public void sortAlfab() {
        familyTree.sortByName();
    }

    @Override
    public void sortYear() {
        familyTree.sortByAge();
    }

    @Override
    public boolean addHuman(String fullName, String dateBirth, String motherName, String fatherName) {
        Human father = familyTree.getByName(fatherName);
        Human mother = familyTree.getByName(motherName);
        Human child = new Human(fullName, dateBirth, father, mother);
        return familyTree.add(child);    
    }

    @Override
    public boolean deletePerson(String name) {
        return familyTree.deletePerson(familyTree.getByName(name));
    }
}
