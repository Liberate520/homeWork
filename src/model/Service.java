package model;

import model.familytree.FamilyTree;
import model.filesaver.FileReaderWriter;
import model.human.Gender;
import model.human.Human;
import model.human.HumanCreator;

public class Service {
    private FamilyTree<Human> familyTree;
    private FileReaderWriter fileReaderWriter;
    private HumanCreator humanCreator;

    public Service() {
        this.familyTree = new FamilyTree();
        this.fileReaderWriter = new FileReaderWriter();
        this.humanCreator = new HumanCreator();
    }

    public void readFamilyTreeFromFile(String path){
       this.familyTree = fileReaderWriter.read(path);
    }

    public void writeFamilyTreeInFile(String path) {
        fileReaderWriter.save(this.familyTree, path);
    }

    public void addNewHumanToFamilyTree(Gender gender, String name, String lastName, Integer age ) {
        this.familyTree.addHumanToList(humanCreator.createNewHuman(gender, name, lastName, age));
    }

    public String getFamilyTreeInfo() {
       return this.familyTree.getFamilyTreeInfo();
    }

    public void sortFamilyTreeByName() {
        this.familyTree.sortByName();
    }

    public void sortFamilyTreeByAge() {
        this.familyTree.sortByAge();
    }

    public void sortFamilyTreeById() {
        this.familyTree.sortById();
    }

    public void sortFamilyTreeByLastname() {
        this.familyTree.sortByLastname();
    }

    public void setFamilyTree(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }
}
