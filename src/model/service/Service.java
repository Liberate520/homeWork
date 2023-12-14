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

    public void addHumanInTree(String name, Gender gender, LocalDate localDate){
        Human newHuman = new Human(name, gender,localDate);
        familyTree.addHumanInTree(newHuman);

    }

    public void addChildren(Human human){
    }

    public String printAllTree(){
        StringBuilder sb = new StringBuilder();
        sb.append("Список Людей:\n");
        for (Human human1: familyTree){
            sb.append(human1);
        }
        return sb.toString();
    }
}
