package family_tree.model.service;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.human.Kinship;
import family_tree.model.save_file.FileHandlerInnterface;
import family_tree.model.tree.FamilyTree;

public class Service implements Serializable{
    private int id;
    private String path;

    private ConvertListToString<Human> convertListToString;
    private FileHandlerInnterface<FamilyTree<Human, Kinship>> fileHandler;
    private FamilyTree<Human, Kinship> familyTree;

    public Service(String path, FileHandlerInnterface<FamilyTree<Human, Kinship>> fileHandler){
        this.convertListToString = new ConvertListToString<>();
        this.fileHandler = fileHandler;
        this.familyTree = new FamilyTree<>();
        this.path = path;
    }

    public void addHuman (String name, String surName, String patronymic, Gender gender, LocalDate dateOfBirth,
                    LocalDate dateOfDeath) {
        familyTree.addHuman(new Human(id++, name, surName, patronymic, gender, dateOfBirth, dateOfDeath));
    }

    public void removeHuman(int id) {
        familyTree.removeHuman(familyTree.getHumanById(id));
    }

    public void addKinship (int humanId, int humanKinshipId, Kinship kinship) {   
        familyTree.getHumanById(humanId).addKinship(familyTree.getHumanById(humanKinshipId), kinship);
    }

    public String getSibling(int id) {
        return convertListToString.convert(familyTree.getBySibling(familyTree.getHumanById(id)));
    }

    public String getChildren(int id) {
        return convertListToString.convert(familyTree.getHumanById(id).getChildren());

    }

    public String getParents(int id) {
        return convertListToString.convert(familyTree.getHumanById(id).getParents());
    }

    public String getFamilyTreeInfo() {
        return convertListToString.convert(familyTree.getFamilyList());
    }
    
    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void sortByName() {
        familyTree.sortByName();
    }
    
    public void sortBySurname() {
        familyTree.sortBySurname();
    }

    public void sortByPatronymic() {
        familyTree.sortByPatronymic();
    }

    public boolean fileSave() {
        try {
            fileHandler.writeToFile(familyTree, path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean fileRead() {
        try {
            familyTree = fileHandler.readFromFile(path);
            return true;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}