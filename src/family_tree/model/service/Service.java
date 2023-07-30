package family_tree.model.service;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Human;
import family_tree.model.human.Gender;
import family_tree.model.writer.FileHandler;

import java.time.LocalDate;
import java.util.List;

public class Service {

    private FamilyTree tree;


    String filePath = "src/family_tree/model/data/tree.out";

    public boolean save(){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree, filePath);

        return false;
    }
    public Object read(){
        FileHandler fileHandler = new FileHandler();
        FamilyTree saveTree = (FamilyTree) fileHandler.read(filePath);
        System.out.println(saveTree);

        return null;
    }


    public Service() {
        tree = new FamilyTree<>();
    }
    public void sortByName() {
        tree.sortByName();
    }
    public void sortByBirthDate() {
        tree.sortByBirthDate();
    }
    public String getInfo() {return tree.getInfo();}


    public void addHuman(String name, Gender gender, LocalDate birthDate, String nameFather, String  nameMother) {
        Human human = new Human(name, gender, birthDate,
                (Human) tree.humanGetByName(nameFather),
                (Human) tree.humanGetByName(nameMother));

        tree.add(human);
        getInfo();
    }


}
