package model.service;


import model.creatures.Creature;
import model.creatures.Gender;
import model.creatures.Human;
import model.creatures.HumanBuilder;
import model.family_tree.FamilyTree;
import model.human_tree.HumanTree;

import java.time.LocalDate;

public class Service {

    private final FamilyTree<Human> familyTree;
    private final HumanTree<Human> humanTree;
    private final HumanBuilder humanBuilder;

    public Service() {
        familyTree = new FamilyTree<>();
        humanBuilder = new HumanBuilder();
        humanTree = new HumanTree<>(familyTree);
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }

    public HumanTree getHumanTree() {
        return humanTree;
    }

    public boolean addHuman(String firstName, String lastName, Gender gender, LocalDate birthDate) {
        Human human = humanBuilder.build(firstName, lastName, gender, birthDate);
        return familyTree.addCreature(human);
    }

    public String showIsNotInTree() {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if (familyTree.getNotInTree().isEmpty()) {
            sb.append("Элементы вне дерева отсутствуют");
            return sb.toString();
        } else {
            sb.append("Еще не добавлены в дерево:\n");
            for (Creature creature : familyTree.getNotInTree()) {
                if (flag)
                    sb.append("\n");
                sb.append(creature.getId() + " " + creature.getName());
                flag = true;
            }
            return sb.toString();
        }
    }

    public String showTree() {
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        if (familyTree.getFamilyTree().isEmpty()) {
            return sb.append("Дерево пустое").toString();
        } else {
            sb.append("Дерево состоит из следующих членов\n");
            for (Creature creature : familyTree.getFamilyTree()) {
                if (flag)
                    sb.append("\n");
                sb.append(creature.getId() + " " + creature.getName());
                flag = true;
            }
        }
        return sb.toString();
    }


    public String showHumanTree() {
        return humanTree.showTree();
    }

    //TODO: Отформатировать вывод
    public String showAll() {
        StringBuilder sb = new StringBuilder();
        if (familyTree.getFamilyTree().isEmpty() && familyTree.getNotInTree().isEmpty()) {
            return sb.append("Добавленных людей нет").toString();
        } else {
            boolean flag1 = false;
            sb.append("Все добавленные люди:\n");
            for (Creature creature : familyTree.getFamilyTree()) {
                if (flag1) {
                    sb.append("\n");
                }
                sb.append(creature.getId() + " " + creature.getName());
                flag1 = true;
            }
            flag1 = true;
            for (Creature creature : familyTree.getNotInTree()) {
                if (flag1) {
                    sb.append("\n");
                }
                sb.append(creature.getId() + " " + creature.getName());
            }
        }
        return sb.toString();
    }

    public boolean setChild(Integer idParent, Integer idChild) {
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
