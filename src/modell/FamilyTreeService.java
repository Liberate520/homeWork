package modell;

import modell.fam_tree.FamilyTree;
import modell.human.Human;
import modell.file_handler.FileHandler;

public class FamilyTreeService {
    FileHandler<Human> fileHandler = new FileHandler<>("homeWork_family_tree/output/human_data.ser");
    private FamilyTree<Human> familyTree;

    public FamilyTreeService(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTreeService(){
        familyTree = new FamilyTree<>();
    }

    public boolean save(){
        if (fileHandler == null){
            return false;
        }
        return fileHandler.saveToFile(familyTree);
    }

    public boolean load(){
        if (fileHandler == null){
            return false;
        }
        familyTree = fileHandler.loadFromFile();
        return true;
    }

    public void setWritable(FileHandler<Human> fileHandler) {
        this.fileHandler = fileHandler;
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByBirthDate(){
        familyTree.sortByBirthDate();
    }

    public String getHumanList() {
        return familyTree.getInfo();
    }
}
