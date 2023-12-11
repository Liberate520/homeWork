package service;


import model.creatures.*;
import model.family_tree.FamilyTree;
import model.family_tree.TreeAppNaturally;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Service {

    private FamilyTree familyTree;
    private TreeAppNaturally naturalView;
    private HumanBuilder humanBuilder;

    public Service() {
        familyTree = new FamilyTree();
        humanBuilder = new HumanBuilder();
        //naturalView = new TreeAppNaturally(familyTree);

    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }

    public TreeAppNaturally getNaturalView() {
        return naturalView;
    }

    public boolean addHuman(String firstName, String lastName, Gender gender, LocalDate birthDate) {
        Creature human = humanBuilder.build(firstName, lastName, gender, birthDate);

        if (familyTree.getNotInTree().contains(human) || familyTree.getFamilyTree().contains(human)) {
            return false;
        } else {
            familyTree.getNotInTree().add(human);
            return true;
        }
    }

    public String showIsNotInTree() {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if (familyTree.getNotInTree().isEmpty()) {
            sb.append("Элементы вне дерева отсутствуют");
            return sb.toString();
        } else {
            for (Creature creature : (List<Creature>) familyTree.getNotInTree()) {
                if (flag)
                    sb.append("\n");
                sb.append(creature.getId() + " " + creature.getName() + "\n");
                flag = true;
            }
            return sb.toString();
        }
    }

    public String showTree() {
        Boolean flag = false;
        StringBuilder sb = new StringBuilder();
        if (familyTree.getFamilyTree().isEmpty()) {
            return sb.append("Дерево пустое").toString();
        } else {
            System.out.println("Дерево состоит из следующих членов: ");
            for (Creature creature : (List<Creature>) familyTree.getFamilyTree()) {
                if (flag)
                    sb.append("\n");
                sb.append(creature.getId() + " " + creature.getName());
                flag = true;
            }
        }
        return sb.toString();
    }


    public String showAll() {
        StringBuilder sb = new StringBuilder();
        if (familyTree.getFamilyTree().isEmpty() && familyTree.getNotInTree().isEmpty()) {
            return sb.append("Добавленных людей нет").toString();
        } else {
            System.out.println("Все добавленные люди: ");
            for (Creature creature : (List<Creature>) familyTree.getFamilyTree()) {
                sb.append(creature.getId() + " " + creature.getName() + "\n");
            }
            for (Creature creature : (List<Creature>) familyTree.getNotInTree()) {
                sb.append(creature.getId() + " " + creature.getName() + "\n");
            }
        }
        return sb.toString();
    }


    public boolean SetChild(Integer idParent, Integer idChild) {
        if (familyTree.setChildren(familyTree.searchById(idParent), familyTree.searchById(idChild))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean SetSpouce(Integer idSpouce1, Integer idSpouce2) {
        if (familyTree.setSpouse(familyTree.searchById(idSpouce1), familyTree.searchById(idSpouce2))) {
            return true;
        } else {
            return false;
        }
    }

    public String ShowAllInfo(Integer id) {
        StringBuilder sb = new StringBuilder();
        if (familyTree.searchById(id) != null) {
            sb.append(familyTree.searchById(id));
            return sb.toString();
        } else {
            return sb.append("Человек с таким ID отсутствует").toString();
        }
    }
}
