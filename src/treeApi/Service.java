package src.treeApi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Service implements Serializable{
    private int id;
    private FamilyTree<Human> tree;
    private FileHandler file = new FileHandler();

    public Service(FamilyTree<Human> familyTree) {
        this.tree = familyTree;
    }

    public String get() {
        String res = "";
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

    // public void add(String name, Human father, Human mother) {
    //     Human human = new Human(++id, name, father, mother);
    //     father.addChildren(human);
    //     mother.addChildren(human);
    //     tree.add(human);
    // }

    public void add(String name) {
        Human human = new Human(++id, name);
        tree.add(human);
    }

    public String getInfo() {
        String res = "";
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
            this.tree = (FamilyTree<Human>) file.getFile().inPut();
    }

    public void save() {
            file.getFile().outPut(tree);
    }

    public void remove(String name) {
        Human remover;
        for (Human human : tree) {
            if (human.getName().equals(name)) {
                remover = human;
                tree.remove(remover);
            }
        }
        
    }
}
