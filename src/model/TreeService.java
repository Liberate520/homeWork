package model;

import java.io.Serializable;

import model.handler.FileHandler;
import model.handler.Saveble;
import model.human.Gender;
import model.human.Human;
import model.tree.Tree;

public class TreeService implements Saveble {
    private Tree<Human> tree;
    private Saveble saveble;

    public TreeService(Tree<Human> tree, Saveble saveble) {
        this.tree = tree;
        this.saveble = saveble;
    }

    public TreeService(Tree<Human> tree) {
        this(tree, new FileHandler());

    }

    public TreeService(Saveble saveble) {
        this(new Tree<Human>(), saveble);

    }

    public TreeService() {
        this(new Tree<Human>(), new FileHandler());

    }

    public void addHuman(String name, String surName, String fatherName, String mother, String father, String sex,
            int age) {
        Gender gender = (sex.equals("Male")) ? Gender.Male : Gender.Female;
        tree.addHuman(
                new Human(name, surName, fatherName, tree.getHumanByFullName(mother), tree.getHumanByFullName(father),
                        gender, age));
    }

    public void removeHuman(String name, String surName, String fatherName) {
        if (tree.getHumans().size() != 0) {
            String temp = ((fatherName != null && (!fatherName.equals(""))) ? " " + fatherName : "");
            Human human = tree.getHumanByFullName(surName + " " + name + temp);
            if (human != null) {
                tree.removeHuman(human);
            }

        }
    }

    public void sortBySurName() {
        tree.sortBySurName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }

    public void sortByChildrens() {
        tree.sortByChildrens();
    }

    public String showShortTreeInfo() {
        return tree.showShortTreeInfo();
    }

    public String showGenderStatistics(String sex) {
        Gender gender = (sex.equals("Male"))? Gender.Male: Gender.Female;
        return tree.showGenderStatistics(gender);
    }

    public void showChildrensInfo(String fullName) {
        tree.showChildrensInfo(tree.getHumanByFullName(fullName));
    }

    public String showInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nПОДРОБНАЯ ИНФОРМАЦИЯ О ГЕНЕАЛОГИЧЕСКОМ ДЕРЕВЕ\n");
        if (tree.size() > 0) {
            for (Human human : tree) {
                sb.append(human.getFullInfo()).append("\n");
            }
            return sb.toString();
        }
        return "Данные отсутствуют";
    }

    public void showGrandmotherInfo(String fullName) {
        tree.showGrandmotherInfo(fullName);
    }

    public void showGrandfatherInfo(String fullName) {
        tree.showGrandfatherInfo(fullName);
    }

    @Override
    public Tree<Human> load(String path) {
        if (saveble != null) {
            this.tree = (Tree<Human>) saveble.load(path);
            return this.tree;
        } else {
            return null;
        }
    }

    @Override
    public void save(String path, Serializable serializable) {
        if (saveble != null) {
            saveble.save(path, serializable);
        }

    }

    public Tree<Human> getTree() {
        return tree;
    }

    public int getTreeSize() {
        return tree.size();
    } 

}
