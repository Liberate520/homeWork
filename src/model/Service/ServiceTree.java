package model.Service;

import model.genealogicalTree.GenealogicalTree;
import model.genealogicalTree.TreeNode;
import model.human.Gender;
import model.human.Human;

import java.time.LocalDate;
import java.util.List;

public class ServiceTree<T extends TreeNode> {
    private int idHuman;
    private GenealogicalTree<T> family;

    public ServiceTree() {
        family = new GenealogicalTree<>();
    }

    public void addHuman(String name, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father, Human spouse, List<Human> children){
        idHuman++;
        Human human = new Human(name, lastName, gender, birthDate, deathDate, mother, father, spouse, children);
        human.setID(idHuman);
        family.humanList.add((T)human);
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


}
