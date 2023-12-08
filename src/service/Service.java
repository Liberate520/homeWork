package service;


import model.creatures.Creature;
import model.creatures.Gender;
import model.creatures.Human;
import model.family_tree.FamilyTree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private static Creature treeTop;
    private static List<Creature> notInTree;
    private FamilyTree familyTree;

    public Service() {
        notInTree = new ArrayList<>();
        familyTree = new FamilyTree();
    }

    public static void setTreeTop(Creature treeTop) {
        Service.treeTop = treeTop;
    }

    public Creature getTreeTop() {
        return treeTop;
    }

    //TODO: Перенести List notinInTree в FamilyTree
    public boolean addHuman(String firstName, String lastName, Gender gender,
                            LocalDate birthDate) {
        Creature human = new Human(firstName, lastName, gender, birthDate);
        if (notInTree.contains(human) || familyTree.getFamilyTree().contains(human)) {
            System.out.println("Ошибка: такой человек уже добавлен");
            return false;
        } else {
            notInTree.add(human);
            return true;
        }
    }

    public boolean showIsNotInTree() {
        if (notInTree.isEmpty()) {
            return false;
        } else {
            System.out.println("Добавлены но не состоят в дереве: ");
            for (Creature creature : notInTree) {
                System.out.println(creature.getName());
            }
            return true;
        }
    }

  /*  public boolean showTree() {
        if (familyTree.getFamilyTree().isEmpty()) {
            return false;
        } else {
            System.out.println("Дерево состоит из следующих членов: ");
            for (Creature creature : familyTree.getFamilyTree()){
                System.out.println(creature.getName());
            }
            return true;
        }
    }*/
}
