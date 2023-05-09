package model;

import model.familytree.FamilyTree;
import model.filesaver.FileReaderWriter;
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

    public FamilyTree readFamilyTreeFromFile(String path){
       return fileReaderWriter.read(path);
    }

    public void writeFamilyTreeInFile(String path) {
        fileReaderWriter.write(this.familyTree, path);
    }

    public void addNewHumanToFamilyTree() {
        this.familyTree.addHumanToList(humanCreator.createNewHuman());
    }

    public void getFamilyTreeInfo() {
        for (Human human : familyTree) {
            System.out.println(human.getGeneralInfo());
        }
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
