package model;

import java.time.LocalDate;

import model.familyTreeApi.FamilyTree;
import model.familyTreeApi.Human;
import model.familyTreeApi.fileHandler.LoadFile;

public class Service {
    private LoadFile loadFile;
    private FamilyTree<Human> activTree;

    
    public Service(FamilyTree<Human> tree) {
        this.activTree = tree;
        this.loadFile = new LoadFile();
    }


    public void add(String firstName, String secondName, LocalDate birthDate, String sex) {
        activTree.add(new Human(firstName, secondName, birthDate, sex));
    }

    public void deleteByName(String firstName, String lastName) {
        activTree.deleteByName(firstName, lastName);
    }

    public void getHumanByName(String firstName) {
        activTree.getHumanByName(firstName);
    }

    public void printTree() {
        activTree.printTree();
    }

    public void sortByBirthDate() {
        activTree.sortByBirthDate();
    }

    public void sortByName() {
        activTree.sortByName();
    }
    
}
