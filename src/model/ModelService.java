package model;

import model.familytree.FamilyTree;
import model.filesaver.FileReaderWriter;
import model.filesaver.Saveable;
import model.human.Gender;
import model.human.Human;
import model.human.HumanCreator;

public class ModelService {
    private FamilyTree<Human> familyTree;
    private Saveable saveable;
    private HumanCreator humanCreator;

    public ModelService() {
        this.familyTree = new FamilyTree();
        this.saveable = new FileReaderWriter();
        this.humanCreator = new HumanCreator();
    }

    public Integer readFamilyTreeFromFile(String path){
       this.familyTree = saveable.read(path);
       return this.familyTree.getSizeOfFamilyTree();
    }

    public boolean writeFamilyTreeInFile(String path) {
      return   saveable.save(this.familyTree, path);
    }

    public void addNewHumanToFamilyTree(Gender gender, String name, String lastName, Integer age ) {
        this.familyTree.addHumanToList(humanCreator.createNewHuman(gender, name, lastName, age));
    }

    public String getFamilyTreeInfo() {
       return this.familyTree.getFamilyTreeInfo();
    }

    public boolean deleteHumanFromFamilyTree(Integer id) {
        return this.familyTree.deleteHumanFromFamilyTree(id);
    }

    public Integer getFamilyTreeSize() {
       return this.familyTree.getSizeOfFamilyTree();
    }
}
