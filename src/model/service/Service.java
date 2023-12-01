package model.service;

import model.familyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.writer.FileHandler;

import java.time.LocalDate;

public class Service {
    private int idHuman;
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler;

    public Service() {
        familyTree = new FamilyTree<>();
        fileHandler = new FileHandler("default_name");
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
        fileHandler.setFileName(fileName);
        fileHandler.save(familyTree);
    }
    public FamilyTree<Human> loadFamilyTree(String fileName){
        fileHandler.setFileName(fileName);
        familyTree = fileHandler.load();
        return fileHandler.load();
    }

    public void addChild(String parentFirstName, String parentSecondName,  String childFirstName, String childSecondName){
        Human parent = familyTree.getHumanByFullName(parentFirstName, parentSecondName);
        Human child = familyTree.getHumanByFullName(childFirstName, childSecondName);
        parent.addChild(child);
    }
}
