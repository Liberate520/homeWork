package model.service;

import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;

import java.time.LocalDate;

public class Service {
    public Human human;
    public FamilyTree<Human> familyTree;

    public Service() {
        this.human = new Human();
        this.familyTree = new FamilyTree<>();
    }

    public String addHumanInTree(String name, Gender gender,LocalDate localDate){
        Human newHuman = new Human(name, gender,localDate);
        familyTree.addHumanInTree(newHuman);
        return "Человек добавлен в семейное древо";
    }

    public void addChildren(String parants,String name, Gender gender, LocalDate localDate){
        for (Human human: familyTree){
            if(human.getName().equals(parants)){
                human.addChildren(name,gender,localDate);
            }
        }
    }

    public String printAllTree(){
        return familyTree.toString();
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByAge(){
        familyTree.sortByAge();
    }
}
