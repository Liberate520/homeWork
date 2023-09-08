package ru.gb.Tree.Model.Service;
import java.time.LocalDate;

import ru.gb.Tree.Model.FamilyTree.Tree;
import ru.gb.Tree.Model.FileHandler.FileHandler;
import ru.gb.Tree.Model.FileHandler.Writable;
import ru.gb.Tree.Model.Human.Gender;
import ru.gb.Tree.Model.Human.Human;

public class Service{
    private int id;
    private Tree <Human> tree;
    private final Writable writable;

    public Service(){
        this.writable = new FileHandler();
        tree = writable.readFile();

        if (tree == null){
            tree = new Tree<>();
        }
        id = tree.getLastIndex();
    }

    public void addNewPerson(String name, String  gender, LocalDate birthDate, LocalDate deathDate, Integer motherId, Integer fatherId){
        Human human = new Human(id++, name, Gender.valueOf(gender), birthDate, deathDate, tree.getById(motherId), tree.getById(fatherId));
        tree.addHuman(human);
        writable.saveFile(tree);
    }

    public void addNewWedding(int firstHumanId, int secondHumanId){
        tree.setWedding(firstHumanId, secondHumanId);
        writable.saveFile(tree);
    }

    public void addNewChild(int parentId, int childId){
        Human parent = tree.getById(parentId);
        Human child = tree.getById(childId);
        parent.addToChildren(child);
        writable.saveFile(tree);
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }
    
    public void sortByBirthDate(){
        tree.sortByBirthDate();
    }

    public String getHumanInfo() {
        return tree.getFamilyTreeInfo();
    }
}
