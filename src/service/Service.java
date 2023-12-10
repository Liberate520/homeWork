package service;


import model.creatures.Creature;
import model.creatures.Gender;
import model.creatures.Human;
import model.family_tree.FamilyTree;
import model.family_tree.TreeAppNaturally;

import java.time.LocalDate;
import java.util.List;

//TODO: Реализовать метод сохранения
public class Service {

    private FamilyTree familyTree;
    private TreeAppNaturally naturalView;

    public Service() {
        familyTree = new FamilyTree();
        //naturalView = new TreeAppNaturally(familyTree);

    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }

    public TreeAppNaturally getNaturalView() {
        return naturalView;
    }

    public boolean addHuman(String firstName, String lastName, Gender gender,
                            LocalDate birthDate) {
        Creature human = new Human(firstName, lastName, gender, birthDate);
        if (familyTree.getNotInTree().contains(human) || familyTree.getFamilyTree().contains(human)) {
            return false;
        } else {
            familyTree.getNotInTree().add(human);
            return true;
        }
    }

    public String showIsNotInTree() {
        StringBuilder sb = new StringBuilder();
        if (familyTree.getNotInTree().isEmpty()) {
            sb.append("Элементы вне дерева отсутствуют");
            return sb.toString();
        } else {
            for (Creature creature : (List<Creature>) familyTree.getNotInTree()) {
                sb.append(creature.getName() + "\n");
            }
            return sb.toString();
        }
    }

    public String showTree() {
        StringBuilder sb = new StringBuilder();
        if (familyTree.getFamilyTree().isEmpty()) {
            return sb.append("Дерево пустое").toString();
        } else {
            System.out.println("Дерево состоит из следующих членов: ");
            for (Creature creature : (List<Creature>) familyTree.getFamilyTree()) {
                sb.append(creature.getName() + "\n");
            }
            return sb.toString();
        }


    }
}
