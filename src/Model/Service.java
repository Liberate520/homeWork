package Model;

import java.io.Serializable;

public class Service<T extends HouseHold> implements Serializable {
    private FileHandler fileHandler;
    private FamilyTree<HouseHold> familyTree;
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

    public void saveTree(FamilyTree<HouseHold> familyTree, String filePath){
        fileHandler.save(familyTree, filePath);
    }

    public void readTree(String filePath){
        familyTree = (FamilyTree<HouseHold>) fileHandler.read(filePath);
    }

}
