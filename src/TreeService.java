import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import handler.FileHandler;
import handler.Saveble;
import human.Gender;
import human.Human;
import tree.Tree;

public class TreeService implements Saveble {
    private Tree tree;
    private Saveble saveble;

    public TreeService(Tree tree, Saveble saveble) {
        this.tree = tree;
        this.saveble = saveble;
    }

    public TreeService(Tree tree) {
        this(tree, new FileHandler());

    }

    public TreeService(Saveble saveble) {
        this(new Tree(), saveble);

    }

    public TreeService() {
        this(new Tree(), new FileHandler());

    }

    public void addHuman(String name, String surName, String fatherName, String mother, String father, Gender gender,
            int age) {
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

    public void showShortTreeInfo() {
        tree.showShortTreeInfo();
    }

    public void showGenderStatistics(Gender gender) {
        tree.showGenderStatistics(gender);
    }

    public void showChildrensInfo(String fullName) {
        tree.showChildrensInfo(tree.getHumanByFullName(fullName));
    }

    public void showInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nПОДРОБНАЯ ИНФОРМАЦИЯ О ГЕНЕАЛОГИЧЕСКОМ ДЕРЕВЕ\n");
        for (Human human : tree) {
            sb.append(human.getFullHumanInfo()).append("\n");
        }
        System.out.println(sb.toString());
    }

    public void showGrandmotherInfo(String fullName) {
        tree.showGrandmotherInfo(fullName);
    }

    public void showGrandfatherInfo(String fullName) {
        tree.showGrandfatherInfo(fullName);
    }

    @Override
    public Object load(String path) {
        if (saveble != null) {
            this.tree = (Tree) saveble.load(path);
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

    public Tree getTree() {
        return tree;
    }

}
