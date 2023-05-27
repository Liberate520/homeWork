package model;

import java.io.Serializable;

import model.handler.Loadable;
import model.handler.Saveble;
import model.human.Human;
import model.tree.Tree;

public class TreeService implements Saveble, Loadable {
    private Tree<Human> tree;
    private Saveble saveble;
    private Loadable loadable;
    private static final String PATH = "src/model/handler/saveTree.txt";

    public TreeService(Tree<Human> tree, Saveble saveble, Loadable loadable) {
        this.tree = tree;
        this.saveble = saveble;
        this.loadable = loadable;
    }

    public TreeService(Saveble saveble, Loadable loadable) {
        this(new Tree<Human>(), saveble, loadable);
    }

    public void addHuman(String name, String surName, String fatherName, String mother, String father, String sex,
            int age) {
        tree.addHuman(
                new Human(name, surName, fatherName, tree.getHumanByFullName(mother), tree.getHumanByFullName(father),
                        tree.convertStringToGender(sex), age));
    }

    public void removeHuman(String name, String surName, String fatherName) {
        if (getTreeSize() != 0) {
            String temp = ((fatherName != null && (!fatherName.equals(""))) ? " " + fatherName : "");
            Human human = tree.getHumanByFullName(surName + " " + name + temp);
            if (human != null) {
                tree.removeHuman(human);
            }

        }
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
        return tree.showGenderStatistics(sex);

    }

    public void showChildrensInfo(String fullName) {
        tree.showChildrensInfo(tree.getHumanByFullName(fullName));
    }

    public String showFullTreeInfo() {
        return tree.showFullTreeInfo();
    }

    public String showGrandMotherInfo(String fullName) {
        return tree.showGrandmotherInfo(fullName);
    }

    public String showGrandFatherInfo(String fullName) {
        return tree.showGrandfatherInfo(fullName);
    }

    public Tree<Human> load(String path) {
        if (loadable != null) {
            this.tree = ((path.equals("")) || (path == null)) ? (Tree<Human>) loadable.load(PATH)
                    : (Tree<Human>) loadable.load(path);
            return this.tree;
        } else {
            return null;
        }
    }

    public void save(String path, Serializable serializable) {
        if (saveble != null) {
            if ((path.equals("")) || (path == null)) {
                saveble.save(PATH, serializable);
            } else {
                saveble.save(path, serializable);
            }
        }

    }

    public Tree<Human> getTree() {
        return tree;
    }

    public int getTreeSize() {
        return tree.size();
    }

}
