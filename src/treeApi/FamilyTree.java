package src.treeApi;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

public class FamilyTree<E extends Human> implements Serializable, Iterable<E> {

    private HashSet<E> tree;
    private String res = "";
    

    public FamilyTree(HashSet<E> tree) {
        this.tree = tree;
    }

    public FamilyTree() {
        this(new HashSet<>());
    }

    public HashSet<E> getTree() {
        return tree;
    }

    public void addHuman(E husband, E wife, E child) {

        husband.addChildren(child);
        wife.addChildren(child);
        child.setFather(husband);
        child.setMother(wife);
        tree.add(wife);
        tree.add(husband);
        tree.add(child);
    }

    public boolean add(E human) {
        tree.add(human);
        if (human == null) {
            return false;
        }
        if (human.getFather() != null) {
            human.getFather().addChildren(human);
        }
        if (human.getMother() != null) {
            human.getMother().addChildren(human);
        }
        return true;
    }

    public E getByName(String name) {
        for (E human : tree) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        for (E string : tree) {
            res = res + string.getInfo() + "\n";
        }
        return res;
    }

    @Override
    public Iterator<E> iterator() {
        return tree.iterator();
    }
    
}