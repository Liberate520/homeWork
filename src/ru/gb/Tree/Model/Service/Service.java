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
        tree = readFile();

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
    public void addNewPerson(String name, String gender, LocalDate birthDate, Integer motherId, Integer fatherId){

        Human human = new Human(id++, name, Gender.valueOf(gender), birthDate, tree.getById(motherId), tree.getById(fatherId));
        tree.addHuman(human);
        writable.saveFile(tree);
    }

     public void addNewPerson(String name, String  gender, LocalDate birthDate, LocalDate deathDate){
        Human human = new Human(id++, name, Gender.valueOf(gender), birthDate, deathDate);
        tree.addHuman(human);
         writable.saveFile(tree);
    }

    public void addNewPerson(String name, String  gender, LocalDate birthDate, Integer motherId){
        Human human = new Human(id++, name, Gender.valueOf(gender), birthDate, tree.getById(motherId));
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

    public String getServiceInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семья состоит из:\n");
        for (Human human : tree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public Tree<Human> readFile(){
        return  writable.readFile();
    }

    public void sortByName(){
        tree.sortByName();
        getServiceInfo();
    }

    public void sortByAge() {
        tree.sortByAge();
        getServiceInfo();
    }
    
    public void sortByBirthDate(){
        tree.sortByBirthDate();
        getServiceInfo();
    }
}
