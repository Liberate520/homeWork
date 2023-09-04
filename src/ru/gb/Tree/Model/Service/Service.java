package ru.gb.Tree.Model.Service;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import ru.gb.Tree.Model.FamilyTree.Tree;
import ru.gb.Tree.Model.FileHandler.FileHandler;
import ru.gb.Tree.Model.FileHandler.Writable;
import ru.gb.Tree.Model.Human.Gender;
import ru.gb.Tree.Model.Human.Human;

public class Service{
    private int id;
    private final Tree <Human> tree;
    private final String filePath;
    private final Writable writable;

    public Service(){
        filePath = "saveFile.out";
        this.writable = new FileHandler();
        Path file = Path.of(filePath);
        if (Files.exists(file)){
            tree = readFile();
//            id = tree.getLastIndex();

        } else {
            tree = new Tree<>();
        }
    }


    public void addNewPerson(String name, String  gender, LocalDate birthDate, LocalDate deathDate, Integer motherId, Integer fatherId){
        Human human = new Human(id++, name, Gender.valueOf(gender), birthDate, deathDate, tree.getById(motherId), tree.getById(fatherId));
        tree.addHuman(human);
    }
    public void addNewPerson(String name, String gender, LocalDate birthDate, Integer motherId, Integer fatherId){

        Human human = new Human(id++, name, Gender.valueOf(gender), birthDate, tree.getById(motherId), tree.getById(fatherId));
        tree.addHuman(human);
    }

     public void addNewPerson(String name, String  gender, LocalDate birthDate, LocalDate deathDate){
        Human human = new Human(id++, name, Gender.valueOf(gender), birthDate, deathDate);
        tree.addHuman(human);
    }

    public void addNewPerson(String name, String  gender, LocalDate birthDate, Integer motherId){
        Human human = new Human(id++, name, Gender.valueOf(gender), birthDate, tree.getById(motherId));
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
        System.out.println(" ");
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
