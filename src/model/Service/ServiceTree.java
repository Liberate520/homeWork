package model.Service;

import model.genealogicalTree.GenealogicalTree;
import model.genealogicalTree.TreeNode;
import model.human.Gender;
import model.human.Human;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class ServiceTree<T extends TreeNode> implements Serializable {
    private int idHuman;
    private GenealogicalTree<T> family;

    public ServiceTree() {
        family = new GenealogicalTree<>();
    }


    public void addHuman(String name, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father, Human spouse, List<Human> children){
        idHuman++;
        Human human = new Human(name, lastName, gender, birthDate, deathDate, mother, father, spouse, children);
        human.setID(idHuman);
        family.addHuman((T) human);
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("List of family members:\n");

        for (T human: family){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        family.sortByName();
    }

    public void sortByAge(){
        family.sortByAge();
    }

    public int getFamilySize(){
        return family.getSizeFamily();
    }


    public void setSpouseTogether(int idSpouse1, int idSpouse2) {
        Human first = (Human) family.getHumanByID(idSpouse1);
        Human second = (Human)family.getHumanByID(idSpouse2);
        first.setSpouse(second);
        second.setSpouse(first);
    }

    public void setChild(int idParent, int idChild) {
        Human parent = (Human) family.getHumanByID(idParent);
        Human child = (Human) family.getHumanByID(idChild);
        parent.setChild(child);
        Gender genderParent = parent.getGender();
        if(genderParent.equals(Gender.male)) child.addFather(parent);
        else child.addMother(parent);
    }


}
