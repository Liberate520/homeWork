package Model.Service;

import Model.BaseCharacter.Gender;
import Model.BaseCharacter.Human;
import Model.FamilyTree.FamilyTree;
import Model.FamilyTree.FileHandler;
import Model.BaseCharacter.BaseCharacter;

import java.io.Serializable;

public class Service<T extends BaseCharacter>{
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

    public void add(String name, int age, Gender gender) {
        familyTree.add(new Human(name, age, gender));
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
