package familyTree.src.family_tree.model.service;

import familyTree.src.family_tree.model.family_Tree.FamilyTree;
import familyTree.src.family_tree.model.human.Gender;
import familyTree.src.family_tree.model.human.Human;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> tree;

    public Service() {
        tree = new FamilyTree<>();
    }
    public void addHuman(String docId, String name, Gender gender, LocalDate birthDate, LocalDate deathDate,
                         String father, String mother, String spouse){
        Human human = new Human(docId, name, gender, birthDate, deathDate,
                father, mother, spouse);
        tree.addHuman(human);
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей:\n");

        for (Human human: tree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByBirthDate(){
        tree.sortByBirthDate();
    }
}
