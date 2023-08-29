package ru.gb.Tree.Service;
import java.time.LocalDate;

import ru.gb.Tree.FamilyTree.Tree;
import ru.gb.Tree.FileHandler.FileHandler;
import ru.gb.Tree.FileHandler.Writable;
import ru.gb.Tree.Human.Gender;
import ru.gb.Tree.Human.Human;

public class Service{
    private int id;
    private Tree <Human> tree;
    private String filePath;
    private Writable writable;

    public Service(){
        tree = new Tree<>();
        filePath = "homeWork\\src\\ru\\gb\\Tree\\FileHandler\\saveFile.out";
        this.writable = new FileHandler();

    }

    public void addNewPerson(String name, Gender  gender, LocalDate birthDate, int motherId, int fatherId){
        Human human = new Human(id++, name, gender, birthDate, tree.getById(motherId), tree.getById(fatherId));
        tree.addHuman(human);
    }

     public void addNewPerson(String name, Gender  gender, LocalDate birthDate, LocalDate deathDate){
        Human human = new Human(id++, name, gender, birthDate, deathDate);
        tree.addHuman(human);
    }

    public void addNewPerson(String name, Gender  gender, LocalDate birthDate, int motherId){
        Human human = new Human(id++, name, gender, birthDate, tree.getById(motherId));
        tree.addHuman(human);
    }

    public void addNewWedding(int firstHumanId, int secondHumanId){
        tree.setWedding(firstHumanId, secondHumanId);
    }

    public void addNewChild(int parentId, int childId){
        Human parent = tree.getById(parentId);
        Human child = tree.getById(childId);
        parent.addToChildren(child);
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

    public void saveFile(){
        
        writable.saveFile(tree, filePath);
        System.out.println("");
    }

    public Tree<Human> readFile(){
        System.out.println("Сохраненный файл: \n");
        return  writable.readFile(filePath);
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
}
