package family_tree.model.service;

import java.time.LocalDate;
import java.io.*;
import java.util.List;
import java.io.Serializable;

import family_tree.model.family_tree.*;
import family_tree.model.human.*;
import family_tree.model.writer.*;

public class Service {
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler;

    public Service() {
        familyTree = new FamilyTree<>();
        fileHandler = new FileHandler();
    }

    public void addHuman(int id, String name, Gender gender, LocalDate birthDate) {
        Human human = new Human(id, name, gender, birthDate, null, null, null, null, null);
        familyTree.addHuman(human);
    }

    public void addHuman(int id, String name, Gender gender, LocalDate birthDate, Human wife) {
        Human human = new Human(id, name, gender, birthDate, null, null, null, wife);
    }

    public void addHuman(int id, String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        Human human = new Human(id, name, gender, birthDate, null, father, mother, null, null);
    }    

    public void addHuman(int id, String name, Gender gender, LocalDate birthDate,
    Human father, Human mother, Human wife, Human husband) {
        Human human = new Human(id, name, gender, birthDate, null, father, mother, wife, husband);
    }
    

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Генеалогическое древо: \n");
        for (Object human: familyTree) {
            stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }
    

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public void sortByName() {
        familyTree.sortByName();
    }


    
    public boolean saveTree(String filePath) {
        if (fileHandler.save(this.familyTree, filePath)) {
            return true;
        }
        return false;
    }

    public boolean loadTree(String filePath) {
        this.familyTree = (FamilyTree<Human>) fileHandler.read(filePath);
        if (this.familyTree != null) {
            return true;
        }
        return false;
    }

    public boolean loadSampleTree() {
        this.familyTree = TestTree.firstTree();
        if (this.familyTree != null) {
            return true;
        }
        return false;
    }
    
    
    // public static void main (String [] args) {
    //     String filePath = "src/family_tree/tree.out";
        
    //     FileHandler fileHandler = new FileHandler();
    //     FamilyTree<Human> tree = TestTree.firstTree();
   
    //     System.out.println(tree);

    //     tree.sortByName();
    //     System.out.println("Сортировка по имени:");
    //     System.out.println(tree);

    //     tree.sortByBirthDate();
    //     System.out.println("Сортировка по дате рождения:");
    //     System.out.println(tree);
        
    //     fileHandler.save(tree, filePath);      

    // }

}
