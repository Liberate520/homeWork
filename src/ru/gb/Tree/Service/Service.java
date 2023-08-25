package ru.gb.Tree.Service;
import java.io.Serializable;
import java.time.LocalDate;

import ru.gb.Tree.FamilyTree.Tree;
import ru.gb.Tree.Human.Gender;
import ru.gb.Tree.Human.Human;

public class Service implements Serializable{
    private int id;
    private Tree tree;

    public Service(){
        tree = new Tree();
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
