package faminly_tree.model.service;

import faminly_tree.model.human.Gender;
import faminly_tree.model.human.HumanConnection;
import faminly_tree.model.human.Human;
import faminly_tree.model.save_in_file.SaveInFile;
import faminly_tree.model.tree.FamilyTree;

import java.io.IOException;
import java.time.LocalDate;

public class Service {
    private FamilyTree tree;
    private SaveInFile save;
    private HumanConnection humanConnection;
    public Service() {
        this.tree = new FamilyTree<>();
        this.save = new SaveInFile();
        this.humanConnection = new HumanConnection();
    }
    public void sortByAge() {
        tree.sortByAge();
    }
    public void sortByName() {
        tree.sortByName();
    }
    public void sortByID(){
        tree.sortByID();
    }
    public FamilyTree showAllTree() {
        return tree;
    }
    public boolean connection(int parentID, int childID){
        Human child = (Human)tree.getHumanByID(childID);
        Human parent = (Human)tree.getHumanByID(parentID);
        if (child == null || parent == null) return false;
        humanConnection.childFor(child, parent);
        return true;
    }
    public boolean save(String path) {
        try{
            save.write(path, tree);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    public boolean dowland(String path) {
        try{
            this.tree = (FamilyTree) save.readTree(path);
            return true;
        } catch (IOException | ClassNotFoundException e) {
            return false;
        }
    }
    public String nextOfKin(int humanID) {
        Human human = (Human) tree.getHumanByID(humanID);
        if (human == null) return null;
        else return tree.nextOfKin(human);
    }
    public int treeIsEmpty(){
        return tree.getSize();
    }
    public void addHumanToTree(String name, String surname, String patronymic, String sex, LocalDate birth, LocalDate death) {
        Gender gender = null;
        if (sex != null) {
            if (sex.contains("ж")) gender = Gender.Female;
            else if (sex.contains("м")) gender = Gender.Male;
        }
        Human human = new Human(name, surname, patronymic, gender, birth, death);
        tree.addToTree(human);
    }

}
