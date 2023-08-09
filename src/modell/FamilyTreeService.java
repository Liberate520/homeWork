package modell;

import java.time.LocalDate;

import modell.fam_tree.FamilyTree;
import modell.human.Human;
import modell.human.Gender;
import modell.file_handler.FileHandler;
import modell.file_handler.SaveToFile;

public class FamilyTreeService {
    private SaveToFile<Human> fileHandler;
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

    public void addHuman(String name, Gender userGender, LocalDate birthDate, long idFather, long idMother) {
        Human father = familyTree.getById(idFather);
        Human mother = familyTree.getById(idMother);
        Human human = new Human(name, userGender, birthDate, father, mother);
        familyTree.add(human);
    }

    public void removeHuman(long humansId) {
        familyTree.remove(humansId);
    }

    public void setWritable() {
        this.fileHandler = new FileHandler<>();
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
