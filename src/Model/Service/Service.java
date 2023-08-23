package Model.Service;

import Model.FamilyTree.FamilyTree;
import Model.FamilyTree.FileHandler;
import Model.BaseCharacter.BaseCharacter;

import java.io.Serializable;

public class Service<T extends BaseCharacter> implements Serializable {
    private FileHandler fileHandler;
    private FamilyTree<BaseCharacter> familyTree;
    public Service(){
        fileHandler = new FileHandler();
        familyTree = new FamilyTree<>();
    }

    public void printTree(){
        familyTree.print();
    }

    public FamilyTree getFamilyTree(){
        return familyTree;
    }

    public void add(T houseHold) {
        familyTree.add(houseHold);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void saveTree(FamilyTree<BaseCharacter> familyTree, String filePath){
        fileHandler.save(familyTree, filePath);
    }

    public void readTree(String filePath){
        familyTree = (FamilyTree<BaseCharacter>) fileHandler.read(filePath);
    }

}
