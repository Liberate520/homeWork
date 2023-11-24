package model.service;

import model.familyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.writer.FileHandler;

import java.time.LocalDate;

public class Service {
    private int idHuman;
    private FamilyTree<Human> familyTree;
    private FileHandler saveFileHandler;
    private FileHandler loadFileHandler;

    public Service() {
        familyTree = new FamilyTree<>();
        saveFileHandler = new FileHandler("default_name");
        loadFileHandler = new FileHandler("default_name");
    }

    public void addHuman(String firstName, String lastName, Gender gender, LocalDate born){
        Human human = new Human(idHuman++, firstName, lastName, gender, born);
        familyTree.addHuman(human);
    }

    public Human getHumanByFullName(String firstName, String lastName){
        return familyTree.getHumanByFullName(firstName, lastName);
    }
    public String getFamilyTreeInfo() {
        return familyTree.getFamilyTreeInfo();
    }

    public void sortByFullName(){
        familyTree.sortByFullName();
    }

    public void sortByAge(){
        familyTree.sortByAge();
    }

    public void saveFamilyTree(String fileName){
        saveFileHandler.setFileName(fileName);
        saveFileHandler.save(familyTree);
    }
    public FamilyTree<Human> loadFamilyTree(String fileName){
        loadFileHandler.setFileName(fileName);
        return loadFileHandler.load();
    }
}
