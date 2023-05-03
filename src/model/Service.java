package model;

import FamilyTree.FamilyTree;
import model.human.Human;

import java.util.ArrayList;
import java.util.List;

public class Service {
    public int id;
    private FamilyTree activeTree;
    private List<FamilyTree> familyTreeList;
    public Service(FamilyTree tree){
        this.activeTree = tree;
        familyTreeList = new ArrayList<>();
        familyTreeList.add(tree);
    }

    public void addHuman(Human human){
        activeTree.addHuman(human);
    }

    public Service(){
        this(new FamilyTree());
    }

    public void addFamilyTreeList(FamilyTree activeTree){
        familyTreeList.add(activeTree);
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Object human: activeTree){
            stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByFirstName(){
        activeTree.sortByFirstName();
    }

    public void sortByLastName(){
        activeTree.sortByLastName();
    }

    public void addHuman(String firstName, String lastName, String dob, int motherId, int fatherId) {
        Human mother = getHumanById(motherId);
        Human father = getHumanById(fatherId);
        activeTree.addHuman(new Human(id++, firstName, lastName, dob, mother, father));
    }

    public void addHuman(String firstName, String lastName, String dob, Human mother, Human father) {
        activeTree.addHuman(new Human(id++, firstName, lastName, dob, mother.getId(), father.getId()));
    }

    public Human getHumanById(int id){
        return (Human) activeTree.getHumanById(id);
    }
}
