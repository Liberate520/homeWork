package modell;

import java.time.LocalDate;

import modell.fam_tree.FamilyTree;
import modell.human.Human;
import modell.human.Gender;
import modell.file_handler.SaveToFile;

public class FamilyTreeService {
    private SaveToFile<Human> fileHandler;
    private FamilyTree<Human> familyTree;

    // public FamilyTreeService(FamilyTree<Human> familyTree) {
    //     this.familyTree = familyTree;
    // }

    public FamilyTreeService(SaveToFile<Human> fileHandler){
        familyTree = new FamilyTree<>();
        this.fileHandler = fileHandler;
    }

    // public void setWritable() {
    //     this.fileHandler = new FileHandler<>();
    // }

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

    public void addHuman(String name, Gender userGender, LocalDate birthDate, long idFather, long idMother) {
        Human father = familyTree.getById(idFather);
        Human mother = familyTree.getById(idMother);
        Human human = new Human(name, userGender, birthDate, father, mother);
        familyTree.add(human);
    }

    public void removeHuman(long humansId) {
        familyTree.remove(humansId);
    }

    public void setWedding(long humanId1, long humanId2) {
        familyTree.setWedding(humanId1, humanId2);
    }

    public void setDivorce(long humanId1, long humanId2) {
        familyTree.setDivorce(humanId1, humanId2);
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
