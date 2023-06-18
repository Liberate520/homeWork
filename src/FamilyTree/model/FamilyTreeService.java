package FamilyTree.model;

import FamilyTree.model.familyTree.FamilyTree;
import FamilyTree.model.human.Gender;
import FamilyTree.model.human.Human;
import FamilyTree.model.save.FileService;

import java.time.LocalDate;

public class FamilyTreeService {
    private FileService fileService;
    private final String filePath = "/Users/kondratyevivan/Desktop/homeWorkTreeKondratyev/src/FamilyTree/tree.txt";
    private FamilyTree<Human> activeTree;
    public FamilyTreeService(FamilyTree<Human> activeTree){
        this.activeTree = activeTree;
    }
    public FamilyTreeService(){
        activeTree = new FamilyTree<>();
    }
    public boolean save(){
        if (fileService == null){
            return false;
        }
        return fileService.save(activeTree, filePath);
    }
    public boolean load(){
        if (fileService == null){
            return false;
        }
        activeTree = (FamilyTree<Human>) fileService.read(filePath);
        if (activeTree == null){
            activeTree = new FamilyTree<>();
        }
        return true;
    }
    public String addHuman(String name, Gender gender, LocalDate birthDate, String father, String mother){
        Human humanFather = findHuman(father);
        Human humanMother = findHuman(mother);
        Human human = new Human(name, gender, humanFather, humanMother);
        activeTree.addMember(human);
        return "Человек добавлен в дерево";
    }

    private Human findHuman(String name) {
        if (name != null){
            return activeTree.getByName(name);
        }
        return null;
    }

    public void setWritable(FileService fileService) {
        this.fileService = fileService;
    }

    public void sortByName(){
        activeTree.sortByName();
    }

    public void sortByAge(){
        activeTree.sortByAge();
    }

    public void sortByChilds(){
        activeTree.sortByChilds();
    }

    public String getHumanList() {
        return activeTree.getInfo();
    }
}
