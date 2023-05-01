package src.treeApi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Service implements Serializable{
    private int id;
    private FamilyTree<Human> tree;
    private Writable file = new FileHandler();
    private Human remover;
    String res;

    public Service(FamilyTree<Human> familyTree) {
        this.tree = familyTree;
    }

    public String get() {
        res = "";
        for (Human human : this.tree) {
            res = res + human.getName() + "\n";
        }
        return res;
    }

    public Human find(String name) {
        for (Human human : this.tree) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public void add(String name, Human father, Human mother) {
        Human human = new Human(++id, name, father, mother);
        father.addChildren(human);
        mother.addChildren(human);
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

    public List<Human> sortByName() {
        ArrayList<Human> list = new ArrayList<Human>(tree.getTree());
        list.sort(new HumanComparatorByName());
        return list;

    }

    public List<Human> sortById() {
        ArrayList<Human> list = new ArrayList<Human>(tree.getTree());
        list.sort(new HumanComparatorBYId());
        return list;
    }

    public void load() {
            this.tree = (FamilyTree<Human>) file.inPut();
    }

    public void save() {
            file.outPut(tree);
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
