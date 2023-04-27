package src.treeApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {
    private int id;
    private FamilyTree<Human> tree;
    private FileHandler file = new FileHandler();
    private Human remover;
    String res;

    public Service(FamilyTree<Human> familyTree) {
        this.tree = familyTree;
    }

    public String get() {
        res = "";
        for (Human human : tree) {
            res = res + human.getName() + "\n";
        }
        return res;
    }

    public Human find(String name) {
        for (Human human : tree) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public void add(String name, Human father, Human mother) {
        Human human = new Human(++id, name, father, mother);
        tree.add(human);
    }

    public void add(String name) {
        Human human = new Human(++id, name);
        tree.add(human);
    }

    public String getInfo() {
        res = "";
        for (Human string : tree) {
            res = res + string.getInfo() + "\n";
        }
        return res;
    }

    public List sortByName() {
        ArrayList<Human> list = new ArrayList<Human>(tree.getTree());
        list.sort(new HumanComparatorByName());
        return list;

    }

    public List sortById() {
        ArrayList<Human> list = new ArrayList<Human>(tree.getTree());
        list.sort(new HumanComparatorBYId());
        return list;
    }

    public void load() {
        try {
            this.tree = file.inPut();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            file.outPut(tree);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(String name) {
        for (Human human : tree) {
            if (human.getName().equals(name)) {
                remover = human;
                
            }
        }
        tree.remove(remover);
    }
}
