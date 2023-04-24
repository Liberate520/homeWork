package model;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

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

    public ArrayList<Human> getHumansList() {
        return activTree.getHumansList();
    }

    public Human getHumanByName(String firstName) {
        return activTree.getHumanByName(firstName);
    }

    public String printTree() {
        return activTree.printTree();
    }

    public void sortByBirthDate() {
        activTree.sortByBirthDate();
    }

    public void sortByName() {
        activTree.sortByName();
    }


    public void saveFile() throws IOException {
        loadFile.save(activTree, "treeOut.out");
    }


    public void readFile() {
        try {
            activTree = loadFile.read("treeOut.out");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
}
