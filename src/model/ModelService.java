package model;

import model.project.User;
import model.fileProcessing.FileHandler;
import model.project.FamilyTree;

public class ModelService<T extends User> {
    private FileHandler<T> fileHandler;
    private FamilyTree<T> familyTree;
    
    public ModelService() {
        this.fileHandler = new FileHandler<>();
    }

    // Начало работы с FamilyTree
    public void createNewTree() {
        this.familyTree = new FamilyTree<>();
    }

    public void addTreeElement(String name, String sex, Integer yearOfbirth, String father, String mother) {
        this.familyTree.add((T) new User(name, sex, yearOfbirth, familyTree.getHuman(father), familyTree.getHuman(mother)));
    }

    public String showTree() { return familyTree.getTree(); }

    public String findTreeElement(String nextLine) { 
        return familyTree.getInfoHuman(nextLine); 
    }
    
    public String showMother(String nextLine) {
        return familyTree.getInfoMother(nextLine);
    }

    public String showChildrens(String nextLine) {
        return familyTree.getInfoChildren(nextLine);
    }

    public String showFather(String nextLine) {
        return familyTree.getInfoFather(nextLine);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByYearOfBirth() {
        familyTree.sortByYear();
    }
    // Конец работы с FamilyTree

    // Начало работы с FileHandler
    public void saveTree() {
        fileHandler.saveTree(familyTree);
    }

    public void loadTree() {
        this.familyTree = fileHandler.loadTree();
    }

    public void saveTo(String fileName) {
        fileHandler.write(familyTree, fileName);
    }
    // Конец работы с FileHandler
}
